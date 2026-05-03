package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import androidx.core.content.ContextCompat;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.caverock.androidsvg.SVGParser;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzt {
    public static final /* synthetic */ int zza = 0;
    private static final String[] zzb = {"com.android.", "com.google.", "com.chrome.", "com.nest.", "com.waymo.", "com.waze"};
    private static final String[] zzc;
    private static final String[] zzd;

    static {
        String[] strArr = new String[2];
        strArr[0] = SVGParser.XML_STYLESHEET_ATTR_MEDIA;
        strArr[1] = (Build.HARDWARE.equals("goldfish") || Build.HARDWARE.equals("ranchu")) ? "androidx.test.services.storage.runfiles" : "";
        zzc = strArr;
        zzd = new String[]{"", "", "com.google.android.apps.docs.storage.legacy"};
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005a, code lost:
    
        if (r10.zzb == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007b, code lost:
    
        if (r10.zzb != false) goto L56;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01ac A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0151 A[Catch: IOException -> 0x01bd, FileNotFoundException -> 0x01cc, TryCatch #2 {FileNotFoundException -> 0x01cc, IOException -> 0x01bd, blocks: (B:63:0x0108, B:65:0x0124, B:67:0x012c, B:69:0x0135, B:98:0x01a6, B:75:0x0151, B:77:0x0157, B:79:0x015d, B:82:0x0168, B:84:0x0175, B:86:0x0179, B:89:0x0184, B:90:0x0187, B:92:0x0194, B:94:0x0198, B:97:0x01a3, B:72:0x0142, B:101:0x01ad, B:102:0x01bc), top: B:111:0x0108 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AssetFileDescriptor zza(final Context context, Uri uri, String str) throws FileNotFoundException {
        File dataDir;
        zzs zzsVar = zzs.zza;
        ContentResolver contentResolver = context.getContentResolver();
        if (Build.VERSION.SDK_INT < 30) {
            uri = Uri.parse(uri.toString());
        }
        String scheme = uri.getScheme();
        if ("android.resource".equals(scheme)) {
            return contentResolver.openAssetFileDescriptor(uri, "r");
        }
        int i = 0;
        if (FirebaseAnalytics.Param.CONTENT.equals(scheme)) {
            String authority = uri.getAuthority();
            ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider(authority, 0);
            if (providerInfoResolveContentProvider == null) {
                int iLastIndexOf = authority.lastIndexOf(64);
                if (iLastIndexOf >= 0) {
                    authority = authority.substring(iLastIndexOf + 1);
                    providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider(authority, 0);
                }
                if (providerInfoResolveContentProvider == null) {
                }
            }
            if (zzs.zzc(zzsVar, context, new zzu(uri, providerInfoResolveContentProvider, authority)) - 1 != 1) {
                if (!context.getPackageName().equals(providerInfoResolveContentProvider.packageName)) {
                    if (!zzsVar.zzb) {
                        if (context.checkUriPermission(uri, Process.myPid(), Process.myUid(), 1) != 0 && providerInfoResolveContentProvider.exported) {
                            String[] strArr = zzc;
                            int length = strArr.length;
                            int i2 = 0;
                            while (true) {
                                if (i2 >= 2) {
                                    String[] strArr2 = zzd;
                                    int length2 = strArr2.length;
                                    int i3 = 0;
                                    while (true) {
                                        if (i3 >= 3) {
                                            String[] strArr3 = zzb;
                                            while (i < 6) {
                                                String str2 = strArr3[i];
                                                if (str2.charAt(str2.length() - 1) == '.') {
                                                    if (!providerInfoResolveContentProvider.packageName.startsWith(str2)) {
                                                        i++;
                                                    }
                                                } else if (!providerInfoResolveContentProvider.packageName.equals(str2)) {
                                                    i++;
                                                }
                                            }
                                        } else {
                                            if (strArr2[i3].equals(authority)) {
                                                break;
                                            }
                                            i3++;
                                        }
                                    }
                                } else {
                                    if (strArr[i2].equals(authority)) {
                                        break;
                                    }
                                    i2++;
                                }
                            }
                        }
                        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
                        zzb(assetFileDescriptorOpenAssetFileDescriptor);
                        return assetFileDescriptorOpenAssetFileDescriptor;
                    }
                }
            }
            throw new FileNotFoundException("Can't open content uri.");
        }
        if (!"file".equals(scheme)) {
            throw new FileNotFoundException("Unsupported scheme");
        }
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor2 = contentResolver.openAssetFileDescriptor(uri, "r");
        zzb(assetFileDescriptorOpenAssetFileDescriptor2);
        try {
            ParcelFileDescriptor parcelFileDescriptor = assetFileDescriptorOpenAssetFileDescriptor2.getParcelFileDescriptor();
            String canonicalPath = new File(uri.getPath()).getCanonicalPath();
            zzd(parcelFileDescriptor, canonicalPath);
            if (!canonicalPath.startsWith("/proc/") && !canonicalPath.startsWith("/data/misc/")) {
                zzs.zza(zzsVar);
                File dataDir2 = ContextCompat.getDataDir(context);
                if (dataDir2 == null) {
                    if (canonicalPath.startsWith(zzc(Environment.getDataDirectory()))) {
                    }
                    i = 1;
                    if (i == zzsVar.zzb) {
                    }
                } else if (canonicalPath.startsWith(zzc(dataDir2))) {
                    i = 1;
                    if (i == zzsVar.zzb) {
                        return assetFileDescriptorOpenAssetFileDescriptor2;
                    }
                } else {
                    Context contextCreateDeviceProtectedStorageContext = ContextCompat.createDeviceProtectedStorageContext(context);
                    if (contextCreateDeviceProtectedStorageContext == null || (dataDir = ContextCompat.getDataDir(contextCreateDeviceProtectedStorageContext)) == null || !canonicalPath.startsWith(zzc(dataDir))) {
                        File[] fileArrZzf = zzf(new Callable() { // from class: com.google.android.gms.internal.mlkit_vision_internal_vkp.zzm
                            @Override // java.util.concurrent.Callable
                            public final Object call() {
                                int i4 = zzt.zza;
                                return ContextCompat.getExternalFilesDirs(context, null);
                            }
                        });
                        int length3 = fileArrZzf.length;
                        int i4 = 0;
                        while (true) {
                            if (i4 < length3) {
                                File file = fileArrZzf[i4];
                                if (file != null && canonicalPath.startsWith(zzc(file))) {
                                    break;
                                }
                                i4++;
                            } else {
                                for (File file2 : zzf(new Callable() { // from class: com.google.android.gms.internal.mlkit_vision_internal_vkp.zzn
                                    @Override // java.util.concurrent.Callable
                                    public final Object call() {
                                        int i5 = zzt.zza;
                                        return ContextCompat.getExternalCacheDirs(context);
                                    }
                                })) {
                                    if (file2 == null || !canonicalPath.startsWith(zzc(file2))) {
                                    }
                                }
                            }
                        }
                    }
                    i = 1;
                    if (i == zzsVar.zzb) {
                    }
                }
            }
            throw new FileNotFoundException("Can't open file: ".concat(String.valueOf(canonicalPath)));
        } catch (FileNotFoundException e) {
            zze(assetFileDescriptorOpenAssetFileDescriptor2, e);
            throw e;
        } catch (IOException e2) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException("Validation failed.");
            fileNotFoundException.initCause(e2);
            zze(assetFileDescriptorOpenAssetFileDescriptor2, fileNotFoundException);
            throw fileNotFoundException;
        }
    }

    private static Object zzb(Object obj) throws FileNotFoundException {
        if (obj != null) {
            return obj;
        }
        throw new FileNotFoundException("Content resolver returned null value.");
    }

    private static String zzc(File file) throws IOException {
        String canonicalPath = file.getCanonicalPath();
        return !canonicalPath.endsWith(DomExceptionUtils.SEPARATOR) ? String.valueOf(canonicalPath).concat(DomExceptionUtils.SEPARATOR) : canonicalPath;
    }

    private static void zzd(ParcelFileDescriptor parcelFileDescriptor, String str) throws IOException {
        try {
            StructStat structStatFstat = Os.fstat(parcelFileDescriptor.getFileDescriptor());
            try {
                StructStat structStatLstat = Os.lstat(str);
                if (OsConstants.S_ISLNK(structStatLstat.st_mode)) {
                    throw new FileNotFoundException("Can't open file: ".concat(String.valueOf(str)));
                }
                if (structStatFstat.st_dev != structStatLstat.st_dev || structStatFstat.st_ino != structStatLstat.st_ino) {
                    throw new FileNotFoundException("Can't open file: ".concat(String.valueOf(str)));
                }
            } catch (ErrnoException e) {
                throw new IOException(e);
            }
        } catch (ErrnoException e2) {
            throw new IOException(e2);
        }
    }

    private static void zze(AssetFileDescriptor assetFileDescriptor, FileNotFoundException fileNotFoundException) {
        try {
            assetFileDescriptor.close();
        } catch (IOException e) {
            fileNotFoundException.addSuppressed(e);
        }
    }

    private static File[] zzf(Callable callable) {
        try {
            return (File[]) callable.call();
        } catch (NullPointerException e) {
            throw e;
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }
}
