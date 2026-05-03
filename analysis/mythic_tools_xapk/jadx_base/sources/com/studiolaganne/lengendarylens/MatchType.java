package com.studiolaganne.lengendarylens;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: DataStructs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/studiolaganne/lengendarylens/MatchType;", "", "<init>", "(Ljava/lang/String;I)V", "BO1", "BO3", "BO5", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MatchType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MatchType[] $VALUES;
    public static final MatchType BO1 = new MatchType("BO1", 0);
    public static final MatchType BO3 = new MatchType("BO3", 1);
    public static final MatchType BO5 = new MatchType("BO5", 2);

    private static final /* synthetic */ MatchType[] $values() {
        return new MatchType[]{BO1, BO3, BO5};
    }

    static {
        MatchType[] matchTypeArr$values = $values();
        $VALUES = matchTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(matchTypeArr$values);
    }

    private MatchType(String str, int i) {
    }

    public static EnumEntries<MatchType> getEntries() {
        return $ENTRIES;
    }

    public static MatchType valueOf(String str) {
        return (MatchType) Enum.valueOf(MatchType.class, str);
    }

    public static MatchType[] values() {
        return (MatchType[]) $VALUES.clone();
    }
}
