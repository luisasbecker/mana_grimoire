package com.studiolaganne.lengendarylens;

import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import com.google.gson.Gson;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: HomeFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/studiolaganne/lengendarylens/HomeFragment$onFriendSelected$2$1$1", "Lretrofit2/Callback;", "Lcom/studiolaganne/lengendarylens/MTFriendResponse;", "onResponse", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "response", "Lretrofit2/Response;", "onFailure", "t", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class HomeFragment$onFriendSelected$2$1$1 implements Callback<MTFriendResponse> {
    final /* synthetic */ MTUser $currentUser;
    final /* synthetic */ PreferencesManager $prefs;
    final /* synthetic */ HomeFragment this$0;

    HomeFragment$onFriendSelected$2$1$1(HomeFragment homeFragment, PreferencesManager preferencesManager, MTUser mTUser) {
        this.this$0 = homeFragment;
        this.$prefs = preferencesManager;
        this.$currentUser = mTUser;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onResponse$lambda$2$0$0(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    @Override // retrofit2.Callback
    public void onFailure(Call<MTFriendResponse> call, Throwable t) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(t, "t");
    }

    @Override // retrofit2.Callback
    public void onResponse(Call<MTFriendResponse> call, Response<MTFriendResponse> response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        if (this.this$0.getContext() == null || this.this$0._binding == null) {
            return;
        }
        ResponseBody responseBodyErrorBody = response.errorBody();
        String strString = responseBodyErrorBody != null ? responseBodyErrorBody.string() : null;
        if (response.isSuccessful()) {
            if (this.this$0.getContext() == null) {
                return;
            }
            MTFriendResponse mTFriendResponseBody = response.body();
            List<MTFriend> friends = mTFriendResponseBody != null ? mTFriendResponseBody.getFriends() : null;
            PreferencesManager preferencesManager = this.$prefs;
            if (friends != null) {
                HomeFragment homeFragment = this.this$0;
                MTUser mTUser = this.$currentUser;
                preferencesManager.saveCurrentUserFriends(friends);
                preferencesManager.setBoolean(PreferencesManager.NEED_USER_RELOAD, true);
                homeFragment.updateFriends(mTUser, friends);
                return;
            }
            HomeFragment homeFragment2 = this.this$0;
            MTUser mTUser2 = this.$currentUser;
            preferencesManager.saveCurrentUserFriends(CollectionsKt.emptyList());
            preferencesManager.setBoolean(PreferencesManager.NEED_USER_RELOAD, true);
            homeFragment2.updateFriends(mTUser2, CollectionsKt.emptyList());
            return;
        }
        if (strString != null) {
            HomeFragment homeFragment3 = this.this$0;
            MTResponse mTResponse = (MTResponse) new Gson().fromJson(strString, MTResponse.class);
            if (mTResponse != null) {
                CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
                String string = homeFragment3.getString(R.string.server_error);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                CustomDialogFragment.Builder body = builder.setTitle(string).setBody("Error " + mTResponse.getCode() + ": " + mTResponse.getMessage());
                String string2 = homeFragment3.getString(R.string.ok);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string2, new Function2() { // from class: com.studiolaganne.lengendarylens.HomeFragment$onFriendSelected$2$1$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return HomeFragment$onFriendSelected$2$1$1.onResponse$lambda$2$0$0(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                    }
                });
                FragmentManager childFragmentManager = homeFragment3.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
                positiveButton.show(childFragmentManager, "mtapi_error_dialog");
            }
        }
    }
}
