package com.studiolaganne.lengendarylens;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DecksListAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001a\u0010\u001c\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001a\u0010\u001f\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018R\u001a\u0010\"\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\u001a\u0010%\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0016\"\u0004\b'\u0010\u0018R\u001a\u0010(\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-R\u001a\u00101\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010+\"\u0004\b3\u0010-R\u001a\u00104\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010+\"\u0004\b6\u0010-R\u001a\u00107\u001a\u000208X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010=\u001a\u00020>X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0011\u0010C\u001a\u000208¢\u0006\b\n\u0000\u001a\u0004\bD\u0010:R\u0011\u0010E\u001a\u00020)¢\u0006\b\n\u0000\u001a\u0004\bF\u0010+R\u0011\u0010G\u001a\u00020)¢\u0006\b\n\u0000\u001a\u0004\bH\u0010+R\u0011\u0010I\u001a\u00020)¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010+R\u0011\u0010K\u001a\u00020)¢\u0006\b\n\u0000\u001a\u0004\bL\u0010+R\u0011\u0010M\u001a\u00020)¢\u0006\b\n\u0000\u001a\u0004\bN\u0010+R\u0011\u0010O\u001a\u00020)¢\u0006\b\n\u0000\u001a\u0004\bP\u0010+R\u0011\u0010Q\u001a\u00020)¢\u0006\b\n\u0000\u001a\u0004\bR\u0010+R\u0011\u0010S\u001a\u00020)¢\u0006\b\n\u0000\u001a\u0004\bT\u0010+R\u001a\u0010U\u001a\u000208X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010:\"\u0004\bW\u0010<R\u001a\u0010X\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010+\"\u0004\bZ\u0010-R\u001a\u0010[\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\r\"\u0004\b]\u0010\u000fR\u001a\u0010^\u001a\u00020_X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u001a\u0010d\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010\u0016\"\u0004\bf\u0010\u0018R\u001a\u0010g\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010+\"\u0004\bi\u0010-R\u001c\u0010j\u001a\u0004\u0018\u000108X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010:\"\u0004\bl\u0010<R\u001c\u0010m\u001a\u0004\u0018\u00010nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010p\"\u0004\bq\u0010r¨\u0006s"}, d2 = {"Lcom/studiolaganne/lengendarylens/DecksListViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "clickListener", "Lcom/studiolaganne/lengendarylens/DecksListClickListener;", "<init>", "(Landroid/view/View;Lcom/studiolaganne/lengendarylens/DecksListClickListener;)V", "getClickListener", "()Lcom/studiolaganne/lengendarylens/DecksListClickListener;", "rootLayout", "Landroid/widget/LinearLayout;", "getRootLayout", "()Landroid/widget/LinearLayout;", "setRootLayout", "(Landroid/widget/LinearLayout;)V", "manaLayout", "getManaLayout", "setManaLayout", "wMana", "Landroid/widget/ImageView;", "getWMana", "()Landroid/widget/ImageView;", "setWMana", "(Landroid/widget/ImageView;)V", "uMana", "getUMana", "setUMana", "bMana", "getBMana", "setBMana", "rMana", "getRMana", "setRMana", "gMana", "getGMana", "setGMana", "cMana", "getCMana", "setCMana", "deckName", "Landroid/widget/TextView;", "getDeckName", "()Landroid/widget/TextView;", "setDeckName", "(Landroid/widget/TextView;)V", "deckFormat", "getDeckFormat", "setDeckFormat", "winrateValue", "getWinrateValue", "setWinrateValue", "pendingText", "getPendingText", "setPendingText", "innerLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getInnerLayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setInnerLayout", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "deckImage", "Lcom/studiolaganne/lengendarylens/LoadingImageViewDeck;", "getDeckImage", "()Lcom/studiolaganne/lengendarylens/LoadingImageViewDeck;", "setDeckImage", "(Lcom/studiolaganne/lengendarylens/LoadingImageViewDeck;)V", "dotsLayout", "getDotsLayout", "gamesLabel", "getGamesLabel", "gamesValue", "getGamesValue", "winsLabel", "getWinsLabel", "winsValue", "getWinsValue", "lossesLabel", "getLossesLabel", "lossesValue", "getLossesValue", "drawsLabel", "getDrawsLabel", "drawsValue", "getDrawsValue", "bracketLayout", "getBracketLayout", "setBracketLayout", "bracketValueTextView", "getBracketValueTextView", "setBracketValueTextView", "ownerLayout", "getOwnerLayout", "setOwnerLayout", "profileIcon", "Lcom/studiolaganne/lengendarylens/CachedImageView;", "getProfileIcon", "()Lcom/studiolaganne/lengendarylens/CachedImageView;", "setProfileIcon", "(Lcom/studiolaganne/lengendarylens/CachedImageView;)V", "noPhotoIcon", "getNoPhotoIcon", "setNoPhotoIcon", "userName", "getUserName", "setUserName", "smartDeckHeaderLayout", "getSmartDeckHeaderLayout", "setSmartDeckHeaderLayout", "smartDeckBorderView", "Lcom/studiolaganne/lengendarylens/MythicBorderAnimationView;", "getSmartDeckBorderView", "()Lcom/studiolaganne/lengendarylens/MythicBorderAnimationView;", "setSmartDeckBorderView", "(Lcom/studiolaganne/lengendarylens/MythicBorderAnimationView;)V", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DecksListViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    private ImageView bMana;
    private ConstraintLayout bracketLayout;
    private TextView bracketValueTextView;
    private ImageView cMana;
    private final DecksListClickListener clickListener;
    private TextView deckFormat;
    private LoadingImageViewDeck deckImage;
    private TextView deckName;
    private final ConstraintLayout dotsLayout;
    private final TextView drawsLabel;
    private final TextView drawsValue;
    private ImageView gMana;
    private final TextView gamesLabel;
    private final TextView gamesValue;
    private ConstraintLayout innerLayout;
    private final TextView lossesLabel;
    private final TextView lossesValue;
    private LinearLayout manaLayout;
    private ImageView noPhotoIcon;
    private LinearLayout ownerLayout;
    private TextView pendingText;
    private CachedImageView profileIcon;
    private ImageView rMana;
    private LinearLayout rootLayout;
    private MythicBorderAnimationView smartDeckBorderView;
    private ConstraintLayout smartDeckHeaderLayout;
    private ImageView uMana;
    private TextView userName;
    private ImageView wMana;
    private TextView winrateValue;
    private final TextView winsLabel;
    private final TextView winsValue;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DecksListViewHolder(View itemView, DecksListClickListener clickListener) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.clickListener = clickListener;
        View viewFindViewById = itemView.findViewById(R.id.root_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.rootLayout = (LinearLayout) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R.id.manaLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.manaLayout = (LinearLayout) viewFindViewById2;
        View viewFindViewById3 = itemView.findViewById(R.id.w_mana);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.wMana = (ImageView) viewFindViewById3;
        View viewFindViewById4 = itemView.findViewById(R.id.u_mana);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.uMana = (ImageView) viewFindViewById4;
        View viewFindViewById5 = itemView.findViewById(R.id.b_mana);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.bMana = (ImageView) viewFindViewById5;
        View viewFindViewById6 = itemView.findViewById(R.id.r_mana);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.rMana = (ImageView) viewFindViewById6;
        View viewFindViewById7 = itemView.findViewById(R.id.g_mana);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.gMana = (ImageView) viewFindViewById7;
        View viewFindViewById8 = itemView.findViewById(R.id.c_mana);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.cMana = (ImageView) viewFindViewById8;
        View viewFindViewById9 = itemView.findViewById(R.id.deckName);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        this.deckName = (TextView) viewFindViewById9;
        View viewFindViewById10 = itemView.findViewById(R.id.deckFormat);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        this.deckFormat = (TextView) viewFindViewById10;
        View viewFindViewById11 = itemView.findViewById(R.id.winrateValue);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        this.winrateValue = (TextView) viewFindViewById11;
        View viewFindViewById12 = itemView.findViewById(R.id.pendingText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
        this.pendingText = (TextView) viewFindViewById12;
        View viewFindViewById13 = itemView.findViewById(R.id.innerLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(...)");
        this.innerLayout = (ConstraintLayout) viewFindViewById13;
        View viewFindViewById14 = itemView.findViewById(R.id.deckImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById14, "findViewById(...)");
        this.deckImage = (LoadingImageViewDeck) viewFindViewById14;
        View viewFindViewById15 = itemView.findViewById(R.id.dotsLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById15, "findViewById(...)");
        this.dotsLayout = (ConstraintLayout) viewFindViewById15;
        View viewFindViewById16 = itemView.findViewById(R.id.numGamesLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById16, "findViewById(...)");
        this.gamesLabel = (TextView) viewFindViewById16;
        View viewFindViewById17 = itemView.findViewById(R.id.numGamesValueLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById17, "findViewById(...)");
        this.gamesValue = (TextView) viewFindViewById17;
        View viewFindViewById18 = itemView.findViewById(R.id.numWinsLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById18, "findViewById(...)");
        this.winsLabel = (TextView) viewFindViewById18;
        View viewFindViewById19 = itemView.findViewById(R.id.numWinsValueLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById19, "findViewById(...)");
        this.winsValue = (TextView) viewFindViewById19;
        View viewFindViewById20 = itemView.findViewById(R.id.numLossesLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById20, "findViewById(...)");
        this.lossesLabel = (TextView) viewFindViewById20;
        View viewFindViewById21 = itemView.findViewById(R.id.numLossesValueLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById21, "findViewById(...)");
        this.lossesValue = (TextView) viewFindViewById21;
        View viewFindViewById22 = itemView.findViewById(R.id.numDrawsLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById22, "findViewById(...)");
        this.drawsLabel = (TextView) viewFindViewById22;
        View viewFindViewById23 = itemView.findViewById(R.id.numDrawsValueLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById23, "findViewById(...)");
        this.drawsValue = (TextView) viewFindViewById23;
        View viewFindViewById24 = itemView.findViewById(R.id.bracketLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById24, "findViewById(...)");
        this.bracketLayout = (ConstraintLayout) viewFindViewById24;
        View viewFindViewById25 = itemView.findViewById(R.id.bracketValueTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById25, "findViewById(...)");
        this.bracketValueTextView = (TextView) viewFindViewById25;
        View viewFindViewById26 = itemView.findViewById(R.id.ownerLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById26, "findViewById(...)");
        this.ownerLayout = (LinearLayout) viewFindViewById26;
        View viewFindViewById27 = itemView.findViewById(R.id.profile_icon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById27, "findViewById(...)");
        this.profileIcon = (CachedImageView) viewFindViewById27;
        View viewFindViewById28 = itemView.findViewById(R.id.no_photo_icon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById28, "findViewById(...)");
        this.noPhotoIcon = (ImageView) viewFindViewById28;
        View viewFindViewById29 = itemView.findViewById(R.id.userName);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById29, "findViewById(...)");
        this.userName = (TextView) viewFindViewById29;
        this.smartDeckHeaderLayout = (ConstraintLayout) itemView.findViewById(R.id.smartDeckHeaderLayout);
        this.smartDeckBorderView = (MythicBorderAnimationView) itemView.findViewById(R.id.smartDeckBorderView);
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

    public final DecksListClickListener getClickListener() {
        return this.clickListener;
    }

    public final TextView getDeckFormat() {
        return this.deckFormat;
    }

    public final LoadingImageViewDeck getDeckImage() {
        return this.deckImage;
    }

    public final TextView getDeckName() {
        return this.deckName;
    }

    public final ConstraintLayout getDotsLayout() {
        return this.dotsLayout;
    }

    public final TextView getDrawsLabel() {
        return this.drawsLabel;
    }

    public final TextView getDrawsValue() {
        return this.drawsValue;
    }

    public final ImageView getGMana() {
        return this.gMana;
    }

    public final TextView getGamesLabel() {
        return this.gamesLabel;
    }

    public final TextView getGamesValue() {
        return this.gamesValue;
    }

    public final ConstraintLayout getInnerLayout() {
        return this.innerLayout;
    }

    public final TextView getLossesLabel() {
        return this.lossesLabel;
    }

    public final TextView getLossesValue() {
        return this.lossesValue;
    }

    public final LinearLayout getManaLayout() {
        return this.manaLayout;
    }

    public final ImageView getNoPhotoIcon() {
        return this.noPhotoIcon;
    }

    public final LinearLayout getOwnerLayout() {
        return this.ownerLayout;
    }

    public final TextView getPendingText() {
        return this.pendingText;
    }

    public final CachedImageView getProfileIcon() {
        return this.profileIcon;
    }

    public final ImageView getRMana() {
        return this.rMana;
    }

    public final LinearLayout getRootLayout() {
        return this.rootLayout;
    }

    public final MythicBorderAnimationView getSmartDeckBorderView() {
        return this.smartDeckBorderView;
    }

    public final ConstraintLayout getSmartDeckHeaderLayout() {
        return this.smartDeckHeaderLayout;
    }

    public final ImageView getUMana() {
        return this.uMana;
    }

    public final TextView getUserName() {
        return this.userName;
    }

    public final ImageView getWMana() {
        return this.wMana;
    }

    public final TextView getWinrateValue() {
        return this.winrateValue;
    }

    public final TextView getWinsLabel() {
        return this.winsLabel;
    }

    public final TextView getWinsValue() {
        return this.winsValue;
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

    public final void setDeckFormat(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.deckFormat = textView;
    }

    public final void setDeckImage(LoadingImageViewDeck loadingImageViewDeck) {
        Intrinsics.checkNotNullParameter(loadingImageViewDeck, "<set-?>");
        this.deckImage = loadingImageViewDeck;
    }

    public final void setDeckName(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.deckName = textView;
    }

    public final void setGMana(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.gMana = imageView;
    }

    public final void setInnerLayout(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.innerLayout = constraintLayout;
    }

    public final void setManaLayout(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.manaLayout = linearLayout;
    }

    public final void setNoPhotoIcon(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.noPhotoIcon = imageView;
    }

    public final void setOwnerLayout(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.ownerLayout = linearLayout;
    }

    public final void setPendingText(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.pendingText = textView;
    }

    public final void setProfileIcon(CachedImageView cachedImageView) {
        Intrinsics.checkNotNullParameter(cachedImageView, "<set-?>");
        this.profileIcon = cachedImageView;
    }

    public final void setRMana(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.rMana = imageView;
    }

    public final void setRootLayout(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.rootLayout = linearLayout;
    }

    public final void setSmartDeckBorderView(MythicBorderAnimationView mythicBorderAnimationView) {
        this.smartDeckBorderView = mythicBorderAnimationView;
    }

    public final void setSmartDeckHeaderLayout(ConstraintLayout constraintLayout) {
        this.smartDeckHeaderLayout = constraintLayout;
    }

    public final void setUMana(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.uMana = imageView;
    }

    public final void setUserName(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.userName = textView;
    }

    public final void setWMana(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.wMana = imageView;
    }

    public final void setWinrateValue(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.winrateValue = textView;
    }
}
