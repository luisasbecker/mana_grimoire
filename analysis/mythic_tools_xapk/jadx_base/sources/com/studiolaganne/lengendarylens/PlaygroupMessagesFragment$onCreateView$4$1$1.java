package com.studiolaganne.lengendarylens;

import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import com.google.gson.Gson;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: PlaygroupMessagesFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/studiolaganne/lengendarylens/PlaygroupMessagesFragment$onCreateView$4$1$1", "Lretrofit2/Callback;", "Lcom/studiolaganne/lengendarylens/MTPostMessageResponse;", "onResponse", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "response", "Lretrofit2/Response;", "onFailure", "t", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PlaygroupMessagesFragment$onCreateView$4$1$1 implements Callback<MTPostMessageResponse> {
    final /* synthetic */ PreferencesManager $prefs;
    final /* synthetic */ PlaygroupMessagesFragment this$0;

    PlaygroupMessagesFragment$onCreateView$4$1$1(PlaygroupMessagesFragment playgroupMessagesFragment, PreferencesManager preferencesManager) {
        this.this$0 = playgroupMessagesFragment;
        this.$prefs = preferencesManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onResponse$lambda$1$0$0(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    @Override // retrofit2.Callback
    public void onFailure(Call<MTPostMessageResponse> call, Throwable t) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(t, "t");
        this.this$0.getBinding().sendButtonLayout.setEnabled(true);
        this.this$0.getBinding().sendButtonLayout.setBackground(ContextCompat.getDrawable(this.this$0.requireContext(), R.drawable.add_friend_background));
        this.this$0.getBinding().sendHintLayout.setVisibility(8);
        Toast.makeText(this.this$0.requireContext(), "Failed to send message: " + t.getLocalizedMessage(), 0).show();
    }

    @Override // retrofit2.Callback
    public void onResponse(Call<MTPostMessageResponse> call, Response<MTPostMessageResponse> response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        ResponseBody responseBodyErrorBody = response.errorBody();
        String strString = responseBodyErrorBody != null ? responseBodyErrorBody.string() : null;
        boolean zIsSuccessful = response.isSuccessful();
        PlaygroupMessagesFragment playgroupMessagesFragment = this.this$0;
        if (zIsSuccessful) {
            playgroupMessagesFragment.getBinding().messageInput.setText("");
            this.this$0.getBinding().sendButtonLayout.setEnabled(true);
            this.this$0.getBinding().sendButtonLayout.setBackground(ContextCompat.getDrawable(this.this$0.requireContext(), R.drawable.add_friend_background));
            this.this$0.getBinding().sendHintLayout.setVisibility(8);
            MTPostMessageResponse mTPostMessageResponseBody = response.body();
            MTMessage message = mTPostMessageResponseBody != null ? mTPostMessageResponseBody.getMessage() : null;
            if (message != null) {
                PlaygroupMessagesFragment playgroupMessagesFragment2 = this.this$0;
                PreferencesManager preferencesManager = this.$prefs;
                MTPlaygroup mTPlaygroup = playgroupMessagesFragment2.currentPlaygroup;
                if (mTPlaygroup != null) {
                    MessagesDBHelper messagesDBHelper = playgroupMessagesFragment2.messagesDBHelper;
                    if (messagesDBHelper != null) {
                        messagesDBHelper.addMessageForPlaygroup(mTPlaygroup.getId(), message);
                    }
                    playgroupMessagesFragment2.updateUI(true);
                    MessagesDBHelper messagesDBHelper2 = playgroupMessagesFragment2.messagesDBHelper;
                    if (messagesDBHelper2 != null) {
                        messagesDBHelper2.setLastReadTimestampForPlaygroup(mTPlaygroup.getId(), message.getTimestamp());
                    }
                    preferencesManager.setBoolean(PreferencesManager.NEED_USER_RELOAD, true);
                    return;
                }
                return;
            }
            return;
        }
        playgroupMessagesFragment.getBinding().sendButtonLayout.setEnabled(true);
        this.this$0.getBinding().sendButtonLayout.setBackground(ContextCompat.getDrawable(this.this$0.requireContext(), R.drawable.add_friend_background));
        this.this$0.getBinding().sendHintLayout.setVisibility(8);
        if (strString != null) {
            PlaygroupMessagesFragment playgroupMessagesFragment3 = this.this$0;
            MTResponse mTResponse = (MTResponse) new Gson().fromJson(strString, MTResponse.class);
            if (mTResponse != null) {
                CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
                String string = playgroupMessagesFragment3.getString(R.string.server_error);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                CustomDialogFragment.Builder body = builder.setTitle(string).setBody("Error " + mTResponse.getCode() + ": " + mTResponse.getMessage());
                String string2 = playgroupMessagesFragment3.getString(R.string.ok);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string2, new Function2() { // from class: com.studiolaganne.lengendarylens.PlaygroupMessagesFragment$onCreateView$4$1$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PlaygroupMessagesFragment$onCreateView$4$1$1.onResponse$lambda$1$0$0(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                    }
                });
                FragmentManager childFragmentManager = playgroupMessagesFragment3.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
                positiveButton.show(childFragmentManager, "mtapi_error_dialog");
            }
        }
    }
}
