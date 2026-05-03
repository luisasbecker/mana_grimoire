package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import androidx.media3.muxer.MuxerUtil;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: SharedElement.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002\u001a\u0013\u0010\u0007\u001a\u00020\u0006*\u00020\bH\u0000¢\u0006\u0004\b\t\u0010\n\"\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"hasVisibleContent", "", "", "Landroidx/compose/animation/SharedElementEntry;", "DefaultMomentumSpring", "Landroidx/compose/animation/core/SpringSpec;", "Landroidx/compose/ui/geometry/Offset;", "toOffset", "Landroidx/compose/ui/unit/Velocity;", "toOffset-TH1AsA0", "(J)J", "animation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SharedElementKt {
    private static final SpringSpec<Offset> DefaultMomentumSpring = AnimationSpecKt.spring$default(0.0f, 400.0f, Offset.m6069boximpl(Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(3.0f)) << 32) | (((long) Float.floatToRawIntBits(3.0f)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE))), 1, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hasVisibleContent(List<SharedElementEntry> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i).getBoundsAnimation().getTarget()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: toOffset-TH1AsA0, reason: not valid java name */
    public static final long m1341toOffsetTH1AsA0(long j) {
        float fM9352getXimpl = Velocity.m9352getXimpl(j);
        return Offset.m6072constructorimpl((((long) Float.floatToRawIntBits(Velocity.m9353getYimpl(j))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE) | (Float.floatToRawIntBits(fM9352getXimpl) << 32));
    }
}
