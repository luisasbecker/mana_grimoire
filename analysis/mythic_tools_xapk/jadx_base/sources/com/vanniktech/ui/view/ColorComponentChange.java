package com.vanniktech.ui.view;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ColorComponentView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/vanniktech/ui/view/ColorComponentChange;", "", "origin", "Lcom/vanniktech/ui/view/ColorComponentView;", "value", "", "<init>", "(Lcom/vanniktech/ui/view/ColorComponentView;I)V", "getOrigin", "()Lcom/vanniktech/ui/view/ColorComponentView;", "getValue", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class ColorComponentChange {
    private final ColorComponentView origin;
    private final int value;

    public ColorComponentChange(ColorComponentView origin, int i) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        this.origin = origin;
        this.value = i;
    }

    public static /* synthetic */ ColorComponentChange copy$default(ColorComponentChange colorComponentChange, ColorComponentView colorComponentView, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            colorComponentView = colorComponentChange.origin;
        }
        if ((i2 & 2) != 0) {
            i = colorComponentChange.value;
        }
        return colorComponentChange.copy(colorComponentView, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ColorComponentView getOrigin() {
        return this.origin;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getValue() {
        return this.value;
    }

    public final ColorComponentChange copy(ColorComponentView origin, int value) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        return new ColorComponentChange(origin, value);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ColorComponentChange)) {
            return false;
        }
        ColorComponentChange colorComponentChange = (ColorComponentChange) other;
        return Intrinsics.areEqual(this.origin, colorComponentChange.origin) && this.value == colorComponentChange.value;
    }

    public final ColorComponentView getOrigin() {
        return this.origin;
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return (this.origin.hashCode() * 31) + Integer.hashCode(this.value);
    }

    public String toString() {
        return "ColorComponentChange(origin=" + this.origin + ", value=" + this.value + ")";
    }
}
