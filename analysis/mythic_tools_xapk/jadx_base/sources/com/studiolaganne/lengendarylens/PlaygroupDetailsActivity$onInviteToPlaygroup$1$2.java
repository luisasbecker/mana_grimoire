package com.studiolaganne.lengendarylens;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import com.google.gson.Gson;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import java.util.Collection;
import java.util.Iterator;
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

/* JADX INFO: compiled from: PlaygroupDetailsActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/studiolaganne/lengendarylens/PlaygroupDetailsActivity$onInviteToPlaygroup$1$2", "Lretrofit2/Callback;", "Lcom/studiolaganne/lengendarylens/MTSinglePlaygroupResponse;", "onResponse", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "response", "Lretrofit2/Response;", "onFailure", "t", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PlaygroupDetailsActivity$onInviteToPlaygroup$1$2 implements Callback<MTSinglePlaygroupResponse> {
    final /* synthetic */ ConstraintLayout $overlay;
    final /* synthetic */ PreferencesManager $prefs;
    final /* synthetic */ PlaygroupDetailsActivity this$0;

    PlaygroupDetailsActivity$onInviteToPlaygroup$1$2(PlaygroupDetailsActivity playgroupDetailsActivity, ConstraintLayout constraintLayout, PreferencesManager preferencesManager) {
        this.this$0 = playgroupDetailsActivity;
        this.$overlay = constraintLayout;
        this.$prefs = preferencesManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onResponse$lambda$1$0$0(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    @Override // retrofit2.Callback
    public void onFailure(Call<MTSinglePlaygroupResponse> call, Throwable t) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(t, "t");
        ConstraintLayout constraintLayout = this.$overlay;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
    }

    @Override // retrofit2.Callback
    public void onResponse(Call<MTSinglePlaygroupResponse> call, Response<MTSinglePlaygroupResponse> response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        ResponseBody responseBodyErrorBody = response.errorBody();
        String strString = responseBodyErrorBody != null ? responseBodyErrorBody.string() : null;
        if (response.isSuccessful()) {
            if (this.this$0.isFinishing() || this.this$0.isDestroyed()) {
                return;
            }
            MTSinglePlaygroupResponse mTSinglePlaygroupResponseBody = response.body();
            MTPlaygroup playgroup = mTSinglePlaygroupResponseBody != null ? mTSinglePlaygroupResponseBody.getPlaygroup() : null;
            if (playgroup != null) {
                PreferencesManager preferencesManager = this.$prefs;
                PlaygroupDetailsActivity playgroupDetailsActivity = this.this$0;
                List<MTPlaygroup> mutableList = CollectionsKt.toMutableList((Collection) preferencesManager.getCurrentUserPlaygroups());
                Iterator<MTPlaygroup> it = mutableList.iterator();
                int i = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i = -1;
                        break;
                    } else if (it.next().getId() == playgroup.getId()) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i != -1) {
                    mutableList.set(i, playgroup);
                    preferencesManager.saveCurrentUserPlaygroups(mutableList);
                }
                preferencesManager.setBoolean(PreferencesManager.NEED_USER_RELOAD, true);
                playgroupDetailsActivity.setCurrentPlaygroup(playgroup);
                playgroupDetailsActivity.updateUI();
            }
        } else if (strString != null) {
            PlaygroupDetailsActivity playgroupDetailsActivity2 = this.this$0;
            MTResponse mTResponse = (MTResponse) new Gson().fromJson(strString, MTResponse.class);
            if (mTResponse != null) {
                CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
                String string = playgroupDetailsActivity2.getString(R.string.server_error);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                CustomDialogFragment.Builder body = builder.setTitle(string).setBody("Error " + mTResponse.getCode() + ": " + mTResponse.getMessage());
                String string2 = playgroupDetailsActivity2.getString(R.string.ok);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string2, new Function2() { // from class: com.studiolaganne.lengendarylens.PlaygroupDetailsActivity$onInviteToPlaygroup$1$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PlaygroupDetailsActivity$onInviteToPlaygroup$1$2.onResponse$lambda$1$0$0(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                    }
                });
                FragmentManager supportFragmentManager = playgroupDetailsActivity2.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
                positiveButton.show(supportFragmentManager, "mtapi_error_dialog");
            }
        }
        ConstraintLayout constraintLayout = this.$overlay;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
    }
}
