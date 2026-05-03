package com.revenuecat.purchases.ui.revenuecatui.components.timeline;

import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.compose.ConstrainScope;
import androidx.constraintlayout.compose.ConstrainedLayoutReference;
import androidx.constraintlayout.compose.Dimension;
import androidx.constraintlayout.compose.HorizontalAnchorable;
import androidx.constraintlayout.compose.VerticalAnchorable;
import com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: TimelineComponentView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/constraintlayout/compose/ConstrainScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class TimelineComponentViewKt$TimelineComponentView$2$6$1$1 extends Lambda implements Function1<ConstrainScope, Unit> {
    final /* synthetic */ ConstrainedLayoutReference $currentIconRef;
    final /* synthetic */ boolean $isLastItem;
    final /* synthetic */ TimelineComponentState.ItemState $item;
    final /* synthetic */ ConstrainedLayoutReference $nextIconRef;
    final /* synthetic */ float $nextItemIconHalfSize;
    final /* synthetic */ Pair<Dp, Dp> $offsets;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TimelineComponentViewKt$TimelineComponentView$2$6$1$1(Pair<Dp, Dp> pair, TimelineComponentState.ItemState itemState, ConstrainedLayoutReference constrainedLayoutReference, boolean z, ConstrainedLayoutReference constrainedLayoutReference2, float f) {
        super(1);
        this.$offsets = pair;
        this.$item = itemState;
        this.$currentIconRef = constrainedLayoutReference;
        this.$isLastItem = z;
        this.$nextIconRef = constrainedLayoutReference2;
        this.$nextItemIconHalfSize = f;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ConstrainScope constrainScope) {
        invoke2(constrainScope);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ConstrainScope constrainAs) {
        Intrinsics.checkNotNullParameter(constrainAs, "$this$constrainAs");
        VerticalAnchorable.m9583linkToVpY3zN4$default(constrainAs.getStart(), constrainAs.getParent().getStart(), this.$offsets.getFirst().m9128unboximpl(), 0.0f, 4, null);
        constrainAs.setWidth(Dimension.INSTANCE.m9471value0680j_4(Dp.m9114constructorimpl(this.$item.getConnector() != null ? r1.getWidth() : 0.0f)));
        HorizontalAnchorable.m9489linkToVpY3zN4$default(constrainAs.getTop(), this.$currentIconRef.getTop(), 0.0f, 0.0f, 6, (Object) null);
        if (this.$isLastItem) {
            HorizontalAnchorable.m9489linkToVpY3zN4$default(constrainAs.getBottom(), constrainAs.getParent().getBottom(), this.$offsets.getSecond().m9128unboximpl(), 0.0f, 4, (Object) null);
        } else {
            HorizontalAnchorable bottom = constrainAs.getBottom();
            ConstrainedLayoutReference constrainedLayoutReference = this.$nextIconRef;
            Intrinsics.checkNotNull(constrainedLayoutReference);
            HorizontalAnchorable.m9489linkToVpY3zN4$default(bottom, constrainedLayoutReference.getBottom(), Dp.m9114constructorimpl(this.$nextItemIconHalfSize + this.$offsets.getSecond().m9128unboximpl()), 0.0f, 4, (Object) null);
        }
        constrainAs.setHeight(Dimension.INSTANCE.getFillToConstraints());
    }
}
