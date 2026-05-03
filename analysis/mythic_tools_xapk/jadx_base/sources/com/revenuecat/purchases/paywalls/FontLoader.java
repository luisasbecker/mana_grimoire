package com.revenuecat.purchases.paywalls;

import android.content.Context;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.paywalls.fonts.DownloadableFontInfo;
import com.revenuecat.purchases.paywalls.fonts.DownloadableFontInfoKt;
import com.revenuecat.purchases.utils.DefaultUrlConnectionFactory;
import com.revenuecat.purchases.utils.Result;
import com.revenuecat.purchases.utils.UrlConnection;
import com.revenuecat.purchases.utils.UrlConnectionFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: compiled from: FontLoader.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u0005H\u0002J\u0018\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0005H\u0002J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0005H\u0002J\u0010\u0010*\u001a\u0004\u0018\u00010\u00132\u0006\u0010+\u001a\u00020,J\u0010\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020/H\u0002JC\u00100\u001a\b\u0012\u0004\u0012\u00020\u0005012\u0006\u0010%\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u0005H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u00105J\u0010\u00106\u001a\u00020!2\u0006\u0010+\u001a\u00020\u0015H\u0002J\u0018\u00107\u001a\u00020!2\u0006\u00108\u001a\u0002092\u0006\u0010#\u001a\u00020\u0005H\u0002R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00170\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000f\u001a\u0004\b\u001d\u0010\u001eR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006:"}, d2 = {"Lcom/revenuecat/purchases/paywalls/FontLoader;", "", "context", "Landroid/content/Context;", "providedCacheDir", "Ljava/io/File;", "ioScope", "Lkotlinx/coroutines/CoroutineScope;", "urlConnectionFactory", "Lcom/revenuecat/purchases/utils/UrlConnectionFactory;", "(Landroid/content/Context;Ljava/io/File;Lkotlinx/coroutines/CoroutineScope;Lcom/revenuecat/purchases/utils/UrlConnectionFactory;)V", "cacheDirectory", "getCacheDirectory", "()Ljava/io/File;", "cacheDirectory$delegate", "Lkotlin/Lazy;", "cachedFontFamilyByFamilyName", "", "", "Lcom/revenuecat/purchases/paywalls/DownloadedFontFamily;", "cachedFontFamilyByFontInfo", "Lcom/revenuecat/purchases/paywalls/fonts/DownloadableFontInfo;", "fontInfosForHash", "", "hasCheckedFoldersExist", "Ljava/util/concurrent/atomic/AtomicBoolean;", "lock", "md", "Ljava/security/MessageDigest;", "getMd", "()Ljava/security/MessageDigest;", "md$delegate", "addFileToCache", "", "urlHash", "file", "downloadToFile", "url", "outputFile", "ensureFoldersExist", "", "cacheDir", "getCachedFontFamilyOrStartDownload", "fontInfo", "Lcom/revenuecat/purchases/UiConfig$AppConfig$FontsConfig$FontInfo$Name;", "md5Hex", "bytes", "", "performDownloadAndCache", "Lkotlin/Result;", "expectedMd5", "extension", "performDownloadAndCache-yxL6bBk", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Ljava/lang/Object;", "startFontDownload", "writeStream", "input", "Ljava/io/InputStream;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FontLoader {

    /* JADX INFO: renamed from: cacheDirectory$delegate, reason: from kotlin metadata */
    private final Lazy cacheDirectory;
    private final Map<String, DownloadedFontFamily> cachedFontFamilyByFamilyName;
    private final Map<DownloadableFontInfo, String> cachedFontFamilyByFontInfo;
    private final Context context;
    private final Map<String, Set<DownloadableFontInfo>> fontInfosForHash;
    private AtomicBoolean hasCheckedFoldersExist;
    private final CoroutineScope ioScope;
    private final Object lock;

    /* JADX INFO: renamed from: md$delegate, reason: from kotlin metadata */
    private final Lazy md;
    private final File providedCacheDir;
    private final UrlConnectionFactory urlConnectionFactory;

    /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.FontLoader$startFontDownload$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FontLoader.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.paywalls.FontLoader$startFontDownload$1", f = "FontLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C06721 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $expectedMd5;
        final /* synthetic */ DownloadableFontInfo $fontInfo;
        final /* synthetic */ String $url;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06721(String str, String str2, DownloadableFontInfo downloadableFontInfo, Continuation<? super C06721> continuation) {
            super(2, continuation);
            this.$url = str;
            this.$expectedMd5 = str2;
            this.$fontInfo = downloadableFontInfo;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FontLoader.this.new C06721(this.$url, this.$expectedMd5, this.$fontInfo, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06721) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object obj2;
            FontLoader fontLoader;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            File cacheDirectory = FontLoader.this.getCacheDirectory();
            if (cacheDirectory == null) {
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Cannot download font: cache directory is not available", null);
                return Unit.INSTANCE;
            }
            if (!FontLoader.this.ensureFoldersExist(cacheDirectory)) {
                return Unit.INSTANCE;
            }
            FontLoader fontLoader2 = FontLoader.this;
            byte[] bytes = this.$url.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            String strMd5Hex = fontLoader2.md5Hex(bytes);
            String strSubstringAfterLast = StringsKt.substringAfterLast(this.$url, FilenameUtils.EXTENSION_SEPARATOR, "");
            File file = new File(cacheDirectory, strMd5Hex + FilenameUtils.EXTENSION_SEPARATOR + strSubstringAfterLast);
            Object obj3 = FontLoader.this.lock;
            FontLoader fontLoader3 = FontLoader.this;
            DownloadableFontInfo downloadableFontInfo = this.$fontInfo;
            String str = this.$url;
            synchronized (obj3) {
                Set set = (Set) fontLoader3.fontInfosForHash.get(strMd5Hex);
                if (set != null) {
                    LogLevel logLevel = LogLevel.VERBOSE;
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler.v("[Purchases] - " + logLevel.name(), "Font download already in progress for " + str);
                    }
                    set.add(downloadableFontInfo);
                    return Unit.INSTANCE;
                }
                fontLoader3.fontInfosForHash.put(strMd5Hex, SetsKt.mutableSetOf(downloadableFontInfo));
                Unit unit = Unit.INSTANCE;
                boolean zExists = file.exists();
                FontLoader fontLoader4 = FontLoader.this;
                if (zExists) {
                    fontLoader4.addFileToCache(strMd5Hex, file);
                    return Unit.INSTANCE;
                }
                try {
                    Object objM10353performDownloadAndCacheyxL6bBk = fontLoader4.m10353performDownloadAndCacheyxL6bBk(this.$url, this.$expectedMd5, strMd5Hex, strSubstringAfterLast, cacheDirectory);
                    FontLoader fontLoader5 = FontLoader.this;
                    if (Result.m11452isSuccessimpl(objM10353performDownloadAndCacheyxL6bBk)) {
                        fontLoader5.addFileToCache(strMd5Hex, (File) objM10353performDownloadAndCacheyxL6bBk);
                    }
                    DownloadableFontInfo downloadableFontInfo2 = this.$fontInfo;
                    if (Result.m11448exceptionOrNullimpl(objM10353performDownloadAndCacheyxL6bBk) != null) {
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Failed to download font for " + downloadableFontInfo2.getFamily(), null);
                    }
                    obj2 = FontLoader.this.lock;
                    fontLoader = FontLoader.this;
                } catch (Throwable th) {
                    try {
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Error downloading remote font from " + this.$url, th);
                        obj2 = FontLoader.this.lock;
                        FontLoader fontLoader6 = FontLoader.this;
                        synchronized (obj2) {
                        }
                    } catch (Throwable th2) {
                        Object obj4 = FontLoader.this.lock;
                        FontLoader fontLoader7 = FontLoader.this;
                        synchronized (obj4) {
                            throw th2;
                        }
                    }
                }
                synchronized (obj2) {
                    return Unit.INSTANCE;
                }
            }
        }
    }

    public FontLoader(Context context, File file, CoroutineScope ioScope, UrlConnectionFactory urlConnectionFactory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(ioScope, "ioScope");
        Intrinsics.checkNotNullParameter(urlConnectionFactory, "urlConnectionFactory");
        this.context = context;
        this.providedCacheDir = file;
        this.ioScope = ioScope;
        this.urlConnectionFactory = urlConnectionFactory;
        this.hasCheckedFoldersExist = new AtomicBoolean(false);
        this.cacheDirectory = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<File>() { // from class: com.revenuecat.purchases.paywalls.FontLoader$cacheDirectory$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final File invoke() {
                File file2 = this.this$0.providedCacheDir;
                if (file2 != null) {
                    return file2;
                }
                File cacheDir = this.this$0.context.getCacheDir();
                if (cacheDir != null) {
                    return new File(cacheDir, "rc_paywall_fonts");
                }
                return null;
            }
        });
        this.md = LazyKt.lazy(new Function0<MessageDigest>() { // from class: com.revenuecat.purchases.paywalls.FontLoader$md$2
            @Override // kotlin.jvm.functions.Function0
            public final MessageDigest invoke() {
                return MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            }
        });
        this.fontInfosForHash = new LinkedHashMap();
        this.lock = new Object();
        this.cachedFontFamilyByFontInfo = new LinkedHashMap();
        this.cachedFontFamilyByFamilyName = new LinkedHashMap();
    }

    public /* synthetic */ FontLoader(Context context, File file, CoroutineScope coroutineScope, DefaultUrlConnectionFactory defaultUrlConnectionFactory, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : file, (i & 4) != 0 ? CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO())) : coroutineScope, (i & 8) != 0 ? new DefaultUrlConnectionFactory() : defaultUrlConnectionFactory);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addFileToCache(String urlHash, File file) {
        synchronized (this.lock) {
            Set<DownloadableFontInfo> setEmptySet = this.fontInfosForHash.get(urlHash);
            if (setEmptySet == null) {
                setEmptySet = SetsKt.emptySet();
            }
            for (DownloadableFontInfo downloadableFontInfo : setEmptySet) {
                String family = downloadableFontInfo.getFamily();
                if (this.cachedFontFamilyByFontInfo.get(downloadableFontInfo) != null) {
                    LogLevel logLevel = LogLevel.VERBOSE;
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler.v("[Purchases] - " + logLevel.name(), "Font already cached for " + family + ". Skipping download.");
                    }
                } else {
                    DownloadedFontFamily downloadedFontFamily = this.cachedFontFamilyByFamilyName.get(family);
                    if (downloadedFontFamily != null) {
                        this.cachedFontFamilyByFamilyName.put(family, new DownloadedFontFamily(downloadedFontFamily.getFamily(), CollectionsKt.plus((Collection<? extends DownloadedFont>) downloadedFontFamily.getFonts(), new DownloadedFont(downloadableFontInfo.getWeight(), downloadableFontInfo.getStyle(), file))));
                        this.cachedFontFamilyByFontInfo.put(downloadableFontInfo, family);
                    } else {
                        DownloadedFontFamily downloadedFontFamily2 = new DownloadedFontFamily(family, CollectionsKt.listOf(new DownloadedFont(downloadableFontInfo.getWeight(), downloadableFontInfo.getStyle(), file)));
                        this.cachedFontFamilyByFontInfo.put(downloadableFontInfo, family);
                        this.cachedFontFamilyByFamilyName.put(family, downloadedFontFamily2);
                    }
                }
            }
            this.fontInfosForHash.remove(urlHash);
        }
    }

    private final void downloadToFile(String url, File outputFile) throws Throwable {
        LogLevel logLevel = LogLevel.VERBOSE;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.v("[Purchases] - " + logLevel.name(), "Downloading remote font from " + url);
        }
        UrlConnection urlConnection = null;
        try {
            UrlConnection urlConnectionCreateConnection$default = UrlConnectionFactory.createConnection$default(this.urlConnectionFactory, url, null, 2, null);
            try {
                if (urlConnectionCreateConnection$default.getResponseCode() != 200) {
                    throw new IOException("HTTP " + urlConnectionCreateConnection$default.getResponseCode() + " when downloading paywall font: " + url);
                }
                InputStream inputStream = urlConnectionCreateConnection$default.getInputStream();
                try {
                    writeStream(inputStream, outputFile);
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(inputStream, null);
                    if (urlConnectionCreateConnection$default != null) {
                        urlConnectionCreateConnection$default.disconnect();
                    }
                } finally {
                }
            } catch (Throwable th) {
                th = th;
                urlConnection = urlConnectionCreateConnection$default;
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean ensureFoldersExist(File cacheDir) {
        boolean z = true;
        if (this.hasCheckedFoldersExist.get()) {
            return true;
        }
        if (cacheDir.exists() || cacheDir.mkdirs()) {
            if (!cacheDir.isDirectory()) {
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Remote fonts cache path exists but is not a directory: " + cacheDir.getAbsolutePath(), null);
            }
            this.hasCheckedFoldersExist.set(z);
            return z;
        }
        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Unable to create cache directory for remote fonts: " + cacheDir.getAbsolutePath(), null);
        z = false;
        this.hasCheckedFoldersExist.set(z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File getCacheDirectory() {
        return (File) this.cacheDirectory.getValue();
    }

    private final MessageDigest getMd() {
        Object value = this.md.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-md>(...)");
        return (MessageDigest) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String md5Hex(byte[] bytes) {
        byte[] digest = getMd().digest(bytes);
        Intrinsics.checkNotNullExpressionValue(digest, "digest");
        return ArraysKt.joinToString$default(digest, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) new Function1<Byte, CharSequence>() { // from class: com.revenuecat.purchases.paywalls.FontLoader.md5Hex.1
            public final CharSequence invoke(byte b) {
                String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                return str;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Byte b) {
                return invoke(b.byteValue());
            }
        }, 30, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: performDownloadAndCache-yxL6bBk, reason: not valid java name */
    public final Object m10353performDownloadAndCacheyxL6bBk(String url, String expectedMd5, String urlHash, String extension, File cacheDir) throws Throwable {
        File file = new File(cacheDir, urlHash + FilenameUtils.EXTENSION_SEPARATOR + extension);
        File tempFile = File.createTempFile("rc_paywall_font_download_", "." + extension, cacheDir);
        try {
            Intrinsics.checkNotNullExpressionValue(tempFile, "tempFile");
            downloadToFile(url, tempFile);
            String strMd5Hex = md5Hex(FilesKt.readBytes(tempFile));
            if (!StringsKt.equals(strMd5Hex, expectedMd5, true)) {
                tempFile.delete();
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Downloaded font file is corrupt for " + url + ". expected=" + expectedMd5 + ", actual=" + strMd5Hex, null);
                Result.Companion companion = Result.INSTANCE;
                return Result.m11445constructorimpl(ResultKt.createFailure(new IOException("Downloaded font file is corrupt for " + url)));
            }
            if (!tempFile.renameTo(file)) {
                FilesKt.copyTo$default(tempFile, file, true, 0, 4, null);
                tempFile.delete();
            }
            LogLevel logLevel = LogLevel.DEBUG;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.d("[Purchases] - " + logLevel.name(), "Font downloaded successfully from " + url);
            }
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m11445constructorimpl(file);
        } catch (IOException e) {
            if (tempFile.exists()) {
                tempFile.delete();
            }
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Error downloading font from " + url + ": " + e.getMessage(), null);
            Result.Companion companion3 = Result.INSTANCE;
            return Result.m11445constructorimpl(ResultKt.createFailure(e));
        }
    }

    private final void startFontDownload(DownloadableFontInfo fontInfo) {
        BuildersKt__Builders_commonKt.launch$default(this.ioScope, null, null, new C06721(fontInfo.getUrl(), fontInfo.getExpectedMd5(), fontInfo, null), 3, null);
    }

    private final void writeStream(InputStream input, File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            FileOutputStream fileOutputStream2 = fileOutputStream;
            byte[] bArr = new byte[8192];
            while (true) {
                int i = input.read(bArr);
                if (i < 0) {
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(fileOutputStream, null);
                    return;
                }
                fileOutputStream2.write(bArr, 0, i);
            }
        } finally {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [T, java.lang.Object] */
    public final DownloadedFontFamily getCachedFontFamilyOrStartDownload(UiConfig.AppConfig.FontsConfig.FontInfo.Name fontInfo) {
        Intrinsics.checkNotNullParameter(fontInfo, "fontInfo");
        com.revenuecat.purchases.utils.Result downloadableFontInfo = DownloadableFontInfoKt.toDownloadableFontInfo(fontInfo);
        if (!(downloadableFontInfo instanceof Result.Success)) {
            if (!(downloadableFontInfo instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) ((Result.Error) downloadableFontInfo).getValue(), null);
            return null;
        }
        DownloadableFontInfo downloadableFontInfo2 = (DownloadableFontInfo) ((Result.Success) downloadableFontInfo).getValue();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (this.lock) {
            objectRef.element = this.cachedFontFamilyByFamilyName.get(this.cachedFontFamilyByFontInfo.get(downloadableFontInfo2));
            Unit unit = Unit.INSTANCE;
        }
        if (objectRef.element != 0) {
            List fonts = ((DownloadedFontFamily) objectRef.element).getFonts();
            if (!(fonts instanceof Collection) || !fonts.isEmpty()) {
                Iterator it = fonts.iterator();
                while (it.hasNext()) {
                    if (!((DownloadedFont) it.next()).getFile().exists()) {
                        LogLevel logLevel = LogLevel.WARN;
                        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                            currentLogHandler.w("[Purchases] - " + logLevel.name(), "Cached font files missing for " + ((DownloadedFontFamily) objectRef.element).getFamily() + ", re-downloading");
                        }
                        synchronized (this.lock) {
                            if (this.cachedFontFamilyByFamilyName.get(((DownloadedFontFamily) objectRef.element).getFamily()) == objectRef.element) {
                                this.cachedFontFamilyByFamilyName.remove(((DownloadedFontFamily) objectRef.element).getFamily());
                                CollectionsKt.removeAll(this.cachedFontFamilyByFontInfo.entrySet(), new Function1<Map.Entry<DownloadableFontInfo, String>, Boolean>() { // from class: com.revenuecat.purchases.paywalls.FontLoader$getCachedFontFamilyOrStartDownload$4$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Boolean invoke(Map.Entry<DownloadableFontInfo, String> it2) {
                                        Intrinsics.checkNotNullParameter(it2, "it");
                                        return Boolean.valueOf(Intrinsics.areEqual(it2.getValue(), objectRef.element.getFamily()));
                                    }
                                });
                            }
                            Unit unit2 = Unit.INSTANCE;
                        }
                    }
                }
            }
            return (DownloadedFontFamily) objectRef.element;
        }
        startFontDownload(downloadableFontInfo2);
        return null;
    }
}
