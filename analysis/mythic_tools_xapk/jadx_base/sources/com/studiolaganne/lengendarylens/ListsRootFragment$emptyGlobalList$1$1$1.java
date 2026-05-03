package com.studiolaganne.lengendarylens;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: ListsRootFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/studiolaganne/lengendarylens/ListsRootFragment$emptyGlobalList$1$1$1", "Lretrofit2/Callback;", "Lcom/studiolaganne/lengendarylens/MTCardListResponse;", "onResponse", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "response", "Lretrofit2/Response;", "onFailure", "t", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ListsRootFragment$emptyGlobalList$1$1$1 implements Callback<MTCardListResponse> {
    final /* synthetic */ MTCardContainer $container;
    final /* synthetic */ ConstraintLayout $overlay;
    final /* synthetic */ ListsRootFragment this$0;

    ListsRootFragment$emptyGlobalList$1$1$1(ListsRootFragment listsRootFragment, ConstraintLayout constraintLayout, MTCardContainer mTCardContainer) {
        this.this$0 = listsRootFragment;
        this.$overlay = constraintLayout;
        this.$container = mTCardContainer;
    }

    static final Unit onFailure$lambda$1(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [T, com.studiolaganne.lengendarylens.MTUserLists] */
    public static final Unit onResponse$lambda$0$1(Ref.ObjectRef objectRef, MTCardContainer mTCardContainer) {
        objectRef.element = new MTUserLists(CollectionsKt.mutableListOf(mTCardContainer), new ArrayList());
        return Unit.INSTANCE;
    }

    @Override // retrofit2.Callback
    public void onFailure(Call<MTCardListResponse> call, Throwable t) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(t, "t");
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = this.this$0.getString(R.string.server_error);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder body = builder.setTitle(string).setBody("Error emptying list: " + t.getMessage());
        String string2 = this.this$0.getString(R.string.ok);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string2, new Function2() { // from class: com.studiolaganne.lengendarylens.ListsRootFragment$emptyGlobalList$1$1$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ListsRootFragment$emptyGlobalList$1$1$1.onFailure$lambda$1(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        positiveButton.show(childFragmentManager, "mtapi_error_dialog");
        this.$overlay.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [T, com.studiolaganne.lengendarylens.MTUserLists] */
    @Override // retrofit2.Callback
    public void onResponse(Call<MTCardListResponse> call, Response<MTCardListResponse> response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.isSuccessful()) {
            MTCardListResponse mTCardListResponseBody = response.body();
            final MTCardContainer list = mTCardListResponseBody != null ? mTCardListResponseBody.getList() : null;
            if (list != null) {
                ListsRootFragment listsRootFragment = this.this$0;
                MTCardContainer mTCardContainer = this.$container;
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = listsRootFragment.getLists();
                MTUserLists mTUserLists = (MTUserLists) objectRef.element;
                if (mTUserLists != null) {
                    List<MTCardContainer> global = mTUserLists.getGlobal();
                    int i = 0;
                    if (global != null) {
                        Iterator<MTCardContainer> it = global.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                i = -1;
                                break;
                            } else if (it.next().getId() == mTCardContainer.getId()) {
                                break;
                            } else {
                                i++;
                            }
                        }
                        if (i != -1) {
                            global.set(i, list);
                        } else {
                            global.add(list);
                        }
                    } else {
                        mTUserLists.setGlobal(CollectionsKt.mutableListOf(list));
                    }
                } else {
                    new Function0() { // from class: com.studiolaganne.lengendarylens.ListsRootFragment$emptyGlobalList$1$1$1$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ListsRootFragment$emptyGlobalList$1$1$1.onResponse$lambda$0$1(objectRef, list);
                        }
                    };
                }
                listsRootFragment.setLists((MTUserLists) objectRef.element);
                Context contextRequireContext = listsRootFragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
                MTUserLists lists = listsRootFragment.getLists();
                if (lists != null) {
                    preferencesManager.saveCurrentUserLists(lists);
                    preferencesManager.incrementContainerVersion(mTCardContainer.getId());
                }
                if (mTCardContainer.getId() == 1) {
                    preferencesManager.clearRecentCardsNew();
                    preferencesManager.clearRecentCardsOld();
                }
            }
            this.this$0.refreshUILocal();
            this.$overlay.setVisibility(8);
        }
    }
}
