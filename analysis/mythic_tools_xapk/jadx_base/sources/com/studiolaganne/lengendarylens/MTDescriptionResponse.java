package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J2\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTDescriptionResponse;", "", "description", "", "message", "code", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "getMessage", "setMessage", "getCode", "()Ljava/lang/Integer;", "setCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/studiolaganne/lengendarylens/MTDescriptionResponse;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTDescriptionResponse {
    public static final int $stable = 8;
    private Integer code;
    private String description;
    private String message;

    public MTDescriptionResponse() {
        this(null, null, null, 7, null);
    }

    public MTDescriptionResponse(String str, String str2, Integer num) {
        this.description = str;
        this.message = str2;
        this.code = num;
    }

    public /* synthetic */ MTDescriptionResponse(String str, String str2, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num);
    }

    public static /* synthetic */ MTDescriptionResponse copy$default(MTDescriptionResponse mTDescriptionResponse, String str, String str2, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTDescriptionResponse.description;
        }
        if ((i & 2) != 0) {
            str2 = mTDescriptionResponse.message;
        }
        if ((i & 4) != 0) {
            num = mTDescriptionResponse.code;
        }
        return mTDescriptionResponse.copy(str, str2, num);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getCode() {
        return this.code;
    }

    public final MTDescriptionResponse copy(String description, String message, Integer code) {
        return new MTDescriptionResponse(description, message, code);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTDescriptionResponse)) {
            return false;
        }
        MTDescriptionResponse mTDescriptionResponse = (MTDescriptionResponse) other;
        return Intrinsics.areEqual(this.description, mTDescriptionResponse.description) && Intrinsics.areEqual(this.message, mTDescriptionResponse.message) && Intrinsics.areEqual(this.code, mTDescriptionResponse.code);
    }

    public final Integer getCode() {
        return this.code;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        String str = this.description;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.message;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.code;
        return iHashCode2 + (num != null ? num.hashCode() : 0);
    }

    public final void setCode(Integer num) {
        this.code = num;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public String toString() {
        return "MTDescriptionResponse(description=" + this.description + ", message=" + this.message + ", code=" + this.code + ")";
    }
}
