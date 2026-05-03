package com.studiolaganne.lengendarylens;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: DataStructs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/studiolaganne/lengendarylens/LowlifeEffect;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "RANDOM", "FIRE", "SCORE_HEARTBEAT", "SKULL", "GHOST", "DEATH", "RANDOM_CUSTOM", "CUSTOM_SLIDE_UP", "CUSTOM_SLIDE_RIGHT", "CUSTOM_FADE", "CUSTOM_LOTTIE", "CUSTOM_SLIDE_LEFT", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LowlifeEffect {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LowlifeEffect[] $VALUES;
    public static final LowlifeEffect NONE = new LowlifeEffect("NONE", 0);
    public static final LowlifeEffect RANDOM = new LowlifeEffect("RANDOM", 1);
    public static final LowlifeEffect FIRE = new LowlifeEffect("FIRE", 2);
    public static final LowlifeEffect SCORE_HEARTBEAT = new LowlifeEffect("SCORE_HEARTBEAT", 3);
    public static final LowlifeEffect SKULL = new LowlifeEffect("SKULL", 4);
    public static final LowlifeEffect GHOST = new LowlifeEffect("GHOST", 5);
    public static final LowlifeEffect DEATH = new LowlifeEffect("DEATH", 6);
    public static final LowlifeEffect RANDOM_CUSTOM = new LowlifeEffect("RANDOM_CUSTOM", 7);
    public static final LowlifeEffect CUSTOM_SLIDE_UP = new LowlifeEffect("CUSTOM_SLIDE_UP", 8);
    public static final LowlifeEffect CUSTOM_SLIDE_RIGHT = new LowlifeEffect("CUSTOM_SLIDE_RIGHT", 9);
    public static final LowlifeEffect CUSTOM_FADE = new LowlifeEffect("CUSTOM_FADE", 10);
    public static final LowlifeEffect CUSTOM_LOTTIE = new LowlifeEffect("CUSTOM_LOTTIE", 11);
    public static final LowlifeEffect CUSTOM_SLIDE_LEFT = new LowlifeEffect("CUSTOM_SLIDE_LEFT", 12);

    private static final /* synthetic */ LowlifeEffect[] $values() {
        return new LowlifeEffect[]{NONE, RANDOM, FIRE, SCORE_HEARTBEAT, SKULL, GHOST, DEATH, RANDOM_CUSTOM, CUSTOM_SLIDE_UP, CUSTOM_SLIDE_RIGHT, CUSTOM_FADE, CUSTOM_LOTTIE, CUSTOM_SLIDE_LEFT};
    }

    static {
        LowlifeEffect[] lowlifeEffectArr$values = $values();
        $VALUES = lowlifeEffectArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(lowlifeEffectArr$values);
    }

    private LowlifeEffect(String str, int i) {
    }

    public static EnumEntries<LowlifeEffect> getEntries() {
        return $ENTRIES;
    }

    public static LowlifeEffect valueOf(String str) {
        return (LowlifeEffect) Enum.valueOf(LowlifeEffect.class, str);
    }

    public static LowlifeEffect[] values() {
        return (LowlifeEffect[]) $VALUES.clone();
    }
}
