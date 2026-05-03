package com.studiolaganne.lengendarylens;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: CollectionStatusDialogResult.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/studiolaganne/lengendarylens/CollectionStatusChoice;", "", "<init>", "(Ljava/lang/String;I)V", "ADD_TO_COLLECTION", "GRAB_FROM_COLLECTION", "MAKE_PROXY", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CollectionStatusChoice {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CollectionStatusChoice[] $VALUES;
    public static final CollectionStatusChoice ADD_TO_COLLECTION = new CollectionStatusChoice("ADD_TO_COLLECTION", 0);
    public static final CollectionStatusChoice GRAB_FROM_COLLECTION = new CollectionStatusChoice("GRAB_FROM_COLLECTION", 1);
    public static final CollectionStatusChoice MAKE_PROXY = new CollectionStatusChoice("MAKE_PROXY", 2);

    private static final /* synthetic */ CollectionStatusChoice[] $values() {
        return new CollectionStatusChoice[]{ADD_TO_COLLECTION, GRAB_FROM_COLLECTION, MAKE_PROXY};
    }

    static {
        CollectionStatusChoice[] collectionStatusChoiceArr$values = $values();
        $VALUES = collectionStatusChoiceArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(collectionStatusChoiceArr$values);
    }

    private CollectionStatusChoice(String str, int i) {
    }

    public static EnumEntries<CollectionStatusChoice> getEntries() {
        return $ENTRIES;
    }

    public static CollectionStatusChoice valueOf(String str) {
        return (CollectionStatusChoice) Enum.valueOf(CollectionStatusChoice.class, str);
    }

    public static CollectionStatusChoice[] values() {
        return (CollectionStatusChoice[]) $VALUES.clone();
    }
}
