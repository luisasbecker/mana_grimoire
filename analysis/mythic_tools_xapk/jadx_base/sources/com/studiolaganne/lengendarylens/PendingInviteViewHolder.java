package com.studiolaganne.lengendarylens;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SharedCollectionsActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\tR\u0011\u0010\u0012\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0014\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\tR\u0011\u0010\u0016\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\tR\u0011\u0010\u0018\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/studiolaganne/lengendarylens/PendingInviteViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inviteLabel", "Landroid/widget/TextView;", "getInviteLabel", "()Landroid/widget/TextView;", "otherPartyName", "getOtherPartyName", "participantsContainer", "Landroid/widget/LinearLayout;", "getParticipantsContainer", "()Landroid/widget/LinearLayout;", "statusText", "getStatusText", "actionsRow", "getActionsRow", "acceptButton", "getAcceptButton", "rejectButton", "getRejectButton", "cancelInviteButton", "getCancelInviteButton", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PendingInviteViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    private final TextView acceptButton;
    private final LinearLayout actionsRow;
    private final TextView cancelInviteButton;
    private final TextView inviteLabel;
    private final TextView otherPartyName;
    private final LinearLayout participantsContainer;
    private final TextView rejectButton;
    private final TextView statusText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PendingInviteViewHolder(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View viewFindViewById = itemView.findViewById(R.id.inviteLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.inviteLabel = (TextView) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R.id.otherPartyName);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.otherPartyName = (TextView) viewFindViewById2;
        View viewFindViewById3 = itemView.findViewById(R.id.participantsContainer);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.participantsContainer = (LinearLayout) viewFindViewById3;
        View viewFindViewById4 = itemView.findViewById(R.id.statusText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.statusText = (TextView) viewFindViewById4;
        View viewFindViewById5 = itemView.findViewById(R.id.actionsRow);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.actionsRow = (LinearLayout) viewFindViewById5;
        View viewFindViewById6 = itemView.findViewById(R.id.acceptButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.acceptButton = (TextView) viewFindViewById6;
        View viewFindViewById7 = itemView.findViewById(R.id.rejectButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.rejectButton = (TextView) viewFindViewById7;
        View viewFindViewById8 = itemView.findViewById(R.id.cancelInviteButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.cancelInviteButton = (TextView) viewFindViewById8;
    }

    public final TextView getAcceptButton() {
        return this.acceptButton;
    }

    public final LinearLayout getActionsRow() {
        return this.actionsRow;
    }

    public final TextView getCancelInviteButton() {
        return this.cancelInviteButton;
    }

    public final TextView getInviteLabel() {
        return this.inviteLabel;
    }

    public final TextView getOtherPartyName() {
        return this.otherPartyName;
    }

    public final LinearLayout getParticipantsContainer() {
        return this.participantsContainer;
    }

    public final TextView getRejectButton() {
        return this.rejectButton;
    }

    public final TextView getStatusText() {
        return this.statusText;
    }
}
