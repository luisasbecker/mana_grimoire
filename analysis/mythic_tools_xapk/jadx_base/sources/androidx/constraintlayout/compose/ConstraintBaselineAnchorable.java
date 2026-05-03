package androidx.constraintlayout.compose;

import androidx.constraintlayout.compose.ConstraintLayoutBaseScope;
import androidx.constraintlayout.core.parser.CLArray;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLString;
import kotlin.Metadata;

/* JADX INFO: compiled from: ConstrainScope.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J*\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ*\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0010"}, d2 = {"Landroidx/constraintlayout/compose/ConstraintBaselineAnchorable;", "Landroidx/constraintlayout/compose/BaselineAnchorable;", "containerObject", "Landroidx/constraintlayout/core/parser/CLObject;", "(Landroidx/constraintlayout/core/parser/CLObject;)V", "linkTo", "", "anchor", "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$BaselineAnchor;", "margin", "Landroidx/compose/ui/unit/Dp;", "goneMargin", "linkTo-VpY3zN4", "(Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$BaselineAnchor;FF)V", "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;", "(Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;FF)V", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ConstraintBaselineAnchorable implements BaselineAnchorable {
    private final CLObject containerObject;

    public ConstraintBaselineAnchorable(CLObject cLObject) {
        this.containerObject = cLObject;
    }

    @Override // androidx.constraintlayout.compose.BaselineAnchorable
    /* JADX INFO: renamed from: linkTo-VpY3zN4 */
    public void mo9376linkToVpY3zN4(ConstraintLayoutBaseScope.BaselineAnchor anchor, float margin, float goneMargin) {
        CLArray cLArray = new CLArray(new char[0]);
        cLArray.add(CLString.from(anchor.getId$constraintlayout_compose_release().toString()));
        cLArray.add(CLString.from("baseline"));
        cLArray.add(new CLNumber(margin));
        cLArray.add(new CLNumber(goneMargin));
        this.containerObject.put("baseline", cLArray);
    }

    @Override // androidx.constraintlayout.compose.BaselineAnchorable
    /* JADX INFO: renamed from: linkTo-VpY3zN4 */
    public void mo9377linkToVpY3zN4(ConstraintLayoutBaseScope.HorizontalAnchor anchor, float margin, float goneMargin) {
        String strHorizontalAnchorIndexToAnchorName = AnchorFunctions.INSTANCE.horizontalAnchorIndexToAnchorName(anchor.getIndex$constraintlayout_compose_release());
        CLArray cLArray = new CLArray(new char[0]);
        cLArray.add(CLString.from(anchor.getId$constraintlayout_compose_release().toString()));
        cLArray.add(CLString.from(strHorizontalAnchorIndexToAnchorName));
        cLArray.add(new CLNumber(margin));
        cLArray.add(new CLNumber(goneMargin));
        this.containerObject.put("baseline", cLArray);
    }
}
