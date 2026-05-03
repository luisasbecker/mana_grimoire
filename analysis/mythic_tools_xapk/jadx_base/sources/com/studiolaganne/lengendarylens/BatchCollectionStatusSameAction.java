package com.studiolaganne.lengendarylens;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: CollectionStatusDialogResult.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/studiolaganne/lengendarylens/BatchCollectionStatusSameAction;", "", "<init>", "(Ljava/lang/String;I)V", "ADD_TO_COLLECTION", "MAKE_PROXY", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BatchCollectionStatusSameAction {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BatchCollectionStatusSameAction[] $VALUES;
    public static final BatchCollectionStatusSameAction ADD_TO_COLLECTION = new BatchCollectionStatusSameAction("ADD_TO_COLLECTION", 0);
    public static final BatchCollectionStatusSameAction MAKE_PROXY = new BatchCollectionStatusSameAction("MAKE_PROXY", 1);

    private static final /* synthetic */ BatchCollectionStatusSameAction[] $values() {
        return new BatchCollectionStatusSameAction[]{ADD_TO_COLLECTION, MAKE_PROXY};
    }

    static {
        BatchCollectionStatusSameAction[] batchCollectionStatusSameActionArr$values = $values();
        $VALUES = batchCollectionStatusSameActionArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(batchCollectionStatusSameActionArr$values);
    }

    private BatchCollectionStatusSameAction(String str, int i) {
    }

    public static EnumEntries<BatchCollectionStatusSameAction> getEntries() {
        return $ENTRIES;
    }

    public static BatchCollectionStatusSameAction valueOf(String str) {
        return (BatchCollectionStatusSameAction) Enum.valueOf(BatchCollectionStatusSameAction.class, str);
    }

    public static BatchCollectionStatusSameAction[] values() {
        return (BatchCollectionStatusSameAction[]) $VALUES.clone();
    }
}
