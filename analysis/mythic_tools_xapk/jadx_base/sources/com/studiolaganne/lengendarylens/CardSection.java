package com.studiolaganne.lengendarylens;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: DeckListTxtParser.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/studiolaganne/lengendarylens/CardSection;", "", "<init>", "(Ljava/lang/String;I)V", "MAIN_DECK", "SIDEBOARD", "MAYBEBOARD", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CardSection {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CardSection[] $VALUES;
    public static final CardSection MAIN_DECK = new CardSection("MAIN_DECK", 0);
    public static final CardSection SIDEBOARD = new CardSection("SIDEBOARD", 1);
    public static final CardSection MAYBEBOARD = new CardSection("MAYBEBOARD", 2);

    private static final /* synthetic */ CardSection[] $values() {
        return new CardSection[]{MAIN_DECK, SIDEBOARD, MAYBEBOARD};
    }

    static {
        CardSection[] cardSectionArr$values = $values();
        $VALUES = cardSectionArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(cardSectionArr$values);
    }

    private CardSection(String str, int i) {
    }

    public static EnumEntries<CardSection> getEntries() {
        return $ENTRIES;
    }

    public static CardSection valueOf(String str) {
        return (CardSection) Enum.valueOf(CardSection.class, str);
    }

    public static CardSection[] values() {
        return (CardSection[]) $VALUES.clone();
    }
}
