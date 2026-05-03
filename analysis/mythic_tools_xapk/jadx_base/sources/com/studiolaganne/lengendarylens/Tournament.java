package com.studiolaganne.lengendarylens;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DataStructs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\bN\b\u0087\b\u0018\u00002\u00020\u0001BÉ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0016\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0016\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0016\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0012¢\u0006\u0004\b\u001f\u0010 J\t\u0010U\u001a\u00020\u0003HÆ\u0003J\t\u0010V\u001a\u00020\u0005HÆ\u0003J\t\u0010W\u001a\u00020\u0007HÆ\u0003J\t\u0010X\u001a\u00020\u0005HÆ\u0003J\t\u0010Y\u001a\u00020\nHÆ\u0003J\t\u0010Z\u001a\u00020\fHÆ\u0003J\t\u0010[\u001a\u00020\u000eHÆ\u0003J\t\u0010\\\u001a\u00020\u0005HÆ\u0003J\t\u0010]\u001a\u00020\u0005HÆ\u0003J\t\u0010^\u001a\u00020\u0012HÆ\u0003J\t\u0010_\u001a\u00020\u0014HÆ\u0003J\u000f\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016HÆ\u0003J\u000f\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00030\u0016HÆ\u0003J\u000f\u0010b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0016HÆ\u0003J\t\u0010c\u001a\u00020\u0005HÆ\u0003J\u000f\u0010d\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0016HÆ\u0003J\t\u0010e\u001a\u00020\u0012HÆ\u0003JË\u0001\u0010f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00162\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u00052\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00162\b\b\u0002\u0010\u001e\u001a\u00020\u0012HÆ\u0001J\u0013\u0010g\u001a\u00020\u00122\b\u0010h\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010i\u001a\u00020\u0005HÖ\u0001J\t\u0010j\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010&\"\u0004\b.\u0010(R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010\u000f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010&\"\u0004\b<\u0010(R\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010&\"\u0004\b>\u0010(R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010H\"\u0004\bL\u0010JR \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010H\"\u0004\bN\u0010JR\u001a\u0010\u001b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010&\"\u0004\bP\u0010(R \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010H\"\u0004\bR\u0010JR\u001a\u0010\u001e\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010@\"\u0004\bT\u0010B¨\u0006k"}, d2 = {"Lcom/studiolaganne/lengendarylens/Tournament;", "", "version", "", "setupStep", "", "tournamentStep", "Lcom/studiolaganne/lengendarylens/TournamentStep;", "currentStepTime", "eventType", "Lcom/studiolaganne/lengendarylens/EventType;", "pairingType", "Lcom/studiolaganne/lengendarylens/PairingType;", "matchType", "Lcom/studiolaganne/lengendarylens/MatchType;", "numberOfRounds", "roundTimer", "currentTimerActive", "", "currentTimeLeft", "", "players", "", "Lcom/studiolaganne/lengendarylens/TournamentPlayer;", "byes", "rounds", "Lcom/studiolaganne/lengendarylens/Round;", "currentRound", "tables", "Lcom/studiolaganne/lengendarylens/DraftTable;", "allowCrossTablePairings", "<init>", "(Ljava/lang/String;ILcom/studiolaganne/lengendarylens/TournamentStep;ILcom/studiolaganne/lengendarylens/EventType;Lcom/studiolaganne/lengendarylens/PairingType;Lcom/studiolaganne/lengendarylens/MatchType;IIZJLjava/util/List;Ljava/util/List;Ljava/util/List;ILjava/util/List;Z)V", "getVersion", "()Ljava/lang/String;", "setVersion", "(Ljava/lang/String;)V", "getSetupStep", "()I", "setSetupStep", "(I)V", "getTournamentStep", "()Lcom/studiolaganne/lengendarylens/TournamentStep;", "setTournamentStep", "(Lcom/studiolaganne/lengendarylens/TournamentStep;)V", "getCurrentStepTime", "setCurrentStepTime", "getEventType", "()Lcom/studiolaganne/lengendarylens/EventType;", "setEventType", "(Lcom/studiolaganne/lengendarylens/EventType;)V", "getPairingType", "()Lcom/studiolaganne/lengendarylens/PairingType;", "setPairingType", "(Lcom/studiolaganne/lengendarylens/PairingType;)V", "getMatchType", "()Lcom/studiolaganne/lengendarylens/MatchType;", "setMatchType", "(Lcom/studiolaganne/lengendarylens/MatchType;)V", "getNumberOfRounds", "setNumberOfRounds", "getRoundTimer", "setRoundTimer", "getCurrentTimerActive", "()Z", "setCurrentTimerActive", "(Z)V", "getCurrentTimeLeft", "()J", "setCurrentTimeLeft", "(J)V", "getPlayers", "()Ljava/util/List;", "setPlayers", "(Ljava/util/List;)V", "getByes", "setByes", "getRounds", "setRounds", "getCurrentRound", "setCurrentRound", "getTables", "setTables", "getAllowCrossTablePairings", "setAllowCrossTablePairings", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class Tournament {
    public static final int $stable = 8;
    private boolean allowCrossTablePairings;
    private List<String> byes;
    private int currentRound;
    private int currentStepTime;
    private long currentTimeLeft;
    private boolean currentTimerActive;
    private EventType eventType;
    private MatchType matchType;
    private int numberOfRounds;
    private PairingType pairingType;
    private List<TournamentPlayer> players;
    private int roundTimer;
    private List<Round> rounds;
    private int setupStep;
    private List<DraftTable> tables;
    private TournamentStep tournamentStep;
    private String version;

    public Tournament() {
        this(null, 0, null, 0, null, null, null, 0, 0, false, 0L, null, null, null, 0, null, false, 131071, null);
    }

    public Tournament(String version, int i, TournamentStep tournamentStep, int i2, EventType eventType, PairingType pairingType, MatchType matchType, int i3, int i4, boolean z, long j, List<TournamentPlayer> players, List<String> byes, List<Round> rounds, int i5, List<DraftTable> tables, boolean z2) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(tournamentStep, "tournamentStep");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(pairingType, "pairingType");
        Intrinsics.checkNotNullParameter(matchType, "matchType");
        Intrinsics.checkNotNullParameter(players, "players");
        Intrinsics.checkNotNullParameter(byes, "byes");
        Intrinsics.checkNotNullParameter(rounds, "rounds");
        Intrinsics.checkNotNullParameter(tables, "tables");
        this.version = version;
        this.setupStep = i;
        this.tournamentStep = tournamentStep;
        this.currentStepTime = i2;
        this.eventType = eventType;
        this.pairingType = pairingType;
        this.matchType = matchType;
        this.numberOfRounds = i3;
        this.roundTimer = i4;
        this.currentTimerActive = z;
        this.currentTimeLeft = j;
        this.players = players;
        this.byes = byes;
        this.rounds = rounds;
        this.currentRound = i5;
        this.tables = tables;
        this.allowCrossTablePairings = z2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ Tournament(String str, int i, TournamentStep tournamentStep, int i2, EventType eventType, PairingType pairingType, MatchType matchType, int i3, int i4, boolean z, long j, List list, List list2, List list3, int i5, List list4, boolean z2, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        String str2 = (i6 & 1) != 0 ? "v1" : str;
        int i7 = (i6 & 2) != 0 ? 0 : i;
        TournamentStep tournamentStep2 = (i6 & 4) != 0 ? TournamentStep.NOT_STARTED : tournamentStep;
        int i8 = (i6 & 8) != 0 ? 0 : i2;
        EventType eventType2 = (i6 & 16) != 0 ? EventType.CONSTRUCTED : eventType;
        PairingType pairingType2 = (i6 & 32) != 0 ? PairingType.SWISS : pairingType;
        MatchType matchType2 = (i6 & 64) != 0 ? MatchType.BO3 : matchType;
        int i9 = (i6 & 128) != 0 ? 3 : i3;
        int i10 = (i6 & 256) != 0 ? 0 : i4;
        boolean z3 = (i6 & 512) != 0 ? false : z;
        long j2 = (i6 & 1024) != 0 ? 0L : j;
        ArrayList arrayList = (i6 & 2048) != 0 ? new ArrayList() : list;
        ArrayList arrayList2 = (i6 & 4096) != 0 ? new ArrayList() : list2;
        ArrayList arrayList3 = (i6 & 8192) != 0 ? new ArrayList() : list3;
        this(str2, i7, tournamentStep2, i8, eventType2, pairingType2, matchType2, i9, i10, z3, j2, arrayList, arrayList2, arrayList3, (i6 & 16384) != 0 ? 0 : i5, (i6 & 32768) != 0 ? new ArrayList() : list4, (i6 & 65536) != 0 ? false : z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Tournament copy$default(Tournament tournament, String str, int i, TournamentStep tournamentStep, int i2, EventType eventType, PairingType pairingType, MatchType matchType, int i3, int i4, boolean z, long j, List list, List list2, List list3, int i5, List list4, boolean z2, int i6, Object obj) {
        boolean z3;
        List list5;
        String str2 = (i6 & 1) != 0 ? tournament.version : str;
        int i7 = (i6 & 2) != 0 ? tournament.setupStep : i;
        TournamentStep tournamentStep2 = (i6 & 4) != 0 ? tournament.tournamentStep : tournamentStep;
        int i8 = (i6 & 8) != 0 ? tournament.currentStepTime : i2;
        EventType eventType2 = (i6 & 16) != 0 ? tournament.eventType : eventType;
        PairingType pairingType2 = (i6 & 32) != 0 ? tournament.pairingType : pairingType;
        MatchType matchType2 = (i6 & 64) != 0 ? tournament.matchType : matchType;
        int i9 = (i6 & 128) != 0 ? tournament.numberOfRounds : i3;
        int i10 = (i6 & 256) != 0 ? tournament.roundTimer : i4;
        boolean z4 = (i6 & 512) != 0 ? tournament.currentTimerActive : z;
        long j2 = (i6 & 1024) != 0 ? tournament.currentTimeLeft : j;
        List list6 = (i6 & 2048) != 0 ? tournament.players : list;
        List list7 = (i6 & 4096) != 0 ? tournament.byes : list2;
        String str3 = str2;
        List list8 = (i6 & 8192) != 0 ? tournament.rounds : list3;
        int i11 = (i6 & 16384) != 0 ? tournament.currentRound : i5;
        List list9 = (i6 & 32768) != 0 ? tournament.tables : list4;
        if ((i6 & 65536) != 0) {
            list5 = list9;
            z3 = tournament.allowCrossTablePairings;
        } else {
            z3 = z2;
            list5 = list9;
        }
        return tournament.copy(str3, i7, tournamentStep2, i8, eventType2, pairingType2, matchType2, i9, i10, z4, j2, list6, list7, list8, i11, list5, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getCurrentTimerActive() {
        return this.currentTimerActive;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final long getCurrentTimeLeft() {
        return this.currentTimeLeft;
    }

    public final List<TournamentPlayer> component12() {
        return this.players;
    }

    public final List<String> component13() {
        return this.byes;
    }

    public final List<Round> component14() {
        return this.rounds;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final int getCurrentRound() {
        return this.currentRound;
    }

    public final List<DraftTable> component16() {
        return this.tables;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final boolean getAllowCrossTablePairings() {
        return this.allowCrossTablePairings;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getSetupStep() {
        return this.setupStep;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final TournamentStep getTournamentStep() {
        return this.tournamentStep;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getCurrentStepTime() {
        return this.currentStepTime;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final EventType getEventType() {
        return this.eventType;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final PairingType getPairingType() {
        return this.pairingType;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final MatchType getMatchType() {
        return this.matchType;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getNumberOfRounds() {
        return this.numberOfRounds;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getRoundTimer() {
        return this.roundTimer;
    }

    public final Tournament copy(String version, int setupStep, TournamentStep tournamentStep, int currentStepTime, EventType eventType, PairingType pairingType, MatchType matchType, int numberOfRounds, int roundTimer, boolean currentTimerActive, long currentTimeLeft, List<TournamentPlayer> players, List<String> byes, List<Round> rounds, int currentRound, List<DraftTable> tables, boolean allowCrossTablePairings) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(tournamentStep, "tournamentStep");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(pairingType, "pairingType");
        Intrinsics.checkNotNullParameter(matchType, "matchType");
        Intrinsics.checkNotNullParameter(players, "players");
        Intrinsics.checkNotNullParameter(byes, "byes");
        Intrinsics.checkNotNullParameter(rounds, "rounds");
        Intrinsics.checkNotNullParameter(tables, "tables");
        return new Tournament(version, setupStep, tournamentStep, currentStepTime, eventType, pairingType, matchType, numberOfRounds, roundTimer, currentTimerActive, currentTimeLeft, players, byes, rounds, currentRound, tables, allowCrossTablePairings);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Tournament)) {
            return false;
        }
        Tournament tournament = (Tournament) other;
        return Intrinsics.areEqual(this.version, tournament.version) && this.setupStep == tournament.setupStep && this.tournamentStep == tournament.tournamentStep && this.currentStepTime == tournament.currentStepTime && this.eventType == tournament.eventType && this.pairingType == tournament.pairingType && this.matchType == tournament.matchType && this.numberOfRounds == tournament.numberOfRounds && this.roundTimer == tournament.roundTimer && this.currentTimerActive == tournament.currentTimerActive && this.currentTimeLeft == tournament.currentTimeLeft && Intrinsics.areEqual(this.players, tournament.players) && Intrinsics.areEqual(this.byes, tournament.byes) && Intrinsics.areEqual(this.rounds, tournament.rounds) && this.currentRound == tournament.currentRound && Intrinsics.areEqual(this.tables, tournament.tables) && this.allowCrossTablePairings == tournament.allowCrossTablePairings;
    }

    public final boolean getAllowCrossTablePairings() {
        return this.allowCrossTablePairings;
    }

    public final List<String> getByes() {
        return this.byes;
    }

    public final int getCurrentRound() {
        return this.currentRound;
    }

    public final int getCurrentStepTime() {
        return this.currentStepTime;
    }

    public final long getCurrentTimeLeft() {
        return this.currentTimeLeft;
    }

    public final boolean getCurrentTimerActive() {
        return this.currentTimerActive;
    }

    public final EventType getEventType() {
        return this.eventType;
    }

    public final MatchType getMatchType() {
        return this.matchType;
    }

    public final int getNumberOfRounds() {
        return this.numberOfRounds;
    }

    public final PairingType getPairingType() {
        return this.pairingType;
    }

    public final List<TournamentPlayer> getPlayers() {
        return this.players;
    }

    public final int getRoundTimer() {
        return this.roundTimer;
    }

    public final List<Round> getRounds() {
        return this.rounds;
    }

    public final int getSetupStep() {
        return this.setupStep;
    }

    public final List<DraftTable> getTables() {
        return this.tables;
    }

    public final TournamentStep getTournamentStep() {
        return this.tournamentStep;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((this.version.hashCode() * 31) + Integer.hashCode(this.setupStep)) * 31) + this.tournamentStep.hashCode()) * 31) + Integer.hashCode(this.currentStepTime)) * 31) + this.eventType.hashCode()) * 31) + this.pairingType.hashCode()) * 31) + this.matchType.hashCode()) * 31) + Integer.hashCode(this.numberOfRounds)) * 31) + Integer.hashCode(this.roundTimer)) * 31) + Boolean.hashCode(this.currentTimerActive)) * 31) + Long.hashCode(this.currentTimeLeft)) * 31) + this.players.hashCode()) * 31) + this.byes.hashCode()) * 31) + this.rounds.hashCode()) * 31) + Integer.hashCode(this.currentRound)) * 31) + this.tables.hashCode()) * 31) + Boolean.hashCode(this.allowCrossTablePairings);
    }

    public final void setAllowCrossTablePairings(boolean z) {
        this.allowCrossTablePairings = z;
    }

    public final void setByes(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.byes = list;
    }

    public final void setCurrentRound(int i) {
        this.currentRound = i;
    }

    public final void setCurrentStepTime(int i) {
        this.currentStepTime = i;
    }

    public final void setCurrentTimeLeft(long j) {
        this.currentTimeLeft = j;
    }

    public final void setCurrentTimerActive(boolean z) {
        this.currentTimerActive = z;
    }

    public final void setEventType(EventType eventType) {
        Intrinsics.checkNotNullParameter(eventType, "<set-?>");
        this.eventType = eventType;
    }

    public final void setMatchType(MatchType matchType) {
        Intrinsics.checkNotNullParameter(matchType, "<set-?>");
        this.matchType = matchType;
    }

    public final void setNumberOfRounds(int i) {
        this.numberOfRounds = i;
    }

    public final void setPairingType(PairingType pairingType) {
        Intrinsics.checkNotNullParameter(pairingType, "<set-?>");
        this.pairingType = pairingType;
    }

    public final void setPlayers(List<TournamentPlayer> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.players = list;
    }

    public final void setRoundTimer(int i) {
        this.roundTimer = i;
    }

    public final void setRounds(List<Round> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.rounds = list;
    }

    public final void setSetupStep(int i) {
        this.setupStep = i;
    }

    public final void setTables(List<DraftTable> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.tables = list;
    }

    public final void setTournamentStep(TournamentStep tournamentStep) {
        Intrinsics.checkNotNullParameter(tournamentStep, "<set-?>");
        this.tournamentStep = tournamentStep;
    }

    public final void setVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.version = str;
    }

    public String toString() {
        return "Tournament(version=" + this.version + ", setupStep=" + this.setupStep + ", tournamentStep=" + this.tournamentStep + ", currentStepTime=" + this.currentStepTime + ", eventType=" + this.eventType + ", pairingType=" + this.pairingType + ", matchType=" + this.matchType + ", numberOfRounds=" + this.numberOfRounds + ", roundTimer=" + this.roundTimer + ", currentTimerActive=" + this.currentTimerActive + ", currentTimeLeft=" + this.currentTimeLeft + ", players=" + this.players + ", byes=" + this.byes + ", rounds=" + this.rounds + ", currentRound=" + this.currentRound + ", tables=" + this.tables + ", allowCrossTablePairings=" + this.allowCrossTablePairings + ")";
    }
}
