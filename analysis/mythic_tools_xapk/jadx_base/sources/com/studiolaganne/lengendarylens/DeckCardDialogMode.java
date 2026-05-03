package com.studiolaganne.lengendarylens;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: DeckMoveCardDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckCardDialogMode;", "", "<init>", "(Ljava/lang/String;I)V", "MOVE", "BULK_MOVE", "ADD", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeckCardDialogMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DeckCardDialogMode[] $VALUES;
    public static final DeckCardDialogMode MOVE = new DeckCardDialogMode("MOVE", 0);
    public static final DeckCardDialogMode BULK_MOVE = new DeckCardDialogMode("BULK_MOVE", 1);
    public static final DeckCardDialogMode ADD = new DeckCardDialogMode("ADD", 2);

    private static final /* synthetic */ DeckCardDialogMode[] $values() {
        return new DeckCardDialogMode[]{MOVE, BULK_MOVE, ADD};
    }

    static {
        DeckCardDialogMode[] deckCardDialogModeArr$values = $values();
        $VALUES = deckCardDialogModeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(deckCardDialogModeArr$values);
    }

    private DeckCardDialogMode(String str, int i) {
    }

    public static EnumEntries<DeckCardDialogMode> getEntries() {
        return $ENTRIES;
    }

    public static DeckCardDialogMode valueOf(String str) {
        return (DeckCardDialogMode) Enum.valueOf(DeckCardDialogMode.class, str);
    }

    public static DeckCardDialogMode[] values() {
        return (DeckCardDialogMode[]) $VALUES.clone();
    }
}
