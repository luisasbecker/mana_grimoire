package com.revenuecat.purchases.ui.revenuecatui.components.style;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TabsComponentStyle.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabControlButtonComponentStyle;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", "tabIndex", "", "stack", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;", "(ILcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;)V", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getSize", "()Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getStack", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;", "getTabIndex", "()I", "visible", "", "getVisible", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class TabControlButtonComponentStyle implements ComponentStyle {
    public static final int $stable = 0;
    private final Size size;
    private final StackComponentStyle stack;
    private final int tabIndex;
    private final boolean visible;

    public TabControlButtonComponentStyle(int i, StackComponentStyle stack) {
        Intrinsics.checkNotNullParameter(stack, "stack");
        this.tabIndex = i;
        this.stack = stack;
        this.visible = stack.getVisible();
        this.size = stack.getSize();
    }

    public static /* synthetic */ TabControlButtonComponentStyle copy$default(TabControlButtonComponentStyle tabControlButtonComponentStyle, int i, StackComponentStyle stackComponentStyle, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = tabControlButtonComponentStyle.tabIndex;
        }
        if ((i2 & 2) != 0) {
            stackComponentStyle = tabControlButtonComponentStyle.stack;
        }
        return tabControlButtonComponentStyle.copy(i, stackComponentStyle);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getTabIndex() {
        return this.tabIndex;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final StackComponentStyle getStack() {
        return this.stack;
    }

    public final TabControlButtonComponentStyle copy(int tabIndex, StackComponentStyle stack) {
        Intrinsics.checkNotNullParameter(stack, "stack");
        return new TabControlButtonComponentStyle(tabIndex, stack);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TabControlButtonComponentStyle)) {
            return false;
        }
        TabControlButtonComponentStyle tabControlButtonComponentStyle = (TabControlButtonComponentStyle) other;
        return this.tabIndex == tabControlButtonComponentStyle.tabIndex && Intrinsics.areEqual(this.stack, tabControlButtonComponentStyle.stack);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
    public Size getSize() {
        return this.size;
    }

    public final /* synthetic */ StackComponentStyle getStack() {
        return this.stack;
    }

    public final /* synthetic */ int getTabIndex() {
        return this.tabIndex;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
    public boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        return (Integer.hashCode(this.tabIndex) * 31) + this.stack.hashCode();
    }

    public String toString() {
        return "TabControlButtonComponentStyle(tabIndex=" + this.tabIndex + ", stack=" + this.stack + ')';
    }
}
