package com.studiolaganne.lengendarylens;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: DataStructs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0013\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/studiolaganne/lengendarylens/SortBy;", "", "<init>", "(Ljava/lang/String;I)V", "ADDED_DATE", "COLLECTOR_NUMBER", "NAME", "QUANTITY", "FOIL_STATUS", "SET_CODE", "CONDITION", "LANGUAGE", "PRICE", "TOTAL_PRICE", "ALTERED", "SIGNED", "MISPRINT", "PROXY", "MANA_VALUE", "RARITY", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SortBy {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SortBy[] $VALUES;
    public static final SortBy ADDED_DATE = new SortBy("ADDED_DATE", 0);
    public static final SortBy COLLECTOR_NUMBER = new SortBy("COLLECTOR_NUMBER", 1);
    public static final SortBy NAME = new SortBy("NAME", 2);
    public static final SortBy QUANTITY = new SortBy("QUANTITY", 3);
    public static final SortBy FOIL_STATUS = new SortBy("FOIL_STATUS", 4);
    public static final SortBy SET_CODE = new SortBy("SET_CODE", 5);
    public static final SortBy CONDITION = new SortBy("CONDITION", 6);
    public static final SortBy LANGUAGE = new SortBy("LANGUAGE", 7);
    public static final SortBy PRICE = new SortBy("PRICE", 8);
    public static final SortBy TOTAL_PRICE = new SortBy("TOTAL_PRICE", 9);
    public static final SortBy ALTERED = new SortBy("ALTERED", 10);
    public static final SortBy SIGNED = new SortBy("SIGNED", 11);
    public static final SortBy MISPRINT = new SortBy("MISPRINT", 12);
    public static final SortBy PROXY = new SortBy("PROXY", 13);
    public static final SortBy MANA_VALUE = new SortBy("MANA_VALUE", 14);
    public static final SortBy RARITY = new SortBy("RARITY", 15);

    private static final /* synthetic */ SortBy[] $values() {
        return new SortBy[]{ADDED_DATE, COLLECTOR_NUMBER, NAME, QUANTITY, FOIL_STATUS, SET_CODE, CONDITION, LANGUAGE, PRICE, TOTAL_PRICE, ALTERED, SIGNED, MISPRINT, PROXY, MANA_VALUE, RARITY};
    }

    static {
        SortBy[] sortByArr$values = $values();
        $VALUES = sortByArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(sortByArr$values);
    }

    private SortBy(String str, int i) {
    }

    public static EnumEntries<SortBy> getEntries() {
        return $ENTRIES;
    }

    public static SortBy valueOf(String str) {
        return (SortBy) Enum.valueOf(SortBy.class, str);
    }

    public static SortBy[] values() {
        return (SortBy[]) $VALUES.clone();
    }
}
