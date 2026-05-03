package com.studiolaganne.lengendarylens;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import java.util.ArrayList;
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

/* JADX INFO: compiled from: DeckDetailsActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/studiolaganne/lengendarylens/DeckDetailsActivity$onUnpublishGameClicked$1$2$1", "Lretrofit2/Callback;", "Lcom/studiolaganne/lengendarylens/MTIdResponse;", "onResponse", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "response", "Lretrofit2/Response;", "onFailure", "t", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeckDetailsActivity$onUnpublishGameClicked$1$2$1 implements Callback<MTIdResponse> {
    final /* synthetic */ MTGame $game;
    final /* synthetic */ ConstraintLayout $overlay;
    final /* synthetic */ DeckDetailsActivity $this_run;
    final /* synthetic */ DeckDetailsActivity this$0;

    DeckDetailsActivity$onUnpublishGameClicked$1$2$1(DeckDetailsActivity deckDetailsActivity, DeckDetailsActivity deckDetailsActivity2, ConstraintLayout constraintLayout, MTGame mTGame) {
        this.$this_run = deckDetailsActivity;
        this.this$0 = deckDetailsActivity2;
        this.$overlay = constraintLayout;
        this.$game = mTGame;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onResponse$lambda$1$0$0(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    @Override // retrofit2.Callback
    public void onFailure(Call<MTIdResponse> call, Throwable t) {
        ConstraintLayout constraintLayout;
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(t, "t");
        if (this.$this_run.isDestroyed() || this.$this_run.isFinishing() || (constraintLayout = this.$overlay) == null) {
            return;
        }
        constraintLayout.setVisibility(8);
    }

    @Override // retrofit2.Callback
    public void onResponse(Call<MTIdResponse> call, Response<MTIdResponse> response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        if (this.$this_run.isDestroyed() || this.$this_run.isFinishing()) {
            return;
        }
        ResponseBody responseBodyErrorBody = response.errorBody();
        String strString = responseBodyErrorBody != null ? responseBodyErrorBody.string() : null;
        if (response.isSuccessful()) {
            if (this.$this_run.isFinishing() || this.$this_run.isDestroyed()) {
                return;
            }
            DeckDetailsActivity deckDetailsActivity = this.this$0;
            List list = deckDetailsActivity.games;
            MTGame mTGame = this.$game;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MTGame mTGameCopy = (MTGame) it.next();
                if (mTGameCopy.getId() == mTGame.getId()) {
                    mTGameCopy = mTGameCopy.copy((28671 & 1) != 0 ? mTGameCopy.id : 0, (28671 & 2) != 0 ? mTGameCopy.format : null, (28671 & 4) != 0 ? mTGameCopy.subformat : null, (28671 & 8) != 0 ? mTGameCopy.playgroup : null, (28671 & 16) != 0 ? mTGameCopy.created_by : null, (28671 & 32) != 0 ? mTGameCopy.winner : null, (28671 & 64) != 0 ? mTGameCopy.started_at : null, (28671 & 128) != 0 ? mTGameCopy.ended_at : null, (28671 & 256) != 0 ? mTGameCopy.set : null, (28671 & 512) != 0 ? mTGameCopy.players : null, (28671 & 1024) != 0 ? mTGameCopy.events : null, (28671 & 2048) != 0 ? mTGameCopy.pausetime : null, (28671 & 4096) != 0 ? mTGameCopy.published : false, (28671 & 8192) != 0 ? mTGameCopy.tags : null, (28671 & 16384) != 0 ? mTGameCopy.note : null);
                }
                arrayList.add(mTGameCopy);
            }
            deckDetailsActivity.games = CollectionsKt.toMutableList((Collection) arrayList);
            List listGroupGamesWithSeparators = this.$this_run.groupGamesWithSeparators(this.this$0.games);
            View viewFindViewById = this.$this_run.findViewById(R.id.gamesRecyclerView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            View viewFindViewById2 = this.$this_run.findViewById(R.id.noGamesTextView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            TextView textView = (TextView) viewFindViewById2;
            ((RecyclerView) viewFindViewById).setAdapter(new GamesAdapter(CollectionsKt.toMutableList((Collection) listGroupGamesWithSeparators), false, this.this$0, false, 8, null));
            textView.setVisibility(this.$this_run.games.isEmpty() ? 0 : 8);
            this.this$0.adjustRecyclerViewHeight();
        } else if (strString != null) {
            DeckDetailsActivity deckDetailsActivity2 = this.$this_run;
            MTResponse mTResponse = (MTResponse) new Gson().fromJson(strString, MTResponse.class);
            if (mTResponse != null) {
                CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
                String string = deckDetailsActivity2.getString(R.string.server_error);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                CustomDialogFragment.Builder body = builder.setTitle(string).setBody("Error " + mTResponse.getCode() + ": " + mTResponse.getMessage());
                String string2 = deckDetailsActivity2.getString(R.string.ok);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string2, new Function2() { // from class: com.studiolaganne.lengendarylens.DeckDetailsActivity$onUnpublishGameClicked$1$2$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DeckDetailsActivity$onUnpublishGameClicked$1$2$1.onResponse$lambda$1$0$0(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                    }
                });
                FragmentManager supportFragmentManager = deckDetailsActivity2.getSupportFragmentManager();
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
