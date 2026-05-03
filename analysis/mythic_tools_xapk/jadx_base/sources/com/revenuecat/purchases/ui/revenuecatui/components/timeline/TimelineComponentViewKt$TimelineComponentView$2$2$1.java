package com.revenuecat.purchases.ui.revenuecatui.components.timeline;

import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.compose.ConstrainScope;
import androidx.constraintlayout.compose.ConstrainedLayoutReference;
import androidx.constraintlayout.compose.ConstraintLayoutBaseScope;
import androidx.constraintlayout.compose.Dimension;
import androidx.constraintlayout.compose.HorizontalAnchorable;
import androidx.constraintlayout.compose.VerticalAnchorable;
import com.revenuecat.purchases.paywalls.components.TimelineComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: TimelineComponentView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/constraintlayout/compose/ConstrainScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class TimelineComponentViewKt$TimelineComponentView$2$2$1 extends Lambda implements Function1<ConstrainScope, Unit> {
    final /* synthetic */ State<Dp> $biggestIconWidth$delegate;
    final /* synthetic */ ConstraintLayoutBaseScope.HorizontalAnchor $currentPreviousItem;
    final /* synthetic */ ConstrainedLayoutReference $descriptionRef;
    final /* synthetic */ TimelineComponentState $timelineState;
    final /* synthetic */ ConstrainedLayoutReference $titleRef;

    /* JADX INFO: compiled from: TimelineComponentView.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TimelineComponent.IconAlignment.values().length];
            try {
                iArr[TimelineComponent.IconAlignment.Title.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TimelineComponent.IconAlignment.TitleAndDescription.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TimelineComponentViewKt$TimelineComponentView$2$2$1(TimelineComponentState timelineComponentState, ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor, ConstrainedLayoutReference constrainedLayoutReference, ConstrainedLayoutReference constrainedLayoutReference2, State<Dp> state) {
        super(1);
        this.$timelineState = timelineComponentState;
        this.$currentPreviousItem = horizontalAnchor;
        this.$titleRef = constrainedLayoutReference;
        this.$descriptionRef = constrainedLayoutReference2;
        this.$biggestIconWidth$delegate = state;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ConstrainScope constrainScope) {
        invoke2(constrainScope);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x008f  */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void invoke2(ConstrainScope constrainAs) {
        Dimension wrapContent;
        Intrinsics.checkNotNullParameter(constrainAs, "$this$constrainAs");
        int i = WhenMappings.$EnumSwitchMapping$0[this.$timelineState.getIconAlignment().ordinal()];
        if (i == 1) {
            HorizontalAnchorable top = constrainAs.getTop();
            ConstraintLayoutBaseScope.HorizontalAnchor top2 = this.$currentPreviousItem;
            if (top2 == null) {
                top2 = constrainAs.getParent().getTop();
            }
            HorizontalAnchorable.m9489linkToVpY3zN4$default(top, top2, 0.0f, 0.0f, 6, (Object) null);
            VerticalAnchorable.m9583linkToVpY3zN4$default(constrainAs.getStart(), constrainAs.getParent().getStart(), 0.0f, 0.0f, 6, null);
        } else if (i == 2) {
            HorizontalAnchorable.m9489linkToVpY3zN4$default(constrainAs.getTop(), this.$titleRef.getTop(), 0.0f, 0.0f, 6, (Object) null);
            HorizontalAnchorable.m9489linkToVpY3zN4$default(constrainAs.getBottom(), this.$descriptionRef.getBottom(), 0.0f, 0.0f, 6, (Object) null);
            VerticalAnchorable.m9583linkToVpY3zN4$default(constrainAs.getStart(), constrainAs.getParent().getStart(), 0.0f, 0.0f, 6, null);
        }
        Dp dpTimelineComponentView$lambda$13$lambda$1 = TimelineComponentViewKt.TimelineComponentView$lambda$13$lambda$1(this.$biggestIconWidth$delegate);
        if (dpTimelineComponentView$lambda$13$lambda$1 != null) {
            wrapContent = Dimension.INSTANCE.m9471value0680j_4(dpTimelineComponentView$lambda$13$lambda$1.m9128unboximpl());
            if (wrapContent == null) {
                wrapContent = Dimension.INSTANCE.getWrapContent();
            }
        }
        constrainAs.setWidth(wrapContent);
    }
}
