package com.revenuecat.purchases.ui.revenuecatui.extensions;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import com.revenuecat.purchases.ui.revenuecatui.UIConstant;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Animations.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0001¢\u0006\u0002\u0010\u0003\u001a.\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0001ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\r²\u0006\n\u0010\u000e\u001a\u00020\u0001X\u008a\u0084\u0002²\u0006\n\u0010\u000f\u001a\u00020\u0005X\u008a\u0084\u0002"}, d2 = {"packageButtonActionInProgressOpacityAnimation", "", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;Landroidx/compose/runtime/Composer;I)F", "packageButtonColorAnimation", "Landroidx/compose/ui/graphics/Color;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;", "packageInfo", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;", "selectedColor", "unselectedColor", "packageButtonColorAnimation-9z6LAg8", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;JJLandroidx/compose/runtime/Composer;I)J", "revenuecatui_defaultsBc8Release", "alpha", "result"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AnimationsKt {
    public static final float packageButtonActionInProgressOpacityAnimation(PaywallViewModel paywallViewModel, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(paywallViewModel, "<this>");
        composer.startReplaceGroup(-1704661559);
        ComposerKt.sourceInformation(composer, "C(packageButtonActionInProgressOpacityAnimation)14@697L242:Animations.kt#yuhptp");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1704661559, i, -1, "com.revenuecat.purchases.ui.revenuecatui.extensions.packageButtonActionInProgressOpacityAnimation (Animations.kt:13)");
        }
        float fPackageButtonActionInProgressOpacityAnimation$lambda$0 = packageButtonActionInProgressOpacityAnimation$lambda$0(AnimateAsStateKt.animateFloatAsState(paywallViewModel.getActionInProgress().getValue().booleanValue() ? 0.4f : 1.0f, UIConstant.INSTANCE.defaultAnimation(), 0.0f, "Package button action in progress alpha", null, composer, 3072, 20));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return fPackageButtonActionInProgressOpacityAnimation$lambda$0;
    }

    private static final float packageButtonActionInProgressOpacityAnimation$lambda$0(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: renamed from: packageButtonColorAnimation-9z6LAg8, reason: not valid java name */
    public static final long m10841packageButtonColorAnimation9z6LAg8(PaywallState.Loaded.Legacy packageButtonColorAnimation, TemplateConfiguration.PackageInfo packageInfo, long j, long j2, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(packageButtonColorAnimation, "$this$packageButtonColorAnimation");
        Intrinsics.checkNotNullParameter(packageInfo, "packageInfo");
        composer.startReplaceGroup(792231715);
        ComposerKt.sourceInformation(composer, "C(packageButtonColorAnimation)P(!1,1:c#ui.graphics.Color,2:c#ui.graphics.Color)31@1236L241:Animations.kt#yuhptp");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(792231715, i, -1, "com.revenuecat.purchases.ui.revenuecatui.extensions.packageButtonColorAnimation (Animations.kt:28)");
        }
        long jPackageButtonColorAnimation_9z6LAg8$lambda$1 = packageButtonColorAnimation_9z6LAg8$lambda$1(SingleValueAnimationKt.m1353animateColorAsStateeuL9pac(Intrinsics.areEqual(packageInfo, packageButtonColorAnimation.getSelectedPackage().getValue()) ? j : j2, UIConstant.INSTANCE.defaultAnimation(), "Package button selected color: " + packageInfo.getRcPackage().getIdentifier(), null, composer, 0, 8));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return jPackageButtonColorAnimation_9z6LAg8$lambda$1;
    }

    private static final long packageButtonColorAnimation_9z6LAg8$lambda$1(State<Color> state) {
        return state.getValue().m6335unboximpl();
    }
}
