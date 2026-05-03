package com.studiolaganne.lengendarylens;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AdditionalUserInfo;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.auth.OAuthProvider;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.messaging.Constants;
import com.google.firebase.messaging.FirebaseMessaging;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.ListenerConversionsKt;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.PurchasesError;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import com.studiolaganne.lengendarylens.SignUpActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: SignUpActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0016H\u0014J\u0012\u0010\u001a\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u000e\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u001fJ\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u001fH\u0002J\b\u0010$\u001a\u00020\u0018H\u0002J\u0010\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u001fH\u0002J\u0012\u0010'\u001a\u0004\u0018\u00010\u001f2\u0006\u0010&\u001a\u00020\u001fH\u0002J \u0010(\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\u001fH\u0002J\u0010\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u0010-\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u001fH\u0002J\u0006\u0010.\u001a\u00020\u0018J\b\u0010/\u001a\u00020\u0018H\u0002J\u0012\u00100\u001a\u00020\u00182\b\u00101\u001a\u0004\u0018\u00010\u0016H\u0002J\"\u00102\u001a\u00020\u00182\u0006\u00103\u001a\u00020\u001f2\b\u0010)\u001a\u0004\u0018\u00010\u001f2\b\u0010#\u001a\u0004\u0018\u00010\u001fJ\u000e\u00104\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u001fJ\u0016\u00105\u001a\u00020\u00182\u0006\u00106\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\u001fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/studiolaganne/lengendarylens/SignUpActivity;", "Lcom/studiolaganne/lengendarylens/BaseActivity;", "<init>", "()V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "googleSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "firebaseAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "signUpMode", "", "emailEditText", "Lcom/google/android/material/textfield/TextInputEditText;", "passwordEditText", "firstnameEditText", "signInWithEmailActionButton", "Landroid/view/View;", "signInText", "Landroid/widget/TextView;", "googleSignInLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "onNewIntent", "", "intent", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "startOAuthFlow", "provider", "", "onOAuthError", "errorMessage", "isValidEmail", "email", "validateInputs", "isValidPassword", "password", "validatePassword", "createUserWithEmailAndPassword", "firstname", "sendVerificationEmailAndShowInstructions", "user", "Lcom/google/firebase/auth/FirebaseUser;", "showVerificationEmailSentDialog", "onEmailVerified", "handleSuccessfulFirebaseAuth", "handleSignInResult", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "onSignInSuccess", "token", "onSignInFailure", "onOAuthSignInSuccess", "code", "type", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SignUpActivity extends BaseActivity {
    public static final int $stable = 8;
    private TextInputEditText emailEditText;
    private FirebaseAuth firebaseAuth;
    private TextInputEditText firstnameEditText;
    private GoogleSignInClient googleSignInClient;
    private TextInputEditText passwordEditText;
    private TextView signInText;
    private View signInWithEmailActionButton;
    private final CoroutineScope coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
    private boolean signUpMode = true;
    private final ActivityResultLauncher<Intent> googleSignInLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.SignUpActivity$$ExternalSyntheticLambda19
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) throws Throwable {
            SignUpActivity.googleSignInLauncher$lambda$0(this.f$0, (ActivityResult) obj);
        }
    });

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.SignUpActivity$onOAuthSignInSuccess$1, reason: invalid class name */
    /* JADX INFO: compiled from: SignUpActivity.kt */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/studiolaganne/lengendarylens/SignUpActivity$onOAuthSignInSuccess$1", "Lretrofit2/Callback;", "Lcom/studiolaganne/lengendarylens/MTLoginResponse;", "onResponse", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "response", "Lretrofit2/Response;", "onFailure", "t", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class AnonymousClass1 implements Callback<MTLoginResponse> {
        final /* synthetic */ View $overlay;
        final /* synthetic */ PreferencesManager $prefs;
        final /* synthetic */ SignUpActivity this$0;

        AnonymousClass1(View view, PreferencesManager preferencesManager, SignUpActivity signUpActivity) {
            this.$overlay = view;
            this.$prefs = preferencesManager;
            this.this$0 = signUpActivity;
        }

        static final Unit onResponse$lambda$0(final PreferencesManager preferencesManager, final SignUpActivity signUpActivity, final View view, AuthResult authResult) {
            Task<GetTokenResult> idToken;
            FirebaseUser user = authResult.getUser();
            if (user != null && (idToken = user.getIdToken(true)) != null) {
                final Function1 function1 = new Function1() { // from class: com.studiolaganne.lengendarylens.SignUpActivity$onOAuthSignInSuccess$1$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SignUpActivity.AnonymousClass1.onResponse$lambda$0$0(preferencesManager, signUpActivity, view, (GetTokenResult) obj);
                    }
                };
                idToken.addOnSuccessListener(new OnSuccessListener() { // from class: com.studiolaganne.lengendarylens.SignUpActivity$onOAuthSignInSuccess$1$$ExternalSyntheticLambda4
                    @Override // com.google.android.gms.tasks.OnSuccessListener
                    public final void onSuccess(Object obj) {
                        function1.invoke(obj);
                    }
                });
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onResponse$lambda$0$0(PreferencesManager preferencesManager, SignUpActivity signUpActivity, View view, GetTokenResult getTokenResult) {
            String token = getTokenResult.getToken();
            String str = token;
            if (str == null || str.length() == 0) {
                Log.w("MTApi", "FIREBASE SIGNIN: Token was null or empty");
                view.setVisibility(8);
                signUpActivity.onSignInFailure("Token was null or empty");
            } else {
                preferencesManager.setString(PreferencesManager.FIREBASE_TOKEN, token);
                preferencesManager.setString(PreferencesManager.AUTH_PROVIDER, FirebaseAuthProvider.PROVIDER_ID);
                preferencesManager.setTokenExpiryTime(System.currentTimeMillis() + 3300000);
                signUpActivity.onSignInSuccess(token, null, null);
            }
            return Unit.INSTANCE;
        }

        static final void onResponse$lambda$2(View view, SignUpActivity signUpActivity, Exception e) {
            Intrinsics.checkNotNullParameter(e, "e");
            Log.e("MTApi", "Firebase sign-in with custom token failed", e);
            view.setVisibility(8);
            signUpActivity.onSignInFailure("Firebase sign-in failed: " + e.getLocalizedMessage());
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<MTLoginResponse> call, Throwable t) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(t, "t");
            this.$overlay.setVisibility(8);
            Log.d("MTApi", "Login failed: " + t.getLocalizedMessage());
            SignUpActivity signUpActivity = this.this$0;
            String localizedMessage = t.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = "Unknown error";
            }
            signUpActivity.onSignInFailure(localizedMessage);
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<MTLoginResponse> call, Response<MTLoginResponse> response) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            if (response.isSuccessful()) {
                MTLoginResponse mTLoginResponseBody = response.body();
                String customToken = mTLoginResponseBody != null ? mTLoginResponseBody.getCustomToken() : null;
                String str = customToken;
                if (str != null && str.length() != 0) {
                    Task<AuthResult> taskSignInWithCustomToken = FirebaseAuth.getInstance().signInWithCustomToken(customToken);
                    final PreferencesManager preferencesManager = this.$prefs;
                    final SignUpActivity signUpActivity = this.this$0;
                    final View view = this.$overlay;
                    final Function1 function1 = new Function1() { // from class: com.studiolaganne.lengendarylens.SignUpActivity$onOAuthSignInSuccess$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SignUpActivity.AnonymousClass1.onResponse$lambda$0(preferencesManager, signUpActivity, view, (AuthResult) obj);
                        }
                    };
                    Task<AuthResult> taskAddOnSuccessListener = taskSignInWithCustomToken.addOnSuccessListener(new OnSuccessListener() { // from class: com.studiolaganne.lengendarylens.SignUpActivity$onOAuthSignInSuccess$1$$ExternalSyntheticLambda1
                        @Override // com.google.android.gms.tasks.OnSuccessListener
                        public final void onSuccess(Object obj) {
                            function1.invoke(obj);
                        }
                    });
                    final View view2 = this.$overlay;
                    final SignUpActivity signUpActivity2 = this.this$0;
                    taskAddOnSuccessListener.addOnFailureListener(new OnFailureListener() { // from class: com.studiolaganne.lengendarylens.SignUpActivity$onOAuthSignInSuccess$1$$ExternalSyntheticLambda2
                        @Override // com.google.android.gms.tasks.OnFailureListener
                        public final void onFailure(Exception exc) {
                            SignUpActivity.AnonymousClass1.onResponse$lambda$2(view2, signUpActivity2, exc);
                        }
                    });
                    return;
                }
            }
            this.$overlay.setVisibility(8);
        }
    }

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.SignUpActivity$onSignInSuccess$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SignUpActivity.kt */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/studiolaganne/lengendarylens/SignUpActivity$onSignInSuccess$1", "Lretrofit2/Callback;", "Lcom/studiolaganne/lengendarylens/MTLoginResponse;", "onResponse", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "response", "Lretrofit2/Response;", "onFailure", "t", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class C12561 implements Callback<MTLoginResponse> {
        final /* synthetic */ View $overlay;
        final /* synthetic */ PreferencesManager $prefs;
        final /* synthetic */ SignUpActivity this$0;

        C12561(PreferencesManager preferencesManager, SignUpActivity signUpActivity, View view) {
            this.$prefs = preferencesManager;
            this.this$0 = signUpActivity;
            this.$overlay = view;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onResponse$lambda$0$0(PurchasesError it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onResponse$lambda$0$1(SignUpActivity signUpActivity, CustomerInfo customerInfo, boolean z) {
            Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
            MythicPlusManager.INSTANCE.handleCustomerInfoUpdate(signUpActivity, customerInfo);
            return Unit.INSTANCE;
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<MTLoginResponse> call, Throwable t) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(t, "t");
            this.$overlay.setVisibility(8);
            Log.d("MTApi", "Login failed: " + t.getLocalizedMessage());
            SignUpActivity signUpActivity = this.this$0;
            String localizedMessage = t.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = "Unknown error";
            }
            signUpActivity.onSignInFailure(localizedMessage);
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<MTLoginResponse> call, Response<MTLoginResponse> response) {
            List<MTPlaygroup> listEmptyList;
            List<MTFriend> listEmptyList2;
            List<MTDeck> listEmptyList3;
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            if (response.isSuccessful()) {
                MTLoginResponse mTLoginResponseBody = response.body();
                MTUser user = mTLoginResponseBody != null ? mTLoginResponseBody.getUser() : null;
                MTLoginResponse mTLoginResponseBody2 = response.body();
                if (mTLoginResponseBody2 == null || (listEmptyList = mTLoginResponseBody2.getPlaygroups()) == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                MTLoginResponse mTLoginResponseBody3 = response.body();
                if (mTLoginResponseBody3 == null || (listEmptyList2 = mTLoginResponseBody3.getFriends()) == null) {
                    listEmptyList2 = CollectionsKt.emptyList();
                }
                MTLoginResponse mTLoginResponseBody4 = response.body();
                if (mTLoginResponseBody4 == null || (listEmptyList3 = mTLoginResponseBody4.getDecks()) == null) {
                    listEmptyList3 = CollectionsKt.emptyList();
                }
                if (user != null) {
                    PreferencesManager preferencesManager = this.$prefs;
                    final SignUpActivity signUpActivity = this.this$0;
                    CustomerIOHelper.INSTANCE.maybeIdentifyAfterLogin(user, preferencesManager);
                    ListenerConversionsKt.logInWith(Purchases.INSTANCE.getSharedInstance(), String.valueOf(user.getId()), new Function1() { // from class: com.studiolaganne.lengendarylens.SignUpActivity$onSignInSuccess$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SignUpActivity.C12561.onResponse$lambda$0$0((PurchasesError) obj);
                        }
                    }, new Function2() { // from class: com.studiolaganne.lengendarylens.SignUpActivity$onSignInSuccess$1$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SignUpActivity.C12561.onResponse$lambda$0$1(signUpActivity, (CustomerInfo) obj, ((Boolean) obj2).booleanValue());
                        }
                    });
                    FirebaseAnalytics.getInstance(signUpActivity).setUserProperty("is_logged_in", "true");
                    preferencesManager.saveCurrentUser(user);
                    preferencesManager.saveCurrentUserPlaygroups(listEmptyList);
                    preferencesManager.saveCurrentUserFriends(listEmptyList2);
                    preferencesManager.saveCurrentUserDecks(listEmptyList3);
                    preferencesManager.setBoolean(PreferencesManager.NEED_USER_RELOAD, true);
                }
            }
            this.$prefs.setBoolean(PreferencesManager.ASK_FOR_NOTIFICATIONS, true);
            Intent intent = new Intent(this.this$0, (Class<?>) MainActivity.class);
            intent.addFlags(335544320);
            this.this$0.startActivity(intent);
        }
    }

    private final void createUserWithEmailAndPassword(String email, String password, final String firstname) {
        View viewFindViewById = findViewById(R.id.overlay);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        viewFindViewById.setVisibility(0);
        ((TextView) findViewById(R.id.signingUpTextView)).setVisibility(0);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.SignUpActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SignUpActivity.createUserWithEmailAndPassword$lambda$0(view);
            }
        });
        FirebaseAuth firebaseAuth = this.firebaseAuth;
        if (firebaseAuth == null) {
            Intrinsics.throwUninitializedPropertyAccessException("firebaseAuth");
            firebaseAuth = null;
        }
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener() { // from class: com.studiolaganne.lengendarylens.SignUpActivity$$ExternalSyntheticLambda11
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                SignUpActivity.createUserWithEmailAndPassword$lambda$1(firstname, this, task);
            }
        });
    }

    static final void createUserWithEmailAndPassword$lambda$0(View view) {
    }

    static final void createUserWithEmailAndPassword$lambda$1(String str, final SignUpActivity signUpActivity, Task task) {
        String localizedMessage;
        Task<Void> taskUpdateProfile;
        Intrinsics.checkNotNullParameter(task, "task");
        if (!task.isSuccessful()) {
            Exception exception = task.getException();
            if (exception == null || (localizedMessage = exception.getLocalizedMessage()) == null) {
                localizedMessage = "Authentication failed";
            }
            signUpActivity.onSignInFailure(localizedMessage);
            View viewFindViewById = signUpActivity.findViewById(R.id.overlay);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            viewFindViewById.setVisibility(8);
            return;
        }
        UserProfileChangeRequest userProfileChangeRequestBuild = new UserProfileChangeRequest.Builder().setDisplayName(str).build();
        Intrinsics.checkNotNullExpressionValue(userProfileChangeRequestBuild, "build(...)");
        FirebaseAuth firebaseAuth = signUpActivity.firebaseAuth;
        if (firebaseAuth == null) {
            Intrinsics.throwUninitializedPropertyAccessException("firebaseAuth");
            firebaseAuth = null;
        }
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if (currentUser == null || (taskUpdateProfile = currentUser.updateProfile(userProfileChangeRequestBuild)) == null) {
            return;
        }
        taskUpdateProfile.addOnCompleteListener(new OnCompleteListener() { // from class: com.studiolaganne.lengendarylens.SignUpActivity$$ExternalSyntheticLambda9
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task2) {
                SignUpActivity.createUserWithEmailAndPassword$lambda$1$0(this.f$0, task2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createUserWithEmailAndPassword$lambda$1$0(SignUpActivity signUpActivity, Task profileTask) {
        Intrinsics.checkNotNullParameter(profileTask, "profileTask");
        FirebaseAuth firebaseAuth = signUpActivity.firebaseAuth;
        if (firebaseAuth == null) {
            Intrinsics.throwUninitializedPropertyAccessException("firebaseAuth");
            firebaseAuth = null;
        }
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if (currentUser != null) {
            if (currentUser.isEmailVerified()) {
                signUpActivity.handleSuccessfulFirebaseAuth();
            } else {
                signUpActivity.sendVerificationEmailAndShowInstructions(currentUser);
            }
        }
    }

    static final void googleSignInLauncher$lambda$0(SignUpActivity signUpActivity, ActivityResult result) throws Throwable {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == -1) {
            signUpActivity.handleSignInResult(result.getData());
        }
    }

    private final void handleSignInResult(Intent data) throws Throwable {
        View viewFindViewById = findViewById(R.id.overlay);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        viewFindViewById.setVisibility(0);
        ((TextView) findViewById(R.id.signingUpTextView)).setVisibility(0);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.SignUpActivity$$ExternalSyntheticLambda20
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SignUpActivity.handleSignInResult$lambda$0(view);
            }
        });
        Task<GoogleSignInAccount> signedInAccountFromIntent = GoogleSignIn.getSignedInAccountFromIntent(data);
        Intrinsics.checkNotNullExpressionValue(signedInAccountFromIntent, "getSignedInAccountFromIntent(...)");
        try {
            GoogleSignInAccount result = signedInAccountFromIntent.getResult(ApiException.class);
            if (result == null) {
                throw new ApiException(Status.RESULT_CANCELED);
            }
            String idToken = result.getIdToken();
            if (idToken == null) {
                onSignInFailure("No ID token received from Google account.");
                return;
            }
            FirebaseAuth firebaseAuth = null;
            AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
            Intrinsics.checkNotNullExpressionValue(credential, "getCredential(...)");
            FirebaseAuth firebaseAuth2 = this.firebaseAuth;
            if (firebaseAuth2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("firebaseAuth");
            } else {
                firebaseAuth = firebaseAuth2;
            }
            Intrinsics.checkNotNull(firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener() { // from class: com.studiolaganne.lengendarylens.SignUpActivity$$ExternalSyntheticLambda21
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    SignUpActivity.handleSignInResult$lambda$1(this.f$0, task);
                }
            }));
        } catch (ApiException e) {
            onSignInFailure("Google sign-in failed: " + e.getStatusCode());
        }
    }

    static final void handleSignInResult$lambda$0(View view) {
    }

    static final void handleSignInResult$lambda$1(final SignUpActivity signUpActivity, Task authTask) {
        Task<GetTokenResult> idToken;
        Intrinsics.checkNotNullParameter(authTask, "authTask");
        if (!authTask.isSuccessful()) {
            signUpActivity.onSignInFailure("Firebase sign-in failed.");
            return;
        }
        FirebaseAuth firebaseAuth = signUpActivity.firebaseAuth;
        if (firebaseAuth == null) {
            Intrinsics.throwUninitializedPropertyAccessException("firebaseAuth");
            firebaseAuth = null;
        }
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if (currentUser == null || (idToken = currentUser.getIdToken(true)) == null) {
            return;
        }
        idToken.addOnCompleteListener(new OnCompleteListener() { // from class: com.studiolaganne.lengendarylens.SignUpActivity$$ExternalSyntheticLambda14
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                SignUpActivity.handleSignInResult$lambda$1$0(this.f$0, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleSignInResult$lambda$1$0(SignUpActivity signUpActivity, Task tokenTask) {
        Intrinsics.checkNotNullParameter(tokenTask, "tokenTask");
        if (!tokenTask.isSuccessful()) {
            signUpActivity.onSignInFailure("Failed to retrieve Firebase ID token.");
            return;
        }
        GetTokenResult getTokenResult = (GetTokenResult) tokenTask.getResult();
        String token = getTokenResult != null ? getTokenResult.getToken() : null;
        if (token == null) {
            signUpActivity.onSignInFailure("No Firebase token received.");
            return;
        }
        PreferencesManager preferencesManager = new PreferencesManager(signUpActivity);
        preferencesManager.setString(PreferencesManager.FIREBASE_TOKEN, token);
        preferencesManager.setString(PreferencesManager.AUTH_PROVIDER, FirebaseAuthProvider.PROVIDER_ID);
        preferencesManager.setTokenExpiryTime(System.currentTimeMillis() + 3300000);
        signUpActivity.onSignInSuccess(token, null, null);
    }

    private final void handleSuccessfulFirebaseAuth() {
        Task<GetTokenResult> idToken;
        FirebaseAuth firebaseAuth = this.firebaseAuth;
        if (firebaseAuth == null) {
            Intrinsics.throwUninitializedPropertyAccessException("firebaseAuth");
            firebaseAuth = null;
        }
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if (currentUser == null || (idToken = currentUser.getIdToken(true)) == null) {
            return;
        }
        idToken.addOnCompleteListener(new OnCompleteListener() { // from class: com.studiolaganne.lengendarylens.SignUpActivity$$ExternalSyntheticLambda10
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                SignUpActivity.handleSuccessfulFirebaseAuth$lambda$0(this.f$0, task);
            }
        });
    }

    static final void handleSuccessfulFirebaseAuth$lambda$0(SignUpActivity signUpActivity, Task tokenTask) {
        Intrinsics.checkNotNullParameter(tokenTask, "tokenTask");
        if (!tokenTask.isSuccessful()) {
            signUpActivity.onSignInFailure("Failed to retrieve Firebase ID token.");
            return;
        }
        GetTokenResult getTokenResult = (GetTokenResult) tokenTask.getResult();
        String token = getTokenResult != null ? getTokenResult.getToken() : null;
        if (token == null) {
            signUpActivity.onSignInFailure("No Firebase token received.");
            return;
        }
        PreferencesManager preferencesManager = new PreferencesManager(signUpActivity);
        preferencesManager.setString(PreferencesManager.FIREBASE_TOKEN, token);
        preferencesManager.setString(PreferencesManager.AUTH_PROVIDER, FirebaseAuthProvider.PROVIDER_ID);
        preferencesManager.setTokenExpiryTime(System.currentTimeMillis() + 3300000);
        signUpActivity.onSignInSuccess(token, null, null);
    }

    private final boolean isValidEmail(String email) {
        String str = email;
        if (str.length() == 0) {
            return false;
        }
        return Patterns.EMAIL_ADDRESS.matcher(str).matches();
    }

    private final boolean isValidPassword(String password) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (password.length() < 8) {
            return false;
        }
        String str = password;
        int i = 0;
        while (true) {
            if (i >= str.length()) {
                z = false;
                break;
            }
            if (Character.isUpperCase(str.charAt(i))) {
                z = true;
                break;
            }
            i++;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= str.length()) {
                z2 = false;
                break;
            }
            if (Character.isLowerCase(str.charAt(i2))) {
                z2 = true;
                break;
            }
            i2++;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= str.length()) {
                z3 = false;
                break;
            }
            if (Character.isDigit(str.charAt(i3))) {
                z3 = true;
                break;
            }
            i3++;
        }
        int i4 = 0;
        while (true) {
            if (i4 >= str.length()) {
                z4 = false;
                break;
            }
            if (!Character.isLetterOrDigit(str.charAt(i4))) {
                z4 = true;
                break;
            }
            i4++;
        }
        return z && z2 && z3 && z4;
    }

    static final Unit onCreate$lambda$0(SignUpActivity signUpActivity) {
        Intent intent = new Intent(signUpActivity, (Class<?>) MainActivity.class);
        intent.addFlags(335544320);
        signUpActivity.startActivity(intent);
        signUpActivity.finish();
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$1(SignUpActivity signUpActivity) {
        BuildersKt__Builders_commonKt.launch$default(signUpActivity.coroutineScope, null, null, new SignUpActivity$onCreate$2$1(signUpActivity, null), 3, null);
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$10(final SignUpActivity signUpActivity) {
        OAuthProvider.Builder builderNewBuilder = OAuthProvider.newBuilder("apple.com");
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder(...)");
        builderNewBuilder.setScopes(CollectionsKt.listOf((Object[]) new String[]{"email", "name"}));
        builderNewBuilder.addCustomParameter(AndroidContextPlugin.LOCALE_KEY, Locale.getDefault().getLanguage());
        FirebaseAuth firebaseAuth = signUpActivity.firebaseAuth;
        if (firebaseAuth == null) {
            Intrinsics.throwUninitializedPropertyAccessException("firebaseAuth");
            firebaseAuth = null;
        }
        Task<AuthResult> taskStartActivityForSignInWithProvider = firebaseAuth.startActivityForSignInWithProvider(signUpActivity, builderNewBuilder.build());
        final Function1 function1 = new Function1() { // from class: com.studiolaganne.lengendarylens.SignUpActivity$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SignUpActivity.onCreate$lambda$10$0(this.f$0, (AuthResult) obj);
            }
        };
        taskStartActivityForSignInWithProvider.addOnSuccessListener(new OnSuccessListener() { // from class: com.studiolaganne.lengendarylens.SignUpActivity$$ExternalSyntheticLambda17
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                function1.invoke(obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.studiolaganne.lengendarylens.SignUpActivity$$ExternalSyntheticLambda18
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                SignUpActivity.onCreate$lambda$10$2(this.f$0, exc);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v25, types: [T, java.lang.Object] */
    public static final Unit onCreate$lambda$10$0(final SignUpActivity signUpActivity, AuthResult authResult) {
        Task<GetTokenResult> idToken;
        CharSequence charSequence;
        View viewFindViewById = signUpActivity.findViewById(R.id.overlay);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        viewFindViewById.setVisibility(0);
        ((TextView) signUpActivity.findViewById(R.id.signingUpTextView)).setVisibility(0);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.SignUpActivity$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SignUpActivity.onCreate$lambda$10$0$0(view);
            }
        });
        FirebaseUser user = authResult.getUser();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef.element = user != null ? user.getEmail() : 0;
        String displayName = user != null ? user.getDisplayName() : null;
        if (displayName != null && displayName.length() != 0) {
            objectRef2.element = CollectionsKt.firstOrNull(StringsKt.split$default((CharSequence) displayName, new String[]{" "}, false, 0, 6, (Object) null));
        }
        AdditionalUserInfo additionalUserInfo = authResult.getAdditionalUserInfo();
        Map<String, Object> profile = additionalUserInfo != null ? additionalUserInfo.getProfile() : null;
        if (profile != null) {
            CharSequence charSequence2 = (CharSequence) objectRef.element;
            if ((charSequence2 == null || charSequence2.length() == 0) && profile.containsKey("email")) {
                Object obj = profile.get("email");
                objectRef.element = obj instanceof String ? (String) obj : 0;
            }
            if (profile.containsKey("name")) {
                Object obj2 = profile.get("name");
                Map map = obj2 instanceof Map ? (Map) obj2 : null;
                if (map != null && (((charSequence = (CharSequence) objectRef2.element) == null || charSequence.length() == 0) && map.containsKey("firstName"))) {
                    Object obj3 = map.get("firstName");
                    objectRef2.element = obj3 instanceof String ? (String) obj3 : 0;
                }
            }
            CharSequence charSequence3 = (CharSequence) objectRef2.element;
            if ((charSequence3 == null || charSequence3.length() == 0) && profile.containsKey("firstName")) {
                Object obj4 = profile.get("firstName");
                objectRef2.element = obj4 instanceof String ? (String) obj4 : 0;
            }
        }
        if (user != null && (idToken = user.getIdToken(true)) != null) {
            idToken.addOnCompleteListener(new OnCompleteListener() { // from class: com.studiolaganne.lengendarylens.SignUpActivity$$ExternalSyntheticLambda23
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    SignUpActivity.onCreate$lambda$10$0$1(this.f$0, objectRef2, objectRef, task);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$10$0$0(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void onCreate$lambda$10$0$1(SignUpActivity signUpActivity, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, Task tokenTask) {
        Intrinsics.checkNotNullParameter(tokenTask, "tokenTask");
        if (!tokenTask.isSuccessful()) {
            signUpActivity.onSignInFailure("Failed to retrieve Firebase ID token.");
            return;
        }
        GetTokenResult getTokenResult = (GetTokenResult) tokenTask.getResult();
        String token = getTokenResult != null ? getTokenResult.getToken() : null;
        if (token == null) {
            signUpActivity.onSignInFailure("No Firebase token received.");
            return;
        }
        PreferencesManager preferencesManager = new PreferencesManager(signUpActivity);
        preferencesManager.setString(PreferencesManager.FIREBASE_TOKEN, token);
        preferencesManager.setString(PreferencesManager.AUTH_PROVIDER, FirebaseAuthProvider.PROVIDER_ID);
        preferencesManager.setTokenExpiryTime(System.currentTimeMillis() + 3300000);
        signUpActivity.onSignInSuccess(token, (String) objectRef.element, (String) objectRef2.element);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$10$2(SignUpActivity signUpActivity, Exception e) {
        Intrinsics.checkNotNullParameter(e, "e");
        signUpActivity.onSignInFailure("Apple sign-in failed: " + e.getMessage());
    }

    static final Unit onCreate$lambda$2(View view, View view2, TextView textView, View view3, TextInputLayout textInputLayout, View view4, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, SignUpActivity signUpActivity) {
        view.setVisibility(0);
        view2.setVisibility(0);
        textView.setVisibility(0);
        view3.setVisibility(0);
        textInputLayout.setVisibility(8);
        view4.setVisibility(8);
        textInputLayout2.setVisibility(8);
        textInputLayout3.setVisibility(8);
        View view5 = signUpActivity.signInWithEmailActionButton;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signInWithEmailActionButton");
            view5 = null;
        }
        view5.setVisibility(8);
        signUpActivity.signUpMode = true;
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$3(View view, View view2, TextView textView, View view3, TextInputLayout textInputLayout, View view4, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, SignUpActivity signUpActivity) {
        view.setVisibility(8);
        view2.setVisibility(8);
        textView.setVisibility(8);
        view3.setVisibility(8);
        textInputLayout.setVisibility(0);
        view4.setVisibility(0);
        textInputLayout2.setVisibility(0);
        textInputLayout3.setVisibility(0);
        View view5 = signUpActivity.signInWithEmailActionButton;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signInWithEmailActionButton");
            view5 = null;
        }
        view5.setVisibility(0);
        return Unit.INSTANCE;
    }

    static final void onCreate$lambda$4(SignUpActivity signUpActivity, View view, boolean z) {
        if (z) {
            return;
        }
        signUpActivity.validateInputs();
    }

    static final void onCreate$lambda$5(SignUpActivity signUpActivity, View view, boolean z) {
        if (z) {
            return;
        }
        signUpActivity.validateInputs();
    }

    static final Unit onCreate$lambda$7(SignUpActivity signUpActivity) {
        TextInputEditText textInputEditText = signUpActivity.emailEditText;
        TextInputEditText textInputEditText2 = null;
        if (textInputEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emailEditText");
            textInputEditText = null;
        }
        String strValueOf = String.valueOf(textInputEditText.getText());
        TextInputEditText textInputEditText3 = signUpActivity.passwordEditText;
        if (textInputEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("passwordEditText");
            textInputEditText3 = null;
        }
        String strValueOf2 = String.valueOf(textInputEditText3.getText());
        if (signUpActivity.signUpMode) {
            TextInputEditText textInputEditText4 = signUpActivity.firstnameEditText;
            if (textInputEditText4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("firstnameEditText");
            } else {
                textInputEditText2 = textInputEditText4;
            }
            signUpActivity.createUserWithEmailAndPassword(strValueOf, strValueOf2, String.valueOf(textInputEditText2.getText()));
        }
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$8(SignUpActivity signUpActivity) {
        signUpActivity.startOAuthFlow("discord");
        return Unit.INSTANCE;
    }

    static final Unit onCreate$lambda$9(SignUpActivity signUpActivity) {
        signUpActivity.startOAuthFlow("twitch");
        return Unit.INSTANCE;
    }

    static final Unit onSignInFailure$lambda$0(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    private final void sendVerificationEmailAndShowInstructions(final FirebaseUser user) {
        View viewFindViewById = findViewById(R.id.overlay);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        viewFindViewById.setVisibility(0);
        ((TextView) findViewById(R.id.signingUpTextView)).setVisibility(8);
        FirebaseAuth firebaseAuth = null;
        ActionCodeSettings actionCodeSettingsBuild = ActionCodeSettings.newBuilder().setUrl("https://" + (StringsKt.contains$default((CharSequence) "https://api.mythic.tools/", (CharSequence) "preprod", false, 2, (Object) null) ? "artifact.mythic.tools" : "mythic.tools") + "/mobile/auth/email/verify").setHandleCodeInApp(true).setAndroidPackageName(getPackageName(), true, null).build();
        Intrinsics.checkNotNullExpressionValue(actionCodeSettingsBuild, "build(...)");
        String language = Locale.getDefault().getLanguage();
        FirebaseAuth firebaseAuth2 = this.firebaseAuth;
        if (firebaseAuth2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("firebaseAuth");
        } else {
            firebaseAuth = firebaseAuth2;
        }
        firebaseAuth.setLanguageCode(language);
        user.sendEmailVerification(actionCodeSettingsBuild).addOnCompleteListener(new OnCompleteListener() { // from class: com.studiolaganne.lengendarylens.SignUpActivity$$ExternalSyntheticLambda12
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                SignUpActivity.sendVerificationEmailAndShowInstructions$lambda$0(this.f$0, user, task);
            }
        });
    }

    static final void sendVerificationEmailAndShowInstructions$lambda$0(SignUpActivity signUpActivity, FirebaseUser firebaseUser, Task task) {
        String localizedMessage;
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isSuccessful()) {
            String email = firebaseUser.getEmail();
            if (email == null) {
                email = "";
            }
            signUpActivity.showVerificationEmailSentDialog(email);
            return;
        }
        Exception exception = task.getException();
        if (exception == null || (localizedMessage = exception.getLocalizedMessage()) == null) {
            localizedMessage = "Failed to send verification email";
        }
        signUpActivity.onSignInFailure(localizedMessage);
        View viewFindViewById = signUpActivity.findViewById(R.id.overlay);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        viewFindViewById.setVisibility(8);
    }

    private final void showVerificationEmailSentDialog(String email) {
        View viewFindViewById = findViewById(R.id.overlay);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        viewFindViewById.setVisibility(0);
        ((TextView) findViewById(R.id.signingUpTextView)).setVisibility(8);
        final View viewFindViewById2 = findViewById(R.id.loadingAnimationView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        viewFindViewById2.setVisibility(8);
        View viewFindViewById3 = findViewById(R.id.email_icon_2);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        final TextView textView = (TextView) viewFindViewById3;
        View viewFindViewById4 = findViewById(R.id.connectingTextViewTitle);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        final TextView textView2 = (TextView) viewFindViewById4;
        View viewFindViewById5 = findViewById(R.id.connectingTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        final TextView textView3 = (TextView) viewFindViewById5;
        final View viewFindViewById6 = findViewById(R.id.resendEmailButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        textView.setVisibility(0);
        textView2.setVisibility(0);
        textView3.setVisibility(0);
        viewFindViewById6.setVisibility(0);
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById6, new Function0() { // from class: com.studiolaganne.lengendarylens.SignUpActivity$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SignUpActivity.showVerificationEmailSentDialog$lambda$0(this.f$0, textView, textView2, textView3, viewFindViewById6, viewFindViewById2);
            }
        });
    }

    static final Unit showVerificationEmailSentDialog$lambda$0(SignUpActivity signUpActivity, TextView textView, TextView textView2, TextView textView3, View view, View view2) {
        FirebaseAuth firebaseAuth = signUpActivity.firebaseAuth;
        if (firebaseAuth == null) {
            Intrinsics.throwUninitializedPropertyAccessException("firebaseAuth");
            firebaseAuth = null;
        }
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if (currentUser != null && !currentUser.isEmailVerified()) {
            textView.setVisibility(8);
            textView2.setVisibility(8);
            textView3.setVisibility(8);
            view.setVisibility(8);
            view2.setVisibility(0);
            signUpActivity.sendVerificationEmailAndShowInstructions(currentUser);
        }
        return Unit.INSTANCE;
    }

    private final void startOAuthFlow(String provider) {
        String str;
        String str2 = StringsKt.contains$default((CharSequence) "https://api.mythic.tools/", (CharSequence) "preprod", false, 2, (Object) null) ? "artifact.mythic.tools" : "mythic.tools";
        if (Intrinsics.areEqual(provider, "discord")) {
            str = "https://discord.com/api/oauth2/authorize?client_id=1364349646545092668&redirect_uri=" + Uri.encode("https://" + str2 + "/mobile/auth/discord/callback") + "&response_type=code&scope=identify+email";
        } else {
            if (!Intrinsics.areEqual(provider, "twitch")) {
                throw new IllegalArgumentException("Unsupported provider: " + provider);
            }
            str = "https://id.twitch.tv/oauth2/authorize?client_id=80uzvtoklxj2dcd6mjlhqobd8dn8k4&redirect_uri=" + Uri.encode("https://" + str2 + "/mobile/auth/twitch/callback") + "&response_type=code&scope=user:read:email";
        }
        new PreferencesManager(this).setString("current_oauth_provider", provider);
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void validateInputs() {
        String string;
        String string2;
        String string3;
        TextInputEditText textInputEditText = this.emailEditText;
        View view = null;
        if (textInputEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emailEditText");
            textInputEditText = null;
        }
        Editable text = textInputEditText.getText();
        String str = "";
        if (text == null || (string = text.toString()) == null) {
            string = "";
        }
        TextInputEditText textInputEditText2 = this.passwordEditText;
        if (textInputEditText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("passwordEditText");
            textInputEditText2 = null;
        }
        Editable text2 = textInputEditText2.getText();
        if (text2 == null || (string2 = text2.toString()) == null) {
            string2 = "";
        }
        TextInputEditText textInputEditText3 = this.firstnameEditText;
        if (textInputEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("firstnameEditText");
            textInputEditText3 = null;
        }
        Editable text3 = textInputEditText3.getText();
        if (text3 != null && (string3 = text3.toString()) != null) {
            str = string3;
        }
        boolean zIsValidEmail = isValidEmail(string);
        String strValidatePassword = validatePassword(string2);
        boolean z = strValidatePassword == null;
        boolean z2 = !this.signUpMode || str.length() > 0;
        if (string.length() <= 0 || zIsValidEmail) {
            TextInputLayout textInputLayout = (TextInputLayout) findViewById(R.id.emailInputLayout);
            if (textInputLayout != null) {
                textInputLayout.setError(null);
            }
        } else {
            TextInputLayout textInputLayout2 = (TextInputLayout) findViewById(R.id.emailInputLayout);
            if (textInputLayout2 != null) {
                textInputLayout2.setError(getString(R.string.invalid_email));
            }
        }
        if (string2.length() > 0) {
            TextInputLayout textInputLayout3 = (TextInputLayout) findViewById(R.id.passwordInputLayout);
            if (textInputLayout3 != null) {
                textInputLayout3.setError(strValidatePassword);
            }
        } else {
            TextInputLayout textInputLayout4 = (TextInputLayout) findViewById(R.id.passwordInputLayout);
            if (textInputLayout4 != null) {
                textInputLayout4.setError(null);
            }
        }
        if (zIsValidEmail && z && z2) {
            View view2 = this.signInWithEmailActionButton;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("signInWithEmailActionButton");
                view2 = null;
            }
            SignUpActivity signUpActivity = this;
            view2.setBackground(ContextCompat.getDrawable(signUpActivity, R.drawable.custom_email_button_background));
            TextView textView = this.signInText;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("signInText");
                textView = null;
            }
            textView.setTextColor(ContextCompat.getColor(signUpActivity, R.color.almost_black));
            View view3 = this.signInWithEmailActionButton;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("signInWithEmailActionButton");
            } else {
                view = view3;
            }
            view.setEnabled(true);
            return;
        }
        View view4 = this.signInWithEmailActionButton;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signInWithEmailActionButton");
            view4 = null;
        }
        SignUpActivity signUpActivity2 = this;
        view4.setBackground(ContextCompat.getDrawable(signUpActivity2, R.drawable.custom_email_button_background_disabled));
        TextView textView2 = this.signInText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signInText");
            textView2 = null;
        }
        textView2.setTextColor(ContextCompat.getColor(signUpActivity2, R.color.dark_grey));
        View view5 = this.signInWithEmailActionButton;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signInWithEmailActionButton");
        } else {
            view = view5;
        }
        view.setEnabled(false);
    }

    private final String validatePassword(String password) {
        boolean z;
        boolean z2;
        boolean z3;
        String str = password;
        if (str.length() == 0) {
            return getString(R.string.password_required);
        }
        ArrayList arrayList = new ArrayList();
        boolean z4 = true;
        boolean z5 = password.length() >= 8;
        arrayList.add(Boolean.valueOf(z5));
        int i = 0;
        while (true) {
            if (i >= str.length()) {
                z = false;
                break;
            }
            if (Character.isUpperCase(str.charAt(i))) {
                z = true;
                break;
            }
            i++;
        }
        arrayList.add(Boolean.valueOf(z));
        int i2 = 0;
        while (true) {
            if (i2 >= str.length()) {
                z2 = false;
                break;
            }
            if (Character.isLowerCase(str.charAt(i2))) {
                z2 = true;
                break;
            }
            i2++;
        }
        arrayList.add(Boolean.valueOf(z2));
        int i3 = 0;
        while (true) {
            if (i3 >= str.length()) {
                z3 = false;
                break;
            }
            if (Character.isDigit(str.charAt(i3))) {
                z3 = true;
                break;
            }
            i3++;
        }
        arrayList.add(Boolean.valueOf(z3));
        int i4 = 0;
        while (true) {
            if (i4 >= str.length()) {
                z4 = false;
                break;
            }
            if (!Character.isLetterOrDigit(str.charAt(i4))) {
                break;
            }
            i4++;
        }
        arrayList.add(Boolean.valueOf(z4));
        ArrayList arrayList2 = arrayList;
        if ((arrayList2 instanceof Collection) && arrayList2.isEmpty()) {
            return null;
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            if (!((Boolean) it.next()).booleanValue()) {
                ArrayList arrayList3 = new ArrayList();
                if (!z5) {
                    String string = getString(R.string.password_length);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    arrayList3.add(string);
                }
                if (!z) {
                    String string2 = getString(R.string.password_uppercase);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    arrayList3.add(string2);
                }
                if (!z2) {
                    String string3 = getString(R.string.password_lowercase);
                    Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                    arrayList3.add(string3);
                }
                if (!z3) {
                    String string4 = getString(R.string.password_digit);
                    Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                    arrayList3.add(string4);
                }
                if (!z4) {
                    String string5 = getString(R.string.password_special);
                    Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                    arrayList3.add(string5);
                }
                return CollectionsKt.joinToString$default(arrayList3, "\n", null, null, 0, null, null, 62, null);
            }
        }
        return null;
    }

    @Override // com.studiolaganne.lengendarylens.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        String path;
        String path2;
        String path3;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        PreferencesManager preferencesManager = new PreferencesManager(this);
        preferencesManager.setBoolean(PreferencesManager.SIGN_UP_ACTIVE, true);
        GoogleSignInOptions googleSignInOptionsBuild = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(getResources().getString(R.string.default_web_client_id)).requestEmail().build();
        Intrinsics.checkNotNullExpressionValue(googleSignInOptionsBuild, "build(...)");
        GoogleSignInClient client = GoogleSignIn.getClient((Activity) this, googleSignInOptionsBuild);
        Intrinsics.checkNotNullExpressionValue(client, "getClient(...)");
        this.googleSignInClient = client;
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        Intrinsics.checkNotNullExpressionValue(firebaseAuth, "getInstance(...)");
        this.firebaseAuth = firebaseAuth;
        TextView textView = (TextView) findViewById(R.id.skipLabel);
        Intrinsics.checkNotNull(textView);
        ViewExtensionsKt.setOnClickWithFade(textView, new Function0() { // from class: com.studiolaganne.lengendarylens.SignUpActivity$$ExternalSyntheticLambda24
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SignUpActivity.onCreate$lambda$0(this.f$0);
            }
        });
        final View viewFindViewById = findViewById(R.id.google_sign_in_button);
        final View viewFindViewById2 = findViewById(R.id.email_sign_in_button);
        final TextView textView2 = (TextView) findViewById(R.id.orContinueLabel);
        final View viewFindViewById3 = findViewById(R.id.extra_sign_in_button);
        View viewFindViewById4 = findViewById(R.id.emailEditText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.emailEditText = (TextInputEditText) viewFindViewById4;
        View viewFindViewById5 = findViewById(R.id.passwordEditText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.passwordEditText = (TextInputEditText) viewFindViewById5;
        View viewFindViewById6 = findViewById(R.id.firstnameEditText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.firstnameEditText = (TextInputEditText) viewFindViewById6;
        View viewFindViewById7 = findViewById(R.id.signInWithEmailButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.signInWithEmailActionButton = viewFindViewById7;
        View viewFindViewById8 = findViewById(R.id.signInText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.signInText = (TextView) viewFindViewById8;
        final View viewFindViewById9 = findViewById(R.id.closeEmailLayout);
        ImageView imageView = (ImageView) findViewById(R.id.closeEmailImage);
        final TextInputLayout textInputLayout = (TextInputLayout) findViewById(R.id.firstnameInputLayout);
        final TextInputLayout textInputLayout2 = (TextInputLayout) findViewById(R.id.emailInputLayout);
        final TextInputLayout textInputLayout3 = (TextInputLayout) findViewById(R.id.passwordInputLayout);
        Intrinsics.checkNotNull(viewFindViewById);
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById, new Function0() { // from class: com.studiolaganne.lengendarylens.SignUpActivity$$ExternalSyntheticLambda26
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SignUpActivity.onCreate$lambda$1(this.f$0);
            }
        });
        Intrinsics.checkNotNull(imageView);
        ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.SignUpActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SignUpActivity.onCreate$lambda$2(viewFindViewById, viewFindViewById2, textView2, viewFindViewById3, textInputLayout, viewFindViewById9, textInputLayout2, textInputLayout3, this);
            }
        });
        Intrinsics.checkNotNull(viewFindViewById2);
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById2, new Function0() { // from class: com.studiolaganne.lengendarylens.SignUpActivity$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SignUpActivity.onCreate$lambda$3(viewFindViewById, viewFindViewById2, textView2, viewFindViewById3, textInputLayout, viewFindViewById9, textInputLayout2, textInputLayout3, this);
            }
        });
        TextWatcher textWatcher = new TextWatcher() { // from class: com.studiolaganne.lengendarylens.SignUpActivity$onCreate$textWatcher$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                this.this$0.validateInputs();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        };
        TextInputEditText textInputEditText = this.firstnameEditText;
        if (textInputEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("firstnameEditText");
            textInputEditText = null;
        }
        TextWatcher textWatcher2 = textWatcher;
        textInputEditText.addTextChangedListener(textWatcher2);
        TextInputEditText textInputEditText2 = this.emailEditText;
        if (textInputEditText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emailEditText");
            textInputEditText2 = null;
        }
        textInputEditText2.addTextChangedListener(textWatcher2);
        TextInputEditText textInputEditText3 = this.passwordEditText;
        if (textInputEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("passwordEditText");
            textInputEditText3 = null;
        }
        textInputEditText3.addTextChangedListener(textWatcher2);
        textWatcher.afterTextChanged(null);
        TextInputEditText textInputEditText4 = this.emailEditText;
        if (textInputEditText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emailEditText");
            textInputEditText4 = null;
        }
        textInputEditText4.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.studiolaganne.lengendarylens.SignUpActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                SignUpActivity.onCreate$lambda$4(this.f$0, view, z);
            }
        });
        TextInputEditText textInputEditText5 = this.passwordEditText;
        if (textInputEditText5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("passwordEditText");
            textInputEditText5 = null;
        }
        textInputEditText5.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.studiolaganne.lengendarylens.SignUpActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                SignUpActivity.onCreate$lambda$5(this.f$0, view, z);
            }
        });
        ((ViewGroup) getWindow().getDecorView().findViewById(android.R.id.content)).getChildAt(0).getViewTreeObserver().addOnGlobalFocusChangeListener(new ViewTreeObserver.OnGlobalFocusChangeListener() { // from class: com.studiolaganne.lengendarylens.SignUpActivity$$ExternalSyntheticLambda5
            @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
            public final void onGlobalFocusChanged(View view, View view2) {
                this.f$0.validateInputs();
            }
        });
        View view = this.signInWithEmailActionButton;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signInWithEmailActionButton");
            view = null;
        }
        ViewExtensionsKt.setOnClickWithFade(view, new Function0() { // from class: com.studiolaganne.lengendarylens.SignUpActivity$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SignUpActivity.onCreate$lambda$7(this.f$0);
            }
        });
        View viewFindViewById10 = findViewById(R.id.discordButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById10, new Function0() { // from class: com.studiolaganne.lengendarylens.SignUpActivity$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SignUpActivity.onCreate$lambda$8(this.f$0);
            }
        });
        View viewFindViewById11 = findViewById(R.id.twitchButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById11, new Function0() { // from class: com.studiolaganne.lengendarylens.SignUpActivity$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SignUpActivity.onCreate$lambda$9(this.f$0);
            }
        });
        View viewFindViewById12 = findViewById(R.id.appleButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById12, new Function0() { // from class: com.studiolaganne.lengendarylens.SignUpActivity$$ExternalSyntheticLambda25
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SignUpActivity.onCreate$lambda$10(this.f$0);
            }
        });
        String action = getIntent().getAction();
        Uri data = getIntent().getData();
        if (!Intrinsics.areEqual(action, "android.intent.action.VIEW") || data == null || (((path2 = data.getPath()) == null || !StringsKt.contains$default((CharSequence) path2, (CharSequence) "discord/callback", false, 2, (Object) null)) && ((path3 = data.getPath()) == null || !StringsKt.contains$default((CharSequence) path3, (CharSequence) "twitch/callback", false, 2, (Object) null)))) {
            if (!Intrinsics.areEqual(action, "android.intent.action.VIEW") || data == null || (path = data.getPath()) == null || !StringsKt.contains$default((CharSequence) path, (CharSequence) "email/verify", false, 2, (Object) null)) {
                return;
            }
            onEmailVerified();
            return;
        }
        Log.d("SignUpActivity", "onCreate received OAuth callback");
        String queryParameter = data.getQueryParameter("code");
        String path4 = data.getPath();
        if (path4 == null) {
            path4 = "";
        }
        String str = path4;
        String string = "discord";
        if (!StringsKt.contains$default((CharSequence) str, (CharSequence) "discord", false, 2, (Object) null)) {
            string = "twitch";
            if (!StringsKt.contains$default((CharSequence) str, (CharSequence) "twitch", false, 2, (Object) null)) {
                string = preferencesManager.getString("current_oauth_provider", "");
            }
        }
        if (queryParameter != null) {
            onOAuthSignInSuccess(queryParameter, string);
        } else {
            onOAuthError("No authorization code received.");
        }
    }

    public final void onEmailVerified() {
        View viewFindViewById = findViewById(R.id.overlay);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        viewFindViewById.setVisibility(0);
        ((TextView) findViewById(R.id.signingUpTextView)).setVisibility(0);
        View viewFindViewById2 = findViewById(R.id.loadingAnimationView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        viewFindViewById2.setVisibility(0);
        View viewFindViewById3 = findViewById(R.id.email_icon_2);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        ((TextView) viewFindViewById3).setVisibility(8);
        View viewFindViewById4 = findViewById(R.id.connectingTextViewTitle);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        ((TextView) viewFindViewById4).setVisibility(8);
        View viewFindViewById5 = findViewById(R.id.connectingTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        ((TextView) viewFindViewById5).setVisibility(8);
        View viewFindViewById6 = findViewById(R.id.resendEmailButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        viewFindViewById6.setVisibility(8);
        handleSuccessfulFirebaseAuth();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        String path;
        String path2;
        String path3;
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        Log.d("SignUpActivity", "onNewIntent called");
        String action = intent.getAction();
        Uri data = intent.getData();
        if (!Intrinsics.areEqual(action, "android.intent.action.VIEW") || data == null || (((path2 = data.getPath()) == null || !StringsKt.contains$default((CharSequence) path2, (CharSequence) "discord/callback", false, 2, (Object) null)) && ((path3 = data.getPath()) == null || !StringsKt.contains$default((CharSequence) path3, (CharSequence) "twitch/callback", false, 2, (Object) null)))) {
            if (!Intrinsics.areEqual(action, "android.intent.action.VIEW") || data == null || (path = data.getPath()) == null || !StringsKt.contains$default((CharSequence) path, (CharSequence) "email/verify", false, 2, (Object) null)) {
                return;
            }
            onEmailVerified();
            return;
        }
        Log.d("OAuth", "Received URI: " + data);
        Log.d("OAuth", "Scheme: " + data.getScheme());
        Log.d("OAuth", "Host: " + data.getHost());
        Log.d("OAuth", "Path: " + data.getPath());
        Log.d("OAuth", "Query params: " + data.getQuery());
        String queryParameter = data.getQueryParameter("code");
        String path4 = data.getPath();
        if (path4 == null) {
            path4 = "";
        }
        String str = path4;
        String string = "discord";
        if (!StringsKt.contains$default((CharSequence) str, (CharSequence) "discord", false, 2, (Object) null)) {
            string = "twitch";
            if (!StringsKt.contains$default((CharSequence) str, (CharSequence) "twitch", false, 2, (Object) null)) {
                string = new PreferencesManager(this).getString("current_oauth_provider", "");
            }
        }
        if (queryParameter != null) {
            onOAuthSignInSuccess(queryParameter, string);
        } else {
            onOAuthError("No authorization code received.");
        }
    }

    public final void onOAuthError(String errorMessage) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        onSignInFailure(errorMessage);
    }

    public final void onOAuthSignInSuccess(String code, String type) {
        String str;
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(type, "type");
        Breadcrumbs.INSTANCE.leaveBreadcrumb("onboarding_oauth_success");
        SignUpActivity signUpActivity = this;
        FirebaseAnalytics.getInstance(signUpActivity).logEvent("onboarding_oauth_success", null);
        PreferencesManager preferencesManager = new PreferencesManager(signUpActivity);
        String string = preferencesManager.getString(PreferencesManager.FCM_TOKEN, "");
        if (Intrinsics.areEqual(string, "")) {
            try {
                String result = FirebaseMessaging.getInstance().getToken().getResult();
                Intrinsics.checkNotNullExpressionValue(result, "getResult(...)");
                str = result;
            } catch (Exception e) {
                Log.d(FirebaseMessaging.INSTANCE_ID_SCOPE, "Failed to get FCM token: " + e.getLocalizedMessage());
                str = string;
            }
        } else {
            str = string;
        }
        MTLoginBody mTLoginBody = new MTLoginBody(str, preferencesManager.getDeviceLanguage(), null, null, code, type, 12, null);
        View viewFindViewById = findViewById(R.id.overlay);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        viewFindViewById.setVisibility(0);
        View viewFindViewById2 = findViewById(R.id.loadingAnimationView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        viewFindViewById2.setVisibility(0);
        MTApiKt.getMtApi().exchange(mTLoginBody).enqueue(new AnonymousClass1(viewFindViewById, preferencesManager, this));
    }

    public final void onSignInFailure(String errorMessage) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        View viewFindViewById = findViewById(R.id.overlay);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        viewFindViewById.setVisibility(8);
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = getString(R.string.login_error);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder positiveButtonRed = builder.setTitle(string).setBody(errorMessage).setPositiveButtonRed();
        String string2 = getString(R.string.close);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder positiveButton = positiveButtonRed.setPositiveButton(string2, new Function2() { // from class: com.studiolaganne.lengendarylens.SignUpActivity$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return SignUpActivity.onSignInFailure$lambda$0(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        positiveButton.show(supportFragmentManager, "notification_permission_dialog");
    }

    public final void onSignInSuccess(String token, String firstname, String email) {
        String str;
        Intrinsics.checkNotNullParameter(token, "token");
        Breadcrumbs.INSTANCE.leaveBreadcrumb("onboarding_sign_up_success");
        SignUpActivity signUpActivity = this;
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(signUpActivity);
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("onboarding_sign_up_success", null);
        PreferencesManager preferencesManager = new PreferencesManager(signUpActivity);
        String string = preferencesManager.getString(PreferencesManager.FCM_TOKEN, "");
        if (Intrinsics.areEqual(string, "")) {
            try {
                String result = FirebaseMessaging.getInstance().getToken().getResult();
                Intrinsics.checkNotNullExpressionValue(result, "getResult(...)");
                str = result;
            } catch (Exception e) {
                Log.d(FirebaseMessaging.INSTANCE_ID_SCOPE, "Failed to get FCM token: " + e.getLocalizedMessage());
                str = string;
            }
        } else {
            str = string;
        }
        MTLoginBody mTLoginBody = new MTLoginBody(str, preferencesManager.getDeviceLanguage(), firstname, email, null, null, 48, null);
        View viewFindViewById = findViewById(R.id.overlay);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        viewFindViewById.setVisibility(0);
        View viewFindViewById2 = findViewById(R.id.loadingAnimationView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        viewFindViewById2.setVisibility(0);
        MTApiKt.getMtApi().signin(mTLoginBody).enqueue(new C12561(preferencesManager, this, viewFindViewById));
    }
}
