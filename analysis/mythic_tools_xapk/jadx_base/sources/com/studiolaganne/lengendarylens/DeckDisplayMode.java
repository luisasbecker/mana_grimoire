package com.studiolaganne.lengendarylens;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: DeckCardItem.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckDisplayMode;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "LIST", "ONE_COLUMN_STACKS", "TWO_COLUMN_STACKS", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeckDisplayMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DeckDisplayMode[] $VALUES;
    public static final DeckDisplayMode LIST = new DeckDisplayMode("LIST", 0, "list");
    public static final DeckDisplayMode ONE_COLUMN_STACKS = new DeckDisplayMode("ONE_COLUMN_STACKS", 1, "stacks_1");
    public static final DeckDisplayMode TWO_COLUMN_STACKS = new DeckDisplayMode("TWO_COLUMN_STACKS", 2, "stacks_2");
    private final String value;

    private static final /* synthetic */ DeckDisplayMode[] $values() {
        return new DeckDisplayMode[]{LIST, ONE_COLUMN_STACKS, TWO_COLUMN_STACKS};
    }

    static {
        DeckDisplayMode[] deckDisplayModeArr$values = $values();
        $VALUES = deckDisplayModeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(deckDisplayModeArr$values);
    }

    private DeckDisplayMode(String str, int i, String str2) {
        this.value = str2;
    }

    public static EnumEntries<DeckDisplayMode> getEntries() {
        return $ENTRIES;
    }

    public static DeckDisplayMode valueOf(String str) {
        return (DeckDisplayMode) Enum.valueOf(DeckDisplayMode.class, str);
    }

    public static DeckDisplayMode[] values() {
        return (DeckDisplayMode[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }
}
