package com.revenuecat.purchases.ui.revenuecatui.data.processed;

import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.paywalls.components.common.VariableLocalizationKey;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: PricingPhaseExtensions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0000\u001a:\u0010\u0010\u001a\u0004\u0018\u00010\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00132\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0015H\u0000\u001a@\u0010\u0016\u001a\u0004\u0018\u00010\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u001a2\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0015H\u0000\u001a\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0000\u001a\u0014\u0010\u001d\u001a\u00020\u001e*\u00020\u00022\u0006\u0010\u001f\u001a\u00020 H\u0000\u001a\u001e\u0010!\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020#H\u0000\u001a\"\u0010$\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u001aH\u0000\u001a\"\u0010%\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u001aH\u0000\u001a/\u0010&\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u001f\u001a\u00020 2\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b)H\u0000\u001a\"\u0010*\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u001aH\u0000\u001a*\u0010+\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u001aH\u0000\u001a*\u0010,\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u001aH\u0000\u001a*\u0010-\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u001aH\u0000\u001aK\u0010.\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u001a2\u0006\u0010\u001f\u001a\u00020 2\u0017\u0010/\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002000\u0013¢\u0006\u0002\b)H\u0000\u001a*\u00101\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u001aH\u0000\u001a*\u00102\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u001aH\u0000\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\"\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004\"\u001a\u0010\t\u001a\u0004\u0018\u00010\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004¨\u00063"}, d2 = {"productOfferPeriodInDays", "", "Lcom/revenuecat/purchases/models/PricingPhase;", "getProductOfferPeriodInDays", "(Lcom/revenuecat/purchases/models/PricingPhase;)Ljava/lang/String;", "productOfferPeriodInMonths", "getProductOfferPeriodInMonths", "productOfferPeriodInWeeks", "getProductOfferPeriodInWeeks", "productOfferPeriodInYears", "getProductOfferPeriodInYears", "primaryDiscountPhase", "subscriptionOption", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "rcPackage", "Lcom/revenuecat/purchases/Package;", "resolveOfferPeriod", "discountPhase", "discountValue", "Lkotlin/Function1;", "productFallback", "Lkotlin/Function0;", "resolveOfferPrice", AndroidContextPlugin.LOCALE_KEY, "Ljava/util/Locale;", "localizedVariableKeys", "", "Lcom/revenuecat/purchases/paywalls/components/common/VariableLocalizationKey;", "secondaryDiscountPhase", "canDisplay", "", "unit", "Lcom/revenuecat/purchases/models/Period$Unit;", "productOfferEndDate", "date", "Ljava/util/Date;", "productOfferPeriod", "productOfferPeriodAbbreviated", "productOfferPeriodInPeriodUnit", "calculateValue", "Lcom/revenuecat/purchases/models/Period;", "Lkotlin/ExtensionFunctionType;", "productOfferPeriodWithUnit", "productOfferPrice", "productOfferPricePerDay", "productOfferPricePerMonth", "productOfferPricePerPeriod", "calculatePrice", "Lcom/revenuecat/purchases/models/Price;", "productOfferPricePerWeek", "productOfferPricePerYear", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PricingPhaseExtensionsKt {
    public static final boolean canDisplay(PricingPhase pricingPhase, Period.Unit unit) {
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        return unit.ordinal() <= pricingPhase.getBillingPeriod().getUnit().ordinal();
    }

    public static final String getProductOfferPeriodInDays(PricingPhase pricingPhase) {
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        return productOfferPeriodInPeriodUnit(pricingPhase, Period.Unit.DAY, new Function1<Period, String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.PricingPhaseExtensionsKt$productOfferPeriodInDays$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Period productOfferPeriodInPeriodUnit) {
                Intrinsics.checkNotNullParameter(productOfferPeriodInPeriodUnit, "$this$productOfferPeriodInPeriodUnit");
                return PeriodExtensionsKt.getRoundedValueInDays(productOfferPeriodInPeriodUnit);
            }
        });
    }

    public static final String getProductOfferPeriodInMonths(PricingPhase pricingPhase) {
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        return productOfferPeriodInPeriodUnit(pricingPhase, Period.Unit.MONTH, new Function1<Period, String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.PricingPhaseExtensionsKt$productOfferPeriodInMonths$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Period productOfferPeriodInPeriodUnit) {
                Intrinsics.checkNotNullParameter(productOfferPeriodInPeriodUnit, "$this$productOfferPeriodInPeriodUnit");
                return PeriodExtensionsKt.getRoundedValueInMonths(productOfferPeriodInPeriodUnit);
            }
        });
    }

    public static final String getProductOfferPeriodInWeeks(PricingPhase pricingPhase) {
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        return productOfferPeriodInPeriodUnit(pricingPhase, Period.Unit.WEEK, new Function1<Period, String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.PricingPhaseExtensionsKt$productOfferPeriodInWeeks$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Period productOfferPeriodInPeriodUnit) {
                Intrinsics.checkNotNullParameter(productOfferPeriodInPeriodUnit, "$this$productOfferPeriodInPeriodUnit");
                return PeriodExtensionsKt.getRoundedValueInWeeks(productOfferPeriodInPeriodUnit);
            }
        });
    }

    public static final String getProductOfferPeriodInYears(PricingPhase pricingPhase) {
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        return productOfferPeriodInPeriodUnit(pricingPhase, Period.Unit.YEAR, new Function1<Period, String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.PricingPhaseExtensionsKt$productOfferPeriodInYears$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Period productOfferPeriodInPeriodUnit) {
                Intrinsics.checkNotNullParameter(productOfferPeriodInPeriodUnit, "$this$productOfferPeriodInPeriodUnit");
                return PeriodExtensionsKt.getRoundedValueInYears(productOfferPeriodInPeriodUnit);
            }
        });
    }

    public static final PricingPhase primaryDiscountPhase(SubscriptionOption subscriptionOption, Package r2) {
        StoreProduct product;
        if (subscriptionOption == null) {
            subscriptionOption = (r2 == null || (product = r2.getProduct()) == null) ? null : product.getDefaultOption();
        }
        if (subscriptionOption == null) {
            return null;
        }
        PricingPhase freePhase = subscriptionOption.getFreePhase();
        return freePhase == null ? subscriptionOption.getIntroPhase() : freePhase;
    }

    public static final String productOfferEndDate(PricingPhase pricingPhase, Locale locale, Date date) {
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(date, "date");
        Calendar calendar = Calendar.getInstance(locale);
        calendar.setTime(date);
        calendar.add(6, MathKt.roundToInt(pricingPhase.getBillingPeriod().getValueInDays()));
        return DateFormat.getDateInstance(1, locale).format(calendar.getTime());
    }

    public static final String productOfferPeriod(PricingPhase pricingPhase, Map<VariableLocalizationKey, String> localizedVariableKeys) {
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        Intrinsics.checkNotNullParameter(localizedVariableKeys, "localizedVariableKeys");
        VariableLocalizationKey periodUnitLocalizationKey = PeriodExtensionsKt.getPeriodUnitLocalizationKey(pricingPhase.getBillingPeriod());
        if (periodUnitLocalizationKey != null) {
            return PackagePeriodExtensionsKt.getStringOrLogError(localizedVariableKeys, periodUnitLocalizationKey);
        }
        return null;
    }

    public static final String productOfferPeriodAbbreviated(PricingPhase pricingPhase, Map<VariableLocalizationKey, String> localizedVariableKeys) {
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        Intrinsics.checkNotNullParameter(localizedVariableKeys, "localizedVariableKeys");
        VariableLocalizationKey periodUnitAbbreviatedLocalizationKey = PeriodExtensionsKt.getPeriodUnitAbbreviatedLocalizationKey(pricingPhase.getBillingPeriod());
        if (periodUnitAbbreviatedLocalizationKey != null) {
            return PackagePeriodExtensionsKt.getStringOrLogError(localizedVariableKeys, periodUnitAbbreviatedLocalizationKey);
        }
        return null;
    }

    public static final String productOfferPeriodInPeriodUnit(PricingPhase pricingPhase, Period.Unit unit, Function1<? super Period, String> calculateValue) {
        Period billingPeriod;
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(calculateValue, "calculateValue");
        if (!canDisplay(pricingPhase, unit)) {
            pricingPhase = null;
        }
        if (pricingPhase == null || (billingPeriod = pricingPhase.getBillingPeriod()) == null) {
            return null;
        }
        return calculateValue.invoke(billingPeriod);
    }

    public static final String productOfferPeriodWithUnit(PricingPhase pricingPhase, Map<VariableLocalizationKey, String> localizedVariableKeys) {
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        Intrinsics.checkNotNullParameter(localizedVariableKeys, "localizedVariableKeys");
        String stringOrLogError = PackagePeriodExtensionsKt.getStringOrLogError(localizedVariableKeys, PeriodExtensionsKt.getPeriodValueWithUnitLocalizationKey(pricingPhase.getBillingPeriod()));
        if (stringOrLogError == null) {
            return null;
        }
        String str = String.format(stringOrLogError, Arrays.copyOf(new Object[]{Integer.valueOf(pricingPhase.getBillingPeriod().getValue())}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public static final String productOfferPrice(PricingPhase pricingPhase, Locale locale, Map<VariableLocalizationKey, String> localizedVariableKeys) {
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(localizedVariableKeys, "localizedVariableKeys");
        return pricingPhase.getPrice().getAmountMicros() == 0 ? PackagePeriodExtensionsKt.getStringOrLogError(localizedVariableKeys, VariableLocalizationKey.FREE_PRICE) : VariableDataProviderKt.getFormatted(pricingPhase.getPrice(), locale);
    }

    public static final String productOfferPricePerDay(PricingPhase pricingPhase, final Locale locale, Map<VariableLocalizationKey, String> localizedVariableKeys) {
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(localizedVariableKeys, "localizedVariableKeys");
        return productOfferPricePerPeriod(pricingPhase, locale, localizedVariableKeys, Period.Unit.DAY, new Function1<PricingPhase, Price>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.PricingPhaseExtensionsKt.productOfferPricePerDay.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Price invoke(PricingPhase productOfferPricePerPeriod) {
                Intrinsics.checkNotNullParameter(productOfferPricePerPeriod, "$this$productOfferPricePerPeriod");
                return productOfferPricePerPeriod.pricePerDay(locale);
            }
        });
    }

    public static final String productOfferPricePerMonth(PricingPhase pricingPhase, final Locale locale, Map<VariableLocalizationKey, String> localizedVariableKeys) {
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(localizedVariableKeys, "localizedVariableKeys");
        return productOfferPricePerPeriod(pricingPhase, locale, localizedVariableKeys, Period.Unit.MONTH, new Function1<PricingPhase, Price>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.PricingPhaseExtensionsKt.productOfferPricePerMonth.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Price invoke(PricingPhase productOfferPricePerPeriod) {
                Intrinsics.checkNotNullParameter(productOfferPricePerPeriod, "$this$productOfferPricePerPeriod");
                return productOfferPricePerPeriod.pricePerMonth(locale);
            }
        });
    }

    public static final String productOfferPricePerPeriod(PricingPhase pricingPhase, Locale locale, Map<VariableLocalizationKey, String> localizedVariableKeys, Period.Unit unit, Function1<? super PricingPhase, Price> calculatePrice) {
        Price priceInvoke;
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(localizedVariableKeys, "localizedVariableKeys");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(calculatePrice, "calculatePrice");
        if (!canDisplay(pricingPhase, unit)) {
            pricingPhase = null;
        }
        if (pricingPhase == null || (priceInvoke = calculatePrice.invoke(pricingPhase)) == null) {
            return null;
        }
        return priceInvoke.getAmountMicros() == 0 ? PackagePeriodExtensionsKt.getStringOrLogError(localizedVariableKeys, VariableLocalizationKey.FREE_PRICE) : VariableDataProviderKt.getFormatted(priceInvoke, locale);
    }

    public static final String productOfferPricePerWeek(PricingPhase pricingPhase, final Locale locale, Map<VariableLocalizationKey, String> localizedVariableKeys) {
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(localizedVariableKeys, "localizedVariableKeys");
        return productOfferPricePerPeriod(pricingPhase, locale, localizedVariableKeys, Period.Unit.WEEK, new Function1<PricingPhase, Price>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.PricingPhaseExtensionsKt.productOfferPricePerWeek.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Price invoke(PricingPhase productOfferPricePerPeriod) {
                Intrinsics.checkNotNullParameter(productOfferPricePerPeriod, "$this$productOfferPricePerPeriod");
                return productOfferPricePerPeriod.pricePerWeek(locale);
            }
        });
    }

    public static final String productOfferPricePerYear(PricingPhase pricingPhase, final Locale locale, Map<VariableLocalizationKey, String> localizedVariableKeys) {
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(localizedVariableKeys, "localizedVariableKeys");
        return productOfferPricePerPeriod(pricingPhase, locale, localizedVariableKeys, Period.Unit.YEAR, new Function1<PricingPhase, Price>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.PricingPhaseExtensionsKt.productOfferPricePerYear.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Price invoke(PricingPhase productOfferPricePerPeriod) {
                Intrinsics.checkNotNullParameter(productOfferPricePerPeriod, "$this$productOfferPricePerPeriod");
                return productOfferPricePerPeriod.pricePerYear(locale);
            }
        });
    }

    public static final String resolveOfferPeriod(PricingPhase pricingPhase, Function1<? super PricingPhase, String> discountValue, Function0<String> productFallback) {
        String strInvoke;
        Intrinsics.checkNotNullParameter(discountValue, "discountValue");
        Intrinsics.checkNotNullParameter(productFallback, "productFallback");
        return (pricingPhase == null || (strInvoke = discountValue.invoke(pricingPhase)) == null) ? productFallback.invoke() : strInvoke;
    }

    public static final String resolveOfferPrice(PricingPhase pricingPhase, Locale locale, Map<VariableLocalizationKey, String> localizedVariableKeys, Function0<String> productFallback) {
        String strProductOfferPrice;
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(localizedVariableKeys, "localizedVariableKeys");
        Intrinsics.checkNotNullParameter(productFallback, "productFallback");
        return (pricingPhase == null || (strProductOfferPrice = productOfferPrice(pricingPhase, locale, localizedVariableKeys)) == null) ? productFallback.invoke() : strProductOfferPrice;
    }

    public static final PricingPhase secondaryDiscountPhase(SubscriptionOption subscriptionOption, Package r2) {
        StoreProduct product;
        if (subscriptionOption == null) {
            subscriptionOption = (r2 == null || (product = r2.getProduct()) == null) ? null : product.getDefaultOption();
        }
        if (subscriptionOption == null || subscriptionOption.getFreePhase() == null) {
            return null;
        }
        return subscriptionOption.getIntroPhase();
    }
}
