package com.studiolaganne.lengendarylens;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GamesAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\rR\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u0011\u0010#\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010 R\u0011\u0010%\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010 R\u0011\u0010'\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010 R\u0011\u0010-\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\b.\u0010*R\u0011\u0010/\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b0\u0010 R\u0011\u00101\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\b2\u0010*R\u0011\u00103\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b4\u0010 R\u0011\u00105\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\b6\u0010*R\u0011\u00107\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b8\u0010 R\u0011\u00109\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u001aR\u0011\u0010;\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u001aR\u0011\u0010=\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u001aR\u0011\u0010?\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u001aR\u0011\u0010A\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\u001aR\u0011\u0010C\u001a\u00020D¢\u0006\b\n\u0000\u001a\u0004\bE\u0010F¨\u0006G"}, d2 = {"Lcom/studiolaganne/lengendarylens/GameViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "clickListener", "Lcom/studiolaganne/lengendarylens/GamesClickListener;", "<init>", "(Landroid/view/View;Lcom/studiolaganne/lengendarylens/GamesClickListener;)V", "getClickListener", "()Lcom/studiolaganne/lengendarylens/GamesClickListener;", "rootLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getRootLayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setRootLayout", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "profileLayout", "getProfileLayout", "setProfileLayout", "profileIcon", "Lcom/studiolaganne/lengendarylens/CachedImageView;", "getProfileIcon", "()Lcom/studiolaganne/lengendarylens/CachedImageView;", "noPhotoIcon", "Landroid/widget/ImageView;", "getNoPhotoIcon", "()Landroid/widget/ImageView;", "dotsLayout", "getDotsLayout", "victoryLabel", "Landroid/widget/TextView;", "getVictoryLabel", "()Landroid/widget/TextView;", "timeLabel", "getTimeLabel", "gameName", "getGameName", "playgroupName", "getPlaygroupName", "smallUsersRecyclerView1", "Landroidx/recyclerview/widget/RecyclerView;", "getSmallUsersRecyclerView1", "()Landroidx/recyclerview/widget/RecyclerView;", "interLabel1", "getInterLabel1", "smallUsersRecyclerView2", "getSmallUsersRecyclerView2", "interLabel2", "getInterLabel2", "smallUsersRecyclerView3", "getSmallUsersRecyclerView3", "winnerNamesLabel", "getWinnerNamesLabel", "winnersRecyclerView", "getWinnersRecyclerView", "winnersHeaderLabel", "getWinnersHeaderLabel", "leaderImage", "getLeaderImage", "guardianImage", "getGuardianImage", "assassinsImage", "getAssassinsImage", "traitorsImage", "getTraitorsImage", "noteImage", "getNoteImage", "tagsFlexboxLayout", "Lcom/google/android/flexbox/FlexboxLayout;", "getTagsFlexboxLayout", "()Lcom/google/android/flexbox/FlexboxLayout;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GameViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    private final ImageView assassinsImage;
    private final GamesClickListener clickListener;
    private final ConstraintLayout dotsLayout;
    private final TextView gameName;
    private final ImageView guardianImage;
    private final TextView interLabel1;
    private final TextView interLabel2;
    private final ImageView leaderImage;
    private final ImageView noPhotoIcon;
    private final ImageView noteImage;
    private final TextView playgroupName;
    private final CachedImageView profileIcon;
    private ConstraintLayout profileLayout;
    private ConstraintLayout rootLayout;
    private final RecyclerView smallUsersRecyclerView1;
    private final RecyclerView smallUsersRecyclerView2;
    private final RecyclerView smallUsersRecyclerView3;
    private final FlexboxLayout tagsFlexboxLayout;
    private final TextView timeLabel;
    private final ImageView traitorsImage;
    private final TextView victoryLabel;
    private final TextView winnerNamesLabel;
    private final TextView winnersHeaderLabel;
    private final RecyclerView winnersRecyclerView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameViewHolder(View itemView, GamesClickListener clickListener) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.clickListener = clickListener;
        View viewFindViewById = itemView.findViewById(R.id.root_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.rootLayout = (ConstraintLayout) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R.id.profileLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.profileLayout = (ConstraintLayout) viewFindViewById2;
        View viewFindViewById3 = itemView.findViewById(R.id.profileImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.profileIcon = (CachedImageView) viewFindViewById3;
        View viewFindViewById4 = itemView.findViewById(R.id.defaultProfileImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.noPhotoIcon = (ImageView) viewFindViewById4;
        View viewFindViewById5 = itemView.findViewById(R.id.dotsLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.dotsLayout = (ConstraintLayout) viewFindViewById5;
        View viewFindViewById6 = itemView.findViewById(R.id.victoryLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.victoryLabel = (TextView) viewFindViewById6;
        View viewFindViewById7 = itemView.findViewById(R.id.timeLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.timeLabel = (TextView) viewFindViewById7;
        View viewFindViewById8 = itemView.findViewById(R.id.gameName);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.gameName = (TextView) viewFindViewById8;
        View viewFindViewById9 = itemView.findViewById(R.id.playgroupName);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        this.playgroupName = (TextView) viewFindViewById9;
        View viewFindViewById10 = itemView.findViewById(R.id.usersRecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        this.smallUsersRecyclerView1 = (RecyclerView) viewFindViewById10;
        View viewFindViewById11 = itemView.findViewById(R.id.interLabel1);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        this.interLabel1 = (TextView) viewFindViewById11;
        View viewFindViewById12 = itemView.findViewById(R.id.usersRecyclerView2);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
        this.smallUsersRecyclerView2 = (RecyclerView) viewFindViewById12;
        View viewFindViewById13 = itemView.findViewById(R.id.interLabel2);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(...)");
        this.interLabel2 = (TextView) viewFindViewById13;
        View viewFindViewById14 = itemView.findViewById(R.id.usersRecyclerView3);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById14, "findViewById(...)");
        this.smallUsersRecyclerView3 = (RecyclerView) viewFindViewById14;
        View viewFindViewById15 = itemView.findViewById(R.id.winnersLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById15, "findViewById(...)");
        this.winnerNamesLabel = (TextView) viewFindViewById15;
        View viewFindViewById16 = itemView.findViewById(R.id.winnersRecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById16, "findViewById(...)");
        this.winnersRecyclerView = (RecyclerView) viewFindViewById16;
        View viewFindViewById17 = itemView.findViewById(R.id.winnersHeaderLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById17, "findViewById(...)");
        this.winnersHeaderLabel = (TextView) viewFindViewById17;
        View viewFindViewById18 = itemView.findViewById(R.id.leaderImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById18, "findViewById(...)");
        this.leaderImage = (ImageView) viewFindViewById18;
        View viewFindViewById19 = itemView.findViewById(R.id.guardianImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById19, "findViewById(...)");
        this.guardianImage = (ImageView) viewFindViewById19;
        View viewFindViewById20 = itemView.findViewById(R.id.assassinsImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById20, "findViewById(...)");
        this.assassinsImage = (ImageView) viewFindViewById20;
        View viewFindViewById21 = itemView.findViewById(R.id.traitorsImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById21, "findViewById(...)");
        this.traitorsImage = (ImageView) viewFindViewById21;
        View viewFindViewById22 = itemView.findViewById(R.id.noteImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById22, "findViewById(...)");
        this.noteImage = (ImageView) viewFindViewById22;
        View viewFindViewById23 = itemView.findViewById(R.id.tagsFlexboxLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById23, "findViewById(...)");
        this.tagsFlexboxLayout = (FlexboxLayout) viewFindViewById23;
    }

    public final ImageView getAssassinsImage() {
        return this.assassinsImage;
    }

    public final GamesClickListener getClickListener() {
        return this.clickListener;
    }

    public final ConstraintLayout getDotsLayout() {
        return this.dotsLayout;
    }

    public final TextView getGameName() {
        return this.gameName;
    }

    public final ImageView getGuardianImage() {
        return this.guardianImage;
    }

    public final TextView getInterLabel1() {
        return this.interLabel1;
    }

    public final TextView getInterLabel2() {
        return this.interLabel2;
    }

    public final ImageView getLeaderImage() {
        return this.leaderImage;
    }

    public final ImageView getNoPhotoIcon() {
        return this.noPhotoIcon;
    }

    public final ImageView getNoteImage() {
        return this.noteImage;
    }

    public final TextView getPlaygroupName() {
        return this.playgroupName;
    }

    public final CachedImageView getProfileIcon() {
        return this.profileIcon;
    }

    public final ConstraintLayout getProfileLayout() {
        return this.profileLayout;
    }

    public final ConstraintLayout getRootLayout() {
        return this.rootLayout;
    }

    public final RecyclerView getSmallUsersRecyclerView1() {
        return this.smallUsersRecyclerView1;
    }

    public final RecyclerView getSmallUsersRecyclerView2() {
        return this.smallUsersRecyclerView2;
    }

    public final RecyclerView getSmallUsersRecyclerView3() {
        return this.smallUsersRecyclerView3;
    }

    public final FlexboxLayout getTagsFlexboxLayout() {
        return this.tagsFlexboxLayout;
    }

    public final TextView getTimeLabel() {
        return this.timeLabel;
    }

    public final ImageView getTraitorsImage() {
        return this.traitorsImage;
    }

    public final TextView getVictoryLabel() {
        return this.victoryLabel;
    }

    public final TextView getWinnerNamesLabel() {
        return this.winnerNamesLabel;
    }

    public final TextView getWinnersHeaderLabel() {
        return this.winnersHeaderLabel;
    }

    public final RecyclerView getWinnersRecyclerView() {
        return this.winnersRecyclerView;
    }

    public final void setProfileLayout(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.profileLayout = constraintLayout;
    }

    public final void setRootLayout(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.rootLayout = constraintLayout;
    }
}
