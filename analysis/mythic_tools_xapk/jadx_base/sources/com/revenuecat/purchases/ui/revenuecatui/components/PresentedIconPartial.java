package com.revenuecat.purchases.ui.revenuecatui.components;

import com.revenuecat.purchases.paywalls.components.IconComponent;
import com.revenuecat.purchases.paywalls.components.PartialIconComponent;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.style.IconComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.IconComponentStyleKt;
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

/* JADX INFO: compiled from: PresentedIconPartial.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u000f\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0000H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedIconPartial;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedPartial;", "colorStyles", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;", "background", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/IconComponentStyle$Background;", "partial", "Lcom/revenuecat/purchases/paywalls/components/PartialIconComponent;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/IconComponentStyle$Background;Lcom/revenuecat/purchases/paywalls/components/PartialIconComponent;)V", "getBackground", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/style/IconComponentStyle$Background;", "getColorStyles", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;", "getPartial", "()Lcom/revenuecat/purchases/paywalls/components/PartialIconComponent;", "combine", "with", "Companion", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PresentedIconPartial implements PresentedPartial<PresentedIconPartial> {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final IconComponentStyle.Background background;
    private final ColorStyles colorStyles;
    private final PartialIconComponent partial;

    /* JADX INFO: compiled from: PresentedIconPartial.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J7\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00042\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0086\u0002¨\u0006\u000e"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedIconPartial$Companion;", "", "()V", "invoke", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/Result;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedIconPartial;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyList;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError;", "from", "Lcom/revenuecat/purchases/paywalls/components/PartialIconComponent;", "aliases", "", "Lcom/revenuecat/purchases/ColorAlias;", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final /* synthetic */ Result invoke(PartialIconComponent from, Map aliases) {
            Intrinsics.checkNotNullParameter(from, "from");
            Intrinsics.checkNotNullParameter(aliases, "aliases");
            ColorScheme color = from.getColor();
            Result resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(color != null ? ColorStyleKt.toColorStyles(color, aliases) : null);
            IconComponent.IconBackground iconBackground = from.getIconBackground();
            Result resultOrSuccessfullyNull2 = ResultKt.orSuccessfullyNull(iconBackground != null ? IconComponentStyleKt.toBackground(iconBackground, aliases) : null);
            Result.Success success = new Result.Success(Unit.INSTANCE);
            Result.Success success2 = new Result.Success(Unit.INSTANCE);
            Result.Success success3 = new Result.Success(Unit.INSTANCE);
            Result.Success success4 = new Result.Success(Unit.INSTANCE);
            NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{resultOrSuccessfullyNull, resultOrSuccessfullyNull2, success, success2, success3, success4})));
            if (nonEmptyListOrNull != null) {
                return new Result.Error(nonEmptyListOrNull);
            }
            Intrinsics.checkNotNull(resultOrSuccessfullyNull, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
            Object value = ((Result.Success) resultOrSuccessfullyNull).getValue();
            Intrinsics.checkNotNull(resultOrSuccessfullyNull2, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<B of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
            Object value2 = ((Result.Success) resultOrSuccessfullyNull2).getValue();
            Object value3 = success.getValue();
            Object value4 = success2.getValue();
            Object value5 = success3.getValue();
            return new Result.Success(new PresentedIconPartial((ColorStyles) value, (IconComponentStyle.Background) value2, from));
        }
    }

    public PresentedIconPartial(ColorStyles colorStyles, IconComponentStyle.Background background, PartialIconComponent partial) {
        Intrinsics.checkNotNullParameter(partial, "partial");
        this.colorStyles = colorStyles;
        this.background = background;
        this.partial = partial;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.PresentedPartial
    public PresentedIconPartial combine(PresentedIconPartial with) {
        ColorStyles colorStyles;
        IconComponentStyle.Background background;
        Boolean visible;
        String baseUrl;
        String iconName;
        IconComponent.Formats formats;
        Size size;
        ColorScheme color;
        Padding padding;
        Padding margin;
        IconComponent.IconBackground iconBackground;
        PartialIconComponent partialIconComponent = with != null ? with.partial : null;
        if (with == null || (colorStyles = with.colorStyles) == null) {
            colorStyles = this.colorStyles;
        }
        if (with == null || (background = with.background) == null) {
            background = this.background;
        }
        if (partialIconComponent == null || (visible = partialIconComponent.getVisible()) == null) {
            visible = this.partial.getVisible();
        }
        if (partialIconComponent == null || (baseUrl = partialIconComponent.getBaseUrl()) == null) {
            baseUrl = this.partial.getBaseUrl();
        }
        if (partialIconComponent == null || (iconName = partialIconComponent.getIconName()) == null) {
            iconName = this.partial.getIconName();
        }
        if (partialIconComponent == null || (formats = partialIconComponent.getFormats()) == null) {
            formats = this.partial.getFormats();
        }
        if (partialIconComponent == null || (size = partialIconComponent.getSize()) == null) {
            size = this.partial.getSize();
        }
        if (partialIconComponent == null || (color = partialIconComponent.getColor()) == null) {
            color = this.partial.getColor();
        }
        if (partialIconComponent == null || (padding = partialIconComponent.getPadding()) == null) {
            padding = this.partial.getPadding();
        }
        if (partialIconComponent == null || (margin = partialIconComponent.getMargin()) == null) {
            margin = this.partial.getMargin();
        }
        if (partialIconComponent == null || (iconBackground = partialIconComponent.getIconBackground()) == null) {
            iconBackground = this.partial.getIconBackground();
        }
        return new PresentedIconPartial(colorStyles, background, new PartialIconComponent(visible, baseUrl, iconName, formats, size, color, padding, margin, iconBackground));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PresentedIconPartial)) {
            return false;
        }
        PresentedIconPartial presentedIconPartial = (PresentedIconPartial) obj;
        return Intrinsics.areEqual(this.colorStyles, presentedIconPartial.colorStyles) && Intrinsics.areEqual(this.background, presentedIconPartial.background) && Intrinsics.areEqual(this.partial, presentedIconPartial.partial);
    }

    public final /* synthetic */ IconComponentStyle.Background getBackground() {
        return this.background;
    }

    public final /* synthetic */ ColorStyles getColorStyles() {
        return this.colorStyles;
    }

    public final /* synthetic */ PartialIconComponent getPartial() {
        return this.partial;
    }

    public int hashCode() {
        ColorStyles colorStyles = this.colorStyles;
        int iHashCode = (colorStyles == null ? 0 : colorStyles.hashCode()) * 31;
        IconComponentStyle.Background background = this.background;
        return ((iHashCode + (background != null ? background.hashCode() : 0)) * 31) + this.partial.hashCode();
    }

    public String toString() {
        return "PresentedIconPartial(colorStyles=" + this.colorStyles + ", background=" + this.background + ", partial=" + this.partial + ')';
    }
}
