package com.studiolaganne.lengendarylens;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: DataStructs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/studiolaganne/lengendarylens/PairingType;", "", "<init>", "(Ljava/lang/String;I)V", "SINGLE_ELIMINATION", "SWISS", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PairingType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PairingType[] $VALUES;
    public static final PairingType SINGLE_ELIMINATION = new PairingType("SINGLE_ELIMINATION", 0);
    public static final PairingType SWISS = new PairingType("SWISS", 1);

    private static final /* synthetic */ PairingType[] $values() {
        return new PairingType[]{SINGLE_ELIMINATION, SWISS};
    }

    static {
        PairingType[] pairingTypeArr$values = $values();
        $VALUES = pairingTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(pairingTypeArr$values);
    }

    private PairingType(String str, int i) {
    }

    public static EnumEntries<PairingType> getEntries() {
        return $ENTRIES;
    }

    public static PairingType valueOf(String str) {
        return (PairingType) Enum.valueOf(PairingType.class, str);
    }

    public static PairingType[] values() {
        return (PairingType[]) $VALUES.clone();
    }
}
