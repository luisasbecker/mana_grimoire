package com.studiolaganne.lengendarylens;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: DeckIdCardArcGaugeView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckIdCardGaugeCenterMode;", "", "<init>", "(Ljava/lang/String;I)V", "ICON", "SCORE_TEXT", "QUESTION_MARK", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeckIdCardGaugeCenterMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DeckIdCardGaugeCenterMode[] $VALUES;
    public static final DeckIdCardGaugeCenterMode ICON = new DeckIdCardGaugeCenterMode("ICON", 0);
    public static final DeckIdCardGaugeCenterMode SCORE_TEXT = new DeckIdCardGaugeCenterMode("SCORE_TEXT", 1);
    public static final DeckIdCardGaugeCenterMode QUESTION_MARK = new DeckIdCardGaugeCenterMode("QUESTION_MARK", 2);

    private static final /* synthetic */ DeckIdCardGaugeCenterMode[] $values() {
        return new DeckIdCardGaugeCenterMode[]{ICON, SCORE_TEXT, QUESTION_MARK};
    }

    static {
        DeckIdCardGaugeCenterMode[] deckIdCardGaugeCenterModeArr$values = $values();
        $VALUES = deckIdCardGaugeCenterModeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(deckIdCardGaugeCenterModeArr$values);
    }

    private DeckIdCardGaugeCenterMode(String str, int i) {
    }

    public static EnumEntries<DeckIdCardGaugeCenterMode> getEntries() {
        return $ENTRIES;
    }

    public static DeckIdCardGaugeCenterMode valueOf(String str) {
        return (DeckIdCardGaugeCenterMode) Enum.valueOf(DeckIdCardGaugeCenterMode.class, str);
    }

    public static DeckIdCardGaugeCenterMode[] values() {
        return (DeckIdCardGaugeCenterMode[]) $VALUES.clone();
    }
}
