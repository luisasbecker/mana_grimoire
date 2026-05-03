package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTDBResponse;", "", "url", "", "size", "", "filename", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "getSize", "()I", "setSize", "(I)V", "getFilename", "setFilename", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTDBResponse {
    public static final int $stable = 8;
    private String filename;
    private int size;
    private String url;

    public MTDBResponse() {
        this(null, 0, null, 7, null);
    }

    public MTDBResponse(String url, int i, String filename) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(filename, "filename");
        this.url = url;
        this.size = i;
        this.filename = filename;
    }

    public /* synthetic */ MTDBResponse(String str, int i, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? "" : str2);
    }

    public static /* synthetic */ MTDBResponse copy$default(MTDBResponse mTDBResponse, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = mTDBResponse.url;
        }
        if ((i2 & 2) != 0) {
            i = mTDBResponse.size;
        }
        if ((i2 & 4) != 0) {
            str2 = mTDBResponse.filename;
        }
        return mTDBResponse.copy(str, i, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getSize() {
        return this.size;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getFilename() {
        return this.filename;
    }

    public final MTDBResponse copy(String url, int size, String filename) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(filename, "filename");
        return new MTDBResponse(url, size, filename);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTDBResponse)) {
            return false;
        }
        MTDBResponse mTDBResponse = (MTDBResponse) other;
        return Intrinsics.areEqual(this.url, mTDBResponse.url) && this.size == mTDBResponse.size && Intrinsics.areEqual(this.filename, mTDBResponse.filename);
    }

    public final String getFilename() {
        return this.filename;
    }

    public final int getSize() {
        return this.size;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (((this.url.hashCode() * 31) + Integer.hashCode(this.size)) * 31) + this.filename.hashCode();
    }

    public final void setFilename(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.filename = str;
    }

    public final void setSize(int i) {
        this.size = i;
    }

    public final void setUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    public String toString() {
        return "MTDBResponse(url=" + this.url + ", size=" + this.size + ", filename=" + this.filename + ")";
    }
}
