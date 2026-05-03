package androidx.compose.material3.adaptive;

import androidx.compose.ui.unit.Dp;
import androidx.webkit.Profile;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;

/* JADX INFO: compiled from: WindowSizeClassHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\"\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u0017"}, d2 = {"Landroidx/compose/material3/adaptive/DpWidthSizeClasses;", "", "<init>", "()V", "Compact", "Landroidx/compose/ui/unit/Dp;", "getCompact-D9Ej5fM", "()F", "F", "Medium", "getMedium-D9Ej5fM", "Expanded", "getExpanded-D9Ej5fM", "Large", "getLarge-D9Ej5fM", "ExtraLarge", "getExtraLarge-D9Ej5fM", Profile.DEFAULT_PROFILE_NAME, "", "getDefault", "()Ljava/util/Set;", "DefaultV2", "getDefaultV2", "adaptive"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DpWidthSizeClasses {
    private static final float Compact;
    private static final Set<Dp> Default;
    private static final Set<Dp> DefaultV2;
    private static final float Expanded;
    private static final float ExtraLarge;
    public static final DpWidthSizeClasses INSTANCE = new DpWidthSizeClasses();
    private static final float Large;
    private static final float Medium;

    static {
        float fM9114constructorimpl = Dp.m9114constructorimpl(0.0f);
        Compact = fM9114constructorimpl;
        float fM9114constructorimpl2 = Dp.m9114constructorimpl(600.0f);
        Medium = fM9114constructorimpl2;
        float fM9114constructorimpl3 = Dp.m9114constructorimpl(840.0f);
        Expanded = fM9114constructorimpl3;
        float fM9114constructorimpl4 = Dp.m9114constructorimpl(1200.0f);
        Large = fM9114constructorimpl4;
        float fM9114constructorimpl5 = Dp.m9114constructorimpl(1600.0f);
        ExtraLarge = fM9114constructorimpl5;
        Default = SetsKt.setOf((Object[]) new Dp[]{Dp.m9112boximpl(fM9114constructorimpl), Dp.m9112boximpl(fM9114constructorimpl2), Dp.m9112boximpl(fM9114constructorimpl3)});
        DefaultV2 = SetsKt.setOf((Object[]) new Dp[]{Dp.m9112boximpl(fM9114constructorimpl), Dp.m9112boximpl(fM9114constructorimpl2), Dp.m9112boximpl(fM9114constructorimpl3), Dp.m9112boximpl(fM9114constructorimpl4), Dp.m9112boximpl(fM9114constructorimpl5)});
    }

    private DpWidthSizeClasses() {
    }

    /* JADX INFO: renamed from: getCompact-D9Ej5fM, reason: not valid java name */
    public final float m4536getCompactD9Ej5fM() {
        return Compact;
    }

    public final Set<Dp> getDefault() {
        return Default;
    }

    public final Set<Dp> getDefaultV2() {
        return DefaultV2;
    }

    /* JADX INFO: renamed from: getExpanded-D9Ej5fM, reason: not valid java name */
    public final float m4537getExpandedD9Ej5fM() {
        return Expanded;
    }

    /* JADX INFO: renamed from: getExtraLarge-D9Ej5fM, reason: not valid java name */
    public final float m4538getExtraLargeD9Ej5fM() {
        return ExtraLarge;
    }

    /* JADX INFO: renamed from: getLarge-D9Ej5fM, reason: not valid java name */
    public final float m4539getLargeD9Ej5fM() {
        return Large;
    }

    /* JADX INFO: renamed from: getMedium-D9Ej5fM, reason: not valid java name */
    public final float m4540getMediumD9Ej5fM() {
        return Medium;
    }
}
