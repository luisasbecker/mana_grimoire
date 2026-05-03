package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MTCardRankingsModels.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardRankingFlags;", "", "gameChanger", "", "fastMana", "extraTurn", "universalTutor", "comboPiece", "massLandDenial", "<init>", "(ZZZZZZ)V", "getGameChanger", "()Z", "getFastMana", "getExtraTurn", "getUniversalTutor", "getComboPiece", "getMassLandDenial", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MTCardRankingFlags {
    public static final int $stable = 0;
    private final boolean comboPiece;
    private final boolean extraTurn;
    private final boolean fastMana;
    private final boolean gameChanger;
    private final boolean massLandDenial;
    private final boolean universalTutor;

    public MTCardRankingFlags() {
        this(false, false, false, false, false, false, 63, null);
    }

    public MTCardRankingFlags(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.gameChanger = z;
        this.fastMana = z2;
        this.extraTurn = z3;
        this.universalTutor = z4;
        this.comboPiece = z5;
        this.massLandDenial = z6;
    }

    public /* synthetic */ MTCardRankingFlags(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? false : z4, (i & 16) != 0 ? false : z5, (i & 32) != 0 ? false : z6);
    }

    public static /* synthetic */ MTCardRankingFlags copy$default(MTCardRankingFlags mTCardRankingFlags, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i, Object obj) {
        if ((i & 1) != 0) {
            z = mTCardRankingFlags.gameChanger;
        }
        if ((i & 2) != 0) {
            z2 = mTCardRankingFlags.fastMana;
        }
        if ((i & 4) != 0) {
            z3 = mTCardRankingFlags.extraTurn;
        }
        if ((i & 8) != 0) {
            z4 = mTCardRankingFlags.universalTutor;
        }
        if ((i & 16) != 0) {
            z5 = mTCardRankingFlags.comboPiece;
        }
        if ((i & 32) != 0) {
            z6 = mTCardRankingFlags.massLandDenial;
        }
        boolean z7 = z5;
        boolean z8 = z6;
        return mTCardRankingFlags.copy(z, z2, z3, z4, z7, z8);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getGameChanger() {
        return this.gameChanger;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getFastMana() {
        return this.fastMana;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getExtraTurn() {
        return this.extraTurn;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getUniversalTutor() {
        return this.universalTutor;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getComboPiece() {
        return this.comboPiece;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getMassLandDenial() {
        return this.massLandDenial;
    }

    public final MTCardRankingFlags copy(boolean gameChanger, boolean fastMana, boolean extraTurn, boolean universalTutor, boolean comboPiece, boolean massLandDenial) {
        return new MTCardRankingFlags(gameChanger, fastMana, extraTurn, universalTutor, comboPiece, massLandDenial);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MTCardRankingFlags)) {
            return false;
        }
        MTCardRankingFlags mTCardRankingFlags = (MTCardRankingFlags) other;
        return this.gameChanger == mTCardRankingFlags.gameChanger && this.fastMana == mTCardRankingFlags.fastMana && this.extraTurn == mTCardRankingFlags.extraTurn && this.universalTutor == mTCardRankingFlags.universalTutor && this.comboPiece == mTCardRankingFlags.comboPiece && this.massLandDenial == mTCardRankingFlags.massLandDenial;
    }

    public final boolean getComboPiece() {
        return this.comboPiece;
    }

    public final boolean getExtraTurn() {
        return this.extraTurn;
    }

    public final boolean getFastMana() {
        return this.fastMana;
    }

    public final boolean getGameChanger() {
        return this.gameChanger;
    }

    public final boolean getMassLandDenial() {
        return this.massLandDenial;
    }

    public final boolean getUniversalTutor() {
        return this.universalTutor;
    }

    public int hashCode() {
        return (((((((((Boolean.hashCode(this.gameChanger) * 31) + Boolean.hashCode(this.fastMana)) * 31) + Boolean.hashCode(this.extraTurn)) * 31) + Boolean.hashCode(this.universalTutor)) * 31) + Boolean.hashCode(this.comboPiece)) * 31) + Boolean.hashCode(this.massLandDenial);
    }

    public String toString() {
        return "MTCardRankingFlags(gameChanger=" + this.gameChanger + ", fastMana=" + this.fastMana + ", extraTurn=" + this.extraTurn + ", universalTutor=" + this.universalTutor + ", comboPiece=" + this.comboPiece + ", massLandDenial=" + this.massLandDenial + ")";
    }
}
