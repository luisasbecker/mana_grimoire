package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b3\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0092\u0001\u00104\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00105J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020\u0003HÖ\u0001J\t\u0010:\u001a\u00020;HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0017\u0010\u0011\"\u0004\b\u0018\u0010\u0013R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u001d\u0010\u0011\"\u0004\b\u001e\u0010\u0013R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0013R\u001e\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b#\u0010\u0011\"\u0004\b$\u0010\u0013R\u001e\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b%\u0010\u0011\"\u0004\b&\u0010\u0013R\u001e\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b'\u0010\u0011\"\u0004\b(\u0010\u0013¨\u0006<"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTLanguagesAndVersions;", "", "en", "", "fr", "de", "es", "it", "pt", "ru", "ja", "ko", "zht", "zhs", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getEn", "()Ljava/lang/Integer;", "setEn", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getFr", "setFr", "getDe", "setDe", "getEs", "setEs", "getIt", "setIt", "getPt", "setPt", "getRu", "setRu", "getJa", "setJa", "getKo", "setKo", "getZht", "setZht", "getZhs", "setZhs", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/studiolaganne/lengendarylens/MTLanguagesAndVersions;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTLanguagesAndVersions {
    public static final int $stable = 8;
    private Integer de;
    private Integer en;
    private Integer es;
    private Integer fr;
    private Integer it;
    private Integer ja;
    private Integer ko;
    private Integer pt;
    private Integer ru;
    private Integer zhs;
    private Integer zht;

    public MTLanguagesAndVersions() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public MTLanguagesAndVersions(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11) {
        this.en = num;
        this.fr = num2;
        this.de = num3;
        this.es = num4;
        this.it = num5;
        this.pt = num6;
        this.ru = num7;
        this.ja = num8;
        this.ko = num9;
        this.zht = num10;
        this.zhs = num11;
    }

    public /* synthetic */ MTLanguagesAndVersions(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4, (i & 16) != 0 ? null : num5, (i & 32) != 0 ? null : num6, (i & 64) != 0 ? null : num7, (i & 128) != 0 ? null : num8, (i & 256) != 0 ? null : num9, (i & 512) != 0 ? null : num10, (i & 1024) != 0 ? null : num11);
    }

    public static /* synthetic */ MTLanguagesAndVersions copy$default(MTLanguagesAndVersions mTLanguagesAndVersions, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, int i, Object obj) {
        if ((i & 1) != 0) {
            num = mTLanguagesAndVersions.en;
        }
        if ((i & 2) != 0) {
            num2 = mTLanguagesAndVersions.fr;
        }
        if ((i & 4) != 0) {
            num3 = mTLanguagesAndVersions.de;
        }
        if ((i & 8) != 0) {
            num4 = mTLanguagesAndVersions.es;
        }
        if ((i & 16) != 0) {
            num5 = mTLanguagesAndVersions.it;
        }
        if ((i & 32) != 0) {
            num6 = mTLanguagesAndVersions.pt;
        }
        if ((i & 64) != 0) {
            num7 = mTLanguagesAndVersions.ru;
        }
        if ((i & 128) != 0) {
            num8 = mTLanguagesAndVersions.ja;
        }
        if ((i & 256) != 0) {
            num9 = mTLanguagesAndVersions.ko;
        }
        if ((i & 512) != 0) {
            num10 = mTLanguagesAndVersions.zht;
        }
        if ((i & 1024) != 0) {
            num11 = mTLanguagesAndVersions.zhs;
        }
        Integer num12 = num10;
        Integer num13 = num11;
        Integer num14 = num8;
        Integer num15 = num9;
        Integer num16 = num6;
        Integer num17 = num7;
        Integer num18 = num5;
        Integer num19 = num3;
        return mTLanguagesAndVersions.copy(num, num2, num19, num4, num18, num16, num17, num14, num15, num12, num13);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getEn() {
        return this.en;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Integer getZht() {
        return this.zht;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Integer getZhs() {
        return this.zhs;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getFr() {
        return this.fr;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getDe() {
        return this.de;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getEs() {
        return this.es;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getIt() {
        return this.it;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Integer getPt() {
        return this.pt;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getRu() {
        return this.ru;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Integer getJa() {
        return this.ja;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Integer getKo() {
        return this.ko;
    }

    public final MTLanguagesAndVersions copy(Integer en, Integer fr, Integer de, Integer es, Integer it, Integer pt, Integer ru, Integer ja, Integer ko, Integer zht, Integer zhs) {
        return new MTLanguagesAndVersions(en, fr, de, es, it, pt, ru, ja, ko, zht, zhs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTLanguagesAndVersions)) {
            return false;
        }
        MTLanguagesAndVersions mTLanguagesAndVersions = (MTLanguagesAndVersions) other;
        return Intrinsics.areEqual(this.en, mTLanguagesAndVersions.en) && Intrinsics.areEqual(this.fr, mTLanguagesAndVersions.fr) && Intrinsics.areEqual(this.de, mTLanguagesAndVersions.de) && Intrinsics.areEqual(this.es, mTLanguagesAndVersions.es) && Intrinsics.areEqual(this.it, mTLanguagesAndVersions.it) && Intrinsics.areEqual(this.pt, mTLanguagesAndVersions.pt) && Intrinsics.areEqual(this.ru, mTLanguagesAndVersions.ru) && Intrinsics.areEqual(this.ja, mTLanguagesAndVersions.ja) && Intrinsics.areEqual(this.ko, mTLanguagesAndVersions.ko) && Intrinsics.areEqual(this.zht, mTLanguagesAndVersions.zht) && Intrinsics.areEqual(this.zhs, mTLanguagesAndVersions.zhs);
    }

    public final Integer getDe() {
        return this.de;
    }

    public final Integer getEn() {
        return this.en;
    }

    public final Integer getEs() {
        return this.es;
    }

    public final Integer getFr() {
        return this.fr;
    }

    public final Integer getIt() {
        return this.it;
    }

    public final Integer getJa() {
        return this.ja;
    }

    public final Integer getKo() {
        return this.ko;
    }

    public final Integer getPt() {
        return this.pt;
    }

    public final Integer getRu() {
        return this.ru;
    }

    public final Integer getZhs() {
        return this.zhs;
    }

    public final Integer getZht() {
        return this.zht;
    }

    public int hashCode() {
        Integer num = this.en;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.fr;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.de;
        int iHashCode3 = (iHashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.es;
        int iHashCode4 = (iHashCode3 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.it;
        int iHashCode5 = (iHashCode4 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.pt;
        int iHashCode6 = (iHashCode5 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Integer num7 = this.ru;
        int iHashCode7 = (iHashCode6 + (num7 == null ? 0 : num7.hashCode())) * 31;
        Integer num8 = this.ja;
        int iHashCode8 = (iHashCode7 + (num8 == null ? 0 : num8.hashCode())) * 31;
        Integer num9 = this.ko;
        int iHashCode9 = (iHashCode8 + (num9 == null ? 0 : num9.hashCode())) * 31;
        Integer num10 = this.zht;
        int iHashCode10 = (iHashCode9 + (num10 == null ? 0 : num10.hashCode())) * 31;
        Integer num11 = this.zhs;
        return iHashCode10 + (num11 != null ? num11.hashCode() : 0);
    }

    public final void setDe(Integer num) {
        this.de = num;
    }

    public final void setEn(Integer num) {
        this.en = num;
    }

    public final void setEs(Integer num) {
        this.es = num;
    }

    public final void setFr(Integer num) {
        this.fr = num;
    }

    public final void setIt(Integer num) {
        this.it = num;
    }

    public final void setJa(Integer num) {
        this.ja = num;
    }

    public final void setKo(Integer num) {
        this.ko = num;
    }

    public final void setPt(Integer num) {
        this.pt = num;
    }

    public final void setRu(Integer num) {
        this.ru = num;
    }

    public final void setZhs(Integer num) {
        this.zhs = num;
    }

    public final void setZht(Integer num) {
        this.zht = num;
    }

    public String toString() {
        return "MTLanguagesAndVersions(en=" + this.en + ", fr=" + this.fr + ", de=" + this.de + ", es=" + this.es + ", it=" + this.it + ", pt=" + this.pt + ", ru=" + this.ru + ", ja=" + this.ja + ", ko=" + this.ko + ", zht=" + this.zht + ", zhs=" + this.zhs + ")";
    }
}
