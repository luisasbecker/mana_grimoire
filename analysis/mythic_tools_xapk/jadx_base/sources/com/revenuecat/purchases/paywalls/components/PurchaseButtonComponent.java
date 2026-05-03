package com.revenuecat.purchases.paywalls.components;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.paywalls.components.ButtonComponent;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey$$serializer;
import java.lang.annotation.Annotation;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.ObjectSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: PurchaseButtonComponent.kt */
/* JADX INFO: loaded from: classes5.dex */
@SerialName("purchase_button")
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0005\u001c\u001d\u001e\u001f B7\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\rJ&\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aHÁ\u0001¢\u0006\u0002\b\u001bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent;", "Lcom/revenuecat/purchases/paywalls/components/PaywallComponent;", "seen1", "", "stack", "Lcom/revenuecat/purchases/paywalls/components/StackComponent;", NativeProtocol.WEB_DIALOG_ACTION, "Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$Action;", FirebaseAnalytics.Param.METHOD, "Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$Method;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/paywalls/components/StackComponent;Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$Action;Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$Method;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/paywalls/components/StackComponent;Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$Action;Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$Method;)V", "getAction", "()Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$Action;", "getMethod", "()Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$Method;", "getStack", "()Lcom/revenuecat/purchases/paywalls/components/StackComponent;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Action", "Companion", "CustomUrl", "Method", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Serializable
public final class PurchaseButtonComponent implements PaywallComponent {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Action action;
    private final Method method;
    private final StackComponent stack;

