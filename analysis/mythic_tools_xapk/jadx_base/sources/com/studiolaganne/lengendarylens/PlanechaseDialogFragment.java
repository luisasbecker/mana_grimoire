package com.studiolaganne.lengendarylens;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.studiolaganne.lengendarylens.PlanechaseDialogFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: PlanechaseDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\fH\u0016J\u0016\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u0005J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\fH\u0002J\u0010\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"H\u0002J\u0018\u0010#\u001a\u00020\f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0012H\u0002J\b\u0010%\u001a\u00020\fH\u0002J(\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+H\u0002J(\u0010-\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+H\u0002J(\u0010.\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+H\u0002J(\u0010/\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\f0\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/studiolaganne/lengendarylens/PlanechaseDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "gameState", "Lcom/studiolaganne/lengendarylens/GameState;", "getGameState", "()Lcom/studiolaganne/lengendarylens/GameState;", "setGameState", "(Lcom/studiolaganne/lengendarylens/GameState;)V", "planeswalkButtonCallback", "Lkotlin/Function1;", "", "getPlaneswalkButtonCallback", "()Lkotlin/jvm/functions/Function1;", "setPlaneswalkButtonCallback", "(Lkotlin/jvm/functions/Function1;)V", "animating", "", "onStart", "updateState", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "showPlaneSetSelectionDialog", "isSetEnabled", "setCode", "", "saveSetSelection", "isEnabled", "rebuildPlanarDeck", "animateTextViewVariationTopLeft", "newTextView", "rootLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "w", "", "h", "animateTextViewVariationBottomLeft", "animateTextViewVariationBottomRight", "animateTextViewVariationTopRight", "Builder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PlanechaseDialogFragment extends DialogFragment {
    public static final int $stable = 8;
    private boolean animating;
    public GameState gameState;
    public Function1<? super PlanechaseDialogFragment, Unit> planeswalkButtonCallback;

    /* JADX INFO: compiled from: PlanechaseDialogFragment.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u001a\u0010\u000b\u001a\u00020\u00002\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007J\u0006\u0010\r\u001a\u00020\bJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/studiolaganne/lengendarylens/PlanechaseDialogFragment$Builder;", "", "<init>", "()V", "gameState", "Lcom/studiolaganne/lengendarylens/GameState;", "planeswalkButtonCallback", "Lkotlin/Function1;", "Lcom/studiolaganne/lengendarylens/PlanechaseDialogFragment;", "", "setState", "setPlaneswalkButtonCallback", "callback", "build", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", ViewHierarchyConstants.TAG_KEY, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private GameState gameState = new GameState(null, 0, 0, null, false, false, null, false, false, false, 0, 0, 0, null, 0, 0, 0, null, null, null, false, false, false, false, false, false, 0, false, 0, 0, false, false, 0, 0, 0, 0, false, false, null, false, null, 0, 0, false, null, 0, null, 0, -1, 65535, null);
        private Function1<? super PlanechaseDialogFragment, Unit> planeswalkButtonCallback = new Function1() { // from class: com.studiolaganne.lengendarylens.PlanechaseDialogFragment$Builder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PlanechaseDialogFragment.Builder.planeswalkButtonCallback$lambda$0((PlanechaseDialogFragment) obj);
            }
        };

        static final Unit planeswalkButtonCallback$lambda$0(PlanechaseDialogFragment planechaseDialogFragment) {
            Intrinsics.checkNotNullParameter(planechaseDialogFragment, "<unused var>");
            return Unit.INSTANCE;
        }

        public final PlanechaseDialogFragment build() {
            PlanechaseDialogFragment planechaseDialogFragment = new PlanechaseDialogFragment();
            planechaseDialogFragment.setGameState(this.gameState);
            planechaseDialogFragment.setPlaneswalkButtonCallback(this.planeswalkButtonCallback);
            return planechaseDialogFragment;
        }

        public final Builder setPlaneswalkButtonCallback(Function1<? super PlanechaseDialogFragment, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.planeswalkButtonCallback = callback;
            return this;
        }

        public final Builder setState(GameState gameState) {
            Intrinsics.checkNotNullParameter(gameState, "gameState");
            this.gameState = gameState;
            return this;
        }

        public final boolean show(FragmentManager manager, String tag) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(tag, "tag");
            return FragmentExtensionsKt.showSafely(build(), manager, tag);
        }
    }

    private final void animateTextViewVariationBottomLeft(final View newTextView, final ConstraintLayout rootLayout, final float w, final float h) {
        newTextView.animate().x((rootLayout.getWidth() / 2.0f) - (w / 2.0f)).y(rootLayout.getHeight() - (h / 2.0f)).setDuration(200L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.PlanechaseDialogFragment$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                View view = newTextView;
                ConstraintLayout constraintLayout = rootLayout;
                float f = h;
                view.animate().x(0.0f).y(((constraintLayout.getHeight() * 3.0f) / 4.0f) - (f / 2.0f)).setDuration(100L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.PlanechaseDialogFragment$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        PlanechaseDialogFragment.animateTextViewVariationBottomLeft$lambda$0$0(view, constraintLayout, f, f, planechaseDialogFragment);
                    }
                }).start();
            }
        }).start();
        newTextView.animate().rotationBy(1080.0f).setDuration(600L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.PlanechaseDialogFragment$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                PlanechaseDialogFragment.animateTextViewVariationBottomLeft$lambda$1();
            }
        }).setInterpolator(new DecelerateInterpolator()).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateTextViewVariationBottomLeft$lambda$0$0(View view, ConstraintLayout constraintLayout, float f, float f2, final PlanechaseDialogFragment planechaseDialogFragment) {
        view.animate().x((constraintLayout.getWidth() / 2.0f) - (f / 2.0f)).y((constraintLayout.getHeight() / 2.0f) - (f2 / 2.0f)).setDuration(300L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.PlanechaseDialogFragment$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                PlanechaseDialogFragment.animateTextViewVariationBottomLeft$lambda$0$0$0();
            }
        }).start();
        view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(150L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.PlanechaseDialogFragment$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                PlanechaseDialogFragment.animateTextViewVariationBottomLeft$lambda$0$0$1(this.f$0);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateTextViewVariationBottomLeft$lambda$0$0$0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateTextViewVariationBottomLeft$lambda$0$0$1(PlanechaseDialogFragment planechaseDialogFragment) {
        View view = planechaseDialogFragment.getView();
        TextView textView = view != null ? (TextView) view.findViewById(R.id.resultText) : null;
        View view2 = planechaseDialogFragment.getView();
        ConstraintLayout constraintLayout = view2 != null ? (ConstraintLayout) view2.findViewById(R.id.ldicePlaneswalkButtonLayout) : null;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    static final void animateTextViewVariationBottomLeft$lambda$1() {
    }

    private final void animateTextViewVariationBottomRight(final View newTextView, final ConstraintLayout rootLayout, final float w, final float h) {
        newTextView.animate().x((rootLayout.getWidth() / 2.0f) - (w / 2.0f)).y(rootLayout.getHeight() - (h / 2.0f)).setDuration(200L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.PlanechaseDialogFragment$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                View view = newTextView;
                ConstraintLayout constraintLayout = rootLayout;
                float f = w;
                float f2 = h;
                view.animate().x(constraintLayout.getWidth() - (f / 2.0f)).y(((constraintLayout.getHeight() * 3.0f) / 4.0f) - (f2 / 2.0f)).setDuration(100L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.PlanechaseDialogFragment$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        PlanechaseDialogFragment.animateTextViewVariationBottomRight$lambda$0$0(view, constraintLayout, f, f2, planechaseDialogFragment);
                    }
                }).start();
            }
        }).start();
        newTextView.animate().rotationBy(-1080.0f).setDuration(600L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.PlanechaseDialogFragment$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                PlanechaseDialogFragment.animateTextViewVariationBottomRight$lambda$1();
            }
        }).setInterpolator(new DecelerateInterpolator()).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateTextViewVariationBottomRight$lambda$0$0(View view, ConstraintLayout constraintLayout, float f, float f2, final PlanechaseDialogFragment planechaseDialogFragment) {
        view.animate().x((constraintLayout.getWidth() / 2.0f) - (f / 2.0f)).y((constraintLayout.getHeight() / 2.0f) - (f2 / 2.0f)).setDuration(300L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.PlanechaseDialogFragment$$ExternalSyntheticLambda26
            @Override // java.lang.Runnable
            public final void run() {
                PlanechaseDialogFragment.animateTextViewVariationBottomRight$lambda$0$0$0();
            }
        }).start();
        view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(150L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.PlanechaseDialogFragment$$ExternalSyntheticLambda27
            @Override // java.lang.Runnable
            public final void run() {
                PlanechaseDialogFragment.animateTextViewVariationBottomRight$lambda$0$0$1(this.f$0);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateTextViewVariationBottomRight$lambda$0$0$0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateTextViewVariationBottomRight$lambda$0$0$1(PlanechaseDialogFragment planechaseDialogFragment) {
        View view = planechaseDialogFragment.getView();
        TextView textView = view != null ? (TextView) view.findViewById(R.id.resultText) : null;
        View view2 = planechaseDialogFragment.getView();
        ConstraintLayout constraintLayout = view2 != null ? (ConstraintLayout) view2.findViewById(R.id.ldicePlaneswalkButtonLayout) : null;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    static final void animateTextViewVariationBottomRight$lambda$1() {
    }

    private final void animateTextViewVariationTopLeft(final View newTextView, final ConstraintLayout rootLayout, final float w, final float h) {
        newTextView.animate().x((rootLayout.getWidth() / 2.0f) - (w / 2.0f)).y(0.0f).setDuration(200L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.PlanechaseDialogFragment$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                View view = newTextView;
                ConstraintLayout constraintLayout = rootLayout;
                float f = h;
                view.animate().x(0.0f).y((constraintLayout.getHeight() / 4.0f) - (f / 2.0f)).setDuration(100L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.PlanechaseDialogFragment$$ExternalSyntheticLambda11
                    @Override // java.lang.Runnable
                    public final void run() {
                        PlanechaseDialogFragment.animateTextViewVariationTopLeft$lambda$0$0(view, constraintLayout, f, f, planechaseDialogFragment);
                    }
                }).start();
            }
        }).start();
        newTextView.animate().rotationBy(1080.0f).setDuration(700L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.PlanechaseDialogFragment$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                PlanechaseDialogFragment.animateTextViewVariationTopLeft$lambda$1();
            }
        }).setInterpolator(new DecelerateInterpolator()).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateTextViewVariationTopLeft$lambda$0$0(View view, ConstraintLayout constraintLayout, float f, float f2, final PlanechaseDialogFragment planechaseDialogFragment) {
        view.animate().x((constraintLayout.getWidth() / 2.0f) - (f / 2.0f)).y((constraintLayout.getHeight() / 2.0f) - (f2 / 2.0f)).setDuration(300L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.PlanechaseDialogFragment$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                PlanechaseDialogFragment.animateTextViewVariationTopLeft$lambda$0$0$0();
            }
        }).start();
        view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(150L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.PlanechaseDialogFragment$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                PlanechaseDialogFragment.animateTextViewVariationTopLeft$lambda$0$0$1(this.f$0);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateTextViewVariationTopLeft$lambda$0$0$0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateTextViewVariationTopLeft$lambda$0$0$1(PlanechaseDialogFragment planechaseDialogFragment) {
        View view = planechaseDialogFragment.getView();
        TextView textView = view != null ? (TextView) view.findViewById(R.id.resultText) : null;
        View view2 = planechaseDialogFragment.getView();
        ConstraintLayout constraintLayout = view2 != null ? (ConstraintLayout) view2.findViewById(R.id.ldicePlaneswalkButtonLayout) : null;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    static final void animateTextViewVariationTopLeft$lambda$1() {
    }

    private final void animateTextViewVariationTopRight(final View newTextView, final ConstraintLayout rootLayout, final float w, final float h) {
        newTextView.animate().x((rootLayout.getWidth() / 2.0f) - (w / 2.0f)).y(0.0f).setDuration(200L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.PlanechaseDialogFragment$$ExternalSyntheticLambda28
            @Override // java.lang.Runnable
            public final void run() {
                View view = newTextView;
                ConstraintLayout constraintLayout = rootLayout;
                float f = w;
                float f2 = h;
                view.animate().x(constraintLayout.getWidth() - (f / 2.0f)).y((constraintLayout.getHeight() / 4.0f) - (f2 / 2.0f)).setDuration(100L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.PlanechaseDialogFragment$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        PlanechaseDialogFragment.animateTextViewVariationTopRight$lambda$0$0(view, constraintLayout, f, f2, planechaseDialogFragment);
                    }
                }).start();
            }
        }).start();
        newTextView.animate().rotationBy(-1080.0f).setDuration(600L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.PlanechaseDialogFragment$$ExternalSyntheticLambda29
            @Override // java.lang.Runnable
            public final void run() {
                PlanechaseDialogFragment.animateTextViewVariationTopRight$lambda$1();
            }
        }).setInterpolator(new DecelerateInterpolator()).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateTextViewVariationTopRight$lambda$0$0(View view, ConstraintLayout constraintLayout, float f, float f2, final PlanechaseDialogFragment planechaseDialogFragment) {
        view.animate().x((constraintLayout.getWidth() / 2.0f) - (f / 2.0f)).y((constraintLayout.getHeight() / 2.0f) - (f2 / 2.0f)).setDuration(300L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.PlanechaseDialogFragment$$ExternalSyntheticLambda30
            @Override // java.lang.Runnable
            public final void run() {
                PlanechaseDialogFragment.animateTextViewVariationTopRight$lambda$0$0$0();
            }
        }).start();
        view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(150L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.PlanechaseDialogFragment$$ExternalSyntheticLambda31
            @Override // java.lang.Runnable
            public final void run() {
                PlanechaseDialogFragment.animateTextViewVariationTopRight$lambda$0$0$1(this.f$0);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateTextViewVariationTopRight$lambda$0$0$0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateTextViewVariationTopRight$lambda$0$0$1(PlanechaseDialogFragment planechaseDialogFragment) {
        View view = planechaseDialogFragment.getView();
        TextView textView = view != null ? (TextView) view.findViewById(R.id.resultText) : null;
        View view2 = planechaseDialogFragment.getView();
        ConstraintLayout constraintLayout = view2 != null ? (ConstraintLayout) view2.findViewById(R.id.ldicePlaneswalkButtonLayout) : null;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    static final void animateTextViewVariationTopRight$lambda$1() {
    }

    private final boolean isSetEnabled(String setCode) {
        return requireContext().getSharedPreferences("planechase_settings", 0).getBoolean("set_" + setCode, true);
    }

    static final void onCreateView$lambda$0(PlanechaseDialogFragment planechaseDialogFragment) {
        if (planechaseDialogFragment.getContext() == null) {
            return;
        }
        Context contextRequireContext = planechaseDialogFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        planechaseDialogFragment.updateState(contextRequireContext, planechaseDialogFragment.getGameState());
    }

    static final Unit onCreateView$lambda$1(PlanechaseDialogFragment planechaseDialogFragment) {
        planechaseDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$2(final PlanechaseDialogFragment planechaseDialogFragment, LoadingImageView loadingImageView) {
        if (planechaseDialogFragment.animating) {
            return Unit.INSTANCE;
        }
        planechaseDialogFragment.animating = true;
        loadingImageView.animate().rotationBy(180.0f).setDuration(1000L).setListener(new AnimatorListenerAdapter() { // from class: com.studiolaganne.lengendarylens.PlanechaseDialogFragment$onCreateView$3$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                super.onAnimationEnd(animation);
                this.this$0.animating = false;
            }
        }).start();
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$3(PlanechaseDialogFragment planechaseDialogFragment) {
        planechaseDialogFragment.getPlaneswalkButtonCallback().invoke(planechaseDialogFragment);
        return Unit.INSTANCE;
    }

    static final void onCreateView$lambda$4(View view, ImageView imageView, TextView textView, ConstraintLayout constraintLayout, View view2) {
        view.setVisibility(8);
        imageView.setVisibility(8);
        textView.setVisibility(8);
        constraintLayout.setVisibility(8);
    }

    static final Unit onCreateView$lambda$5(View view, ImageView imageView, TextView textView, ConstraintLayout constraintLayout, PlanechaseDialogFragment planechaseDialogFragment) {
        view.setVisibility(8);
        imageView.setVisibility(8);
        textView.setVisibility(8);
        constraintLayout.setVisibility(8);
        planechaseDialogFragment.getPlaneswalkButtonCallback().invoke(planechaseDialogFragment);
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$6(PlanechaseDialogFragment planechaseDialogFragment) {
        planechaseDialogFragment.showPlaneSetSelectionDialog();
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$7(View view, ConstraintLayout constraintLayout, final ImageView imageView, TextView textView, final PlanechaseDialogFragment planechaseDialogFragment, final ConstraintLayout constraintLayout2) {
        int iRandom = RangesKt.random(new IntRange(1, 6), Random.INSTANCE);
        view.setVisibility(0);
        constraintLayout.setVisibility(8);
        imageView.setVisibility(0);
        textView.setVisibility(8);
        imageView.setScaleY(0.5f);
        imageView.setScaleX(0.5f);
        imageView.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.PlanechaseDialogFragment$$ExternalSyntheticLambda24
            @Override // java.lang.Runnable
            public final void run() {
                PlanechaseDialogFragment.onCreateView$lambda$7$0(this.f$0, imageView, constraintLayout2);
            }
        });
        if (iRandom == 1) {
            imageView.setImageResource(R.drawable.dice_planeswalk);
            textView.setText(planechaseDialogFragment.getResources().getString(R.string.dice_planeswalk));
            constraintLayout.setAlpha(1.0f);
        } else if (iRandom != 6) {
            imageView.setImageResource(R.drawable.dice_nothing);
            textView.setText(planechaseDialogFragment.getResources().getString(R.string.dice_no_effect));
            constraintLayout.setAlpha(0.0f);
        } else {
            imageView.setImageResource(R.drawable.dice_chaos);
            textView.setText(planechaseDialogFragment.getResources().getString(R.string.dice_chaos));
            constraintLayout.setAlpha(0.0f);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$7$0(PlanechaseDialogFragment planechaseDialogFragment, ImageView imageView, ConstraintLayout constraintLayout) {
        int iRandom = RangesKt.random(new IntRange(1, 4), Random.INSTANCE);
        if (iRandom == 1) {
            Intrinsics.checkNotNull(imageView);
            planechaseDialogFragment.animateTextViewVariationTopLeft(imageView, constraintLayout, imageView.getWidth(), imageView.getHeight());
            return;
        }
        if (iRandom == 2) {
            Intrinsics.checkNotNull(imageView);
            planechaseDialogFragment.animateTextViewVariationBottomLeft(imageView, constraintLayout, imageView.getWidth(), imageView.getHeight());
        } else if (iRandom == 3) {
            Intrinsics.checkNotNull(imageView);
            planechaseDialogFragment.animateTextViewVariationTopRight(imageView, constraintLayout, imageView.getWidth(), imageView.getHeight());
        } else {
            if (iRandom != 4) {
                return;
            }
            Intrinsics.checkNotNull(imageView);
            planechaseDialogFragment.animateTextViewVariationBottomRight(imageView, constraintLayout, imageView.getWidth(), imageView.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void rebuildPlanarDeck() {
        if (getContext() == null) {
            return;
        }
        GameUtils companion = GameUtils.INSTANCE.getInstance();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        getGameState().setPlanechaseSeed(companion.rebuildPlanarDeck(contextRequireContext, getGameState()));
        getGameState().setCurrentPlaneIndex(0);
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        new PreferencesManager(contextRequireContext2).saveCurrentGame(getGameState());
        Context contextRequireContext3 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
        updateState(contextRequireContext3, getGameState());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void saveSetSelection(String setCode, boolean isEnabled) {
        requireContext().getSharedPreferences("planechase_settings", 0).edit().putBoolean("set_" + setCode, isEnabled).apply();
    }

    private final void showPlaneSetSelectionDialog() {
        String name;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        List<CardRecord> allPlanes = MTGDBHelper.INSTANCE.getInstance(contextRequireContext).getAllPlanes();
        List<CardSet> sets = SetsDBHelper.INSTANCE.getInstance(contextRequireContext).getSets();
        List<CardRecord> list = allPlanes;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((CardRecord) it.next()).getSet());
        }
        final List listDistinct = CollectionsKt.distinct(arrayList);
        List list2 = listDistinct;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it2 = list2.iterator();
        while (true) {
            Object obj = null;
            if (!it2.hasNext()) {
                break;
            }
            String str = (String) it2.next();
            Iterator<T> it3 = sets.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                Object next = it3.next();
                if (Intrinsics.areEqual(((CardSet) next).getCode(), str)) {
                    obj = next;
                    break;
                }
            }
            CardSet cardSet = (CardSet) obj;
            if (cardSet == null || (name = cardSet.getName()) == null) {
                name = "Unknown Set (" + str + ")";
            }
            arrayList2.add(name);
        }
        String[] strArr = (String[]) arrayList2.toArray(new String[0]);
        int size = listDistinct.size();
        boolean[] zArr = new boolean[size];
        for (int i = 0; i < size; i++) {
            zArr[i] = isSetEnabled((String) listDistinct.get(i));
        }
        new AlertDialog.Builder(contextRequireContext).setTitle(getResources().getString(R.string.select_planes)).setMultiChoiceItems(strArr, zArr, new DialogInterface.OnMultiChoiceClickListener() { // from class: com.studiolaganne.lengendarylens.PlanechaseDialogFragment$$ExternalSyntheticLambda22
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public final void onClick(DialogInterface dialogInterface, int i2, boolean z) {
                this.f$0.saveSetSelection((String) listDistinct.get(i2), z);
            }
        }).setPositiveButton(getResources().getString(R.string.apply), new DialogInterface.OnClickListener() { // from class: com.studiolaganne.lengendarylens.PlanechaseDialogFragment$$ExternalSyntheticLambda25
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.f$0.rebuildPlanarDeck();
            }
        }).setNegativeButton(getResources().getString(R.string.cancel), (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateState$lambda$0$0(LoadingImageView loadingImageView, String str) {
        if (loadingImageView != null) {
            loadingImageView.loadImage(str);
        }
    }

    public final GameState getGameState() {
        GameState gameState = this.gameState;
        if (gameState != null) {
            return gameState;
        }
        Intrinsics.throwUninitializedPropertyAccessException("gameState");
        return null;
    }

    public final Function1<PlanechaseDialogFragment, Unit> getPlaneswalkButtonCallback() {
        Function1 function1 = this.planeswalkButtonCallback;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("planeswalkButtonCallback");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.dialog_planechase, container, false);
        View viewFindViewById = viewInflate.findViewById(R.id.cardImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        final LoadingImageView loadingImageView = (LoadingImageView) viewFindViewById;
        viewInflate.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.PlanechaseDialogFragment$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                PlanechaseDialogFragment.onCreateView$lambda$0(this.f$0);
            }
        });
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.closeImage);
        Intrinsics.checkNotNull(imageView);
        ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.PlanechaseDialogFragment$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PlanechaseDialogFragment.onCreateView$lambda$1(this.f$0);
            }
        });
        View viewFindViewById2 = viewInflate.findViewById(R.id.flipCardButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade((SquareButton) viewFindViewById2, new Function0() { // from class: com.studiolaganne.lengendarylens.PlanechaseDialogFragment$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PlanechaseDialogFragment.onCreateView$lambda$2(this.f$0, loadingImageView);
            }
        });
        View viewFindViewById3 = viewInflate.findViewById(R.id.planeswalkButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade((ConstraintLayout) viewFindViewById3, new Function0() { // from class: com.studiolaganne.lengendarylens.PlanechaseDialogFragment$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PlanechaseDialogFragment.onCreateView$lambda$3(this.f$0);
            }
        });
        final View viewFindViewById4 = viewInflate.findViewById(R.id.overlay);
        final ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.diceResultImage);
        final TextView textView = (TextView) viewInflate.findViewById(R.id.resultText);
        final ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate.findViewById(R.id.ldicePlaneswalkButtonLayout);
        viewFindViewById4.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.PlanechaseDialogFragment$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlanechaseDialogFragment.onCreateView$lambda$4(viewFindViewById4, imageView2, textView, constraintLayout, view);
            }
        });
        Intrinsics.checkNotNull(constraintLayout);
        ViewExtensionsKt.setOnClickWithFade(constraintLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.PlanechaseDialogFragment$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PlanechaseDialogFragment.onCreateView$lambda$5(viewFindViewById4, imageView2, textView, constraintLayout, this);
            }
        });
        View viewFindViewById5 = viewInflate.findViewById(R.id.rootLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        final ConstraintLayout constraintLayout2 = (ConstraintLayout) viewFindViewById5;
        View viewFindViewById6 = viewInflate.findViewById(R.id.settingsImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade((ImageView) viewFindViewById6, new Function0() { // from class: com.studiolaganne.lengendarylens.PlanechaseDialogFragment$$ExternalSyntheticLambda21
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PlanechaseDialogFragment.onCreateView$lambda$6(this.f$0);
            }
        });
        View viewFindViewById7 = viewInflate.findViewById(R.id.rollButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade((ConstraintLayout) viewFindViewById7, new Function0() { // from class: com.studiolaganne.lengendarylens.PlanechaseDialogFragment$$ExternalSyntheticLambda23
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PlanechaseDialogFragment.onCreateView$lambda$7(viewFindViewById4, constraintLayout, imageView2, textView, this, constraintLayout2);
            }
        });
        setCancelable(false);
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        Window window2;
        super.onStart();
        FragmentActivity activity = getActivity();
        if (activity != null && (window2 = activity.getWindow()) != null) {
            window2.addFlags(128);
        }
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setLayout(-1, -1);
        window.setFlags(1024, 1024);
        window.setBackgroundDrawable(new ColorDrawable(-16777216));
    }

    public final void setGameState(GameState gameState) {
        Intrinsics.checkNotNullParameter(gameState, "<set-?>");
        this.gameState = gameState;
    }

    public final void setPlaneswalkButtonCallback(Function1<? super PlanechaseDialogFragment, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.planeswalkButtonCallback = function1;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateState(final Context context, GameState gameState) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gameState, "gameState");
        setGameState(gameState);
        View view = getView();
        final LoadingImageView loadingImageView = view != null ? (LoadingImageView) view.findViewById(R.id.cardImage) : null;
        List<String> planarDeck = GameUtils.INSTANCE.getInstance().getPlanarDeck();
        if (gameState.getHasPlanechase() && gameState.getCurrentPlaneIndex() < planarDeck.size()) {
            final String str = planarDeck.get(gameState.getCurrentPlaneIndex());
            CardImageCache cardImageCache = CardImageCache.INSTANCE;
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            final String imageUrl = cardImageCache.getImageUrl(contextRequireContext, str, 0);
            if (imageUrl == null) {
                MTApiKt.getMtApi().getCardByScryfallId(str).enqueue(new Callback<MTCardResponse>() { // from class: com.studiolaganne.lengendarylens.PlanechaseDialogFragment$updateState$2$1
                    @Override // retrofit2.Callback
                    public void onFailure(Call<MTCardResponse> call, Throwable t) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(t, "t");
                        Log.d("PlanechaseDialogFragment", "Failed to load card image: " + t.getMessage() + " for scryfallId: " + str);
                    }

                    @Override // retrofit2.Callback
                    public void onResponse(Call<MTCardResponse> call, Response<MTCardResponse> response) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        Intrinsics.checkNotNullParameter(response, "response");
                        if (response.isSuccessful()) {
                            MTCardResponse mTCardResponseBody = response.body();
                            MTFullCard card = mTCardResponseBody != null ? mTCardResponseBody.getCard() : null;
                            String imageUrl2 = card != null ? card.getImageUrl(0) : null;
                            String str2 = imageUrl2;
                            if (str2 == null || str2.length() == 0) {
                                return;
                            }
                            Context context2 = context;
                            if (context2 != null) {
                                CardImageCache.INSTANCE.saveImageUrl(context2, str, imageUrl2, 0);
                            }
                            LoadingImageView loadingImageView2 = loadingImageView;
                            if (loadingImageView2 != null) {
                                loadingImageView2.loadImage(imageUrl2);
                            }
                        }
                    }
                });
                Unit unit = Unit.INSTANCE;
            } else {
                if ((loadingImageView != null ? Boolean.valueOf(loadingImageView.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.PlanechaseDialogFragment$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        PlanechaseDialogFragment.updateState$lambda$0$0(loadingImageView, imageUrl);
                    }
                })) : null) == null) {
                }
            }
        }
        if (loadingImageView != null) {
            loadingImageView.setAutoLoad(false);
        }
        if (loadingImageView != null) {
            loadingImageView.reset();
        }
    }
}
