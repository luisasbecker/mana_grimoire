package com.revenuecat.purchases.paywalls.components;

import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.ObjectSerializer;

/* JADX INFO: compiled from: FallbackHeaderComponent.kt */
/* JADX INFO: loaded from: classes5.dex */
@SerialName("fallback_header")
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004HÆ\u0001¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/FallbackHeaderComponent;", "Lcom/revenuecat/purchases/paywalls/components/PaywallComponent;", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Serializable
public final class FallbackHeaderComponent implements PaywallComponent {
    public static final FallbackHeaderComponent INSTANCE = new FallbackHeaderComponent();
    private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KSerializer<Object>>() { // from class: com.revenuecat.purchases.paywalls.components.FallbackHeaderComponent.1
        @Override // kotlin.jvm.functions.Function0
        public final KSerializer<Object> invoke() {
            return new ObjectSerializer("fallback_header", FallbackHeaderComponent.INSTANCE, new Annotation[0]);
        }
    });

    private FallbackHeaderComponent() {
    }

    private final /* synthetic */ KSerializer get$cachedSerializer() {
        return $cachedSerializer$delegate.getValue();
    }

    public final KSerializer<FallbackHeaderComponent> serializer() {
        return get$cachedSerializer();
    }
}
