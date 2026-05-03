package com.studiolaganne.lengendarylens;

import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import com.google.gson.Gson;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: HomeFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/studiolaganne/lengendarylens/HomeFragment$onQRScanned$1$2$1", "Lretrofit2/Callback;", "Lcom/studiolaganne/lengendarylens/MTFriendResponse;", "onResponse", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "response", "Lretrofit2/Response;", "onFailure", "t", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class HomeFragment$onQRScanned$1$2$1 implements Callback<MTFriendResponse> {
    final /* synthetic */ int $friend;
    final /* synthetic */ PreferencesManager $prefs;
    final /* synthetic */ HomeFragment this$0;

    HomeFragment$onQRScanned$1$2$1(HomeFragment homeFragment, int i, PreferencesManager preferencesManager) {
        this.this$0 = homeFragment;
        this.$friend = i;
        this.$prefs = preferencesManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onResponse$lambda$0$1$1(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onResponse$lambda$1$0$0(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    @Override // retrofit2.Callback
    public void onFailure(Call<MTFriendResponse> call, Throwable t) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(t, "t");
        if (this.this$0.getContext() == null || this.this$0._binding == null) {
            return;
        }
        this.this$0.getBinding().overlay.setVisibility(8);
    }

    @Override // retrofit2.Callback
    public void onResponse(Call<MTFriendResponse> call, Response<MTFriendResponse> response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        if (this.this$0.getContext() == null || this.this$0._binding == null) {
            return;
        }
        ResponseBody responseBodyErrorBody = response.errorBody();
        Object obj = null;
        String strString = responseBodyErrorBody != null ? responseBodyErrorBody.string() : null;
        if (response.isSuccessful()) {
            if (this.this$0.getContext() == null) {
                return;
            }
            MTFriendResponse mTFriendResponseBody = response.body();
            List<MTFriend> friends = mTFriendResponseBody != null ? mTFriendResponseBody.getFriends() : null;
            if (friends != null) {
                int i = this.$friend;
                PreferencesManager preferencesManager = this.$prefs;
                HomeFragment homeFragment = this.this$0;
                List<MTFriend> list = friends;
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (((MTFriend) next).getId() == i) {
                        obj = next;
                        break;
                    }
                }
                MTFriend mTFriend = (MTFriend) obj;
                if (mTFriend != null) {
                    preferencesManager.saveCurrentUserFriends(friends);
                    homeFragment.getBinding().friendsRecyclerView.setAdapter(new FriendsAdapter(CollectionsKt.sortedWith(list, new Comparator() { // from class: com.studiolaganne.lengendarylens.HomeFragment$onQRScanned$1$2$1$onResponse$lambda$0$1$$inlined$compareByDescending$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            return ComparisonsKt.compareValues(((MTFriend) t2).getStatus(), ((MTFriend) t).getStatus());
                        }
                    }), homeFragment));
                    CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
                    String string = homeFragment.getString(R.string.invite_sent);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    CustomDialogFragment.Builder title = builder.setTitle(string);
                    String string2 = homeFragment.getString(R.string.invite_sent_body);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    CustomDialogFragment.Builder body = title.setBody(StringsKt.replace$default(string2, "{1}", mTFriend.getFirstname(), false, 4, (Object) null));
                    String string3 = homeFragment.getString(R.string.ok);
                    Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                    CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.HomeFragment$onQRScanned$1$2$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return HomeFragment$onQRScanned$1$2$1.onResponse$lambda$0$1$1(((Boolean) obj2).booleanValue(), (CustomDialogFragment) obj3);
                        }
                    });
                    FragmentManager childFragmentManager = homeFragment.getChildFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
                    positiveButton.show(childFragmentManager, "mtapi_error_dialog");
                }
            }
        } else if (strString != null) {
            HomeFragment homeFragment2 = this.this$0;
            MTResponse mTResponse = (MTResponse) new Gson().fromJson(strString, MTResponse.class);
            if (mTResponse != null) {
                CustomDialogFragment.Builder builder2 = new CustomDialogFragment.Builder();
                String string4 = homeFragment2.getString(R.string.server_error);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                CustomDialogFragment.Builder body2 = builder2.setTitle(string4).setBody("Error " + mTResponse.getCode() + ": " + mTResponse.getMessage());
                String string5 = homeFragment2.getString(R.string.ok);
                Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                CustomDialogFragment.Builder positiveButton2 = body2.setPositiveButton(string5, new Function2() { // from class: com.studiolaganne.lengendarylens.HomeFragment$onQRScanned$1$2$1$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return HomeFragment$onQRScanned$1$2$1.onResponse$lambda$1$0$0(((Boolean) obj2).booleanValue(), (CustomDialogFragment) obj3);
                    }
                });
                FragmentManager childFragmentManager2 = homeFragment2.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
                positiveButton2.show(childFragmentManager2, "mtapi_error_dialog");
            }
        }
        this.this$0.getBinding().overlay.setVisibility(8);
    }
}
