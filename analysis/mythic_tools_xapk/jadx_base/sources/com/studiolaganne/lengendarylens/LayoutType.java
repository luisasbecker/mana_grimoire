package com.studiolaganne.lengendarylens;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: DataStructs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/studiolaganne/lengendarylens/LayoutType;", "", "<init>", "(Ljava/lang/String;I)V", "TYPE_1", "TYPE_2", "TYPE_3", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LayoutType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LayoutType[] $VALUES;
    public static final LayoutType TYPE_1 = new LayoutType("TYPE_1", 0);
    public static final LayoutType TYPE_2 = new LayoutType("TYPE_2", 1);
    public static final LayoutType TYPE_3 = new LayoutType("TYPE_3", 2);

    private static final /* synthetic */ LayoutType[] $values() {
        return new LayoutType[]{TYPE_1, TYPE_2, TYPE_3};
    }

    static {
        LayoutType[] layoutTypeArr$values = $values();
        $VALUES = layoutTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(layoutTypeArr$values);
    }

    private LayoutType(String str, int i) {
    }

    public static EnumEntries<LayoutType> getEntries() {
        return $ENTRIES;
    }

    public static LayoutType valueOf(String str) {
        return (LayoutType) Enum.valueOf(LayoutType.class, str);
    }

    public static LayoutType[] values() {
        return (LayoutType[]) $VALUES.clone();
    }
}
