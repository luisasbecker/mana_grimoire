package com.revenuecat.purchases.ui.revenuecatui.components.properties;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Result;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ShadowStyle.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a2\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006*\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0000¨\u0006\u000e"}, d2 = {"rememberShadowStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyle;", "shadow", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;Landroidx/compose/runtime/Composer;I)Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyle;", "toShadowStyles", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/Result;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyList;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError;", "Lcom/revenuecat/purchases/paywalls/components/properties/Shadow;", "aliases", "", "Lcom/revenuecat/purchases/ColorAlias;", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ShadowStyleKt {
    public static final /* synthetic */ ShadowStyle rememberShadowStyle(ShadowStyles shadow, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(shadow, "shadow");
        composer.startReplaceGroup(1695935038);
        ComposerKt.sourceInformation(composer, "C(rememberShadowStyle)56@1805L15,57@1832L179:ShadowStyle.kt#nqkcqm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1695935038, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.properties.rememberShadowStyle (ShadowStyle.kt:55)");
        }
        ColorStyle forCurrentTheme = ColorStyleKt.getForCurrentTheme(shadow.getColors(), composer, 0);
        composer.startReplaceGroup(-634727445);
        ComposerKt.sourceInformation(composer, "CC(remember):ShadowStyle.kt#9igjgp");
        boolean zChanged = composer.changed(forCurrentTheme);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            Object shadowStyle = new ShadowStyle(forCurrentTheme, shadow.m10558getRadiusD9Ej5fM(), shadow.m10559getXD9Ej5fM(), shadow.m10560getYD9Ej5fM(), null);
            composer.updateRememberedValue(shadowStyle);
            objRememberedValue = shadowStyle;
        }
        ShadowStyle shadowStyle2 = (ShadowStyle) objRememberedValue;
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return shadowStyle2;
    }

    public static final /* synthetic */ Result toShadowStyles(Shadow shadow, Map aliases) {
        Intrinsics.checkNotNullParameter(shadow, "<this>");
        Intrinsics.checkNotNullParameter(aliases, "aliases");
        Result colorStyles = ColorStyleKt.toColorStyles(shadow.getColor(), aliases);
        if (colorStyles instanceof Result.Success) {
            return new Result.Success(new ShadowStyles((ColorStyles) ((Result.Success) colorStyles).getValue(), Dp.m9114constructorimpl((float) shadow.getRadius()), Dp.m9114constructorimpl((float) shadow.getX()), Dp.m9114constructorimpl((float) shadow.getY()), null));
        }
        if (colorStyles instanceof Result.Error) {
            return colorStyles;
        }
        throw new NoWhenBranchMatchedException();
    }
}
