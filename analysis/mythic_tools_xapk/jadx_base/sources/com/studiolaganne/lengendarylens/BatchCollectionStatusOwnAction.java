package com.studiolaganne.lengendarylens;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: CollectionStatusDialogResult.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/studiolaganne/lengendarylens/BatchCollectionStatusOwnAction;", "", "<init>", "(Ljava/lang/String;I)V", "GRAB_EXACT_MATCH", "GRAB_PARTIAL_MATCH", "DO_NOTHING", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BatchCollectionStatusOwnAction {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BatchCollectionStatusOwnAction[] $VALUES;
    public static final BatchCollectionStatusOwnAction GRAB_EXACT_MATCH = new BatchCollectionStatusOwnAction("GRAB_EXACT_MATCH", 0);
    public static final BatchCollectionStatusOwnAction GRAB_PARTIAL_MATCH = new BatchCollectionStatusOwnAction("GRAB_PARTIAL_MATCH", 1);
    public static final BatchCollectionStatusOwnAction DO_NOTHING = new BatchCollectionStatusOwnAction("DO_NOTHING", 2);

    private static final /* synthetic */ BatchCollectionStatusOwnAction[] $values() {
        return new BatchCollectionStatusOwnAction[]{GRAB_EXACT_MATCH, GRAB_PARTIAL_MATCH, DO_NOTHING};
    }

    static {
        BatchCollectionStatusOwnAction[] batchCollectionStatusOwnActionArr$values = $values();
        $VALUES = batchCollectionStatusOwnActionArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(batchCollectionStatusOwnActionArr$values);
    }

    private BatchCollectionStatusOwnAction(String str, int i) {
    }

    public static EnumEntries<BatchCollectionStatusOwnAction> getEntries() {
        return $ENTRIES;
    }

    public static BatchCollectionStatusOwnAction valueOf(String str) {
        return (BatchCollectionStatusOwnAction) Enum.valueOf(BatchCollectionStatusOwnAction.class, str);
    }

    public static BatchCollectionStatusOwnAction[] values() {
        return (BatchCollectionStatusOwnAction[]) $VALUES.clone();
    }
}
