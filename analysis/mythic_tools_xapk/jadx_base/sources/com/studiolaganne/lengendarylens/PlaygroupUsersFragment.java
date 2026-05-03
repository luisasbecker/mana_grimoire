package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.studiolaganne.lengendarylens.databinding.FragmentPlaygroupUsersBinding;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlaygroupUsersFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 )2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001)B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J&\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u000e\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\fR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/studiolaganne/lengendarylens/PlaygroupUsersFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/studiolaganne/lengendarylens/InviteToPlaygroupCallback;", "Lcom/studiolaganne/lengendarylens/PlaygroupUserClickListener;", "<init>", "()V", "_binding", "Lcom/studiolaganne/lengendarylens/databinding/FragmentPlaygroupUsersBinding;", "binding", "getBinding", "()Lcom/studiolaganne/lengendarylens/databinding/FragmentPlaygroupUsersBinding;", "currentPlaygroup", "Lcom/studiolaganne/lengendarylens/MTPlaygroup;", "parentActivity", "Lcom/studiolaganne/lengendarylens/PlaygroupDetailsActivity;", "onUserFriendRequest", "", "user", "Lcom/studiolaganne/lengendarylens/MTUser;", "onUserLeave", "onUserPending", "onUserRemove", "onUserAdminPromote", "onUserAdminRemove", "onTransferOwnership", "onInviteToPlaygroup", "Lcom/studiolaganne/lengendarylens/MTFriend;", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "updateUI", "newPlaygroup", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PlaygroupUsersFragment extends Fragment implements InviteToPlaygroupCallback, PlaygroupUserClickListener {
    private FragmentPlaygroupUsersBinding _binding;
    private MTPlaygroup currentPlaygroup;
    private PlaygroupDetailsActivity parentActivity;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: PlaygroupUsersFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/studiolaganne/lengendarylens/PlaygroupUsersFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/studiolaganne/lengendarylens/PlaygroupUsersFragment;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final PlaygroupUsersFragment newInstance() {
            PlaygroupUsersFragment playgroupUsersFragment = new PlaygroupUsersFragment();
            playgroupUsersFragment.setArguments(new Bundle());
            return playgroupUsersFragment;
        }
    }

    @JvmStatic
    public static final PlaygroupUsersFragment newInstance() {
        return INSTANCE.newInstance();
    }

    static final Unit onCreateView$lambda$1(PreferencesManager preferencesManager, PlaygroupUsersFragment playgroupUsersFragment) {
        List<MTFriend> currentUserFriends = preferencesManager.getCurrentUserFriends();
        ArrayList arrayList = new ArrayList();
        for (Object obj : currentUserFriends) {
            if (!Intrinsics.areEqual(((MTFriend) obj).getStatus(), "pending")) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        MTPlaygroup mTPlaygroup = playgroupUsersFragment.currentPlaygroup;
        if (mTPlaygroup != null) {
            new InviteToPlaygroupBottomSheetFragment(playgroupUsersFragment, arrayList2, mTPlaygroup).show(playgroupUsersFragment.getChildFragmentManager(), InviteToPlaygroupBottomSheetFragment.TAG);
        }
        return Unit.INSTANCE;
    }

    public final FragmentPlaygroupUsersBinding getBinding() {
        FragmentPlaygroupUsersBinding fragmentPlaygroupUsersBinding = this._binding;
        Intrinsics.checkNotNull(fragmentPlaygroupUsersBinding);
        return fragmentPlaygroupUsersBinding;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        try {
            FragmentActivity activity = getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.studiolaganne.lengendarylens.PlaygroupDetailsActivity");
            this.parentActivity = (PlaygroupDetailsActivity) activity;
        } catch (ClassCastException unused) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        Object next;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            int i = arguments.getInt("playgroupId");
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
            if (preferencesManager.getCurrentUser() != null) {
                Iterator<T> it = preferencesManager.getCurrentUserPlaygroups().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it.next();
                        if (((MTPlaygroup) next).getId() == i) {
                            break;
                        }
                    }
                }
                this.currentPlaygroup = (MTPlaygroup) next;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentPlaygroupUsersBinding.inflate(inflater, container, false);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        MTUser currentUser = preferencesManager.getCurrentUser();
        ConstraintLayout inviteButtonLayout = getBinding().inviteButtonLayout;
        Intrinsics.checkNotNullExpressionValue(inviteButtonLayout, "inviteButtonLayout");
        inviteButtonLayout.setVisibility(8);
        MTPlaygroup mTPlaygroup = this.currentPlaygroup;
        if (mTPlaygroup != null) {
            if (CollectionsKt.contains(mTPlaygroup.getAdmins(), currentUser != null ? Integer.valueOf(currentUser.getId()) : null)) {
                inviteButtonLayout.setVisibility(0);
            }
            updateUI(mTPlaygroup);
        }
        ViewExtensionsKt.setOnClickWithFade(inviteButtonLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.PlaygroupUsersFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PlaygroupUsersFragment.onCreateView$lambda$1(preferencesManager, this);
            }
        });
        return getBinding().getRoot();
    }

    @Override // com.studiolaganne.lengendarylens.InviteToPlaygroupCallback
    public void onInviteToPlaygroup(MTFriend user) {
        Intrinsics.checkNotNullParameter(user, "user");
        PlaygroupDetailsActivity playgroupDetailsActivity = this.parentActivity;
        if (playgroupDetailsActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parentActivity");
            playgroupDetailsActivity = null;
        }
        playgroupDetailsActivity.onInviteToPlaygroup(user);
    }

    @Override // com.studiolaganne.lengendarylens.PlaygroupUserClickListener
    public void onTransferOwnership(MTUser user) {
        Intrinsics.checkNotNullParameter(user, "user");
        PlaygroupDetailsActivity playgroupDetailsActivity = this.parentActivity;
        if (playgroupDetailsActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parentActivity");
            playgroupDetailsActivity = null;
        }
        playgroupDetailsActivity.onTransferOwnership(user);
    }

    @Override // com.studiolaganne.lengendarylens.PlaygroupUserClickListener
    public void onUserAdminPromote(MTUser user) {
        Intrinsics.checkNotNullParameter(user, "user");
        PlaygroupDetailsActivity playgroupDetailsActivity = this.parentActivity;
        if (playgroupDetailsActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parentActivity");
            playgroupDetailsActivity = null;
        }
        playgroupDetailsActivity.onUserAdminPromote(user);
    }

    @Override // com.studiolaganne.lengendarylens.PlaygroupUserClickListener
    public void onUserAdminRemove(MTUser user) {
        Intrinsics.checkNotNullParameter(user, "user");
        PlaygroupDetailsActivity playgroupDetailsActivity = this.parentActivity;
        if (playgroupDetailsActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parentActivity");
            playgroupDetailsActivity = null;
        }
        playgroupDetailsActivity.onUserAdminRemove(user);
    }

    @Override // com.studiolaganne.lengendarylens.PlaygroupUserClickListener
    public void onUserFriendRequest(MTUser user) {
        Intrinsics.checkNotNullParameter(user, "user");
        PlaygroupDetailsActivity playgroupDetailsActivity = this.parentActivity;
        if (playgroupDetailsActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parentActivity");
            playgroupDetailsActivity = null;
        }
        playgroupDetailsActivity.onUserFriendRequest(user);
    }

    @Override // com.studiolaganne.lengendarylens.PlaygroupUserClickListener
    public void onUserLeave(MTUser user) {
        Intrinsics.checkNotNullParameter(user, "user");
        PlaygroupDetailsActivity playgroupDetailsActivity = this.parentActivity;
        if (playgroupDetailsActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parentActivity");
            playgroupDetailsActivity = null;
        }
        playgroupDetailsActivity.onUserLeave(user);
    }

    @Override // com.studiolaganne.lengendarylens.PlaygroupUserClickListener
    public void onUserPending(MTUser user) {
        Intrinsics.checkNotNullParameter(user, "user");
        PlaygroupDetailsActivity playgroupDetailsActivity = this.parentActivity;
        if (playgroupDetailsActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parentActivity");
            playgroupDetailsActivity = null;
        }
        playgroupDetailsActivity.onUserPending(user);
    }

    @Override // com.studiolaganne.lengendarylens.PlaygroupUserClickListener
    public void onUserRemove(MTUser user) {
        Intrinsics.checkNotNullParameter(user, "user");
        PlaygroupDetailsActivity playgroupDetailsActivity = this.parentActivity;
        if (playgroupDetailsActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("parentActivity");
            playgroupDetailsActivity = null;
        }
        playgroupDetailsActivity.onUserRemove(user);
    }

    public final void updateUI(MTPlaygroup newPlaygroup) {
        Intrinsics.checkNotNullParameter(newPlaygroup, "newPlaygroup");
        if (getContext() == null) {
            return;
        }
        this.currentPlaygroup = newPlaygroup;
        RecyclerView membersRecyclerView = getBinding().membersRecyclerView;
        Intrinsics.checkNotNullExpressionValue(membersRecyclerView, "membersRecyclerView");
        membersRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        MTPlaygroup mTPlaygroup = this.currentPlaygroup;
        if (mTPlaygroup == null || currentUser == null) {
            return;
        }
        membersRecyclerView.setAdapter(new PlaygroupUsersAdapter(mTPlaygroup.getUsers(), currentUser, mTPlaygroup.getAdmins(), mTPlaygroup.getOwner(), this));
    }
}
