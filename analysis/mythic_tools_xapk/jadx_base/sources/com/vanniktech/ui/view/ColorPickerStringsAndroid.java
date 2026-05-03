package com.vanniktech.ui.view;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;

/* JADX INFO: compiled from: ColorPickerView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/vanniktech/ui/view/ColorPickerStringsAndroid;", "Lcom/vanniktech/ui/view/ColorPickerStrings;", "alpha", "", "red", "green", "blue", "hex", "<init>", "(IIIII)V", "getAlpha", "()I", "getRed", "getGreen", "getBlue", "getHex", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class ColorPickerStringsAndroid implements ColorPickerStrings {
    private final int alpha;
    private final int blue;
    private final int green;
    private final int hex;
    private final int red;

    public ColorPickerStringsAndroid(int i, int i2, int i3, int i4, int i5) {
        this.alpha = i;
        this.red = i2;
        this.green = i3;
        this.blue = i4;
        this.hex = i5;
    }

    public static /* synthetic */ ColorPickerStringsAndroid copy$default(ColorPickerStringsAndroid colorPickerStringsAndroid, int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = colorPickerStringsAndroid.alpha;
        }
        if ((i6 & 2) != 0) {
            i2 = colorPickerStringsAndroid.red;
        }
        if ((i6 & 4) != 0) {
            i3 = colorPickerStringsAndroid.green;
        }
        if ((i6 & 8) != 0) {
            i4 = colorPickerStringsAndroid.blue;
        }
        if ((i6 & 16) != 0) {
            i5 = colorPickerStringsAndroid.hex;
        }
        int i7 = i5;
        int i8 = i3;
        return colorPickerStringsAndroid.copy(i, i2, i8, i4, i7);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getAlpha() {
        return this.alpha;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getRed() {
        return this.red;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getGreen() {
        return this.green;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getBlue() {
        return this.blue;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getHex() {
        return this.hex;
    }

    public final ColorPickerStringsAndroid copy(int alpha, int red, int green, int blue, int hex) {
        return new ColorPickerStringsAndroid(alpha, red, green, blue, hex);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ColorPickerStringsAndroid)) {
            return false;
        }
        ColorPickerStringsAndroid colorPickerStringsAndroid = (ColorPickerStringsAndroid) other;
        return this.alpha == colorPickerStringsAndroid.alpha && this.red == colorPickerStringsAndroid.red && this.green == colorPickerStringsAndroid.green && this.blue == colorPickerStringsAndroid.blue && this.hex == colorPickerStringsAndroid.hex;
    }

    public final int getAlpha() {
        return this.alpha;
    }

    public final int getBlue() {
        return this.blue;
    }

    public final int getGreen() {
        return this.green;
    }

    public final int getHex() {
        return this.hex;
    }

    public final int getRed() {
        return this.red;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.alpha) * 31) + Integer.hashCode(this.red)) * 31) + Integer.hashCode(this.green)) * 31) + Integer.hashCode(this.blue)) * 31) + Integer.hashCode(this.hex);
    }

    public String toString() {
        return "ColorPickerStringsAndroid(alpha=" + this.alpha + ", red=" + this.red + ", green=" + this.green + ", blue=" + this.blue + ", hex=" + this.hex + ")";
    }
}
