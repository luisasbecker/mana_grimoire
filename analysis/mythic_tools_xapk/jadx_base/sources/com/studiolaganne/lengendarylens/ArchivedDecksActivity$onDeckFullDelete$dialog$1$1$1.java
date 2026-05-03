package com.studiolaganne.lengendarylens;

import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import com.google.gson.Gson;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import java.util.ArrayList;
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

/* JADX INFO: compiled from: ArchivedDecksActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/studiolaganne/lengendarylens/ArchivedDecksActivity$onDeckFullDelete$dialog$1$1$1", "Lretrofit2/Callback;", "Lcom/studiolaganne/lengendarylens/MTDecksResponse;", "onResponse", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "response", "Lretrofit2/Response;", "onFailure", "t", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ArchivedDecksActivity$onDeckFullDelete$dialog$1$1$1 implements Callback<MTDecksResponse> {
    final /* synthetic */ MTDeck $deck;
    final /* synthetic */ ConstraintLayout $overlay;
    final /* synthetic */ PreferencesManager $prefs;
    final /* synthetic */ ArchivedDecksActivity this$0;

    ArchivedDecksActivity$onDeckFullDelete$dialog$1$1$1(ConstraintLayout constraintLayout, ArchivedDecksActivity archivedDecksActivity, PreferencesManager preferencesManager, MTDeck mTDeck) {
        this.$overlay = constraintLayout;
        this.this$0 = archivedDecksActivity;
        this.$prefs = preferencesManager;
        this.$deck = mTDeck;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onResponse$lambda$1$0$0(boolean z, CustomDialogFragment dlg) {
        Intrinsics.checkNotNullParameter(dlg, "dlg");
        dlg.dismiss();
        return Unit.INSTANCE;
    }

    @Override // retrofit2.Callback
    public void onFailure(Call<MTDecksResponse> call, Throwable t) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(t, "t");
        this.$overlay.setVisibility(8);
        Log.e("ArchivedDecksActivity", "Failed to delete deck", t);
    }

    @Override // retrofit2.Callback
    public void onResponse(Call<MTDecksResponse> call, Response<MTDecksResponse> response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        ResponseBody responseBodyErrorBody = response.errorBody();
        String strString = responseBodyErrorBody != null ? responseBodyErrorBody.string() : null;
        this.$overlay.setVisibility(8);
        if (!response.isSuccessful()) {
            if (strString != null) {
                ArchivedDecksActivity archivedDecksActivity = this.this$0;
                MTResponse mTResponse = (MTResponse) new Gson().fromJson(strString, MTResponse.class);
                if (mTResponse != null) {
                    CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
                    String string = archivedDecksActivity.getString(R.string.server_error);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    CustomDialogFragment.Builder body = builder.setTitle(string).setBody("Error " + mTResponse.getCode() + ": " + mTResponse.getMessage());
                    String string2 = archivedDecksActivity.getString(R.string.ok);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string2, new Function2() { // from class: com.studiolaganne.lengendarylens.ArchivedDecksActivity$onDeckFullDelete$dialog$1$1$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ArchivedDecksActivity$onDeckFullDelete$dialog$1$1$1.onResponse$lambda$1$0$0(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                        }
                    });
                    FragmentManager supportFragmentManager = archivedDecksActivity.getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
                    positiveButton.show(supportFragmentManager, "mtapi_error_dialog");
                    return;
                }
                return;
            }
            return;
        }
        if (this.this$0.isFinishing() || this.this$0.isDestroyed()) {
            return;
        }
        MTDecksResponse mTDecksResponseBody = response.body();
        List<MTDeck> decks = mTDecksResponseBody != null ? mTDecksResponseBody.getDecks() : null;
        PreferencesManager preferencesManager = this.$prefs;
        if (decks == null) {
            decks = CollectionsKt.emptyList();
        }
        preferencesManager.saveCurrentUserDecks(decks);
        this.$prefs.setForcedApiUpdate(true);
        this.$prefs.setBoolean(PreferencesManager.NEED_USER_RELOAD, true);
        ArchivedDecksActivity archivedDecksActivity2 = this.this$0;
        List list = archivedDecksActivity2.archivedDecks;
        MTDeck mTDeck = this.$deck;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((MTDeck) obj).getId() != mTDeck.getId()) {
                arrayList.add(obj);
            }
        }
        archivedDecksActivity2.archivedDecks = arrayList;
        this.$prefs.saveCurrentUserArchivedDecks(this.this$0.archivedDecks);
        this.this$0.updateDecks();
    }
}
