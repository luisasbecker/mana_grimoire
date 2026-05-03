package coil.compose;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.ScaleFactorKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: ContentPainterModifier.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B/\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u001d\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0014\u001a\u00020\u0005HÂ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÂ\u0003J\t\u0010\u0016\u001a\u00020\tHÂ\u0003J\t\u0010\u0017\u001a\u00020\u000bHÂ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\rHÂ\u0003J=\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\u001d\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010\u0013J\t\u0010$\u001a\u00020%HÖ\u0001J\f\u0010&\u001a\u00020'*\u00020(H\u0016J\u001c\u0010)\u001a\u00020\u001f*\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u001fH\u0016J\u001c\u0010.\u001a\u00020\u001f*\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010/\u001a\u00020\u001fH\u0016J)\u00100\u001a\u000201*\u0002022\u0006\u0010+\u001a\u0002032\u0006\u0010\"\u001a\u00020!H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u00105J\u001c\u00106\u001a\u00020\u001f*\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u001fH\u0016J\u001c\u00107\u001a\u00020\u001f*\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010/\u001a\u00020\u001fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00068"}, d2 = {"Lcoil/compose/ContentPainterModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/draw/DrawModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;)V", "calculateScaledSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "calculateScaledSize-E7KxVPU", "(J)J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "modifyConstraints", "Landroidx/compose/ui/unit/Constraints;", "constraints", "modifyConstraints-ZezNO4M", InAppPurchaseConstants.METHOD_TO_STRING, "", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "coil-compose-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ContentPainterModifier extends InspectorValueInfo implements LayoutModifier, DrawModifier {
    private final Alignment alignment;
    private final float alpha;
    private final ColorFilter colorFilter;
    private final ContentScale contentScale;
    private final Painter painter;

    public ContentPainterModifier(Painter painter, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter) {
        final Painter painter2;
        final Alignment alignment2;
        final ContentScale contentScale2;
        final float f2;
        final ColorFilter colorFilter2;
        Function1<InspectorInfo, Unit> noInspectorInfo;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            painter2 = painter;
            alignment2 = alignment;
            contentScale2 = contentScale;
            f2 = f;
            colorFilter2 = colorFilter;
            noInspectorInfo = new Function1<InspectorInfo, Unit>() { // from class: coil.compose.ContentPainterModifier$special$$inlined$debugInspectorInfo$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                    invoke2(inspectorInfo);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(InspectorInfo inspectorInfo) {
                    Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                    inspectorInfo.setName(FirebaseAnalytics.Param.CONTENT);
                    inspectorInfo.getProperties().set("painter", painter2);
                    inspectorInfo.getProperties().set("alignment", alignment2);
                    inspectorInfo.getProperties().set("contentScale", contentScale2);
                    inspectorInfo.getProperties().set("alpha", Float.valueOf(f2));
                    inspectorInfo.getProperties().set("colorFilter", colorFilter2);
                }
            };
        } else {
            painter2 = painter;
            alignment2 = alignment;
            contentScale2 = contentScale;
            f2 = f;
            colorFilter2 = colorFilter;
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        super(noInspectorInfo);
        this.painter = painter2;
        this.alignment = alignment2;
        this.contentScale = contentScale2;
        this.alpha = f2;
        this.colorFilter = colorFilter2;
    }

    /* JADX INFO: renamed from: calculateScaledSize-E7KxVPU, reason: not valid java name */
    private final long m9913calculateScaledSizeE7KxVPU(long dstSize) {
        if (Size.m6151isEmptyimpl(dstSize)) {
            return Size.INSTANCE.m6158getZeroNHjbRc();
        }
        long intrinsicSize = this.painter.getIntrinsicSize();
        if (intrinsicSize == Size.INSTANCE.m6157getUnspecifiedNHjbRc()) {
            return dstSize;
        }
        float fM6149getWidthimpl = Size.m6149getWidthimpl(intrinsicSize);
        if (Float.isInfinite(fM6149getWidthimpl) || Float.isNaN(fM6149getWidthimpl)) {
            fM6149getWidthimpl = Size.m6149getWidthimpl(dstSize);
        }
        float fM6146getHeightimpl = Size.m6146getHeightimpl(intrinsicSize);
        if (Float.isInfinite(fM6146getHeightimpl) || Float.isNaN(fM6146getHeightimpl)) {
            fM6146getHeightimpl = Size.m6146getHeightimpl(dstSize);
        }
        long jSize = SizeKt.Size(fM6149getWidthimpl, fM6146getHeightimpl);
        return ScaleFactorKt.m7900timesUQTWf7w(jSize, this.contentScale.mo7762computeScaleFactorH7hwNQA(jSize, dstSize));
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final Painter getPainter() {
        return this.painter;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final Alignment getAlignment() {
        return this.alignment;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    private final ContentScale getContentScale() {
        return this.contentScale;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    private final float getAlpha() {
        return this.alpha;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    private final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public static /* synthetic */ ContentPainterModifier copy$default(ContentPainterModifier contentPainterModifier, Painter painter, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, Object obj) {
        if ((i & 1) != 0) {
            painter = contentPainterModifier.painter;
        }
        if ((i & 2) != 0) {
            alignment = contentPainterModifier.alignment;
        }
        if ((i & 4) != 0) {
            contentScale = contentPainterModifier.contentScale;
        }
        if ((i & 8) != 0) {
            f = contentPainterModifier.alpha;
        }
        if ((i & 16) != 0) {
            colorFilter = contentPainterModifier.colorFilter;
        }
        ColorFilter colorFilter2 = colorFilter;
        ContentScale contentScale2 = contentScale;
        return contentPainterModifier.copy(painter, alignment, contentScale2, f, colorFilter2);
    }

    /* JADX INFO: renamed from: modifyConstraints-ZezNO4M, reason: not valid java name */
    private final long m9914modifyConstraintsZezNO4M(long constraints) {
        float fM9069getMinWidthimpl;
        int iM9068getMinHeightimpl;
        float fM9934constrainHeightK40F9xA;
        boolean zM9065getHasFixedWidthimpl = Constraints.m9065getHasFixedWidthimpl(constraints);
        boolean zM9064getHasFixedHeightimpl = Constraints.m9064getHasFixedHeightimpl(constraints);
        if (!zM9065getHasFixedWidthimpl || !zM9064getHasFixedHeightimpl) {
            boolean z = Constraints.m9063getHasBoundedWidthimpl(constraints) && Constraints.m9062getHasBoundedHeightimpl(constraints);
            long intrinsicSize = this.painter.getIntrinsicSize();
            if (intrinsicSize != Size.INSTANCE.m6157getUnspecifiedNHjbRc()) {
                if (z && (zM9065getHasFixedWidthimpl || zM9064getHasFixedHeightimpl)) {
                    fM9069getMinWidthimpl = Constraints.m9067getMaxWidthimpl(constraints);
                    iM9068getMinHeightimpl = Constraints.m9066getMaxHeightimpl(constraints);
                } else {
                    float fM6149getWidthimpl = Size.m6149getWidthimpl(intrinsicSize);
                    float fM6146getHeightimpl = Size.m6146getHeightimpl(intrinsicSize);
                    fM9069getMinWidthimpl = (Float.isInfinite(fM6149getWidthimpl) || Float.isNaN(fM6149getWidthimpl)) ? Constraints.m9069getMinWidthimpl(constraints) : UtilsKt.m9935constrainWidthK40F9xA(constraints, fM6149getWidthimpl);
                    if (!Float.isInfinite(fM6146getHeightimpl) && !Float.isNaN(fM6146getHeightimpl)) {
                        fM9934constrainHeightK40F9xA = UtilsKt.m9934constrainHeightK40F9xA(constraints, fM6146getHeightimpl);
                        long jM9913calculateScaledSizeE7KxVPU = m9913calculateScaledSizeE7KxVPU(SizeKt.Size(fM9069getMinWidthimpl, fM9934constrainHeightK40F9xA));
                        return Constraints.m9057copyZbe2FdA$default(constraints, ConstraintsKt.m9084constrainWidthK40F9xA(constraints, MathKt.roundToInt(Size.m6149getWidthimpl(jM9913calculateScaledSizeE7KxVPU))), 0, ConstraintsKt.m9083constrainHeightK40F9xA(constraints, MathKt.roundToInt(Size.m6146getHeightimpl(jM9913calculateScaledSizeE7KxVPU))), 0, 10, null);
                    }
                    iM9068getMinHeightimpl = Constraints.m9068getMinHeightimpl(constraints);
                }
                fM9934constrainHeightK40F9xA = iM9068getMinHeightimpl;
                long jM9913calculateScaledSizeE7KxVPU2 = m9913calculateScaledSizeE7KxVPU(SizeKt.Size(fM9069getMinWidthimpl, fM9934constrainHeightK40F9xA));
                return Constraints.m9057copyZbe2FdA$default(constraints, ConstraintsKt.m9084constrainWidthK40F9xA(constraints, MathKt.roundToInt(Size.m6149getWidthimpl(jM9913calculateScaledSizeE7KxVPU2))), 0, ConstraintsKt.m9083constrainHeightK40F9xA(constraints, MathKt.roundToInt(Size.m6146getHeightimpl(jM9913calculateScaledSizeE7KxVPU2))), 0, 10, null);
            }
            if (z) {
                return Constraints.m9057copyZbe2FdA$default(constraints, Constraints.m9067getMaxWidthimpl(constraints), 0, Constraints.m9066getMaxHeightimpl(constraints), 0, 10, null);
            }
        }
        return constraints;
    }

    public final ContentPainterModifier copy(Painter painter, Alignment alignment, ContentScale contentScale, float alpha, ColorFilter colorFilter) {
        return new ContentPainterModifier(painter, alignment, contentScale, alpha, colorFilter);
    }

    @Override // androidx.compose.ui.draw.DrawModifier
    public void draw(ContentDrawScope contentDrawScope) {
        long jM9913calculateScaledSizeE7KxVPU = m9913calculateScaledSizeE7KxVPU(contentDrawScope.mo6899getSizeNHjbRc());
        long jMo5799alignKFBX0sM = this.alignment.mo5799alignKFBX0sM(UtilsKt.m9936toIntSizeuvyYCjk(jM9913calculateScaledSizeE7KxVPU), UtilsKt.m9936toIntSizeuvyYCjk(contentDrawScope.mo6899getSizeNHjbRc()), contentDrawScope.getLayoutDirection());
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        float fM9234component1impl = IntOffset.m9234component1impl(jMo5799alignKFBX0sM);
        float fM9235component2impl = IntOffset.m9235component2impl(jMo5799alignKFBX0sM);
        contentDrawScope2.getDrawContext().getTransform().translate(fM9234component1impl, fM9235component2impl);
        this.painter.m7025drawx_KDEd0(contentDrawScope2, jM9913calculateScaledSizeE7KxVPU, this.alpha, this.colorFilter);
        contentDrawScope2.getDrawContext().getTransform().translate(-fM9234component1impl, -fM9235component2impl);
        contentDrawScope.drawContent();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ContentPainterModifier)) {
            return false;
        }
        ContentPainterModifier contentPainterModifier = (ContentPainterModifier) other;
        return Intrinsics.areEqual(this.painter, contentPainterModifier.painter) && Intrinsics.areEqual(this.alignment, contentPainterModifier.alignment) && Intrinsics.areEqual(this.contentScale, contentPainterModifier.contentScale) && Float.compare(this.alpha, contentPainterModifier.alpha) == 0 && Intrinsics.areEqual(this.colorFilter, contentPainterModifier.colorFilter);
    }

    public int hashCode() {
        int iHashCode = ((((((this.painter.hashCode() * 31) + this.alignment.hashCode()) * 31) + this.contentScale.hashCode()) * 31) + Float.hashCode(this.alpha)) * 31;
        ColorFilter colorFilter = this.colorFilter;
        return iHashCode + (colorFilter == null ? 0 : colorFilter.hashCode());
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (this.painter.getIntrinsicSize() == Size.INSTANCE.m6157getUnspecifiedNHjbRc()) {
            return intrinsicMeasurable.maxIntrinsicHeight(i);
        }
        int iMaxIntrinsicHeight = intrinsicMeasurable.maxIntrinsicHeight(Constraints.m9067getMaxWidthimpl(m9914modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null))));
        return Math.max(MathKt.roundToInt(Size.m6146getHeightimpl(m9913calculateScaledSizeE7KxVPU(SizeKt.Size(i, iMaxIntrinsicHeight)))), iMaxIntrinsicHeight);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (this.painter.getIntrinsicSize() == Size.INSTANCE.m6157getUnspecifiedNHjbRc()) {
            return intrinsicMeasurable.maxIntrinsicWidth(i);
        }
        int iMaxIntrinsicWidth = intrinsicMeasurable.maxIntrinsicWidth(Constraints.m9066getMaxHeightimpl(m9914modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null))));
        return Math.max(MathKt.roundToInt(Size.m6149getWidthimpl(m9913calculateScaledSizeE7KxVPU(SizeKt.Size(iMaxIntrinsicWidth, i)))), iMaxIntrinsicWidth);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo2417measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        final Placeable placeableMo7769measureBRTryo0 = measurable.mo7769measureBRTryo0(m9914modifyConstraintsZezNO4M(j));
        return MeasureScope.layout$default(measureScope, placeableMo7769measureBRTryo0.getWidth(), placeableMo7769measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: coil.compose.ContentPainterModifier$measure$1
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

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (this.painter.getIntrinsicSize() == Size.INSTANCE.m6157getUnspecifiedNHjbRc()) {
            return intrinsicMeasurable.minIntrinsicHeight(i);
        }
        int iMinIntrinsicHeight = intrinsicMeasurable.minIntrinsicHeight(Constraints.m9067getMaxWidthimpl(m9914modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null))));
        return Math.max(MathKt.roundToInt(Size.m6146getHeightimpl(m9913calculateScaledSizeE7KxVPU(SizeKt.Size(i, iMinIntrinsicHeight)))), iMinIntrinsicHeight);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (this.painter.getIntrinsicSize() == Size.INSTANCE.m6157getUnspecifiedNHjbRc()) {
            return intrinsicMeasurable.minIntrinsicWidth(i);
        }
        int iMinIntrinsicWidth = intrinsicMeasurable.minIntrinsicWidth(Constraints.m9066getMaxHeightimpl(m9914modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null))));
        return Math.max(MathKt.roundToInt(Size.m6149getWidthimpl(m9913calculateScaledSizeE7KxVPU(SizeKt.Size(iMinIntrinsicWidth, i)))), iMinIntrinsicWidth);
    }

    public String toString() {
        return "ContentPainterModifier(painter=" + this.painter + ", alignment=" + this.alignment + ", contentScale=" + this.contentScale + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ')';
    }
}
