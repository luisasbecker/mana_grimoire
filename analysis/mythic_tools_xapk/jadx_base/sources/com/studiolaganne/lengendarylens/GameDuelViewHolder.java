package com.studiolaganne.lengendarylens;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GamesAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b?\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010|\u001a\u00020}2\u0006\u0010~\u001a\u00020\u007fJ\u0007\u0010\u0080\u0001\u001a\u00020}R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u0011\u0010 \u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u0011\u0010&\u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b'\u0010#R\u0011\u0010(\u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b)\u0010#R\u0011\u0010*\u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b+\u0010#R\u0011\u0010,\u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b-\u0010#R\u0011\u0010.\u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b/\u0010#R\u0011\u00100\u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b1\u0010#R\u0011\u00102\u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b3\u0010#R\u0011\u00104\u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b5\u0010#R\u0011\u00106\u001a\u000207¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0011\u0010:\u001a\u000207¢\u0006\b\n\u0000\u001a\u0004\b;\u00109R\u0011\u0010<\u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b=\u0010#R\u0011\u0010>\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0013R\u0011\u0010@\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u0013R\u0011\u0010B\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u0013R\u0011\u0010D\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\u0013R\u0011\u0010F\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\bG\u0010\u0013R\u0011\u0010H\u001a\u000207¢\u0006\b\n\u0000\u001a\u0004\bI\u00109R\u0011\u0010J\u001a\u000207¢\u0006\b\n\u0000\u001a\u0004\bK\u00109R\u0011\u0010L\u001a\u000207¢\u0006\b\n\u0000\u001a\u0004\bM\u00109R\u0011\u0010N\u001a\u000207¢\u0006\b\n\u0000\u001a\u0004\bO\u00109R\u0011\u0010P\u001a\u000207¢\u0006\b\n\u0000\u001a\u0004\bQ\u00109R\u0011\u0010R\u001a\u000207¢\u0006\b\n\u0000\u001a\u0004\bS\u00109R\u0011\u0010T\u001a\u000207¢\u0006\b\n\u0000\u001a\u0004\bU\u00109R\u0011\u0010V\u001a\u000207¢\u0006\b\n\u0000\u001a\u0004\bW\u00109R\u0011\u0010X\u001a\u000207¢\u0006\b\n\u0000\u001a\u0004\bY\u00109R\u0011\u0010Z\u001a\u000207¢\u0006\b\n\u0000\u001a\u0004\b[\u00109R\u0011\u0010\\\u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b]\u0010#R\u0011\u0010^\u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b_\u0010#R\u0011\u0010`\u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\ba\u0010#R\u0011\u0010b\u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\bc\u0010#R\u0011\u0010d\u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\be\u0010#R\u0011\u0010f\u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\bg\u0010#R\u0011\u0010h\u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\bi\u0010#R\u0011\u0010j\u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\bk\u0010#R\u0011\u0010l\u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\bm\u0010#R\u0011\u0010n\u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\bo\u0010#R\u0011\u0010p\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\bq\u0010\u0013R\u0011\u0010r\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\bs\u0010\u001dR\u0011\u0010t\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\bu\u0010\u001dR\u0011\u0010v\u001a\u00020w¢\u0006\b\n\u0000\u001a\u0004\bx\u0010yR\u0011\u0010z\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b{\u0010\u0013¨\u0006\u0081\u0001"}, d2 = {"Lcom/studiolaganne/lengendarylens/GameDuelViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "clickListener", "Lcom/studiolaganne/lengendarylens/GamesClickListener;", "<init>", "(Landroid/view/View;Lcom/studiolaganne/lengendarylens/GamesClickListener;)V", "getClickListener", "()Lcom/studiolaganne/lengendarylens/GamesClickListener;", "rootLayout", "Landroid/widget/LinearLayout;", "getRootLayout", "()Landroid/widget/LinearLayout;", "setRootLayout", "(Landroid/widget/LinearLayout;)V", "profileLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getProfileLayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setProfileLayout", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "profileIcon", "Lcom/studiolaganne/lengendarylens/CachedImageView;", "getProfileIcon", "()Lcom/studiolaganne/lengendarylens/CachedImageView;", "noPhotoIcon", "Landroid/widget/ImageView;", "getNoPhotoIcon", "()Landroid/widget/ImageView;", "dotsLayout", "getDotsLayout", "victoryLabel", "Landroid/widget/TextView;", "getVictoryLabel", "()Landroid/widget/TextView;", "timeLabel", "getTimeLabel", "gameName", "getGameName", "playgroupName", "getPlaygroupName", "player1NameLabel", "getPlayer1NameLabel", "player2NameLabel", "getPlayer2NameLabel", "player1ScoreLabel", "getPlayer1ScoreLabel", "player2ScoreLabel", "getPlayer2ScoreLabel", "player1WinnerHeader", "getPlayer1WinnerHeader", "player2WinnerHeader", "getPlayer2WinnerHeader", "player1RecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getPlayer1RecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "player2RecyclerView", "getPlayer2RecyclerView", "bestOfLabel", "getBestOfLabel", "game1Layout", "getGame1Layout", "game2Layout", "getGame2Layout", "game3Layout", "getGame3Layout", "game4Layout", "getGame4Layout", "game5Layout", "getGame5Layout", "game1player1RecyclerView", "getGame1player1RecyclerView", "game2player1RecyclerView", "getGame2player1RecyclerView", "game3player1RecyclerView", "getGame3player1RecyclerView", "game4player1RecyclerView", "getGame4player1RecyclerView", "game5player1RecyclerView", "getGame5player1RecyclerView", "game1player2RecyclerView", "getGame1player2RecyclerView", "game2player2RecyclerView", "getGame2player2RecyclerView", "game3player2RecyclerView", "getGame3player2RecyclerView", "game4player2RecyclerView", "getGame4player2RecyclerView", "game5player2RecyclerView", "getGame5player2RecyclerView", "game1player1WinnerHeaderLabel", "getGame1player1WinnerHeaderLabel", "game2player1WinnerHeaderLabel", "getGame2player1WinnerHeaderLabel", "game3player1WinnerHeaderLabel", "getGame3player1WinnerHeaderLabel", "game4player1WinnerHeaderLabel", "getGame4player1WinnerHeaderLabel", "game5player1WinnerHeaderLabel", "getGame5player1WinnerHeaderLabel", "game1player2WinnerHeaderLabel", "getGame1player2WinnerHeaderLabel", "game2player2WinnerHeaderLabel", "getGame2player2WinnerHeaderLabel", "game3player2WinnerHeaderLabel", "getGame3player2WinnerHeaderLabel", "game4player2WinnerHeaderLabel", "getGame4player2WinnerHeaderLabel", "game5player2WinnerHeaderLabel", "getGame5player2WinnerHeaderLabel", "playgroupInfoInnerLayout", "getPlaygroupInfoInnerLayout", "bestOfChevron", "getBestOfChevron", "noteImage", "getNoteImage", "tagsFlexboxLayout", "Lcom/google/android/flexbox/FlexboxLayout;", "getTagsFlexboxLayout", "()Lcom/google/android/flexbox/FlexboxLayout;", "bottomLayout", "getBottomLayout", "expand", "", "numGames", "", "collapse", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GameDuelViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    private final ImageView bestOfChevron;
    private final TextView bestOfLabel;
    private final ConstraintLayout bottomLayout;
    private final GamesClickListener clickListener;
    private final ConstraintLayout dotsLayout;
    private final ConstraintLayout game1Layout;
    private final RecyclerView game1player1RecyclerView;
    private final TextView game1player1WinnerHeaderLabel;
    private final RecyclerView game1player2RecyclerView;
    private final TextView game1player2WinnerHeaderLabel;
    private final ConstraintLayout game2Layout;
    private final RecyclerView game2player1RecyclerView;
    private final TextView game2player1WinnerHeaderLabel;
    private final RecyclerView game2player2RecyclerView;
    private final TextView game2player2WinnerHeaderLabel;
    private final ConstraintLayout game3Layout;
    private final RecyclerView game3player1RecyclerView;
    private final TextView game3player1WinnerHeaderLabel;
    private final RecyclerView game3player2RecyclerView;
    private final TextView game3player2WinnerHeaderLabel;
    private final ConstraintLayout game4Layout;
    private final RecyclerView game4player1RecyclerView;
    private final TextView game4player1WinnerHeaderLabel;
    private final RecyclerView game4player2RecyclerView;
    private final TextView game4player2WinnerHeaderLabel;
    private final ConstraintLayout game5Layout;
    private final RecyclerView game5player1RecyclerView;
    private final TextView game5player1WinnerHeaderLabel;
    private final RecyclerView game5player2RecyclerView;
    private final TextView game5player2WinnerHeaderLabel;
    private final TextView gameName;
    private final ImageView noPhotoIcon;
    private final ImageView noteImage;
    private final TextView player1NameLabel;
    private final RecyclerView player1RecyclerView;
    private final TextView player1ScoreLabel;
    private final TextView player1WinnerHeader;
    private final TextView player2NameLabel;
    private final RecyclerView player2RecyclerView;
    private final TextView player2ScoreLabel;
    private final TextView player2WinnerHeader;
    private final ConstraintLayout playgroupInfoInnerLayout;
    private final TextView playgroupName;
    private final CachedImageView profileIcon;
    private ConstraintLayout profileLayout;
    private LinearLayout rootLayout;
    private final FlexboxLayout tagsFlexboxLayout;
    private final TextView timeLabel;
    private final TextView victoryLabel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameDuelViewHolder(View itemView, GamesClickListener clickListener) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.clickListener = clickListener;
        View viewFindViewById = itemView.findViewById(R.id.root_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.rootLayout = (LinearLayout) viewFindViewById;
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
        View viewFindViewById10 = itemView.findViewById(R.id.player1Label);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        this.player1NameLabel = (TextView) viewFindViewById10;
        View viewFindViewById11 = itemView.findViewById(R.id.player2Label);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        this.player2NameLabel = (TextView) viewFindViewById11;
        View viewFindViewById12 = itemView.findViewById(R.id.player1Score);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
        this.player1ScoreLabel = (TextView) viewFindViewById12;
        View viewFindViewById13 = itemView.findViewById(R.id.player2Score);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(...)");
        this.player2ScoreLabel = (TextView) viewFindViewById13;
        View viewFindViewById14 = itemView.findViewById(R.id.player1WinnerHeaderLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById14, "findViewById(...)");
        this.player1WinnerHeader = (TextView) viewFindViewById14;
        View viewFindViewById15 = itemView.findViewById(R.id.player2WinnerHeaderLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById15, "findViewById(...)");
        this.player2WinnerHeader = (TextView) viewFindViewById15;
        View viewFindViewById16 = itemView.findViewById(R.id.player1RecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById16, "findViewById(...)");
        this.player1RecyclerView = (RecyclerView) viewFindViewById16;
        View viewFindViewById17 = itemView.findViewById(R.id.player2RecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById17, "findViewById(...)");
        this.player2RecyclerView = (RecyclerView) viewFindViewById17;
        View viewFindViewById18 = itemView.findViewById(R.id.bestOfLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById18, "findViewById(...)");
        this.bestOfLabel = (TextView) viewFindViewById18;
        View viewFindViewById19 = itemView.findViewById(R.id.game1Layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById19, "findViewById(...)");
        this.game1Layout = (ConstraintLayout) viewFindViewById19;
        View viewFindViewById20 = itemView.findViewById(R.id.game2Layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById20, "findViewById(...)");
        this.game2Layout = (ConstraintLayout) viewFindViewById20;
        View viewFindViewById21 = itemView.findViewById(R.id.game3Layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById21, "findViewById(...)");
        this.game3Layout = (ConstraintLayout) viewFindViewById21;
        View viewFindViewById22 = itemView.findViewById(R.id.game4Layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById22, "findViewById(...)");
        this.game4Layout = (ConstraintLayout) viewFindViewById22;
        View viewFindViewById23 = itemView.findViewById(R.id.game5Layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById23, "findViewById(...)");
        this.game5Layout = (ConstraintLayout) viewFindViewById23;
        View viewFindViewById24 = itemView.findViewById(R.id.game1player1RecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById24, "findViewById(...)");
        this.game1player1RecyclerView = (RecyclerView) viewFindViewById24;
        View viewFindViewById25 = itemView.findViewById(R.id.game2player1RecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById25, "findViewById(...)");
        this.game2player1RecyclerView = (RecyclerView) viewFindViewById25;
        View viewFindViewById26 = itemView.findViewById(R.id.game3player1RecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById26, "findViewById(...)");
        this.game3player1RecyclerView = (RecyclerView) viewFindViewById26;
        View viewFindViewById27 = itemView.findViewById(R.id.game4player1RecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById27, "findViewById(...)");
        this.game4player1RecyclerView = (RecyclerView) viewFindViewById27;
        View viewFindViewById28 = itemView.findViewById(R.id.game5player1RecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById28, "findViewById(...)");
        this.game5player1RecyclerView = (RecyclerView) viewFindViewById28;
        View viewFindViewById29 = itemView.findViewById(R.id.game1player2RecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById29, "findViewById(...)");
        this.game1player2RecyclerView = (RecyclerView) viewFindViewById29;
        View viewFindViewById30 = itemView.findViewById(R.id.game2player2RecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById30, "findViewById(...)");
        this.game2player2RecyclerView = (RecyclerView) viewFindViewById30;
        View viewFindViewById31 = itemView.findViewById(R.id.game3player2RecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById31, "findViewById(...)");
        this.game3player2RecyclerView = (RecyclerView) viewFindViewById31;
        View viewFindViewById32 = itemView.findViewById(R.id.game4player2RecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById32, "findViewById(...)");
        this.game4player2RecyclerView = (RecyclerView) viewFindViewById32;
        View viewFindViewById33 = itemView.findViewById(R.id.game5player2RecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById33, "findViewById(...)");
        this.game5player2RecyclerView = (RecyclerView) viewFindViewById33;
        View viewFindViewById34 = itemView.findViewById(R.id.game1player1WinnerHeaderLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById34, "findViewById(...)");
        this.game1player1WinnerHeaderLabel = (TextView) viewFindViewById34;
        View viewFindViewById35 = itemView.findViewById(R.id.game2player1WinnerHeaderLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById35, "findViewById(...)");
        this.game2player1WinnerHeaderLabel = (TextView) viewFindViewById35;
        View viewFindViewById36 = itemView.findViewById(R.id.game3player1WinnerHeaderLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById36, "findViewById(...)");
        this.game3player1WinnerHeaderLabel = (TextView) viewFindViewById36;
        View viewFindViewById37 = itemView.findViewById(R.id.game4player1WinnerHeaderLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById37, "findViewById(...)");
        this.game4player1WinnerHeaderLabel = (TextView) viewFindViewById37;
        View viewFindViewById38 = itemView.findViewById(R.id.game5player1WinnerHeaderLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById38, "findViewById(...)");
        this.game5player1WinnerHeaderLabel = (TextView) viewFindViewById38;
        View viewFindViewById39 = itemView.findViewById(R.id.game1player2WinnerHeaderLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById39, "findViewById(...)");
        this.game1player2WinnerHeaderLabel = (TextView) viewFindViewById39;
        View viewFindViewById40 = itemView.findViewById(R.id.game2player2WinnerHeaderLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById40, "findViewById(...)");
        this.game2player2WinnerHeaderLabel = (TextView) viewFindViewById40;
        View viewFindViewById41 = itemView.findViewById(R.id.game3player2WinnerHeaderLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById41, "findViewById(...)");
        this.game3player2WinnerHeaderLabel = (TextView) viewFindViewById41;
        View viewFindViewById42 = itemView.findViewById(R.id.game4player2WinnerHeaderLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById42, "findViewById(...)");
        this.game4player2WinnerHeaderLabel = (TextView) viewFindViewById42;
        View viewFindViewById43 = itemView.findViewById(R.id.game5player2WinnerHeaderLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById43, "findViewById(...)");
        this.game5player2WinnerHeaderLabel = (TextView) viewFindViewById43;
        View viewFindViewById44 = itemView.findViewById(R.id.playgroupInfoInnerLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById44, "findViewById(...)");
        this.playgroupInfoInnerLayout = (ConstraintLayout) viewFindViewById44;
        View viewFindViewById45 = itemView.findViewById(R.id.bestOfChevron);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById45, "findViewById(...)");
        this.bestOfChevron = (ImageView) viewFindViewById45;
        View viewFindViewById46 = itemView.findViewById(R.id.noteImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById46, "findViewById(...)");
        this.noteImage = (ImageView) viewFindViewById46;
        View viewFindViewById47 = itemView.findViewById(R.id.tagsFlexboxLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById47, "findViewById(...)");
        this.tagsFlexboxLayout = (FlexboxLayout) viewFindViewById47;
        View viewFindViewById48 = itemView.findViewById(R.id.bottomLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById48, "findViewById(...)");
        this.bottomLayout = (ConstraintLayout) viewFindViewById48;
    }

    public final void collapse() {
        this.game1Layout.setVisibility(8);
        this.game2Layout.setVisibility(8);
        this.game3Layout.setVisibility(8);
        this.game4Layout.setVisibility(8);
        this.game5Layout.setVisibility(8);
        this.bestOfChevron.setImageResource(R.drawable.chevron_right);
    }

    public final void expand(int numGames) {
        if (numGames == 1) {
            this.game1Layout.setVisibility(0);
            this.game2Layout.setVisibility(8);
            this.game3Layout.setVisibility(8);
            this.game4Layout.setVisibility(8);
            this.game5Layout.setVisibility(8);
        } else if (numGames == 2) {
            this.game1Layout.setVisibility(0);
            this.game2Layout.setVisibility(0);
            this.game3Layout.setVisibility(8);
            this.game4Layout.setVisibility(8);
            this.game5Layout.setVisibility(8);
        } else if (numGames == 3) {
            this.game1Layout.setVisibility(0);
            this.game2Layout.setVisibility(0);
            this.game3Layout.setVisibility(0);
            this.game4Layout.setVisibility(8);
            this.game5Layout.setVisibility(8);
        } else if (numGames == 4) {
            this.game1Layout.setVisibility(0);
            this.game2Layout.setVisibility(0);
            this.game3Layout.setVisibility(0);
            this.game4Layout.setVisibility(0);
            this.game5Layout.setVisibility(8);
        } else if (numGames == 5) {
            this.game1Layout.setVisibility(0);
            this.game2Layout.setVisibility(0);
            this.game3Layout.setVisibility(0);
            this.game4Layout.setVisibility(0);
            this.game5Layout.setVisibility(0);
        }
        this.bestOfChevron.setImageResource(R.drawable.chevron_down);
    }

    public final ImageView getBestOfChevron() {
        return this.bestOfChevron;
    }

    public final TextView getBestOfLabel() {
        return this.bestOfLabel;
    }

    public final ConstraintLayout getBottomLayout() {
        return this.bottomLayout;
    }

    public final GamesClickListener getClickListener() {
        return this.clickListener;
    }

    public final ConstraintLayout getDotsLayout() {
        return this.dotsLayout;
    }

    public final ConstraintLayout getGame1Layout() {
        return this.game1Layout;
    }

    public final RecyclerView getGame1player1RecyclerView() {
        return this.game1player1RecyclerView;
    }

    public final TextView getGame1player1WinnerHeaderLabel() {
        return this.game1player1WinnerHeaderLabel;
    }

    public final RecyclerView getGame1player2RecyclerView() {
        return this.game1player2RecyclerView;
    }

    public final TextView getGame1player2WinnerHeaderLabel() {
        return this.game1player2WinnerHeaderLabel;
    }

    public final ConstraintLayout getGame2Layout() {
        return this.game2Layout;
    }

    public final RecyclerView getGame2player1RecyclerView() {
        return this.game2player1RecyclerView;
    }

    public final TextView getGame2player1WinnerHeaderLabel() {
        return this.game2player1WinnerHeaderLabel;
    }

    public final RecyclerView getGame2player2RecyclerView() {
        return this.game2player2RecyclerView;
    }

    public final TextView getGame2player2WinnerHeaderLabel() {
        return this.game2player2WinnerHeaderLabel;
    }

    public final ConstraintLayout getGame3Layout() {
        return this.game3Layout;
    }

    public final RecyclerView getGame3player1RecyclerView() {
        return this.game3player1RecyclerView;
    }

    public final TextView getGame3player1WinnerHeaderLabel() {
        return this.game3player1WinnerHeaderLabel;
    }

    public final RecyclerView getGame3player2RecyclerView() {
        return this.game3player2RecyclerView;
    }

    public final TextView getGame3player2WinnerHeaderLabel() {
        return this.game3player2WinnerHeaderLabel;
    }

    public final ConstraintLayout getGame4Layout() {
        return this.game4Layout;
    }

    public final RecyclerView getGame4player1RecyclerView() {
        return this.game4player1RecyclerView;
    }

    public final TextView getGame4player1WinnerHeaderLabel() {
        return this.game4player1WinnerHeaderLabel;
    }

    public final RecyclerView getGame4player2RecyclerView() {
        return this.game4player2RecyclerView;
    }

    public final TextView getGame4player2WinnerHeaderLabel() {
        return this.game4player2WinnerHeaderLabel;
    }

    public final ConstraintLayout getGame5Layout() {
        return this.game5Layout;
    }

    public final RecyclerView getGame5player1RecyclerView() {
        return this.game5player1RecyclerView;
    }

    public final TextView getGame5player1WinnerHeaderLabel() {
        return this.game5player1WinnerHeaderLabel;
    }

    public final RecyclerView getGame5player2RecyclerView() {
        return this.game5player2RecyclerView;
    }

    public final TextView getGame5player2WinnerHeaderLabel() {
        return this.game5player2WinnerHeaderLabel;
    }

    public final TextView getGameName() {
        return this.gameName;
    }

    public final ImageView getNoPhotoIcon() {
        return this.noPhotoIcon;
    }

    public final ImageView getNoteImage() {
        return this.noteImage;
    }

    public final TextView getPlayer1NameLabel() {
        return this.player1NameLabel;
    }

    public final RecyclerView getPlayer1RecyclerView() {
        return this.player1RecyclerView;
    }

    public final TextView getPlayer1ScoreLabel() {
        return this.player1ScoreLabel;
    }

    public final TextView getPlayer1WinnerHeader() {
        return this.player1WinnerHeader;
    }

    public final TextView getPlayer2NameLabel() {
        return this.player2NameLabel;
    }

    public final RecyclerView getPlayer2RecyclerView() {
        return this.player2RecyclerView;
    }

    public final TextView getPlayer2ScoreLabel() {
        return this.player2ScoreLabel;
    }

    public final TextView getPlayer2WinnerHeader() {
        return this.player2WinnerHeader;
    }

    public final ConstraintLayout getPlaygroupInfoInnerLayout() {
        return this.playgroupInfoInnerLayout;
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

    public final LinearLayout getRootLayout() {
        return this.rootLayout;
    }

    public final FlexboxLayout getTagsFlexboxLayout() {
        return this.tagsFlexboxLayout;
    }

    public final TextView getTimeLabel() {
        return this.timeLabel;
    }

    public final TextView getVictoryLabel() {
        return this.victoryLabel;
    }

    public final void setProfileLayout(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.profileLayout = constraintLayout;
    }

    public final void setRootLayout(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.rootLayout = linearLayout;
    }
}
