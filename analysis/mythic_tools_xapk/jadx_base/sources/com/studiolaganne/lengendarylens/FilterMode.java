package com.studiolaganne.lengendarylens;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: UnifiedFiltersBottomSheetFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/studiolaganne/lengendarylens/FilterMode;", "", "<init>", "(Ljava/lang/String;I)V", "GENERAL", "COLLECTION", "LOCAL_DB", ViewHierarchyConstants.SEARCH, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FilterMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FilterMode[] $VALUES;
    public static final FilterMode GENERAL = new FilterMode("GENERAL", 0);
    public static final FilterMode COLLECTION = new FilterMode("COLLECTION", 1);
    public static final FilterMode LOCAL_DB = new FilterMode("LOCAL_DB", 2);
    public static final FilterMode SEARCH = new FilterMode(ViewHierarchyConstants.SEARCH, 3);

    private static final /* synthetic */ FilterMode[] $values() {
        return new FilterMode[]{GENERAL, COLLECTION, LOCAL_DB, SEARCH};
    }

    static {
        FilterMode[] filterModeArr$values = $values();
        $VALUES = filterModeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(filterModeArr$values);
    }

    private FilterMode(String str, int i) {
    }

    public static EnumEntries<FilterMode> getEntries() {
        return $ENTRIES;
    }

    public static FilterMode valueOf(String str) {
        return (FilterMode) Enum.valueOf(FilterMode.class, str);
    }

    public static FilterMode[] values() {
        return (FilterMode[]) $VALUES.clone();
    }
}
