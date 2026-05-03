package com.studiolaganne.lengendarylens;

import android.content.Context;
import androidx.work.PeriodicWorkRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TokenValidator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/studiolaganne/lengendarylens/TokenValidator;", "", "<init>", "()V", "isTokenValid", "", "context", "Landroid/content/Context;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TokenValidator {
    public static final int $stable = 0;
    public static final TokenValidator INSTANCE = new TokenValidator();

    private TokenValidator() {
    }

    public final boolean isTokenValid(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        long tokenExpiryTime = new PreferencesManager(context).getTokenExpiryTime();
        return tokenExpiryTime != 0 && System.currentTimeMillis() < tokenExpiryTime - PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
    }
}
