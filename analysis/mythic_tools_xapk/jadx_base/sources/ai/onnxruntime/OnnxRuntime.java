package ai.onnxruntime;

import com.facebook.appevents.codeless.internal.Constants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.language.Soundex;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes.dex */
final class OnnxRuntime {
    static final String ONNXRUNTIME_JNI_LIBRARY_NAME = "onnxruntime4j_jni";
    static final String ONNXRUNTIME_LIBRARY_CUDA_NAME = "onnxruntime_providers_cuda";
    static final String ONNXRUNTIME_LIBRARY_DNNL_NAME = "onnxruntime_providers_dnnl";
    static final String ONNXRUNTIME_LIBRARY_NAME = "onnxruntime";
    static final String ONNXRUNTIME_LIBRARY_OPENVINO_NAME = "onnxruntime_providers_openvino";
    static final String ONNXRUNTIME_LIBRARY_QNN_NAME = "onnxruntime_providers_qnn";
    static final String ONNXRUNTIME_LIBRARY_ROCM_NAME = "onnxruntime_providers_rocm";
    static final String ONNXRUNTIME_LIBRARY_SHARED_NAME = "onnxruntime_providers_shared";
    static final String ONNXRUNTIME_LIBRARY_TENSORRT_NAME = "onnxruntime_providers_tensorrt";
    static final String ONNXRUNTIME_LIBRARY_WEBGPU_DAWN_NAME = "webgpu_dawn";
    static final String ONNXRUNTIME_LIBRARY_WEBGPU_DXC_DXCOMPILER_NAME = "dxcompiler";
    static final String ONNXRUNTIME_LIBRARY_WEBGPU_DXC_DXIL_NAME = "dxil";
    static final String ONNXRUNTIME_NATIVE_PATH = "onnxruntime.native.path";
    private static final int ORT_API_VERSION_1 = 1;
    private static final int ORT_API_VERSION_11 = 11;
    private static final int ORT_API_VERSION_13 = 13;
    private static final int ORT_API_VERSION_14 = 14;
    private static final int ORT_API_VERSION_2 = 2;
    private static final int ORT_API_VERSION_23 = 23;
    private static final int ORT_API_VERSION_3 = 3;
    private static final int ORT_API_VERSION_7 = 7;
    private static final int ORT_API_VERSION_8 = 8;
    private static final int ORT_TRAINING_API_VERSION_1 = 1;
    private static String libraryDirPathProperty;
    static long ortApiHandle;
    static long ortCompileApiHandle;
    static long ortTrainingApiHandle;
    static EnumSet<OrtProvider> providers;
    private static Path tempDirectory;
    static boolean trainingEnabled;
    private static String version;
    private static final Logger logger = Logger.getLogger(OnnxRuntime.class.getName());
    private static final String OS_ARCH_STR = initOsArch();
    private static boolean loaded = false;
    private static final Set<String> extractedSharedProviders = new HashSet();

    private OnnxRuntime() {
    }

    private static void cleanUp(File file) {
        if (file.exists()) {
            logger.log(Level.FINE, "Deleting " + file + " on exit");
            file.deleteOnExit();
        }
    }

    static boolean extractCUDA() {
        return extractProviderLibrary(ONNXRUNTIME_LIBRARY_CUDA_NAME);
    }

    static boolean extractDNNL() {
        return extractProviderLibrary(ONNXRUNTIME_LIBRARY_DNNL_NAME);
    }

