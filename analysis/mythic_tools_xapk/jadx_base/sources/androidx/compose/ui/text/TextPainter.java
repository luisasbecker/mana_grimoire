package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.media3.muxer.MuxerUtil;
import kotlin.Metadata;

/* JADX INFO: compiled from: TextPainter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Landroidx/compose/ui/text/TextPainter;", "", "<init>", "()V", "paint", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextPainter {
    public static final int $stable = 0;
    public static final TextPainter INSTANCE = new TextPainter();

    private TextPainter() {
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void paint(Canvas canvas, TextLayoutResult textLayoutResult) {
        Canvas canvas2;
        Throwable th;
        Brush brush;
        Canvas canvas3;
        float alpha;
        boolean z = textLayoutResult.getHasVisualOverflow() && !TextOverflow.m9040equalsimpl0(textLayoutResult.getLayoutInput().getOverflow(), TextOverflow.INSTANCE.m9053getVisiblegIe3tQ8());
        if (z) {
            float size = (int) (textLayoutResult.getSize() >> 32);
            Rect rectM6120Recttz77jQw = RectKt.m6120Recttz77jQw(Offset.INSTANCE.m6096getZeroF1C5BW0(), Size.m6140constructorimpl((((long) Float.floatToRawIntBits((int) (textLayoutResult.getSize() & MuxerUtil.UNSIGNED_INT_MAX_VALUE))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) Float.floatToRawIntBits(size)) << 32)));
            canvas.save();
            canvas2 = null;
            Canvas.m6298clipRectmtrdDE$default(canvas, rectM6120Recttz77jQw, 0, 2, null);
        }
        SpanStyle spanStyle = textLayoutResult.getLayoutInput().getStyle().getSpanStyle();
        TextDecoration textDecoration = spanStyle.getTextDecoration();
        if (textDecoration == null) {
            textDecoration = TextDecoration.INSTANCE.getNone();
        }
        TextDecoration textDecoration2 = textDecoration;
        Shadow shadow = spanStyle.getShadow();
        if (shadow == null) {
            shadow = Shadow.INSTANCE.getNone();
        }
        Shadow shadow2 = shadow;
        Fill drawStyle = spanStyle.getDrawStyle();
        if (drawStyle == null) {
            drawStyle = Fill.INSTANCE;
        }
        DrawStyle drawStyle2 = drawStyle;
        try {
            brush = spanStyle.getBrush();
        } catch (Throwable th2) {
            th = th2;
            canvas2 = canvas;
        }
        try {
            if (brush != null) {
                if (spanStyle.getTextForegroundStyle() != TextForegroundStyle.Unspecified.INSTANCE) {
                    try {
                        alpha = spanStyle.getTextForegroundStyle().getAlpha();
                    } catch (Throwable th3) {
                        th = th3;
                        canvas2 = canvas;
                        if (z) {
                            throw th;
                        }
                        canvas2.restore();
                        throw th;
                    }
                } else {
                    alpha = 1.0f;
                }
                canvas3 = canvas;
                MultiParagraph.m8415painthn5TExg$default(textLayoutResult.getMultiParagraph(), canvas3, brush, alpha, shadow2, textDecoration2, drawStyle2, 0, 64, null);
            } else {
                canvas3 = canvas;
                textLayoutResult.getMultiParagraph().m8420paintLG529CI(canvas3, (32 & 2) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : spanStyle.getTextForegroundStyle() != TextForegroundStyle.Unspecified.INSTANCE ? spanStyle.getTextForegroundStyle().mo8872getColor0d7_KjU() : Color.INSTANCE.m6351getBlack0d7_KjU(), (32 & 4) != 0 ? null : shadow2, (32 & 8) != 0 ? null : textDecoration2, (32 & 16) == 0 ? drawStyle2 : null, (32 & 32) != 0 ? DrawScope.INSTANCE.m6901getDefaultBlendMode0nO6VwU() : 0);
            }
            if (z) {
                canvas3.restore();
            }
        } catch (Throwable th4) {
            th = th4;
            th = th;
            if (z) {
            }
        }
    }
}
