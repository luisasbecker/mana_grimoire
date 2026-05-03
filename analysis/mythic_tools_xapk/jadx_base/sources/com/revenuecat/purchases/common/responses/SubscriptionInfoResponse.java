package com.revenuecat.purchases.common.responses;

import com.appsflyer.AppsFlyerProperties;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.OwnershipType;
import com.revenuecat.purchases.PeriodType;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.StoreSerializer;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.utils.serializers.ISO8601DateSerializer;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: SubscriptionInfoResponse.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bB\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0081\b\u0018\u0000 h2\u00020\u0001:\u0003ghiBã\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\u0002\u0010\u001eB¿\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u001fJ\t\u0010I\u001a\u00020\u0005HÆ\u0003J\t\u0010J\u001a\u00020\u0012HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010T\u001a\u00020\tHÆ\u0003J\t\u0010U\u001a\u00020\u000bHÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010Y\u001a\u00020\u0010HÆ\u0003JË\u0001\u0010Z\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0015HÆ\u0001J\u0013\u0010[\u001a\u00020\u000b2\b\u0010\\\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010]\u001a\u00020\u0003HÖ\u0001J\t\u0010^\u001a\u00020\u0015HÖ\u0001J&\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020\u00002\u0006\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020eHÁ\u0001¢\u0006\u0002\bfR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010!\u001a\u0004\b%\u0010#R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010!\u001a\u0004\b'\u0010(R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010!\u001a\u0004\b*\u0010#R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010!\u001a\u0004\b,\u0010#R\u001c\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010!\u001a\u0004\b\n\u0010.R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b/\u0010!\u001a\u0004\b0\u0010(R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b1\u0010!\u001a\u0004\b2\u0010#R\u001c\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b3\u0010!\u001a\u0004\b4\u00105R\u001c\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b6\u0010!\u001a\u0004\b7\u00108R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b9\u0010!\u001a\u0004\b:\u0010;R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b<\u0010!\u001a\u0004\b=\u0010(R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b>\u0010!\u001a\u0004\b?\u0010#R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b@\u0010!\u001a\u0004\bA\u0010#R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bB\u0010!\u001a\u0004\bC\u0010DR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bE\u0010!\u001a\u0004\bF\u0010(R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bG\u0010!\u001a\u0004\bH\u0010#¨\u0006j"}, d2 = {"Lcom/revenuecat/purchases/common/responses/SubscriptionInfoResponse;", "", "seen1", "", "purchaseDate", "Ljava/util/Date;", "originalPurchaseDate", "expiresDate", ProductResponseJsonKeys.STORE, "Lcom/revenuecat/purchases/Store;", "isSandbox", "", "unsubscribeDetectedAt", "billingIssuesDetectedAt", "gracePeriodExpiresDate", "ownershipType", "Lcom/revenuecat/purchases/OwnershipType;", "periodType", "Lcom/revenuecat/purchases/PeriodType;", "refundedAt", "storeTransactionId", "", "autoResumeDate", "displayName", FirebaseAnalytics.Param.PRICE, "Lcom/revenuecat/purchases/common/responses/SubscriptionInfoResponse$PriceResponse;", "productPlanIdentifier", "managementURL", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/Date;Ljava/util/Date;Ljava/util/Date;Lcom/revenuecat/purchases/Store;ZLjava/util/Date;Ljava/util/Date;Ljava/util/Date;Lcom/revenuecat/purchases/OwnershipType;Lcom/revenuecat/purchases/PeriodType;Ljava/util/Date;Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Lcom/revenuecat/purchases/common/responses/SubscriptionInfoResponse$PriceResponse;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Lcom/revenuecat/purchases/Store;ZLjava/util/Date;Ljava/util/Date;Ljava/util/Date;Lcom/revenuecat/purchases/OwnershipType;Lcom/revenuecat/purchases/PeriodType;Ljava/util/Date;Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Lcom/revenuecat/purchases/common/responses/SubscriptionInfoResponse$PriceResponse;Ljava/lang/String;Ljava/lang/String;)V", "getAutoResumeDate$annotations", "()V", "getAutoResumeDate", "()Ljava/util/Date;", "getBillingIssuesDetectedAt$annotations", "getBillingIssuesDetectedAt", "getDisplayName$annotations", "getDisplayName", "()Ljava/lang/String;", "getExpiresDate$annotations", "getExpiresDate", "getGracePeriodExpiresDate$annotations", "getGracePeriodExpiresDate", "isSandbox$annotations", "()Z", "getManagementURL$annotations", "getManagementURL", "getOriginalPurchaseDate$annotations", "getOriginalPurchaseDate", "getOwnershipType$annotations", "getOwnershipType", "()Lcom/revenuecat/purchases/OwnershipType;", "getPeriodType$annotations", "getPeriodType", "()Lcom/revenuecat/purchases/PeriodType;", "getPrice$annotations", "getPrice", "()Lcom/revenuecat/purchases/common/responses/SubscriptionInfoResponse$PriceResponse;", "getProductPlanIdentifier$annotations", "getProductPlanIdentifier", "getPurchaseDate$annotations", "getPurchaseDate", "getRefundedAt$annotations", "getRefundedAt", "getStore$annotations", "getStore", "()Lcom/revenuecat/purchases/Store;", "getStoreTransactionId$annotations", "getStoreTransactionId", "getUnsubscribeDetectedAt$annotations", "getUnsubscribeDetectedAt", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "PriceResponse", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Serializable
public final /* data */ class SubscriptionInfoResponse {
    private final Date autoResumeDate;
    private final Date billingIssuesDetectedAt;
    private final String displayName;
    private final Date expiresDate;
    private final Date gracePeriodExpiresDate;
    private final boolean isSandbox;
    private final String managementURL;
    private final Date originalPurchaseDate;
    private final OwnershipType ownershipType;
    private final PeriodType periodType;
    private final PriceResponse price;
    private final String productPlanIdentifier;
    private final Date purchaseDate;
    private final Date refundedAt;
    private final Store store;
    private final String storeTransactionId;
    private final Date unsubscribeDetectedAt;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, null, null, OwnershipType.INSTANCE.serializer(), PeriodType.INSTANCE.serializer(), null, null, null, null, null, null, null};

    /* JADX INFO: compiled from: SubscriptionInfoResponse.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/common/responses/SubscriptionInfoResponse$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/responses/SubscriptionInfoResponse;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<SubscriptionInfoResponse> serializer() {
            return SubscriptionInfoResponse$$serializer.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: SubscriptionInfoResponse.kt */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 (2\u00020\u0001:\u0002'(B/\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\u001d\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001J&\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%HÁ\u0001¢\u0006\u0002\b&R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0012¨\u0006)"}, d2 = {"Lcom/revenuecat/purchases/common/responses/SubscriptionInfoResponse$PriceResponse;", "", "seen1", "", "amount", "", AppsFlyerProperties.CURRENCY_CODE, "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IDLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(DLjava/lang/String;)V", "getAmount$annotations", "()V", "getAmount", "()D", "getCurrencyCode$annotations", "getCurrencyCode", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toPrice", "Lcom/revenuecat/purchases/models/Price;", AndroidContextPlugin.LOCALE_KEY, "Ljava/util/Locale;", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Serializable
    public static final /* data */ class PriceResponse {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final double amount;
        private final String currencyCode;

        /* JADX INFO: compiled from: SubscriptionInfoResponse.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/common/responses/SubscriptionInfoResponse$PriceResponse$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/responses/SubscriptionInfoResponse$PriceResponse;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<PriceResponse> serializer() {
                return SubscriptionInfoResponse$PriceResponse$$serializer.INSTANCE;
            }
        }

        public PriceResponse(double d, String currencyCode) {
            Intrinsics.checkNotNullParameter(currencyCode, "currencyCode");
            this.amount = d;
            this.currencyCode = currencyCode;
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ PriceResponse(int i, @SerialName("amount") double d, @SerialName(FirebaseAnalytics.Param.CURRENCY) String str, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i, 3, SubscriptionInfoResponse$PriceResponse$$serializer.INSTANCE.getDescriptor());
            }
            this.amount = d;
            this.currencyCode = str;
        }

        public static /* synthetic */ PriceResponse copy$default(PriceResponse priceResponse, double d, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                d = priceResponse.amount;
            }
            if ((i & 2) != 0) {
                str = priceResponse.currencyCode;
            }
            return priceResponse.copy(d, str);
        }

        @SerialName("amount")
        public static /* synthetic */ void getAmount$annotations() {
        }

        @SerialName(FirebaseAnalytics.Param.CURRENCY)
        public static /* synthetic */ void getCurrencyCode$annotations() {
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PriceResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeDoubleElement(serialDesc, 0, self.amount);
            output.encodeStringElement(serialDesc, 1, self.currencyCode);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final double getAmount() {
            return this.amount;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getCurrencyCode() {
            return this.currencyCode;
        }

        public final PriceResponse copy(double amount, String currencyCode) {
            Intrinsics.checkNotNullParameter(currencyCode, "currencyCode");
            return new PriceResponse(amount, currencyCode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PriceResponse)) {
                return false;
            }
            PriceResponse priceResponse = (PriceResponse) other;
            return Double.compare(this.amount, priceResponse.amount) == 0 && Intrinsics.areEqual(this.currencyCode, priceResponse.currencyCode);
        }

        public final double getAmount() {
            return this.amount;
        }

        public final String getCurrencyCode() {
            return this.currencyCode;
        }

        public int hashCode() {
            return (Double.hashCode(this.amount) * 31) + this.currencyCode.hashCode();
        }

        public final /* synthetic */ Price toPrice(Locale locale) {
            Intrinsics.checkNotNullParameter(locale, "locale");
            NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(locale);
            currencyInstance.setCurrency(Currency.getInstance(this.currencyCode));
            String formatted = currencyInstance.format(this.amount);
            Intrinsics.checkNotNullExpressionValue(formatted, "formatted");
            return new Price(formatted, (long) (this.amount * 1000000.0d), this.currencyCode);
        }

        public String toString() {
            return "PriceResponse(amount=" + this.amount + ", currencyCode=" + this.currencyCode + ')';
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ SubscriptionInfoResponse(int i, @SerialName("purchase_date") @Serializable(with = ISO8601DateSerializer.class) Date date, @SerialName("original_purchase_date") @Serializable(with = ISO8601DateSerializer.class) Date date2, @SerialName("expires_date") @Serializable(with = ISO8601DateSerializer.class) Date date3, @SerialName(ProductResponseJsonKeys.STORE) Store store, @SerialName(ProductResponseJsonKeys.IS_SANDBOX) boolean z, @SerialName(ProductResponseJsonKeys.UNSUBSCRIBE_DETECTED_AT) @Serializable(with = ISO8601DateSerializer.class) Date date4, @SerialName(ProductResponseJsonKeys.BILLING_ISSUES_DETECTED_AT) @Serializable(with = ISO8601DateSerializer.class) Date date5, @SerialName("grace_period_expires_date") @Serializable(with = ISO8601DateSerializer.class) Date date6, @SerialName(ProductResponseJsonKeys.OWNERSHIP_TYPE) OwnershipType ownershipType, @SerialName(ProductResponseJsonKeys.PERIOD_TYPE) PeriodType periodType, @SerialName("refunded_at") @Serializable(with = ISO8601DateSerializer.class) Date date7, @SerialName("store_transaction_id") String str, @SerialName("auto_resume_date") @Serializable(with = ISO8601DateSerializer.class) Date date8, @SerialName("display_name") String str2, @SerialName(FirebaseAnalytics.Param.PRICE) PriceResponse priceResponse, @SerialName("product_plan_identifier") String str3, @SerialName("management_url") String str4, SerializationConstructorMarker serializationConstructorMarker) {
        if (537 != (i & Videoio.CAP_PROP_XI_COUNTER_VALUE)) {
            PluginExceptionsKt.throwMissingFieldException(i, Videoio.CAP_PROP_XI_COUNTER_VALUE, SubscriptionInfoResponse$$serializer.INSTANCE.getDescriptor());
        }
        this.purchaseDate = date;
        if ((i & 2) == 0) {
            this.originalPurchaseDate = null;
        } else {
            this.originalPurchaseDate = date2;
        }
        if ((i & 4) == 0) {
            this.expiresDate = null;
        } else {
            this.expiresDate = date3;
        }
        this.store = store;
        this.isSandbox = z;
        if ((i & 32) == 0) {
            this.unsubscribeDetectedAt = null;
        } else {
            this.unsubscribeDetectedAt = date4;
        }
        if ((i & 64) == 0) {
            this.billingIssuesDetectedAt = null;
        } else {
            this.billingIssuesDetectedAt = date5;
        }
        if ((i & 128) == 0) {
            this.gracePeriodExpiresDate = null;
        } else {
            this.gracePeriodExpiresDate = date6;
        }
        if ((i & 256) == 0) {
            this.ownershipType = OwnershipType.UNKNOWN;
        } else {
            this.ownershipType = ownershipType;
        }
        this.periodType = periodType;
        if ((i & 1024) == 0) {
            this.refundedAt = null;
        } else {
            this.refundedAt = date7;
        }
        if ((i & 2048) == 0) {
            this.storeTransactionId = null;
        } else {
            this.storeTransactionId = str;
        }
        if ((i & 4096) == 0) {
            this.autoResumeDate = null;
        } else {
            this.autoResumeDate = date8;
        }
        if ((i & 8192) == 0) {
            this.displayName = null;
        } else {
            this.displayName = str2;
        }
        if ((i & 16384) == 0) {
            this.price = null;
        } else {
            this.price = priceResponse;
        }
        if ((32768 & i) == 0) {
            this.productPlanIdentifier = null;
        } else {
            this.productPlanIdentifier = str3;
        }
        if ((i & 65536) == 0) {
            this.managementURL = null;
        } else {
            this.managementURL = str4;
        }
    }

    public SubscriptionInfoResponse(Date purchaseDate, Date date, Date date2, Store store, boolean z, Date date3, Date date4, Date date5, OwnershipType ownershipType, PeriodType periodType, Date date6, String str, Date date7, String str2, PriceResponse priceResponse, String str3, String str4) {
        Intrinsics.checkNotNullParameter(purchaseDate, "purchaseDate");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(ownershipType, "ownershipType");
        Intrinsics.checkNotNullParameter(periodType, "periodType");
        this.purchaseDate = purchaseDate;
        this.originalPurchaseDate = date;
        this.expiresDate = date2;
        this.store = store;
        this.isSandbox = z;
        this.unsubscribeDetectedAt = date3;
        this.billingIssuesDetectedAt = date4;
        this.gracePeriodExpiresDate = date5;
        this.ownershipType = ownershipType;
        this.periodType = periodType;
        this.refundedAt = date6;
        this.storeTransactionId = str;
        this.autoResumeDate = date7;
        this.displayName = str2;
        this.price = priceResponse;
        this.productPlanIdentifier = str3;
        this.managementURL = str4;
    }

    public /* synthetic */ SubscriptionInfoResponse(Date date, Date date2, Date date3, Store store, boolean z, Date date4, Date date5, Date date6, OwnershipType ownershipType, PeriodType periodType, Date date7, String str, Date date8, String str2, PriceResponse priceResponse, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(date, (i & 2) != 0 ? null : date2, (i & 4) != 0 ? null : date3, store, z, (i & 32) != 0 ? null : date4, (i & 64) != 0 ? null : date5, (i & 128) != 0 ? null : date6, (i & 256) != 0 ? OwnershipType.UNKNOWN : ownershipType, periodType, (i & 1024) != 0 ? null : date7, (i & 2048) != 0 ? null : str, (i & 4096) != 0 ? null : date8, (i & 8192) != 0 ? null : str2, (i & 16384) != 0 ? null : priceResponse, (32768 & i) != 0 ? null : str3, (i & 65536) != 0 ? null : str4);
    }

    public static /* synthetic */ SubscriptionInfoResponse copy$default(SubscriptionInfoResponse subscriptionInfoResponse, Date date, Date date2, Date date3, Store store, boolean z, Date date4, Date date5, Date date6, OwnershipType ownershipType, PeriodType periodType, Date date7, String str, Date date8, String str2, PriceResponse priceResponse, String str3, String str4, int i, Object obj) {
        String str5;
        String str6;
        Date date9;
        SubscriptionInfoResponse subscriptionInfoResponse2;
        PriceResponse priceResponse2;
        Date date10;
        Date date11;
        Store store2;
        boolean z2;
        Date date12;
        Date date13;
        Date date14;
        OwnershipType ownershipType2;
        PeriodType periodType2;
        Date date15;
        String str7;
        Date date16;
        String str8;
        Date date17 = (i & 1) != 0 ? subscriptionInfoResponse.purchaseDate : date;
        Date date18 = (i & 2) != 0 ? subscriptionInfoResponse.originalPurchaseDate : date2;
        Date date19 = (i & 4) != 0 ? subscriptionInfoResponse.expiresDate : date3;
        Store store3 = (i & 8) != 0 ? subscriptionInfoResponse.store : store;
        boolean z3 = (i & 16) != 0 ? subscriptionInfoResponse.isSandbox : z;
        Date date20 = (i & 32) != 0 ? subscriptionInfoResponse.unsubscribeDetectedAt : date4;
        Date date21 = (i & 64) != 0 ? subscriptionInfoResponse.billingIssuesDetectedAt : date5;
        Date date22 = (i & 128) != 0 ? subscriptionInfoResponse.gracePeriodExpiresDate : date6;
        OwnershipType ownershipType3 = (i & 256) != 0 ? subscriptionInfoResponse.ownershipType : ownershipType;
        PeriodType periodType3 = (i & 512) != 0 ? subscriptionInfoResponse.periodType : periodType;
        Date date23 = (i & 1024) != 0 ? subscriptionInfoResponse.refundedAt : date7;
        String str9 = (i & 2048) != 0 ? subscriptionInfoResponse.storeTransactionId : str;
        Date date24 = (i & 4096) != 0 ? subscriptionInfoResponse.autoResumeDate : date8;
        String str10 = (i & 8192) != 0 ? subscriptionInfoResponse.displayName : str2;
        Date date25 = date17;
        PriceResponse priceResponse3 = (i & 16384) != 0 ? subscriptionInfoResponse.price : priceResponse;
        String str11 = (i & 32768) != 0 ? subscriptionInfoResponse.productPlanIdentifier : str3;
        if ((i & 65536) != 0) {
            str6 = str11;
            str5 = subscriptionInfoResponse.managementURL;
            priceResponse2 = priceResponse3;
            date10 = date18;
            date11 = date19;
            store2 = store3;
            z2 = z3;
            date12 = date20;
            date13 = date21;
            date14 = date22;
            ownershipType2 = ownershipType3;
            periodType2 = periodType3;
            date15 = date23;
            str7 = str9;
            date16 = date24;
            str8 = str10;
            date9 = date25;
            subscriptionInfoResponse2 = subscriptionInfoResponse;
        } else {
            str5 = str4;
            str6 = str11;
            date9 = date25;
            subscriptionInfoResponse2 = subscriptionInfoResponse;
            priceResponse2 = priceResponse3;
            date10 = date18;
            date11 = date19;
            store2 = store3;
            z2 = z3;
            date12 = date20;
            date13 = date21;
            date14 = date22;
            ownershipType2 = ownershipType3;
            periodType2 = periodType3;
            date15 = date23;
            str7 = str9;
            date16 = date24;
            str8 = str10;
        }
        return subscriptionInfoResponse2.copy(date9, date10, date11, store2, z2, date12, date13, date14, ownershipType2, periodType2, date15, str7, date16, str8, priceResponse2, str6, str5);
    }

    @SerialName("auto_resume_date")
    @Serializable(with = ISO8601DateSerializer.class)
    public static /* synthetic */ void getAutoResumeDate$annotations() {
    }

    @SerialName(ProductResponseJsonKeys.BILLING_ISSUES_DETECTED_AT)
    @Serializable(with = ISO8601DateSerializer.class)
    public static /* synthetic */ void getBillingIssuesDetectedAt$annotations() {
    }

    @SerialName("display_name")
    public static /* synthetic */ void getDisplayName$annotations() {
    }

    @SerialName("expires_date")
    @Serializable(with = ISO8601DateSerializer.class)
    public static /* synthetic */ void getExpiresDate$annotations() {
    }

    @SerialName("grace_period_expires_date")
    @Serializable(with = ISO8601DateSerializer.class)
    public static /* synthetic */ void getGracePeriodExpiresDate$annotations() {
    }

    @SerialName("management_url")
    public static /* synthetic */ void getManagementURL$annotations() {
    }

    @SerialName("original_purchase_date")
    @Serializable(with = ISO8601DateSerializer.class)
    public static /* synthetic */ void getOriginalPurchaseDate$annotations() {
    }

    @SerialName(ProductResponseJsonKeys.OWNERSHIP_TYPE)
    public static /* synthetic */ void getOwnershipType$annotations() {
    }

    @SerialName(ProductResponseJsonKeys.PERIOD_TYPE)
    public static /* synthetic */ void getPeriodType$annotations() {
    }

    @SerialName(FirebaseAnalytics.Param.PRICE)
    public static /* synthetic */ void getPrice$annotations() {
    }

    @SerialName("product_plan_identifier")
    public static /* synthetic */ void getProductPlanIdentifier$annotations() {
    }

    @SerialName("purchase_date")
    @Serializable(with = ISO8601DateSerializer.class)
    public static /* synthetic */ void getPurchaseDate$annotations() {
    }

    @SerialName("refunded_at")
    @Serializable(with = ISO8601DateSerializer.class)
    public static /* synthetic */ void getRefundedAt$annotations() {
    }

    @SerialName(ProductResponseJsonKeys.STORE)
    public static /* synthetic */ void getStore$annotations() {
    }

    @SerialName("store_transaction_id")
    public static /* synthetic */ void getStoreTransactionId$annotations() {
    }

    @SerialName(ProductResponseJsonKeys.UNSUBSCRIBE_DETECTED_AT)
    @Serializable(with = ISO8601DateSerializer.class)
    public static /* synthetic */ void getUnsubscribeDetectedAt$annotations() {
    }

    @SerialName(ProductResponseJsonKeys.IS_SANDBOX)
    public static /* synthetic */ void isSandbox$annotations() {
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(SubscriptionInfoResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, ISO8601DateSerializer.INSTANCE, self.purchaseDate);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.originalPurchaseDate != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, ISO8601DateSerializer.INSTANCE, self.originalPurchaseDate);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.expiresDate != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, ISO8601DateSerializer.INSTANCE, self.expiresDate);
        }
        output.encodeSerializableElement(serialDesc, 3, StoreSerializer.INSTANCE, self.store);
        output.encodeBooleanElement(serialDesc, 4, self.isSandbox);
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.unsubscribeDetectedAt != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, ISO8601DateSerializer.INSTANCE, self.unsubscribeDetectedAt);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.billingIssuesDetectedAt != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, ISO8601DateSerializer.INSTANCE, self.billingIssuesDetectedAt);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.gracePeriodExpiresDate != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, ISO8601DateSerializer.INSTANCE, self.gracePeriodExpiresDate);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.ownershipType != OwnershipType.UNKNOWN) {
            output.encodeSerializableElement(serialDesc, 8, kSerializerArr[8], self.ownershipType);
        }
        output.encodeSerializableElement(serialDesc, 9, kSerializerArr[9], self.periodType);
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.refundedAt != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, ISO8601DateSerializer.INSTANCE, self.refundedAt);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.storeTransactionId != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.storeTransactionId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.autoResumeDate != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, ISO8601DateSerializer.INSTANCE, self.autoResumeDate);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.displayName != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.displayName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.price != null) {
            output.encodeNullableSerializableElement(serialDesc, 14, SubscriptionInfoResponse$PriceResponse$$serializer.INSTANCE, self.price);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.productPlanIdentifier != null) {
            output.encodeNullableSerializableElement(serialDesc, 15, StringSerializer.INSTANCE, self.productPlanIdentifier);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 16) && self.managementURL == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 16, StringSerializer.INSTANCE, self.managementURL);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Date getPurchaseDate() {
        return this.purchaseDate;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final PeriodType getPeriodType() {
        return this.periodType;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Date getRefundedAt() {
        return this.refundedAt;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getStoreTransactionId() {
        return this.storeTransactionId;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Date getAutoResumeDate() {
        return this.autoResumeDate;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final PriceResponse getPrice() {
        return this.price;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getProductPlanIdentifier() {
        return this.productPlanIdentifier;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getManagementURL() {
        return this.managementURL;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Date getOriginalPurchaseDate() {
        return this.originalPurchaseDate;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Date getExpiresDate() {
        return this.expiresDate;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Store getStore() {
        return this.store;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsSandbox() {
        return this.isSandbox;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Date getUnsubscribeDetectedAt() {
        return this.unsubscribeDetectedAt;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Date getBillingIssuesDetectedAt() {
        return this.billingIssuesDetectedAt;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Date getGracePeriodExpiresDate() {
        return this.gracePeriodExpiresDate;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final OwnershipType getOwnershipType() {
        return this.ownershipType;
    }

    public final SubscriptionInfoResponse copy(Date purchaseDate, Date originalPurchaseDate, Date expiresDate, Store store, boolean isSandbox, Date unsubscribeDetectedAt, Date billingIssuesDetectedAt, Date gracePeriodExpiresDate, OwnershipType ownershipType, PeriodType periodType, Date refundedAt, String storeTransactionId, Date autoResumeDate, String displayName, PriceResponse price, String productPlanIdentifier, String managementURL) {
        Intrinsics.checkNotNullParameter(purchaseDate, "purchaseDate");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(ownershipType, "ownershipType");
        Intrinsics.checkNotNullParameter(periodType, "periodType");
        return new SubscriptionInfoResponse(purchaseDate, originalPurchaseDate, expiresDate, store, isSandbox, unsubscribeDetectedAt, billingIssuesDetectedAt, gracePeriodExpiresDate, ownershipType, periodType, refundedAt, storeTransactionId, autoResumeDate, displayName, price, productPlanIdentifier, managementURL);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubscriptionInfoResponse)) {
            return false;
        }
        SubscriptionInfoResponse subscriptionInfoResponse = (SubscriptionInfoResponse) other;
        return Intrinsics.areEqual(this.purchaseDate, subscriptionInfoResponse.purchaseDate) && Intrinsics.areEqual(this.originalPurchaseDate, subscriptionInfoResponse.originalPurchaseDate) && Intrinsics.areEqual(this.expiresDate, subscriptionInfoResponse.expiresDate) && this.store == subscriptionInfoResponse.store && this.isSandbox == subscriptionInfoResponse.isSandbox && Intrinsics.areEqual(this.unsubscribeDetectedAt, subscriptionInfoResponse.unsubscribeDetectedAt) && Intrinsics.areEqual(this.billingIssuesDetectedAt, subscriptionInfoResponse.billingIssuesDetectedAt) && Intrinsics.areEqual(this.gracePeriodExpiresDate, subscriptionInfoResponse.gracePeriodExpiresDate) && this.ownershipType == subscriptionInfoResponse.ownershipType && this.periodType == subscriptionInfoResponse.periodType && Intrinsics.areEqual(this.refundedAt, subscriptionInfoResponse.refundedAt) && Intrinsics.areEqual(this.storeTransactionId, subscriptionInfoResponse.storeTransactionId) && Intrinsics.areEqual(this.autoResumeDate, subscriptionInfoResponse.autoResumeDate) && Intrinsics.areEqual(this.displayName, subscriptionInfoResponse.displayName) && Intrinsics.areEqual(this.price, subscriptionInfoResponse.price) && Intrinsics.areEqual(this.productPlanIdentifier, subscriptionInfoResponse.productPlanIdentifier) && Intrinsics.areEqual(this.managementURL, subscriptionInfoResponse.managementURL);
    }

    public final Date getAutoResumeDate() {
        return this.autoResumeDate;
    }

    public final Date getBillingIssuesDetectedAt() {
        return this.billingIssuesDetectedAt;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final Date getExpiresDate() {
        return this.expiresDate;
    }

    public final Date getGracePeriodExpiresDate() {
        return this.gracePeriodExpiresDate;
    }

    public final String getManagementURL() {
        return this.managementURL;
    }

    public final Date getOriginalPurchaseDate() {
        return this.originalPurchaseDate;
    }

    public final OwnershipType getOwnershipType() {
        return this.ownershipType;
    }

    public final PeriodType getPeriodType() {
        return this.periodType;
    }

    public final PriceResponse getPrice() {
        return this.price;
    }

    public final String getProductPlanIdentifier() {
        return this.productPlanIdentifier;
    }

    public final Date getPurchaseDate() {
        return this.purchaseDate;
    }

    public final Date getRefundedAt() {
        return this.refundedAt;
    }

    public final Store getStore() {
        return this.store;
    }

    public final String getStoreTransactionId() {
        return this.storeTransactionId;
    }

    public final Date getUnsubscribeDetectedAt() {
        return this.unsubscribeDetectedAt;
    }

    public int hashCode() {
        int iHashCode = this.purchaseDate.hashCode() * 31;
        Date date = this.originalPurchaseDate;
        int iHashCode2 = (iHashCode + (date == null ? 0 : date.hashCode())) * 31;
        Date date2 = this.expiresDate;
        int iHashCode3 = (((((iHashCode2 + (date2 == null ? 0 : date2.hashCode())) * 31) + this.store.hashCode()) * 31) + Boolean.hashCode(this.isSandbox)) * 31;
        Date date3 = this.unsubscribeDetectedAt;
        int iHashCode4 = (iHashCode3 + (date3 == null ? 0 : date3.hashCode())) * 31;
        Date date4 = this.billingIssuesDetectedAt;
        int iHashCode5 = (iHashCode4 + (date4 == null ? 0 : date4.hashCode())) * 31;
        Date date5 = this.gracePeriodExpiresDate;
        int iHashCode6 = (((((iHashCode5 + (date5 == null ? 0 : date5.hashCode())) * 31) + this.ownershipType.hashCode()) * 31) + this.periodType.hashCode()) * 31;
        Date date6 = this.refundedAt;
        int iHashCode7 = (iHashCode6 + (date6 == null ? 0 : date6.hashCode())) * 31;
        String str = this.storeTransactionId;
        int iHashCode8 = (iHashCode7 + (str == null ? 0 : str.hashCode())) * 31;
        Date date7 = this.autoResumeDate;
        int iHashCode9 = (iHashCode8 + (date7 == null ? 0 : date7.hashCode())) * 31;
        String str2 = this.displayName;
        int iHashCode10 = (iHashCode9 + (str2 == null ? 0 : str2.hashCode())) * 31;
        PriceResponse priceResponse = this.price;
        int iHashCode11 = (iHashCode10 + (priceResponse == null ? 0 : priceResponse.hashCode())) * 31;
        String str3 = this.productPlanIdentifier;
        int iHashCode12 = (iHashCode11 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.managementURL;
        return iHashCode12 + (str4 != null ? str4.hashCode() : 0);
    }

    public final boolean isSandbox() {
        return this.isSandbox;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SubscriptionInfoResponse(purchaseDate=");
        sb.append(this.purchaseDate).append(", originalPurchaseDate=").append(this.originalPurchaseDate).append(", expiresDate=").append(this.expiresDate).append(", store=").append(this.store).append(", isSandbox=").append(this.isSandbox).append(", unsubscribeDetectedAt=").append(this.unsubscribeDetectedAt).append(", billingIssuesDetectedAt=").append(this.billingIssuesDetectedAt).append(", gracePeriodExpiresDate=").append(this.gracePeriodExpiresDate).append(", ownershipType=").append(this.ownershipType).append(", periodType=").append(this.periodType).append(", refundedAt=").append(this.refundedAt).append(", storeTransactionId=");
        sb.append(this.storeTransactionId).append(", autoResumeDate=").append(this.autoResumeDate).append(", displayName=").append(this.displayName).append(", price=").append(this.price).append(", productPlanIdentifier=").append(this.productPlanIdentifier).append(", managementURL=").append(this.managementURL).append(')');
        return sb.toString();
    }
}
