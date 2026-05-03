package com.studiolaganne.lengendarylens;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OnboardingActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/studiolaganne/lengendarylens/OnboardingActivity;", "Landroidx/activity/ComponentActivity;", "<init>", "()V", "firebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class OnboardingActivity extends ComponentActivity {
    public static final int $stable = 8;
    private FirebaseAnalytics firebaseAnalytics;

    static final Unit onCreate$lambda$0(final OnboardingActivity onboardingActivity, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C56@2272L1410,56@2258L1424:OnboardingActivity.kt#r9tj48");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1284999766, i, -1, "com.studiolaganne.lengendarylens.OnboardingActivity.onCreate.<anonymous> (OnboardingActivity.kt:56)");
            }
            MaterialThemeKt.MaterialTheme(null, null, null, ComposableLambdaKt.rememberComposableLambda(649375870, true, new Function2() { // from class: com.studiolaganne.lengendarylens.OnboardingActivity$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingActivity.onCreate$lambda$0$0(this.f$0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 3072, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0$0(final OnboardingActivity onboardingActivity, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C59@2402L745,75@3189L461,57@2290L1378:OnboardingActivity.kt#r9tj48");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(649375870, i, -1, "com.studiolaganne.lengendarylens.OnboardingActivity.onCreate.<anonymous>.<anonymous> (OnboardingActivity.kt:57)");
            }
            FirebaseAnalytics firebaseAnalytics = onboardingActivity.firebaseAnalytics;
            if (firebaseAnalytics == null) {
                Intrinsics.throwUninitializedPropertyAccessException("firebaseAnalytics");
                firebaseAnalytics = null;
            }
            ComposerKt.sourceInformationMarkerStart(composer, 1279958055, "CC(remember):OnboardingActivity.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(onboardingActivity);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.studiolaganne.lengendarylens.OnboardingActivity$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return OnboardingActivity.onCreate$lambda$0$0$0$0(this.f$0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1279982955, "CC(remember):OnboardingActivity.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(onboardingActivity);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.studiolaganne.lengendarylens.OnboardingActivity$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return OnboardingActivity.onCreate$lambda$0$0$1$0(this.f$0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            OnboardingActivityKt.OnboardingScreen(firebaseAnalytics, function0, (Function0) objRememberedValue2, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0$0$0$0(OnboardingActivity onboardingActivity) {
        FirebaseAnalytics firebaseAnalytics = onboardingActivity.firebaseAnalytics;
        if (firebaseAnalytics == null) {
            Intrinsics.throwUninitializedPropertyAccessException("firebaseAnalytics");
            firebaseAnalytics = null;
        }
        firebaseAnalytics.logEvent("onboarding_sign_in_tapped", null);
        OnboardingActivity onboardingActivity2 = onboardingActivity;
        new PreferencesManager(onboardingActivity2).setBoolean(PreferencesManager.GO_TO_SIGN_IN, true);
        Intent intent = new Intent(onboardingActivity2, (Class<?>) MainActivity.class);
        intent.addFlags(335544320);
        onboardingActivity.startActivity(intent);
        onboardingActivity.finish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0$0$1$0(OnboardingActivity onboardingActivity) {
        FirebaseAnalytics firebaseAnalytics = onboardingActivity.firebaseAnalytics;
        if (firebaseAnalytics == null) {
            Intrinsics.throwUninitializedPropertyAccessException("firebaseAnalytics");
            firebaseAnalytics = null;
        }
        firebaseAnalytics.logEvent("onboarding_completed", null);
        Intent intent = new Intent(onboardingActivity, (Class<?>) SignUpActivity.class);
        intent.addFlags(335544320);
        onboardingActivity.startActivity(intent);
        onboardingActivity.finish();
        return Unit.INSTANCE;
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        this.firebaseAnalytics = firebaseAnalytics;
        ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(-1284999766, true, new Function2() { // from class: com.studiolaganne.lengendarylens.OnboardingActivity$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return OnboardingActivity.onCreate$lambda$0(this.f$0, (Composer) obj, ((Integer) obj2).intValue());
            }
        }), 1, null);
        FirebaseAnalytics firebaseAnalytics2 = this.firebaseAnalytics;
        if (firebaseAnalytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("firebaseAnalytics");
            firebaseAnalytics2 = null;
        }
        firebaseAnalytics2.logEvent("onboarding_started", null);
    }
}
