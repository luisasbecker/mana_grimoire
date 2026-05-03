package com.revenuecat.purchases.ui.revenuecatui.composables;

import android.content.Context;
import android.os.Build;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.BlurKt;
import androidx.compose.ui.draw.BlurredEdgeTreatment;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.ui.revenuecatui.PaywallModeKt;
import com.revenuecat.purchases.ui.revenuecatui.R;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.extensions.ModifierExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.extensions.PaywallDataExtensionsKt;
import defpackage.BlurTransformation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PaywallBackground.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0001¢\u0006\u0002\u0010\u0005\u001a\u0016\u0010\u0006\u001a\u00020\u0007*\u00020\bH\u0003ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000b"}, d2 = {"PaywallBackground", "", "Landroidx/compose/foundation/layout/BoxScope;", "templateConfiguration", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration;", "(Landroidx/compose/foundation/layout/BoxScope;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration;Landroidx/compose/runtime/Composer;I)V", "toFloatPx", "", "Landroidx/compose/ui/unit/Dp;", "toFloatPx-8Feqmps", "(FLandroidx/compose/runtime/Composer;I)F", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PaywallBackgroundKt {
    public static final void PaywallBackground(final BoxScope boxScope, final TemplateConfiguration templateConfiguration, Composer composer, final int i) {
        int i2;
        BlurTransformation blurTransformation;
        Intrinsics.checkNotNullParameter(boxScope, "<this>");
        Intrinsics.checkNotNullParameter(templateConfiguration, "templateConfiguration");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1106841354);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PaywallBackground):PaywallBackground.kt#51odh9");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(boxScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(templateConfiguration) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1106841354, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.PaywallBackground (PaywallBackground.kt:23)");
            }
            boolean z = Build.VERSION.SDK_INT >= 31;
            boolean blurredBackgroundImage = templateConfiguration.getConfiguration().getBlurredBackgroundImage();
            float f = blurredBackgroundImage ? 0.7f : 1.0f;
            composerStartRestartGroup.startReplaceGroup(1963318254);
            ComposerKt.sourceInformation(composerStartRestartGroup, "30@1565L7,31@1626L11");
            if (!blurredBackgroundImage || z) {
                blurTransformation = null;
            } else {
                ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localContext);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                blurTransformation = new BlurTransformation((Context) objConsume, m10654toFloatPx8Feqmps(BackgroundUIConstants.INSTANCE.m10617getBlurSizeD9Ej5fM(), composerStartRestartGroup, 6));
            }
            composerStartRestartGroup.endReplaceGroup();
            Modifier modifierConditional = ModifierExtensionsKt.conditional(boxScope.matchParentSize(Modifier.INSTANCE), blurredBackgroundImage && z, new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PaywallBackgroundKt$PaywallBackground$modifier$1
                @Override // kotlin.jvm.functions.Function1
                public final Modifier invoke(Modifier conditional) {
                    Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                    return BlurKt.m5847blurF8QBwvs(conditional, BackgroundUIConstants.INSTANCE.m10617getBlurSizeD9Ej5fM(), BlurredEdgeTreatment.INSTANCE.m5857getUnboundedGoahg());
                }
            });
            if (Intrinsics.areEqual(templateConfiguration.getConfiguration().getImages().getBackground(), PaywallDataExtensionsKt.getDefaultBackgroundPlaceholder(PaywallData.INSTANCE))) {
                composerStartRestartGroup.startReplaceGroup(733877144);
                ComposerKt.sourceInformation(composerStartRestartGroup, "44@2023L267");
                RemoteImageKt.LocalImage(R.drawable.default_background, modifierConditional, BackgroundUIConstants.INSTANCE.getContentScale(), null, blurTransformation, f, null, composerStartRestartGroup, 384, 72);
                composerStartRestartGroup.endReplaceGroup();
            } else if (templateConfiguration.getImages().getBackgroundUri() != null) {
                composerStartRestartGroup.startReplaceGroup(734225770);
                ComposerKt.sourceInformation(composerStartRestartGroup, "54@2514L317");
                if (blurredBackgroundImage || PaywallModeKt.isFullScreen(templateConfiguration.getMode())) {
                    String string = templateConfiguration.getImages().getBackgroundUri().toString();
                    Intrinsics.checkNotNullExpressionValue(string, "templateConfiguration.im….backgroundUri.toString()");
                    RemoteImageKt.RemoteImage(string, modifierConditional, null, BackgroundUIConstants.INSTANCE.getContentScale(), null, blurTransformation, f, null, composerStartRestartGroup, 3072, 148);
                    composerStartRestartGroup = composerStartRestartGroup;
                }
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(734695699);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PaywallBackgroundKt.PaywallBackground.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    PaywallBackgroundKt.PaywallBackground(boxScope, templateConfiguration, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: renamed from: toFloatPx-8Feqmps, reason: not valid java name */
    private static final float m10654toFloatPx8Feqmps(float f, Composer composer, int i) {
        composer.startReplaceGroup(452796480);
        ComposerKt.sourceInformation(composer, "C(toFloatPx)74@3116L7:PaywallBackground.kt#51odh9");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(452796480, i, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.toFloatPx (PaywallBackground.kt:73)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        float density = f * ((Density) objConsume).getDensity();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return density;
    }
}