    /* JADX INFO: compiled from: PurchaseButtonComponent.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$Action;", "", "(Ljava/lang/String;I)V", "toMethod", "Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$Method;", "IN_APP_CHECKOUT", "WEB_CHECKOUT", "WEB_PRODUCT_SELECTION", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Serializable(with = ActionDeserializer.class)
    public enum Action {
        IN_APP_CHECKOUT,
        WEB_CHECKOUT,
        WEB_PRODUCT_SELECTION;


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* JADX INFO: compiled from: PurchaseButtonComponent.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$Action$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$Action;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Action> serializer() {
                return ActionDeserializer.INSTANCE;
            }
        }

        /* JADX INFO: compiled from: PurchaseButtonComponent.kt */
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Action.values().length];
                try {
                    iArr[Action.IN_APP_CHECKOUT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Action.WEB_CHECKOUT.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Action.WEB_PRODUCT_SELECTION.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Method toMethod() {
            int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            if (i == 1) {
                return Method.InAppCheckout.INSTANCE;
            }
            int i2 = 3;
            Boolean bool = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            Object[] objArr3 = 0;
            Object[] objArr4 = 0;
            Object[] objArr5 = 0;
            if (i == 2) {
                return new Method.WebCheckout((Boolean) (objArr3 == true ? 1 : 0), (ButtonComponent.UrlMethod) (objArr2 == true ? 1 : 0), i2, (DefaultConstructorMarker) (objArr == true ? 1 : 0));
            }
            if (i == 3) {
                return new Method.WebProductSelection(bool, (ButtonComponent.UrlMethod) (objArr5 == true ? 1 : 0), i2, (DefaultConstructorMarker) (objArr4 == true ? 1 : 0));
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: compiled from: PurchaseButtonComponent.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<PurchaseButtonComponent> serializer() {
            return PurchaseButtonComponent$$serializer.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: PurchaseButtonComponent.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002&'B1\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\u0016\u0010\u0013\u001a\u00020\u0005HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u000fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J&\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$HÁ\u0001¢\u0006\u0002\b%R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0012\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006("}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$CustomUrl;", "", "seen1", "", "urlLid", "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationKey;", "packageParam", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getPackageParam$annotations", "()V", "getPackageParam", "()Ljava/lang/String;", "getUrlLid-z7Tp-4o$annotations", "getUrlLid-z7Tp-4o", "Ljava/lang/String;", "component1", "component1-z7Tp-4o", "component2", "copy", "copy-26kQY28", "(Ljava/lang/String;Ljava/lang/String;)Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$CustomUrl;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Serializable
    public static final /* data */ class CustomUrl {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String packageParam;
        private final String urlLid;

        /* JADX INFO: compiled from: PurchaseButtonComponent.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$CustomUrl$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$CustomUrl;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<CustomUrl> serializer() {
                return PurchaseButtonComponent$CustomUrl$$serializer.INSTANCE;
            }
        }

        private CustomUrl(int i, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, PurchaseButtonComponent$CustomUrl$$serializer.INSTANCE.getDescriptor());
            }
            this.urlLid = str;
            if ((i & 2) == 0) {
                this.packageParam = null;
            } else {
                this.packageParam = str2;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ CustomUrl(int i, @SerialName("url_lid") String str, @SerialName("package_param") String str2, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, str, str2, serializationConstructorMarker);
        }

        private CustomUrl(String urlLid, String str) {
            Intrinsics.checkNotNullParameter(urlLid, "urlLid");
            this.urlLid = urlLid;
            this.packageParam = str;
        }

        public /* synthetic */ CustomUrl(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2, null);
        }

        public /* synthetic */ CustomUrl(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2);
        }

        /* JADX INFO: renamed from: copy-26kQY28$default, reason: not valid java name */
        public static /* synthetic */ CustomUrl m10380copy26kQY28$default(CustomUrl customUrl, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = customUrl.urlLid;
            }
            if ((i & 2) != 0) {
                str2 = customUrl.packageParam;
            }
            return customUrl.m10383copy26kQY28(str, str2);
        }

        @SerialName("package_param")
        public static /* synthetic */ void getPackageParam$annotations() {
        }

        @SerialName("url_lid")
        /* JADX INFO: renamed from: getUrlLid-z7Tp-4o$annotations, reason: not valid java name */
        public static /* synthetic */ void m10381getUrlLidz7Tp4o$annotations() {
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(CustomUrl self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeSerializableElement(serialDesc, 0, LocalizationKey$$serializer.INSTANCE, LocalizationKey.m10428boximpl(self.urlLid));
            if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.packageParam == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.packageParam);
        }

        /* JADX INFO: renamed from: component1-z7Tp-4o, reason: not valid java name and from getter */
        public final String getUrlLid() {
            return this.urlLid;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getPackageParam() {
            return this.packageParam;
        }

        /* JADX INFO: renamed from: copy-26kQY28, reason: not valid java name */
        public final CustomUrl m10383copy26kQY28(String urlLid, String packageParam) {
            Intrinsics.checkNotNullParameter(urlLid, "urlLid");
            return new CustomUrl(urlLid, packageParam, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CustomUrl)) {
                return false;
            }
            CustomUrl customUrl = (CustomUrl) other;
            return LocalizationKey.m10431equalsimpl0(this.urlLid, customUrl.urlLid) && Intrinsics.areEqual(this.packageParam, customUrl.packageParam);
        }

        public final String getPackageParam() {
            return this.packageParam;
        }

        /* JADX INFO: renamed from: getUrlLid-z7Tp-4o, reason: not valid java name */
        public final String m10384getUrlLidz7Tp4o() {
            return this.urlLid;
        }

        public int hashCode() {
            int iM10432hashCodeimpl = LocalizationKey.m10432hashCodeimpl(this.urlLid) * 31;
            String str = this.packageParam;
            return iM10432hashCodeimpl + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "CustomUrl(urlLid=" + ((Object) LocalizationKey.m10433toStringimpl(this.urlLid)) + ", packageParam=" + this.packageParam + ')';
        }
    }

    /* JADX INFO: compiled from: PurchaseButtonComponent.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u00022\u00020\u0001:\u0006\u0002\u0003\u0004\u0005\u0006\u0007\u0082\u0001\u0005\b\t\n\u000b\f¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$Method;", "", "Companion", "CustomWebCheckout", "InAppCheckout", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "WebCheckout", "WebProductSelection", "Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$Method$CustomWebCheckout;", "Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$Method$InAppCheckout;", "Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$Method$Unknown;", "Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$Method$WebCheckout;", "Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$Method$WebProductSelection;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Serializable(with = PurchaseButtonMethodDeserializer.class)
    public interface Method {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        /* JADX INFO: compiled from: PurchaseButtonComponent.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$Method$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$Method;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            public final KSerializer<Method> serializer() {
                return PurchaseButtonMethodDeserializer.INSTANCE;
            }
        }

        /* JADX INFO: compiled from: PurchaseButtonComponent.kt */
        @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0002,-B=\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003J0\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001J&\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*HÁ\u0001¢\u0006\u0002\b+R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0012\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0018¨\u0006."}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$Method$CustomWebCheckout;", "Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$Method;", "seen1", "", "customUrl", "Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$CustomUrl;", "autoDismiss", "", "openMethod", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$CustomUrl;Ljava/lang/Boolean;Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$CustomUrl;Ljava/lang/Boolean;Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;)V", "getAutoDismiss$annotations", "()V", "getAutoDismiss", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCustomUrl$annotations", "getCustomUrl", "()Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$CustomUrl;", "getOpenMethod$annotations", "getOpenMethod", "()Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", "component1", "component2", "component3", "copy", "(Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$CustomUrl;Ljava/lang/Boolean;Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;)Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$Method$CustomWebCheckout;", "equals", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        @Serializable
        public static final /* data */ class CustomWebCheckout implements Method {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final Boolean autoDismiss;
            private final CustomUrl customUrl;
            private final ButtonComponent.UrlMethod openMethod;

            /* JADX INFO: compiled from: PurchaseButtonComponent.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$Method$CustomWebCheckout$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$Method$CustomWebCheckout;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer<CustomWebCheckout> serializer() {
                    return PurchaseButtonComponent$Method$CustomWebCheckout$$serializer.INSTANCE;
                }
            }

            @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
            public /* synthetic */ CustomWebCheckout(int i, @SerialName("custom_url") CustomUrl customUrl, @SerialName("auto_dismiss") Boolean bool, @SerialName("open_method") ButtonComponent.UrlMethod urlMethod, SerializationConstructorMarker serializationConstructorMarker) {
                if (1 != (i & 1)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 1, PurchaseButtonComponent$Method$CustomWebCheckout$$serializer.INSTANCE.getDescriptor());
                }
                this.customUrl = customUrl;
                if ((i & 2) == 0) {
                    this.autoDismiss = null;
                } else {
                    this.autoDismiss = bool;
                }
                if ((i & 4) == 0) {
                    this.openMethod = null;
                } else {
                    this.openMethod = urlMethod;
                }
            }

            public CustomWebCheckout(CustomUrl customUrl, Boolean bool, ButtonComponent.UrlMethod urlMethod) {
                Intrinsics.checkNotNullParameter(customUrl, "customUrl");
                this.customUrl = customUrl;
                this.autoDismiss = bool;
                this.openMethod = urlMethod;
            }

            public /* synthetic */ CustomWebCheckout(CustomUrl customUrl, Boolean bool, ButtonComponent.UrlMethod urlMethod, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(customUrl, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : urlMethod);
            }

            public static /* synthetic */ CustomWebCheckout copy$default(CustomWebCheckout customWebCheckout, CustomUrl customUrl, Boolean bool, ButtonComponent.UrlMethod urlMethod, int i, Object obj) {
                if ((i & 1) != 0) {
                    customUrl = customWebCheckout.customUrl;
                }
                if ((i & 2) != 0) {
                    bool = customWebCheckout.autoDismiss;
                }
                if ((i & 4) != 0) {
                    urlMethod = customWebCheckout.openMethod;
                }
                return customWebCheckout.copy(customUrl, bool, urlMethod);
            }

            @SerialName("auto_dismiss")
            public static /* synthetic */ void getAutoDismiss$annotations() {
            }

            @SerialName("custom_url")
            public static /* synthetic */ void getCustomUrl$annotations() {
            }

            @SerialName("open_method")
            public static /* synthetic */ void getOpenMethod$annotations() {
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(CustomWebCheckout self, CompositeEncoder output, SerialDescriptor serialDesc) {
                output.encodeSerializableElement(serialDesc, 0, PurchaseButtonComponent$CustomUrl$$serializer.INSTANCE, self.customUrl);
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.autoDismiss != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.autoDismiss);
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.openMethod == null) {
                    return;
                }
                output.encodeNullableSerializableElement(serialDesc, 2, UrlMethodDeserializer.INSTANCE, self.openMethod);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final CustomUrl getCustomUrl() {
                return this.customUrl;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Boolean getAutoDismiss() {
                return this.autoDismiss;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final ButtonComponent.UrlMethod getOpenMethod() {
                return this.openMethod;
            }

            public final CustomWebCheckout copy(CustomUrl customUrl, Boolean autoDismiss, ButtonComponent.UrlMethod openMethod) {
                Intrinsics.checkNotNullParameter(customUrl, "customUrl");
                return new CustomWebCheckout(customUrl, autoDismiss, openMethod);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CustomWebCheckout)) {
                    return false;
                }
                CustomWebCheckout customWebCheckout = (CustomWebCheckout) other;
                return Intrinsics.areEqual(this.customUrl, customWebCheckout.customUrl) && Intrinsics.areEqual(this.autoDismiss, customWebCheckout.autoDismiss) && this.openMethod == customWebCheckout.openMethod;
            }

            public final /* synthetic */ Boolean getAutoDismiss() {
                return this.autoDismiss;
            }

            public final /* synthetic */ CustomUrl getCustomUrl() {
                return this.customUrl;
            }

            public final /* synthetic */ ButtonComponent.UrlMethod getOpenMethod() {
                return this.openMethod;
            }

            public int hashCode() {
                int iHashCode = this.customUrl.hashCode() * 31;
                Boolean bool = this.autoDismiss;
                int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
                ButtonComponent.UrlMethod urlMethod = this.openMethod;
                return iHashCode2 + (urlMethod != null ? urlMethod.hashCode() : 0);
            }

            public String toString() {
                return "CustomWebCheckout(customUrl=" + this.customUrl + ", autoDismiss=" + this.autoDismiss + ", openMethod=" + this.openMethod + ')';
            }
        }

        /* JADX INFO: compiled from: PurchaseButtonComponent.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004HÆ\u0001¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$Method$InAppCheckout;", "Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$Method;", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        @Serializable
        public static final class InAppCheckout implements Method {
            public static final InAppCheckout INSTANCE = new InAppCheckout();
            private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KSerializer<Object>>() { // from class: com.revenuecat.purchases.paywalls.components.PurchaseButtonComponent.Method.InAppCheckout.1
                @Override // kotlin.jvm.functions.Function0
                public final KSerializer<Object> invoke() {
                    return new ObjectSerializer("com.revenuecat.purchases.paywalls.components.PurchaseButtonComponent.Method.InAppCheckout", InAppCheckout.INSTANCE, new Annotation[0]);
                }
            });

            private InAppCheckout() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return $cachedSerializer$delegate.getValue();
            }

            public final KSerializer<InAppCheckout> serializer() {
                return get$cachedSerializer();
            }
        }

        /* JADX INFO: compiled from: PurchaseButtonComponent.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004HÆ\u0001¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$Method$Unknown;", "Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$Method;", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        @Serializable
        public static final class Unknown implements Method {
            public static final Unknown INSTANCE = new Unknown();
            private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KSerializer<Object>>() { // from class: com.revenuecat.purchases.paywalls.components.PurchaseButtonComponent.Method.Unknown.1
                @Override // kotlin.jvm.functions.Function0
                public final KSerializer<Object> invoke() {
                    return new ObjectSerializer("com.revenuecat.purchases.paywalls.components.PurchaseButtonComponent.Method.Unknown", Unknown.INSTANCE, new Annotation[0]);
                }
            });

            private Unknown() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return $cachedSerializer$delegate.getValue();
            }

            public final KSerializer<Unknown> serializer() {
                return get$cachedSerializer();
            }
        }

        /* JADX INFO: compiled from: PurchaseButtonComponent.kt */
        @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002&'B1\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u001d\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J&\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J&\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$HÁ\u0001¢\u0006\u0002\b%R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0010\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u0013¨\u0006("}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$Method$WebCheckout;", "Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$Method;", "seen1", "", "autoDismiss", "", "openMethod", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Boolean;Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;)V", "getAutoDismiss$annotations", "()V", "getAutoDismiss", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getOpenMethod$annotations", "getOpenMethod", "()Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;)Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$Method$WebCheckout;", "equals", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        @Serializable
        public static final /* data */ class WebCheckout implements Method {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final Boolean autoDismiss;
            private final ButtonComponent.UrlMethod openMethod;

            /* JADX INFO: compiled from: PurchaseButtonComponent.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$Method$WebCheckout$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$Method$WebCheckout;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer<WebCheckout> serializer() {
                    return PurchaseButtonComponent$Method$WebCheckout$$serializer.INSTANCE;
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public WebCheckout() {
                this((Boolean) null, (ButtonComponent.UrlMethod) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
            }

            @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
            public /* synthetic */ WebCheckout(int i, @SerialName("auto_dismiss") Boolean bool, @SerialName("open_method") ButtonComponent.UrlMethod urlMethod, SerializationConstructorMarker serializationConstructorMarker) {
                if ((i & 1) == 0) {
                    this.autoDismiss = null;
                } else {
                    this.autoDismiss = bool;
                }
                if ((i & 2) == 0) {
                    this.openMethod = null;
                } else {
                    this.openMethod = urlMethod;
                }
            }

            public WebCheckout(Boolean bool, ButtonComponent.UrlMethod urlMethod) {
                this.autoDismiss = bool;
                this.openMethod = urlMethod;
            }

            public /* synthetic */ WebCheckout(Boolean bool, ButtonComponent.UrlMethod urlMethod, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : urlMethod);
            }

            public static /* synthetic */ WebCheckout copy$default(WebCheckout webCheckout, Boolean bool, ButtonComponent.UrlMethod urlMethod, int i, Object obj) {
                if ((i & 1) != 0) {
                    bool = webCheckout.autoDismiss;
                }
                if ((i & 2) != 0) {
                    urlMethod = webCheckout.openMethod;
                }
                return webCheckout.copy(bool, urlMethod);
            }

            @SerialName("auto_dismiss")
            public static /* synthetic */ void getAutoDismiss$annotations() {
            }

            @SerialName("open_method")
            public static /* synthetic */ void getOpenMethod$annotations() {
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(WebCheckout self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.autoDismiss != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.autoDismiss);
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.openMethod == null) {
                    return;
                }
                output.encodeNullableSerializableElement(serialDesc, 1, UrlMethodDeserializer.INSTANCE, self.openMethod);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Boolean getAutoDismiss() {
                return this.autoDismiss;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final ButtonComponent.UrlMethod getOpenMethod() {
                return this.openMethod;
            }

            public final WebCheckout copy(Boolean autoDismiss, ButtonComponent.UrlMethod openMethod) {
                return new WebCheckout(autoDismiss, openMethod);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof WebCheckout)) {
                    return false;
                }
                WebCheckout webCheckout = (WebCheckout) other;
                return Intrinsics.areEqual(this.autoDismiss, webCheckout.autoDismiss) && this.openMethod == webCheckout.openMethod;
            }

            public final /* synthetic */ Boolean getAutoDismiss() {
                return this.autoDismiss;
            }

            public final /* synthetic */ ButtonComponent.UrlMethod getOpenMethod() {
                return this.openMethod;
            }

            public int hashCode() {
                Boolean bool = this.autoDismiss;
                int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
                ButtonComponent.UrlMethod urlMethod = this.openMethod;
                return iHashCode + (urlMethod != null ? urlMethod.hashCode() : 0);
            }

            public String toString() {
                return "WebCheckout(autoDismiss=" + this.autoDismiss + ", openMethod=" + this.openMethod + ')';
            }
        }

        /* JADX INFO: compiled from: PurchaseButtonComponent.kt */
        @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002&'B1\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u001d\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J&\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J&\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$HÁ\u0001¢\u0006\u0002\b%R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0010\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u0013¨\u0006("}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$Method$WebProductSelection;", "Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$Method;", "seen1", "", "autoDismiss", "", "openMethod", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Boolean;Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;)V", "getAutoDismiss$annotations", "()V", "getAutoDismiss", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getOpenMethod$annotations", "getOpenMethod", "()Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;)Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$Method$WebProductSelection;", "equals", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        @Serializable
        public static final /* data */ class WebProductSelection implements Method {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final Boolean autoDismiss;
            private final ButtonComponent.UrlMethod openMethod;

            /* JADX INFO: compiled from: PurchaseButtonComponent.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$Method$WebProductSelection$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$Method$WebProductSelection;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final KSerializer<WebProductSelection> serializer() {
                    return PurchaseButtonComponent$Method$WebProductSelection$$serializer.INSTANCE;
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public WebProductSelection() {
                this((Boolean) null, (ButtonComponent.UrlMethod) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
            }

            @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
            public /* synthetic */ WebProductSelection(int i, @SerialName("auto_dismiss") Boolean bool, @SerialName("open_method") ButtonComponent.UrlMethod urlMethod, SerializationConstructorMarker serializationConstructorMarker) {
                if ((i & 1) == 0) {
                    this.autoDismiss = null;
                } else {
                    this.autoDismiss = bool;
                }
                if ((i & 2) == 0) {
                    this.openMethod = null;
                } else {
                    this.openMethod = urlMethod;
                }
            }

            public WebProductSelection(Boolean bool, ButtonComponent.UrlMethod urlMethod) {
                this.autoDismiss = bool;
                this.openMethod = urlMethod;
            }

            public /* synthetic */ WebProductSelection(Boolean bool, ButtonComponent.UrlMethod urlMethod, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : urlMethod);
            }

            public static /* synthetic */ WebProductSelection copy$default(WebProductSelection webProductSelection, Boolean bool, ButtonComponent.UrlMethod urlMethod, int i, Object obj) {
                if ((i & 1) != 0) {
                    bool = webProductSelection.autoDismiss;
                }
                if ((i & 2) != 0) {
                    urlMethod = webProductSelection.openMethod;
                }
                return webProductSelection.copy(bool, urlMethod);
            }

            @SerialName("auto_dismiss")
            public static /* synthetic */ void getAutoDismiss$annotations() {
            }

            @SerialName("open_method")
            public static /* synthetic */ void getOpenMethod$annotations() {
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(WebProductSelection self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.autoDismiss != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.autoDismiss);
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.openMethod == null) {
                    return;
                }
                output.encodeNullableSerializableElement(serialDesc, 1, UrlMethodDeserializer.INSTANCE, self.openMethod);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Boolean getAutoDismiss() {
                return this.autoDismiss;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final ButtonComponent.UrlMethod getOpenMethod() {
                return this.openMethod;
            }

            public final WebProductSelection copy(Boolean autoDismiss, ButtonComponent.UrlMethod openMethod) {
                return new WebProductSelection(autoDismiss, openMethod);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof WebProductSelection)) {
                    return false;
                }
                WebProductSelection webProductSelection = (WebProductSelection) other;
                return Intrinsics.areEqual(this.autoDismiss, webProductSelection.autoDismiss) && this.openMethod == webProductSelection.openMethod;
            }

            public final /* synthetic */ Boolean getAutoDismiss() {
                return this.autoDismiss;
            }

            public final /* synthetic */ ButtonComponent.UrlMethod getOpenMethod() {
                return this.openMethod;
            }

            public int hashCode() {
                Boolean bool = this.autoDismiss;
                int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
                ButtonComponent.UrlMethod urlMethod = this.openMethod;
                return iHashCode + (urlMethod != null ? urlMethod.hashCode() : 0);
            }

            public String toString() {
                return "WebProductSelection(autoDismiss=" + this.autoDismiss + ", openMethod=" + this.openMethod + ')';
            }
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ PurchaseButtonComponent(int i, StackComponent stackComponent, Action action, Method method, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, PurchaseButtonComponent$$serializer.INSTANCE.getDescriptor());
        }
        this.stack = stackComponent;
        if ((i & 2) == 0) {
            this.action = null;
        } else {
            this.action = action;
        }
        if ((i & 4) == 0) {
            this.method = null;
        } else {
            this.method = method;
        }
    }

    public PurchaseButtonComponent(StackComponent stack, Action action, Method method) {
        Intrinsics.checkNotNullParameter(stack, "stack");
        this.stack = stack;
        this.action = action;
        this.method = method;
    }

    public /* synthetic */ PurchaseButtonComponent(StackComponent stackComponent, Action action, Method method, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(stackComponent, (i & 2) != 0 ? null : action, (i & 4) != 0 ? null : method);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PurchaseButtonComponent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, StackComponent$$serializer.INSTANCE, self.stack);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.action != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, ActionDeserializer.INSTANCE, self.action);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.method == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 2, PurchaseButtonMethodDeserializer.INSTANCE, self.method);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PurchaseButtonComponent)) {
            return false;
        }
        PurchaseButtonComponent purchaseButtonComponent = (PurchaseButtonComponent) obj;
        return Intrinsics.areEqual(this.stack, purchaseButtonComponent.stack) && this.action == purchaseButtonComponent.action && Intrinsics.areEqual(this.method, purchaseButtonComponent.method);
    }

    public final /* synthetic */ Action getAction() {
        return this.action;
    }

    public final /* synthetic */ Method getMethod() {
        return this.method;
    }

    public final /* synthetic */ StackComponent getStack() {
        return this.stack;
    }

    public int hashCode() {
        int iHashCode = this.stack.hashCode() * 31;
        Action action = this.action;
        int iHashCode2 = (iHashCode + (action == null ? 0 : action.hashCode())) * 31;
        Method method = this.method;
        return iHashCode2 + (method != null ? method.hashCode() : 0);
    }

    public String toString() {
        return "PurchaseButtonComponent(stack=" + this.stack + ", action=" + this.action + ", method=" + this.method + ')';
    }
}
