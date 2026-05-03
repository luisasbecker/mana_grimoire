package com.revenuecat.purchases.ui.revenuecatui.components.timeline;

import androidx.constraintlayout.compose.ConstrainScope;
import androidx.constraintlayout.compose.ConstraintLayoutBaseScope;
import androidx.constraintlayout.compose.HorizontalAnchorable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: TimelineComponentView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/constraintlayout/compose/ConstrainScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class TimelineComponentViewKt$TimelineComponentView$2$1$1 extends Lambda implements Function1<ConstrainScope, Unit> {
    final /* synthetic */ ConstraintLayoutBaseScope.HorizontalAnchor $bottomContentBarrier;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TimelineComponentViewKt$TimelineComponentView$2$1$1(ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor) {
        super(1);
        this.$bottomContentBarrier = horizontalAnchor;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ConstrainScope constrainScope) {
        invoke2(constrainScope);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ConstrainScope constrainAs) {
        Intrinsics.checkNotNullParameter(constrainAs, "$this$constrainAs");
        HorizontalAnchorable.m9489linkToVpY3zN4$default(constrainAs.getTop(), this.$bottomContentBarrier, 0.0f, 0.0f, 6, (Object) null);
    }
}
