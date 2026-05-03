package com.revenuecat.purchases.ui.revenuecatui.defaultpaywall;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.revenuecat.purchases.ui.revenuecatui.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultPaywallView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public final class ComposableSingletons$DefaultPaywallViewKt {
    public static final ComposableSingletons$DefaultPaywallViewKt INSTANCE = new ComposableSingletons$DefaultPaywallViewKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f178lambda1 = ComposableLambdaKt.composableLambdaInstance(619696328, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.ComposableSingletons$DefaultPaywallViewKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation(composer, "C228@9773L41:DefaultPaywallView.kt#trihdm");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(619696328, i, -1, "com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.ComposableSingletons$DefaultPaywallViewKt.lambda-1.<anonymous> (DefaultPaywallView.kt:228)");
            }
            SpacerKt.Spacer(SizeKt.m2069height3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(16.0f)), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-2, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f179lambda2 = ComposableLambdaKt.composableLambdaInstance(-1207225124, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.ComposableSingletons$DefaultPaywallViewKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope Button, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(Button, "$this$Button");
            ComposerKt.sourceInformation(composer, "C273@11119L46,272@11086L148:DefaultPaywallView.kt#trihdm");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1207225124, i, -1, "com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.ComposableSingletons$DefaultPaywallViewKt.lambda-2.<anonymous> (DefaultPaywallView.kt:272)");
            }
            TextKt.m4286Text4IGK_g(StringResources_androidKt.stringResource(R.string.revenuecatui_purchase, composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 131038);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-3, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f180lambda3 = ComposableLambdaKt.composableLambdaInstance(-1536372177, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.ComposableSingletons$DefaultPaywallViewKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation(composer, "C286@11558L55,286@11546L68:DefaultPaywallView.kt#trihdm");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1536372177, i, -1, "com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.ComposableSingletons$DefaultPaywallViewKt.lambda-3.<anonymous> (DefaultPaywallView.kt:286)");
            }
            TextKt.m4286Text4IGK_g(StringResources_androidKt.stringResource(R.string.revenuecatui_restore_purchases, composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$revenuecatui_defaultsBc8Release, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m10789getLambda1$revenuecatui_defaultsBc8Release() {
        return f178lambda1;
    }

    /* JADX INFO: renamed from: getLambda-2$revenuecatui_defaultsBc8Release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m10790getLambda2$revenuecatui_defaultsBc8Release() {
        return f179lambda2;
    }

    /* JADX INFO: renamed from: getLambda-3$revenuecatui_defaultsBc8Release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m10791getLambda3$revenuecatui_defaultsBc8Release() {
        return f180lambda3;
    }
}
