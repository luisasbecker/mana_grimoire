package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import com.facebook.internal.AnalyticsEvents;
import com.revenuecat.purchases.ui.revenuecatui.UIConstant;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferEligibility;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IntroEligibilityStateView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0003\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0004\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001ax\u0010\u0006\u001a\u00020\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a.\u0010\u001b\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"IntroEligibilityPreviewBothTextsEligibleMultipleOffers", "", "(Landroidx/compose/runtime/Composer;I)V", "IntroEligibilityPreviewBothTextsEligibleSingleOffer", "IntroEligibilityPreviewBothTextsIneligible", "IntroEligibilityPreviewNoOffer", "IntroEligibilityStateView", "textWithNoIntroOffer", "", "textWithIntroOffer", "textWithMultipleIntroOffers", "eligibility", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "color", "Landroidx/compose/ui/graphics/Color;", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Landroidx/compose/ui/text/TextStyle;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "allowLinks", "", "modifier", "Landroidx/compose/ui/Modifier;", "IntroEligibilityStateView-QETHhvg", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;JLandroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/style/TextAlign;ZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "introEligibilityText", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class IntroEligibilityStateViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void IntroEligibilityPreviewBothTextsEligibleMultipleOffers(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-420223294);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(IntroEligibilityPreviewBothTextsEligibleMultipleOffers)153@5389L343:IntroEligibilityStateView.kt#51odh9");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-420223294, i, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.IntroEligibilityPreviewBothTextsEligibleMultipleOffers (IntroEligibilityStateView.kt:152)");
            }
            m10633IntroEligibilityStateViewQETHhvg("$3.99/mo", "7 day trial, then $3.99/mo", "7 days for free, then $1.99 for your first month, and just $4.99/mo thereafter.", OfferEligibility.IntroOfferMultiple.INSTANCE, Color.INSTANCE.m6351getBlack0d7_KjU(), null, null, null, false, null, composerStartRestartGroup, 28086, 992);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.IntroEligibilityStateViewKt.IntroEligibilityPreviewBothTextsEligibleMultipleOffers.1
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
                    IntroEligibilityStateViewKt.IntroEligibilityPreviewBothTextsEligibleMultipleOffers(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void IntroEligibilityPreviewBothTextsEligibleSingleOffer(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1448735195);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(IntroEligibilityPreviewBothTextsEligibleSingleOffer)141@4925L341:IntroEligibilityStateView.kt#51odh9");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1448735195, i, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.IntroEligibilityPreviewBothTextsEligibleSingleOffer (IntroEligibilityStateView.kt:140)");
            }
            m10633IntroEligibilityStateViewQETHhvg("$3.99/mo", "7 day trial, then $3.99/mo", "7 days for free, then $1.99 for your first month, and just $3.99/mo thereafter.", OfferEligibility.IntroOfferSingle.INSTANCE, Color.INSTANCE.m6351getBlack0d7_KjU(), null, null, null, false, null, composerStartRestartGroup, 28086, 992);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.IntroEligibilityStateViewKt.IntroEligibilityPreviewBothTextsEligibleSingleOffer.1
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
                    IntroEligibilityStateViewKt.IntroEligibilityPreviewBothTextsEligibleSingleOffer(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void IntroEligibilityPreviewBothTextsIneligible(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(170689540);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(IntroEligibilityPreviewBothTextsIneligible)129@4470L335:IntroEligibilityStateView.kt#51odh9");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(170689540, i, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.IntroEligibilityPreviewBothTextsIneligible (IntroEligibilityStateView.kt:128)");
            }
            m10633IntroEligibilityStateViewQETHhvg("$3.99/mo", "7 day trial, then $3.99/mo", "7 days for free, then $1.99 for your first month, and just $4.99/mo thereafter.", OfferEligibility.Ineligible.INSTANCE, Color.INSTANCE.m6351getBlack0d7_KjU(), null, null, null, false, null, composerStartRestartGroup, 28086, 992);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.IntroEligibilityStateViewKt.IntroEligibilityPreviewBothTextsIneligible.1
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
                    IntroEligibilityStateViewKt.IntroEligibilityPreviewBothTextsIneligible(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void IntroEligibilityPreviewNoOffer(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-255198870);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(IntroEligibilityPreviewNoOffer)117@4119L240:IntroEligibilityStateView.kt#51odh9");
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-255198870, i, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.IntroEligibilityPreviewNoOffer (IntroEligibilityStateView.kt:116)");
            }
            m10633IntroEligibilityStateViewQETHhvg("$3.99/mo", null, null, OfferEligibility.IntroOfferSingle.INSTANCE, Color.INSTANCE.m6351getBlack0d7_KjU(), null, null, null, false, null, composerStartRestartGroup, 28086, 992);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.IntroEligibilityStateViewKt.IntroEligibilityPreviewNoOffer.1
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
                    IntroEligibilityStateViewKt.IntroEligibilityPreviewNoOffer(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:155:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0116  */
    /* JADX INFO: renamed from: IntroEligibilityStateView-QETHhvg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m10633IntroEligibilityStateViewQETHhvg(final String str, final String str2, final String str3, final OfferEligibility eligibility, long j, TextStyle textStyle, FontWeight fontWeight, TextAlign textAlign, boolean z, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        long j2;
        TextStyle textStyle2;
        int i4;
        FontWeight fontWeight2;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        long jM6361getUnspecified0d7_KjU;
        int i10;
        TextAlign textAlign2;
        boolean z2;
        Modifier.Companion companion;
        final TextAlign textAlign3;
        final long j3;
        Composer composer2;
        final long j4;
        final TextStyle textStyle3;
        final TextAlign textAlign4;
        final boolean z3;
        final Modifier modifier2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(eligibility, "eligibility");
        Composer composerStartRestartGroup = composer.startRestartGroup(-465085850);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(IntroEligibilityStateView)P(9,7,8,2,1:c#ui.graphics.Color,5,3,6:c#ui.text.style.TextAlign)39@1386L330,30@1082L634:IntroEligibilityStateView.kt#51odh9");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(str2) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(str3) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(eligibility) ? 2048 : 1024;
        }
        int i11 = i2 & 16;
        if (i11 != 0) {
            i3 |= 24576;
        } else {
            if ((i & 24576) == 0) {
                j2 = j;
                i3 |= composerStartRestartGroup.changed(j2) ? 16384 : 8192;
            }
            if ((196608 & i) != 0) {
                if ((i2 & 32) == 0) {
                    textStyle2 = textStyle;
                    int i12 = composerStartRestartGroup.changed(textStyle2) ? 131072 : 65536;
                    i3 |= i12;
                } else {
                    textStyle2 = textStyle;
                }
                i3 |= i12;
            } else {
                textStyle2 = textStyle;
            }
            i4 = i2 & 64;
            if (i4 == 0) {
                i3 |= 1572864;
            } else {
                if ((1572864 & i) == 0) {
                    fontWeight2 = fontWeight;
                    i3 |= composerStartRestartGroup.changed(fontWeight2) ? 1048576 : 524288;
                }
                i5 = i2 & 128;
                if (i5 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    i3 |= composerStartRestartGroup.changed(textAlign) ? 8388608 : 4194304;
                }
                i6 = i2 & 256;
                if (i6 != 0) {
                    i3 |= 100663296;
                } else {
                    if ((i & 100663296) == 0) {
                        i7 = i6;
                        i3 |= composerStartRestartGroup.changed(z) ? 67108864 : 33554432;
                    }
                    i8 = i2 & 512;
                    if (i8 != 0) {
                        if ((i & 805306368) == 0) {
                            i9 = i8;
                            i3 |= composerStartRestartGroup.changed(modifier) ? 536870912 : 268435456;
                        }
                        int i13 = i3;
                        if ((i3 & 306783379) == 306783378 && composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                            composer2 = composerStartRestartGroup;
                            j4 = j2;
                            textStyle3 = textStyle2;
                            textAlign4 = textAlign;
                            z3 = z;
                        } else {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "24@928L7");
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                jM6361getUnspecified0d7_KjU = i11 == 0 ? Color.INSTANCE.m6361getUnspecified0d7_KjU() : j2;
                                if ((i2 & 32) == 0) {
                                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    Object objConsume = composerStartRestartGroup.consume(localTextStyle);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    i10 = i13 & (-458753);
                                    textStyle2 = (TextStyle) objConsume;
                                } else {
                                    i10 = i13;
                                }
                                if (i4 != 0) {
                                    fontWeight2 = null;
                                }
                                textAlign2 = i5 == 0 ? textAlign : null;
                                z2 = i7 == 0 ? true : z;
                                companion = i9 == 0 ? Modifier.INSTANCE : modifier;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 32) != 0) {
                                    z2 = z;
                                    companion = modifier;
                                    jM6361getUnspecified0d7_KjU = j2;
                                    i10 = i13 & (-458753);
                                    textAlign2 = textAlign;
                                } else {
                                    textAlign2 = textAlign;
                                    z2 = z;
                                    companion = modifier;
                                    jM6361getUnspecified0d7_KjU = j2;
                                    i10 = i13;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                textAlign3 = textAlign2;
                                j3 = jM6361getUnspecified0d7_KjU;
                            } else {
                                textAlign3 = textAlign2;
                                j3 = jM6361getUnspecified0d7_KjU;
                                ComposerKt.traceEventStart(-465085850, i10, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.IntroEligibilityStateView (IntroEligibilityStateView.kt:29)");
                            }
                            final TextStyle textStyle4 = textStyle2;
                            final boolean z4 = z2;
                            final FontWeight fontWeight3 = fontWeight2;
                            final Modifier modifier3 = companion;
                            long j5 = j3;
                            TextAlign textAlign5 = textAlign3;
                            CrossfadeKt.Crossfade(introEligibilityText(eligibility, str2, str3, str), (Modifier) null, UIConstant.INSTANCE.defaultAnimation(), "IntroEligibilityStateView", ComposableLambdaKt.rememberComposableLambda(-88431708, true, new Function3<String, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.IntroEligibilityStateViewKt$IntroEligibilityStateView$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(String str4, Composer composer3, Integer num) {
                                    invoke(str4, composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(String it, Composer composer3, int i14) {
                                    int i15;
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    ComposerKt.sourceInformation(composer3, "C40@1396L314:IntroEligibilityStateView.kt#51odh9");
                                    if ((i14 & 6) == 0) {
                                        i15 = i14 | (composer3.changed(it) ? 4 : 2);
                                    } else {
                                        i15 = i14;
                                    }
                                    if ((i15 & 19) == 18 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-88431708, i15, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.IntroEligibilityStateView.<anonymous> (IntroEligibilityStateView.kt:40)");
                                    }
                                    MarkdownKt.m10642MarkdownDkhmgE0(it, modifier3, j3, textStyle4, 0L, fontWeight3, null, null, textAlign3, z4, true, false, composer3, i15 & 14, 54, 208);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, 27648, 2);
                            composer2 = composerStartRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            j4 = j5;
                            textStyle3 = textStyle2;
                            textAlign4 = textAlign5;
                            z3 = z4;
                            modifier2 = modifier3;
                        }
                        final FontWeight fontWeight4 = fontWeight2;
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.IntroEligibilityStateViewKt$IntroEligibilityStateView$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i14) {
                                    IntroEligibilityStateViewKt.m10633IntroEligibilityStateViewQETHhvg(str, str2, str3, eligibility, j4, textStyle3, fontWeight4, textAlign4, z3, modifier2, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i3 |= 805306368;
                    i9 = i8;
                    int i132 = i3;
                    if ((i3 & 306783379) == 306783378) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "24@928L7");
                        if ((i & 1) != 0) {
                            if (i11 == 0) {
                            }
                            if ((i2 & 32) == 0) {
                            }
                            if (i4 != 0) {
                            }
                            if (i5 == 0) {
                            }
                            if (i7 == 0) {
                            }
                            if (i9 == 0) {
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            final TextStyle textStyle42 = textStyle2;
                            final boolean z42 = z2;
                            final FontWeight fontWeight32 = fontWeight2;
                            final Modifier modifier32 = companion;
                            long j52 = j3;
                            TextAlign textAlign52 = textAlign3;
                            CrossfadeKt.Crossfade(introEligibilityText(eligibility, str2, str3, str), (Modifier) null, UIConstant.INSTANCE.defaultAnimation(), "IntroEligibilityStateView", ComposableLambdaKt.rememberComposableLambda(-88431708, true, new Function3<String, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.IntroEligibilityStateViewKt$IntroEligibilityStateView$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(String str4, Composer composer3, Integer num) {
                                    invoke(str4, composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(String it, Composer composer3, int i14) {
                                    int i15;
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    ComposerKt.sourceInformation(composer3, "C40@1396L314:IntroEligibilityStateView.kt#51odh9");
                                    if ((i14 & 6) == 0) {
                                        i15 = i14 | (composer3.changed(it) ? 4 : 2);
                                    } else {
                                        i15 = i14;
                                    }
                                    if ((i15 & 19) == 18 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-88431708, i15, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.IntroEligibilityStateView.<anonymous> (IntroEligibilityStateView.kt:40)");
                                    }
                                    MarkdownKt.m10642MarkdownDkhmgE0(it, modifier32, j3, textStyle42, 0L, fontWeight32, null, null, textAlign3, z42, true, false, composer3, i15 & 14, 54, 208);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, 27648, 2);
                            composer2 = composerStartRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            j4 = j52;
                            textStyle3 = textStyle2;
                            textAlign4 = textAlign52;
                            z3 = z42;
                            modifier2 = modifier32;
                        }
                    }
                    final FontWeight fontWeight42 = fontWeight2;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                i7 = i6;
                i8 = i2 & 512;
                if (i8 != 0) {
                }
                i9 = i8;
                int i1322 = i3;
                if ((i3 & 306783379) == 306783378) {
                }
                final FontWeight fontWeight422 = fontWeight2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            fontWeight2 = fontWeight;
            i5 = i2 & 128;
            if (i5 != 0) {
            }
            i6 = i2 & 256;
            if (i6 != 0) {
            }
            i7 = i6;
            i8 = i2 & 512;
            if (i8 != 0) {
            }
            i9 = i8;
            int i13222 = i3;
            if ((i3 & 306783379) == 306783378) {
            }
            final FontWeight fontWeight4222 = fontWeight2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        j2 = j;
        if ((196608 & i) != 0) {
        }
        i4 = i2 & 64;
        if (i4 == 0) {
        }
        fontWeight2 = fontWeight;
        i5 = i2 & 128;
        if (i5 != 0) {
        }
        i6 = i2 & 256;
        if (i6 != 0) {
        }
        i7 = i6;
        i8 = i2 & 512;
        if (i8 != 0) {
        }
        i9 = i8;
        int i132222 = i3;
        if ((i3 & 306783379) == 306783378) {
        }
        final FontWeight fontWeight42222 = fontWeight2;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    public static final String introEligibilityText(OfferEligibility eligibility, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(eligibility, "eligibility");
        if (Intrinsics.areEqual(eligibility, OfferEligibility.IntroOfferSingle.INSTANCE) ? true : Intrinsics.areEqual(eligibility, OfferEligibility.PromoOfferSingle.INSTANCE)) {
            str2 = str;
        } else {
            if (!(Intrinsics.areEqual(eligibility, OfferEligibility.IntroOfferMultiple.INSTANCE) ? true : Intrinsics.areEqual(eligibility, OfferEligibility.PromoOfferMultiple.INSTANCE))) {
                if (!(Intrinsics.areEqual(eligibility, OfferEligibility.Ineligible.INSTANCE) ? true : Intrinsics.areEqual(eligibility, OfferEligibility.PromoOfferIneligible.INSTANCE))) {
                    throw new NoWhenBranchMatchedException();
                }
                str2 = str3;
            }
        }
        return str2 == null ? str3 == null ? str == null ? "" : str : str3 : str2;
    }
}
