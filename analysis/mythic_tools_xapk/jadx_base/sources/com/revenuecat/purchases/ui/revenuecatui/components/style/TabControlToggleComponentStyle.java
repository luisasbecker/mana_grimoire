package com.revenuecat.purchases.ui.revenuecatui.components.style;

import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TabsComponentStyle.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\u00020\u0012X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabControlToggleComponentStyle;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", "thumbColorOn", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;", "thumbColorOff", "trackColorOn", "trackColorOff", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;)V", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getSize", "()Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getThumbColorOff", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;", "getThumbColorOn", "getTrackColorOff", "getTrackColorOn", "visible", "", "getVisible", "()Z", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TabControlToggleComponentStyle implements ComponentStyle {
    public static final int $stable = 0;
    private final Size size;
    private final ColorStyles thumbColorOff;
    private final ColorStyles thumbColorOn;
    private final ColorStyles trackColorOff;
    private final ColorStyles trackColorOn;
    private final boolean visible;

    public TabControlToggleComponentStyle(ColorStyles thumbColorOn, ColorStyles thumbColorOff, ColorStyles trackColorOn, ColorStyles trackColorOff) {
        Intrinsics.checkNotNullParameter(thumbColorOn, "thumbColorOn");
        Intrinsics.checkNotNullParameter(thumbColorOff, "thumbColorOff");
        Intrinsics.checkNotNullParameter(trackColorOn, "trackColorOn");
        Intrinsics.checkNotNullParameter(trackColorOff, "trackColorOff");
        this.thumbColorOn = thumbColorOn;
        this.thumbColorOff = thumbColorOff;
        this.trackColorOn = trackColorOn;
        this.trackColorOff = trackColorOff;
        this.visible = true;
        this.size = new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fit.INSTANCE);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
    public Size getSize() {
        return this.size;
    }

    public final /* synthetic */ ColorStyles getThumbColorOff() {
        return this.thumbColorOff;
    }

    public final /* synthetic */ ColorStyles getThumbColorOn() {
        return this.thumbColorOn;
    }

    public final /* synthetic */ ColorStyles getTrackColorOff() {
        return this.trackColorOff;
    }

    public final /* synthetic */ ColorStyles getTrackColorOn() {
        return this.trackColorOn;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
    public boolean getVisible() {
        return this.visible;
    }
}
