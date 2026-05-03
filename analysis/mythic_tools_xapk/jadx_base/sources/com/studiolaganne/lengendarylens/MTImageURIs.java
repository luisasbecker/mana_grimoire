package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\""}, d2 = {"Lcom/studiolaganne/lengendarylens/MTImageURIs;", "", "small", "", "normal", "large", "png", "border_crop", "art_crop", "gatherer", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSmall", "()Ljava/lang/String;", "getNormal", "getLarge", "getPng", "getBorder_crop", "getArt_crop", "getGatherer", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTImageURIs {
    public static final int $stable = 0;
    private final String art_crop;
    private final String border_crop;
    private final String gatherer;
    private final String large;
    private final String normal;
    private final String png;
    private final String small;

    public MTImageURIs() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public MTImageURIs(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.small = str;
        this.normal = str2;
        this.large = str3;
        this.png = str4;
        this.border_crop = str5;
        this.art_crop = str6;
        this.gatherer = str7;
    }

    public /* synthetic */ MTImageURIs(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7);
    }

    public static /* synthetic */ MTImageURIs copy$default(MTImageURIs mTImageURIs, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTImageURIs.small;
        }
        if ((i & 2) != 0) {
            str2 = mTImageURIs.normal;
        }
        if ((i & 4) != 0) {
            str3 = mTImageURIs.large;
        }
        if ((i & 8) != 0) {
            str4 = mTImageURIs.png;
        }
        if ((i & 16) != 0) {
            str5 = mTImageURIs.border_crop;
        }
        if ((i & 32) != 0) {
            str6 = mTImageURIs.art_crop;
        }
        if ((i & 64) != 0) {
            str7 = mTImageURIs.gatherer;
        }
        String str8 = str6;
        String str9 = str7;
        String str10 = str5;
        String str11 = str3;
        return mTImageURIs.copy(str, str2, str11, str4, str10, str8, str9);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSmall() {
        return this.small;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getNormal() {
        return this.normal;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLarge() {
        return this.large;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPng() {
        return this.png;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getBorder_crop() {
        return this.border_crop;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getArt_crop() {
        return this.art_crop;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getGatherer() {
        return this.gatherer;
    }

    public final MTImageURIs copy(String small, String normal, String large, String png, String border_crop, String art_crop, String gatherer) {
        return new MTImageURIs(small, normal, large, png, border_crop, art_crop, gatherer);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTImageURIs)) {
            return false;
        }
        MTImageURIs mTImageURIs = (MTImageURIs) other;
        return Intrinsics.areEqual(this.small, mTImageURIs.small) && Intrinsics.areEqual(this.normal, mTImageURIs.normal) && Intrinsics.areEqual(this.large, mTImageURIs.large) && Intrinsics.areEqual(this.png, mTImageURIs.png) && Intrinsics.areEqual(this.border_crop, mTImageURIs.border_crop) && Intrinsics.areEqual(this.art_crop, mTImageURIs.art_crop) && Intrinsics.areEqual(this.gatherer, mTImageURIs.gatherer);
    }

    public final String getArt_crop() {
        return this.art_crop;
    }

    public final String getBorder_crop() {
        return this.border_crop;
    }

    public final String getGatherer() {
        return this.gatherer;
    }

    public final String getLarge() {
        return this.large;
    }

    public final String getNormal() {
        return this.normal;
    }

    public final String getPng() {
        return this.png;
    }

    public final String getSmall() {
        return this.small;
    }

    public int hashCode() {
        String str = this.small;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.normal;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.large;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.png;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.border_crop;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.art_crop;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.gatherer;
        return iHashCode6 + (str7 != null ? str7.hashCode() : 0);
    }

    public String toString() {
        return "MTImageURIs(small=" + this.small + ", normal=" + this.normal + ", large=" + this.large + ", png=" + this.png + ", border_crop=" + this.border_crop + ", art_crop=" + this.art_crop + ", gatherer=" + this.gatherer + ")";
    }
}
