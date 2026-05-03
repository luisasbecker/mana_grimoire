package com.studiolaganne.lengendarylens;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: GameUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/studiolaganne/lengendarylens/CounterType;", "", "<init>", "(Ljava/lang/String;I)V", "Tax", "Poison", "Energy", "Experience", "Storm", "Radiation", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CounterType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CounterType[] $VALUES;
    public static final CounterType Tax = new CounterType("Tax", 0);
    public static final CounterType Poison = new CounterType("Poison", 1);
    public static final CounterType Energy = new CounterType("Energy", 2);
    public static final CounterType Experience = new CounterType("Experience", 3);
    public static final CounterType Storm = new CounterType("Storm", 4);
    public static final CounterType Radiation = new CounterType("Radiation", 5);

    private static final /* synthetic */ CounterType[] $values() {
        return new CounterType[]{Tax, Poison, Energy, Experience, Storm, Radiation};
    }

    static {
        CounterType[] counterTypeArr$values = $values();
        $VALUES = counterTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(counterTypeArr$values);
    }

    private CounterType(String str, int i) {
    }

    public static EnumEntries<CounterType> getEntries() {
        return $ENTRIES;
    }

    public static CounterType valueOf(String str) {
        return (CounterType) Enum.valueOf(CounterType.class, str);
    }

    public static CounterType[] values() {
        return (CounterType[]) $VALUES.clone();
    }
}
