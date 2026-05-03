package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import com.studiolaganne.lengendarylens.databinding.FragmentEventContentBinding;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: EventContentFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 A2\u00020\u00012\u00020\u0002:\u0002@AB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0006H\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0016J\u0018\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u001e\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#H\u0002J.\u0010%\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002J&\u0010-\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010.\u001a\u00020*2\u0006\u0010/\u001a\u00020!H\u0002J \u00100\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020*H\u0002J\u0012\u00104\u001a\u00020\u00162\b\u00105\u001a\u0004\u0018\u000106H\u0016J&\u00107\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u001a\u0010=\u001a\u00020\u00162\u0006\u0010>\u001a\u0002082\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u0010\u0010?\u001a\u00020\u00162\u0006\u0010/\u001a\u00020!H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006B"}, d2 = {"Lcom/studiolaganne/lengendarylens/EventContentFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/studiolaganne/lengendarylens/EventContentCallback;", "<init>", "()V", "isFinals", "", "()Z", "setFinals", "(Z)V", "callback", "Lcom/studiolaganne/lengendarylens/EventContentFragment$ContentCallback;", "getCallback", "()Lcom/studiolaganne/lengendarylens/EventContentFragment$ContentCallback;", "setCallback", "(Lcom/studiolaganne/lengendarylens/EventContentFragment$ContentCallback;)V", "_binding", "Lcom/studiolaganne/lengendarylens/databinding/FragmentEventContentBinding;", "binding", "getBinding", "()Lcom/studiolaganne/lengendarylens/databinding/FragmentEventContentBinding;", "moveToDeckBuilding", "", "moveToRoundOne", "load", "submitStandings", "createFinals", ViewHierarchyConstants.DIMENSION_TOP_KEY, "", "matchType", "Lcom/studiolaganne/lengendarylens/MatchType;", "createNextRoundPairings", "tournament", "Lcom/studiolaganne/lengendarylens/Tournament;", "standings", "", "Lcom/studiolaganne/lengendarylens/StandingsRow;", "createPairingsRecursive", "playerPool", "", "", "newRound", "Lcom/studiolaganne/lengendarylens/Round;", "utils", "Lcom/studiolaganne/lengendarylens/TournamentUtils;", "createPairingsWithRematch", "createFirstRandomPairings", "it", "addPairingsForTable", "table", "Lcom/studiolaganne/lengendarylens/DraftTable;", "intoRound", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "setupSeekBar", "ContentCallback", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EventContentFragment extends Fragment implements EventContentCallback {
    private FragmentEventContentBinding _binding;
    private ContentCallback callback;
    private boolean isFinals;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: EventContentFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/studiolaganne/lengendarylens/EventContentFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/studiolaganne/lengendarylens/EventContentFragment;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final EventContentFragment newInstance() {
            EventContentFragment eventContentFragment = new EventContentFragment();
            eventContentFragment.setArguments(new Bundle());
            return eventContentFragment;
        }
    }

    /* JADX INFO: compiled from: EventContentFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004À\u0006\u0003"}, d2 = {"Lcom/studiolaganne/lengendarylens/EventContentFragment$ContentCallback;", "", "clearCurrentTournament", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface ContentCallback {
        void clearCurrentTournament();
    }

    /* JADX INFO: compiled from: EventContentFragment.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

        static {
            int[] iArr = new int[EventType.values().length];
            try {
                iArr[EventType.CONSTRUCTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EventType.SEALED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EventType.DRAFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[MatchType.values().length];
            try {
                iArr2[MatchType.BO1.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[MatchType.BO3.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[MatchType.BO5.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[PairingType.values().length];
            try {
                iArr3[PairingType.SINGLE_ELIMINATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr3[PairingType.SWISS.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[TournamentStep.values().length];
            try {
                iArr4[TournamentStep.DECK_BUILDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr4[TournamentStep.IN_ROUNDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr4[TournamentStep.FINAL_STANDINGS.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr4[TournamentStep.DRAFTING.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            $EnumSwitchMapping$3 = iArr4;
        }
    }

    private final void addPairingsForTable(Tournament tournament, DraftTable table, Round intoRound) {
        int i = 2;
        if (table.getPlayers().size() % 2 == 0) {
            int size = table.getPlayers().size() / 2;
            for (int i2 = 0; i2 < size; i2++) {
                Pairing pairing = new Pairing(null, null, null, 0, 0, 31, null);
                pairing.setFirstPlayerId(table.getPlayers().get(i2).getId());
                pairing.setFirstPlayerScore(0);
                pairing.setSecondPlayerId(table.getPlayers().get(size + i2).getId());
                pairing.setSecondPlayerScore(0);
                intoRound.getPairings().add(pairing);
            }
            return;
        }
        TournamentPlayer tournamentPlayer = (TournamentPlayer) CollectionsKt.last((List) table.getPlayers());
        List mutableList = CollectionsKt.toMutableList((Collection) table.getPlayers());
        if (tournamentPlayer != null) {
            mutableList.remove(tournamentPlayer);
            int size2 = mutableList.size() / 2;
            for (int i3 = 0; i3 < size2; i3++) {
                Pairing pairing2 = new Pairing(null, null, null, 0, 0, 31, null);
                pairing2.setFirstPlayerId(((TournamentPlayer) mutableList.get(i3)).getId());
                pairing2.setFirstPlayerScore(0);
                pairing2.setSecondPlayerId(((TournamentPlayer) mutableList.get(size2 + i3)).getId());
                pairing2.setSecondPlayerScore(0);
                intoRound.getPairings().add(pairing2);
            }
            Pairing pairing3 = new Pairing(null, null, null, 0, 0, 31, null);
            pairing3.setFirstPlayerId(tournamentPlayer.getId());
            int i4 = WhenMappings.$EnumSwitchMapping$1[tournament.getMatchType().ordinal()];
            if (i4 == 1) {
                i = 1;
            } else if (i4 != 2) {
                i = 3;
                if (i4 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
            }
            pairing3.setFirstPlayerScore(i);
            pairing3.setSecondPlayerId("");
            pairing3.setSecondPlayerScore(0);
            intoRound.getPairings().add(pairing3);
            tournament.getByes().add(tournamentPlayer.getId());
        }
    }

    private final Round createFirstRandomPairings(Tournament it) {
        Round round = new Round(null, false, null, 7, null);
        List mutableList = CollectionsKt.toMutableList((Collection) it.getPlayers());
        int i = 2;
        if (it.getPlayers().size() % 2 == 0) {
            int size = it.getPlayers().size() / 2;
            for (int i2 = 0; i2 < size; i2++) {
                List list = mutableList;
                TournamentPlayer tournamentPlayer = (TournamentPlayer) CollectionsKt.random(list, Random.INSTANCE);
                if (tournamentPlayer != null) {
                    mutableList.remove(tournamentPlayer);
                    TournamentPlayer tournamentPlayer2 = (TournamentPlayer) CollectionsKt.random(list, Random.INSTANCE);
                    if (tournamentPlayer2 != null) {
                        mutableList.remove(tournamentPlayer2);
                        Pairing pairing = new Pairing(null, null, null, 0, 0, 31, null);
                        pairing.setFirstPlayerId(tournamentPlayer.getId());
                        pairing.setFirstPlayerScore(0);
                        pairing.setSecondPlayerId(tournamentPlayer2.getId());
                        pairing.setSecondPlayerScore(0);
                        round.getPairings().add(pairing);
                    }
                }
            }
        } else {
            List list2 = mutableList;
            TournamentPlayer tournamentPlayer3 = (TournamentPlayer) CollectionsKt.random(list2, Random.INSTANCE);
            if (tournamentPlayer3 != null) {
                mutableList.remove(tournamentPlayer3);
                int size2 = list2.size() / 2;
                for (int i3 = 0; i3 < size2; i3++) {
                    TournamentPlayer tournamentPlayer4 = (TournamentPlayer) CollectionsKt.random(list2, Random.INSTANCE);
                    if (tournamentPlayer4 != null) {
                        mutableList.remove(tournamentPlayer4);
                        TournamentPlayer tournamentPlayer5 = (TournamentPlayer) CollectionsKt.random(list2, Random.INSTANCE);
                        if (tournamentPlayer5 != null) {
                            mutableList.remove(tournamentPlayer5);
                            Pairing pairing2 = new Pairing(null, null, null, 0, 0, 31, null);
                            pairing2.setFirstPlayerId(tournamentPlayer4.getId());
                            pairing2.setFirstPlayerScore(0);
                            pairing2.setSecondPlayerId(tournamentPlayer5.getId());
                            pairing2.setSecondPlayerScore(0);
                            round.getPairings().add(pairing2);
                        }
                    }
                }
                Pairing pairing3 = new Pairing(null, null, null, 0, 0, 31, null);
                pairing3.setFirstPlayerId(tournamentPlayer3.getId());
                int i4 = WhenMappings.$EnumSwitchMapping$1[it.getMatchType().ordinal()];
                if (i4 == 1) {
                    i = 1;
                } else if (i4 != 2) {
                    i = 3;
                    if (i4 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                pairing3.setFirstPlayerScore(i);
                pairing3.setSecondPlayerId("");
                pairing3.setSecondPlayerScore(0);
                round.getPairings().add(pairing3);
                it.getByes().add(tournamentPlayer3.getId());
            }
        }
        return round;
    }

    private final void createNextRoundPairings(Tournament tournament, List<StandingsRow> standings) {
        TournamentPlayer tournamentPlayer;
        String str;
        int i = WhenMappings.$EnumSwitchMapping$2[tournament.getPairingType().ordinal()];
        int i2 = 3;
        if (i != 1) {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            TournamentUtils companion = TournamentUtils.INSTANCE.getInstance();
            tournament.getRounds().get(tournament.getCurrentRound());
            Round round = new Round(null, false, null, 7, null);
            ArrayList arrayList = new ArrayList();
            Iterator<StandingsRow> it = standings.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getPlayer().getId());
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : standings) {
                StandingsRow standingsRow = (StandingsRow) obj;
                if (standingsRow.getPlayer().getDroppedAfterRound() >= 0 && standingsRow.getPlayer().getDroppedAfterRound() <= tournament.getCurrentRound()) {
                    arrayList2.add(obj);
                }
            }
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                arrayList.remove(((StandingsRow) it2.next()).getPlayer().getId());
            }
            if (arrayList.size() % 2 != 0) {
                int size = arrayList.size() - 1;
                while (true) {
                    if (-1 >= size) {
                        str = null;
                        break;
                    }
                    str = arrayList.get(size);
                    if (!companion.playerHasBye(tournament, str)) {
                        break;
                    } else {
                        size--;
                    }
                }
                if (str == null) {
                    str = (String) CollectionsKt.last((List) arrayList);
                }
                if (str != null) {
                    arrayList.remove(str);
                    Pairing pairing = new Pairing(null, null, null, 0, 0, 31, null);
                    pairing.setFirstPlayerId(str);
                    int i3 = WhenMappings.$EnumSwitchMapping$1[tournament.getMatchType().ordinal()];
                    if (i3 == 1) {
                        i2 = 1;
                    } else if (i3 == 2) {
                        i2 = 2;
                    } else if (i3 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    pairing.setFirstPlayerScore(i2);
                    pairing.setSecondPlayerId("");
                    pairing.setSecondPlayerScore(0);
                    round.getPairings().add(pairing);
                    tournament.getByes().add(str);
                }
            }
            if (!createPairingsRecursive(tournament, arrayList, round, companion)) {
                createPairingsWithRematch(tournament, arrayList, round);
            }
            tournament.getRounds().add(round);
            tournament.setCurrentRound(tournament.getCurrentRound() + 1);
            return;
        }
        Round round2 = tournament.getRounds().get(tournament.getCurrentRound());
        Round round3 = new Round(null, false, null, 7, null);
        int size2 = (round2.getPairings().size() * 2) / 2;
        ArrayList arrayList3 = new ArrayList();
        for (int i4 = 0; i4 < size2; i4++) {
            arrayList3.add(standings.get(i4).getPlayer());
        }
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : arrayList3) {
            TournamentPlayer tournamentPlayer2 = (TournamentPlayer) obj2;
            if (tournamentPlayer2.getDroppedAfterRound() >= 0 && tournamentPlayer2.getDroppedAfterRound() <= tournament.getCurrentRound()) {
                arrayList4.add(obj2);
            }
        }
        Iterator it3 = arrayList4.iterator();
        while (it3.hasNext()) {
            arrayList3.remove((TournamentPlayer) it3.next());
        }
        int size3 = arrayList3.size();
        if (size3 % 2 == 0) {
            int i5 = size3 / 2;
            for (int i6 = 0; i6 < i5; i6++) {
                Pairing pairing2 = new Pairing(null, null, null, 0, 0, 31, null);
                int i7 = i6 * 2;
                pairing2.setFirstPlayerId(((TournamentPlayer) arrayList3.get(i7)).getId());
                pairing2.setSecondPlayerId(((TournamentPlayer) arrayList3.get(i7 + 1)).getId());
                round3.getPairings().add(pairing2);
            }
        } else {
            TournamentUtils companion2 = TournamentUtils.INSTANCE.getInstance();
            int size4 = arrayList3.size() - 1;
            while (true) {
                if (-1 >= size4) {
                    tournamentPlayer = null;
                    break;
                }
                TournamentPlayer tournamentPlayer3 = (TournamentPlayer) arrayList3.get(size4);
                if (!companion2.playerHasBye(tournament, tournamentPlayer3.getId())) {
                    tournamentPlayer = tournamentPlayer3;
                    break;
                }
                size4--;
            }
            if (tournamentPlayer == null) {
                tournamentPlayer = (TournamentPlayer) CollectionsKt.last((List) arrayList3);
            }
            TournamentPlayer tournamentPlayer4 = tournamentPlayer;
            if (tournamentPlayer4 != null) {
                arrayList3.remove(tournamentPlayer4);
                int size5 = arrayList3.size() / 2;
                for (int i8 = 0; i8 < size5; i8++) {
                    Pairing pairing3 = new Pairing(null, null, null, 0, 0, 31, null);
                    int i9 = i8 * 2;
                    pairing3.setFirstPlayerId(((TournamentPlayer) arrayList3.get(i9)).getId());
                    pairing3.setSecondPlayerId(((TournamentPlayer) arrayList3.get(i9 + 1)).getId());
                    round3.getPairings().add(pairing3);
                }
                Pairing pairing4 = new Pairing(null, null, null, 0, 0, 31, null);
                pairing4.setFirstPlayerId(tournamentPlayer4.getId());
                int i10 = WhenMappings.$EnumSwitchMapping$1[tournament.getMatchType().ordinal()];
                if (i10 == 1) {
                    i2 = 1;
                } else if (i10 == 2) {
                    i2 = 2;
                } else if (i10 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                pairing4.setFirstPlayerScore(i2);
                pairing4.setSecondPlayerId("");
                pairing4.setSecondPlayerScore(0);
                round3.getPairings().add(pairing4);
                tournament.getByes().add(tournamentPlayer4.getId());
            }
        }
        tournament.getRounds().add(round3);
        tournament.setCurrentRound(tournament.getCurrentRound() + 1);
    }

    private final boolean createPairingsRecursive(Tournament tournament, List<String> playerPool, Round newRound, TournamentUtils utils) {
        if (playerPool.isEmpty()) {
            return true;
        }
        String str = playerPool.get(0);
        int size = playerPool.size();
        for (int i = 1; i < size; i++) {
            String str2 = playerPool.get(i);
            if (!utils.playersHaveMet(tournament, str, str2)) {
                Pairing pairing = new Pairing(null, null, null, 0, 0, 31, null);
                pairing.setFirstPlayerId(str);
                pairing.setSecondPlayerId(str2);
                newRound.getPairings().add(pairing);
                playerPool.remove(str);
                playerPool.remove(str2);
                if (createPairingsRecursive(tournament, playerPool, newRound, utils)) {
                    return true;
                }
                newRound.getPairings().remove(pairing);
                playerPool.add(0, str);
                playerPool.add(i, str2);
            }
        }
        return false;
    }

    private final void createPairingsWithRematch(Tournament tournament, List<String> playerPool, Round newRound) {
        while (playerPool.size() >= 2) {
            String str = playerPool.get(0);
            String str2 = playerPool.get(1);
            Pairing pairing = new Pairing(null, null, null, 0, 0, 31, null);
            pairing.setFirstPlayerId(str);
            pairing.setSecondPlayerId(str2);
            newRound.getPairings().add(pairing);
            playerPool.remove(str);
            playerPool.remove(str2);
        }
    }

    @JvmStatic
    public static final EventContentFragment newInstance() {
        return INSTANCE.newInstance();
    }

    static final boolean onViewCreated$lambda$0(View view, MotionEvent motionEvent) {
        return true;
    }

    static final Unit onViewCreated$lambda$2(final EventContentFragment eventContentFragment, final PreferencesManager preferencesManager) {
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = eventContentFragment.getString(R.string.are_you_sure_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string);
        String string2 = eventContentFragment.getString(R.string.delete_tournament_body);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder positiveButtonRed = title.setBody(string2).setPositiveButtonRed();
        String string3 = eventContentFragment.getString(R.string.delete);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButton = positiveButtonRed.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.EventContentFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return EventContentFragment.onViewCreated$lambda$2$0(preferencesManager, eventContentFragment, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        String string4 = eventContentFragment.getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.EventContentFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EventContentFragment.onViewCreated$lambda$2$1((CustomDialogFragment) obj);
            }
        });
        FragmentManager childFragmentManager = eventContentFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        negativeButton.show(childFragmentManager, "CustomDialogFragment");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$2$0(PreferencesManager preferencesManager, EventContentFragment eventContentFragment, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        preferencesManager.clearCurrentTournament();
        ContentCallback contentCallback = eventContentFragment.callback;
        if (contentCallback != null) {
            contentCallback.clearCurrentTournament();
        }
        Fragment fragment = new Fragment();
        FragmentTransaction fragmentTransactionBeginTransaction = eventContentFragment.getChildFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction(...)");
        fragmentTransactionBeginTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransactionBeginTransaction.commit();
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$2$1(CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    private final void setupSeekBar(Tournament it) {
        if (this._binding == null) {
            return;
        }
        SeekBar seekBar = getBinding().seekBar;
        Intrinsics.checkNotNullExpressionValue(seekBar, "seekBar");
        int i = WhenMappings.$EnumSwitchMapping$3[it.getTournamentStep().ordinal()];
        if (i == 1) {
            getBinding().labelTextView.setText(getString(R.string.deck_building));
            if (it.getEventType() == EventType.SEALED) {
                seekBar.setProgress(0);
            } else {
                seekBar.setProgress(1);
            }
        } else if (i == 2) {
            TextView textView = getBinding().labelTextView;
            String string = getString(R.string.round_x_of_y);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            textView.setText(StringsKt.replace$default(StringsKt.replace$default(string, "{0}", String.valueOf(it.getCurrentRound() + 1), false, 4, (Object) null), "{1}", String.valueOf(it.getNumberOfRounds()), false, 4, (Object) null));
            int i2 = WhenMappings.$EnumSwitchMapping$0[it.getEventType().ordinal()];
            if (i2 == 1) {
                seekBar.setProgress(it.getCurrentRound());
            } else if (i2 == 2) {
                seekBar.setProgress(it.getCurrentRound() + 1);
            } else {
                if (i2 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                seekBar.setProgress(it.getCurrentRound() + 2);
            }
        } else if (i == 3) {
            getBinding().labelTextView.setText(getString(R.string.standings));
            seekBar.setProgress(seekBar.getMax());
        } else if (i == 4) {
            getBinding().labelTextView.setText(getString(R.string.draft));
        }
        if (this.isFinals) {
            getBinding().labelTextView.setText(getString(R.string.finals));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00d1  */
    @Override // com.studiolaganne.lengendarylens.EventContentCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void createFinals(int top, MatchType matchType) {
        Intrinsics.checkNotNullParameter(matchType, "matchType");
        if (getContext() == null) {
            return;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("event_create_finals");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("event_create_finals", null);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        TournamentUtils companion = TournamentUtils.INSTANCE.getInstance();
        Tournament currentTournament = preferencesManager.getCurrentTournament();
        if (currentTournament == null || currentTournament.getPlayers().size() < top) {
            return;
        }
        List<StandingsRow> currentStandings = companion.getCurrentStandings(currentTournament);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < top; i++) {
            arrayList.add(currentStandings.get(i).getPlayer());
        }
        preferencesManager.clearCurrentTournament();
        Tournament tournament = new Tournament(null, 0, null, 0, null, null, null, 0, 0, false, 0L, null, null, null, 0, null, false, 131071, null);
        tournament.setEventType(EventType.CONSTRUCTED);
        tournament.setMatchType(matchType);
        tournament.setPairingType(PairingType.SINGLE_ELIMINATION);
        tournament.setPlayers(arrayList);
        int i2 = 3;
        tournament.setSetupStep(3);
        tournament.setTournamentStep(TournamentStep.IN_ROUNDS);
        tournament.setCurrentRound(0);
        tournament.setRoundTimer(50);
        if (top == 2) {
            i2 = 1;
        } else if (top == 4) {
            i2 = 2;
        } else if (top != 8) {
            if (top == 16) {
                i2 = 4;
            }
        }
        tournament.setNumberOfRounds(i2);
        Round round = new Round(null, false, null, 7, null);
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size() / 2;
        for (int i3 = 0; i3 < size; i3++) {
            Pairing pairing = new Pairing(null, null, null, 0, 0, 31, null);
            pairing.setFirstPlayerId(arrayList.get(i3).getId());
            pairing.setSecondPlayerId(arrayList.get((arrayList2.size() - 1) - i3).getId());
            round.getPairings().add(pairing);
        }
        tournament.getRounds().add(round);
        preferencesManager.saveCurrentTournament(tournament);
        Breadcrumbs.INSTANCE.leaveBreadcrumb("new_finals");
        FirebaseAnalytics firebaseAnalytics2 = FirebaseAnalytics.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics2, "getInstance(...)");
        firebaseAnalytics2.logEvent("new_finals", null);
        EventPairingsFragment eventPairingsFragmentNewInstance = EventPairingsFragment.INSTANCE.newInstance();
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction(...)");
        fragmentTransactionBeginTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
        fragmentTransactionBeginTransaction.replace(R.id.fragment_container, eventPairingsFragmentNewInstance);
        fragmentTransactionBeginTransaction.commit();
        this.isFinals = true;
        getBinding().seekBar.setMax(tournament.getNumberOfRounds());
        setupSeekBar(tournament);
    }

    public final FragmentEventContentBinding getBinding() {
        FragmentEventContentBinding fragmentEventContentBinding = this._binding;
        Intrinsics.checkNotNull(fragmentEventContentBinding);
        return fragmentEventContentBinding;
    }

    public final ContentCallback getCallback() {
        return this.callback;
    }

    /* JADX INFO: renamed from: isFinals, reason: from getter */
    public final boolean getIsFinals() {
        return this.isFinals;
    }

    @Override // com.studiolaganne.lengendarylens.EventContentCallback
    public void moveToDeckBuilding() {
        if (getContext() == null) {
            return;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("event_move_to_deck_building");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("event_move_to_deck_building", null);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        Tournament currentTournament = preferencesManager.getCurrentTournament();
        if (currentTournament != null) {
            currentTournament.setTournamentStep(TournamentStep.DECK_BUILDING);
            preferencesManager.saveCurrentTournament(currentTournament);
            EventDeckBuildingFragment eventDeckBuildingFragmentNewInstance = EventDeckBuildingFragment.INSTANCE.newInstance();
            FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
            Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction(...)");
            fragmentTransactionBeginTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
            fragmentTransactionBeginTransaction.replace(R.id.fragment_container, eventDeckBuildingFragmentNewInstance);
            fragmentTransactionBeginTransaction.commit();
            setupSeekBar(currentTournament);
        }
    }

    @Override // com.studiolaganne.lengendarylens.EventContentCallback
    public void moveToRoundOne(boolean load) {
        if (getContext() == null) {
            return;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("event_move_to_round_one");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("event_move_to_round_one", null);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        Tournament currentTournament = preferencesManager.getCurrentTournament();
        if (currentTournament != null) {
            currentTournament.setTournamentStep(TournamentStep.IN_ROUNDS);
            currentTournament.setCurrentRound(0);
            int i = WhenMappings.$EnumSwitchMapping$0[currentTournament.getEventType().ordinal()];
            if (i == 1 || i == 2) {
                currentTournament.getRounds().add(createFirstRandomPairings(currentTournament));
            } else {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                if (currentTournament.getAllowCrossTablePairings()) {
                    currentTournament.getRounds().add(createFirstRandomPairings(currentTournament));
                } else {
                    Round round = new Round(null, false, null, 7, null);
                    Iterator<DraftTable> it = currentTournament.getTables().iterator();
                    while (it.hasNext()) {
                        addPairingsForTable(currentTournament, it.next(), round);
                    }
                    currentTournament.getRounds().add(round);
                }
            }
            preferencesManager.saveCurrentTournament(currentTournament);
            if (load) {
                EventPairingsFragment eventPairingsFragmentNewInstance = EventPairingsFragment.INSTANCE.newInstance();
                FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
                Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction(...)");
                fragmentTransactionBeginTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
                fragmentTransactionBeginTransaction.replace(R.id.fragment_container, eventPairingsFragmentNewInstance);
                fragmentTransactionBeginTransaction.commit();
            }
            setupSeekBar(currentTournament);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getArguments();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentEventContentBinding.inflate(inflater, container, false);
        return getBinding().getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Fragment fragmentNewInstance;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        SeekBar seekBar = getBinding().seekBar;
        Intrinsics.checkNotNullExpressionValue(seekBar, "seekBar");
        seekBar.setProgress(0);
        seekBar.setClickable(false);
        seekBar.setFocusable(false);
        seekBar.setFocusableInTouchMode(false);
        seekBar.setOnTouchListener(new View.OnTouchListener() { // from class: com.studiolaganne.lengendarylens.EventContentFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return EventContentFragment.onViewCreated$lambda$0(view2, motionEvent);
            }
        });
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        Tournament currentTournament = preferencesManager.getCurrentTournament();
        Fragment fragmentNewInstance2 = EventDraftFragment.INSTANCE.newInstance();
        if (currentTournament != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[currentTournament.getEventType().ordinal()];
            if (i == 1) {
                seekBar.setMax(currentTournament.getNumberOfRounds());
            } else if (i == 2) {
                seekBar.setMax(currentTournament.getNumberOfRounds() + 1);
            } else {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                seekBar.setMax(currentTournament.getNumberOfRounds() + 2);
            }
            setupSeekBar(currentTournament);
            int i2 = WhenMappings.$EnumSwitchMapping$3[currentTournament.getTournamentStep().ordinal()];
            if (i2 == 1) {
                fragmentNewInstance = EventDeckBuildingFragment.INSTANCE.newInstance();
            } else if (i2 == 2) {
                if (currentTournament.getCurrentRound() == 0 && currentTournament.getRounds().isEmpty()) {
                    moveToRoundOne(false);
                }
                fragmentNewInstance = EventPairingsFragment.INSTANCE.newInstance();
            } else if (i2 == 3) {
                fragmentNewInstance = EventStandingsFragment.INSTANCE.newInstance();
            }
            fragmentNewInstance2 = fragmentNewInstance;
        }
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction(...)");
        fragmentTransactionBeginTransaction.replace(R.id.fragment_container, fragmentNewInstance2);
        fragmentTransactionBeginTransaction.commit();
        ImageView closeButton = getBinding().closeButton;
        Intrinsics.checkNotNullExpressionValue(closeButton, "closeButton");
        ViewExtensionsKt.setOnClickWithFade(closeButton, new Function0() { // from class: com.studiolaganne.lengendarylens.EventContentFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EventContentFragment.onViewCreated$lambda$2(this.f$0, preferencesManager);
            }
        });
    }

    public final void setCallback(ContentCallback contentCallback) {
        this.callback = contentCallback;
    }

    public final void setFinals(boolean z) {
        this.isFinals = z;
    }

    @Override // com.studiolaganne.lengendarylens.EventContentCallback
    public void submitStandings() {
        if (getContext() == null) {
            return;
        }
        Breadcrumbs.INSTANCE.leaveBreadcrumb("event_submit_standings");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        firebaseAnalytics.logEvent("event_submit_standings", null);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        Tournament currentTournament = preferencesManager.getCurrentTournament();
        if (currentTournament != null) {
            currentTournament.getRounds().get(currentTournament.getCurrentRound()).setFinal(true);
            if (currentTournament.getCurrentRound() < currentTournament.getNumberOfRounds() - 1) {
                createNextRoundPairings(currentTournament, TournamentUtils.INSTANCE.getInstance().getCurrentStandings(currentTournament));
            } else {
                currentTournament.setTournamentStep(TournamentStep.FINAL_STANDINGS);
                Breadcrumbs.INSTANCE.leaveBreadcrumb("event_complete");
                FirebaseAnalytics firebaseAnalytics2 = FirebaseAnalytics.getInstance(requireContext());
                Intrinsics.checkNotNullExpressionValue(firebaseAnalytics2, "getInstance(...)");
                firebaseAnalytics2.logEvent("event_complete", null);
            }
            preferencesManager.saveCurrentTournament(currentTournament);
            if (currentTournament.getTournamentStep() == TournamentStep.FINAL_STANDINGS) {
                EventStandingsFragment eventStandingsFragmentNewInstance = EventStandingsFragment.INSTANCE.newInstance();
                FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
                Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction(...)");
                fragmentTransactionBeginTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
                fragmentTransactionBeginTransaction.replace(R.id.fragment_container, eventStandingsFragmentNewInstance);
                fragmentTransactionBeginTransaction.commit();
            } else {
                EventPairingsFragment eventPairingsFragmentNewInstance = EventPairingsFragment.INSTANCE.newInstance();
                FragmentTransaction fragmentTransactionBeginTransaction2 = getChildFragmentManager().beginTransaction();
                Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction2, "beginTransaction(...)");
                fragmentTransactionBeginTransaction2.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
                fragmentTransactionBeginTransaction2.replace(R.id.fragment_container, eventPairingsFragmentNewInstance);
                fragmentTransactionBeginTransaction2.commit();
            }
            setupSeekBar(currentTournament);
        }
    }
}
