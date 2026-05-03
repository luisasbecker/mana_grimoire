package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.activity.result.ActivityResultCaller;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.studiolaganne.lengendarylens.MatchMenuDialogFragment;
import com.studiolaganne.lengendarylens.TimerLeftFragment;
import com.studiolaganne.lengendarylens.databinding.FragmentGame2PlayersType2Binding;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: GameFragment2PlayersType2.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 12\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\fH\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\b\u0010\u0014\u001a\u00020\fH\u0016J\b\u0010\u0015\u001a\u00020\fH\u0016J\b\u0010\u0016\u001a\u00020\fH\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016J\u0018\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\fH\u0016J\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010!\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u001a\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020$2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J&\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020\u001fH\u0016J\b\u0010,\u001a\u00020\fH\u0016J\u0010\u0010-\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010.\u001a\u00020\fH\u0016J\b\u0010/\u001a\u00020\fH\u0016J\b\u00100\u001a\u00020\fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/studiolaganne/lengendarylens/GameFragment2PlayersType2;", "Lcom/studiolaganne/lengendarylens/GameFragmentBase;", "<init>", "()V", "_binding", "Lcom/studiolaganne/lengendarylens/databinding/FragmentGame2PlayersType2Binding;", "binding", "getBinding", "()Lcom/studiolaganne/lengendarylens/databinding/FragmentGame2PlayersType2Binding;", "callback", "Lcom/studiolaganne/lengendarylens/GameCallback;", "onAttach", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "tutorialComplete", "gameFinished", "nonSyncableGameFinished", "showStartGameButton", "hideStartGameButton", "hideBestOfScore", "showBestOfScore", "player1Score", "", "player2Score", "showBestOfHelp", "dayNightToggled", "isOn", "", "planechaseToggled", "archenemyToggled", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onHiddenChanged", "hidden", "onDestroyView", "commanderDamageToggled", "showLifeHistory", "hideLifeHistory", "updateLifeHistory", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GameFragment2PlayersType2 extends GameFragmentBase {
    private FragmentGame2PlayersType2Binding _binding;
    private GameCallback callback;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: GameFragment2PlayersType2.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/studiolaganne/lengendarylens/GameFragment2PlayersType2$Companion;", "", "<init>", "()V", "newInstance", "Lcom/studiolaganne/lengendarylens/GameFragment2PlayersType2;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final GameFragment2PlayersType2 newInstance() {
            return new GameFragment2PlayersType2();
        }
    }

    @JvmStatic
    public static final GameFragment2PlayersType2 newInstance() {
        return INSTANCE.newInstance();
    }

    static final void onCreateView$lambda$0(View view) {
    }

    static final Unit onCreateView$lambda$1(GameFragment2PlayersType2 gameFragment2PlayersType2) {
        if (gameFragment2PlayersType2.getContext() == null) {
            return Unit.INSTANCE;
        }
        gameFragment2PlayersType2.showPlanechaseUI();
        return Unit.INSTANCE;
    }

    static final void onCreateView$lambda$13(GameFragment2PlayersType2 gameFragment2PlayersType2) {
        gameFragment2PlayersType2.poisonCounterToggled(gameFragment2PlayersType2.getSharedViewModel().getGameState().getHasPoisonCounters());
        gameFragment2PlayersType2.commanderDamageToggled(gameFragment2PlayersType2.getSharedViewModel().getGameState().getHasCommanderDamage());
    }

    static final Unit onCreateView$lambda$2(GameFragment2PlayersType2 gameFragment2PlayersType2) {
        if (gameFragment2PlayersType2.getContext() == null) {
            return Unit.INSTANCE;
        }
        Context contextRequireContext = gameFragment2PlayersType2.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        if (gameFragment2PlayersType2.getSharedViewModel().getGameState().isDay()) {
            gameFragment2PlayersType2.getSharedViewModel().getGameState().setDay(false);
            gameFragment2PlayersType2.getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.Night.getValue(), 0, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
            gameFragment2PlayersType2.getBinding().dayNightImageView.setImageResource(R.drawable.moon);
        } else {
            gameFragment2PlayersType2.getSharedViewModel().getGameState().setDay(true);
            gameFragment2PlayersType2.getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.Day.getValue(), 0, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
            gameFragment2PlayersType2.getBinding().dayNightImageView.setImageResource(R.drawable.sun);
        }
        preferencesManager.saveCurrentGame(gameFragment2PlayersType2.getSharedViewModel().getGameState());
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$4(GameFragment2PlayersType2 gameFragment2PlayersType2) {
        if (gameFragment2PlayersType2.getContext() == null) {
            return Unit.INSTANCE;
        }
        gameFragment2PlayersType2.getSharedViewModel().getGameState().setStartedAt(GameUtils.INSTANCE.getInstance().getCurrentTimestamp());
        Context contextRequireContext = gameFragment2PlayersType2.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        new PreferencesManager(contextRequireContext).saveCurrentGame(gameFragment2PlayersType2.getSharedViewModel().getGameState());
        GameCallback gameCallback = gameFragment2PlayersType2.callback;
        if (gameCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            gameCallback = null;
        }
        gameCallback.startGamePressed();
        return Unit.INSTANCE;
    }

    static final void onCreateView$lambda$5(final GameFragment2PlayersType2 gameFragment2PlayersType2, View view) {
        gameFragment2PlayersType2.getBinding().menuButtonBlack.animate().scaleX(1.2f).scaleY(1.2f).setDuration(80L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment2PlayersType2$$ExternalSyntheticLambda22
            @Override // java.lang.Runnable
            public final void run() {
                GameFragment2PlayersType2.onCreateView$lambda$5$0(this.f$0);
            }
        });
        gameFragment2PlayersType2.getBinding().menuButtonWhite.animate().scaleX(1.2f).scaleY(1.2f).setDuration(80L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment2PlayersType2$$ExternalSyntheticLambda29
            @Override // java.lang.Runnable
            public final void run() {
                GameFragment2PlayersType2.onCreateView$lambda$5$1(this.f$0);
            }
        });
        gameFragment2PlayersType2.getBinding().menuButton.animate().scaleX(1.2f).scaleY(1.2f).setDuration(80L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment2PlayersType2$$ExternalSyntheticLambda30
            @Override // java.lang.Runnable
            public final void run() {
                GameFragment2PlayersType2.onCreateView$lambda$5$2(this.f$0);
            }
        });
        gameFragment2PlayersType2.getBinding().overlayView1.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment2PlayersType2$$ExternalSyntheticLambda31
            @Override // java.lang.Runnable
            public final void run() {
                GameFragment2PlayersType2.onCreateView$lambda$5$3(this.f$0);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$5$0(GameFragment2PlayersType2 gameFragment2PlayersType2) {
        gameFragment2PlayersType2.getBinding().menuButtonBlack.animate().scaleX(1.0f).scaleY(1.0f).setDuration(80L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$5$1(GameFragment2PlayersType2 gameFragment2PlayersType2) {
        gameFragment2PlayersType2.getBinding().menuButtonWhite.animate().scaleX(1.0f).scaleY(1.0f).setDuration(80L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$5$2(GameFragment2PlayersType2 gameFragment2PlayersType2) {
        gameFragment2PlayersType2.getBinding().menuButton.animate().scaleX(1.0f).scaleY(1.0f).setDuration(80L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$5$3(GameFragment2PlayersType2 gameFragment2PlayersType2) {
        GameCallback gameCallback = gameFragment2PlayersType2.callback;
        if (gameCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            gameCallback = null;
        }
        gameCallback.menuPressed();
    }

    static final Unit onCreateView$lambda$6(final GameFragment2PlayersType2 gameFragment2PlayersType2) {
        if (gameFragment2PlayersType2.getContext() == null || gameFragment2PlayersType2._binding == null) {
            return Unit.INSTANCE;
        }
        gameFragment2PlayersType2.getBinding().customMenuButtonImage.animate().scaleX(1.2f).scaleY(1.2f).setDuration(80L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment2PlayersType2$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                GameFragment2PlayersType2.onCreateView$lambda$6$0(this.f$0);
            }
        });
        gameFragment2PlayersType2.getBinding().overlayView1.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment2PlayersType2$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                GameFragment2PlayersType2.onCreateView$lambda$6$1(this.f$0);
            }
        }, 200L);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$6$0(GameFragment2PlayersType2 gameFragment2PlayersType2) {
        gameFragment2PlayersType2.getBinding().customMenuButtonImage.animate().scaleX(1.0f).scaleY(1.0f).setDuration(80L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$6$1(GameFragment2PlayersType2 gameFragment2PlayersType2) {
        GameCallback gameCallback = gameFragment2PlayersType2.callback;
        if (gameCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            gameCallback = null;
        }
        gameCallback.menuPressed();
    }

    static final void onCreateView$lambda$7(GameFragment2PlayersType2 gameFragment2PlayersType2) {
        String str;
        if (gameFragment2PlayersType2.getSharedViewModel().getGameState().getTimerEnabled()) {
            int iTimeLeft = GameUtils.INSTANCE.getInstance().timeLeft(gameFragment2PlayersType2.getSharedViewModel().getGameState());
            int i = iTimeLeft / 60;
            int i2 = iTimeLeft % 60;
            if (i > 0) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                str = String.format("%dh %02dmin", Arrays.copyOf(new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}, 2));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            } else {
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                str = String.format("%02d min", Arrays.copyOf(new Object[]{Integer.valueOf(i2)}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            }
            TimerLeftFragment.Builder rotation = new TimerLeftFragment.Builder().setPositiveButton(new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment2PlayersType2$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment2PlayersType2.onCreateView$lambda$7$0((TimerLeftFragment) obj);
                }
            }).setText(str).setRotation(270);
            FragmentManager childFragmentManager = gameFragment2PlayersType2.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            rotation.show(childFragmentManager, "TimerLeftFragment");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$7$0(TimerLeftFragment it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.dismiss();
        return Unit.INSTANCE;
    }

    static final boolean onCreateView$lambda$8(GameFragment2PlayersType2 gameFragment2PlayersType2, Handler handler, Runnable runnable, View view, MotionEvent motionEvent) {
        if (gameFragment2PlayersType2.getContext() != null) {
            FragmentGame2PlayersType2Binding fragmentGame2PlayersType2Binding = gameFragment2PlayersType2._binding;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            handler.postDelayed(runnable, 500L);
            return true;
        }
        if (action != 1) {
            if (action != 3) {
                return false;
            }
            handler.removeCallbacks(runnable);
            return true;
        }
        handler.removeCallbacks(runnable);
        if (motionEvent.getEventTime() - motionEvent.getDownTime() < 200) {
            view.performClick();
        }
        return true;
    }

    static final Unit onCreateView$lambda$9(final GameFragment2PlayersType2 gameFragment2PlayersType2) {
        new MatchMenuDialogFragment.Builder().setRotation(90).setPlayer1ConcedeButtonCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment2PlayersType2$$ExternalSyntheticLambda34
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GameFragment2PlayersType2.onCreateView$lambda$9$0(this.f$0, (MatchMenuDialogFragment) obj);
            }
        }).setPlayer1DrawButtonCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment2PlayersType2$$ExternalSyntheticLambda35
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GameFragment2PlayersType2.onCreateView$lambda$9$1(this.f$0, (MatchMenuDialogFragment) obj);
            }
        }).setPlayer1WinButtonCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment2PlayersType2$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GameFragment2PlayersType2.onCreateView$lambda$9$2(this.f$0, (MatchMenuDialogFragment) obj);
            }
        }).setPlayer1LoseButtonCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment2PlayersType2$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GameFragment2PlayersType2.onCreateView$lambda$9$3(this.f$0, (MatchMenuDialogFragment) obj);
            }
        }).setPlayer2ConcedeButtonCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment2PlayersType2$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GameFragment2PlayersType2.onCreateView$lambda$9$4(this.f$0, (MatchMenuDialogFragment) obj);
            }
        }).setPlayer2DrawButtonCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment2PlayersType2$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GameFragment2PlayersType2.onCreateView$lambda$9$5(this.f$0, (MatchMenuDialogFragment) obj);
            }
        }).setPlayer2WinButtonCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment2PlayersType2$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GameFragment2PlayersType2.onCreateView$lambda$9$6(this.f$0, (MatchMenuDialogFragment) obj);
            }
        }).setPlayer2LoseButtonCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment2PlayersType2$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GameFragment2PlayersType2.onCreateView$lambda$9$7(this.f$0, (MatchMenuDialogFragment) obj);
            }
        }).setEndGameButtonCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment2PlayersType2$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GameFragment2PlayersType2.onCreateView$lambda$9$8(this.f$0, (MatchMenuDialogFragment) obj);
            }
        }).setSaveEnabled(gameFragment2PlayersType2.getSharedViewModel().getGameState().getGameSyncable()).build().show(gameFragment2PlayersType2.getChildFragmentManager(), "match_menu_dialog");
        Unit unit = Unit.INSTANCE;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$9$0(GameFragment2PlayersType2 gameFragment2PlayersType2, final MatchMenuDialogFragment it) {
        Intrinsics.checkNotNullParameter(it, "it");
        View view = it.getView();
        if (view != null) {
            view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment2PlayersType2$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    it.dismiss();
                }
            }, 300L);
        }
        gameFragment2PlayersType2.getBinding().lifeTotalView1.triggerPlayerDeadQ("concede", true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$9$1(GameFragment2PlayersType2 gameFragment2PlayersType2, final MatchMenuDialogFragment it) {
        Intrinsics.checkNotNullParameter(it, "it");
        View view = it.getView();
        if (view != null) {
            view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment2PlayersType2$$ExternalSyntheticLambda17
                @Override // java.lang.Runnable
                public final void run() {
                    it.dismiss();
                }
            }, 300L);
        }
        gameFragment2PlayersType2.getBinding().lifeTotalView1.triggerPlayerDeadQ("draw", true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$9$2(GameFragment2PlayersType2 gameFragment2PlayersType2, final MatchMenuDialogFragment it) {
        Intrinsics.checkNotNullParameter(it, "it");
        View view = it.getView();
        if (view != null) {
            view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment2PlayersType2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    it.dismiss();
                }
            }, 300L);
        }
        gameFragment2PlayersType2.getBinding().lifeTotalView1.triggerPlayerWinQ();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$9$3(GameFragment2PlayersType2 gameFragment2PlayersType2, final MatchMenuDialogFragment it) {
        Intrinsics.checkNotNullParameter(it, "it");
        View view = it.getView();
        if (view != null) {
            view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment2PlayersType2$$ExternalSyntheticLambda14
                @Override // java.lang.Runnable
                public final void run() {
                    it.dismiss();
                }
            }, 300L);
        }
        gameFragment2PlayersType2.getBinding().lifeTotalView1.triggerPlayerDeadQ("", true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$9$4(GameFragment2PlayersType2 gameFragment2PlayersType2, final MatchMenuDialogFragment it) {
        Intrinsics.checkNotNullParameter(it, "it");
        View view = it.getView();
        if (view != null) {
            view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment2PlayersType2$$ExternalSyntheticLambda33
                @Override // java.lang.Runnable
                public final void run() {
                    it.dismiss();
                }
            }, 300L);
        }
        gameFragment2PlayersType2.getBinding().lifeTotalView2.triggerPlayerDeadQ("concede", true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$9$5(GameFragment2PlayersType2 gameFragment2PlayersType2, final MatchMenuDialogFragment it) {
        Intrinsics.checkNotNullParameter(it, "it");
        View view = it.getView();
        if (view != null) {
            view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment2PlayersType2$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    it.dismiss();
                }
            }, 300L);
        }
        gameFragment2PlayersType2.getBinding().lifeTotalView2.triggerPlayerDeadQ("draw", true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$9$6(GameFragment2PlayersType2 gameFragment2PlayersType2, final MatchMenuDialogFragment it) {
        Intrinsics.checkNotNullParameter(it, "it");
        View view = it.getView();
        if (view != null) {
            view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment2PlayersType2$$ExternalSyntheticLambda15
                @Override // java.lang.Runnable
                public final void run() {
                    it.dismiss();
                }
            }, 300L);
        }
        gameFragment2PlayersType2.getBinding().lifeTotalView2.triggerPlayerWinQ();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$9$7(GameFragment2PlayersType2 gameFragment2PlayersType2, final MatchMenuDialogFragment it) {
        Intrinsics.checkNotNullParameter(it, "it");
        View view = it.getView();
        if (view != null) {
            view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment2PlayersType2$$ExternalSyntheticLambda32
                @Override // java.lang.Runnable
                public final void run() {
                    it.dismiss();
                }
            }, 300L);
        }
        gameFragment2PlayersType2.getBinding().lifeTotalView2.triggerPlayerDeadQ("", true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$9$8(GameFragment2PlayersType2 gameFragment2PlayersType2, final MatchMenuDialogFragment it) {
        Intrinsics.checkNotNullParameter(it, "it");
        View view = it.getView();
        if (view != null) {
            view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment2PlayersType2$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    it.dismiss();
                }
            }, 300L);
        }
        GameCallback gameCallback = gameFragment2PlayersType2.callback;
        if (gameCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            gameCallback = null;
        }
        gameCallback.gameForceUpload();
        return Unit.INSTANCE;
    }

    static final void onViewCreated$lambda$1(GameFragment2PlayersType2 gameFragment2PlayersType2) {
        if (gameFragment2PlayersType2._binding == null) {
            return;
        }
        if (gameFragment2PlayersType2.getSharedViewModel().getGameState().isDay()) {
            gameFragment2PlayersType2.getBinding().dayNightImageView.setImageResource(R.drawable.sun);
        } else {
            gameFragment2PlayersType2.getBinding().dayNightImageView.setImageResource(R.drawable.moon);
        }
        gameFragment2PlayersType2.dayNightToggled(gameFragment2PlayersType2.getSharedViewModel().getGameState().getHasDayNight());
    }

    @Override // com.studiolaganne.lengendarylens.GameFragmentBase
    public void archenemyToggled(boolean isOn) {
        if (this._binding == null) {
            return;
        }
        if (!isOn) {
            getBinding().planechaseBkg.setVisibility(8);
            getBinding().planechaseImageView.setVisibility(8);
        } else {
            getBinding().planechaseImageView.setImageResource(R.drawable.archenemy);
            getBinding().planechaseBkg.setVisibility(0);
            getBinding().planechaseImageView.setVisibility(0);
        }
    }

    @Override // com.studiolaganne.lengendarylens.GameFragmentBase
    public void commanderDamageToggled(boolean isOn) {
        if (getContext() == null) {
            return;
        }
        super.commanderDamageToggled(isOn);
        GameUtils companion = GameUtils.INSTANCE.getInstance();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        int iDpToPx = companion.dpToPx(80, contextRequireContext);
        GameUtils companion2 = GameUtils.INSTANCE.getInstance();
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        int iDpToPx2 = companion2.dpToPx(32, contextRequireContext2);
        if (isOn) {
            ViewGroup.LayoutParams layoutParams = getBinding().player1EventsRecyclerView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            layoutParams2.setMargins(layoutParams2.leftMargin, iDpToPx, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            getBinding().player1EventsRecyclerView.setLayoutParams(layoutParams2);
            ViewGroup.LayoutParams layoutParams3 = getBinding().player2EventsRecyclerView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
            layoutParams4.setMargins(layoutParams4.leftMargin, layoutParams4.topMargin, layoutParams4.rightMargin, iDpToPx);
            getBinding().player2EventsRecyclerView.setLayoutParams(layoutParams4);
            return;
        }
        ViewGroup.LayoutParams layoutParams5 = getBinding().player1EventsRecyclerView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams5, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) layoutParams5;
        layoutParams6.setMargins(layoutParams6.leftMargin, iDpToPx2, layoutParams6.rightMargin, layoutParams6.bottomMargin);
        getBinding().player1EventsRecyclerView.setLayoutParams(layoutParams6);
        ViewGroup.LayoutParams layoutParams7 = getBinding().player2EventsRecyclerView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams7, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams8 = (ConstraintLayout.LayoutParams) layoutParams7;
        layoutParams8.setMargins(layoutParams8.leftMargin, layoutParams8.topMargin, layoutParams8.rightMargin, iDpToPx2);
        getBinding().player2EventsRecyclerView.setLayoutParams(layoutParams8);
    }

    @Override // com.studiolaganne.lengendarylens.GameFragmentBase
    public void dayNightToggled(boolean isOn) {
        if (this._binding == null) {
            return;
        }
        if (isOn) {
            getBinding().dayNightBkg.setVisibility(0);
            getBinding().dayNightImageView.setVisibility(0);
        } else {
            getBinding().dayNightBkg.setVisibility(8);
            getBinding().dayNightImageView.setVisibility(8);
        }
    }

    @Override // com.studiolaganne.lengendarylens.GameFragmentBase
    public void gameFinished() {
        GameCallback gameCallback = this.callback;
        if (gameCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            gameCallback = null;
        }
        gameCallback.gameFinished();
    }

    public final FragmentGame2PlayersType2Binding getBinding() {
        FragmentGame2PlayersType2Binding fragmentGame2PlayersType2Binding = this._binding;
        Intrinsics.checkNotNull(fragmentGame2PlayersType2Binding);
        return fragmentGame2PlayersType2Binding;
    }

    @Override // com.studiolaganne.lengendarylens.GameFragmentBase
    public void hideBestOfScore() {
        if (this._binding == null) {
            return;
        }
        getBinding().bestOfResultLayout.setVisibility(8);
    }

    @Override // com.studiolaganne.lengendarylens.GameFragmentBase
    public void hideLifeHistory() {
        if (getContext() == null || this._binding == null) {
            return;
        }
        super.hideLifeHistory();
        getBinding().player1EventsRecyclerView.setVisibility(8);
        getBinding().player2EventsRecyclerView.setVisibility(8);
    }

    @Override // com.studiolaganne.lengendarylens.GameFragmentBase
    public void hideStartGameButton() {
        if (this._binding == null) {
            return;
        }
        getBinding().startGameButtonLayout.setVisibility(8);
        showMenu();
        showMenu();
    }

    @Override // com.studiolaganne.lengendarylens.GameFragmentBase
    public void nonSyncableGameFinished() {
        GameCallback gameCallback = this.callback;
        if (gameCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            gameCallback = null;
        }
        gameCallback.nonSyncableGameFinished();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        try {
            ActivityResultCaller parentFragment = getParentFragment();
            Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.studiolaganne.lengendarylens.GameCallback");
            this.callback = (GameCallback) parentFragment;
        } catch (ClassCastException unused) {
        }
    }

    @Override // com.studiolaganne.lengendarylens.GameFragmentBase, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0278  */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String borderColor;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentGame2PlayersType2Binding.inflate(inflater, container, false);
        getBinding().constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.GameFragment2PlayersType2$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GameFragment2PlayersType2.onCreateView$lambda$0(view);
            }
        });
        getBinding().planechaseBkg.setOutlineProvider(new CircularOutlineProvider());
        getBinding().planechaseBkg.setClipToOutline(true);
        ImageView planechaseImageView = getBinding().planechaseImageView;
        Intrinsics.checkNotNullExpressionValue(planechaseImageView, "planechaseImageView");
        ViewExtensionsKt.setOnClickWithFade(planechaseImageView, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragment2PlayersType2$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameFragment2PlayersType2.onCreateView$lambda$1(this.f$0);
            }
        });
        getBinding().dayNightBkg.setOutlineProvider(new CircularOutlineProvider());
        getBinding().dayNightBkg.setClipToOutline(true);
        ImageView dayNightImageView = getBinding().dayNightImageView;
        Intrinsics.checkNotNullExpressionValue(dayNightImageView, "dayNightImageView");
        ViewExtensionsKt.setOnClickWithFade(dayNightImageView, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragment2PlayersType2$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameFragment2PlayersType2.onCreateView$lambda$2(this.f$0);
            }
        });
        SkinManager companion = SkinManager.INSTANCE.getInstance();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        SkinDefinition currentSkinDefinition = companion.getCurrentSkinDefinition(contextRequireContext);
        Unit unit = null;
        if (currentSkinDefinition != null && (borderColor = currentSkinDefinition.getBorderColor()) != null) {
            int colorFromHex = SkinManager.INSTANCE.getInstance().getColorFromHex(borderColor);
            if (((int) ((((double) ((colorFromHex >> 16) & 255)) * 0.299d) + (((double) ((colorFromHex >> 8) & 255)) * 0.587d) + (((double) (colorFromHex & 255)) * 0.114d))) < 17) {
                colorFromHex = ContextCompat.getColor(requireContext(), R.color.almost_white);
            }
            Drawable background = getBinding().startGameButtonLayout.getBackground();
            Drawable drawableMutate = background != null ? background.mutate() : null;
            GradientDrawable gradientDrawable = drawableMutate instanceof GradientDrawable ? (GradientDrawable) drawableMutate : null;
            if (gradientDrawable != null) {
                GameUtils companion2 = GameUtils.INSTANCE.getInstance();
                Context contextRequireContext2 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                gradientDrawable.setStroke(companion2.dpToPx(2, contextRequireContext2), colorFromHex);
                getBinding().startGameButtonLayout.setBackground(gradientDrawable);
            }
        }
        ConstraintLayout startGameButtonLayout = getBinding().startGameButtonLayout;
        Intrinsics.checkNotNullExpressionValue(startGameButtonLayout, "startGameButtonLayout");
        ViewExtensionsKt.setOnClickWithFade(startGameButtonLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragment2PlayersType2$$ExternalSyntheticLambda21
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameFragment2PlayersType2.onCreateView$lambda$4(this.f$0);
            }
        });
        getBinding().overlayView1.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.GameFragment2PlayersType2$$ExternalSyntheticLambda23
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GameFragment2PlayersType2.onCreateView$lambda$5(this.f$0, view);
            }
        });
        getBinding().customMenuButtonImage.setOnNonTransparentClickListener(new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragment2PlayersType2$$ExternalSyntheticLambda24
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameFragment2PlayersType2.onCreateView$lambda$6(this.f$0);
            }
        });
        final Handler handler = new Handler(Looper.getMainLooper());
        final Runnable runnable = new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment2PlayersType2$$ExternalSyntheticLambda25
            @Override // java.lang.Runnable
            public final void run() {
                GameFragment2PlayersType2.onCreateView$lambda$7(this.f$0);
            }
        };
        getBinding().overlayView1.setOnTouchListener(new View.OnTouchListener() { // from class: com.studiolaganne.lengendarylens.GameFragment2PlayersType2$$ExternalSyntheticLambda26
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return GameFragment2PlayersType2.onCreateView$lambda$8(this.f$0, handler, runnable, view, motionEvent);
            }
        });
        ConstraintLayout bestOfResultLayout = getBinding().bestOfResultLayout;
        Intrinsics.checkNotNullExpressionValue(bestOfResultLayout, "bestOfResultLayout");
        ViewExtensionsKt.setOnClickWithBounce(bestOfResultLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragment2PlayersType2$$ExternalSyntheticLambda27
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameFragment2PlayersType2.onCreateView$lambda$9(this.f$0);
            }
        });
        List<LifeTotalView> lifeViews = getLifeViews();
        LifeTotalView lifeTotalView1 = getBinding().lifeTotalView1;
        Intrinsics.checkNotNullExpressionValue(lifeTotalView1, "lifeTotalView1");
        lifeViews.add(lifeTotalView1);
        List<LifeTotalView> lifeViews2 = getLifeViews();
        LifeTotalView lifeTotalView2 = getBinding().lifeTotalView2;
        Intrinsics.checkNotNullExpressionValue(lifeTotalView2, "lifeTotalView2");
        lifeViews2.add(lifeTotalView2);
        setupLifeViews();
        getBinding().backgroundImage.setVisibility(8);
        SkinManager companion3 = SkinManager.INSTANCE.getInstance();
        Context contextRequireContext3 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
        SkinDefinition currentSkinDefinition2 = companion3.getCurrentSkinDefinition(contextRequireContext3);
        if (currentSkinDefinition2 != null) {
            Integer extraMargin = currentSkinDefinition2.getExtraMargin();
            if (extraMargin != null) {
                extraMargin.intValue();
                ViewGroup.LayoutParams layoutParams = getBinding().lifeTotalView1.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                layoutParams2.setMargins(0, 0, 0, 0);
                getBinding().lifeTotalView1.setLayoutParams(layoutParams2);
                getBinding().lifeTotalView1.setRightMarginMultiplier(0.5f);
                getBinding().lifeTotalView1.refreshMargins();
                ViewGroup.LayoutParams layoutParams3 = getBinding().lifeTotalView2.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
                layoutParams4.setMargins(0, 0, 0, 0);
                getBinding().lifeTotalView2.setLayoutParams(layoutParams4);
                getBinding().lifeTotalView2.setLeftMarginMultiplier(0.5f);
                getBinding().lifeTotalView2.refreshMargins();
            }
            String backgroundImage = currentSkinDefinition2.getBackgroundImage();
            if (backgroundImage != null) {
                SkinManager companion4 = SkinManager.INSTANCE.getInstance();
                Context contextRequireContext4 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext4, "requireContext(...)");
                String currentSkinCode = companion4.getCurrentSkinCode(contextRequireContext4);
                SkinManager companion5 = SkinManager.INSTANCE.getInstance();
                Context contextRequireContext5 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext5, "requireContext(...)");
                Bitmap imageFromSkin = companion5.getImageFromSkin(contextRequireContext5, currentSkinCode, backgroundImage);
                if (imageFromSkin != null) {
                    getBinding().backgroundImage.setImageBitmap(TransformationUtils.rotateImage(imageFromSkin, 90));
                }
                getBinding().backgroundImage.setVisibility(0);
                Float backgroundAlpha = currentSkinDefinition2.getBackgroundAlpha();
                if (backgroundAlpha != null) {
                    getBinding().backgroundImage.setAlpha(backgroundAlpha.floatValue());
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    getBinding().backgroundImage.setVisibility(8);
                }
            }
        }
        getBinding().player1EventsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        List<LifeHistoryEntry> lifeHistoryEntries = GameUtils.INSTANCE.getInstance().getLifeHistoryEntries(getSharedViewModel().getGameState(), 0);
        getBinding().player1EventsRecyclerView.setAdapter(new LifeHistoryAdapter(lifeHistoryEntries, 90));
        RecyclerView.Adapter adapter = getBinding().player1EventsRecyclerView.getAdapter();
        if (adapter != null) {
            getBinding().player1EventsRecyclerView.scrollToPosition(adapter.getItemCount() - 1);
        }
        getBinding().player2EventsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, true));
        List<LifeHistoryEntry> lifeHistoryEntries2 = GameUtils.INSTANCE.getInstance().getLifeHistoryEntries(getSharedViewModel().getGameState(), 1);
        getBinding().player2EventsRecyclerView.setAdapter(new LifeHistoryAdapter(lifeHistoryEntries2, 270));
        RecyclerView.Adapter adapter2 = getBinding().player2EventsRecyclerView.getAdapter();
        if (adapter2 != null) {
            getBinding().player2EventsRecyclerView.scrollToPosition(adapter2.getItemCount() - 1);
        }
        View view = getView();
        if (view != null) {
            view.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment2PlayersType2$$ExternalSyntheticLambda28
                @Override // java.lang.Runnable
                public final void run() {
                    GameFragment2PlayersType2.onCreateView$lambda$13(this.f$0);
                }
            });
        }
        Context contextRequireContext6 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext6, "requireContext(...)");
        if (new PreferencesManager(contextRequireContext6).getBoolean(PreferencesManager.DISPLAY_GAME_EVENTS, true)) {
            if (!lifeHistoryEntries.isEmpty()) {
                getBinding().player1EventsRecyclerView.setVisibility(0);
            }
            if (!lifeHistoryEntries2.isEmpty()) {
                getBinding().player2EventsRecyclerView.setVisibility(0);
            }
        } else {
            getBinding().player1EventsRecyclerView.setVisibility(8);
            getBinding().player2EventsRecyclerView.setVisibility(8);
        }
        FragmentReadyListener fragmentReadyListener = getFragmentReadyListener();
        if (fragmentReadyListener != null) {
            fragmentReadyListener.onFragmentReady();
        }
        return getBinding().getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        if (new PreferencesManager(contextRequireContext).getBoolean(PreferencesManager.DISPLAY_GAME_EVENTS, true)) {
            List<LifeHistoryEntry> lifeHistoryEntries = GameUtils.INSTANCE.getInstance().getLifeHistoryEntries(getSharedViewModel().getGameState(), 0);
            getBinding().player1EventsRecyclerView.setAdapter(new LifeHistoryAdapter(lifeHistoryEntries, 90));
            List<LifeHistoryEntry> lifeHistoryEntries2 = GameUtils.INSTANCE.getInstance().getLifeHistoryEntries(getSharedViewModel().getGameState(), 1);
            getBinding().player2EventsRecyclerView.setAdapter(new LifeHistoryAdapter(lifeHistoryEntries2, 270));
            if (!lifeHistoryEntries.isEmpty()) {
                getBinding().player1EventsRecyclerView.setVisibility(0);
            }
            if (!lifeHistoryEntries2.isEmpty()) {
                getBinding().player2EventsRecyclerView.setVisibility(0);
            }
        } else {
            getBinding().player1EventsRecyclerView.setVisibility(8);
            getBinding().player2EventsRecyclerView.setVisibility(8);
        }
        poisonCounterToggled(getSharedViewModel().getGameState().getHasPoisonCounters());
        commanderDamageToggled(getSharedViewModel().getGameState().getHasCommanderDamage());
    }

    @Override // com.studiolaganne.lengendarylens.GameFragmentBase, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if ((!getSharedViewModel().getGameState().getTimerEnabled() || getSharedViewModel().getGameState().getTimerTotalTime() <= 0) && !getSharedViewModel().getGameState().getTurnTimerEnabled()) {
            hideClock();
        } else {
            int value = 0;
            boolean z = (getSharedViewModel().getGameState().getPlaygroupId() == -1 && !getSharedViewModel().getGameState().getGameSyncable()) || (getSharedViewModel().getGameState().getUsersSeated() && !getSharedViewModel().getGameState().getDecksSelected());
            if (getSharedViewModel().getGameState().getTurnTimerEnabled() && !getSharedViewModel().getGameState().getTurnTimerPromptDismissed()) {
                z = false;
            }
            if (z && getSharedViewModel().getGameState().getTurnTimerEnabled()) {
                showTurnCounterUI(getSharedViewModel().getGameState().getCurrentGameTurn());
                long currentTurnStartTime = getSharedViewModel().getGameState().getCurrentTurnStartTime();
                long jCurrentTimeMillis = System.currentTimeMillis();
                int currentTurnPauseTime = getSharedViewModel().getGameState().getCurrentTurnPauseTime();
                if (getSharedViewModel().getGameState().getTimerPaused()) {
                    currentTurnPauseTime += (int) ((System.currentTimeMillis() - getSharedViewModel().getGameState().getTimerPausedAt()) / 1000);
                }
                long j = ((jCurrentTimeMillis - currentTurnStartTime) / 1000) - ((long) currentTurnPauseTime);
                for (MTGameEvent mTGameEvent : getSharedViewModel().getGameState().getEvents()) {
                    if (Intrinsics.areEqual(mTGameEvent.getType(), MTEvent.TurnEnd.getValue()) && mTGameEvent.getPlayerid() == getSharedViewModel().getGameState().getCurrentTurnPlayerIndex()) {
                        value += mTGameEvent.getValue();
                    }
                }
                if (getSharedViewModel().getGameState().getCurrentTurnPlayerIndex() >= 0 && getSharedViewModel().getGameState().getCurrentTurnPlayerIndex() < getLifeViews().size()) {
                    getLifeViews().get(getSharedViewModel().getGameState().getCurrentTurnPlayerIndex()).setIsCurrentPlayerTurn(true, value);
                    getLifeViews().get(getSharedViewModel().getGameState().getCurrentTurnPlayerIndex()).updateCurrentTurnTime((int) j);
                }
            }
            if (z) {
                showClock();
                Context context = getContext();
                if (context != null && !new PreferencesManager(context).getBoolean(PreferencesManager.AUTO_START_TIMER, true)) {
                    toggleTimerPause();
                }
            } else {
                hideClock();
            }
        }
        View view2 = getView();
        if (view2 != null) {
            view2.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment2PlayersType2$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    GameFragment2PlayersType2.onViewCreated$lambda$1(this.f$0);
                }
            });
        }
    }

    @Override // com.studiolaganne.lengendarylens.GameFragmentBase
    public void planechaseToggled(boolean isOn) {
        if (this._binding == null) {
            return;
        }
        if (!isOn) {
            getBinding().planechaseBkg.setVisibility(8);
            getBinding().planechaseImageView.setVisibility(8);
        } else {
            getBinding().planechaseImageView.setImageResource(R.drawable.planechase);
            getBinding().planechaseBkg.setVisibility(0);
            getBinding().planechaseImageView.setVisibility(0);
        }
    }

    @Override // com.studiolaganne.lengendarylens.GameFragmentBase
    public void showBestOfHelp() {
    }

    @Override // com.studiolaganne.lengendarylens.GameFragmentBase
    public void showBestOfScore(int player1Score, int player2Score) {
        String borderColor;
        if (this._binding == null) {
            return;
        }
        SkinManager companion = SkinManager.INSTANCE.getInstance();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        SkinDefinition currentSkinDefinition = companion.getCurrentSkinDefinition(contextRequireContext);
        if (currentSkinDefinition != null && (borderColor = currentSkinDefinition.getBorderColor()) != null) {
            int colorFromHex = SkinManager.INSTANCE.getInstance().getColorFromHex(borderColor);
            if (((int) ((((double) ((colorFromHex >> 16) & 255)) * 0.299d) + (((double) ((colorFromHex >> 8) & 255)) * 0.587d) + (((double) (colorFromHex & 255)) * 0.114d))) < 17) {
                colorFromHex = ContextCompat.getColor(requireContext(), R.color.almost_white);
            }
            Drawable background = getBinding().bestOfResultLayout.getBackground();
            Drawable drawableMutate = background != null ? background.mutate() : null;
            GradientDrawable gradientDrawable = drawableMutate instanceof GradientDrawable ? (GradientDrawable) drawableMutate : null;
            if (gradientDrawable != null) {
                GameUtils companion2 = GameUtils.INSTANCE.getInstance();
                Context contextRequireContext2 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                gradientDrawable.setStroke(companion2.dpToPx(2, contextRequireContext2), colorFromHex);
                getBinding().bestOfResultLayout.setBackground(gradientDrawable);
            }
        }
        getBinding().bestOfResultLayout.setVisibility(0);
        getBinding().scoreBottomTextView.setText(String.valueOf(player1Score));
        getBinding().scoreTopTextView.setText(String.valueOf(player2Score));
        if (player1Score > 0) {
            getBinding().scoreBottomTextView.setTextColor(ContextCompat.getColor(requireContext(), R.color.selected_color_new));
        } else {
            getBinding().scoreBottomTextView.setTextColor(ContextCompat.getColor(requireContext(), R.color.text_color));
        }
        if (player2Score > 0) {
            getBinding().scoreTopTextView.setTextColor(ContextCompat.getColor(requireContext(), R.color.selected_color_new));
        } else {
            getBinding().scoreTopTextView.setTextColor(ContextCompat.getColor(requireContext(), R.color.text_color));
        }
    }

    @Override // com.studiolaganne.lengendarylens.GameFragmentBase
    public void showLifeHistory() {
        if (getContext() == null || this._binding == null) {
            return;
        }
        super.showLifeHistory();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        if (new PreferencesManager(contextRequireContext).getBoolean(PreferencesManager.DISPLAY_GAME_EVENTS, true)) {
            getBinding().player1EventsRecyclerView.setVisibility(0);
            getBinding().player2EventsRecyclerView.setVisibility(0);
        } else {
            getBinding().player1EventsRecyclerView.setVisibility(8);
            getBinding().player2EventsRecyclerView.setVisibility(8);
        }
    }

    @Override // com.studiolaganne.lengendarylens.GameFragmentBase
    public void showStartGameButton() {
        if (this._binding == null) {
            return;
        }
        getBinding().startGameButtonLayout.setVisibility(0);
        hideMenu();
    }

    @Override // com.studiolaganne.lengendarylens.GameFragmentBase
    public void tutorialComplete() {
        GameCallback gameCallback = this.callback;
        if (gameCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            gameCallback = null;
        }
        gameCallback.tutorialComplete();
    }

    @Override // com.studiolaganne.lengendarylens.GameFragmentBase
    public void updateLifeHistory() {
        if (getContext() == null || this._binding == null) {
            return;
        }
        super.updateLifeHistory();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        boolean z = new PreferencesManager(contextRequireContext).getBoolean(PreferencesManager.DISPLAY_GAME_EVENTS, true);
        List<LifeHistoryEntry> lifeHistoryEntries = GameUtils.INSTANCE.getInstance().getLifeHistoryEntries(getSharedViewModel().getGameState(), 0);
        getBinding().player1EventsRecyclerView.setAdapter(new LifeHistoryAdapter(lifeHistoryEntries, 90));
        RecyclerView.Adapter adapter = getBinding().player1EventsRecyclerView.getAdapter();
        if (adapter != null) {
            getBinding().player1EventsRecyclerView.scrollToPosition(adapter.getItemCount() - 1);
        }
        if (lifeHistoryEntries.isEmpty() || !z) {
            getBinding().player1EventsRecyclerView.setVisibility(8);
        } else {
            getBinding().player1EventsRecyclerView.setVisibility(0);
        }
        List<LifeHistoryEntry> lifeHistoryEntries2 = GameUtils.INSTANCE.getInstance().getLifeHistoryEntries(getSharedViewModel().getGameState(), 1);
        getBinding().player2EventsRecyclerView.setAdapter(new LifeHistoryAdapter(lifeHistoryEntries2, 270));
        RecyclerView.Adapter adapter2 = getBinding().player2EventsRecyclerView.getAdapter();
        if (adapter2 != null) {
            getBinding().player2EventsRecyclerView.scrollToPosition(adapter2.getItemCount() - 1);
        }
        if (lifeHistoryEntries2.isEmpty() || !z) {
            getBinding().player2EventsRecyclerView.setVisibility(8);
        } else {
            getBinding().player2EventsRecyclerView.setVisibility(0);
        }
    }
}
