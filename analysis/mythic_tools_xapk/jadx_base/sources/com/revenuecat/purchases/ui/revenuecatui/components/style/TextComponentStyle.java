package com.revenuecat.purchases.ui.revenuecatui.components.style;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.paywalls.components.CountdownComponent;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.paywalls.components.common.VariableLocalizationKey;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.ui.revenuecatui.components.LocalizedTextPartial;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedOverride;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.FontSpec;
import com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyMap;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResolvedOffer;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextComponentStyle.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b(\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002Bë\u0001\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!\u0012\b\u0010\"\u001a\u0004\u0018\u00010#\u0012\u0006\u0010$\u001a\u00020%\u0012\u001e\u0010&\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00060\u00040\u0004\u0012\u0012\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0*0)¢\u0006\u0002\u0010,R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b/\u0010.R\u0011\u0010$\u001a\u00020%¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0013\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0011\u0010\u001a\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0016\u0010 \u001a\u0004\u0018\u00010!X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u001d\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0*0)¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\bB\u0010=R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0014\u0010\u0016\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\nX\u0096\u0004¢\u0006\n\n\u0002\u0010K\u001a\u0004\bI\u0010JR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR)\u0010&\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00060\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010OR\u0014\u0010\u0014\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010R\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006S"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TextComponentStyle;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/state/PackageContext;", "texts", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyMap;", "Lcom/revenuecat/purchases/paywalls/components/common/LocaleId;", "", "color", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;", "fontSize", "", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontSpec", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "backgroundColor", "visible", "", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "padding", "Landroidx/compose/foundation/layout/PaddingValues;", "margin", "rcPackage", "Lcom/revenuecat/purchases/Package;", "resolvedOffer", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "tabIndex", "offerEligibility", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "countdownDate", "Ljava/util/Date;", "countFrom", "Lcom/revenuecat/purchases/paywalls/components/CountdownComponent$CountFrom;", "variableLocalizations", "Lcom/revenuecat/purchases/paywalls/components/common/VariableLocalizationKey;", "overrides", "", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedOverride;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/LocalizedTextPartial;", "(Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyMap;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;ILandroidx/compose/ui/text/font/FontWeight;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/Alignment$Horizontal;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;ZLcom/revenuecat/purchases/paywalls/components/properties/Size;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/PaddingValues;Lcom/revenuecat/purchases/Package;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;Ljava/lang/Integer;Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;Ljava/util/Date;Lcom/revenuecat/purchases/paywalls/components/CountdownComponent$CountFrom;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyMap;Ljava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBackgroundColor", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;", "getColor", "getCountFrom", "()Lcom/revenuecat/purchases/paywalls/components/CountdownComponent$CountFrom;", "getCountdownDate", "()Ljava/util/Date;", "getFontSize", "()I", "getFontSpec", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec;", "getFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "getHorizontalAlignment", "()Landroidx/compose/ui/Alignment$Horizontal;", "getMargin", "()Landroidx/compose/foundation/layout/PaddingValues;", "getOfferEligibility", "()Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "getOverrides", "()Ljava/util/List;", "getPadding", "getRcPackage", "()Lcom/revenuecat/purchases/Package;", "getResolvedOffer", "()Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "getSize", "()Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getTabIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTextAlign-buA522U", "()Landroidx/compose/ui/text/style/TextAlign;", "getTexts", "()Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyMap;", "getVariableLocalizations", "getVisible", "()Z", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextComponentStyle implements ComponentStyle, PackageContext {
    public static final int $stable = 0;
    private final ColorStyles backgroundColor;
    private final ColorStyles color;
    private final CountdownComponent.CountFrom countFrom;
    private final Date countdownDate;
    private final int fontSize;
    private final FontSpec fontSpec;
    private final FontWeight fontWeight;
    private final Alignment.Horizontal horizontalAlignment;
    private final PaddingValues margin;
    private final OfferEligibility offerEligibility;
    private final List<PresentedOverride<LocalizedTextPartial>> overrides;
    private final PaddingValues padding;
    private final Package rcPackage;
    private final ResolvedOffer resolvedOffer;
    private final Size size;
    private final Integer tabIndex;
    private final TextAlign textAlign;
    private final NonEmptyMap<LocaleId, String> texts;
    private final NonEmptyMap<LocaleId, NonEmptyMap<VariableLocalizationKey, String>> variableLocalizations;
    private final boolean visible;

    private TextComponentStyle(NonEmptyMap<LocaleId, String> texts, ColorStyles color, int i, FontWeight fontWeight, FontSpec fontSpec, TextAlign textAlign, Alignment.Horizontal horizontalAlignment, ColorStyles colorStyles, boolean z, Size size, PaddingValues padding, PaddingValues margin, Package r20, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, Date date, CountdownComponent.CountFrom countFrom, NonEmptyMap<LocaleId, NonEmptyMap<VariableLocalizationKey, String>> variableLocalizations, List<PresentedOverride<LocalizedTextPartial>> overrides) {
        Intrinsics.checkNotNullParameter(texts, "texts");
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(horizontalAlignment, "horizontalAlignment");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(margin, "margin");
        Intrinsics.checkNotNullParameter(countFrom, "countFrom");
        Intrinsics.checkNotNullParameter(variableLocalizations, "variableLocalizations");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        this.texts = texts;
        this.color = color;
        this.fontSize = i;
        this.fontWeight = fontWeight;
        this.fontSpec = fontSpec;
        this.textAlign = textAlign;
        this.horizontalAlignment = horizontalAlignment;
        this.backgroundColor = colorStyles;
        this.visible = z;
        this.size = size;
        this.padding = padding;
        this.margin = margin;
        this.rcPackage = r20;
        this.resolvedOffer = resolvedOffer;
        this.tabIndex = num;
        this.offerEligibility = offerEligibility;
        this.countdownDate = date;
        this.countFrom = countFrom;
        this.variableLocalizations = variableLocalizations;
        this.overrides = overrides;
    }

    public /* synthetic */ TextComponentStyle(NonEmptyMap nonEmptyMap, ColorStyles colorStyles, int i, FontWeight fontWeight, FontSpec fontSpec, TextAlign textAlign, Alignment.Horizontal horizontal, ColorStyles colorStyles2, boolean z, Size size, PaddingValues paddingValues, PaddingValues paddingValues2, Package r38, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, Date date, CountdownComponent.CountFrom countFrom, NonEmptyMap nonEmptyMap2, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(nonEmptyMap, colorStyles, i, fontWeight, fontSpec, textAlign, horizontal, colorStyles2, z, size, paddingValues, paddingValues2, r38, (i2 & 8192) != 0 ? null : resolvedOffer, num, (i2 & 32768) != 0 ? null : offerEligibility, date, countFrom, nonEmptyMap2, list, null);
    }

    public /* synthetic */ TextComponentStyle(NonEmptyMap nonEmptyMap, ColorStyles colorStyles, int i, FontWeight fontWeight, FontSpec fontSpec, TextAlign textAlign, Alignment.Horizontal horizontal, ColorStyles colorStyles2, boolean z, Size size, PaddingValues paddingValues, PaddingValues paddingValues2, Package r13, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, Date date, CountdownComponent.CountFrom countFrom, NonEmptyMap nonEmptyMap2, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(nonEmptyMap, colorStyles, i, fontWeight, fontSpec, textAlign, horizontal, colorStyles2, z, size, paddingValues, paddingValues2, r13, resolvedOffer, num, offerEligibility, date, countFrom, nonEmptyMap2, list);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ boolean computeIsSelected(PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo, int i) {
        return PackageContext.DefaultImpls.computeIsSelected(this, selectedPackageInfo, i);
    }

    public final /* synthetic */ ColorStyles getBackgroundColor() {
        return this.backgroundColor;
    }

    public final /* synthetic */ ColorStyles getColor() {
        return this.color;
    }

    public final /* synthetic */ CountdownComponent.CountFrom getCountFrom() {
        return this.countFrom;
    }

    public final /* synthetic */ Date getCountdownDate() {
        return this.countdownDate;
    }

    public final /* synthetic */ int getFontSize() {
        return this.fontSize;
    }

    public final /* synthetic */ FontSpec getFontSpec() {
        return this.fontSpec;
    }

    public final /* synthetic */ FontWeight getFontWeight() {
        return this.fontWeight;
    }

    public final /* synthetic */ Alignment.Horizontal getHorizontalAlignment() {
        return this.horizontalAlignment;
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

    /* JADX INFO: renamed from: getTextAlign-buA522U, reason: not valid java name and from getter */
    public final /* synthetic */ TextAlign getTextAlign() {
        return this.textAlign;
    }

    public final /* synthetic */ NonEmptyMap getTexts() {
        return this.texts;
    }

    public final /* synthetic */ NonEmptyMap getVariableLocalizations() {
        return this.variableLocalizations;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
    public /* synthetic */ boolean getVisible() {
        return this.visible;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ OfferEligibility resolveOfferEligibility(OfferEligibility offerEligibility) {
        return PackageContext.DefaultImpls.resolveOfferEligibility(this, offerEligibility);
    }
}
