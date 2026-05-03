package com.revenuecat.purchases.ui.revenuecatui.components.tabs;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.tooling.preview.PreviewParameter;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.revenuecat.purchases.paywalls.components.properties.ColorInfo;
import com.revenuecat.purchases.ui.revenuecatui.components.PreviewHelpersKt;
import com.revenuecat.purchases.ui.revenuecatui.components.modifier.SizeKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.style.TabControlToggleComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.composables.SwitchDefaults;
import com.revenuecat.purchases.ui.revenuecatui.composables.SwitchKt;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TabControlToggleView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b\u001a\r\u0010\t\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\n\u001a\u0017\u0010\u000b\u001a\u00020\u00012\b\b\u0001\u0010\f\u001a\u00020\rH\u0003¢\u0006\u0002\u0010\u000e¨\u0006\u000f²\u0006\n\u0010\f\u001a\u00020\rX\u008a\u0084\u0002"}, d2 = {"TabControlToggleView", "", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabControlToggleComponentStyle;", ServerProtocol.DIALOG_PARAM_STATE, "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabControlToggleComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "TabControlToggleView_Gradient_Preview", "(Landroidx/compose/runtime/Composer;I)V", "TabControlToggleView_Preview", "checked", "", "(ZLandroidx/compose/runtime/Composer;I)V", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class TabControlToggleViewKt {
    /* JADX WARN: Removed duplicated region for block: B:40:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TabControlToggleView(final TabControlToggleComponentStyle style, final PaywallState.Loaded.Components state, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        Object objRememberedValue;
        boolean z;
        Object objRememberedValue2;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(state, "state");
        Composer composerStartRestartGroup = composer.startRestartGroup(329554554);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TabControlToggleView)P(2,1)33@1650L58,37@1775L53,42@2062L15,43@2130L15,44@2201L15,45@2272L15,40@1921L377,35@1714L591:TabControlToggleView.kt#fyu6fh");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(style) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(state) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i3 & 147) == 146 || !composerStartRestartGroup.getSkipping()) {
                Modifier modifier4 = i4 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(329554554, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabControlToggleView (TabControlToggleView.kt:32)");
                }
                composerStartRestartGroup.startReplaceGroup(251497884);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):TabControlToggleView.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabControlToggleViewKt$TabControlToggleView$checked$2$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            return Boolean.valueOf(state.getSelectedTabIndex() > 0);
                        }
                    });
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceGroup();
                boolean zTabControlToggleView$lambda$1 = TabControlToggleView$lambda$1((State) objRememberedValue);
                composerStartRestartGroup.startReplaceGroup(251501879);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):TabControlToggleView.kt#9igjgp");
                z = (i3 & 112) != 32;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = (Function1) new Function1<Boolean, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabControlToggleViewKt$TabControlToggleView$1$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z2) {
                            PaywallState.Loaded.Components.update$default(state, null, Integer.valueOf(z2 ? 1 : 0), null, 5, null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifier5 = modifier4;
                composer2 = composerStartRestartGroup;
                SwitchKt.Switch(zTabControlToggleView$lambda$1, (Function1) objRememberedValue2, SizeKt.size$default(modifier4, style.getSize(), null, null, 6, null), null, false, SwitchDefaults.INSTANCE.m10670colorslRJcREg(ColorStyleKt.getForCurrentTheme(style.getThumbColorOn(), composerStartRestartGroup, 0), ColorStyleKt.getForCurrentTheme(style.getTrackColorOn(), composerStartRestartGroup, 0), null, 0L, ColorStyleKt.getForCurrentTheme(style.getThumbColorOff(), composerStartRestartGroup, 0), ColorStyleKt.getForCurrentTheme(style.getTrackColorOff(), composerStartRestartGroup, 0), null, 0L, null, null, null, 0L, null, null, null, 0L, composer2, 0, 1572864, 65484), null, composer2, 0, 88);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                composer2 = composerStartRestartGroup;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabControlToggleViewKt.TabControlToggleView.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i5) {
                        TabControlToggleViewKt.TabControlToggleView(style, state, modifier3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i3 & 147) == 146) {
            if (i4 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            composerStartRestartGroup.startReplaceGroup(251497884);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):TabControlToggleView.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            composerStartRestartGroup.endReplaceGroup();
            boolean zTabControlToggleView$lambda$12 = TabControlToggleView$lambda$1((State) objRememberedValue);
            composerStartRestartGroup.startReplaceGroup(251501879);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):TabControlToggleView.kt#9igjgp");
            if ((i3 & 112) != 32) {
            }
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!z) {
                objRememberedValue2 = (Function1) new Function1<Boolean, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabControlToggleViewKt$TabControlToggleView$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z2) {
                        PaywallState.Loaded.Components.update$default(state, null, Integer.valueOf(z2 ? 1 : 0), null, 5, null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifier52 = modifier4;
                composer2 = composerStartRestartGroup;
                SwitchKt.Switch(zTabControlToggleView$lambda$12, (Function1) objRememberedValue2, SizeKt.size$default(modifier4, style.getSize(), null, null, 6, null), null, false, SwitchDefaults.INSTANCE.m10670colorslRJcREg(ColorStyleKt.getForCurrentTheme(style.getThumbColorOn(), composerStartRestartGroup, 0), ColorStyleKt.getForCurrentTheme(style.getTrackColorOn(), composerStartRestartGroup, 0), null, 0L, ColorStyleKt.getForCurrentTheme(style.getThumbColorOff(), composerStartRestartGroup, 0), ColorStyleKt.getForCurrentTheme(style.getTrackColorOff(), composerStartRestartGroup, 0), null, 0L, null, null, null, 0L, null, null, null, 0L, composer2, 0, 1572864, 65484), null, composer2, 0, 88);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier52;
            }
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    private static final boolean TabControlToggleView$lambda$1(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TabControlToggleView_Gradient_Preview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-813499163);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TabControlToggleView_Gradient_Preview)127@4966L19,102@4077L915:TabControlToggleView.kt#fyu6fh");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-813499163, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabControlToggleView_Gradient_Preview (TabControlToggleView.kt:86)");
            }
            List listListOf = CollectionsKt.listOf((Object[]) new ColorInfo.Gradient.Point[]{new ColorInfo.Gradient.Point(ColorKt.m6379toArgb8_81llA(Color.INSTANCE.m6359getRed0d7_KjU()), 0.0f), new ColorInfo.Gradient.Point(ColorKt.m6379toArgb8_81llA(Color.INSTANCE.m6356getGreen0d7_KjU()), 35.0f), new ColorInfo.Gradient.Point(ColorKt.m6379toArgb8_81llA(Color.INSTANCE.m6352getBlue0d7_KjU()), 100.0f)});
            TabControlToggleView(new TabControlToggleComponentStyle(new ColorStyles(ColorStyleKt.toColorStyle(new ColorInfo.Gradient.Radial(listListOf)), null, 2, null), new ColorStyles(ColorStyleKt.toColorStyle(new ColorInfo.Gradient.Radial(listListOf)), null, 2, null), new ColorStyles(ColorStyleKt.toColorStyle(new ColorInfo.Gradient.Linear(90.0f, listListOf)), null, 2, null), new ColorStyles(ColorStyleKt.toColorStyle(new ColorInfo.Gradient.Linear(90.0f, listListOf)), null, 2, null)), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), null, composerStartRestartGroup, 0, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabControlToggleViewKt.TabControlToggleView_Gradient_Preview.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    TabControlToggleViewKt.TabControlToggleView_Gradient_Preview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TabControlToggleView_Preview(@PreviewParameter(provider = CheckedPreviewProvider.class) final boolean z, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(259221708);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TabControlToggleView_Preview)80@3553L60,61@2738L882:TabControlToggleView.kt#fyu6fh");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(259221708, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabControlToggleView_Preview (TabControlToggleView.kt:59)");
            }
            TabControlToggleView(new TabControlToggleComponentStyle(new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6359getRed0d7_KjU())), ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6352getBlue0d7_KjU()))), new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6352getBlue0d7_KjU())), ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6359getRed0d7_KjU()))), new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6363getYellow0d7_KjU())), ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6356getGreen0d7_KjU()))), new ColorStyles(ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6356getGreen0d7_KjU())), ColorStyle.Solid.m10531boximpl(ColorStyle.Solid.m10532constructorimpl(Color.INSTANCE.m6363getYellow0d7_KjU())))), PreviewHelpersKt.previewEmptyState(Integer.valueOf(z ? 1 : 0), composerStartRestartGroup, 0, 0), null, composerStartRestartGroup, 0, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabControlToggleViewKt.TabControlToggleView_Preview.1
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
                    TabControlToggleViewKt.TabControlToggleView_Preview(z, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
