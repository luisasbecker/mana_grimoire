package com.studiolaganne.lengendarylens;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlaygroupsAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0012\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0011\u0010\u001e\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0011\u0010 \u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0011\u0010\"\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010&\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017R\u0011\u0010(\u001a\u00020)¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lcom/studiolaganne/lengendarylens/PlaygroupViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "clickListener", "Lcom/studiolaganne/lengendarylens/PlaygroupsClickListener;", "<init>", "(Landroid/view/View;Lcom/studiolaganne/lengendarylens/PlaygroupsClickListener;)V", "getClickListener", "()Lcom/studiolaganne/lengendarylens/PlaygroupsClickListener;", "rootLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getRootLayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setRootLayout", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "profileIcon", "getProfileIcon", "notificationsView", "getNotificationsView", "notificationCount", "Landroid/widget/TextView;", "getNotificationCount", "()Landroid/widget/TextView;", "profileImage", "Lcom/studiolaganne/lengendarylens/CachedImageView;", "getProfileImage", "()Lcom/studiolaganne/lengendarylens/CachedImageView;", "playgroupName", "getPlaygroupName", "playgroupDescription", "getPlaygroupDescription", "usersCount", "getUsersCount", "defaultProfileImage", "Landroid/widget/ImageView;", "getDefaultProfileImage", "()Landroid/widget/ImageView;", "pendingText", "getPendingText", "usersRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getUsersRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PlaygroupViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    private final PlaygroupsClickListener clickListener;
    private final ImageView defaultProfileImage;
    private final TextView notificationCount;
    private final ConstraintLayout notificationsView;
    private final TextView pendingText;
    private final TextView playgroupDescription;
    private final TextView playgroupName;
    private final ConstraintLayout profileIcon;
    private final CachedImageView profileImage;
    private ConstraintLayout rootLayout;
    private final TextView usersCount;
    private final RecyclerView usersRecyclerView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlaygroupViewHolder(View itemView, PlaygroupsClickListener clickListener) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.clickListener = clickListener;
        View viewFindViewById = itemView.findViewById(R.id.root_layout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.rootLayout = (ConstraintLayout) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R.id.profileIcon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.profileIcon = (ConstraintLayout) viewFindViewById2;
        View viewFindViewById3 = itemView.findViewById(R.id.messageBubbleLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.notificationsView = (ConstraintLayout) viewFindViewById3;
        View viewFindViewById4 = itemView.findViewById(R.id.notificationCount);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.notificationCount = (TextView) viewFindViewById4;
        View viewFindViewById5 = itemView.findViewById(R.id.profileImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.profileImage = (CachedImageView) viewFindViewById5;
        View viewFindViewById6 = itemView.findViewById(R.id.playgroupName);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.playgroupName = (TextView) viewFindViewById6;
        View viewFindViewById7 = itemView.findViewById(R.id.playgroupDescription);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.playgroupDescription = (TextView) viewFindViewById7;
        View viewFindViewById8 = itemView.findViewById(R.id.usersCount);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.usersCount = (TextView) viewFindViewById8;
        View viewFindViewById9 = itemView.findViewById(R.id.defaultProfileImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        this.defaultProfileImage = (ImageView) viewFindViewById9;
        View viewFindViewById10 = itemView.findViewById(R.id.pendingText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        this.pendingText = (TextView) viewFindViewById10;
        View viewFindViewById11 = itemView.findViewById(R.id.usersRecyclerView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        this.usersRecyclerView = (RecyclerView) viewFindViewById11;
    }

    public final PlaygroupsClickListener getClickListener() {
        return this.clickListener;
    }

    public final ImageView getDefaultProfileImage() {
        return this.defaultProfileImage;
    }

    public final TextView getNotificationCount() {
        return this.notificationCount;
    }

    public final ConstraintLayout getNotificationsView() {
        return this.notificationsView;
    }

    public final TextView getPendingText() {
        return this.pendingText;
    }

    public final TextView getPlaygroupDescription() {
        return this.playgroupDescription;
    }

    public final TextView getPlaygroupName() {
        return this.playgroupName;
    }

    public final ConstraintLayout getProfileIcon() {
        return this.profileIcon;
    }

    public final CachedImageView getProfileImage() {
        return this.profileImage;
    }

    public final ConstraintLayout getRootLayout() {
        return this.rootLayout;
    }

    public final TextView getUsersCount() {
        return this.usersCount;
    }

    public final RecyclerView getUsersRecyclerView() {
        return this.usersRecyclerView;
    }

    public final void setRootLayout(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.rootLayout = constraintLayout;
    }
}
