package com.studiolaganne.lengendarylens;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MatchupsAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015R\u0011\u0010#\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0015R\u0011\u0010%\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0015R\u0011\u0010'\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0015R\u0011\u0010)\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0015¨\u0006+"}, d2 = {"Lcom/studiolaganne/lengendarylens/MatchupViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "rootLayout", "Landroid/widget/LinearLayout;", "getRootLayout", "()Landroid/widget/LinearLayout;", "setRootLayout", "(Landroid/widget/LinearLayout;)V", "innerLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getInnerLayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setInnerLayout", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "matchupName", "Landroid/widget/TextView;", "getMatchupName", "()Landroid/widget/TextView;", "setMatchupName", "(Landroid/widget/TextView;)V", "winrateValue", "getWinrateValue", "setWinrateValue", "deckImage", "Lcom/studiolaganne/lengendarylens/LoadingImageViewDeck;", "getDeckImage", "()Lcom/studiolaganne/lengendarylens/LoadingImageViewDeck;", "setDeckImage", "(Lcom/studiolaganne/lengendarylens/LoadingImageViewDeck;)V", "gamesValue", "getGamesValue", "gamesLabel", "getGamesLabel", "winsValue", "getWinsValue", "lossesValue", "getLossesValue", "drawsValue", "getDrawsValue", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MatchupViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    private LoadingImageViewDeck deckImage;
    private final TextView drawsValue;
    private final TextView gamesLabel;
    private final TextView gamesValue;
    private ConstraintLayout innerLayout;
    private final TextView lossesValue;
    private TextView matchupName;
    private LinearLayout rootLayout;
    private TextView winrateValue;
    private final TextView winsValue;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MatchupViewHolder(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View viewFindViewById = itemView.findViewById(R.id.root_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.rootLayout = (LinearLayout) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R.id.innerLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.innerLayout = (ConstraintLayout) viewFindViewById2;
        View viewFindViewById3 = itemView.findViewById(R.id.matchupName);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.matchupName = (TextView) viewFindViewById3;
        View viewFindViewById4 = itemView.findViewById(R.id.winrateValue);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.winrateValue = (TextView) viewFindViewById4;
        View viewFindViewById5 = itemView.findViewById(R.id.deckImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.deckImage = (LoadingImageViewDeck) viewFindViewById5;
        View viewFindViewById6 = itemView.findViewById(R.id.numGamesValueLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.gamesValue = (TextView) viewFindViewById6;
        View viewFindViewById7 = itemView.findViewById(R.id.numGamesLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.gamesLabel = (TextView) viewFindViewById7;
        View viewFindViewById8 = itemView.findViewById(R.id.numWinsValueLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.winsValue = (TextView) viewFindViewById8;
        View viewFindViewById9 = itemView.findViewById(R.id.numLossesValueLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        this.lossesValue = (TextView) viewFindViewById9;
        View viewFindViewById10 = itemView.findViewById(R.id.numDrawsValueLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        this.drawsValue = (TextView) viewFindViewById10;
    }

    public final LoadingImageViewDeck getDeckImage() {
        return this.deckImage;
    }

    public final TextView getDrawsValue() {
        return this.drawsValue;
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

    public final TextView getLossesValue() {
        return this.lossesValue;
    }

    public final TextView getMatchupName() {
        return this.matchupName;
    }

    public final LinearLayout getRootLayout() {
        return this.rootLayout;
    }

    public final TextView getWinrateValue() {
        return this.winrateValue;
    }

    public final TextView getWinsValue() {
        return this.winsValue;
    }

    public final void setDeckImage(LoadingImageViewDeck loadingImageViewDeck) {
        Intrinsics.checkNotNullParameter(loadingImageViewDeck, "<set-?>");
        this.deckImage = loadingImageViewDeck;
    }

    public final void setInnerLayout(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.innerLayout = constraintLayout;
    }

    public final void setMatchupName(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.matchupName = textView;
    }

    public final void setRootLayout(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.rootLayout = linearLayout;
    }

    public final void setWinrateValue(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.winrateValue = textView;
    }
}
