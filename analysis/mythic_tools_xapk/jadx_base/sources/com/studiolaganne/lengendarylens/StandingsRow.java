package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DataStructs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b+\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0007HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\nHÆ\u0003J\t\u00100\u001a\u00020\nHÆ\u0003J\t\u00101\u001a\u00020\nHÆ\u0003J\t\u00102\u001a\u00020\nHÆ\u0003J\t\u00103\u001a\u00020\nHÆ\u0003Jc\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\nHÆ\u0001J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\u0007HÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u000b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"R\u001a\u0010\f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R\u001a\u0010\r\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R\u001a\u0010\u000e\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010 \"\u0004\b*\u0010\"¨\u0006:"}, d2 = {"Lcom/studiolaganne/lengendarylens/StandingsRow;", "", "version", "", "player", "Lcom/studiolaganne/lengendarylens/TournamentPlayer;", "points", "", "wld", "omw", "", "gw", "ogw", "mw", "gwForOppoAvg", "<init>", "(Ljava/lang/String;Lcom/studiolaganne/lengendarylens/TournamentPlayer;ILjava/lang/String;DDDDD)V", "getVersion", "()Ljava/lang/String;", "setVersion", "(Ljava/lang/String;)V", "getPlayer", "()Lcom/studiolaganne/lengendarylens/TournamentPlayer;", "setPlayer", "(Lcom/studiolaganne/lengendarylens/TournamentPlayer;)V", "getPoints", "()I", "setPoints", "(I)V", "getWld", "setWld", "getOmw", "()D", "setOmw", "(D)V", "getGw", "setGw", "getOgw", "setOgw", "getMw", "setMw", "getGwForOppoAvg", "setGwForOppoAvg", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class StandingsRow {
    public static final int $stable = 8;
    private double gw;
    private double gwForOppoAvg;
    private double mw;
    private double ogw;
    private double omw;
    private TournamentPlayer player;
    private int points;
    private String version;
    private String wld;

    public StandingsRow(String version, TournamentPlayer player, int i, String wld, double d, double d2, double d3, double d4, double d5) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter(wld, "wld");
        this.version = version;
        this.player = player;
        this.points = i;
        this.wld = wld;
        this.omw = d;
        this.gw = d2;
        this.ogw = d3;
        this.mw = d4;
        this.gwForOppoAvg = d5;
    }

    public /* synthetic */ StandingsRow(String str, TournamentPlayer tournamentPlayer, int i, String str2, double d, double d2, double d3, double d4, double d5, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "v1" : str, tournamentPlayer, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? "0-0-0" : str2, (i2 & 16) != 0 ? 0.0d : d, (i2 & 32) != 0 ? 0.0d : d2, (i2 & 64) != 0 ? 0.0d : d3, (i2 & 128) != 0 ? 0.3333333333333333d : d4, (i2 & 256) != 0 ? 0.3333333333333333d : d5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final TournamentPlayer getPlayer() {
        return this.player;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getPoints() {
        return this.points;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getWld() {
        return this.wld;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final double getOmw() {
        return this.omw;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final double getGw() {
        return this.gw;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final double getOgw() {
        return this.ogw;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final double getMw() {
        return this.mw;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final double getGwForOppoAvg() {
        return this.gwForOppoAvg;
    }

    public final StandingsRow copy(String version, TournamentPlayer player, int points, String wld, double omw, double gw, double ogw, double mw, double gwForOppoAvg) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter(wld, "wld");
        return new StandingsRow(version, player, points, wld, omw, gw, ogw, mw, gwForOppoAvg);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StandingsRow)) {
            return false;
        }
        StandingsRow standingsRow = (StandingsRow) other;
        return Intrinsics.areEqual(this.version, standingsRow.version) && Intrinsics.areEqual(this.player, standingsRow.player) && this.points == standingsRow.points && Intrinsics.areEqual(this.wld, standingsRow.wld) && Double.compare(this.omw, standingsRow.omw) == 0 && Double.compare(this.gw, standingsRow.gw) == 0 && Double.compare(this.ogw, standingsRow.ogw) == 0 && Double.compare(this.mw, standingsRow.mw) == 0 && Double.compare(this.gwForOppoAvg, standingsRow.gwForOppoAvg) == 0;
    }

    public final double getGw() {
        return this.gw;
    }

    public final double getGwForOppoAvg() {
        return this.gwForOppoAvg;
    }

    public final double getMw() {
        return this.mw;
    }

    public final double getOgw() {
        return this.ogw;
    }

    public final double getOmw() {
        return this.omw;
    }

    public final TournamentPlayer getPlayer() {
        return this.player;
    }

    public final int getPoints() {
        return this.points;
    }

    public final String getVersion() {
        return this.version;
    }

    public final String getWld() {
        return this.wld;
    }

    public int hashCode() {
        return (((((((((((((((this.version.hashCode() * 31) + this.player.hashCode()) * 31) + Integer.hashCode(this.points)) * 31) + this.wld.hashCode()) * 31) + Double.hashCode(this.omw)) * 31) + Double.hashCode(this.gw)) * 31) + Double.hashCode(this.ogw)) * 31) + Double.hashCode(this.mw)) * 31) + Double.hashCode(this.gwForOppoAvg);
    }

    public final void setGw(double d) {
        this.gw = d;
    }

    public final void setGwForOppoAvg(double d) {
        this.gwForOppoAvg = d;
    }

    public final void setMw(double d) {
        this.mw = d;
    }

    public final void setOgw(double d) {
        this.ogw = d;
    }

    public final void setOmw(double d) {
        this.omw = d;
    }

    public final void setPlayer(TournamentPlayer tournamentPlayer) {
        Intrinsics.checkNotNullParameter(tournamentPlayer, "<set-?>");
        this.player = tournamentPlayer;
    }

    public final void setPoints(int i) {
        this.points = i;
    }

    public final void setVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.version = str;
    }

    public final void setWld(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.wld = str;
    }

    public String toString() {
        return "StandingsRow(version=" + this.version + ", player=" + this.player + ", points=" + this.points + ", wld=" + this.wld + ", omw=" + this.omw + ", gw=" + this.gw + ", ogw=" + this.ogw + ", mw=" + this.mw + ", gwForOppoAvg=" + this.gwForOppoAvg + ")";
    }
}
