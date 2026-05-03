package com.studiolaganne.lengendarylens;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
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
import kotlin.jvm.internal.Ref;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: CreateDeckBottomSheetFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/studiolaganne/lengendarylens/CreateDeckBottomSheetFragment$onViewCreated$38$3", "Lretrofit2/Callback;", "Lcom/studiolaganne/lengendarylens/MTDecksResponse;", "onResponse", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "response", "Lretrofit2/Response;", "onFailure", "t", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CreateDeckBottomSheetFragment$onViewCreated$38$3 implements Callback<MTDecksResponse> {
    final /* synthetic */ Ref.IntRef $forUserId;
    final /* synthetic */ View $view;
    final /* synthetic */ CreateDeckBottomSheetFragment this$0;

    CreateDeckBottomSheetFragment$onViewCreated$38$3(CreateDeckBottomSheetFragment createDeckBottomSheetFragment, View view, Ref.IntRef intRef) {
        this.this$0 = createDeckBottomSheetFragment;
        this.$view = view;
        this.$forUserId = intRef;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onResponse$lambda$1$0$0(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    @Override // retrofit2.Callback
    public void onFailure(Call<MTDecksResponse> call, Throwable t) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(t, "t");
        if (this.this$0.getContext() == null) {
            return;
        }
        ((ConstraintLayout) this.$view.findViewById(R.id.overlay)).setVisibility(8);
        this.this$0.dismiss();
    }

    @Override // retrofit2.Callback
    public void onResponse(Call<MTDecksResponse> call, Response<MTDecksResponse> response) {
        CreateDeckCallback createDeckCallback;
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        if (this.this$0.getContext() == null) {
            return;
        }
        ResponseBody responseBodyErrorBody = response.errorBody();
        String strString = responseBodyErrorBody != null ? responseBodyErrorBody.string() : null;
        if (response.isSuccessful()) {
            if (this.this$0.getContext() == null) {
                return;
            }
            MTDecksResponse mTDecksResponseBody = response.body();
            List<MTDeck> decks = mTDecksResponseBody != null ? mTDecksResponseBody.getDecks() : null;
            if (decks != null) {
                CreateDeckBottomSheetFragment createDeckBottomSheetFragment = this.this$0;
                Ref.IntRef intRef = this.$forUserId;
                MTDeck mTDeck = (MTDeck) CollectionsKt.firstOrNull((List) decks);
                if (mTDeck != null && (createDeckCallback = createDeckBottomSheetFragment.callback) != null) {
                    createDeckCallback.onDeckCreatedForUser(mTDeck, intRef.element);
                }
            }
        } else if (strString != null) {
            CreateDeckBottomSheetFragment createDeckBottomSheetFragment2 = this.this$0;
            MTResponse mTResponse = (MTResponse) new Gson().fromJson(strString, MTResponse.class);
            if (mTResponse != null) {
                CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
                String string = createDeckBottomSheetFragment2.getString(R.string.server_error);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                CustomDialogFragment.Builder body = builder.setTitle(string).setBody("Error " + mTResponse.getCode() + ": " + mTResponse.getMessage());
                String string2 = createDeckBottomSheetFragment2.getString(R.string.ok);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string2, new Function2() { // from class: com.studiolaganne.lengendarylens.CreateDeckBottomSheetFragment$onViewCreated$38$3$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CreateDeckBottomSheetFragment$onViewCreated$38$3.onResponse$lambda$1$0$0(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                    }
                });
                FragmentManager childFragmentManager = createDeckBottomSheetFragment2.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
                positiveButton.show(childFragmentManager, "mtapi_error_dialog");
            }
        }
        ((ConstraintLayout) this.$view.findViewById(R.id.overlay)).setVisibility(8);
        this.this$0.dismiss();
    }
}
