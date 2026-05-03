package com.studiolaganne.lengendarylens;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: DecksListActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckSortingType;", "", "<init>", "(Ljava/lang/String;I)V", "A_TO_Z", "WINRATE", "NUM_GAMES", "CREATED_AT", "UPDATED_AT", "BRACKET", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeckSortingType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DeckSortingType[] $VALUES;
    public static final DeckSortingType A_TO_Z = new DeckSortingType("A_TO_Z", 0);
    public static final DeckSortingType WINRATE = new DeckSortingType("WINRATE", 1);
    public static final DeckSortingType NUM_GAMES = new DeckSortingType("NUM_GAMES", 2);
    public static final DeckSortingType CREATED_AT = new DeckSortingType("CREATED_AT", 3);
    public static final DeckSortingType UPDATED_AT = new DeckSortingType("UPDATED_AT", 4);
    public static final DeckSortingType BRACKET = new DeckSortingType("BRACKET", 5);

    private static final /* synthetic */ DeckSortingType[] $values() {
        return new DeckSortingType[]{A_TO_Z, WINRATE, NUM_GAMES, CREATED_AT, UPDATED_AT, BRACKET};
    }

    static {
        DeckSortingType[] deckSortingTypeArr$values = $values();
        $VALUES = deckSortingTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(deckSortingTypeArr$values);
    }

    private DeckSortingType(String str, int i) {
    }

    public static EnumEntries<DeckSortingType> getEntries() {
        return $ENTRIES;
    }

    public static DeckSortingType valueOf(String str) {
        return (DeckSortingType) Enum.valueOf(DeckSortingType.class, str);
    }

    public static DeckSortingType[] values() {
        return (DeckSortingType[]) $VALUES.clone();
    }
}
