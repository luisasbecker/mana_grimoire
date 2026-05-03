package com.studiolaganne.lengendarylens;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CirclesListAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/studiolaganne/lengendarylens/CirclesListViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "rootLayout", "Landroid/widget/LinearLayout;", "getRootLayout", "()Landroid/widget/LinearLayout;", "circleName", "Landroid/widget/TextView;", "getCircleName", "()Landroid/widget/TextView;", "circleDescription", "getCircleDescription", "autoBadge", "getAutoBadge", "dotsLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getDotsLayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CirclesListViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    private final TextView autoBadge;
    private final TextView circleDescription;
    private final TextView circleName;
    private final ConstraintLayout dotsLayout;
    private final LinearLayout rootLayout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CirclesListViewHolder(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View viewFindViewById = itemView.findViewById(R.id.root_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.rootLayout = (LinearLayout) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R.id.circleName);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.circleName = (TextView) viewFindViewById2;
        View viewFindViewById3 = itemView.findViewById(R.id.circleDescription);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.circleDescription = (TextView) viewFindViewById3;
        View viewFindViewById4 = itemView.findViewById(R.id.autoBadge);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.autoBadge = (TextView) viewFindViewById4;
        View viewFindViewById5 = itemView.findViewById(R.id.dotsLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.dotsLayout = (ConstraintLayout) viewFindViewById5;
    }

    public final TextView getAutoBadge() {
        return this.autoBadge;
    }

    public final TextView getCircleDescription() {
        return this.circleDescription;
    }

    public final TextView getCircleName() {
        return this.circleName;
    }

    public final ConstraintLayout getDotsLayout() {
        return this.dotsLayout;
    }

    public final LinearLayout getRootLayout() {
        return this.rootLayout;
    }
}
