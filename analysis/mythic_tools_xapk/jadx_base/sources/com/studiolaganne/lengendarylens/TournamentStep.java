package com.studiolaganne.lengendarylens;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: DataStructs.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/studiolaganne/lengendarylens/TournamentStep;", "", "<init>", "(Ljava/lang/String;I)V", "NOT_STARTED", "DRAFTING", "DECK_BUILDING", "IN_ROUNDS", "FINAL_STANDINGS", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TournamentStep {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TournamentStep[] $VALUES;
    public static final TournamentStep NOT_STARTED = new TournamentStep("NOT_STARTED", 0);
    public static final TournamentStep DRAFTING = new TournamentStep("DRAFTING", 1);
    public static final TournamentStep DECK_BUILDING = new TournamentStep("DECK_BUILDING", 2);
    public static final TournamentStep IN_ROUNDS = new TournamentStep("IN_ROUNDS", 3);
    public static final TournamentStep FINAL_STANDINGS = new TournamentStep("FINAL_STANDINGS", 4);

    private static final /* synthetic */ TournamentStep[] $values() {
        return new TournamentStep[]{NOT_STARTED, DRAFTING, DECK_BUILDING, IN_ROUNDS, FINAL_STANDINGS};
    }

    static {
        TournamentStep[] tournamentStepArr$values = $values();
        $VALUES = tournamentStepArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(tournamentStepArr$values);
    }

    private TournamentStep(String str, int i) {
    }

    public static EnumEntries<TournamentStep> getEntries() {
        return $ENTRIES;
    }

    public static TournamentStep valueOf(String str) {
        return (TournamentStep) Enum.valueOf(TournamentStep.class, str);
    }

    public static TournamentStep[] values() {
        return (TournamentStep[]) $VALUES.clone();
    }
}
