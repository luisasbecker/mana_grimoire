package com.studiolaganne.lengendarylens;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: PrivacyContext.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/studiolaganne/lengendarylens/PrivacyContext;", "", "<init>", "(Ljava/lang/String;I)V", "LIST", "DECK", "PROFILE", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PrivacyContext {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PrivacyContext[] $VALUES;
    public static final PrivacyContext LIST = new PrivacyContext("LIST", 0);
    public static final PrivacyContext DECK = new PrivacyContext("DECK", 1);
    public static final PrivacyContext PROFILE = new PrivacyContext("PROFILE", 2);

    private static final /* synthetic */ PrivacyContext[] $values() {
        return new PrivacyContext[]{LIST, DECK, PROFILE};
    }

    static {
        PrivacyContext[] privacyContextArr$values = $values();
        $VALUES = privacyContextArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(privacyContextArr$values);
    }

    private PrivacyContext(String str, int i) {
    }

    public static EnumEntries<PrivacyContext> getEntries() {
        return $ENTRIES;
    }

    public static PrivacyContext valueOf(String str) {
        return (PrivacyContext) Enum.valueOf(PrivacyContext.class, str);
    }

    public static PrivacyContext[] values() {
        return (PrivacyContext[]) $VALUES.clone();
    }
}
