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
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.studiolaganne.lengendarylens.TimerLeftFragment;
import com.studiolaganne.lengendarylens.databinding.FragmentGame8PlayersType2Binding;
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

/* JADX INFO: compiled from: GameFragment8PlayersType2.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\fH\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\b\u0010\u0014\u001a\u00020\fH\u0016J\b\u0010\u0015\u001a\u00020\fH\u0016J\b\u0010\u0016\u001a\u00020\fH\u0016J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001a\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\r\u001a\u00020\u000eH\u0002J&\u0010\"\u001a\u0004\u0018\u00010\u001e2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020\u0019H\u0016J\b\u0010)\u001a\u00020\fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/studiolaganne/lengendarylens/GameFragment8PlayersType2;", "Lcom/studiolaganne/lengendarylens/GameFragmentBase;", "<init>", "()V", "_binding", "Lcom/studiolaganne/lengendarylens/databinding/FragmentGame8PlayersType2Binding;", "binding", "getBinding", "()Lcom/studiolaganne/lengendarylens/databinding/FragmentGame8PlayersType2Binding;", "callback", "Lcom/studiolaganne/lengendarylens/GameCallback;", "onAttach", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "tutorialComplete", "gameFinished", "nonSyncableGameFinished", "showStartGameButton", "hideStartGameButton", "dayNightToggled", "isOn", "", "planechaseToggled", "archenemyToggled", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "dpToPx", "", "dp", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onHiddenChanged", "hidden", "onDestroyView", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GameFragment8PlayersType2 extends GameFragmentBase {
    private FragmentGame8PlayersType2Binding _binding;
    private GameCallback callback;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: GameFragment8PlayersType2.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/studiolaganne/lengendarylens/GameFragment8PlayersType2$Companion;", "", "<init>", "()V", "newInstance", "Lcom/studiolaganne/lengendarylens/GameFragment8PlayersType2;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final GameFragment8PlayersType2 newInstance() {
            return new GameFragment8PlayersType2();
        }
    }

    private final int dpToPx(int dp, Context context) {
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }

    @JvmStatic
    public static final GameFragment8PlayersType2 newInstance() {
        return INSTANCE.newInstance();
    }

    static final void onCreateView$lambda$0(View view) {
    }

    static final Unit onCreateView$lambda$1(GameFragment8PlayersType2 gameFragment8PlayersType2) {
        if (gameFragment8PlayersType2.getContext() == null) {
            return Unit.INSTANCE;
        }
        gameFragment8PlayersType2.showPlanechaseUI();
        return Unit.INSTANCE;
    }

    static final void onCreateView$lambda$10(GameFragment8PlayersType2 gameFragment8PlayersType2, ConstraintLayout constraintLayout) {
        if (gameFragment8PlayersType2._binding == null) {
            return;
        }
        float width = constraintLayout.getWidth();
        float height = width / 2.35f;
        float f = width / 2.85f;
        View view = gameFragment8PlayersType2.getView();
        if (view != null) {
            int width2 = view.getWidth();
            int height2 = view.getHeight();
            float f2 = width2 > height2 ? width2 / height2 : height2 / width2;
            Context contextRequireContext = gameFragment8PlayersType2.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            int iDpToPx = gameFragment8PlayersType2.dpToPx(150, contextRequireContext);
            if (f2 < 1.75d) {
                height = f;
            }
            float f3 = iDpToPx;
            if (height < f3) {
                height = f3;
            }
        }
        if (height > constraintLayout.getHeight() * 0.2f) {
            height = constraintLayout.getHeight() * 0.2f;
        }
        ViewGroup.LayoutParams layoutParams = gameFragment8PlayersType2.getBinding().lifeTotalView4.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        int i = (int) height;
        layoutParams2.height = i;
        gameFragment8PlayersType2.getBinding().lifeTotalView4.setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = gameFragment8PlayersType2.getBinding().lifeTotalView1.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
        layoutParams4.height = i;
        gameFragment8PlayersType2.getBinding().lifeTotalView1.setLayoutParams(layoutParams4);
        constraintLayout.requestLayout();
    }

    static final Unit onCreateView$lambda$2(GameFragment8PlayersType2 gameFragment8PlayersType2) {
        if (gameFragment8PlayersType2.getContext() == null) {
            return Unit.INSTANCE;
        }
        Context contextRequireContext = gameFragment8PlayersType2.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        if (gameFragment8PlayersType2.getSharedViewModel().getGameState().isDay()) {
            gameFragment8PlayersType2.getSharedViewModel().getGameState().setDay(false);
            gameFragment8PlayersType2.getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.Night.getValue(), 0, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
            gameFragment8PlayersType2.getBinding().dayNightImageView.setImageResource(R.drawable.moon);
        } else {
            gameFragment8PlayersType2.getSharedViewModel().getGameState().setDay(true);
            gameFragment8PlayersType2.getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.Day.getValue(), 0, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
            gameFragment8PlayersType2.getBinding().dayNightImageView.setImageResource(R.drawable.sun);
        }
        preferencesManager.saveCurrentGame(gameFragment8PlayersType2.getSharedViewModel().getGameState());
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$4(GameFragment8PlayersType2 gameFragment8PlayersType2) {
        if (gameFragment8PlayersType2.getContext() == null) {
            return Unit.INSTANCE;
        }
        gameFragment8PlayersType2.getSharedViewModel().getGameState().setStartedAt(GameUtils.INSTANCE.getInstance().getCurrentTimestamp());
        Context contextRequireContext = gameFragment8PlayersType2.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        new PreferencesManager(contextRequireContext).saveCurrentGame(gameFragment8PlayersType2.getSharedViewModel().getGameState());
        GameCallback gameCallback = gameFragment8PlayersType2.callback;
        if (gameCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            gameCallback = null;
        }
        gameCallback.startGamePressed();
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$5(final GameFragment8PlayersType2 gameFragment8PlayersType2) {
        if (gameFragment8PlayersType2.getContext() == null || gameFragment8PlayersType2._binding == null) {
            return Unit.INSTANCE;
        }
        gameFragment8PlayersType2.getBinding().customMenuButtonImage.animate().scaleX(1.2f).scaleY(1.2f).setDuration(80L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment8PlayersType2$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                GameFragment8PlayersType2.onCreateView$lambda$5$0(this.f$0);
            }
        });
        gameFragment8PlayersType2.getBinding().overlayView1.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment8PlayersType2$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                GameFragment8PlayersType2.onCreateView$lambda$5$1(this.f$0);
            }
        }, 200L);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$5$0(GameFragment8PlayersType2 gameFragment8PlayersType2) {
        gameFragment8PlayersType2.getBinding().customMenuButtonImage.animate().scaleX(1.0f).scaleY(1.0f).setDuration(80L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$5$1(GameFragment8PlayersType2 gameFragment8PlayersType2) {
        GameCallback gameCallback = gameFragment8PlayersType2.callback;
        if (gameCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            gameCallback = null;
        }
        gameCallback.menuPressed();
    }

    static final void onCreateView$lambda$6(final GameFragment8PlayersType2 gameFragment8PlayersType2, View view) {
        gameFragment8PlayersType2.getBinding().menuButtonBlack.animate().scaleX(1.2f).scaleY(1.2f).setDuration(80L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment8PlayersType2$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                GameFragment8PlayersType2.onCreateView$lambda$6$0(this.f$0);
            }
        });
        gameFragment8PlayersType2.getBinding().menuButtonWhite.animate().scaleX(1.2f).scaleY(1.2f).setDuration(80L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment8PlayersType2$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                GameFragment8PlayersType2.onCreateView$lambda$6$1(this.f$0);
            }
        });
        gameFragment8PlayersType2.getBinding().menuButton.animate().scaleX(1.2f).scaleY(1.2f).setDuration(80L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment8PlayersType2$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                GameFragment8PlayersType2.onCreateView$lambda$6$2(this.f$0);
            }
        });
        gameFragment8PlayersType2.getBinding().overlayView1.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment8PlayersType2$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                GameFragment8PlayersType2.onCreateView$lambda$6$3(this.f$0);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$6$0(GameFragment8PlayersType2 gameFragment8PlayersType2) {
        gameFragment8PlayersType2.getBinding().menuButtonBlack.animate().scaleX(1.0f).scaleY(1.0f).setDuration(80L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$6$1(GameFragment8PlayersType2 gameFragment8PlayersType2) {
        gameFragment8PlayersType2.getBinding().menuButtonWhite.animate().scaleX(1.0f).scaleY(1.0f).setDuration(80L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$6$2(GameFragment8PlayersType2 gameFragment8PlayersType2) {
        gameFragment8PlayersType2.getBinding().menuButton.animate().scaleX(1.0f).scaleY(1.0f).setDuration(80L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$6$3(GameFragment8PlayersType2 gameFragment8PlayersType2) {
        GameCallback gameCallback = gameFragment8PlayersType2.callback;
        if (gameCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            gameCallback = null;
        }
        gameCallback.menuPressed();
    }

    static final void onCreateView$lambda$7(GameFragment8PlayersType2 gameFragment8PlayersType2) {
        String str;
        if (gameFragment8PlayersType2.getSharedViewModel().getGameState().getTimerEnabled()) {
            int iTimeLeft = GameUtils.INSTANCE.getInstance().timeLeft(gameFragment8PlayersType2.getSharedViewModel().getGameState());
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
            TimerLeftFragment.Builder rotation = new TimerLeftFragment.Builder().setPositiveButton(new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment8PlayersType2$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment8PlayersType2.onCreateView$lambda$7$0((TimerLeftFragment) obj);
                }
            }).setText(str).setRotation(270);
            FragmentManager childFragmentManager = gameFragment8PlayersType2.getChildFragmentManager();
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

    static final boolean onCreateView$lambda$8(GameFragment8PlayersType2 gameFragment8PlayersType2, Handler handler, Runnable runnable, View view, MotionEvent motionEvent) {
        if (gameFragment8PlayersType2.getContext() != null) {
            FragmentGame8PlayersType2Binding fragmentGame8PlayersType2Binding = gameFragment8PlayersType2._binding;
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

    static final void onHiddenChanged$lambda$0(GameFragment8PlayersType2 gameFragment8PlayersType2, ConstraintLayout constraintLayout) {
        if (gameFragment8PlayersType2._binding == null) {
            return;
        }
        double width = constraintLayout.getWidth();
        double d = width / 2.35d;
        double d2 = width / 2.85d;
        View view = gameFragment8PlayersType2.getView();
        if (view != null) {
            int width2 = view.getWidth();
            int height = view.getHeight();
            float f = width2 > height ? width2 / height : height / width2;
            Context contextRequireContext = gameFragment8PlayersType2.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            double dDpToPx = gameFragment8PlayersType2.dpToPx(150, contextRequireContext);
            if (f < 1.75d) {
                d = d2;
            }
            if (d < dDpToPx) {
                d = dDpToPx;
            }
        }
        ViewGroup.LayoutParams layoutParams = gameFragment8PlayersType2.getBinding().lifeTotalView4.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        int i = (int) d;
        layoutParams2.height = i;
        gameFragment8PlayersType2.getBinding().lifeTotalView4.setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = gameFragment8PlayersType2.getBinding().lifeTotalView1.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
        layoutParams4.height = i;
        gameFragment8PlayersType2.getBinding().lifeTotalView1.setLayoutParams(layoutParams4);
        constraintLayout.requestLayout();
    }

    static final void onViewCreated$lambda$1(GameFragment8PlayersType2 gameFragment8PlayersType2) {
        if (gameFragment8PlayersType2._binding == null) {
            return;
        }
        if (gameFragment8PlayersType2.getSharedViewModel().getGameState().isDay()) {
            gameFragment8PlayersType2.getBinding().dayNightImageView.setImageResource(R.drawable.sun);
        } else {
            gameFragment8PlayersType2.getBinding().dayNightImageView.setImageResource(R.drawable.moon);
        }
        gameFragment8PlayersType2.dayNightToggled(gameFragment8PlayersType2.getSharedViewModel().getGameState().getHasDayNight());
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

    public final FragmentGame8PlayersType2Binding getBinding() {
        FragmentGame8PlayersType2Binding fragmentGame8PlayersType2Binding = this._binding;
        Intrinsics.checkNotNull(fragmentGame8PlayersType2Binding);
        return fragmentGame8PlayersType2Binding;
    }

    @Override // com.studiolaganne.lengendarylens.GameFragmentBase
    public void hideStartGameButton() {
        if (this._binding == null) {
            return;
        }
        getBinding().startGameButtonLayout.setVisibility(8);
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

    /* JADX WARN: Removed duplicated region for block: B:33:0x0455  */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String borderColor;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentGame8PlayersType2Binding.inflate(inflater, container, false);
        getBinding().constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.GameFragment8PlayersType2$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GameFragment8PlayersType2.onCreateView$lambda$0(view);
            }
        });
        List<LifeTotalView> lifeViews = getLifeViews();
        LifeTotalView lifeTotalView1 = getBinding().lifeTotalView1;
        Intrinsics.checkNotNullExpressionValue(lifeTotalView1, "lifeTotalView1");
        lifeViews.add(lifeTotalView1);
        List<LifeTotalView> lifeViews2 = getLifeViews();
        LifeTotalView lifeTotalView7 = getBinding().lifeTotalView7;
        Intrinsics.checkNotNullExpressionValue(lifeTotalView7, "lifeTotalView7");
        lifeViews2.add(lifeTotalView7);
        List<LifeTotalView> lifeViews3 = getLifeViews();
        LifeTotalView lifeTotalView6 = getBinding().lifeTotalView6;
        Intrinsics.checkNotNullExpressionValue(lifeTotalView6, "lifeTotalView6");
        lifeViews3.add(lifeTotalView6);
        List<LifeTotalView> lifeViews4 = getLifeViews();
        LifeTotalView lifeTotalView5 = getBinding().lifeTotalView5;
        Intrinsics.checkNotNullExpressionValue(lifeTotalView5, "lifeTotalView5");
        lifeViews4.add(lifeTotalView5);
        List<LifeTotalView> lifeViews5 = getLifeViews();
        LifeTotalView lifeTotalView4 = getBinding().lifeTotalView4;
        Intrinsics.checkNotNullExpressionValue(lifeTotalView4, "lifeTotalView4");
        lifeViews5.add(lifeTotalView4);
        List<LifeTotalView> lifeViews6 = getLifeViews();
        LifeTotalView lifeTotalView3 = getBinding().lifeTotalView3;
        Intrinsics.checkNotNullExpressionValue(lifeTotalView3, "lifeTotalView3");
        lifeViews6.add(lifeTotalView3);
        List<LifeTotalView> lifeViews7 = getLifeViews();
        LifeTotalView lifeTotalView2 = getBinding().lifeTotalView2;
        Intrinsics.checkNotNullExpressionValue(lifeTotalView2, "lifeTotalView2");
        lifeViews7.add(lifeTotalView2);
        List<LifeTotalView> lifeViews8 = getLifeViews();
        LifeTotalView lifeTotalView8 = getBinding().lifeTotalView8;
        Intrinsics.checkNotNullExpressionValue(lifeTotalView8, "lifeTotalView8");
        lifeViews8.add(lifeTotalView8);
        setupLifeViews();
        getBinding().planechaseBkg.setOutlineProvider(new CircularOutlineProvider());
        getBinding().planechaseBkg.setClipToOutline(true);
        ImageView planechaseImageView = getBinding().planechaseImageView;
        Intrinsics.checkNotNullExpressionValue(planechaseImageView, "planechaseImageView");
        ViewExtensionsKt.setOnClickWithFade(planechaseImageView, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragment8PlayersType2$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameFragment8PlayersType2.onCreateView$lambda$1(this.f$0);
            }
        });
        getBinding().dayNightBkg.setOutlineProvider(new CircularOutlineProvider());
        getBinding().dayNightBkg.setClipToOutline(true);
        ImageView dayNightImageView = getBinding().dayNightImageView;
        Intrinsics.checkNotNullExpressionValue(dayNightImageView, "dayNightImageView");
        ViewExtensionsKt.setOnClickWithFade(dayNightImageView, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragment8PlayersType2$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameFragment8PlayersType2.onCreateView$lambda$2(this.f$0);
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
        ViewExtensionsKt.setOnClickWithFade(startGameButtonLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragment8PlayersType2$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameFragment8PlayersType2.onCreateView$lambda$4(this.f$0);
            }
        });
        getBinding().customMenuButtonImage.setOnNonTransparentClickListener(new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragment8PlayersType2$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameFragment8PlayersType2.onCreateView$lambda$5(this.f$0);
            }
        });
        getBinding().overlayView1.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.GameFragment8PlayersType2$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GameFragment8PlayersType2.onCreateView$lambda$6(this.f$0, view);
            }
        });
        final Handler handler = new Handler(Looper.getMainLooper());
        final Runnable runnable = new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment8PlayersType2$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                GameFragment8PlayersType2.onCreateView$lambda$7(this.f$0);
            }
        };
        getBinding().overlayView1.setOnTouchListener(new View.OnTouchListener() { // from class: com.studiolaganne.lengendarylens.GameFragment8PlayersType2$$ExternalSyntheticLambda16
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return GameFragment8PlayersType2.onCreateView$lambda$8(this.f$0, handler, runnable, view, motionEvent);
            }
        });
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
                getBinding().lifeTotalView1.setTopMarginMultiplier(0.5f);
                getBinding().lifeTotalView1.refreshMargins();
                ViewGroup.LayoutParams layoutParams3 = getBinding().lifeTotalView2.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
                layoutParams4.setMargins(0, 0, 0, 0);
                getBinding().lifeTotalView2.setLayoutParams(layoutParams4);
                getBinding().lifeTotalView2.setTopMarginMultiplier(0.5f);
                getBinding().lifeTotalView2.setLeftMarginMultiplier(0.5f);
                getBinding().lifeTotalView2.setBottomMarginMultiplier(0.5f);
                getBinding().lifeTotalView2.refreshMargins();
                ViewGroup.LayoutParams layoutParams5 = getBinding().lifeTotalView3.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams5, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) layoutParams5;
                layoutParams6.setMargins(0, 0, 0, 0);
                getBinding().lifeTotalView3.setLayoutParams(layoutParams6);
                getBinding().lifeTotalView3.setTopMarginMultiplier(0.5f);
                getBinding().lifeTotalView3.setLeftMarginMultiplier(0.5f);
                getBinding().lifeTotalView3.setBottomMarginMultiplier(0.5f);
                getBinding().lifeTotalView3.refreshMargins();
                ViewGroup.LayoutParams layoutParams7 = getBinding().lifeTotalView4.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams7, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams8 = (ConstraintLayout.LayoutParams) layoutParams7;
                layoutParams8.setMargins(0, 0, 0, 0);
                getBinding().lifeTotalView4.setLayoutParams(layoutParams8);
                getBinding().lifeTotalView4.setBottomMarginMultiplier(0.5f);
                getBinding().lifeTotalView4.refreshMargins();
                ViewGroup.LayoutParams layoutParams9 = getBinding().lifeTotalView5.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams9, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams10 = (ConstraintLayout.LayoutParams) layoutParams9;
                layoutParams10.setMargins(0, 0, 0, 0);
                getBinding().lifeTotalView5.setLayoutParams(layoutParams10);
                getBinding().lifeTotalView5.setTopMarginMultiplier(0.5f);
                getBinding().lifeTotalView5.setRightMarginMultiplier(0.5f);
                getBinding().lifeTotalView5.setBottomMarginMultiplier(0.5f);
                getBinding().lifeTotalView5.refreshMargins();
                ViewGroup.LayoutParams layoutParams11 = getBinding().lifeTotalView6.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams11, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams12 = (ConstraintLayout.LayoutParams) layoutParams11;
                layoutParams12.setMargins(0, 0, 0, 0);
                getBinding().lifeTotalView6.setLayoutParams(layoutParams12);
                getBinding().lifeTotalView6.setTopMarginMultiplier(0.5f);
                getBinding().lifeTotalView6.setRightMarginMultiplier(0.5f);
                getBinding().lifeTotalView6.setBottomMarginMultiplier(0.5f);
                getBinding().lifeTotalView6.refreshMargins();
                ViewGroup.LayoutParams layoutParams13 = getBinding().lifeTotalView7.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams13, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams14 = (ConstraintLayout.LayoutParams) layoutParams13;
                layoutParams14.setMargins(0, 0, 0, 0);
                getBinding().lifeTotalView7.setLayoutParams(layoutParams14);
                getBinding().lifeTotalView7.setTopMarginMultiplier(0.5f);
                getBinding().lifeTotalView7.setRightMarginMultiplier(0.5f);
                getBinding().lifeTotalView7.setBottomMarginMultiplier(0.5f);
                getBinding().lifeTotalView7.refreshMargins();
                ViewGroup.LayoutParams layoutParams15 = getBinding().lifeTotalView8.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams15, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams16 = (ConstraintLayout.LayoutParams) layoutParams15;
                layoutParams16.setMargins(0, 0, 0, 0);
                getBinding().lifeTotalView8.setLayoutParams(layoutParams16);
                getBinding().lifeTotalView8.setTopMarginMultiplier(0.5f);
                getBinding().lifeTotalView8.setLeftMarginMultiplier(0.5f);
                getBinding().lifeTotalView8.setBottomMarginMultiplier(0.5f);
                getBinding().lifeTotalView8.refreshMargins();
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
        FragmentReadyListener fragmentReadyListener = getFragmentReadyListener();
        if (fragmentReadyListener != null) {
            fragmentReadyListener.onFragmentReady();
        }
        final ConstraintLayout constraintLayout = getBinding().constraintLayout;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "constraintLayout");
        constraintLayout.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment8PlayersType2$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                GameFragment8PlayersType2.onCreateView$lambda$10(this.f$0, constraintLayout);
            }
        });
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
        if (hidden || this._binding == null) {
            return;
        }
        final ConstraintLayout constraintLayout = getBinding().constraintLayout;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "constraintLayout");
        constraintLayout.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment8PlayersType2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                GameFragment8PlayersType2.onHiddenChanged$lambda$0(this.f$0, constraintLayout);
            }
        });
    }

    @Override // com.studiolaganne.lengendarylens.GameFragmentBase, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if ((!getSharedViewModel().getGameState().getTimerEnabled() || getSharedViewModel().getGameState().getTimerTotalTime() <= 0) && !getSharedViewModel().getGameState().getTurnTimerEnabled()) {
            hideClock();
        } else {
            int value = 0;
            boolean z = (getSharedViewModel().getGameState().getPlaygroupId() == -1 && !getSharedViewModel().getGameState().getGameSyncable()) || (getSharedViewModel().getGameState().getUsersSeated() && getSharedViewModel().getGameState().getDecksSelected());
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
            view2.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment8PlayersType2$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    GameFragment8PlayersType2.onViewCreated$lambda$1(this.f$0);
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
}
