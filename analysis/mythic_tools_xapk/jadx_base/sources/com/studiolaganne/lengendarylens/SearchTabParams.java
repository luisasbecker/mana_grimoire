package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SearchTabManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0019\u001a\u00020\u001aJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\"\u001a\u00020\u001a2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000e¨\u0006'"}, d2 = {"Lcom/studiolaganne/lengendarylens/SearchTabParams;", "", "scryfall", "", "name", "similarTo", "similarToName", "similarMode", "fillGap", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getScryfall", "()Ljava/lang/String;", "setScryfall", "(Ljava/lang/String;)V", "getName", "setName", "getSimilarTo", "setSimilarTo", "getSimilarToName", "setSimilarToName", "getSimilarMode", "setSimilarMode", "getFillGap", "setFillGap", "isEmpty", "", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SearchTabParams {
    public static final int $stable = 8;
    private String fillGap;
    private String name;
    private String scryfall;
    private String similarMode;
    private String similarTo;
    private String similarToName;

    public SearchTabParams() {
        this(null, null, null, null, null, null, 63, null);
    }

    public SearchTabParams(String str, String str2, String str3, String str4, String str5, String str6) {
        this.scryfall = str;
        this.name = str2;
        this.similarTo = str3;
        this.similarToName = str4;
        this.similarMode = str5;
        this.fillGap = str6;
    }

    public /* synthetic */ SearchTabParams(String str, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6);
    }

    public static /* synthetic */ SearchTabParams copy$default(SearchTabParams searchTabParams, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = searchTabParams.scryfall;
        }
        if ((i & 2) != 0) {
            str2 = searchTabParams.name;
        }
        if ((i & 4) != 0) {
            str3 = searchTabParams.similarTo;
        }
        if ((i & 8) != 0) {
            str4 = searchTabParams.similarToName;
        }
        if ((i & 16) != 0) {
            str5 = searchTabParams.similarMode;
        }
        if ((i & 32) != 0) {
            str6 = searchTabParams.fillGap;
        }
        String str7 = str5;
        String str8 = str6;
        return searchTabParams.copy(str, str2, str3, str4, str7, str8);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getScryfall() {
        return this.scryfall;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSimilarTo() {
        return this.similarTo;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSimilarToName() {
        return this.similarToName;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSimilarMode() {
        return this.similarMode;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getFillGap() {
        return this.fillGap;
    }

    public final SearchTabParams copy(String scryfall, String name, String similarTo, String similarToName, String similarMode, String fillGap) {
        return new SearchTabParams(scryfall, name, similarTo, similarToName, similarMode, fillGap);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchTabParams)) {
            return false;
        }
        SearchTabParams searchTabParams = (SearchTabParams) other;
        return Intrinsics.areEqual(this.scryfall, searchTabParams.scryfall) && Intrinsics.areEqual(this.name, searchTabParams.name) && Intrinsics.areEqual(this.similarTo, searchTabParams.similarTo) && Intrinsics.areEqual(this.similarToName, searchTabParams.similarToName) && Intrinsics.areEqual(this.similarMode, searchTabParams.similarMode) && Intrinsics.areEqual(this.fillGap, searchTabParams.fillGap);
    }

    public final String getFillGap() {
        return this.fillGap;
    }

    public final String getName() {
        return this.name;
    }

    public final String getScryfall() {
        return this.scryfall;
    }

    public final String getSimilarMode() {
        return this.similarMode;
    }

    public final String getSimilarTo() {
        return this.similarTo;
    }

    public final String getSimilarToName() {
        return this.similarToName;
    }

    public int hashCode() {
        String str = this.scryfall;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.similarTo;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.similarToName;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.similarMode;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.fillGap;
        return iHashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    public final boolean isEmpty() {
        String str = this.scryfall;
        if (str != null && !StringsKt.isBlank(str)) {
            return false;
        }
        String str2 = this.name;
        if (str2 != null && !StringsKt.isBlank(str2)) {
            return false;
        }
        String str3 = this.similarTo;
        if (str3 != null && !StringsKt.isBlank(str3)) {
            return false;
        }
        String str4 = this.fillGap;
        return str4 == null || StringsKt.isBlank(str4);
    }

    public final void setFillGap(String str) {
        this.fillGap = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setScryfall(String str) {
        this.scryfall = str;
    }

    public final void setSimilarMode(String str) {
        this.similarMode = str;
    }

    public final void setSimilarTo(String str) {
        this.similarTo = str;
    }

    public final void setSimilarToName(String str) {
        this.similarToName = str;
    }

    public String toString() {
        return "SearchTabParams(scryfall=" + this.scryfall + ", name=" + this.name + ", similarTo=" + this.similarTo + ", similarToName=" + this.similarToName + ", similarMode=" + this.similarMode + ", fillGap=" + this.fillGap + ")";
    }
}
