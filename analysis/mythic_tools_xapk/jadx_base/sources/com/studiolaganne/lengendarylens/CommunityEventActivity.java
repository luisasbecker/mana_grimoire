package com.studiolaganne.lengendarylens;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.gson.Gson;
import com.studiolaganne.lengendarylens.CommunityEventActivity;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: CommunityEventActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\b\u0010 \u001a\u00020\u001dH\u0002J\b\u0010!\u001a\u00020\u001dH\u0002J\b\u0010\"\u001a\u00020\u001dH\u0002J\u001e\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u00052\f\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/studiolaganne/lengendarylens/CommunityEventActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "eventId", "", "currentEvent", "Lcom/studiolaganne/lengendarylens/MTCommunityEvent;", "currentTrivia", "", "Lcom/studiolaganne/lengendarylens/MTTrivia;", "currentChallenges", "Lcom/studiolaganne/lengendarylens/MTChallenge;", "loadingOverlay", "Landroidx/constraintlayout/widget/ConstraintLayout;", "eventNameTextView", "Landroid/widget/TextView;", "eventDescriptionTextView", "eventImage", "Landroid/widget/ImageView;", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "tabLayout", "Lcom/google/android/material/tabs/TabLayout;", "triviaFragment", "Lcom/studiolaganne/lengendarylens/TriviaFragment;", "challengesFragment", "Lcom/studiolaganne/lengendarylens/ChallengesFragment;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setupTabs", "fetchEventData", "updateUI", "submitTriviaAnswers", "triviaId", "answers", "Lcom/studiolaganne/lengendarylens/MTAnswerAttempt;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CommunityEventActivity extends AppCompatActivity {
    public static final int $stable = 8;
    private ChallengesFragment challengesFragment;
    private List<MTChallenge> currentChallenges;
    private MTCommunityEvent currentEvent;
    private List<MTTrivia> currentTrivia;
    private TextView eventDescriptionTextView;
    private int eventId = -1;
    private ImageView eventImage;
    private TextView eventNameTextView;
    private ConstraintLayout loadingOverlay;
    private TabLayout tabLayout;
    private TriviaFragment triviaFragment;
    private ViewPager2 viewPager;

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.CommunityEventActivity$fetchEventData$1, reason: invalid class name */
    /* JADX INFO: compiled from: CommunityEventActivity.kt */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/studiolaganne/lengendarylens/CommunityEventActivity$fetchEventData$1", "Lretrofit2/Callback;", "Lcom/studiolaganne/lengendarylens/MTCommunityEventResponse;", "onResponse", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "response", "Lretrofit2/Response;", "onFailure", "t", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class AnonymousClass1 implements Callback<MTCommunityEventResponse> {
        AnonymousClass1() {
        }

        static final Unit onFailure$lambda$1(CommunityEventActivity communityEventActivity, boolean z, CustomDialogFragment dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            dialog.dismiss();
            communityEventActivity.finish();
            return Unit.INSTANCE;
        }

        static final Unit onResponse$lambda$0(CommunityEventActivity communityEventActivity, boolean z, CustomDialogFragment dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            dialog.dismiss();
            communityEventActivity.finish();
            return Unit.INSTANCE;
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<MTCommunityEventResponse> call, Throwable t) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(t, "t");
            if (CommunityEventActivity.this.isDestroyed() || CommunityEventActivity.this.isFinishing()) {
                return;
            }
            ConstraintLayout constraintLayout = CommunityEventActivity.this.loadingOverlay;
            if (constraintLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingOverlay");
                constraintLayout = null;
            }
            constraintLayout.setVisibility(8);
            CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
            String string = CommunityEventActivity.this.getString(R.string.server_error);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragment.Builder title = builder.setTitle(string);
            String string2 = CommunityEventActivity.this.getString(R.string.server_error);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragment.Builder body = title.setBody(string2);
            String string3 = CommunityEventActivity.this.getString(R.string.ok);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            final CommunityEventActivity communityEventActivity = CommunityEventActivity.this;
            CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.CommunityEventActivity$fetchEventData$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CommunityEventActivity.AnonymousClass1.onFailure$lambda$1(communityEventActivity, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            });
            FragmentManager supportFragmentManager = CommunityEventActivity.this.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            positiveButton.show(supportFragmentManager, "event_error_dialog");
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<MTCommunityEventResponse> call, Response<MTCommunityEventResponse> response) throws IOException {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            ConstraintLayout constraintLayout = CommunityEventActivity.this.loadingOverlay;
            if (constraintLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingOverlay");
                constraintLayout = null;
            }
            constraintLayout.setVisibility(8);
            if (response.isSuccessful()) {
                MTCommunityEventResponse mTCommunityEventResponseBody = response.body();
                CommunityEventActivity.this.currentEvent = mTCommunityEventResponseBody != null ? mTCommunityEventResponseBody.getEvent() : null;
                CommunityEventActivity.this.currentTrivia = mTCommunityEventResponseBody != null ? mTCommunityEventResponseBody.getTrivia() : null;
                CommunityEventActivity.this.currentChallenges = mTCommunityEventResponseBody != null ? mTCommunityEventResponseBody.getChallenges() : null;
                CommunityEventActivity.this.updateUI();
                return;
            }
            ResponseBody responseBodyErrorBody = response.errorBody();
            if (responseBodyErrorBody != null) {
                responseBodyErrorBody.string();
            }
            CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
            String string = CommunityEventActivity.this.getString(R.string.server_error);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragment.Builder title = builder.setTitle(string);
            String string2 = CommunityEventActivity.this.getString(R.string.server_error);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragment.Builder body = title.setBody(string2);
            String string3 = CommunityEventActivity.this.getString(R.string.ok);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            final CommunityEventActivity communityEventActivity = CommunityEventActivity.this;
            CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.CommunityEventActivity$fetchEventData$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CommunityEventActivity.AnonymousClass1.onResponse$lambda$0(communityEventActivity, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            });
            FragmentManager supportFragmentManager = CommunityEventActivity.this.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            positiveButton.show(supportFragmentManager, "event_error_dialog");
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.CommunityEventActivity$submitTriviaAnswers$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CommunityEventActivity.kt */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/studiolaganne/lengendarylens/CommunityEventActivity$submitTriviaAnswers$1", "Lretrofit2/Callback;", "Lcom/studiolaganne/lengendarylens/MTCommunityEventResponse;", "onResponse", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "response", "Lretrofit2/Response;", "onFailure", "t", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class C11401 implements Callback<MTCommunityEventResponse> {
        C11401() {
        }

        static final Unit onFailure$lambda$3(boolean z, CustomDialogFragment dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onResponse$lambda$0$0$1$0(CommunityEventActivity communityEventActivity, boolean z, CustomDialogFragment dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            dialog.dismiss();
            communityEventActivity.updateUI();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onResponse$lambda$0$0$1$1(CommunityEventActivity communityEventActivity, boolean z, CustomDialogFragment dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            dialog.dismiss();
            communityEventActivity.updateUI();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onResponse$lambda$0$0$1$2(CommunityEventActivity communityEventActivity, boolean z, CustomDialogFragment dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            dialog.dismiss();
            communityEventActivity.updateUI();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onResponse$lambda$1$0$0(boolean z, CustomDialogFragment dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onResponse$lambda$1$1(boolean z, CustomDialogFragment dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onResponse$lambda$2$0(boolean z, CustomDialogFragment dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            dialog.dismiss();
            return Unit.INSTANCE;
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<MTCommunityEventResponse> call, Throwable t) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(t, "t");
            if (CommunityEventActivity.this.isDestroyed() || CommunityEventActivity.this.isFinishing()) {
                return;
            }
            ConstraintLayout constraintLayout = CommunityEventActivity.this.loadingOverlay;
            if (constraintLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingOverlay");
                constraintLayout = null;
            }
            constraintLayout.setVisibility(8);
            CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
            String string = CommunityEventActivity.this.getString(R.string.server_error);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragment.Builder title = builder.setTitle(string);
            String string2 = CommunityEventActivity.this.getString(R.string.server_error);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragment.Builder body = title.setBody(string2);
            String string3 = CommunityEventActivity.this.getString(R.string.ok);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.CommunityEventActivity$submitTriviaAnswers$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CommunityEventActivity.C11401.onFailure$lambda$3(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            });
            FragmentManager supportFragmentManager = CommunityEventActivity.this.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            positiveButton.show(supportFragmentManager, "submit_error_dialog");
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<MTCommunityEventResponse> call, Response<MTCommunityEventResponse> response) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            ConstraintLayout constraintLayout = CommunityEventActivity.this.loadingOverlay;
            Boolean boolValueOf = null;
            Object next = null;
            MTTriviaAttempt mTTriviaAttempt = null;
            if (constraintLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingOverlay");
                constraintLayout = null;
            }
            constraintLayout.setVisibility(8);
            if (!response.isSuccessful()) {
                ResponseBody responseBodyErrorBody = response.errorBody();
                String strString = responseBodyErrorBody != null ? responseBodyErrorBody.string() : null;
                if (strString != null) {
                    CommunityEventActivity communityEventActivity = CommunityEventActivity.this;
                    try {
                        MTResponse mTResponse = (MTResponse) new Gson().fromJson(strString, MTResponse.class);
                        if (mTResponse != null) {
                            CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
                            String string = communityEventActivity.getString(R.string.server_error);
                            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                            CustomDialogFragment.Builder body = builder.setTitle(string).setBody("Error " + mTResponse.getCode() + ": " + mTResponse.getMessage());
                            String string2 = communityEventActivity.getString(R.string.ok);
                            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                            CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string2, new Function2() { // from class: com.studiolaganne.lengendarylens.CommunityEventActivity$submitTriviaAnswers$1$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CommunityEventActivity.C11401.onResponse$lambda$1$0$0(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                                }
                            });
                            FragmentManager supportFragmentManager = communityEventActivity.getSupportFragmentManager();
                            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
                            boolValueOf = Boolean.valueOf(positiveButton.show(supportFragmentManager, "submit_error_dialog"));
                        }
                    } catch (Exception unused) {
                        CustomDialogFragment.Builder builder2 = new CustomDialogFragment.Builder();
                        String string3 = communityEventActivity.getString(R.string.server_error);
                        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                        CustomDialogFragment.Builder title = builder2.setTitle(string3);
                        String string4 = communityEventActivity.getString(R.string.server_error);
                        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                        CustomDialogFragment.Builder body2 = title.setBody(string4);
                        String string5 = communityEventActivity.getString(R.string.ok);
                        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                        CustomDialogFragment.Builder positiveButton2 = body2.setPositiveButton(string5, new Function2() { // from class: com.studiolaganne.lengendarylens.CommunityEventActivity$submitTriviaAnswers$1$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CommunityEventActivity.C11401.onResponse$lambda$1$1(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                            }
                        });
                        FragmentManager supportFragmentManager2 = communityEventActivity.getSupportFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "getSupportFragmentManager(...)");
                        boolValueOf = Boolean.valueOf(positiveButton2.show(supportFragmentManager2, "submit_error_dialog"));
                    }
                    if (boolValueOf != null) {
                        boolValueOf.booleanValue();
                        return;
                    }
                }
                CommunityEventActivity communityEventActivity2 = CommunityEventActivity.this;
                CustomDialogFragment.Builder builder3 = new CustomDialogFragment.Builder();
                String string6 = communityEventActivity2.getString(R.string.server_error);
                Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                CustomDialogFragment.Builder title2 = builder3.setTitle(string6);
                String string7 = communityEventActivity2.getString(R.string.server_error);
                Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
                CustomDialogFragment.Builder body3 = title2.setBody(string7);
                String string8 = communityEventActivity2.getString(R.string.ok);
                Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
                CustomDialogFragment.Builder positiveButton3 = body3.setPositiveButton(string8, new Function2() { // from class: com.studiolaganne.lengendarylens.CommunityEventActivity$submitTriviaAnswers$1$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CommunityEventActivity.C11401.onResponse$lambda$2$0(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                    }
                });
                FragmentManager supportFragmentManager3 = communityEventActivity2.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager3, "getSupportFragmentManager(...)");
                positiveButton3.show(supportFragmentManager3, "submit_error_dialog");
                return;
            }
            MTCommunityEventResponse mTCommunityEventResponseBody = response.body();
            CommunityEventActivity.this.currentEvent = mTCommunityEventResponseBody != null ? mTCommunityEventResponseBody.getEvent() : null;
            CommunityEventActivity.this.currentTrivia = mTCommunityEventResponseBody != null ? mTCommunityEventResponseBody.getTrivia() : null;
            CommunityEventActivity.this.currentChallenges = mTCommunityEventResponseBody != null ? mTCommunityEventResponseBody.getChallenges() : null;
            List list = CommunityEventActivity.this.currentTrivia;
            if (list != null) {
                final CommunityEventActivity communityEventActivity3 = CommunityEventActivity.this;
                MTTrivia mTTrivia = (MTTrivia) CollectionsKt.firstOrNull(list);
                if (mTTrivia != null) {
                    List<MTTriviaAttempt> attempts = mTTrivia.getAttempts();
                    if (attempts != null) {
                        Iterator<T> it = attempts.iterator();
                        if (it.hasNext()) {
                            next = it.next();
                            if (it.hasNext()) {
                                int attempt_number = ((MTTriviaAttempt) next).getAttempt_number();
                                do {
                                    Object next2 = it.next();
                                    int attempt_number2 = ((MTTriviaAttempt) next2).getAttempt_number();
                                    if (attempt_number < attempt_number2) {
                                        next = next2;
                                        attempt_number = attempt_number2;
                                    }
                                } while (it.hasNext());
                            }
                        }
                        mTTriviaAttempt = (MTTriviaAttempt) next;
                    }
                    if (mTTriviaAttempt != null) {
                        int score = mTTriviaAttempt.getScore();
                        int size = mTTrivia.getQuestions().size();
                        int max_attempts = mTTrivia.getMax_attempts() - mTTrivia.getUser_attempts();
                        if (score == size) {
                            CustomDialogFragment.Builder builder4 = new CustomDialogFragment.Builder();
                            String string9 = communityEventActivity3.getString(R.string.trivia_perfect_score_title);
                            Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
                            CustomDialogFragment.Builder title3 = builder4.setTitle(string9);
                            String string10 = communityEventActivity3.getString(R.string.trivia_perfect_score_message);
                            Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
                            CustomDialogFragment.Builder body4 = title3.setBody(string10);
                            String string11 = communityEventActivity3.getString(R.string.ok);
                            Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
                            CustomDialogFragment.Builder positiveButton4 = body4.setPositiveButton(string11, new Function2() { // from class: com.studiolaganne.lengendarylens.CommunityEventActivity$submitTriviaAnswers$1$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CommunityEventActivity.C11401.onResponse$lambda$0$0$1$0(communityEventActivity3, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                                }
                            });
                            FragmentManager supportFragmentManager4 = communityEventActivity3.getSupportFragmentManager();
                            Intrinsics.checkNotNullExpressionValue(supportFragmentManager4, "getSupportFragmentManager(...)");
                            positiveButton4.show(supportFragmentManager4, "trivia_result_dialog");
                            return;
                        }
                        if (max_attempts > 0) {
                            CustomDialogFragment.Builder builder5 = new CustomDialogFragment.Builder();
                            String string12 = communityEventActivity3.getString(R.string.trivia_try_again_title);
                            Intrinsics.checkNotNullExpressionValue(string12, "getString(...)");
                            CustomDialogFragment.Builder title4 = builder5.setTitle(string12);
                            String string13 = communityEventActivity3.getString(R.string.trivia_try_again_message, new Object[]{Integer.valueOf(score), Integer.valueOf(size), Integer.valueOf(max_attempts)});
                            Intrinsics.checkNotNullExpressionValue(string13, "getString(...)");
                            CustomDialogFragment.Builder body5 = title4.setBody(string13);
                            String string14 = communityEventActivity3.getString(R.string.ok);
                            Intrinsics.checkNotNullExpressionValue(string14, "getString(...)");
                            CustomDialogFragment.Builder positiveButton5 = body5.setPositiveButton(string14, new Function2() { // from class: com.studiolaganne.lengendarylens.CommunityEventActivity$submitTriviaAnswers$1$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CommunityEventActivity.C11401.onResponse$lambda$0$0$1$1(communityEventActivity3, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                                }
                            });
                            FragmentManager supportFragmentManager5 = communityEventActivity3.getSupportFragmentManager();
                            Intrinsics.checkNotNullExpressionValue(supportFragmentManager5, "getSupportFragmentManager(...)");
                            positiveButton5.show(supportFragmentManager5, "trivia_result_dialog");
                            return;
                        }
                        CustomDialogFragment.Builder builder6 = new CustomDialogFragment.Builder();
                        String string15 = communityEventActivity3.getString(R.string.trivia_no_attempts_title);
                        Intrinsics.checkNotNullExpressionValue(string15, "getString(...)");
                        CustomDialogFragment.Builder title5 = builder6.setTitle(string15);
                        String string16 = communityEventActivity3.getString(R.string.trivia_no_attempts_message, new Object[]{Integer.valueOf(score), Integer.valueOf(size)});
                        Intrinsics.checkNotNullExpressionValue(string16, "getString(...)");
                        CustomDialogFragment.Builder body6 = title5.setBody(string16);
                        String string17 = communityEventActivity3.getString(R.string.ok);
                        Intrinsics.checkNotNullExpressionValue(string17, "getString(...)");
                        CustomDialogFragment.Builder positiveButton6 = body6.setPositiveButton(string17, new Function2() { // from class: com.studiolaganne.lengendarylens.CommunityEventActivity$submitTriviaAnswers$1$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CommunityEventActivity.C11401.onResponse$lambda$0$0$1$2(communityEventActivity3, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                            }
                        });
                        FragmentManager supportFragmentManager6 = communityEventActivity3.getSupportFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(supportFragmentManager6, "getSupportFragmentManager(...)");
                        positiveButton6.show(supportFragmentManager6, "trivia_result_dialog");
                        return;
                    }
                }
            }
            CommunityEventActivity.this.updateUI();
        }
    }

    private final void fetchEventData() {
        MTUser currentUser = new PreferencesManager(this).getCurrentUser();
        if (currentUser != null) {
            MTApiKt.getMtApi().getEvent(currentUser.getId(), this.eventId).enqueue(new AnonymousClass1());
            return;
        }
        ConstraintLayout constraintLayout = this.loadingOverlay;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingOverlay");
            constraintLayout = null;
        }
        constraintLayout.setVisibility(8);
        finish();
    }

    static final Unit onCreate$lambda$0(CommunityEventActivity communityEventActivity) {
        communityEventActivity.finish();
        return Unit.INSTANCE;
    }

    static final WindowInsetsCompat onCreate$lambda$1(View v, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        Insets insets2 = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
        v.setPadding(insets2.left, insets2.top, insets2.right, insets2.bottom);
        return insets;
    }

    private final void setupTabs() {
        TriviaFragment triviaFragment = new TriviaFragment();
        Bundle bundle = new Bundle();
        ViewPager2 viewPager2 = null;
        bundle.putString("triviaJson", null);
        triviaFragment.setArguments(bundle);
        this.triviaFragment = triviaFragment;
        ChallengesFragment challengesFragment = new ChallengesFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putString("challengesJson", null);
        challengesFragment.setArguments(bundle2);
        this.challengesFragment = challengesFragment;
        final List listListOfNotNull = CollectionsKt.listOfNotNull((Object[]) new Fragment[]{this.triviaFragment, challengesFragment});
        ViewPager2 viewPager22 = this.viewPager;
        if (viewPager22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager22 = null;
        }
        viewPager22.setAdapter(new FragmentStateAdapter(this) { // from class: com.studiolaganne.lengendarylens.CommunityEventActivity.setupTabs.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(this);
            }

            @Override // androidx.viewpager2.adapter.FragmentStateAdapter
            public Fragment createFragment(int position) {
                return position != 0 ? position != 1 ? new Fragment() : listListOfNotNull.get(1) : listListOfNotNull.get(0);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                return listListOfNotNull.size();
            }
        });
        TabLayout tabLayout = this.tabLayout;
        if (tabLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            tabLayout = null;
        }
        ViewPager2 viewPager23 = this.viewPager;
        if (viewPager23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        } else {
            viewPager2 = viewPager23;
        }
        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() { // from class: com.studiolaganne.lengendarylens.CommunityEventActivity$$ExternalSyntheticLambda2
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final void onConfigureTab(TabLayout.Tab tab, int i) {
                CommunityEventActivity.setupTabs$lambda$2(this.f$0, tab, i);
            }
        }).attach();
        TriviaFragment triviaFragment2 = this.triviaFragment;
        if (triviaFragment2 != null) {
            triviaFragment2.setSubmitListener(new Function2() { // from class: com.studiolaganne.lengendarylens.CommunityEventActivity$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CommunityEventActivity.setupTabs$lambda$3(this.f$0, ((Integer) obj).intValue(), (List) obj2);
                }
            });
        }
    }

    static final void setupTabs$lambda$2(CommunityEventActivity communityEventActivity, TabLayout.Tab tab, int i) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        tab.setText(i != 0 ? i != 1 ? null : communityEventActivity.getString(R.string.challenges_tab) : communityEventActivity.getString(R.string.trivia_tab));
    }

    static final Unit setupTabs$lambda$3(CommunityEventActivity communityEventActivity, int i, List answers) {
        Intrinsics.checkNotNullParameter(answers, "answers");
        communityEventActivity.submitTriviaAnswers(i, answers);
        return Unit.INSTANCE;
    }

    private final void submitTriviaAnswers(int triviaId, List<MTAnswerAttempt> answers) {
        MTUser currentUser = new PreferencesManager(this).getCurrentUser();
        if (currentUser == null) {
            return;
        }
        ConstraintLayout constraintLayout = this.loadingOverlay;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingOverlay");
            constraintLayout = null;
        }
        constraintLayout.setVisibility(0);
        ((TextView) findViewById(R.id.updatingTextView)).setText(getString(R.string.validating));
        MTTriviaAnswersBody mTTriviaAnswersBody = new MTTriviaAnswersBody(null, 1, null);
        mTTriviaAnswersBody.getAnswers().addAll(answers);
        MTApiKt.getMtApi().submitTrivia(currentUser.getId(), this.eventId, triviaId, mTTriviaAnswersBody).enqueue(new C11401());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:53:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x010e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateUI() {
        Unit unit;
        Bundle arguments;
        Unit unit2;
        Bundle arguments2;
        MTCommunityEvent mTCommunityEvent = this.currentEvent;
        if (mTCommunityEvent != null) {
            TextView textView = this.eventNameTextView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("eventNameTextView");
                textView = null;
            }
            String name = mTCommunityEvent.getName();
            textView.setText(name != null ? name : "");
            TextView textView2 = this.eventDescriptionTextView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("eventDescriptionTextView");
                textView2 = null;
            }
            String description = mTCommunityEvent.getDescription();
            textView2.setText(description != null ? description : "");
            String deviceLanguage = new PreferencesManager(this).getDeviceLanguage();
            for (MTEntryLocalization mTEntryLocalization : mTCommunityEvent.getLocalization()) {
                String lowerCase = mTEntryLocalization.getLocale().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                String lowerCase2 = deviceLanguage.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                if (Intrinsics.areEqual(lowerCase, lowerCase2)) {
                    TextView textView3 = this.eventNameTextView;
                    if (textView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("eventNameTextView");
                        textView3 = null;
                    }
                    textView3.setText(mTEntryLocalization.getName());
                    TextView textView4 = this.eventDescriptionTextView;
                    if (textView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("eventDescriptionTextView");
                        textView4 = null;
                    }
                    textView4.setText(mTEntryLocalization.getDescription());
                }
            }
            String logo_url = mTCommunityEvent.getLogo_url();
            if (logo_url != null && logo_url.length() > 0) {
                RequestBuilder requestBuilderPlaceholder = Glide.with((FragmentActivity) this).load(logo_url).placeholder(R.drawable.medal_outline);
                ImageView imageView = this.eventImage;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("eventImage");
                    imageView = null;
                }
                requestBuilderPlaceholder.into(imageView);
            }
        }
        List<MTTrivia> list = this.currentTrivia;
        if (list == null) {
            TriviaFragment triviaFragment = this.triviaFragment;
            if (triviaFragment != null) {
                triviaFragment.setTrivia(null);
                Unit unit3 = Unit.INSTANCE;
            }
        } else if (list.isEmpty()) {
            TriviaFragment triviaFragment2 = this.triviaFragment;
            if (triviaFragment2 != null) {
                triviaFragment2.setTrivia(null);
                unit2 = Unit.INSTANCE;
            }
            if (unit2 == null) {
            }
        } else {
            MTTrivia mTTrivia = list.get(0);
            String json = new Gson().toJson(mTTrivia);
            TriviaFragment triviaFragment3 = this.triviaFragment;
            if (triviaFragment3 != null && (arguments2 = triviaFragment3.getArguments()) != null) {
                arguments2.putString("triviaJson", json);
            }
            TriviaFragment triviaFragment4 = this.triviaFragment;
            if (triviaFragment4 != null) {
                triviaFragment4.setTrivia(mTTrivia);
                unit2 = Unit.INSTANCE;
            } else {
                unit2 = null;
            }
            if (unit2 == null) {
            }
        }
        List<MTChallenge> list2 = this.currentChallenges;
        if (list2 != null) {
            String json2 = new Gson().toJson(list2);
            ChallengesFragment challengesFragment = this.challengesFragment;
            if (challengesFragment != null && (arguments = challengesFragment.getArguments()) != null) {
                arguments.putString("challengesJson", json2);
            }
            ChallengesFragment challengesFragment2 = this.challengesFragment;
            if (challengesFragment2 != null) {
                challengesFragment2.setChallenges(list2);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit != null) {
                return;
            }
        }
        ChallengesFragment challengesFragment3 = this.challengesFragment;
        if (challengesFragment3 != null) {
            challengesFragment3.setChallenges(null);
            Unit unit4 = Unit.INSTANCE;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ConstraintLayout constraintLayout = null;
        EdgeToEdge.enable$default(this, null, null, 3, null);
        setContentView(R.layout.activity_community_event);
        int intExtra = getIntent().getIntExtra("eventId", -1);
        this.eventId = intExtra;
        if (intExtra == -1) {
            finish();
            return;
        }
        View viewFindViewById = findViewById(R.id.loadingOverlay);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.loadingOverlay = (ConstraintLayout) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.eventNameTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.eventNameTextView = (TextView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.eventDescriptionTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.eventDescriptionTextView = (TextView) viewFindViewById3;
        View viewFindViewById4 = findViewById(R.id.eventImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.eventImage = (ImageView) viewFindViewById4;
        View viewFindViewById5 = findViewById(R.id.viewPager);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.viewPager = (ViewPager2) viewFindViewById5;
        View viewFindViewById6 = findViewById(R.id.tabs);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.tabLayout = (TabLayout) viewFindViewById6;
        View viewFindViewById7 = findViewById(R.id.backLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById7, new Function0() { // from class: com.studiolaganne.lengendarylens.CommunityEventActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CommunityEventActivity.onCreate$lambda$0(this.f$0);
            }
        });
        setupTabs();
        ConstraintLayout constraintLayout2 = this.loadingOverlay;
        if (constraintLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingOverlay");
        } else {
            constraintLayout = constraintLayout2;
        }
        constraintLayout.setVisibility(0);
        fetchEventData();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), new OnApplyWindowInsetsListener() { // from class: com.studiolaganne.lengendarylens.CommunityEventActivity$$ExternalSyntheticLambda1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return CommunityEventActivity.onCreate$lambda$1(view, windowInsetsCompat);
            }
        });
    }
}
