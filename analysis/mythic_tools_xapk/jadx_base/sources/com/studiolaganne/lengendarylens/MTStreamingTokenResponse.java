package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTStreamingTokenResponse;", "", "streamingToken", "", "<init>", "(Ljava/lang/String;)V", "getStreamingToken", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTStreamingTokenResponse {
    public static final int $stable = 0;
    private final String streamingToken;

    /* JADX WARN: Multi-variable type inference failed */
    public MTStreamingTokenResponse() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public MTStreamingTokenResponse(String streamingToken) {
        Intrinsics.checkNotNullParameter(streamingToken, "streamingToken");
        this.streamingToken = streamingToken;
    }

    public /* synthetic */ MTStreamingTokenResponse(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str);
    }

    public static /* synthetic */ MTStreamingTokenResponse copy$default(MTStreamingTokenResponse mTStreamingTokenResponse, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTStreamingTokenResponse.streamingToken;
        }
        return mTStreamingTokenResponse.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getStreamingToken() {
        return this.streamingToken;
    }

    public final MTStreamingTokenResponse copy(String streamingToken) {
        Intrinsics.checkNotNullParameter(streamingToken, "streamingToken");
        return new MTStreamingTokenResponse(streamingToken);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MTStreamingTokenResponse) && Intrinsics.areEqual(this.streamingToken, ((MTStreamingTokenResponse) other).streamingToken);
    }

    public final String getStreamingToken() {
        return this.streamingToken;
    }

    public int hashCode() {
        return this.streamingToken.hashCode();
    }

    public String toString() {
        return "MTStreamingTokenResponse(streamingToken=" + this.streamingToken + ")";
    }
}
