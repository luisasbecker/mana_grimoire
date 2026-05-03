package com.studiolaganne.lengendarylens;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import com.studiolaganne.lengendarylens.TimerTimeDialogFragment;
import com.studiolaganne.lengendarylens.databinding.FragmentGameOptionsBinding;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: GameOptionsFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 .2\u00020\u0001:\u0002-.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0012\u0010\"\u001a\u00020\u001f2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J&\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010#\u001a\u0004\u0018\u00010$H\u0017J\b\u0010+\u001a\u00020\u001fH\u0002J\b\u0010,\u001a\u00020\u001fH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/studiolaganne/lengendarylens/GameOptionsFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "sharedViewModel", "Lcom/studiolaganne/lengendarylens/SharedViewModel;", "getSharedViewModel", "()Lcom/studiolaganne/lengendarylens/SharedViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "isUpdatingSwitch", "", "dragging", "downRawX", "", "downRawY", "moveThreshold", "", "gameEventsCountPrior", "gameEventsActivityLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "_binding", "Lcom/studiolaganne/lengendarylens/databinding/FragmentGameOptionsBinding;", "binding", "getBinding", "()Lcom/studiolaganne/lengendarylens/databinding/FragmentGameOptionsBinding;", "callback", "Lcom/studiolaganne/lengendarylens/GameOptionsFragment$OptionsSetupCallback;", "onAttach", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "toggleBottomLayout", "onDestroyView", "OptionsSetupCallback", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GameOptionsFragment extends Fragment {
    private FragmentGameOptionsBinding _binding;
    private OptionsSetupCallback callback;
    private float downRawX;
    private float downRawY;
    private boolean dragging;
    private final ActivityResultLauncher<Intent> gameEventsActivityLauncher;
    private int gameEventsCountPrior;
    private boolean isUpdatingSwitch;
    private int moveThreshold = 50;

    /* JADX INFO: renamed from: sharedViewModel$delegate, reason: from kotlin metadata */
    private final Lazy sharedViewModel;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: GameOptionsFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/studiolaganne/lengendarylens/GameOptionsFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/studiolaganne/lengendarylens/GameOptionsFragment;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final GameOptionsFragment newInstance() {
            return new GameOptionsFragment();
        }
    }

    /* JADX INFO: compiled from: GameOptionsFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\u0003H&J\b\u0010\u0012\u001a\u00020\u0003H&J\b\u0010\u0013\u001a\u00020\u0003H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0016À\u0006\u0003"}, d2 = {"Lcom/studiolaganne/lengendarylens/GameOptionsFragment$OptionsSetupCallback;", "", "batterySavingModeChanged", "", "value", "", "commanderDamageValueChanged", "poisonCountersValueChanged", "dayNightValueChanged", "timerEnabledValueChanged", "timerValueChanged", "minutes", "", "turnTimersEnabledValueChanged", "monarchCoinDragged", "initiativeCoinDragged", "cityCoinDragged", "theRingCoinDragged", "diceTapped", "gameEventsEdited", "planechaseValueChanged", "archenemyValueChanged", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface OptionsSetupCallback {
        void archenemyValueChanged(boolean value);

        void batterySavingModeChanged(boolean value);

        void cityCoinDragged();

        void commanderDamageValueChanged(boolean value);

        void dayNightValueChanged(boolean value);

        void diceTapped();

        void gameEventsEdited();

        void initiativeCoinDragged();

        void monarchCoinDragged();

        void planechaseValueChanged(boolean value);

        void poisonCountersValueChanged(boolean value);

        void theRingCoinDragged();

        void timerEnabledValueChanged(boolean value);

        void timerValueChanged(int minutes);

        void turnTimersEnabledValueChanged(boolean value);
    }

    public GameOptionsFragment() {
        final GameOptionsFragment gameOptionsFragment = this;
        final Function0 function0 = null;
        this.sharedViewModel = FragmentViewModelLazyKt.createViewModelLazy(gameOptionsFragment, Reflection.getOrCreateKotlinClass(SharedViewModel.class), new Function0<ViewModelStore>() { // from class: com.studiolaganne.lengendarylens.GameOptionsFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return gameOptionsFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.studiolaganne.lengendarylens.GameOptionsFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? gameOptionsFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.studiolaganne.lengendarylens.GameOptionsFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return gameOptionsFragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.GameOptionsFragment$$ExternalSyntheticLambda35
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                GameOptionsFragment.gameEventsActivityLauncher$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.gameEventsActivityLauncher = activityResultLauncherRegisterForActivityResult;
    }

    static final void gameEventsActivityLauncher$lambda$0(GameOptionsFragment gameOptionsFragment, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (gameOptionsFragment.getContext() == null) {
            return;
        }
        Context contextRequireContext = gameOptionsFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        GameState currentGame = new PreferencesManager(contextRequireContext).getCurrentGame();
        if (currentGame == null || currentGame.getEvents().size() == gameOptionsFragment.gameEventsCountPrior) {
            return;
        }
        OptionsSetupCallback optionsSetupCallback = gameOptionsFragment.callback;
        if (optionsSetupCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            optionsSetupCallback = null;
        }
        optionsSetupCallback.gameEventsEdited();
    }

    private final SharedViewModel getSharedViewModel() {
        return (SharedViewModel) this.sharedViewModel.getValue();
    }

    @JvmStatic
    public static final GameOptionsFragment newInstance() {
        return INSTANCE.newInstance();
    }

    static final void onCreateView$lambda$0(GameOptionsFragment gameOptionsFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        OptionsSetupCallback optionsSetupCallback = gameOptionsFragment.callback;
        if (optionsSetupCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            optionsSetupCallback = null;
        }
        optionsSetupCallback.batterySavingModeChanged(z);
    }

    static final void onCreateView$lambda$1(GameOptionsFragment gameOptionsFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        OptionsSetupCallback optionsSetupCallback = gameOptionsFragment.callback;
        if (optionsSetupCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            optionsSetupCallback = null;
        }
        optionsSetupCallback.commanderDamageValueChanged(z);
    }

    static final void onCreateView$lambda$11(View view) {
    }

    static final Unit onCreateView$lambda$12(GameOptionsFragment gameOptionsFragment) {
        Toast.makeText(gameOptionsFragment.requireContext(), gameOptionsFragment.getResources().getString(R.string.turn_timers_locked), 1).show();
        return Unit.INSTANCE;
    }

    static final void onCreateView$lambda$13(final GameOptionsFragment gameOptionsFragment, final SwitchCompat switchCompat, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        if (gameOptionsFragment.isUpdatingSwitch || gameOptionsFragment.getContext() == null) {
            return;
        }
        Context contextRequireContext = gameOptionsFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        OptionsSetupCallback optionsSetupCallback = null;
        if (!gameOptionsFragment.getSharedViewModel().getGameState().getTurnTimerEnabled()) {
            OptionsSetupCallback optionsSetupCallback2 = gameOptionsFragment.callback;
            if (optionsSetupCallback2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("callback");
            } else {
                optionsSetupCallback = optionsSetupCallback2;
            }
            optionsSetupCallback.turnTimersEnabledValueChanged(true);
            return;
        }
        if (gameOptionsFragment.getSharedViewModel().getGameState().getEvents().size() <= 2) {
            gameOptionsFragment.getSharedViewModel().getGameState().setTurnTimerEnabled(false);
            preferencesManager.saveCurrentGame(gameOptionsFragment.getSharedViewModel().getGameState());
            OptionsSetupCallback optionsSetupCallback3 = gameOptionsFragment.callback;
            if (optionsSetupCallback3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("callback");
            } else {
                optionsSetupCallback = optionsSetupCallback3;
            }
            optionsSetupCallback.turnTimersEnabledValueChanged(false);
            return;
        }
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = gameOptionsFragment.getResources().getString(R.string.are_you_sure_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string);
        String string2 = gameOptionsFragment.getResources().getString(R.string.turn_timers_off_body);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder positiveButtonRed = title.setBody(string2).setPositiveButtonRed();
        String string3 = gameOptionsFragment.getResources().getString(R.string.confirm_turn_timers);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButton = positiveButtonRed.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.GameOptionsFragment$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return GameOptionsFragment.onCreateView$lambda$13$0(this.f$0, preferencesManager, switchCompat, ((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        String string4 = gameOptionsFragment.getResources().getString(R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        CustomDialogFragment.Builder negativeButton = positiveButton.setNegativeButton(string4, new Function1() { // from class: com.studiolaganne.lengendarylens.GameOptionsFragment$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GameOptionsFragment.onCreateView$lambda$13$1(this.f$0, switchCompat, (CustomDialogFragment) obj);
            }
        });
        FragmentManager childFragmentManager = gameOptionsFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        negativeButton.show(childFragmentManager, "CustomDialogFragment");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$13$0(GameOptionsFragment gameOptionsFragment, PreferencesManager preferencesManager, SwitchCompat switchCompat, boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        gameOptionsFragment.getSharedViewModel().getGameState().setTurnTimerEnabled(false);
        preferencesManager.saveCurrentGame(gameOptionsFragment.getSharedViewModel().getGameState());
        switchCompat.setEnabled(false);
        OptionsSetupCallback optionsSetupCallback = gameOptionsFragment.callback;
        if (optionsSetupCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            optionsSetupCallback = null;
        }
        optionsSetupCallback.turnTimersEnabledValueChanged(false);
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$13$1(GameOptionsFragment gameOptionsFragment, SwitchCompat switchCompat, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        gameOptionsFragment.isUpdatingSwitch = true;
        switchCompat.setChecked(true);
        gameOptionsFragment.isUpdatingSwitch = false;
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final void onCreateView$lambda$14(GameOptionsFragment gameOptionsFragment) {
        View view = gameOptionsFragment.getView();
        ConstraintLayout constraintLayout = view != null ? (ConstraintLayout) view.findViewById(R.id.timer_left_layout) : null;
        if (constraintLayout != null) {
            constraintLayout.setTranslationY(-constraintLayout.getHeight());
        }
    }

    static final void onCreateView$lambda$15(GameOptionsFragment gameOptionsFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        gameOptionsFragment.toggleBottomLayout();
        OptionsSetupCallback optionsSetupCallback = gameOptionsFragment.callback;
        if (optionsSetupCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            optionsSetupCallback = null;
        }
        optionsSetupCallback.timerEnabledValueChanged(z);
        if (z) {
            TextView timerLeftHeader = gameOptionsFragment.getBinding().timerLeftHeader;
            Intrinsics.checkNotNullExpressionValue(timerLeftHeader, "timerLeftHeader");
            int iTimeLeft = GameUtils.INSTANCE.getInstance().timeLeft(gameOptionsFragment.getSharedViewModel().getGameState());
            String string = gameOptionsFragment.getResources().getString(R.string.left);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            int i = iTimeLeft / 60;
            timerLeftHeader.setText(StringsKt.replace$default(string, "{1}", (i > 0 ? new StringBuilder().append(i).append("h ") : new StringBuilder()).append(iTimeLeft % 60).append("min").toString(), false, 4, (Object) null));
            Context context = gameOptionsFragment.getContext();
            if (context != null) {
                FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(context);
                Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
                firebaseAnalytics.logEvent("game_menu_timer_enabled", null);
            }
        }
    }

    static final Unit onCreateView$lambda$16(final GameOptionsFragment gameOptionsFragment, final TextView textView, final TextView textView2) {
        Context context = gameOptionsFragment.getContext();
        if (context != null) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(context);
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            firebaseAnalytics.logEvent("game_menu_timer_value_edited", null);
        }
        new TimerTimeDialogFragment.Builder().setMinutes(gameOptionsFragment.getSharedViewModel().getGameState().getTimerTotalTime()).setPositiveButtonCallback(new Function2() { // from class: com.studiolaganne.lengendarylens.GameOptionsFragment$$ExternalSyntheticLambda33
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return GameOptionsFragment.onCreateView$lambda$16$1(this.f$0, textView, textView2, ((Integer) obj).intValue(), (TimerTimeDialogFragment) obj2);
            }
        }).setNegativeButtonCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.GameOptionsFragment$$ExternalSyntheticLambda34
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GameOptionsFragment.onCreateView$lambda$16$2((TimerTimeDialogFragment) obj);
            }
        }).build().show(gameOptionsFragment.getParentFragmentManager(), "timer_time_dialog");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$16$1(GameOptionsFragment gameOptionsFragment, TextView textView, TextView textView2, int i, TimerTimeDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        gameOptionsFragment.getSharedViewModel().getGameState().setTimerTotalTime(i);
        OptionsSetupCallback optionsSetupCallback = gameOptionsFragment.callback;
        if (optionsSetupCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            optionsSetupCallback = null;
        }
        optionsSetupCallback.timerValueChanged(i);
        int i2 = i / 60;
        textView.setText((i2 > 0 ? new StringBuilder().append(i2).append("h ") : new StringBuilder()).append(i % 60).append("min").toString());
        int iTimeLeft = GameUtils.INSTANCE.getInstance().timeLeft(gameOptionsFragment.getSharedViewModel().getGameState());
        String string = gameOptionsFragment.getResources().getString(R.string.left);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        int i3 = iTimeLeft / 60;
        textView2.setText(StringsKt.replace$default(string, "{1}", (i3 > 0 ? new StringBuilder().append(i3).append("h ") : new StringBuilder()).append(iTimeLeft % 60).append("min").toString(), false, 4, (Object) null));
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$16$2(TimerTimeDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$17(GameOptionsFragment gameOptionsFragment) {
        OptionsSetupCallback optionsSetupCallback = gameOptionsFragment.callback;
        if (optionsSetupCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            optionsSetupCallback = null;
        }
        optionsSetupCallback.diceTapped();
        return Unit.INSTANCE;
    }

    static final void onCreateView$lambda$2(GameOptionsFragment gameOptionsFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        OptionsSetupCallback optionsSetupCallback = gameOptionsFragment.callback;
        if (optionsSetupCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            optionsSetupCallback = null;
        }
        optionsSetupCallback.poisonCountersValueChanged(z);
    }

    static final boolean onCreateView$lambda$22(ImageView imageView, GameOptionsFragment gameOptionsFragment, View view) {
        ClipData clipDataNewPlainText = ClipData.newPlainText("", "");
        View.DragShadowBuilder dragShadowBuilder = new View.DragShadowBuilder(imageView);
        dragShadowBuilder.getView().setScaleX(1.5f);
        dragShadowBuilder.getView().setScaleY(1.5f);
        imageView.startDragAndDrop(clipDataNewPlainText, dragShadowBuilder, "TheInitiative", 0);
        OptionsSetupCallback optionsSetupCallback = gameOptionsFragment.callback;
        if (optionsSetupCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            optionsSetupCallback = null;
        }
        optionsSetupCallback.initiativeCoinDragged();
        return false;
    }

    static final boolean onCreateView$lambda$23(GameOptionsFragment gameOptionsFragment, final ConstraintLayout constraintLayout, ImageView imageView, View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            gameOptionsFragment.downRawX = motionEvent.getRawX();
            gameOptionsFragment.downRawY = motionEvent.getRawY();
            gameOptionsFragment.dragging = true;
            return true;
        }
        OptionsSetupCallback optionsSetupCallback = null;
        if (action == 1) {
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            float fAbs = Math.abs(rawX - gameOptionsFragment.downRawX);
            float fAbs2 = Math.abs(rawY - gameOptionsFragment.downRawY);
            int i = gameOptionsFragment.moveThreshold;
            if (fAbs > i && fAbs2 > i) {
                return false;
            }
            constraintLayout.setVisibility(0);
            Breadcrumbs.INSTANCE.leaveBreadcrumb("initiative_coin_tapped");
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(gameOptionsFragment.requireContext());
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            firebaseAnalytics.logEvent("initiative_coin_tapped", null);
            constraintLayout.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameOptionsFragment$$ExternalSyntheticLambda32
                @Override // java.lang.Runnable
                public final void run() {
                    constraintLayout.setVisibility(4);
                }
            }, 1500L);
            return true;
        }
        if (action != 2 || !gameOptionsFragment.dragging) {
            return false;
        }
        gameOptionsFragment.moveThreshold = ViewConfiguration.get(gameOptionsFragment.requireContext()).getScaledTouchSlop();
        float rawX2 = motionEvent.getRawX();
        float rawY2 = motionEvent.getRawY();
        float fAbs3 = Math.abs(rawX2 - gameOptionsFragment.downRawX);
        float fAbs4 = Math.abs(rawY2 - gameOptionsFragment.downRawY);
        int i2 = gameOptionsFragment.moveThreshold;
        if (fAbs3 > i2 || fAbs4 > i2) {
            gameOptionsFragment.dragging = false;
            imageView.startDragAndDrop(ClipData.newPlainText("", ""), new ScaledDragShadowBuilder(imageView, 1.5f), "TheInitiative", 0);
            OptionsSetupCallback optionsSetupCallback2 = gameOptionsFragment.callback;
            if (optionsSetupCallback2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("callback");
            } else {
                optionsSetupCallback = optionsSetupCallback2;
            }
            optionsSetupCallback.initiativeCoinDragged();
        }
        return true;
    }

    static final boolean onCreateView$lambda$24(MonarchCoin monarchCoin, GameOptionsFragment gameOptionsFragment, View view) {
        monarchCoin.startDragAndDrop(ClipData.newPlainText("", ""), new ScaledDragShadowBuilder(monarchCoin, 1.5f), monarchCoin, 0);
        OptionsSetupCallback optionsSetupCallback = gameOptionsFragment.callback;
        if (optionsSetupCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            optionsSetupCallback = null;
        }
        optionsSetupCallback.monarchCoinDragged();
        return false;
    }

    static final boolean onCreateView$lambda$25(GameOptionsFragment gameOptionsFragment, final ConstraintLayout constraintLayout, MonarchCoin monarchCoin, View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            gameOptionsFragment.downRawX = motionEvent.getRawX();
            gameOptionsFragment.downRawY = motionEvent.getRawY();
            gameOptionsFragment.dragging = true;
            return true;
        }
        OptionsSetupCallback optionsSetupCallback = null;
        if (action == 1) {
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            float fAbs = Math.abs(rawX - gameOptionsFragment.downRawX);
            float fAbs2 = Math.abs(rawY - gameOptionsFragment.downRawY);
            int i = gameOptionsFragment.moveThreshold;
            if (fAbs > i && fAbs2 > i) {
                return false;
            }
            constraintLayout.setVisibility(0);
            Breadcrumbs.INSTANCE.leaveBreadcrumb("monarch_coin_tapped");
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(gameOptionsFragment.requireContext());
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            firebaseAnalytics.logEvent("monarch_coin_tapped", null);
            constraintLayout.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameOptionsFragment$$ExternalSyntheticLambda36
                @Override // java.lang.Runnable
                public final void run() {
                    constraintLayout.setVisibility(4);
                }
            }, 1500L);
            return true;
        }
        if (action != 2 || !gameOptionsFragment.dragging) {
            return false;
        }
        gameOptionsFragment.moveThreshold = ViewConfiguration.get(gameOptionsFragment.requireContext()).getScaledTouchSlop();
        float rawX2 = motionEvent.getRawX();
        float rawY2 = motionEvent.getRawY();
        float fAbs3 = Math.abs(rawX2 - gameOptionsFragment.downRawX);
        float fAbs4 = Math.abs(rawY2 - gameOptionsFragment.downRawY);
        int i2 = gameOptionsFragment.moveThreshold;
        if (fAbs3 > i2 || fAbs4 > i2) {
            gameOptionsFragment.dragging = false;
            monarchCoin.startDragAndDrop(ClipData.newPlainText("", ""), new ScaledDragShadowBuilder(monarchCoin, 1.5f), monarchCoin, 0);
            OptionsSetupCallback optionsSetupCallback2 = gameOptionsFragment.callback;
            if (optionsSetupCallback2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("callback");
            } else {
                optionsSetupCallback = optionsSetupCallback2;
            }
            optionsSetupCallback.monarchCoinDragged();
        }
        return true;
    }

    static final boolean onCreateView$lambda$26(ImageView imageView, GameOptionsFragment gameOptionsFragment, View view) {
        imageView.startDragAndDrop(ClipData.newPlainText("", ""), new ScaledDragShadowBuilder(imageView, 1.5f), "City", 0);
        OptionsSetupCallback optionsSetupCallback = gameOptionsFragment.callback;
        if (optionsSetupCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            optionsSetupCallback = null;
        }
        optionsSetupCallback.cityCoinDragged();
        return false;
    }

    static final boolean onCreateView$lambda$27(GameOptionsFragment gameOptionsFragment, final ConstraintLayout constraintLayout, ImageView imageView, View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            gameOptionsFragment.downRawX = motionEvent.getRawX();
            gameOptionsFragment.downRawY = motionEvent.getRawY();
            gameOptionsFragment.dragging = true;
            return true;
        }
        OptionsSetupCallback optionsSetupCallback = null;
        if (action == 1) {
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            float fAbs = Math.abs(rawX - gameOptionsFragment.downRawX);
            float fAbs2 = Math.abs(rawY - gameOptionsFragment.downRawY);
            int i = gameOptionsFragment.moveThreshold;
            if (fAbs > i && fAbs2 > i) {
                return false;
            }
            constraintLayout.setVisibility(0);
            Breadcrumbs.INSTANCE.leaveBreadcrumb("city_coin_tapped");
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(gameOptionsFragment.requireContext());
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            firebaseAnalytics.logEvent("city_coin_tapped", null);
            constraintLayout.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameOptionsFragment$$ExternalSyntheticLambda31
                @Override // java.lang.Runnable
                public final void run() {
                    constraintLayout.setVisibility(4);
                }
            }, 1500L);
            return true;
        }
        if (action != 2 || !gameOptionsFragment.dragging) {
            return false;
        }
        gameOptionsFragment.moveThreshold = ViewConfiguration.get(gameOptionsFragment.requireContext()).getScaledTouchSlop();
        float rawX2 = motionEvent.getRawX();
        float rawY2 = motionEvent.getRawY();
        float fAbs3 = Math.abs(rawX2 - gameOptionsFragment.downRawX);
        float fAbs4 = Math.abs(rawY2 - gameOptionsFragment.downRawY);
        int i2 = gameOptionsFragment.moveThreshold;
        if (fAbs3 > i2 || fAbs4 > i2) {
            gameOptionsFragment.dragging = false;
            imageView.startDragAndDrop(ClipData.newPlainText("", ""), new ScaledDragShadowBuilder(imageView, 1.5f), "City", 0);
            OptionsSetupCallback optionsSetupCallback2 = gameOptionsFragment.callback;
            if (optionsSetupCallback2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("callback");
            } else {
                optionsSetupCallback = optionsSetupCallback2;
            }
            optionsSetupCallback.cityCoinDragged();
        }
        return true;
    }

    static final boolean onCreateView$lambda$28(ImageView imageView, GameOptionsFragment gameOptionsFragment, View view) {
        imageView.startDragAndDrop(ClipData.newPlainText("", ""), new ScaledDragShadowBuilder(imageView, 1.5f), "TheRing", 0);
        OptionsSetupCallback optionsSetupCallback = gameOptionsFragment.callback;
        if (optionsSetupCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            optionsSetupCallback = null;
        }
        optionsSetupCallback.theRingCoinDragged();
        return false;
    }

    static final boolean onCreateView$lambda$29(GameOptionsFragment gameOptionsFragment, final ConstraintLayout constraintLayout, ImageView imageView, View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            gameOptionsFragment.downRawX = motionEvent.getRawX();
            gameOptionsFragment.downRawY = motionEvent.getRawY();
            gameOptionsFragment.dragging = true;
            return true;
        }
        OptionsSetupCallback optionsSetupCallback = null;
        if (action == 1) {
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            float fAbs = Math.abs(rawX - gameOptionsFragment.downRawX);
            float fAbs2 = Math.abs(rawY - gameOptionsFragment.downRawY);
            int i = gameOptionsFragment.moveThreshold;
            if (fAbs > i && fAbs2 > i) {
                return false;
            }
            constraintLayout.setVisibility(0);
            Breadcrumbs.INSTANCE.leaveBreadcrumb("the_ring_coin_tapped");
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(gameOptionsFragment.requireContext());
            Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
            firebaseAnalytics.logEvent("the_ring_coin_tapped", null);
            constraintLayout.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameOptionsFragment$$ExternalSyntheticLambda29
                @Override // java.lang.Runnable
                public final void run() {
                    constraintLayout.setVisibility(4);
                }
            }, 1500L);
            return true;
        }
        if (action != 2 || !gameOptionsFragment.dragging) {
            return false;
        }
        gameOptionsFragment.moveThreshold = ViewConfiguration.get(gameOptionsFragment.requireContext()).getScaledTouchSlop();
        float rawX2 = motionEvent.getRawX();
        float rawY2 = motionEvent.getRawY();
        float fAbs3 = Math.abs(rawX2 - gameOptionsFragment.downRawX);
        float fAbs4 = Math.abs(rawY2 - gameOptionsFragment.downRawY);
        int i2 = gameOptionsFragment.moveThreshold;
        if (fAbs3 > i2 || fAbs4 > i2) {
            gameOptionsFragment.dragging = false;
            imageView.startDragAndDrop(ClipData.newPlainText("", ""), new ScaledDragShadowBuilder(imageView, 1.5f), "TheRing", 0);
            OptionsSetupCallback optionsSetupCallback2 = gameOptionsFragment.callback;
            if (optionsSetupCallback2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("callback");
            } else {
                optionsSetupCallback = optionsSetupCallback2;
            }
            optionsSetupCallback.theRingCoinDragged();
        }
        return true;
    }

    static final void onCreateView$lambda$3(GameOptionsFragment gameOptionsFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<unused var>");
        OptionsSetupCallback optionsSetupCallback = gameOptionsFragment.callback;
        if (optionsSetupCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            optionsSetupCallback = null;
        }
        optionsSetupCallback.dayNightValueChanged(z);
    }

    static final Unit onCreateView$lambda$30(GameOptionsFragment gameOptionsFragment, PreferencesManager preferencesManager) {
        if (gameOptionsFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        GameState currentGame = preferencesManager.getCurrentGame();
        if (currentGame != null) {
            gameOptionsFragment.gameEventsCountPrior = currentGame.getEvents().size();
        }
        gameOptionsFragment.gameEventsActivityLauncher.launch(new Intent(gameOptionsFragment.requireContext(), (Class<?>) GameEventsActivity.class));
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$4(GameOptionsFragment gameOptionsFragment, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4) {
        if (gameOptionsFragment.getContext() == null || gameOptionsFragment._binding == null) {
            return Unit.INSTANCE;
        }
        if (gameOptionsFragment.getSharedViewModel().getGameState().getHasPlanechase()) {
            imageView.setAlpha(0.65f);
            imageView2.setVisibility(4);
        } else {
            imageView.setAlpha(0.95f);
            imageView2.setVisibility(0);
            imageView3.setAlpha(0.65f);
            imageView4.setVisibility(4);
        }
        OptionsSetupCallback optionsSetupCallback = gameOptionsFragment.callback;
        if (optionsSetupCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            optionsSetupCallback = null;
        }
        optionsSetupCallback.planechaseValueChanged(!gameOptionsFragment.getSharedViewModel().getGameState().getHasPlanechase());
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$5(GameOptionsFragment gameOptionsFragment, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4) {
        if (gameOptionsFragment.getContext() == null || gameOptionsFragment._binding == null) {
            return Unit.INSTANCE;
        }
        if (gameOptionsFragment.getSharedViewModel().getGameState().getHasArchenemy()) {
            imageView.setAlpha(0.65f);
            imageView2.setVisibility(4);
        } else {
            imageView.setAlpha(0.95f);
            imageView2.setVisibility(0);
            imageView3.setAlpha(0.65f);
            imageView4.setVisibility(4);
        }
        OptionsSetupCallback optionsSetupCallback = gameOptionsFragment.callback;
        if (optionsSetupCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            optionsSetupCallback = null;
        }
        optionsSetupCallback.archenemyValueChanged(!gameOptionsFragment.getSharedViewModel().getGameState().getHasArchenemy());
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$6(GameOptionsFragment gameOptionsFragment) {
        if (gameOptionsFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        gameOptionsFragment.getBinding().addonsOverlay.setVisibility(0);
        gameOptionsFragment.getBinding().innerAddonsLayout.setVisibility(0);
        return Unit.INSTANCE;
    }

    static final void onCreateView$lambda$8(View view) {
    }

    static final Unit onCreateView$lambda$9(GameOptionsFragment gameOptionsFragment) {
        if (gameOptionsFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        gameOptionsFragment.getBinding().tokensOverlay.setVisibility(0);
        gameOptionsFragment.getBinding().innerTokensLayout.setVisibility(0);
        return Unit.INSTANCE;
    }

    private final void toggleBottomLayout() {
        View view = getView();
        final ConstraintLayout constraintLayout = view != null ? (ConstraintLayout) view.findViewById(R.id.timer_left_layout) : null;
        if (constraintLayout != null) {
            constraintLayout.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameOptionsFragment$$ExternalSyntheticLambda30
                @Override // java.lang.Runnable
                public final void run() {
                    GameOptionsFragment.toggleBottomLayout$lambda$0$0(constraintLayout);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void toggleBottomLayout$lambda$0$0(final ConstraintLayout constraintLayout) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(constraintLayout.getTranslationY(), constraintLayout.getTranslationY() == 0.0f ? -constraintLayout.getHeight() : 0.0f);
        valueAnimatorOfFloat.setDuration(450L);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.studiolaganne.lengendarylens.GameOptionsFragment$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                GameOptionsFragment.toggleBottomLayout$lambda$0$0$0$0(constraintLayout, valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.studiolaganne.lengendarylens.GameOptionsFragment$toggleBottomLayout$1$1$animator$1$2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        });
        valueAnimatorOfFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void toggleBottomLayout$lambda$0$0$0$0(ConstraintLayout constraintLayout, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        constraintLayout.setTranslationY(((Float) animatedValue).floatValue());
    }

    public final FragmentGameOptionsBinding getBinding() {
        FragmentGameOptionsBinding fragmentGameOptionsBinding = this._binding;
        Intrinsics.checkNotNull(fragmentGameOptionsBinding);
        return fragmentGameOptionsBinding;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        try {
            ActivityResultCaller parentFragment = getParentFragment();
            Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.studiolaganne.lengendarylens.GameOptionsFragment.OptionsSetupCallback");
            this.callback = (OptionsSetupCallback) parentFragment;
        } catch (ClassCastException unused) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ConstraintLayout constraintLayout;
        int i;
        StringBuilder sb;
        StringBuilder sbAppend;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentGameOptionsBinding.inflate(inflater, container, false);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        SwitchCompat commanderSwitch = getBinding().commanderSwitch;
        Intrinsics.checkNotNullExpressionValue(commanderSwitch, "commanderSwitch");
        SwitchCompat poisonSwitch = getBinding().poisonSwitch;
        Intrinsics.checkNotNullExpressionValue(poisonSwitch, "poisonSwitch");
        SwitchCompat dayNightSwitch = getBinding().dayNightSwitch;
        Intrinsics.checkNotNullExpressionValue(dayNightSwitch, "dayNightSwitch");
        final MonarchCoin monarchCoin = getBinding().monarchCoin;
        Intrinsics.checkNotNullExpressionValue(monarchCoin, "monarchCoin");
        TextView monarchText = getBinding().monarchText;
        Intrinsics.checkNotNullExpressionValue(monarchText, "monarchText");
        ConstraintLayout monarchHelpLayout = getBinding().monarchHelpLayout;
        Intrinsics.checkNotNullExpressionValue(monarchHelpLayout, "monarchHelpLayout");
        ConstraintLayout diceLayout = getBinding().diceLayout;
        Intrinsics.checkNotNullExpressionValue(diceLayout, "diceLayout");
        ConstraintLayout eventsLayout = getBinding().eventsLayout;
        Intrinsics.checkNotNullExpressionValue(eventsLayout, "eventsLayout");
        SwitchCompat batterySavingSwitch = getBinding().batterySavingSwitch;
        Intrinsics.checkNotNullExpressionValue(batterySavingSwitch, "batterySavingSwitch");
        ConstraintLayout tokensLayout = getBinding().tokensLayout;
        Intrinsics.checkNotNullExpressionValue(tokensLayout, "tokensLayout");
        final ImageView initiativeIcon = getBinding().initiativeIcon;
        Intrinsics.checkNotNullExpressionValue(initiativeIcon, "initiativeIcon");
        TextView intiativeLabelText = getBinding().intiativeLabelText;
        Intrinsics.checkNotNullExpressionValue(intiativeLabelText, "intiativeLabelText");
        final ImageView blessingIcon = getBinding().blessingIcon;
        Intrinsics.checkNotNullExpressionValue(blessingIcon, "blessingIcon");
        TextView blessingLabelText = getBinding().blessingLabelText;
        Intrinsics.checkNotNullExpressionValue(blessingLabelText, "blessingLabelText");
        final ImageView theRingIcon = getBinding().theRingIcon;
        Intrinsics.checkNotNullExpressionValue(theRingIcon, "theRingIcon");
        TextView theRingLabelText = getBinding().theRingLabelText;
        Intrinsics.checkNotNullExpressionValue(theRingLabelText, "theRingLabelText");
        ConstraintLayout addonsLayout = getBinding().addonsLayout;
        Intrinsics.checkNotNullExpressionValue(addonsLayout, "addonsLayout");
        batterySavingSwitch.setChecked(preferencesManager.isBatterySavingMode());
        batterySavingSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.GameOptionsFragment$$ExternalSyntheticLambda37
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                GameOptionsFragment.onCreateView$lambda$0(this.f$0, compoundButton, z);
            }
        });
        commanderSwitch.setChecked(getSharedViewModel().getGameState().getHasCommanderDamage());
        poisonSwitch.setChecked(getSharedViewModel().getGameState().getHasPoisonCounters());
        dayNightSwitch.setChecked(getSharedViewModel().getGameState().getHasDayNight());
        commanderSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.GameOptionsFragment$$ExternalSyntheticLambda12
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                GameOptionsFragment.onCreateView$lambda$1(this.f$0, compoundButton, z);
            }
        });
        poisonSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.GameOptionsFragment$$ExternalSyntheticLambda20
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                GameOptionsFragment.onCreateView$lambda$2(this.f$0, compoundButton, z);
            }
        });
        dayNightSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.GameOptionsFragment$$ExternalSyntheticLambda21
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                GameOptionsFragment.onCreateView$lambda$3(this.f$0, compoundButton, z);
            }
        });
        final ImageView planechaseIcon = getBinding().planechaseIcon;
        Intrinsics.checkNotNullExpressionValue(planechaseIcon, "planechaseIcon");
        final ImageView planechaseCheckmark = getBinding().planechaseCheckmark;
        Intrinsics.checkNotNullExpressionValue(planechaseCheckmark, "planechaseCheckmark");
        final ImageView archenemyIcon = getBinding().archenemyIcon;
        Intrinsics.checkNotNullExpressionValue(archenemyIcon, "archenemyIcon");
        final ImageView archenemyCheckmark = getBinding().archenemyCheckmark;
        Intrinsics.checkNotNullExpressionValue(archenemyCheckmark, "archenemyCheckmark");
        if (getSharedViewModel().getGameState().getHasPlanechase()) {
            planechaseIcon.setAlpha(0.95f);
            planechaseCheckmark.setVisibility(0);
        } else {
            planechaseIcon.setAlpha(0.65f);
            planechaseCheckmark.setVisibility(4);
        }
        ViewExtensionsKt.setOnClickWithBounce(planechaseIcon, new Function0() { // from class: com.studiolaganne.lengendarylens.GameOptionsFragment$$ExternalSyntheticLambda23
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameOptionsFragment.onCreateView$lambda$4(this.f$0, planechaseIcon, planechaseCheckmark, archenemyIcon, archenemyCheckmark);
            }
        });
        if (getSharedViewModel().getGameState().getHasArchenemy()) {
            archenemyIcon.setAlpha(0.95f);
            archenemyCheckmark.setVisibility(0);
        } else {
            archenemyIcon.setAlpha(0.65f);
            archenemyCheckmark.setVisibility(4);
        }
        ViewExtensionsKt.setOnClickWithBounce(archenemyIcon, new Function0() { // from class: com.studiolaganne.lengendarylens.GameOptionsFragment$$ExternalSyntheticLambda24
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameOptionsFragment.onCreateView$lambda$5(this.f$0, archenemyIcon, archenemyCheckmark, planechaseIcon, planechaseCheckmark);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(addonsLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.GameOptionsFragment$$ExternalSyntheticLambda25
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameOptionsFragment.onCreateView$lambda$6(this.f$0);
            }
        });
        getBinding().addonsOverlay.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.GameOptionsFragment$$ExternalSyntheticLambda26
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.getBinding().addonsOverlay.setVisibility(8);
            }
        });
        getBinding().innerAddonsLayout.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.GameOptionsFragment$$ExternalSyntheticLambda27
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GameOptionsFragment.onCreateView$lambda$8(view);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(tokensLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.GameOptionsFragment$$ExternalSyntheticLambda28
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameOptionsFragment.onCreateView$lambda$9(this.f$0);
            }
        });
        getBinding().tokensOverlay.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.GameOptionsFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.getBinding().tokensOverlay.setVisibility(8);
            }
        });
        getBinding().innerTokensLayout.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.GameOptionsFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GameOptionsFragment.onCreateView$lambda$11(view);
            }
        });
        final SwitchCompat turnTimerSwitch = getBinding().turnTimerSwitch;
        Intrinsics.checkNotNullExpressionValue(turnTimerSwitch, "turnTimerSwitch");
        turnTimerSwitch.setChecked(getSharedViewModel().getGameState().getTurnTimerEnabled());
        if (!getSharedViewModel().getGameState().getTurnTimerEnabled() && getSharedViewModel().getGameState().getEvents().size() > 2) {
            turnTimerSwitch.setEnabled(false);
            ConstraintLayout turnTimerLayout = getBinding().turnTimerLayout;
            Intrinsics.checkNotNullExpressionValue(turnTimerLayout, "turnTimerLayout");
            ViewExtensionsKt.setOnClickWithFade(turnTimerLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.GameOptionsFragment$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return GameOptionsFragment.onCreateView$lambda$12(this.f$0);
                }
            });
        }
        turnTimerSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.GameOptionsFragment$$ExternalSyntheticLambda4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                GameOptionsFragment.onCreateView$lambda$13(this.f$0, turnTimerSwitch, compoundButton, z);
            }
        });
        SwitchCompat timerSwitch = getBinding().timerSwitch;
        Intrinsics.checkNotNullExpressionValue(timerSwitch, "timerSwitch");
        timerSwitch.setChecked(getSharedViewModel().getGameState().getTimerEnabled());
        if (!timerSwitch.isChecked()) {
            timerSwitch.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameOptionsFragment$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    GameOptionsFragment.onCreateView$lambda$14(this.f$0);
                }
            });
        }
        final TextView timerLeftHeader = getBinding().timerLeftHeader;
        Intrinsics.checkNotNullExpressionValue(timerLeftHeader, "timerLeftHeader");
        int iTimeLeft = GameUtils.INSTANCE.getInstance().timeLeft(getSharedViewModel().getGameState());
        String string = getResources().getString(R.string.left);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        int i2 = iTimeLeft / 60;
        if (i2 > 0) {
            i = iTimeLeft % 60;
            constraintLayout = monarchHelpLayout;
            sb = new StringBuilder().append(i2).append("h ");
        } else {
            constraintLayout = monarchHelpLayout;
            i = iTimeLeft % 60;
            sb = new StringBuilder();
        }
        timerLeftHeader.setText(StringsKt.replace$default(string, "{1}", sb.append(i).append("min").toString(), false, 4, (Object) null));
        timerSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.studiolaganne.lengendarylens.GameOptionsFragment$$ExternalSyntheticLambda6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                GameOptionsFragment.onCreateView$lambda$15(this.f$0, compoundButton, z);
            }
        });
        final TextView timerValue = getBinding().timerValue;
        Intrinsics.checkNotNullExpressionValue(timerValue, "timerValue");
        if (getSharedViewModel().getGameState().getTimerTotalTime() / 60 > 0) {
            int timerTotalTime = getSharedViewModel().getGameState().getTimerTotalTime() / 60;
            sbAppend = new StringBuilder().append(timerTotalTime).append("h ").append(getSharedViewModel().getGameState().getTimerTotalTime() % 60);
        } else {
            sbAppend = new StringBuilder().append(getSharedViewModel().getGameState().getTimerTotalTime() % 60);
        }
        timerValue.setText(sbAppend.append("min").toString());
        ViewExtensionsKt.setOnClickWithFade(timerValue, new Function0() { // from class: com.studiolaganne.lengendarylens.GameOptionsFragment$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameOptionsFragment.onCreateView$lambda$16(this.f$0, timerValue, timerLeftHeader);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(diceLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.GameOptionsFragment$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameOptionsFragment.onCreateView$lambda$17(this.f$0);
            }
        });
        GameState currentGame = preferencesManager.getCurrentGame();
        if (currentGame != null) {
            Iterator<Player> it = currentGame.getPlayers().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (it.next().getMonarch()) {
                    monarchCoin.setVisibility(4);
                    monarchText.setVisibility(4);
                    break;
                }
            }
        }
        if (currentGame != null) {
            Iterator<Player> it2 = currentGame.getPlayers().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                if (it2.next().getInitiative()) {
                    initiativeIcon.setVisibility(4);
                    intiativeLabelText.setVisibility(4);
                    break;
                }
            }
        }
        if (currentGame != null) {
            Iterator<Player> it3 = currentGame.getPlayers().iterator();
            while (it3.hasNext()) {
                if (!it3.next().getCityBlessing()) {
                    break;
                }
            }
            blessingIcon.setVisibility(4);
            blessingLabelText.setVisibility(4);
        } else {
            blessingIcon.setVisibility(4);
            blessingLabelText.setVisibility(4);
        }
        if (currentGame != null) {
            Iterator<Player> it4 = currentGame.getPlayers().iterator();
            while (it4.hasNext()) {
                if (!it4.next().getTheRing()) {
                    break;
                }
            }
            theRingIcon.setVisibility(4);
            theRingLabelText.setVisibility(4);
        } else {
            theRingIcon.setVisibility(4);
            theRingLabelText.setVisibility(4);
        }
        this.moveThreshold = ViewConfiguration.get(requireContext()).getScaledTouchSlop();
        initiativeIcon.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.studiolaganne.lengendarylens.GameOptionsFragment$$ExternalSyntheticLambda9
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return GameOptionsFragment.onCreateView$lambda$22(initiativeIcon, this, view);
            }
        });
        final ConstraintLayout constraintLayout2 = constraintLayout;
        initiativeIcon.setOnTouchListener(new View.OnTouchListener() { // from class: com.studiolaganne.lengendarylens.GameOptionsFragment$$ExternalSyntheticLambda10
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return GameOptionsFragment.onCreateView$lambda$23(this.f$0, constraintLayout2, initiativeIcon, view, motionEvent);
            }
        });
        monarchCoin.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.studiolaganne.lengendarylens.GameOptionsFragment$$ExternalSyntheticLambda13
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return GameOptionsFragment.onCreateView$lambda$24(monarchCoin, this, view);
            }
        });
        monarchCoin.setOnTouchListener(new View.OnTouchListener() { // from class: com.studiolaganne.lengendarylens.GameOptionsFragment$$ExternalSyntheticLambda14
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return GameOptionsFragment.onCreateView$lambda$25(this.f$0, constraintLayout2, monarchCoin, view, motionEvent);
            }
        });
        blessingIcon.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.studiolaganne.lengendarylens.GameOptionsFragment$$ExternalSyntheticLambda15
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return GameOptionsFragment.onCreateView$lambda$26(blessingIcon, this, view);
            }
        });
        blessingIcon.setOnTouchListener(new View.OnTouchListener() { // from class: com.studiolaganne.lengendarylens.GameOptionsFragment$$ExternalSyntheticLambda16
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return GameOptionsFragment.onCreateView$lambda$27(this.f$0, constraintLayout2, blessingIcon, view, motionEvent);
            }
        });
        theRingIcon.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.studiolaganne.lengendarylens.GameOptionsFragment$$ExternalSyntheticLambda17
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return GameOptionsFragment.onCreateView$lambda$28(theRingIcon, this, view);
            }
        });
        theRingIcon.setOnTouchListener(new View.OnTouchListener() { // from class: com.studiolaganne.lengendarylens.GameOptionsFragment$$ExternalSyntheticLambda18
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return GameOptionsFragment.onCreateView$lambda$29(this.f$0, constraintLayout2, theRingIcon, view, motionEvent);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(eventsLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.GameOptionsFragment$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameOptionsFragment.onCreateView$lambda$30(this.f$0, preferencesManager);
            }
        });
        return getBinding().getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }
}
