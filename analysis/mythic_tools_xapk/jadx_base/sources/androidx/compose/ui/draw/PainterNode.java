package androidx.compose.ui.draw;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.ScaleFactorKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.media3.muxer.MuxerUtil;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: PainterModifier.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BA\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010.\u001a\u00020/*\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0016¢\u0006\u0004\b5\u00106J\u001c\u00107\u001a\u000208*\u0002092\u0006\u00101\u001a\u00020:2\u0006\u0010;\u001a\u000208H\u0016J\u001c\u0010<\u001a\u000208*\u0002092\u0006\u00101\u001a\u00020:2\u0006\u0010;\u001a\u000208H\u0016J\u001c\u0010=\u001a\u000208*\u0002092\u0006\u00101\u001a\u00020:2\u0006\u0010>\u001a\u000208H\u0016J\u001c\u0010?\u001a\u000208*\u0002092\u0006\u00101\u001a\u00020:2\u0006\u0010>\u001a\u000208H\u0016J\u0017\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020AH\u0002¢\u0006\u0004\bC\u0010DJ\u0017\u0010E\u001a\u0002042\u0006\u00103\u001a\u000204H\u0002¢\u0006\u0004\bF\u0010DJ\f\u0010G\u001a\u00020H*\u00020IH\u0016J\u0013\u0010J\u001a\u00020\u0007*\u00020AH\u0002¢\u0006\u0004\bK\u0010LJ\u0013\u0010M\u001a\u00020\u0007*\u00020AH\u0002¢\u0006\u0004\bN\u0010LJ\b\u0010O\u001a\u00020PH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u0017R\u0014\u0010,\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u0017¨\u0006Q"}, d2 = {"Landroidx/compose/ui/draw/PainterNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "sizeToIntrinsics", "", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "<init>", "(Landroidx/compose/ui/graphics/painter/Painter;ZLandroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;)V", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "setPainter", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "getSizeToIntrinsics", "()Z", "setSizeToIntrinsics", "(Z)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "setAlignment", "(Landroidx/compose/ui/Alignment;)V", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "setContentScale", "(Landroidx/compose/ui/layout/ContentScale;)V", "getAlpha", "()F", "setAlpha", "(F)V", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "useIntrinsicSize", "getUseIntrinsicSize", "shouldAutoInvalidate", "getShouldAutoInvalidate", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "maxIntrinsicWidth", "minIntrinsicHeight", "width", "maxIntrinsicHeight", "calculateScaledSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "calculateScaledSize-E7KxVPU", "(J)J", "modifyConstraints", "modifyConstraints-ZezNO4M", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "hasSpecifiedAndFiniteWidth", "hasSpecifiedAndFiniteWidth-uvyYCjk", "(J)Z", "hasSpecifiedAndFiniteHeight", "hasSpecifiedAndFiniteHeight-uvyYCjk", InAppPurchaseConstants.METHOD_TO_STRING, "", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class PainterNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode {
    private Alignment alignment;
    private float alpha;
    private ColorFilter colorFilter;
    private ContentScale contentScale;
    private Painter painter;
    private boolean sizeToIntrinsics;

    public PainterNode(Painter painter, boolean z, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter) {
        this.painter = painter;
        this.sizeToIntrinsics = z;
        this.alignment = alignment;
        this.contentScale = contentScale;
        this.alpha = f;
        this.colorFilter = colorFilter;
    }

    public /* synthetic */ PainterNode(Painter painter, boolean z, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(painter, z, (i & 4) != 0 ? Alignment.INSTANCE.getCenter() : alignment, (i & 8) != 0 ? ContentScale.INSTANCE.getInside() : contentScale, (i & 16) != 0 ? 1.0f : f, (i & 32) != 0 ? null : colorFilter);
    }

    /* JADX INFO: renamed from: calculateScaledSize-E7KxVPU, reason: not valid java name */
    private final long m5910calculateScaledSizeE7KxVPU(long dstSize) {
        if (!getUseIntrinsicSize()) {
            return dstSize;
        }
        long jM6140constructorimpl = Size.m6140constructorimpl((((long) Float.floatToRawIntBits(!m5912hasSpecifiedAndFiniteWidthuvyYCjk(this.painter.getIntrinsicSize()) ? Float.intBitsToFloat((int) (dstSize >> 32)) : Float.intBitsToFloat((int) (this.painter.getIntrinsicSize() >> 32)))) << 32) | (((long) Float.floatToRawIntBits(!m5911hasSpecifiedAndFiniteHeightuvyYCjk(this.painter.getIntrinsicSize()) ? Float.intBitsToFloat((int) (dstSize & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) : Float.intBitsToFloat((int) (this.painter.getIntrinsicSize() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        return (Float.intBitsToFloat((int) (dstSize >> 32)) == 0.0f || Float.intBitsToFloat((int) (dstSize & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) == 0.0f) ? Size.INSTANCE.m6158getZeroNHjbRc() : ScaleFactorKt.m7900timesUQTWf7w(jM6140constructorimpl, this.contentScale.mo7762computeScaleFactorH7hwNQA(jM6140constructorimpl, dstSize));
    }

    private final boolean getUseIntrinsicSize() {
        return this.sizeToIntrinsics && this.painter.getIntrinsicSize() != InlineClassHelperKt.UnspecifiedPackedFloats;
    }

    /* JADX INFO: renamed from: hasSpecifiedAndFiniteHeight-uvyYCjk, reason: not valid java name */
    private final boolean m5911hasSpecifiedAndFiniteHeightuvyYCjk(long j) {
        return !Size.m6145equalsimpl0(j, Size.INSTANCE.m6157getUnspecifiedNHjbRc()) && (Float.floatToRawIntBits(Float.intBitsToFloat((int) (j & MuxerUtil.UNSIGNED_INT_MAX_VALUE))) & Integer.MAX_VALUE) < 2139095040;
    }

    /* JADX INFO: renamed from: hasSpecifiedAndFiniteWidth-uvyYCjk, reason: not valid java name */
    private final boolean m5912hasSpecifiedAndFiniteWidthuvyYCjk(long j) {
        return !Size.m6145equalsimpl0(j, Size.INSTANCE.m6157getUnspecifiedNHjbRc()) && (Float.floatToRawIntBits(Float.intBitsToFloat((int) (j >> 32))) & Integer.MAX_VALUE) < 2139095040;
    }

    /* JADX INFO: renamed from: modifyConstraints-ZezNO4M, reason: not valid java name */
    private final long m5913modifyConstraintsZezNO4M(long constraints) {
        boolean z = Constraints.m9063getHasBoundedWidthimpl(constraints) && Constraints.m9062getHasBoundedHeightimpl(constraints);
        boolean z2 = Constraints.m9065getHasFixedWidthimpl(constraints) && Constraints.m9064getHasFixedHeightimpl(constraints);
        if ((!getUseIntrinsicSize() && z) || z2) {
            return Constraints.m9057copyZbe2FdA$default(constraints, Constraints.m9067getMaxWidthimpl(constraints), 0, Constraints.m9066getMaxHeightimpl(constraints), 0, 10, null);
        }
        long jMo7019getIntrinsicSizeNHjbRc = this.painter.getIntrinsicSize();
        int iRound = m5912hasSpecifiedAndFiniteWidthuvyYCjk(jMo7019getIntrinsicSizeNHjbRc) ? Math.round(Float.intBitsToFloat((int) (jMo7019getIntrinsicSizeNHjbRc >> 32))) : Constraints.m9069getMinWidthimpl(constraints);
        int iRound2 = m5911hasSpecifiedAndFiniteHeightuvyYCjk(jMo7019getIntrinsicSizeNHjbRc) ? Math.round(Float.intBitsToFloat((int) (jMo7019getIntrinsicSizeNHjbRc & MuxerUtil.UNSIGNED_INT_MAX_VALUE))) : Constraints.m9068getMinHeightimpl(constraints);
        long jM5910calculateScaledSizeE7KxVPU = m5910calculateScaledSizeE7KxVPU(Size.m6140constructorimpl((((long) Float.floatToRawIntBits(ConstraintsKt.m9083constrainHeightK40F9xA(constraints, iRound2))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) Float.floatToRawIntBits(ConstraintsKt.m9084constrainWidthK40F9xA(constraints, iRound))) << 32)));
        return Constraints.m9057copyZbe2FdA$default(constraints, ConstraintsKt.m9084constrainWidthK40F9xA(constraints, Math.round(Float.intBitsToFloat((int) (jM5910calculateScaledSizeE7KxVPU >> 32)))), 0, ConstraintsKt.m9083constrainHeightK40F9xA(constraints, Math.round(Float.intBitsToFloat((int) (jM5910calculateScaledSizeE7KxVPU & MuxerUtil.UNSIGNED_INT_MAX_VALUE)))), 0, 10, null);
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        long jMo7019getIntrinsicSizeNHjbRc = this.painter.getIntrinsicSize();
        long jM6140constructorimpl = Size.m6140constructorimpl((((long) Float.floatToRawIntBits(m5912hasSpecifiedAndFiniteWidthuvyYCjk(jMo7019getIntrinsicSizeNHjbRc) ? Float.intBitsToFloat((int) (jMo7019getIntrinsicSizeNHjbRc >> 32)) : Float.intBitsToFloat((int) (contentDrawScope.mo6899getSizeNHjbRc() >> 32)))) << 32) | (((long) Float.floatToRawIntBits(m5911hasSpecifiedAndFiniteHeightuvyYCjk(jMo7019getIntrinsicSizeNHjbRc) ? Float.intBitsToFloat((int) (jMo7019getIntrinsicSizeNHjbRc & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) : Float.intBitsToFloat((int) (contentDrawScope.mo6899getSizeNHjbRc() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE));
        long jM6158getZeroNHjbRc = (Float.intBitsToFloat((int) (contentDrawScope.mo6899getSizeNHjbRc() >> 32)) == 0.0f || Float.intBitsToFloat((int) (contentDrawScope.mo6899getSizeNHjbRc() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) == 0.0f) ? Size.INSTANCE.m6158getZeroNHjbRc() : ScaleFactorKt.m7900timesUQTWf7w(jM6140constructorimpl, this.contentScale.mo7762computeScaleFactorH7hwNQA(jM6140constructorimpl, contentDrawScope.mo6899getSizeNHjbRc()));
        long jMo5799alignKFBX0sM = this.alignment.mo5799alignKFBX0sM(IntSize.m9280constructorimpl((((long) Math.round(Float.intBitsToFloat((int) (jM6158getZeroNHjbRc & MuxerUtil.UNSIGNED_INT_MAX_VALUE)))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) Math.round(Float.intBitsToFloat((int) (jM6158getZeroNHjbRc >> 32)))) << 32)), IntSize.m9280constructorimpl((((long) Math.round(Float.intBitsToFloat((int) (contentDrawScope.mo6899getSizeNHjbRc() & MuxerUtil.UNSIGNED_INT_MAX_VALUE)))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (((long) Math.round(Float.intBitsToFloat((int) (contentDrawScope.mo6899getSizeNHjbRc() >> 32)))) << 32)), contentDrawScope.getLayoutDirection());
        float fM9242getXimpl = IntOffset.m9242getXimpl(jMo5799alignKFBX0sM);
        float fM9243getYimpl = IntOffset.m9243getYimpl(jMo5799alignKFBX0sM);
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        contentDrawScope2.getDrawContext().getTransform().translate(fM9242getXimpl, fM9243getYimpl);
        try {
            this.painter.m7025drawx_KDEd0(contentDrawScope2, jM6158getZeroNHjbRc, this.alpha, this.colorFilter);
            contentDrawScope2.getDrawContext().getTransform().translate(-fM9242getXimpl, -fM9243getYimpl);
            contentDrawScope.drawContent();
        } catch (Throwable th) {
            contentDrawScope2.getDrawContext().getTransform().translate(-fM9242getXimpl, -fM9243getYimpl);
            throw th;
        }
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    public final Painter getPainter() {
        return this.painter;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    public final boolean getSizeToIntrinsics() {
        return this.sizeToIntrinsics;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (!getUseIntrinsicSize()) {
            return intrinsicMeasurable.maxIntrinsicHeight(i);
        }
        long jM5913modifyConstraintsZezNO4M = m5913modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null));
        return Math.max(Constraints.m9068getMinHeightimpl(jM5913modifyConstraintsZezNO4M), intrinsicMeasurable.maxIntrinsicHeight(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (!getUseIntrinsicSize()) {
            return intrinsicMeasurable.maxIntrinsicWidth(i);
        }
        long jM5913modifyConstraintsZezNO4M = m5913modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null));
        return Math.max(Constraints.m9069getMinWidthimpl(jM5913modifyConstraintsZezNO4M), intrinsicMeasurable.maxIntrinsicWidth(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo1288measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        final Placeable placeableMo7769measureBRTryo0 = measurable.mo7769measureBRTryo0(m5913modifyConstraintsZezNO4M(j));
        return MeasureScope.layout$default(measureScope, placeableMo7769measureBRTryo0.getWidth(), placeableMo7769measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.draw.PainterNode$measure$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope.placeRelative$default(placementScope, placeableMo7769measureBRTryo0, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (!getUseIntrinsicSize()) {
            return intrinsicMeasurable.minIntrinsicHeight(i);
        }
        long jM5913modifyConstraintsZezNO4M = m5913modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null));
        return Math.max(Constraints.m9068getMinHeightimpl(jM5913modifyConstraintsZezNO4M), intrinsicMeasurable.minIntrinsicHeight(i));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (!getUseIntrinsicSize()) {
            return intrinsicMeasurable.minIntrinsicWidth(i);
        }
        long jM5913modifyConstraintsZezNO4M = m5913modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null));
        return Math.max(Constraints.m9069getMinWidthimpl(jM5913modifyConstraintsZezNO4M), intrinsicMeasurable.minIntrinsicWidth(i));
    }

    public final void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    public final void setAlpha(float f) {
        this.alpha = f;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.colorFilter = colorFilter;
    }

    public final void setContentScale(ContentScale contentScale) {
        this.contentScale = contentScale;
    }

    public final void setPainter(Painter painter) {
        this.painter = painter;
    }

    public final void setSizeToIntrinsics(boolean z) {
        this.sizeToIntrinsics = z;
    }

    public String toString() {
        return "PainterModifier(painter=" + this.painter + ", sizeToIntrinsics=" + this.sizeToIntrinsics + ", alignment=" + this.alignment + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ')';
    }
}
