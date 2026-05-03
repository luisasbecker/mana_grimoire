package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import androidx.compose.ui.geometry.Offset;
import androidx.media3.muxer.MuxerUtil;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;

/* JADX INFO: compiled from: MotionEventAdapter.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/compose/ui/input/pointer/MotionEventHelper;", "", "<init>", "()V", "toRawOffset", "Landroidx/compose/ui/geometry/Offset;", "motionEvent", "Landroid/view/MotionEvent;", FirebaseAnalytics.Param.INDEX, "", "toRawOffset-dBAh8RU", "(Landroid/view/MotionEvent;I)J", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class MotionEventHelper {
    public static final MotionEventHelper INSTANCE = new MotionEventHelper();

    private MotionEventHelper() {
    }

    /* JADX INFO: renamed from: toRawOffset-dBAh8RU, reason: not valid java name */
    public final long m7569toRawOffsetdBAh8RU(MotionEvent motionEvent, int index) {
        float rawX = motionEvent.getRawX(index);
        return Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(motionEvent.getRawY(index))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(rawX) << 32));
    }
}