    private static Optional<File> extractFromResources(String str) {
        String strMapLibraryName = mapLibraryName(str);
        String str2 = "/ai/onnxruntime/native/" + OS_ARCH_STR + IOUtils.DIR_SEPARATOR_UNIX + strMapLibraryName;
        File file = tempDirectory.resolve(strMapLibraryName).toFile();
        try {
            InputStream resourceAsStream = OnnxRuntime.class.getResourceAsStream(str2);
            try {
                if (resourceAsStream == null) {
                    Optional<File> optionalEmpty = Optional.empty();
                    if (resourceAsStream != null) {
                        resourceAsStream.close();
                    }
                    return optionalEmpty;
                }
                logger.log(Level.FINE, "Attempting to load native library '" + str + "' from resource path " + str2 + " copying to " + file);
                byte[] bArr = new byte[4096];
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                while (true) {
                    try {
                        int i = resourceAsStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, i);
                    } finally {
                    }
                }
                fileOutputStream.close();
                logger.log(Level.FINE, "Extracted native library '" + str + "' from resource path");
                Optional<File> optionalOf = Optional.of(file);
                if (resourceAsStream != null) {
                    resourceAsStream.close();
                }
                return optionalOf;
            } catch (Throwable th) {
                if (resourceAsStream != null) {
                    try {
                        resourceAsStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (IOException e) {
            logger.log(Level.WARNING, "Failed to extract library '" + str + "' from the resources", (Throwable) e);
            return Optional.empty();
        } finally {
            cleanUp(file);
        }
    }

    static boolean extractOpenVINO() {
        return extractProviderLibrary(ONNXRUNTIME_LIBRARY_OPENVINO_NAME);
    }

    static synchronized boolean extractProviderLibrary(String str) {
        if (isAndroid()) {
            return false;
        }
        Set<String> set = extractedSharedProviders;
        if (set.contains(str)) {
            return true;
        }
        if (libraryDirPathProperty != null) {
            if (Paths.get(libraryDirPathProperty, mapLibraryName(str)).toFile().exists()) {
                set.add(str);
                return true;
            }
        }
        if (!extractFromResources(str).isPresent()) {
            return false;
        }
        set.add(str);
        return true;
    }

    static boolean extractQNN() {
        return extractProviderLibrary(ONNXRUNTIME_LIBRARY_QNN_NAME);
    }

    static boolean extractROCM() {
        return extractProviderLibrary(ONNXRUNTIME_LIBRARY_ROCM_NAME);
    }

    static boolean extractTensorRT() {
        return extractProviderLibrary(ONNXRUNTIME_LIBRARY_TENSORRT_NAME);
    }

    private static native String[] getAvailableProviders(long j);

    static synchronized void init() throws IOException {
        if (loaded) {
            return;
        }
        tempDirectory = isAndroid() ? null : Files.createTempDirectory("onnxruntime-java", new FileAttribute[0]);
        try {
            libraryDirPathProperty = System.getProperty(ONNXRUNTIME_NATIVE_PATH);
            extractProviderLibrary(ONNXRUNTIME_LIBRARY_SHARED_NAME);
            extractProviderLibrary(ONNXRUNTIME_LIBRARY_WEBGPU_DAWN_NAME);
            extractProviderLibrary(ONNXRUNTIME_LIBRARY_WEBGPU_DXC_DXIL_NAME);
            extractProviderLibrary(ONNXRUNTIME_LIBRARY_WEBGPU_DXC_DXCOMPILER_NAME);
            if (!isAndroid()) {
                load(ONNXRUNTIME_LIBRARY_NAME);
            }
            load(ONNXRUNTIME_JNI_LIBRARY_NAME);
            long jInitialiseAPIBase = initialiseAPIBase(23);
            ortApiHandle = jInitialiseAPIBase;
            if (jInitialiseAPIBase == 0) {
                throw new IllegalStateException("There is a mismatch between the ORT class files and the ORT native library, and the native library could not be loaded");
            }
            ortTrainingApiHandle = initialiseTrainingAPIBase(jInitialiseAPIBase, 23);
            ortCompileApiHandle = initialiseCompileAPIBase(ortApiHandle);
            trainingEnabled = ortTrainingApiHandle != 0;
            providers = initialiseProviders(ortApiHandle);
            version = initialiseVersion();
            loaded = true;
        } finally {
            Path path = tempDirectory;
            if (path != null) {
                cleanUp(path.toFile());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x007b A[PHI: r1
      0x007b: PHI (r1v15 java.lang.String) = (r1v9 java.lang.String), (r1v10 java.lang.String), (r1v11 java.lang.String), (r1v12 java.lang.String) binds: [B:25:0x0079, B:28:0x0083, B:31:0x008c, B:34:0x0095] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String initOsArch() {
        String str;
        String lowerCase = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
        if (lowerCase.contains("mac") || lowerCase.contains("darwin")) {
            str = "osx";
        } else {
            str = "win";
            if (!lowerCase.contains("win")) {
                if (lowerCase.contains("nux")) {
                    str = "linux";
                } else {
                    if (!isAndroid()) {
                        throw new IllegalStateException("Unsupported os:" + lowerCase);
                    }
                    str = Constants.PLATFORM;
                }
            }
        }
        String lowerCase2 = System.getProperty("os.arch", "generic").toLowerCase(Locale.ENGLISH);
        if (lowerCase2.startsWith("amd64") || lowerCase2.startsWith("x86_64")) {
            lowerCase2 = "x64";
        } else {
            String str2 = "x86";
            if (lowerCase2.startsWith("x86")) {
                lowerCase2 = str2;
            } else {
                str2 = "aarch64";
                if (!lowerCase2.startsWith("aarch64")) {
                    str2 = "ppc64";
                    if (!lowerCase2.startsWith("ppc64")) {
                        str2 = "loongarch64";
                        if (!lowerCase2.startsWith("loongarch64")) {
                            if (!isAndroid()) {
                                throw new IllegalStateException("Unsupported arch:" + lowerCase2);
                            }
                        }
                    }
                }
            }
        }
        return str + Soundex.SILENT_MARKER + lowerCase2;
    }

    private static native long initialiseAPIBase(int i);

    private static native long initialiseCompileAPIBase(long j);

    private static EnumSet<OrtProvider> initialiseProviders(long j) {
        String[] availableProviders = getAvailableProviders(j);
        EnumSet<OrtProvider> enumSetNoneOf = EnumSet.noneOf(OrtProvider.class);
        for (String str : availableProviders) {
            enumSetNoneOf.add(OrtProvider.mapFromName(str));
        }
        return enumSetNoneOf;
    }

    private static native long initialiseTrainingAPIBase(long j, int i);

    private static native String initialiseVersion();

    static boolean isAndroid() {
        return System.getProperty("java.vendor", "generic").equals("The Android Project");
    }

    private static void load(String str) throws IOException {
        if (isAndroid()) {
            System.loadLibrary(str);
            return;
        }
        if (Boolean.TRUE.toString().equalsIgnoreCase(System.getProperty("onnxruntime.native." + str + ".skip"))) {
            logger.log(Level.FINE, "Skipping load of native library '" + str + "'");
            return;
        }
        String strMapLibraryName = mapLibraryName(str);
        if (libraryDirPathProperty != null) {
            Logger logger2 = logger;
            logger2.log(Level.FINE, "Attempting to load native library '" + str + "' from specified path: " + libraryDirPathProperty);
            File file = Paths.get(libraryDirPathProperty, strMapLibraryName).toFile();
            String absolutePath = file.getAbsolutePath();
            if (!file.exists()) {
                throw new IOException("Native library '" + str + "' not found at " + absolutePath);
            }
            System.load(absolutePath);
            logger2.log(Level.FINE, "Loaded native library '" + str + "' from specified path");
            return;
        }
        String property = System.getProperty("onnxruntime.native." + str + ".path");
        if (property != null) {
            Logger logger3 = logger;
            logger3.log(Level.FINE, "Attempting to load native library '" + str + "' from specified path: " + property);
            File file2 = new File(property);
            String absolutePath2 = file2.getAbsolutePath();
            if (!file2.exists()) {
                throw new IOException("Native library '" + str + "' not found at " + absolutePath2);
            }
            System.load(absolutePath2);
            logger3.log(Level.FINE, "Loaded native library '" + str + "' from specified path");
            return;
        }
        Optional<File> optionalExtractFromResources = extractFromResources(str);
        if (optionalExtractFromResources.isPresent()) {
            System.load(optionalExtractFromResources.get().getAbsolutePath());
            logger.log(Level.FINE, "Loaded native library '" + str + "' from resource path");
        } else {
            Logger logger4 = logger;
            logger4.log(Level.FINE, "Attempting to load native library '" + str + "' from library path");
            System.loadLibrary(str);
            logger4.log(Level.FINE, "Loaded native library '" + str + "' from library path");
        }
    }

    private static String mapLibraryName(String str) {
        return System.mapLibraryName(str).replace("jnilib", "dylib");
    }

    static String version() {
        return version;
    }
}
