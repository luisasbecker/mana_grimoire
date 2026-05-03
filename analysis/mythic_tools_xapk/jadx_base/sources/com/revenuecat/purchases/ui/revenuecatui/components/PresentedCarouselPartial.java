package com.revenuecat.purchases.ui.revenuecatui.components;

import com.revenuecat.purchases.paywalls.components.CarouselComponent;
import com.revenuecat.purchases.paywalls.components.PartialCarouselComponent;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.VerticalAlignment;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.style.CarouselComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.extensions.PageControlExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyList;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyListKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Result;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PresentedCarouselPartial.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0019B5\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0012\u0010\u0017\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0000H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedCarouselPartial;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedPartial;", "backgroundStyles", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;", "borderStyles", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;", "shadowStyles", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;", "pageControlStyles", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/CarouselComponentStyle$PageControlStyles;", "partial", "Lcom/revenuecat/purchases/paywalls/components/PartialCarouselComponent;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/CarouselComponentStyle$PageControlStyles;Lcom/revenuecat/purchases/paywalls/components/PartialCarouselComponent;)V", "getBackgroundStyles", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;", "getBorderStyles", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;", "getPageControlStyles", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/style/CarouselComponentStyle$PageControlStyles;", "getPartial", "()Lcom/revenuecat/purchases/paywalls/components/PartialCarouselComponent;", "getShadowStyles", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;", "combine", "with", "Companion", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PresentedCarouselPartial implements PresentedPartial<PresentedCarouselPartial> {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final BackgroundStyles backgroundStyles;
    private final BorderStyles borderStyles;
    private final CarouselComponentStyle.PageControlStyles pageControlStyles;
    private final PartialCarouselComponent partial;
    private final ShadowStyles shadowStyles;

    /* JADX INFO: compiled from: PresentedCarouselPartial.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J7\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00042\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0086\u0002¨\u0006\u000e"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedCarouselPartial$Companion;", "", "()V", "invoke", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/Result;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedCarouselPartial;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyList;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError;", "from", "Lcom/revenuecat/purchases/paywalls/components/PartialCarouselComponent;", "aliases", "", "Lcom/revenuecat/purchases/ColorAlias;", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final /* synthetic */ Result invoke(PartialCarouselComponent from, Map aliases) {
            BackgroundStyles backgroundStylesM10509boximpl;
            Intrinsics.checkNotNullParameter(from, "from");
            Intrinsics.checkNotNullParameter(aliases, "aliases");
            Background background = from.getBackground();
            Result resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(background != null ? BackgroundStyleKt.toBackgroundStyles(background, aliases) : null);
            ColorScheme backgroundColor = from.getBackgroundColor();
            Result resultOrSuccessfullyNull2 = ResultKt.orSuccessfullyNull(backgroundColor != null ? ColorStyleKt.toColorStyles(backgroundColor, aliases) : null);
            Border border = from.getBorder();
            Result resultOrSuccessfullyNull3 = ResultKt.orSuccessfullyNull(border != null ? BorderStyleKt.toBorderStyles(border, aliases) : null);
            Shadow shadow = from.getShadow();
            Result resultOrSuccessfullyNull4 = ResultKt.orSuccessfullyNull(shadow != null ? ShadowStyleKt.toShadowStyles(shadow, aliases) : null);
            CarouselComponent.PageControl pageControl = from.getPageControl();
            Result resultOrSuccessfullyNull5 = ResultKt.orSuccessfullyNull(pageControl != null ? PageControlExtensionsKt.toPageControlStyles(pageControl, aliases) : null);
            Result.Success success = new Result.Success(Unit.INSTANCE);
            NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{resultOrSuccessfullyNull, resultOrSuccessfullyNull2, resultOrSuccessfullyNull3, resultOrSuccessfullyNull4, resultOrSuccessfullyNull5, success})));
            if (nonEmptyListOrNull != null) {
                return new Result.Error(nonEmptyListOrNull);
            }
            Intrinsics.checkNotNull(resultOrSuccessfullyNull, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
            Object value = ((Result.Success) resultOrSuccessfullyNull).getValue();
            Intrinsics.checkNotNull(resultOrSuccessfullyNull2, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<B of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
            Object value2 = ((Result.Success) resultOrSuccessfullyNull2).getValue();
            Intrinsics.checkNotNull(resultOrSuccessfullyNull3, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<C of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
            Object value3 = ((Result.Success) resultOrSuccessfullyNull3).getValue();
            Intrinsics.checkNotNull(resultOrSuccessfullyNull4, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<D of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
            Object value4 = ((Result.Success) resultOrSuccessfullyNull4).getValue();
            Intrinsics.checkNotNull(resultOrSuccessfullyNull5, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<E of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
            Object value5 = ((Result.Success) resultOrSuccessfullyNull5).getValue();
            CarouselComponentStyle.PageControlStyles pageControlStyles = (CarouselComponentStyle.PageControlStyles) value5;
            ShadowStyles shadowStyles = (ShadowStyles) value4;
            BorderStyles borderStyles = (BorderStyles) value3;
            ColorStyles colorStyles = (ColorStyles) value2;
            BackgroundStyles backgroundStyles = (BackgroundStyles) value;
            if (backgroundStyles == null) {
                ColorStyles colorStylesM10510constructorimpl = colorStyles != null ? BackgroundStyles.Color.m10510constructorimpl(colorStyles) : null;
                backgroundStylesM10509boximpl = colorStylesM10510constructorimpl != null ? BackgroundStyles.Color.m10509boximpl(colorStylesM10510constructorimpl) : null;
            } else {
                backgroundStylesM10509boximpl = backgroundStyles;
            }
            return new Result.Success(new PresentedCarouselPartial(backgroundStylesM10509boximpl, borderStyles, shadowStyles, pageControlStyles, from));
        }
    }

    public PresentedCarouselPartial(BackgroundStyles backgroundStyles, BorderStyles borderStyles, ShadowStyles shadowStyles, CarouselComponentStyle.PageControlStyles pageControlStyles, PartialCarouselComponent partial) {
        Intrinsics.checkNotNullParameter(partial, "partial");
        this.backgroundStyles = backgroundStyles;
        this.borderStyles = borderStyles;
        this.shadowStyles = shadowStyles;
        this.pageControlStyles = pageControlStyles;
        this.partial = partial;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.PresentedPartial
    public PresentedCarouselPartial combine(PresentedCarouselPartial with) {
        Boolean visible;
        Integer initialPageIndex;
        VerticalAlignment pageAlignment;
        Size size;
        Integer pagePeek;
        Float pageSpacing;
        ColorScheme backgroundColor;
        Background background;
        Padding padding;
        Padding margin;
        Shape shape;
        Border border;
        Shadow shadow;
        CarouselComponent.PageControl pageControl;
        Boolean loop;
        CarouselComponent.AutoAdvancePages autoAdvance;
        PartialCarouselComponent partialCarouselComponent = with != null ? with.partial : null;
        BackgroundStyles backgroundStyles = this.backgroundStyles;
        if (backgroundStyles == null) {
            backgroundStyles = with != null ? with.backgroundStyles : null;
        }
        BorderStyles borderStyles = this.borderStyles;
        if (borderStyles == null) {
            borderStyles = with != null ? with.borderStyles : null;
        }
        ShadowStyles shadowStyles = this.shadowStyles;
        if (shadowStyles == null) {
            shadowStyles = with != null ? with.shadowStyles : null;
        }
        CarouselComponentStyle.PageControlStyles pageControlStyles = this.pageControlStyles;
        if (pageControlStyles == null) {
            pageControlStyles = with != null ? with.pageControlStyles : null;
        }
        if (partialCarouselComponent == null || (visible = partialCarouselComponent.getVisible()) == null) {
            visible = this.partial.getVisible();
        }
        Boolean bool = visible;
        if (partialCarouselComponent == null || (initialPageIndex = partialCarouselComponent.getInitialPageIndex()) == null) {
            initialPageIndex = this.partial.getInitialPageIndex();
        }
        Integer num = initialPageIndex;
        if (partialCarouselComponent == null || (pageAlignment = partialCarouselComponent.getPageAlignment()) == null) {
            pageAlignment = this.partial.getPageAlignment();
        }
        VerticalAlignment verticalAlignment = pageAlignment;
        if (partialCarouselComponent == null || (size = partialCarouselComponent.getSize()) == null) {
            size = this.partial.getSize();
        }
        Size size2 = size;
        if (partialCarouselComponent == null || (pagePeek = partialCarouselComponent.getPagePeek()) == null) {
            pagePeek = this.partial.getPagePeek();
        }
        Integer num2 = pagePeek;
        if (partialCarouselComponent == null || (pageSpacing = partialCarouselComponent.getPageSpacing()) == null) {
            pageSpacing = this.partial.getPageSpacing();
        }
        Float f = pageSpacing;
        if (partialCarouselComponent == null || (backgroundColor = partialCarouselComponent.getBackgroundColor()) == null) {
            backgroundColor = this.partial.getBackgroundColor();
        }
        ColorScheme colorScheme = backgroundColor;
        if (partialCarouselComponent == null || (background = partialCarouselComponent.getBackground()) == null) {
            background = this.partial.getBackground();
        }
        Background background2 = background;
        if (partialCarouselComponent == null || (padding = partialCarouselComponent.getPadding()) == null) {
            padding = this.partial.getPadding();
        }
        Padding padding2 = padding;
        if (partialCarouselComponent == null || (margin = partialCarouselComponent.getMargin()) == null) {
            margin = this.partial.getMargin();
        }
        Padding padding3 = margin;
        if (partialCarouselComponent == null || (shape = partialCarouselComponent.getShape()) == null) {
            shape = this.partial.getShape();
        }
        Shape shape2 = shape;
        if (partialCarouselComponent == null || (border = partialCarouselComponent.getBorder()) == null) {
            border = this.partial.getBorder();
        }
        Border border2 = border;
        if (partialCarouselComponent == null || (shadow = partialCarouselComponent.getShadow()) == null) {
            shadow = this.partial.getShadow();
        }
        Shadow shadow2 = shadow;
        if (partialCarouselComponent == null || (pageControl = partialCarouselComponent.getPageControl()) == null) {
            pageControl = this.partial.getPageControl();
        }
        CarouselComponent.PageControl pageControl2 = pageControl;
        if (partialCarouselComponent == null || (loop = partialCarouselComponent.getLoop()) == null) {
            loop = this.partial.getLoop();
        }
        Boolean bool2 = loop;
        if (partialCarouselComponent == null || (autoAdvance = partialCarouselComponent.getAutoAdvance()) == null) {
            autoAdvance = this.partial.getAutoAdvance();
        }
        return new PresentedCarouselPartial(backgroundStyles, borderStyles, shadowStyles, pageControlStyles, new PartialCarouselComponent(bool, num, verticalAlignment, size2, num2, f, colorScheme, background2, padding2, padding3, shape2, border2, shadow2, pageControl2, bool2, autoAdvance));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PresentedCarouselPartial)) {
            return false;
        }
        PresentedCarouselPartial presentedCarouselPartial = (PresentedCarouselPartial) obj;
        return Intrinsics.areEqual(this.backgroundStyles, presentedCarouselPartial.backgroundStyles) && Intrinsics.areEqual(this.borderStyles, presentedCarouselPartial.borderStyles) && Intrinsics.areEqual(this.shadowStyles, presentedCarouselPartial.shadowStyles) && Intrinsics.areEqual(this.pageControlStyles, presentedCarouselPartial.pageControlStyles) && Intrinsics.areEqual(this.partial, presentedCarouselPartial.partial);
    }

    public final /* synthetic */ BackgroundStyles getBackgroundStyles() {
        return this.backgroundStyles;
    }

    public final /* synthetic */ BorderStyles getBorderStyles() {
        return this.borderStyles;
    }

    public final /* synthetic */ CarouselComponentStyle.PageControlStyles getPageControlStyles() {
        return this.pageControlStyles;
    }

    public final /* synthetic */ PartialCarouselComponent getPartial() {
        return this.partial;
    }

    public final /* synthetic */ ShadowStyles getShadowStyles() {
        return this.shadowStyles;
    }

    public int hashCode() {
        BackgroundStyles backgroundStyles = this.backgroundStyles;
        int iHashCode = (backgroundStyles == null ? 0 : backgroundStyles.hashCode()) * 31;
        BorderStyles borderStyles = this.borderStyles;
        int iHashCode2 = (iHashCode + (borderStyles == null ? 0 : borderStyles.hashCode())) * 31;
        ShadowStyles shadowStyles = this.shadowStyles;
        int iHashCode3 = (iHashCode2 + (shadowStyles == null ? 0 : shadowStyles.hashCode())) * 31;
        CarouselComponentStyle.PageControlStyles pageControlStyles = this.pageControlStyles;
        return ((iHashCode3 + (pageControlStyles != null ? pageControlStyles.hashCode() : 0)) * 31) + this.partial.hashCode();
    }

    public String toString() {
        return "PresentedCarouselPartial(backgroundStyles=" + this.backgroundStyles + ", borderStyles=" + this.borderStyles + ", shadowStyles=" + this.shadowStyles + ", pageControlStyles=" + this.pageControlStyles + ", partial=" + this.partial + ')';
    }
}
