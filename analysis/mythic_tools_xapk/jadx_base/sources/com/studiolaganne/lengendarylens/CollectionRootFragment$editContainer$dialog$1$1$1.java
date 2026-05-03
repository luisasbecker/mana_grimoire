package com.studiolaganne.lengendarylens;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: CollectionRootFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/studiolaganne/lengendarylens/CollectionRootFragment$editContainer$dialog$1$1$1", "Lretrofit2/Callback;", "Lcom/studiolaganne/lengendarylens/MTCardListResponse;", "onResponse", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "response", "Lretrofit2/Response;", "onFailure", "t", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CollectionRootFragment$editContainer$dialog$1$1$1 implements Callback<MTCardListResponse> {
    final /* synthetic */ MTCardContainer $container;
    final /* synthetic */ ConstraintLayout $overlay;
    final /* synthetic */ boolean $wasConverted;
    final /* synthetic */ CollectionRootFragment this$0;

    CollectionRootFragment$editContainer$dialog$1$1$1(CollectionRootFragment collectionRootFragment, ConstraintLayout constraintLayout, boolean z, MTCardContainer mTCardContainer) {
        this.this$0 = collectionRootFragment;
        this.$overlay = constraintLayout;
        this.$wasConverted = z;
        this.$container = mTCardContainer;
    }

    static final Unit onFailure$lambda$1(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    @Override // retrofit2.Callback
    public void onFailure(Call<MTCardListResponse> call, Throwable t) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(t, "t");
        if (this.this$0.getContext() == null || this.this$0._binding == null) {
            return;
        }
        this.$overlay.setVisibility(8);
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = this.this$0.getString(R.string.server_error);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder body = builder.setTitle(string).setBody("Error updating list: " + t.getMessage());
        String string2 = this.this$0.getString(R.string.ok);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string2, new Function2() { // from class: com.studiolaganne.lengendarylens.CollectionRootFragment$editContainer$dialog$1$1$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return CollectionRootFragment$editContainer$dialog$1$1$1.onFailure$lambda$1(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        positiveButton.show(childFragmentManager, "mtapi_error_dialog");
    }

    @Override // retrofit2.Callback
    public void onResponse(Call<MTCardListResponse> call, Response<MTCardListResponse> response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        if (this.this$0.getContext() == null || this.this$0._binding == null) {
            return;
        }
        this.$overlay.setVisibility(8);
        if (response.isSuccessful()) {
            if (this.$wasConverted) {
                this.this$0.refreshFromRemote();
                Context contextRequireContext = this.this$0.requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                new PreferencesManager(contextRequireContext).incrementListsVersion();
                return;
            }
            MTCardListResponse mTCardListResponseBody = response.body();
            MTCardContainer list = mTCardListResponseBody != null ? mTCardListResponseBody.getList() : null;
            if (list != null) {
                CollectionRootFragment collectionRootFragment = this.this$0;
                MTCardContainer mTCardContainer = this.$container;
                MTCollection collection = collectionRootFragment.getCollection();
                if (collection != null) {
                    List<MTCardContainer> boxes = collection.getBoxes();
                    int i = 0;
                    if (boxes != null) {
                        Iterator<MTCardContainer> it = boxes.iterator();
                        int i2 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                i2 = -1;
                                break;
                            } else if (it.next().getId() == mTCardContainer.getId()) {
                                break;
                            } else {
                                i2++;
                            }
                        }
                        if (i2 != -1) {
                            boxes.set(i2, list);
                        }
                    }
                    List<MTCardContainer> binders = collection.getBinders();
                    if (binders != null) {
                        Iterator<MTCardContainer> it2 = binders.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                i = -1;
                                break;
                            } else if (it2.next().getId() == mTCardContainer.getId()) {
                                break;
                            } else {
                                i++;
                            }
                        }
                        if (i != -1) {
                            binders.set(i, list);
                        }
                    }
                }
                collectionRootFragment.setCollection(collection);
                if (collection != null) {
                    Context contextRequireContext2 = collectionRootFragment.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                    new PreferencesManager(contextRequireContext2).saveCurrentUserCollection(collection);
                }
                MTCollection collection2 = collectionRootFragment.getCollection();
                if (collection2 != null) {
                    collectionRootFragment.updateUI(collection2);
                }
            }
        }
    }
}
