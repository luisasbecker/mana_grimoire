package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\bC\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bë\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010¢\u0006\u0004\b\u0017\u0010\u0018J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\u0011\u0010M\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010HÆ\u0003J\u0011\u0010N\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010HÆ\u0003J\u0011\u0010O\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010HÆ\u0003J\u0011\u0010P\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010HÆ\u0003J\u0011\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010HÆ\u0003J\u0011\u0010R\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010HÆ\u0003Jí\u0001\u0010S\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010HÆ\u0001J\u0013\u0010T\u001a\u00020U2\b\u0010V\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010W\u001a\u00020\u0003HÖ\u0001J\t\u0010X\u001a\u00020YHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001a\"\u0004\b$\u0010\u001cR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001a\"\u0004\b&\u0010\u001cR\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001a\"\u0004\b(\u0010\u001cR\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001a\"\u0004\b*\u0010\u001cR\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001a\"\u0004\b,\u0010\u001cR\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001a\"\u0004\b.\u0010\u001cR\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001a\"\u0004\b0\u0010\u001cR\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001a\"\u0004\b2\u0010\u001cR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00104\"\u0004\b8\u00106R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u00104\"\u0004\b:\u00106R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u00104\"\u0004\b<\u00106R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00104\"\u0004\b>\u00106R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u00104\"\u0004\b@\u00106¨\u0006Z"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTBracketMetrics;", "", "totalCards", "", "staxCount", "tutorCount", "fastManaCount", "manaRockCount", "altWinconCount", "extraTurnCount", "gameChangerCount", "counterspellCount", "twoCardComboCount", "massLandDenialCount", "universalTutorCount", "gameChangerCards", "", "Lcom/studiolaganne/lengendarylens/MTBracketMetricsCard;", "fastManaCards", "extraTurnCards", "massLandDenialCards", "universalTutorCards", "twoCardComboCards", "<init>", "(IIIIIIIIIIIILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getTotalCards", "()I", "setTotalCards", "(I)V", "getStaxCount", "setStaxCount", "getTutorCount", "setTutorCount", "getFastManaCount", "setFastManaCount", "getManaRockCount", "setManaRockCount", "getAltWinconCount", "setAltWinconCount", "getExtraTurnCount", "setExtraTurnCount", "getGameChangerCount", "setGameChangerCount", "getCounterspellCount", "setCounterspellCount", "getTwoCardComboCount", "setTwoCardComboCount", "getMassLandDenialCount", "setMassLandDenialCount", "getUniversalTutorCount", "setUniversalTutorCount", "getGameChangerCards", "()Ljava/util/List;", "setGameChangerCards", "(Ljava/util/List;)V", "getFastManaCards", "setFastManaCards", "getExtraTurnCards", "setExtraTurnCards", "getMassLandDenialCards", "setMassLandDenialCards", "getUniversalTutorCards", "setUniversalTutorCards", "getTwoCardComboCards", "setTwoCardComboCards", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTBracketMetrics {
    public static final int $stable = 8;
    private int altWinconCount;
    private int counterspellCount;
    private List<MTBracketMetricsCard> extraTurnCards;
    private int extraTurnCount;
    private List<MTBracketMetricsCard> fastManaCards;
    private int fastManaCount;
    private List<MTBracketMetricsCard> gameChangerCards;
    private int gameChangerCount;
    private int manaRockCount;
    private List<MTBracketMetricsCard> massLandDenialCards;
    private int massLandDenialCount;
    private int staxCount;
    private int totalCards;
    private int tutorCount;
    private List<MTBracketMetricsCard> twoCardComboCards;
    private int twoCardComboCount;
    private List<MTBracketMetricsCard> universalTutorCards;
    private int universalTutorCount;

    public MTBracketMetrics() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null, null, 262143, null);
    }

    public MTBracketMetrics(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, List<MTBracketMetricsCard> list, List<MTBracketMetricsCard> list2, List<MTBracketMetricsCard> list3, List<MTBracketMetricsCard> list4, List<MTBracketMetricsCard> list5, List<MTBracketMetricsCard> list6) {
        this.totalCards = i;
        this.staxCount = i2;
        this.tutorCount = i3;
        this.fastManaCount = i4;
        this.manaRockCount = i5;
        this.altWinconCount = i6;
        this.extraTurnCount = i7;
        this.gameChangerCount = i8;
        this.counterspellCount = i9;
        this.twoCardComboCount = i10;
        this.massLandDenialCount = i11;
        this.universalTutorCount = i12;
        this.gameChangerCards = list;
        this.fastManaCards = list2;
        this.extraTurnCards = list3;
        this.massLandDenialCards = list4;
        this.universalTutorCards = list5;
        this.twoCardComboCards = list6;
    }

    public /* synthetic */ MTBracketMetrics(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, List list, List list2, List list3, List list4, List list5, List list6, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? 0 : i, (i13 & 2) != 0 ? 0 : i2, (i13 & 4) != 0 ? 0 : i3, (i13 & 8) != 0 ? 0 : i4, (i13 & 16) != 0 ? 0 : i5, (i13 & 32) != 0 ? 0 : i6, (i13 & 64) != 0 ? 0 : i7, (i13 & 128) != 0 ? 0 : i8, (i13 & 256) != 0 ? 0 : i9, (i13 & 512) != 0 ? 0 : i10, (i13 & 1024) != 0 ? 0 : i11, (i13 & 2048) == 0 ? i12 : 0, (i13 & 4096) != 0 ? null : list, (i13 & 8192) != 0 ? null : list2, (i13 & 16384) != 0 ? null : list3, (i13 & 32768) != 0 ? null : list4, (i13 & 65536) != 0 ? null : list5, (i13 & 131072) != 0 ? null : list6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MTBracketMetrics copy$default(MTBracketMetrics mTBracketMetrics, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, List list, List list2, List list3, List list4, List list5, List list6, int i13, Object obj) {
        List list7;
        List list8;
        int i14 = (i13 & 1) != 0 ? mTBracketMetrics.totalCards : i;
        int i15 = (i13 & 2) != 0 ? mTBracketMetrics.staxCount : i2;
        int i16 = (i13 & 4) != 0 ? mTBracketMetrics.tutorCount : i3;
        int i17 = (i13 & 8) != 0 ? mTBracketMetrics.fastManaCount : i4;
        int i18 = (i13 & 16) != 0 ? mTBracketMetrics.manaRockCount : i5;
        int i19 = (i13 & 32) != 0 ? mTBracketMetrics.altWinconCount : i6;
        int i20 = (i13 & 64) != 0 ? mTBracketMetrics.extraTurnCount : i7;
        int i21 = (i13 & 128) != 0 ? mTBracketMetrics.gameChangerCount : i8;
        int i22 = (i13 & 256) != 0 ? mTBracketMetrics.counterspellCount : i9;
        int i23 = (i13 & 512) != 0 ? mTBracketMetrics.twoCardComboCount : i10;
        int i24 = (i13 & 1024) != 0 ? mTBracketMetrics.massLandDenialCount : i11;
        int i25 = (i13 & 2048) != 0 ? mTBracketMetrics.universalTutorCount : i12;
        List list9 = (i13 & 4096) != 0 ? mTBracketMetrics.gameChangerCards : list;
        List list10 = (i13 & 8192) != 0 ? mTBracketMetrics.fastManaCards : list2;
        int i26 = i14;
        List list11 = (i13 & 16384) != 0 ? mTBracketMetrics.extraTurnCards : list3;
        List list12 = (i13 & 32768) != 0 ? mTBracketMetrics.massLandDenialCards : list4;
        List list13 = (i13 & 65536) != 0 ? mTBracketMetrics.universalTutorCards : list5;
        if ((i13 & 131072) != 0) {
            list8 = list13;
            list7 = mTBracketMetrics.twoCardComboCards;
        } else {
            list7 = list6;
            list8 = list13;
        }
        return mTBracketMetrics.copy(i26, i15, i16, i17, i18, i19, i20, i21, i22, i23, i24, i25, list9, list10, list11, list12, list8, list7);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getTotalCards() {
        return this.totalCards;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getTwoCardComboCount() {
        return this.twoCardComboCount;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getMassLandDenialCount() {
        return this.massLandDenialCount;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final int getUniversalTutorCount() {
        return this.universalTutorCount;
    }

    public final List<MTBracketMetricsCard> component13() {
        return this.gameChangerCards;
    }

    public final List<MTBracketMetricsCard> component14() {
        return this.fastManaCards;
    }

    public final List<MTBracketMetricsCard> component15() {
        return this.extraTurnCards;
    }

    public final List<MTBracketMetricsCard> component16() {
        return this.massLandDenialCards;
    }

    public final List<MTBracketMetricsCard> component17() {
        return this.universalTutorCards;
    }

    public final List<MTBracketMetricsCard> component18() {
        return this.twoCardComboCards;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getStaxCount() {
        return this.staxCount;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getTutorCount() {
        return this.tutorCount;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getFastManaCount() {
        return this.fastManaCount;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getManaRockCount() {
        return this.manaRockCount;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getAltWinconCount() {
        return this.altWinconCount;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getExtraTurnCount() {
        return this.extraTurnCount;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getGameChangerCount() {
        return this.gameChangerCount;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getCounterspellCount() {
        return this.counterspellCount;
    }

    public final MTBracketMetrics copy(int totalCards, int staxCount, int tutorCount, int fastManaCount, int manaRockCount, int altWinconCount, int extraTurnCount, int gameChangerCount, int counterspellCount, int twoCardComboCount, int massLandDenialCount, int universalTutorCount, List<MTBracketMetricsCard> gameChangerCards, List<MTBracketMetricsCard> fastManaCards, List<MTBracketMetricsCard> extraTurnCards, List<MTBracketMetricsCard> massLandDenialCards, List<MTBracketMetricsCard> universalTutorCards, List<MTBracketMetricsCard> twoCardComboCards) {
        return new MTBracketMetrics(totalCards, staxCount, tutorCount, fastManaCount, manaRockCount, altWinconCount, extraTurnCount, gameChangerCount, counterspellCount, twoCardComboCount, massLandDenialCount, universalTutorCount, gameChangerCards, fastManaCards, extraTurnCards, massLandDenialCards, universalTutorCards, twoCardComboCards);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTBracketMetrics)) {
            return false;
        }
        MTBracketMetrics mTBracketMetrics = (MTBracketMetrics) other;
        return this.totalCards == mTBracketMetrics.totalCards && this.staxCount == mTBracketMetrics.staxCount && this.tutorCount == mTBracketMetrics.tutorCount && this.fastManaCount == mTBracketMetrics.fastManaCount && this.manaRockCount == mTBracketMetrics.manaRockCount && this.altWinconCount == mTBracketMetrics.altWinconCount && this.extraTurnCount == mTBracketMetrics.extraTurnCount && this.gameChangerCount == mTBracketMetrics.gameChangerCount && this.counterspellCount == mTBracketMetrics.counterspellCount && this.twoCardComboCount == mTBracketMetrics.twoCardComboCount && this.massLandDenialCount == mTBracketMetrics.massLandDenialCount && this.universalTutorCount == mTBracketMetrics.universalTutorCount && Intrinsics.areEqual(this.gameChangerCards, mTBracketMetrics.gameChangerCards) && Intrinsics.areEqual(this.fastManaCards, mTBracketMetrics.fastManaCards) && Intrinsics.areEqual(this.extraTurnCards, mTBracketMetrics.extraTurnCards) && Intrinsics.areEqual(this.massLandDenialCards, mTBracketMetrics.massLandDenialCards) && Intrinsics.areEqual(this.universalTutorCards, mTBracketMetrics.universalTutorCards) && Intrinsics.areEqual(this.twoCardComboCards, mTBracketMetrics.twoCardComboCards);
    }

    public final int getAltWinconCount() {
        return this.altWinconCount;
    }

    public final int getCounterspellCount() {
        return this.counterspellCount;
    }

    public final List<MTBracketMetricsCard> getExtraTurnCards() {
        return this.extraTurnCards;
    }

    public final int getExtraTurnCount() {
        return this.extraTurnCount;
    }

    public final List<MTBracketMetricsCard> getFastManaCards() {
        return this.fastManaCards;
    }

    public final int getFastManaCount() {
        return this.fastManaCount;
    }

    public final List<MTBracketMetricsCard> getGameChangerCards() {
        return this.gameChangerCards;
    }

    public final int getGameChangerCount() {
        return this.gameChangerCount;
    }

    public final int getManaRockCount() {
        return this.manaRockCount;
    }

    public final List<MTBracketMetricsCard> getMassLandDenialCards() {
        return this.massLandDenialCards;
    }

    public final int getMassLandDenialCount() {
        return this.massLandDenialCount;
    }

    public final int getStaxCount() {
        return this.staxCount;
    }

    public final int getTotalCards() {
        return this.totalCards;
    }

    public final int getTutorCount() {
        return this.tutorCount;
    }

    public final List<MTBracketMetricsCard> getTwoCardComboCards() {
        return this.twoCardComboCards;
    }

    public final int getTwoCardComboCount() {
        return this.twoCardComboCount;
    }

    public final List<MTBracketMetricsCard> getUniversalTutorCards() {
        return this.universalTutorCards;
    }

    public final int getUniversalTutorCount() {
        return this.universalTutorCount;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((((((((Integer.hashCode(this.totalCards) * 31) + Integer.hashCode(this.staxCount)) * 31) + Integer.hashCode(this.tutorCount)) * 31) + Integer.hashCode(this.fastManaCount)) * 31) + Integer.hashCode(this.manaRockCount)) * 31) + Integer.hashCode(this.altWinconCount)) * 31) + Integer.hashCode(this.extraTurnCount)) * 31) + Integer.hashCode(this.gameChangerCount)) * 31) + Integer.hashCode(this.counterspellCount)) * 31) + Integer.hashCode(this.twoCardComboCount)) * 31) + Integer.hashCode(this.massLandDenialCount)) * 31) + Integer.hashCode(this.universalTutorCount)) * 31;
        List<MTBracketMetricsCard> list = this.gameChangerCards;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<MTBracketMetricsCard> list2 = this.fastManaCards;
        int iHashCode3 = (iHashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<MTBracketMetricsCard> list3 = this.extraTurnCards;
        int iHashCode4 = (iHashCode3 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<MTBracketMetricsCard> list4 = this.massLandDenialCards;
        int iHashCode5 = (iHashCode4 + (list4 == null ? 0 : list4.hashCode())) * 31;
        List<MTBracketMetricsCard> list5 = this.universalTutorCards;
        int iHashCode6 = (iHashCode5 + (list5 == null ? 0 : list5.hashCode())) * 31;
        List<MTBracketMetricsCard> list6 = this.twoCardComboCards;
        return iHashCode6 + (list6 != null ? list6.hashCode() : 0);
    }

    public final void setAltWinconCount(int i) {
        this.altWinconCount = i;
    }

    public final void setCounterspellCount(int i) {
        this.counterspellCount = i;
    }

    public final void setExtraTurnCards(List<MTBracketMetricsCard> list) {
        this.extraTurnCards = list;
    }

    public final void setExtraTurnCount(int i) {
        this.extraTurnCount = i;
    }

    public final void setFastManaCards(List<MTBracketMetricsCard> list) {
        this.fastManaCards = list;
    }

    public final void setFastManaCount(int i) {
        this.fastManaCount = i;
    }

    public final void setGameChangerCards(List<MTBracketMetricsCard> list) {
        this.gameChangerCards = list;
    }

    public final void setGameChangerCount(int i) {
        this.gameChangerCount = i;
    }

    public final void setManaRockCount(int i) {
        this.manaRockCount = i;
    }

    public final void setMassLandDenialCards(List<MTBracketMetricsCard> list) {
        this.massLandDenialCards = list;
    }

    public final void setMassLandDenialCount(int i) {
        this.massLandDenialCount = i;
    }

    public final void setStaxCount(int i) {
        this.staxCount = i;
    }

    public final void setTotalCards(int i) {
        this.totalCards = i;
    }

    public final void setTutorCount(int i) {
        this.tutorCount = i;
    }

    public final void setTwoCardComboCards(List<MTBracketMetricsCard> list) {
        this.twoCardComboCards = list;
    }

    public final void setTwoCardComboCount(int i) {
        this.twoCardComboCount = i;
    }

    public final void setUniversalTutorCards(List<MTBracketMetricsCard> list) {
        this.universalTutorCards = list;
    }

    public final void setUniversalTutorCount(int i) {
        this.universalTutorCount = i;
    }

    public String toString() {
        return "MTBracketMetrics(totalCards=" + this.totalCards + ", staxCount=" + this.staxCount + ", tutorCount=" + this.tutorCount + ", fastManaCount=" + this.fastManaCount + ", manaRockCount=" + this.manaRockCount + ", altWinconCount=" + this.altWinconCount + ", extraTurnCount=" + this.extraTurnCount + ", gameChangerCount=" + this.gameChangerCount + ", counterspellCount=" + this.counterspellCount + ", twoCardComboCount=" + this.twoCardComboCount + ", massLandDenialCount=" + this.massLandDenialCount + ", universalTutorCount=" + this.universalTutorCount + ", gameChangerCards=" + this.gameChangerCards + ", fastManaCards=" + this.fastManaCards + ", extraTurnCards=" + this.extraTurnCards + ", massLandDenialCards=" + this.massLandDenialCards + ", universalTutorCards=" + this.universalTutorCards + ", twoCardComboCards=" + this.twoCardComboCards + ")";
    }
}
