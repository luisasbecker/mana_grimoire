package com.revenuecat.purchases.common.events;

import com.appsflyer.AdRevenueScheme;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.customercenter.events.CustomerCenterDisplayMode;
import com.revenuecat.purchases.customercenter.events.CustomerCenterEventType;
import com.revenuecat.purchases.utils.Event;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.lang.annotation.Annotation;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: BackendEvent.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u0000 \u00102\u00020\u0001:\u0005\u000f\u0010\u0011\u0012\u0013B\u0019\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0007J!\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eHÇ\u0001\u0082\u0001\u0004\u0014\u0015\u0016\u0017¨\u0006\u0018"}, d2 = {"Lcom/revenuecat/purchases/common/events/BackendEvent;", "Lcom/revenuecat/purchases/utils/Event;", "seen1", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "()V", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Ad", "Companion", "CustomPaywall", "CustomerCenter", "Paywalls", "Lcom/revenuecat/purchases/common/events/BackendEvent$Ad;", "Lcom/revenuecat/purchases/common/events/BackendEvent$CustomPaywall;", "Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter;", "Lcom/revenuecat/purchases/common/events/BackendEvent$Paywalls;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Serializable
public abstract class BackendEvent implements Event {
    public static final int AD_EVENT_SCHEMA_VERSION = 1;
    public static final int CUSTOMER_CENTER_EVENT_SCHEMA_VERSION = 1;
    public static final int CUSTOM_PAYWALL_EVENT_SCHEMA_VERSION = 1;
    public static final int PAYWALL_EVENT_SCHEMA_VERSION = 1;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KSerializer<Object>>() { // from class: com.revenuecat.purchases.common.events.BackendEvent.Companion.1
        @Override // kotlin.jvm.functions.Function0
        public final KSerializer<Object> invoke() {
            return new SealedClassSerializer("com.revenuecat.purchases.common.events.BackendEvent", Reflection.getOrCreateKotlinClass(BackendEvent.class), new KClass[]{Reflection.getOrCreateKotlinClass(Ad.class), Reflection.getOrCreateKotlinClass(CustomPaywall.class), Reflection.getOrCreateKotlinClass(CustomerCenter.class), Reflection.getOrCreateKotlinClass(Paywalls.class)}, new KSerializer[]{BackendEvent$Ad$$serializer.INSTANCE, BackendEvent$CustomPaywall$$serializer.INSTANCE, BackendEvent$CustomerCenter$$serializer.INSTANCE, BackendEvent$Paywalls$$serializer.INSTANCE}, new Annotation[0]);
        }
    });

    /* JADX INFO: compiled from: BackendEvent.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b7\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ]2\u00020\u0001:\u0002\\]BÉ\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010\u0018B¡\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0019J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010>\u001a\u00020\u0005HÆ\u0003J\t\u0010?\u001a\u00020\u0005HÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u00104J\u000b\u0010A\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010*J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0005HÆ\u0003J\t\u0010F\u001a\u00020\tHÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010H\u001a\u00020\u0005HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010K\u001a\u00020\u0005HÆ\u0003J¾\u0001\u0010L\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010MJ\u0013\u0010N\u001a\u00020O2\b\u0010P\u001a\u0004\u0018\u00010QHÖ\u0003J\t\u0010R\u001a\u00020\u0003HÖ\u0001J\t\u0010S\u001a\u00020\u0005HÖ\u0001J&\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\u00002\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020ZHÁ\u0001¢\u0006\u0002\b[R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR\u001c\u0010\u0011\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001dR\u001c\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u001b\u001a\u0004\b#\u0010\u001dR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u001b\u001a\u0004\b'\u0010\u001dR \u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010+\u0012\u0004\b(\u0010\u001b\u001a\u0004\b)\u0010*R\u001c\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u001b\u001a\u0004\b-\u0010\u001dR\u001e\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u001b\u001a\u0004\b/\u0010\u001dR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001dR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001dR \u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00105\u0012\u0004\b2\u0010\u001b\u001a\u0004\b3\u00104R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b6\u0010\u001b\u001a\u0004\b7\u00108R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u001dR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;¨\u0006^"}, d2 = {"Lcom/revenuecat/purchases/common/events/BackendEvent$Ad;", "Lcom/revenuecat/purchases/common/events/BackendEvent;", "seen1", "", "id", "", "version", "type", DiagnosticsEntry.TIMESTAMP_KEY, "", "networkName", "mediatorName", "adFormat", AdRevenueScheme.PLACEMENT, "adUnitId", "impressionId", "appUserID", "appSessionID", "revenueMicros", FirebaseAnalytics.Param.CURRENCY, "precision", "mediatorErrorCode", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getAdFormat$annotations", "()V", "getAdFormat", "()Ljava/lang/String;", "getAdUnitId$annotations", "getAdUnitId", "getAppSessionID$annotations", "getAppSessionID", "getAppUserID$annotations", "getAppUserID", "getCurrency", "getId", "getImpressionId$annotations", "getImpressionId", "getMediatorErrorCode$annotations", "getMediatorErrorCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMediatorName$annotations", "getMediatorName", "getNetworkName$annotations", "getNetworkName", "getPlacement", "getPrecision", "getRevenueMicros$annotations", "getRevenueMicros", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTimestamp$annotations", "getTimestamp", "()J", "getType", "getVersion", "()I", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/revenuecat/purchases/common/events/BackendEvent$Ad;", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Serializable
    @SerialName("ad")
    public static final /* data */ class Ad extends BackendEvent {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String adFormat;
        private final String adUnitId;
        private final String appSessionID;
        private final String appUserID;
        private final String currency;
        private final String id;
        private final String impressionId;
        private final Integer mediatorErrorCode;
        private final String mediatorName;
        private final String networkName;
        private final String placement;
        private final String precision;
        private final Long revenueMicros;
        private final long timestamp;
        private final String type;
        private final int version;

        /* JADX INFO: compiled from: BackendEvent.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/common/events/BackendEvent$Ad$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/events/BackendEvent$Ad;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Ad> serializer() {
                return BackendEvent$Ad$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ Ad(int i, String str, int i2, String str2, @SerialName("timestamp_ms") long j, @SerialName("network_name") String str3, @SerialName("mediator_name") String str4, @SerialName(FirebaseAnalytics.Param.AD_FORMAT) String str5, String str6, @SerialName("ad_unit_id") String str7, @SerialName("impression_id") String str8, @SerialName("app_user_id") String str9, @SerialName(DiagnosticsEntry.APP_SESSION_ID_KEY) String str10, @SerialName("revenue_micros") Long l, String str11, String str12, @SerialName("mediator_error_code") Integer num, SerializationConstructorMarker serializationConstructorMarker) {
            super(i, serializationConstructorMarker);
            if (4015 != (i & 4015)) {
                PluginExceptionsKt.throwMissingFieldException(i, 4015, BackendEvent$Ad$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            this.version = i2;
            this.type = str2;
            this.timestamp = j;
            if ((i & 16) == 0) {
                this.networkName = null;
            } else {
                this.networkName = str3;
            }
            this.mediatorName = str4;
            if ((i & 64) == 0) {
                this.adFormat = null;
            } else {
                this.adFormat = str5;
            }
            this.placement = str6;
            this.adUnitId = str7;
            this.impressionId = str8;
            this.appUserID = str9;
            this.appSessionID = str10;
            if ((i & 4096) == 0) {
                this.revenueMicros = null;
            } else {
                this.revenueMicros = l;
            }
            if ((i & 8192) == 0) {
                this.currency = null;
            } else {
                this.currency = str11;
            }
            if ((i & 16384) == 0) {
                this.precision = null;
            } else {
                this.precision = str12;
            }
            if ((i & 32768) == 0) {
                this.mediatorErrorCode = null;
            } else {
                this.mediatorErrorCode = num;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Ad(String id, int i, String type, long j, String str, String mediatorName, String str2, String str3, String adUnitId, String str4, String appUserID, String appSessionID, Long l, String str5, String str6, Integer num) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(mediatorName, "mediatorName");
            Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
            Intrinsics.checkNotNullParameter(appUserID, "appUserID");
            Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
            this.id = id;
            this.version = i;
            this.type = type;
            this.timestamp = j;
            this.networkName = str;
            this.mediatorName = mediatorName;
            this.adFormat = str2;
            this.placement = str3;
            this.adUnitId = adUnitId;
            this.impressionId = str4;
            this.appUserID = appUserID;
            this.appSessionID = appSessionID;
            this.revenueMicros = l;
            this.currency = str5;
            this.precision = str6;
            this.mediatorErrorCode = num;
        }

        public /* synthetic */ Ad(String str, int i, String str2, long j, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Long l, String str11, String str12, Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, str2, j, (i2 & 16) != 0 ? null : str3, str4, (i2 & 64) != 0 ? null : str5, str6, str7, str8, str9, str10, (i2 & 4096) != 0 ? null : l, (i2 & 8192) != 0 ? null : str11, (i2 & 16384) != 0 ? null : str12, (i2 & 32768) != 0 ? null : num);
        }

        public static /* synthetic */ Ad copy$default(Ad ad, String str, int i, String str2, long j, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Long l, String str11, String str12, Integer num, int i2, Object obj) {
            String str13 = (i2 & 1) != 0 ? ad.id : str;
            return ad.copy(str13, (i2 & 2) != 0 ? ad.version : i, (i2 & 4) != 0 ? ad.type : str2, (i2 & 8) != 0 ? ad.timestamp : j, (i2 & 16) != 0 ? ad.networkName : str3, (i2 & 32) != 0 ? ad.mediatorName : str4, (i2 & 64) != 0 ? ad.adFormat : str5, (i2 & 128) != 0 ? ad.placement : str6, (i2 & 256) != 0 ? ad.adUnitId : str7, (i2 & 512) != 0 ? ad.impressionId : str8, (i2 & 1024) != 0 ? ad.appUserID : str9, (i2 & 2048) != 0 ? ad.appSessionID : str10, (i2 & 4096) != 0 ? ad.revenueMicros : l, (i2 & 8192) != 0 ? ad.currency : str11, (i2 & 16384) != 0 ? ad.precision : str12, (i2 & 32768) != 0 ? ad.mediatorErrorCode : num);
        }

        @SerialName(FirebaseAnalytics.Param.AD_FORMAT)
        public static /* synthetic */ void getAdFormat$annotations() {
        }

        @SerialName("ad_unit_id")
        public static /* synthetic */ void getAdUnitId$annotations() {
        }

        @SerialName(DiagnosticsEntry.APP_SESSION_ID_KEY)
        public static /* synthetic */ void getAppSessionID$annotations() {
        }

        @SerialName("app_user_id")
        public static /* synthetic */ void getAppUserID$annotations() {
        }

        @SerialName("impression_id")
        public static /* synthetic */ void getImpressionId$annotations() {
        }

        @SerialName("mediator_error_code")
        public static /* synthetic */ void getMediatorErrorCode$annotations() {
        }

        @SerialName("mediator_name")
        public static /* synthetic */ void getMediatorName$annotations() {
        }

        @SerialName("network_name")
        public static /* synthetic */ void getNetworkName$annotations() {
        }

        @SerialName("revenue_micros")
        public static /* synthetic */ void getRevenueMicros$annotations() {
        }

        @SerialName("timestamp_ms")
        public static /* synthetic */ void getTimestamp$annotations() {
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Ad self, CompositeEncoder output, SerialDescriptor serialDesc) {
            BackendEvent.write$Self(self, output, serialDesc);
            output.encodeStringElement(serialDesc, 0, self.id);
            output.encodeIntElement(serialDesc, 1, self.version);
            output.encodeStringElement(serialDesc, 2, self.type);
            output.encodeLongElement(serialDesc, 3, self.timestamp);
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.networkName != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.networkName);
            }
            output.encodeStringElement(serialDesc, 5, self.mediatorName);
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.adFormat != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.adFormat);
            }
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.placement);
            output.encodeStringElement(serialDesc, 8, self.adUnitId);
            output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.impressionId);
            output.encodeStringElement(serialDesc, 10, self.appUserID);
            output.encodeStringElement(serialDesc, 11, self.appSessionID);
            if (output.shouldEncodeElementDefault(serialDesc, 12) || self.revenueMicros != null) {
                output.encodeNullableSerializableElement(serialDesc, 12, LongSerializer.INSTANCE, self.revenueMicros);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 13) || self.currency != null) {
                output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.currency);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 14) || self.precision != null) {
                output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.precision);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 15) && self.mediatorErrorCode == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 15, IntSerializer.INSTANCE, self.mediatorErrorCode);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getImpressionId() {
            return this.impressionId;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final String getAppUserID() {
            return this.appUserID;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final String getAppSessionID() {
            return this.appSessionID;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final Long getRevenueMicros() {
            return this.revenueMicros;
        }

        /* JADX INFO: renamed from: component14, reason: from getter */
        public final String getCurrency() {
            return this.currency;
        }

        /* JADX INFO: renamed from: component15, reason: from getter */
        public final String getPrecision() {
            return this.precision;
        }

        /* JADX INFO: renamed from: component16, reason: from getter */
        public final Integer getMediatorErrorCode() {
            return this.mediatorErrorCode;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getVersion() {
            return this.version;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getNetworkName() {
            return this.networkName;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getMediatorName() {
            return this.mediatorName;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getAdFormat() {
            return this.adFormat;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getPlacement() {
            return this.placement;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getAdUnitId() {
            return this.adUnitId;
        }

        public final Ad copy(String id, int version, String type, long timestamp, String networkName, String mediatorName, String adFormat, String placement, String adUnitId, String impressionId, String appUserID, String appSessionID, Long revenueMicros, String currency, String precision, Integer mediatorErrorCode) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(mediatorName, "mediatorName");
            Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
            Intrinsics.checkNotNullParameter(appUserID, "appUserID");
            Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
            return new Ad(id, version, type, timestamp, networkName, mediatorName, adFormat, placement, adUnitId, impressionId, appUserID, appSessionID, revenueMicros, currency, precision, mediatorErrorCode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Ad)) {
                return false;
            }
            Ad ad = (Ad) other;
            return Intrinsics.areEqual(this.id, ad.id) && this.version == ad.version && Intrinsics.areEqual(this.type, ad.type) && this.timestamp == ad.timestamp && Intrinsics.areEqual(this.networkName, ad.networkName) && Intrinsics.areEqual(this.mediatorName, ad.mediatorName) && Intrinsics.areEqual(this.adFormat, ad.adFormat) && Intrinsics.areEqual(this.placement, ad.placement) && Intrinsics.areEqual(this.adUnitId, ad.adUnitId) && Intrinsics.areEqual(this.impressionId, ad.impressionId) && Intrinsics.areEqual(this.appUserID, ad.appUserID) && Intrinsics.areEqual(this.appSessionID, ad.appSessionID) && Intrinsics.areEqual(this.revenueMicros, ad.revenueMicros) && Intrinsics.areEqual(this.currency, ad.currency) && Intrinsics.areEqual(this.precision, ad.precision) && Intrinsics.areEqual(this.mediatorErrorCode, ad.mediatorErrorCode);
        }

        public final String getAdFormat() {
            return this.adFormat;
        }

        public final String getAdUnitId() {
            return this.adUnitId;
        }

        public final String getAppSessionID() {
            return this.appSessionID;
        }

        public final String getAppUserID() {
            return this.appUserID;
        }

        public final String getCurrency() {
            return this.currency;
        }

        public final String getId() {
            return this.id;
        }

        public final String getImpressionId() {
            return this.impressionId;
        }

        public final Integer getMediatorErrorCode() {
            return this.mediatorErrorCode;
        }

        public final String getMediatorName() {
            return this.mediatorName;
        }

        public final String getNetworkName() {
            return this.networkName;
        }

        public final String getPlacement() {
            return this.placement;
        }

        public final String getPrecision() {
            return this.precision;
        }

        public final Long getRevenueMicros() {
            return this.revenueMicros;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public final String getType() {
            return this.type;
        }

        public final int getVersion() {
            return this.version;
        }

        public int hashCode() {
            int iHashCode = ((((((this.id.hashCode() * 31) + Integer.hashCode(this.version)) * 31) + this.type.hashCode()) * 31) + Long.hashCode(this.timestamp)) * 31;
            String str = this.networkName;
            int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.mediatorName.hashCode()) * 31;
            String str2 = this.adFormat;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.placement;
            int iHashCode4 = (((iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.adUnitId.hashCode()) * 31;
            String str4 = this.impressionId;
            int iHashCode5 = (((((iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.appUserID.hashCode()) * 31) + this.appSessionID.hashCode()) * 31;
            Long l = this.revenueMicros;
            int iHashCode6 = (iHashCode5 + (l == null ? 0 : l.hashCode())) * 31;
            String str5 = this.currency;
            int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.precision;
            int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
            Integer num = this.mediatorErrorCode;
            return iHashCode8 + (num != null ? num.hashCode() : 0);
        }

        @Override // com.revenuecat.purchases.utils.Event
        public String toString() {
            StringBuilder sb = new StringBuilder("Ad(id=");
            sb.append(this.id).append(", version=").append(this.version).append(", type=").append(this.type).append(", timestamp=").append(this.timestamp).append(", networkName=").append(this.networkName).append(", mediatorName=").append(this.mediatorName).append(", adFormat=").append(this.adFormat).append(", placement=").append(this.placement).append(", adUnitId=").append(this.adUnitId).append(", impressionId=").append(this.impressionId).append(", appUserID=").append(this.appUserID).append(", appSessionID=");
            sb.append(this.appSessionID).append(", revenueMicros=").append(this.revenueMicros).append(", currency=").append(this.currency).append(", precision=").append(this.precision).append(", mediatorErrorCode=").append(this.mediatorErrorCode).append(')');
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: BackendEvent.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/common/events/BackendEvent$Companion;", "", "()V", "AD_EVENT_SCHEMA_VERSION", "", "CUSTOMER_CENTER_EVENT_SCHEMA_VERSION", "CUSTOM_PAYWALL_EVENT_SCHEMA_VERSION", "PAYWALL_EVENT_SCHEMA_VERSION", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/events/BackendEvent;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) BackendEvent.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<BackendEvent> serializer() {
            return get$cachedSerializer();
        }
    }

    /* JADX INFO: compiled from: BackendEvent.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 :2\u00020\u0001:\u00029:Bm\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010BQ\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0011J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J_\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\t\u00100\u001a\u00020\u0005HÖ\u0001J&\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207HÁ\u0001¢\u0006\u0002\b8R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006;"}, d2 = {"Lcom/revenuecat/purchases/common/events/BackendEvent$CustomPaywall;", "Lcom/revenuecat/purchases/common/events/BackendEvent;", "seen1", "", "id", "", "version", "type", "appUserID", "appSessionID", DiagnosticsEntry.TIMESTAMP_KEY, "", "paywallID", "offeringID", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "getAppSessionID$annotations", "()V", "getAppSessionID", "()Ljava/lang/String;", "getAppUserID$annotations", "getAppUserID", "getId", "getOfferingID$annotations", "getOfferingID", "getPaywallID$annotations", "getPaywallID", "getTimestamp", "()J", "getType", "getVersion", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Serializable
    @SerialName("custom_paywall_event")
    public static final /* data */ class CustomPaywall extends BackendEvent {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String appSessionID;
        private final String appUserID;
        private final String id;
        private final String offeringID;
        private final String paywallID;
        private final long timestamp;
        private final String type;
        private final int version;

        /* JADX INFO: compiled from: BackendEvent.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/common/events/BackendEvent$CustomPaywall$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/events/BackendEvent$CustomPaywall;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<CustomPaywall> serializer() {
                return BackendEvent$CustomPaywall$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ CustomPaywall(int i, String str, int i2, String str2, @SerialName("app_user_id") String str3, @SerialName(DiagnosticsEntry.APP_SESSION_ID_KEY) String str4, long j, @SerialName("paywall_id") String str5, @SerialName("offering_id") String str6, SerializationConstructorMarker serializationConstructorMarker) {
            super(i, serializationConstructorMarker);
            if (47 != (i & 47)) {
                PluginExceptionsKt.throwMissingFieldException(i, 47, BackendEvent$CustomPaywall$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            this.version = i2;
            this.type = str2;
            this.appUserID = str3;
            if ((i & 16) == 0) {
                this.appSessionID = null;
            } else {
                this.appSessionID = str4;
            }
            this.timestamp = j;
            if ((i & 64) == 0) {
                this.paywallID = null;
            } else {
                this.paywallID = str5;
            }
            if ((i & 128) == 0) {
                this.offeringID = null;
            } else {
                this.offeringID = str6;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomPaywall(String id, int i, String type, String appUserID, String str, long j, String str2, String str3) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(appUserID, "appUserID");
            this.id = id;
            this.version = i;
            this.type = type;
            this.appUserID = appUserID;
            this.appSessionID = str;
            this.timestamp = j;
            this.paywallID = str2;
            this.offeringID = str3;
        }

        public /* synthetic */ CustomPaywall(String str, int i, String str2, String str3, String str4, long j, String str5, String str6, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, str2, str3, (i2 & 16) != 0 ? null : str4, j, (i2 & 64) != 0 ? null : str5, (i2 & 128) != 0 ? null : str6);
        }

        public static /* synthetic */ CustomPaywall copy$default(CustomPaywall customPaywall, String str, int i, String str2, String str3, String str4, long j, String str5, String str6, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = customPaywall.id;
            }
            if ((i2 & 2) != 0) {
                i = customPaywall.version;
            }
            if ((i2 & 4) != 0) {
                str2 = customPaywall.type;
            }
            if ((i2 & 8) != 0) {
                str3 = customPaywall.appUserID;
            }
            if ((i2 & 16) != 0) {
                str4 = customPaywall.appSessionID;
            }
            if ((i2 & 32) != 0) {
                j = customPaywall.timestamp;
            }
            if ((i2 & 64) != 0) {
                str5 = customPaywall.paywallID;
            }
            if ((i2 & 128) != 0) {
                str6 = customPaywall.offeringID;
            }
            long j2 = j;
            String str7 = str3;
            String str8 = str4;
            String str9 = str2;
            return customPaywall.copy(str, i, str9, str7, str8, j2, str5, str6);
        }

        @SerialName(DiagnosticsEntry.APP_SESSION_ID_KEY)
        public static /* synthetic */ void getAppSessionID$annotations() {
        }

        @SerialName("app_user_id")
        public static /* synthetic */ void getAppUserID$annotations() {
        }

        @SerialName("offering_id")
        public static /* synthetic */ void getOfferingID$annotations() {
        }

        @SerialName("paywall_id")
        public static /* synthetic */ void getPaywallID$annotations() {
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(CustomPaywall self, CompositeEncoder output, SerialDescriptor serialDesc) {
            BackendEvent.write$Self(self, output, serialDesc);
            output.encodeStringElement(serialDesc, 0, self.id);
            output.encodeIntElement(serialDesc, 1, self.version);
            output.encodeStringElement(serialDesc, 2, self.type);
            output.encodeStringElement(serialDesc, 3, self.appUserID);
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.appSessionID != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.appSessionID);
            }
            output.encodeLongElement(serialDesc, 5, self.timestamp);
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.paywallID != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.paywallID);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 7) && self.offeringID == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.offeringID);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getVersion() {
            return this.version;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getAppUserID() {
            return this.appUserID;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getAppSessionID() {
            return this.appSessionID;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getPaywallID() {
            return this.paywallID;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getOfferingID() {
            return this.offeringID;
        }

        public final CustomPaywall copy(String id, int version, String type, String appUserID, String appSessionID, long timestamp, String paywallID, String offeringID) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(appUserID, "appUserID");
            return new CustomPaywall(id, version, type, appUserID, appSessionID, timestamp, paywallID, offeringID);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CustomPaywall)) {
                return false;
            }
            CustomPaywall customPaywall = (CustomPaywall) other;
            return Intrinsics.areEqual(this.id, customPaywall.id) && this.version == customPaywall.version && Intrinsics.areEqual(this.type, customPaywall.type) && Intrinsics.areEqual(this.appUserID, customPaywall.appUserID) && Intrinsics.areEqual(this.appSessionID, customPaywall.appSessionID) && this.timestamp == customPaywall.timestamp && Intrinsics.areEqual(this.paywallID, customPaywall.paywallID) && Intrinsics.areEqual(this.offeringID, customPaywall.offeringID);
        }

        public final String getAppSessionID() {
            return this.appSessionID;
        }

        public final String getAppUserID() {
            return this.appUserID;
        }

        public final String getId() {
            return this.id;
        }

        public final String getOfferingID() {
            return this.offeringID;
        }

        public final String getPaywallID() {
            return this.paywallID;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public final String getType() {
            return this.type;
        }

        public final int getVersion() {
            return this.version;
        }

        public int hashCode() {
            int iHashCode = ((((((this.id.hashCode() * 31) + Integer.hashCode(this.version)) * 31) + this.type.hashCode()) * 31) + this.appUserID.hashCode()) * 31;
            String str = this.appSessionID;
            int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Long.hashCode(this.timestamp)) * 31;
            String str2 = this.paywallID;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.offeringID;
            return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
        }

        @Override // com.revenuecat.purchases.utils.Event
        public String toString() {
            return "CustomPaywall(id=" + this.id + ", version=" + this.version + ", type=" + this.type + ", appUserID=" + this.appUserID + ", appSessionID=" + this.appSessionID + ", timestamp=" + this.timestamp + ", paywallID=" + this.paywallID + ", offeringID=" + this.offeringID + ')';
        }
    }

    /* JADX INFO: compiled from: BackendEvent.kt */
    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 O2\u00020\u0001:\u0002NOB\u0097\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0001\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010\u0018Bk\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0019J\t\u00104\u001a\u00020\u0005HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\bHÆ\u0003J\t\u0010:\u001a\u00020\u0005HÆ\u0003J\t\u0010;\u001a\u00020\u0005HÆ\u0003J\t\u0010<\u001a\u00020\fHÆ\u0003J\t\u0010=\u001a\u00020\u000eHÆ\u0003J\t\u0010>\u001a\u00020\u0005HÆ\u0003J\t\u0010?\u001a\u00020\u0011HÆ\u0003J\u0087\u0001\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010A\u001a\u00020\u000e2\b\u0010B\u001a\u0004\u0018\u00010CHÖ\u0003J\t\u0010D\u001a\u00020\u0003HÖ\u0001J\t\u0010E\u001a\u00020\u0005HÖ\u0001J&\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u00002\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020LHÁ\u0001¢\u0006\u0002\bMR\u001c\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR\u001c\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\"R\u001c\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u001b\u001a\u0004\b$\u0010%R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001dR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u001b\u001a\u0004\b+\u0010,R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010\u001b\u001a\u0004\b.\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001d¨\u0006P"}, d2 = {"Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter;", "Lcom/revenuecat/purchases/common/events/BackendEvent;", "seen1", "", "id", "", "revisionID", "type", "Lcom/revenuecat/purchases/customercenter/events/CustomerCenterEventType;", "appUserID", "appSessionID", DiagnosticsEntry.TIMESTAMP_KEY, "", "darkMode", "", AndroidContextPlugin.LOCALE_KEY, "displayMode", "Lcom/revenuecat/purchases/customercenter/events/CustomerCenterDisplayMode;", "path", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathType;", "url", "surveyOptionID", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ILcom/revenuecat/purchases/customercenter/events/CustomerCenterEventType;Ljava/lang/String;Ljava/lang/String;JZLjava/lang/String;Lcom/revenuecat/purchases/customercenter/events/CustomerCenterDisplayMode;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathType;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;ILcom/revenuecat/purchases/customercenter/events/CustomerCenterEventType;Ljava/lang/String;Ljava/lang/String;JZLjava/lang/String;Lcom/revenuecat/purchases/customercenter/events/CustomerCenterDisplayMode;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathType;Ljava/lang/String;Ljava/lang/String;)V", "getAppSessionID$annotations", "()V", "getAppSessionID", "()Ljava/lang/String;", "getAppUserID$annotations", "getAppUserID", "getDarkMode$annotations", "getDarkMode", "()Z", "getDisplayMode$annotations", "getDisplayMode", "()Lcom/revenuecat/purchases/customercenter/events/CustomerCenterDisplayMode;", "getId", "getLocale", "getPath", "()Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathType;", "getRevisionID$annotations", "getRevisionID", "()I", "getSurveyOptionID$annotations", "getSurveyOptionID", "getTimestamp", "()J", "getType", "()Lcom/revenuecat/purchases/customercenter/events/CustomerCenterEventType;", "getUrl", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Serializable
    @SerialName("customer_center")
    public static final /* data */ class CustomerCenter extends BackendEvent {
        private final String appSessionID;
        private final String appUserID;
        private final boolean darkMode;
        private final CustomerCenterDisplayMode displayMode;
        private final String id;
        private final String locale;
        private final CustomerCenterConfigData.HelpPath.PathType path;
        private final int revisionID;
        private final String surveyOptionID;
        private final long timestamp;
        private final CustomerCenterEventType type;
        private final String url;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, null, CustomerCenterEventType.INSTANCE.serializer(), null, null, null, null, null, CustomerCenterDisplayMode.INSTANCE.serializer(), CustomerCenterConfigData.HelpPath.PathType.INSTANCE.serializer(), null, null};

        /* JADX INFO: compiled from: BackendEvent.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<CustomerCenter> serializer() {
                return BackendEvent$CustomerCenter$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ CustomerCenter(int i, String str, @SerialName("revision_id") int i2, CustomerCenterEventType customerCenterEventType, @SerialName("app_user_id") String str2, @SerialName(DiagnosticsEntry.APP_SESSION_ID_KEY) String str3, long j, @SerialName("dark_mode") boolean z, String str4, @SerialName("display_mode") CustomerCenterDisplayMode customerCenterDisplayMode, CustomerCenterConfigData.HelpPath.PathType pathType, String str5, @SerialName("survey_option_id") String str6, SerializationConstructorMarker serializationConstructorMarker) {
            super(i, serializationConstructorMarker);
            if (4095 != (i & 4095)) {
                PluginExceptionsKt.throwMissingFieldException(i, 4095, BackendEvent$CustomerCenter$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            this.revisionID = i2;
            this.type = customerCenterEventType;
            this.appUserID = str2;
            this.appSessionID = str3;
            this.timestamp = j;
            this.darkMode = z;
            this.locale = str4;
            this.displayMode = customerCenterDisplayMode;
            this.path = pathType;
            this.url = str5;
            this.surveyOptionID = str6;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomerCenter(String id, int i, CustomerCenterEventType type, String appUserID, String appSessionID, long j, boolean z, String locale, CustomerCenterDisplayMode displayMode, CustomerCenterConfigData.HelpPath.PathType pathType, String str, String str2) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(appUserID, "appUserID");
            Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
            Intrinsics.checkNotNullParameter(locale, "locale");
            Intrinsics.checkNotNullParameter(displayMode, "displayMode");
            this.id = id;
            this.revisionID = i;
            this.type = type;
            this.appUserID = appUserID;
            this.appSessionID = appSessionID;
            this.timestamp = j;
            this.darkMode = z;
            this.locale = locale;
            this.displayMode = displayMode;
            this.path = pathType;
            this.url = str;
            this.surveyOptionID = str2;
        }

        public static /* synthetic */ CustomerCenter copy$default(CustomerCenter customerCenter, String str, int i, CustomerCenterEventType customerCenterEventType, String str2, String str3, long j, boolean z, String str4, CustomerCenterDisplayMode customerCenterDisplayMode, CustomerCenterConfigData.HelpPath.PathType pathType, String str5, String str6, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = customerCenter.id;
            }
            return customerCenter.copy(str, (i2 & 2) != 0 ? customerCenter.revisionID : i, (i2 & 4) != 0 ? customerCenter.type : customerCenterEventType, (i2 & 8) != 0 ? customerCenter.appUserID : str2, (i2 & 16) != 0 ? customerCenter.appSessionID : str3, (i2 & 32) != 0 ? customerCenter.timestamp : j, (i2 & 64) != 0 ? customerCenter.darkMode : z, (i2 & 128) != 0 ? customerCenter.locale : str4, (i2 & 256) != 0 ? customerCenter.displayMode : customerCenterDisplayMode, (i2 & 512) != 0 ? customerCenter.path : pathType, (i2 & 1024) != 0 ? customerCenter.url : str5, (i2 & 2048) != 0 ? customerCenter.surveyOptionID : str6);
        }

        @SerialName(DiagnosticsEntry.APP_SESSION_ID_KEY)
        public static /* synthetic */ void getAppSessionID$annotations() {
        }

        @SerialName("app_user_id")
        public static /* synthetic */ void getAppUserID$annotations() {
        }

        @SerialName("dark_mode")
        public static /* synthetic */ void getDarkMode$annotations() {
        }

        @SerialName("display_mode")
        public static /* synthetic */ void getDisplayMode$annotations() {
        }

        @SerialName("revision_id")
        public static /* synthetic */ void getRevisionID$annotations() {
        }

        @SerialName("survey_option_id")
        public static /* synthetic */ void getSurveyOptionID$annotations() {
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(CustomerCenter self, CompositeEncoder output, SerialDescriptor serialDesc) {
            BackendEvent.write$Self(self, output, serialDesc);
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            output.encodeStringElement(serialDesc, 0, self.id);
            output.encodeIntElement(serialDesc, 1, self.revisionID);
            output.encodeSerializableElement(serialDesc, 2, kSerializerArr[2], self.type);
            output.encodeStringElement(serialDesc, 3, self.appUserID);
            output.encodeStringElement(serialDesc, 4, self.appSessionID);
            output.encodeLongElement(serialDesc, 5, self.timestamp);
            output.encodeBooleanElement(serialDesc, 6, self.darkMode);
            output.encodeStringElement(serialDesc, 7, self.locale);
            output.encodeSerializableElement(serialDesc, 8, kSerializerArr[8], self.displayMode);
            output.encodeNullableSerializableElement(serialDesc, 9, kSerializerArr[9], self.path);
            output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.url);
            output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.surveyOptionID);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final CustomerCenterConfigData.HelpPath.PathType getPath() {
            return this.path;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final String getSurveyOptionID() {
            return this.surveyOptionID;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getRevisionID() {
            return this.revisionID;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final CustomerCenterEventType getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getAppUserID() {
            return this.appUserID;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getAppSessionID() {
            return this.appSessionID;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getDarkMode() {
            return this.darkMode;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getLocale() {
            return this.locale;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final CustomerCenterDisplayMode getDisplayMode() {
            return this.displayMode;
        }

        public final CustomerCenter copy(String id, int revisionID, CustomerCenterEventType type, String appUserID, String appSessionID, long timestamp, boolean darkMode, String locale, CustomerCenterDisplayMode displayMode, CustomerCenterConfigData.HelpPath.PathType path, String url, String surveyOptionID) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(appUserID, "appUserID");
            Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
            Intrinsics.checkNotNullParameter(locale, "locale");
            Intrinsics.checkNotNullParameter(displayMode, "displayMode");
            return new CustomerCenter(id, revisionID, type, appUserID, appSessionID, timestamp, darkMode, locale, displayMode, path, url, surveyOptionID);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CustomerCenter)) {
                return false;
            }
            CustomerCenter customerCenter = (CustomerCenter) other;
            return Intrinsics.areEqual(this.id, customerCenter.id) && this.revisionID == customerCenter.revisionID && this.type == customerCenter.type && Intrinsics.areEqual(this.appUserID, customerCenter.appUserID) && Intrinsics.areEqual(this.appSessionID, customerCenter.appSessionID) && this.timestamp == customerCenter.timestamp && this.darkMode == customerCenter.darkMode && Intrinsics.areEqual(this.locale, customerCenter.locale) && this.displayMode == customerCenter.displayMode && this.path == customerCenter.path && Intrinsics.areEqual(this.url, customerCenter.url) && Intrinsics.areEqual(this.surveyOptionID, customerCenter.surveyOptionID);
        }

        public final String getAppSessionID() {
            return this.appSessionID;
        }

        public final String getAppUserID() {
            return this.appUserID;
        }

        public final boolean getDarkMode() {
            return this.darkMode;
        }

        public final CustomerCenterDisplayMode getDisplayMode() {
            return this.displayMode;
        }

        public final String getId() {
            return this.id;
        }

        public final String getLocale() {
            return this.locale;
        }

        public final CustomerCenterConfigData.HelpPath.PathType getPath() {
            return this.path;
        }

        public final int getRevisionID() {
            return this.revisionID;
        }

        public final String getSurveyOptionID() {
            return this.surveyOptionID;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public final CustomerCenterEventType getType() {
            return this.type;
        }

        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            int iHashCode = ((((((((((((((((this.id.hashCode() * 31) + Integer.hashCode(this.revisionID)) * 31) + this.type.hashCode()) * 31) + this.appUserID.hashCode()) * 31) + this.appSessionID.hashCode()) * 31) + Long.hashCode(this.timestamp)) * 31) + Boolean.hashCode(this.darkMode)) * 31) + this.locale.hashCode()) * 31) + this.displayMode.hashCode()) * 31;
            CustomerCenterConfigData.HelpPath.PathType pathType = this.path;
            int iHashCode2 = (iHashCode + (pathType == null ? 0 : pathType.hashCode())) * 31;
            String str = this.url;
            int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.surveyOptionID;
            return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
        }

        @Override // com.revenuecat.purchases.utils.Event
        public String toString() {
            StringBuilder sb = new StringBuilder("CustomerCenter(id=");
            sb.append(this.id).append(", revisionID=").append(this.revisionID).append(", type=").append(this.type).append(", appUserID=").append(this.appUserID).append(", appSessionID=").append(this.appSessionID).append(", timestamp=").append(this.timestamp).append(", darkMode=").append(this.darkMode).append(", locale=").append(this.locale).append(", displayMode=").append(this.displayMode).append(", path=").append(this.path).append(", url=").append(this.url).append(", surveyOptionID=");
            sb.append(this.surveyOptionID).append(')');
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: BackendEvent.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b?\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 f2\u00020\u0001:\u0002efBá\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0002\u0010\u001bB¯\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u001cJ\t\u0010D\u001a\u00020\u0005HÆ\u0003J\t\u0010E\u001a\u00020\u0005HÆ\u0003J\t\u0010F\u001a\u00020\u0011HÆ\u0003J\t\u0010G\u001a\u00020\u0005HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010(J\u000b\u0010M\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0005HÆ\u0003J\t\u0010P\u001a\u00020\u0005HÆ\u0003J\t\u0010Q\u001a\u00020\u0005HÆ\u0003J\t\u0010R\u001a\u00020\u0005HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010T\u001a\u00020\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u000eHÆ\u0003JÐ\u0001\u0010V\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010WJ\u0013\u0010X\u001a\u00020\u00112\b\u0010Y\u001a\u0004\u0018\u00010ZHÖ\u0003J\t\u0010[\u001a\u00020\u0003HÖ\u0001J\t\u0010\\\u001a\u00020\u0005HÖ\u0001J&\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020\u00002\u0006\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020cHÁ\u0001¢\u0006\u0002\bdR\u001c\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u001e\u001a\u0004\b\"\u0010#R\u001c\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u001e\u001a\u0004\b%\u0010 R \u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010)\u0012\u0004\b&\u0010\u001e\u001a\u0004\b'\u0010(R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u001e\u001a\u0004\b+\u0010 R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u001e\u001a\u0004\b-\u0010 R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u001e\u001a\u0004\b/\u0010 R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b0\u0010 R\u001c\u0010\u0012\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b1\u0010\u001e\u001a\u0004\b2\u0010 R\u001c\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b3\u0010\u001e\u001a\u0004\b4\u0010 R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b5\u0010\u001e\u001a\u0004\b6\u0010 R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b7\u0010\u001e\u001a\u0004\b8\u0010 R\u001c\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b9\u0010\u001e\u001a\u0004\b:\u0010;R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b<\u0010\u001e\u001a\u0004\b=\u0010 R\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b>\u0010\u001e\u001a\u0004\b?\u0010 R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bB\u0010 R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bC\u0010;¨\u0006g"}, d2 = {"Lcom/revenuecat/purchases/common/events/BackendEvent$Paywalls;", "Lcom/revenuecat/purchases/common/events/BackendEvent;", "seen1", "", "id", "", "version", "type", "appUserID", "sessionID", "offeringID", "paywallID", "paywallRevision", DiagnosticsEntry.TIMESTAMP_KEY, "", "displayMode", "darkMode", "", "localeIdentifier", "exitOfferType", "exitOfferingID", "packageID", "productID", "errorCode", "errorMessage", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getAppUserID$annotations", "()V", "getAppUserID", "()Ljava/lang/String;", "getDarkMode$annotations", "getDarkMode", "()Z", "getDisplayMode$annotations", "getDisplayMode", "getErrorCode$annotations", "getErrorCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getErrorMessage$annotations", "getErrorMessage", "getExitOfferType$annotations", "getExitOfferType", "getExitOfferingID$annotations", "getExitOfferingID", "getId", "getLocaleIdentifier$annotations", "getLocaleIdentifier", "getOfferingID$annotations", "getOfferingID", "getPackageID$annotations", "getPackageID", "getPaywallID$annotations", "getPaywallID", "getPaywallRevision$annotations", "getPaywallRevision", "()I", "getProductID$annotations", "getProductID", "getSessionID$annotations", "getSessionID", "getTimestamp", "()J", "getType", "getVersion", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/revenuecat/purchases/common/events/BackendEvent$Paywalls;", "equals", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Serializable
    @SerialName("paywalls")
    public static final /* data */ class Paywalls extends BackendEvent {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String appUserID;
        private final boolean darkMode;
        private final String displayMode;
        private final Integer errorCode;
        private final String errorMessage;
        private final String exitOfferType;
        private final String exitOfferingID;
        private final String id;
        private final String localeIdentifier;
        private final String offeringID;
        private final String packageID;
        private final String paywallID;
        private final int paywallRevision;
        private final String productID;
        private final String sessionID;
        private final long timestamp;
        private final String type;
        private final int version;

        /* JADX INFO: compiled from: BackendEvent.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/common/events/BackendEvent$Paywalls$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/events/BackendEvent$Paywalls;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Paywalls> serializer() {
                return BackendEvent$Paywalls$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ Paywalls(int i, String str, int i2, String str2, @SerialName("app_user_id") String str3, @SerialName("session_id") String str4, @SerialName("offering_id") String str5, @SerialName("paywall_id") String str6, @SerialName("paywall_revision") int i3, long j, @SerialName("display_mode") String str7, @SerialName("dark_mode") boolean z, @SerialName(AndroidContextPlugin.LOCALE_KEY) String str8, @SerialName("exit_offer_type") String str9, @SerialName("exit_offering_id") String str10, @SerialName("package_id") String str11, @SerialName("product_id") String str12, @SerialName("error_code") Integer num, @SerialName("error_message") String str13, SerializationConstructorMarker serializationConstructorMarker) {
            super(i, serializationConstructorMarker);
            if (4095 != (i & 4095)) {
                PluginExceptionsKt.throwMissingFieldException(i, 4095, BackendEvent$Paywalls$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            this.version = i2;
            this.type = str2;
            this.appUserID = str3;
            this.sessionID = str4;
            this.offeringID = str5;
            this.paywallID = str6;
            this.paywallRevision = i3;
            this.timestamp = j;
            this.displayMode = str7;
            this.darkMode = z;
            this.localeIdentifier = str8;
            if ((i & 4096) == 0) {
                this.exitOfferType = null;
            } else {
                this.exitOfferType = str9;
            }
            if ((i & 8192) == 0) {
                this.exitOfferingID = null;
            } else {
                this.exitOfferingID = str10;
            }
            if ((i & 16384) == 0) {
                this.packageID = null;
            } else {
                this.packageID = str11;
            }
            if ((32768 & i) == 0) {
                this.productID = null;
            } else {
                this.productID = str12;
            }
            if ((65536 & i) == 0) {
                this.errorCode = null;
            } else {
                this.errorCode = num;
            }
            if ((i & 131072) == 0) {
                this.errorMessage = null;
            } else {
                this.errorMessage = str13;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Paywalls(String id, int i, String type, String appUserID, String sessionID, String offeringID, String str, int i2, long j, String displayMode, boolean z, String localeIdentifier, String str2, String str3, String str4, String str5, Integer num, String str6) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(appUserID, "appUserID");
            Intrinsics.checkNotNullParameter(sessionID, "sessionID");
            Intrinsics.checkNotNullParameter(offeringID, "offeringID");
            Intrinsics.checkNotNullParameter(displayMode, "displayMode");
            Intrinsics.checkNotNullParameter(localeIdentifier, "localeIdentifier");
            this.id = id;
            this.version = i;
            this.type = type;
            this.appUserID = appUserID;
            this.sessionID = sessionID;
            this.offeringID = offeringID;
            this.paywallID = str;
            this.paywallRevision = i2;
            this.timestamp = j;
            this.displayMode = displayMode;
            this.darkMode = z;
            this.localeIdentifier = localeIdentifier;
            this.exitOfferType = str2;
            this.exitOfferingID = str3;
            this.packageID = str4;
            this.productID = str5;
            this.errorCode = num;
            this.errorMessage = str6;
        }

        public /* synthetic */ Paywalls(String str, int i, String str2, String str3, String str4, String str5, String str6, int i2, long j, String str7, boolean z, String str8, String str9, String str10, String str11, String str12, Integer num, String str13, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, str2, str3, str4, str5, str6, i2, j, str7, z, str8, (i3 & 4096) != 0 ? null : str9, (i3 & 8192) != 0 ? null : str10, (i3 & 16384) != 0 ? null : str11, (32768 & i3) != 0 ? null : str12, (65536 & i3) != 0 ? null : num, (i3 & 131072) != 0 ? null : str13);
        }

        public static /* synthetic */ Paywalls copy$default(Paywalls paywalls, String str, int i, String str2, String str3, String str4, String str5, String str6, int i2, long j, String str7, boolean z, String str8, String str9, String str10, String str11, String str12, Integer num, String str13, int i3, Object obj) {
            String str14;
            Integer num2;
            String str15 = (i3 & 1) != 0 ? paywalls.id : str;
            int i4 = (i3 & 2) != 0 ? paywalls.version : i;
            String str16 = (i3 & 4) != 0 ? paywalls.type : str2;
            String str17 = (i3 & 8) != 0 ? paywalls.appUserID : str3;
            String str18 = (i3 & 16) != 0 ? paywalls.sessionID : str4;
            String str19 = (i3 & 32) != 0 ? paywalls.offeringID : str5;
            String str20 = (i3 & 64) != 0 ? paywalls.paywallID : str6;
            int i5 = (i3 & 128) != 0 ? paywalls.paywallRevision : i2;
            long j2 = (i3 & 256) != 0 ? paywalls.timestamp : j;
            String str21 = (i3 & 512) != 0 ? paywalls.displayMode : str7;
            boolean z2 = (i3 & 1024) != 0 ? paywalls.darkMode : z;
            String str22 = (i3 & 2048) != 0 ? paywalls.localeIdentifier : str8;
            String str23 = (i3 & 4096) != 0 ? paywalls.exitOfferType : str9;
            String str24 = str15;
            String str25 = (i3 & 8192) != 0 ? paywalls.exitOfferingID : str10;
            String str26 = (i3 & 16384) != 0 ? paywalls.packageID : str11;
            String str27 = (i3 & 32768) != 0 ? paywalls.productID : str12;
            Integer num3 = (i3 & 65536) != 0 ? paywalls.errorCode : num;
            if ((i3 & 131072) != 0) {
                num2 = num3;
                str14 = paywalls.errorMessage;
            } else {
                str14 = str13;
                num2 = num3;
            }
            return paywalls.copy(str24, i4, str16, str17, str18, str19, str20, i5, j2, str21, z2, str22, str23, str25, str26, str27, num2, str14);
        }

        @SerialName("app_user_id")
        public static /* synthetic */ void getAppUserID$annotations() {
        }

        @SerialName("dark_mode")
        public static /* synthetic */ void getDarkMode$annotations() {
        }

        @SerialName("display_mode")
        public static /* synthetic */ void getDisplayMode$annotations() {
        }

        @SerialName("error_code")
        public static /* synthetic */ void getErrorCode$annotations() {
        }

        @SerialName("error_message")
        public static /* synthetic */ void getErrorMessage$annotations() {
        }

        @SerialName("exit_offer_type")
        public static /* synthetic */ void getExitOfferType$annotations() {
        }

        @SerialName("exit_offering_id")
        public static /* synthetic */ void getExitOfferingID$annotations() {
        }

        @SerialName(AndroidContextPlugin.LOCALE_KEY)
        public static /* synthetic */ void getLocaleIdentifier$annotations() {
        }

        @SerialName("offering_id")
        public static /* synthetic */ void getOfferingID$annotations() {
        }

        @SerialName("package_id")
        public static /* synthetic */ void getPackageID$annotations() {
        }

        @SerialName("paywall_id")
        public static /* synthetic */ void getPaywallID$annotations() {
        }

        @SerialName("paywall_revision")
        public static /* synthetic */ void getPaywallRevision$annotations() {
        }

        @SerialName("product_id")
        public static /* synthetic */ void getProductID$annotations() {
        }

        @SerialName("session_id")
        public static /* synthetic */ void getSessionID$annotations() {
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Paywalls self, CompositeEncoder output, SerialDescriptor serialDesc) {
            BackendEvent.write$Self(self, output, serialDesc);
            output.encodeStringElement(serialDesc, 0, self.id);
            output.encodeIntElement(serialDesc, 1, self.version);
            output.encodeStringElement(serialDesc, 2, self.type);
            output.encodeStringElement(serialDesc, 3, self.appUserID);
            output.encodeStringElement(serialDesc, 4, self.sessionID);
            output.encodeStringElement(serialDesc, 5, self.offeringID);
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.paywallID);
            output.encodeIntElement(serialDesc, 7, self.paywallRevision);
            output.encodeLongElement(serialDesc, 8, self.timestamp);
            output.encodeStringElement(serialDesc, 9, self.displayMode);
            output.encodeBooleanElement(serialDesc, 10, self.darkMode);
            output.encodeStringElement(serialDesc, 11, self.localeIdentifier);
            if (output.shouldEncodeElementDefault(serialDesc, 12) || self.exitOfferType != null) {
                output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.exitOfferType);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 13) || self.exitOfferingID != null) {
                output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.exitOfferingID);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 14) || self.packageID != null) {
                output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.packageID);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 15) || self.productID != null) {
                output.encodeNullableSerializableElement(serialDesc, 15, StringSerializer.INSTANCE, self.productID);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 16) || self.errorCode != null) {
                output.encodeNullableSerializableElement(serialDesc, 16, IntSerializer.INSTANCE, self.errorCode);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 17) && self.errorMessage == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 17, StringSerializer.INSTANCE, self.errorMessage);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getDisplayMode() {
            return this.displayMode;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final boolean getDarkMode() {
            return this.darkMode;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final String getLocaleIdentifier() {
            return this.localeIdentifier;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final String getExitOfferType() {
            return this.exitOfferType;
        }

        /* JADX INFO: renamed from: component14, reason: from getter */
        public final String getExitOfferingID() {
            return this.exitOfferingID;
        }

        /* JADX INFO: renamed from: component15, reason: from getter */
        public final String getPackageID() {
            return this.packageID;
        }

        /* JADX INFO: renamed from: component16, reason: from getter */
        public final String getProductID() {
            return this.productID;
        }

        /* JADX INFO: renamed from: component17, reason: from getter */
        public final Integer getErrorCode() {
            return this.errorCode;
        }

        /* JADX INFO: renamed from: component18, reason: from getter */
        public final String getErrorMessage() {
            return this.errorMessage;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getVersion() {
            return this.version;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getAppUserID() {
            return this.appUserID;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getSessionID() {
            return this.sessionID;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getOfferingID() {
            return this.offeringID;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getPaywallID() {
            return this.paywallID;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final int getPaywallRevision() {
            return this.paywallRevision;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        public final Paywalls copy(String id, int version, String type, String appUserID, String sessionID, String offeringID, String paywallID, int paywallRevision, long timestamp, String displayMode, boolean darkMode, String localeIdentifier, String exitOfferType, String exitOfferingID, String packageID, String productID, Integer errorCode, String errorMessage) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(appUserID, "appUserID");
            Intrinsics.checkNotNullParameter(sessionID, "sessionID");
            Intrinsics.checkNotNullParameter(offeringID, "offeringID");
            Intrinsics.checkNotNullParameter(displayMode, "displayMode");
            Intrinsics.checkNotNullParameter(localeIdentifier, "localeIdentifier");
            return new Paywalls(id, version, type, appUserID, sessionID, offeringID, paywallID, paywallRevision, timestamp, displayMode, darkMode, localeIdentifier, exitOfferType, exitOfferingID, packageID, productID, errorCode, errorMessage);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Paywalls)) {
                return false;
            }
            Paywalls paywalls = (Paywalls) other;
            return Intrinsics.areEqual(this.id, paywalls.id) && this.version == paywalls.version && Intrinsics.areEqual(this.type, paywalls.type) && Intrinsics.areEqual(this.appUserID, paywalls.appUserID) && Intrinsics.areEqual(this.sessionID, paywalls.sessionID) && Intrinsics.areEqual(this.offeringID, paywalls.offeringID) && Intrinsics.areEqual(this.paywallID, paywalls.paywallID) && this.paywallRevision == paywalls.paywallRevision && this.timestamp == paywalls.timestamp && Intrinsics.areEqual(this.displayMode, paywalls.displayMode) && this.darkMode == paywalls.darkMode && Intrinsics.areEqual(this.localeIdentifier, paywalls.localeIdentifier) && Intrinsics.areEqual(this.exitOfferType, paywalls.exitOfferType) && Intrinsics.areEqual(this.exitOfferingID, paywalls.exitOfferingID) && Intrinsics.areEqual(this.packageID, paywalls.packageID) && Intrinsics.areEqual(this.productID, paywalls.productID) && Intrinsics.areEqual(this.errorCode, paywalls.errorCode) && Intrinsics.areEqual(this.errorMessage, paywalls.errorMessage);
        }

        public final String getAppUserID() {
            return this.appUserID;
        }

        public final boolean getDarkMode() {
            return this.darkMode;
        }

        public final String getDisplayMode() {
            return this.displayMode;
        }

        public final Integer getErrorCode() {
            return this.errorCode;
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public final String getExitOfferType() {
            return this.exitOfferType;
        }

        public final String getExitOfferingID() {
            return this.exitOfferingID;
        }

        public final String getId() {
            return this.id;
        }

        public final String getLocaleIdentifier() {
            return this.localeIdentifier;
        }

        public final String getOfferingID() {
            return this.offeringID;
        }

        public final String getPackageID() {
            return this.packageID;
        }

        public final String getPaywallID() {
            return this.paywallID;
        }

        public final int getPaywallRevision() {
            return this.paywallRevision;
        }

        public final String getProductID() {
            return this.productID;
        }

        public final String getSessionID() {
            return this.sessionID;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public final String getType() {
            return this.type;
        }

        public final int getVersion() {
            return this.version;
        }

        public int hashCode() {
            int iHashCode = ((((((((((this.id.hashCode() * 31) + Integer.hashCode(this.version)) * 31) + this.type.hashCode()) * 31) + this.appUserID.hashCode()) * 31) + this.sessionID.hashCode()) * 31) + this.offeringID.hashCode()) * 31;
            String str = this.paywallID;
            int iHashCode2 = (((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.paywallRevision)) * 31) + Long.hashCode(this.timestamp)) * 31) + this.displayMode.hashCode()) * 31) + Boolean.hashCode(this.darkMode)) * 31) + this.localeIdentifier.hashCode()) * 31;
            String str2 = this.exitOfferType;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.exitOfferingID;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.packageID;
            int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.productID;
            int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            Integer num = this.errorCode;
            int iHashCode7 = (iHashCode6 + (num == null ? 0 : num.hashCode())) * 31;
            String str6 = this.errorMessage;
            return iHashCode7 + (str6 != null ? str6.hashCode() : 0);
        }

        @Override // com.revenuecat.purchases.utils.Event
        public String toString() {
            StringBuilder sb = new StringBuilder("Paywalls(id=");
            sb.append(this.id).append(", version=").append(this.version).append(", type=").append(this.type).append(", appUserID=").append(this.appUserID).append(", sessionID=").append(this.sessionID).append(", offeringID=").append(this.offeringID).append(", paywallID=").append(this.paywallID).append(", paywallRevision=").append(this.paywallRevision).append(", timestamp=").append(this.timestamp).append(", displayMode=").append(this.displayMode).append(", darkMode=").append(this.darkMode).append(", localeIdentifier=");
            sb.append(this.localeIdentifier).append(", exitOfferType=").append(this.exitOfferType).append(", exitOfferingID=").append(this.exitOfferingID).append(", packageID=").append(this.packageID).append(", productID=").append(this.productID).append(", errorCode=").append(this.errorCode).append(", errorMessage=").append(this.errorMessage).append(')');
            return sb.toString();
        }
    }

    private BackendEvent() {
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ BackendEvent(int i, SerializationConstructorMarker serializationConstructorMarker) {
    }

    public /* synthetic */ BackendEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(BackendEvent self, CompositeEncoder output, SerialDescriptor serialDesc) {
    }
}
