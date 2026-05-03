package io.customer.datapipelines.di;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: SDKComponentKeys.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lio/customer/datapipelines/di/SDKComponentKeys;", "", "<init>", "(Ljava/lang/String;I)V", "AnalyticsFactory", "datapipelines_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SDKComponentKeys {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SDKComponentKeys[] $VALUES;
    public static final SDKComponentKeys AnalyticsFactory = new SDKComponentKeys("AnalyticsFactory", 0);

    private static final /* synthetic */ SDKComponentKeys[] $values() {
        return new SDKComponentKeys[]{AnalyticsFactory};
    }

    static {
        SDKComponentKeys[] sDKComponentKeysArr$values = $values();
        $VALUES = sDKComponentKeysArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(sDKComponentKeysArr$values);
    }

    private SDKComponentKeys(String str, int i) {
    }

    public static EnumEntries<SDKComponentKeys> getEntries() {
        return $ENTRIES;
    }

    public static SDKComponentKeys valueOf(String str) {
        return (SDKComponentKeys) Enum.valueOf(SDKComponentKeys.class, str);
    }

    public static SDKComponentKeys[] values() {
        return (SDKComponentKeys[]) $VALUES.clone();
    }
}
