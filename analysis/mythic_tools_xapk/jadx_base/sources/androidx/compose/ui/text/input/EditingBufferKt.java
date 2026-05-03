package androidx.compose.ui.text.input;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;

/* JADX INFO: compiled from: EditingBuffer.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"updateRangeAfterDelete", "Landroidx/compose/ui/text/TextRange;", TypedValues.AttributesType.S_TARGET, "deleted", "updateRangeAfterDelete-pWDy79M", "(JJ)J", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class EditingBufferKt {
    /* JADX INFO: renamed from: updateRangeAfterDelete-pWDy79M, reason: not valid java name */
    public static final long m8726updateRangeAfterDeletepWDy79M(long j, long j2) {
        int iM8552getLengthimpl;
        int iM8554getMinimpl = TextRange.m8554getMinimpl(j);
        int iM8553getMaximpl = TextRange.m8553getMaximpl(j);
        if (TextRange.m8558intersects5zctL8(j2, j)) {
            if (TextRange.m8546contains5zctL8(j2, j)) {
                iM8554getMinimpl = TextRange.m8554getMinimpl(j2);
                iM8553getMaximpl = iM8554getMinimpl;
            } else {
                if (TextRange.m8546contains5zctL8(j, j2)) {
                    iM8552getLengthimpl = TextRange.m8552getLengthimpl(j2);
                } else if (TextRange.m8547containsimpl(j2, iM8554getMinimpl)) {
                    iM8554getMinimpl = TextRange.m8554getMinimpl(j2);
                    iM8552getLengthimpl = TextRange.m8552getLengthimpl(j2);
                } else {
                    iM8553getMaximpl = TextRange.m8554getMinimpl(j2);
                }
                iM8553getMaximpl -= iM8552getLengthimpl;
            }
        } else if (iM8553getMaximpl > TextRange.m8554getMinimpl(j2)) {
            iM8554getMinimpl -= TextRange.m8552getLengthimpl(j2);
            iM8552getLengthimpl = TextRange.m8552getLengthimpl(j2);
            iM8553getMaximpl -= iM8552getLengthimpl;
        }
        return TextRangeKt.TextRange(iM8554getMinimpl, iM8553getMaximpl);
    }
}
