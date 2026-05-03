package com.studiolaganne.lengendarylens;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: HomeFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/studiolaganne/lengendarylens/HomeFragment$onViewCreated$18$1", "Lretrofit2/Callback;", "Lcom/studiolaganne/lengendarylens/MTVersionResponse;", "onResponse", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "response", "Lretrofit2/Response;", "onFailure", "t", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class HomeFragment$onViewCreated$18$1 implements Callback<MTVersionResponse> {
    final /* synthetic */ HomeFragment this$0;

    HomeFragment$onViewCreated$18$1(HomeFragment homeFragment) {
        this.this$0 = homeFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onResponse$lambda$0$0(HomeFragment homeFragment) {
        if (homeFragment.getContext() == null || homeFragment._binding == null) {
            return Unit.INSTANCE;
        }
        String packageName = homeFragment.requireContext().getPackageName();
        try {
            homeFragment.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName)));
        } catch (ActivityNotFoundException unused) {
            homeFragment.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + packageName)));
        }
        return Unit.INSTANCE;
    }

    @Override // retrofit2.Callback
    public void onFailure(Call<MTVersionResponse> call, Throwable t) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(t, "t");
    }

    @Override // retrofit2.Callback
    public void onResponse(Call<MTVersionResponse> call, Response<MTVersionResponse> response) {
        MTVersionResponse mTVersionResponseBody;
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        if (this.this$0.getContext() == null || this.this$0._binding == null || (mTVersionResponseBody = response.body()) == null) {
            return;
        }
        final HomeFragment homeFragment = this.this$0;
        if (mTVersionResponseBody.getHasUpdate()) {
            String latest = mTVersionResponseBody.getLatest();
            homeFragment.getBinding().updateBannerLayout.setVisibility(0);
            TextView textView = homeFragment.getBinding().updateLabel;
            String string = homeFragment.getString(R.string.update_available);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            textView.setText(StringsKt.replace$default(string, "{1}", latest, false, 4, (Object) null));
            ConstraintLayout updateBannerLayout = homeFragment.getBinding().updateBannerLayout;
            Intrinsics.checkNotNullExpressionValue(updateBannerLayout, "updateBannerLayout");
            ViewExtensionsKt.setOnClickWithFade(updateBannerLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.HomeFragment$onViewCreated$18$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return HomeFragment$onViewCreated$18$1.onResponse$lambda$0$0(homeFragment);
                }
            });
        }
    }
}
