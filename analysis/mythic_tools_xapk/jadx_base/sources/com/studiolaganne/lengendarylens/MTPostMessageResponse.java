package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0012"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTPostMessageResponse;", "", "message", "Lcom/studiolaganne/lengendarylens/MTMessage;", "<init>", "(Lcom/studiolaganne/lengendarylens/MTMessage;)V", "getMessage", "()Lcom/studiolaganne/lengendarylens/MTMessage;", "setMessage", "component1", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTPostMessageResponse {
    public static final int $stable = 8;
    private MTMessage message;

    /* JADX WARN: Multi-variable type inference failed */
    public MTPostMessageResponse() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public MTPostMessageResponse(MTMessage mTMessage) {
        this.message = mTMessage;
    }

    public /* synthetic */ MTPostMessageResponse(MTMessage mTMessage, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : mTMessage);
    }

    public static /* synthetic */ MTPostMessageResponse copy$default(MTPostMessageResponse mTPostMessageResponse, MTMessage mTMessage, int i, Object obj) {
        if ((i & 1) != 0) {
            mTMessage = mTPostMessageResponse.message;
        }
        return mTPostMessageResponse.copy(mTMessage);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MTMessage getMessage() {
        return this.message;
    }

    public final MTPostMessageResponse copy(MTMessage message) {
        return new MTPostMessageResponse(message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MTPostMessageResponse) && Intrinsics.areEqual(this.message, ((MTPostMessageResponse) other).message);
    }

    public final MTMessage getMessage() {
        return this.message;
    }

    public int hashCode() {
        MTMessage mTMessage = this.message;
        if (mTMessage == null) {
            return 0;
        }
        return mTMessage.hashCode();
    }

    public final void setMessage(MTMessage mTMessage) {
        this.message = mTMessage;
    }

    public String toString() {
        return "MTPostMessageResponse(message=" + this.message + ")";
    }
}
