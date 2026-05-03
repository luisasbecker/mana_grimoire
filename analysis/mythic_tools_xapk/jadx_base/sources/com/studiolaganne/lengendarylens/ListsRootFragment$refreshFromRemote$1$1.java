package com.studiolaganne.lengendarylens;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: ListsRootFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/studiolaganne/lengendarylens/ListsRootFragment$refreshFromRemote$1$1", "Lretrofit2/Callback;", "Lcom/studiolaganne/lengendarylens/MTListsResponse;", "onResponse", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "response", "Lretrofit2/Response;", "onFailure", "t", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ListsRootFragment$refreshFromRemote$1$1 implements Callback<MTListsResponse> {
    final /* synthetic */ ListsRootFragment this$0;

    ListsRootFragment$refreshFromRemote$1$1(ListsRootFragment listsRootFragment) {
        this.this$0 = listsRootFragment;
    }

    static final Unit onFailure$lambda$1(ListsRootFragment listsRootFragment, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (listsRootFragment.getContext() == null || listsRootFragment._binding == null) {
            return Unit.INSTANCE;
        }
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    @Override // retrofit2.Callback
    public void onFailure(Call<MTListsResponse> call, Throwable t) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(t, "t");
        if (this.this$0.getContext() == null || this.this$0._binding == null) {
            return;
        }
        this.this$0.getBinding().overlay.setVisibility(8);
        this.this$0.getBinding().swipeRefreshLayout.setRefreshing(false);
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = this.this$0.getString(R.string.server_error);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder body = builder.setTitle(string).setBody("Error retrieving lists: " + t.getMessage());
        String string2 = this.this$0.getString(R.string.ok);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        final ListsRootFragment listsRootFragment = this.this$0;
        CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string2, new Function2() { // from class: com.studiolaganne.lengendarylens.ListsRootFragment$refreshFromRemote$1$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ListsRootFragment$refreshFromRemote$1$1.onFailure$lambda$1(listsRootFragment, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        positiveButton.show(childFragmentManager, "mtapi_error_dialog");
    }

    @Override // retrofit2.Callback
    public void onResponse(Call<MTListsResponse> call, Response<MTListsResponse> response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        if (this.this$0.getContext() == null || this.this$0._binding == null) {
            return;
        }
        this.this$0.getBinding().overlay.setVisibility(8);
        this.this$0.getBinding().swipeRefreshLayout.setRefreshing(false);
        if (response.isSuccessful()) {
            MTListsResponse mTListsResponseBody = response.body();
            MTUserLists lists = mTListsResponseBody != null ? mTListsResponseBody.getLists() : null;
            if (lists != null) {
                ListsRootFragment listsRootFragment = this.this$0;
                Context contextRequireContext = listsRootFragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                new PreferencesManager(contextRequireContext).saveCurrentUserLists(lists);
                listsRootFragment.updateUI(lists);
            }
        }
    }
}
