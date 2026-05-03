package com.revenuecat.purchases.paywalls.components.common.serializers;

import com.revenuecat.purchases.models.GoogleReplacementMode;
import com.revenuecat.purchases.utils.serializers.EnumDeserializerWithDefault;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReplacementModeDeserializers.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/common/serializers/DowngradeReplacementModeDeserializer;", "Lcom/revenuecat/purchases/utils/serializers/EnumDeserializerWithDefault;", "Lcom/revenuecat/purchases/models/GoogleReplacementMode;", "()V", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DowngradeReplacementModeDeserializer extends EnumDeserializerWithDefault<GoogleReplacementMode> {
    public static final DowngradeReplacementModeDeserializer INSTANCE = new DowngradeReplacementModeDeserializer();

    private DowngradeReplacementModeDeserializer() {
        super(GoogleReplacementMode.DEFERRED, new Function1<GoogleReplacementMode, String>() { // from class: com.revenuecat.purchases.paywalls.components.common.serializers.DowngradeReplacementModeDeserializer.1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(GoogleReplacementMode value) {
                Intrinsics.checkNotNullParameter(value, "value");
                String lowerCase = value.name().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                return lowerCase;
            }
        });
    }
}
