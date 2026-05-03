package com.studiolaganne.lengendarylens;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: StreamingDataClasses.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/studiolaganne/lengendarylens/GameResult;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "LOSS", "WIN", "CONCEDE", "DRAW", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GameResult {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ GameResult[] $VALUES;
    private final int value;
    public static final GameResult LOSS = new GameResult("LOSS", 0, 0);
    public static final GameResult WIN = new GameResult("WIN", 1, 1);
    public static final GameResult CONCEDE = new GameResult("CONCEDE", 2, 2);
    public static final GameResult DRAW = new GameResult("DRAW", 3, 3);

    private static final /* synthetic */ GameResult[] $values() {
        return new GameResult[]{LOSS, WIN, CONCEDE, DRAW};
    }

    static {
        GameResult[] gameResultArr$values = $values();
        $VALUES = gameResultArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(gameResultArr$values);
    }

    private GameResult(String str, int i, int i2) {
        this.value = i2;
    }

    public static EnumEntries<GameResult> getEntries() {
        return $ENTRIES;
    }

    public static GameResult valueOf(String str) {
        return (GameResult) Enum.valueOf(GameResult.class, str);
    }

    public static GameResult[] values() {
        return (GameResult[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }
}
