package com.revenuecat.purchases;

import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

/* JADX INFO: compiled from: EntitlementInfo.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/PeriodType;", "", "(Ljava/lang/String;I)V", "NORMAL", "INTRO", "TRIAL", "PREPAID", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Serializable
public enum PeriodType {
    NORMAL,
    INTRO,
    TRIAL,
    PREPAID;


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<KSerializer<Object>>() { // from class: com.revenuecat.purchases.PeriodType.Companion.1
        @Override // kotlin.jvm.functions.Function0
        public final KSerializer<Object> invoke() {
            return EnumsKt.createAnnotatedEnumSerializer("com.revenuecat.purchases.PeriodType", PeriodType.values(), new String[]{"normal", "intro", "trial", "prepaid"}, new Annotation[][]{null, null, null, null}, null);
        }
    });

    /* JADX INFO: compiled from: EntitlementInfo.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/PeriodType$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/PeriodType;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) PeriodType.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<PeriodType> serializer() {
            return get$cachedSerializer();
        }
    }
}
