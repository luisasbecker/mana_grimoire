package com.studiolaganne.lengendarylens;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TheRingDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\nH\u0016J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0019\u001a\u00020\nH\u0002J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0007H\u0002J\u0018\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\nH\u0002J\b\u0010!\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/studiolaganne/lengendarylens/TheRingDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "gameState", "Lcom/studiolaganne/lengendarylens/GameState;", "currentPlayerIndex", "", "onDismissCallback", "Lkotlin/Function1;", "", "newRingLevel", "levelOverlayIds", "", "onStart", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "handleCurrentLevel", "showCurrentLevel", FirebaseAnalytics.Param.LEVEL, "dpToPx", "dp", "context", "Landroid/content/Context;", "enableCloseButton", "dismissWithResult", "Builder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TheRingDialogFragment extends DialogFragment {
    public static final int $stable = 8;
    private int currentPlayerIndex;
    private GameState gameState;
    private Function1<? super Integer, Unit> onDismissCallback;
    private int newRingLevel = -1;
    private final Map<Integer, Integer> levelOverlayIds = MapsKt.mapOf(TuplesKt.to(1, Integer.valueOf(R.id.level1Overlay)), TuplesKt.to(2, Integer.valueOf(R.id.level2Overlay)), TuplesKt.to(3, Integer.valueOf(R.id.level3Overlay)), TuplesKt.to(4, Integer.valueOf(R.id.level4Overlay)));

    /* JADX INFO: compiled from: TheRingDialogFragment.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0007J\u001a\u0010\u000e\u001a\u00020\u00002\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\tJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/studiolaganne/lengendarylens/TheRingDialogFragment$Builder;", "", "<init>", "()V", "gameState", "Lcom/studiolaganne/lengendarylens/GameState;", "currentPlayerIndex", "", "onDismissCallback", "Lkotlin/Function1;", "", "setState", "setCurrentPlayerIndex", FirebaseAnalytics.Param.INDEX, "setOnDismissCallback", "callback", "build", "Lcom/studiolaganne/lengendarylens/TheRingDialogFragment;", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", ViewHierarchyConstants.TAG_KEY, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private int currentPlayerIndex;
        private GameState gameState = new GameState(null, 0, 0, null, false, false, null, false, false, false, 0, 0, 0, null, 0, 0, 0, null, null, null, false, false, false, false, false, false, 0, false, 0, 0, false, false, 0, 0, 0, 0, false, false, null, false, null, 0, 0, false, null, 0, null, 0, -1, 65535, null);
        private Function1<? super Integer, Unit> onDismissCallback;

        public final TheRingDialogFragment build() {
            TheRingDialogFragment theRingDialogFragment = new TheRingDialogFragment();
            theRingDialogFragment.gameState = this.gameState;
            theRingDialogFragment.currentPlayerIndex = this.currentPlayerIndex;
            theRingDialogFragment.onDismissCallback = this.onDismissCallback;
            return theRingDialogFragment;
        }

        public final Builder setCurrentPlayerIndex(int index) {
            this.currentPlayerIndex = index;
            return this;
        }

        public final Builder setOnDismissCallback(Function1<? super Integer, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.onDismissCallback = callback;
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

    private final void dismissWithResult() {
        Function1<? super Integer, Unit> function1 = this.onDismissCallback;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(this.newRingLevel));
        }
        dismiss();
    }

    private final int dpToPx(int dp, Context context) {
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }

    private final void enableCloseButton() {
        ImageView imageView;
        View view = getView();
        if (view != null && (imageView = (ImageView) view.findViewById(R.id.closeImage)) != null) {
            imageView.setAlpha(1.0f);
            imageView.setEnabled(true);
            ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.TheRingDialogFragment$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return TheRingDialogFragment.enableCloseButton$lambda$0$0(this.f$0);
                }
            });
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, "scaleX", 1.0f, 1.1f, 1.0f);
            objectAnimatorOfFloat.setDuration(300L);
            objectAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
            objectAnimatorOfFloat.start();
        }
        View view2 = getView();
        ConstraintLayout constraintLayout = view2 != null ? (ConstraintLayout) view2.findViewById(R.id.cancelButtonLayout) : null;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit enableCloseButton$lambda$0$0(TheRingDialogFragment theRingDialogFragment) {
        theRingDialogFragment.dismissWithResult();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleCurrentLevel() {
        GameState gameState = this.gameState;
        if (gameState == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gameState");
            gameState = null;
        }
        Player player = gameState.getPlayers().get(this.currentPlayerIndex);
        if (player.getTheRingLevel() == -1) {
            this.newRingLevel = 1;
            showCurrentLevel(1);
        } else {
            showCurrentLevel(player.getTheRingLevel());
        }
        enableCloseButton();
    }

    static final void onViewCreated$lambda$0(View view) {
    }

    static final void onViewCreated$lambda$1(TheRingDialogFragment theRingDialogFragment, View view) {
        theRingDialogFragment.newRingLevel = 1;
        theRingDialogFragment.showCurrentLevel(1);
        theRingDialogFragment.enableCloseButton();
    }

    static final void onViewCreated$lambda$2(TheRingDialogFragment theRingDialogFragment, View view) {
        theRingDialogFragment.newRingLevel = 2;
        theRingDialogFragment.showCurrentLevel(2);
        theRingDialogFragment.enableCloseButton();
    }

    static final void onViewCreated$lambda$3(TheRingDialogFragment theRingDialogFragment, View view) {
        theRingDialogFragment.newRingLevel = 3;
        theRingDialogFragment.showCurrentLevel(3);
        theRingDialogFragment.enableCloseButton();
    }

    static final void onViewCreated$lambda$4(TheRingDialogFragment theRingDialogFragment, View view) {
        theRingDialogFragment.newRingLevel = 4;
        theRingDialogFragment.showCurrentLevel(4);
        theRingDialogFragment.enableCloseButton();
    }

    private final void showCurrentLevel(int level) {
        View viewFindViewById;
        for (Map.Entry<Integer, Integer> entry : this.levelOverlayIds.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            int iIntValue2 = entry.getValue().intValue();
            View view = getView();
            if (view != null && (viewFindViewById = view.findViewById(iIntValue2)) != null) {
                viewFindViewById.setVisibility(iIntValue == level ? 0 : 8);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.dialog_the_ring, container, false);
        setCancelable(false);
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        View view;
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(-1, -1);
            window.setFlags(1024, 1024);
            window.setBackgroundDrawable(new ColorDrawable(-16777216));
        }
        if (this.gameState == null || (view = getView()) == null) {
            return;
        }
        view.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.TheRingDialogFragment$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.handleCurrentLevel();
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
        ImageView imageView = (ImageView) view.findViewById(R.id.cardImage);
        if (Intrinsics.areEqual(preferencesManager.getDeviceLanguage(), "fr") && imageView != null) {
            imageView.setImageResource(R.drawable.the_ring_card_fr);
        }
        ImageView imageView2 = (ImageView) view.findViewById(R.id.closeImage);
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.TheRingDialogFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TheRingDialogFragment.onViewCreated$lambda$0(view2);
            }
        });
        if (imageView2 != null) {
            imageView2.setAlpha(0.3f);
        }
        if (imageView2 != null) {
            imageView2.setEnabled(false);
        }
        View viewFindViewById = view.findViewById(R.id.level1View);
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.TheRingDialogFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TheRingDialogFragment.onViewCreated$lambda$1(this.f$0, view2);
                }
            });
        }
        View viewFindViewById2 = view.findViewById(R.id.level2View);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.TheRingDialogFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TheRingDialogFragment.onViewCreated$lambda$2(this.f$0, view2);
                }
            });
        }
        View viewFindViewById3 = view.findViewById(R.id.level3View);
        if (viewFindViewById3 != null) {
            viewFindViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.TheRingDialogFragment$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TheRingDialogFragment.onViewCreated$lambda$3(this.f$0, view2);
                }
            });
        }
        View viewFindViewById4 = view.findViewById(R.id.level4View);
        if (viewFindViewById4 != null) {
            viewFindViewById4.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.TheRingDialogFragment$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TheRingDialogFragment.onViewCreated$lambda$4(this.f$0, view2);
                }
            });
        }
    }
}
