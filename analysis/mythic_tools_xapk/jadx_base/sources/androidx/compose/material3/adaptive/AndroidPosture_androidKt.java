package androidx.compose.material3.adaptive;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.window.layout.FoldingFeature;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidPosture.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0001\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"calculatePosture", "Landroidx/compose/material3/adaptive/Posture;", "foldingFeatures", "", "Landroidx/window/layout/FoldingFeature;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/adaptive/Posture;", "adaptive"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidPosture_androidKt {
    public static final Posture calculatePosture(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 702079131, "C(calculatePosture)55@2028L31:AndroidPosture.android.kt#8avflz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(702079131, i, -1, "androidx.compose.material3.adaptive.calculatePosture (AndroidPosture.android.kt:55)");
        }
        Posture postureCalculatePosture = calculatePosture(AndroidWindowAdaptiveInfo_androidKt.collectFoldingFeaturesAsState(composer, 0).getValue());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return postureCalculatePosture;
    }

    public static final Posture calculatePosture(List<? extends FoldingFeature> list) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (FoldingFeature foldingFeature : list) {
            if (Intrinsics.areEqual(foldingFeature.getOrientation(), FoldingFeature.Orientation.HORIZONTAL) && Intrinsics.areEqual(foldingFeature.getState(), FoldingFeature.State.HALF_OPENED)) {
                z = true;
            }
            arrayList.add(new HingeInfo(RectHelper_androidKt.toComposeRect(foldingFeature.getBounds()), Intrinsics.areEqual(foldingFeature.getState(), FoldingFeature.State.FLAT), Intrinsics.areEqual(foldingFeature.getOrientation(), FoldingFeature.Orientation.VERTICAL), foldingFeature.isSeparating(), Intrinsics.areEqual(foldingFeature.getOcclusionType(), FoldingFeature.OcclusionType.FULL)));
        }
        return new Posture(z, arrayList);
    }
}
