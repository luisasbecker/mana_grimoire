package com.studiolaganne.lengendarylens;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.studiolaganne.lengendarylens.ArchenemyDialogFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: ArchenemyDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\fH\u0016J\u0016\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u0005J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\fH\u0002J\u0010\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020%H\u0002J\u0018\u0010&\u001a\u00020\f2\u0006\u0010$\u001a\u00020%2\u0006\u0010'\u001a\u00020\u0015H\u0002J\b\u0010(\u001a\u00020\fH\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\f0\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R&\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\f0\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/studiolaganne/lengendarylens/ArchenemyDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "gameState", "Lcom/studiolaganne/lengendarylens/GameState;", "getGameState", "()Lcom/studiolaganne/lengendarylens/GameState;", "setGameState", "(Lcom/studiolaganne/lengendarylens/GameState;)V", "nextSchemeButtonCallback", "Lkotlin/Function1;", "", "getNextSchemeButtonCallback", "()Lkotlin/jvm/functions/Function1;", "setNextSchemeButtonCallback", "(Lkotlin/jvm/functions/Function1;)V", "previousSchemeButtonCallback", "getPreviousSchemeButtonCallback", "setPreviousSchemeButtonCallback", "animating", "", "onStart", "updateState", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "showSchemeSetSelectionDialog", "isSetEnabled", "setCode", "", "saveSetSelection", "isEnabled", "rebuildSchemeDeck", "Builder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ArchenemyDialogFragment extends DialogFragment {
    public static final int $stable = 8;
    private boolean animating;
    public GameState gameState;
    public Function1<? super ArchenemyDialogFragment, Unit> nextSchemeButtonCallback;
    public Function1<? super ArchenemyDialogFragment, Unit> previousSchemeButtonCallback;

    /* JADX INFO: compiled from: ArchenemyDialogFragment.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u001a\u0010\f\u001a\u00020\u00002\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007J\u001a\u0010\u000e\u001a\u00020\u00002\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007J\u0006\u0010\u000f\u001a\u00020\bJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/studiolaganne/lengendarylens/ArchenemyDialogFragment$Builder;", "", "<init>", "()V", "gameState", "Lcom/studiolaganne/lengendarylens/GameState;", "nextSchemeButtonCallback", "Lkotlin/Function1;", "Lcom/studiolaganne/lengendarylens/ArchenemyDialogFragment;", "", "previousSchemeButtonCallback", "setState", "setNextSchemeButtonCallback", "callback", "setPreviousSchemeButtonCallback", "build", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", ViewHierarchyConstants.TAG_KEY, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private GameState gameState = new GameState(null, 0, 0, null, false, false, null, false, false, false, 0, 0, 0, null, 0, 0, 0, null, null, null, false, false, false, false, false, false, 0, false, 0, 0, false, false, 0, 0, 0, 0, false, false, null, false, null, 0, 0, false, null, 0, null, 0, -1, 65535, null);
        private Function1<? super ArchenemyDialogFragment, Unit> nextSchemeButtonCallback = new Function1() { // from class: com.studiolaganne.lengendarylens.ArchenemyDialogFragment$Builder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ArchenemyDialogFragment.Builder.nextSchemeButtonCallback$lambda$0((ArchenemyDialogFragment) obj);
            }
        };
        private Function1<? super ArchenemyDialogFragment, Unit> previousSchemeButtonCallback = new Function1() { // from class: com.studiolaganne.lengendarylens.ArchenemyDialogFragment$Builder$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ArchenemyDialogFragment.Builder.previousSchemeButtonCallback$lambda$0((ArchenemyDialogFragment) obj);
            }
        };

        static final Unit nextSchemeButtonCallback$lambda$0(ArchenemyDialogFragment archenemyDialogFragment) {
            Intrinsics.checkNotNullParameter(archenemyDialogFragment, "<unused var>");
            return Unit.INSTANCE;
        }

        static final Unit previousSchemeButtonCallback$lambda$0(ArchenemyDialogFragment archenemyDialogFragment) {
            Intrinsics.checkNotNullParameter(archenemyDialogFragment, "<unused var>");
            return Unit.INSTANCE;
        }

        public final ArchenemyDialogFragment build() {
            ArchenemyDialogFragment archenemyDialogFragment = new ArchenemyDialogFragment();
            archenemyDialogFragment.setGameState(this.gameState);
            archenemyDialogFragment.setNextSchemeButtonCallback(this.nextSchemeButtonCallback);
            archenemyDialogFragment.setPreviousSchemeButtonCallback(this.previousSchemeButtonCallback);
            return archenemyDialogFragment;
        }

        public final Builder setNextSchemeButtonCallback(Function1<? super ArchenemyDialogFragment, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.nextSchemeButtonCallback = callback;
            return this;
        }

        public final Builder setPreviousSchemeButtonCallback(Function1<? super ArchenemyDialogFragment, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.previousSchemeButtonCallback = callback;
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

    private final boolean isSetEnabled(String setCode) {
        return requireContext().getSharedPreferences("archenemy_settings", 0).getBoolean("set_" + setCode, true);
    }

    static final void onCreateView$lambda$0(ArchenemyDialogFragment archenemyDialogFragment) {
        if (archenemyDialogFragment.getContext() == null) {
            return;
        }
        Context contextRequireContext = archenemyDialogFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        archenemyDialogFragment.updateState(contextRequireContext, archenemyDialogFragment.getGameState());
    }

    static final Unit onCreateView$lambda$1(ArchenemyDialogFragment archenemyDialogFragment) {
        archenemyDialogFragment.getNextSchemeButtonCallback().invoke(archenemyDialogFragment);
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$2(ArchenemyDialogFragment archenemyDialogFragment) {
        archenemyDialogFragment.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$3(final ArchenemyDialogFragment archenemyDialogFragment, LoadingImageView loadingImageView) {
        if (archenemyDialogFragment.animating) {
            return Unit.INSTANCE;
        }
        archenemyDialogFragment.animating = true;
        loadingImageView.animate().rotationBy(180.0f).setDuration(1000L).setListener(new AnimatorListenerAdapter() { // from class: com.studiolaganne.lengendarylens.ArchenemyDialogFragment$onCreateView$4$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                super.onAnimationEnd(animation);
                this.this$0.animating = false;
            }
        }).start();
        return Unit.INSTANCE;
    }

    static final Unit onCreateView$lambda$4(ArchenemyDialogFragment archenemyDialogFragment) {
        archenemyDialogFragment.showSchemeSetSelectionDialog();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void rebuildSchemeDeck() {
        if (getContext() == null) {
            return;
        }
        GameUtils companion = GameUtils.INSTANCE.getInstance();
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        getGameState().setArchenemySeed(companion.rebuildSchemeDeck(contextRequireContext, getGameState()));
        getGameState().setCurrentSchemeIndex(0);
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        new PreferencesManager(contextRequireContext2).saveCurrentGame(getGameState());
        Context contextRequireContext3 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
        updateState(contextRequireContext3, getGameState());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void saveSetSelection(String setCode, boolean isEnabled) {
        requireContext().getSharedPreferences("archenemy_settings", 0).edit().putBoolean("set_" + setCode, isEnabled).apply();
    }

    private final void showSchemeSetSelectionDialog() {
        String name;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        List<CardRecord> allSchemes = MTGDBHelper.INSTANCE.getInstance(contextRequireContext).getAllSchemes();
        List<CardSet> sets = SetsDBHelper.INSTANCE.getInstance(contextRequireContext).getSets();
        List<CardRecord> list = allSchemes;
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
        new AlertDialog.Builder(contextRequireContext).setTitle(getResources().getString(R.string.select_planes)).setMultiChoiceItems(strArr, zArr, new DialogInterface.OnMultiChoiceClickListener() { // from class: com.studiolaganne.lengendarylens.ArchenemyDialogFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public final void onClick(DialogInterface dialogInterface, int i2, boolean z) {
                this.f$0.saveSetSelection((String) listDistinct.get(i2), z);
            }
        }).setPositiveButton(getResources().getString(R.string.apply), new DialogInterface.OnClickListener() { // from class: com.studiolaganne.lengendarylens.ArchenemyDialogFragment$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.f$0.rebuildSchemeDeck();
            }
        }).setNegativeButton(getResources().getString(R.string.cancel), (DialogInterface.OnClickListener) null).show();
    }

    static final Unit updateState$lambda$0(ArchenemyDialogFragment archenemyDialogFragment) {
        archenemyDialogFragment.getPreviousSchemeButtonCallback().invoke(archenemyDialogFragment);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateState$lambda$2$0(LoadingImageView loadingImageView, String str, final ArchenemyDialogFragment archenemyDialogFragment, final String str2) {
        loadingImageView.loadImage(str);
        ViewExtensionsKt.setOnClickWithFade(loadingImageView, new Function0() { // from class: com.studiolaganne.lengendarylens.ArchenemyDialogFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ArchenemyDialogFragment.updateState$lambda$2$0$0(this.f$0, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateState$lambda$2$0$0(ArchenemyDialogFragment archenemyDialogFragment, String str) {
        Context contextRequireContext = archenemyDialogFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        new FullscreenImageURLDialog(contextRequireContext, str).show();
        return Unit.INSTANCE;
    }

    public final GameState getGameState() {
        GameState gameState = this.gameState;
        if (gameState != null) {
            return gameState;
        }
        Intrinsics.throwUninitializedPropertyAccessException("gameState");
        return null;
    }

    public final Function1<ArchenemyDialogFragment, Unit> getNextSchemeButtonCallback() {
        Function1 function1 = this.nextSchemeButtonCallback;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("nextSchemeButtonCallback");
        return null;
    }

    public final Function1<ArchenemyDialogFragment, Unit> getPreviousSchemeButtonCallback() {
        Function1 function1 = this.previousSchemeButtonCallback;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("previousSchemeButtonCallback");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.dialog_archenemy, container, false);
        RecyclerView recyclerView = viewInflate != null ? (RecyclerView) viewInflate.findViewById(R.id.ongoingSchemesRecyclerView) : null;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        }
        View viewFindViewById = viewInflate.findViewById(R.id.cardImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        final LoadingImageView loadingImageView = (LoadingImageView) viewFindViewById;
        viewInflate.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.ArchenemyDialogFragment$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                ArchenemyDialogFragment.onCreateView$lambda$0(this.f$0);
            }
        });
        View viewFindViewById2 = viewInflate.findViewById(R.id.nextButtonLayout);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithBounce((ConstraintLayout) viewFindViewById2, new Function0() { // from class: com.studiolaganne.lengendarylens.ArchenemyDialogFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ArchenemyDialogFragment.onCreateView$lambda$1(this.f$0);
            }
        });
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.closeImage);
        Intrinsics.checkNotNull(imageView);
        ViewExtensionsKt.setOnClickWithFade(imageView, new Function0() { // from class: com.studiolaganne.lengendarylens.ArchenemyDialogFragment$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ArchenemyDialogFragment.onCreateView$lambda$2(this.f$0);
            }
        });
        View viewFindViewById3 = viewInflate.findViewById(R.id.flipCardButton);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade((SquareButton) viewFindViewById3, new Function0() { // from class: com.studiolaganne.lengendarylens.ArchenemyDialogFragment$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ArchenemyDialogFragment.onCreateView$lambda$3(this.f$0, loadingImageView);
            }
        });
        View viewFindViewById4 = viewInflate.findViewById(R.id.settingsImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        ViewExtensionsKt.setOnClickWithFade((ImageView) viewFindViewById4, new Function0() { // from class: com.studiolaganne.lengendarylens.ArchenemyDialogFragment$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ArchenemyDialogFragment.onCreateView$lambda$4(this.f$0);
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

    public final void setNextSchemeButtonCallback(Function1<? super ArchenemyDialogFragment, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.nextSchemeButtonCallback = function1;
    }

    public final void setPreviousSchemeButtonCallback(Function1<? super ArchenemyDialogFragment, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.previousSchemeButtonCallback = function1;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0121  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateState(final Context context, final GameState gameState) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gameState, "gameState");
        setGameState(gameState);
        View view = getView();
        ConstraintLayout constraintLayout = view != null ? (ConstraintLayout) view.findViewById(R.id.backButtonLayout) : null;
        if (gameState.getCurrentSchemeIndex() > 0) {
            if (constraintLayout != null) {
                constraintLayout.setAlpha(1.0f);
            }
            if (constraintLayout != null) {
                constraintLayout.setEnabled(true);
            }
            if (constraintLayout != null) {
                ViewExtensionsKt.setOnClickWithBounce(constraintLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.ArchenemyDialogFragment$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ArchenemyDialogFragment.updateState$lambda$0(this.f$0);
                    }
                });
            }
        } else {
            if (constraintLayout != null) {
                constraintLayout.setAlpha(0.5f);
            }
            if (constraintLayout != null) {
                constraintLayout.setEnabled(false);
            }
            if (constraintLayout != null) {
                ViewExtensionsKt.setOnClickWithBounce(constraintLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.ArchenemyDialogFragment$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                });
            }
        }
        View view2 = getView();
        TextView textView = view2 != null ? (TextView) view2.findViewById(R.id.noOngoingSchemesText) : null;
        View view3 = getView();
        TextView textView2 = view3 != null ? (TextView) view3.findViewById(R.id.ongoingSchemesText) : null;
        View view4 = getView();
        RecyclerView recyclerView = view4 != null ? (RecyclerView) view4.findViewById(R.id.ongoingSchemesRecyclerView) : null;
        if (gameState.getOngoingSchemes().isEmpty()) {
            if (textView != null) {
                textView.setVisibility(0);
            }
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
            }
        } else {
            if (textView != null) {
                textView.setVisibility(8);
            }
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            if (recyclerView != null) {
                recyclerView.setVisibility(0);
            }
            SchemeListAdapter schemeListAdapter = new SchemeListAdapter(gameState.getOngoingSchemes(), new SchemeClickListener() { // from class: com.studiolaganne.lengendarylens.ArchenemyDialogFragment$updateState$adapter$1
                @Override // com.studiolaganne.lengendarylens.SchemeClickListener
                public void onDeleteSchemeClick(String scryfallId) {
                    Intrinsics.checkNotNullParameter(scryfallId, "scryfallId");
                    int iIndexOf = gameState.getOngoingSchemes().indexOf(scryfallId);
                    if (iIndexOf != -1) {
                        gameState.getOngoingSchemes().remove(iIndexOf);
                        Context contextRequireContext = this.this$0.requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                        new PreferencesManager(contextRequireContext).saveCurrentGame(gameState);
                        ArchenemyDialogFragment archenemyDialogFragment = this.this$0;
                        Context contextRequireContext2 = archenemyDialogFragment.requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                        archenemyDialogFragment.updateState(contextRequireContext2, gameState);
                    }
                }

                @Override // com.studiolaganne.lengendarylens.SchemeClickListener
                public void onSchemeClick(final String scryfallId) {
                    Intrinsics.checkNotNullParameter(scryfallId, "scryfallId");
                    CardImageCache cardImageCache = CardImageCache.INSTANCE;
                    Context contextRequireContext = this.this$0.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                    String imageUrl = cardImageCache.getImageUrl(contextRequireContext, scryfallId, 0);
                    if (imageUrl != null) {
                        Context contextRequireContext2 = this.this$0.requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                        new FullscreenImageURLDialog(contextRequireContext2, imageUrl).show();
                    } else {
                        final Context context2 = context;
                        final ArchenemyDialogFragment archenemyDialogFragment = this.this$0;
                        MTApiKt.getMtApi().getCardByScryfallId(scryfallId).enqueue(new Callback<MTCardResponse>() { // from class: com.studiolaganne.lengendarylens.ArchenemyDialogFragment$updateState$adapter$1$onSchemeClick$2$1
                            @Override // retrofit2.Callback
                            public void onFailure(Call<MTCardResponse> call, Throwable t) {
                                Intrinsics.checkNotNullParameter(call, "call");
                                Intrinsics.checkNotNullParameter(t, "t");
                            }

                            @Override // retrofit2.Callback
                            public void onResponse(Call<MTCardResponse> call, Response<MTCardResponse> response) {
                                Intrinsics.checkNotNullParameter(call, "call");
                                Intrinsics.checkNotNullParameter(response, "response");
                                if (response.isSuccessful()) {
                                    MTCardResponse mTCardResponseBody = response.body();
                                    MTFullCard card = mTCardResponseBody != null ? mTCardResponseBody.getCard() : null;
                                    String imageUrl2 = card != null ? card.getImageUrl(0) : null;
                                    String str = imageUrl2;
                                    if (str == null || str.length() == 0) {
                                        return;
                                    }
                                    CardImageCache.INSTANCE.saveImageUrl(context2, scryfallId, imageUrl2, 0);
                                    Context contextRequireContext3 = archenemyDialogFragment.requireContext();
                                    Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
                                    new FullscreenImageURLDialog(contextRequireContext3, imageUrl2).show();
                                }
                            }
                        });
                    }
                }
            });
            if (recyclerView != null) {
                recyclerView.setAdapter(schemeListAdapter);
            }
        }
        View view5 = getView();
        final LoadingImageView loadingImageView = view5 != null ? (LoadingImageView) view5.findViewById(R.id.cardImage) : null;
        List<String> schemeDeck = GameUtils.INSTANCE.getInstance().getSchemeDeck();
        if (gameState.getHasArchenemy() && gameState.getCurrentSchemeIndex() < schemeDeck.size()) {
            String str = schemeDeck.get(gameState.getCurrentSchemeIndex());
            CardImageCache cardImageCache = CardImageCache.INSTANCE;
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            final String imageUrl = cardImageCache.getImageUrl(contextRequireContext, str, 0);
            if (imageUrl == null) {
                MTApiKt.getMtApi().getCardByScryfallId(str).enqueue(new ArchenemyDialogFragment$updateState$4$1(context, loadingImageView, str, this));
                Unit unit = Unit.INSTANCE;
            } else {
                if ((loadingImageView != null ? Boolean.valueOf(loadingImageView.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.ArchenemyDialogFragment$$ExternalSyntheticLambda10
                    @Override // java.lang.Runnable
                    public final void run() {
                        ArchenemyDialogFragment.updateState$lambda$2$0(loadingImageView, imageUrl, this, imageUrl);
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
