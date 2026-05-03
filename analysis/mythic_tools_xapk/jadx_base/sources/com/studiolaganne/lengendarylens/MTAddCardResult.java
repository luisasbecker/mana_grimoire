package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTAddCardResult;", "", "original_data", "Lcom/studiolaganne/lengendarylens/MTAddCardOriginalData;", "reason", "", "details", "<init>", "(Lcom/studiolaganne/lengendarylens/MTAddCardOriginalData;Ljava/lang/String;Ljava/lang/String;)V", "getOriginal_data", "()Lcom/studiolaganne/lengendarylens/MTAddCardOriginalData;", "getReason", "()Ljava/lang/String;", "getDetails", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTAddCardResult {
    public static final int $stable = 0;
    private final String details;
    private final MTAddCardOriginalData original_data;
    private final String reason;

    public MTAddCardResult() {
        this(null, null, null, 7, null);
    }

    public MTAddCardResult(MTAddCardOriginalData mTAddCardOriginalData, String str, String str2) {
        this.original_data = mTAddCardOriginalData;
        this.reason = str;
        this.details = str2;
    }

    public /* synthetic */ MTAddCardResult(MTAddCardOriginalData mTAddCardOriginalData, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : mTAddCardOriginalData, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
    }

    public static /* synthetic */ MTAddCardResult copy$default(MTAddCardResult mTAddCardResult, MTAddCardOriginalData mTAddCardOriginalData, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            mTAddCardOriginalData = mTAddCardResult.original_data;
        }
        if ((i & 2) != 0) {
            str = mTAddCardResult.reason;
        }
        if ((i & 4) != 0) {
            str2 = mTAddCardResult.details;
        }
        return mTAddCardResult.copy(mTAddCardOriginalData, str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MTAddCardOriginalData getOriginal_data() {
        return this.original_data;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getReason() {
        return this.reason;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDetails() {
        return this.details;
    }

    public final MTAddCardResult copy(MTAddCardOriginalData original_data, String reason, String details) {
        return new MTAddCardResult(original_data, reason, details);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTAddCardResult)) {
            return false;
        }
        MTAddCardResult mTAddCardResult = (MTAddCardResult) other;
        return Intrinsics.areEqual(this.original_data, mTAddCardResult.original_data) && Intrinsics.areEqual(this.reason, mTAddCardResult.reason) && Intrinsics.areEqual(this.details, mTAddCardResult.details);
    }

    public final String getDetails() {
        return this.details;
    }

    public final MTAddCardOriginalData getOriginal_data() {
        return this.original_data;
    }

    public final String getReason() {
        return this.reason;
    }

    public int hashCode() {
        MTAddCardOriginalData mTAddCardOriginalData = this.original_data;
        int iHashCode = (mTAddCardOriginalData == null ? 0 : mTAddCardOriginalData.hashCode()) * 31;
        String str = this.reason;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.details;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "MTAddCardResult(original_data=" + this.original_data + ", reason=" + this.reason + ", details=" + this.details + ")";
    }
}
