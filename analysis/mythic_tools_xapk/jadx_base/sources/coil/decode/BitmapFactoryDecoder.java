package coil.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import coil.ImageLoader;
import coil.decode.Decoder;
import coil.decode.ImageSource;
import coil.fetch.SourceResult;
import coil.request.Options;
import coil.size.Size;
import coil.size.Sizes;
import coil.util.Bitmaps;
import coil.util.Utils;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.InterruptibleKt;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/* JADX INFO: compiled from: BitmapFactoryDecoder.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0003\u0016\u0017\u0018B\u0017\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B!\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0011\u0010\r\u001a\u00020\u000eH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0014\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0014\u0010\u0015\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\f\u0010\r\u001a\u00020\u000e*\u00020\u0012H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lcoil/decode/BitmapFactoryDecoder;", "Lcoil/decode/Decoder;", "source", "Lcoil/decode/ImageSource;", "options", "Lcoil/request/Options;", "(Lcoil/decode/ImageSource;Lcoil/request/Options;)V", "parallelismLock", "Lkotlinx/coroutines/sync/Semaphore;", "(Lcoil/decode/ImageSource;Lcoil/request/Options;Lkotlinx/coroutines/sync/Semaphore;)V", "exifOrientationPolicy", "Lcoil/decode/ExifOrientationPolicy;", "(Lcoil/decode/ImageSource;Lcoil/request/Options;Lkotlinx/coroutines/sync/Semaphore;Lcoil/decode/ExifOrientationPolicy;)V", "decode", "Lcoil/decode/DecodeResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "configureConfig", "", "Landroid/graphics/BitmapFactory$Options;", "exifData", "Lcoil/decode/ExifData;", "configureScale", "Companion", "ExceptionCatchingSource", "Factory", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BitmapFactoryDecoder implements Decoder {
    public static final int DEFAULT_MAX_PARALLELISM = 4;
    private final ExifOrientationPolicy exifOrientationPolicy;
    private final Options options;
    private final Semaphore parallelismLock;
    private final ImageSource source;

    /* JADX INFO: compiled from: BitmapFactoryDecoder.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0016R.\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00072\u000e\u0010\u0005\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcoil/decode/BitmapFactoryDecoder$ExceptionCatchingSource;", "Lokio/ForwardingSource;", "delegate", "Lokio/Source;", "(Lokio/Source;)V", "<set-?>", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "getException", "()Ljava/lang/Exception;", "read", "", "sink", "Lokio/Buffer;", "byteCount", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class ExceptionCatchingSource extends ForwardingSource {
        private Exception exception;

        public ExceptionCatchingSource(Source source) {
            super(source);
        }

        public final Exception getException() {
            return this.exception;
        }

        @Override // okio.ForwardingSource, okio.Source
        public long read(Buffer sink, long byteCount) throws Exception {
            try {
                return super.read(sink, byteCount);
            } catch (Exception e) {
                this.exception = e;
                throw e;
            }
        }
    }

    /* JADX INFO: compiled from: BitmapFactoryDecoder.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0017¢\u0006\u0002\u0010\u0002B\u0011\b\u0017\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcoil/decode/BitmapFactoryDecoder$Factory;", "Lcoil/decode/Decoder$Factory;", "()V", "maxParallelism", "", "(I)V", "exifOrientationPolicy", "Lcoil/decode/ExifOrientationPolicy;", "(ILcoil/decode/ExifOrientationPolicy;)V", "parallelismLock", "Lkotlinx/coroutines/sync/Semaphore;", "create", "Lcoil/decode/Decoder;", "result", "Lcoil/fetch/SourceResult;", "options", "Lcoil/request/Options;", "imageLoader", "Lcoil/ImageLoader;", "equals", "", "other", "", "hashCode", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Factory implements Decoder.Factory {
        private final ExifOrientationPolicy exifOrientationPolicy;
        private final Semaphore parallelismLock;

        /* JADX WARN: Multi-variable type inference failed */
        public Factory() {
            this(0, null, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Kept for binary compatibility.")
        public /* synthetic */ Factory(int i) {
            this(i, null, 2, 0 == true ? 1 : 0);
        }

        public /* synthetic */ Factory(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 4 : i);
        }

        public Factory(int i, ExifOrientationPolicy exifOrientationPolicy) {
            this.exifOrientationPolicy = exifOrientationPolicy;
            this.parallelismLock = SemaphoreKt.Semaphore$default(i, 0, 2, null);
        }

        public /* synthetic */ Factory(int i, ExifOrientationPolicy exifOrientationPolicy, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 4 : i, (i2 & 2) != 0 ? ExifOrientationPolicy.RESPECT_PERFORMANCE : exifOrientationPolicy);
        }

        @Override // coil.decode.Decoder.Factory
        public Decoder create(SourceResult result, Options options, ImageLoader imageLoader) {
            return new BitmapFactoryDecoder(result.getSource(), options, this.parallelismLock, this.exifOrientationPolicy);
        }

        public boolean equals(Object other) {
            return other instanceof Factory;
        }

        public int hashCode() {
            return getClass().hashCode();
        }
    }

    /* JADX INFO: renamed from: coil.decode.BitmapFactoryDecoder$decode$1, reason: invalid class name */
    /* JADX INFO: compiled from: BitmapFactoryDecoder.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "coil.decode.BitmapFactoryDecoder", f = "BitmapFactoryDecoder.kt", i = {0, 0, 1}, l = {232, 46}, m = "decode", n = {"this", "$this$withPermit$iv", "$this$withPermit$iv"}, s = {"L$0", "L$1", "L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BitmapFactoryDecoder.this.decode(this);
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Kept for binary compatibility.")
    public /* synthetic */ BitmapFactoryDecoder(ImageSource imageSource, Options options) {
        this(imageSource, options, null, null, 12, null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Kept for binary compatibility.")
    public /* synthetic */ BitmapFactoryDecoder(ImageSource imageSource, Options options, Semaphore semaphore) {
        this(imageSource, options, semaphore, null, 8, null);
    }

    public /* synthetic */ BitmapFactoryDecoder(ImageSource imageSource, Options options, Semaphore semaphore, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageSource, options, (i & 4) != 0 ? SemaphoreKt.Semaphore$default(Integer.MAX_VALUE, 0, 2, null) : semaphore);
    }

    public BitmapFactoryDecoder(ImageSource imageSource, Options options, Semaphore semaphore, ExifOrientationPolicy exifOrientationPolicy) {
        this.source = imageSource;
        this.options = options;
        this.parallelismLock = semaphore;
        this.exifOrientationPolicy = exifOrientationPolicy;
    }

    public /* synthetic */ BitmapFactoryDecoder(ImageSource imageSource, Options options, Semaphore semaphore, ExifOrientationPolicy exifOrientationPolicy, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageSource, options, (i & 4) != 0 ? SemaphoreKt.Semaphore$default(Integer.MAX_VALUE, 0, 2, null) : semaphore, (i & 8) != 0 ? ExifOrientationPolicy.RESPECT_PERFORMANCE : exifOrientationPolicy);
    }

    private final void configureConfig(BitmapFactory.Options options, ExifData exifData) {
        Bitmap.Config config = this.options.getConfig();
        if (exifData.getIsFlipped() || ExifUtilsKt.isRotated(exifData)) {
            config = Bitmaps.toSoftware(config);
        }
        if (this.options.getAllowRgb565() && config == Bitmap.Config.ARGB_8888 && Intrinsics.areEqual(options.outMimeType, "image/jpeg")) {
            config = Bitmap.Config.RGB_565;
        }
        if (options.outConfig == Bitmap.Config.RGBA_F16 && config != Bitmap.Config.HARDWARE) {
            config = Bitmap.Config.RGBA_F16;
        }
        options.inPreferredConfig = config;
    }

    private final void configureScale(BitmapFactory.Options options, ExifData exifData) {
        ImageSource.Metadata metadata = this.source.getMetadata();
        if ((metadata instanceof ResourceMetadata) && Sizes.isOriginal(this.options.getSize())) {
            options.inSampleSize = 1;
            options.inScaled = true;
            options.inDensity = ((ResourceMetadata) metadata).getDensity();
            options.inTargetDensity = this.options.getContext().getResources().getDisplayMetrics().densityDpi;
            return;
        }
        if (options.outWidth <= 0 || options.outHeight <= 0) {
            options.inSampleSize = 1;
            options.inScaled = false;
            return;
        }
        int i = ExifUtilsKt.isSwapped(exifData) ? options.outHeight : options.outWidth;
        int i2 = ExifUtilsKt.isSwapped(exifData) ? options.outWidth : options.outHeight;
        Size size = this.options.getSize();
        int px = Sizes.isOriginal(size) ? i : Utils.toPx(size.getWidth(), this.options.getScale());
        Size size2 = this.options.getSize();
        int px2 = Sizes.isOriginal(size2) ? i2 : Utils.toPx(size2.getHeight(), this.options.getScale());
        options.inSampleSize = DecodeUtils.calculateInSampleSize(i, i2, px, px2, this.options.getScale());
        double dComputeSizeMultiplier = DecodeUtils.computeSizeMultiplier(((double) i) / ((double) options.inSampleSize), ((double) i2) / ((double) options.inSampleSize), px, px2, this.options.getScale());
        if (this.options.getAllowInexactSize()) {
            dComputeSizeMultiplier = RangesKt.coerceAtMost(dComputeSizeMultiplier, 1.0d);
        }
        options.inScaled = !(dComputeSizeMultiplier == 1.0d);
        if (options.inScaled) {
            if (dComputeSizeMultiplier > 1.0d) {
                options.inDensity = MathKt.roundToInt(2.147483647E9d / dComputeSizeMultiplier);
                options.inTargetDensity = Integer.MAX_VALUE;
            } else {
                options.inDensity = Integer.MAX_VALUE;
                options.inTargetDensity = MathKt.roundToInt(2.147483647E9d * dComputeSizeMultiplier);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DecodeResult decode(BitmapFactory.Options options) throws Exception {
        ExceptionCatchingSource exceptionCatchingSource = new ExceptionCatchingSource(this.source.source());
        BufferedSource bufferedSourceBuffer = Okio.buffer(exceptionCatchingSource);
        boolean z = true;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(bufferedSourceBuffer.peek().inputStream(), null, options);
        Exception exception = exceptionCatchingSource.getException();
        if (exception != null) {
            throw exception;
        }
        options.inJustDecodeBounds = false;
        ExifData exifData = ExifUtils.INSTANCE.getExifData(options.outMimeType, bufferedSourceBuffer, this.exifOrientationPolicy);
        Exception exception2 = exceptionCatchingSource.getException();
        if (exception2 != null) {
            throw exception2;
        }
        options.inMutable = false;
        if (this.options.getColorSpace() != null) {
            options.inPreferredColorSpace = this.options.getColorSpace();
        }
        options.inPremultiplied = this.options.getPremultipliedAlpha();
        configureConfig(options, exifData);
        configureScale(options, exifData);
        BufferedSource bufferedSource = bufferedSourceBuffer;
        try {
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(bufferedSource.inputStream(), null, options);
            CloseableKt.closeFinally(bufferedSource, null);
            Exception exception3 = exceptionCatchingSource.getException();
            if (exception3 != null) {
                throw exception3;
            }
            if (bitmapDecodeStream == null) {
                throw new IllegalStateException("BitmapFactory returned a null bitmap. Often this means BitmapFactory could not decode the image data read from the input source (e.g. network, disk, or memory) as it's not encoded as a valid image format.".toString());
            }
            bitmapDecodeStream.setDensity(this.options.getContext().getResources().getDisplayMetrics().densityDpi);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(this.options.getContext().getResources(), ExifUtils.INSTANCE.reverseTransformations(bitmapDecodeStream, exifData));
            if (options.inSampleSize <= 1 && !options.inScaled) {
                z = false;
            }
            return new DecodeResult(bitmapDrawable, z);
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // coil.decode.Decoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object decode(Continuation<? super DecodeResult> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Semaphore semaphore;
        Throwable th;
        Semaphore semaphore2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                semaphore = this.parallelismLock;
                anonymousClass1.L$0 = this;
                anonymousClass1.L$1 = semaphore;
                anonymousClass1.label = 1;
                if (semaphore.acquire(anonymousClass1) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                semaphore2 = (Semaphore) anonymousClass1.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    DecodeResult decodeResult = (DecodeResult) obj;
                    semaphore2.release();
                    return decodeResult;
                } catch (Throwable th2) {
                    th = th2;
                    semaphore2.release();
                    throw th;
                }
            }
            Semaphore semaphore3 = (Semaphore) anonymousClass1.L$1;
            BitmapFactoryDecoder bitmapFactoryDecoder = (BitmapFactoryDecoder) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            semaphore = semaphore3;
            this = bitmapFactoryDecoder;
            Function0<DecodeResult> function0 = new Function0<DecodeResult>() { // from class: coil.decode.BitmapFactoryDecoder$decode$2$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final DecodeResult invoke() {
                    return this.this$0.decode(new BitmapFactory.Options());
                }
            };
            anonymousClass1.L$0 = semaphore;
            anonymousClass1.L$1 = null;
            anonymousClass1.label = 2;
            Object objRunInterruptible$default = InterruptibleKt.runInterruptible$default(null, function0, anonymousClass1, 1, null);
            if (objRunInterruptible$default != coroutine_suspended) {
                Semaphore semaphore4 = semaphore;
                obj = objRunInterruptible$default;
                semaphore2 = semaphore4;
                DecodeResult decodeResult2 = (DecodeResult) obj;
                semaphore2.release();
                return decodeResult2;
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            Semaphore semaphore5 = semaphore;
            th = th3;
            semaphore2 = semaphore5;
            semaphore2.release();
            throw th;
        }
    }
}
