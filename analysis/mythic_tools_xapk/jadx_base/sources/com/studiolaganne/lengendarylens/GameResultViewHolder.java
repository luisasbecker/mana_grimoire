package com.studiolaganne.lengendarylens;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GameResultAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b0\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u000f\"\u0004\b,\u0010\u0011R\u001a\u0010-\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u000f\"\u0004\b/\u0010\u0011R\u001a\u00100\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u000f\"\u0004\b2\u0010\u0011R\u001a\u00103\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\t\"\u0004\b5\u0010\u000bR\u001a\u00106\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010'\"\u0004\b8\u0010)R\u001a\u00109\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010'\"\u0004\b;\u0010)R\u001a\u0010<\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010'\"\u0004\b>\u0010)R\u001a\u0010?\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010'\"\u0004\bA\u0010)R\u001a\u0010B\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010'\"\u0004\bD\u0010)R\u001a\u0010E\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010'\"\u0004\bG\u0010)R\u001a\u0010H\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u001b\"\u0004\bJ\u0010\u001dR\u001a\u0010K\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u000f\"\u0004\bM\u0010\u0011R\u001a\u0010N\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u001b\"\u0004\bP\u0010\u001dR\u0011\u0010Q\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bR\u0010\u000fR\u0011\u0010S\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bT\u0010\u000f¨\u0006U"}, d2 = {"Lcom/studiolaganne/lengendarylens/GameResultViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "rootLayout", "Landroid/widget/LinearLayout;", "getRootLayout", "()Landroid/widget/LinearLayout;", "setRootLayout", "(Landroid/widget/LinearLayout;)V", "winnerTextView", "Landroid/widget/TextView;", "getWinnerTextView", "()Landroid/widget/TextView;", "setWinnerTextView", "(Landroid/widget/TextView;)V", "lifeTotalView", "Lcom/studiolaganne/lengendarylens/LifeTotalView;", "getLifeTotalView", "()Lcom/studiolaganne/lengendarylens/LifeTotalView;", "setLifeTotalView", "(Lcom/studiolaganne/lengendarylens/LifeTotalView;)V", "profileLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getProfileLayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setProfileLayout", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "profileIcon", "Lcom/studiolaganne/lengendarylens/CachedImageView;", "getProfileIcon", "()Lcom/studiolaganne/lengendarylens/CachedImageView;", "setProfileIcon", "(Lcom/studiolaganne/lengendarylens/CachedImageView;)V", "noPhotoIcon", "Landroid/widget/ImageView;", "getNoPhotoIcon", "()Landroid/widget/ImageView;", "setNoPhotoIcon", "(Landroid/widget/ImageView;)V", "userFirstnameTextView", "getUserFirstnameTextView", "setUserFirstnameTextView", "userNameTextView", "getUserNameTextView", "setUserNameTextView", "deckNameTextView", "getDeckNameTextView", "setDeckNameTextView", "manaLayout", "getManaLayout", "setManaLayout", "wMana", "getWMana", "setWMana", "uMana", "getUMana", "setUMana", "bMana", "getBMana", "setBMana", "rMana", "getRMana", "setRMana", "gMana", "getGMana", "setGMana", "cMana", "getCMana", "setCMana", "bracketLayout", "getBracketLayout", "setBracketLayout", "bracketValueTextView", "getBracketValueTextView", "setBracketValueTextView", "totalTimeLayout", "getTotalTimeLayout", "setTotalTimeLayout", "totalTimeTextView", "getTotalTimeTextView", "startingPlayerLabel", "getStartingPlayerLabel", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GameResultViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    private ImageView bMana;
    private ConstraintLayout bracketLayout;
    private TextView bracketValueTextView;
    private ImageView cMana;
    private TextView deckNameTextView;
    private ImageView gMana;
    private LifeTotalView lifeTotalView;
    private LinearLayout manaLayout;
    private ImageView noPhotoIcon;
    private CachedImageView profileIcon;
    private ConstraintLayout profileLayout;
    private ImageView rMana;
    private LinearLayout rootLayout;
    private final TextView startingPlayerLabel;
    private ConstraintLayout totalTimeLayout;
    private final TextView totalTimeTextView;
    private ImageView uMana;
    private TextView userFirstnameTextView;
    private TextView userNameTextView;
    private ImageView wMana;
    private TextView winnerTextView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameResultViewHolder(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View viewFindViewById = itemView.findViewById(R.id.root_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.rootLayout = (LinearLayout) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R.id.winnerTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.winnerTextView = (TextView) viewFindViewById2;
        View viewFindViewById3 = itemView.findViewById(R.id.lifeTotalView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.lifeTotalView = (LifeTotalView) viewFindViewById3;
        View viewFindViewById4 = itemView.findViewById(R.id.profileLayoutSummary);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.profileLayout = (ConstraintLayout) viewFindViewById4;
        View viewFindViewById5 = itemView.findViewById(R.id.profileIconSummary);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.profileIcon = (CachedImageView) viewFindViewById5;
        View viewFindViewById6 = itemView.findViewById(R.id.noPhotoIconSummary);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.noPhotoIcon = (ImageView) viewFindViewById6;
        View viewFindViewById7 = itemView.findViewById(R.id.userFirstnameTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.userFirstnameTextView = (TextView) viewFindViewById7;
        View viewFindViewById8 = itemView.findViewById(R.id.userNameTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.userNameTextView = (TextView) viewFindViewById8;
        View viewFindViewById9 = itemView.findViewById(R.id.deckNameTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        this.deckNameTextView = (TextView) viewFindViewById9;
        View viewFindViewById10 = itemView.findViewById(R.id.manaLayoutSummary);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        this.manaLayout = (LinearLayout) viewFindViewById10;
        View viewFindViewById11 = itemView.findViewById(R.id.w_manaSummary);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        this.wMana = (ImageView) viewFindViewById11;
        View viewFindViewById12 = itemView.findViewById(R.id.u_manaSummary);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
        this.uMana = (ImageView) viewFindViewById12;
        View viewFindViewById13 = itemView.findViewById(R.id.b_manaSummary);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(...)");
        this.bMana = (ImageView) viewFindViewById13;
        View viewFindViewById14 = itemView.findViewById(R.id.r_manaSummary);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById14, "findViewById(...)");
        this.rMana = (ImageView) viewFindViewById14;
        View viewFindViewById15 = itemView.findViewById(R.id.g_manaSummary);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById15, "findViewById(...)");
        this.gMana = (ImageView) viewFindViewById15;
        View viewFindViewById16 = itemView.findViewById(R.id.c_manaSummary);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById16, "findViewById(...)");
        this.cMana = (ImageView) viewFindViewById16;
        View viewFindViewById17 = itemView.findViewById(R.id.bracketLayoutResult);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById17, "findViewById(...)");
        this.bracketLayout = (ConstraintLayout) viewFindViewById17;
        View viewFindViewById18 = itemView.findViewById(R.id.bracketValueText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById18, "findViewById(...)");
        this.bracketValueTextView = (TextView) viewFindViewById18;
        View viewFindViewById19 = itemView.findViewById(R.id.totalTimeLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById19, "findViewById(...)");
        this.totalTimeLayout = (ConstraintLayout) viewFindViewById19;
        View viewFindViewById20 = itemView.findViewById(R.id.totalTimeTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById20, "findViewById(...)");
        this.totalTimeTextView = (TextView) viewFindViewById20;
        View viewFindViewById21 = itemView.findViewById(R.id.startingPlayerLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById21, "findViewById(...)");
        this.startingPlayerLabel = (TextView) viewFindViewById21;
    }

    public final ImageView getBMana() {
        return this.bMana;
    }

    public final ConstraintLayout getBracketLayout() {
        return this.bracketLayout;
    }

    public final TextView getBracketValueTextView() {
        return this.bracketValueTextView;
    }

    public final ImageView getCMana() {
        return this.cMana;
    }

    public final TextView getDeckNameTextView() {
        return this.deckNameTextView;
    }

    public final ImageView getGMana() {
        return this.gMana;
    }

    public final LifeTotalView getLifeTotalView() {
        return this.lifeTotalView;
    }

    public final LinearLayout getManaLayout() {
        return this.manaLayout;
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

    public final ImageView getRMana() {
        return this.rMana;
    }

    public final LinearLayout getRootLayout() {
        return this.rootLayout;
    }

    public final TextView getStartingPlayerLabel() {
        return this.startingPlayerLabel;
    }

    public final ConstraintLayout getTotalTimeLayout() {
        return this.totalTimeLayout;
    }

    public final TextView getTotalTimeTextView() {
        return this.totalTimeTextView;
    }

    public final ImageView getUMana() {
        return this.uMana;
    }

    public final TextView getUserFirstnameTextView() {
        return this.userFirstnameTextView;
    }

    public final TextView getUserNameTextView() {
        return this.userNameTextView;
    }

    public final ImageView getWMana() {
        return this.wMana;
    }

    public final TextView getWinnerTextView() {
        return this.winnerTextView;
    }

    public final void setBMana(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.bMana = imageView;
    }

    public final void setBracketLayout(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.bracketLayout = constraintLayout;
    }

    public final void setBracketValueTextView(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.bracketValueTextView = textView;
    }

    public final void setCMana(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.cMana = imageView;
    }

    public final void setDeckNameTextView(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.deckNameTextView = textView;
    }

    public final void setGMana(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.gMana = imageView;
    }

    public final void setLifeTotalView(LifeTotalView lifeTotalView) {
        Intrinsics.checkNotNullParameter(lifeTotalView, "<set-?>");
        this.lifeTotalView = lifeTotalView;
    }

    public final void setManaLayout(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.manaLayout = linearLayout;
    }

    public final void setNoPhotoIcon(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.noPhotoIcon = imageView;
    }

    public final void setProfileIcon(CachedImageView cachedImageView) {
        Intrinsics.checkNotNullParameter(cachedImageView, "<set-?>");
        this.profileIcon = cachedImageView;
    }

    public final void setProfileLayout(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.profileLayout = constraintLayout;
    }

    public final void setRMana(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.rMana = imageView;
    }

    public final void setRootLayout(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.rootLayout = linearLayout;
    }

    public final void setTotalTimeLayout(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.totalTimeLayout = constraintLayout;
    }

    public final void setUMana(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.uMana = imageView;
    }

    public final void setUserFirstnameTextView(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.userFirstnameTextView = textView;
    }

    public final void setUserNameTextView(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.userNameTextView = textView;
    }

    public final void setWMana(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.wMana = imageView;
    }

    public final void setWinnerTextView(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.winnerTextView = textView;
    }
}
