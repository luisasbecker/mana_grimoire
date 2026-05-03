package com.studiolaganne.lengendarylens;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GameEventsAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R\u001a\u0010$\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017R\u001a\u0010'\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0011\u0010-\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\tR\u0011\u0010/\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\tR\u0011\u00101\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0015R\u0011\u00103\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0015R\u0011\u00105\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u00108\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u00107R\u0011\u0010:\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\t¨\u0006<"}, d2 = {"Lcom/studiolaganne/lengendarylens/GameEventViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "rootLayout", "Landroid/widget/LinearLayout;", "getRootLayout", "()Landroid/widget/LinearLayout;", "setRootLayout", "(Landroid/widget/LinearLayout;)V", "usersRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getUsersRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setUsersRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "line1TextView", "Landroid/widget/TextView;", "getLine1TextView", "()Landroid/widget/TextView;", "setLine1TextView", "(Landroid/widget/TextView;)V", "line2TextView", "getLine2TextView", "setLine2TextView", "typeIcon", "Landroid/widget/ImageView;", "getTypeIcon", "()Landroid/widget/ImageView;", "setTypeIcon", "(Landroid/widget/ImageView;)V", "valueLabel", "getValueLabel", "setValueLabel", "timeLabel", "getTimeLabel", "setTimeLabel", "dotsLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getDotsLayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setDotsLayout", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "separatorLayout", "getSeparatorLayout", "mainEventLayout", "getMainEventLayout", "separatorTextStart", "getSeparatorTextStart", "separatorTextEnd", "getSeparatorTextEnd", "separatorLine", "getSeparatorLine", "()Landroid/view/View;", "separatorSpacer", "getSeparatorSpacer", "mainLayout", "getMainLayout", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GameEventViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    private ConstraintLayout dotsLayout;
    private TextView line1TextView;
    private TextView line2TextView;
    private final LinearLayout mainEventLayout;
    private final LinearLayout mainLayout;
    private LinearLayout rootLayout;
    private final LinearLayout separatorLayout;
    private final View separatorLine;
    private final View separatorSpacer;
    private final TextView separatorTextEnd;
    private final TextView separatorTextStart;
    private TextView timeLabel;
    private ImageView typeIcon;
    private RecyclerView usersRecyclerView;
    private TextView valueLabel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameEventViewHolder(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View viewFindViewById = itemView.findViewById(R.id.root_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.rootLayout = (LinearLayout) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R.id.usersRecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.usersRecyclerView = (RecyclerView) viewFindViewById2;
        View viewFindViewById3 = itemView.findViewById(R.id.line1Text);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.line1TextView = (TextView) viewFindViewById3;
        View viewFindViewById4 = itemView.findViewById(R.id.line2Text);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.line2TextView = (TextView) viewFindViewById4;
        View viewFindViewById5 = itemView.findViewById(R.id.typeIcon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.typeIcon = (ImageView) viewFindViewById5;
        View viewFindViewById6 = itemView.findViewById(R.id.valueLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.valueLabel = (TextView) viewFindViewById6;
        View viewFindViewById7 = itemView.findViewById(R.id.timeLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.timeLabel = (TextView) viewFindViewById7;
        View viewFindViewById8 = itemView.findViewById(R.id.dotsLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.dotsLayout = (ConstraintLayout) viewFindViewById8;
        View viewFindViewById9 = itemView.findViewById(R.id.separator_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        this.separatorLayout = (LinearLayout) viewFindViewById9;
        View viewFindViewById10 = itemView.findViewById(R.id.main_event_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        this.mainEventLayout = (LinearLayout) viewFindViewById10;
        View viewFindViewById11 = itemView.findViewById(R.id.separatorTextStart);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        this.separatorTextStart = (TextView) viewFindViewById11;
        View viewFindViewById12 = itemView.findViewById(R.id.separatorTextEnd);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
        this.separatorTextEnd = (TextView) viewFindViewById12;
        View viewFindViewById13 = itemView.findViewById(R.id.separatorLine);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(...)");
        this.separatorLine = viewFindViewById13;
        View viewFindViewById14 = itemView.findViewById(R.id.separatorSpacer);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById14, "findViewById(...)");
        this.separatorSpacer = viewFindViewById14;
        View viewFindViewById15 = itemView.findViewById(R.id.main_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById15, "findViewById(...)");
        this.mainLayout = (LinearLayout) viewFindViewById15;
    }

    public final ConstraintLayout getDotsLayout() {
        return this.dotsLayout;
    }

    public final TextView getLine1TextView() {
        return this.line1TextView;
    }

    public final TextView getLine2TextView() {
        return this.line2TextView;
    }

    public final LinearLayout getMainEventLayout() {
        return this.mainEventLayout;
    }

    public final LinearLayout getMainLayout() {
        return this.mainLayout;
    }

    public final LinearLayout getRootLayout() {
        return this.rootLayout;
    }

    public final LinearLayout getSeparatorLayout() {
        return this.separatorLayout;
    }

    public final View getSeparatorLine() {
        return this.separatorLine;
    }

    public final View getSeparatorSpacer() {
        return this.separatorSpacer;
    }

    public final TextView getSeparatorTextEnd() {
        return this.separatorTextEnd;
    }

    public final TextView getSeparatorTextStart() {
        return this.separatorTextStart;
    }

    public final TextView getTimeLabel() {
        return this.timeLabel;
    }

    public final ImageView getTypeIcon() {
        return this.typeIcon;
    }

    public final RecyclerView getUsersRecyclerView() {
        return this.usersRecyclerView;
    }

    public final TextView getValueLabel() {
        return this.valueLabel;
    }

    public final void setDotsLayout(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.dotsLayout = constraintLayout;
    }

    public final void setLine1TextView(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.line1TextView = textView;
    }

    public final void setLine2TextView(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.line2TextView = textView;
    }

    public final void setRootLayout(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.rootLayout = linearLayout;
    }

    public final void setTimeLabel(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.timeLabel = textView;
    }

    public final void setTypeIcon(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.typeIcon = imageView;
    }

    public final void setUsersRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
        this.usersRecyclerView = recyclerView;
    }

    public final void setValueLabel(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.valueLabel = textView;
    }
}
