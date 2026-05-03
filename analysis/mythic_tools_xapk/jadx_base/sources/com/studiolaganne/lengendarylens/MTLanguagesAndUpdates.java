package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b5\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0092\u0001\u00104\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00105J\u0013\u00106\u001a\u00020\u00032\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u000209HÖ\u0001J\t\u0010:\u001a\u00020;HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0017\u0010\u0011\"\u0004\b\u0018\u0010\u0013R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u001d\u0010\u0011\"\u0004\b\u001e\u0010\u0013R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0013R\u001e\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b#\u0010\u0011\"\u0004\b$\u0010\u0013R\u001e\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b%\u0010\u0011\"\u0004\b&\u0010\u0013R\u001e\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b'\u0010\u0011\"\u0004\b(\u0010\u0013¨\u0006<"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTLanguagesAndUpdates;", "", "en", "", "fr", "de", "es", "it", "pt", "ru", "ja", "ko", "zht", "zhs", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getEn", "()Ljava/lang/Boolean;", "setEn", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getFr", "setFr", "getDe", "setDe", "getEs", "setEs", "getIt", "setIt", "getPt", "setPt", "getRu", "setRu", "getJa", "setJa", "getKo", "setKo", "getZht", "setZht", "getZhs", "setZhs", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/studiolaganne/lengendarylens/MTLanguagesAndUpdates;", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTLanguagesAndUpdates {
    public static final int $stable = 8;
    private Boolean de;
    private Boolean en;
    private Boolean es;
    private Boolean fr;
    private Boolean it;
    private Boolean ja;
    private Boolean ko;
    private Boolean pt;
    private Boolean ru;
    private Boolean zhs;
    private Boolean zht;

    public MTLanguagesAndUpdates() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public MTLanguagesAndUpdates(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11) {
        this.en = bool;
        this.fr = bool2;
        this.de = bool3;
        this.es = bool4;
        this.it = bool5;
        this.pt = bool6;
        this.ru = bool7;
        this.ja = bool8;
        this.ko = bool9;
        this.zht = bool10;
        this.zhs = bool11;
    }

    public /* synthetic */ MTLanguagesAndUpdates(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : bool2, (i & 4) != 0 ? null : bool3, (i & 8) != 0 ? null : bool4, (i & 16) != 0 ? null : bool5, (i & 32) != 0 ? null : bool6, (i & 64) != 0 ? null : bool7, (i & 128) != 0 ? null : bool8, (i & 256) != 0 ? null : bool9, (i & 512) != 0 ? null : bool10, (i & 1024) != 0 ? null : bool11);
    }

    public static /* synthetic */ MTLanguagesAndUpdates copy$default(MTLanguagesAndUpdates mTLanguagesAndUpdates, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = mTLanguagesAndUpdates.en;
        }
        if ((i & 2) != 0) {
            bool2 = mTLanguagesAndUpdates.fr;
        }
        if ((i & 4) != 0) {
            bool3 = mTLanguagesAndUpdates.de;
        }
        if ((i & 8) != 0) {
            bool4 = mTLanguagesAndUpdates.es;
        }
        if ((i & 16) != 0) {
            bool5 = mTLanguagesAndUpdates.it;
        }
        if ((i & 32) != 0) {
            bool6 = mTLanguagesAndUpdates.pt;
        }
        if ((i & 64) != 0) {
            bool7 = mTLanguagesAndUpdates.ru;
        }
        if ((i & 128) != 0) {
            bool8 = mTLanguagesAndUpdates.ja;
        }
        if ((i & 256) != 0) {
            bool9 = mTLanguagesAndUpdates.ko;
        }
        if ((i & 512) != 0) {
            bool10 = mTLanguagesAndUpdates.zht;
        }
        if ((i & 1024) != 0) {
            bool11 = mTLanguagesAndUpdates.zhs;
        }
        Boolean bool12 = bool10;
        Boolean bool13 = bool11;
        Boolean bool14 = bool8;
        Boolean bool15 = bool9;
        Boolean bool16 = bool6;
        Boolean bool17 = bool7;
        Boolean bool18 = bool5;
        Boolean bool19 = bool3;
        return mTLanguagesAndUpdates.copy(bool, bool2, bool19, bool4, bool18, bool16, bool17, bool14, bool15, bool12, bool13);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Boolean getEn() {
        return this.en;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Boolean getZht() {
        return this.zht;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Boolean getZhs() {
        return this.zhs;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Boolean getFr() {
        return this.fr;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Boolean getDe() {
        return this.de;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Boolean getEs() {
        return this.es;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Boolean getIt() {
        return this.it;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Boolean getPt() {
        return this.pt;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Boolean getRu() {
        return this.ru;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Boolean getJa() {
        return this.ja;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Boolean getKo() {
        return this.ko;
    }

    public final MTLanguagesAndUpdates copy(Boolean en, Boolean fr, Boolean de, Boolean es, Boolean it, Boolean pt, Boolean ru, Boolean ja, Boolean ko, Boolean zht, Boolean zhs) {
        return new MTLanguagesAndUpdates(en, fr, de, es, it, pt, ru, ja, ko, zht, zhs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTLanguagesAndUpdates)) {
            return false;
        }
        MTLanguagesAndUpdates mTLanguagesAndUpdates = (MTLanguagesAndUpdates) other;
        return Intrinsics.areEqual(this.en, mTLanguagesAndUpdates.en) && Intrinsics.areEqual(this.fr, mTLanguagesAndUpdates.fr) && Intrinsics.areEqual(this.de, mTLanguagesAndUpdates.de) && Intrinsics.areEqual(this.es, mTLanguagesAndUpdates.es) && Intrinsics.areEqual(this.it, mTLanguagesAndUpdates.it) && Intrinsics.areEqual(this.pt, mTLanguagesAndUpdates.pt) && Intrinsics.areEqual(this.ru, mTLanguagesAndUpdates.ru) && Intrinsics.areEqual(this.ja, mTLanguagesAndUpdates.ja) && Intrinsics.areEqual(this.ko, mTLanguagesAndUpdates.ko) && Intrinsics.areEqual(this.zht, mTLanguagesAndUpdates.zht) && Intrinsics.areEqual(this.zhs, mTLanguagesAndUpdates.zhs);
    }

    public final Boolean getDe() {
        return this.de;
    }

    public final Boolean getEn() {
        return this.en;
    }

    public final Boolean getEs() {
        return this.es;
    }

    public final Boolean getFr() {
        return this.fr;
    }

    public final Boolean getIt() {
        return this.it;
    }

    public final Boolean getJa() {
        return this.ja;
    }

    public final Boolean getKo() {
        return this.ko;
    }

    public final Boolean getPt() {
        return this.pt;
    }

    public final Boolean getRu() {
        return this.ru;
    }

    public final Boolean getZhs() {
        return this.zhs;
    }

    public final Boolean getZht() {
        return this.zht;
    }

    public int hashCode() {
        Boolean bool = this.en;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Boolean bool2 = this.fr;
        int iHashCode2 = (iHashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.de;
        int iHashCode3 = (iHashCode2 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.es;
        int iHashCode4 = (iHashCode3 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Boolean bool5 = this.it;
        int iHashCode5 = (iHashCode4 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        Boolean bool6 = this.pt;
        int iHashCode6 = (iHashCode5 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
        Boolean bool7 = this.ru;
        int iHashCode7 = (iHashCode6 + (bool7 == null ? 0 : bool7.hashCode())) * 31;
        Boolean bool8 = this.ja;
        int iHashCode8 = (iHashCode7 + (bool8 == null ? 0 : bool8.hashCode())) * 31;
        Boolean bool9 = this.ko;
        int iHashCode9 = (iHashCode8 + (bool9 == null ? 0 : bool9.hashCode())) * 31;
        Boolean bool10 = this.zht;
        int iHashCode10 = (iHashCode9 + (bool10 == null ? 0 : bool10.hashCode())) * 31;
        Boolean bool11 = this.zhs;
        return iHashCode10 + (bool11 != null ? bool11.hashCode() : 0);
    }

    public final void setDe(Boolean bool) {
        this.de = bool;
    }

    public final void setEn(Boolean bool) {
        this.en = bool;
    }

    public final void setEs(Boolean bool) {
        this.es = bool;
    }

    public final void setFr(Boolean bool) {
        this.fr = bool;
    }

    public final void setIt(Boolean bool) {
        this.it = bool;
    }

    public final void setJa(Boolean bool) {
        this.ja = bool;
    }

    public final void setKo(Boolean bool) {
        this.ko = bool;
    }

    public final void setPt(Boolean bool) {
        this.pt = bool;
    }

    public final void setRu(Boolean bool) {
        this.ru = bool;
    }

    public final void setZhs(Boolean bool) {
        this.zhs = bool;
    }

    public final void setZht(Boolean bool) {
        this.zht = bool;
    }

    public String toString() {
        return "MTLanguagesAndUpdates(en=" + this.en + ", fr=" + this.fr + ", de=" + this.de + ", es=" + this.es + ", it=" + this.it + ", pt=" + this.pt + ", ru=" + this.ru + ", ja=" + this.ja + ", ko=" + this.ko + ", zht=" + this.zht + ", zhs=" + this.zhs + ")";
    }
}
