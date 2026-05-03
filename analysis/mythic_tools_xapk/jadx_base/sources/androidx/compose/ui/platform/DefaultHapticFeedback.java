package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.core.view.ViewCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;

/* JADX INFO: compiled from: HapticFeedback.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/compose/ui/platform/DefaultHapticFeedback;", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "performHapticFeedback", "", "hapticFeedbackType", "Landroidx/compose/ui/hapticfeedback/HapticFeedbackType;", "performHapticFeedback-CdsT49E", "(I)V", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultHapticFeedback implements HapticFeedback {
    public static final int $stable = 8;
    private final View view;

    public DefaultHapticFeedback(View view) {
        this.view = view;
    }

    @Override // androidx.compose.ui.hapticfeedback.HapticFeedback
    /* JADX INFO: renamed from: performHapticFeedback-CdsT49E */
    public void mo7094performHapticFeedbackCdsT49E(int hapticFeedbackType) {
        ViewCompat.performHapticFeedback(this.view, HapticFeedbackType.m7098equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m7102getConfirm5zf0vsI()) ? 16 : HapticFeedbackType.m7098equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m7103getContextClick5zf0vsI()) ? 6 : HapticFeedbackType.m7098equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m7104getGestureEnd5zf0vsI()) ? 13 : HapticFeedbackType.m7098equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m7105getGestureThresholdActivate5zf0vsI()) ? 23 : HapticFeedbackType.m7098equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m7106getKeyboardTap5zf0vsI()) ? 3 : HapticFeedbackType.m7098equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m7107getLongPress5zf0vsI()) ? 0 : HapticFeedbackType.m7098equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m7108getReject5zf0vsI()) ? 17 : HapticFeedbackType.m7098equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m7109getSegmentFrequentTick5zf0vsI()) ? 27 : HapticFeedbackType.m7098equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m7110getSegmentTick5zf0vsI()) ? 26 : HapticFeedbackType.m7098equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m7111getTextHandleMove5zf0vsI()) ? 9 : HapticFeedbackType.m7098equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m7112getToggleOff5zf0vsI()) ? 22 : HapticFeedbackType.m7098equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m7113getToggleOn5zf0vsI()) ? 21 : HapticFeedbackType.m7098equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m7114getVirtualKey5zf0vsI()) ? 1 : -1);
    }
}
