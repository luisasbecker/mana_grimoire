package com.revenuecat.purchases.ui.revenuecatui.customercenter.extensions;

import android.icu.text.MeasureFormat;
import android.icu.util.Measure;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.models.OfferPaymentMode;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.ui.revenuecatui.extensions.PeriodExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.extensions.PriceExtensionsKt;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SubscriptionOptionExtensions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0002\u001a\u001c\u0010\u0006\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0000\u001a\u001c\u0010\f\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u001c\u0010\r\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u0014\u0010\u000e\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\u0010"}, d2 = {"replaceVariables", "", "template", "replacements", "", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization$VariableName;", "getLocalizedDescription", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "localization", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$Localization;", AndroidContextPlugin.LOCALE_KEY, "Ljava/util/Locale;", "getThreePhaseDescription", "getTwoPhaseDescription", "localizedTotalDuration", "Lcom/revenuecat/purchases/models/PricingPhase;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class SubscriptionOptionExtensionsKt {

    /* JADX INFO: compiled from: SubscriptionOptionExtensions.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OfferPaymentMode.values().length];
            try {
                iArr[OfferPaymentMode.FREE_TRIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OfferPaymentMode.SINGLE_PAYMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OfferPaymentMode.DISCOUNTED_RECURRING_PAYMENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final /* synthetic */ String getLocalizedDescription(SubscriptionOption subscriptionOption, CustomerCenterConfigData.Localization localization, Locale locale) {
        Intrinsics.checkNotNullParameter(subscriptionOption, "<this>");
        Intrinsics.checkNotNullParameter(localization, "localization");
        Intrinsics.checkNotNullParameter(locale, "locale");
        int size = subscriptionOption.getPricingPhases().size();
        return size != 2 ? size != 3 ? ((PricingPhase) CollectionsKt.first((List) subscriptionOption.getPricingPhases())).getPrice().getFormatted() : getThreePhaseDescription(subscriptionOption, localization, locale) : getTwoPhaseDescription(subscriptionOption, localization, locale);
    }

    private static final String getThreePhaseDescription(SubscriptionOption subscriptionOption, CustomerCenterConfigData.Localization localization, Locale locale) {
        PricingPhase pricingPhase = (PricingPhase) CollectionsKt.first((List) subscriptionOption.getPricingPhases());
        PricingPhase pricingPhase2 = subscriptionOption.getPricingPhases().get(1);
        PricingPhase pricingPhase3 = (PricingPhase) CollectionsKt.last((List) subscriptionOption.getPricingPhases());
        String strLocalizedPerPeriod = PriceExtensionsKt.localizedPerPeriod(pricingPhase3.getPrice(), pricingPhase3.getBillingPeriod(), locale, false);
        if (pricingPhase.getOfferPaymentMode() != OfferPaymentMode.FREE_TRIAL) {
            return getTwoPhaseDescription(subscriptionOption, localization, locale);
        }
        String strLocalizedTotalDuration = localizedTotalDuration(pricingPhase, locale);
        String strLocalizedTotalDuration2 = localizedTotalDuration(pricingPhase2, locale);
        Integer billingCycleCount = pricingPhase2.getBillingCycleCount();
        Map mapMapOf = MapsKt.mapOf(TuplesKt.to(CustomerCenterConfigData.Localization.VariableName.SUB_OFFER_DURATION, strLocalizedTotalDuration), TuplesKt.to(CustomerCenterConfigData.Localization.VariableName.SUB_OFFER_DURATION_2, strLocalizedTotalDuration2), TuplesKt.to(CustomerCenterConfigData.Localization.VariableName.SUB_OFFER_PRICE_2, pricingPhase2.getPrice().getFormatted()), TuplesKt.to(CustomerCenterConfigData.Localization.VariableName.DISCOUNTED_RECURRING_PAYMENT_PRICE_PER_PERIOD, PriceExtensionsKt.localizedPerPeriod(pricingPhase2.getPrice(), pricingPhase2.getBillingPeriod(), locale, false)), TuplesKt.to(CustomerCenterConfigData.Localization.VariableName.PRICE, strLocalizedPerPeriod), TuplesKt.to(CustomerCenterConfigData.Localization.VariableName.DISCOUNTED_RECURRING_PAYMENT_CYCLES, String.valueOf(billingCycleCount != null ? billingCycleCount.intValue() : 1)));
        OfferPaymentMode offerPaymentMode = pricingPhase2.getOfferPaymentMode();
        int i = offerPaymentMode == null ? -1 : WhenMappings.$EnumSwitchMapping$0[offerPaymentMode.ordinal()];
        return i != 2 ? i != 3 ? strLocalizedPerPeriod : replaceVariables(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.FREE_TRIAL_DISCOUNTED_RECURRING_PAYMENT_THEN_PRICE), mapMapOf) : replaceVariables(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.FREE_TRIAL_SINGLE_PAYMENT_THEN_PRICE), mapMapOf);
    }

    private static final String getTwoPhaseDescription(SubscriptionOption subscriptionOption, CustomerCenterConfigData.Localization localization, Locale locale) {
        PricingPhase pricingPhase = (PricingPhase) CollectionsKt.first((List) subscriptionOption.getPricingPhases());
        String strLocalizedTotalDuration = localizedTotalDuration(pricingPhase, locale);
        PricingPhase pricingPhase2 = (PricingPhase) CollectionsKt.last((List) subscriptionOption.getPricingPhases());
        String strLocalizedPerPeriod = PriceExtensionsKt.localizedPerPeriod(pricingPhase2.getPrice(), pricingPhase2.getBillingPeriod(), locale, false);
        Integer billingCycleCount = pricingPhase.getBillingCycleCount();
        Map mapMapOf = MapsKt.mapOf(TuplesKt.to(CustomerCenterConfigData.Localization.VariableName.SUB_OFFER_DURATION, strLocalizedTotalDuration), TuplesKt.to(CustomerCenterConfigData.Localization.VariableName.SUB_OFFER_PRICE, pricingPhase.getPrice().getFormatted()), TuplesKt.to(CustomerCenterConfigData.Localization.VariableName.PRICE, strLocalizedPerPeriod), TuplesKt.to(CustomerCenterConfigData.Localization.VariableName.DISCOUNTED_RECURRING_PAYMENT_PRICE_PER_PERIOD, PriceExtensionsKt.localizedPerPeriod(pricingPhase.getPrice(), pricingPhase.getBillingPeriod(), locale, false)), TuplesKt.to(CustomerCenterConfigData.Localization.VariableName.DISCOUNTED_RECURRING_PAYMENT_CYCLES, String.valueOf(billingCycleCount != null ? billingCycleCount.intValue() : 1)));
        OfferPaymentMode offerPaymentMode = pricingPhase.getOfferPaymentMode();
        int i = offerPaymentMode == null ? -1 : WhenMappings.$EnumSwitchMapping$0[offerPaymentMode.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? strLocalizedPerPeriod : replaceVariables(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.DISCOUNTED_RECURRING_PAYMENT_THEN_PRICE), mapMapOf) : replaceVariables(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.SINGLE_PAYMENT_THEN_PRICE), mapMapOf) : replaceVariables(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.FREE_TRIAL_THEN_PRICE), mapMapOf);
    }

    private static final String localizedTotalDuration(PricingPhase pricingPhase, Locale locale) {
        Integer billingCycleCount = pricingPhase.getBillingCycleCount();
        String str = MeasureFormat.getInstance(locale, MeasureFormat.FormatWidth.WIDE).format(new Measure(Integer.valueOf((billingCycleCount != null ? billingCycleCount.intValue() : 1) * pricingPhase.getBillingPeriod().getValue()), PeriodExtensionsKt.getMeasureUnit(pricingPhase.getBillingPeriod().getUnit())));
        Intrinsics.checkNotNullExpressionValue(str, "getInstance(locale, Meas….unit.measureUnit),\n    )");
        return str;
    }

    private static final String replaceVariables(String str, final Map<CustomerCenterConfigData.Localization.VariableName, String> map) {
        return new Regex("\\{\\{\\s*([^}]+)\\s*\\}\\}").replace(str, new Function1<MatchResult, CharSequence>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.extensions.SubscriptionOptionExtensionsKt.replaceVariables.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(MatchResult matchResult) {
                Object next;
                String str2;
                Intrinsics.checkNotNullParameter(matchResult, "matchResult");
                String string = StringsKt.trim((CharSequence) matchResult.getGroupValues().get(1)).toString();
                Iterator<T> it = map.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (Intrinsics.areEqual(((CustomerCenterConfigData.Localization.VariableName) ((Map.Entry) next).getKey()).getIdentifier(), string)) {
                        break;
                    }
                }
                Map.Entry entry = (Map.Entry) next;
                return (entry == null || (str2 = (String) entry.getValue()) == null) ? matchResult.getValue() : str2;
            }
        });
    }
}
