package com.studiolaganne.lengendarylens;

import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import com.airbnb.lottie.LottieAnimationView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: AllPrintsActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/studiolaganne/lengendarylens/AllPrintsActivity$onCreate$5$1", "Lretrofit2/Callback;", "Lcom/studiolaganne/lengendarylens/MTCardPrintsResponse;", "onResponse", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "response", "Lretrofit2/Response;", "onFailure", "t", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AllPrintsActivity$onCreate$5$1 implements Callback<MTCardPrintsResponse> {
    final /* synthetic */ LottieAnimationView $loadingAnimationView;
    final /* synthetic */ View $loadingBackgroundView;
    final /* synthetic */ AllPrintsActivity this$0;

    AllPrintsActivity$onCreate$5$1(View view, LottieAnimationView lottieAnimationView, AllPrintsActivity allPrintsActivity) {
        this.$loadingBackgroundView = view;
        this.$loadingAnimationView = lottieAnimationView;
        this.this$0 = allPrintsActivity;
    }

    static final void onFailure$lambda$1(View view, LottieAnimationView lottieAnimationView, AllPrintsActivity allPrintsActivity) {
        view.setVisibility(8);
        lottieAnimationView.setVisibility(8);
        Toast.makeText(allPrintsActivity, R.string.error_fetching_prints, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onResponse$lambda$0$0(View view, LottieAnimationView lottieAnimationView, AllPrintsActivity allPrintsActivity, MTCardPrints mTCardPrints) {
        view.setVisibility(8);
        lottieAnimationView.setVisibility(8);
        allPrintsActivity.originalMTCards = mTCardPrints.getPrints();
        allPrintsActivity.mtCards = mTCardPrints.getPrints();
        allPrintsActivity.isMTCards = true;
        allPrintsActivity.sortCardsAndReload();
    }

    @Override // retrofit2.Callback
    public void onFailure(Call<MTCardPrintsResponse> call, Throwable t) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(t, "t");
        Log.e("AllPrintsActivity", "Failed to fetch MT Card Prints: " + t.getMessage());
        final AllPrintsActivity allPrintsActivity = this.this$0;
        final View view = this.$loadingBackgroundView;
        final LottieAnimationView lottieAnimationView = this.$loadingAnimationView;
        allPrintsActivity.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.AllPrintsActivity$onCreate$5$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AllPrintsActivity$onCreate$5$1.onFailure$lambda$1(view, lottieAnimationView, allPrintsActivity);
            }
        });
    }

    @Override // retrofit2.Callback
    public void onResponse(Call<MTCardPrintsResponse> call, Response<MTCardPrintsResponse> response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        if (!response.isSuccessful()) {
            this.$loadingBackgroundView.setVisibility(8);
            this.$loadingAnimationView.setVisibility(8);
            Toast.makeText(this.this$0, R.string.error_fetching_prints, 0).show();
            return;
        }
        MTCardPrintsResponse mTCardPrintsResponseBody = response.body();
        final MTCardPrints prints = mTCardPrintsResponseBody != null ? mTCardPrintsResponseBody.getPrints() : null;
        if (prints != null) {
            final AllPrintsActivity allPrintsActivity = this.this$0;
            final View view = this.$loadingBackgroundView;
            final LottieAnimationView lottieAnimationView = this.$loadingAnimationView;
            allPrintsActivity.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.AllPrintsActivity$onCreate$5$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    AllPrintsActivity$onCreate$5$1.onResponse$lambda$0$0(view, lottieAnimationView, allPrintsActivity, prints);
                }
            });
        }
    }
}
