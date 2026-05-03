package androidx.compose.ui.text;

import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDrawStyleKt;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.media3.muxer.MuxerUtil;
import com.facebook.internal.AnalyticsEvents;
import java.util.List;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: TextPainter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a}\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001a\u001ag\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u001b2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018¢\u0006\u0004\b\u001c\u0010\u001d\u001ae\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)2\b\b\u0002\u0010\u0017\u001a\u00020\u0018¢\u0006\u0004\b*\u0010+\u001ac\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)2\b\b\u0002\u0010\u0017\u001a\u00020\u0018¢\u0006\u0004\b.\u0010/\u001a\u0014\u00100\u001a\u00020\u0001*\u0002012\u0006\u0010\u001e\u001a\u00020\u001fH\u0002\u001a#\u00102\u001a\u000203*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\bH\u0002¢\u0006\u0004\b4\u00105¨\u00066"}, d2 = {"drawText", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "textMeasurer", "Landroidx/compose/ui/text/TextMeasurer;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "topLeft", "Landroidx/compose/ui/geometry/Offset;", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Landroidx/compose/ui/text/TextStyle;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "size", "Landroidx/compose/ui/geometry/Size;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawText-JFhB2K4", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/text/TextMeasurer;Landroidx/compose/ui/text/AnnotatedString;JLandroidx/compose/ui/text/TextStyle;IZILjava/util/List;JI)V", "", "drawText-TPWCCtM", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/text/TextMeasurer;Ljava/lang/String;JLandroidx/compose/ui/text/TextStyle;IZIJI)V", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "color", "Landroidx/compose/ui/graphics/Color;", "alpha", "", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "drawText-d8-rzKo", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/text/TextLayoutResult;JJFLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "brush", "Landroidx/compose/ui/graphics/Brush;", "drawText-LVfH_YU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/graphics/Brush;JFLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "clip", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "textLayoutConstraints", "Landroidx/compose/ui/unit/Constraints;", "textLayoutConstraints-v_w8tDc", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJ)J", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextPainterKt {
    private static final void clip(DrawTransform drawTransform, TextLayoutResult textLayoutResult) {
        if (!textLayoutResult.getHasVisualOverflow() || TextOverflow.m9040equalsimpl0(textLayoutResult.getLayoutInput().getOverflow(), TextOverflow.INSTANCE.m9053getVisiblegIe3tQ8())) {
            return;
        }
        DrawTransform.m6956clipRectN_I0leg$default(drawTransform, 0.0f, 0.0f, (int) (textLayoutResult.getSize() >> 32), (int) (textLayoutResult.getSize() & MuxerUtil.UNSIGNED_INT_MAX_VALUE), 0, 16, null);
    }

    /* JADX INFO: renamed from: drawText-JFhB2K4, reason: not valid java name */
    public static final void m8535drawTextJFhB2K4(DrawScope drawScope, TextMeasurer textMeasurer, AnnotatedString annotatedString, long j, TextStyle textStyle, int i, boolean z, int i2, List<AnnotatedString.Range<Placeholder>> list, long j2, int i3) {
        TextLayoutResult textLayoutResultM8530measurexDpz5zY$default = TextMeasurer.m8530measurexDpz5zY$default(textMeasurer, annotatedString, textStyle, i, z, i2, list, m8543textLayoutConstraintsv_w8tDc(drawScope, j2, j), drawScope.getLayoutDirection(), drawScope, null, false, 1536, null);
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo6820getSizeNHjbRc = drawContext.mo6820getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            DrawTransform transform = drawContext.getTransform();
            transform.translate(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & MuxerUtil.UNSIGNED_INT_MAX_VALUE)));
            clip(transform, textLayoutResultM8530measurexDpz5zY$default);
            textLayoutResultM8530measurexDpz5zY$default.getMultiParagraph().m8420paintLG529CI(drawScope.getDrawContext().getCanvas(), (32 & 2) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : 0L, (32 & 4) != 0 ? null : null, (32 & 8) != 0 ? null : null, (32 & 16) == 0 ? null : null, (32 & 32) != 0 ? DrawScope.INSTANCE.m6901getDefaultBlendMode0nO6VwU() : i3);
        } finally {
            drawContext.getCanvas().restore();
            drawContext.mo6821setSizeuvyYCjk(jMo6820getSizeNHjbRc);
        }
    }

    /* JADX INFO: renamed from: drawText-LVfH_YU, reason: not valid java name */
    public static final void m8537drawTextLVfH_YU(DrawScope drawScope, TextLayoutResult textLayoutResult, Brush brush, long j, float f, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int i) {
        Shadow shadow2 = shadow == null ? textLayoutResult.getLayoutInput().getStyle().getShadow() : shadow;
        TextDecoration textDecoration2 = textDecoration == null ? textLayoutResult.getLayoutInput().getStyle().getTextDecoration() : textDecoration;
        DrawStyle drawStyle2 = drawStyle == null ? textLayoutResult.getLayoutInput().getStyle().getDrawStyle() : drawStyle;
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo6820getSizeNHjbRc = drawContext.mo6820getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            DrawTransform transform = drawContext.getTransform();
            transform.translate(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (MuxerUtil.UNSIGNED_INT_MAX_VALUE & j)));
            clip(transform, textLayoutResult);
            textLayoutResult.getMultiParagraph().m8422painthn5TExg(drawScope.getDrawContext().getCanvas(), brush, !Float.isNaN(f) ? f : textLayoutResult.getLayoutInput().getStyle().getAlpha(), shadow2, textDecoration2, drawStyle2, i);
        } finally {
            drawContext.getCanvas().restore();
            drawContext.mo6821setSizeuvyYCjk(jMo6820getSizeNHjbRc);
        }
    }

    /* JADX INFO: renamed from: drawText-TPWCCtM, reason: not valid java name */
    public static final void m8539drawTextTPWCCtM(DrawScope drawScope, TextMeasurer textMeasurer, String str, long j, TextStyle textStyle, int i, boolean z, int i2, long j2, int i3) {
        TextLayoutResult textLayoutResultM8530measurexDpz5zY$default = TextMeasurer.m8530measurexDpz5zY$default(textMeasurer, new AnnotatedString(str, null, 2, null), textStyle, i, z, i2, null, m8543textLayoutConstraintsv_w8tDc(drawScope, j2, j), drawScope.getLayoutDirection(), drawScope, null, false, 1568, null);
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo6820getSizeNHjbRc = drawContext.mo6820getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            DrawTransform transform = drawContext.getTransform();
            transform.translate(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & MuxerUtil.UNSIGNED_INT_MAX_VALUE)));
            clip(transform, textLayoutResultM8530measurexDpz5zY$default);
            textLayoutResultM8530measurexDpz5zY$default.getMultiParagraph().m8420paintLG529CI(drawScope.getDrawContext().getCanvas(), (32 & 2) != 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : 0L, (32 & 4) != 0 ? null : null, (32 & 8) != 0 ? null : null, (32 & 16) == 0 ? null : null, (32 & 32) != 0 ? DrawScope.INSTANCE.m6901getDefaultBlendMode0nO6VwU() : i3);
        } finally {
            drawContext.getCanvas().restore();
            drawContext.mo6821setSizeuvyYCjk(jMo6820getSizeNHjbRc);
        }
    }

    /* JADX INFO: renamed from: drawText-d8-rzKo, reason: not valid java name */
    public static final void m8541drawTextd8rzKo(DrawScope drawScope, TextLayoutResult textLayoutResult, long j, long j2, float f, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int i) {
        float alpha;
        int i2;
        Shadow shadow2;
        TextDecoration textDecoration2;
        DrawStyle drawStyle2;
        Canvas canvas;
        MultiParagraph multiParagraph;
        Shadow shadow3 = shadow == null ? textLayoutResult.getLayoutInput().getStyle().getShadow() : shadow;
        TextDecoration textDecoration3 = textDecoration == null ? textLayoutResult.getLayoutInput().getStyle().getTextDecoration() : textDecoration;
        DrawStyle drawStyle3 = drawStyle == null ? textLayoutResult.getLayoutInput().getStyle().getDrawStyle() : drawStyle;
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo6820getSizeNHjbRc = drawContext.mo6820getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            DrawTransform transform = drawContext.getTransform();
            transform.translate(Float.intBitsToFloat((int) (j2 >> 32)), Float.intBitsToFloat((int) (MuxerUtil.UNSIGNED_INT_MAX_VALUE & j2)));
            clip(transform, textLayoutResult);
            Brush brush = textLayoutResult.getLayoutInput().getStyle().getBrush();
            if (brush == null || j != 16) {
                MultiParagraph multiParagraph2 = textLayoutResult.getMultiParagraph();
                Canvas canvas2 = drawScope.getDrawContext().getCanvas();
                if (j == 16) {
                    j = textLayoutResult.getLayoutInput().getStyle().m8586getColor0d7_KjU();
                }
                multiParagraph2.m8420paintLG529CI(canvas2, TextDrawStyleKt.m9018modulateDxMtmZc(j, f), shadow3, textDecoration3, drawStyle3, i);
            } else {
                MultiParagraph multiParagraph3 = textLayoutResult.getMultiParagraph();
                Canvas canvas3 = drawScope.getDrawContext().getCanvas();
                if (Float.isNaN(f)) {
                    alpha = textLayoutResult.getLayoutInput().getStyle().getAlpha();
                    i2 = i;
                    shadow2 = shadow3;
                    textDecoration2 = textDecoration3;
                    drawStyle2 = drawStyle3;
                    canvas = canvas3;
                    multiParagraph = multiParagraph3;
                } else {
                    alpha = f;
                    canvas = canvas3;
                    multiParagraph = multiParagraph3;
                    i2 = i;
                    shadow2 = shadow3;
                    textDecoration2 = textDecoration3;
                    drawStyle2 = drawStyle3;
                }
                multiParagraph.m8422painthn5TExg(canvas, brush, alpha, shadow2, textDecoration2, drawStyle2, i2);
            }
        } finally {
            drawContext.getCanvas().restore();
            drawContext.mo6821setSizeuvyYCjk(jMo6820getSizeNHjbRc);
        }
    }

    /* JADX INFO: renamed from: textLayoutConstraints-v_w8tDc, reason: not valid java name */
    private static final long m8543textLayoutConstraintsv_w8tDc(DrawScope drawScope, long j, long j2) {
        int iCoerceAtLeast;
        int iRound;
        int iCoerceAtLeast2;
        int iRound2 = 0;
        if (j == InlineClassHelperKt.UnspecifiedPackedFloats || Float.isNaN(Float.intBitsToFloat((int) (j >> 32)))) {
            iCoerceAtLeast = RangesKt.coerceAtLeast(Math.round((float) Math.ceil(Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() >> 32)) - Float.intBitsToFloat((int) (j2 >> 32)))), 0);
            iRound = 0;
        } else {
            iRound = Math.round((float) Math.ceil(Float.intBitsToFloat((int) (j >> 32))));
            iCoerceAtLeast = iRound;
        }
        if (j == InlineClassHelperKt.UnspecifiedPackedFloats || Float.isNaN(Float.intBitsToFloat((int) (j & MuxerUtil.UNSIGNED_INT_MAX_VALUE)))) {
            iCoerceAtLeast2 = RangesKt.coerceAtLeast(Math.round((float) Math.ceil(Float.intBitsToFloat((int) (drawScope.mo6899getSizeNHjbRc() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) - Float.intBitsToFloat((int) (j2 & MuxerUtil.UNSIGNED_INT_MAX_VALUE)))), 0);
        } else {
            iRound2 = Math.round((float) Math.ceil(Float.intBitsToFloat((int) (j & MuxerUtil.UNSIGNED_INT_MAX_VALUE))));
            iCoerceAtLeast2 = iRound2;
        }
        return ConstraintsKt.Constraints(iRound, iCoerceAtLeast, iRound2, iCoerceAtLeast2);
    }
}
