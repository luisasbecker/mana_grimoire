package com.studiolaganne.lengendarylens;

import android.view.View;
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
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: EditPlaygroupBottomSheetFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/studiolaganne/lengendarylens/EditPlaygroupBottomSheetFragment$onViewCreated$4$1", "Lretrofit2/Callback;", "Lcom/studiolaganne/lengendarylens/MTPlaygroupResponse;", "onResponse", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "response", "Lretrofit2/Response;", "onFailure", "t", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EditPlaygroupBottomSheetFragment$onViewCreated$4$1 implements Callback<MTPlaygroupResponse> {
    final /* synthetic */ PreferencesManager $prefs;
    final /* synthetic */ View $view;
    final /* synthetic */ EditPlaygroupBottomSheetFragment this$0;

    EditPlaygroupBottomSheetFragment$onViewCreated$4$1(EditPlaygroupBottomSheetFragment editPlaygroupBottomSheetFragment, PreferencesManager preferencesManager, View view) {
        this.this$0 = editPlaygroupBottomSheetFragment;
        this.$prefs = preferencesManager;
        this.$view = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onResponse$lambda$1$0$0(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    @Override // retrofit2.Callback
    public void onFailure(Call<MTPlaygroupResponse> call, Throwable t) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(t, "t");
        ((ConstraintLayout) this.$view.findViewById(R.id.overlay)).setVisibility(8);
        this.this$0.dismiss();
    }

    @Override // retrofit2.Callback
    public void onResponse(Call<MTPlaygroupResponse> call, Response<MTPlaygroupResponse> response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        ResponseBody responseBodyErrorBody = response.errorBody();
        Object obj = null;
        String strString = responseBodyErrorBody != null ? responseBodyErrorBody.string() : null;
        if (response.isSuccessful()) {
            if (this.this$0.getContext() == null) {
                return;
            }
            MTPlaygroupResponse mTPlaygroupResponseBody = response.body();
            List<MTPlaygroup> playgroups = mTPlaygroupResponseBody != null ? mTPlaygroupResponseBody.getPlaygroups() : null;
            if (playgroups != null) {
                this.$prefs.saveCurrentUserPlaygroups(playgroups);
                EditPlaygroupBottomSheetFragment editPlaygroupBottomSheetFragment = this.this$0;
                Iterator<T> it = playgroups.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (((MTPlaygroup) next).getId() == editPlaygroupBottomSheetFragment.playgroup.getId()) {
                        obj = next;
                        break;
                    }
                }
                MTPlaygroup mTPlaygroup = (MTPlaygroup) obj;
                if (mTPlaygroup != null) {
                    this.this$0.callback.onPlaygroupEdited(mTPlaygroup);
                }
            }
        } else if (strString != null) {
            EditPlaygroupBottomSheetFragment editPlaygroupBottomSheetFragment2 = this.this$0;
            MTResponse mTResponse = (MTResponse) new Gson().fromJson(strString, MTResponse.class);
            if (mTResponse != null) {
                CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
                String string = editPlaygroupBottomSheetFragment2.getString(R.string.server_error);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                CustomDialogFragment.Builder body = builder.setTitle(string).setBody("Error " + mTResponse.getCode() + ": " + mTResponse.getMessage());
                String string2 = editPlaygroupBottomSheetFragment2.getString(R.string.ok);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string2, new Function2() { // from class: com.studiolaganne.lengendarylens.EditPlaygroupBottomSheetFragment$onViewCreated$4$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return EditPlaygroupBottomSheetFragment$onViewCreated$4$1.onResponse$lambda$1$0$0(((Boolean) obj2).booleanValue(), (CustomDialogFragment) obj3);
                    }
                });
                FragmentManager childFragmentManager = editPlaygroupBottomSheetFragment2.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
                positiveButton.show(childFragmentManager, "mtapi_error_dialog");
            }
        }
        ((ConstraintLayout) this.$view.findViewById(R.id.overlay)).setVisibility(8);
        this.this$0.dismiss();
    }
}
