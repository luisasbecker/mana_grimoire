package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.studiolaganne.lengendarylens.databinding.FragmentGameResultBinding;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GameResultFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0006\u0010 \u001a\u00020\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/studiolaganne/lengendarylens/GameResultFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "_binding", "Lcom/studiolaganne/lengendarylens/databinding/FragmentGameResultBinding;", "binding", "getBinding", "()Lcom/studiolaganne/lengendarylens/databinding/FragmentGameResultBinding;", "currentFullGame", "Lcom/studiolaganne/lengendarylens/MTGame;", "currentGame", "Lcom/studiolaganne/lengendarylens/MTCreateGame;", "getCurrentGame", "()Lcom/studiolaganne/lengendarylens/MTCreateGame;", "setCurrentGame", "(Lcom/studiolaganne/lengendarylens/MTCreateGame;)V", "parentActivity", "Lcom/studiolaganne/lengendarylens/GameDetailsActivity;", "onAttach", "", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "updateUI", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GameResultFragment extends Fragment {
    private FragmentGameResultBinding _binding;
    private MTGame currentFullGame;
    private MTCreateGame currentGame;
    private GameDetailsActivity parentActivity;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: GameResultFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/studiolaganne/lengendarylens/GameResultFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/studiolaganne/lengendarylens/GameResultFragment;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final GameResultFragment newInstance() {
            GameResultFragment gameResultFragment = new GameResultFragment();
            gameResultFragment.setArguments(new Bundle());
            return gameResultFragment;
        }
    }

    @JvmStatic
    public static final GameResultFragment newInstance() {
        return INSTANCE.newInstance();
    }

    public final FragmentGameResultBinding getBinding() {
        FragmentGameResultBinding fragmentGameResultBinding = this._binding;
        Intrinsics.checkNotNull(fragmentGameResultBinding);
        return fragmentGameResultBinding;
    }

    public final MTCreateGame getCurrentGame() {
        return this.currentGame;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        try {
            FragmentActivity activity = getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.studiolaganne.lengendarylens.GameDetailsActivity");
            this.parentActivity = (GameDetailsActivity) activity;
        } catch (ClassCastException unused) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.currentFullGame = (MTGame) new Gson().fromJson(arguments.getString("gameJson"), MTGame.class);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentGameResultBinding.inflate(inflater, container, false);
        getBinding().loadingAnimationViewRecyclerView.setVisibility(0);
        updateUI();
        return getBinding().getRoot();
    }

    public final void setCurrentGame(MTCreateGame mTCreateGame) {
        this.currentGame = mTCreateGame;
    }

    public final void updateUI() {
        MTGame mTGame;
        MTCreateGame mTCreateGame;
        if (getContext() == null || this._binding == null || (mTGame = this.currentFullGame) == null || (mTCreateGame = this.currentGame) == null) {
            return;
        }
        getBinding().loadingAnimationViewRecyclerView.setVisibility(8);
        RecyclerView recyclerViewGameResult = getBinding().recyclerViewGameResult;
        Intrinsics.checkNotNullExpressionValue(recyclerViewGameResult, "recyclerViewGameResult");
        recyclerViewGameResult.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewGameResult.setAdapter(new GameResultAdapter(mTCreateGame, mTGame));
    }
}
