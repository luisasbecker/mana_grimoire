package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\"\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u001e\u001a\u00020\u0003J\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003JQ\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010(\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000e\"\u0004\b\u001b\u0010\u0010R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000e\"\u0004\b\u001d\u0010\u0010¨\u0006-"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardTag;", "", "tagName", "", "descriptionEn", "descriptionFr", "parentTag", "isRoot", "", "createdAt", "updatedAt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "getTagName", "()Ljava/lang/String;", "setTagName", "(Ljava/lang/String;)V", "getDescriptionEn", "setDescriptionEn", "getDescriptionFr", "setDescriptionFr", "getParentTag", "setParentTag", "()Z", "setRoot", "(Z)V", "getCreatedAt", "setCreatedAt", "getUpdatedAt", "setUpdatedAt", "getRootTag", "getSubTag", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCardTag {
    public static final int $stable = 8;
    private String createdAt;
    private String descriptionEn;
    private String descriptionFr;
    private boolean isRoot;
    private String parentTag;
    private String tagName;
    private String updatedAt;

    public MTCardTag() {
        this(null, null, null, null, false, null, null, 127, null);
    }

    public MTCardTag(String tagName, String descriptionEn, String descriptionFr, String str, boolean z, String createdAt, String updatedAt) {
        Intrinsics.checkNotNullParameter(tagName, "tagName");
        Intrinsics.checkNotNullParameter(descriptionEn, "descriptionEn");
        Intrinsics.checkNotNullParameter(descriptionFr, "descriptionFr");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(updatedAt, "updatedAt");
        this.tagName = tagName;
        this.descriptionEn = descriptionEn;
        this.descriptionFr = descriptionFr;
        this.parentTag = str;
        this.isRoot = z;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public /* synthetic */ MTCardTag(String str, String str2, String str3, String str4, boolean z, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? false : z, (i & 32) != 0 ? "" : str5, (i & 64) != 0 ? "" : str6);
    }

    public static /* synthetic */ MTCardTag copy$default(MTCardTag mTCardTag, String str, String str2, String str3, String str4, boolean z, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mTCardTag.tagName;
        }
        if ((i & 2) != 0) {
            str2 = mTCardTag.descriptionEn;
        }
        if ((i & 4) != 0) {
            str3 = mTCardTag.descriptionFr;
        }
        if ((i & 8) != 0) {
            str4 = mTCardTag.parentTag;
        }
        if ((i & 16) != 0) {
            z = mTCardTag.isRoot;
        }
        if ((i & 32) != 0) {
            str5 = mTCardTag.createdAt;
        }
        if ((i & 64) != 0) {
            str6 = mTCardTag.updatedAt;
        }
        String str7 = str5;
        String str8 = str6;
        boolean z2 = z;
        String str9 = str3;
        return mTCardTag.copy(str, str2, str9, str4, z2, str7, str8);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTagName() {
        return this.tagName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDescriptionEn() {
        return this.descriptionEn;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDescriptionFr() {
        return this.descriptionFr;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getParentTag() {
        return this.parentTag;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsRoot() {
        return this.isRoot;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    public final MTCardTag copy(String tagName, String descriptionEn, String descriptionFr, String parentTag, boolean isRoot, String createdAt, String updatedAt) {
        Intrinsics.checkNotNullParameter(tagName, "tagName");
        Intrinsics.checkNotNullParameter(descriptionEn, "descriptionEn");
        Intrinsics.checkNotNullParameter(descriptionFr, "descriptionFr");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(updatedAt, "updatedAt");
        return new MTCardTag(tagName, descriptionEn, descriptionFr, parentTag, isRoot, createdAt, updatedAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCardTag)) {
            return false;
        }
        MTCardTag mTCardTag = (MTCardTag) other;
        return Intrinsics.areEqual(this.tagName, mTCardTag.tagName) && Intrinsics.areEqual(this.descriptionEn, mTCardTag.descriptionEn) && Intrinsics.areEqual(this.descriptionFr, mTCardTag.descriptionFr) && Intrinsics.areEqual(this.parentTag, mTCardTag.parentTag) && this.isRoot == mTCardTag.isRoot && Intrinsics.areEqual(this.createdAt, mTCardTag.createdAt) && Intrinsics.areEqual(this.updatedAt, mTCardTag.updatedAt);
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

    public final String getParentTag() {
        return this.parentTag;
    }

    public final String getRootTag() {
        boolean zContains$default = StringsKt.contains$default((CharSequence) this.tagName, FilenameUtils.EXTENSION_SEPARATOR, false, 2, (Object) null);
        String str = this.tagName;
        return zContains$default ? StringsKt.substringBefore$default(str, FilenameUtils.EXTENSION_SEPARATOR, (String) null, 2, (Object) null) : str;
    }

    public final String getSubTag() {
        if (StringsKt.contains$default((CharSequence) this.tagName, FilenameUtils.EXTENSION_SEPARATOR, false, 2, (Object) null)) {
            return StringsKt.substringAfter$default(this.tagName, FilenameUtils.EXTENSION_SEPARATOR, (String) null, 2, (Object) null);
        }
        return null;
    }

    public final String getTagName() {
        return this.tagName;
    }

    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    public int hashCode() {
        int iHashCode = ((((this.tagName.hashCode() * 31) + this.descriptionEn.hashCode()) * 31) + this.descriptionFr.hashCode()) * 31;
        String str = this.parentTag;
        return ((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.isRoot)) * 31) + this.createdAt.hashCode()) * 31) + this.updatedAt.hashCode();
    }

    public final boolean isRoot() {
        return this.isRoot;
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

    public final void setParentTag(String str) {
        this.parentTag = str;
    }

    public final void setRoot(boolean z) {
        this.isRoot = z;
    }

    public final void setTagName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tagName = str;
    }

    public final void setUpdatedAt(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.updatedAt = str;
    }

    public String toString() {
        return "MTCardTag(tagName=" + this.tagName + ", descriptionEn=" + this.descriptionEn + ", descriptionFr=" + this.descriptionFr + ", parentTag=" + this.parentTag + ", isRoot=" + this.isRoot + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ")";
    }
}
