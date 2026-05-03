package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTResponse;", "", "message", "", "code", "", "<init>", "(Ljava/lang/String;I)V", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getCode", "()I", "setCode", "(I)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTResponse {
    public static final int $stable = 8;
    private int code;
    private String message;

    public MTResponse(String message, int i) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.message = message;
        this.code = i;
    }

    public static /* synthetic */ MTResponse copy$default(MTResponse mTResponse, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = mTResponse.message;
        }
        if ((i2 & 2) != 0) {
            i = mTResponse.code;
        }
        return mTResponse.copy(str, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    public final MTResponse copy(String message, int code) {
        Intrinsics.checkNotNullParameter(message, "message");
        return new MTResponse(message, code);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTResponse)) {
            return false;
        }
        MTResponse mTResponse = (MTResponse) other;
        return Intrinsics.areEqual(this.message, mTResponse.message) && this.code == mTResponse.code;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        return (this.message.hashCode() * 31) + Integer.hashCode(this.code);
    }

    public final void setCode(int i) {
        this.code = i;
    }

    public final void setMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.message = str;
    }

    public String toString() {
        return "MTResponse(message=" + this.message + ", code=" + this.code + ")";
    }
}
