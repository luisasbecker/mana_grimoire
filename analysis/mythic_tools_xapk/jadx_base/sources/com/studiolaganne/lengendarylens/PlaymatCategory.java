package com.studiolaganne.lengendarylens;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: GameUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/studiolaganne/lengendarylens/PlaymatCategory;", "", "<init>", "(Ljava/lang/String;I)V", "BASIC", "CREATURE", "GUILD", "SCENERY", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PlaymatCategory {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PlaymatCategory[] $VALUES;
    public static final PlaymatCategory BASIC = new PlaymatCategory("BASIC", 0);
    public static final PlaymatCategory CREATURE = new PlaymatCategory("CREATURE", 1);
    public static final PlaymatCategory GUILD = new PlaymatCategory("GUILD", 2);
    public static final PlaymatCategory SCENERY = new PlaymatCategory("SCENERY", 3);

    private static final /* synthetic */ PlaymatCategory[] $values() {
        return new PlaymatCategory[]{BASIC, CREATURE, GUILD, SCENERY};
    }

    static {
        PlaymatCategory[] playmatCategoryArr$values = $values();
        $VALUES = playmatCategoryArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(playmatCategoryArr$values);
    }

    private PlaymatCategory(String str, int i) {
    }

    public static EnumEntries<PlaymatCategory> getEntries() {
        return $ENTRIES;
    }

    public static PlaymatCategory valueOf(String str) {
        return (PlaymatCategory) Enum.valueOf(PlaymatCategory.class, str);
    }

    public static PlaymatCategory[] values() {
        return (PlaymatCategory[]) $VALUES.clone();
    }
}
