package com.studiolaganne.lengendarylens;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import com.google.gson.Gson;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: PlaygroupDetailsActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/studiolaganne/lengendarylens/PlaygroupDetailsActivity$onUserFriendRequest$1$1", "Lretrofit2/Callback;", "Lcom/studiolaganne/lengendarylens/MTFriendResponse;", "onResponse", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "response", "Lretrofit2/Response;", "onFailure", "t", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PlaygroupDetailsActivity$onUserFriendRequest$1$1 implements Callback<MTFriendResponse> {
    final /* synthetic */ ConstraintLayout $overlay;
    final /* synthetic */ PreferencesManager $prefs;
    final /* synthetic */ MTUser $user;
    final /* synthetic */ PlaygroupDetailsActivity this$0;

    PlaygroupDetailsActivity$onUserFriendRequest$1$1(PlaygroupDetailsActivity playgroupDetailsActivity, ConstraintLayout constraintLayout, MTUser mTUser, PreferencesManager preferencesManager) {
        this.this$0 = playgroupDetailsActivity;
        this.$overlay = constraintLayout;
        this.$user = mTUser;
        this.$prefs = preferencesManager;
    }

    static final Unit onFailure$lambda$2(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onResponse$lambda$0$1$0(boolean z, CustomDialogFragment dialog) {
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
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = this.this$0.getString(R.string.server_error);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string);
        String string2 = this.this$0.getString(R.string.server_error_body);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder body = title.setBody(string2);
        String string3 = this.this$0.getString(R.string.ok);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity$onUserFriendRequest$1$1$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return PlaygroupDetailsActivity$onUserFriendRequest$1$1.onFailure$lambda$2(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        FragmentManager supportFragmentManager = this.this$0.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        positiveButton.show(supportFragmentManager, "mtapi_error_dialog");
        ConstraintLayout constraintLayout = this.$overlay;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
    }

    @Override // retrofit2.Callback
    public void onResponse(Call<MTFriendResponse> call, Response<MTFriendResponse> response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        ResponseBody responseBodyErrorBody = response.errorBody();
        Object obj = null;
        String strString = responseBodyErrorBody != null ? responseBodyErrorBody.string() : null;
        if (!response.isSuccessful()) {
            if (strString != null) {
                PlaygroupDetailsActivity playgroupDetailsActivity = this.this$0;
                MTResponse mTResponse = (MTResponse) new Gson().fromJson(strString, MTResponse.class);
                if (mTResponse != null) {
                    CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
                    String string = playgroupDetailsActivity.getString(R.string.server_error);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    CustomDialogFragment.Builder body = builder.setTitle(string).setBody("Error " + mTResponse.getCode() + ": " + mTResponse.getMessage());
                    String string2 = playgroupDetailsActivity.getString(R.string.ok);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string2, new Function2() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity$onUserFriendRequest$1$1$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return PlaygroupDetailsActivity$onUserFriendRequest$1$1.onResponse$lambda$1$0$0(((Boolean) obj2).booleanValue(), (CustomDialogFragment) obj3);
                        }
                    });
                    FragmentManager supportFragmentManager = playgroupDetailsActivity.getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
                    positiveButton.show(supportFragmentManager, "mtapi_error_dialog");
                }
            }
            ConstraintLayout constraintLayout = this.$overlay;
            if (constraintLayout != null) {
                constraintLayout.setVisibility(8);
                return;
            }
            return;
        }
        if (this.this$0.isDestroyed() || this.this$0.isFinishing()) {
            return;
        }
        ConstraintLayout constraintLayout2 = this.$overlay;
        if (constraintLayout2 != null) {
            constraintLayout2.setVisibility(8);
        }
        MTFriendResponse mTFriendResponseBody = response.body();
        List<MTFriend> friends = mTFriendResponseBody != null ? mTFriendResponseBody.getFriends() : null;
        if (friends != null) {
            MTUser mTUser = this.$user;
            PreferencesManager preferencesManager = this.$prefs;
            PlaygroupDetailsActivity playgroupDetailsActivity2 = this.this$0;
            Iterator<T> it = friends.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((MTFriend) next).getId() == mTUser.getId()) {
                    obj = next;
                    break;
                }
            }
            MTFriend mTFriend = (MTFriend) obj;
            if (mTFriend != null) {
                preferencesManager.saveCurrentUserFriends(friends);
                preferencesManager.setBoolean(PreferencesManager.NEED_USER_RELOAD, true);
                CustomDialogFragment.Builder builder2 = new CustomDialogFragment.Builder();
                String string3 = playgroupDetailsActivity2.getString(R.string.invite_sent);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                CustomDialogFragment.Builder title = builder2.setTitle(string3);
                String string4 = playgroupDetailsActivity2.getString(R.string.invite_sent_body);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                CustomDialogFragment.Builder body2 = title.setBody(StringsKt.replace$default(string4, "{1}", mTFriend.getFirstname(), false, 4, (Object) null));
                String string5 = playgroupDetailsActivity2.getString(R.string.ok);
                Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                CustomDialogFragment.Builder positiveButton2 = body2.setPositiveButton(string5, new Function2() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity$onUserFriendRequest$1$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return PlaygroupDetailsActivity$onUserFriendRequest$1$1.onResponse$lambda$0$1$0(((Boolean) obj2).booleanValue(), (CustomDialogFragment) obj3);
                    }
                });
                FragmentManager supportFragmentManager2 = playgroupDetailsActivity2.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "getSupportFragmentManager(...)");
                positiveButton2.show(supportFragmentManager2, "mtapi_error_dialog");
            }
        }
    }
}
