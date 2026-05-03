package com.revenuecat.purchases.ui.revenuecatui.customercenter.views;

import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterConstants;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PurchaseInformation;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PurchaseStatusBadge.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001a\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u001d\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"PurchaseStatusBadge", "", "purchaseInformation", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PurchaseInformation;", "localization", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;", "(Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/data/PurchaseInformation;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;Landroidx/compose/runtime/Composer;I)V", "determinePurchaseStatus", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/views/PurchaseStatus;", "getBadgeInfo", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/views/BadgeInfo;", "status", "(Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/views/PurchaseStatus;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;Landroidx/compose/runtime/Composer;I)Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/views/BadgeInfo;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PurchaseStatusBadgeKt {
    public static final void PurchaseStatusBadge(final PurchaseInformation purchaseInformation, final CustomerCenterConfigData.Localization localization, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(purchaseInformation, "purchaseInformation");
        Intrinsics.checkNotNullParameter(localization, "localization");
        Composer composerStartRestartGroup = composer.startRestartGroup(256749794);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PurchaseStatusBadge)P(1)23@1035L34,33@1325L423,29@1158L590:PurchaseStatusBadge.kt#870w7w");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(purchaseInformation) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(localization) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(256749794, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PurchaseStatusBadge (PurchaseStatusBadge.kt:21)");
            }
            final BadgeInfo badgeInfo = getBadgeInfo(determinePurchaseStatus(purchaseInformation), localization, composerStartRestartGroup, i2 & 112);
            if (badgeInfo.getText() == null || badgeInfo.m10723getColorQN2ZGVo() == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PurchaseStatusBadgeKt.PurchaseStatusBadge.1
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
                            PurchaseStatusBadgeKt.PurchaseStatusBadge(purchaseInformation, localization, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                        }
                    });
                    return;
                }
                return;
            }
            SurfaceKt.m4145SurfaceT9BRK9s(null, RoundedCornerShapeKt.m2345RoundedCornerShape0680j_4(CustomerCenterConstants.Card.INSTANCE.m10688getBADGE_CORNER_SIZED9Ej5fM()), badgeInfo.m10723getColorQN2ZGVo().m6335unboximpl(), 0L, 0.0f, 0.0f, badgeInfo.getBorder(), ComposableLambdaKt.rememberComposableLambda(1077364541, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PurchaseStatusBadgeKt.PurchaseStatusBadge.2
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ComposerKt.sourceInformation(composer2, "C36@1410L10,34@1335L407:PurchaseStatusBadge.kt#870w7w");
                    if ((i3 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1077364541, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PurchaseStatusBadge.<anonymous> (PurchaseStatusBadge.kt:34)");
                    }
                    String text = badgeInfo.getText();
                    TextStyle labelLarge = MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getLabelLarge();
                    Color colorM10724getTextColorQN2ZGVo = badgeInfo.m10724getTextColorQN2ZGVo();
                    composer2.startReplaceGroup(2012735351);
                    ComposerKt.sourceInformation(composer2, "37@1490L11");
                    long onSurface = colorM10724getTextColorQN2ZGVo == null ? MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurface() : colorM10724getTextColorQN2ZGVo.m6335unboximpl();
                    composer2.endReplaceGroup();
                    TextKt.m4286Text4IGK_g(text, PaddingKt.m2038paddingVpY3zN4(Modifier.INSTANCE, CustomerCenterConstants.Card.INSTANCE.m10689getBADGE_HORIZONTAL_PADDINGD9Ej5fM(), CustomerCenterConstants.Card.INSTANCE.m10690getBADGE_VERTICAL_PADDINGD9Ej5fM()), onSurface, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, labelLarge, composer2, 48, 0, 65528);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 12582912, 57);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PurchaseStatusBadgeKt.PurchaseStatusBadge.3
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
                    PurchaseStatusBadgeKt.PurchaseStatusBadge(purchaseInformation, localization, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final PurchaseStatus determinePurchaseStatus(PurchaseInformation purchaseInformation) {
        return purchaseInformation.isExpired() ? PurchaseStatus.EXPIRED : (purchaseInformation.isCancelled() && purchaseInformation.isTrial()) ? PurchaseStatus.FREE_TRIAL_CANCELLED : (!purchaseInformation.isCancelled() || purchaseInformation.getStore() == Store.PROMOTIONAL) ? purchaseInformation.isTrial() ? PurchaseStatus.FREE_TRIAL : purchaseInformation.isLifetime() ? PurchaseStatus.LIFETIME : purchaseInformation.getExpirationOrRenewal() != null ? PurchaseStatus.ACTIVE : PurchaseStatus.NONE : PurchaseStatus.CANCELLED;
    }

    private static final BadgeInfo getBadgeInfo(PurchaseStatus purchaseStatus, CustomerCenterConfigData.Localization localization, Composer composer, int i) {
        BadgeInfo badgeInfo;
        BadgeInfo badgeInfo2;
        composer.startReplaceGroup(806722768);
        ComposerKt.sourceInformation(composer, "C(getBadgeInfo)P(1)90@3611L11:PurchaseStatusBadge.kt#870w7w");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(806722768, i, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.getBadgeInfo (PurchaseStatusBadge.kt:57)");
        }
        if (purchaseStatus == PurchaseStatus.EXPIRED) {
            badgeInfo = new BadgeInfo(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.EXPIRED), Color.m6315boximpl(ColorKt.Color(CustomerCenterConstants.Card.COLOR_BADGE_EXPIRED)), null, null, 12, null);
        } else {
            if (purchaseStatus == PurchaseStatus.FREE_TRIAL_CANCELLED) {
                badgeInfo2 = new BadgeInfo(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.BADGE_FREE_TRIAL_CANCELLED), Color.m6315boximpl(ColorKt.Color(CustomerCenterConstants.Card.COLOR_BADGE_CANCELLED)), null, null, 12, null);
            } else if (purchaseStatus == PurchaseStatus.CANCELLED) {
                badgeInfo2 = new BadgeInfo(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.BADGE_CANCELLED), Color.m6315boximpl(ColorKt.Color(CustomerCenterConstants.Card.COLOR_BADGE_CANCELLED)), null, null, 12, null);
            } else if (purchaseStatus == PurchaseStatus.FREE_TRIAL) {
                badgeInfo = new BadgeInfo(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.BADGE_FREE_TRIAL), Color.m6315boximpl(ColorKt.Color(CustomerCenterConstants.Card.COLOR_BADGE_FREE_TRIAL)), null, null, 12, null);
            } else if (purchaseStatus == PurchaseStatus.LIFETIME) {
                badgeInfo = new BadgeInfo(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.BADGE_LIFETIME), Color.m6315boximpl(Color.INSTANCE.m6360getTransparent0d7_KjU()), BorderStrokeKt.m1509BorderStrokecXLIe8U(Dp.m9114constructorimpl(1.0f), Color.m6324copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurface(), 0.29f, 0.0f, 0.0f, 0.0f, 14, null)), null, 8, null);
            } else if (purchaseStatus == PurchaseStatus.ACTIVE) {
                badgeInfo = new BadgeInfo(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.ACTIVE), Color.m6315boximpl(ColorKt.Color(CustomerCenterConstants.Card.COLOR_BADGE_ACTIVE)), null, null, 12, null);
            } else {
                if (purchaseStatus != PurchaseStatus.NONE) {
                    throw new NoWhenBranchMatchedException();
                }
                badgeInfo = new BadgeInfo(null, null, null, null, 12, null);
            }
            badgeInfo = badgeInfo2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return badgeInfo;
    }
}
