package com.studiolaganne.lengendarylens;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: DataStructs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/studiolaganne/lengendarylens/BackgroundType;", "", "<init>", "(Ljava/lang/String;I)V", "PLAIN_COLOR", "MTG_COLORS", "CARD_ID", "PLAYMAT", "BLACK", "NONE", "PHOTO", "SCRYFALL_ID", "SOLID_COLOR", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BackgroundType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BackgroundType[] $VALUES;
    public static final BackgroundType PLAIN_COLOR = new BackgroundType("PLAIN_COLOR", 0);
    public static final BackgroundType MTG_COLORS = new BackgroundType("MTG_COLORS", 1);
    public static final BackgroundType CARD_ID = new BackgroundType("CARD_ID", 2);
    public static final BackgroundType PLAYMAT = new BackgroundType("PLAYMAT", 3);
    public static final BackgroundType BLACK = new BackgroundType("BLACK", 4);
    public static final BackgroundType NONE = new BackgroundType("NONE", 5);
    public static final BackgroundType PHOTO = new BackgroundType("PHOTO", 6);
    public static final BackgroundType SCRYFALL_ID = new BackgroundType("SCRYFALL_ID", 7);
    public static final BackgroundType SOLID_COLOR = new BackgroundType("SOLID_COLOR", 8);

    private static final /* synthetic */ BackgroundType[] $values() {
        return new BackgroundType[]{PLAIN_COLOR, MTG_COLORS, CARD_ID, PLAYMAT, BLACK, NONE, PHOTO, SCRYFALL_ID, SOLID_COLOR};
    }

    static {
        BackgroundType[] backgroundTypeArr$values = $values();
        $VALUES = backgroundTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(backgroundTypeArr$values);
    }

    private BackgroundType(String str, int i) {
    }

    public static EnumEntries<BackgroundType> getEntries() {
        return $ENTRIES;
    }

    public static BackgroundType valueOf(String str) {
        return (BackgroundType) Enum.valueOf(BackgroundType.class, str);
    }

    public static BackgroundType[] values() {
        return (BackgroundType[]) $VALUES.clone();
    }
}
