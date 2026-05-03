package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.studiolaganne.lengendarylens.databinding.FragmentUserListsBinding;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: UserListsFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J$\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0010\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001c\u001a\u00020\u000fH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/studiolaganne/lengendarylens/UserListsFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/studiolaganne/lengendarylens/CardContainerClickListener;", "<init>", "()V", "_binding", "Lcom/studiolaganne/lengendarylens/databinding/FragmentUserListsBinding;", "binding", "getBinding", "()Lcom/studiolaganne/lengendarylens/databinding/FragmentUserListsBinding;", "userId", "", "currentUser", "Lcom/studiolaganne/lengendarylens/MTUser;", "onCardContainerClick", "", "container", "Lcom/studiolaganne/lengendarylens/MTCardContainer;", "onCardContainerDotsClick", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "onDestroyView", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UserListsFragment extends Fragment implements CardContainerClickListener {
    public static final int $stable = 8;
    private FragmentUserListsBinding _binding;
    private MTUser currentUser;
    private int userId = -1;

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentUserListsBinding getBinding() {
        FragmentUserListsBinding fragmentUserListsBinding = this._binding;
        Intrinsics.checkNotNull(fragmentUserListsBinding);
        return fragmentUserListsBinding;
    }

    @Override // com.studiolaganne.lengendarylens.CardContainerClickListener
    public void onCardContainerClick(MTCardContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        GenericFragmentActivityKt.launchBrowseListFragment$default(contextRequireContext, container.getId(), null, Integer.valueOf(this.userId), 4, null);
    }

    @Override // com.studiolaganne.lengendarylens.CardContainerClickListener
    public void onCardContainerDotsClick(MTCardContainer container, View view) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.userId = arguments.getInt("userId");
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            this.currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentUserListsBinding.inflate(inflater, container, false);
        getBinding().loadingAnimationViewRecyclerView.setVisibility(0);
        getBinding().noListsText.setVisibility(8);
        getBinding().listsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        MTUser mTUser = this.currentUser;
        if (mTUser != null) {
            MTApiKt.getMtApi().getUserLists(mTUser.getId(), this.userId).enqueue(new Callback<MTListsResponse>() { // from class: com.studiolaganne.lengendarylens.UserListsFragment$onCreateView$1$1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTListsResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    if (this.this$0.getContext() == null || this.this$0._binding == null) {
                        return;
                    }
                    this.this$0.getBinding().loadingAnimationViewRecyclerView.setVisibility(8);
                    this.this$0.getBinding().noListsText.setVisibility(0);
                    Log.e("UserListsFragment", "Error fetching user lists: " + t.getMessage());
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTListsResponse> call, Response<MTListsResponse> response) {
                    MTUserLists lists;
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (this.this$0.getContext() == null || this.this$0._binding == null) {
                        return;
                    }
                    this.this$0.getBinding().loadingAnimationViewRecyclerView.setVisibility(8);
                    if (!response.isSuccessful()) {
                        ResponseBody responseBodyErrorBody = response.errorBody();
                        Log.e("UserListsFragment", "Error fetching user lists: " + (responseBodyErrorBody != null ? responseBodyErrorBody.string() : null));
                        this.this$0.getBinding().noListsText.setVisibility(0);
                        return;
                    }
                    MTListsResponse mTListsResponseBody = response.body();
                    if (mTListsResponseBody == null || (lists = mTListsResponseBody.getLists()) == null) {
                        this.this$0.getBinding().noListsText.setVisibility(0);
                        return;
                    }
                    UserListsFragment userListsFragment = this.this$0;
                    ArrayList arrayList = new ArrayList();
                    List<MTCardContainer> global = lists.getGlobal();
                    if (global != null) {
                        Iterator<T> it = global.iterator();
                        while (it.hasNext()) {
                            arrayList.add(new CardContainerItemHolder(1, (MTCardContainer) it.next(), null, 4, null));
                        }
                    }
                    List<MTCardContainer> user = lists.getUser();
                    if (user != null) {
                        Iterator<T> it2 = user.iterator();
                        while (it2.hasNext()) {
                            arrayList.add(new CardContainerItemHolder(1, (MTCardContainer) it2.next(), null, 4, null));
                        }
                    }
                    if (arrayList.isEmpty()) {
                        userListsFragment.getBinding().noListsText.setVisibility(0);
                    } else {
                        userListsFragment.getBinding().listsRecyclerView.setAdapter(new CardContainerAdapter(arrayList, userListsFragment, false));
                    }
                }
            });
        }
        LinearLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }
}
