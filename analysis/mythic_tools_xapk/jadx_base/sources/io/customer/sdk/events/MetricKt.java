package io.customer.sdk.events;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Metric.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"serializedName", "", "Lio/customer/sdk/events/Metric;", "getSerializedName", "(Lio/customer/sdk/events/Metric;)Ljava/lang/String;", "core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class MetricKt {
    public static final String getSerializedName(Metric metric) {
        Intrinsics.checkNotNullParameter(metric, "<this>");
        String strName = metric.name();
        Locale ENGLISH = Locale.ENGLISH;
        Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
        String lowerCase = strName.toLowerCase(ENGLISH);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }
}
