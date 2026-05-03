package com.studiolaganne.lengendarylens;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: CollectionStatusDialogResult.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/studiolaganne/lengendarylens/BatchCollectionStatusInitialChoice;", "", "<init>", "(Ljava/lang/String;I)V", "SAME_ACTION_FOR_ALL", "COLLECTION_BASED_ACTION", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BatchCollectionStatusInitialChoice {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BatchCollectionStatusInitialChoice[] $VALUES;
    public static final BatchCollectionStatusInitialChoice SAME_ACTION_FOR_ALL = new BatchCollectionStatusInitialChoice("SAME_ACTION_FOR_ALL", 0);
    public static final BatchCollectionStatusInitialChoice COLLECTION_BASED_ACTION = new BatchCollectionStatusInitialChoice("COLLECTION_BASED_ACTION", 1);

    private static final /* synthetic */ BatchCollectionStatusInitialChoice[] $values() {
        return new BatchCollectionStatusInitialChoice[]{SAME_ACTION_FOR_ALL, COLLECTION_BASED_ACTION};
    }

    static {
        BatchCollectionStatusInitialChoice[] batchCollectionStatusInitialChoiceArr$values = $values();
        $VALUES = batchCollectionStatusInitialChoiceArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(batchCollectionStatusInitialChoiceArr$values);
    }

    private BatchCollectionStatusInitialChoice(String str, int i) {
    }

    public static EnumEntries<BatchCollectionStatusInitialChoice> getEntries() {
        return $ENTRIES;
    }

    public static BatchCollectionStatusInitialChoice valueOf(String str) {
        return (BatchCollectionStatusInitialChoice) Enum.valueOf(BatchCollectionStatusInitialChoice.class, str);
    }

    public static BatchCollectionStatusInitialChoice[] values() {
        return (BatchCollectionStatusInitialChoice[]) $VALUES.clone();
    }
}
