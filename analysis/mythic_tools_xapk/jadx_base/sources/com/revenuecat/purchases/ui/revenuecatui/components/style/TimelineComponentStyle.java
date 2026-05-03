package com.revenuecat.purchases.ui.revenuecatui.components.style;

import androidx.compose.foundation.layout.PaddingValues;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.paywalls.components.TimelineComponent;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedOverride;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedTimelineItemPartial;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedTimelinePartial;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResolvedOffer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimelineComponentStyle.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0081\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0002MNB\u0093\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u0011¢\u0006\u0002\u0010\u001dJ\t\u00107\u001a\u00020\u0004HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u00102J\u000b\u0010;\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u0015\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u0011HÆ\u0003J\t\u0010=\u001a\u00020\u0004HÆ\u0003J\t\u0010>\u001a\u00020\u0004HÆ\u0003J\t\u0010?\u001a\u00020\bHÆ\u0003J\t\u0010@\u001a\u00020\nHÆ\u0003J\t\u0010A\u001a\u00020\fHÆ\u0003J\t\u0010B\u001a\u00020\u000eHÆ\u0003J\t\u0010C\u001a\u00020\u000eHÆ\u0003J\u000f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011HÆ\u0003J´\u0001\u0010E\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u0011HÆ\u0001¢\u0006\u0002\u0010FJ\u0013\u0010G\u001a\u00020\n2\b\u0010H\u001a\u0004\u0018\u00010IHÖ\u0003J\t\u0010J\u001a\u00020\u0004HÖ\u0001J\t\u0010K\u001a\u00020LHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001d\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b0\u0011¢\u0006\b\n\u0000\u001a\u0004\b)\u0010$R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010&R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\n\n\u0002\u00103\u001a\u0004\b1\u00102R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001fR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106¨\u0006O"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TimelineComponentStyle;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/state/PackageContext;", "itemSpacing", "", "textSpacing", "columnGutter", "iconAlignment", "Lcom/revenuecat/purchases/paywalls/components/TimelineComponent$IconAlignment;", "visible", "", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "padding", "Landroidx/compose/foundation/layout/PaddingValues;", "margin", FirebaseAnalytics.Param.ITEMS, "", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TimelineComponentStyle$ItemStyle;", "rcPackage", "Lcom/revenuecat/purchases/Package;", "resolvedOffer", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "tabIndex", "offerEligibility", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "overrides", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedOverride;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedTimelinePartial;", "(IIILcom/revenuecat/purchases/paywalls/components/TimelineComponent$IconAlignment;ZLcom/revenuecat/purchases/paywalls/components/properties/Size;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/PaddingValues;Ljava/util/List;Lcom/revenuecat/purchases/Package;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;Ljava/lang/Integer;Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;Ljava/util/List;)V", "getColumnGutter", "()I", "getIconAlignment", "()Lcom/revenuecat/purchases/paywalls/components/TimelineComponent$IconAlignment;", "getItemSpacing", "getItems", "()Ljava/util/List;", "getMargin", "()Landroidx/compose/foundation/layout/PaddingValues;", "getOfferEligibility", "()Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "getOverrides", "getPadding", "getRcPackage", "()Lcom/revenuecat/purchases/Package;", "getResolvedOffer", "()Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "getSize", "()Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getTabIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTextSpacing", "getVisible", "()Z", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(IIILcom/revenuecat/purchases/paywalls/components/TimelineComponent$IconAlignment;ZLcom/revenuecat/purchases/paywalls/components/properties/Size;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/PaddingValues;Ljava/util/List;Lcom/revenuecat/purchases/Package;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;Ljava/lang/Integer;Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;Ljava/util/List;)Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TimelineComponentStyle;", "equals", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "ConnectorStyle", "ItemStyle", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class TimelineComponentStyle implements ComponentStyle, PackageContext {
    public static final int $stable = 0;
    private final int columnGutter;
    private final TimelineComponent.IconAlignment iconAlignment;
    private final int itemSpacing;
    private final List<ItemStyle> items;
    private final PaddingValues margin;
    private final OfferEligibility offerEligibility;
    private final List<PresentedOverride<PresentedTimelinePartial>> overrides;
    private final PaddingValues padding;
    private final Package rcPackage;
    private final ResolvedOffer resolvedOffer;
    private final Size size;
    private final Integer tabIndex;
    private final int textSpacing;
    private final boolean visible;

    /* JADX INFO: compiled from: TimelineComponentStyle.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TimelineComponentStyle$ConnectorStyle;", "", "width", "", "margin", "Landroidx/compose/foundation/layout/PaddingValues;", "color", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;", "(ILandroidx/compose/foundation/layout/PaddingValues;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;)V", "getColor", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;", "getMargin", "()Landroidx/compose/foundation/layout/PaddingValues;", "getWidth", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class ConnectorStyle {
        public static final int $stable = 0;
        private final ColorStyles color;
        private final PaddingValues margin;
        private final int width;

        public ConnectorStyle(int i, PaddingValues margin, ColorStyles color) {
            Intrinsics.checkNotNullParameter(margin, "margin");
            Intrinsics.checkNotNullParameter(color, "color");
            this.width = i;
            this.margin = margin;
            this.color = color;
        }

        public static /* synthetic */ ConnectorStyle copy$default(ConnectorStyle connectorStyle, int i, PaddingValues paddingValues, ColorStyles colorStyles, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = connectorStyle.width;
            }
            if ((i2 & 2) != 0) {
                paddingValues = connectorStyle.margin;
            }
            if ((i2 & 4) != 0) {
                colorStyles = connectorStyle.color;
            }
            return connectorStyle.copy(i, paddingValues, colorStyles);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getWidth() {
            return this.width;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final PaddingValues getMargin() {
            return this.margin;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final ColorStyles getColor() {
            return this.color;
        }

        public final ConnectorStyle copy(int width, PaddingValues margin, ColorStyles color) {
            Intrinsics.checkNotNullParameter(margin, "margin");
            Intrinsics.checkNotNullParameter(color, "color");
            return new ConnectorStyle(width, margin, color);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ConnectorStyle)) {
                return false;
            }
            ConnectorStyle connectorStyle = (ConnectorStyle) other;
            return this.width == connectorStyle.width && Intrinsics.areEqual(this.margin, connectorStyle.margin) && Intrinsics.areEqual(this.color, connectorStyle.color);
        }

        public final /* synthetic */ ColorStyles getColor() {
            return this.color;
        }

        public final /* synthetic */ PaddingValues getMargin() {
            return this.margin;
        }

        public final /* synthetic */ int getWidth() {
            return this.width;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.width) * 31) + this.margin.hashCode()) * 31) + this.color.hashCode();
        }

        public String toString() {
            return "ConnectorStyle(width=" + this.width + ", margin=" + this.margin + ", color=" + this.color + ')';
        }
    }

    /* JADX INFO: compiled from: TimelineComponentStyle.kt */
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0014¢\u0006\u0002\u0010\u0017J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u0015\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0014HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00100\u001a\u00020\bHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010'J\u000b\u00105\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u008a\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0014HÆ\u0001¢\u0006\u0002\u00107J\u0013\u00108\u001a\u00020\u00052\b\u00109\u001a\u0004\u0018\u00010:HÖ\u0003J\t\u0010;\u001a\u00020\u0010HÖ\u0001J\t\u0010<\u001a\u00020=HÖ\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0016\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0096\u0004¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u0006>"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TimelineComponentStyle$ItemStyle;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/state/PackageContext;", Constants.GP_IAP_TITLE, "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TextComponentStyle;", "visible", "", "description", "icon", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/IconComponentStyle;", "connector", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TimelineComponentStyle$ConnectorStyle;", "rcPackage", "Lcom/revenuecat/purchases/Package;", "resolvedOffer", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "tabIndex", "", "offerEligibility", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "overrides", "", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedOverride;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedTimelineItemPartial;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TextComponentStyle;ZLcom/revenuecat/purchases/ui/revenuecatui/components/style/TextComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/IconComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TimelineComponentStyle$ConnectorStyle;Lcom/revenuecat/purchases/Package;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;Ljava/lang/Integer;Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;Ljava/util/List;)V", "getConnector", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TimelineComponentStyle$ConnectorStyle;", "getDescription", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TextComponentStyle;", "getIcon", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/style/IconComponentStyle;", "getOfferEligibility", "()Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "getOverrides", "()Ljava/util/List;", "getRcPackage", "()Lcom/revenuecat/purchases/Package;", "getResolvedOffer", "()Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "getTabIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTitle", "getVisible", "()Z", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TextComponentStyle;ZLcom/revenuecat/purchases/ui/revenuecatui/components/style/TextComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/IconComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TimelineComponentStyle$ConnectorStyle;Lcom/revenuecat/purchases/Package;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;Ljava/lang/Integer;Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;Ljava/util/List;)Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TimelineComponentStyle$ItemStyle;", "equals", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class ItemStyle implements PackageContext {
        public static final int $stable = 0;
        private final ConnectorStyle connector;
        private final TextComponentStyle description;
        private final IconComponentStyle icon;
        private final OfferEligibility offerEligibility;
        private final List<PresentedOverride<PresentedTimelineItemPartial>> overrides;
        private final Package rcPackage;
        private final ResolvedOffer resolvedOffer;
        private final Integer tabIndex;
        private final TextComponentStyle title;
        private final boolean visible;

        public ItemStyle(TextComponentStyle title, boolean z, TextComponentStyle textComponentStyle, IconComponentStyle icon, ConnectorStyle connectorStyle, Package r7, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, List<PresentedOverride<PresentedTimelineItemPartial>> overrides) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(icon, "icon");
            Intrinsics.checkNotNullParameter(overrides, "overrides");
            this.title = title;
            this.visible = z;
            this.description = textComponentStyle;
            this.icon = icon;
            this.connector = connectorStyle;
            this.rcPackage = r7;
            this.resolvedOffer = resolvedOffer;
            this.tabIndex = num;
            this.offerEligibility = offerEligibility;
            this.overrides = overrides;
        }

        public /* synthetic */ ItemStyle(TextComponentStyle textComponentStyle, boolean z, TextComponentStyle textComponentStyle2, IconComponentStyle iconComponentStyle, ConnectorStyle connectorStyle, Package r7, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(textComponentStyle, z, textComponentStyle2, iconComponentStyle, connectorStyle, r7, (i & 64) != 0 ? null : resolvedOffer, num, (i & 256) != 0 ? null : offerEligibility, list);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ItemStyle copy$default(ItemStyle itemStyle, TextComponentStyle textComponentStyle, boolean z, TextComponentStyle textComponentStyle2, IconComponentStyle iconComponentStyle, ConnectorStyle connectorStyle, Package r6, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                textComponentStyle = itemStyle.title;
            }
            if ((i & 2) != 0) {
                z = itemStyle.visible;
            }
            if ((i & 4) != 0) {
                textComponentStyle2 = itemStyle.description;
            }
            if ((i & 8) != 0) {
                iconComponentStyle = itemStyle.icon;
            }
            if ((i & 16) != 0) {
                connectorStyle = itemStyle.connector;
            }
            if ((i & 32) != 0) {
                r6 = itemStyle.rcPackage;
            }
            if ((i & 64) != 0) {
                resolvedOffer = itemStyle.resolvedOffer;
            }
            if ((i & 128) != 0) {
                num = itemStyle.tabIndex;
            }
            if ((i & 256) != 0) {
                offerEligibility = itemStyle.offerEligibility;
            }
            if ((i & 512) != 0) {
                list = itemStyle.overrides;
            }
            OfferEligibility offerEligibility2 = offerEligibility;
            List list2 = list;
            ResolvedOffer resolvedOffer2 = resolvedOffer;
            Integer num2 = num;
            ConnectorStyle connectorStyle2 = connectorStyle;
            Package r8 = r6;
            return itemStyle.copy(textComponentStyle, z, textComponentStyle2, iconComponentStyle, connectorStyle2, r8, resolvedOffer2, num2, offerEligibility2, list2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final TextComponentStyle getTitle() {
            return this.title;
        }

        public final List<PresentedOverride<PresentedTimelineItemPartial>> component10() {
            return this.overrides;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getVisible() {
            return this.visible;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final TextComponentStyle getDescription() {
            return this.description;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final IconComponentStyle getIcon() {
            return this.icon;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final ConnectorStyle getConnector() {
            return this.connector;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Package getRcPackage() {
            return this.rcPackage;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final ResolvedOffer getResolvedOffer() {
            return this.resolvedOffer;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Integer getTabIndex() {
            return this.tabIndex;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final OfferEligibility getOfferEligibility() {
            return this.offerEligibility;
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
        public /* synthetic */ boolean computeIsSelected(PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo, int i) {
            return PackageContext.DefaultImpls.computeIsSelected(this, selectedPackageInfo, i);
        }

        public final ItemStyle copy(TextComponentStyle title, boolean visible, TextComponentStyle description, IconComponentStyle icon, ConnectorStyle connector, Package rcPackage, ResolvedOffer resolvedOffer, Integer tabIndex, OfferEligibility offerEligibility, List<PresentedOverride<PresentedTimelineItemPartial>> overrides) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(icon, "icon");
            Intrinsics.checkNotNullParameter(overrides, "overrides");
            return new ItemStyle(title, visible, description, icon, connector, rcPackage, resolvedOffer, tabIndex, offerEligibility, overrides);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ItemStyle)) {
                return false;
            }
            ItemStyle itemStyle = (ItemStyle) other;
            return Intrinsics.areEqual(this.title, itemStyle.title) && this.visible == itemStyle.visible && Intrinsics.areEqual(this.description, itemStyle.description) && Intrinsics.areEqual(this.icon, itemStyle.icon) && Intrinsics.areEqual(this.connector, itemStyle.connector) && Intrinsics.areEqual(this.rcPackage, itemStyle.rcPackage) && Intrinsics.areEqual(this.resolvedOffer, itemStyle.resolvedOffer) && Intrinsics.areEqual(this.tabIndex, itemStyle.tabIndex) && Intrinsics.areEqual(this.offerEligibility, itemStyle.offerEligibility) && Intrinsics.areEqual(this.overrides, itemStyle.overrides);
        }

        public final /* synthetic */ ConnectorStyle getConnector() {
            return this.connector;
        }

        public final /* synthetic */ TextComponentStyle getDescription() {
            return this.description;
        }

        public final /* synthetic */ IconComponentStyle getIcon() {
            return this.icon;
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
        public /* synthetic */ OfferEligibility getOfferEligibility() {
            return this.offerEligibility;
        }

        public final /* synthetic */ List getOverrides() {
            return this.overrides;
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
        public String getPackageUniqueId() {
            return PackageContext.DefaultImpls.getPackageUniqueId(this);
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
        public /* synthetic */ Package getRcPackage() {
            return this.rcPackage;
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
        public /* synthetic */ ResolvedOffer getResolvedOffer() {
            return this.resolvedOffer;
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
        public /* synthetic */ Integer getTabIndex() {
            return this.tabIndex;
        }

        public final /* synthetic */ TextComponentStyle getTitle() {
            return this.title;
        }

        public final /* synthetic */ boolean getVisible() {
            return this.visible;
        }

        public int hashCode() {
            int iHashCode = ((this.title.hashCode() * 31) + Boolean.hashCode(this.visible)) * 31;
            TextComponentStyle textComponentStyle = this.description;
            int iHashCode2 = (((iHashCode + (textComponentStyle == null ? 0 : textComponentStyle.hashCode())) * 31) + this.icon.hashCode()) * 31;
            ConnectorStyle connectorStyle = this.connector;
            int iHashCode3 = (iHashCode2 + (connectorStyle == null ? 0 : connectorStyle.hashCode())) * 31;
            Package r1 = this.rcPackage;
            int iHashCode4 = (iHashCode3 + (r1 == null ? 0 : r1.hashCode())) * 31;
            ResolvedOffer resolvedOffer = this.resolvedOffer;
            int iHashCode5 = (iHashCode4 + (resolvedOffer == null ? 0 : resolvedOffer.hashCode())) * 31;
            Integer num = this.tabIndex;
            int iHashCode6 = (iHashCode5 + (num == null ? 0 : num.hashCode())) * 31;
            OfferEligibility offerEligibility = this.offerEligibility;
            return ((iHashCode6 + (offerEligibility != null ? offerEligibility.hashCode() : 0)) * 31) + this.overrides.hashCode();
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
        public /* synthetic */ OfferEligibility resolveOfferEligibility(OfferEligibility offerEligibility) {
            return PackageContext.DefaultImpls.resolveOfferEligibility(this, offerEligibility);
        }

        public String toString() {
            return "ItemStyle(title=" + this.title + ", visible=" + this.visible + ", description=" + this.description + ", icon=" + this.icon + ", connector=" + this.connector + ", rcPackage=" + this.rcPackage + ", resolvedOffer=" + this.resolvedOffer + ", tabIndex=" + this.tabIndex + ", offerEligibility=" + this.offerEligibility + ", overrides=" + this.overrides + ')';
        }
    }

    public TimelineComponentStyle(int i, int i2, int i3, TimelineComponent.IconAlignment iconAlignment, boolean z, Size size, PaddingValues padding, PaddingValues margin, List<ItemStyle> items, Package r11, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, List<PresentedOverride<PresentedTimelinePartial>> overrides) {
        Intrinsics.checkNotNullParameter(iconAlignment, "iconAlignment");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(margin, "margin");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        this.itemSpacing = i;
        this.textSpacing = i2;
        this.columnGutter = i3;
        this.iconAlignment = iconAlignment;
        this.visible = z;
        this.size = size;
        this.padding = padding;
        this.margin = margin;
        this.items = items;
        this.rcPackage = r11;
        this.resolvedOffer = resolvedOffer;
        this.tabIndex = num;
        this.offerEligibility = offerEligibility;
        this.overrides = overrides;
    }

    public /* synthetic */ TimelineComponentStyle(int i, int i2, int i3, TimelineComponent.IconAlignment iconAlignment, boolean z, Size size, PaddingValues paddingValues, PaddingValues paddingValues2, List list, Package r28, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, List list2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, iconAlignment, z, size, paddingValues, paddingValues2, list, r28, (i4 & 1024) != 0 ? null : resolvedOffer, num, (i4 & 4096) != 0 ? null : offerEligibility, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getItemSpacing() {
        return this.itemSpacing;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Package getRcPackage() {
        return this.rcPackage;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final ResolvedOffer getResolvedOffer() {
        return this.resolvedOffer;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Integer getTabIndex() {
        return this.tabIndex;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final OfferEligibility getOfferEligibility() {
        return this.offerEligibility;
    }

    public final List<PresentedOverride<PresentedTimelinePartial>> component14() {
        return this.overrides;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getTextSpacing() {
        return this.textSpacing;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getColumnGutter() {
        return this.columnGutter;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final TimelineComponent.IconAlignment getIconAlignment() {
        return this.iconAlignment;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getVisible() {
        return this.visible;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Size getSize() {
        return this.size;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final PaddingValues getPadding() {
        return this.padding;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final PaddingValues getMargin() {
        return this.margin;
    }

    public final List<ItemStyle> component9() {
        return this.items;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ boolean computeIsSelected(PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo, int i) {
        return PackageContext.DefaultImpls.computeIsSelected(this, selectedPackageInfo, i);
    }

    public final TimelineComponentStyle copy(int itemSpacing, int textSpacing, int columnGutter, TimelineComponent.IconAlignment iconAlignment, boolean visible, Size size, PaddingValues padding, PaddingValues margin, List<ItemStyle> items, Package rcPackage, ResolvedOffer resolvedOffer, Integer tabIndex, OfferEligibility offerEligibility, List<PresentedOverride<PresentedTimelinePartial>> overrides) {
        Intrinsics.checkNotNullParameter(iconAlignment, "iconAlignment");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(margin, "margin");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        return new TimelineComponentStyle(itemSpacing, textSpacing, columnGutter, iconAlignment, visible, size, padding, margin, items, rcPackage, resolvedOffer, tabIndex, offerEligibility, overrides);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TimelineComponentStyle)) {
            return false;
        }
        TimelineComponentStyle timelineComponentStyle = (TimelineComponentStyle) other;
        return this.itemSpacing == timelineComponentStyle.itemSpacing && this.textSpacing == timelineComponentStyle.textSpacing && this.columnGutter == timelineComponentStyle.columnGutter && this.iconAlignment == timelineComponentStyle.iconAlignment && this.visible == timelineComponentStyle.visible && Intrinsics.areEqual(this.size, timelineComponentStyle.size) && Intrinsics.areEqual(this.padding, timelineComponentStyle.padding) && Intrinsics.areEqual(this.margin, timelineComponentStyle.margin) && Intrinsics.areEqual(this.items, timelineComponentStyle.items) && Intrinsics.areEqual(this.rcPackage, timelineComponentStyle.rcPackage) && Intrinsics.areEqual(this.resolvedOffer, timelineComponentStyle.resolvedOffer) && Intrinsics.areEqual(this.tabIndex, timelineComponentStyle.tabIndex) && Intrinsics.areEqual(this.offerEligibility, timelineComponentStyle.offerEligibility) && Intrinsics.areEqual(this.overrides, timelineComponentStyle.overrides);
    }

    public final /* synthetic */ int getColumnGutter() {
        return this.columnGutter;
    }

    public final /* synthetic */ TimelineComponent.IconAlignment getIconAlignment() {
        return this.iconAlignment;
    }

    public final /* synthetic */ int getItemSpacing() {
        return this.itemSpacing;
    }

    public final /* synthetic */ List getItems() {
        return this.items;
    }

    public final /* synthetic */ PaddingValues getMargin() {
        return this.margin;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ OfferEligibility getOfferEligibility() {
        return this.offerEligibility;
    }

    public final /* synthetic */ List getOverrides() {
        return this.overrides;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public String getPackageUniqueId() {
        return PackageContext.DefaultImpls.getPackageUniqueId(this);
    }

    public final /* synthetic */ PaddingValues getPadding() {
        return this.padding;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ Package getRcPackage() {
        return this.rcPackage;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ ResolvedOffer getResolvedOffer() {
        return this.resolvedOffer;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
    public /* synthetic */ Size getSize() {
        return this.size;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ Integer getTabIndex() {
        return this.tabIndex;
    }

    public final /* synthetic */ int getTextSpacing() {
        return this.textSpacing;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
    public /* synthetic */ boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((Integer.hashCode(this.itemSpacing) * 31) + Integer.hashCode(this.textSpacing)) * 31) + Integer.hashCode(this.columnGutter)) * 31) + this.iconAlignment.hashCode()) * 31) + Boolean.hashCode(this.visible)) * 31) + this.size.hashCode()) * 31) + this.padding.hashCode()) * 31) + this.margin.hashCode()) * 31) + this.items.hashCode()) * 31;
        Package r1 = this.rcPackage;
        int iHashCode2 = (iHashCode + (r1 == null ? 0 : r1.hashCode())) * 31;
        ResolvedOffer resolvedOffer = this.resolvedOffer;
        int iHashCode3 = (iHashCode2 + (resolvedOffer == null ? 0 : resolvedOffer.hashCode())) * 31;
        Integer num = this.tabIndex;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        OfferEligibility offerEligibility = this.offerEligibility;
        return ((iHashCode4 + (offerEligibility != null ? offerEligibility.hashCode() : 0)) * 31) + this.overrides.hashCode();
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ OfferEligibility resolveOfferEligibility(OfferEligibility offerEligibility) {
        return PackageContext.DefaultImpls.resolveOfferEligibility(this, offerEligibility);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TimelineComponentStyle(itemSpacing=");
        sb.append(this.itemSpacing).append(", textSpacing=").append(this.textSpacing).append(", columnGutter=").append(this.columnGutter).append(", iconAlignment=").append(this.iconAlignment).append(", visible=").append(this.visible).append(", size=").append(this.size).append(", padding=").append(this.padding).append(", margin=").append(this.margin).append(", items=").append(this.items).append(", rcPackage=").append(this.rcPackage).append(", resolvedOffer=").append(this.resolvedOffer).append(", tabIndex=");
        sb.append(this.tabIndex).append(", offerEligibility=").append(this.offerEligibility).append(", overrides=").append(this.overrides).append(')');
        return sb.toString();
    }
}
