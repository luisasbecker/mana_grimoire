package com.vanniktech.ui;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: MaterialColor.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000e\u0010\nj\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!¨\u0006\""}, d2 = {"Lcom/vanniktech/ui/MaterialColor;", "", "color400", "Lcom/vanniktech/ui/Color;", "color500", "color800", "colorToolbar", "<init>", "(Ljava/lang/String;IIIII)V", "getColor400-oEAH0UE", "()I", "I", "getColor500-oEAH0UE", "getColor800-oEAH0UE", "getColorToolbar-oEAH0UE", "RED", "PINK", "PURPLE", "PURPLE_DEEP", "INDIGO", "BLUE", "BLUE_LIGHT", "CYAN", "TEAL", "GREEN", "GREEN_LIGHT", "LIME", "YELLOW", "AMBER", "ORANGE", "ORANGE_DEEP", "BROWN", "GRAY", "BLUE_GRAY", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MaterialColor {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MaterialColor[] $VALUES;
    private final int color400;
    private final int color500;
    private final int color800;
    private final int colorToolbar;
    public static final MaterialColor RED = new MaterialColor("RED", 0, ColorKt.getColor(4293874512L), ColorKt.getColor(4294198070L), ColorKt.getColor(4291176488L), ColorKt.getColor(4290379789L));
    public static final MaterialColor PINK = new MaterialColor("PINK", 1, ColorKt.getColor(4293673082L), ColorKt.getColor(4293467747L), ColorKt.getColor(4289533015L), ColorKt.getColor(4289724474L));
    public static final MaterialColor PURPLE = new MaterialColor("PURPLE", 2, ColorKt.getColor(4289415100L), ColorKt.getColor(4288423856L), ColorKt.getColor(4285143962L), ColorKt.getColor(4285137024L));
    public static final MaterialColor PURPLE_DEEP = new MaterialColor("PURPLE_DEEP", 3, ColorKt.getColor(4286470082L), ColorKt.getColor(4284955319L), ColorKt.getColor(4282722208L), ColorKt.getColor(4281469830L));
    public static final MaterialColor INDIGO = new MaterialColor("INDIGO", 4, ColorKt.getColor(4284246976L), ColorKt.getColor(4282339765L), ColorKt.getColor(4280825235L), ColorKt.getColor(4278200708L));
    public static final MaterialColor BLUE = new MaterialColor("BLUE", 5, ColorKt.getColor(4282557941L), ColorKt.getColor(4280391411L), ColorKt.getColor(4279592384L), ColorKt.getColor(4278217152L));
    public static final MaterialColor BLUE_LIGHT = new MaterialColor("BLUE_LIGHT", 6, ColorKt.getColor(4280923894L), ColorKt.getColor(4278430196L), ColorKt.getColor(4278351805L), ColorKt.getColor(4278221505L));
    public static final MaterialColor CYAN = new MaterialColor("CYAN", 7, ColorKt.getColor(4280731354L), ColorKt.getColor(4278238420L), ColorKt.getColor(4278223759L), ColorKt.getColor(4278225827L));
    public static final MaterialColor TEAL = new MaterialColor("TEAL", 8, ColorKt.getColor(4280723098L), ColorKt.getColor(4278228616L), ColorKt.getColor(4278217052L), ColorKt.getColor(4278216539L));
    public static final MaterialColor GREEN = new MaterialColor("GREEN", 9, ColorKt.getColor(4284922730L), ColorKt.getColor(4283215696L), ColorKt.getColor(4281236786L), ColorKt.getColor(4278746915L));
    public static final MaterialColor GREEN_LIGHT = new MaterialColor("GREEN_LIGHT", 10, ColorKt.getColor(4288466021L), ColorKt.getColor(4287349578L), ColorKt.getColor(4283796271L), ColorKt.getColor(4284125718L));
    public static final MaterialColor LIME = new MaterialColor("LIME", 11, ColorKt.getColor(4292141399L), ColorKt.getColor(4291681337L), ColorKt.getColor(4288584996L), ColorKt.getColor(4288260608L));
    public static final MaterialColor YELLOW = new MaterialColor("YELLOW", 12, ColorKt.getColor(4294962776L), ColorKt.getColor(4294961979L), ColorKt.getColor(4294551589L), ColorKt.getColor(4291344640L));
    public static final MaterialColor AMBER = new MaterialColor("AMBER", 13, ColorKt.getColor(4294953512L), ColorKt.getColor(4294951175L), ColorKt.getColor(4294938368L), ColorKt.getColor(4291268864L));
    public static final MaterialColor ORANGE = new MaterialColor("ORANGE", 14, ColorKt.getColor(4294944550L), ColorKt.getColor(4294940672L), ColorKt.getColor(4293880832L), ColorKt.getColor(4291193088L));
    public static final MaterialColor ORANGE_DEEP = new MaterialColor("ORANGE_DEEP", 15, ColorKt.getColor(4294930499L), ColorKt.getColor(4294924066L), ColorKt.getColor(4292363029L), ColorKt.getColor(4291042304L));
    public static final MaterialColor BROWN = new MaterialColor("BROWN", 16, ColorKt.getColor(4287458915L), ColorKt.getColor(4286141768L), ColorKt.getColor(4283315246L), ColorKt.getColor(4283116576L));
    public static final MaterialColor GRAY = new MaterialColor("GRAY", 17, ColorKt.getColor(4290624957L), ColorKt.getColor(4288585374L), ColorKt.getColor(4282532418L), ColorKt.getColor(4285558896L));
    public static final MaterialColor BLUE_GRAY = new MaterialColor("BLUE_GRAY", 18, ColorKt.getColor(4286091420L), ColorKt.getColor(4284513675L), ColorKt.getColor(4281812815L), ColorKt.getColor(4281618782L));

    private static final /* synthetic */ MaterialColor[] $values() {
        return new MaterialColor[]{RED, PINK, PURPLE, PURPLE_DEEP, INDIGO, BLUE, BLUE_LIGHT, CYAN, TEAL, GREEN, GREEN_LIGHT, LIME, YELLOW, AMBER, ORANGE, ORANGE_DEEP, BROWN, GRAY, BLUE_GRAY};
    }

    static {
        MaterialColor[] materialColorArr$values = $values();
        $VALUES = materialColorArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(materialColorArr$values);
    }

    private MaterialColor(String str, int i, int i2, int i3, int i4, int i5) {
        this.color400 = i2;
        this.color500 = i3;
        this.color800 = i4;
        this.colorToolbar = i5;
    }

    public static EnumEntries<MaterialColor> getEntries() {
        return $ENTRIES;
    }

    public static MaterialColor valueOf(String str) {
        return (MaterialColor) Enum.valueOf(MaterialColor.class, str);
    }

    public static MaterialColor[] values() {
        return (MaterialColor[]) $VALUES.clone();
    }

    /* JADX INFO: renamed from: getColor400-oEAH0UE, reason: not valid java name and from getter */
    public final int getColor400() {
        return this.color400;
    }

    /* JADX INFO: renamed from: getColor500-oEAH0UE, reason: not valid java name and from getter */
    public final int getColor500() {
        return this.color500;
    }

    /* JADX INFO: renamed from: getColor800-oEAH0UE, reason: not valid java name and from getter */
    public final int getColor800() {
        return this.color800;
    }

    /* JADX INFO: renamed from: getColorToolbar-oEAH0UE, reason: not valid java name and from getter */
    public final int getColorToolbar() {
        return this.colorToolbar;
    }
}
