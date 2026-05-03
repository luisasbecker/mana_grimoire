package androidx.compose.material3.adaptive;

import androidx.window.core.layout.WindowSizeClass;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WindowAdaptiveInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Landroidx/compose/material3/adaptive/WindowAdaptiveInfo;", "", "windowSizeClass", "Landroidx/window/core/layout/WindowSizeClass;", "windowPosture", "Landroidx/compose/material3/adaptive/Posture;", "<init>", "(Landroidx/window/core/layout/WindowSizeClass;Landroidx/compose/material3/adaptive/Posture;)V", "getWindowSizeClass", "()Landroidx/window/core/layout/WindowSizeClass;", "getWindowPosture", "()Landroidx/compose/material3/adaptive/Posture;", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "adaptive"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WindowAdaptiveInfo {
    public static final int $stable = 0;
    private final Posture windowPosture;
    private final WindowSizeClass windowSizeClass;

    public WindowAdaptiveInfo(WindowSizeClass windowSizeClass, Posture posture) {
        this.windowSizeClass = windowSizeClass;
        this.windowPosture = posture;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WindowAdaptiveInfo)) {
            return false;
        }
        WindowAdaptiveInfo windowAdaptiveInfo = (WindowAdaptiveInfo) other;
        return Intrinsics.areEqual(this.windowSizeClass, windowAdaptiveInfo.windowSizeClass) && Intrinsics.areEqual(this.windowPosture, windowAdaptiveInfo.windowPosture);
    }

    public final Posture getWindowPosture() {
        return this.windowPosture;
    }

    public final WindowSizeClass getWindowSizeClass() {
        return this.windowSizeClass;
    }

    public int hashCode() {
        return (this.windowSizeClass.hashCode() * 31) + this.windowPosture.hashCode();
    }

    public String toString() {
        return "WindowAdaptiveInfo(windowSizeClass=" + this.windowSizeClass + ", windowPosture=" + this.windowPosture + ')';
    }
}
