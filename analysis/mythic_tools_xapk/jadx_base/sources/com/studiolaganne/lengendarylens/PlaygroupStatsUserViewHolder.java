package com.studiolaganne.lengendarylens;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlaygroupStatsUsersAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b \b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0011\u0010 \u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\tR\u001a\u0010\"\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001d\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001d\"\u0004\b(\u0010%R\u001a\u0010)\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010%R\u001a\u0010,\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001d\"\u0004\b.\u0010%R\u001a\u0010/\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001d\"\u0004\b1\u0010%R\u001a\u00102\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001d\"\u0004\b4\u0010%R\u001a\u00105\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001d\"\u0004\b7\u0010%R\u001a\u00108\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001d\"\u0004\b:\u0010%¨\u0006;"}, d2 = {"Lcom/studiolaganne/lengendarylens/PlaygroupStatsUserViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "rootLayout", "Landroid/widget/LinearLayout;", "getRootLayout", "()Landroid/widget/LinearLayout;", "setRootLayout", "(Landroid/widget/LinearLayout;)V", "profileLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getProfileLayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setProfileLayout", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "profileIcon", "Lcom/studiolaganne/lengendarylens/CachedImageView;", "getProfileIcon", "()Lcom/studiolaganne/lengendarylens/CachedImageView;", "noPhotoIcon", "Landroid/widget/ImageView;", "getNoPhotoIcon", "()Landroid/widget/ImageView;", "userFirstName", "Landroid/widget/TextView;", "getUserFirstName", "()Landroid/widget/TextView;", "userName", "getUserName", "statsLayout", "getStatsLayout", "winRateValueLabel", "getWinRateValueLabel", "setWinRateValueLabel", "(Landroid/widget/TextView;)V", "gamesValueLabel", "getGamesValueLabel", "setGamesValueLabel", "gamesLabel", "getGamesLabel", "setGamesLabel", "winsValueLabel", "getWinsValueLabel", "setWinsValueLabel", "winsLabel", "getWinsLabel", "setWinsLabel", "lossesValueLabel", "getLossesValueLabel", "setLossesValueLabel", "lossesLabel", "getLossesLabel", "setLossesLabel", "drawsValueLabel", "getDrawsValueLabel", "setDrawsValueLabel", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PlaygroupStatsUserViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    private TextView drawsValueLabel;
    private TextView gamesLabel;
    private TextView gamesValueLabel;
    private TextView lossesLabel;
    private TextView lossesValueLabel;
    private final ImageView noPhotoIcon;
    private final CachedImageView profileIcon;
    private ConstraintLayout profileLayout;
    private LinearLayout rootLayout;
    private final LinearLayout statsLayout;
    private final TextView userFirstName;
    private final TextView userName;
    private TextView winRateValueLabel;
    private TextView winsLabel;
    private TextView winsValueLabel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlaygroupStatsUserViewHolder(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View viewFindViewById = itemView.findViewById(R.id.root_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.rootLayout = (LinearLayout) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R.id.profileLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.profileLayout = (ConstraintLayout) viewFindViewById2;
        View viewFindViewById3 = itemView.findViewById(R.id.profile_icon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.profileIcon = (CachedImageView) viewFindViewById3;
        View viewFindViewById4 = itemView.findViewById(R.id.no_photo_icon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.noPhotoIcon = (ImageView) viewFindViewById4;
        View viewFindViewById5 = itemView.findViewById(R.id.userFirstName);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.userFirstName = (TextView) viewFindViewById5;
        View viewFindViewById6 = itemView.findViewById(R.id.userName);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.userName = (TextView) viewFindViewById6;
        View viewFindViewById7 = itemView.findViewById(R.id.stats_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.statsLayout = (LinearLayout) viewFindViewById7;
        View viewFindViewById8 = itemView.findViewById(R.id.winRateValueLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.winRateValueLabel = (TextView) viewFindViewById8;
        View viewFindViewById9 = itemView.findViewById(R.id.gamesValueLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        this.gamesValueLabel = (TextView) viewFindViewById9;
        View viewFindViewById10 = itemView.findViewById(R.id.gamesLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        this.gamesLabel = (TextView) viewFindViewById10;
        View viewFindViewById11 = itemView.findViewById(R.id.winsValueLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        this.winsValueLabel = (TextView) viewFindViewById11;
        View viewFindViewById12 = itemView.findViewById(R.id.winsLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
        this.winsLabel = (TextView) viewFindViewById12;
        View viewFindViewById13 = itemView.findViewById(R.id.lossesValueLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(...)");
        this.lossesValueLabel = (TextView) viewFindViewById13;
        View viewFindViewById14 = itemView.findViewById(R.id.lossesLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById14, "findViewById(...)");
        this.lossesLabel = (TextView) viewFindViewById14;
        View viewFindViewById15 = itemView.findViewById(R.id.drawsValueLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById15, "findViewById(...)");
        this.drawsValueLabel = (TextView) viewFindViewById15;
    }

    public final TextView getDrawsValueLabel() {
        return this.drawsValueLabel;
    }

    public final TextView getGamesLabel() {
        return this.gamesLabel;
    }

    public final TextView getGamesValueLabel() {
        return this.gamesValueLabel;
    }

    public final TextView getLossesLabel() {
        return this.lossesLabel;
    }

    public final TextView getLossesValueLabel() {
        return this.lossesValueLabel;
    }

    public final ImageView getNoPhotoIcon() {
        return this.noPhotoIcon;
    }

    public final CachedImageView getProfileIcon() {
        return this.profileIcon;
    }

    public final ConstraintLayout getProfileLayout() {
        return this.profileLayout;
    }

    public final LinearLayout getRootLayout() {
        return this.rootLayout;
    }

    public final LinearLayout getStatsLayout() {
        return this.statsLayout;
    }

    public final TextView getUserFirstName() {
        return this.userFirstName;
    }

    public final TextView getUserName() {
        return this.userName;
    }

    public final TextView getWinRateValueLabel() {
        return this.winRateValueLabel;
    }

    public final TextView getWinsLabel() {
        return this.winsLabel;
    }

    public final TextView getWinsValueLabel() {
        return this.winsValueLabel;
    }

    public final void setDrawsValueLabel(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.drawsValueLabel = textView;
    }

    public final void setGamesLabel(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.gamesLabel = textView;
    }

    public final void setGamesValueLabel(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.gamesValueLabel = textView;
    }

    public final void setLossesLabel(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.lossesLabel = textView;
    }

    public final void setLossesValueLabel(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.lossesValueLabel = textView;
    }

    public final void setProfileLayout(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.profileLayout = constraintLayout;
    }

    public final void setRootLayout(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.rootLayout = linearLayout;
    }

    public final void setWinRateValueLabel(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.winRateValueLabel = textView;
    }

    public final void setWinsLabel(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.winsLabel = textView;
    }

    public final void setWinsValueLabel(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.winsValueLabel = textView;
    }
}
