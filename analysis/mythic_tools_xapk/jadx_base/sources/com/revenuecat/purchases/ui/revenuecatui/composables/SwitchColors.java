package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.ui.graphics.Color;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Switch.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0007¢\u0006\u0002\u0010\u0014J\u001d\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0001¢\u0006\u0002\b\u001aJ%\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0001¢\u0006\u0002\b\u001fJ\u001d\u0010 \u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0001¢\u0006\u0002\b!R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u00020\u0007X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\u00020\u0007X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\u00020\u0007X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0010\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u00020\u0007X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\""}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/composables/SwitchColors;", "", "checkedThumbColor", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;", "checkedTrackColor", "checkedBorderColor", "checkedIconColor", "Landroidx/compose/ui/graphics/Color;", "uncheckedThumbColor", "uncheckedTrackColor", "uncheckedBorderColor", "uncheckedIconColor", "disabledCheckedThumbColor", "disabledCheckedTrackColor", "disabledCheckedBorderColor", "disabledCheckedIconColor", "disabledUncheckedThumbColor", "disabledUncheckedTrackColor", "disabledUncheckedBorderColor", "disabledUncheckedIconColor", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;JLcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;JLcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;JLcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "borderColor", "enabled", "", "checked", "borderColor$revenuecatui_defaultsBc8Release", "iconColor", "iconColor-WaAFU9c$revenuecatui_defaultsBc8Release", "(ZZ)J", "thumbColor", "thumbColor$revenuecatui_defaultsBc8Release", "trackColor", "trackColor$revenuecatui_defaultsBc8Release", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SwitchColors {
    public static final int $stable = 0;
    private final ColorStyle checkedBorderColor;
    private final long checkedIconColor;
    private final ColorStyle checkedThumbColor;
    private final ColorStyle checkedTrackColor;
    private final ColorStyle disabledCheckedBorderColor;
    private final long disabledCheckedIconColor;
    private final ColorStyle disabledCheckedThumbColor;
    private final ColorStyle disabledCheckedTrackColor;
    private final ColorStyle disabledUncheckedBorderColor;
    private final long disabledUncheckedIconColor;
    private final ColorStyle disabledUncheckedThumbColor;
    private final ColorStyle disabledUncheckedTrackColor;
    private final ColorStyle uncheckedBorderColor;
    private final long uncheckedIconColor;
    private final ColorStyle uncheckedThumbColor;
    private final ColorStyle uncheckedTrackColor;

    private SwitchColors(ColorStyle checkedThumbColor, ColorStyle checkedTrackColor, ColorStyle checkedBorderColor, long j, ColorStyle uncheckedThumbColor, ColorStyle uncheckedTrackColor, ColorStyle uncheckedBorderColor, long j2, ColorStyle disabledCheckedThumbColor, ColorStyle disabledCheckedTrackColor, ColorStyle disabledCheckedBorderColor, long j3, ColorStyle disabledUncheckedThumbColor, ColorStyle disabledUncheckedTrackColor, ColorStyle disabledUncheckedBorderColor, long j4) {
        Intrinsics.checkNotNullParameter(checkedThumbColor, "checkedThumbColor");
        Intrinsics.checkNotNullParameter(checkedTrackColor, "checkedTrackColor");
        Intrinsics.checkNotNullParameter(checkedBorderColor, "checkedBorderColor");
        Intrinsics.checkNotNullParameter(uncheckedThumbColor, "uncheckedThumbColor");
        Intrinsics.checkNotNullParameter(uncheckedTrackColor, "uncheckedTrackColor");
        Intrinsics.checkNotNullParameter(uncheckedBorderColor, "uncheckedBorderColor");
        Intrinsics.checkNotNullParameter(disabledCheckedThumbColor, "disabledCheckedThumbColor");
        Intrinsics.checkNotNullParameter(disabledCheckedTrackColor, "disabledCheckedTrackColor");
        Intrinsics.checkNotNullParameter(disabledCheckedBorderColor, "disabledCheckedBorderColor");
        Intrinsics.checkNotNullParameter(disabledUncheckedThumbColor, "disabledUncheckedThumbColor");
        Intrinsics.checkNotNullParameter(disabledUncheckedTrackColor, "disabledUncheckedTrackColor");
        Intrinsics.checkNotNullParameter(disabledUncheckedBorderColor, "disabledUncheckedBorderColor");
        this.checkedThumbColor = checkedThumbColor;
        this.checkedTrackColor = checkedTrackColor;
        this.checkedBorderColor = checkedBorderColor;
        this.checkedIconColor = j;
        this.uncheckedThumbColor = uncheckedThumbColor;
        this.uncheckedTrackColor = uncheckedTrackColor;
        this.uncheckedBorderColor = uncheckedBorderColor;
        this.uncheckedIconColor = j2;
        this.disabledCheckedThumbColor = disabledCheckedThumbColor;
        this.disabledCheckedTrackColor = disabledCheckedTrackColor;
        this.disabledCheckedBorderColor = disabledCheckedBorderColor;
        this.disabledCheckedIconColor = j3;
        this.disabledUncheckedThumbColor = disabledUncheckedThumbColor;
        this.disabledUncheckedTrackColor = disabledUncheckedTrackColor;
        this.disabledUncheckedBorderColor = disabledUncheckedBorderColor;
        this.disabledUncheckedIconColor = j4;
    }

    public /* synthetic */ SwitchColors(ColorStyle colorStyle, ColorStyle colorStyle2, ColorStyle colorStyle3, long j, ColorStyle colorStyle4, ColorStyle colorStyle5, ColorStyle colorStyle6, long j2, ColorStyle colorStyle7, ColorStyle colorStyle8, ColorStyle colorStyle9, long j3, ColorStyle colorStyle10, ColorStyle colorStyle11, ColorStyle colorStyle12, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this(colorStyle, colorStyle2, colorStyle3, j, colorStyle4, colorStyle5, colorStyle6, j2, colorStyle7, colorStyle8, colorStyle9, j3, colorStyle10, colorStyle11, colorStyle12, j4);
    }

    public final ColorStyle borderColor$revenuecatui_defaultsBc8Release(boolean enabled, boolean checked) {
        return enabled ? checked ? this.checkedBorderColor : this.uncheckedBorderColor : checked ? this.disabledCheckedBorderColor : this.disabledUncheckedBorderColor;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SwitchColors)) {
            return false;
        }
        SwitchColors switchColors = (SwitchColors) obj;
        return Intrinsics.areEqual(this.checkedThumbColor, switchColors.checkedThumbColor) && Intrinsics.areEqual(this.checkedTrackColor, switchColors.checkedTrackColor) && Intrinsics.areEqual(this.checkedBorderColor, switchColors.checkedBorderColor) && Color.m6326equalsimpl0(this.checkedIconColor, switchColors.checkedIconColor) && Intrinsics.areEqual(this.uncheckedThumbColor, switchColors.uncheckedThumbColor) && Intrinsics.areEqual(this.uncheckedTrackColor, switchColors.uncheckedTrackColor) && Intrinsics.areEqual(this.uncheckedBorderColor, switchColors.uncheckedBorderColor) && Color.m6326equalsimpl0(this.uncheckedIconColor, switchColors.uncheckedIconColor) && Intrinsics.areEqual(this.disabledCheckedThumbColor, switchColors.disabledCheckedThumbColor) && Intrinsics.areEqual(this.disabledCheckedTrackColor, switchColors.disabledCheckedTrackColor) && Intrinsics.areEqual(this.disabledCheckedBorderColor, switchColors.disabledCheckedBorderColor) && Color.m6326equalsimpl0(this.disabledCheckedIconColor, switchColors.disabledCheckedIconColor) && Intrinsics.areEqual(this.disabledUncheckedThumbColor, switchColors.disabledUncheckedThumbColor) && Intrinsics.areEqual(this.disabledUncheckedTrackColor, switchColors.disabledUncheckedTrackColor) && Intrinsics.areEqual(this.disabledUncheckedBorderColor, switchColors.disabledUncheckedBorderColor) && Color.m6326equalsimpl0(this.disabledUncheckedIconColor, switchColors.disabledUncheckedIconColor);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((this.checkedThumbColor.hashCode() * 31) + this.checkedTrackColor.hashCode()) * 31) + this.checkedBorderColor.hashCode()) * 31) + Color.m6332hashCodeimpl(this.checkedIconColor)) * 31) + this.uncheckedThumbColor.hashCode()) * 31) + this.uncheckedTrackColor.hashCode()) * 31) + this.uncheckedBorderColor.hashCode()) * 31) + Color.m6332hashCodeimpl(this.uncheckedIconColor)) * 31) + this.disabledCheckedThumbColor.hashCode()) * 31) + this.disabledCheckedTrackColor.hashCode()) * 31) + this.disabledCheckedBorderColor.hashCode()) * 31) + Color.m6332hashCodeimpl(this.disabledCheckedIconColor)) * 31) + this.disabledUncheckedThumbColor.hashCode()) * 31) + this.disabledUncheckedTrackColor.hashCode()) * 31) + this.disabledUncheckedBorderColor.hashCode()) * 31) + Color.m6332hashCodeimpl(this.disabledUncheckedIconColor);
    }

    /* JADX INFO: renamed from: iconColor-WaAFU9c$revenuecatui_defaultsBc8Release, reason: not valid java name */
    public final long m10669iconColorWaAFU9c$revenuecatui_defaultsBc8Release(boolean enabled, boolean checked) {
        return enabled ? checked ? this.checkedIconColor : this.uncheckedIconColor : checked ? this.disabledCheckedIconColor : this.disabledUncheckedIconColor;
    }

    public final ColorStyle thumbColor$revenuecatui_defaultsBc8Release(boolean enabled, boolean checked) {
        return enabled ? checked ? this.checkedThumbColor : this.uncheckedThumbColor : checked ? this.disabledCheckedThumbColor : this.disabledUncheckedThumbColor;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SwitchColors(checkedThumbColor=");
        sb.append(this.checkedThumbColor).append(", checkedTrackColor=").append(this.checkedTrackColor).append(", checkedBorderColor=").append(this.checkedBorderColor).append(", checkedIconColor=").append((Object) Color.m6333toStringimpl(this.checkedIconColor)).append(", uncheckedThumbColor=").append(this.uncheckedThumbColor).append(", uncheckedTrackColor=").append(this.uncheckedTrackColor).append(", uncheckedBorderColor=").append(this.uncheckedBorderColor).append(", uncheckedIconColor=").append((Object) Color.m6333toStringimpl(this.uncheckedIconColor)).append(", disabledCheckedThumbColor=").append(this.disabledCheckedThumbColor).append(", disabledCheckedTrackColor=").append(this.disabledCheckedTrackColor).append(", disabledCheckedBorderColor=").append(this.disabledCheckedBorderColor).append(", disabledCheckedIconColor=");
        sb.append((Object) Color.m6333toStringimpl(this.disabledCheckedIconColor)).append(", disabledUncheckedThumbColor=").append(this.disabledUncheckedThumbColor).append(", disabledUncheckedTrackColor=").append(this.disabledUncheckedTrackColor).append(", disabledUncheckedBorderColor=").append(this.disabledUncheckedBorderColor).append(", disabledUncheckedIconColor=").append((Object) Color.m6333toStringimpl(this.disabledUncheckedIconColor)).append(')');
        return sb.toString();
    }

    public final ColorStyle trackColor$revenuecatui_defaultsBc8Release(boolean enabled, boolean checked) {
        return enabled ? checked ? this.checkedTrackColor : this.uncheckedTrackColor : checked ? this.disabledCheckedTrackColor : this.disabledUncheckedTrackColor;
    }
}
