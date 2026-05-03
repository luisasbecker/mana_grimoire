package com.revenuecat.purchases.ui.revenuecatui.templates;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import com.revenuecat.purchases.ui.revenuecatui.UIConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Template7.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public final class ComposableSingletons$Template7Kt {
    public static final ComposableSingletons$Template7Kt INSTANCE = new ComposableSingletons$Template7Kt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function3<AnimatedVisibilityScope, Composer, Integer, Unit> f185lambda1 = ComposableLambdaKt.composableLambdaInstance(-1653557890, false, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.ComposableSingletons$Template7Kt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
            invoke(animatedVisibilityScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
            ComposerKt.sourceInformation(composer, "C236@9791L69:Template7.kt#mf3l5c");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1653557890, i, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.ComposableSingletons$Template7Kt.lambda-1.<anonymous> (Template7.kt:236)");
            }
            SpacerKt.Spacer(SizeKt.m2069height3ABfNKs(Modifier.INSTANCE, UIConstant.INSTANCE.m10454getDefaultVerticalSpacingD9Ej5fM()), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$revenuecatui_defaultsBc8Release, reason: not valid java name */
    public final Function3<AnimatedVisibilityScope, Composer, Integer, Unit> m10853getLambda1$revenuecatui_defaultsBc8Release() {
        return f185lambda1;
    }
}
