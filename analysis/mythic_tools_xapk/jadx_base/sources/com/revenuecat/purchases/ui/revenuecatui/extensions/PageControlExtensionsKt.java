package com.revenuecat.purchases.ui.revenuecatui.extensions;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.paywalls.components.CarouselComponent;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.PaddingKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.style.CarouselComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.StyleFactory;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyList;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyListKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Result;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PageControlExtensions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a2\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0000¨\u0006\n"}, d2 = {"toPageControlStyles", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/Result;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/CarouselComponentStyle$PageControlStyles;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyList;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError;", "Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl;", "aliases", "", "Lcom/revenuecat/purchases/ColorAlias;", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class PageControlExtensionsKt {
    public static final /* synthetic */ Result toPageControlStyles(CarouselComponent.PageControl pageControl, Map aliases) {
        Intrinsics.checkNotNullParameter(pageControl, "<this>");
        Intrinsics.checkNotNullParameter(aliases, "aliases");
        Result colorStyles = ColorStyleKt.toColorStyles(pageControl.getActive().getColor(), aliases);
        Result colorStyles2 = ColorStyleKt.toColorStyles(pageControl.getDefault().getColor(), aliases);
        ColorScheme backgroundColor = pageControl.getBackgroundColor();
        Result resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(backgroundColor != null ? ColorStyleKt.toColorStyles(backgroundColor, aliases) : null);
        Border border = pageControl.getBorder();
        Result resultOrSuccessfullyNull2 = ResultKt.orSuccessfullyNull(border != null ? BorderStyleKt.toBorderStyles(border, aliases) : null);
        Shadow shadow = pageControl.getShadow();
        Result resultOrSuccessfullyNull3 = ResultKt.orSuccessfullyNull(shadow != null ? ShadowStyleKt.toShadowStyles(shadow, aliases) : null);
        ColorScheme strokeColor = pageControl.getActive().getStrokeColor();
        Result resultOrSuccessfullyNull4 = ResultKt.orSuccessfullyNull(strokeColor != null ? ColorStyleKt.toColorStyles(strokeColor, aliases) : null);
        ColorScheme strokeColor2 = pageControl.getDefault().getStrokeColor();
        Result resultOrSuccessfullyNull5 = ResultKt.orSuccessfullyNull(strokeColor2 != null ? ColorStyleKt.toColorStyles(strokeColor2, aliases) : null);
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{colorStyles, colorStyles2, resultOrSuccessfullyNull, resultOrSuccessfullyNull2, resultOrSuccessfullyNull3, resultOrSuccessfullyNull4})));
        if (nonEmptyListOrNull != null) {
            return new Result.Error(nonEmptyListOrNull);
        }
        Intrinsics.checkNotNull(colorStyles, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value = ((Result.Success) colorStyles).getValue();
        Intrinsics.checkNotNull(colorStyles2, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<B of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value2 = ((Result.Success) colorStyles2).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<C of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value3 = ((Result.Success) resultOrSuccessfullyNull).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull2, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<D of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value4 = ((Result.Success) resultOrSuccessfullyNull2).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull3, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<E of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value5 = ((Result.Success) resultOrSuccessfullyNull3).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull4, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<F of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value6 = ((Result.Success) resultOrSuccessfullyNull4).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull5, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<G of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        ColorStyles colorStyles3 = (ColorStyles) ((Result.Success) resultOrSuccessfullyNull5).getValue();
        ColorStyles colorStyles4 = (ColorStyles) value6;
        ShadowStyles shadowStyles = (ShadowStyles) value5;
        BorderStyles borderStyles = (BorderStyles) value4;
        ColorStyles colorStyles5 = (ColorStyles) value3;
        ColorStyles colorStyles6 = (ColorStyles) value2;
        ColorStyles colorStyles7 = (ColorStyles) value;
        CarouselComponent.PageControl.Position position = pageControl.getPosition();
        float fM9114constructorimpl = Dp.m9114constructorimpl(pageControl.getSpacing() != null ? r3.intValue() : 0.0f);
        PaddingValues paddingValues = PaddingKt.toPaddingValues(pageControl.getPadding());
        PaddingValues paddingValues2 = PaddingKt.toPaddingValues(pageControl.getMargin());
        Shape.Rectangle shape = pageControl.getShape();
        if (shape == null) {
            shape = StyleFactory.INSTANCE.getDEFAULT_SHAPE$revenuecatui_defaultsBc8Release();
        }
        return new Result.Success(new CarouselComponentStyle.PageControlStyles(position, fM9114constructorimpl, paddingValues, paddingValues2, colorStyles5, shape, borderStyles, shadowStyles, new CarouselComponentStyle.IndicatorStyles(Dp.m9114constructorimpl(pageControl.getActive().getWidth()), Dp.m9114constructorimpl(pageControl.getActive().getHeight()), colorStyles7, colorStyles4, pageControl.getActive().getStrokeWidth() != null ? Dp.m9112boximpl(Dp.m9114constructorimpl(r3.getData())) : null, null), new CarouselComponentStyle.IndicatorStyles(Dp.m9114constructorimpl(pageControl.getDefault().getWidth()), Dp.m9114constructorimpl(pageControl.getDefault().getHeight()), colorStyles6, colorStyles3, pageControl.getDefault().getStrokeWidth() != null ? Dp.m9112boximpl(Dp.m9114constructorimpl(r2.getData())) : null, null), null));
    }
}
