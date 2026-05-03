package com.studiolaganne.lengendarylens;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: CollectionStatusDialogResult.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/studiolaganne/lengendarylens/BatchCollectionStatusDontOwnAction;", "", "<init>", "(Ljava/lang/String;I)V", "ADD_TO_COLLECTION", "MARK_PROXY", "DO_NOTHING", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BatchCollectionStatusDontOwnAction {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BatchCollectionStatusDontOwnAction[] $VALUES;
    public static final BatchCollectionStatusDontOwnAction ADD_TO_COLLECTION = new BatchCollectionStatusDontOwnAction("ADD_TO_COLLECTION", 0);
    public static final BatchCollectionStatusDontOwnAction MARK_PROXY = new BatchCollectionStatusDontOwnAction("MARK_PROXY", 1);
    public static final BatchCollectionStatusDontOwnAction DO_NOTHING = new BatchCollectionStatusDontOwnAction("DO_NOTHING", 2);

    private static final /* synthetic */ BatchCollectionStatusDontOwnAction[] $values() {
        return new BatchCollectionStatusDontOwnAction[]{ADD_TO_COLLECTION, MARK_PROXY, DO_NOTHING};
    }

    static {
        BatchCollectionStatusDontOwnAction[] batchCollectionStatusDontOwnActionArr$values = $values();
        $VALUES = batchCollectionStatusDontOwnActionArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(batchCollectionStatusDontOwnActionArr$values);
    }

    private BatchCollectionStatusDontOwnAction(String str, int i) {
    }

    public static EnumEntries<BatchCollectionStatusDontOwnAction> getEntries() {
        return $ENTRIES;
    }

    public static BatchCollectionStatusDontOwnAction valueOf(String str) {
        return (BatchCollectionStatusDontOwnAction) Enum.valueOf(BatchCollectionStatusDontOwnAction.class, str);
    }

    public static BatchCollectionStatusDontOwnAction[] values() {
        return (BatchCollectionStatusDontOwnAction[]) $VALUES.clone();
    }
}
