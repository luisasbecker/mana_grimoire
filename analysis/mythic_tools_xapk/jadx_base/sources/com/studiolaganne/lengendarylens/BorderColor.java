package com.studiolaganne.lengendarylens;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: MTGBorderColorDetector.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/studiolaganne/lengendarylens/BorderColor;", "", "<init>", "(Ljava/lang/String;I)V", "WHITE", "BLACK", "UNKNOWN", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BorderColor {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BorderColor[] $VALUES;
    public static final BorderColor WHITE = new BorderColor("WHITE", 0);
    public static final BorderColor BLACK = new BorderColor("BLACK", 1);
    public static final BorderColor UNKNOWN = new BorderColor("UNKNOWN", 2);

    private static final /* synthetic */ BorderColor[] $values() {
        return new BorderColor[]{WHITE, BLACK, UNKNOWN};
    }

    static {
        BorderColor[] borderColorArr$values = $values();
        $VALUES = borderColorArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(borderColorArr$values);
    }

    private BorderColor(String str, int i) {
    }

    public static EnumEntries<BorderColor> getEntries() {
        return $ENTRIES;
    }

    public static BorderColor valueOf(String str) {
        return (BorderColor) Enum.valueOf(BorderColor.class, str);
    }

    public static BorderColor[] values() {
        return (BorderColor[]) $VALUES.clone();
    }
}
