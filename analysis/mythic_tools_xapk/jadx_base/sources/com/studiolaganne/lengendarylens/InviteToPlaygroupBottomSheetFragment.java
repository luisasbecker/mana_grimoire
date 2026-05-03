package com.studiolaganne.lengendarylens;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.NativeProtocol;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InviteToPlaygroupBottomSheetFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/studiolaganne/lengendarylens/InviteToPlaygroupBottomSheetFragment;", "Lcom/studiolaganne/lengendarylens/TransparentBottomSheet;", "Lcom/studiolaganne/lengendarylens/FriendsListClickListener;", "callback", "Lcom/studiolaganne/lengendarylens/InviteToPlaygroupCallback;", NativeProtocol.AUDIENCE_FRIENDS, "", "Lcom/studiolaganne/lengendarylens/MTFriend;", "playgroup", "Lcom/studiolaganne/lengendarylens/MTPlaygroup;", "<init>", "(Lcom/studiolaganne/lengendarylens/InviteToPlaygroupCallback;Ljava/util/List;Lcom/studiolaganne/lengendarylens/MTPlaygroup;)V", "onFriendPending", "", "user", "onFriendRemove", "onFriendWaitDialog", "onFriendTap", "onFriendInvite", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InviteToPlaygroupBottomSheetFragment extends TransparentBottomSheet implements FriendsListClickListener {
    public static final String TAG = "InviteToPlaygroupBottomSheetFragment";
    private final InviteToPlaygroupCallback callback;
    private final List<MTFriend> friends;
    private final MTPlaygroup playgroup;
    public static final int $stable = 8;

    public InviteToPlaygroupBottomSheetFragment(InviteToPlaygroupCallback callback, List<MTFriend> friends, MTPlaygroup playgroup) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(friends, "friends");
        Intrinsics.checkNotNullParameter(playgroup, "playgroup");
        this.callback = callback;
        this.friends = friends;
        this.playgroup = playgroup;
    }

    static final Unit onViewCreated$lambda$0(InviteToPlaygroupBottomSheetFragment inviteToPlaygroupBottomSheetFragment) {
        inviteToPlaygroupBottomSheetFragment.dismiss();
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.bottom_sheet_invite_to_playgroup, container, false);
    }

    @Override // com.studiolaganne.lengendarylens.FriendsListClickListener
    public void onFriendInvite(MTFriend user) {
        Intrinsics.checkNotNullParameter(user, "user");
        dismiss();
        InviteToPlaygroupCallback inviteToPlaygroupCallback = this.callback;
        if (inviteToPlaygroupCallback != null) {
            inviteToPlaygroupCallback.onInviteToPlaygroup(user);
        }
    }

    @Override // com.studiolaganne.lengendarylens.FriendsListClickListener
    public void onFriendPending(MTFriend user) {
        Intrinsics.checkNotNullParameter(user, "user");
    }

    @Override // com.studiolaganne.lengendarylens.FriendsListClickListener
    public void onFriendRemove(MTFriend user) {
        Intrinsics.checkNotNullParameter(user, "user");
    }

    @Override // com.studiolaganne.lengendarylens.FriendsListClickListener
    public void onFriendTap(MTFriend user) {
        Intrinsics.checkNotNullParameter(user, "user");
    }

    @Override // com.studiolaganne.lengendarylens.FriendsListClickListener
    public void onFriendWaitDialog(MTFriend user) {
        Intrinsics.checkNotNullParameter(user, "user");
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View viewFindViewById = view.findViewById(R.id.chevron_down);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById, new Function0() { // from class: com.studiolaganne.lengendarylens.InviteToPlaygroupBottomSheetFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return InviteToPlaygroupBottomSheetFragment.onViewCreated$lambda$0(this.f$0);
            }
        });
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.friendsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        recyclerView.setAdapter(new FriendsListAdapter(this.friends, this, true, this.playgroup));
        if (this.friends.isEmpty()) {
            ((TextView) view.findViewById(R.id.noFriendsTextView)).setVisibility(0);
        } else {
            ((TextView) view.findViewById(R.id.noFriendsTextView)).setVisibility(8);
        }
    }
}
