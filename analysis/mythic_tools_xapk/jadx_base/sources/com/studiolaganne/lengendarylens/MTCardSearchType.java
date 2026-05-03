package com.studiolaganne.lengendarylens;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: MTCardSearchViewModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardSearchType;", "", "<init>", "(Ljava/lang/String;I)V", "COMMANDER", "PARTNER", "SIGNATURE_SPELL", "PLAYMAT", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MTCardSearchType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MTCardSearchType[] $VALUES;
    public static final MTCardSearchType COMMANDER = new MTCardSearchType("COMMANDER", 0);
    public static final MTCardSearchType PARTNER = new MTCardSearchType("PARTNER", 1);
    public static final MTCardSearchType SIGNATURE_SPELL = new MTCardSearchType("SIGNATURE_SPELL", 2);
    public static final MTCardSearchType PLAYMAT = new MTCardSearchType("PLAYMAT", 3);

    private static final /* synthetic */ MTCardSearchType[] $values() {
        return new MTCardSearchType[]{COMMANDER, PARTNER, SIGNATURE_SPELL, PLAYMAT};
    }

    static {
        MTCardSearchType[] mTCardSearchTypeArr$values = $values();
        $VALUES = mTCardSearchTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(mTCardSearchTypeArr$values);
    }

    private MTCardSearchType(String str, int i) {
    }

    public static EnumEntries<MTCardSearchType> getEntries() {
        return $ENTRIES;
    }

    public static MTCardSearchType valueOf(String str) {
        return (MTCardSearchType) Enum.valueOf(MTCardSearchType.class, str);
    }

    public static MTCardSearchType[] values() {
        return (MTCardSearchType[]) $VALUES.clone();
    }
}
