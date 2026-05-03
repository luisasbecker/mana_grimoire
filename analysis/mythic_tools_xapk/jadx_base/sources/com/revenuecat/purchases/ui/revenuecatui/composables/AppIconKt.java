package com.revenuecat.purchases.ui.revenuecatui.composables;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.compose.foundation.ImageKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.graphics.drawable.DrawableKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppIcon.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"AppIcon", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AppIconKt {
    public static final void AppIcon(Modifier modifier, Composer composer, final int i, final int i2) {
        final Modifier modifier2;
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-960707246);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AppIcon)15@512L7,17@544L125,21@702L208:AppIcon.kt#51odh9");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i3 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier2 = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-960707246, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.AppIcon (AppIcon.kt:14)");
            }
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Context context = (Context) objConsume;
            composerStartRestartGroup.startReplaceGroup(831081126);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):AppIcon.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = context.getApplicationInfo().loadIcon(context.getPackageManager());
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Drawable appIconResId = (Drawable) objRememberedValue;
            composerStartRestartGroup.endReplaceGroup();
            Intrinsics.checkNotNullExpressionValue(appIconResId, "appIconResId");
            ImageKt.m1540Image5hnEew(AndroidImageBitmap_androidKt.asImageBitmap(DrawableKt.toBitmap$default(appIconResId, 0, 0, Bitmap.Config.ARGB_8888, 3, null)), null, modifier2, null, ContentScale.INSTANCE.getCrop(), 0.0f, null, 0, composerStartRestartGroup, ((i3 << 6) & 896) | 24624, 232);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.AppIconKt.AppIcon.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i5) {
                    AppIconKt.AppIcon(modifier2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }
}
