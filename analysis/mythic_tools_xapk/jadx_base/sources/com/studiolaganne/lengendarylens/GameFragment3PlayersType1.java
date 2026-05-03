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
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.activity.result.ActivityResultCaller;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.studiolaganne.lengendarylens.TimerLeftFragment;
import com.studiolaganne.lengendarylens.databinding.FragmentGame3PlayersType1Binding;
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

/* JADX INFO: compiled from: GameFragment3PlayersType1.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016J\b\u0010\u0016\u001a\u00020\u000eH\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0016J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u001a\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J&\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u001bH\u0016J\b\u0010(\u001a\u00020\u000eH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/studiolaganne/lengendarylens/GameFragment3PlayersType1;", "Lcom/studiolaganne/lengendarylens/GameFragmentBase;", "<init>", "()V", "globalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "_binding", "Lcom/studiolaganne/lengendarylens/databinding/FragmentGame3PlayersType1Binding;", "binding", "getBinding", "()Lcom/studiolaganne/lengendarylens/databinding/FragmentGame3PlayersType1Binding;", "callback", "Lcom/studiolaganne/lengendarylens/GameCallback;", "onAttach", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "tutorialComplete", "gameFinished", "nonSyncableGameFinished", "showStartGameButton", "hideStartGameButton", "dayNightToggled", "isOn", "", "planechaseToggled", "archenemyToggled", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onHiddenChanged", "hidden", "onDestroyView", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GameFragment3PlayersType1 extends GameFragmentBase {
    private FragmentGame3PlayersType1Binding _binding;
    private GameCallback callback;
    private ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: GameFragment3PlayersType1.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/studiolaganne/lengendarylens/GameFragment3PlayersType1$Companion;", "", "<init>", "()V", "newInstance", "Lcom/studiolaganne/lengendarylens/GameFragment3PlayersType1;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final GameFragment3PlayersType1 newInstance() {
            return new GameFragment3PlayersType1();
        }
    }

    @JvmStatic
    public static final GameFragment3PlayersType1 newInstance() {
        return INSTANCE.newInstance();
    }

    static final void onCreateView$lambda$0(View view) {
    }

    static final Unit onCreateView$lambda$1(GameFragment3PlayersType1 gameFragment3PlayersType1) {
        if (gameFragment3PlayersType1.getContext() == null) {
            return Unit.INSTANCE;
        }
        gameFragment3PlayersType1.showPlanechaseUI();
        return Unit.INSTANCE;
    }

    static final void onCreateView$lambda$10(GameFragment3PlayersType1 gameFragment3PlayersType1, ConstraintLayout constraintLayout) {
        if (gameFragment3PlayersType1._binding == null) {
            return;
        }
        float width = (constraintLayout.getWidth() / 2) * 1.5f;
        if (width > constraintLayout.getHeight() * 0.4f) {
            width = constraintLayout.getHeight() * 0.4f;
        }
        ViewGroup.LayoutParams layoutParams = gameFragment3PlayersType1.getBinding().lifeTotalView1.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.height = (int) width;
        gameFragment3PlayersType1.getBinding().lifeTotalView1.setLayoutParams(layoutParams2);
        constraintLayout.requestLayout();
    }

    static final Unit onCreateView$lambda$2(GameFragment3PlayersType1 gameFragment3PlayersType1) {
        if (gameFragment3PlayersType1.getContext() == null) {
            return Unit.INSTANCE;
        }
        Context contextRequireContext = gameFragment3PlayersType1.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        if (gameFragment3PlayersType1.getSharedViewModel().getGameState().isDay()) {
            gameFragment3PlayersType1.getSharedViewModel().getGameState().setDay(false);
            gameFragment3PlayersType1.getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.Night.getValue(), 0, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
            gameFragment3PlayersType1.getBinding().dayNightImageView.setImageResource(R.drawable.moon);
        } else {
            gameFragment3PlayersType1.getSharedViewModel().getGameState().setDay(true);
            gameFragment3PlayersType1.getSharedViewModel().getGameState().getEvents().add(new MTGameEvent(null, MTEvent.Day.getValue(), 0, null, 0, GameUtils.INSTANCE.getInstance().getCurrentTimestamp()));
            gameFragment3PlayersType1.getBinding().dayNightImageView.setImageResource(R.drawable.sun);
        }
        preferencesManager.saveCurrentGame(gameFragment3PlayersType1.getSharedViewModel().getGameState());
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$4(GameFragment3PlayersType1 gameFragment3PlayersType1) {
        if (gameFragment3PlayersType1.getContext() == null) {
            return Unit.INSTANCE;
        }
        gameFragment3PlayersType1.getSharedViewModel().getGameState().setStartedAt(GameUtils.INSTANCE.getInstance().getCurrentTimestamp());
        Context contextRequireContext = gameFragment3PlayersType1.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        new PreferencesManager(contextRequireContext).saveCurrentGame(gameFragment3PlayersType1.getSharedViewModel().getGameState());
        GameCallback gameCallback = gameFragment3PlayersType1.callback;
        if (gameCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            gameCallback = null;
        }
        gameCallback.startGamePressed();
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$5(final GameFragment3PlayersType1 gameFragment3PlayersType1) {
        if (gameFragment3PlayersType1.getContext() == null || gameFragment3PlayersType1._binding == null) {
            return Unit.INSTANCE;
        }
        gameFragment3PlayersType1.getBinding().customMenuButtonImage.animate().scaleX(1.2f).scaleY(1.2f).setDuration(80L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment3PlayersType1$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                GameFragment3PlayersType1.onCreateView$lambda$5$0(this.f$0);
            }
        });
        gameFragment3PlayersType1.getBinding().overlayView1.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment3PlayersType1$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                GameFragment3PlayersType1.onCreateView$lambda$5$1(this.f$0);
            }
        }, 200L);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$5$0(GameFragment3PlayersType1 gameFragment3PlayersType1) {
        gameFragment3PlayersType1.getBinding().customMenuButtonImage.animate().scaleX(1.0f).scaleY(1.0f).setDuration(80L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$5$1(GameFragment3PlayersType1 gameFragment3PlayersType1) {
        GameCallback gameCallback = gameFragment3PlayersType1.callback;
        if (gameCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            gameCallback = null;
        }
        gameCallback.menuPressed();
    }

    static final void onCreateView$lambda$6(final GameFragment3PlayersType1 gameFragment3PlayersType1, View view) {
        gameFragment3PlayersType1.getBinding().menuButtonBlack.animate().scaleX(1.2f).scaleY(1.2f).setDuration(80L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment3PlayersType1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                GameFragment3PlayersType1.onCreateView$lambda$6$0(this.f$0);
            }
        });
        gameFragment3PlayersType1.getBinding().menuButtonWhite.animate().scaleX(1.2f).scaleY(1.2f).setDuration(80L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment3PlayersType1$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                GameFragment3PlayersType1.onCreateView$lambda$6$1(this.f$0);
            }
        });
        gameFragment3PlayersType1.getBinding().menuButton.animate().scaleX(1.2f).scaleY(1.2f).setDuration(80L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment3PlayersType1$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                GameFragment3PlayersType1.onCreateView$lambda$6$2(this.f$0);
            }
        });
        gameFragment3PlayersType1.getBinding().overlayView1.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment3PlayersType1$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                GameFragment3PlayersType1.onCreateView$lambda$6$3(this.f$0);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$6$0(GameFragment3PlayersType1 gameFragment3PlayersType1) {
        gameFragment3PlayersType1.getBinding().menuButtonBlack.animate().scaleX(1.0f).scaleY(1.0f).setDuration(80L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$6$1(GameFragment3PlayersType1 gameFragment3PlayersType1) {
        gameFragment3PlayersType1.getBinding().menuButtonWhite.animate().scaleX(1.0f).scaleY(1.0f).setDuration(80L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$6$2(GameFragment3PlayersType1 gameFragment3PlayersType1) {
        gameFragment3PlayersType1.getBinding().menuButton.animate().scaleX(1.0f).scaleY(1.0f).setDuration(80L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$6$3(GameFragment3PlayersType1 gameFragment3PlayersType1) {
        GameCallback gameCallback = gameFragment3PlayersType1.callback;
        if (gameCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            gameCallback = null;
        }
        gameCallback.menuPressed();
    }

    static final void onCreateView$lambda$7(GameFragment3PlayersType1 gameFragment3PlayersType1) {
        String str;
        if (gameFragment3PlayersType1.getSharedViewModel().getGameState().getTimerEnabled()) {
            int iTimeLeft = GameUtils.INSTANCE.getInstance().timeLeft(gameFragment3PlayersType1.getSharedViewModel().getGameState());
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
            TimerLeftFragment.Builder rotation = new TimerLeftFragment.Builder().setPositiveButton(new Function1() { // from class: com.studiolaganne.lengendarylens.GameFragment3PlayersType1$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GameFragment3PlayersType1.onCreateView$lambda$7$0((TimerLeftFragment) obj);
                }
            }).setText(str).setRotation(270);
            FragmentManager childFragmentManager = gameFragment3PlayersType1.getChildFragmentManager();
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

    static final boolean onCreateView$lambda$8(GameFragment3PlayersType1 gameFragment3PlayersType1, Handler handler, Runnable runnable, View view, MotionEvent motionEvent) {
        if (gameFragment3PlayersType1.getContext() != null) {
            FragmentGame3PlayersType1Binding fragmentGame3PlayersType1Binding = gameFragment3PlayersType1._binding;
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

    static final void onCreateView$lambda$9(GameFragment3PlayersType1 gameFragment3PlayersType1) {
        if (gameFragment3PlayersType1.globalLayoutListener != null) {
            gameFragment3PlayersType1.getBinding().lifeTotalView1.getViewTreeObserver().removeOnGlobalLayoutListener(gameFragment3PlayersType1.globalLayoutListener);
            gameFragment3PlayersType1.globalLayoutListener = null;
        }
        if (gameFragment3PlayersType1.getActivity() == null || gameFragment3PlayersType1._binding == null) {
            return;
        }
        gameFragment3PlayersType1.getBinding().lifeTotalView1.setOverrideFontSize(gameFragment3PlayersType1.getBinding().lifeTotalView2.textSize());
        gameFragment3PlayersType1.getBinding().lifeTotalView1.requestLayout();
    }

    static final void onHiddenChanged$lambda$0(GameFragment3PlayersType1 gameFragment3PlayersType1, ConstraintLayout constraintLayout) {
        if (gameFragment3PlayersType1._binding == null) {
            return;
        }
        int width = constraintLayout.getWidth() / 2;
        ViewGroup.LayoutParams layoutParams = gameFragment3PlayersType1.getBinding().lifeTotalView1.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.height = (int) (width * 1.5f);
        gameFragment3PlayersType1.getBinding().lifeTotalView1.setLayoutParams(layoutParams2);
        constraintLayout.requestLayout();
    }

    static final void onViewCreated$lambda$1(GameFragment3PlayersType1 gameFragment3PlayersType1) {
        if (gameFragment3PlayersType1._binding == null) {
            return;
        }
        if (gameFragment3PlayersType1.getSharedViewModel().getGameState().isDay()) {
            gameFragment3PlayersType1.getBinding().dayNightImageView.setImageResource(R.drawable.sun);
        } else {
            gameFragment3PlayersType1.getBinding().dayNightImageView.setImageResource(R.drawable.moon);
        }
        gameFragment3PlayersType1.dayNightToggled(gameFragment3PlayersType1.getSharedViewModel().getGameState().getHasDayNight());
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

    public final FragmentGame3PlayersType1Binding getBinding() {
        FragmentGame3PlayersType1Binding fragmentGame3PlayersType1Binding = this._binding;
        Intrinsics.checkNotNull(fragmentGame3PlayersType1Binding);
        return fragmentGame3PlayersType1Binding;
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

    /* JADX WARN: Removed duplicated region for block: B:33:0x02df  */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String borderColor;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentGame3PlayersType1Binding.inflate(inflater, container, false);
        getBinding().constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.GameFragment3PlayersType1$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GameFragment3PlayersType1.onCreateView$lambda$0(view);
            }
        });
        getBinding().planechaseBkg.setOutlineProvider(new CircularOutlineProvider());
        getBinding().planechaseBkg.setClipToOutline(true);
        ImageView planechaseImageView = getBinding().planechaseImageView;
        Intrinsics.checkNotNullExpressionValue(planechaseImageView, "planechaseImageView");
        ViewExtensionsKt.setOnClickWithFade(planechaseImageView, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragment3PlayersType1$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameFragment3PlayersType1.onCreateView$lambda$1(this.f$0);
            }
        });
        getBinding().dayNightBkg.setOutlineProvider(new CircularOutlineProvider());
        getBinding().dayNightBkg.setClipToOutline(true);
        ImageView dayNightImageView = getBinding().dayNightImageView;
        Intrinsics.checkNotNullExpressionValue(dayNightImageView, "dayNightImageView");
        ViewExtensionsKt.setOnClickWithFade(dayNightImageView, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragment3PlayersType1$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameFragment3PlayersType1.onCreateView$lambda$2(this.f$0);
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
        ViewExtensionsKt.setOnClickWithFade(startGameButtonLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragment3PlayersType1$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameFragment3PlayersType1.onCreateView$lambda$4(this.f$0);
            }
        });
        getBinding().customMenuButtonImage.setOnNonTransparentClickListener(new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragment3PlayersType1$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GameFragment3PlayersType1.onCreateView$lambda$5(this.f$0);
            }
        });
        getBinding().overlayView1.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.GameFragment3PlayersType1$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GameFragment3PlayersType1.onCreateView$lambda$6(this.f$0, view);
            }
        });
        final Handler handler = new Handler(Looper.getMainLooper());
        final Runnable runnable = new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment3PlayersType1$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                GameFragment3PlayersType1.onCreateView$lambda$7(this.f$0);
            }
        };
        getBinding().overlayView1.setOnTouchListener(new View.OnTouchListener() { // from class: com.studiolaganne.lengendarylens.GameFragment3PlayersType1$$ExternalSyntheticLambda3
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return GameFragment3PlayersType1.onCreateView$lambda$8(this.f$0, handler, runnable, view, motionEvent);
            }
        });
        List<LifeTotalView> lifeViews = getLifeViews();
        LifeTotalView lifeTotalView1 = getBinding().lifeTotalView1;
        Intrinsics.checkNotNullExpressionValue(lifeTotalView1, "lifeTotalView1");
        lifeViews.add(lifeTotalView1);
        List<LifeTotalView> lifeViews2 = getLifeViews();
        LifeTotalView lifeTotalView3 = getBinding().lifeTotalView3;
        Intrinsics.checkNotNullExpressionValue(lifeTotalView3, "lifeTotalView3");
        lifeViews2.add(lifeTotalView3);
        List<LifeTotalView> lifeViews3 = getLifeViews();
        LifeTotalView lifeTotalView2 = getBinding().lifeTotalView2;
        Intrinsics.checkNotNullExpressionValue(lifeTotalView2, "lifeTotalView2");
        lifeViews3.add(lifeTotalView2);
        setupLifeViews();
        this.globalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.studiolaganne.lengendarylens.GameFragment3PlayersType1$$ExternalSyntheticLambda4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                GameFragment3PlayersType1.onCreateView$lambda$9(this.f$0);
            }
        };
        final ConstraintLayout constraintLayout = getBinding().constraintLayout;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "constraintLayout");
        constraintLayout.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment3PlayersType1$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                GameFragment3PlayersType1.onCreateView$lambda$10(this.f$0, constraintLayout);
            }
        });
        getBinding().lifeTotalView1.getViewTreeObserver().addOnGlobalLayoutListener(this.globalLayoutListener);
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
                getBinding().lifeTotalView2.setBottomMarginMultiplier(0.5f);
                getBinding().lifeTotalView2.setLeftMarginMultiplier(0.5f);
                getBinding().lifeTotalView2.refreshMargins();
                ViewGroup.LayoutParams layoutParams5 = getBinding().lifeTotalView3.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams5, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) layoutParams5;
                layoutParams6.setMargins(0, 0, 0, 0);
                getBinding().lifeTotalView3.setLayoutParams(layoutParams6);
                getBinding().lifeTotalView3.setBottomMarginMultiplier(0.5f);
                getBinding().lifeTotalView3.setRightMarginMultiplier(0.5f);
                getBinding().lifeTotalView3.refreshMargins();
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
        return getBinding().getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.globalLayoutListener != null) {
            getBinding().lifeTotalView1.getViewTreeObserver().removeOnGlobalLayoutListener(this.globalLayoutListener);
            this.globalLayoutListener = null;
        }
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
        constraintLayout.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment3PlayersType1$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                GameFragment3PlayersType1.onHiddenChanged$lambda$0(this.f$0, constraintLayout);
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
            view2.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.GameFragment3PlayersType1$$ExternalSyntheticLambda13
                @Override // java.lang.Runnable
                public final void run() {
                    GameFragment3PlayersType1.onViewCreated$lambda$1(this.f$0);
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
