package com.studiolaganne.lengendarylens;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: DataStructs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTGColor;", "", "<init>", "(Ljava/lang/String;I)V", ExifInterface.LONGITUDE_WEST, "U", "B", "R", GameUtils.CONDITION_GOOD, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MTGColor {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MTGColor[] $VALUES;
    public static final MTGColor W = new MTGColor(ExifInterface.LONGITUDE_WEST, 0);
    public static final MTGColor U = new MTGColor("U", 1);
    public static final MTGColor B = new MTGColor("B", 2);
    public static final MTGColor R = new MTGColor("R", 3);
    public static final MTGColor G = new MTGColor(GameUtils.CONDITION_GOOD, 4);

    private static final /* synthetic */ MTGColor[] $values() {
        return new MTGColor[]{W, U, B, R, G};
    }

    static {
        MTGColor[] mTGColorArr$values = $values();
        $VALUES = mTGColorArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(mTGColorArr$values);
    }

    private MTGColor(String str, int i) {
    }

    public static EnumEntries<MTGColor> getEntries() {
        return $ENTRIES;
    }

    public static MTGColor valueOf(String str) {
        return (MTGColor) Enum.valueOf(MTGColor.class, str);
    }

    public static MTGColor[] values() {
        return (MTGColor[]) $VALUES.clone();
    }
}
