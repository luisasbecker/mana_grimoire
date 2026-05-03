package com.studiolaganne.lengendarylens;

import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import com.google.gson.Gson;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import java.util.ArrayList;
import java.util.Collection;
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

/* JADX INFO: compiled from: UserGamesFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/studiolaganne/lengendarylens/UserGamesFragment$onPublishGameClicked$1$1$1", "Lretrofit2/Callback;", "Lcom/studiolaganne/lengendarylens/MTIdResponse;", "onResponse", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "response", "Lretrofit2/Response;", "onFailure", "t", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UserGamesFragment$onPublishGameClicked$1$1$1 implements Callback<MTIdResponse> {
    final /* synthetic */ MTSet $set;
    final /* synthetic */ UserGamesFragment this$0;

    UserGamesFragment$onPublishGameClicked$1$1$1(UserGamesFragment userGamesFragment, MTSet mTSet) {
        this.this$0 = userGamesFragment;
        this.$set = mTSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onResponse$lambda$1$0$0(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    @Override // retrofit2.Callback
    public void onFailure(Call<MTIdResponse> call, Throwable t) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(t, "t");
        if (this.this$0.getContext() == null || this.this$0._binding == null) {
            return;
        }
        this.this$0.getBinding().loadingAnimationViewRecyclerView.setVisibility(8);
    }

    @Override // retrofit2.Callback
    public void onResponse(Call<MTIdResponse> call, Response<MTIdResponse> response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        if (this.this$0.getContext() == null || this.this$0._binding == null) {
            return;
        }
        ResponseBody responseBodyErrorBody = response.errorBody();
        String strString = responseBodyErrorBody != null ? responseBodyErrorBody.string() : null;
        if (response.isSuccessful()) {
            if (this.this$0.getContext() == null || this.this$0._binding == null) {
                return;
            }
            UserGamesFragment userGamesFragment = this.this$0;
            List<MTGame> list = userGamesFragment.games;
            MTSet mTSet = this.$set;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (MTGame mTGameCopy : list) {
                MTSet set = mTGameCopy.getSet();
                if (set != null && set.getId() == mTSet.getId()) {
                    mTGameCopy = mTGameCopy.copy((28671 & 1) != 0 ? mTGameCopy.id : 0, (28671 & 2) != 0 ? mTGameCopy.format : null, (28671 & 4) != 0 ? mTGameCopy.subformat : null, (28671 & 8) != 0 ? mTGameCopy.playgroup : null, (28671 & 16) != 0 ? mTGameCopy.created_by : null, (28671 & 32) != 0 ? mTGameCopy.winner : null, (28671 & 64) != 0 ? mTGameCopy.started_at : null, (28671 & 128) != 0 ? mTGameCopy.ended_at : null, (28671 & 256) != 0 ? mTGameCopy.set : null, (28671 & 512) != 0 ? mTGameCopy.players : null, (28671 & 1024) != 0 ? mTGameCopy.events : null, (28671 & 2048) != 0 ? mTGameCopy.pausetime : null, (28671 & 4096) != 0 ? mTGameCopy.published : true, (28671 & 8192) != 0 ? mTGameCopy.tags : null, (28671 & 16384) != 0 ? mTGameCopy.note : null);
                }
                arrayList.add(mTGameCopy);
            }
            userGamesFragment.games = CollectionsKt.toMutableList((Collection) arrayList);
            UserGamesFragment userGamesFragment2 = this.this$0;
            List listGroupGamesWithSeparators = userGamesFragment2.groupGamesWithSeparators(userGamesFragment2.games);
            this.this$0.getBinding().gamesRecyclerView.setAdapter(new GamesAdapter(CollectionsKt.toMutableList((Collection) listGroupGamesWithSeparators), false, this.this$0, false, 8, null));
            boolean zIsEmpty = listGroupGamesWithSeparators.isEmpty();
            UserGamesFragment userGamesFragment3 = this.this$0;
            if (zIsEmpty) {
                userGamesFragment3.getBinding().noGamesText.setVisibility(0);
            } else {
                userGamesFragment3.getBinding().noGamesText.setVisibility(8);
            }
        } else if (strString != null) {
            UserGamesFragment userGamesFragment4 = this.this$0;
            MTResponse mTResponse = (MTResponse) new Gson().fromJson(strString, MTResponse.class);
            if (mTResponse != null) {
                CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
                String string = userGamesFragment4.getString(R.string.server_error);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                CustomDialogFragment.Builder body = builder.setTitle(string).setBody("Error " + mTResponse.getCode() + ": " + mTResponse.getMessage());
                String string2 = userGamesFragment4.getString(R.string.ok);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string2, new Function2() { // from class: com.studiolaganne.lengendarylens.UserGamesFragment$onPublishGameClicked$1$1$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return UserGamesFragment$onPublishGameClicked$1$1$1.onResponse$lambda$1$0$0(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                    }
                });
                FragmentManager childFragmentManager = userGamesFragment4.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
                positiveButton.show(childFragmentManager, "mtapi_error_dialog");
            }
        }
        this.this$0.getBinding().loadingAnimationViewRecyclerView.setVisibility(8);
    }
}
