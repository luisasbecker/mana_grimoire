package com.revenuecat.purchases.ui.revenuecatui.components.timeline;

import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState;
import com.revenuecat.purchases.ui.revenuecatui.extensions.SizeConstraintExtensionsKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: TimelineComponentView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/ui/unit/Dp;", "invoke-lTKBWiU"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class TimelineComponentViewKt$TimelineComponentView$2$biggestIconWidth$2$1 extends Lambda implements Function0<Dp> {
    final /* synthetic */ TimelineComponentState $timelineState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TimelineComponentViewKt$TimelineComponentView$2$biggestIconWidth$2$1(TimelineComponentState timelineComponentState) {
        super(0);
        this.$timelineState = timelineComponentState;
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke-lTKBWiU, reason: not valid java name and merged with bridge method [inline-methods] */
    public final Dp invoke() {
        Dp dp;
        Iterator it = this.$timelineState.getItems().iterator();
        if (it.hasNext()) {
            Dp dpDpOrNull = SizeConstraintExtensionsKt.dpOrNull(((TimelineComponentState.ItemState) it.next()).getIcon().getSize().getWidth());
            Dp dpM9112boximpl = Dp.m9112boximpl(dpDpOrNull != null ? dpDpOrNull.m9128unboximpl() : Dp.m9114constructorimpl(0.0f));
            while (it.hasNext()) {
                Dp dpDpOrNull2 = SizeConstraintExtensionsKt.dpOrNull(((TimelineComponentState.ItemState) it.next()).getIcon().getSize().getWidth());
                Dp dpM9112boximpl2 = Dp.m9112boximpl(dpDpOrNull2 != null ? dpDpOrNull2.m9128unboximpl() : Dp.m9114constructorimpl(0.0f));
                if (dpM9112boximpl.compareTo(dpM9112boximpl2) < 0) {
                    dpM9112boximpl = dpM9112boximpl2;
                }
            }
            dp = dpM9112boximpl;
        } else {
            dp = null;
        }
        return dp;
    }
}
