package androidx.constraintlayout.compose;

import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.compose.ConstraintLayoutBaseScope;
import kotlin.Metadata;

/* JADX INFO: compiled from: ConstraintScopeCommon.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H&ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ.\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000b2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H&ø\u0001\u0000¢\u0006\u0004\b\t\u0010\fø\u0001\u0001\u0082\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0003"}, d2 = {"Landroidx/constraintlayout/compose/HorizontalAnchorable;", "", "linkTo", "", "anchor", "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$BaselineAnchor;", "margin", "Landroidx/compose/ui/unit/Dp;", "goneMargin", "linkTo-VpY3zN4", "(Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$BaselineAnchor;FF)V", "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;", "(Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;FF)V", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface HorizontalAnchorable {

    /* JADX INFO: compiled from: ConstraintScopeCommon.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    /* JADX INFO: renamed from: linkTo-VpY3zN4$default, reason: not valid java name */
    static /* synthetic */ void m9488linkToVpY3zN4$default(HorizontalAnchorable horizontalAnchorable, ConstraintLayoutBaseScope.BaselineAnchor baselineAnchor, float f, float f2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: linkTo-VpY3zN4");
        }
        if ((i & 2) != 0) {
            f = Dp.m9114constructorimpl(0.0f);
        }
        if ((i & 4) != 0) {
            f2 = Dp.m9114constructorimpl(0.0f);
        }
        horizontalAnchorable.mo9371linkToVpY3zN4(baselineAnchor, f, f2);
    }

    /* JADX INFO: renamed from: linkTo-VpY3zN4$default, reason: not valid java name */
    static /* synthetic */ void m9489linkToVpY3zN4$default(HorizontalAnchorable horizontalAnchorable, ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor, float f, float f2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: linkTo-VpY3zN4");
        }
        if ((i & 2) != 0) {
            f = Dp.m9114constructorimpl(0.0f);
        }
        if ((i & 4) != 0) {
            f2 = Dp.m9114constructorimpl(0.0f);
        }
        horizontalAnchorable.mo9372linkToVpY3zN4(horizontalAnchor, f, f2);
    }

    /* JADX INFO: renamed from: linkTo-VpY3zN4 */
    void mo9371linkToVpY3zN4(ConstraintLayoutBaseScope.BaselineAnchor anchor, float margin, float goneMargin);

    /* JADX INFO: renamed from: linkTo-VpY3zN4 */
    void mo9372linkToVpY3zN4(ConstraintLayoutBaseScope.HorizontalAnchor anchor, float margin, float goneMargin);
}
