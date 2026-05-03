package io.customer.sdk.events;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: Metric.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lio/customer/sdk/events/Metric;", "", "<init>", "(Ljava/lang/String;I)V", "Delivered", "Opened", "Converted", "Clicked", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Metric {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Metric[] $VALUES;
    public static final Metric Delivered = new Metric("Delivered", 0);
    public static final Metric Opened = new Metric("Opened", 1);
    public static final Metric Converted = new Metric("Converted", 2);
    public static final Metric Clicked = new Metric("Clicked", 3);

    private static final /* synthetic */ Metric[] $values() {
        return new Metric[]{Delivered, Opened, Converted, Clicked};
    }

    static {
        Metric[] metricArr$values = $values();
        $VALUES = metricArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(metricArr$values);
    }

    private Metric(String str, int i) {
    }

    public static EnumEntries<Metric> getEntries() {
        return $ENTRIES;
    }

    public static Metric valueOf(String str) {
        return (Metric) Enum.valueOf(Metric.class, str);
    }

    public static Metric[] values() {
        return (Metric[]) $VALUES.clone();
    }
}
