package com.revenuecat.purchases.ui.revenuecatui.customercenter.composables;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.facebook.appevents.internal.Constants;
import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SettingsButton.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0003ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a?\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0001¢\u0006\u0002\u0010\u0013\u001a\r\u0010\u0014\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0015\u001a\r\u0010\u0016\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0015\u001a\r\u0010\u0017\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0015\u001a\r\u0010\u0018\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0015\u001a\r\u0010\u0019\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0015\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, d2 = {"ButtonContent", "", Constants.GP_IAP_TITLE, "", "loading", "", "loadingColor", "Landroidx/compose/ui/graphics/Color;", "ButtonContent-XO-JAsU", "(Ljava/lang/String;ZJLandroidx/compose/runtime/Composer;I)V", "SettingsButton", "onClick", "Lkotlin/Function0;", "config", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/composables/SettingsButtonConfig;", "modifier", "Landroidx/compose/ui/Modifier;", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/composables/SettingsButtonStyle;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/composables/SettingsButtonConfig;Landroidx/compose/ui/Modifier;Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/composables/SettingsButtonStyle;Landroidx/compose/runtime/Composer;II)V", "SettingsButtonDisabled_Preview", "(Landroidx/compose/runtime/Composer;I)V", "SettingsButtonLoading_Preview", "SettingsButtonOutlinedLoading_Preview", "SettingsButtonOutlined_Preview", "SettingsButton_Preview", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class SettingsButtonKt {

    /* JADX INFO: compiled from: SettingsButton.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SettingsButtonStyle.values().length];
            try {
                iArr[SettingsButtonStyle.FILLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SettingsButtonStyle.OUTLINED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: ButtonContent-XO-JAsU, reason: not valid java name */
    public static final void m10715ButtonContentXOJAsU(final String str, final boolean z, final long j, Composer composer, final int i) {
        String str2;
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(483726370);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ButtonContent)P(2!,1:c#ui.graphics.Color):SettingsButton.kt#4bm52s");
        if ((i & 6) == 0) {
            str2 = str;
            i2 = (composerStartRestartGroup.changed(str2) ? 4 : 2) | i;
        } else {
            str2 = str;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(483726370, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.ButtonContent (SettingsButton.kt:85)");
            }
            if (z) {
                composerStartRestartGroup.startReplaceGroup(-945467054);
                ComposerKt.sourceInformation(composerStartRestartGroup, "87@2928L147");
                ProgressIndicatorKt.m3947CircularProgressIndicatorLxG7B9w(SizeKt.m2083size3ABfNKs(Modifier.INSTANCE, Dp.m9114constructorimpl(20.0f)), j, Dp.m9114constructorimpl(2.0f), 0L, 0, composerStartRestartGroup, ((i2 >> 3) & 112) | 390, 24);
                composerStartRestartGroup.endReplaceGroup();
                composer2 = composerStartRestartGroup;
            } else {
                composerStartRestartGroup.startReplaceGroup(-945298848);
                ComposerKt.sourceInformation(composerStartRestartGroup, "95@3163L10,93@3097L165");
                composer2 = composerStartRestartGroup;
                TextKt.m4286Text4IGK_g(str2, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.m8569copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyLarge(), 0L, 0L, FontWeight.INSTANCE.getMedium(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), composer2, i2 & 14, 0, 65534);
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonKt$ButtonContent$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i3) {
                    SettingsButtonKt.m10715ButtonContentXOJAsU(str, z, j, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void SettingsButton(final String title, final Function0 onClick, final SettingsButtonConfig config, Modifier modifier, SettingsButtonStyle settingsButtonStyle, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        SettingsButtonStyle settingsButtonStyle2;
        int i5;
        Modifier modifier3;
        final SettingsButtonStyle settingsButtonStyle3;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(config, "config");
        Composer composerStartRestartGroup = composer.startRestartGroup(1826003105);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SettingsButton)P(4,2):SettingsButton.kt#4bm52s");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(title) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(config) ? 256 : 128;
        }
        int i6 = i2 & 8;
        if (i6 != 0) {
            i3 |= 3072;
        } else {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    settingsButtonStyle2 = settingsButtonStyle;
                    i3 |= composerStartRestartGroup.changed(settingsButtonStyle2) ? 16384 : 8192;
                }
                if ((i3 & 9363) == 9362 && composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier4 = modifier2;
                    settingsButtonStyle3 = settingsButtonStyle2;
                } else {
                    Modifier.Companion companion = i6 == 0 ? Modifier.INSTANCE : modifier2;
                    SettingsButtonStyle settingsButtonStyle4 = i4 == 0 ? SettingsButtonStyle.FILLED : settingsButtonStyle2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1826003105, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButton (SettingsButton.kt:33)");
                    }
                    RoundedCornerShape roundedCornerShapeM2345RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(Dp.m9114constructorimpl(24.0f));
                    Modifier modifierM2068defaultMinSizeVpY3zN4$default = SizeKt.m2068defaultMinSizeVpY3zN4$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), 0.0f, Dp.m9114constructorimpl(48.0f), 1, null);
                    i5 = WhenMappings.$EnumSwitchMapping$0[settingsButtonStyle4.ordinal()];
                    if (i5 != 1) {
                        modifier3 = companion;
                        composerStartRestartGroup.startReplaceGroup(-1545012110);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "46@1598L11,47@1668L11,45@1533L175,51@1840L217,41@1376L681");
                        ButtonKt.Button(onClick, modifierM2068defaultMinSizeVpY3zN4$default, config.getEnabled(), roundedCornerShapeM2345RoundedCornerShape0680j_4, ButtonDefaults.INSTANCE.m3340buttonColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnPrimary(), 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 12), null, null, ButtonDefaults.INSTANCE.getTextButtonContentPadding(), null, ComposableLambdaKt.rememberComposableLambda(1433762825, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonKt.SettingsButton.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                                invoke(rowScope, composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(RowScope Button, Composer composer2, int i7) {
                                Intrinsics.checkNotNullParameter(Button, "$this$Button");
                                ComposerKt.sourceInformation(composer2, "C55@2003L11,52@1858L185:SettingsButton.kt#4bm52s");
                                if ((i7 & 17) == 16 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1433762825, i7, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButton.<anonymous> (SettingsButton.kt:52)");
                                }
                                SettingsButtonKt.m10715ButtonContentXOJAsU(title, config.getLoading(), MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnPrimary(), composer2, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 3) & 14) | 805306368, 352);
                        composerStartRestartGroup.endReplaceGroup();
                    } else if (i5 != 2) {
                        composerStartRestartGroup.startReplaceGroup(-1543648141);
                        composerStartRestartGroup.endReplaceGroup();
                        modifier3 = companion;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1544273938);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "65@2358L11,64@2287L109,69@2528L215,60@2122L621");
                        modifier3 = companion;
                        ButtonKt.OutlinedButton(onClick, modifierM2068defaultMinSizeVpY3zN4$default, config.getEnabled(), roundedCornerShapeM2345RoundedCornerShape0680j_4, ButtonDefaults.INSTANCE.m3350outlinedButtonColorsro_MJ88(0L, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary(), 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 13), null, null, ButtonDefaults.INSTANCE.getTextButtonContentPadding(), null, ComposableLambdaKt.rememberComposableLambda(397195892, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonKt.SettingsButton.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                                invoke(rowScope, composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(RowScope OutlinedButton, Composer composer2, int i7) {
                                Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
                                ComposerKt.sourceInformation(composer2, "C73@2691L11,70@2546L183:SettingsButton.kt#4bm52s");
                                if ((i7 & 17) == 16 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(397195892, i7, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButton.<anonymous> (SettingsButton.kt:70)");
                                }
                                SettingsButtonKt.m10715ButtonContentXOJAsU(title, config.getLoading(), MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getPrimary(), composer2, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 3) & 14) | 805306368, 352);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    settingsButtonStyle3 = settingsButtonStyle4;
                    modifier4 = modifier3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonKt.SettingsButton.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i7) {
                            SettingsButtonKt.SettingsButton(title, onClick, config, modifier4, settingsButtonStyle3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= 24576;
            settingsButtonStyle2 = settingsButtonStyle;
            if ((i3 & 9363) == 9362) {
                if (i6 == 0) {
                }
                if (i4 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                RoundedCornerShape roundedCornerShapeM2345RoundedCornerShape0680j_42 = RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(Dp.m9114constructorimpl(24.0f));
                Modifier modifierM2068defaultMinSizeVpY3zN4$default2 = SizeKt.m2068defaultMinSizeVpY3zN4$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), 0.0f, Dp.m9114constructorimpl(48.0f), 1, null);
                i5 = WhenMappings.$EnumSwitchMapping$0[settingsButtonStyle4.ordinal()];
                if (i5 != 1) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                settingsButtonStyle3 = settingsButtonStyle4;
                modifier4 = modifier3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 16;
        if (i4 != 0) {
        }
        settingsButtonStyle2 = settingsButtonStyle;
        if ((i3 & 9363) == 9362) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SettingsButtonDisabled_Preview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1257236177);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SettingsButtonDisabled_Preview)148@4300L137:SettingsButton.kt#4bm52s");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1257236177, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonDisabled_Preview (SettingsButton.kt:147)");
            }
            SettingsButton("Restore purchases", new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonKt.SettingsButtonDisabled_Preview.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }, new SettingsButtonConfig(false, false, 2, null), null, null, composerStartRestartGroup, 54, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonKt.SettingsButtonDisabled_Preview.2
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
                    SettingsButtonKt.SettingsButtonDisabled_Preview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SettingsButtonLoading_Preview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1692829163);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SettingsButtonLoading_Preview)127@3823L136:SettingsButton.kt#4bm52s");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1692829163, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonLoading_Preview (SettingsButton.kt:126)");
            }
            SettingsButton("Restore purchases", new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonKt.SettingsButtonLoading_Preview.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }, new SettingsButtonConfig(false, true, 1, null), null, null, composerStartRestartGroup, 54, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonKt.SettingsButtonLoading_Preview.2
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
                    SettingsButtonKt.SettingsButtonLoading_Preview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SettingsButtonOutlinedLoading_Preview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-919118185);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SettingsButtonOutlinedLoading_Preview)137@4042L182:SettingsButton.kt#4bm52s");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-919118185, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonOutlinedLoading_Preview (SettingsButton.kt:136)");
            }
            SettingsButtonStyle settingsButtonStyle = SettingsButtonStyle.OUTLINED;
            SettingsButton("Restore purchases", new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonKt.SettingsButtonOutlinedLoading_Preview.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }, new SettingsButtonConfig(false, true, 1, null), null, settingsButtonStyle, composerStartRestartGroup, 24630, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonKt.SettingsButtonOutlinedLoading_Preview.2
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
                    SettingsButtonKt.SettingsButtonOutlinedLoading_Preview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SettingsButtonOutlined_Preview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1472127241);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SettingsButtonOutlined_Preview)116@3580L168:SettingsButton.kt#4bm52s");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1472127241, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonOutlined_Preview (SettingsButton.kt:115)");
            }
            SettingsButtonStyle settingsButtonStyle = SettingsButtonStyle.OUTLINED;
            SettingsButton("Restore purchases", new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonKt.SettingsButtonOutlined_Preview.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }, new SettingsButtonConfig(false, false, 3, null), null, settingsButtonStyle, composerStartRestartGroup, 24630, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonKt.SettingsButtonOutlined_Preview.2
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
                    SettingsButtonKt.SettingsButtonOutlined_Preview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SettingsButton_Preview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-745433269);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SettingsButton_Preview)105@3336L168:SettingsButton.kt#4bm52s");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-745433269, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButton_Preview (SettingsButton.kt:104)");
            }
            SettingsButtonStyle settingsButtonStyle = SettingsButtonStyle.FILLED;
            SettingsButton("Cancel subscription", new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonKt.SettingsButton_Preview.1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }
            }, new SettingsButtonConfig(false, false, 3, null), null, settingsButtonStyle, composerStartRestartGroup, 24630, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonKt.SettingsButton_Preview.2
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
                    SettingsButtonKt.SettingsButton_Preview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
