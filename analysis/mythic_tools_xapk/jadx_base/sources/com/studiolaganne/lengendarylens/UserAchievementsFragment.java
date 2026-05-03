package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import com.studiolaganne.lengendarylens.TrophyDetailsDialogFragment;
import com.studiolaganne.lengendarylens.databinding.FragmentUserAchievementsBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: UserAchievementsFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001$B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012H\u0016J\u0012\u0010\u001a\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0006\u0010#\u001a\u00020\u0018R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006%"}, d2 = {"Lcom/studiolaganne/lengendarylens/UserAchievementsFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/studiolaganne/lengendarylens/TrophiesClickListener;", "<init>", "()V", "_binding", "Lcom/studiolaganne/lengendarylens/databinding/FragmentUserAchievementsBinding;", "binding", "getBinding", "()Lcom/studiolaganne/lengendarylens/databinding/FragmentUserAchievementsBinding;", "isCurrentUser", "", "userId", "", "currentUser", "Lcom/studiolaganne/lengendarylens/MTUser;", "trophies", "", "Lcom/studiolaganne/lengendarylens/MTTrophy;", "getTrophies", "()Ljava/util/List;", "setTrophies", "(Ljava/util/List;)V", "onTrophyClick", "", "trophy", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "updateTrophies", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UserAchievementsFragment extends Fragment implements TrophiesClickListener {
    private FragmentUserAchievementsBinding _binding;
    private MTUser currentUser;
    private boolean isCurrentUser;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private int userId = -1;
    private List<MTTrophy> trophies = CollectionsKt.emptyList();

    /* JADX INFO: compiled from: UserAchievementsFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/studiolaganne/lengendarylens/UserAchievementsFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/studiolaganne/lengendarylens/UserAchievementsFragment;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final UserAchievementsFragment newInstance() {
            UserAchievementsFragment userAchievementsFragment = new UserAchievementsFragment();
            userAchievementsFragment.setArguments(new Bundle());
            return userAchievementsFragment;
        }
    }

    @JvmStatic
    public static final UserAchievementsFragment newInstance() {
        return INSTANCE.newInstance();
    }

    public final FragmentUserAchievementsBinding getBinding() {
        FragmentUserAchievementsBinding fragmentUserAchievementsBinding = this._binding;
        Intrinsics.checkNotNull(fragmentUserAchievementsBinding);
        return fragmentUserAchievementsBinding;
    }

    public final List<MTTrophy> getTrophies() {
        return this.trophies;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.userId = arguments.getInt("userId");
            this.isCurrentUser = false;
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
            if (currentUser != null) {
                this.currentUser = currentUser;
                if (currentUser.getId() == this.userId) {
                    this.isCurrentUser = true;
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentUserAchievementsBinding.inflate(inflater, container, false);
        updateTrophies();
        return getBinding().getRoot();
    }

    @Override // com.studiolaganne.lengendarylens.TrophiesClickListener
    public void onTrophyClick(MTTrophy trophy) {
        Intrinsics.checkNotNullParameter(trophy, "trophy");
        TrophyDetailsDialogFragment.Builder currentIndex = new TrophyDetailsDialogFragment.Builder().setTrophies(this.trophies).setCurrentIndex(this.trophies.indexOf(trophy));
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        currentIndex.show(childFragmentManager);
    }

    public final void setTrophies(List<MTTrophy> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.trophies = list;
    }

    public final void updateTrophies() {
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        if (!this.isCurrentUser) {
            getBinding().loadingAnimationViewRecyclerView.setVisibility(0);
            getBinding().loadingAnimationViewRecyclerView.playAnimation();
            getBinding().medalsRecyclerView.setVisibility(8);
            getBinding().noMedalsTextView.setVisibility(8);
            Context contextRequireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
            MTUser currentUser = new PreferencesManager(contextRequireContext2).getCurrentUser();
            if (currentUser != null) {
                MTApiKt.getMtApi().getUserById(currentUser.getId(), this.userId).enqueue(new Callback<MTUserResponse>() { // from class: com.studiolaganne.lengendarylens.UserAchievementsFragment$updateTrophies$1$1
                    @Override // retrofit2.Callback
                    public void onFailure(Call<MTUserResponse> call, Throwable t) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(t, "t");
                        if (this.this$0.getContext() == null || !this.this$0.isAdded() || this.this$0._binding == null) {
                            return;
                        }
                        this.this$0.getBinding().loadingAnimationViewRecyclerView.setVisibility(8);
                        this.this$0.getBinding().medalsRecyclerView.setVisibility(8);
                        this.this$0.getBinding().noMedalsTextView.setVisibility(0);
                        this.this$0.getBinding().noMedalsTextView.setText(this.this$0.getString(R.string.no_medals_yet_friend));
                    }

                    @Override // retrofit2.Callback
                    public void onResponse(Call<MTUserResponse> call, Response<MTUserResponse> response) {
                        List<MTTrophy> listEmptyList;
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(response, "response");
                        if (!response.isSuccessful() || this.this$0.getContext() == null || !this.this$0.isAdded() || this.this$0._binding == null) {
                            return;
                        }
                        this.this$0.getBinding().loadingAnimationViewRecyclerView.setVisibility(8);
                        MTUserResponse mTUserResponseBody = response.body();
                        if (mTUserResponseBody == null || (listEmptyList = mTUserResponseBody.getTrophies()) == null) {
                            listEmptyList = CollectionsKt.emptyList();
                        }
                        this.this$0.setTrophies(listEmptyList);
                        this.this$0.getBinding().medalsRecyclerView.setVisibility(0);
                        this.this$0.getBinding().noMedalsTextView.setVisibility(8);
                        this.this$0.getBinding().medalsRecyclerView.setLayoutManager(new GridLayoutManager(this.this$0.requireContext(), 3));
                        this.this$0.getBinding().medalsRecyclerView.setAdapter(new TrophiesAdapter(listEmptyList, this.this$0));
                        if (listEmptyList.isEmpty()) {
                            this.this$0.getBinding().noMedalsTextView.setText(this.this$0.getString(R.string.no_medals_yet_friend));
                            this.this$0.getBinding().noMedalsTextView.setVisibility(0);
                        }
                    }
                });
                return;
            }
            return;
        }
        List<MTTrophy> currentUserTrophies = preferencesManager.getCurrentUserTrophies();
        this.trophies = currentUserTrophies;
        getBinding().medalsRecyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 3));
        getBinding().medalsRecyclerView.setAdapter(new TrophiesAdapter(currentUserTrophies, this));
        if (!currentUserTrophies.isEmpty()) {
            getBinding().medalsRecyclerView.setVisibility(0);
            getBinding().noMedalsTextView.setVisibility(8);
        } else {
            getBinding().medalsRecyclerView.setVisibility(8);
            getBinding().noMedalsTextView.setText(getString(R.string.no_medals_yet));
            getBinding().noMedalsTextView.setVisibility(0);
        }
    }
}
