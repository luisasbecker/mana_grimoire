package com.revenuecat.purchases.ui.revenuecatui.customercenter.navigation;

import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.ContentTransform;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomerCenterAnimations.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/navigation/CustomerCenterAnimations;", "", "()V", "getTransitionForNavigation", "Landroidx/compose/animation/ContentTransform;", "from", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/navigation/CustomerCenterDestination;", TypedValues.TransitionType.S_TO, "navigationState", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/navigation/CustomerCenterNavigationState;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CustomerCenterAnimations {
    public static final int $stable = 0;
    public static final CustomerCenterAnimations INSTANCE = new CustomerCenterAnimations();

    private CustomerCenterAnimations() {
    }

    public final ContentTransform getTransitionForNavigation(CustomerCenterDestination from, CustomerCenterDestination to, CustomerCenterNavigationState navigationState) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        Intrinsics.checkNotNullParameter(navigationState, "navigationState");
        return navigationState.isBackwardTransition(from, to) ? AnimatedContentKt.togetherWith(EnterExitTransitionKt.slideInHorizontally$default(null, new Function1<Integer, Integer>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.navigation.CustomerCenterAnimations.getTransitionForNavigation.1
            public final Integer invoke(int i) {
                return Integer.valueOf(-i);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                return invoke(num.intValue());
            }
        }, 1, null), EnterExitTransitionKt.slideOutHorizontally$default(null, new Function1<Integer, Integer>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.navigation.CustomerCenterAnimations.getTransitionForNavigation.2
            public final Integer invoke(int i) {
                return Integer.valueOf(i);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                return invoke(num.intValue());
            }
        }, 1, null)) : AnimatedContentKt.togetherWith(EnterExitTransitionKt.slideInHorizontally$default(null, new Function1<Integer, Integer>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.navigation.CustomerCenterAnimations.getTransitionForNavigation.3
            public final Integer invoke(int i) {
                return Integer.valueOf(i);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                return invoke(num.intValue());
            }
        }, 1, null), EnterExitTransitionKt.slideOutHorizontally$default(null, new Function1<Integer, Integer>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.navigation.CustomerCenterAnimations.getTransitionForNavigation.4
            public final Integer invoke(int i) {
                return Integer.valueOf(-i);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                return invoke(num.intValue());
            }
        }, 1, null));
    }
}
