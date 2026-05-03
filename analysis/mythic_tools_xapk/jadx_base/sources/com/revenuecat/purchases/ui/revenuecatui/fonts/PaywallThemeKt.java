package com.revenuecat.purchases.ui.revenuecatui.fonts;

import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.ui.revenuecatui.extensions.TypographyExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PaywallTheme.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0001¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"PaywallTheme", "", "fontProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/fonts/FontProvider;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lcom/revenuecat/purchases/ui/revenuecatui/fonts/FontProvider;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PaywallThemeKt {
    public static final void PaywallTheme(final FontProvider fontProvider, Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i) {
        int i2;
        final Function2<? super Composer, ? super Integer, Unit> function2;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1433874321);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PaywallTheme)P(1):PaywallTheme.kt#1c51fp");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(fontProvider) : composerStartRestartGroup.changedInstance(fontProvider) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(content) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            function2 = content;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1433874321, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.fonts.PaywallTheme (PaywallTheme.kt:10)");
            }
            if (fontProvider == null) {
                composerStartRestartGroup.startReplaceGroup(1090937919);
                ComposerKt.sourceInformation(composerStartRestartGroup, "12@381L9");
                content.invoke(composerStartRestartGroup, Integer.valueOf((i2 >> 3) & 14));
                composerStartRestartGroup.endReplaceGroup();
                function2 = content;
            } else {
                composerStartRestartGroup.startReplaceGroup(1090975739);
                ComposerKt.sourceInformation(composerStartRestartGroup, "15@467L11,16@519L10,17@601L6,14@412L237");
                function2 = content;
                MaterialThemeKt.MaterialTheme(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable), MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, MaterialTheme.$stable), TypographyExtensionsKt.copyWithFontProvider(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable), fontProvider), function2, composerStartRestartGroup, (i2 << 6) & 7168, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.fonts.PaywallThemeKt.PaywallTheme.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    PaywallThemeKt.PaywallTheme(fontProvider, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
