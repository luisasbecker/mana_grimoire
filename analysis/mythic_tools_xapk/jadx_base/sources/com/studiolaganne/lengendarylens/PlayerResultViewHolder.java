package com.studiolaganne.lengendarylens;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlayerResultsAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0018\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0011\u0010 \u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u0011\u0010\"\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\t¨\u0006$"}, d2 = {"Lcom/studiolaganne/lengendarylens/PlayerResultViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "rootLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getRootLayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "profileIconSummary", "Lcom/studiolaganne/lengendarylens/CachedImageView;", "getProfileIconSummary", "()Lcom/studiolaganne/lengendarylens/CachedImageView;", "noPhotoIconSummary", "Landroid/widget/ImageView;", "getNoPhotoIconSummary", "()Landroid/widget/ImageView;", "firstnameTextView", "Landroid/widget/TextView;", "getFirstnameTextView", "()Landroid/widget/TextView;", "usernameTextView", "getUsernameTextView", "resultTextView", "getResultTextView", "deckImage", "Lcom/studiolaganne/lengendarylens/LoadingImageViewDeck;", "getDeckImage", "()Lcom/studiolaganne/lengendarylens/LoadingImageViewDeck;", "deckName", "getDeckName", "editIconTextView", "getEditIconTextView", "rootLineLayout", "getRootLineLayout", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PlayerResultViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    private final LoadingImageViewDeck deckImage;
    private final TextView deckName;
    private final TextView editIconTextView;
    private final TextView firstnameTextView;
    private final ImageView noPhotoIconSummary;
    private final CachedImageView profileIconSummary;
    private final TextView resultTextView;
    private final ConstraintLayout rootLayout;
    private final ConstraintLayout rootLineLayout;
    private final TextView usernameTextView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayerResultViewHolder(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View viewFindViewById = itemView.findViewById(R.id.rootLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.rootLayout = (ConstraintLayout) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R.id.profileIconSummary);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.profileIconSummary = (CachedImageView) viewFindViewById2;
        View viewFindViewById3 = itemView.findViewById(R.id.noPhotoIconSummary);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.noPhotoIconSummary = (ImageView) viewFindViewById3;
        View viewFindViewById4 = itemView.findViewById(R.id.firstnameTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.firstnameTextView = (TextView) viewFindViewById4;
        View viewFindViewById5 = itemView.findViewById(R.id.usernameTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.usernameTextView = (TextView) viewFindViewById5;
        View viewFindViewById6 = itemView.findViewById(R.id.resultTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.resultTextView = (TextView) viewFindViewById6;
        View viewFindViewById7 = itemView.findViewById(R.id.deckImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.deckImage = (LoadingImageViewDeck) viewFindViewById7;
        View viewFindViewById8 = itemView.findViewById(R.id.deckName);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.deckName = (TextView) viewFindViewById8;
        View viewFindViewById9 = itemView.findViewById(R.id.editIconTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        this.editIconTextView = (TextView) viewFindViewById9;
        View viewFindViewById10 = itemView.findViewById(R.id.rootLineLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        this.rootLineLayout = (ConstraintLayout) viewFindViewById10;
    }

    public final LoadingImageViewDeck getDeckImage() {
        return this.deckImage;
    }

    public final TextView getDeckName() {
        return this.deckName;
    }

    public final TextView getEditIconTextView() {
        return this.editIconTextView;
    }

    public final TextView getFirstnameTextView() {
        return this.firstnameTextView;
    }

    public final ImageView getNoPhotoIconSummary() {
        return this.noPhotoIconSummary;
    }

    public final CachedImageView getProfileIconSummary() {
        return this.profileIconSummary;
    }

    public final TextView getResultTextView() {
        return this.resultTextView;
    }

    public final ConstraintLayout getRootLayout() {
        return this.rootLayout;
    }

    public final ConstraintLayout getRootLineLayout() {
        return this.rootLineLayout;
    }

    public final TextView getUsernameTextView() {
        return this.usernameTextView;
    }
}
