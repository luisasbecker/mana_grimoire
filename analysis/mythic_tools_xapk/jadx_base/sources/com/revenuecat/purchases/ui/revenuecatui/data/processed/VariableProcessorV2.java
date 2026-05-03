package com.revenuecat.purchases.ui.revenuecatui.data.processed;

import com.google.android.material.timepicker.TimeModel;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.paywalls.components.CountdownComponent;
import com.revenuecat.purchases.paywalls.components.common.VariableLocalizationKey;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import com.revenuecat.purchases.ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.ui.revenuecatui.components.countdown.CountdownTime;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableProcessor;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableProcessorV2;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: VariableProcessorV2.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002GHB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0002J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0012H\u0002J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\f\u001a\u00020\u00072\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0012H\u0002J´\u0001\u0010\u0016\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020,2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020.0\u00122\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020.0\u0012H\u0002Jº\u0001\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\b\b\u0002\u0010'\u001a\u00020(2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\b\b\u0002\u0010+\u001a\u00020,2\u0014\b\u0002\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020.0\u00122\u0014\b\u0002\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020.0\u0012JN\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00072\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020.0\u00122\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020.0\u00122\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\u0006\u0010$\u001a\u00020%H\u0002J\u001c\u00105\u001a\u00020\u000b*\u0002062\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!H\u0002Jt\u00107\u001a\u0004\u0018\u00010\u0007*\u00020\u00142\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00070\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020,H\u0002J\u001c\u00108\u001a\u00020\u0007*\u00020\u00072\u0006\u00109\u001a\u00020\u000f2\u0006\u0010:\u001a\u00020%H\u0002J\"\u0010;\u001a\u0004\u0018\u00010\u0007*\u00020\u001f2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00070\u0012H\u0002JJ\u0010<\u001a\u00020\u0007*\u00020\u00072<\u00107\u001a8\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020\u00070=H\u0002J\u0014\u0010A\u001a\u00020\u000b*\u0002062\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\u0014\u0010B\u001a\u00020\u000b*\u0002062\u0006\u0010\f\u001a\u00020\u0007H\u0002J\u001c\u0010C\u001a\u00020\u000b*\u0002062\u0006\u0010D\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\u0007H\u0002J\u001c\u0010F\u001a\u00020\u000b*\u0002062\u0006\u0010D\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\u0007H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/VariableProcessorV2;", "", "()V", "PERCENT_SCALE", "", "customVariablePrefixes", "", "", "regex", "Lkotlin/text/Regex;", "checkForMalformedCustomVariable", "", "variableIdentifier", "extractCustomVariableKey", "findFunction", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/VariableProcessorV2$Function;", "functionIdentifier", "functionCompatibilityMap", "", "findVariable", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/VariableProcessorV2$Variable;", "variableCompatibilityMap", "getVariableValue", "functionIdentifiers", "localizedVariableKeys", "Lcom/revenuecat/purchases/paywalls/components/common/VariableLocalizationKey;", "variableConfig", "Lcom/revenuecat/purchases/UiConfig$VariableConfig;", "variableDataProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/VariableDataProvider;", "packageContext", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/VariableProcessor$PackageContext;", "rcPackage", "Lcom/revenuecat/purchases/Package;", "subscriptionOption", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "currencyLocale", "Ljava/util/Locale;", "dateLocale", "date", "Ljava/util/Date;", "countdownTime", "Lcom/revenuecat/purchases/ui/revenuecatui/components/countdown/CountdownTime;", "countFrom", "Lcom/revenuecat/purchases/paywalls/components/CountdownComponent$CountFrom;", "customVariables", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "defaultCustomVariables", "processVariables", "template", "resolveCustomVariable", SubscriberAttributeKt.JSON_NAME_KEY, "functions", "failedToGetValue", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/Logger;", "getValue", "processFunction", "function", AndroidContextPlugin.LOCALE_KEY, "relativeDiscount", "replaceVariablesWithValues", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "variable", "unsupportedFunctionWithoutFallback", "unsupportedVariableWithoutFallback", "usingFallbackFunction", "original", "fallback", "usingFallbackVariable", "Function", "Variable", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VariableProcessorV2 {
    private static final float PERCENT_SCALE = 100.0f;
    public static final VariableProcessorV2 INSTANCE = new VariableProcessorV2();
    private static final Regex regex = new Regex("\\{\\{\\s*(.*?)\\s*\\}\\}");
    private static final List<String> customVariablePrefixes = CollectionsKt.listOf((Object[]) new String[]{"custom.", "$custom."});
    public static final int $stable = 8;

    /* JADX INFO: compiled from: VariableProcessorV2.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0080\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/VariableProcessorV2$Function;", "", "identifier", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getIdentifier", "()Ljava/lang/String;", "LOWERCASE", "UPPERCASE", "CAPITALIZE", "Companion", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum Function {
        LOWERCASE("lowercase"),
        UPPERCASE("uppercase"),
        CAPITALIZE("capitalize");

        private final String identifier;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Lazy<Map<String, Function>> valuesByIdentifier$delegate = LazyKt.lazy(new Function0<Map<String, ? extends Function>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableProcessorV2$Function$Companion$valuesByIdentifier$2
            @Override // kotlin.jvm.functions.Function0
            public final Map<String, ? extends VariableProcessorV2.Function> invoke() {
                VariableProcessorV2.Function[] functionArrValues = VariableProcessorV2.Function.values();
                LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(functionArrValues.length), 16));
                for (VariableProcessorV2.Function function : functionArrValues) {
                    linkedHashMap.put(function.getIdentifier(), function);
                }
                return linkedHashMap;
            }
        });

        /* JADX INFO: compiled from: VariableProcessorV2.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u0005R'\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/VariableProcessorV2$Function$Companion;", "", "()V", "valuesByIdentifier", "", "", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/VariableProcessorV2$Function;", "getValuesByIdentifier", "()Ljava/util/Map;", "valuesByIdentifier$delegate", "Lkotlin/Lazy;", "valueOfIdentifier", "identifier", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final Map<String, Function> getValuesByIdentifier() {
                return (Map) Function.valuesByIdentifier$delegate.getValue();
            }

            public final Function valueOfIdentifier(String identifier) {
                Intrinsics.checkNotNullParameter(identifier, "identifier");
                return getValuesByIdentifier().get(identifier);
            }
        }

        Function(String str) {
            this.identifier = str;
        }

        public final /* synthetic */ String getIdentifier() {
            return this.identifier;
        }
    }

    /* JADX INFO: compiled from: VariableProcessorV2.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b0\b\u0080\u0001\u0018\u0000 22\b\u0012\u0004\u0012\u00020\u00000\u0001:\u00012B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1¨\u00063"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/VariableProcessorV2$Variable;", "", "identifier", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getIdentifier", "()Ljava/lang/String;", "PRODUCT_CURRENCY_CODE", "PRODUCT_CURRENCY_SYMBOL", "PRODUCT_PERIODLY", "PRODUCT_PRICE", "PRODUCT_PRICE_PER_PERIOD", "PRODUCT_PRICE_PER_PERIOD_ABBREVIATED", "PRODUCT_PRICE_PER_DAY", "PRODUCT_PRICE_PER_WEEK", "PRODUCT_PRICE_PER_MONTH", "PRODUCT_PRICE_PER_YEAR", "PRODUCT_PERIOD", "PRODUCT_PERIOD_ABBREVIATED", "PRODUCT_PERIOD_IN_DAYS", "PRODUCT_PERIOD_IN_WEEKS", "PRODUCT_PERIOD_IN_MONTHS", "PRODUCT_PERIOD_IN_YEARS", "PRODUCT_PERIOD_WITH_UNIT", "PRODUCT_OFFER_PRICE", "PRODUCT_OFFER_PRICE_PER_DAY", "PRODUCT_OFFER_PRICE_PER_WEEK", "PRODUCT_OFFER_PRICE_PER_MONTH", "PRODUCT_OFFER_PRICE_PER_YEAR", "PRODUCT_OFFER_PERIOD", "PRODUCT_OFFER_PERIOD_ABBREVIATED", "PRODUCT_OFFER_PERIOD_IN_DAYS", "PRODUCT_OFFER_PERIOD_IN_WEEKS", "PRODUCT_OFFER_PERIOD_IN_MONTHS", "PRODUCT_OFFER_PERIOD_IN_YEARS", "PRODUCT_OFFER_PERIOD_WITH_UNIT", "PRODUCT_OFFER_END_DATE", "PRODUCT_SECONDARY_OFFER_PRICE", "PRODUCT_SECONDARY_OFFER_PERIOD", "PRODUCT_SECONDARY_OFFER_PERIOD_ABBREVIATED", "PRODUCT_RELATIVE_DISCOUNT", "PRODUCT_STORE_PRODUCT_NAME", "COUNT_DAYS_WITH_ZERO", "COUNT_DAYS_WITHOUT_ZERO", "COUNT_HOURS_WITH_ZERO", "COUNT_HOURS_WITHOUT_ZERO", "COUNT_MINUTES_WITH_ZERO", "COUNT_MINUTES_WITHOUT_ZERO", "COUNT_SECONDS_WITH_ZERO", "COUNT_SECONDS_WITHOUT_ZERO", "Companion", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum Variable {
        PRODUCT_CURRENCY_CODE("product.currency_code"),
        PRODUCT_CURRENCY_SYMBOL("product.currency_symbol"),
        PRODUCT_PERIODLY("product.periodly"),
        PRODUCT_PRICE("product.price"),
        PRODUCT_PRICE_PER_PERIOD("product.price_per_period"),
        PRODUCT_PRICE_PER_PERIOD_ABBREVIATED("product.price_per_period_abbreviated"),
        PRODUCT_PRICE_PER_DAY("product.price_per_day"),
        PRODUCT_PRICE_PER_WEEK("product.price_per_week"),
        PRODUCT_PRICE_PER_MONTH("product.price_per_month"),
        PRODUCT_PRICE_PER_YEAR("product.price_per_year"),
        PRODUCT_PERIOD("product.period"),
        PRODUCT_PERIOD_ABBREVIATED("product.period_abbreviated"),
        PRODUCT_PERIOD_IN_DAYS("product.period_in_days"),
        PRODUCT_PERIOD_IN_WEEKS("product.period_in_weeks"),
        PRODUCT_PERIOD_IN_MONTHS("product.period_in_months"),
        PRODUCT_PERIOD_IN_YEARS("product.period_in_years"),
        PRODUCT_PERIOD_WITH_UNIT("product.period_with_unit"),
        PRODUCT_OFFER_PRICE("product.offer_price"),
        PRODUCT_OFFER_PRICE_PER_DAY("product.offer_price_per_day"),
        PRODUCT_OFFER_PRICE_PER_WEEK("product.offer_price_per_week"),
        PRODUCT_OFFER_PRICE_PER_MONTH("product.offer_price_per_month"),
        PRODUCT_OFFER_PRICE_PER_YEAR("product.offer_price_per_year"),
        PRODUCT_OFFER_PERIOD("product.offer_period"),
        PRODUCT_OFFER_PERIOD_ABBREVIATED("product.offer_period_abbreviated"),
        PRODUCT_OFFER_PERIOD_IN_DAYS("product.offer_period_in_days"),
        PRODUCT_OFFER_PERIOD_IN_WEEKS("product.offer_period_in_weeks"),
        PRODUCT_OFFER_PERIOD_IN_MONTHS("product.offer_period_in_months"),
        PRODUCT_OFFER_PERIOD_IN_YEARS("product.offer_period_in_years"),
        PRODUCT_OFFER_PERIOD_WITH_UNIT("product.offer_period_with_unit"),
        PRODUCT_OFFER_END_DATE("product.offer_end_date"),
        PRODUCT_SECONDARY_OFFER_PRICE("product.secondary_offer_price"),
        PRODUCT_SECONDARY_OFFER_PERIOD("product.secondary_offer_period"),
        PRODUCT_SECONDARY_OFFER_PERIOD_ABBREVIATED("product.secondary_offer_period_abbreviated"),
        PRODUCT_RELATIVE_DISCOUNT("product.relative_discount"),
        PRODUCT_STORE_PRODUCT_NAME("product.store_product_name"),
        COUNT_DAYS_WITH_ZERO("count_days_with_zero"),
        COUNT_DAYS_WITHOUT_ZERO("count_days_without_zero"),
        COUNT_HOURS_WITH_ZERO("count_hours_with_zero"),
        COUNT_HOURS_WITHOUT_ZERO("count_hours_without_zero"),
        COUNT_MINUTES_WITH_ZERO("count_minutes_with_zero"),
        COUNT_MINUTES_WITHOUT_ZERO("count_minutes_without_zero"),
        COUNT_SECONDS_WITH_ZERO("count_seconds_with_zero"),
        COUNT_SECONDS_WITHOUT_ZERO("count_seconds_without_zero");

        private final String identifier;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Lazy<Map<String, Variable>> valuesByIdentifier$delegate = LazyKt.lazy(new Function0<Map<String, ? extends Variable>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableProcessorV2$Variable$Companion$valuesByIdentifier$2
            @Override // kotlin.jvm.functions.Function0
            public final Map<String, ? extends VariableProcessorV2.Variable> invoke() {
                VariableProcessorV2.Variable[] variableArrValues = VariableProcessorV2.Variable.values();
                LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(variableArrValues.length), 16));
                for (VariableProcessorV2.Variable variable : variableArrValues) {
                    linkedHashMap.put(variable.getIdentifier(), variable);
                }
                return linkedHashMap;
            }
        });

        /* JADX INFO: compiled from: VariableProcessorV2.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u0005R'\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/VariableProcessorV2$Variable$Companion;", "", "()V", "valuesByIdentifier", "", "", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/VariableProcessorV2$Variable;", "getValuesByIdentifier", "()Ljava/util/Map;", "valuesByIdentifier$delegate", "Lkotlin/Lazy;", "valueOfIdentifier", "identifier", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final Map<String, Variable> getValuesByIdentifier() {
                return (Map) Variable.valuesByIdentifier$delegate.getValue();
            }

            public final Variable valueOfIdentifier(String identifier) {
                Intrinsics.checkNotNullParameter(identifier, "identifier");
                return getValuesByIdentifier().get(identifier);
            }
        }

        Variable(String str) {
            this.identifier = str;
        }

        public final /* synthetic */ String getIdentifier() {
            return this.identifier;
        }
    }

    /* JADX INFO: compiled from: VariableProcessorV2.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[CountdownComponent.CountFrom.values().length];
            try {
                iArr[CountdownComponent.CountFrom.DAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CountdownComponent.CountFrom.HOURS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CountdownComponent.CountFrom.MINUTES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[Variable.values().length];
            try {
                iArr2[Variable.PRODUCT_CURRENCY_CODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[Variable.PRODUCT_CURRENCY_SYMBOL.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[Variable.PRODUCT_PERIODLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[Variable.PRODUCT_PRICE.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[Variable.PRODUCT_PRICE_PER_PERIOD.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[Variable.PRODUCT_PRICE_PER_PERIOD_ABBREVIATED.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[Variable.PRODUCT_PRICE_PER_DAY.ordinal()] = 7;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[Variable.PRODUCT_PRICE_PER_WEEK.ordinal()] = 8;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[Variable.PRODUCT_PRICE_PER_MONTH.ordinal()] = 9;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[Variable.PRODUCT_PRICE_PER_YEAR.ordinal()] = 10;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr2[Variable.PRODUCT_PERIOD.ordinal()] = 11;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr2[Variable.PRODUCT_PERIOD_ABBREVIATED.ordinal()] = 12;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr2[Variable.PRODUCT_PERIOD_IN_DAYS.ordinal()] = 13;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr2[Variable.PRODUCT_PERIOD_IN_WEEKS.ordinal()] = 14;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr2[Variable.PRODUCT_PERIOD_IN_MONTHS.ordinal()] = 15;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr2[Variable.PRODUCT_PERIOD_IN_YEARS.ordinal()] = 16;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr2[Variable.PRODUCT_PERIOD_WITH_UNIT.ordinal()] = 17;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr2[Variable.PRODUCT_OFFER_PRICE.ordinal()] = 18;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr2[Variable.PRODUCT_OFFER_PRICE_PER_DAY.ordinal()] = 19;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr2[Variable.PRODUCT_OFFER_PRICE_PER_WEEK.ordinal()] = 20;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr2[Variable.PRODUCT_OFFER_PRICE_PER_MONTH.ordinal()] = 21;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr2[Variable.PRODUCT_OFFER_PRICE_PER_YEAR.ordinal()] = 22;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr2[Variable.PRODUCT_OFFER_PERIOD.ordinal()] = 23;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr2[Variable.PRODUCT_OFFER_PERIOD_ABBREVIATED.ordinal()] = 24;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr2[Variable.PRODUCT_OFFER_PERIOD_IN_DAYS.ordinal()] = 25;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr2[Variable.PRODUCT_OFFER_PERIOD_IN_WEEKS.ordinal()] = 26;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr2[Variable.PRODUCT_OFFER_PERIOD_IN_MONTHS.ordinal()] = 27;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr2[Variable.PRODUCT_OFFER_PERIOD_IN_YEARS.ordinal()] = 28;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr2[Variable.PRODUCT_OFFER_PERIOD_WITH_UNIT.ordinal()] = 29;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                iArr2[Variable.PRODUCT_OFFER_END_DATE.ordinal()] = 30;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                iArr2[Variable.PRODUCT_SECONDARY_OFFER_PRICE.ordinal()] = 31;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                iArr2[Variable.PRODUCT_SECONDARY_OFFER_PERIOD.ordinal()] = 32;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                iArr2[Variable.PRODUCT_SECONDARY_OFFER_PERIOD_ABBREVIATED.ordinal()] = 33;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                iArr2[Variable.PRODUCT_RELATIVE_DISCOUNT.ordinal()] = 34;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                iArr2[Variable.PRODUCT_STORE_PRODUCT_NAME.ordinal()] = 35;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                iArr2[Variable.COUNT_DAYS_WITH_ZERO.ordinal()] = 36;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                iArr2[Variable.COUNT_DAYS_WITHOUT_ZERO.ordinal()] = 37;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                iArr2[Variable.COUNT_HOURS_WITH_ZERO.ordinal()] = 38;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                iArr2[Variable.COUNT_HOURS_WITHOUT_ZERO.ordinal()] = 39;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                iArr2[Variable.COUNT_MINUTES_WITH_ZERO.ordinal()] = 40;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                iArr2[Variable.COUNT_MINUTES_WITHOUT_ZERO.ordinal()] = 41;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                iArr2[Variable.COUNT_SECONDS_WITH_ZERO.ordinal()] = 42;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                iArr2[Variable.COUNT_SECONDS_WITHOUT_ZERO.ordinal()] = 43;
            } catch (NoSuchFieldError unused46) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[Function.values().length];
            try {
                iArr3[Function.LOWERCASE.ordinal()] = 1;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                iArr3[Function.UPPERCASE.ordinal()] = 2;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                iArr3[Function.CAPITALIZE.ordinal()] = 3;
            } catch (NoSuchFieldError unused49) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    private VariableProcessorV2() {
    }

    private final void checkForMalformedCustomVariable(String variableIdentifier) {
        for (String str : CollectionsKt.listOf((Object[]) new String[]{"custom", "$custom"})) {
            if (Intrinsics.areEqual(variableIdentifier, str) || StringsKt.startsWith$default(variableIdentifier, str + ' ', false, 2, (Object) null)) {
                Logger.INSTANCE.w("Variable '" + variableIdentifier + "' looks like it might be intended as a custom variable. Use 'custom.<variable_name>' or '$custom.<variable_name>' syntax instead.");
                return;
            }
        }
    }

    private final String extractCustomVariableKey(String variableIdentifier) {
        for (String str : customVariablePrefixes) {
            if (StringsKt.startsWith$default(variableIdentifier, str, false, 2, (Object) null)) {
                String strRemovePrefix = StringsKt.removePrefix(variableIdentifier, (CharSequence) str);
                if (strRemovePrefix.length() != 0) {
                    return strRemovePrefix;
                }
                Logger.INSTANCE.w("Custom variable '" + variableIdentifier + "' appears to be malformed. Expected format: 'custom.<variable_name>' or '$custom.<variable_name>'.");
                return null;
            }
        }
        checkForMalformedCustomVariable(variableIdentifier);
        return null;
    }

    private final void failedToGetValue(Logger logger, String str, Package r4) {
        logger.w("Could not process value for variable '" + str + "' for package '" + r4.getIdentifier() + "'. Please check that the product for that package matches the requirements for that variable. Defaulting to empty string.");
    }

    private final Function findFunction(String functionIdentifier, Map<String, String> functionCompatibilityMap) {
        Function functionValueOfIdentifier = Function.INSTANCE.valueOfIdentifier(functionIdentifier);
        if (functionValueOfIdentifier != null) {
            return functionValueOfIdentifier;
        }
        String str = functionCompatibilityMap.get(functionIdentifier);
        if (str == null) {
            unsupportedFunctionWithoutFallback(Logger.INSTANCE, functionIdentifier);
            return null;
        }
        Function functionFindFunction = findFunction(str, functionCompatibilityMap);
        if (functionFindFunction == null) {
            return null;
        }
        INSTANCE.usingFallbackFunction(Logger.INSTANCE, functionIdentifier, str);
        return functionFindFunction;
    }

    private final Variable findVariable(String variableIdentifier, Map<String, String> variableCompatibilityMap) {
        Variable variableValueOfIdentifier = Variable.INSTANCE.valueOfIdentifier(variableIdentifier);
        if (variableValueOfIdentifier != null) {
            return variableValueOfIdentifier;
        }
        String str = variableCompatibilityMap.get(variableIdentifier);
        if (str == null) {
            unsupportedVariableWithoutFallback(Logger.INSTANCE, variableIdentifier);
            return null;
        }
        Variable variableFindVariable = findVariable(str, variableCompatibilityMap);
        if (variableFindVariable == null) {
            return null;
        }
        INSTANCE.usingFallbackVariable(Logger.INSTANCE, variableIdentifier, str);
        return variableFindVariable;
    }

    private final String getValue(Variable variable, final Map<VariableLocalizationKey, String> map, final VariableDataProvider variableDataProvider, final VariableProcessor.PackageContext packageContext, final Package r23, SubscriptionOption subscriptionOption, final Locale locale, Locale locale2, Date date, CountdownTime countdownTime, CountdownComponent.CountFrom countFrom) {
        StoreProduct product;
        Price price;
        StoreProduct product2;
        Period period;
        StoreProduct product3;
        Period period2;
        StoreProduct product4;
        Period period3;
        StoreProduct product5;
        Period period4;
        String strProductOfferPricePerDay;
        String strProductOfferPricePerWeek;
        String strProductOfferPricePerMonth;
        String strProductOfferPricePerYear;
        StoreProduct product6;
        Period period5;
        String productOfferPeriodInDays;
        StoreProduct product7;
        Period period6;
        String productOfferPeriodInWeeks;
        StoreProduct product8;
        Period period7;
        String productOfferPeriodInMonths;
        StoreProduct product9;
        Period period8;
        String productOfferPeriodInYears;
        String strProductOfferPeriodWithUnit;
        StoreProduct product10;
        int minutes;
        int minutes2;
        int hours = 0;
        int hours2 = 0;
        days = 0;
        int days = 0;
        days = 0;
        int days2 = 0;
        switch (WhenMappings.$EnumSwitchMapping$1[variable.ordinal()]) {
            case 1:
                if (r23 == null || (product = r23.getProduct()) == null || (price = product.getPrice()) == null) {
                    return null;
                }
                return price.getCurrencyCode();
            case 2:
                if (r23 != null) {
                    return Currency.getInstance(r23.getProduct().getPrice().getCurrencyCode()).getSymbol(locale);
                }
                return null;
            case 3:
                if (r23 != null) {
                    return PackagePeriodExtensionsKt.productPeriodly(r23, map);
                }
                return null;
            case 4:
                if (r23 == null || variableDataProvider == null) {
                    return null;
                }
                return variableDataProvider.localizedPrice(r23, locale, packageContext != null ? packageContext.getShowZeroDecimalPlacePrices() : false);
            case 5:
                if (r23 != null && variableDataProvider != null) {
                    String strLocalizedPrice = variableDataProvider.localizedPrice(r23, locale, packageContext != null ? packageContext.getShowZeroDecimalPlacePrices() : false);
                    if (strLocalizedPrice != null) {
                        String strProductPeriod = PackagePeriodExtensionsKt.productPeriod(r23, map);
                        if (PackagePeriodExtensionsKt.isLifetime(r23)) {
                            return strLocalizedPrice;
                        }
                        if (strProductPeriod != null) {
                            return strLocalizedPrice + IOUtils.DIR_SEPARATOR_UNIX + strProductPeriod;
                        }
                    }
                }
                return null;
            case 6:
                if (r23 != null && variableDataProvider != null) {
                    String strLocalizedPrice2 = variableDataProvider.localizedPrice(r23, locale, packageContext != null ? packageContext.getShowZeroDecimalPlacePrices() : false);
                    if (strLocalizedPrice2 != null) {
                        String strProductPeriodAbbreviated = PackagePeriodExtensionsKt.productPeriodAbbreviated(r23, map);
                        if (PackagePeriodExtensionsKt.isLifetime(r23)) {
                            return strLocalizedPrice2;
                        }
                        if (strProductPeriodAbbreviated != null) {
                            return strLocalizedPrice2 + IOUtils.DIR_SEPARATOR_UNIX + strProductPeriodAbbreviated;
                        }
                    }
                }
                return null;
            case 7:
                if (r23 != null) {
                    boolean showZeroDecimalPlacePrices = packageContext != null ? packageContext.getShowZeroDecimalPlacePrices() : false;
                    if (PackagePeriodExtensionsKt.isLifetime(r23)) {
                        if (variableDataProvider != null) {
                            return variableDataProvider.localizedPrice(r23, locale, showZeroDecimalPlacePrices);
                        }
                        return null;
                    }
                    if (variableDataProvider != null) {
                        return variableDataProvider.localizedPricePerDay(r23, locale, showZeroDecimalPlacePrices);
                    }
                }
                return null;
            case 8:
                if (r23 != null) {
                    boolean showZeroDecimalPlacePrices2 = packageContext != null ? packageContext.getShowZeroDecimalPlacePrices() : false;
                    if (PackagePeriodExtensionsKt.isLifetime(r23)) {
                        if (variableDataProvider != null) {
                            return variableDataProvider.localizedPrice(r23, locale, showZeroDecimalPlacePrices2);
                        }
                        return null;
                    }
                    if (variableDataProvider != null) {
                        return variableDataProvider.localizedPricePerWeek(r23, locale, showZeroDecimalPlacePrices2);
                    }
                }
                return null;
            case 9:
                if (r23 != null) {
                    boolean showZeroDecimalPlacePrices3 = packageContext != null ? packageContext.getShowZeroDecimalPlacePrices() : false;
                    if (PackagePeriodExtensionsKt.isLifetime(r23)) {
                        if (variableDataProvider != null) {
                            return variableDataProvider.localizedPrice(r23, locale, showZeroDecimalPlacePrices3);
                        }
                        return null;
                    }
                    if (variableDataProvider != null) {
                        return variableDataProvider.localizedPricePerMonth(r23, locale, showZeroDecimalPlacePrices3);
                    }
                }
                return null;
            case 10:
                if (r23 != null) {
                    boolean showZeroDecimalPlacePrices4 = packageContext != null ? packageContext.getShowZeroDecimalPlacePrices() : false;
                    if (PackagePeriodExtensionsKt.isLifetime(r23)) {
                        if (variableDataProvider != null) {
                            return variableDataProvider.localizedPrice(r23, locale, showZeroDecimalPlacePrices4);
                        }
                        return null;
                    }
                    if (variableDataProvider != null) {
                        return variableDataProvider.localizedPricePerYear(r23, locale, showZeroDecimalPlacePrices4);
                    }
                }
                return null;
            case 11:
                if (r23 != null) {
                    return PackagePeriodExtensionsKt.productPeriod(r23, map);
                }
                return null;
            case 12:
                if (r23 != null) {
                    return PackagePeriodExtensionsKt.productPeriodAbbreviated(r23, map);
                }
                return null;
            case 13:
                if (r23 == null || (product2 = r23.getProduct()) == null || (period = product2.getPeriod()) == null) {
                    return null;
                }
                return PeriodExtensionsKt.getRoundedValueInDays(period);
            case 14:
                if (r23 == null || (product3 = r23.getProduct()) == null || (period2 = product3.getPeriod()) == null) {
                    return null;
                }
                return PeriodExtensionsKt.getRoundedValueInWeeks(period2);
            case 15:
                if (r23 == null || (product4 = r23.getProduct()) == null || (period3 = product4.getPeriod()) == null) {
                    return null;
                }
                return PeriodExtensionsKt.getRoundedValueInMonths(period3);
            case 16:
                if (r23 == null || (product5 = r23.getProduct()) == null || (period4 = product5.getPeriod()) == null) {
                    return null;
                }
                return PeriodExtensionsKt.getRoundedValueInYears(period4);
            case 17:
                if (r23 != null) {
                    return PackagePeriodExtensionsKt.productPeriodWithUnit(r23, map);
                }
                return null;
            case 18:
                return PricingPhaseExtensionsKt.resolveOfferPrice(PricingPhaseExtensionsKt.primaryDiscountPhase(subscriptionOption, r23), locale, map, new Function0<String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableProcessorV2.getValue.9
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        Package r0 = r23;
                        if (r0 != null) {
                            VariableProcessor.PackageContext packageContext2 = packageContext;
                            VariableDataProvider variableDataProvider2 = variableDataProvider;
                            Locale locale3 = locale;
                            boolean showZeroDecimalPlacePrices5 = packageContext2 != null ? packageContext2.getShowZeroDecimalPlacePrices() : false;
                            if (variableDataProvider2 != null) {
                                return variableDataProvider2.localizedPrice(r0, locale3, showZeroDecimalPlacePrices5);
                            }
                        }
                        return null;
                    }
                });
            case 19:
                PricingPhase pricingPhasePrimaryDiscountPhase = PricingPhaseExtensionsKt.primaryDiscountPhase(subscriptionOption, r23);
                if (pricingPhasePrimaryDiscountPhase != null && (strProductOfferPricePerDay = PricingPhaseExtensionsKt.productOfferPricePerDay(pricingPhasePrimaryDiscountPhase, locale, map)) != null) {
                    return strProductOfferPricePerDay;
                }
                if (r23 != null) {
                    boolean showZeroDecimalPlacePrices5 = packageContext != null ? packageContext.getShowZeroDecimalPlacePrices() : false;
                    if (variableDataProvider != null) {
                        return variableDataProvider.localizedPricePerDay(r23, locale, showZeroDecimalPlacePrices5);
                    }
                }
                return null;
            case 20:
                PricingPhase pricingPhasePrimaryDiscountPhase2 = PricingPhaseExtensionsKt.primaryDiscountPhase(subscriptionOption, r23);
                if (pricingPhasePrimaryDiscountPhase2 != null && (strProductOfferPricePerWeek = PricingPhaseExtensionsKt.productOfferPricePerWeek(pricingPhasePrimaryDiscountPhase2, locale, map)) != null) {
                    return strProductOfferPricePerWeek;
                }
                if (r23 != null) {
                    boolean showZeroDecimalPlacePrices6 = packageContext != null ? packageContext.getShowZeroDecimalPlacePrices() : false;
                    if (variableDataProvider != null) {
                        return variableDataProvider.localizedPricePerWeek(r23, locale, showZeroDecimalPlacePrices6);
                    }
                }
                return null;
            case 21:
                PricingPhase pricingPhasePrimaryDiscountPhase3 = PricingPhaseExtensionsKt.primaryDiscountPhase(subscriptionOption, r23);
                if (pricingPhasePrimaryDiscountPhase3 != null && (strProductOfferPricePerMonth = PricingPhaseExtensionsKt.productOfferPricePerMonth(pricingPhasePrimaryDiscountPhase3, locale, map)) != null) {
                    return strProductOfferPricePerMonth;
                }
                if (r23 != null) {
                    boolean showZeroDecimalPlacePrices7 = packageContext != null ? packageContext.getShowZeroDecimalPlacePrices() : false;
                    if (variableDataProvider != null) {
                        return variableDataProvider.localizedPricePerMonth(r23, locale, showZeroDecimalPlacePrices7);
                    }
                }
                return null;
            case 22:
                PricingPhase pricingPhasePrimaryDiscountPhase4 = PricingPhaseExtensionsKt.primaryDiscountPhase(subscriptionOption, r23);
                if (pricingPhasePrimaryDiscountPhase4 != null && (strProductOfferPricePerYear = PricingPhaseExtensionsKt.productOfferPricePerYear(pricingPhasePrimaryDiscountPhase4, locale, map)) != null) {
                    return strProductOfferPricePerYear;
                }
                if (r23 != null) {
                    boolean showZeroDecimalPlacePrices8 = packageContext != null ? packageContext.getShowZeroDecimalPlacePrices() : false;
                    if (variableDataProvider != null) {
                        return variableDataProvider.localizedPricePerYear(r23, locale, showZeroDecimalPlacePrices8);
                    }
                }
                return null;
            case 23:
                return PricingPhaseExtensionsKt.resolveOfferPeriod(PricingPhaseExtensionsKt.primaryDiscountPhase(subscriptionOption, r23), new Function1<PricingPhase, String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableProcessorV2.getValue.14
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final String invoke(PricingPhase it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return PricingPhaseExtensionsKt.productOfferPeriod(it, map);
                    }
                }, new Function0<String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableProcessorV2.getValue.15
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        Package r0 = r23;
                        if (r0 != null) {
                            return PackagePeriodExtensionsKt.productPeriod(r0, map);
                        }
                        return null;
                    }
                });
            case 24:
                return PricingPhaseExtensionsKt.resolveOfferPeriod(PricingPhaseExtensionsKt.primaryDiscountPhase(subscriptionOption, r23), new Function1<PricingPhase, String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableProcessorV2.getValue.16
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final String invoke(PricingPhase it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return PricingPhaseExtensionsKt.productOfferPeriodAbbreviated(it, map);
                    }
                }, new Function0<String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableProcessorV2.getValue.17
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        Package r0 = r23;
                        if (r0 != null) {
                            return PackagePeriodExtensionsKt.productPeriodAbbreviated(r0, map);
                        }
                        return null;
                    }
                });
            case 25:
                PricingPhase pricingPhasePrimaryDiscountPhase5 = PricingPhaseExtensionsKt.primaryDiscountPhase(subscriptionOption, r23);
                if (pricingPhasePrimaryDiscountPhase5 != null && (productOfferPeriodInDays = PricingPhaseExtensionsKt.getProductOfferPeriodInDays(pricingPhasePrimaryDiscountPhase5)) != null) {
                    return productOfferPeriodInDays;
                }
                if (r23 == null || (product6 = r23.getProduct()) == null || (period5 = product6.getPeriod()) == null) {
                    return null;
                }
                return PeriodExtensionsKt.getRoundedValueInDays(period5);
            case 26:
                PricingPhase pricingPhasePrimaryDiscountPhase6 = PricingPhaseExtensionsKt.primaryDiscountPhase(subscriptionOption, r23);
                if (pricingPhasePrimaryDiscountPhase6 != null && (productOfferPeriodInWeeks = PricingPhaseExtensionsKt.getProductOfferPeriodInWeeks(pricingPhasePrimaryDiscountPhase6)) != null) {
                    return productOfferPeriodInWeeks;
                }
                if (r23 == null || (product7 = r23.getProduct()) == null || (period6 = product7.getPeriod()) == null) {
                    return null;
                }
                return PeriodExtensionsKt.getRoundedValueInWeeks(period6);
            case 27:
                PricingPhase pricingPhasePrimaryDiscountPhase7 = PricingPhaseExtensionsKt.primaryDiscountPhase(subscriptionOption, r23);
                if (pricingPhasePrimaryDiscountPhase7 != null && (productOfferPeriodInMonths = PricingPhaseExtensionsKt.getProductOfferPeriodInMonths(pricingPhasePrimaryDiscountPhase7)) != null) {
                    return productOfferPeriodInMonths;
                }
                if (r23 == null || (product8 = r23.getProduct()) == null || (period7 = product8.getPeriod()) == null) {
                    return null;
                }
                return PeriodExtensionsKt.getRoundedValueInMonths(period7);
            case 28:
                PricingPhase pricingPhasePrimaryDiscountPhase8 = PricingPhaseExtensionsKt.primaryDiscountPhase(subscriptionOption, r23);
                if (pricingPhasePrimaryDiscountPhase8 != null && (productOfferPeriodInYears = PricingPhaseExtensionsKt.getProductOfferPeriodInYears(pricingPhasePrimaryDiscountPhase8)) != null) {
                    return productOfferPeriodInYears;
                }
                if (r23 == null || (product9 = r23.getProduct()) == null || (period8 = product9.getPeriod()) == null) {
                    return null;
                }
                return PeriodExtensionsKt.getRoundedValueInYears(period8);
            case 29:
                PricingPhase pricingPhasePrimaryDiscountPhase9 = PricingPhaseExtensionsKt.primaryDiscountPhase(subscriptionOption, r23);
                if (pricingPhasePrimaryDiscountPhase9 != null && (strProductOfferPeriodWithUnit = PricingPhaseExtensionsKt.productOfferPeriodWithUnit(pricingPhasePrimaryDiscountPhase9, map)) != null) {
                    return strProductOfferPeriodWithUnit;
                }
                if (r23 != null) {
                    return PackagePeriodExtensionsKt.productPeriodWithUnit(r23, map);
                }
                return null;
            case 30:
                PricingPhase pricingPhasePrimaryDiscountPhase10 = PricingPhaseExtensionsKt.primaryDiscountPhase(subscriptionOption, r23);
                if (pricingPhasePrimaryDiscountPhase10 != null) {
                    return PricingPhaseExtensionsKt.productOfferEndDate(pricingPhasePrimaryDiscountPhase10, locale2, date);
                }
                return null;
            case 31:
                return PricingPhaseExtensionsKt.resolveOfferPrice(PricingPhaseExtensionsKt.secondaryDiscountPhase(subscriptionOption, r23), locale, map, new Function0<String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableProcessorV2.getValue.18
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        Package r0 = r23;
                        if (r0 != null) {
                            VariableProcessor.PackageContext packageContext2 = packageContext;
                            VariableDataProvider variableDataProvider2 = variableDataProvider;
                            Locale locale3 = locale;
                            boolean showZeroDecimalPlacePrices9 = packageContext2 != null ? packageContext2.getShowZeroDecimalPlacePrices() : false;
                            if (variableDataProvider2 != null) {
                                return variableDataProvider2.localizedPrice(r0, locale3, showZeroDecimalPlacePrices9);
                            }
                        }
                        return null;
                    }
                });
            case 32:
                return PricingPhaseExtensionsKt.resolveOfferPeriod(PricingPhaseExtensionsKt.secondaryDiscountPhase(subscriptionOption, r23), new Function1<PricingPhase, String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableProcessorV2.getValue.19
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final String invoke(PricingPhase it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return PricingPhaseExtensionsKt.productOfferPeriod(it, map);
                    }
                }, new Function0<String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableProcessorV2.getValue.20
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        Package r0 = r23;
                        if (r0 != null) {
                            return PackagePeriodExtensionsKt.productPeriod(r0, map);
                        }
                        return null;
                    }
                });
            case 33:
                return PricingPhaseExtensionsKt.resolveOfferPeriod(PricingPhaseExtensionsKt.secondaryDiscountPhase(subscriptionOption, r23), new Function1<PricingPhase, String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableProcessorV2.getValue.21
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final String invoke(PricingPhase it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return PricingPhaseExtensionsKt.productOfferPeriodAbbreviated(it, map);
                    }
                }, new Function0<String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableProcessorV2.getValue.22
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        Package r0 = r23;
                        if (r0 != null) {
                            return PackagePeriodExtensionsKt.productPeriodAbbreviated(r0, map);
                        }
                        return null;
                    }
                });
            case 34:
                if (packageContext != null) {
                    return relativeDiscount(packageContext, map);
                }
                return null;
            case 35:
                if (r23 == null || (product10 = r23.getProduct()) == null) {
                    return null;
                }
                return product10.getName();
            case 36:
                if (countdownTime != null) {
                    int i = WhenMappings.$EnumSwitchMapping$0[countFrom.ordinal()];
                    if (i == 1) {
                        days2 = countdownTime.getDays();
                    } else if (i != 2 && i != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String str = String.format(locale2, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(days2)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    if (str != null) {
                        return str;
                    }
                }
                return "";
            case 37:
                if (countdownTime != null) {
                    int i2 = WhenMappings.$EnumSwitchMapping$0[countFrom.ordinal()];
                    if (i2 == 1) {
                        days = countdownTime.getDays();
                    } else if (i2 != 2 && i2 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                    String str2 = String.format(locale2, TimeModel.NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(days)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                    if (str2 != null) {
                        return str2;
                    }
                }
                return "";
            case 38:
                if (countdownTime != null) {
                    int i3 = WhenMappings.$EnumSwitchMapping$0[countFrom.ordinal()];
                    if (i3 == 1) {
                        hours2 = countdownTime.getHours();
                    } else if (i3 == 2) {
                        hours2 = countdownTime.getTotalHours();
                    } else if (i3 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                    String str3 = String.format(locale2, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(hours2)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    if (str3 != null) {
                        return str3;
                    }
                }
                return "";
            case 39:
                if (countdownTime != null) {
                    int i4 = WhenMappings.$EnumSwitchMapping$0[countFrom.ordinal()];
                    if (i4 == 1) {
                        hours = countdownTime.getHours();
                    } else if (i4 == 2) {
                        hours = countdownTime.getTotalHours();
                    } else if (i4 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
                    String str4 = String.format(locale2, TimeModel.NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(hours)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                    if (str4 != null) {
                        return str4;
                    }
                }
                return "";
            case 40:
                if (countdownTime != null) {
                    int i5 = WhenMappings.$EnumSwitchMapping$0[countFrom.ordinal()];
                    if (i5 == 1 || i5 == 2) {
                        minutes = countdownTime.getMinutes();
                    } else {
                        if (i5 != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        minutes = countdownTime.getTotalMinutes();
                    }
                    StringCompanionObject stringCompanionObject5 = StringCompanionObject.INSTANCE;
                    String str5 = String.format(locale2, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(minutes)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                    if (str5 != null) {
                        return str5;
                    }
                }
                return "";
            case 41:
                if (countdownTime != null) {
                    int i6 = WhenMappings.$EnumSwitchMapping$0[countFrom.ordinal()];
                    if (i6 == 1 || i6 == 2) {
                        minutes2 = countdownTime.getMinutes();
                    } else {
                        if (i6 != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        minutes2 = countdownTime.getTotalMinutes();
                    }
                    StringCompanionObject stringCompanionObject6 = StringCompanionObject.INSTANCE;
                    String str6 = String.format(locale2, TimeModel.NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(minutes2)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                    if (str6 != null) {
                        return str6;
                    }
                }
                return "";
            case 42:
                if (countdownTime != null) {
                    int seconds = countdownTime.getSeconds();
                    StringCompanionObject stringCompanionObject7 = StringCompanionObject.INSTANCE;
                    String str7 = String.format(locale2, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(seconds)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                    if (str7 != null) {
                        return str7;
                    }
                }
                return "";
            case 43:
                if (countdownTime != null) {
                    int seconds2 = countdownTime.getSeconds();
                    StringCompanionObject stringCompanionObject8 = StringCompanionObject.INSTANCE;
                    String str8 = String.format(locale2, TimeModel.NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(seconds2)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str8, "format(...)");
                    if (str8 != null) {
                        return str8;
                    }
                }
                return "";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getVariableValue(String variableIdentifier, List<String> functionIdentifiers, Map<VariableLocalizationKey, String> localizedVariableKeys, UiConfig.VariableConfig variableConfig, VariableDataProvider variableDataProvider, VariableProcessor.PackageContext packageContext, Package rcPackage, SubscriptionOption subscriptionOption, Locale currencyLocale, Locale dateLocale, Date date, CountdownTime countdownTime, CountdownComponent.CountFrom countFrom, Map<String, ? extends CustomVariableValue> customVariables, Map<String, ? extends CustomVariableValue> defaultCustomVariables) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = functionIdentifiers.iterator();
        while (it.hasNext()) {
            Function functionFindFunction = INSTANCE.findFunction((String) it.next(), variableConfig.getFunctionCompatibilityMap());
            if (functionFindFunction != null) {
                arrayList.add(functionFindFunction);
            }
        }
        ArrayList arrayList2 = arrayList;
        String strExtractCustomVariableKey = extractCustomVariableKey(variableIdentifier);
        if (strExtractCustomVariableKey != null) {
            return resolveCustomVariable(strExtractCustomVariableKey, customVariables, defaultCustomVariables, arrayList2, currencyLocale);
        }
        Variable variableFindVariable = findVariable(variableIdentifier, variableConfig.getVariableCompatibilityMap());
        if (variableFindVariable == null) {
            return "";
        }
        String value = getValue(variableFindVariable, localizedVariableKeys, variableDataProvider, packageContext, rcPackage, subscriptionOption, currencyLocale, dateLocale, date, countdownTime, countFrom);
        if (value != null) {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                value = INSTANCE.processFunction(value, (Function) it2.next(), currencyLocale);
            }
        } else {
            value = null;
        }
        if (value != null) {
            return value;
        }
        if (rcPackage != null) {
            failedToGetValue(Logger.INSTANCE, variableIdentifier, rcPackage);
        }
        return "";
    }

    private final String processFunction(String str, Function function, Locale locale) {
        int i = WhenMappings.$EnumSwitchMapping$2[function.ordinal()];
        if (i == 1) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            return lowerCase;
        }
        if (i == 2) {
            String upperCase = str.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            return upperCase;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        if (str.length() <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char cCharAt = str.charAt(0);
        StringBuilder sbAppend = sb.append((Object) (Character.isLowerCase(cCharAt) ? CharsKt.titlecase(cCharAt, locale) : String.valueOf(cCharAt)));
        String strSubstring = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return sbAppend.append(strSubstring).toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String processVariables$default(VariableProcessorV2 variableProcessorV2, String str, Map map, UiConfig.VariableConfig variableConfig, VariableDataProvider variableDataProvider, VariableProcessor.PackageContext packageContext, Package r23, SubscriptionOption subscriptionOption, Locale locale, Locale locale2, Date date, CountdownTime countdownTime, CountdownComponent.CountFrom countFrom, Map map2, Map map3, int i, Object obj) {
        Locale locale3;
        Map mapEmptyMap = (i & 2) != 0 ? MapsKt.emptyMap() : map;
        VariableDataProvider variableDataProvider2 = (i & 8) != 0 ? null : variableDataProvider;
        VariableProcessor.PackageContext packageContext2 = (i & 16) != 0 ? null : packageContext;
        Package r8 = (i & 32) != 0 ? null : r23;
        SubscriptionOption subscriptionOption2 = (i & 64) != 0 ? null : subscriptionOption;
        if ((i & 128) != 0) {
            Locale locale4 = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale4, "getDefault()");
            locale3 = locale4;
        } else {
            locale3 = locale;
        }
        return variableProcessorV2.processVariables(str, mapEmptyMap, variableConfig, variableDataProvider2, packageContext2, r8, subscriptionOption2, locale3, locale2, (i & 512) != 0 ? new Date() : date, (i & 1024) != 0 ? null : countdownTime, (i & 2048) != 0 ? CountdownComponent.CountFrom.DAYS : countFrom, (i & 4096) != 0 ? MapsKt.emptyMap() : map2, (i & 8192) != 0 ? MapsKt.emptyMap() : map3);
    }

    private final String relativeDiscount(VariableProcessor.PackageContext packageContext, Map<VariableLocalizationKey, String> map) {
        Double discountRelativeToMostExpensivePerMonth = packageContext.getDiscountRelativeToMostExpensivePerMonth();
        if (discountRelativeToMostExpensivePerMonth != null) {
            int iRoundToInt = MathKt.roundToInt(discountRelativeToMostExpensivePerMonth.doubleValue() * 100.0d);
            String stringOrLogError = PackagePeriodExtensionsKt.getStringOrLogError(map, VariableLocalizationKey.PERCENT);
            if (stringOrLogError != null) {
                String str = String.format(stringOrLogError, Arrays.copyOf(new Object[]{Integer.valueOf(iRoundToInt)}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                return str;
            }
        }
        return null;
    }

    private final String replaceVariablesWithValues(String str, Function2<? super String, ? super List<String>, String> function2) {
        StringBuilder sb = new StringBuilder();
        String str2 = str;
        int last = 0;
        for (MatchResult matchResult : Regex.findAll$default(regex, str2, 0, 2, null)) {
            sb.append((CharSequence) str2, last, matchResult.getRange().getFirst());
            List listSplit$default = StringsKt.split$default((CharSequence) matchResult.getDestructured().getMatch().getGroupValues().get(1), new String[]{"|"}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit$default, 10));
            Iterator it = listSplit$default.iterator();
            while (it.hasNext()) {
                arrayList.add(StringsKt.trim((CharSequence) it.next()).toString());
            }
            ArrayList arrayList2 = arrayList;
            sb.append(function2.invoke((String) arrayList2.get(0), arrayList2.size() > 1 ? CollectionsKt.drop(arrayList2, 1) : CollectionsKt.emptyList()));
            last = matchResult.getRange().getLast() + 1;
        }
        sb.append((CharSequence) str2, last, str.length());
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private final String resolveCustomVariable(String key, Map<String, ? extends CustomVariableValue> customVariables, Map<String, ? extends CustomVariableValue> defaultCustomVariables, List<? extends Function> functions, Locale currencyLocale) {
        CustomVariableValue customVariableValue = customVariables.get(key);
        if (customVariableValue == null && (customVariableValue = defaultCustomVariables.get(key)) == null) {
            Logger.INSTANCE.w("Custom variable '" + key + "' was not provided and has no default value. Defaulting to empty string.");
            return "";
        }
        String stringValue = customVariableValue.getStringValue();
        Iterator<T> it = functions.iterator();
        while (it.hasNext()) {
            stringValue = INSTANCE.processFunction(stringValue, (Function) it.next(), currencyLocale);
        }
        return stringValue;
    }

    private final void unsupportedFunctionWithoutFallback(Logger logger, String str) {
        logger.e("Paywall function '" + str + "' is not supported and no backwards compatible replacement found.");
    }

    private final void unsupportedVariableWithoutFallback(Logger logger, String str) {
        logger.e("Paywall variable '" + str + "' is not supported and no backwards compatible replacement found.");
    }

    private final void usingFallbackFunction(Logger logger, String str, String str2) {
        logger.w("Paywall function '" + str + "' is not supported. Using backward compatible '" + str2 + "' instead.");
    }

    private final void usingFallbackVariable(Logger logger, String str, String str2) {
        logger.w("Paywall variable '" + str + "' is not supported. Using backwards compatible '" + str2 + "' instead.");
    }

    public final String processVariables(String template, final Map<VariableLocalizationKey, String> localizedVariableKeys, final UiConfig.VariableConfig variableConfig, final VariableDataProvider variableDataProvider, final VariableProcessor.PackageContext packageContext, final Package rcPackage, final SubscriptionOption subscriptionOption, final Locale currencyLocale, final Locale dateLocale, final Date date, final CountdownTime countdownTime, final CountdownComponent.CountFrom countFrom, final Map<String, ? extends CustomVariableValue> customVariables, final Map<String, ? extends CustomVariableValue> defaultCustomVariables) {
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(localizedVariableKeys, "localizedVariableKeys");
        Intrinsics.checkNotNullParameter(variableConfig, "variableConfig");
        Intrinsics.checkNotNullParameter(currencyLocale, "currencyLocale");
        Intrinsics.checkNotNullParameter(dateLocale, "dateLocale");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(countFrom, "countFrom");
        Intrinsics.checkNotNullParameter(customVariables, "customVariables");
        Intrinsics.checkNotNullParameter(defaultCustomVariables, "defaultCustomVariables");
        return replaceVariablesWithValues(template, new Function2<String, List<? extends String>, String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableProcessorV2.processVariables.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ String invoke(String str, List<? extends String> list) {
                return invoke2(str, (List<String>) list);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final String invoke2(String variable, List<String> functions) {
                Intrinsics.checkNotNullParameter(variable, "variable");
                Intrinsics.checkNotNullParameter(functions, "functions");
                return VariableProcessorV2.INSTANCE.getVariableValue(variable, functions, localizedVariableKeys, variableConfig, variableDataProvider, packageContext, rcPackage, subscriptionOption, currencyLocale, dateLocale, date, countdownTime, countFrom, customVariables, defaultCustomVariables);
            }
        });
    }
}
