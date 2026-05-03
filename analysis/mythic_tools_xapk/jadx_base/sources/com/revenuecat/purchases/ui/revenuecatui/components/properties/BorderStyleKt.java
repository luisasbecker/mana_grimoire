package com.revenuecat.purchases.ui.revenuecatui.components.properties;

import androidx.compose.material.OutlinedTextFieldKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Result;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BorderStyle.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a2\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006*\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0000¨\u0006\u000e"}, d2 = {"rememberBorderStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyle;", OutlinedTextFieldKt.BorderId, "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;Landroidx/compose/runtime/Composer;I)Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyle;", "toBorderStyles", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/Result;", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyList;", "Lcom/revenuecat/purchases/ui/revenuecatui/errors/PaywallValidationError;", "Lcom/revenuecat/purchases/paywalls/components/properties/Border;", "aliases", "", "Lcom/revenuecat/purchases/ColorAlias;", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BorderStyleKt {
    public static final /* synthetic */ BorderStyle rememberBorderStyle(BorderStyles border, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(border, "border");
        composer.startReplaceGroup(1521770814);
        ComposerKt.sourceInformation(composer, "C(rememberBorderStyle)50@1617L15,51@1644L125:BorderStyle.kt#nqkcqm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1521770814, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.properties.rememberBorderStyle (BorderStyle.kt:49)");
        }
        ColorStyle forCurrentTheme = ColorStyleKt.getForCurrentTheme(border.getColors(), composer, 0);
        composer.startReplaceGroup(1248885673);
        ComposerKt.sourceInformation(composer, "CC(remember):BorderStyle.kt#9igjgp");
        boolean zChanged = composer.changed(forCurrentTheme);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new BorderStyle(border.m10523getWidthD9Ej5fM(), forCurrentTheme, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        BorderStyle borderStyle = (BorderStyle) objRememberedValue;
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return borderStyle;
    }

    public static final /* synthetic */ Result toBorderStyles(Border border, Map aliases) {
        Intrinsics.checkNotNullParameter(border, "<this>");
        Intrinsics.checkNotNullParameter(aliases, "aliases");
        Result colorStyles = ColorStyleKt.toColorStyles(border.getColor(), aliases);
        if (colorStyles instanceof Result.Success) {
            return new Result.Success(new BorderStyles(Dp.m9114constructorimpl((float) border.getWidth()), (ColorStyles) ((Result.Success) colorStyles).getValue(), null));
        }
        if (colorStyles instanceof Result.Error) {
            return colorStyles;
        }
        throw new NoWhenBranchMatchedException();
    }
}
