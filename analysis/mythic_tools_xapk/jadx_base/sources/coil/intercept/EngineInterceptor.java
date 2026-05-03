package coil.intercept;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.media3.muxer.WebmConstants;
import coil.ComponentRegistry;
import coil.EventListener;
import coil.ImageLoader;
import coil.decode.DataSource;
import coil.decode.DecodeResult;
import coil.decode.Decoder;
import coil.decode.FileImageSource;
import coil.decode.ImageSource;
import coil.fetch.DrawableResult;
import coil.fetch.FetchResult;
import coil.fetch.Fetcher;
import coil.fetch.SourceResult;
import coil.intercept.Interceptor;
import coil.memory.MemoryCache;
import coil.memory.MemoryCacheService;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import coil.request.Options;
import coil.request.RequestService;
import coil.request.SuccessResult;
import coil.size.Scale;
import coil.size.Size;
import coil.transform.Transformation;
import coil.util.Bitmaps;
import coil.util.DrawableUtils;
import coil.util.Logger;
import coil.util.Utils;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.apache.commons.io.FilenameUtils;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: compiled from: EngineInterceptor.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 02\u00020\u0001:\u000201B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ&\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002JA\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010 J1\u0010!\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010#J9\u0010$\u001a\u00020%2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010&J\u0019\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010+J3\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fH\u0081@ø\u0001\u0000¢\u0006\u0004\b.\u0010/R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00062"}, d2 = {"Lcoil/intercept/EngineInterceptor;", "Lcoil/intercept/Interceptor;", "imageLoader", "Lcoil/ImageLoader;", "requestService", "Lcoil/request/RequestService;", "logger", "Lcoil/util/Logger;", "(Lcoil/ImageLoader;Lcoil/request/RequestService;Lcoil/util/Logger;)V", "memoryCacheService", "Lcoil/memory/MemoryCacheService;", "convertDrawableToBitmap", "Landroid/graphics/Bitmap;", "drawable", "Landroid/graphics/drawable/Drawable;", "options", "Lcoil/request/Options;", "transformations", "", "Lcoil/transform/Transformation;", "decode", "Lcoil/intercept/EngineInterceptor$ExecuteResult;", "fetchResult", "Lcoil/fetch/SourceResult;", "components", "Lcoil/ComponentRegistry;", "request", "Lcoil/request/ImageRequest;", "mappedData", "", "eventListener", "Lcoil/EventListener;", "(Lcoil/fetch/SourceResult;Lcoil/ComponentRegistry;Lcoil/request/ImageRequest;Ljava/lang/Object;Lcoil/request/Options;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "execute", "_options", "(Lcoil/request/ImageRequest;Ljava/lang/Object;Lcoil/request/Options;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetch", "Lcoil/fetch/FetchResult;", "(Lcoil/ComponentRegistry;Lcoil/request/ImageRequest;Ljava/lang/Object;Lcoil/request/Options;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "intercept", "Lcoil/request/ImageResult;", "chain", "Lcoil/intercept/Interceptor$Chain;", "(Lcoil/intercept/Interceptor$Chain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transform", "result", "transform$coil_base_release", "(Lcoil/intercept/EngineInterceptor$ExecuteResult;Lcoil/request/ImageRequest;Lcoil/request/Options;Lcoil/EventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ExecuteResult", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class EngineInterceptor implements Interceptor {
    private static final String TAG = "EngineInterceptor";
    private final ImageLoader imageLoader;
    private final Logger logger;
    private final MemoryCacheService memoryCacheService;
    private final RequestService requestService;

    /* JADX INFO: compiled from: EngineInterceptor.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ0\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcoil/intercept/EngineInterceptor$ExecuteResult;", "", "drawable", "Landroid/graphics/drawable/Drawable;", "isSampled", "", "dataSource", "Lcoil/decode/DataSource;", "diskCacheKey", "", "(Landroid/graphics/drawable/Drawable;ZLcoil/decode/DataSource;Ljava/lang/String;)V", "getDataSource", "()Lcoil/decode/DataSource;", "getDiskCacheKey", "()Ljava/lang/String;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "()Z", "copy", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ExecuteResult {
        private final DataSource dataSource;
        private final String diskCacheKey;
        private final Drawable drawable;
        private final boolean isSampled;

        public ExecuteResult(Drawable drawable, boolean z, DataSource dataSource, String str) {
            this.drawable = drawable;
            this.isSampled = z;
            this.dataSource = dataSource;
            this.diskCacheKey = str;
        }

        public static /* synthetic */ ExecuteResult copy$default(ExecuteResult executeResult, Drawable drawable, boolean z, DataSource dataSource, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                drawable = executeResult.drawable;
            }
            if ((i & 2) != 0) {
                z = executeResult.isSampled;
            }
            if ((i & 4) != 0) {
                dataSource = executeResult.dataSource;
            }
            if ((i & 8) != 0) {
                str = executeResult.diskCacheKey;
            }
            return executeResult.copy(drawable, z, dataSource, str);
        }

        public final ExecuteResult copy(Drawable drawable, boolean isSampled, DataSource dataSource, String diskCacheKey) {
            return new ExecuteResult(drawable, isSampled, dataSource, diskCacheKey);
        }

        public final DataSource getDataSource() {
            return this.dataSource;
        }

        public final String getDiskCacheKey() {
            return this.diskCacheKey;
        }

        public final Drawable getDrawable() {
            return this.drawable;
        }

        /* JADX INFO: renamed from: isSampled, reason: from getter */
        public final boolean getIsSampled() {
            return this.isSampled;
        }
    }

    /* JADX INFO: renamed from: coil.intercept.EngineInterceptor$decode$1, reason: invalid class name */
    /* JADX INFO: compiled from: EngineInterceptor.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "coil.intercept.EngineInterceptor", f = "EngineInterceptor.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {199}, m = "decode", n = {"this", "fetchResult", "components", "request", "mappedData", "options", "eventListener", "decoder", "searchIndex"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EngineInterceptor.this.decode(null, null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: coil.intercept.EngineInterceptor$execute$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EngineInterceptor.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "coil.intercept.EngineInterceptor", f = "EngineInterceptor.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {Imgproc.COLOR_YUV2BGRA_YVYU, 126, 144}, m = "execute", n = {"this", "request", "mappedData", "eventListener", "options", "components", "fetchResult", "this", "request", "eventListener", "options", "fetchResult"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4"})
    static final class C05681 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        C05681(Continuation<? super C05681> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EngineInterceptor.this.execute(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: coil.intercept.EngineInterceptor$fetch$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EngineInterceptor.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "coil.intercept.EngineInterceptor", f = "EngineInterceptor.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {WebmConstants.MkvEbmlElement.BLOCK_ADDITIONAL}, m = "fetch", n = {"this", "components", "request", "mappedData", "options", "eventListener", "fetcher", "searchIndex"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0"})
    static final class C05691 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C05691(Continuation<? super C05691> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EngineInterceptor.this.fetch(null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: coil.intercept.EngineInterceptor$intercept$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EngineInterceptor.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "coil.intercept.EngineInterceptor", f = "EngineInterceptor.kt", i = {0, 0}, l = {Imgproc.COLOR_HLS2RGB_FULL}, m = "intercept", n = {"this", "chain"}, s = {"L$0", "L$1"})
    static final class C05701 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C05701(Continuation<? super C05701> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EngineInterceptor.this.intercept(null, this);
        }
    }

    /* JADX INFO: renamed from: coil.intercept.EngineInterceptor$intercept$2, reason: invalid class name */
    /* JADX INFO: compiled from: EngineInterceptor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcoil/request/SuccessResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "coil.intercept.EngineInterceptor$intercept$2", f = "EngineInterceptor.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SuccessResult>, Object> {
        final /* synthetic */ MemoryCache.Key $cacheKey;
        final /* synthetic */ Interceptor.Chain $chain;
        final /* synthetic */ EventListener $eventListener;
        final /* synthetic */ Object $mappedData;
        final /* synthetic */ Options $options;
        final /* synthetic */ ImageRequest $request;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ImageRequest imageRequest, Object obj, Options options, EventListener eventListener, MemoryCache.Key key, Interceptor.Chain chain, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$request = imageRequest;
            this.$mappedData = obj;
            this.$options = options;
            this.$eventListener = eventListener;
            this.$cacheKey = key;
            this.$chain = chain;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return EngineInterceptor.this.new AnonymousClass2(this.$request, this.$mappedData, this.$options, this.$eventListener, this.$cacheKey, this.$chain, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SuccessResult> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = EngineInterceptor.this.execute(this.$request, this.$mappedData, this.$options, this.$eventListener, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ExecuteResult executeResult = (ExecuteResult) obj;
            boolean cacheValue = EngineInterceptor.this.memoryCacheService.setCacheValue(this.$cacheKey, this.$request, executeResult);
            Drawable drawable = executeResult.getDrawable();
            ImageRequest imageRequest = this.$request;
            DataSource dataSource = executeResult.getDataSource();
            MemoryCache.Key key = this.$cacheKey;
            if (!cacheValue) {
                key = null;
            }
            return new SuccessResult(drawable, imageRequest, dataSource, key, executeResult.getDiskCacheKey(), executeResult.getIsSampled(), Utils.isPlaceholderCached(this.$chain));
        }
    }

    public EngineInterceptor(ImageLoader imageLoader, RequestService requestService, Logger logger) {
        this.imageLoader = imageLoader;
        this.requestService = requestService;
        this.logger = logger;
        this.memoryCacheService = new MemoryCacheService(imageLoader, requestService, logger);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap convertDrawableToBitmap(Drawable drawable, Options options, List<? extends Transformation> transformations) {
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Bitmap.Config safeConfig = Bitmaps.getSafeConfig(bitmap);
            if (ArraysKt.contains(Utils.getVALID_TRANSFORMATION_CONFIGS(), safeConfig)) {
                return bitmap;
            }
            Logger logger = this.logger;
            if (logger != null && logger.getLevel() <= 4) {
                logger.log(TAG, 4, "Converting bitmap with config " + safeConfig + " to apply transformations: " + transformations + FilenameUtils.EXTENSION_SEPARATOR, null);
            }
        } else {
            Logger logger2 = this.logger;
            if (logger2 != null && logger2.getLevel() <= 4) {
                logger2.log(TAG, 4, "Converting drawable of type " + drawable.getClass().getCanonicalName() + " to apply transformations: " + transformations + FilenameUtils.EXTENSION_SEPARATOR, null);
            }
        }
        return DrawableUtils.INSTANCE.convertToBitmap(drawable, options.getConfig(), options.getSize(), options.getScale(), options.getAllowInexactSize());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0097 -> B:21:0x009e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object decode(SourceResult sourceResult, ComponentRegistry componentRegistry, ImageRequest imageRequest, Object obj, Options options, EventListener eventListener, Continuation<? super ExecuteResult> continuation) {
        AnonymousClass1 anonymousClass1;
        int i;
        Pair<Decoder, Integer> pairNewDecoder;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object obj2 = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            i = 0;
            pairNewDecoder = componentRegistry.newDecoder(sourceResult, options, this.imageLoader, i);
            if (pairNewDecoder != null) {
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i3 = anonymousClass1.I$0;
            Decoder decoder = (Decoder) anonymousClass1.L$7;
            EventListener eventListener2 = (EventListener) anonymousClass1.L$6;
            Options options2 = (Options) anonymousClass1.L$5;
            obj = anonymousClass1.L$4;
            ImageRequest imageRequest2 = (ImageRequest) anonymousClass1.L$3;
            ComponentRegistry componentRegistry2 = (ComponentRegistry) anonymousClass1.L$2;
            SourceResult sourceResult2 = (SourceResult) anonymousClass1.L$1;
            EngineInterceptor engineInterceptor = (EngineInterceptor) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj2);
            AnonymousClass1 anonymousClass12 = anonymousClass1;
            int i4 = i3;
            this = engineInterceptor;
            AnonymousClass1 anonymousClass13 = anonymousClass12;
            eventListener = eventListener2;
            componentRegistry = componentRegistry2;
            options = options2;
            imageRequest = imageRequest2;
            DecodeResult decodeResult = (DecodeResult) obj2;
            eventListener.decodeEnd(imageRequest, decoder, options, decodeResult);
            if (decodeResult == null) {
                Drawable drawable = decodeResult.getDrawable();
                boolean isSampled = decodeResult.getIsSampled();
                DataSource dataSource = sourceResult2.getDataSource();
                ImageSource source = sourceResult2.getSource();
                FileImageSource fileImageSource = source instanceof FileImageSource ? (FileImageSource) source : null;
                return new ExecuteResult(drawable, isSampled, dataSource, fileImageSource != null ? fileImageSource.getDiskCacheKey() : null);
            }
            i = i4;
            sourceResult = sourceResult2;
            anonymousClass1 = anonymousClass13;
            pairNewDecoder = componentRegistry.newDecoder(sourceResult, options, this.imageLoader, i);
            if (pairNewDecoder != null) {
                throw new IllegalStateException(("Unable to create a decoder that supports: " + obj).toString());
            }
            Decoder first = pairNewDecoder.getFirst();
            int iIntValue = pairNewDecoder.getSecond().intValue() + 1;
            eventListener.decodeStart(imageRequest, first, options);
            anonymousClass1.L$0 = this;
            anonymousClass1.L$1 = sourceResult;
            anonymousClass1.L$2 = componentRegistry;
            anonymousClass1.L$3 = imageRequest;
            anonymousClass1.L$4 = obj;
            anonymousClass1.L$5 = options;
            anonymousClass1.L$6 = eventListener;
            anonymousClass1.L$7 = first;
            anonymousClass1.I$0 = iIntValue;
            anonymousClass1.label = 1;
            Object objDecode = first.decode(anonymousClass1);
            if (objDecode == coroutine_suspended) {
                return coroutine_suspended;
            }
            sourceResult2 = sourceResult;
            decoder = first;
            AnonymousClass1 anonymousClass14 = anonymousClass1;
            i4 = iIntValue;
            obj2 = objDecode;
            anonymousClass13 = anonymousClass14;
            DecodeResult decodeResult2 = (DecodeResult) obj2;
            eventListener.decodeEnd(imageRequest, decoder, options, decodeResult2);
            if (decodeResult2 == null) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01fe, code lost:
    
        if (r1 == r7) goto L71;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0228  */
    /* JADX WARN: Type inference failed for: r1v14, types: [T, coil.ComponentRegistry] */
    /* JADX WARN: Type inference failed for: r1v20, types: [T, coil.request.Options] */
    /* JADX WARN: Type inference failed for: r1v7, types: [T, coil.ComponentRegistry] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object execute(ImageRequest imageRequest, Object obj, Options options, EventListener eventListener, Continuation<? super ExecuteResult> continuation) throws Throwable {
        C05681 c05681;
        SourceResult sourceResult;
        ImageSource source;
        EngineInterceptor engineInterceptor;
        ImageRequest imageRequest2;
        Object obj2;
        EventListener eventListener2;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        Ref.ObjectRef objectRef3;
        Ref.ObjectRef objectRef4;
        T t;
        ImageRequest imageRequest3;
        Ref.ObjectRef objectRef5;
        EventListener eventListener3;
        ExecuteResult executeResult;
        Ref.ObjectRef objectRef6;
        EngineInterceptor engineInterceptor2;
        SourceResult sourceResult2;
        ImageSource source2;
        Object obj3;
        Object obj4;
        Bitmap bitmap;
        if (continuation instanceof C05681) {
            c05681 = (C05681) continuation;
            if ((c05681.label & Integer.MIN_VALUE) != 0) {
                c05681.label -= Integer.MIN_VALUE;
            } else {
                c05681 = new C05681(continuation);
            }
        }
        C05681 c056812 = c05681;
        Object obj5 = c056812.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        Ref.ObjectRef objectRef7 = c056812.label;
        try {
            if (objectRef7 == 0) {
                ResultKt.throwOnFailure(obj5);
                Ref.ObjectRef objectRef8 = new Ref.ObjectRef();
                objectRef8.element = options;
                Ref.ObjectRef objectRef9 = new Ref.ObjectRef();
                objectRef9.element = this.imageLoader.getComponents();
                Ref.ObjectRef objectRef10 = new Ref.ObjectRef();
                try {
                    if (!this.requestService.allowHardwareWorkerThread((Options) objectRef8.element)) {
                        Options options2 = (Options) objectRef8.element;
                        objectRef8.element = options2.copy((32765 & 1) != 0 ? options2.context : null, (32765 & 2) != 0 ? options2.config : Bitmap.Config.ARGB_8888, (32765 & 4) != 0 ? options2.colorSpace : null, (32765 & 8) != 0 ? options2.size : null, (32765 & 16) != 0 ? options2.scale : null, (32765 & 32) != 0 ? options2.allowInexactSize : false, (32765 & 64) != 0 ? options2.allowRgb565 : false, (32765 & 128) != 0 ? options2.premultipliedAlpha : false, (32765 & 256) != 0 ? options2.diskCacheKey : null, (32765 & 512) != 0 ? options2.headers : null, (32765 & 1024) != 0 ? options2.tags : null, (32765 & 2048) != 0 ? options2.parameters : null, (32765 & 4096) != 0 ? options2.memoryCachePolicy : null, (32765 & 8192) != 0 ? options2.diskCachePolicy : null, (32765 & 16384) != 0 ? options2.networkCachePolicy : null);
                    }
                    if (imageRequest.getFetcherFactory() != null || imageRequest.getDecoderFactory() != null) {
                        ComponentRegistry.Builder builderNewBuilder = ((ComponentRegistry) objectRef9.element).newBuilder();
                        Pair<Fetcher.Factory<?>, Class<?>> fetcherFactory = imageRequest.getFetcherFactory();
                        if (fetcherFactory != null) {
                            builderNewBuilder.getFetcherFactories$coil_base_release().add(0, fetcherFactory);
                        }
                        Decoder.Factory decoderFactory = imageRequest.getDecoderFactory();
                        if (decoderFactory != null) {
                            builderNewBuilder.getDecoderFactories$coil_base_release().add(0, decoderFactory);
                        }
                        objectRef9.element = builderNewBuilder.build();
                    }
                    ComponentRegistry componentRegistry = (ComponentRegistry) objectRef9.element;
                    Options options3 = (Options) objectRef8.element;
                    c056812.L$0 = this;
                    c056812.L$1 = imageRequest;
                    c056812.L$2 = obj;
                    c056812.L$3 = eventListener;
                    c056812.L$4 = objectRef8;
                    c056812.L$5 = objectRef9;
                    c056812.L$6 = objectRef10;
                    c056812.L$7 = objectRef10;
                    c056812.label = 1;
                    Object objFetch = fetch(componentRegistry, imageRequest, obj, options3, eventListener, c056812);
                    if (objFetch != coroutine_suspended) {
                        engineInterceptor = this;
                        imageRequest2 = imageRequest;
                        obj2 = obj;
                        eventListener2 = eventListener;
                        objectRef = objectRef8;
                        objectRef2 = objectRef9;
                        objectRef3 = objectRef10;
                        objectRef4 = objectRef3;
                        t = objFetch;
                    }
                    return coroutine_suspended;
                } catch (Throwable th) {
                    th = th;
                    objectRef7 = objectRef10;
                    T t2 = objectRef7.element;
                    sourceResult = t2 instanceof SourceResult ? (SourceResult) t2 : null;
                    if (sourceResult != null && (source = sourceResult.getSource()) != null) {
                        Utils.closeQuietly(source);
                    }
                    throw th;
                }
            }
            if (objectRef7 == 1) {
                objectRef3 = (Ref.ObjectRef) c056812.L$7;
                objectRef4 = (Ref.ObjectRef) c056812.L$6;
                Ref.ObjectRef objectRef11 = (Ref.ObjectRef) c056812.L$5;
                Ref.ObjectRef objectRef12 = (Ref.ObjectRef) c056812.L$4;
                EventListener eventListener4 = (EventListener) c056812.L$3;
                Object obj6 = c056812.L$2;
                ImageRequest imageRequest4 = (ImageRequest) c056812.L$1;
                EngineInterceptor engineInterceptor3 = (EngineInterceptor) c056812.L$0;
                ResultKt.throwOnFailure(obj5);
                objectRef2 = objectRef11;
                objectRef = objectRef12;
                eventListener2 = eventListener4;
                obj2 = obj6;
                imageRequest2 = imageRequest4;
                engineInterceptor = engineInterceptor3;
                t = obj5;
            } else {
                if (objectRef7 != 2) {
                    if (objectRef7 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj5);
                    obj4 = obj5;
                    ExecuteResult executeResult2 = (ExecuteResult) obj4;
                    Drawable drawable = executeResult2.getDrawable();
                    BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
                    if (bitmapDrawable != null && (bitmap = bitmapDrawable.getBitmap()) != null) {
                        bitmap.prepareToDraw();
                    }
                    return executeResult2;
                }
                objectRef4 = (Ref.ObjectRef) c056812.L$4;
                objectRef6 = (Ref.ObjectRef) c056812.L$3;
                eventListener3 = (EventListener) c056812.L$2;
                imageRequest3 = (ImageRequest) c056812.L$1;
                engineInterceptor2 = (EngineInterceptor) c056812.L$0;
                ResultKt.throwOnFailure(obj5);
                obj3 = obj5;
                executeResult = (ExecuteResult) obj3;
                objectRef5 = objectRef6;
                engineInterceptor = engineInterceptor2;
                EventListener eventListener5 = eventListener3;
                ImageRequest imageRequest5 = imageRequest3;
                T t3 = objectRef4.element;
                sourceResult2 = t3 instanceof SourceResult ? (SourceResult) t3 : null;
                if (sourceResult2 != null && (source2 = sourceResult2.getSource()) != null) {
                    Utils.closeQuietly(source2);
                }
                Options options4 = (Options) objectRef5.element;
                c056812.L$0 = null;
                c056812.L$1 = null;
                c056812.L$2 = null;
                c056812.L$3 = null;
                c056812.L$4 = null;
                c056812.L$5 = null;
                c056812.L$6 = null;
                c056812.L$7 = null;
                c056812.label = 3;
                Object objTransform$coil_base_release = engineInterceptor.transform$coil_base_release(executeResult, imageRequest5, options4, eventListener5, c056812);
                obj4 = objTransform$coil_base_release;
            }
            objectRef3.element = t;
            FetchResult fetchResult = (FetchResult) objectRef4.element;
            if (fetchResult instanceof SourceResult) {
                CoroutineDispatcher decoderDispatcher = imageRequest2.getDecoderDispatcher();
                Ref.ObjectRef objectRef13 = objectRef4;
                try {
                    imageRequest3 = imageRequest2;
                    Ref.ObjectRef objectRef14 = objectRef;
                    eventListener3 = eventListener2;
                    EngineInterceptor$execute$executeResult$1 engineInterceptor$execute$executeResult$1 = new EngineInterceptor$execute$executeResult$1(engineInterceptor, objectRef13, objectRef2, imageRequest2, obj2, objectRef, eventListener2, null);
                    c056812.L$0 = engineInterceptor;
                    c056812.L$1 = imageRequest3;
                    c056812.L$2 = eventListener3;
                    c056812.L$3 = objectRef14;
                    c056812.L$4 = objectRef4;
                    c056812.L$5 = null;
                    c056812.L$6 = null;
                    c056812.L$7 = null;
                    c056812.label = 2;
                    Object objWithContext = BuildersKt.withContext(decoderDispatcher, engineInterceptor$execute$executeResult$1, c056812);
                    if (objWithContext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef6 = objectRef14;
                    engineInterceptor2 = engineInterceptor;
                    obj3 = objWithContext;
                    executeResult = (ExecuteResult) obj3;
                    objectRef5 = objectRef6;
                    engineInterceptor = engineInterceptor2;
                    EventListener eventListener52 = eventListener3;
                    ImageRequest imageRequest52 = imageRequest3;
                    T t32 = objectRef4.element;
                    if (t32 instanceof SourceResult) {
                    }
                    if (sourceResult2 != null) {
                        Utils.closeQuietly(source2);
                    }
                    Options options42 = (Options) objectRef5.element;
                    c056812.L$0 = null;
                    c056812.L$1 = null;
                    c056812.L$2 = null;
                    c056812.L$3 = null;
                    c056812.L$4 = null;
                    c056812.L$5 = null;
                    c056812.L$6 = null;
                    c056812.L$7 = null;
                    c056812.label = 3;
                    Object objTransform$coil_base_release2 = engineInterceptor.transform$coil_base_release(executeResult, imageRequest52, options42, eventListener52, c056812);
                    obj4 = objTransform$coil_base_release2;
                } catch (Throwable th2) {
                    th = th2;
                    objectRef7 = objectRef13;
                    T t22 = objectRef7.element;
                    if (t22 instanceof SourceResult) {
                    }
                    if (sourceResult != null) {
                        Utils.closeQuietly(source);
                    }
                    throw th;
                }
            } else {
                imageRequest3 = imageRequest2;
                objectRef5 = objectRef;
                eventListener3 = eventListener2;
                if (!(fetchResult instanceof DrawableResult)) {
                    throw new NoWhenBranchMatchedException();
                }
                executeResult = new ExecuteResult(((DrawableResult) objectRef4.element).getDrawable(), ((DrawableResult) objectRef4.element).getIsSampled(), ((DrawableResult) objectRef4.element).getDataSource(), null);
                EventListener eventListener522 = eventListener3;
                ImageRequest imageRequest522 = imageRequest3;
                T t322 = objectRef4.element;
                if (t322 instanceof SourceResult) {
                }
                if (sourceResult2 != null) {
                }
                Options options422 = (Options) objectRef5.element;
                c056812.L$0 = null;
                c056812.L$1 = null;
                c056812.L$2 = null;
                c056812.L$3 = null;
                c056812.L$4 = null;
                c056812.L$5 = null;
                c056812.L$6 = null;
                c056812.L$7 = null;
                c056812.label = 3;
                Object objTransform$coil_base_release22 = engineInterceptor.transform$coil_base_release(executeResult, imageRequest522, options422, eventListener522, c056812);
                obj4 = objTransform$coil_base_release22;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0091 -> B:21:0x0098). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetch(ComponentRegistry componentRegistry, ImageRequest imageRequest, Object obj, Options options, EventListener eventListener, Continuation<? super FetchResult> continuation) {
        C05691 c05691;
        int i;
        Pair<Fetcher, Integer> pairNewFetcher;
        ImageSource source;
        if (continuation instanceof C05691) {
            c05691 = (C05691) continuation;
            if ((c05691.label & Integer.MIN_VALUE) != 0) {
                c05691.label -= Integer.MIN_VALUE;
            } else {
                c05691 = new C05691(continuation);
            }
        }
        Object obj2 = c05691.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c05691.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            i = 0;
            pairNewFetcher = componentRegistry.newFetcher(obj, options, this.imageLoader, i);
            if (pairNewFetcher != null) {
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i3 = c05691.I$0;
            Fetcher fetcher = (Fetcher) c05691.L$6;
            EventListener eventListener2 = (EventListener) c05691.L$5;
            Options options2 = (Options) c05691.L$4;
            Object obj3 = c05691.L$3;
            ImageRequest imageRequest2 = (ImageRequest) c05691.L$2;
            ComponentRegistry componentRegistry2 = (ComponentRegistry) c05691.L$1;
            EngineInterceptor engineInterceptor = (EngineInterceptor) c05691.L$0;
            ResultKt.throwOnFailure(obj2);
            C05691 c056912 = c05691;
            int i4 = i3;
            this = engineInterceptor;
            C05691 c056913 = c056912;
            eventListener = eventListener2;
            imageRequest = imageRequest2;
            options = options2;
            obj = obj3;
            FetchResult fetchResult = (FetchResult) obj2;
            try {
                eventListener.fetchEnd(imageRequest, fetcher, options, fetchResult);
                if (fetchResult == null) {
                    return fetchResult;
                }
                i = i4;
                componentRegistry = componentRegistry2;
                c05691 = c056913;
                pairNewFetcher = componentRegistry.newFetcher(obj, options, this.imageLoader, i);
                if (pairNewFetcher != null) {
                    throw new IllegalStateException(("Unable to create a fetcher that supports: " + obj).toString());
                }
                Fetcher first = pairNewFetcher.getFirst();
                int iIntValue = pairNewFetcher.getSecond().intValue() + 1;
                eventListener.fetchStart(imageRequest, first, options);
                c05691.L$0 = this;
                c05691.L$1 = componentRegistry;
                c05691.L$2 = imageRequest;
                c05691.L$3 = obj;
                c05691.L$4 = options;
                c05691.L$5 = eventListener;
                c05691.L$6 = first;
                c05691.I$0 = iIntValue;
                c05691.label = 1;
                Object objFetch = first.fetch(c05691);
                if (objFetch == coroutine_suspended) {
                    return coroutine_suspended;
                }
                componentRegistry2 = componentRegistry;
                fetcher = first;
                C05691 c056914 = c05691;
                i4 = iIntValue;
                obj2 = objFetch;
                c056913 = c056914;
                FetchResult fetchResult2 = (FetchResult) obj2;
                eventListener.fetchEnd(imageRequest, fetcher, options, fetchResult2);
                if (fetchResult2 == null) {
                }
            } catch (Throwable th) {
                SourceResult sourceResult = fetchResult2 instanceof SourceResult ? (SourceResult) fetchResult2 : null;
                if (sourceResult != null && (source = sourceResult.getSource()) != null) {
                    Utils.closeQuietly(source);
                }
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // coil.intercept.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object intercept(Interceptor.Chain chain, Continuation<? super ImageResult> continuation) throws Throwable {
        C05701 c05701;
        Throwable th;
        if (continuation instanceof C05701) {
            c05701 = (C05701) continuation;
            if ((c05701.label & Integer.MIN_VALUE) != 0) {
                c05701.label -= Integer.MIN_VALUE;
            } else {
                c05701 = new C05701(continuation);
            }
        }
        Object obj = c05701.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c05701.label;
        try {
        } catch (Throwable th2) {
            th = th2;
        }
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        try {
            ImageRequest request = chain.getRequest();
            Object data = request.getData();
            Size size = chain.getSize();
            EventListener eventListener = Utils.getEventListener(chain);
            Options options = this.requestService.options(request, size);
            Scale scale = options.getScale();
            eventListener.mapStart(request, data);
            Object map = this.imageLoader.getComponents().map(data, options);
            eventListener.mapEnd(request, map);
            MemoryCache.Key keyNewCacheKey = this.memoryCacheService.newCacheKey(request, map, options, eventListener);
            MemoryCache.Value cacheValue = keyNewCacheKey != null ? this.memoryCacheService.getCacheValue(request, keyNewCacheKey, size, scale) : null;
            if (cacheValue != null) {
                return this.memoryCacheService.newResult(chain, request, keyNewCacheKey, cacheValue);
            }
            CoroutineDispatcher fetcherDispatcher = request.getFetcherDispatcher();
            try {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(request, map, options, eventListener, keyNewCacheKey, chain, null);
                c05701.L$0 = this;
                c05701.L$1 = chain;
                c05701.label = 1;
                Object objWithContext = BuildersKt.withContext(fetcherDispatcher, anonymousClass2, c05701);
                return objWithContext == coroutine_suspended ? coroutine_suspended : objWithContext;
            } catch (Throwable th3) {
                th = th3;
                this = this;
                chain = chain;
            }
        } catch (Throwable th4) {
            th = th4;
            th = th;
        }
        if (th instanceof CancellationException) {
            throw th;
        }
        return this.requestService.errorResult(chain.getRequest(), th);
    }

    public final Object transform$coil_base_release(ExecuteResult executeResult, ImageRequest imageRequest, Options options, EventListener eventListener, Continuation<? super ExecuteResult> continuation) {
        List<Transformation> transformations = imageRequest.getTransformations();
        if (!transformations.isEmpty()) {
            if ((executeResult.getDrawable() instanceof BitmapDrawable) || imageRequest.getAllowConversionToBitmap()) {
                return BuildersKt.withContext(imageRequest.getTransformationDispatcher(), new EngineInterceptor$transform$3(this, executeResult, options, transformations, eventListener, imageRequest, null), continuation);
            }
            Logger logger = this.logger;
            if (logger != null && logger.getLevel() <= 4) {
                logger.log(TAG, 4, "allowConversionToBitmap=false, skipping transformations for type " + executeResult.getDrawable().getClass().getCanonicalName() + FilenameUtils.EXTENSION_SEPARATOR, null);
            }
        }
        return executeResult;
    }
}
