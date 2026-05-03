package com.studiolaganne.lengendarylens;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: CollectionStatus.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/studiolaganne/lengendarylens/CollectionStatus;", "", "<init>", "(Ljava/lang/String;I)V", "EXACT_MATCH_FETCHED", "EXACT_MATCH_NOT_FETCHED", "PARTIAL_MATCH_NOT_FETCHED", "NO_MATCH_IN_COLLECTION", "PROXY", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CollectionStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CollectionStatus[] $VALUES;
    public static final CollectionStatus EXACT_MATCH_FETCHED = new CollectionStatus("EXACT_MATCH_FETCHED", 0);
    public static final CollectionStatus EXACT_MATCH_NOT_FETCHED = new CollectionStatus("EXACT_MATCH_NOT_FETCHED", 1);
    public static final CollectionStatus PARTIAL_MATCH_NOT_FETCHED = new CollectionStatus("PARTIAL_MATCH_NOT_FETCHED", 2);
    public static final CollectionStatus NO_MATCH_IN_COLLECTION = new CollectionStatus("NO_MATCH_IN_COLLECTION", 3);
    public static final CollectionStatus PROXY = new CollectionStatus("PROXY", 4);

    private static final /* synthetic */ CollectionStatus[] $values() {
        return new CollectionStatus[]{EXACT_MATCH_FETCHED, EXACT_MATCH_NOT_FETCHED, PARTIAL_MATCH_NOT_FETCHED, NO_MATCH_IN_COLLECTION, PROXY};
    }

    static {
        CollectionStatus[] collectionStatusArr$values = $values();
        $VALUES = collectionStatusArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(collectionStatusArr$values);
    }

    private CollectionStatus(String str, int i) {
    }

    public static EnumEntries<CollectionStatus> getEntries() {
        return $ENTRIES;
    }

    public static CollectionStatus valueOf(String str) {
        return (CollectionStatus) Enum.valueOf(CollectionStatus.class, str);
    }

    public static CollectionStatus[] values() {
        return (CollectionStatus[]) $VALUES.clone();
    }
}
