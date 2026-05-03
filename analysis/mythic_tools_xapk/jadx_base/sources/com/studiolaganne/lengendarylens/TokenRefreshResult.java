package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FirebaseTokenManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J+\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/studiolaganne/lengendarylens/TokenRefreshResult;", "", "token", "", "failureReason", "isFirebaseUserNull", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getToken", "()Ljava/lang/String;", "getFailureReason", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class TokenRefreshResult {
    public static final int $stable = 0;
    private final String failureReason;
    private final boolean isFirebaseUserNull;
    private final String token;

    public TokenRefreshResult() {
        this(null, null, false, 7, null);
    }

    public TokenRefreshResult(String str, String str2, boolean z) {
        this.token = str;
        this.failureReason = str2;
        this.isFirebaseUserNull = z;
    }

    public /* synthetic */ TokenRefreshResult(String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? false : z);
    }

    public static /* synthetic */ TokenRefreshResult copy$default(TokenRefreshResult tokenRefreshResult, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = tokenRefreshResult.token;
        }
        if ((i & 2) != 0) {
            str2 = tokenRefreshResult.failureReason;
        }
        if ((i & 4) != 0) {
            z = tokenRefreshResult.isFirebaseUserNull;
        }
        return tokenRefreshResult.copy(str, str2, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFailureReason() {
        return this.failureReason;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsFirebaseUserNull() {
        return this.isFirebaseUserNull;
    }

    public final TokenRefreshResult copy(String token, String failureReason, boolean isFirebaseUserNull) {
        return new TokenRefreshResult(token, failureReason, isFirebaseUserNull);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TokenRefreshResult)) {
            return false;
        }
        TokenRefreshResult tokenRefreshResult = (TokenRefreshResult) other;
        return Intrinsics.areEqual(this.token, tokenRefreshResult.token) && Intrinsics.areEqual(this.failureReason, tokenRefreshResult.failureReason) && this.isFirebaseUserNull == tokenRefreshResult.isFirebaseUserNull;
    }

    public final String getFailureReason() {
        return this.failureReason;
    }

    public final String getToken() {
        return this.token;
    }

    public int hashCode() {
        String str = this.token;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.failureReason;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Boolean.hashCode(this.isFirebaseUserNull);
    }

    public final boolean isFirebaseUserNull() {
        return this.isFirebaseUserNull;
    }

    public String toString() {
        return "TokenRefreshResult(token=" + this.token + ", failureReason=" + this.failureReason + ", isFirebaseUserNull=" + this.isFirebaseUserNull + ")";
    }
}
