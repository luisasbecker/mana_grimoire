package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.paywalls.components.PurchaseButtonComponent;
import com.revenuecat.purchases.utils.serializers.SealedDeserializerWithDefault;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;

/* JADX INFO: compiled from: PurchaseButtonComponent.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonMethodDeserializer;", "Lcom/revenuecat/purchases/utils/serializers/SealedDeserializerWithDefault;", "Lcom/revenuecat/purchases/paywalls/components/PurchaseButtonComponent$Method;", "()V", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PurchaseButtonMethodDeserializer extends SealedDeserializerWithDefault<PurchaseButtonComponent.Method> {
    public static final PurchaseButtonMethodDeserializer INSTANCE = new PurchaseButtonMethodDeserializer();

    private PurchaseButtonMethodDeserializer() {
        super("Method", MapsKt.mapOf(TuplesKt.to("in_app_checkout", new Function0<KSerializer<PurchaseButtonComponent.Method.InAppCheckout>>() { // from class: com.revenuecat.purchases.paywalls.components.PurchaseButtonMethodDeserializer.1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<PurchaseButtonComponent.Method.InAppCheckout> invoke() {
                return PurchaseButtonComponent.Method.InAppCheckout.INSTANCE.serializer();
            }
        }), TuplesKt.to("web_checkout", new Function0<KSerializer<PurchaseButtonComponent.Method.WebCheckout>>() { // from class: com.revenuecat.purchases.paywalls.components.PurchaseButtonMethodDeserializer.2
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<PurchaseButtonComponent.Method.WebCheckout> invoke() {
                return PurchaseButtonComponent.Method.WebCheckout.INSTANCE.serializer();
            }
        }), TuplesKt.to("web_product_selection", new Function0<KSerializer<PurchaseButtonComponent.Method.WebProductSelection>>() { // from class: com.revenuecat.purchases.paywalls.components.PurchaseButtonMethodDeserializer.3
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<PurchaseButtonComponent.Method.WebProductSelection> invoke() {
                return PurchaseButtonComponent.Method.WebProductSelection.INSTANCE.serializer();
            }
        }), TuplesKt.to("custom_web_checkout", new Function0<KSerializer<PurchaseButtonComponent.Method.CustomWebCheckout>>() { // from class: com.revenuecat.purchases.paywalls.components.PurchaseButtonMethodDeserializer.4
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<PurchaseButtonComponent.Method.CustomWebCheckout> invoke() {
                return PurchaseButtonComponent.Method.CustomWebCheckout.INSTANCE.serializer();
            }
        })), new Function1<String, PurchaseButtonComponent.Method>() { // from class: com.revenuecat.purchases.paywalls.components.PurchaseButtonMethodDeserializer.5
            @Override // kotlin.jvm.functions.Function1
            public final PurchaseButtonComponent.Method invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return PurchaseButtonComponent.Method.Unknown.INSTANCE;
            }
        }, null, 8, null);
    }
}
