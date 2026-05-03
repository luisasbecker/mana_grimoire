package com.studiolaganne.lengendarylens;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.DurationKt;

/* JADX INFO: compiled from: GameFragmentBase.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/studiolaganne/lengendarylens/GameFragmentBase$clockRunnable$1", "Ljava/lang/Runnable;", "run", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GameFragmentBase$clockRunnable$1 implements Runnable {
    final /* synthetic */ GameFragmentBase this$0;

    GameFragmentBase$clockRunnable$1(GameFragmentBase gameFragmentBase) {
        this.this$0 = gameFragmentBase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit run$lambda$2$0(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        int iIntValue;
        int iIntValue2;
        boolean timerPaused = this.this$0.getSharedViewModel().getGameState().getTimerPaused();
        GameFragmentBase gameFragmentBase = this.this$0;
        if (timerPaused) {
            gameFragmentBase.clockHandler.postDelayed(this, 1000L);
            return;
        }
        gameFragmentBase.updateClock();
        int iTimeLeft = GameUtils.INSTANCE.getInstance().timeLeft(this.this$0.getSharedViewModel().getGameState());
        if (this.this$0.getShowSeconds()) {
            iTimeLeft = GameUtils.INSTANCE.getInstance().timeLeftSeconds(this.this$0.getSharedViewModel().getGameState());
        }
        if (this.this$0.getSharedViewModel().getGameState().getTurnTimerEnabled()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long currentTurnStartTime = this.this$0.getSharedViewModel().getGameState().getCurrentTurnStartTime();
            int currentTurnPauseTime = this.this$0.getSharedViewModel().getGameState().getCurrentTurnPauseTime();
            if (this.this$0.getSharedViewModel().getGameState().getTimerPaused()) {
                currentTurnPauseTime += (int) ((System.currentTimeMillis() - this.this$0.getSharedViewModel().getGameState().getTimerPausedAt()) / 1000);
            }
            final long j = ((jCurrentTimeMillis - currentTurnStartTime) / 1000) - ((long) currentTurnPauseTime);
            if (this.this$0.getSharedViewModel().getGameState().getSubformatId() == 10) {
                int currentGameTurn = this.this$0.getSharedViewModel().getGameState().getCurrentGameTurn();
                int iIntValue3 = (currentGameTurn < GameUtils.INSTANCE.getBlitzTimePerTurn().size() ? GameUtils.INSTANCE.getBlitzTimePerTurn().get(currentGameTurn).intValue() : ((Number) CollectionsKt.last((List) GameUtils.INSTANCE.getBlitzTimePerTurn())).intValue()) - ((int) j);
                if (iIntValue3 < 0) {
                    int iAbs = Math.abs(iIntValue3);
                    if (this.this$0.currentTurnPenaltyIndex < GameUtils.INSTANCE.getBlitzPenaltyTimeOffsets().size()) {
                        iIntValue = GameUtils.INSTANCE.getBlitzPenaltyTimeOffsets().get(this.this$0.currentTurnPenaltyIndex).intValue();
                        iIntValue2 = GameUtils.INSTANCE.getBlitzPenaltyLifeOffsets().get(this.this$0.currentTurnPenaltyIndex).intValue();
                        z = false;
                    } else {
                        z = true;
                        iIntValue = 0;
                        iIntValue2 = 0;
                    }
                    int currentTurnPlayerIndex = this.this$0.getSharedViewModel().getGameState().getCurrentTurnPlayerIndex();
                    if (currentTurnPlayerIndex >= 0 && currentTurnPlayerIndex < this.this$0.getLifeViews().size()) {
                        int lifeTotal = this.this$0.getSharedViewModel().getGameState().getPlayers().get(currentTurnPlayerIndex).getLifeTotal();
                        if (z) {
                            if (this.this$0.currentPenaltyTimeOffset != iAbs && lifeTotal >= 1) {
                                this.this$0.currentPenaltyTimeOffset = iAbs;
                                int i = lifeTotal - 1;
                                this.this$0.getLifeViews().get(currentTurnPlayerIndex).setLifeTotal(i);
                                GameFragmentBase gameFragmentBase2 = this.this$0;
                                gameFragmentBase2.lifeTotalChangeCommitted(gameFragmentBase2.getLifeViews().get(currentTurnPlayerIndex), -1);
                                this.this$0.getSoundPool().play(this.this$0.penaltySoundId, 0.1f, 0.1f, 0, 0, 1.0f);
                                if (i <= 0) {
                                    GameFragmentBase gameFragmentBase3 = this.this$0;
                                    gameFragmentBase3.confirmPlayerDeath(gameFragmentBase3.getLifeViews().get(currentTurnPlayerIndex), false);
                                }
                            }
                        } else if (iAbs >= iIntValue) {
                            int i2 = lifeTotal - iIntValue2;
                            this.this$0.getLifeViews().get(currentTurnPlayerIndex).setLifeTotal(i2);
                            GameFragmentBase gameFragmentBase4 = this.this$0;
                            gameFragmentBase4.lifeTotalChangeCommitted(gameFragmentBase4.getLifeViews().get(currentTurnPlayerIndex), -iIntValue2);
                            this.this$0.currentTurnPenaltyIndex++;
                            this.this$0.getSoundPool().play(this.this$0.penaltySoundId, 0.5f, 0.5f, 0, 0, 1.0f);
                            if (i2 <= 0) {
                                GameFragmentBase gameFragmentBase5 = this.this$0;
                                gameFragmentBase5.confirmPlayerDeath(gameFragmentBase5.getLifeViews().get(currentTurnPlayerIndex), false);
                            }
                        }
                    }
                }
            }
            int currentTurnPlayerIndex2 = this.this$0.getSharedViewModel().getGameState().getCurrentTurnPlayerIndex();
            if (currentTurnPlayerIndex2 >= 0 && currentTurnPlayerIndex2 < this.this$0.getLifeViews().size()) {
                if (this.this$0.getSharedViewModel().getGameState().getSubformatId() == 5) {
                    if (currentTurnPlayerIndex2 == 0 || currentTurnPlayerIndex2 == 3) {
                        LifeTotalView lifeViewTeam1 = this.this$0.getLifeViewTeam1();
                        if (lifeViewTeam1 != null) {
                            lifeViewTeam1.updateCurrentTurnTime((int) j);
                        }
                    } else {
                        LifeTotalView lifeViewTeam2 = this.this$0.getLifeViewTeam2();
                        if (lifeViewTeam2 != null) {
                            lifeViewTeam2.updateCurrentTurnTime((int) j);
                        }
                    }
                } else if (this.this$0.getSharedViewModel().getGameState().getSubformatId() != 6) {
                    LifeTotalView lifeTotalView = this.this$0.getLifeViews().get(this.this$0.getSharedViewModel().getGameState().getCurrentTurnPlayerIndex());
                    final GameFragmentBase gameFragmentBase6 = this.this$0;
                    lifeTotalView.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$clockRunnable$1$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            GameFragmentBase gameFragmentBase7 = gameFragmentBase6;
                            gameFragmentBase7.getLifeViews().get(gameFragmentBase7.getSharedViewModel().getGameState().getCurrentTurnPlayerIndex()).updateCurrentTurnTime((int) j);
                        }
                    });
                } else if (currentTurnPlayerIndex2 == 0 || currentTurnPlayerIndex2 == 1 || currentTurnPlayerIndex2 == 5) {
                    LifeTotalView lifeViewTeam12 = this.this$0.getLifeViewTeam1();
                    if (lifeViewTeam12 != null) {
                        lifeViewTeam12.updateCurrentTurnTime((int) j);
                    }
                } else {
                    LifeTotalView lifeViewTeam22 = this.this$0.getLifeViewTeam2();
                    if (lifeViewTeam22 != null) {
                        lifeViewTeam22.updateCurrentTurnTime((int) j);
                    }
                }
            }
        }
        if (iTimeLeft == 0 && !this.this$0.clockExpired && this.this$0.getSharedViewModel().getGameState().getTimerEnabled()) {
            this.this$0.clockExpired = true;
            this.this$0.getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.TimerExpire.getValue(), 0, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
            Context context = this.this$0.getContext();
            if (context != null) {
                new PreferencesManager(context).saveCurrentGame(this.this$0.getSharedViewModel().getGameState());
            }
            this.this$0.updateStreamingState$app_release();
            if (this.this$0.getContext() != null) {
                GameFragmentBase gameFragmentBase7 = this.this$0;
                if (gameFragmentBase7.isDetached() || gameFragmentBase7.isRemoving() || gameFragmentBase7.instanceSaved) {
                    return;
                }
                CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
                String string = gameFragmentBase7.getString(R.string.string_clock_expired_title);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                CustomDialogFragment.Builder title = builder.setTitle(string);
                String string2 = gameFragmentBase7.getString(R.string.string_clock_expired);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                CustomDialogFragment.Builder body = title.setBody(string2);
                String string3 = gameFragmentBase7.getString(R.string.internet_error_button);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.GameFragmentBase$clockRunnable$1$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return GameFragmentBase$clockRunnable$1.run$lambda$2$0(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
                    }
                });
                FragmentManager childFragmentManager = gameFragmentBase7.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
                positiveButton.show(childFragmentManager, "CustomDialogFragment");
            }
            if (!this.this$0.getSharedViewModel().getGameState().getTurnTimerEnabled()) {
                return;
            }
        }
        if (this.this$0.getShowSeconds() || this.this$0.getSharedViewModel().getGameState().getTurnTimerEnabled()) {
            this.this$0.clockHandler.postDelayed(this, 1000L);
        } else {
            this.this$0.clockHandler.postDelayed(this, DurationKt.MILLIS_IN_MINUTE);
        }
    }
}
