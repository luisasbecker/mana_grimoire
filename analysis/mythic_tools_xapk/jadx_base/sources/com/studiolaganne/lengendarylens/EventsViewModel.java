package com.studiolaganne.lengendarylens;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: EventsFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\bR\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/studiolaganne/lengendarylens/EventsViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "eventType", "Landroidx/lifecycle/MutableLiveData;", "Lcom/studiolaganne/lengendarylens/EventType;", "getEventType", "()Landroidx/lifecycle/MutableLiveData;", "pairingType", "Lcom/studiolaganne/lengendarylens/PairingType;", "getPairingType", "matchType", "Lcom/studiolaganne/lengendarylens/MatchType;", "getMatchType", "numPlayers", "", "getNumPlayers", "players", "", "Lcom/studiolaganne/lengendarylens/TournamentPlayer;", "getPlayers", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EventsViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableLiveData<EventType> eventType = new MutableLiveData<>();
    private final MutableLiveData<PairingType> pairingType = new MutableLiveData<>();
    private final MutableLiveData<MatchType> matchType = new MutableLiveData<>();
    private final MutableLiveData<Integer> numPlayers = new MutableLiveData<>();
    private final MutableLiveData<List<TournamentPlayer>> players = new MutableLiveData<>();

    public final MutableLiveData<EventType> getEventType() {
        return this.eventType;
    }

    public final MutableLiveData<MatchType> getMatchType() {
        return this.matchType;
    }

    public final MutableLiveData<Integer> getNumPlayers() {
        return this.numPlayers;
    }

    public final MutableLiveData<PairingType> getPairingType() {
        return this.pairingType;
    }

    public final MutableLiveData<List<TournamentPlayer>> getPlayers() {
        return this.players;
    }
}
