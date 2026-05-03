package androidx.compose.material3;

import androidx.compose.material3.internal.LayoutUtilKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.compose.ui.util.MathHelpersKt;
import com.google.firebase.messaging.Constants;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: NavigationItem.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010!\u001a\u00020\"*\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010'\u001a\u00020(H\u0016¢\u0006\u0004\b)\u0010*J\"\u0010+\u001a\u00020,*\u00020-2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020.0%2\u0006\u0010/\u001a\u00020,H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\b\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\n\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001b\u0010\u0019R\u0013\u0010\u000b\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001c\u0010\u0019R\u0013\u0010\f\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001d\u0010\u0019R\u0013\u0010\r\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001e\u0010\u0019R\u0013\u0010\u000e\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001f\u0010\u0019R\u0013\u0010\u000f\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b \u0010\u0019¨\u00060"}, d2 = {"Landroidx/compose/material3/AnimatedMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "iconPosition", "Landroidx/compose/material3/NavigationItemIconPosition;", "iconPositionProgress", "Lkotlin/Function0;", "", "indicatorAnimationProgress", "topIconIndicatorHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "topIconIndicatorVerticalPadding", "topIconIndicatorToLabelVerticalPadding", "startIconIndicatorHorizontalPadding", "startIconIndicatorVerticalPadding", "startIconToLabelHorizontalPadding", "itemHorizontalPadding", "<init>", "(ILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;FFFFFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getIconPosition--xw1Ddg", "()I", "I", "getIconPositionProgress", "()Lkotlin/jvm/functions/Function0;", "getIndicatorAnimationProgress", "getTopIconIndicatorHorizontalPadding-D9Ej5fM", "()F", "F", "getTopIconIndicatorVerticalPadding-D9Ej5fM", "getTopIconIndicatorToLabelVerticalPadding-D9Ej5fM", "getStartIconIndicatorHorizontalPadding-D9Ej5fM", "getStartIconIndicatorVerticalPadding-D9Ej5fM", "getStartIconToLabelHorizontalPadding-D9Ej5fM", "getItemHorizontalPadding-D9Ej5fM", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "maxIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class AnimatedMeasurePolicy implements MeasurePolicy {
    private final int iconPosition;
    private final Function0<Float> iconPositionProgress;
    private final Function0<Float> indicatorAnimationProgress;
    private final float itemHorizontalPadding;
    private final float startIconIndicatorHorizontalPadding;
    private final float startIconIndicatorVerticalPadding;
    private final float startIconToLabelHorizontalPadding;
    private final float topIconIndicatorHorizontalPadding;
    private final float topIconIndicatorToLabelVerticalPadding;
    private final float topIconIndicatorVerticalPadding;

    private AnimatedMeasurePolicy(int i, Function0<Float> function0, Function0<Float> function02, float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        this.iconPosition = i;
        this.iconPositionProgress = function0;
        this.indicatorAnimationProgress = function02;
        this.topIconIndicatorHorizontalPadding = f;
        this.topIconIndicatorVerticalPadding = f2;
        this.topIconIndicatorToLabelVerticalPadding = f3;
        this.startIconIndicatorHorizontalPadding = f4;
        this.startIconIndicatorVerticalPadding = f5;
        this.startIconToLabelHorizontalPadding = f6;
        this.itemHorizontalPadding = f7;
    }

    public /* synthetic */ AnimatedMeasurePolicy(int i, Function0 function0, Function0 function02, float f, float f2, float f3, float f4, float f5, float f6, float f7, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, function0, function02, f, f2, f3, f4, f5, f6, f7);
    }

    /* JADX INFO: renamed from: getIconPosition--xw1Ddg, reason: not valid java name and from getter */
    public final int getIconPosition() {
        return this.iconPosition;
    }

    public final Function0<Float> getIconPositionProgress() {
        return this.iconPositionProgress;
    }

    public final Function0<Float> getIndicatorAnimationProgress() {
        return this.indicatorAnimationProgress;
    }

    /* JADX INFO: renamed from: getItemHorizontalPadding-D9Ej5fM, reason: not valid java name and from getter */
    public final float getItemHorizontalPadding() {
        return this.itemHorizontalPadding;
    }

    /* JADX INFO: renamed from: getStartIconIndicatorHorizontalPadding-D9Ej5fM, reason: not valid java name and from getter */
    public final float getStartIconIndicatorHorizontalPadding() {
        return this.startIconIndicatorHorizontalPadding;
    }

    /* JADX INFO: renamed from: getStartIconIndicatorVerticalPadding-D9Ej5fM, reason: not valid java name and from getter */
    public final float getStartIconIndicatorVerticalPadding() {
        return this.startIconIndicatorVerticalPadding;
    }

    /* JADX INFO: renamed from: getStartIconToLabelHorizontalPadding-D9Ej5fM, reason: not valid java name and from getter */
    public final float getStartIconToLabelHorizontalPadding() {
        return this.startIconToLabelHorizontalPadding;
    }

    /* JADX INFO: renamed from: getTopIconIndicatorHorizontalPadding-D9Ej5fM, reason: not valid java name and from getter */
    public final float getTopIconIndicatorHorizontalPadding() {
        return this.topIconIndicatorHorizontalPadding;
    }

    /* JADX INFO: renamed from: getTopIconIndicatorToLabelVerticalPadding-D9Ej5fM, reason: not valid java name and from getter */
    public final float getTopIconIndicatorToLabelVerticalPadding() {
        return this.topIconIndicatorToLabelVerticalPadding;
    }

    /* JADX INFO: renamed from: getTopIconIndicatorVerticalPadding-D9Ej5fM, reason: not valid java name and from getter */
    public final float getTopIconIndicatorVerticalPadding() {
        return this.topIconIndicatorVerticalPadding;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        List<? extends IntrinsicMeasurable> list2 = list;
        int size = list2.size();
        for (int i2 = 0; i2 < size; i2++) {
            IntrinsicMeasurable intrinsicMeasurable = list.get(i2);
            if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(intrinsicMeasurable), "icon")) {
                int iMaxIntrinsicWidth = intrinsicMeasurable.maxIntrinsicWidth(i);
                int size2 = list2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    IntrinsicMeasurable intrinsicMeasurable2 = list.get(i3);
                    if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(intrinsicMeasurable2), Constants.ScionAnalytics.PARAM_LABEL)) {
                        int iMaxIntrinsicWidth2 = intrinsicMeasurable2.maxIntrinsicWidth(i);
                        if (NavigationItemIconPosition.m3881equalsimpl0(this.iconPosition, NavigationItemIconPosition.INSTANCE.m3886getTopxw1Ddg())) {
                            return Math.max(iMaxIntrinsicWidth2, iMaxIntrinsicWidth + intrinsicMeasureScope.mo1618roundToPx0680j_4(Dp.m9114constructorimpl(Dp.m9114constructorimpl(this.topIconIndicatorHorizontalPadding * 2.0f) + Dp.m9114constructorimpl(this.itemHorizontalPadding * 2.0f))));
                        }
                        return iMaxIntrinsicWidth + iMaxIntrinsicWidth2 + intrinsicMeasureScope.mo1618roundToPx0680j_4(Dp.m9114constructorimpl(Dp.m9114constructorimpl(Dp.m9114constructorimpl(this.startIconIndicatorHorizontalPadding * 2.0f) + this.startIconToLabelHorizontalPadding) + this.itemHorizontalPadding));
                    }
                }
                ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                throw new KotlinNothingValueException();
            }
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo1260measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        MeasureScope measureScope2 = measureScope;
        float fFloatValue = this.indicatorAnimationProgress.invoke().floatValue();
        float fFloatValue2 = this.iconPositionProgress.invoke().floatValue();
        long jM9057copyZbe2FdA$default = Constraints.m9057copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
        List<? extends Measurable> list2 = list;
        int size = list2.size();
        int i = 0;
        while (i < size) {
            Measurable measurable = list.get(i);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "icon")) {
                Placeable placeableMo7769measureBRTryo0 = measurable.mo7769measureBRTryo0(jM9057copyZbe2FdA$default);
                int size2 = list2.size();
                int i2 = 0;
                while (i2 < size2) {
                    Measurable measurable2 = list.get(i2);
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), Constants.ScionAnalytics.PARAM_LABEL)) {
                        Placeable placeableMo7769measureBRTryo02 = measurable2.mo7769measureBRTryo0(jM9057copyZbe2FdA$default);
                        int width = placeableMo7769measureBRTryo0.getWidth() + measureScope2.mo1618roundToPx0680j_4(Dp.m9114constructorimpl(this.topIconIndicatorHorizontalPadding * 2.0f));
                        int height = placeableMo7769measureBRTryo0.getHeight() + measureScope2.mo1618roundToPx0680j_4(Dp.m9114constructorimpl(this.topIconIndicatorVerticalPadding * 2.0f));
                        int width2 = placeableMo7769measureBRTryo0.getWidth() + placeableMo7769measureBRTryo02.getWidth() + measureScope2.mo1618roundToPx0680j_4(Dp.m9114constructorimpl(this.startIconToLabelHorizontalPadding + Dp.m9114constructorimpl(this.startIconIndicatorHorizontalPadding * 2.0f)));
                        int iMax = Math.max(placeableMo7769measureBRTryo0.getHeight(), placeableMo7769measureBRTryo02.getHeight()) + measureScope2.mo1618roundToPx0680j_4(Dp.m9114constructorimpl(this.startIconIndicatorVerticalPadding * 2.0f));
                        int iLerp = MathHelpersKt.lerp(width, width2, fFloatValue2);
                        int iRoundToInt = MathKt.roundToInt(iLerp * fFloatValue);
                        int iLerp2 = MathHelpersKt.lerp(height, iMax, fFloatValue2);
                        int size3 = list2.size();
                        int i3 = 0;
                        while (i3 < size3) {
                            Measurable measurable3 = list.get(i3);
                            List<? extends Measurable> list3 = list2;
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), "indicatorRipple")) {
                                Placeable placeableMo7769measureBRTryo03 = measurable3.mo7769measureBRTryo0(ConstraintsKt.m9082constrainN9IONVI(jM9057copyZbe2FdA$default, Constraints.INSTANCE.m9077fixedJhjzzOo(iLerp, iLerp2)));
                                int size4 = list3.size();
                                int i4 = 0;
                                while (i4 < size4) {
                                    Measurable measurable4 = list.get(i4);
                                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable4), "indicator")) {
                                        return NavigationItemKt.m3896placeAnimatedLabelAndIcon2QYhCQ8(measureScope, this.iconPosition, this.iconPositionProgress, placeableMo7769measureBRTryo02, placeableMo7769measureBRTryo0, placeableMo7769measureBRTryo03, measurable4.mo7769measureBRTryo0(ConstraintsKt.m9082constrainN9IONVI(jM9057copyZbe2FdA$default, Constraints.INSTANCE.m9077fixedJhjzzOo(iRoundToInt, iLerp2))), width, jM9057copyZbe2FdA$default, this.topIconIndicatorToLabelVerticalPadding, this.topIconIndicatorVerticalPadding, this.topIconIndicatorHorizontalPadding, this.startIconIndicatorHorizontalPadding, this.startIconIndicatorVerticalPadding, this.startIconToLabelHorizontalPadding, this.itemHorizontalPadding);
                                    }
                                    int i5 = width;
                                    i4++;
                                    placeableMo7769measureBRTryo0 = placeableMo7769measureBRTryo0;
                                    placeableMo7769measureBRTryo03 = placeableMo7769measureBRTryo03;
                                    width = i5;
                                    placeableMo7769measureBRTryo02 = placeableMo7769measureBRTryo02;
                                }
                                ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                                throw new KotlinNothingValueException();
                            }
                            i3++;
                            list2 = list3;
                            placeableMo7769measureBRTryo02 = placeableMo7769measureBRTryo02;
                            placeableMo7769measureBRTryo0 = placeableMo7769measureBRTryo0;
                        }
                        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                        throw new KotlinNothingValueException();
                    }
                    i2++;
                    measureScope2 = measureScope;
                }
                ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                throw new KotlinNothingValueException();
            }
            i++;
            measureScope2 = measureScope;
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }
}
