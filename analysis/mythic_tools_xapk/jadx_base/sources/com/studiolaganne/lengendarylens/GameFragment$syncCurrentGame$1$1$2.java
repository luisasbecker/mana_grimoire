package com.studiolaganne.lengendarylens;

import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import java.io.IOException;
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

/* JADX INFO: compiled from: GameFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/studiolaganne/lengendarylens/GameFragment$syncCurrentGame$1$1$2", "Lretrofit2/Callback;", "Lcom/studiolaganne/lengendarylens/MTCreateSetResponse;", "onResponse", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "response", "Lretrofit2/Response;", "onFailure", "t", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GameFragment$syncCurrentGame$1$1$2 implements Callback<MTCreateSetResponse> {
    final /* synthetic */ boolean $playAgain;
    final /* synthetic */ PreferencesManager $prefs;
    final /* synthetic */ boolean $restart;
    final /* synthetic */ GameFragment this$0;

    GameFragment$syncCurrentGame$1$1$2(GameFragment gameFragment, PreferencesManager preferencesManager, boolean z, boolean z2) {
        this.this$0 = gameFragment;
        this.$prefs = preferencesManager;
        this.$restart = z;
        this.$playAgain = z2;
    }

    static final Unit onFailure$lambda$7(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onResponse$lambda$1(PreferencesManager preferencesManager, boolean z, GameFragment gameFragment, boolean z2, boolean z3, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        preferencesManager.setForcedApiUpdate(true);
        if (z) {
            gameFragment.restartCurrentGame(false, true, z2);
        } else {
            gameFragment.deleteCurrentGame();
        }
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onResponse$lambda$4(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    @Override // retrofit2.Callback
    public void onFailure(Call<MTCreateSetResponse> call, Throwable t) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(t, "t");
        if (this.this$0.getContext() == null || this.this$0._binding == null) {
            return;
        }
        this.this$0.getBinding().loadingOverlay.setVisibility(8);
        if (this.this$0.getContext() == null) {
            return;
        }
        if (this.this$0.getSharedViewModel().getGameState().getEndedAt().length() == 0) {
            this.this$0.getSharedViewModel().getGameState().setEndedAt(GameUtils.INSTANCE.getInstance().getCurrentTimestamp());
        }
        this.$prefs.saveCurrentGame(this.this$0.getSharedViewModel().getGameState());
        GameSet currentSet = this.$prefs.getCurrentSet();
        PreferencesManager preferencesManager = this.$prefs;
        if (currentSet != null) {
            List<GameSet> mutableList = CollectionsKt.toMutableList((Collection) preferencesManager.getUnSyncedSets());
            mutableList.add(currentSet);
            preferencesManager.saveUnSyncedSets(mutableList);
        } else {
            GameFragment gameFragment = this.this$0;
            List<GameState> mutableList2 = CollectionsKt.toMutableList((Collection) preferencesManager.getUnSyncedGames());
            mutableList2.add(gameFragment.getSharedViewModel().getGameState());
            preferencesManager.saveUnSyncedGames(mutableList2);
        }
        boolean z = this.$restart;
        GameFragment gameFragment2 = this.this$0;
        if (z) {
            gameFragment2.restartCurrentGame(false, true, this.$playAgain);
        } else {
            gameFragment2.deleteCurrentGame();
        }
        if (this.this$0.getContext() == null) {
            return;
        }
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = this.this$0.getString(R.string.server_error);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string);
        String string2 = this.this$0.getString(R.string.server_error_body_game);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder body = title.setBody(string2);
        String string3 = this.this$0.getString(R.string.ok);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.GameFragment$syncCurrentGame$1$1$2$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return GameFragment$syncCurrentGame$1$1$2.onFailure$lambda$7(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        positiveButton.show(childFragmentManager, "mtapi_error_dialog");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0049  */
    @Override // retrofit2.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onResponse(Call<MTCreateSetResponse> call, Response<MTCreateSetResponse> response) throws IOException {
        boolean z;
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        if (this.this$0.getContext() == null || this.this$0._binding == null) {
            return;
        }
        ResponseBody responseBodyErrorBody = response.errorBody();
        if (responseBodyErrorBody != null) {
            responseBodyErrorBody.string();
        }
        if (!response.isSuccessful()) {
            z = false;
        } else {
            if (this.this$0.getContext() == null) {
                return;
            }
            MTCreateSetResponse mTCreateSetResponseBody = response.body();
            if ((mTCreateSetResponseBody != null ? mTCreateSetResponseBody.getSet() : null) != null) {
                z = true;
            }
        }
        this.this$0.getBinding().loadingOverlay.setVisibility(8);
        if (z) {
            CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
            String string = this.this$0.getString(R.string.game_upload_success_title);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragment.Builder title = builder.setTitle(string);
            String string2 = this.this$0.getString(R.string.game_upload_success_body);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragment.Builder body = title.setBody(string2);
            String string3 = this.this$0.getString(R.string.ok);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            final PreferencesManager preferencesManager = this.$prefs;
            final boolean z2 = this.$restart;
            final GameFragment gameFragment = this.this$0;
            final boolean z3 = this.$playAgain;
            CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.GameFragment$syncCurrentGame$1$1$2$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GameFragment$syncCurrentGame$1$1$2.onResponse$lambda$1(preferencesManager, z2, gameFragment, z3, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            });
            FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            positiveButton.show(childFragmentManager, "mtapi_error_dialog");
            return;
        }
        if (this.this$0.getSharedViewModel().getGameState().getEndedAt().length() == 0) {
            this.this$0.getSharedViewModel().getGameState().setEndedAt(GameUtils.INSTANCE.getInstance().getCurrentTimestamp());
        }
        this.$prefs.saveCurrentGame(this.this$0.getSharedViewModel().getGameState());
        GameSet currentSet = this.$prefs.getCurrentSet();
        PreferencesManager preferencesManager2 = this.$prefs;
        if (currentSet != null) {
            List<GameSet> mutableList = CollectionsKt.toMutableList((Collection) preferencesManager2.getUnSyncedSets());
            mutableList.add(currentSet);
            preferencesManager2.saveUnSyncedSets(mutableList);
        } else {
            GameFragment gameFragment2 = this.this$0;
            List<GameState> mutableList2 = CollectionsKt.toMutableList((Collection) preferencesManager2.getUnSyncedGames());
            mutableList2.add(gameFragment2.getSharedViewModel().getGameState());
            preferencesManager2.saveUnSyncedGames(mutableList2);
        }
        boolean z4 = this.$restart;
        GameFragment gameFragment3 = this.this$0;
        if (z4) {
            gameFragment3.restartCurrentGame(false, true, this.$playAgain);
        } else {
            gameFragment3.deleteCurrentGame();
        }
        if (this.this$0.getContext() == null) {
            return;
        }
        CustomDialogFragment.Builder builder2 = new CustomDialogFragment.Builder();
        String string4 = this.this$0.getString(R.string.server_error);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder title2 = builder2.setTitle(string4);
        String string5 = this.this$0.getString(R.string.server_error_body_game);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        CustomDialogFragment.Builder body2 = title2.setBody(string5);
        String string6 = this.this$0.getString(R.string.ok);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        CustomDialogFragment.Builder positiveButton2 = body2.setPositiveButton(string6, new Function2() { // from class: com.studiolaganne.lengendarylens.GameFragment$syncCurrentGame$1$1$2$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return GameFragment$syncCurrentGame$1$1$2.onResponse$lambda$4(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        FragmentManager childFragmentManager2 = this.this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
        positiveButton2.show(childFragmentManager2, "mtapi_error_dialog");
    }
}
