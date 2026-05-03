package com.studiolaganne.lengendarylens;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;

/* JADX INFO: compiled from: SignInBottomSheetFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0005H&J\b\u0010\r\u001a\u00020\u0003H&¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lcom/studiolaganne/lengendarylens/SignInCallback;", "", "onSignInSuccess", "", "token", "", "firstname", "email", "onOAuthSignInSuccess", "code", "type", "onSignInFailure", NotificationCompat.CATEGORY_MESSAGE, "onSignInCancel", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface SignInCallback {
    void onOAuthSignInSuccess(String code, String type);

    void onSignInCancel();

    void onSignInFailure(String msg);

    void onSignInSuccess(String token, String firstname, String email);
}
