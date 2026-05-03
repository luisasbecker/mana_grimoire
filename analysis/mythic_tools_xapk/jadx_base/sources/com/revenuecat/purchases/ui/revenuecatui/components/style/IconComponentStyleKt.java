package com.revenuecat.purchases.ui.revenuecatui.components.style;

import com.revenuecat.purchases.paywalls.components.IconComponent;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.style.IconComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyList;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyListKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Result;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IconComponentStyle.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a2\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0000¨\u0006\n"}, d2 = {"toBackground", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/Result;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/IconComponentStyle$Background;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyList;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError;", "Lcom/revenuecat/purchases/paywalls/components/IconComponent$IconBackground;", "aliases", "", "Lcom/revenuecat/purchases/ColorAlias;", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final /* synthetic */ class IconComponentStyleKt {
    public static final /* synthetic */ Result toBackground(IconComponent.IconBackground iconBackground, Map aliases) {
        Intrinsics.checkNotNullParameter(iconBackground, "<this>");
        Intrinsics.checkNotNullParameter(aliases, "aliases");
        Result colorStyles = ColorStyleKt.toColorStyles(iconBackground.getColor(), aliases);
        Border border = iconBackground.getBorder();
        Result resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull(border != null ? BorderStyleKt.toBorderStyles(border, aliases) : null);
        Shadow shadow = iconBackground.getShadow();
        Result resultOrSuccessfullyNull2 = ResultKt.orSuccessfullyNull(shadow != null ? ShadowStyleKt.toShadowStyles(shadow, aliases) : null);
        Result.Success success = new Result.Success(Unit.INSTANCE);
        Result.Success success2 = new Result.Success(Unit.INSTANCE);
        Result.Success success3 = new Result.Success(Unit.INSTANCE);
        NonEmptyList nonEmptyListOrNull = NonEmptyListKt.toNonEmptyListOrNull(ResultKt.collectErrors(CollectionsKt.listOf((Object[]) new Result[]{colorStyles, resultOrSuccessfullyNull, resultOrSuccessfullyNull2, success, success2, success3})));
        if (nonEmptyListOrNull != null) {
            return new Result.Error(nonEmptyListOrNull);
        }
        Intrinsics.checkNotNull(colorStyles, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<A of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value = ((Result.Success) colorStyles).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<B of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value2 = ((Result.Success) resultOrSuccessfullyNull).getValue();
        Intrinsics.checkNotNull(resultOrSuccessfullyNull2, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.helpers.Result.Success<C of com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.zipOrAccumulate>");
        Object value3 = ((Result.Success) resultOrSuccessfullyNull2).getValue();
        Object value4 = success.getValue();
        Object value5 = success2.getValue();
        return new Result.Success(new IconComponentStyle.Background((ColorStyles) value, iconBackground.getShape(), (BorderStyles) value2, (ShadowStyles) value3));
    }
}
