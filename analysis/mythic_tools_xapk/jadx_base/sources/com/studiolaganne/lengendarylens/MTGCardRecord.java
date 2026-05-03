package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.Constants;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DataStructs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b.\b\u0087\b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u000fHÆ\u0003J}\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u00109\u001a\u00020\u000f2\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020\u0005HÖ\u0001J\t\u0010<\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0013\"\u0004\b#\u0010\u0015R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0013\"\u0004\b%\u0010\u0015R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0013\"\u0004\b'\u0010\u0015R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0013\"\u0004\b)\u0010\u0015R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010*\"\u0004\b+\u0010,¨\u0006="}, d2 = {"Lcom/studiolaganne/lengendarylens/MTGCardRecord;", "", "oracle_id", "", OptionalModuleUtils.FACE, "", Constants.GP_IAP_TITLE, "type_line", "oracle_text", "lang", "keywords", "scryfallId", "mtCardId", "previewImageUrl", "isArtCropPreview", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getOracle_id", "()Ljava/lang/String;", "setOracle_id", "(Ljava/lang/String;)V", "getFace", "()I", "setFace", "(I)V", "getTitle", "setTitle", "getType_line", "setType_line", "getOracle_text", "setOracle_text", "getLang", "setLang", "getKeywords", "setKeywords", "getScryfallId", "setScryfallId", "getMtCardId", "setMtCardId", "getPreviewImageUrl", "setPreviewImageUrl", "()Z", "setArtCropPreview", "(Z)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTGCardRecord {
    public static final int $stable = 8;
    private int face;
    private boolean isArtCropPreview;
    private String keywords;
    private String lang;
    private String mtCardId;
    private String oracle_id;
    private String oracle_text;
    private String previewImageUrl;
    private String scryfallId;
    private String title;
    private String type_line;

    public MTGCardRecord(String oracle_id, int i, String title, String str, String str2, String lang, String str3, String scryfallId, String mtCardId, String previewImageUrl, boolean z) {
        Intrinsics.checkNotNullParameter(oracle_id, "oracle_id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(lang, "lang");
        Intrinsics.checkNotNullParameter(scryfallId, "scryfallId");
        Intrinsics.checkNotNullParameter(mtCardId, "mtCardId");
        Intrinsics.checkNotNullParameter(previewImageUrl, "previewImageUrl");
        this.oracle_id = oracle_id;
        this.face = i;
        this.title = title;
        this.type_line = str;
        this.oracle_text = str2;
        this.lang = lang;
        this.keywords = str3;
        this.scryfallId = scryfallId;
        this.mtCardId = mtCardId;
        this.previewImageUrl = previewImageUrl;
        this.isArtCropPreview = z;
    }

    public /* synthetic */ MTGCardRecord(String str, int i, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, str2, str3, str4, (i2 & 32) != 0 ? "en" : str5, str6, (i2 & 128) != 0 ? "" : str7, (i2 & 256) != 0 ? "" : str8, (i2 & 512) != 0 ? "" : str9, (i2 & 1024) != 0 ? true : z);
    }

    public static /* synthetic */ MTGCardRecord copy$default(MTGCardRecord mTGCardRecord, String str, int i, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = mTGCardRecord.oracle_id;
        }
        if ((i2 & 2) != 0) {
            i = mTGCardRecord.face;
        }
        if ((i2 & 4) != 0) {
            str2 = mTGCardRecord.title;
        }
        if ((i2 & 8) != 0) {
            str3 = mTGCardRecord.type_line;
        }
        if ((i2 & 16) != 0) {
            str4 = mTGCardRecord.oracle_text;
        }
        if ((i2 & 32) != 0) {
            str5 = mTGCardRecord.lang;
        }
        if ((i2 & 64) != 0) {
            str6 = mTGCardRecord.keywords;
        }
        if ((i2 & 128) != 0) {
            str7 = mTGCardRecord.scryfallId;
        }
        if ((i2 & 256) != 0) {
            str8 = mTGCardRecord.mtCardId;
        }
        if ((i2 & 512) != 0) {
            str9 = mTGCardRecord.previewImageUrl;
        }
        if ((i2 & 1024) != 0) {
            z = mTGCardRecord.isArtCropPreview;
        }
        String str10 = str9;
        boolean z2 = z;
        String str11 = str7;
        String str12 = str8;
        String str13 = str5;
        String str14 = str6;
        String str15 = str4;
        String str16 = str2;
        return mTGCardRecord.copy(str, i, str16, str3, str15, str13, str14, str11, str12, str10, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getOracle_id() {
        return this.oracle_id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getPreviewImageUrl() {
        return this.previewImageUrl;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getIsArtCropPreview() {
        return this.isArtCropPreview;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getFace() {
        return this.face;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getType_line() {
        return this.type_line;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getOracle_text() {
        return this.oracle_text;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getLang() {
        return this.lang;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getKeywords() {
        return this.keywords;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getScryfallId() {
        return this.scryfallId;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getMtCardId() {
        return this.mtCardId;
    }

    public final MTGCardRecord copy(String oracle_id, int face, String title, String type_line, String oracle_text, String lang, String keywords, String scryfallId, String mtCardId, String previewImageUrl, boolean isArtCropPreview) {
        Intrinsics.checkNotNullParameter(oracle_id, "oracle_id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(lang, "lang");
        Intrinsics.checkNotNullParameter(scryfallId, "scryfallId");
        Intrinsics.checkNotNullParameter(mtCardId, "mtCardId");
        Intrinsics.checkNotNullParameter(previewImageUrl, "previewImageUrl");
        return new MTGCardRecord(oracle_id, face, title, type_line, oracle_text, lang, keywords, scryfallId, mtCardId, previewImageUrl, isArtCropPreview);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTGCardRecord)) {
            return false;
        }
        MTGCardRecord mTGCardRecord = (MTGCardRecord) other;
        return Intrinsics.areEqual(this.oracle_id, mTGCardRecord.oracle_id) && this.face == mTGCardRecord.face && Intrinsics.areEqual(this.title, mTGCardRecord.title) && Intrinsics.areEqual(this.type_line, mTGCardRecord.type_line) && Intrinsics.areEqual(this.oracle_text, mTGCardRecord.oracle_text) && Intrinsics.areEqual(this.lang, mTGCardRecord.lang) && Intrinsics.areEqual(this.keywords, mTGCardRecord.keywords) && Intrinsics.areEqual(this.scryfallId, mTGCardRecord.scryfallId) && Intrinsics.areEqual(this.mtCardId, mTGCardRecord.mtCardId) && Intrinsics.areEqual(this.previewImageUrl, mTGCardRecord.previewImageUrl) && this.isArtCropPreview == mTGCardRecord.isArtCropPreview;
    }

    public final int getFace() {
        return this.face;
    }

    public final String getKeywords() {
        return this.keywords;
    }

    public final String getLang() {
        return this.lang;
    }

    public final String getMtCardId() {
        return this.mtCardId;
    }

    public final String getOracle_id() {
        return this.oracle_id;
    }

    public final String getOracle_text() {
        return this.oracle_text;
    }

    public final String getPreviewImageUrl() {
        return this.previewImageUrl;
    }

    public final String getScryfallId() {
        return this.scryfallId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getType_line() {
        return this.type_line;
    }

    public int hashCode() {
        int iHashCode = ((((this.oracle_id.hashCode() * 31) + Integer.hashCode(this.face)) * 31) + this.title.hashCode()) * 31;
        String str = this.type_line;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.oracle_text;
        int iHashCode3 = (((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.lang.hashCode()) * 31;
        String str3 = this.keywords;
        return ((((((((iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.scryfallId.hashCode()) * 31) + this.mtCardId.hashCode()) * 31) + this.previewImageUrl.hashCode()) * 31) + Boolean.hashCode(this.isArtCropPreview);
    }

    public final boolean isArtCropPreview() {
        return this.isArtCropPreview;
    }

    public final void setArtCropPreview(boolean z) {
        this.isArtCropPreview = z;
    }

    public final void setFace(int i) {
        this.face = i;
    }

    public final void setKeywords(String str) {
        this.keywords = str;
    }

    public final void setLang(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lang = str;
    }

    public final void setMtCardId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mtCardId = str;
    }

    public final void setOracle_id(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.oracle_id = str;
    }

    public final void setOracle_text(String str) {
        this.oracle_text = str;
    }

    public final void setPreviewImageUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.previewImageUrl = str;
    }

    public final void setScryfallId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.scryfallId = str;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final void setType_line(String str) {
        this.type_line = str;
    }

    public String toString() {
        return "MTGCardRecord(oracle_id=" + this.oracle_id + ", face=" + this.face + ", title=" + this.title + ", type_line=" + this.type_line + ", oracle_text=" + this.oracle_text + ", lang=" + this.lang + ", keywords=" + this.keywords + ", scryfallId=" + this.scryfallId + ", mtCardId=" + this.mtCardId + ", previewImageUrl=" + this.previewImageUrl + ", isArtCropPreview=" + this.isArtCropPreview + ")";
    }
}
