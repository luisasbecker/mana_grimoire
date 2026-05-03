package com.revenuecat.purchases.ui.revenuecatui.components.timeline;

import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.compose.ConstrainScope;
import androidx.constraintlayout.compose.ConstrainedLayoutReference;
import androidx.constraintlayout.compose.Dimension;
import androidx.constraintlayout.compose.HorizontalAnchorable;
import androidx.constraintlayout.compose.VerticalAnchorable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: TimelineComponentView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/constraintlayout/compose/ConstrainScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class TimelineComponentViewKt$TimelineComponentView$2$5$1$1 extends Lambda implements Function1<ConstrainScope, Unit> {
    final /* synthetic */ TimelineComponentState $timelineState;
    final /* synthetic */ ConstrainedLayoutReference $titleRef;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TimelineComponentViewKt$TimelineComponentView$2$5$1$1(ConstrainedLayoutReference constrainedLayoutReference, TimelineComponentState timelineComponentState) {
        super(1);
        this.$titleRef = constrainedLayoutReference;
        this.$timelineState = timelineComponentState;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ConstrainScope constrainScope) {
        invoke2(constrainScope);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ConstrainScope constrainAs) {
        Intrinsics.checkNotNullParameter(constrainAs, "$this$constrainAs");
        HorizontalAnchorable.m9489linkToVpY3zN4$default(constrainAs.getTop(), this.$titleRef.getBottom(), Dp.m9114constructorimpl(this.$timelineState.getTextSpacing()), 0.0f, 4, (Object) null);
        VerticalAnchorable.m9583linkToVpY3zN4$default(constrainAs.getStart(), this.$titleRef.getStart(), 0.0f, 0.0f, 6, null);
        VerticalAnchorable.m9583linkToVpY3zN4$default(constrainAs.getEnd(), constrainAs.getParent().getEnd(), 0.0f, 0.0f, 6, null);
        constrainAs.setWidth(Dimension.INSTANCE.getPreferredWrapContent());
        constrainAs.setHeight(Dimension.INSTANCE.getPreferredWrapContent());
        constrainAs.setHorizontalBias(0.0f);
    }
}
