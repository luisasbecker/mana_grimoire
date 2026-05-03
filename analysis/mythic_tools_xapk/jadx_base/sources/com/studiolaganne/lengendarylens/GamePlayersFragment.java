package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultCaller;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.studiolaganne.lengendarylens.databinding.FragmentGamePlayersBinding;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: GamePlayersFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000  2\u00020\u0001:\u0002\u001f B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J&\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001e\u001a\u00020\u0012H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/studiolaganne/lengendarylens/GamePlayersFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "sharedViewModel", "Lcom/studiolaganne/lengendarylens/SharedViewModel;", "getSharedViewModel", "()Lcom/studiolaganne/lengendarylens/SharedViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "_binding", "Lcom/studiolaganne/lengendarylens/databinding/FragmentGamePlayersBinding;", "binding", "getBinding", "()Lcom/studiolaganne/lengendarylens/databinding/FragmentGamePlayersBinding;", "callback", "Lcom/studiolaganne/lengendarylens/GamePlayersFragment$PlayersSetupCallback;", "onAttach", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "PlayersSetupCallback", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GamePlayersFragment extends Fragment {
    private FragmentGamePlayersBinding _binding;
    private PlayersSetupCallback callback;

    /* JADX INFO: renamed from: sharedViewModel$delegate, reason: from kotlin metadata */
    private final Lazy sharedViewModel;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: GamePlayersFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/studiolaganne/lengendarylens/GamePlayersFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/studiolaganne/lengendarylens/GamePlayersFragment;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final GamePlayersFragment newInstance() {
            return new GamePlayersFragment();
        }
    }

    /* JADX INFO: compiled from: GamePlayersFragment.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/studiolaganne/lengendarylens/GamePlayersFragment$PlayersSetupCallback;", "", "playersSelected", "", "value", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface PlayersSetupCallback {
        void playersSelected(int value);
    }

    public GamePlayersFragment() {
        final GamePlayersFragment gamePlayersFragment = this;
        final Function0 function0 = null;
        this.sharedViewModel = FragmentViewModelLazyKt.createViewModelLazy(gamePlayersFragment, Reflection.getOrCreateKotlinClass(SharedViewModel.class), new Function0<ViewModelStore>() { // from class: com.studiolaganne.lengendarylens.GamePlayersFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return gamePlayersFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.studiolaganne.lengendarylens.GamePlayersFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? gamePlayersFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.studiolaganne.lengendarylens.GamePlayersFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return gamePlayersFragment.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
    }

    private final SharedViewModel getSharedViewModel() {
        return (SharedViewModel) this.sharedViewModel.getValue();
    }

    @JvmStatic
    public static final GamePlayersFragment newInstance() {
        return INSTANCE.newInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$0$0(final View view, final GamePlayersFragment gamePlayersFragment) {
        view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(80L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.GamePlayersFragment$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                GamePlayersFragment.onCreateView$lambda$0$0$0(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$0$0$0(final GamePlayersFragment gamePlayersFragment, View view) {
        gamePlayersFragment.getSharedViewModel().getNumberOfPlayers().setValue(2);
        view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GamePlayersFragment$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                GamePlayersFragment.onCreateView$lambda$0$0$0$0(this.f$0);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$0$0$0$0(GamePlayersFragment gamePlayersFragment) {
        PlayersSetupCallback playersSetupCallback = gamePlayersFragment.callback;
        if (playersSetupCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            playersSetupCallback = null;
        }
        playersSetupCallback.playersSelected(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$1$0(final View view, final GamePlayersFragment gamePlayersFragment) {
        view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(80L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.GamePlayersFragment$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                GamePlayersFragment.onCreateView$lambda$1$0$0(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$1$0$0(final GamePlayersFragment gamePlayersFragment, View view) {
        gamePlayersFragment.getSharedViewModel().getNumberOfPlayers().setValue(3);
        view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GamePlayersFragment$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                GamePlayersFragment.onCreateView$lambda$1$0$0$0(this.f$0);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$1$0$0$0(GamePlayersFragment gamePlayersFragment) {
        PlayersSetupCallback playersSetupCallback = gamePlayersFragment.callback;
        if (playersSetupCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            playersSetupCallback = null;
        }
        playersSetupCallback.playersSelected(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$2$0(final View view, final GamePlayersFragment gamePlayersFragment) {
        view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(80L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.GamePlayersFragment$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                GamePlayersFragment.onCreateView$lambda$2$0$0(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$2$0$0(final GamePlayersFragment gamePlayersFragment, View view) {
        gamePlayersFragment.getSharedViewModel().getNumberOfPlayers().setValue(4);
        view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GamePlayersFragment$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                GamePlayersFragment.onCreateView$lambda$2$0$0$0(this.f$0);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$2$0$0$0(GamePlayersFragment gamePlayersFragment) {
        PlayersSetupCallback playersSetupCallback = gamePlayersFragment.callback;
        if (playersSetupCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            playersSetupCallback = null;
        }
        playersSetupCallback.playersSelected(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$3$0(final View view, final GamePlayersFragment gamePlayersFragment) {
        view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(80L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.GamePlayersFragment$$ExternalSyntheticLambda26
            @Override // java.lang.Runnable
            public final void run() {
                GamePlayersFragment.onCreateView$lambda$3$0$0(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$3$0$0(final GamePlayersFragment gamePlayersFragment, View view) {
        gamePlayersFragment.getSharedViewModel().getNumberOfPlayers().setValue(5);
        view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GamePlayersFragment$$ExternalSyntheticLambda19
            @Override // java.lang.Runnable
            public final void run() {
                GamePlayersFragment.onCreateView$lambda$3$0$0$0(this.f$0);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$3$0$0$0(GamePlayersFragment gamePlayersFragment) {
        PlayersSetupCallback playersSetupCallback = gamePlayersFragment.callback;
        if (playersSetupCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            playersSetupCallback = null;
        }
        playersSetupCallback.playersSelected(5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$4$0(final View view, final GamePlayersFragment gamePlayersFragment) {
        view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(80L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.GamePlayersFragment$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                GamePlayersFragment.onCreateView$lambda$4$0$0(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$4$0$0(final GamePlayersFragment gamePlayersFragment, View view) {
        gamePlayersFragment.getSharedViewModel().getNumberOfPlayers().setValue(6);
        view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GamePlayersFragment$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                GamePlayersFragment.onCreateView$lambda$4$0$0$0(this.f$0);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$4$0$0$0(GamePlayersFragment gamePlayersFragment) {
        PlayersSetupCallback playersSetupCallback = gamePlayersFragment.callback;
        if (playersSetupCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            playersSetupCallback = null;
        }
        playersSetupCallback.playersSelected(6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$5$0(final View view, final GamePlayersFragment gamePlayersFragment) {
        view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(80L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.GamePlayersFragment$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                GamePlayersFragment.onCreateView$lambda$5$0$0(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$5$0$0(final GamePlayersFragment gamePlayersFragment, View view) {
        gamePlayersFragment.getSharedViewModel().getNumberOfPlayers().setValue(7);
        view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GamePlayersFragment$$ExternalSyntheticLambda18
            @Override // java.lang.Runnable
            public final void run() {
                GamePlayersFragment.onCreateView$lambda$5$0$0$0(this.f$0);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$5$0$0$0(GamePlayersFragment gamePlayersFragment) {
        PlayersSetupCallback playersSetupCallback = gamePlayersFragment.callback;
        if (playersSetupCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            playersSetupCallback = null;
        }
        playersSetupCallback.playersSelected(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$6$0(final View view, final GamePlayersFragment gamePlayersFragment) {
        view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(80L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.GamePlayersFragment$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                GamePlayersFragment.onCreateView$lambda$6$0$0(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$6$0$0(final GamePlayersFragment gamePlayersFragment, View view) {
        gamePlayersFragment.getSharedViewModel().getNumberOfPlayers().setValue(8);
        view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.GamePlayersFragment$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                GamePlayersFragment.onCreateView$lambda$6$0$0$0(this.f$0);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$6$0$0$0(GamePlayersFragment gamePlayersFragment) {
        PlayersSetupCallback playersSetupCallback = gamePlayersFragment.callback;
        if (playersSetupCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            playersSetupCallback = null;
        }
        playersSetupCallback.playersSelected(8);
    }

    public final FragmentGamePlayersBinding getBinding() {
        FragmentGamePlayersBinding fragmentGamePlayersBinding = this._binding;
        Intrinsics.checkNotNull(fragmentGamePlayersBinding);
        return fragmentGamePlayersBinding;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        try {
            ActivityResultCaller parentFragment = getParentFragment();
            Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.studiolaganne.lengendarylens.GamePlayersFragment.PlayersSetupCallback");
            this.callback = (PlayersSetupCallback) parentFragment;
        } catch (ClassCastException unused) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentGamePlayersBinding.inflate(inflater, container, false);
        GameUtils companion = GameUtils.INSTANCE.getInstance();
        ArrayList arrayList = new ArrayList();
        CardView cardView2 = getBinding().cardView2;
        Intrinsics.checkNotNullExpressionValue(cardView2, "cardView2");
        arrayList.add(cardView2);
        CardView cardView3 = getBinding().cardView3;
        Intrinsics.checkNotNullExpressionValue(cardView3, "cardView3");
        arrayList.add(cardView3);
        CardView cardView4 = getBinding().cardView4;
        Intrinsics.checkNotNullExpressionValue(cardView4, "cardView4");
        arrayList.add(cardView4);
        CardView cardView5 = getBinding().cardView5;
        Intrinsics.checkNotNullExpressionValue(cardView5, "cardView5");
        arrayList.add(cardView5);
        CardView cardView6 = getBinding().cardView6;
        Intrinsics.checkNotNullExpressionValue(cardView6, "cardView6");
        arrayList.add(cardView6);
        CardView cardView7 = getBinding().cardView7;
        Intrinsics.checkNotNullExpressionValue(cardView7, "cardView7");
        arrayList.add(cardView7);
        CardView cardView8 = getBinding().cardView8;
        Intrinsics.checkNotNullExpressionValue(cardView8, "cardView8");
        arrayList.add(cardView8);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((CardView) arrayList.get(i)).setCardBackgroundColor(companion.getDefaultColors().get(i).intValue());
        }
        getBinding().cardView2.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.GamePlayersFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                view.animate().scaleX(0.9f).scaleY(0.9f).setDuration(80L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.GamePlayersFragment$$ExternalSyntheticLambda25
                    @Override // java.lang.Runnable
                    public final void run() {
                        GamePlayersFragment.onCreateView$lambda$0$0(view, gamePlayersFragment);
                    }
                });
            }
        });
        getBinding().cardView3.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.GamePlayersFragment$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                view.animate().scaleX(0.9f).scaleY(0.9f).setDuration(80L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.GamePlayersFragment$$ExternalSyntheticLambda12
                    @Override // java.lang.Runnable
                    public final void run() {
                        GamePlayersFragment.onCreateView$lambda$1$0(view, gamePlayersFragment);
                    }
                });
            }
        });
        getBinding().cardView4.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.GamePlayersFragment$$ExternalSyntheticLambda20
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                view.animate().scaleX(0.9f).scaleY(0.9f).setDuration(80L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.GamePlayersFragment$$ExternalSyntheticLambda13
                    @Override // java.lang.Runnable
                    public final void run() {
                        GamePlayersFragment.onCreateView$lambda$2$0(view, gamePlayersFragment);
                    }
                });
            }
        });
        getBinding().cardView5.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.GamePlayersFragment$$ExternalSyntheticLambda21
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                view.animate().scaleX(0.9f).scaleY(0.9f).setDuration(80L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.GamePlayersFragment$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        GamePlayersFragment.onCreateView$lambda$3$0(view, gamePlayersFragment);
                    }
                });
            }
        });
        getBinding().cardView6.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.GamePlayersFragment$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                view.animate().scaleX(0.9f).scaleY(0.9f).setDuration(80L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.GamePlayersFragment$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        GamePlayersFragment.onCreateView$lambda$4$0(view, gamePlayersFragment);
                    }
                });
            }
        });
        getBinding().cardView7.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.GamePlayersFragment$$ExternalSyntheticLambda23
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                view.animate().scaleX(0.9f).scaleY(0.9f).setDuration(80L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.GamePlayersFragment$$ExternalSyntheticLambda10
                    @Override // java.lang.Runnable
                    public final void run() {
                        GamePlayersFragment.onCreateView$lambda$5$0(view, gamePlayersFragment);
                    }
                });
            }
        });
        getBinding().cardView8.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.GamePlayersFragment$$ExternalSyntheticLambda24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                view.animate().scaleX(0.9f).scaleY(0.9f).setDuration(80L).withEndAction(new Runnable() { // from class: com.studiolaganne.lengendarylens.GamePlayersFragment$$ExternalSyntheticLambda27
                    @Override // java.lang.Runnable
                    public final void run() {
                        GamePlayersFragment.onCreateView$lambda$6$0(view, gamePlayersFragment);
                    }
                });
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
