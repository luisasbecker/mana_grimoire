package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
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
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* JADX INFO: compiled from: SignInBottomSheetFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 :2\u00020\u0001:\u0001:B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0018\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020$H\u0002J\u0016\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020$2\u0006\u0010#\u001a\u00020$J\u000e\u0010'\u001a\u00020 2\u0006\u0010(\u001a\u00020$J\u0010\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020$H\u0002J\b\u0010+\u001a\u00020 H\u0002J\u0010\u0010,\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020$H\u0002J\u0012\u0010.\u001a\u0004\u0018\u00010$2\u0006\u0010-\u001a\u00020$H\u0002J\u0018\u0010/\u001a\u00020 2\u0006\u0010*\u001a\u00020$2\u0006\u0010-\u001a\u00020$H\u0002J \u00100\u001a\u00020 2\u0006\u0010*\u001a\u00020$2\u0006\u0010-\u001a\u00020$2\u0006\u00101\u001a\u00020$H\u0002J\u0010\u00102\u001a\u00020 2\u0006\u00103\u001a\u000204H\u0002J\u0010\u00105\u001a\u00020 2\u0006\u0010*\u001a\u00020$H\u0002J\u0006\u00106\u001a\u00020 J\b\u00107\u001a\u00020 H\u0002J\u0012\u00108\u001a\u00020 2\b\u00109\u001a\u0004\u0018\u00010\u0016H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00160\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/studiolaganne/lengendarylens/SignInBottomSheetFragment;", "Lcom/studiolaganne/lengendarylens/TransparentBottomSheet;", "<init>", "()V", "callback", "Lcom/studiolaganne/lengendarylens/SignInCallback;", "googleSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "firebaseAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "signUpMode", "", "emailEditText", "Lcom/google/android/material/textfield/TextInputEditText;", "passwordEditText", "firstnameEditText", "signInWithEmailActionButton", "Landroid/view/View;", "signInText", "Landroid/widget/TextView;", "googleSignInLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", ViewHierarchyConstants.VIEW_KEY, "startOAuthFlow", "provider", "", "onOAuthCodeReceived", "code", "onOAuthError", "errorMessage", "isValidEmail", "email", "validateInputs", "isValidPassword", "password", "validatePassword", "signInWithEmailAndPassword", "createUserWithEmailAndPassword", "firstname", "sendVerificationEmailAndShowInstructions", "user", "Lcom/google/firebase/auth/FirebaseUser;", "showVerificationEmailSentDialog", "onEmailVerified", "handleSuccessfulFirebaseAuth", "handleSignInResult", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SignInBottomSheetFragment extends TransparentBottomSheet {
    public static final String TAG = "SignInBottomSheetFragment";
    private SignInCallback callback;
    private TextInputEditText emailEditText;
    private FirebaseAuth firebaseAuth;
    private TextInputEditText firstnameEditText;
    private GoogleSignInClient googleSignInClient;
    private final ActivityResultLauncher<Intent> googleSignInLauncher;
    private TextInputEditText passwordEditText;
    private TextView signInText;
    private View signInWithEmailActionButton;
    private boolean signUpMode;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: SignInBottomSheetFragment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/studiolaganne/lengendarylens/SignInBottomSheetFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/studiolaganne/lengendarylens/SignInBottomSheetFragment;", "callback", "Lcom/studiolaganne/lengendarylens/SignInCallback;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SignInBottomSheetFragment newInstance(SignInCallback callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            SignInBottomSheetFragment signInBottomSheetFragment = new SignInBottomSheetFragment();
            signInBottomSheetFragment.callback = callback;
            return signInBottomSheetFragment;
        }
    }

    public SignInBottomSheetFragment() {
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.SignInBottomSheetFragment$$ExternalSyntheticLambda19
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) throws Throwable {
                SignInBottomSheetFragment.googleSignInLauncher$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.googleSignInLauncher = activityResultLauncherRegisterForActivityResult;
    }

    private final void createUserWithEmailAndPassword(String email, String password, final String firstname) {
        if (getView() == null) {
            return;
        }
        View viewFindViewById = requireView().findViewById(R.id.overlay);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        viewFindViewById.setVisibility(0);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.SignInBottomSheetFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SignInBottomSheetFragment.createUserWithEmailAndPassword$lambda$0(view);
            }
        });
        FirebaseAuth firebaseAuth = this.firebaseAuth;
        if (firebaseAuth == null) {
            Intrinsics.throwUninitializedPropertyAccessException("firebaseAuth");
            firebaseAuth = null;
        }
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener() { // from class: com.studiolaganne.lengendarylens.SignInBottomSheetFragment$$ExternalSyntheticLambda11
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                SignInBottomSheetFragment.createUserWithEmailAndPassword$lambda$1(firstname, this, task);
            }
        });
    }

    static final void createUserWithEmailAndPassword$lambda$0(View view) {
    }

    static final void createUserWithEmailAndPassword$lambda$1(String str, final SignInBottomSheetFragment signInBottomSheetFragment, Task task) {
        String localizedMessage;
        Task<Void> taskUpdateProfile;
        Intrinsics.checkNotNullParameter(task, "task");
        if (!task.isSuccessful()) {
            Exception exception = task.getException();
            if (exception == null || (localizedMessage = exception.getLocalizedMessage()) == null) {
                localizedMessage = "Authentication failed";
            }
            SignInCallback signInCallback = signInBottomSheetFragment.callback;
            if (signInCallback != null) {
                signInCallback.onSignInFailure(localizedMessage);
            }
            View viewFindViewById = signInBottomSheetFragment.requireView().findViewById(R.id.overlay);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            viewFindViewById.setVisibility(8);
            return;
        }
        UserProfileChangeRequest userProfileChangeRequestBuild = new UserProfileChangeRequest.Builder().setDisplayName(str).build();
        Intrinsics.checkNotNullExpressionValue(userProfileChangeRequestBuild, "build(...)");
        FirebaseAuth firebaseAuth = signInBottomSheetFragment.firebaseAuth;
        if (firebaseAuth == null) {
            Intrinsics.throwUninitializedPropertyAccessException("firebaseAuth");
            firebaseAuth = null;
        }
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if (currentUser == null || (taskUpdateProfile = currentUser.updateProfile(userProfileChangeRequestBuild)) == null) {
            return;
        }
        taskUpdateProfile.addOnCompleteListener(new OnCompleteListener() { // from class: com.studiolaganne.lengendarylens.SignInBottomSheetFragment$$ExternalSyntheticLambda10
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task2) {
                SignInBottomSheetFragment.createUserWithEmailAndPassword$lambda$1$0(this.f$0, task2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createUserWithEmailAndPassword$lambda$1$0(SignInBottomSheetFragment signInBottomSheetFragment, Task profileTask) {
        Intrinsics.checkNotNullParameter(profileTask, "profileTask");
        FirebaseAuth firebaseAuth = signInBottomSheetFragment.firebaseAuth;
        if (firebaseAuth == null) {
            Intrinsics.throwUninitializedPropertyAccessException("firebaseAuth");
            firebaseAuth = null;
        }
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if (currentUser != null) {
            if (currentUser.isEmailVerified()) {
                signInBottomSheetFragment.handleSuccessfulFirebaseAuth();
            } else {
                signInBottomSheetFragment.sendVerificationEmailAndShowInstructions(currentUser);
            }
        }
    }

    static final void googleSignInLauncher$lambda$0(SignInBottomSheetFragment signInBottomSheetFragment, ActivityResult result) throws Throwable {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == -1) {
            signInBottomSheetFragment.handleSignInResult(result.getData());
            return;
        }
        SignInCallback signInCallback = signInBottomSheetFragment.callback;
        if (signInCallback != null) {
            signInCallback.onSignInCancel();
        }
    }

    private final void handleSignInResult(Intent data) throws Throwable {
        Task<GoogleSignInAccount> signedInAccountFromIntent = GoogleSignIn.getSignedInAccountFromIntent(data);
        Intrinsics.checkNotNullExpressionValue(signedInAccountFromIntent, "getSignedInAccountFromIntent(...)");
        try {
            GoogleSignInAccount result = signedInAccountFromIntent.getResult(ApiException.class);
            if (result == null) {
                throw new ApiException(Status.RESULT_CANCELED);
            }
            String idToken = result.getIdToken();
            if (idToken == null) {
                SignInCallback signInCallback = this.callback;
                if (signInCallback != null) {
                    signInCallback.onSignInFailure("No ID token received from Google account.");
                    return;
                }
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
            firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener() { // from class: com.studiolaganne.lengendarylens.SignInBottomSheetFragment$$ExternalSyntheticLambda18
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    SignInBottomSheetFragment.handleSignInResult$lambda$0(this.f$0, task);
                }
            });
        } catch (ApiException e) {
            SignInCallback signInCallback2 = this.callback;
            if (signInCallback2 != null) {
                signInCallback2.onSignInFailure("Google sign-in failed: " + e.getStatusCode());
            }
        }
    }

    static final void handleSignInResult$lambda$0(final SignInBottomSheetFragment signInBottomSheetFragment, Task authTask) {
        Task<GetTokenResult> idToken;
        Intrinsics.checkNotNullParameter(authTask, "authTask");
        if (signInBottomSheetFragment.getContext() == null) {
            return;
        }
        if (!authTask.isSuccessful()) {
            SignInCallback signInCallback = signInBottomSheetFragment.callback;
            if (signInCallback != null) {
                signInCallback.onSignInFailure("Firebase sign-in failed.");
                return;
            }
            return;
        }
        FirebaseAuth firebaseAuth = signInBottomSheetFragment.firebaseAuth;
        if (firebaseAuth == null) {
            Intrinsics.throwUninitializedPropertyAccessException("firebaseAuth");
            firebaseAuth = null;
        }
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if (currentUser == null || (idToken = currentUser.getIdToken(true)) == null) {
            return;
        }
        idToken.addOnCompleteListener(new OnCompleteListener() { // from class: com.studiolaganne.lengendarylens.SignInBottomSheetFragment$$ExternalSyntheticLambda6
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                SignInBottomSheetFragment.handleSignInResult$lambda$0$0(this.f$0, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleSignInResult$lambda$0$0(SignInBottomSheetFragment signInBottomSheetFragment, Task tokenTask) {
        Intrinsics.checkNotNullParameter(tokenTask, "tokenTask");
        if (signInBottomSheetFragment.getContext() == null) {
            return;
        }
        if (!tokenTask.isSuccessful()) {
            SignInCallback signInCallback = signInBottomSheetFragment.callback;
            if (signInCallback != null) {
                signInCallback.onSignInFailure("Failed to retrieve Firebase ID token.");
                return;
            }
            return;
        }
        GetTokenResult getTokenResult = (GetTokenResult) tokenTask.getResult();
        String token = getTokenResult != null ? getTokenResult.getToken() : null;
        if (token == null) {
            SignInCallback signInCallback2 = signInBottomSheetFragment.callback;
            if (signInCallback2 != null) {
                signInCallback2.onSignInFailure("No Firebase token received.");
                return;
            }
            return;
        }
        Context contextRequireContext = signInBottomSheetFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        preferencesManager.setString(PreferencesManager.FIREBASE_TOKEN, token);
        preferencesManager.setString(PreferencesManager.AUTH_PROVIDER, FirebaseAuthProvider.PROVIDER_ID);
        preferencesManager.setTokenExpiryTime(System.currentTimeMillis() + 3300000);
        SignInCallback signInCallback3 = signInBottomSheetFragment.callback;
        if (signInCallback3 != null) {
            signInCallback3.onSignInSuccess(token, null, null);
        }
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
        idToken.addOnCompleteListener(new OnCompleteListener() { // from class: com.studiolaganne.lengendarylens.SignInBottomSheetFragment$$ExternalSyntheticLambda7
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                SignInBottomSheetFragment.handleSuccessfulFirebaseAuth$lambda$0(this.f$0, task);
            }
        });
    }

    static final void handleSuccessfulFirebaseAuth$lambda$0(SignInBottomSheetFragment signInBottomSheetFragment, Task tokenTask) {
        Intrinsics.checkNotNullParameter(tokenTask, "tokenTask");
        if (signInBottomSheetFragment.getContext() == null) {
            return;
        }
        if (!tokenTask.isSuccessful()) {
            SignInCallback signInCallback = signInBottomSheetFragment.callback;
            if (signInCallback != null) {
                signInCallback.onSignInFailure("Failed to retrieve Firebase ID token.");
                return;
            }
            return;
        }
        GetTokenResult getTokenResult = (GetTokenResult) tokenTask.getResult();
        String token = getTokenResult != null ? getTokenResult.getToken() : null;
        if (token == null) {
            SignInCallback signInCallback2 = signInBottomSheetFragment.callback;
            if (signInCallback2 != null) {
                signInCallback2.onSignInFailure("No Firebase token received.");
                return;
            }
            return;
        }
        Context contextRequireContext = signInBottomSheetFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        preferencesManager.setString(PreferencesManager.FIREBASE_TOKEN, token);
        preferencesManager.setString(PreferencesManager.AUTH_PROVIDER, FirebaseAuthProvider.PROVIDER_ID);
        preferencesManager.setTokenExpiryTime(System.currentTimeMillis() + 3300000);
        SignInCallback signInCallback3 = signInBottomSheetFragment.callback;
        if (signInCallback3 != null) {
            signInCallback3.onSignInSuccess(token, null, null);
        }
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

    static final Unit onViewCreated$lambda$0(SignInBottomSheetFragment signInBottomSheetFragment) {
        SignInCallback signInCallback = signInBottomSheetFragment.callback;
        if (signInCallback != null) {
            signInCallback.onSignInCancel();
        }
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$1(SignInBottomSheetFragment signInBottomSheetFragment) {
        LifecycleOwner viewLifecycleOwner = signInBottomSheetFragment.getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new SignInBottomSheetFragment$onViewCreated$4$1(signInBottomSheetFragment, null), 3, null);
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$10(SignInBottomSheetFragment signInBottomSheetFragment) {
        signInBottomSheetFragment.startOAuthFlow("twitch");
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$11(final SignInBottomSheetFragment signInBottomSheetFragment) {
        OAuthProvider.Builder builderNewBuilder = OAuthProvider.newBuilder("apple.com");
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder(...)");
        builderNewBuilder.setScopes(CollectionsKt.listOf((Object[]) new String[]{"email", "name"}));
        builderNewBuilder.addCustomParameter(AndroidContextPlugin.LOCALE_KEY, Locale.getDefault().getLanguage());
        FirebaseAuth firebaseAuth = signInBottomSheetFragment.firebaseAuth;
        if (firebaseAuth == null) {
            Intrinsics.throwUninitializedPropertyAccessException("firebaseAuth");
            firebaseAuth = null;
        }
        Task<AuthResult> taskStartActivityForSignInWithProvider = firebaseAuth.startActivityForSignInWithProvider(signInBottomSheetFragment.requireActivity(), builderNewBuilder.build());
        final Function1 function1 = new Function1() { // from class: com.studiolaganne.lengendarylens.SignInBottomSheetFragment$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SignInBottomSheetFragment.onViewCreated$lambda$11$0(this.f$0, (AuthResult) obj);
            }
        };
        taskStartActivityForSignInWithProvider.addOnSuccessListener(new OnSuccessListener() { // from class: com.studiolaganne.lengendarylens.SignInBottomSheetFragment$$ExternalSyntheticLambda13
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                function1.invoke(obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.studiolaganne.lengendarylens.SignInBottomSheetFragment$$ExternalSyntheticLambda14
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                SignInBottomSheetFragment.onViewCreated$lambda$11$2(this.f$0, exc);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v25, types: [T, java.lang.Object] */
    public static final Unit onViewCreated$lambda$11$0(final SignInBottomSheetFragment signInBottomSheetFragment, AuthResult authResult) {
        Task<GetTokenResult> idToken;
        CharSequence charSequence;
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
            idToken.addOnCompleteListener(new OnCompleteListener() { // from class: com.studiolaganne.lengendarylens.SignInBottomSheetFragment$$ExternalSyntheticLambda9
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    SignInBottomSheetFragment.onViewCreated$lambda$11$0$0(this.f$0, objectRef2, objectRef, task);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void onViewCreated$lambda$11$0$0(SignInBottomSheetFragment signInBottomSheetFragment, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, Task tokenTask) {
        Intrinsics.checkNotNullParameter(tokenTask, "tokenTask");
        if (!tokenTask.isSuccessful()) {
            SignInCallback signInCallback = signInBottomSheetFragment.callback;
            if (signInCallback != null) {
                signInCallback.onSignInFailure("Failed to retrieve Firebase ID token.");
                return;
            }
            return;
        }
        GetTokenResult getTokenResult = (GetTokenResult) tokenTask.getResult();
        String token = getTokenResult != null ? getTokenResult.getToken() : null;
        if (token == null) {
            SignInCallback signInCallback2 = signInBottomSheetFragment.callback;
            if (signInCallback2 != null) {
                signInCallback2.onSignInFailure("No Firebase token received.");
                return;
            }
            return;
        }
        Context contextRequireContext = signInBottomSheetFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        preferencesManager.setString(PreferencesManager.FIREBASE_TOKEN, token);
        preferencesManager.setString(PreferencesManager.AUTH_PROVIDER, FirebaseAuthProvider.PROVIDER_ID);
        preferencesManager.setTokenExpiryTime(System.currentTimeMillis() + 3300000);
        SignInCallback signInCallback3 = signInBottomSheetFragment.callback;
        if (signInCallback3 != null) {
            signInCallback3.onSignInSuccess(token, (String) objectRef.element, (String) objectRef2.element);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$11$2(SignInBottomSheetFragment signInBottomSheetFragment, Exception e) {
        Intrinsics.checkNotNullParameter(e, "e");
        SignInCallback signInCallback = signInBottomSheetFragment.callback;
        if (signInCallback != null) {
            signInCallback.onSignInFailure("Apple sign-in failed: " + e.getMessage());
        }
    }

    static final Unit onViewCreated$lambda$2(View view, View view2, TextView textView, View view3, TextInputLayout textInputLayout, View view4, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, SignInBottomSheetFragment signInBottomSheetFragment, TextView textView2, TextView textView3, TextView textView4) {
        view.setVisibility(0);
        view2.setVisibility(0);
        textView.setVisibility(0);
        view3.setVisibility(0);
        textInputLayout.setVisibility(8);
        view4.setVisibility(8);
        textInputLayout2.setVisibility(8);
        textInputLayout3.setVisibility(8);
        View view5 = signInBottomSheetFragment.signInWithEmailActionButton;
        TextView textView5 = null;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signInWithEmailActionButton");
            view5 = null;
        }
        view5.setVisibility(8);
        textView2.setVisibility(8);
        textView3.setVisibility(8);
        textView4.setVisibility(8);
        TextView textView6 = signInBottomSheetFragment.signInText;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signInText");
        } else {
            textView5 = textView6;
        }
        textView5.setText(signInBottomSheetFragment.getString(R.string.sign_in));
        signInBottomSheetFragment.signUpMode = false;
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$3(View view, View view2, TextView textView, View view3, TextInputLayout textInputLayout, View view4, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, TextView textView2, SignInBottomSheetFragment signInBottomSheetFragment, TextView textView3, TextView textView4) {
        view.setVisibility(8);
        view2.setVisibility(8);
        textView.setVisibility(8);
        view3.setVisibility(8);
        textInputLayout.setVisibility(8);
        view4.setVisibility(0);
        textInputLayout2.setVisibility(0);
        textInputLayout3.setVisibility(0);
        textView2.setVisibility(0);
        View view5 = signInBottomSheetFragment.signInWithEmailActionButton;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signInWithEmailActionButton");
            view5 = null;
        }
        view5.setVisibility(0);
        textView3.setVisibility(0);
        textView4.setVisibility(8);
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$4(final SignInBottomSheetFragment signInBottomSheetFragment) {
        TextInputEditText textInputEditText = signInBottomSheetFragment.emailEditText;
        FirebaseAuth firebaseAuth = null;
        if (textInputEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emailEditText");
            textInputEditText = null;
        }
        String strValueOf = String.valueOf(textInputEditText.getText());
        if (strValueOf.length() <= 0 || !signInBottomSheetFragment.isValidEmail(strValueOf)) {
            Toast.makeText(signInBottomSheetFragment.requireContext(), signInBottomSheetFragment.getString(R.string.enter_valid_email), 1).show();
        } else {
            FirebaseAuth firebaseAuth2 = signInBottomSheetFragment.firebaseAuth;
            if (firebaseAuth2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("firebaseAuth");
            } else {
                firebaseAuth = firebaseAuth2;
            }
            firebaseAuth.sendPasswordResetEmail(strValueOf).addOnCompleteListener(new OnCompleteListener() { // from class: com.studiolaganne.lengendarylens.SignInBottomSheetFragment$$ExternalSyntheticLambda16
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    SignInBottomSheetFragment.onViewCreated$lambda$4$0(this.f$0, task);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$4$0(SignInBottomSheetFragment signInBottomSheetFragment, Task task) {
        String string;
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isSuccessful()) {
            if (signInBottomSheetFragment.getContext() == null) {
                return;
            }
            Toast.makeText(signInBottomSheetFragment.requireContext(), signInBottomSheetFragment.getString(R.string.reset_password_sent), 1).show();
        } else {
            Exception exception = task.getException();
            if (exception == null || (string = exception.getLocalizedMessage()) == null) {
                string = signInBottomSheetFragment.getString(R.string.reset_password_error);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            }
            Toast.makeText(signInBottomSheetFragment.requireContext(), string, 1).show();
        }
    }

    static final void onViewCreated$lambda$5(SignInBottomSheetFragment signInBottomSheetFragment, View view, boolean z) {
        if (z) {
            return;
        }
        signInBottomSheetFragment.validateInputs();
    }

    static final void onViewCreated$lambda$6(SignInBottomSheetFragment signInBottomSheetFragment, View view, boolean z) {
        if (z) {
            return;
        }
        signInBottomSheetFragment.validateInputs();
    }

    static final Unit onViewCreated$lambda$8(SignInBottomSheetFragment signInBottomSheetFragment) {
        TextInputEditText textInputEditText = signInBottomSheetFragment.emailEditText;
        TextInputEditText textInputEditText2 = null;
        if (textInputEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emailEditText");
            textInputEditText = null;
        }
        String strValueOf = String.valueOf(textInputEditText.getText());
        TextInputEditText textInputEditText3 = signInBottomSheetFragment.passwordEditText;
        if (textInputEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("passwordEditText");
            textInputEditText3 = null;
        }
        String strValueOf2 = String.valueOf(textInputEditText3.getText());
        if (signInBottomSheetFragment.signUpMode) {
            TextInputEditText textInputEditText4 = signInBottomSheetFragment.firstnameEditText;
            if (textInputEditText4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("firstnameEditText");
            } else {
                textInputEditText2 = textInputEditText4;
            }
            signInBottomSheetFragment.createUserWithEmailAndPassword(strValueOf, strValueOf2, String.valueOf(textInputEditText2.getText()));
        } else {
            signInBottomSheetFragment.signInWithEmailAndPassword(strValueOf, strValueOf2);
        }
        return Unit.INSTANCE;
    }

    static final Unit onViewCreated$lambda$9(SignInBottomSheetFragment signInBottomSheetFragment) {
        signInBottomSheetFragment.startOAuthFlow("discord");
        return Unit.INSTANCE;
    }

    private final void sendVerificationEmailAndShowInstructions(final FirebaseUser user) {
        if (getView() == null) {
            return;
        }
        View viewFindViewById = requireView().findViewById(R.id.overlay);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        viewFindViewById.setVisibility(0);
        FirebaseAuth firebaseAuth = null;
        ActionCodeSettings actionCodeSettingsBuild = ActionCodeSettings.newBuilder().setUrl("https://" + (StringsKt.contains$default((CharSequence) "https://api.mythic.tools/", (CharSequence) "preprod", false, 2, (Object) null) ? "artifact.mythic.tools" : "mythic.tools") + "/mobile/auth/email/verify").setHandleCodeInApp(true).setAndroidPackageName(requireContext().getPackageName(), true, null).build();
        Intrinsics.checkNotNullExpressionValue(actionCodeSettingsBuild, "build(...)");
        String language = Locale.getDefault().getLanguage();
        FirebaseAuth firebaseAuth2 = this.firebaseAuth;
        if (firebaseAuth2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("firebaseAuth");
        } else {
            firebaseAuth = firebaseAuth2;
        }
        firebaseAuth.setLanguageCode(language);
        user.sendEmailVerification(actionCodeSettingsBuild).addOnCompleteListener(new OnCompleteListener() { // from class: com.studiolaganne.lengendarylens.SignInBottomSheetFragment$$ExternalSyntheticLambda17
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                SignInBottomSheetFragment.sendVerificationEmailAndShowInstructions$lambda$0(this.f$0, user, task);
            }
        });
    }

    static final void sendVerificationEmailAndShowInstructions$lambda$0(SignInBottomSheetFragment signInBottomSheetFragment, FirebaseUser firebaseUser, Task task) {
        String localizedMessage;
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isSuccessful()) {
            String email = firebaseUser.getEmail();
            if (email == null) {
                email = "";
            }
            signInBottomSheetFragment.showVerificationEmailSentDialog(email);
            return;
        }
        Exception exception = task.getException();
        if (exception == null || (localizedMessage = exception.getLocalizedMessage()) == null) {
            localizedMessage = "Failed to send verification email";
        }
        SignInCallback signInCallback = signInBottomSheetFragment.callback;
        if (signInCallback != null) {
            signInCallback.onSignInFailure(localizedMessage);
        }
        View viewFindViewById = signInBottomSheetFragment.requireView().findViewById(R.id.overlay);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        viewFindViewById.setVisibility(8);
    }

    private final void showVerificationEmailSentDialog(String email) {
        if (getView() == null) {
            return;
        }
        View viewFindViewById = requireView().findViewById(R.id.overlay);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        viewFindViewById.setVisibility(0);
        final View viewFindViewById2 = requireView().findViewById(R.id.loadingAnimationView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        viewFindViewById2.setVisibility(8);
        View viewFindViewById3 = requireView().findViewById(R.id.email_icon_2);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        final TextView textView = (TextView) viewFindViewById3;
        View viewFindViewById4 = requireView().findViewById(R.id.connectingTextViewTitle);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        final TextView textView2 = (TextView) viewFindViewById4;
        View viewFindViewById5 = requireView().findViewById(R.id.connectingTextView);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        final TextView textView3 = (TextView) viewFindViewById5;
        final View viewFindViewById6 = requireView().findViewById(R.id.resendEmailButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        textView.setVisibility(0);
        textView2.setVisibility(0);
        textView3.setVisibility(0);
        viewFindViewById6.setVisibility(0);
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById6, new Function0() { // from class: com.studiolaganne.lengendarylens.SignInBottomSheetFragment$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SignInBottomSheetFragment.showVerificationEmailSentDialog$lambda$0(this.f$0, textView, textView2, textView3, viewFindViewById6, viewFindViewById2);
            }
        });
    }

    static final Unit showVerificationEmailSentDialog$lambda$0(SignInBottomSheetFragment signInBottomSheetFragment, TextView textView, TextView textView2, TextView textView3, View view, View view2) {
        FirebaseAuth firebaseAuth = signInBottomSheetFragment.firebaseAuth;
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
            signInBottomSheetFragment.sendVerificationEmailAndShowInstructions(currentUser);
        }
        return Unit.INSTANCE;
    }

    private final void signInWithEmailAndPassword(String email, String password) {
        FirebaseAuth firebaseAuth = this.firebaseAuth;
        if (firebaseAuth == null) {
            Intrinsics.throwUninitializedPropertyAccessException("firebaseAuth");
            firebaseAuth = null;
        }
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener() { // from class: com.studiolaganne.lengendarylens.SignInBottomSheetFragment$$ExternalSyntheticLambda8
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                SignInBottomSheetFragment.signInWithEmailAndPassword$lambda$0(this.f$0, task);
            }
        });
    }

    static final void signInWithEmailAndPassword$lambda$0(SignInBottomSheetFragment signInBottomSheetFragment, Task task) {
        String localizedMessage;
        Intrinsics.checkNotNullParameter(task, "task");
        if (!task.isSuccessful()) {
            Exception exception = task.getException();
            if (exception == null || (localizedMessage = exception.getLocalizedMessage()) == null) {
                localizedMessage = "Authentication failed";
            }
            SignInCallback signInCallback = signInBottomSheetFragment.callback;
            if (signInCallback != null) {
                signInCallback.onSignInFailure(localizedMessage);
                return;
            }
            return;
        }
        FirebaseAuth firebaseAuth = signInBottomSheetFragment.firebaseAuth;
        if (firebaseAuth == null) {
            Intrinsics.throwUninitializedPropertyAccessException("firebaseAuth");
            firebaseAuth = null;
        }
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if (currentUser == null || currentUser.isEmailVerified()) {
            signInBottomSheetFragment.handleSuccessfulFirebaseAuth();
        } else {
            signInBottomSheetFragment.sendVerificationEmailAndShowInstructions(currentUser);
        }
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
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        new PreferencesManager(contextRequireContext).setString("current_oauth_provider", provider);
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void validateInputs() {
        String string;
        String string2;
        TextInputLayout textInputLayout;
        TextInputLayout textInputLayout2;
        TextInputLayout textInputLayout3;
        TextInputLayout textInputLayout4;
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
            View view2 = getView();
            if (view2 != null && (textInputLayout = (TextInputLayout) view2.findViewById(R.id.emailInputLayout)) != null) {
                textInputLayout.setError(null);
            }
        } else {
            View view3 = getView();
            if (view3 != null && (textInputLayout4 = (TextInputLayout) view3.findViewById(R.id.emailInputLayout)) != null) {
                textInputLayout4.setError(getString(R.string.invalid_email));
            }
        }
        if (string2.length() > 0) {
            View view4 = getView();
            if (view4 != null && (textInputLayout3 = (TextInputLayout) view4.findViewById(R.id.passwordInputLayout)) != null) {
                textInputLayout3.setError(strValidatePassword);
            }
        } else {
            View view5 = getView();
            if (view5 != null && (textInputLayout2 = (TextInputLayout) view5.findViewById(R.id.passwordInputLayout)) != null) {
                textInputLayout2.setError(null);
            }
        }
        if (zIsValidEmail && z && z2) {
            View view6 = this.signInWithEmailActionButton;
            if (view6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("signInWithEmailActionButton");
                view6 = null;
            }
            view6.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.custom_email_button_background));
            TextView textView = this.signInText;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("signInText");
                textView = null;
            }
            textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.almost_black));
            View view7 = this.signInWithEmailActionButton;
            if (view7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("signInWithEmailActionButton");
            } else {
                view = view7;
            }
            view.setEnabled(true);
            return;
        }
        View view8 = this.signInWithEmailActionButton;
        if (view8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signInWithEmailActionButton");
            view8 = null;
        }
        view8.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.custom_email_button_background_disabled));
        TextView textView2 = this.signInText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signInText");
            textView2 = null;
        }
        textView2.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_grey));
        View view9 = this.signInWithEmailActionButton;
        if (view9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signInWithEmailActionButton");
        } else {
            view = view9;
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

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        GoogleSignInOptions googleSignInOptionsBuild = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(getResources().getString(R.string.default_web_client_id)).requestEmail().build();
        Intrinsics.checkNotNullExpressionValue(googleSignInOptionsBuild, "build(...)");
        GoogleSignInClient client = GoogleSignIn.getClient(requireContext(), googleSignInOptionsBuild);
        Intrinsics.checkNotNullExpressionValue(client, "getClient(...)");
        this.googleSignInClient = client;
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        Intrinsics.checkNotNullExpressionValue(firebaseAuth, "getInstance(...)");
        this.firebaseAuth = firebaseAuth;
        return inflater.inflate(R.layout.bottom_sheet_signin, container, false);
    }

    public final void onEmailVerified() {
        handleSuccessfulFirebaseAuth();
    }

    public final void onOAuthCodeReceived(String code, String provider) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(provider, "provider");
        SignInCallback signInCallback = this.callback;
        if (signInCallback != null) {
            signInCallback.onOAuthSignInSuccess(code, provider);
        }
        dismiss();
    }

    public final void onOAuthError(String errorMessage) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        SignInCallback signInCallback = this.callback;
        if (signInCallback != null) {
            signInCallback.onSignInFailure("OAuth error: " + errorMessage);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        TextInputLayout textInputLayout;
        String str;
        TextView textView;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ImageView imageView = (ImageView) view.findViewById(R.id.chevron_down);
        final View viewFindViewById = view.findViewById(R.id.google_sign_in_button);
        final View viewFindViewById2 = view.findViewById(R.id.email_sign_in_button);
        TextView textView2 = (TextView) view.findViewById(R.id.orContinueLabel);
        final View viewFindViewById3 = view.findViewById(R.id.extra_sign_in_button);
        View viewFindViewById4 = view.findViewById(R.id.emailEditText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.emailEditText = (TextInputEditText) viewFindViewById4;
        View viewFindViewById5 = view.findViewById(R.id.passwordEditText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.passwordEditText = (TextInputEditText) viewFindViewById5;
        View viewFindViewById6 = view.findViewById(R.id.firstnameEditText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.firstnameEditText = (TextInputEditText) viewFindViewById6;
        View viewFindViewById7 = view.findViewById(R.id.signInWithEmailButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.signInWithEmailActionButton = viewFindViewById7;
        View viewFindViewById8 = view.findViewById(R.id.signInText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.signInText = (TextView) viewFindViewById8;
        final View viewFindViewById9 = view.findViewById(R.id.closeEmailLayout);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.closeEmailImage);
        final TextInputLayout textInputLayout2 = (TextInputLayout) view.findViewById(R.id.firstnameInputLayout);
        final TextInputLayout textInputLayout3 = (TextInputLayout) view.findViewById(R.id.emailInputLayout);
        final TextInputLayout textInputLayout4 = (TextInputLayout) view.findViewById(R.id.passwordInputLayout);
        final TextView textView3 = (TextView) view.findViewById(R.id.signUpPromptText);
        final TextView textView4 = (TextView) view.findViewById(R.id.signInPromptText);
        final TextView textView5 = (TextView) view.findViewById(R.id.forgottenPasswordText);
        Intrinsics.checkNotNull(imageView);
        ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.SignInBottomSheetFragment$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SignInBottomSheetFragment.onViewCreated$lambda$0(this.f$0);
            }
        });
        String string = getString(R.string.no_account_sign_up);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String str2 = string;
        SpannableString spannableString = new SpannableString(str2);
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str2, "?", 0, false, 6, (Object) null);
        if (iIndexOf$default == -1 || iIndexOf$default + 1 >= string.length()) {
            textInputLayout = textInputLayout2;
            str = "getString(...)";
            textView = textView2;
        } else {
            int i = iIndexOf$default + 2;
            spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.selected_color_new)), i, string.length(), 33);
            spannableString.setSpan(new StyleSpan(1), i, string.length(), 33);
            textView = textView2;
            str = "getString(...)";
            textView4 = textView4;
            textInputLayout = textInputLayout2;
            spannableString.setSpan(new ClickableSpan() { // from class: com.studiolaganne.lengendarylens.SignInBottomSheetFragment.onViewCreated.2
                private final void showSignUpMode() {
                    textInputLayout2.setVisibility(0);
                    textView4.setVisibility(0);
                    textView3.setVisibility(8);
                    textView5.setVisibility(8);
                    TextView textView6 = this.signInText;
                    if (textView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("signInText");
                        textView6 = null;
                    }
                    textView6.setText(this.getString(R.string.sign_up));
                    this.signUpMode = true;
                }

                @Override // android.text.style.ClickableSpan
                public void onClick(View widget) {
                    Intrinsics.checkNotNullParameter(widget, "widget");
                    showSignUpMode();
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint ds) {
                    Intrinsics.checkNotNullParameter(ds, "ds");
                    ds.setUnderlineText(false);
                    ds.setColor(ContextCompat.getColor(this.requireContext(), R.color.selected_color_new));
                }
            }, i, string.length(), 33);
        }
        textView3.setText(spannableString);
        textView3.setMovementMethod(LinkMovementMethod.getInstance());
        textView3.setHighlightColor(0);
        String string2 = getString(R.string.already_account_sign_in);
        Intrinsics.checkNotNullExpressionValue(string2, str);
        String str3 = string2;
        SpannableString spannableString2 = new SpannableString(str3);
        int iIndexOf$default2 = StringsKt.indexOf$default((CharSequence) str3, "?", 0, false, 6, (Object) null);
        if (iIndexOf$default2 != -1 && iIndexOf$default2 + 1 < string.length()) {
            int i2 = iIndexOf$default2 + 2;
            spannableString2.setSpan(new ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.selected_color_new)), i2, string2.length(), 33);
            spannableString2.setSpan(new StyleSpan(1), i2, string2.length(), 33);
            final TextInputLayout textInputLayout5 = textInputLayout;
            textView4 = textView4;
            spannableString2.setSpan(new ClickableSpan() { // from class: com.studiolaganne.lengendarylens.SignInBottomSheetFragment.onViewCreated.3
                private final void showSignInMode() {
                    textInputLayout5.setVisibility(8);
                    textView4.setVisibility(8);
                    textView3.setVisibility(0);
                    textView5.setVisibility(0);
                    TextView textView6 = this.signInText;
                    if (textView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("signInText");
                        textView6 = null;
                    }
                    textView6.setText(this.getString(R.string.sign_in));
                    this.signUpMode = false;
                }

                @Override // android.text.style.ClickableSpan
                public void onClick(View widget) {
                    Intrinsics.checkNotNullParameter(widget, "widget");
                    showSignInMode();
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint ds) {
                    Intrinsics.checkNotNullParameter(ds, "ds");
                    ds.setUnderlineText(false);
                    ds.setColor(ContextCompat.getColor(this.requireContext(), R.color.selected_color_new));
                }
            }, i2, string2.length(), 33);
        }
        textView4.setText(spannableString2);
        textView4.setMovementMethod(LinkMovementMethod.getInstance());
        textView4.setHighlightColor(0);
        View viewFindViewById10 = view.findViewById(R.id.google_sign_in_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById10, new Function0() { // from class: com.studiolaganne.lengendarylens.SignInBottomSheetFragment$$ExternalSyntheticLambda23
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SignInBottomSheetFragment.onViewCreated$lambda$1(this.f$0);
            }
        });
        Intrinsics.checkNotNull(imageView2);
        ImageView imageView3 = imageView2;
        final TextView textView6 = textView;
        final TextView textView7 = textView4;
        final TextInputLayout textInputLayout6 = textInputLayout;
        ViewExtensionsKt.setOnClickWithFade(imageView3, new Function0() { // from class: com.studiolaganne.lengendarylens.SignInBottomSheetFragment$$ExternalSyntheticLambda24
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SignInBottomSheetFragment.onViewCreated$lambda$2(viewFindViewById, viewFindViewById2, textView6, viewFindViewById3, textInputLayout6, viewFindViewById9, textInputLayout3, textInputLayout4, this, textView3, textView7, textView5);
            }
        });
        View viewFindViewById11 = view.findViewById(R.id.email_sign_in_button);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById11, new Function0() { // from class: com.studiolaganne.lengendarylens.SignInBottomSheetFragment$$ExternalSyntheticLambda25
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SignInBottomSheetFragment.onViewCreated$lambda$3(viewFindViewById, viewFindViewById2, textView6, viewFindViewById3, textInputLayout6, viewFindViewById9, textInputLayout3, textInputLayout4, textView5, this, textView3, textView7);
            }
        });
        if (textView5 != null) {
            ViewExtensionsKt.setOnClickWithFade(textView5, new Function0() { // from class: com.studiolaganne.lengendarylens.SignInBottomSheetFragment$$ExternalSyntheticLambda26
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SignInBottomSheetFragment.onViewCreated$lambda$4(this.f$0);
                }
            });
        }
        TextWatcher textWatcher = new TextWatcher() { // from class: com.studiolaganne.lengendarylens.SignInBottomSheetFragment$onViewCreated$textWatcher$1
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
        View view2 = null;
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
        textInputEditText4.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.studiolaganne.lengendarylens.SignInBottomSheetFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view3, boolean z) {
                SignInBottomSheetFragment.onViewCreated$lambda$5(this.f$0, view3, z);
            }
        });
        TextInputEditText textInputEditText5 = this.passwordEditText;
        if (textInputEditText5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("passwordEditText");
            textInputEditText5 = null;
        }
        textInputEditText5.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.studiolaganne.lengendarylens.SignInBottomSheetFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view3, boolean z) {
                SignInBottomSheetFragment.onViewCreated$lambda$6(this.f$0, view3, z);
            }
        });
        view.getViewTreeObserver().addOnGlobalFocusChangeListener(new ViewTreeObserver.OnGlobalFocusChangeListener() { // from class: com.studiolaganne.lengendarylens.SignInBottomSheetFragment$$ExternalSyntheticLambda3
            @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
            public final void onGlobalFocusChanged(View view3, View view4) {
                this.f$0.validateInputs();
            }
        });
        View view3 = this.signInWithEmailActionButton;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signInWithEmailActionButton");
        } else {
            view2 = view3;
        }
        ViewExtensionsKt.setOnClickWithFade(view2, new Function0() { // from class: com.studiolaganne.lengendarylens.SignInBottomSheetFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SignInBottomSheetFragment.onViewCreated$lambda$8(this.f$0);
            }
        });
        View viewFindViewById12 = view.findViewById(R.id.discordButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById12, new Function0() { // from class: com.studiolaganne.lengendarylens.SignInBottomSheetFragment$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SignInBottomSheetFragment.onViewCreated$lambda$9(this.f$0);
            }
        });
        View viewFindViewById13 = view.findViewById(R.id.twitchButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById13, new Function0() { // from class: com.studiolaganne.lengendarylens.SignInBottomSheetFragment$$ExternalSyntheticLambda21
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SignInBottomSheetFragment.onViewCreated$lambda$10(this.f$0);
            }
        });
        View viewFindViewById14 = view.findViewById(R.id.appleButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById14, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade(viewFindViewById14, new Function0() { // from class: com.studiolaganne.lengendarylens.SignInBottomSheetFragment$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SignInBottomSheetFragment.onViewCreated$lambda$11(this.f$0);
            }
        });
    }
}
