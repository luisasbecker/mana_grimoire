package com.revenuecat.purchases.ui.revenuecatui.components.properties;

import androidx.compose.ui.unit.Dp;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BorderStyle.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\f\u001a\u00020\u0003HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\nJ\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;", "", "width", "Landroidx/compose/ui/unit/Dp;", "colors", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;", "(FLcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColors", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;", "getWidth-D9Ej5fM", "()F", "F", "component1", "component1-D9Ej5fM", "component2", "copy", "copy-D5KLDUw", "(FLcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;)Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class BorderStyles {
    public static final int $stable = 0;
    private final ColorStyles colors;
    private final float width;

    private BorderStyles(float f, ColorStyles colors) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        this.width = f;
        this.colors = colors;
    }

    public /* synthetic */ BorderStyles(float f, ColorStyles colorStyles, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, colorStyles);
    }

    /* JADX INFO: renamed from: copy-D5KLDUw$default, reason: not valid java name */
    public static /* synthetic */ BorderStyles m10520copyD5KLDUw$default(BorderStyles borderStyles, float f, ColorStyles colorStyles, int i, Object obj) {
        if ((i & 1) != 0) {
            f = borderStyles.width;
        }
        if ((i & 2) != 0) {
            colorStyles = borderStyles.colors;
        }
        return borderStyles.m10522copyD5KLDUw(f, colorStyles);
    }

    /* JADX INFO: renamed from: component1-D9Ej5fM, reason: not valid java name and from getter */
    public final float getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ColorStyles getColors() {
        return this.colors;
    }

    /* JADX INFO: renamed from: copy-D5KLDUw, reason: not valid java name */
    public final BorderStyles m10522copyD5KLDUw(float width, ColorStyles colors) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        return new BorderStyles(width, colors, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BorderStyles)) {
            return false;
        }
        BorderStyles borderStyles = (BorderStyles) other;
        return Dp.m9119equalsimpl0(this.width, borderStyles.width) && Intrinsics.areEqual(this.colors, borderStyles.colors);
    }

    public final /* synthetic */ ColorStyles getColors() {
        return this.colors;
    }

    /* JADX INFO: renamed from: getWidth-D9Ej5fM, reason: not valid java name */
    public final /* synthetic */ float m10523getWidthD9Ej5fM() {
        return this.width;
    }

    public int hashCode() {
        return (Dp.m9120hashCodeimpl(this.width) * 31) + this.colors.hashCode();
    }

    public String toString() {
        return "BorderStyles(width=" + ((Object) Dp.m9125toStringimpl(this.width)) + ", colors=" + this.colors + ')';
    }
}
