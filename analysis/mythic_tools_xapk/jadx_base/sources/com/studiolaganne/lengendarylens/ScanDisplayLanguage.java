package com.studiolaganne.lengendarylens;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: PreferencesManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/studiolaganne/lengendarylens/ScanDisplayLanguage;", "", "<init>", "(Ljava/lang/String;I)V", "ORIGINAL", "TRANSLATED", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ScanDisplayLanguage {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ScanDisplayLanguage[] $VALUES;
    public static final ScanDisplayLanguage ORIGINAL = new ScanDisplayLanguage("ORIGINAL", 0);
    public static final ScanDisplayLanguage TRANSLATED = new ScanDisplayLanguage("TRANSLATED", 1);

    private static final /* synthetic */ ScanDisplayLanguage[] $values() {
        return new ScanDisplayLanguage[]{ORIGINAL, TRANSLATED};
    }

    static {
        ScanDisplayLanguage[] scanDisplayLanguageArr$values = $values();
        $VALUES = scanDisplayLanguageArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(scanDisplayLanguageArr$values);
    }

    private ScanDisplayLanguage(String str, int i) {
    }

    public static EnumEntries<ScanDisplayLanguage> getEntries() {
        return $ENTRIES;
    }

    public static ScanDisplayLanguage valueOf(String str) {
        return (ScanDisplayLanguage) Enum.valueOf(ScanDisplayLanguage.class, str);
    }

    public static ScanDisplayLanguage[] values() {
        return (ScanDisplayLanguage[]) $VALUES.clone();
    }
}
