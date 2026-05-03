package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B]\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J_\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u00062"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTDeckTheme;", "", "themeId", "", "themeName", "themeNameFr", "descriptionEn", "descriptionFr", "createdAt", "updatedAt", "tags", "", "Lcom/studiolaganne/lengendarylens/MTThemeTag;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getThemeId", "()Ljava/lang/String;", "setThemeId", "(Ljava/lang/String;)V", "getThemeName", "setThemeName", "getThemeNameFr", "setThemeNameFr", "getDescriptionEn", "setDescriptionEn", "getDescriptionFr", "setDescriptionFr", "getCreatedAt", "setCreatedAt", "getUpdatedAt", "setUpdatedAt", "getTags", "()Ljava/util/List;", "setTags", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTDeckTheme {
    public static final int $stable = 8;
    private String createdAt;
    private String descriptionEn;
    private String descriptionFr;
    private List<MTThemeTag> tags;
    private String themeId;
    private String themeName;
    private String themeNameFr;
    private String updatedAt;

    public MTDeckTheme() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public MTDeckTheme(String themeId, String themeName, String themeNameFr, String descriptionEn, String descriptionFr, String createdAt, String updatedAt, List<MTThemeTag> tags) {
        Intrinsics.checkNotNullParameter(themeId, "themeId");
        Intrinsics.checkNotNullParameter(themeName, "themeName");
        Intrinsics.checkNotNullParameter(themeNameFr, "themeNameFr");
        Intrinsics.checkNotNullParameter(descriptionEn, "descriptionEn");
        Intrinsics.checkNotNullParameter(descriptionFr, "descriptionFr");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(updatedAt, "updatedAt");
        Intrinsics.checkNotNullParameter(tags, "tags");
        this.themeId = themeId;
        this.themeName = themeName;
        this.themeNameFr = themeNameFr;
        this.descriptionEn = descriptionEn;
        this.descriptionFr = descriptionFr;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.tags = tags;
    }

    public /* synthetic */ MTDeckTheme(String str, String str2, String str3, String str4, String str5, String str6, String str7, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7, (i & 128) != 0 ? CollectionsKt.emptyList() : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTDeckTheme copy$default(MTDeckTheme mTDeckTheme, String str, String str2, String str3, String str4, String str5, String str6, String str7, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTDeckTheme.themeId;
        }
        if ((i & 2) != 0) {
            str2 = mTDeckTheme.themeName;
        }
        if ((i & 4) != 0) {
            str3 = mTDeckTheme.themeNameFr;
        }
        if ((i & 8) != 0) {
            str4 = mTDeckTheme.descriptionEn;
        }
        if ((i & 16) != 0) {
            str5 = mTDeckTheme.descriptionFr;
        }
        if ((i & 32) != 0) {
            str6 = mTDeckTheme.createdAt;
        }
        if ((i & 64) != 0) {
            str7 = mTDeckTheme.updatedAt;
        }
        if ((i & 128) != 0) {
            list = mTDeckTheme.tags;
        }
        String str8 = str7;
        List list2 = list;
        String str9 = str5;
        String str10 = str6;
        return mTDeckTheme.copy(str, str2, str3, str4, str9, str10, str8, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getThemeId() {
        return this.themeId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getThemeName() {
        return this.themeName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getThemeNameFr() {
        return this.themeNameFr;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDescriptionEn() {
        return this.descriptionEn;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDescriptionFr() {
        return this.descriptionFr;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    public final List<MTThemeTag> component8() {
        return this.tags;
    }

    public final MTDeckTheme copy(String themeId, String themeName, String themeNameFr, String descriptionEn, String descriptionFr, String createdAt, String updatedAt, List<MTThemeTag> tags) {
        Intrinsics.checkNotNullParameter(themeId, "themeId");
        Intrinsics.checkNotNullParameter(themeName, "themeName");
        Intrinsics.checkNotNullParameter(themeNameFr, "themeNameFr");
        Intrinsics.checkNotNullParameter(descriptionEn, "descriptionEn");
        Intrinsics.checkNotNullParameter(descriptionFr, "descriptionFr");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(updatedAt, "updatedAt");
        Intrinsics.checkNotNullParameter(tags, "tags");
        return new MTDeckTheme(themeId, themeName, themeNameFr, descriptionEn, descriptionFr, createdAt, updatedAt, tags);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTDeckTheme)) {
            return false;
        }
        MTDeckTheme mTDeckTheme = (MTDeckTheme) other;
        return Intrinsics.areEqual(this.themeId, mTDeckTheme.themeId) && Intrinsics.areEqual(this.themeName, mTDeckTheme.themeName) && Intrinsics.areEqual(this.themeNameFr, mTDeckTheme.themeNameFr) && Intrinsics.areEqual(this.descriptionEn, mTDeckTheme.descriptionEn) && Intrinsics.areEqual(this.descriptionFr, mTDeckTheme.descriptionFr) && Intrinsics.areEqual(this.createdAt, mTDeckTheme.createdAt) && Intrinsics.areEqual(this.updatedAt, mTDeckTheme.updatedAt) && Intrinsics.areEqual(this.tags, mTDeckTheme.tags);
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final String getDescriptionEn() {
        return this.descriptionEn;
    }

    public final String getDescriptionFr() {
        return this.descriptionFr;
    }

    public final List<MTThemeTag> getTags() {
        return this.tags;
    }

    public final String getThemeId() {
        return this.themeId;
    }

    public final String getThemeName() {
        return this.themeName;
    }

    public final String getThemeNameFr() {
        return this.themeNameFr;
    }

    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    public int hashCode() {
        return (((((((((((((this.themeId.hashCode() * 31) + this.themeName.hashCode()) * 31) + this.themeNameFr.hashCode()) * 31) + this.descriptionEn.hashCode()) * 31) + this.descriptionFr.hashCode()) * 31) + this.createdAt.hashCode()) * 31) + this.updatedAt.hashCode()) * 31) + this.tags.hashCode();
    }

    public final void setCreatedAt(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.createdAt = str;
    }

    public final void setDescriptionEn(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.descriptionEn = str;
    }

    public final void setDescriptionFr(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.descriptionFr = str;
    }

    public final void setTags(List<MTThemeTag> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.tags = list;
    }

    public final void setThemeId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.themeId = str;
    }

    public final void setThemeName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.themeName = str;
    }

    public final void setThemeNameFr(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.themeNameFr = str;
    }

    public final void setUpdatedAt(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.updatedAt = str;
    }

    public String toString() {
        return "MTDeckTheme(themeId=" + this.themeId + ", themeName=" + this.themeName + ", themeNameFr=" + this.themeNameFr + ", descriptionEn=" + this.descriptionEn + ", descriptionFr=" + this.descriptionFr + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", tags=" + this.tags + ")";
    }
}
