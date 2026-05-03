package com.revenuecat.purchases.ui.revenuecatui.components;

import com.revenuecat.purchases.paywalls.components.PartialTextComponent;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.FontWeight;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.LocalizationKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.FontSpec;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.FontSpecKt;
import com.revenuecat.purchases.ui.revenuecatui.errors.PaywallValidationError;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyList;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyListKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyMap;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Result;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LocalizedTextPartial.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0019BC\b\u0002\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0012\u0010\u0017\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0000H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/LocalizedTextPartial;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedPartial;", "texts", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyMap;", "Lcom/revenuecat/purchases/paywalls/components/common/LocaleId;", "", "color", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;", "backgroundColor", "fontSpec", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec;", "partial", "Lcom/revenuecat/purchases/paywalls/components/PartialTextComponent;", "(Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyMap;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec;Lcom/revenuecat/purchases/paywalls/components/PartialTextComponent;)V", "getBackgroundColor", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;", "getColor", "getFontSpec", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec;", "getPartial", "()Lcom/revenuecat/purchases/paywalls/components/PartialTextComponent;", "getTexts", "()Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyMap;", "combine", "with", "Companion", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LocalizedTextPartial implements PresentedPartial<LocalizedTextPartial> {
    private final ColorStyles backgroundColor;
    private final ColorStyles color;
    private final FontSpec fontSpec;
    private final PartialTextComponent partial;
    private final NonEmptyMap<LocaleId, String> texts;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: LocalizedTextPartial.kt */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jo\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00042\u0006\u0010\b\u001a\u00020\t2\"\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u000bj\u0002`\u000f0\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00112\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0011H\u0086\u0002¨\u0006\u0017"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/LocalizedTextPartial$Companion;", "", "()V", "invoke", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/Result;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/LocalizedTextPartial;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyList;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError;", "from", "Lcom/revenuecat/purchases/paywalls/components/PartialTextComponent;", "using", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyMap;", "Lcom/revenuecat/purchases/paywalls/components/common/LocaleId;", "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationKey;", "Lcom/revenuecat/purchases/paywalls/components/common/LocalizationData;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/ktx/LocalizationDictionary;", "aliases", "", "Lcom/revenuecat/purchases/ColorAlias;", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "fontAliases", "Lcom/revenuecat/purchases/FontAlias;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final /* synthetic */ Result invoke(PartialTextComponent from, NonEmptyMap using, Map aliases, Map fontAliases) {
            Result resultM10543getFontSpecpDyximM;
            Intrinsics.checkNotNullParameter(from, "from");
            Intrinsics.checkNotNullParameter(using, "using");
            Intrinsics.checkNotNullParameter(aliases, "aliases");
            Intrinsics.checkNotNullParameter(fontAliases, "fontAliases");
            String text = from.getText();
            Result resultRecoverFromFontAliasError = null;
            Result resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(text != null ? LocalizationKt.m10488stringForAllLocales7v81vok(using, text) : null);
            ColorScheme color = from.getColor();
            Result resultOrSuccessfullyNull2 = ResultKt.orSuccessfullyNull(color != null ? ColorStyleKt.toColorStyles(color, aliases) : null);
            ColorScheme backgroundColor = from.getBackgroundColor();
            Result resultOrSuccessfullyNull3 = ResultKt.orSuccessfullyNull(backgroundColor != null ? ColorStyleKt.toColorStyles(backgroundColor, aliases) : null);
            String fontName = from.getFontName();
            if (fontName != null && (resultM10543getFontSpecpDyximM = FontSpecKt.m10543getFontSpecpDyximM(fontAliases, fontName)) != null) {
                resultRecoverFromFontAliasError = FontSpecKt.recoverFromFontAliasError(resultM10543getFontSpecpDyximM);
            }
            Result.Error errorOrSuccessfullyNull = ResultKt.orSuccessfullyNull(resultRecoverFromFontAliasError);
            if (!(errorOrSuccessfullyNull instanceof Result.Success)) {
                if (!(errorOrSuccessfullyNull instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                errorOrSuccessfullyNull = new Result.Error(NonEmptyListKt.nonEmptyListOf((PaywallValidationError) ((Result.Error) errorOrSuccessfullyNull).getValue(), new PaywallValidationError[0]));
            }
            Result.Success success = new Result.Success(Unit.INSTANCE);
            Result.Success success2 = new Result.Success(Unit.INSTANCE);
            NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{resultOrSuccessfullyNull, resultOrSuccessfullyNull2, resultOrSuccessfullyNull3, errorOrSuccessfullyNull, success, success2})));
            if (nonEmptyListOrNull != null) {
                return new Result.Error(nonEmptyListOrNull);
            }
            Intrinsics.checkNotNull(resultOrSuccessfullyNull, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
            Object value = ((Result.Success) resultOrSuccessfullyNull).getValue();
            Intrinsics.checkNotNull(resultOrSuccessfullyNull2, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<B of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
            Object value2 = ((Result.Success) resultOrSuccessfullyNull2).getValue();
            Intrinsics.checkNotNull(resultOrSuccessfullyNull3, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<C of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
            Object value3 = ((Result.Success) resultOrSuccessfullyNull3).getValue();
            Intrinsics.checkNotNull(errorOrSuccessfullyNull, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<D of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
            Object value4 = ((Result.Success) errorOrSuccessfullyNull).getValue();
            Object value5 = success.getValue();
            return new Result.Success(new LocalizedTextPartial((NonEmptyMap) value, (ColorStyles) value2, (ColorStyles) value3, (FontSpec) value4, from, null));
        }
    }

    private LocalizedTextPartial(NonEmptyMap<LocaleId, String> nonEmptyMap, ColorStyles colorStyles, ColorStyles colorStyles2, FontSpec fontSpec, PartialTextComponent partialTextComponent) {
        this.texts = nonEmptyMap;
        this.color = colorStyles;
        this.backgroundColor = colorStyles2;
        this.fontSpec = fontSpec;
        this.partial = partialTextComponent;
    }

    public /* synthetic */ LocalizedTextPartial(NonEmptyMap nonEmptyMap, ColorStyles colorStyles, ColorStyles colorStyles2, FontSpec fontSpec, PartialTextComponent partialTextComponent, DefaultConstructorMarker defaultConstructorMarker) {
        this(nonEmptyMap, colorStyles, colorStyles2, fontSpec, partialTextComponent);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.PresentedPartial
    public /* synthetic */ LocalizedTextPartial combine(LocalizedTextPartial with) {
        NonEmptyMap<LocaleId, String> nonEmptyMap;
        ColorStyles colorStyles;
        ColorStyles colorStyles2;
        FontSpec fontSpec;
        Boolean visible;
        String text;
        ColorScheme color;
        ColorScheme backgroundColor;
        String fontName;
        FontWeight fontWeight;
        Integer fontWeightInt;
        Integer fontSize;
        HorizontalAlignment horizontalAlignment;
        Size size;
        Padding padding;
        Padding margin;
        PartialTextComponent partialTextComponent = with != null ? with.partial : null;
        if (with == null || (nonEmptyMap = with.texts) == null) {
            nonEmptyMap = this.texts;
        }
        if (with == null || (colorStyles = with.color) == null) {
            colorStyles = this.color;
        }
        if (with == null || (colorStyles2 = with.backgroundColor) == null) {
            colorStyles2 = this.backgroundColor;
        }
        if (with == null || (fontSpec = with.fontSpec) == null) {
            fontSpec = this.fontSpec;
        }
        FontSpec fontSpec2 = fontSpec;
        if (partialTextComponent == null || (visible = partialTextComponent.getVisible()) == null) {
            visible = this.partial.getVisible();
        }
        Boolean bool = visible;
        if (partialTextComponent == null || (text = partialTextComponent.getText()) == null) {
            text = this.partial.getText();
        }
        String str = text;
        if (partialTextComponent == null || (color = partialTextComponent.getColor()) == null) {
            color = this.partial.getColor();
        }
        ColorScheme colorScheme = color;
        if (partialTextComponent == null || (backgroundColor = partialTextComponent.getBackgroundColor()) == null) {
            backgroundColor = this.partial.getBackgroundColor();
        }
        ColorScheme colorScheme2 = backgroundColor;
        if (partialTextComponent == null || (fontName = partialTextComponent.getFontName()) == null) {
            fontName = this.partial.getFontName();
        }
        String str2 = fontName;
        if (partialTextComponent == null || (fontWeight = partialTextComponent.getFontWeight()) == null) {
            fontWeight = this.partial.getFontWeight();
        }
        FontWeight fontWeight2 = fontWeight;
        if (partialTextComponent == null || (fontWeightInt = partialTextComponent.getFontWeightInt()) == null) {
            fontWeightInt = this.partial.getFontWeightInt();
        }
        Integer num = fontWeightInt;
        if (partialTextComponent == null || (fontSize = partialTextComponent.getFontSize()) == null) {
            fontSize = this.partial.getFontSize();
        }
        Integer num2 = fontSize;
        if (partialTextComponent == null || (horizontalAlignment = partialTextComponent.getHorizontalAlignment()) == null) {
            horizontalAlignment = this.partial.getHorizontalAlignment();
        }
        HorizontalAlignment horizontalAlignment2 = horizontalAlignment;
        if (partialTextComponent == null || (size = partialTextComponent.getSize()) == null) {
            size = this.partial.getSize();
        }
        Size size2 = size;
        if (partialTextComponent == null || (padding = partialTextComponent.getPadding()) == null) {
            padding = this.partial.getPadding();
        }
        Padding padding2 = padding;
        if (partialTextComponent == null || (margin = partialTextComponent.getMargin()) == null) {
            margin = this.partial.getMargin();
        }
        return new LocalizedTextPartial(nonEmptyMap, colorStyles, colorStyles2, fontSpec2, new PartialTextComponent(bool, str, colorScheme, colorScheme2, str2, fontWeight2, num, num2, horizontalAlignment2, size2, padding2, margin, null));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalizedTextPartial)) {
            return false;
        }
        LocalizedTextPartial localizedTextPartial = (LocalizedTextPartial) obj;
        return Intrinsics.areEqual(this.texts, localizedTextPartial.texts) && Intrinsics.areEqual(this.color, localizedTextPartial.color) && Intrinsics.areEqual(this.backgroundColor, localizedTextPartial.backgroundColor) && Intrinsics.areEqual(this.fontSpec, localizedTextPartial.fontSpec) && Intrinsics.areEqual(this.partial, localizedTextPartial.partial);
    }

    public final /* synthetic */ ColorStyles getBackgroundColor() {
        return this.backgroundColor;
    }

    public final /* synthetic */ ColorStyles getColor() {
        return this.color;
    }

    public final /* synthetic */ FontSpec getFontSpec() {
        return this.fontSpec;
    }

    public final /* synthetic */ PartialTextComponent getPartial() {
        return this.partial;
    }

    public final /* synthetic */ NonEmptyMap getTexts() {
        return this.texts;
    }

    public int hashCode() {
        NonEmptyMap<LocaleId, String> nonEmptyMap = this.texts;
        int iHashCode = (nonEmptyMap == null ? 0 : nonEmptyMap.hashCode()) * 31;
        ColorStyles colorStyles = this.color;
        int iHashCode2 = (iHashCode + (colorStyles == null ? 0 : colorStyles.hashCode())) * 31;
        ColorStyles colorStyles2 = this.backgroundColor;
        int iHashCode3 = (iHashCode2 + (colorStyles2 == null ? 0 : colorStyles2.hashCode())) * 31;
        FontSpec fontSpec = this.fontSpec;
        return ((iHashCode3 + (fontSpec != null ? fontSpec.hashCode() : 0)) * 31) + this.partial.hashCode();
    }

    public String toString() {
        return "LocalizedTextPartial(texts=" + this.texts + ", color=" + this.color + ", backgroundColor=" + this.backgroundColor + ", fontSpec=" + this.fontSpec + ", partial=" + this.partial + ')';
    }
}
