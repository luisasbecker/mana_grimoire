package com.studiolaganne.lengendarylens;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b'\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)¨\u0006*"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTEvent;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "LifeOffset", "CommanderDamage", "PartnerDamage", "PlayerStart", "PlayerLose", "PlayerWin", "Poison", "Energy", "Storm", "TimerStart", "TimerExpire", "Monarch", "FlipCoin", "RollD4", "RollD6", "RollD8", "RollD10", "RollD12", "RollD20", "TreacheryRole", "GameDraw", "PlayerConcede", "PlayerToss", "Day", "Night", "TurnStart", "TurnEnd", "Experience", "Tax", "Radiation", "Initiative", "CityBlessing", "TheRing", "TaxPartner", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MTEvent {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MTEvent[] $VALUES;
    private final String value;
    public static final MTEvent LifeOffset = new MTEvent("LifeOffset", 0, "life-offset");
    public static final MTEvent CommanderDamage = new MTEvent("CommanderDamage", 1, "commander-damage");
    public static final MTEvent PartnerDamage = new MTEvent("PartnerDamage", 2, "partner-damage");
    public static final MTEvent PlayerStart = new MTEvent("PlayerStart", 3, "player-start");
    public static final MTEvent PlayerLose = new MTEvent("PlayerLose", 4, "player-lose");
    public static final MTEvent PlayerWin = new MTEvent("PlayerWin", 5, "player-win");
    public static final MTEvent Poison = new MTEvent("Poison", 6, "poison");
    public static final MTEvent Energy = new MTEvent("Energy", 7, "energy");
    public static final MTEvent Storm = new MTEvent("Storm", 8, "storm");
    public static final MTEvent TimerStart = new MTEvent("TimerStart", 9, "timer-start");
    public static final MTEvent TimerExpire = new MTEvent("TimerExpire", 10, "timer-expire");
    public static final MTEvent Monarch = new MTEvent("Monarch", 11, "monarch");
    public static final MTEvent FlipCoin = new MTEvent("FlipCoin", 12, "flip-coin");
    public static final MTEvent RollD4 = new MTEvent("RollD4", 13, "roll-d4");
    public static final MTEvent RollD6 = new MTEvent("RollD6", 14, "roll-d6");
    public static final MTEvent RollD8 = new MTEvent("RollD8", 15, "roll-d8");
    public static final MTEvent RollD10 = new MTEvent("RollD10", 16, "roll-d10");
    public static final MTEvent RollD12 = new MTEvent("RollD12", 17, "roll-d12");
    public static final MTEvent RollD20 = new MTEvent("RollD20", 18, "roll-d20");
    public static final MTEvent TreacheryRole = new MTEvent("TreacheryRole", 19, "treachery-role");
    public static final MTEvent GameDraw = new MTEvent("GameDraw", 20, "game-draw");
    public static final MTEvent PlayerConcede = new MTEvent("PlayerConcede", 21, "player-concede");
    public static final MTEvent PlayerToss = new MTEvent("PlayerToss", 22, "player-toss");
    public static final MTEvent Day = new MTEvent("Day", 23, "day");
    public static final MTEvent Night = new MTEvent("Night", 24, "night");
    public static final MTEvent TurnStart = new MTEvent("TurnStart", 25, "turn-start");
    public static final MTEvent TurnEnd = new MTEvent("TurnEnd", 26, "turn-end");
    public static final MTEvent Experience = new MTEvent("Experience", 27, "experience");
    public static final MTEvent Tax = new MTEvent("Tax", 28, FirebaseAnalytics.Param.TAX);
    public static final MTEvent Radiation = new MTEvent("Radiation", 29, "radiation");
    public static final MTEvent Initiative = new MTEvent("Initiative", 30, "initiative");
    public static final MTEvent CityBlessing = new MTEvent("CityBlessing", 31, "city-blessing");
    public static final MTEvent TheRing = new MTEvent("TheRing", 32, "the-ring");
    public static final MTEvent TaxPartner = new MTEvent("TaxPartner", 33, "taxPartner");

    private static final /* synthetic */ MTEvent[] $values() {
        return new MTEvent[]{LifeOffset, CommanderDamage, PartnerDamage, PlayerStart, PlayerLose, PlayerWin, Poison, Energy, Storm, TimerStart, TimerExpire, Monarch, FlipCoin, RollD4, RollD6, RollD8, RollD10, RollD12, RollD20, TreacheryRole, GameDraw, PlayerConcede, PlayerToss, Day, Night, TurnStart, TurnEnd, Experience, Tax, Radiation, Initiative, CityBlessing, TheRing, TaxPartner};
    }

    static {
        MTEvent[] mTEventArr$values = $values();
        $VALUES = mTEventArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(mTEventArr$values);
    }

    private MTEvent(String str, int i, String str2) {
        this.value = str2;
    }

    public static EnumEntries<MTEvent> getEntries() {
        return $ENTRIES;
    }

    public static MTEvent valueOf(String str) {
        return (MTEvent) Enum.valueOf(MTEvent.class, str);
    }

    public static MTEvent[] values() {
        return (MTEvent[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }
}
