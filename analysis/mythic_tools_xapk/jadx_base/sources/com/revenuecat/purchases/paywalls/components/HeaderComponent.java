package com.revenuecat.purchases.paywalls.components;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: HeaderComponent.kt */
/* JADX INFO: loaded from: classes5.dex */
@SerialName("header")
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0002\u0014\u0015B#\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ&\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012HÁ\u0001¢\u0006\u0002\b\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/HeaderComponent;", "Lcom/revenuecat/purchases/paywalls/components/PaywallComponent;", "seen1", "", "stack", "Lcom/revenuecat/purchases/paywalls/components/StackComponent;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/paywalls/components/StackComponent;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/paywalls/components/StackComponent;)V", "getStack", "()Lcom/revenuecat/purchases/paywalls/components/StackComponent;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Serializable
public final class HeaderComponent implements PaywallComponent {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final StackComponent stack;

    /* JADX INFO: compiled from: HeaderComponent.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/HeaderComponent$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/HeaderComponent;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<HeaderComponent> serializer() {
            return HeaderComponent$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ HeaderComponent(int i, StackComponent stackComponent, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, HeaderComponent$$serializer.INSTANCE.getDescriptor());
        }
        this.stack = stackComponent;
    }

    public HeaderComponent(StackComponent stack) {
        Intrinsics.checkNotNullParameter(stack, "stack");
        this.stack = stack;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof HeaderComponent) && Intrinsics.areEqual(this.stack, ((HeaderComponent) obj).stack);
    }

    public final /* synthetic */ StackComponent getStack() {
        return this.stack;
    }

    public int hashCode() {
        return this.stack.hashCode();
    }

    public String toString() {
        return "HeaderComponent(stack=" + this.stack + ')';
    }
}
