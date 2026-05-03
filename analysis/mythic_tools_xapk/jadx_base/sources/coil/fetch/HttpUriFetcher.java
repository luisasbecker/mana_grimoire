package coil.fetch;

import android.net.Uri;
import android.os.NetworkOnMainThreadException;
import android.webkit.MimeTypeMap;
import androidx.media3.muxer.WebmConstants;
import androidx.webkit.ProxyConfig;
import coil.ImageLoader;
import coil.decode.DataSource;
import coil.decode.ImageSource;
import coil.decode.ImageSources;
import coil.disk.DiskCache;
import coil.fetch.Fetcher;
import coil.network.CacheResponse;
import coil.network.CacheStrategy;
import coil.network.HttpException;
import coil.request.Options;
import coil.util.Calls;
import coil.util.Utils;
import com.google.firebase.messaging.Constants;
import java.io.Closeable;
import java.io.IOException;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: compiled from: HttpUriFetcher.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 02\u00020\u0001:\u000201B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0011\u0010\u001a\u001a\u00020\u001bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ!\u0010\u001d\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0001¢\u0006\u0002\b J\u0018\u0010!\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u0016H\u0002J\b\u0010#\u001a\u00020\u0018H\u0002J\n\u0010$\u001a\u0004\u0018\u00010%H\u0002J.\u0010&\u001a\u0004\u0018\u00010%2\b\u0010'\u001a\u0004\u0018\u00010%2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u00162\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u000e\u0010*\u001a\u0004\u0018\u00010)*\u00020%H\u0002J\f\u0010+\u001a\u00020,*\u00020\u0016H\u0002J\f\u0010-\u001a\u00020.*\u00020%H\u0002J\f\u0010-\u001a\u00020.*\u00020/H\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00062"}, d2 = {"Lcoil/fetch/HttpUriFetcher;", "Lcoil/fetch/Fetcher;", "url", "", "options", "Lcoil/request/Options;", "callFactory", "Lkotlin/Lazy;", "Lokhttp3/Call$Factory;", "diskCache", "Lcoil/disk/DiskCache;", "respectCacheHeaders", "", "(Ljava/lang/String;Lcoil/request/Options;Lkotlin/Lazy;Lkotlin/Lazy;Z)V", "diskCacheKey", "getDiskCacheKey", "()Ljava/lang/String;", "fileSystem", "Lokio/FileSystem;", "getFileSystem", "()Lokio/FileSystem;", "executeNetworkRequest", "Lokhttp3/Response;", "request", "Lokhttp3/Request;", "(Lokhttp3/Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetch", "Lcoil/fetch/FetchResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMimeType", "contentType", "Lokhttp3/MediaType;", "getMimeType$coil_base_release", "isCacheable", "response", "newRequest", "readFromDiskCache", "Lcoil/disk/DiskCache$Snapshot;", "writeToDiskCache", "snapshot", "cacheResponse", "Lcoil/network/CacheResponse;", "toCacheResponse", "toDataSource", "Lcoil/decode/DataSource;", "toImageSource", "Lcoil/decode/ImageSource;", "Lokhttp3/ResponseBody;", "Companion", "Factory", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HttpUriFetcher implements Fetcher {
    private static final String MIME_TYPE_TEXT_PLAIN = "text/plain";
    private final Lazy<Call.Factory> callFactory;
    private final Lazy<DiskCache> diskCache;
    private final Options options;
    private final boolean respectCacheHeaders;
    private final String url;
    private static final CacheControl CACHE_CONTROL_FORCE_NETWORK_NO_CACHE = new CacheControl.Builder().noCache().noStore().build();
    private static final CacheControl CACHE_CONTROL_NO_NETWORK_NO_CACHE = new CacheControl.Builder().noCache().onlyIfCached().build();

    /* JADX INFO: compiled from: HttpUriFetcher.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B+\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\"\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0002H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcoil/fetch/HttpUriFetcher$Factory;", "Lcoil/fetch/Fetcher$Factory;", "Landroid/net/Uri;", "callFactory", "Lkotlin/Lazy;", "Lokhttp3/Call$Factory;", "diskCache", "Lcoil/disk/DiskCache;", "respectCacheHeaders", "", "(Lkotlin/Lazy;Lkotlin/Lazy;Z)V", "create", "Lcoil/fetch/Fetcher;", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "options", "Lcoil/request/Options;", "imageLoader", "Lcoil/ImageLoader;", "isApplicable", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Factory implements Fetcher.Factory<Uri> {
        private final Lazy<Call.Factory> callFactory;
        private final Lazy<DiskCache> diskCache;
        private final boolean respectCacheHeaders;

        /* JADX WARN: Multi-variable type inference failed */
        public Factory(Lazy<? extends Call.Factory> lazy, Lazy<? extends DiskCache> lazy2, boolean z) {
            this.callFactory = lazy;
            this.diskCache = lazy2;
            this.respectCacheHeaders = z;
        }

        private final boolean isApplicable(Uri data) {
            return Intrinsics.areEqual(data.getScheme(), ProxyConfig.MATCH_HTTP) || Intrinsics.areEqual(data.getScheme(), ProxyConfig.MATCH_HTTPS);
        }

        @Override // coil.fetch.Fetcher.Factory
        public Fetcher create(Uri data, Options options, ImageLoader imageLoader) {
            if (isApplicable(data)) {
                return new HttpUriFetcher(data.toString(), options, this.callFactory, this.diskCache, this.respectCacheHeaders);
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: coil.fetch.HttpUriFetcher$executeNetworkRequest$1, reason: invalid class name */
    /* JADX INFO: compiled from: HttpUriFetcher.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "coil.fetch.HttpUriFetcher", f = "HttpUriFetcher.kt", i = {}, l = {WebmConstants.MkvEbmlElement.VIDEO}, m = "executeNetworkRequest", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpUriFetcher.this.executeNetworkRequest(null, this);
        }
    }

    /* JADX INFO: renamed from: coil.fetch.HttpUriFetcher$fetch$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HttpUriFetcher.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "coil.fetch.HttpUriFetcher", f = "HttpUriFetcher.kt", i = {0, 0, 0, 1, 1, 1}, l = {Imgproc.COLOR_LRGB2Luv, 106}, m = "fetch", n = {"this", "snapshot", "cacheStrategy", "this", "snapshot", "response"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
    static final class C05671 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C05671(Continuation<? super C05671> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpUriFetcher.this.fetch(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HttpUriFetcher(String str, Options options, Lazy<? extends Call.Factory> lazy, Lazy<? extends DiskCache> lazy2, boolean z) {
        this.url = str;
        this.options = options;
        this.callFactory = lazy;
        this.diskCache = lazy2;
        this.respectCacheHeaders = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object executeNetworkRequest(Request request, Continuation<? super Response> continuation) throws IOException {
        AnonymousClass1 anonymousClass1;
        Response responseExecute;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object objAwait = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAwait);
            if (Utils.isMainThread()) {
                if (this.options.getNetworkCachePolicy().getReadEnabled()) {
                    throw new NetworkOnMainThreadException();
                }
                responseExecute = this.callFactory.getValue().newCall(request).execute();
                if (!responseExecute.isSuccessful() || responseExecute.code() == 304) {
                    return responseExecute;
                }
                ResponseBody responseBodyBody = responseExecute.body();
                if (responseBodyBody != null) {
                    Utils.closeQuietly(responseBodyBody);
                }
                throw new HttpException(responseExecute);
            }
            Call callNewCall = this.callFactory.getValue().newCall(request);
            anonymousClass1.label = 1;
            objAwait = Calls.await(callNewCall, anonymousClass1);
            if (objAwait == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objAwait);
        }
        responseExecute = (Response) objAwait;
        if (responseExecute.isSuccessful()) {
        }
        return responseExecute;
    }

    private final String getDiskCacheKey() {
        String diskCacheKey = this.options.getDiskCacheKey();
        return diskCacheKey == null ? this.url : diskCacheKey;
    }

    private final FileSystem getFileSystem() {
        DiskCache value = this.diskCache.getValue();
        Intrinsics.checkNotNull(value);
        return value.getFileSystem();
    }

    private final boolean isCacheable(Request request, Response response) {
        if (this.options.getDiskCachePolicy().getWriteEnabled()) {
            return !this.respectCacheHeaders || CacheStrategy.INSTANCE.isCacheable(request, response);
        }
        return false;
    }

    private final Request newRequest() {
        Request.Builder builderHeaders = new Request.Builder().url(this.url).headers(this.options.getHeaders());
        for (Map.Entry<Class<?>, Object> entry : this.options.getTags().asMap().entrySet()) {
            Class<?> key = entry.getKey();
            Intrinsics.checkNotNull(key, "null cannot be cast to non-null type java.lang.Class<kotlin.Any>");
            builderHeaders.tag(key, entry.getValue());
        }
        boolean readEnabled = this.options.getDiskCachePolicy().getReadEnabled();
        boolean readEnabled2 = this.options.getNetworkCachePolicy().getReadEnabled();
        if (!readEnabled2 && readEnabled) {
            builderHeaders.cacheControl(CacheControl.FORCE_CACHE);
        } else if (!readEnabled2 || readEnabled) {
            if (!readEnabled2 && !readEnabled) {
                builderHeaders.cacheControl(CACHE_CONTROL_NO_NETWORK_NO_CACHE);
            }
        } else if (this.options.getDiskCachePolicy().getWriteEnabled()) {
            builderHeaders.cacheControl(CacheControl.FORCE_NETWORK);
        } else {
            builderHeaders.cacheControl(CACHE_CONTROL_FORCE_NETWORK_NO_CACHE);
        }
        return builderHeaders.build();
    }

    private final DiskCache.Snapshot readFromDiskCache() {
        DiskCache value;
        if (!this.options.getDiskCachePolicy().getReadEnabled() || (value = this.diskCache.getValue()) == null) {
            return null;
        }
        return value.openSnapshot(getDiskCacheKey());
    }

    private final CacheResponse toCacheResponse(DiskCache.Snapshot snapshot) throws Throwable {
        Throwable th;
        CacheResponse cacheResponse;
        try {
            BufferedSource bufferedSourceBuffer = Okio.buffer(getFileSystem().source(snapshot.getMetadata()));
            try {
                cacheResponse = new CacheResponse(bufferedSourceBuffer);
                if (bufferedSourceBuffer != null) {
                    try {
                        bufferedSourceBuffer.close();
                        th = null;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } else {
                    th = null;
                }
            } catch (Throwable th3) {
                if (bufferedSourceBuffer != null) {
                    try {
                        bufferedSourceBuffer.close();
                    } catch (Throwable th4) {
                        ExceptionsKt.addSuppressed(th3, th4);
                    }
                }
                th = th3;
                cacheResponse = null;
            }
            if (th != null) {
                throw th;
            }
            Intrinsics.checkNotNull(cacheResponse);
            return cacheResponse;
        } catch (IOException unused) {
            return null;
        }
    }

    private final DataSource toDataSource(Response response) {
        return response.networkResponse() != null ? DataSource.NETWORK : DataSource.DISK;
    }

    private final ImageSource toImageSource(DiskCache.Snapshot snapshot) {
        return ImageSources.create(snapshot.getData(), getFileSystem(), getDiskCacheKey(), snapshot);
    }

    private final ImageSource toImageSource(ResponseBody responseBody) {
        return ImageSources.create(responseBody.getSource(), this.options.getContext());
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00c7 A[Catch: all -> 0x011b, Exception -> 0x011d, TRY_LEAVE, TryCatch #2 {Exception -> 0x011d, blocks: (B:15:0x002d, B:18:0x0038, B:33:0x0089, B:67:0x010f, B:34:0x008e, B:30:0x0081, B:35:0x008f, B:51:0x00c7, B:66:0x010c, B:70:0x0119, B:63:0x0104, B:71:0x011a, B:48:0x00c0), top: B:83:0x002d, outer: #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x011a A[Catch: all -> 0x011b, Exception -> 0x011d, TRY_LEAVE, TryCatch #2 {Exception -> 0x011d, blocks: (B:15:0x002d, B:18:0x0038, B:33:0x0089, B:67:0x010f, B:34:0x008e, B:30:0x0081, B:35:0x008f, B:51:0x00c7, B:66:0x010c, B:70:0x0119, B:63:0x0104, B:71:0x011a, B:48:0x00c0), top: B:83:0x002d, outer: #8 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final DiskCache.Snapshot writeToDiskCache(DiskCache.Snapshot snapshot, Request request, Response response, CacheResponse cacheResponse) {
        DiskCache.Editor editorOpenEditor;
        Throwable th;
        Unit unit;
        Long lValueOf;
        Unit unit2;
        Throwable th2 = null;
        if (!isCacheable(request, response)) {
            if (snapshot != null) {
                Utils.closeQuietly(snapshot);
            }
            return null;
        }
        if (snapshot != null) {
            editorOpenEditor = snapshot.closeAndOpenEditor();
        } else {
            DiskCache value = this.diskCache.getValue();
            editorOpenEditor = value != null ? value.openEditor(getDiskCacheKey()) : null;
        }
        try {
            if (editorOpenEditor == null) {
                return null;
            }
            try {
                if (response.code() != 304 || cacheResponse == null) {
                    BufferedSink bufferedSinkBuffer = Okio.buffer(getFileSystem().sink(editorOpenEditor.getMetadata(), false));
                    try {
                        new CacheResponse(response).writeTo(bufferedSinkBuffer);
                        unit = Unit.INSTANCE;
                    } catch (Throwable th3) {
                        if (bufferedSinkBuffer != null) {
                            try {
                                bufferedSinkBuffer.close();
                            } catch (Throwable th4) {
                                ExceptionsKt.addSuppressed(th3, th4);
                            }
                        }
                        th = th3;
                        unit = null;
                    }
                    if (bufferedSinkBuffer != null) {
                        try {
                            bufferedSinkBuffer.close();
                            th = null;
                        } catch (Throwable th5) {
                            th = th5;
                        }
                        if (th == null) {
                            throw th;
                        }
                        Intrinsics.checkNotNull(unit);
                        BufferedSink bufferedSinkBuffer2 = Okio.buffer(getFileSystem().sink(editorOpenEditor.getData(), false));
                        try {
                            ResponseBody responseBodyBody = response.body();
                            Intrinsics.checkNotNull(responseBodyBody);
                            lValueOf = Long.valueOf(responseBodyBody.getSource().readAll(bufferedSinkBuffer2));
                            if (bufferedSinkBuffer2 != null) {
                                try {
                                    bufferedSinkBuffer2.close();
                                } catch (Throwable th6) {
                                    th2 = th6;
                                }
                            }
                        } catch (Throwable th7) {
                            if (bufferedSinkBuffer2 != null) {
                                try {
                                    bufferedSinkBuffer2.close();
                                } catch (Throwable th8) {
                                    ExceptionsKt.addSuppressed(th7, th8);
                                }
                            }
                            th2 = th7;
                            lValueOf = null;
                        }
                        if (th2 != null) {
                            throw th2;
                        }
                        Intrinsics.checkNotNull(lValueOf);
                    } else {
                        th = null;
                        if (th == null) {
                        }
                    }
                } else {
                    Response responseBuild = response.newBuilder().headers(CacheStrategy.INSTANCE.combineHeaders(cacheResponse.getResponseHeaders(), response.headers())).build();
                    BufferedSink bufferedSinkBuffer3 = Okio.buffer(getFileSystem().sink(editorOpenEditor.getMetadata(), false));
                    try {
                        new CacheResponse(responseBuild).writeTo(bufferedSinkBuffer3);
                        unit2 = Unit.INSTANCE;
                        if (bufferedSinkBuffer3 != null) {
                            try {
                                bufferedSinkBuffer3.close();
                            } catch (Throwable th9) {
                                th2 = th9;
                            }
                        }
                    } catch (Throwable th10) {
                        if (bufferedSinkBuffer3 != null) {
                            try {
                                bufferedSinkBuffer3.close();
                            } catch (Throwable th11) {
                                ExceptionsKt.addSuppressed(th10, th11);
                            }
                        }
                        th2 = th10;
                        unit2 = null;
                    }
                    if (th2 != null) {
                        throw th2;
                    }
                    Intrinsics.checkNotNull(unit2);
                }
                return editorOpenEditor.commitAndOpenSnapshot();
            } catch (Exception e) {
                Utils.abortQuietly(editorOpenEditor);
                throw e;
            }
        } finally {
            Utils.closeQuietly(response);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v13 */
    @Override // coil.fetch.Fetcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object fetch(Continuation<? super FetchResult> continuation) throws Exception {
        C05671 c05671;
        DiskCache.Snapshot fromDiskCache;
        CacheStrategy cacheStrategyCompute;
        Object objExecuteNetworkRequest;
        Response response;
        ResponseBody responseBodyRequireBody;
        DiskCache.Snapshot snapshot;
        Response response2;
        DiskCache.Snapshot snapshotWriteToDiskCache;
        HttpUriFetcher httpUriFetcher;
        Response response3;
        if (continuation instanceof C05671) {
            c05671 = (C05671) continuation;
            if ((c05671.label & Integer.MIN_VALUE) != 0) {
                c05671.label -= Integer.MIN_VALUE;
            } else {
                c05671 = new C05671(continuation);
            }
        }
        Object obj = c05671.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r2 = c05671.label;
        try {
            try {
                try {
                    if (r2 == 0) {
                        ResultKt.throwOnFailure(obj);
                        fromDiskCache = readFromDiskCache();
                        if (fromDiskCache != null) {
                            Long size = getFileSystem().metadata(fromDiskCache.getMetadata()).getSize();
                            if (size != null && size.longValue() == 0) {
                                return new SourceResult(toImageSource(fromDiskCache), getMimeType$coil_base_release(this.url, null), DataSource.DISK);
                            }
                            if (!this.respectCacheHeaders) {
                                ImageSource imageSource = toImageSource(fromDiskCache);
                                String str = this.url;
                                CacheResponse cacheResponse = toCacheResponse(fromDiskCache);
                                return new SourceResult(imageSource, getMimeType$coil_base_release(str, cacheResponse != null ? cacheResponse.getContentType() : null), DataSource.DISK);
                            }
                            cacheStrategyCompute = new CacheStrategy.Factory(newRequest(), toCacheResponse(fromDiskCache)).compute();
                            if (cacheStrategyCompute.getNetworkRequest() == null && cacheStrategyCompute.getCacheResponse() != null) {
                                return new SourceResult(toImageSource(fromDiskCache), getMimeType$coil_base_release(this.url, cacheStrategyCompute.getCacheResponse().getContentType()), DataSource.DISK);
                            }
                        } else {
                            cacheStrategyCompute = new CacheStrategy.Factory(newRequest(), null).compute();
                        }
                        Request networkRequest = cacheStrategyCompute.getNetworkRequest();
                        Intrinsics.checkNotNull(networkRequest);
                        c05671.L$0 = this;
                        c05671.L$1 = fromDiskCache;
                        c05671.L$2 = cacheStrategyCompute;
                        c05671.label = 1;
                        objExecuteNetworkRequest = executeNetworkRequest(networkRequest, c05671);
                        if (objExecuteNetworkRequest == coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    }
                    if (r2 != 1) {
                        if (r2 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        response2 = (Response) c05671.L$2;
                        snapshot = (DiskCache.Snapshot) c05671.L$1;
                        httpUriFetcher = (HttpUriFetcher) c05671.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            response3 = (Response) obj;
                        } catch (Exception e) {
                            e = e;
                            try {
                                Utils.closeQuietly(response2);
                                throw e;
                            } catch (Exception e2) {
                                e = e2;
                                r2 = snapshot;
                                if (r2 != 0) {
                                    Utils.closeQuietly((Closeable) r2);
                                }
                                throw e;
                            }
                        }
                        try {
                            ResponseBody responseBodyRequireBody2 = Utils.requireBody(response3);
                            return new SourceResult(httpUriFetcher.toImageSource(responseBodyRequireBody2), httpUriFetcher.getMimeType$coil_base_release(httpUriFetcher.url, responseBodyRequireBody2.get$contentType()), httpUriFetcher.toDataSource(response3));
                        } catch (Exception e3) {
                            e = e3;
                            response2 = response3;
                            Utils.closeQuietly(response2);
                            throw e;
                        }
                    }
                    CacheStrategy cacheStrategy = (CacheStrategy) c05671.L$2;
                    fromDiskCache = (DiskCache.Snapshot) c05671.L$1;
                    HttpUriFetcher httpUriFetcher2 = (HttpUriFetcher) c05671.L$0;
                    ResultKt.throwOnFailure(obj);
                    cacheStrategyCompute = cacheStrategy;
                    this = httpUriFetcher2;
                    objExecuteNetworkRequest = obj;
                    if (snapshotWriteToDiskCache != null) {
                        ImageSource imageSource2 = this.toImageSource(snapshotWriteToDiskCache);
                        String str2 = this.url;
                        CacheResponse cacheResponse2 = this.toCacheResponse(snapshotWriteToDiskCache);
                        return new SourceResult(imageSource2, this.getMimeType$coil_base_release(str2, cacheResponse2 != null ? cacheResponse2.getContentType() : null), DataSource.NETWORK);
                    }
                    if (responseBodyRequireBody.getContentLength() > 0) {
                        return new SourceResult(this.toImageSource(responseBodyRequireBody), this.getMimeType$coil_base_release(this.url, responseBodyRequireBody.get$contentType()), this.toDataSource(response));
                    }
                    Utils.closeQuietly(response);
                    Request requestNewRequest = this.newRequest();
                    c05671.L$0 = this;
                    c05671.L$1 = snapshotWriteToDiskCache;
                    c05671.L$2 = response;
                    c05671.label = 2;
                    Object objExecuteNetworkRequest2 = this.executeNetworkRequest(requestNewRequest, c05671);
                    if (objExecuteNetworkRequest2 != coroutine_suspended) {
                        snapshot = snapshotWriteToDiskCache;
                        obj = objExecuteNetworkRequest2;
                        httpUriFetcher = this;
                        response2 = response;
                        response3 = (Response) obj;
                        ResponseBody responseBodyRequireBody22 = Utils.requireBody(response3);
                        return new SourceResult(httpUriFetcher.toImageSource(responseBodyRequireBody22), httpUriFetcher.getMimeType$coil_base_release(httpUriFetcher.url, responseBodyRequireBody22.get$contentType()), httpUriFetcher.toDataSource(response3));
                    }
                    return coroutine_suspended;
                } catch (Exception e4) {
                    snapshot = snapshotWriteToDiskCache;
                    e = e4;
                    response2 = response;
                    Utils.closeQuietly(response2);
                    throw e;
                }
                snapshotWriteToDiskCache = this.writeToDiskCache(fromDiskCache, cacheStrategyCompute.getNetworkRequest(), response, cacheStrategyCompute.getCacheResponse());
            } catch (Exception e5) {
                e = e5;
                snapshot = fromDiskCache;
            }
            response = (Response) objExecuteNetworkRequest;
            responseBodyRequireBody = Utils.requireBody(response);
        } catch (Exception e6) {
            e = e6;
        }
    }

    public final String getMimeType$coil_base_release(String url, MediaType contentType) {
        String mimeTypeFromUrl;
        String mediaType = contentType != null ? contentType.getMediaType() : null;
        if ((mediaType == null || StringsKt.startsWith$default(mediaType, "text/plain", false, 2, (Object) null)) && (mimeTypeFromUrl = Utils.getMimeTypeFromUrl(MimeTypeMap.getSingleton(), url)) != null) {
            return mimeTypeFromUrl;
        }
        if (mediaType != null) {
            return StringsKt.substringBefore$default(mediaType, ';', (String) null, 2, (Object) null);
        }
        return null;
    }
}
