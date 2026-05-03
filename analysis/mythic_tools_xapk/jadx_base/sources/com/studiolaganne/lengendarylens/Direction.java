package com.studiolaganne.lengendarylens;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: DataStructs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/studiolaganne/lengendarylens/Direction;", "", "<init>", "(Ljava/lang/String;I)V", "UP", "DOWN", "LEFT", "RIGHT", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Direction {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Direction[] $VALUES;
    public static final Direction UP = new Direction("UP", 0);
    public static final Direction DOWN = new Direction("DOWN", 1);
    public static final Direction LEFT = new Direction("LEFT", 2);
    public static final Direction RIGHT = new Direction("RIGHT", 3);

    private static final /* synthetic */ Direction[] $values() {
        return new Direction[]{UP, DOWN, LEFT, RIGHT};
    }

    static {
        Direction[] directionArr$values = $values();
        $VALUES = directionArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(directionArr$values);
    }

    private Direction(String str, int i) {
    }

    public static EnumEntries<Direction> getEntries() {
        return $ENTRIES;
    }

    public static Direction valueOf(String str) {
        return (Direction) Enum.valueOf(Direction.class, str);
    }

    public static Direction[] values() {
        return (Direction[]) $VALUES.clone();
    }
}
