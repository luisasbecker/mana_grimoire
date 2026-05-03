package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FilterBottomSheetFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003JV\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\t\u0010)\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000fR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014¨\u0006*"}, d2 = {"Lcom/studiolaganne/lengendarylens/FilterDefinition;", "", "formatId", "", "formatName", "", "subformatId", "subformatName", "tagId", "tagName", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getFormatId", "()Ljava/lang/Integer;", "setFormatId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getFormatName", "()Ljava/lang/String;", "setFormatName", "(Ljava/lang/String;)V", "getSubformatId", "setSubformatId", "getSubformatName", "setSubformatName", "getTagId", "setTagId", "getTagName", "setTagName", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/studiolaganne/lengendarylens/FilterDefinition;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class FilterDefinition {
    public static final int $stable = 8;
    private Integer formatId;
    private String formatName;
    private Integer subformatId;
    private String subformatName;
    private Integer tagId;
    private String tagName;

    public FilterDefinition() {
        this(null, null, null, null, null, null, 63, null);
    }

    public FilterDefinition(Integer num, String str, Integer num2, String str2, Integer num3, String str3) {
        this.formatId = num;
        this.formatName = str;
        this.subformatId = num2;
        this.subformatName = str2;
        this.tagId = num3;
        this.tagName = str3;
    }

    public /* synthetic */ FilterDefinition(Integer num, String str, Integer num2, String str2, Integer num3, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : num3, (i & 32) != 0 ? null : str3);
    }

    public static /* synthetic */ FilterDefinition copy$default(FilterDefinition filterDefinition, Integer num, String str, Integer num2, String str2, Integer num3, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = filterDefinition.formatId;
        }
        if ((i & 2) != 0) {
            str = filterDefinition.formatName;
        }
        if ((i & 4) != 0) {
            num2 = filterDefinition.subformatId;
        }
        if ((i & 8) != 0) {
            str2 = filterDefinition.subformatName;
        }
        if ((i & 16) != 0) {
            num3 = filterDefinition.tagId;
        }
        if ((i & 32) != 0) {
            str3 = filterDefinition.tagName;
        }
        Integer num4 = num3;
        String str4 = str3;
        return filterDefinition.copy(num, str, num2, str2, num4, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getFormatId() {
        return this.formatId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFormatName() {
        return this.formatName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getSubformatId() {
        return this.subformatId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSubformatName() {
        return this.subformatName;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getTagId() {
        return this.tagId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getTagName() {
        return this.tagName;
    }

    public final FilterDefinition copy(Integer formatId, String formatName, Integer subformatId, String subformatName, Integer tagId, String tagName) {
        return new FilterDefinition(formatId, formatName, subformatId, subformatName, tagId, tagName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FilterDefinition)) {
            return false;
        }
        FilterDefinition filterDefinition = (FilterDefinition) other;
        return Intrinsics.areEqual(this.formatId, filterDefinition.formatId) && Intrinsics.areEqual(this.formatName, filterDefinition.formatName) && Intrinsics.areEqual(this.subformatId, filterDefinition.subformatId) && Intrinsics.areEqual(this.subformatName, filterDefinition.subformatName) && Intrinsics.areEqual(this.tagId, filterDefinition.tagId) && Intrinsics.areEqual(this.tagName, filterDefinition.tagName);
    }

    public final Integer getFormatId() {
        return this.formatId;
    }

    public final String getFormatName() {
        return this.formatName;
    }

    public final Integer getSubformatId() {
        return this.subformatId;
    }

    public final String getSubformatName() {
        return this.subformatName;
    }

    public final Integer getTagId() {
        return this.tagId;
    }

    public final String getTagName() {
        return this.tagName;
    }

    public int hashCode() {
        Integer num = this.formatId;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.formatName;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num2 = this.subformatId;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str2 = this.subformatName;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num3 = this.tagId;
        int iHashCode5 = (iHashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str3 = this.tagName;
        return iHashCode5 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void setFormatId(Integer num) {
        this.formatId = num;
    }

    public final void setFormatName(String str) {
        this.formatName = str;
    }

    public final void setSubformatId(Integer num) {
        this.subformatId = num;
    }

    public final void setSubformatName(String str) {
        this.subformatName = str;
    }

    public final void setTagId(Integer num) {
        this.tagId = num;
    }

    public final void setTagName(String str) {
        this.tagName = str;
    }

    public String toString() {
        return "FilterDefinition(formatId=" + this.formatId + ", formatName=" + this.formatName + ", subformatId=" + this.subformatId + ", subformatName=" + this.subformatName + ", tagId=" + this.tagId + ", tagName=" + this.tagName + ")";
    }
}
