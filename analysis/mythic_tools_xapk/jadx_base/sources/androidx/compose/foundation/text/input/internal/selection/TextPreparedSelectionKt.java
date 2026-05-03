package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.text.input.internal.IndexTransformationType;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.input.internal.WedgeAffinity;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: TextPreparedSelection.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"calculateNextCursorPositionAndWedgeAffinity", "Landroidx/compose/foundation/text/input/internal/selection/CursorAndWedgeAffinity;", "proposedCursor", "", "cursor", "transformedTextFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "(IILandroidx/compose/foundation/text/input/internal/TransformedTextFieldState;)J", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextPreparedSelectionKt {

    /* JADX INFO: compiled from: TextPreparedSelection.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IndexTransformationType.values().length];
            try {
                iArr[IndexTransformationType.Untransformed.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IndexTransformationType.Deletion.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IndexTransformationType.Replacement.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[IndexTransformationType.Insertion.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final long calculateNextCursorPositionAndWedgeAffinity(int i, int i2, TransformedTextFieldState transformedTextFieldState) {
        if (i == -1) {
            return CursorAndWedgeAffinity.m2695constructorimpl(i2);
        }
        boolean z = i > i2;
        long jM2680mapFromTransformedjx7JFs = transformedTextFieldState.m2680mapFromTransformedjx7JFs(i);
        long jM2683mapToTransformedGEjPoXI = transformedTextFieldState.m2683mapToTransformedGEjPoXI(jM2680mapFromTransformedjx7JFs);
        int i3 = WhenMappings.$EnumSwitchMapping$0[((TextRange.m8550getCollapsedimpl(jM2680mapFromTransformedjx7JFs) && TextRange.m8550getCollapsedimpl(jM2683mapToTransformedGEjPoXI)) ? IndexTransformationType.Untransformed : (TextRange.m8550getCollapsedimpl(jM2680mapFromTransformedjx7JFs) || TextRange.m8550getCollapsedimpl(jM2683mapToTransformedGEjPoXI)) ? (!TextRange.m8550getCollapsedimpl(jM2680mapFromTransformedjx7JFs) || TextRange.m8550getCollapsedimpl(jM2683mapToTransformedGEjPoXI)) ? IndexTransformationType.Deletion : IndexTransformationType.Insertion : IndexTransformationType.Replacement).ordinal()];
        if (i3 == 1) {
            return CursorAndWedgeAffinity.m2696constructorimpl(i, z ? WedgeAffinity.Start : WedgeAffinity.End);
        }
        if (i3 == 2) {
            return CursorAndWedgeAffinity.m2695constructorimpl(i);
        }
        if (i3 == 3) {
            return z ? CursorAndWedgeAffinity.m2696constructorimpl(TextRange.m8551getEndimpl(jM2683mapToTransformedGEjPoXI), WedgeAffinity.Start) : CursorAndWedgeAffinity.m2696constructorimpl(TextRange.m8556getStartimpl(jM2683mapToTransformedGEjPoXI), WedgeAffinity.End);
        }
        if (i3 == 4) {
            return z ? i == TextRange.m8556getStartimpl(jM2683mapToTransformedGEjPoXI) ? CursorAndWedgeAffinity.m2696constructorimpl(i, WedgeAffinity.Start) : CursorAndWedgeAffinity.m2696constructorimpl(TextRange.m8551getEndimpl(jM2683mapToTransformedGEjPoXI), WedgeAffinity.End) : i == TextRange.m8551getEndimpl(jM2683mapToTransformedGEjPoXI) ? CursorAndWedgeAffinity.m2696constructorimpl(i, WedgeAffinity.End) : CursorAndWedgeAffinity.m2696constructorimpl(TextRange.m8556getStartimpl(jM2683mapToTransformedGEjPoXI), WedgeAffinity.Start);
        }
        throw new NoWhenBranchMatchedException();
    }
}
