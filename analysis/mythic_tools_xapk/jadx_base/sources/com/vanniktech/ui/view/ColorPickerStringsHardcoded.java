package com.vanniktech.ui.view;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ColorPickerView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J=\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/vanniktech/ui/view/ColorPickerStringsHardcoded;", "Lcom/vanniktech/ui/view/ColorPickerStrings;", "alpha", "", "red", "green", "blue", "hex", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAlpha", "()Ljava/lang/String;", "getRed", "getGreen", "getBlue", "getHex", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class ColorPickerStringsHardcoded implements ColorPickerStrings {
    private final String alpha;
    private final String blue;
    private final String green;
    private final String hex;
    private final String red;

    public ColorPickerStringsHardcoded(String str, String red, String green, String blue, String hex) {
        Intrinsics.checkNotNullParameter(red, "red");
        Intrinsics.checkNotNullParameter(green, "green");
        Intrinsics.checkNotNullParameter(blue, "blue");
        Intrinsics.checkNotNullParameter(hex, "hex");
        this.alpha = str;
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.hex = hex;
    }

    public static /* synthetic */ ColorPickerStringsHardcoded copy$default(ColorPickerStringsHardcoded colorPickerStringsHardcoded, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = colorPickerStringsHardcoded.alpha;
        }
        if ((i & 2) != 0) {
            str2 = colorPickerStringsHardcoded.red;
        }
        if ((i & 4) != 0) {
            str3 = colorPickerStringsHardcoded.green;
        }
        if ((i & 8) != 0) {
            str4 = colorPickerStringsHardcoded.blue;
        }
        if ((i & 16) != 0) {
            str5 = colorPickerStringsHardcoded.hex;
        }
        String str6 = str5;
        String str7 = str3;
        return colorPickerStringsHardcoded.copy(str, str2, str7, str4, str6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAlpha() {
        return this.alpha;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRed() {
        return this.red;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getGreen() {
        return this.green;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getBlue() {
        return this.blue;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getHex() {
        return this.hex;
    }

    public final ColorPickerStringsHardcoded copy(String alpha, String red, String green, String blue, String hex) {
        Intrinsics.checkNotNullParameter(red, "red");
        Intrinsics.checkNotNullParameter(green, "green");
        Intrinsics.checkNotNullParameter(blue, "blue");
        Intrinsics.checkNotNullParameter(hex, "hex");
        return new ColorPickerStringsHardcoded(alpha, red, green, blue, hex);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ColorPickerStringsHardcoded)) {
            return false;
        }
        ColorPickerStringsHardcoded colorPickerStringsHardcoded = (ColorPickerStringsHardcoded) other;
        return Intrinsics.areEqual(this.alpha, colorPickerStringsHardcoded.alpha) && Intrinsics.areEqual(this.red, colorPickerStringsHardcoded.red) && Intrinsics.areEqual(this.green, colorPickerStringsHardcoded.green) && Intrinsics.areEqual(this.blue, colorPickerStringsHardcoded.blue) && Intrinsics.areEqual(this.hex, colorPickerStringsHardcoded.hex);
    }

    public final String getAlpha() {
        return this.alpha;
    }

    public final String getBlue() {
        return this.blue;
    }

    public final String getGreen() {
        return this.green;
    }

    public final String getHex() {
        return this.hex;
    }

    public final String getRed() {
        return this.red;
    }

    public int hashCode() {
        String str = this.alpha;
        return ((((((((str == null ? 0 : str.hashCode()) * 31) + this.red.hashCode()) * 31) + this.green.hashCode()) * 31) + this.blue.hashCode()) * 31) + this.hex.hashCode();
    }

    public String toString() {
        return "ColorPickerStringsHardcoded(alpha=" + this.alpha + ", red=" + this.red + ", green=" + this.green + ", blue=" + this.blue + ", hex=" + this.hex + ")";
    }
}
