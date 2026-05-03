package com.studiolaganne.lengendarylens;

import androidx.camera.video.AudioStats;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TournamentUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0002J \u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0006\u001a\u00020\u0007J\u001e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\tJ\u0016\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0012J\u0016\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\t¨\u0006\u001f"}, d2 = {"Lcom/studiolaganne/lengendarylens/TournamentUtils;", "", "<init>", "()V", "getPlayerById", "Lcom/studiolaganne/lengendarylens/TournamentPlayer;", "tournament", "Lcom/studiolaganne/lengendarylens/Tournament;", "id", "", "isBye", "", "pairing", "Lcom/studiolaganne/lengendarylens/Pairing;", "getPlayerResult", "Lcom/studiolaganne/lengendarylens/MatchResult;", "playerId", "gamePointsAvailableFor", "", "gamePointsEarnedFor", "getCurrentStandings", "", "Lcom/studiolaganne/lengendarylens/StandingsRow;", "playersHaveMet", "playerId1", "playerId2", "willHaveRematches", "players", "rounds", "playerHasBye", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TournamentUtils {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static TournamentUtils instance;

    /* JADX INFO: compiled from: TournamentUtils.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/studiolaganne/lengendarylens/TournamentUtils$Companion;", "", "<init>", "()V", "instance", "Lcom/studiolaganne/lengendarylens/TournamentUtils;", "getInstance", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final synchronized TournamentUtils getInstance() {
            TournamentUtils tournamentUtils;
            if (TournamentUtils.instance == null) {
                TournamentUtils.instance = new TournamentUtils(null);
            }
            tournamentUtils = TournamentUtils.instance;
            Intrinsics.checkNotNull(tournamentUtils);
            return tournamentUtils;
        }
    }

    /* JADX INFO: compiled from: TournamentUtils.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[MatchType.values().length];
            try {
                iArr[MatchType.BO1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MatchType.BO3.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[MatchResult.values().length];
            try {
                iArr2[MatchResult.WIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[MatchResult.DRAW.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[MatchResult.LOSS.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private TournamentUtils() {
    }

    public /* synthetic */ TournamentUtils(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final int gamePointsAvailableFor(Tournament tournament, Pairing pairing) {
        return (pairing.getFirstPlayerScore() + pairing.getSecondPlayerScore()) * 3;
    }

    private final int gamePointsEarnedFor(Tournament tournament, String playerId, Pairing pairing) {
        int secondPlayerScore;
        if (Intrinsics.areEqual(pairing.getFirstPlayerId(), playerId)) {
            secondPlayerScore = pairing.getFirstPlayerScore();
        } else {
            if (!Intrinsics.areEqual(pairing.getSecondPlayerId(), playerId)) {
                return 0;
            }
            secondPlayerScore = pairing.getSecondPlayerScore();
        }
        return secondPlayerScore * 3;
    }

    private final MatchResult getPlayerResult(Tournament tournament, String playerId, Pairing pairing) {
        if (isBye(pairing) && Intrinsics.areEqual(pairing.getFirstPlayerId(), playerId)) {
            return MatchResult.WIN;
        }
        if (Intrinsics.areEqual(pairing.getFirstPlayerId(), playerId)) {
            int i = WhenMappings.$EnumSwitchMapping$0[tournament.getMatchType().ordinal()];
            if (i == 1) {
                return (pairing.getFirstPlayerScore() == 0 && pairing.getSecondPlayerScore() == 0) ? MatchResult.DRAW : pairing.getFirstPlayerScore() == 1 ? MatchResult.WIN : MatchResult.LOSS;
            }
            if (i == 2) {
                return ((pairing.getFirstPlayerScore() == 1 && pairing.getSecondPlayerScore() == 1) || (pairing.getFirstPlayerScore() == 0 && pairing.getSecondPlayerScore() == 0)) ? MatchResult.DRAW : pairing.getFirstPlayerScore() == 2 ? MatchResult.WIN : (pairing.getFirstPlayerScore() == 1 && pairing.getSecondPlayerScore() == 0) ? MatchResult.WIN : MatchResult.LOSS;
            }
        } else if (Intrinsics.areEqual(pairing.getSecondPlayerId(), playerId)) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[tournament.getMatchType().ordinal()];
            if (i2 == 1) {
                return (pairing.getFirstPlayerScore() == 0 && pairing.getSecondPlayerScore() == 0) ? MatchResult.DRAW : pairing.getSecondPlayerScore() == 1 ? MatchResult.WIN : MatchResult.LOSS;
            }
            if (i2 == 2) {
                return ((pairing.getFirstPlayerScore() == 1 && pairing.getSecondPlayerScore() == 1) || (pairing.getFirstPlayerScore() == 0 && pairing.getSecondPlayerScore() == 0)) ? MatchResult.DRAW : pairing.getSecondPlayerScore() == 2 ? MatchResult.WIN : (pairing.getSecondPlayerScore() == 1 && pairing.getFirstPlayerScore() == 0) ? MatchResult.WIN : MatchResult.LOSS;
            }
        }
        return MatchResult.DRAW;
    }

    private final boolean isBye(Pairing pairing) {
        return pairing.getSecondPlayerId().length() == 0;
    }

    public final List<StandingsRow> getCurrentStandings(Tournament tournament) {
        int i;
        Object next;
        Intrinsics.checkNotNullParameter(tournament, "tournament");
        ArrayList<StandingsRow> arrayList = new ArrayList();
        Iterator<TournamentPlayer> it = tournament.getPlayers().iterator();
        while (it.hasNext()) {
            TournamentPlayer next2 = it.next();
            int i2 = 0;
            StandingsRow standingsRow = new StandingsRow(null, next2, 0, null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, 509, null);
            int currentRound = tournament.getCurrentRound() + 1;
            Iterator<TournamentPlayer> it2 = it;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            while (i2 < currentRound) {
                int i13 = currentRound;
                Round round = tournament.getRounds().get(i2);
                if (round.getFinal()) {
                    Iterator it3 = round.getPairings().iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            i = i2;
                            next = null;
                            break;
                        }
                        next = it3.next();
                        Pairing pairing = (Pairing) next;
                        Iterator it4 = it3;
                        i = i2;
                        if (Intrinsics.areEqual(pairing.getFirstPlayerId(), next2.getId()) || Intrinsics.areEqual(pairing.getSecondPlayerId(), next2.getId())) {
                            break;
                        }
                        it3 = it4;
                        i2 = i;
                    }
                    Pairing pairing2 = (Pairing) next;
                    if (pairing2 == null) {
                        continue;
                    } else {
                        boolean zIsBye = isBye(pairing2);
                        if (!zIsBye) {
                            i3 += 3;
                        }
                        int iGamePointsAvailableFor = gamePointsAvailableFor(tournament, pairing2);
                        int i14 = i3;
                        int iGamePointsEarnedFor = gamePointsEarnedFor(tournament, next2.getId(), pairing2);
                        i12 += iGamePointsAvailableFor;
                        i4 += iGamePointsEarnedFor;
                        if (!zIsBye) {
                            i5 += iGamePointsAvailableFor;
                            i6 += iGamePointsEarnedFor;
                        }
                        int i15 = WhenMappings.$EnumSwitchMapping$1[getPlayerResult(tournament, next2.getId(), pairing2).ordinal()];
                        if (i15 == 1) {
                            i8 += 3;
                            i9++;
                            if (!zIsBye) {
                                i7 += 3;
                            }
                        } else if (i15 == 2) {
                            i8++;
                            i11++;
                            if (!zIsBye) {
                                i7++;
                            }
                        } else {
                            if (i15 != 3) {
                                throw new NoWhenBranchMatchedException();
                            }
                            i10++;
                        }
                        i3 = i14;
                    }
                } else {
                    i = i2;
                }
                i2 = i + 1;
                currentRound = i13;
            }
            standingsRow.setPoints(i8);
            standingsRow.setWld(i9 + "-" + i10 + "-" + i11);
            if (i12 > 0) {
                standingsRow.setGw(((double) i4) / ((double) i12));
            } else {
                standingsRow.setGw(AudioStats.AUDIO_AMPLITUDE_NONE);
            }
            if (i5 > 0) {
                standingsRow.setGwForOppoAvg(((double) i6) / ((double) i5));
                if (standingsRow.getGwForOppoAvg() < 0.3333333333333333d) {
                    standingsRow.setGwForOppoAvg(0.3333333333333333d);
                }
            } else {
                standingsRow.setGwForOppoAvg(0.3333333333333333d);
            }
            if (i3 > 0) {
                standingsRow.setMw(((double) i7) / ((double) i3));
                if (standingsRow.getMw() < 0.3333333333333333d) {
                    standingsRow.setMw(0.3333333333333333d);
                }
            } else {
                standingsRow.setMw(0.3333333333333333d);
            }
            arrayList.add(standingsRow);
            it = it2;
        }
        for (StandingsRow standingsRow2 : arrayList) {
            double d = AudioStats.AUDIO_AMPLITUDE_NONE;
            double mw = AudioStats.AUDIO_AMPLITUDE_NONE;
            double gwForOppoAvg = AudioStats.AUDIO_AMPLITUDE_NONE;
            for (StandingsRow standingsRow3 : arrayList) {
                if (!Intrinsics.areEqual(standingsRow3.getPlayer().getId(), standingsRow2.getPlayer().getId()) && playersHaveMet(tournament, standingsRow3.getPlayer().getId(), standingsRow2.getPlayer().getId())) {
                    mw += standingsRow3.getMw();
                    gwForOppoAvg += standingsRow3.getGwForOppoAvg();
                    d += 1.0d;
                }
            }
            if (d > AudioStats.AUDIO_AMPLITUDE_NONE) {
                standingsRow2.setOmw(mw / d);
                standingsRow2.setOgw(gwForOppoAvg / d);
            } else {
                standingsRow2.setOmw(1.0d);
                standingsRow2.setOgw(1.0d);
            }
        }
        final Comparator comparator = new Comparator() { // from class: com.studiolaganne.lengendarylens.TournamentUtils$getCurrentStandings$$inlined$compareByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((StandingsRow) t2).getPoints()), Integer.valueOf(((StandingsRow) t).getPoints()));
            }
        };
        final Comparator comparator2 = new Comparator() { // from class: com.studiolaganne.lengendarylens.TournamentUtils$getCurrentStandings$$inlined$thenByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int iCompare = comparator.compare(t, t2);
                return iCompare != 0 ? iCompare : ComparisonsKt.compareValues(Double.valueOf(((StandingsRow) t2).getOmw()), Double.valueOf(((StandingsRow) t).getOmw()));
            }
        };
        final Comparator comparator3 = new Comparator() { // from class: com.studiolaganne.lengendarylens.TournamentUtils$getCurrentStandings$$inlined$thenByDescending$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int iCompare = comparator2.compare(t, t2);
                return iCompare != 0 ? iCompare : ComparisonsKt.compareValues(Double.valueOf(((StandingsRow) t2).getGwForOppoAvg()), Double.valueOf(((StandingsRow) t).getGwForOppoAvg()));
            }
        };
        return CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.studiolaganne.lengendarylens.TournamentUtils$getCurrentStandings$$inlined$thenByDescending$3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int iCompare = comparator3.compare(t, t2);
                return iCompare != 0 ? iCompare : ComparisonsKt.compareValues(Double.valueOf(((StandingsRow) t2).getOgw()), Double.valueOf(((StandingsRow) t).getOgw()));
            }
        });
    }

    public final TournamentPlayer getPlayerById(Tournament tournament, String id) {
        Object next;
        Intrinsics.checkNotNullParameter(tournament, "tournament");
        Intrinsics.checkNotNullParameter(id, "id");
        Iterator<T> it = tournament.getPlayers().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(((TournamentPlayer) next).getId(), id)) {
                break;
            }
        }
        return (TournamentPlayer) next;
    }

    public final boolean playerHasBye(Tournament tournament, String playerId) {
        Intrinsics.checkNotNullParameter(tournament, "tournament");
        Intrinsics.checkNotNullParameter(playerId, "playerId");
        for (Round round : tournament.getRounds()) {
            if (round.getFinal()) {
                for (Pairing pairing : round.getPairings()) {
                    if (Intrinsics.areEqual(pairing.getFirstPlayerId(), playerId) && pairing.getSecondPlayerId().length() == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean playersHaveMet(Tournament tournament, String playerId1, String playerId2) {
        Intrinsics.checkNotNullParameter(tournament, "tournament");
        Intrinsics.checkNotNullParameter(playerId1, "playerId1");
        Intrinsics.checkNotNullParameter(playerId2, "playerId2");
        for (Round round : tournament.getRounds()) {
            if (round.getFinal()) {
                for (Pairing pairing : round.getPairings()) {
                    if (Intrinsics.areEqual(pairing.getFirstPlayerId(), playerId1) && Intrinsics.areEqual(pairing.getSecondPlayerId(), playerId2)) {
                        return true;
                    }
                    if (Intrinsics.areEqual(pairing.getFirstPlayerId(), playerId2) && Intrinsics.areEqual(pairing.getSecondPlayerId(), playerId1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean willHaveRematches(int players, int rounds) {
        return players >= 2 && rounds >= 1 && rounds > players - 1;
    }
}
