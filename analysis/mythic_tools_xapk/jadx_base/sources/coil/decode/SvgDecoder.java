package coil.decode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import coil.ImageLoader;
import coil.decode.Decoder;
import coil.fetch.SourceResult;
import coil.request.Options;
import coil.request.Svgs;
import coil.size.Scale;
import coil.size.Size;
import coil.size.Sizes;
import coil.util.SvgUtils;
import com.caverock.androidsvg.RenderOptions;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParseException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.InterruptibleKt;
import okio.BufferedSource;

/* JADX INFO: compiled from: SvgDecoder.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0002\u0015\u0016B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\u000b\u001a\u00020\fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\rJ,\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcoil/decode/SvgDecoder;", "Lcoil/decode/Decoder;", "source", "Lcoil/decode/ImageSource;", "options", "Lcoil/request/Options;", "useViewBoundsAsIntrinsicSize", "", "(Lcoil/decode/ImageSource;Lcoil/request/Options;Z)V", "getUseViewBoundsAsIntrinsicSize", "()Z", "decode", "Lcoil/decode/DecodeResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDstSize", "Lkotlin/Pair;", "", "srcWidth", "srcHeight", "scale", "Lcoil/size/Scale;", "Companion", "Factory", "coil-svg_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SvgDecoder implements Decoder {
    public static final String CSS_KEY = "coil#css";
    private static final float DEFAULT_SIZE = 512.0f;
    private static final String MIME_TYPE_SVG = "image/svg+xml";
    private final Options options;
    private final ImageSource source;
    private final boolean useViewBoundsAsIntrinsicSize;

    /* JADX INFO: compiled from: SvgDecoder.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcoil/decode/SvgDecoder$Factory;", "Lcoil/decode/Decoder$Factory;", "useViewBoundsAsIntrinsicSize", "", "(Z)V", "getUseViewBoundsAsIntrinsicSize", "()Z", "create", "Lcoil/decode/Decoder;", "result", "Lcoil/fetch/SourceResult;", "options", "Lcoil/request/Options;", "imageLoader", "Lcoil/ImageLoader;", "equals", "other", "", "hashCode", "", "isApplicable", "coil-svg_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Factory implements Decoder.Factory {
        private final boolean useViewBoundsAsIntrinsicSize;

        public Factory() {
            this(false, 1, null);
        }

        public Factory(boolean z) {
            this.useViewBoundsAsIntrinsicSize = z;
        }

        public /* synthetic */ Factory(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? true : z);
        }

        private final boolean isApplicable(SourceResult result) {
            return Intrinsics.areEqual(result.getMimeType(), SvgDecoder.MIME_TYPE_SVG) || SvgDecodeUtils.isSvg(DecodeUtils.INSTANCE, result.getSource().source());
        }

        @Override // coil.decode.Decoder.Factory
        public Decoder create(SourceResult result, Options options, ImageLoader imageLoader) {
            if (isApplicable(result)) {
                return new SvgDecoder(result.getSource(), options, this.useViewBoundsAsIntrinsicSize);
            }
            return null;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Factory) && this.useViewBoundsAsIntrinsicSize == ((Factory) other).useViewBoundsAsIntrinsicSize;
        }

        public final boolean getUseViewBoundsAsIntrinsicSize() {
            return this.useViewBoundsAsIntrinsicSize;
        }

        public int hashCode() {
            return Boolean.hashCode(this.useViewBoundsAsIntrinsicSize);
        }
    }

    public SvgDecoder(ImageSource imageSource, Options options) {
        this(imageSource, options, false, 4, null);
    }

    public SvgDecoder(ImageSource imageSource, Options options, boolean z) {
        this.source = imageSource;
        this.options = options;
        this.useViewBoundsAsIntrinsicSize = z;
    }

    public /* synthetic */ SvgDecoder(ImageSource imageSource, Options options, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageSource, options, (i & 4) != 0 ? true : z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<Float, Float> getDstSize(float srcWidth, float srcHeight, Scale scale) {
        if (!Sizes.isOriginal(this.options.getSize())) {
            Size size = this.options.getSize();
            return TuplesKt.to(Float.valueOf(SvgUtils.toPx(size.getWidth(), scale)), Float.valueOf(SvgUtils.toPx(size.getHeight(), scale)));
        }
        if (srcWidth <= 0.0f) {
            srcWidth = 512.0f;
        }
        if (srcHeight <= 0.0f) {
            srcHeight = 512.0f;
        }
        return TuplesKt.to(Float.valueOf(srcWidth), Float.valueOf(srcHeight));
    }

    @Override // coil.decode.Decoder
    public Object decode(Continuation<? super DecodeResult> continuation) {
        return InterruptibleKt.runInterruptible$default(null, new Function0<DecodeResult>() { // from class: coil.decode.SvgDecoder.decode.2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DecodeResult invoke() throws SVGParseException {
                float documentWidth;
                float documentHeight;
                int iRoundToInt;
                int iRoundToInt2;
                BufferedSource bufferedSourceSource = SvgDecoder.this.source.source();
                try {
                    SVG fromInputStream = SVG.getFromInputStream(bufferedSourceSource.inputStream());
                    CloseableKt.closeFinally(bufferedSourceSource, null);
                    RectF documentViewBox = fromInputStream.getDocumentViewBox();
                    if (!SvgDecoder.this.getUseViewBoundsAsIntrinsicSize() || documentViewBox == null) {
                        documentWidth = fromInputStream.getDocumentWidth();
                        documentHeight = fromInputStream.getDocumentHeight();
                    } else {
                        documentWidth = documentViewBox.width();
                        documentHeight = documentViewBox.height();
                    }
                    SvgDecoder svgDecoder = SvgDecoder.this;
                    Pair dstSize = svgDecoder.getDstSize(documentWidth, documentHeight, svgDecoder.options.getScale());
                    float fFloatValue = ((Number) dstSize.component1()).floatValue();
                    float fFloatValue2 = ((Number) dstSize.component2()).floatValue();
                    if (documentWidth <= 0.0f || documentHeight <= 0.0f) {
                        iRoundToInt = MathKt.roundToInt(fFloatValue);
                        iRoundToInt2 = MathKt.roundToInt(fFloatValue2);
                    } else {
                        float fComputeSizeMultiplier = DecodeUtils.computeSizeMultiplier(documentWidth, documentHeight, fFloatValue, fFloatValue2, SvgDecoder.this.options.getScale());
                        iRoundToInt = (int) (fComputeSizeMultiplier * documentWidth);
                        iRoundToInt2 = (int) (fComputeSizeMultiplier * documentHeight);
                    }
                    if (documentViewBox == null && documentWidth > 0.0f && documentHeight > 0.0f) {
                        fromInputStream.setDocumentViewBox(0.0f, 0.0f, documentWidth, documentHeight);
                    }
                    fromInputStream.setDocumentWidth("100%");
                    fromInputStream.setDocumentHeight("100%");
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iRoundToInt, iRoundToInt2, SvgUtils.toSoftware(SvgDecoder.this.options.getConfig()));
                    Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(width, height, config)");
                    String strCss = Svgs.css(SvgDecoder.this.options.getParameters());
                    fromInputStream.renderToCanvas(new Canvas(bitmapCreateBitmap), strCss != null ? new RenderOptions().css(strCss) : null);
                    return new DecodeResult(new BitmapDrawable(SvgDecoder.this.options.getContext().getResources(), bitmapCreateBitmap), true);
                } finally {
                }
            }
        }, continuation, 1, null);
    }

    public final boolean getUseViewBoundsAsIntrinsicSize() {
        return this.useViewBoundsAsIntrinsicSize;
    }
}
