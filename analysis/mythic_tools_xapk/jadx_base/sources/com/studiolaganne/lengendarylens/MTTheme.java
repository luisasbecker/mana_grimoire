package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bD\b\u0087\b\u0018\u00002\u00020\u0001B¹\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0005HÆ\u0003J\t\u0010L\u001a\u00020\u0005HÆ\u0003J\u0011\u0010M\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000eHÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010O\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u00105J\u0010\u0010P\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u00105J\u0010\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010<J\u000b\u0010R\u001a\u0004\u0018\u00010\u0015HÆ\u0003JÀ\u0001\u0010S\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÆ\u0001¢\u0006\u0002\u0010TJ\u0013\u0010U\u001a\u00020\u00112\b\u0010V\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010W\u001a\u00020\u0003HÖ\u0001J\t\u0010X\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001d\"\u0004\b'\u0010\u001fR\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0019\"\u0004\b)\u0010\u001bR\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010\u001fR\u001a\u0010\f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001d\"\u0004\b-\u0010\u001fR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001d\"\u0004\b3\u0010\u001fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\b9\u00105\"\u0004\b:\u00107R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010?\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010C¨\u0006Y"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTTheme;", "", "id", "", Constants.GP_IAP_TITLE, "", "catchphrase", "description", "contents", "bannerurl", "version", "googleproductid", "appleproductid", "screenshots", "", FirebaseAnalytics.Param.PRICE, "instore", "", "spotlight", "spotlight_order", "category", "Lcom/studiolaganne/lengendarylens/MTThemeCategory;", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Lcom/studiolaganne/lengendarylens/MTThemeCategory;)V", "getId", "()I", "setId", "(I)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getCatchphrase", "setCatchphrase", "getDescription", "setDescription", "getContents", "setContents", "getBannerurl", "setBannerurl", "getVersion", "setVersion", "getGoogleproductid", "setGoogleproductid", "getAppleproductid", "setAppleproductid", "getScreenshots", "()Ljava/util/List;", "setScreenshots", "(Ljava/util/List;)V", "getPrice", "setPrice", "getInstore", "()Ljava/lang/Boolean;", "setInstore", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getSpotlight", "setSpotlight", "getSpotlight_order", "()Ljava/lang/Integer;", "setSpotlight_order", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCategory", "()Lcom/studiolaganne/lengendarylens/MTThemeCategory;", "setCategory", "(Lcom/studiolaganne/lengendarylens/MTThemeCategory;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Lcom/studiolaganne/lengendarylens/MTThemeCategory;)Lcom/studiolaganne/lengendarylens/MTTheme;", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTTheme {
    public static final int $stable = 8;
    private String appleproductid;
    private String bannerurl;
    private String catchphrase;
    private MTThemeCategory category;
    private String contents;
    private String description;
    private String googleproductid;
    private int id;
    private Boolean instore;
    private String price;
    private List<String> screenshots;
    private Boolean spotlight;
    private Integer spotlight_order;
    private String title;
    private int version;

    public MTTheme() {
        this(0, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, 32767, null);
    }

    public MTTheme(int i, String str, String str2, String str3, String str4, String str5, int i2, String googleproductid, String appleproductid, List<String> list, String str6, Boolean bool, Boolean bool2, Integer num, MTThemeCategory mTThemeCategory) {
        Intrinsics.checkNotNullParameter(googleproductid, "googleproductid");
        Intrinsics.checkNotNullParameter(appleproductid, "appleproductid");
        this.id = i;
        this.title = str;
        this.catchphrase = str2;
        this.description = str3;
        this.contents = str4;
        this.bannerurl = str5;
        this.version = i2;
        this.googleproductid = googleproductid;
        this.appleproductid = appleproductid;
        this.screenshots = list;
        this.price = str6;
        this.instore = bool;
        this.spotlight = bool2;
        this.spotlight_order = num;
        this.category = mTThemeCategory;
    }

    public /* synthetic */ MTTheme(int i, String str, String str2, String str3, String str4, String str5, int i2, String str6, String str7, List list, String str8, Boolean bool, Boolean bool2, Integer num, MTThemeCategory mTThemeCategory, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? -1 : i, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? "" : str2, (i3 & 8) != 0 ? "" : str3, (i3 & 16) != 0 ? "" : str4, (i3 & 32) != 0 ? "" : str5, (i3 & 64) != 0 ? 1 : i2, (i3 & 128) != 0 ? "" : str6, (i3 & 256) != 0 ? "" : str7, (i3 & 512) != 0 ? CollectionsKt.emptyList() : list, (i3 & 1024) == 0 ? str8 : "", (i3 & 2048) != 0 ? true : bool, (i3 & 4096) != 0 ? null : bool2, (i3 & 8192) != 0 ? null : num, (i3 & 16384) != 0 ? null : mTThemeCategory);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    public final List<String> component10() {
        return this.screenshots;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getPrice() {
        return this.price;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Boolean getInstore() {
        return this.instore;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Boolean getSpotlight() {
        return this.spotlight;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final Integer getSpotlight_order() {
        return this.spotlight_order;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final MTThemeCategory getCategory() {
        return this.category;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCatchphrase() {
        return this.catchphrase;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getContents() {
        return this.contents;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getBannerurl() {
        return this.bannerurl;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getGoogleproductid() {
        return this.googleproductid;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getAppleproductid() {
        return this.appleproductid;
    }

    public final MTTheme copy(int id, String title, String catchphrase, String description, String contents, String bannerurl, int version, String googleproductid, String appleproductid, List<String> screenshots, String price, Boolean instore, Boolean spotlight, Integer spotlight_order, MTThemeCategory category) {
        Intrinsics.checkNotNullParameter(googleproductid, "googleproductid");
        Intrinsics.checkNotNullParameter(appleproductid, "appleproductid");
        return new MTTheme(id, title, catchphrase, description, contents, bannerurl, version, googleproductid, appleproductid, screenshots, price, instore, spotlight, spotlight_order, category);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTTheme)) {
            return false;
        }
        MTTheme mTTheme = (MTTheme) other;
        return this.id == mTTheme.id && Intrinsics.areEqual(this.title, mTTheme.title) && Intrinsics.areEqual(this.catchphrase, mTTheme.catchphrase) && Intrinsics.areEqual(this.description, mTTheme.description) && Intrinsics.areEqual(this.contents, mTTheme.contents) && Intrinsics.areEqual(this.bannerurl, mTTheme.bannerurl) && this.version == mTTheme.version && Intrinsics.areEqual(this.googleproductid, mTTheme.googleproductid) && Intrinsics.areEqual(this.appleproductid, mTTheme.appleproductid) && Intrinsics.areEqual(this.screenshots, mTTheme.screenshots) && Intrinsics.areEqual(this.price, mTTheme.price) && Intrinsics.areEqual(this.instore, mTTheme.instore) && Intrinsics.areEqual(this.spotlight, mTTheme.spotlight) && Intrinsics.areEqual(this.spotlight_order, mTTheme.spotlight_order) && Intrinsics.areEqual(this.category, mTTheme.category);
    }

    public final String getAppleproductid() {
        return this.appleproductid;
    }

    public final String getBannerurl() {
        return this.bannerurl;
    }

    public final String getCatchphrase() {
        return this.catchphrase;
    }

    public final MTThemeCategory getCategory() {
        return this.category;
    }

    public final String getContents() {
        return this.contents;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getGoogleproductid() {
        return this.googleproductid;
    }

    public final int getId() {
        return this.id;
    }

    public final Boolean getInstore() {
        return this.instore;
    }

    public final String getPrice() {
        return this.price;
    }

    public final List<String> getScreenshots() {
        return this.screenshots;
    }

    public final Boolean getSpotlight() {
        return this.spotlight;
    }

    public final Integer getSpotlight_order() {
        return this.spotlight_order;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.id) * 31;
        String str = this.title;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.catchphrase;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.description;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.contents;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.bannerurl;
        int iHashCode6 = (((((((iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31) + Integer.hashCode(this.version)) * 31) + this.googleproductid.hashCode()) * 31) + this.appleproductid.hashCode()) * 31;
        List<String> list = this.screenshots;
        int iHashCode7 = (iHashCode6 + (list == null ? 0 : list.hashCode())) * 31;
        String str6 = this.price;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Boolean bool = this.instore;
        int iHashCode9 = (iHashCode8 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.spotlight;
        int iHashCode10 = (iHashCode9 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Integer num = this.spotlight_order;
        int iHashCode11 = (iHashCode10 + (num == null ? 0 : num.hashCode())) * 31;
        MTThemeCategory mTThemeCategory = this.category;
        return iHashCode11 + (mTThemeCategory != null ? mTThemeCategory.hashCode() : 0);
    }

    public final void setAppleproductid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appleproductid = str;
    }

    public final void setBannerurl(String str) {
        this.bannerurl = str;
    }

    public final void setCatchphrase(String str) {
        this.catchphrase = str;
    }

    public final void setCategory(MTThemeCategory mTThemeCategory) {
        this.category = mTThemeCategory;
    }

    public final void setContents(String str) {
        this.contents = str;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final void setGoogleproductid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.googleproductid = str;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setInstore(Boolean bool) {
        this.instore = bool;
    }

    public final void setPrice(String str) {
        this.price = str;
    }

    public final void setScreenshots(List<String> list) {
        this.screenshots = list;
    }

    public final void setSpotlight(Boolean bool) {
        this.spotlight = bool;
    }

    public final void setSpotlight_order(Integer num) {
        this.spotlight_order = num;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setVersion(int i) {
        this.version = i;
    }

    public String toString() {
        return "MTTheme(id=" + this.id + ", title=" + this.title + ", catchphrase=" + this.catchphrase + ", description=" + this.description + ", contents=" + this.contents + ", bannerurl=" + this.bannerurl + ", version=" + this.version + ", googleproductid=" + this.googleproductid + ", appleproductid=" + this.appleproductid + ", screenshots=" + this.screenshots + ", price=" + this.price + ", instore=" + this.instore + ", spotlight=" + this.spotlight + ", spotlight_order=" + this.spotlight_order + ", category=" + this.category + ")";
    }
}
