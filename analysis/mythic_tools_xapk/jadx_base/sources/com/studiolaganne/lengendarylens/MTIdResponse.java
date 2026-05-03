package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTIdResponse;", "", "id", "", "<init>", "(I)V", "getId", "()I", "component1", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTIdResponse {
    public static final int $stable = 0;
    private final int id;

    public MTIdResponse() {
        this(0, 1, null);
    }

    public MTIdResponse(int i) {
        this.id = i;
    }

    public /* synthetic */ MTIdResponse(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? -1 : i);
    }

    public static /* synthetic */ MTIdResponse copy$default(MTIdResponse mTIdResponse, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mTIdResponse.id;
        }
        return mTIdResponse.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    public final MTIdResponse copy(int id) {
        return new MTIdResponse(id);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MTIdResponse) && this.id == ((MTIdResponse) other).id;
    }

    public final int getId() {
        return this.id;
    }

    public int hashCode() {
        return Integer.hashCode(this.id);
    }

    public String toString() {
        return "MTIdResponse(id=" + this.id + ")";
    }
}
