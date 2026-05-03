package com.studiolaganne.lengendarylens;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: ArchenemyDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/studiolaganne/lengendarylens/ArchenemyDialogFragment$updateState$4$1", "Lretrofit2/Callback;", "Lcom/studiolaganne/lengendarylens/MTCardResponse;", "onResponse", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "response", "Lretrofit2/Response;", "onFailure", "t", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ArchenemyDialogFragment$updateState$4$1 implements Callback<MTCardResponse> {
    final /* synthetic */ Context $context;
    final /* synthetic */ LoadingImageView $loadingImageView;
    final /* synthetic */ String $schemeId;
    final /* synthetic */ ArchenemyDialogFragment $this_run;

    ArchenemyDialogFragment$updateState$4$1(Context context, LoadingImageView loadingImageView, String str, ArchenemyDialogFragment archenemyDialogFragment) {
        this.$context = context;
        this.$loadingImageView = loadingImageView;
        this.$schemeId = str;
        this.$this_run = archenemyDialogFragment;
    }

    static final Unit onResponse$lambda$1(ArchenemyDialogFragment archenemyDialogFragment, String str) {
        Context contextRequireContext = archenemyDialogFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        new FullscreenImageURLDialog(contextRequireContext, str).show();
        return Unit.INSTANCE;
    }

    @Override // retrofit2.Callback
    public void onFailure(Call<MTCardResponse> call, Throwable t) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(t, "t");
    }

    @Override // retrofit2.Callback
    public void onResponse(Call<MTCardResponse> call, Response<MTCardResponse> response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.isSuccessful()) {
            MTCardResponse mTCardResponseBody = response.body();
            MTFullCard card = mTCardResponseBody != null ? mTCardResponseBody.getCard() : null;
            final String imageUrl = card != null ? card.getImageUrl(0) : null;
            String str = imageUrl;
            if (str == null || str.length() == 0) {
                return;
            }
            CardImageCache.INSTANCE.saveImageUrl(this.$context, this.$schemeId, imageUrl, 0);
            LoadingImageView loadingImageView = this.$loadingImageView;
            if (loadingImageView != null) {
                loadingImageView.loadImage(imageUrl);
            }
            LoadingImageView loadingImageView2 = this.$loadingImageView;
            if (loadingImageView2 != null) {
                final ArchenemyDialogFragment archenemyDialogFragment = this.$this_run;
                ViewExtensionsKt.setOnClickWithFade(loadingImageView2, new Function0() { // from class: com.studiolaganne.lengendarylens.ArchenemyDialogFragment$updateState$4$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ArchenemyDialogFragment$updateState$4$1.onResponse$lambda$1(archenemyDialogFragment, imageUrl);
                    }
                });
            }
        }
    }
}
