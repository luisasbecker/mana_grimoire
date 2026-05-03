package com.studiolaganne.lengendarylens;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: StreamingDataClasses.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/studiolaganne/lengendarylens/GameStatus;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NOT_STARTED", "IN_PROGRESS", "FINISHED", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GameStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ GameStatus[] $VALUES;
    private final String value;
    public static final GameStatus NOT_STARTED = new GameStatus("NOT_STARTED", 0, "not_started");
    public static final GameStatus IN_PROGRESS = new GameStatus("IN_PROGRESS", 1, "in_progress");
    public static final GameStatus FINISHED = new GameStatus("FINISHED", 2, "finished");

    private static final /* synthetic */ GameStatus[] $values() {
        return new GameStatus[]{NOT_STARTED, IN_PROGRESS, FINISHED};
    }

    static {
        GameStatus[] gameStatusArr$values = $values();
        $VALUES = gameStatusArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(gameStatusArr$values);
    }

    private GameStatus(String str, int i, String str2) {
        this.value = str2;
    }

    public static EnumEntries<GameStatus> getEntries() {
        return $ENTRIES;
    }

    public static GameStatus valueOf(String str) {
        return (GameStatus) Enum.valueOf(GameStatus.class, str);
    }

    public static GameStatus[] values() {
        return (GameStatus[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }
}
