package com.studiolaganne.lengendarylens;

import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.font.FontFamilyKt;
import androidx.compose.ui.text.font.FontKt;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: CardRecommendationsPagerActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$CardRecommendationsPagerActivityKt {
    public static final ComposableSingletons$CardRecommendationsPagerActivityKt INSTANCE = new ComposableSingletons$CardRecommendationsPagerActivityKt();
    private static Function2<Composer, Integer, Unit> lambda$747684541 = ComposableLambdaKt.composableLambdaInstance(747684541, false, new Function2() { // from class: com.studiolaganne.lengendarylens.ComposableSingletons$CardRecommendationsPagerActivityKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$CardRecommendationsPagerActivityKt.lambda_747684541$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    static final Unit lambda_747684541$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C427@17941L206:CardRecommendationsPagerActivity.kt#r9tj48");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(747684541, i, -1, "com.studiolaganne.lengendarylens.ComposableSingletons$CardRecommendationsPagerActivityKt.lambda$747684541.<anonymous> (CardRecommendationsPagerActivity.kt:427)");
            }
            TextKt.m4288TextNvy7gAk("\uf00d", null, Color.INSTANCE.m6362getWhite0d7_KjU(), null, TextUnitKt.getSp(18), null, null, FontFamilyKt.FontFamily(FontKt.m8649FontYpTlLL0$default(R.font.fa6solid, null, 0, 0, 14, null)), 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 24966, 0, 261994);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public final Function2<Composer, Integer, Unit> getLambda$747684541$app_release() {
        return lambda$747684541;
    }
}
