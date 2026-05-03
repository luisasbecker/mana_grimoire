package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.fragment.app.FragmentManager;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.firebase.auth.FirebaseAuth;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AuthErrorHandler.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011J\"\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005J$\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0019J\u0006\u0010\u001a\u001a\u00020\u0013J \u0010\u001b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/studiolaganne/lengendarylens/AuthErrorHandler;", "", "<init>", "()V", "TAG", "", "ACTION_AUTH_ERROR", "EXTRA_ERROR_CODE", "EXTRA_ERROR_MESSAGE", "isShowingAuthDialog", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isAuthError", "", "errorCode", "", "hasValidFirebaseSession", "context", "Landroid/content/Context;", "broadcastAuthError", "", "errorMessage", "showSessionExpiredDialog", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "onSignInClicked", "Lkotlin/Function0;", "resetDialogState", "handleApiError", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AuthErrorHandler {
    public static final String ACTION_AUTH_ERROR = "com.studiolaganne.lengendarylens.AUTH_ERROR";
    public static final String EXTRA_ERROR_CODE = "error_code";
    public static final String EXTRA_ERROR_MESSAGE = "error_message";
    private static final String TAG = "AuthErrorHandler";
    public static final AuthErrorHandler INSTANCE = new AuthErrorHandler();
    private static final AtomicBoolean isShowingAuthDialog = new AtomicBoolean(false);
    public static final int $stable = 8;

    private AuthErrorHandler() {
    }

    public static /* synthetic */ void broadcastAuthError$default(AuthErrorHandler authErrorHandler, Context context, int i, String str, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str = null;
        }
        authErrorHandler.broadcastAuthError(context, i, str);
    }

    static final Unit showSessionExpiredDialog$lambda$0(Function0 function0, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        function0.invoke();
        return Unit.INSTANCE;
    }

    static final Unit showSessionExpiredDialog$lambda$1() {
        isShowingAuthDialog.set(false);
        return Unit.INSTANCE;
    }

    public final void broadcastAuthError(Context context, int errorCode, String errorMessage) {
        Intrinsics.checkNotNullParameter(context, "context");
        Log.d(TAG, "Broadcasting auth error: code=" + errorCode + ", message=" + errorMessage);
        Intent intent = new Intent(ACTION_AUTH_ERROR);
        intent.putExtra("error_code", errorCode);
        if (errorMessage == null) {
            errorMessage = "Authentication failed";
        }
        intent.putExtra("error_message", errorMessage);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    public final boolean handleApiError(Context context, int errorCode, String errorMessage) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!isAuthError(errorCode)) {
            return false;
        }
        Log.w(TAG, "Auth error detected: code=" + errorCode + ", message=" + errorMessage);
        broadcastAuthError(context, errorCode, errorMessage);
        return true;
    }

    public final boolean hasValidFirebaseSession(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        boolean zHasValidUser = new PreferencesManager(context).hasValidUser();
        boolean z = FirebaseAuth.getInstance().getCurrentUser() != null;
        if (!zHasValidUser || z) {
            return true;
        }
        Log.w(TAG, "State mismatch: App has user but Firebase currentUser is null");
        return false;
    }

    public final boolean isAuthError(int errorCode) {
        return errorCode == MTError.FIREBASE_TOKEN_EXPIRED.getCode() || errorCode == MTError.FIREBASE_ERROR.getCode();
    }

    public final void resetDialogState() {
        isShowingAuthDialog.set(false);
    }

    public final void showSessionExpiredDialog(Context context, FragmentManager fragmentManager, final Function0<Unit> onSignInClicked) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(onSignInClicked, "onSignInClicked");
        if (isShowingAuthDialog.getAndSet(true)) {
            Log.d(TAG, "Auth dialog already showing, skipping");
            return;
        }
        try {
            CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
            String string = context.getString(R.string.session_expired_title);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDialogFragment.Builder title = builder.setTitle(string);
            String string2 = context.getString(R.string.session_expired_message);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            CustomDialogFragment.Builder body = title.setBody(string2);
            String string3 = context.getString(R.string.sign_in_again);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.AuthErrorHandler$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AuthErrorHandler.showSessionExpiredDialog$lambda$0(onSignInClicked, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                }
            }).setOnDismissListener(new Function0() { // from class: com.studiolaganne.lengendarylens.AuthErrorHandler$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AuthErrorHandler.showSessionExpiredDialog$lambda$1();
                }
            }).show(fragmentManager, "session_expired_dialog");
        } catch (Exception e) {
            Log.e(TAG, "Failed to show session expired dialog", e);
            isShowingAuthDialog.set(false);
        }
    }
}
