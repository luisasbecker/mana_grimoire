package com.studiolaganne.lengendarylens;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: DataStructs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/studiolaganne/lengendarylens/MatchResult;", "", "<init>", "(Ljava/lang/String;I)V", "WIN", "LOSS", "DRAW", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MatchResult {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MatchResult[] $VALUES;
    public static final MatchResult WIN = new MatchResult("WIN", 0);
    public static final MatchResult LOSS = new MatchResult("LOSS", 1);
    public static final MatchResult DRAW = new MatchResult("DRAW", 2);

    private static final /* synthetic */ MatchResult[] $values() {
        return new MatchResult[]{WIN, LOSS, DRAW};
    }

    static {
        MatchResult[] matchResultArr$values = $values();
        $VALUES = matchResultArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(matchResultArr$values);
    }

    private MatchResult(String str, int i) {
    }

    public static EnumEntries<MatchResult> getEntries() {
        return $ENTRIES;
    }

    public static MatchResult valueOf(String str) {
        return (MatchResult) Enum.valueOf(MatchResult.class, str);
    }

    public static MatchResult[] values() {
        return (MatchResult[]) $VALUES.clone();
    }
}
