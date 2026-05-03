package com.revenuecat.purchases.common;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.PresentedOfferingContextSerializer;
import com.revenuecat.purchases.ReplacementMode;
import com.revenuecat.purchases.ReplacementModeSerializer;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.PeriodSerializer;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.models.PricingPhaseSerializer;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.models.SubscriptionOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: ReceiptInfo.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 \\2\u00020\u0001:\u0002[\\BØ\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u001d\u0010\u0011\u001a\u0019\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\t0\u0015\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\u001c\u0010\u0018\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0019\u0018\u00010\u0005\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\u0002\u0010!BÈ\u0001\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u001f\b\u0002\u0010\u0011\u001a\u0019\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\t0\u0015\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\u001c\b\u0002\u0010\u0018\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00190\u0005\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\"J\u000f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u001d\u0010A\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00190\u0005HÆ\u0003J\t\u0010B\u001a\u00020\u001bHÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u00108J\u000b\u0010F\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010G\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u00103J\u000b\u0010H\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0010HÆ\u0003J \u0010K\u001a\u0019\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\t0\u0015\u0018\u00010\u0005HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0017HÆ\u0003JÓ\u0001\u0010M\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u001f\b\u0002\u0010\u0011\u001a\u0019\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\t0\u0015\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u001c\b\u0002\u0010\u0018\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00190\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010NJ\u0013\u0010O\u001a\u00020\u001b2\b\u0010P\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010Q\u001a\u00020\u0003HÖ\u0001J\t\u0010R\u001a\u00020\u0006HÖ\u0001J&\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020\u00002\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020YHÁ\u0001¢\u0006\u0002\bZR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u0006¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010&\u001a\u0004\b'\u0010$R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b(\u0010$R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b)\u0010$R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010&\u001a\u0004\b+\u0010,R%\u0010\u0018\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00190\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u001e\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b/\u0010&\u001a\u0004\b0\u00101R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u00104\u001a\u0004\b2\u00103R(\u0010\u0011\u001a\u0019\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\t0\u0015\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010.R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u0010.R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u00109\u001a\u0004\b7\u00108R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b:\u0010&\u001a\u0004\b;\u0010<R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b?\u0010$¨\u0006]"}, d2 = {"Lcom/revenuecat/purchases/common/ReceiptInfo;", "", "seen1", "", "productIDs", "", "", com.facebook.appevents.internal.Constants.GP_IAP_PURCHASE_TIME, "", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", FirebaseAnalytics.Param.PRICE, "", "formattedPrice", FirebaseAnalytics.Param.CURRENCY, TypedValues.CycleType.S_WAVE_PERIOD, "Lcom/revenuecat/purchases/models/Period;", com.facebook.appevents.internal.Constants.GP_IAP_SUBSCRIPTION_PRICING_PHASES, "Lcom/revenuecat/purchases/models/PricingPhase;", "Lkotlinx/serialization/Serializable;", "with", "Lcom/revenuecat/purchases/models/PricingPhaseSerializer;", "replacementMode", "Lcom/revenuecat/purchases/ReplacementMode;", "platformProductIds", "", "sdkOriginated", "", "storeUserID", "marketplace", TypedValues.TransitionType.S_DURATION, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/lang/Long;Lcom/revenuecat/purchases/PresentedOfferingContext;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/models/Period;Ljava/util/List;Lcom/revenuecat/purchases/ReplacementMode;Ljava/util/List;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/List;Ljava/lang/Long;Lcom/revenuecat/purchases/PresentedOfferingContext;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/models/Period;Ljava/util/List;Lcom/revenuecat/purchases/ReplacementMode;Ljava/util/List;ZLjava/lang/String;Ljava/lang/String;)V", "getCurrency", "()Ljava/lang/String;", "getDuration$annotations", "()V", "getDuration", "getFormattedPrice", "getMarketplace", "getPeriod$annotations", "getPeriod", "()Lcom/revenuecat/purchases/models/Period;", "getPlatformProductIds", "()Ljava/util/List;", "getPresentedOfferingContext$annotations", "getPresentedOfferingContext", "()Lcom/revenuecat/purchases/PresentedOfferingContext;", "getPrice", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getPricingPhases", "getProductIDs", "getPurchaseTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getReplacementMode$annotations", "getReplacementMode", "()Lcom/revenuecat/purchases/ReplacementMode;", "getSdkOriginated", "()Z", "getStoreUserID", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/util/List;Ljava/lang/Long;Lcom/revenuecat/purchases/PresentedOfferingContext;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/models/Period;Ljava/util/List;Lcom/revenuecat/purchases/ReplacementMode;Ljava/util/List;ZLjava/lang/String;Ljava/lang/String;)Lcom/revenuecat/purchases/common/ReceiptInfo;", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Serializable
public final /* data */ class ReceiptInfo {
    private final String currency;
    private final String duration;
    private final String formattedPrice;
    private final String marketplace;
    private final Period period;
    private final List<Map<String, String>> platformProductIds;
    private final PresentedOfferingContext presentedOfferingContext;
    private final Double price;
    private final List<PricingPhase> pricingPhases;
    private final List<String> productIDs;
    private final Long purchaseTime;
    private final ReplacementMode replacementMode;
    private final boolean sdkOriginated;
    private final String storeUserID;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(StringSerializer.INSTANCE), null, null, null, null, null, null, new ArrayListSerializer(PricingPhaseSerializer.INSTANCE), null, new ArrayListSerializer(new LinkedHashMapSerializer(StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE))), null, null, null, null};

    /* JADX INFO: compiled from: ReceiptInfo.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\u000eJ\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010HÆ\u0001¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/common/ReceiptInfo$Companion;", "", "()V", "from", "Lcom/revenuecat/purchases/common/ReceiptInfo;", "storeTransaction", "Lcom/revenuecat/purchases/models/StoreTransaction;", "storeProduct", "Lcom/revenuecat/purchases/models/StoreProduct;", "subscriptionOptionsForProductIDs", "", "", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "sdkOriginated", "", "serializer", "Lkotlinx/serialization/KSerializer;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ReceiptInfo from$default(Companion companion, StoreTransaction storeTransaction, StoreProduct storeProduct, Map map, boolean z, int i, Object obj) {
            if ((i & 8) != 0) {
                z = false;
            }
            return companion.from(storeTransaction, storeProduct, map, z);
        }

        public final ReceiptInfo from(StoreTransaction storeTransaction, StoreProduct storeProduct, Map<String, ? extends SubscriptionOption> subscriptionOptionsForProductIDs, boolean sdkOriginated) {
            SubscriptionOption subscriptionOption;
            PlatformProductId platformProductId;
            Price price;
            Price price2;
            Price price3;
            SubscriptionOption subscriptionOption2;
            PlatformProductId platformProductId2;
            Map<String, String> asMap;
            SubscriptionOptions subscriptionOptions;
            SubscriptionOption next;
            Intrinsics.checkNotNullParameter(storeTransaction, "storeTransaction");
            if (storeProduct == null || (subscriptionOptions = storeProduct.getSubscriptionOptions()) == null) {
                subscriptionOption = null;
            } else {
                Iterator<SubscriptionOption> it = subscriptionOptions.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (Intrinsics.areEqual(next.get$id(), storeTransaction.getSubscriptionOptionId())) {
                        break;
                    }
                }
                subscriptionOption = next;
            }
            if (subscriptionOption == null || (platformProductId = ReceiptInfoKt.platformProductId(subscriptionOption)) == null) {
                platformProductId = storeProduct != null ? ReceiptInfoKt.platformProductId(storeProduct) : null;
            }
            List<String> productIds = storeTransaction.getProductIds();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(productIds, 10));
            for (String str : productIds) {
                arrayList.add(Intrinsics.areEqual(str, platformProductId != null ? platformProductId.getProductId() : null) ? platformProductId.getAsMap() : (subscriptionOptionsForProductIDs == null || (subscriptionOption2 = subscriptionOptionsForProductIDs.get(str)) == null || (platformProductId2 = ReceiptInfoKt.platformProductId(subscriptionOption2)) == null || (asMap = platformProductId2.getAsMap()) == null) ? new PlatformProductId(str).getAsMap() : asMap);
            }
            return new ReceiptInfo(storeTransaction.getProductIds(), Long.valueOf(storeTransaction.getPurchaseTime()), storeTransaction.getPresentedOfferingContext(), (storeProduct == null || (price3 = storeProduct.getPrice()) == null) ? null : Double.valueOf(price3.getAmountMicros() / 1000000.0d), (storeProduct == null || (price2 = storeProduct.getPrice()) == null) ? null : price2.getFormatted(), (storeProduct == null || (price = storeProduct.getPrice()) == null) ? null : price.getCurrencyCode(), storeProduct != null ? storeProduct.getPeriod() : null, subscriptionOption != null ? subscriptionOption.getPricingPhases() : null, storeTransaction.getReplacementMode(), arrayList, sdkOriginated, storeTransaction.getStoreUserID(), storeTransaction.getMarketplace());
        }

        public final KSerializer<ReceiptInfo> serializer() {
            return ReceiptInfo$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ ReceiptInfo(int i, List list, Long l, @Serializable(with = PresentedOfferingContextSerializer.class) PresentedOfferingContext presentedOfferingContext, Double d, String str, String str2, @Serializable(with = PeriodSerializer.class) Period period, List list2, @Serializable(with = ReplacementModeSerializer.class) ReplacementMode replacementMode, List list3, boolean z, String str3, String str4, String str5, SerializationConstructorMarker serializationConstructorMarker) {
        String iso8601;
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, ReceiptInfo$$serializer.INSTANCE.getDescriptor());
        }
        this.productIDs = list;
        String str6 = null;
        if ((i & 2) == 0) {
            this.purchaseTime = null;
        } else {
            this.purchaseTime = l;
        }
        if ((i & 4) == 0) {
            this.presentedOfferingContext = null;
        } else {
            this.presentedOfferingContext = presentedOfferingContext;
        }
        if ((i & 8) == 0) {
            this.price = null;
        } else {
            this.price = d;
        }
        if ((i & 16) == 0) {
            this.formattedPrice = null;
        } else {
            this.formattedPrice = str;
        }
        if ((i & 32) == 0) {
            this.currency = null;
        } else {
            this.currency = str2;
        }
        if ((i & 64) == 0) {
            this.period = null;
        } else {
            this.period = period;
        }
        if ((i & 128) == 0) {
            this.pricingPhases = null;
        } else {
            this.pricingPhases = list2;
        }
        if ((i & 256) == 0) {
            this.replacementMode = null;
        } else {
            this.replacementMode = replacementMode;
        }
        if ((i & 512) == 0) {
            this.platformProductIds = CollectionsKt.emptyList();
        } else {
            this.platformProductIds = list3;
        }
        if ((i & 1024) == 0) {
            this.sdkOriginated = false;
        } else {
            this.sdkOriginated = z;
        }
        if ((i & 2048) == 0) {
            this.storeUserID = null;
        } else {
            this.storeUserID = str3;
        }
        if ((i & 4096) == 0) {
            this.marketplace = null;
        } else {
            this.marketplace = str4;
        }
        if ((i & 8192) != 0) {
            this.duration = str5;
            return;
        }
        Period period2 = this.period;
        if (period2 != null && (iso8601 = period2.getIso8601()) != null && iso8601.length() != 0) {
            str6 = iso8601;
        }
        this.duration = str6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ReceiptInfo(List<String> productIDs, Long l, PresentedOfferingContext presentedOfferingContext, Double d, String str, String str2, Period period, List<PricingPhase> list, ReplacementMode replacementMode, List<? extends Map<String, String>> platformProductIds, boolean z, String str3, String str4) {
        String iso8601;
        Intrinsics.checkNotNullParameter(productIDs, "productIDs");
        Intrinsics.checkNotNullParameter(platformProductIds, "platformProductIds");
        this.productIDs = productIDs;
        this.purchaseTime = l;
        this.presentedOfferingContext = presentedOfferingContext;
        this.price = d;
        this.formattedPrice = str;
        this.currency = str2;
        this.period = period;
        this.pricingPhases = list;
        this.replacementMode = replacementMode;
        this.platformProductIds = platformProductIds;
        this.sdkOriginated = z;
        this.storeUserID = str3;
        this.marketplace = str4;
        String str5 = null;
        if (period != null && (iso8601 = period.getIso8601()) != null && iso8601.length() != 0) {
            str5 = iso8601;
        }
        this.duration = str5;
    }

    public /* synthetic */ ReceiptInfo(List list, Long l, PresentedOfferingContext presentedOfferingContext, Double d, String str, String str2, Period period, List list2, ReplacementMode replacementMode, List list3, boolean z, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : presentedOfferingContext, (i & 8) != 0 ? null : d, (i & 16) != 0 ? null : str, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? null : period, (i & 128) != 0 ? null : list2, (i & 256) != 0 ? null : replacementMode, (i & 512) != 0 ? CollectionsKt.emptyList() : list3, (i & 1024) != 0 ? false : z, (i & 2048) != 0 ? null : str3, (i & 4096) != 0 ? null : str4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ReceiptInfo copy$default(ReceiptInfo receiptInfo, List list, Long l, PresentedOfferingContext presentedOfferingContext, Double d, String str, String str2, Period period, List list2, ReplacementMode replacementMode, List list3, boolean z, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            list = receiptInfo.productIDs;
        }
        return receiptInfo.copy(list, (i & 2) != 0 ? receiptInfo.purchaseTime : l, (i & 4) != 0 ? receiptInfo.presentedOfferingContext : presentedOfferingContext, (i & 8) != 0 ? receiptInfo.price : d, (i & 16) != 0 ? receiptInfo.formattedPrice : str, (i & 32) != 0 ? receiptInfo.currency : str2, (i & 64) != 0 ? receiptInfo.period : period, (i & 128) != 0 ? receiptInfo.pricingPhases : list2, (i & 256) != 0 ? receiptInfo.replacementMode : replacementMode, (i & 512) != 0 ? receiptInfo.platformProductIds : list3, (i & 1024) != 0 ? receiptInfo.sdkOriginated : z, (i & 2048) != 0 ? receiptInfo.storeUserID : str3, (i & 4096) != 0 ? receiptInfo.marketplace : str4);
    }

    public static /* synthetic */ void getDuration$annotations() {
    }

    @Serializable(with = PeriodSerializer.class)
    public static /* synthetic */ void getPeriod$annotations() {
    }

    @Serializable(with = PresentedOfferingContextSerializer.class)
    public static /* synthetic */ void getPresentedOfferingContext$annotations() {
    }

    @Serializable(with = ReplacementModeSerializer.class)
    public static /* synthetic */ void getReplacementMode$annotations() {
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(ReceiptInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        String iso8601;
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, kSerializerArr[0], self.productIDs);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.purchaseTime != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, LongSerializer.INSTANCE, self.purchaseTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.presentedOfferingContext != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, PresentedOfferingContextSerializer.INSTANCE, self.presentedOfferingContext);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.price != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, DoubleSerializer.INSTANCE, self.price);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.formattedPrice != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.formattedPrice);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.currency != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.currency);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.period != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, PeriodSerializer.INSTANCE, self.period);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.pricingPhases != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, kSerializerArr[7], self.pricingPhases);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.replacementMode != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, ReplacementModeSerializer.INSTANCE, self.replacementMode);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || !Intrinsics.areEqual(self.platformProductIds, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 9, kSerializerArr[9], self.platformProductIds);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.sdkOriginated) {
            output.encodeBooleanElement(serialDesc, 10, self.sdkOriginated);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.storeUserID != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.storeUserID);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.marketplace != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.marketplace);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 13)) {
            String str = self.duration;
            Period period = self.period;
            String str2 = null;
            if (period != null && (iso8601 = period.getIso8601()) != null && iso8601.length() != 0) {
                str2 = iso8601;
            }
            if (Intrinsics.areEqual(str, str2)) {
                return;
            }
        }
        output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.duration);
    }

    public final List<String> component1() {
        return this.productIDs;
    }

    public final List<Map<String, String>> component10() {
        return this.platformProductIds;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getSdkOriginated() {
        return this.sdkOriginated;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getStoreUserID() {
        return this.storeUserID;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getMarketplace() {
        return this.marketplace;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getPurchaseTime() {
        return this.purchaseTime;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final PresentedOfferingContext getPresentedOfferingContext() {
        return this.presentedOfferingContext;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Double getPrice() {
        return this.price;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getFormattedPrice() {
        return this.formattedPrice;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getCurrency() {
        return this.currency;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Period getPeriod() {
        return this.period;
    }

    public final List<PricingPhase> component8() {
        return this.pricingPhases;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final ReplacementMode getReplacementMode() {
        return this.replacementMode;
    }

    public final ReceiptInfo copy(List<String> productIDs, Long purchaseTime, PresentedOfferingContext presentedOfferingContext, Double price, String formattedPrice, String currency, Period period, List<PricingPhase> pricingPhases, ReplacementMode replacementMode, List<? extends Map<String, String>> platformProductIds, boolean sdkOriginated, String storeUserID, String marketplace) {
        Intrinsics.checkNotNullParameter(productIDs, "productIDs");
        Intrinsics.checkNotNullParameter(platformProductIds, "platformProductIds");
        return new ReceiptInfo(productIDs, purchaseTime, presentedOfferingContext, price, formattedPrice, currency, period, pricingPhases, replacementMode, platformProductIds, sdkOriginated, storeUserID, marketplace);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReceiptInfo)) {
            return false;
        }
        ReceiptInfo receiptInfo = (ReceiptInfo) other;
        return Intrinsics.areEqual(this.productIDs, receiptInfo.productIDs) && Intrinsics.areEqual(this.purchaseTime, receiptInfo.purchaseTime) && Intrinsics.areEqual(this.presentedOfferingContext, receiptInfo.presentedOfferingContext) && Intrinsics.areEqual((Object) this.price, (Object) receiptInfo.price) && Intrinsics.areEqual(this.formattedPrice, receiptInfo.formattedPrice) && Intrinsics.areEqual(this.currency, receiptInfo.currency) && Intrinsics.areEqual(this.period, receiptInfo.period) && Intrinsics.areEqual(this.pricingPhases, receiptInfo.pricingPhases) && Intrinsics.areEqual(this.replacementMode, receiptInfo.replacementMode) && Intrinsics.areEqual(this.platformProductIds, receiptInfo.platformProductIds) && this.sdkOriginated == receiptInfo.sdkOriginated && Intrinsics.areEqual(this.storeUserID, receiptInfo.storeUserID) && Intrinsics.areEqual(this.marketplace, receiptInfo.marketplace);
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final String getFormattedPrice() {
        return this.formattedPrice;
    }

    public final String getMarketplace() {
        return this.marketplace;
    }

    public final Period getPeriod() {
        return this.period;
    }

    public final List<Map<String, String>> getPlatformProductIds() {
        return this.platformProductIds;
    }

    public final PresentedOfferingContext getPresentedOfferingContext() {
        return this.presentedOfferingContext;
    }

    public final Double getPrice() {
        return this.price;
    }

    public final List<PricingPhase> getPricingPhases() {
        return this.pricingPhases;
    }

    public final List<String> getProductIDs() {
        return this.productIDs;
    }

    public final Long getPurchaseTime() {
        return this.purchaseTime;
    }

    public final ReplacementMode getReplacementMode() {
        return this.replacementMode;
    }

    public final boolean getSdkOriginated() {
        return this.sdkOriginated;
    }

    public final String getStoreUserID() {
        return this.storeUserID;
    }

    public int hashCode() {
        int iHashCode = this.productIDs.hashCode() * 31;
        Long l = this.purchaseTime;
        int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
        PresentedOfferingContext presentedOfferingContext = this.presentedOfferingContext;
        int iHashCode3 = (iHashCode2 + (presentedOfferingContext == null ? 0 : presentedOfferingContext.hashCode())) * 31;
        Double d = this.price;
        int iHashCode4 = (iHashCode3 + (d == null ? 0 : d.hashCode())) * 31;
        String str = this.formattedPrice;
        int iHashCode5 = (iHashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.currency;
        int iHashCode6 = (iHashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Period period = this.period;
        int iHashCode7 = (iHashCode6 + (period == null ? 0 : period.hashCode())) * 31;
        List<PricingPhase> list = this.pricingPhases;
        int iHashCode8 = (iHashCode7 + (list == null ? 0 : list.hashCode())) * 31;
        ReplacementMode replacementMode = this.replacementMode;
        int iHashCode9 = (((((iHashCode8 + (replacementMode == null ? 0 : replacementMode.hashCode())) * 31) + this.platformProductIds.hashCode()) * 31) + Boolean.hashCode(this.sdkOriginated)) * 31;
        String str3 = this.storeUserID;
        int iHashCode10 = (iHashCode9 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.marketplace;
        return iHashCode10 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ReceiptInfo(productIDs=");
        sb.append(this.productIDs).append(", purchaseTime=").append(this.purchaseTime).append(", presentedOfferingContext=").append(this.presentedOfferingContext).append(", price=").append(this.price).append(", formattedPrice=").append(this.formattedPrice).append(", currency=").append(this.currency).append(", period=").append(this.period).append(", pricingPhases=").append(this.pricingPhases).append(", replacementMode=").append(this.replacementMode).append(", platformProductIds=").append(this.platformProductIds).append(", sdkOriginated=").append(this.sdkOriginated).append(", storeUserID=");
        sb.append(this.storeUserID).append(", marketplace=").append(this.marketplace).append(')');
        return sb.toString();
    }
}
