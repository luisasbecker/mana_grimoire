package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006 "}, d2 = {"Lcom/studiolaganne/lengendarylens/MTVersionResponse;", "", "current", "", "latest", "hasUpdate", "", "url", "released", "changelog", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCurrent", "()Ljava/lang/String;", "getLatest", "getHasUpdate", "()Z", "getUrl", "getReleased", "getChangelog", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTVersionResponse {
    public static final int $stable = 0;
    private final String changelog;
    private final String current;
    private final boolean hasUpdate;
    private final String latest;
    private final String released;
    private final String url;

    public MTVersionResponse(String current, String latest, boolean z, String url, String released, String changelog) {
        Intrinsics.checkNotNullParameter(current, "current");
        Intrinsics.checkNotNullParameter(latest, "latest");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(released, "released");
        Intrinsics.checkNotNullParameter(changelog, "changelog");
        this.current = current;
        this.latest = latest;
        this.hasUpdate = z;
        this.url = url;
        this.released = released;
        this.changelog = changelog;
    }

    public /* synthetic */ MTVersionResponse(String str, String str2, boolean z, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, z, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? "" : str4, (i & 32) != 0 ? "" : str5);
    }

    public static /* synthetic */ MTVersionResponse copy$default(MTVersionResponse mTVersionResponse, String str, String str2, boolean z, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTVersionResponse.current;
        }
        if ((i & 2) != 0) {
            str2 = mTVersionResponse.latest;
        }
        if ((i & 4) != 0) {
            z = mTVersionResponse.hasUpdate;
        }
        if ((i & 8) != 0) {
            str3 = mTVersionResponse.url;
        }
        if ((i & 16) != 0) {
            str4 = mTVersionResponse.released;
        }
        if ((i & 32) != 0) {
            str5 = mTVersionResponse.changelog;
        }
        String str6 = str4;
        String str7 = str5;
        return mTVersionResponse.copy(str, str2, z, str3, str6, str7);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCurrent() {
        return this.current;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLatest() {
        return this.latest;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getHasUpdate() {
        return this.hasUpdate;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getReleased() {
        return this.released;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getChangelog() {
        return this.changelog;
    }

    public final MTVersionResponse copy(String current, String latest, boolean hasUpdate, String url, String released, String changelog) {
        Intrinsics.checkNotNullParameter(current, "current");
        Intrinsics.checkNotNullParameter(latest, "latest");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(released, "released");
        Intrinsics.checkNotNullParameter(changelog, "changelog");
        return new MTVersionResponse(current, latest, hasUpdate, url, released, changelog);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTVersionResponse)) {
            return false;
        }
        MTVersionResponse mTVersionResponse = (MTVersionResponse) other;
        return Intrinsics.areEqual(this.current, mTVersionResponse.current) && Intrinsics.areEqual(this.latest, mTVersionResponse.latest) && this.hasUpdate == mTVersionResponse.hasUpdate && Intrinsics.areEqual(this.url, mTVersionResponse.url) && Intrinsics.areEqual(this.released, mTVersionResponse.released) && Intrinsics.areEqual(this.changelog, mTVersionResponse.changelog);
    }

    public final String getChangelog() {
        return this.changelog;
    }

    public final String getCurrent() {
        return this.current;
    }

    public final boolean getHasUpdate() {
        return this.hasUpdate;
    }

    public final String getLatest() {
        return this.latest;
    }

    public final String getReleased() {
        return this.released;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (((((((((this.current.hashCode() * 31) + this.latest.hashCode()) * 31) + Boolean.hashCode(this.hasUpdate)) * 31) + this.url.hashCode()) * 31) + this.released.hashCode()) * 31) + this.changelog.hashCode();
    }

    public String toString() {
        return "MTVersionResponse(current=" + this.current + ", latest=" + this.latest + ", hasUpdate=" + this.hasUpdate + ", url=" + this.url + ", released=" + this.released + ", changelog=" + this.changelog + ")";
    }
}
