package com.studiolaganne.lengendarylens;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SimpleDecksAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001a\u0010\u001f\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u001a\u0010\"\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001bR\u001a\u0010%\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0019\"\u0004\b'\u0010\u001bR\u001a\u0010(\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0019\"\u0004\b*\u0010\u001bR\u001a\u0010+\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010.\"\u0004\b3\u00100R\u001a\u00104\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\r\"\u0004\b6\u0010\u000fR\u001a\u00107\u001a\u000208X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010=\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\r\"\u0004\b?\u0010\u000fR\u001a\u0010@\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010.\"\u0004\bB\u00100¨\u0006C"}, d2 = {"Lcom/studiolaganne/lengendarylens/SimpleDeckViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "clickListener", "Lcom/studiolaganne/lengendarylens/SimpleDeckClickListener;", "<init>", "(Landroid/view/View;Lcom/studiolaganne/lengendarylens/SimpleDeckClickListener;)V", "getClickListener", "()Lcom/studiolaganne/lengendarylens/SimpleDeckClickListener;", "rootLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getRootLayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setRootLayout", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "manaLayout", "Landroid/widget/LinearLayout;", "getManaLayout", "()Landroid/widget/LinearLayout;", "setManaLayout", "(Landroid/widget/LinearLayout;)V", "wMana", "Landroid/widget/ImageView;", "getWMana", "()Landroid/widget/ImageView;", "setWMana", "(Landroid/widget/ImageView;)V", "uMana", "getUMana", "setUMana", "bMana", "getBMana", "setBMana", "rMana", "getRMana", "setRMana", "gMana", "getGMana", "setGMana", "cMana", "getCMana", "setCMana", "deckName", "Landroid/widget/TextView;", "getDeckName", "()Landroid/widget/TextView;", "setDeckName", "(Landroid/widget/TextView;)V", "deckFormat", "getDeckFormat", "setDeckFormat", "innerLayout", "getInnerLayout", "setInnerLayout", "deckImage", "Lcom/studiolaganne/lengendarylens/LoadingImageViewDeck;", "getDeckImage", "()Lcom/studiolaganne/lengendarylens/LoadingImageViewDeck;", "setDeckImage", "(Lcom/studiolaganne/lengendarylens/LoadingImageViewDeck;)V", "bracketLayout", "getBracketLayout", "setBracketLayout", "bracketValueTextView", "getBracketValueTextView", "setBracketValueTextView", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SimpleDeckViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    private ImageView bMana;
    private ConstraintLayout bracketLayout;
    private TextView bracketValueTextView;
    private ImageView cMana;
    private final SimpleDeckClickListener clickListener;
    private TextView deckFormat;
    private LoadingImageViewDeck deckImage;
    private TextView deckName;
    private ImageView gMana;
    private ConstraintLayout innerLayout;
    private LinearLayout manaLayout;
    private ImageView rMana;
    private ConstraintLayout rootLayout;
    private ImageView uMana;
    private ImageView wMana;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleDeckViewHolder(View itemView, SimpleDeckClickListener clickListener) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.clickListener = clickListener;
        View viewFindViewById = itemView.findViewById(R.id.root_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.rootLayout = (ConstraintLayout) viewFindViewById;
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
        View viewFindViewById11 = itemView.findViewById(R.id.innerLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        this.innerLayout = (ConstraintLayout) viewFindViewById11;
        View viewFindViewById12 = itemView.findViewById(R.id.deckImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
        this.deckImage = (LoadingImageViewDeck) viewFindViewById12;
        View viewFindViewById13 = itemView.findViewById(R.id.bracketLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(...)");
        this.bracketLayout = (ConstraintLayout) viewFindViewById13;
        View viewFindViewById14 = itemView.findViewById(R.id.bracketValueTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById14, "findViewById(...)");
        this.bracketValueTextView = (TextView) viewFindViewById14;
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

    public final SimpleDeckClickListener getClickListener() {
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

    public final ImageView getGMana() {
        return this.gMana;
    }

    public final ConstraintLayout getInnerLayout() {
        return this.innerLayout;
    }

    public final LinearLayout getManaLayout() {
        return this.manaLayout;
    }

    public final ImageView getRMana() {
        return this.rMana;
    }

    public final ConstraintLayout getRootLayout() {
        return this.rootLayout;
    }

    public final ImageView getUMana() {
        return this.uMana;
    }

    public final ImageView getWMana() {
        return this.wMana;
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

    public final void setRMana(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.rMana = imageView;
    }

    public final void setRootLayout(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.rootLayout = constraintLayout;
    }

    public final void setUMana(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.uMana = imageView;
    }

    public final void setWMana(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.wMana = imageView;
    }
}
