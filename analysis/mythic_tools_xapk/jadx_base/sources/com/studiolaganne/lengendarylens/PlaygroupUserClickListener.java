package com.studiolaganne.lengendarylens;

import kotlin.Metadata;

/* JADX INFO: compiled from: PlaygroupUsersAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/studiolaganne/lengendarylens/PlaygroupUserClickListener;", "", "onUserFriendRequest", "", "user", "Lcom/studiolaganne/lengendarylens/MTUser;", "onUserRemove", "onUserLeave", "onUserPending", "onUserAdminPromote", "onUserAdminRemove", "onTransferOwnership", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface PlaygroupUserClickListener {
    void onTransferOwnership(MTUser user);

    void onUserAdminPromote(MTUser user);

    void onUserAdminRemove(MTUser user);

    void onUserFriendRequest(MTUser user);

    void onUserLeave(MTUser user);

    void onUserPending(MTUser user);

    void onUserRemove(MTUser user);
}
