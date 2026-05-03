package com.revenuecat.purchases.ui.revenuecatui.customercenter.theme;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.view.WindowCompat;
import androidx.media3.muxer.MuxerUtil;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomerCenterPreviewTheme.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0003\u001a\u00020\u00042\u0011\u0010\u0005\u001a\r\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\b\u0007H\u0001¢\u0006\u0002\u0010\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"DarkColorScheme", "Landroidx/compose/material3/ColorScheme;", "LightColorScheme", "CustomerCenterPreviewTheme", "", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CustomerCenterPreviewThemeKt {
    private static final ColorScheme LightColorScheme = ColorSchemeKt.m3487lightColorSchemeCXl9yA$default(ColorKt.Color(4279199743L), Color.INSTANCE.m6362getWhite0d7_KjU(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, ColorKt.Color(MuxerUtil.UNSIGNED_INT_MAX_VALUE), ColorKt.Color(4280229663L), ColorKt.Color(4293981433L), ColorKt.Color(4280229663L), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -122884, 15, null);
    private static final ColorScheme DarkColorScheme = ColorSchemeKt.m3481darkColorSchemeCXl9yA$default(ColorKt.Color(4286695300L), Color.INSTANCE.m6351getBlack0d7_KjU(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, ColorKt.Color(4279374354L), ColorKt.Color(4292927712L), ColorKt.Color(4280953386L), ColorKt.Color(4292927712L), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -122884, 15, null);

    public static final void CustomerCenterPreviewTheme(Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i) {
        int i2;
        final Function2<? super Composer, ? super Integer, Unit> function2;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(482903071);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CustomerCenterPreviewTheme)37@1209L21,40@1334L7,48@1575L82:CustomerCenterPreviewTheme.kt#85wnsn");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(content) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            function2 = content;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(482903071, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.theme.CustomerCenterPreviewTheme (CustomerCenterPreviewTheme.kt:36)");
            }
            final boolean zIsSystemInDarkTheme = DarkThemeKt.isSystemInDarkTheme(composerStartRestartGroup, 0);
            ColorScheme colorScheme = zIsSystemInDarkTheme ? DarkColorScheme : LightColorScheme;
            ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localView);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final View view = (View) objConsume;
            composerStartRestartGroup.startReplaceGroup(-1492930134);
            ComposerKt.sourceInformation(composerStartRestartGroup, "42@1391L172,42@1380L183");
            if (!view.isInEditMode()) {
                composerStartRestartGroup.startReplaceGroup(-1492928745);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CustomerCenterPreviewTheme.kt#9igjgp");
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(view) | composerStartRestartGroup.changed(zIsSystemInDarkTheme);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.theme.CustomerCenterPreviewThemeKt$CustomerCenterPreviewTheme$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            Context context = view.getContext();
                            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                            WindowCompat.getInsetsController(((Activity) context).getWindow(), view).setAppearanceLightStatusBars(!zIsSystemInDarkTheme);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceGroup();
                EffectsKt.SideEffect((Function0) objRememberedValue, composerStartRestartGroup, 0);
            }
            composerStartRestartGroup.endReplaceGroup();
            function2 = content;
            MaterialThemeKt.MaterialTheme(colorScheme, null, null, function2, composerStartRestartGroup, (i2 << 9) & 7168, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.theme.CustomerCenterPreviewThemeKt.CustomerCenterPreviewTheme.2
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
                    CustomerCenterPreviewThemeKt.CustomerCenterPreviewTheme(function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
