package com.revenuecat.purchases.ui.revenuecatui.helpers;

import android.app.Activity;
import android.content.res.Configuration;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.window.core.layout.WindowHeightSizeClass;
import androidx.window.core.layout.WindowSizeClass;
import androidx.window.core.layout.WindowWidthSizeClass;
import androidx.window.layout.WindowMetrics;
import androidx.window.layout.WindowMetricsCalculator;
import com.revenuecat.purchases.ui.revenuecatui.PaywallMode;
import com.revenuecat.purchases.ui.revenuecatui.PaywallModeKt;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WindowHelper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0003\u001a\u00020\u0004H\u0001¢\u0006\u0002\u0010\u0005\u001a\u0019\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H\u0003¢\u0006\u0002\u0010\t\u001a\r\u0010\n\u001a\u00020\u000bH\u0001¢\u0006\u0002\u0010\f\u001a\u0015\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0003¢\u0006\u0002\u0010\u0010\u001a\u0018\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0001H\u0001\u001a\r\u0010\u0012\u001a\u00020\u0013H\u0003¢\u0006\u0002\u0010\u0014\u001a\u0011\u0010\r\u001a\u00020\u000b*\u00020\u0015H\u0001¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"computeWindowHeightSizeClass", "Landroidx/window/core/layout/WindowHeightSizeClass;", "(Landroidx/compose/runtime/Composer;I)Landroidx/window/core/layout/WindowHeightSizeClass;", "computeWindowWidthSizeClass", "Landroidx/window/core/layout/WindowWidthSizeClass;", "(Landroidx/compose/runtime/Composer;I)Landroidx/window/core/layout/WindowWidthSizeClass;", "getScreenSize", "Lkotlin/Pair;", "", "(Landroidx/compose/runtime/Composer;I)Lkotlin/Pair;", "hasCompactDimension", "", "(Landroidx/compose/runtime/Composer;I)Z", "shouldUseLandscapeLayout", "mode", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallMode;", "(Lcom/revenuecat/purchases/ui/revenuecatui/PaywallMode;Landroidx/compose/runtime/Composer;I)Z", "sizeClass", "windowSizeClass", "Landroidx/window/core/layout/WindowSizeClass;", "(Landroidx/compose/runtime/Composer;I)Landroidx/window/core/layout/WindowSizeClass;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;Landroidx/compose/runtime/Composer;I)Z", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class WindowHelperKt {
    public static final WindowHeightSizeClass computeWindowHeightSizeClass(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1980265325, "C(computeWindowHeightSizeClass)23@922L17:WindowHelper.kt#i2nnek");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1980265325, i, -1, "com.revenuecat.purchases.ui.revenuecatui.helpers.computeWindowHeightSizeClass (WindowHelper.kt:22)");
        }
        WindowHeightSizeClass windowHeightSizeClass = windowSizeClass(composer, 0).getWindowHeightSizeClass();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return windowHeightSizeClass;
    }

    public static final WindowWidthSizeClass computeWindowWidthSizeClass(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 173434359, "C(computeWindowWidthSizeClass)17@768L17:WindowHelper.kt#i2nnek");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(173434359, i, -1, "com.revenuecat.purchases.ui.revenuecatui.helpers.computeWindowWidthSizeClass (WindowHelper.kt:16)");
        }
        WindowWidthSizeClass windowWidthSizeClass = windowSizeClass(composer, 0).getWindowWidthSizeClass();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return windowWidthSizeClass;
    }

    private static final Pair<Float, Float> getScreenSize(Composer composer, int i) {
        Pair<Float, Float> pair;
        ComposerKt.sourceInformationMarkerStart(composer, 392213243, "C(getScreenSize)60@2044L7,61@2067L17,63@2217L7:WindowHelper.kt#i2nnek");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(392213243, i, -1, "com.revenuecat.purchases.ui.revenuecatui.helpers.getScreenSize (WindowHelper.kt:59)");
        }
        ProvidableCompositionLocal<Activity> localActivity = HelperFunctionsKt.getLocalActivity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localActivity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Activity activity = (Activity) objConsume;
        if (HelperFunctionsKt.isInPreviewMode(composer, 0) || activity == null) {
            ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = composer.consume(localConfiguration);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Configuration configuration = (Configuration) objConsume2;
            pair = TuplesKt.to(Float.valueOf(configuration.screenWidthDp), Float.valueOf(configuration.screenHeightDp));
        } else {
            float f = activity.getResources().getDisplayMetrics().density;
            WindowMetrics windowMetricsComputeCurrentWindowMetrics = WindowMetricsCalculator.INSTANCE.getOrCreate().computeCurrentWindowMetrics(activity);
            pair = new Pair<>(Float.valueOf(windowMetricsComputeCurrentWindowMetrics.getBounds().width() / f), Float.valueOf(windowMetricsComputeCurrentWindowMetrics.getBounds().height() / f));
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return pair;
    }

    public static final boolean hasCompactDimension(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 667952227, "C(hasCompactDimension)29@1054L30,30@1129L29:WindowHelper.kt#i2nnek");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(667952227, i, -1, "com.revenuecat.purchases.ui.revenuecatui.helpers.hasCompactDimension (WindowHelper.kt:28)");
        }
        boolean z = Intrinsics.areEqual(computeWindowHeightSizeClass(composer, 0), WindowHeightSizeClass.COMPACT) || Intrinsics.areEqual(computeWindowWidthSizeClass(composer, 0), WindowWidthSizeClass.COMPACT);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return z;
    }

    private static final boolean shouldUseLandscapeLayout(PaywallMode paywallMode, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1400525098, "C(shouldUseLandscapeLayout)42@1519L30:WindowHelper.kt#i2nnek");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1400525098, i, -1, "com.revenuecat.purchases.ui.revenuecatui.helpers.shouldUseLandscapeLayout (WindowHelper.kt:41)");
        }
        boolean zShouldUseLandscapeLayout = shouldUseLandscapeLayout(paywallMode, computeWindowHeightSizeClass(composer, 0));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return zShouldUseLandscapeLayout;
    }

    public static final boolean shouldUseLandscapeLayout(PaywallMode mode, WindowHeightSizeClass sizeClass) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(sizeClass, "sizeClass");
        return PaywallModeKt.isFullScreen(mode) && Intrinsics.areEqual(sizeClass, WindowHeightSizeClass.COMPACT);
    }

    public static final boolean shouldUseLandscapeLayout(PaywallState.Loaded.Legacy legacy, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(legacy, "<this>");
        ComposerKt.sourceInformationMarkerStart(composer, 405801034, "C(shouldUseLandscapeLayout)36@1315L59:WindowHelper.kt#i2nnek");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(405801034, i, -1, "com.revenuecat.purchases.ui.revenuecatui.helpers.shouldUseLandscapeLayout (WindowHelper.kt:35)");
        }
        boolean zShouldUseLandscapeLayout = shouldUseLandscapeLayout(legacy.getTemplateConfiguration().getMode(), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return zShouldUseLandscapeLayout;
    }

    private static final WindowSizeClass windowSizeClass(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1719780984, "C(windowSizeClass)53@1860L15:WindowHelper.kt#i2nnek");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1719780984, i, -1, "com.revenuecat.purchases.ui.revenuecatui.helpers.windowSizeClass (WindowHelper.kt:52)");
        }
        Pair<Float, Float> screenSize = getScreenSize(composer, 0);
        WindowSizeClass windowSizeClassCompute = WindowSizeClass.INSTANCE.compute(screenSize.component1().floatValue(), screenSize.component2().floatValue());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return windowSizeClassCompute;
    }
}
