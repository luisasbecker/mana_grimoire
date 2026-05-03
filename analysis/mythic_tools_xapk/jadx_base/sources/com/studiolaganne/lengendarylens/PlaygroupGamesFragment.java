package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.actions.SearchIntents;
import com.google.gson.Gson;
import com.studiolaganne.lengendarylens.CustomDeleteDialogFragment;
import com.studiolaganne.lengendarylens.CustomDialogFragment;
import com.studiolaganne.lengendarylens.databinding.FragmentPlaygroupGamesBinding;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: PlaygroupGamesFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 B2\u00020\u00012\u00020\u0002:\u0001BB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0014H\u0016J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0014H\u0016J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0014H\u0016J\u001e\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00140'H\u0016J\u0010\u0010(\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0014H\u0016J\u0010\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020+H\u0016J\u0012\u0010,\u001a\u00020\u00182\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J&\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u0001042\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0006\u00105\u001a\u00020\u0018J\u000e\u00106\u001a\u00020\u00182\u0006\u00107\u001a\u000208J\u000e\u00109\u001a\u00020\u00182\u0006\u0010:\u001a\u00020\u000fJ\b\u0010;\u001a\u00020\u0018H\u0002J\u001c\u0010<\u001a\b\u0012\u0004\u0012\u00020=0'2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00140'H\u0002J&\u0010?\u001a\b\u0012\u0004\u0012\u00020=0'2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00140'2\b\u0010A\u001a\u0004\u0018\u000108H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u0010\u0012\f\u0012\n !*\u0004\u0018\u00010 0 0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\"\u001a\u0010\u0012\f\u0012\n !*\u0004\u0018\u00010 0 0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/studiolaganne/lengendarylens/PlaygroupGamesFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/studiolaganne/lengendarylens/GamesClickListener;", "<init>", "()V", "_binding", "Lcom/studiolaganne/lengendarylens/databinding/FragmentPlaygroupGamesBinding;", "binding", "getBinding", "()Lcom/studiolaganne/lengendarylens/databinding/FragmentPlaygroupGamesBinding;", "currentPlaygroup", "Lcom/studiolaganne/lengendarylens/MTPlaygroup;", "currentUser", "Lcom/studiolaganne/lengendarylens/MTUser;", "currentFilterDefinition", "Lcom/studiolaganne/lengendarylens/FilterDefinition;", "shouldShowLoadMore", "", "currentGames", "", "Lcom/studiolaganne/lengendarylens/MTGame;", "parentActivity", "Lcom/studiolaganne/lengendarylens/PlaygroupDetailsActivity;", "onGameItemExpanded", "", "onLoadMoreGamesClicked", "onPublishGameClicked", "game", "onUnpublishGameClicked", "onDeleteGameClicked", "gameDetailsLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "setDetailsLauncher", "onSetClicked", "set", "Lcom/studiolaganne/lengendarylens/MTSet;", "subgames", "", "onGameClicked", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "resetSearch", "performSearch", SearchIntents.EXTRA_QUERY, "", "updateFilter", "filter", "updateGames", "groupGamesWithSeparators", "Lcom/studiolaganne/lengendarylens/GameItemHolder;", "games", "groupNewGamesWithSeparators", "newGames", "lastExistingGameTimestamp", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PlaygroupGamesFragment extends Fragment implements GamesClickListener {
    private FragmentPlaygroupGamesBinding _binding;
    private FilterDefinition currentFilterDefinition = new FilterDefinition(null, null, null, null, null, null, 63, null);
    private List<MTGame> currentGames = new ArrayList();
    private MTPlaygroup currentPlaygroup;
    private MTUser currentUser;
    private final ActivityResultLauncher<Intent> gameDetailsLauncher;
    private PlaygroupDetailsActivity parentActivity;
    private final ActivityResultLauncher<Intent> setDetailsLauncher;
    private boolean shouldShowLoadMore;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: PlaygroupGamesFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/studiolaganne/lengendarylens/PlaygroupGamesFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/studiolaganne/lengendarylens/PlaygroupGamesFragment;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final PlaygroupGamesFragment newInstance() {
            PlaygroupGamesFragment playgroupGamesFragment = new PlaygroupGamesFragment();
            playgroupGamesFragment.setArguments(new Bundle());
            return playgroupGamesFragment;
        }
    }

    public PlaygroupGamesFragment() {
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.PlaygroupGamesFragment$$ExternalSyntheticLambda6
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                PlaygroupGamesFragment.gameDetailsLauncher$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.gameDetailsLauncher = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.PlaygroupGamesFragment$$ExternalSyntheticLambda7
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                PlaygroupGamesFragment.setDetailsLauncher$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(...)");
        this.setDetailsLauncher = activityResultLauncherRegisterForActivityResult2;
    }

    static final void gameDetailsLauncher$lambda$0(PlaygroupGamesFragment playgroupGamesFragment, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        int i = -1;
        if (result.getResultCode() == -1) {
            Intent data = result.getData();
            String stringExtra = data != null ? data.getStringExtra("updatedGame") : null;
            if (stringExtra != null) {
                MTGame mTGame = (MTGame) new Gson().fromJson(stringExtra, MTGame.class);
                Iterator<MTGame> it = playgroupGamesFragment.currentGames.iterator();
                int i2 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (it.next().getId() == mTGame.getId()) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
                if (i >= 0) {
                    List<MTGame> list = playgroupGamesFragment.currentGames;
                    Intrinsics.checkNotNull(mTGame);
                    list.set(i, mTGame);
                    List<GameItemHolder> listGroupGamesWithSeparators = playgroupGamesFragment.groupGamesWithSeparators(playgroupGamesFragment.currentGames);
                    RecyclerView.Adapter adapter = playgroupGamesFragment.getBinding().gamesRecyclerView.getAdapter();
                    GamesAdapter gamesAdapter = adapter instanceof GamesAdapter ? (GamesAdapter) adapter : null;
                    if (gamesAdapter != null) {
                        gamesAdapter.updateGames(listGroupGamesWithSeparators);
                    }
                    if (listGroupGamesWithSeparators.isEmpty()) {
                        playgroupGamesFragment.getBinding().noGamesText.setVisibility(0);
                    } else {
                        playgroupGamesFragment.getBinding().noGamesText.setVisibility(8);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ba A[PHI: r4 r5 r6
      0x00ba: PHI (r4v8 com.studiolaganne.lengendarylens.GameItemHolder) = (r4v1 com.studiolaganne.lengendarylens.GameItemHolder), (r4v16 com.studiolaganne.lengendarylens.GameItemHolder) binds: [B:13:0x0050, B:27:0x00b5] A[DONT_GENERATE, DONT_INLINE]
      0x00ba: PHI (r5v7 java.lang.Integer) = (r5v1 java.lang.Integer), (r5v12 java.lang.Integer) binds: [B:13:0x0050, B:27:0x00b5] A[DONT_GENERATE, DONT_INLINE]
      0x00ba: PHI (r6v6 java.lang.String) = (r6v1 java.lang.String), (r6v12 java.lang.String) binds: [B:13:0x0050, B:27:0x00b5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0107 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x001c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<GameItemHolder> groupGamesWithSeparators(List<MTGame> games) {
        int i;
        Object objValueOf;
        List<MTGame> subgames;
        if (getContext() == null || this._binding == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        GameItemHolder gameItemHolder = null;
        Integer numValueOf = null;
        String str = null;
        for (MTGame mTGame : games) {
            ServerUtils companion = ServerUtils.INSTANCE.getInstance();
            String ended_at = mTGame.getEnded_at();
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            String relativeTimestamp = companion.formatRelativeTimestamp(ended_at, contextRequireContext);
            if (numValueOf != null) {
                int iIntValue = numValueOf.intValue();
                MTSet set = mTGame.getSet();
                if (set == null) {
                    if (gameItemHolder != null) {
                        arrayList.add(gameItemHolder);
                        gameItemHolder = null;
                        numValueOf = null;
                    }
                    if (!Intrinsics.areEqual(relativeTimestamp, str)) {
                        arrayList.add(new GameItemHolder(2, null, null, 0, null, relativeTimestamp, false, 94, null));
                        str = relativeTimestamp;
                    }
                    i = 1;
                    objValueOf = Boolean.valueOf(arrayList.add(new GameItemHolder(1, mTGame, null, 0, null, null, false, 124, null)));
                    if (objValueOf != null) {
                    }
                } else {
                    if (set.getId() == iIntValue) {
                        objValueOf = (gameItemHolder == null || (subgames = gameItemHolder.getSubgames()) == null) ? null : Boolean.valueOf(subgames.add(mTGame));
                    } else {
                        if (gameItemHolder != null) {
                            arrayList.add(gameItemHolder);
                        }
                        if (!Intrinsics.areEqual(relativeTimestamp, str)) {
                            arrayList.add(new GameItemHolder(2, null, null, 0, null, relativeTimestamp, false, 94, null));
                            str = relativeTimestamp;
                        }
                        numValueOf = Integer.valueOf(set.getId());
                        GameItemHolder gameItemHolder2 = new GameItemHolder(4, null, set, set.getOutOf(), CollectionsKt.mutableListOf(mTGame), null, false, 98, null);
                        objValueOf = Unit.INSTANCE;
                        gameItemHolder = gameItemHolder2;
                    }
                    if (objValueOf != null) {
                        i = 1;
                    }
                    if (objValueOf != null) {
                    }
                }
            } else {
                i = 1;
            }
            if (Intrinsics.areEqual(relativeTimestamp, str)) {
                relativeTimestamp = str;
            } else {
                arrayList.add(new GameItemHolder(2, null, null, 0, null, relativeTimestamp, false, 94, null));
            }
            MTSet set2 = mTGame.getSet();
            if (set2 != null) {
                numValueOf = Integer.valueOf(set2.getId());
                MTGame[] mTGameArr = new MTGame[i];
                mTGameArr[0] = mTGame;
                GameItemHolder gameItemHolder3 = new GameItemHolder(4, null, set2, set2.getOutOf(), CollectionsKt.mutableListOf(mTGameArr), null, false, 98, null);
                Unit unit = Unit.INSTANCE;
                gameItemHolder = gameItemHolder3;
            } else {
                Boolean.valueOf(arrayList.add(new GameItemHolder(1, mTGame, null, 0, null, null, false, 124, null)));
            }
            str = relativeTimestamp;
        }
        if (gameItemHolder != null) {
            arrayList.add(gameItemHolder);
        }
        if (this.shouldShowLoadMore) {
            arrayList.add(new GameItemHolder(3, null, null, 0, null, null, false, 126, null));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e6 A[PHI: r6 r7
      0x00e6: PHI (r6v9 com.studiolaganne.lengendarylens.GameItemHolder) = (r6v4 com.studiolaganne.lengendarylens.GameItemHolder), (r6v16 com.studiolaganne.lengendarylens.GameItemHolder) binds: [B:22:0x009a, B:33:0x00e1] A[DONT_GENERATE, DONT_INLINE]
      0x00e6: PHI (r7v6 java.lang.Integer) = (r7v2 java.lang.Integer), (r7v12 java.lang.Integer) binds: [B:22:0x009a, B:33:0x00e1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0117 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0043 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<GameItemHolder> groupNewGamesWithSeparators(List<MTGame> newGames, String lastExistingGameTimestamp) {
        String relativeTimestamp;
        int i;
        Object objValueOf;
        List<MTGame> subgames;
        if (getContext() == null || this._binding == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        if (lastExistingGameTimestamp != null) {
            ServerUtils companion = ServerUtils.INSTANCE.getInstance();
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            relativeTimestamp = companion.formatRelativeTimestamp(lastExistingGameTimestamp, contextRequireContext);
        } else {
            relativeTimestamp = null;
        }
        GameItemHolder gameItemHolder = null;
        Integer numValueOf = null;
        for (MTGame mTGame : CollectionsKt.sortedWith(newGames, new Comparator() { // from class: com.studiolaganne.lengendarylens.PlaygroupGamesFragment$groupNewGamesWithSeparators$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((MTGame) t2).getEnded_at(), ((MTGame) t).getEnded_at());
            }
        })) {
            ServerUtils companion2 = ServerUtils.INSTANCE.getInstance();
            String ended_at = mTGame.getEnded_at();
            Context contextRequireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
            String relativeTimestamp2 = companion2.formatRelativeTimestamp(ended_at, contextRequireContext2);
            if (!Intrinsics.areEqual(relativeTimestamp2, relativeTimestamp)) {
                if (gameItemHolder != null) {
                    arrayList.add(gameItemHolder);
                    gameItemHolder = null;
                    numValueOf = null;
                }
                arrayList.add(new GameItemHolder(2, null, null, 0, null, relativeTimestamp2, false, 94, null));
                relativeTimestamp = relativeTimestamp2;
            }
            if (numValueOf != null) {
                int iIntValue = numValueOf.intValue();
                MTSet set = mTGame.getSet();
                if (set == null) {
                    if (gameItemHolder != null) {
                        arrayList.add(gameItemHolder);
                        gameItemHolder = null;
                        numValueOf = null;
                    }
                    i = 1;
                    objValueOf = Boolean.valueOf(arrayList.add(new GameItemHolder(1, mTGame, null, 0, null, null, false, 124, null)));
                    if (objValueOf != null) {
                    }
                } else {
                    if (set.getId() == iIntValue) {
                        objValueOf = (gameItemHolder == null || (subgames = gameItemHolder.getSubgames()) == null) ? null : Boolean.valueOf(subgames.add(mTGame));
                    } else {
                        if (gameItemHolder != null) {
                            arrayList.add(gameItemHolder);
                        }
                        Integer numValueOf2 = Integer.valueOf(set.getId());
                        GameItemHolder gameItemHolder2 = new GameItemHolder(4, null, set, set.getOutOf(), CollectionsKt.mutableListOf(mTGame), null, false, 98, null);
                        objValueOf = Unit.INSTANCE;
                        numValueOf = numValueOf2;
                        gameItemHolder = gameItemHolder2;
                    }
                    if (objValueOf != null) {
                        i = 1;
                    }
                    if (objValueOf != null) {
                    }
                }
            } else {
                i = 1;
            }
            MTSet set2 = mTGame.getSet();
            if (set2 != null) {
                numValueOf = Integer.valueOf(set2.getId());
                MTGame[] mTGameArr = new MTGame[i];
                mTGameArr[0] = mTGame;
                GameItemHolder gameItemHolder3 = new GameItemHolder(4, null, set2, set2.getOutOf(), CollectionsKt.mutableListOf(mTGameArr), null, false, 98, null);
                Unit unit = Unit.INSTANCE;
                gameItemHolder = gameItemHolder3;
            } else {
                Boolean.valueOf(arrayList.add(new GameItemHolder(1, mTGame, null, 0, null, null, false, 124, null)));
            }
        }
        if (gameItemHolder != null) {
            arrayList.add(gameItemHolder);
        }
        return arrayList;
    }

    @JvmStatic
    public static final PlaygroupGamesFragment newInstance() {
        return INSTANCE.newInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0(PlaygroupGamesFragment playgroupGamesFragment, MTPlaygroup mTPlaygroup) {
        if (playgroupGamesFragment.getContext() == null) {
            return Unit.INSTANCE;
        }
        Context contextRequireContext = playgroupGamesFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        if (!new PreferencesManager(contextRequireContext).hasGame()) {
            Intent intent = new Intent(playgroupGamesFragment.requireContext(), (Class<?>) MainActivity.class);
            intent.setFlags(603979776);
            intent.putExtra("newGamePlaygroupId", mTPlaygroup.getId());
            playgroupGamesFragment.startActivity(intent);
            return Unit.INSTANCE;
        }
        CustomDialogFragment.Builder builder = new CustomDialogFragment.Builder();
        String string = playgroupGamesFragment.getString(R.string.game_in_progress_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        CustomDialogFragment.Builder title = builder.setTitle(string);
        String string2 = playgroupGamesFragment.getString(R.string.game_in_progress_body_delete_first);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CustomDialogFragment.Builder body = title.setBody(string2);
        String string3 = playgroupGamesFragment.getString(R.string.ok);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDialogFragment.Builder positiveButton = body.setPositiveButton(string3, new Function2() { // from class: com.studiolaganne.lengendarylens.PlaygroupGamesFragment$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return PlaygroupGamesFragment.onCreateView$lambda$0$0$0(((Boolean) obj).booleanValue(), (CustomDialogFragment) obj2);
            }
        });
        FragmentManager childFragmentManager = playgroupGamesFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        positiveButton.show(childFragmentManager, "game_in_progress_dialog");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0$0(boolean z, CustomDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onDeleteGameClicked$lambda$0$0(PlaygroupGamesFragment playgroupGamesFragment, MTSet mTSet, String str, boolean z, CustomDeleteDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        if (playgroupGamesFragment.getContext() == null || playgroupGamesFragment._binding == null) {
            return Unit.INSTANCE;
        }
        Context contextRequireContext = playgroupGamesFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (currentUser != null) {
            ConstraintLayout overlay = playgroupGamesFragment.getBinding().overlay;
            Intrinsics.checkNotNullExpressionValue(overlay, "overlay");
            if (overlay != null) {
                overlay.setVisibility(0);
            }
            MTApiKt.getMtApi().deleteSet(currentUser.getId(), mTSet.getId()).enqueue(new PlaygroupGamesFragment$onDeleteGameClicked$1$dialog$1$1$1(playgroupGamesFragment, overlay, mTSet, currentUser));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onDeleteGameClicked$lambda$0$1(CustomDeleteDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onDeleteGameClicked$lambda$1(PlaygroupGamesFragment playgroupGamesFragment, MTGame mTGame, String str, boolean z, CustomDeleteDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        if (playgroupGamesFragment.getContext() == null || playgroupGamesFragment._binding == null) {
            return Unit.INSTANCE;
        }
        Context contextRequireContext = playgroupGamesFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (currentUser != null) {
            ConstraintLayout overlay = playgroupGamesFragment.getBinding().overlay;
            Intrinsics.checkNotNullExpressionValue(overlay, "overlay");
            if (overlay != null) {
                overlay.setVisibility(0);
            }
            int id = mTGame.getId();
            MTApiKt.getMtApi().deleteGame(currentUser.getId(), id).enqueue(new PlaygroupGamesFragment$onDeleteGameClicked$dialog$1$1$1(playgroupGamesFragment, overlay, id, currentUser));
        }
        return Unit.INSTANCE;
    }

    static final Unit onDeleteGameClicked$lambda$2(CustomDeleteDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final void performSearch$lambda$0(final PlaygroupGamesFragment playgroupGamesFragment, String str) {
        if (playgroupGamesFragment.getContext() == null) {
            return;
        }
        Context contextRequireContext = playgroupGamesFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        playgroupGamesFragment.getBinding().loadingAnimationViewRecyclerView.setVisibility(0);
        playgroupGamesFragment.getBinding().noGamesText.setVisibility(8);
        MTApi mtApi = MTApiKt.getMtApi();
        int id = currentUser != null ? currentUser.getId() : -1;
        MTPlaygroup mTPlaygroup = playgroupGamesFragment.currentPlaygroup;
        Call callSearchForGamesWithNote$default = MTApi.searchForGamesWithNote$default(mtApi, id, str, null, Integer.valueOf(mTPlaygroup != null ? mTPlaygroup.getId() : -1), 4, null);
        playgroupGamesFragment.getBinding().noGamesText.setVisibility(8);
        callSearchForGamesWithNote$default.enqueue(new Callback<MTGamesResponse>() { // from class: com.studiolaganne.lengendarylens.PlaygroupGamesFragment$performSearch$1$1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTGamesResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                if (this.this$0.getContext() == null || this.this$0._binding == null) {
                    return;
                }
                this.this$0.getBinding().loadingAnimationViewRecyclerView.setVisibility(8);
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTGamesResponse> call, Response<MTGamesResponse> response) {
                List<Integer> admins;
                boolean z;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (this.this$0.getContext() == null || this.this$0._binding == null) {
                    return;
                }
                this.this$0.getBinding().loadingAnimationViewRecyclerView.setVisibility(8);
                MTGamesResponse mTGamesResponseBody = response.body();
                Boolean boolValueOf = null;
                List<MTGame> games = mTGamesResponseBody != null ? mTGamesResponseBody.getGames() : null;
                if (games != null) {
                    PlaygroupGamesFragment playgroupGamesFragment2 = this.this$0;
                    MTUser mTUser = currentUser;
                    playgroupGamesFragment2.shouldShowLoadMore = false;
                    List listGroupGamesWithSeparators = playgroupGamesFragment2.groupGamesWithSeparators(games);
                    MTPlaygroup mTPlaygroup2 = playgroupGamesFragment2.currentPlaygroup;
                    if (mTPlaygroup2 != null && (admins = mTPlaygroup2.getAdmins()) != null) {
                        List<Integer> list = admins;
                        if ((list instanceof Collection) && list.isEmpty()) {
                            z = false;
                            boolValueOf = Boolean.valueOf(z);
                        } else {
                            Iterator<T> it = list.iterator();
                            while (it.hasNext()) {
                                int iIntValue = ((Number) it.next()).intValue();
                                if (mTUser != null && iIntValue == mTUser.getId()) {
                                    z = true;
                                    break;
                                }
                            }
                            z = false;
                            boolValueOf = Boolean.valueOf(z);
                        }
                    }
                    playgroupGamesFragment2.getBinding().gamesRecyclerView.setAdapter(new GamesAdapter(CollectionsKt.toMutableList((Collection) listGroupGamesWithSeparators), Intrinsics.areEqual((Object) boolValueOf, (Object) true), playgroupGamesFragment2, false, 8, null));
                    if (listGroupGamesWithSeparators.isEmpty()) {
                        playgroupGamesFragment2.getBinding().noGamesText.setVisibility(0);
                    } else {
                        playgroupGamesFragment2.getBinding().noGamesText.setVisibility(8);
                    }
                }
            }
        });
    }

    static final void setDetailsLauncher$lambda$0(PlaygroupGamesFragment playgroupGamesFragment, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == -1) {
            Intent data = result.getData();
            String stringExtra = data != null ? data.getStringExtra("updatedSet") : null;
            if (stringExtra != null) {
                MTSet mTSet = (MTSet) new Gson().fromJson(stringExtra, MTSet.class);
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = playgroupGamesFragment.currentGames.iterator();
                int i = 0;
                while (it.hasNext()) {
                    int i2 = i + 1;
                    MTSet set = ((MTGame) it.next()).getSet();
                    if (set != null && set.getId() == mTSet.getId()) {
                        arrayList.add(Integer.valueOf(i));
                    }
                    i = i2;
                }
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    int iIntValue = ((Number) it2.next()).intValue();
                    MTSet set2 = playgroupGamesFragment.currentGames.get(iIntValue).getSet();
                    if (set2 != null) {
                        set2.setNote(mTSet.getNote());
                    }
                    MTSet set3 = playgroupGamesFragment.currentGames.get(iIntValue).getSet();
                    if (set3 != null) {
                        set3.setTags(mTSet.getTags());
                    }
                }
                List<GameItemHolder> listGroupGamesWithSeparators = playgroupGamesFragment.groupGamesWithSeparators(playgroupGamesFragment.currentGames);
                RecyclerView.Adapter adapter = playgroupGamesFragment.getBinding().gamesRecyclerView.getAdapter();
                GamesAdapter gamesAdapter = adapter instanceof GamesAdapter ? (GamesAdapter) adapter : null;
                if (gamesAdapter != null) {
                    gamesAdapter.updateGames(listGroupGamesWithSeparators);
                }
                if (listGroupGamesWithSeparators.isEmpty()) {
                    playgroupGamesFragment.getBinding().noGamesText.setVisibility(0);
                } else {
                    playgroupGamesFragment.getBinding().noGamesText.setVisibility(8);
                }
            }
        }
    }

    private final void updateGames() {
        final MTUser mTUser;
        final MTPlaygroup mTPlaygroup = this.currentPlaygroup;
        if (mTPlaygroup == null || (mTUser = this.currentUser) == null) {
            return;
        }
        getBinding().loadingAnimationViewRecyclerView.setVisibility(0);
        Call<MTGamesResponse> playgroupGames = MTApiKt.getMtApi().getPlaygroupGames(mTUser.getId(), mTPlaygroup.getId(), this.currentFilterDefinition.getFormatId(), this.currentFilterDefinition.getSubformatId(), this.currentFilterDefinition.getTagId());
        getBinding().noGamesText.setVisibility(8);
        playgroupGames.enqueue(new Callback<MTGamesResponse>() { // from class: com.studiolaganne.lengendarylens.PlaygroupGamesFragment$updateGames$1$1$1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTGamesResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                if (this.this$0.getContext() == null || this.this$0._binding == null) {
                    return;
                }
                this.this$0.getBinding().noGamesText.setVisibility(0);
                this.this$0.getBinding().loadingAnimationViewRecyclerView.setVisibility(8);
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTGamesResponse> call, Response<MTGamesResponse> response) {
                boolean z;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (this.this$0.getContext() == null || this.this$0._binding == null) {
                    return;
                }
                this.this$0.getBinding().loadingAnimationViewRecyclerView.setVisibility(8);
                if (response.isSuccessful()) {
                    MTGamesResponse mTGamesResponseBody = response.body();
                    List<MTGame> games = mTGamesResponseBody != null ? mTGamesResponseBody.getGames() : null;
                    if (games != null) {
                        PlaygroupGamesFragment playgroupGamesFragment = this.this$0;
                        MTPlaygroup mTPlaygroup2 = mTPlaygroup;
                        MTUser mTUser2 = mTUser;
                        playgroupGamesFragment.currentGames = CollectionsKt.toMutableList((Collection) CollectionsKt.sortedWith(games, new Comparator() { // from class: com.studiolaganne.lengendarylens.PlaygroupGamesFragment$updateGames$1$1$1$onResponse$lambda$0$$inlined$sortedByDescending$1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.util.Comparator
                            public final int compare(T t, T t2) {
                                return ComparisonsKt.compareValues(((MTGame) t2).getEnded_at(), ((MTGame) t).getEnded_at());
                            }
                        }));
                        playgroupGamesFragment.shouldShowLoadMore = games.size() >= 20;
                        List listGroupGamesWithSeparators = playgroupGamesFragment.groupGamesWithSeparators(games);
                        List<Integer> admins = mTPlaygroup2.getAdmins();
                        if ((admins instanceof Collection) && admins.isEmpty()) {
                            z = false;
                        } else {
                            Iterator<T> it = admins.iterator();
                            while (it.hasNext()) {
                                if (((Number) it.next()).intValue() == mTUser2.getId()) {
                                    z = true;
                                    break;
                                }
                            }
                            z = false;
                        }
                        playgroupGamesFragment.getBinding().gamesRecyclerView.setAdapter(new GamesAdapter(CollectionsKt.toMutableList((Collection) listGroupGamesWithSeparators), z, playgroupGamesFragment, false, 8, null));
                        playgroupGamesFragment.getBinding().gamesRecyclerView.setLayoutManager(new LinearLayoutManager(playgroupGamesFragment.getContext()));
                        if (listGroupGamesWithSeparators.isEmpty()) {
                            playgroupGamesFragment.getBinding().noGamesText.setVisibility(0);
                        } else {
                            playgroupGamesFragment.getBinding().noGamesText.setVisibility(8);
                        }
                    }
                }
            }
        });
    }

    public final FragmentPlaygroupGamesBinding getBinding() {
        FragmentPlaygroupGamesBinding fragmentPlaygroupGamesBinding = this._binding;
        Intrinsics.checkNotNull(fragmentPlaygroupGamesBinding);
        return fragmentPlaygroupGamesBinding;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        try {
            FragmentActivity activity = getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.studiolaganne.lengendarylens.PlaygroupDetailsActivity");
            this.parentActivity = (PlaygroupDetailsActivity) activity;
        } catch (ClassCastException unused) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        Object next;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            int i = arguments.getInt("playgroupId");
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            PreferencesManager preferencesManager = new PreferencesManager(contextRequireContext);
            MTUser currentUser = preferencesManager.getCurrentUser();
            if (currentUser != null) {
                List<MTPlaygroup> currentUserPlaygroups = preferencesManager.getCurrentUserPlaygroups();
                this.currentUser = currentUser;
                Iterator<T> it = currentUserPlaygroups.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it.next();
                        if (((MTPlaygroup) next).getId() == i) {
                            break;
                        }
                    }
                }
                this.currentPlaygroup = (MTPlaygroup) next;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentPlaygroupGamesBinding.inflate(inflater, container, false);
        final MTPlaygroup mTPlaygroup = this.currentPlaygroup;
        if (mTPlaygroup != null) {
            ConstraintLayout newGameButtonLayout = getBinding().newGameButtonLayout;
            Intrinsics.checkNotNullExpressionValue(newGameButtonLayout, "newGameButtonLayout");
            ViewExtensionsKt.setOnClickWithFade(newGameButtonLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.PlaygroupGamesFragment$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PlaygroupGamesFragment.onCreateView$lambda$0$0(this.f$0, mTPlaygroup);
                }
            });
        }
        updateGames();
        return getBinding().getRoot();
    }

    @Override // com.studiolaganne.lengendarylens.GamesClickListener
    public void onDeleteGameClicked(final MTGame game) {
        Intrinsics.checkNotNullParameter(game, "game");
        if (getContext() == null || this._binding == null) {
            return;
        }
        final MTSet set = game.getSet();
        if (set != null) {
            CustomDeleteDialogFragment.Builder builder = new CustomDeleteDialogFragment.Builder();
            String string = getString(R.string.are_you_sure_title);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            CustomDeleteDialogFragment.Builder title = builder.setTitle(string);
            String string2 = getString(R.string.delete_set_body);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            title.setBody(string2).setPositiveButtonCallback(new Function3() { // from class: com.studiolaganne.lengendarylens.PlaygroupGamesFragment$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PlaygroupGamesFragment.onDeleteGameClicked$lambda$0$0(this.f$0, set, (String) obj, ((Boolean) obj2).booleanValue(), (CustomDeleteDialogFragment) obj3);
                }
            }).setNegativeButtonCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.PlaygroupGamesFragment$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PlaygroupGamesFragment.onDeleteGameClicked$lambda$0$1((CustomDeleteDialogFragment) obj);
                }
            }).build().show(getChildFragmentManager(), "delete_game_dialog");
            return;
        }
        CustomDeleteDialogFragment.Builder builder2 = new CustomDeleteDialogFragment.Builder();
        String string3 = getString(R.string.are_you_sure_title);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDeleteDialogFragment.Builder title2 = builder2.setTitle(string3);
        String string4 = getString(R.string.delete_game_body);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        title2.setBody(string4).setPositiveButtonCallback(new Function3() { // from class: com.studiolaganne.lengendarylens.PlaygroupGamesFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return PlaygroupGamesFragment.onDeleteGameClicked$lambda$1(this.f$0, game, (String) obj, ((Boolean) obj2).booleanValue(), (CustomDeleteDialogFragment) obj3);
            }
        }).setNegativeButtonCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.PlaygroupGamesFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PlaygroupGamesFragment.onDeleteGameClicked$lambda$2((CustomDeleteDialogFragment) obj);
            }
        }).build().show(getChildFragmentManager(), "delete_game_dialog");
    }

    @Override // com.studiolaganne.lengendarylens.GamesClickListener
    public void onGameClicked(MTGame game) {
        Intrinsics.checkNotNullParameter(game, "game");
        if (getContext() == null) {
            return;
        }
        Intent intent = new Intent(requireContext(), (Class<?>) GameDetailsActivity.class);
        intent.putExtra("gameJson", new Gson().toJson(game));
        this.gameDetailsLauncher.launch(intent);
    }

    @Override // com.studiolaganne.lengendarylens.GamesClickListener
    public void onGameItemExpanded() {
    }

    @Override // com.studiolaganne.lengendarylens.GamesClickListener
    public void onLoadMoreGamesClicked() {
        String ended_at;
        MTPlaygroup mTPlaygroup;
        if (getContext() == null || this._binding == null) {
            return;
        }
        MTGame mTGame = (MTGame) CollectionsKt.lastOrNull((List) this.currentGames);
        if (mTGame == null || (ended_at = mTGame.getEnded_at()) == null) {
            ended_at = "";
        }
        String str = ended_at;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (currentUser == null || (mTPlaygroup = this.currentPlaygroup) == null) {
            return;
        }
        MTApiKt.getMtApi().getPlaygroupGamesBeforeTimestamp(currentUser.getId(), mTPlaygroup.getId(), str, this.currentFilterDefinition.getFormatId(), this.currentFilterDefinition.getSubformatId(), this.currentFilterDefinition.getTagId()).enqueue(new Callback<MTGamesResponse>() { // from class: com.studiolaganne.lengendarylens.PlaygroupGamesFragment$onLoadMoreGamesClicked$1$1$1
            @Override // retrofit2.Callback
            public void onFailure(Call<MTGamesResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<MTGamesResponse> call, Response<MTGamesResponse> response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (this.this$0.getContext() == null || this.this$0._binding == null) {
                    return;
                }
                this.this$0.getBinding().loadingAnimationViewRecyclerView.setVisibility(8);
                if (response.isSuccessful()) {
                    MTGamesResponse mTGamesResponseBody = response.body();
                    List<MTGame> games = mTGamesResponseBody != null ? mTGamesResponseBody.getGames() : null;
                    if (games != null) {
                        PlaygroupGamesFragment playgroupGamesFragment = this.this$0;
                        String ended_at2 = !playgroupGamesFragment.currentGames.isEmpty() ? ((MTGame) CollectionsKt.last(playgroupGamesFragment.currentGames)).getEnded_at() : null;
                        Log.d("onLoadMoreGamesClicked", "Received new games : " + games);
                        playgroupGamesFragment.currentGames.addAll(CollectionsKt.sortedWith(games, new Comparator() { // from class: com.studiolaganne.lengendarylens.PlaygroupGamesFragment$onLoadMoreGamesClicked$1$1$1$onResponse$lambda$0$$inlined$sortedByDescending$1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.util.Comparator
                            public final int compare(T t, T t2) {
                                return ComparisonsKt.compareValues(((MTGame) t2).getEnded_at(), ((MTGame) t).getEnded_at());
                            }
                        }));
                        playgroupGamesFragment.shouldShowLoadMore = games.size() >= 20;
                        List<GameItemHolder> listGroupNewGamesWithSeparators = playgroupGamesFragment.groupNewGamesWithSeparators(games, ended_at2);
                        RecyclerView.Adapter adapter = playgroupGamesFragment.getBinding().gamesRecyclerView.getAdapter();
                        GamesAdapter gamesAdapter = adapter instanceof GamesAdapter ? (GamesAdapter) adapter : null;
                        if (gamesAdapter != null) {
                            gamesAdapter.addMoreGames(listGroupNewGamesWithSeparators);
                            gamesAdapter.setLoadMoreVisible(playgroupGamesFragment.shouldShowLoadMore);
                        }
                    }
                }
            }
        });
    }

    @Override // com.studiolaganne.lengendarylens.GamesClickListener
    public void onPublishGameClicked(MTGame game) {
        Intrinsics.checkNotNullParameter(game, "game");
        if (getContext() == null || this._binding == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (currentUser != null) {
            ConstraintLayout overlay = getBinding().overlay;
            Intrinsics.checkNotNullExpressionValue(overlay, "overlay");
            if (overlay != null) {
                overlay.setVisibility(0);
            }
            MTSet set = game.getSet();
            if (set != null) {
                MTApiKt.getMtApi().publishSet(currentUser.getId(), set.getId()).enqueue(new PlaygroupGamesFragment$onPublishGameClicked$1$1$1(this, overlay, set, currentUser));
            } else {
                MTApiKt.getMtApi().publishGame(currentUser.getId(), game.getId()).enqueue(new PlaygroupGamesFragment$onPublishGameClicked$1$2$1(this, this, overlay, game, currentUser));
            }
        }
    }

    @Override // com.studiolaganne.lengendarylens.GamesClickListener
    public void onSetClicked(MTSet set, List<MTGame> subgames) {
        Intrinsics.checkNotNullParameter(set, "set");
        Intrinsics.checkNotNullParameter(subgames, "subgames");
        if (getContext() == null) {
            return;
        }
        Intent intent = new Intent(requireContext(), (Class<?>) SetDetailsActivity.class);
        intent.putExtra("setJson", new Gson().toJson(set));
        MTSubgames mTSubgames = new MTSubgames(null, 1, null);
        mTSubgames.setSubgames(CollectionsKt.toMutableList((Collection) subgames));
        intent.putExtra("subgamesJson", new Gson().toJson(mTSubgames));
        this.setDetailsLauncher.launch(intent);
    }

    @Override // com.studiolaganne.lengendarylens.GamesClickListener
    public void onUnpublishGameClicked(MTGame game) {
        Intrinsics.checkNotNullParameter(game, "game");
        if (getContext() == null || this._binding == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (currentUser != null) {
            ConstraintLayout overlay = getBinding().overlay;
            Intrinsics.checkNotNullExpressionValue(overlay, "overlay");
            if (overlay != null) {
                overlay.setVisibility(0);
            }
            MTSet set = game.getSet();
            if (set != null) {
                MTApiKt.getMtApi().unpublishSet(currentUser.getId(), set.getId()).enqueue(new PlaygroupGamesFragment$onUnpublishGameClicked$1$1$1(this, overlay, set, currentUser));
            } else {
                MTApiKt.getMtApi().unpublishGame(currentUser.getId(), game.getId()).enqueue(new PlaygroupGamesFragment$onUnpublishGameClicked$1$2$1(this, this, overlay, game, currentUser));
            }
        }
    }

    public final void performSearch(final String query) {
        View view;
        Intrinsics.checkNotNullParameter(query, "query");
        if (getContext() == null || (view = getView()) == null) {
            return;
        }
        view.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.PlaygroupGamesFragment$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                PlaygroupGamesFragment.performSearch$lambda$0(this.f$0, query);
            }
        });
    }

    public final void resetSearch() {
        Boolean boolValueOf;
        List<Integer> admins;
        boolean z;
        if (getContext() == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        this.shouldShowLoadMore = true;
        List<GameItemHolder> listGroupGamesWithSeparators = groupGamesWithSeparators(this.currentGames);
        MTPlaygroup mTPlaygroup = this.currentPlaygroup;
        if (mTPlaygroup == null || (admins = mTPlaygroup.getAdmins()) == null) {
            boolValueOf = null;
        } else {
            List<Integer> list = admins;
            if ((list instanceof Collection) && list.isEmpty()) {
                z = false;
                boolValueOf = Boolean.valueOf(z);
            } else {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    int iIntValue = ((Number) it.next()).intValue();
                    if (currentUser != null && iIntValue == currentUser.getId()) {
                        z = true;
                        break;
                    }
                }
                z = false;
                boolValueOf = Boolean.valueOf(z);
            }
        }
        getBinding().gamesRecyclerView.setAdapter(new GamesAdapter(CollectionsKt.toMutableList((Collection) listGroupGamesWithSeparators), Intrinsics.areEqual((Object) boolValueOf, (Object) true), this, false, 8, null));
        if (listGroupGamesWithSeparators.isEmpty()) {
            getBinding().noGamesText.setVisibility(0);
        } else {
            getBinding().noGamesText.setVisibility(8);
        }
    }

    public final void updateFilter(FilterDefinition filter) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        this.currentFilterDefinition = filter;
        updateGames();
    }
}
