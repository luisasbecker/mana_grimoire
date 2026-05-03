package com.tbuonomo.viewpagerdotsindicator.compose;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import com.tbuonomo.viewpagerdotsindicator.compose.model.DotGraphic;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Dot.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Dot", "", "graphic", "Lcom/tbuonomo/viewpagerdotsindicator/compose/model/DotGraphic;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/tbuonomo/viewpagerdotsindicator/compose/model/DotGraphic;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "viewpagerdotsindicator_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class DotKt {
    public static final void Dot(final DotGraphic graphic, final Modifier modifier, Composer composer, final int i) {
        int i2;
        Modifier modifierM1494borderxT4_qwU;
        Intrinsics.checkNotNullParameter(graphic, "graphic");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer composerStartRestartGroup = composer.startRestartGroup(1695287159);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(graphic) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i2 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1695287159, i2, -1, "com.tbuonomo.viewpagerdotsindicator.compose.Dot (Dot.kt:14)");
            }
            Modifier modifierM2083size3ABfNKs = SizeKt.m2083size3ABfNKs(BackgroundKt.m1482backgroundbw27NRU(modifier, graphic.m11293getColor0d7_KjU(), graphic.getShape()), graphic.m11294getSizeD9Ej5fM());
            Dp dpM11292getBorderWidthlTKBWiU = graphic.m11292getBorderWidthlTKBWiU();
            if (dpM11292getBorderWidthlTKBWiU != null && (modifierM1494borderxT4_qwU = BorderKt.m1494borderxT4_qwU(modifierM2083size3ABfNKs, dpM11292getBorderWidthlTKBWiU.m9128unboximpl(), graphic.m11291getBorderColor0d7_KjU(), graphic.getShape())) != null) {
                modifierM2083size3ABfNKs = modifierM1494borderxT4_qwU;
            }
            BoxKt.Box(modifierM2083size3ABfNKs, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tbuonomo.viewpagerdotsindicator.compose.DotKt.Dot.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    DotKt.Dot(graphic, modifier, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
