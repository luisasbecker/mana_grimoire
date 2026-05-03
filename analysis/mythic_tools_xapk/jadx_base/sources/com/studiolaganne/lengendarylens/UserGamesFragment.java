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
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.actions.SearchIntents;
import com.google.gson.Gson;
import com.studiolaganne.lengendarylens.CustomDeleteDialogFragment;
import com.studiolaganne.lengendarylens.DecksDBHelper;
import com.studiolaganne.lengendarylens.databinding.FragmentUserGamesBinding;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: UserGamesFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0001CB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0012H\u0016J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0012H\u0016J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0012H\u0016J\b\u0010\u001f\u001a\u00020\u001aH\u0016J\u001e\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014H\u0016J\u0010\u0010)\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0012H\u0016J\u0012\u0010*\u001a\u00020\u001a2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0006\u0010-\u001a\u00020\u001aJ\u000e\u0010.\u001a\u00020\u001a2\u0006\u0010/\u001a\u000200J\u000e\u00101\u001a\u00020\u001a2\u0006\u00102\u001a\u00020\u0017J\b\u00103\u001a\u00020\u001aH\u0002J&\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u0001092\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\"\u0010:\u001a\u00020\u001a2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00142\n\b\u0002\u0010;\u001a\u0004\u0018\u000100H\u0002J\u001c\u0010<\u001a\b\u0012\u0004\u0012\u00020=0\u00142\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014H\u0002J&\u0010>\u001a\b\u0012\u0004\u0012\u00020=0\u00142\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00120\u00142\b\u0010@\u001a\u0004\u0018\u000100H\u0002J\u000e\u0010A\u001a\u00020\u001a2\u0006\u0010B\u001a\u00020\u000bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010 \u001a\u0010\u0012\f\u0012\n #*\u0004\u0018\u00010\"0\"0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010$\u001a\u0010\u0012\f\u0012\n #*\u0004\u0018\u00010\"0\"0!X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/studiolaganne/lengendarylens/UserGamesFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/studiolaganne/lengendarylens/GamesClickListener;", "<init>", "()V", "_binding", "Lcom/studiolaganne/lengendarylens/databinding/FragmentUserGamesBinding;", "binding", "getBinding", "()Lcom/studiolaganne/lengendarylens/databinding/FragmentUserGamesBinding;", "isCurrentUser", "", "userId", "", "currentUser", "Lcom/studiolaganne/lengendarylens/MTUser;", "games", "", "Lcom/studiolaganne/lengendarylens/MTGame;", "formatsForFilter", "", "Lcom/studiolaganne/lengendarylens/MTFormat;", "currentFilter", "Lcom/studiolaganne/lengendarylens/FilterDefinition;", "shouldShowLoadMore", "onGameItemExpanded", "", "onPublishGameClicked", "game", "onUnpublishGameClicked", "onDeleteGameClicked", "onLoadMoreGamesClicked", "setDetailsLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "gameDetailsLauncher", "onSetClicked", "set", "Lcom/studiolaganne/lengendarylens/MTSet;", "subgames", "onGameClicked", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "resetSearch", "performSearch", SearchIntents.EXTRA_QUERY, "", "updateFilter", "filter", "updateGamesFromRemote", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "updateGames", "lastTimestamp", "groupGamesWithSeparators", "Lcom/studiolaganne/lengendarylens/GameItemHolder;", "groupNewGamesWithSeparators", "newGames", "lastExistingGameTimestamp", "setPrivacyShared", MTApiKt.PRIVACY_TYPE_SHARED, "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UserGamesFragment extends Fragment implements GamesClickListener {
    private FragmentUserGamesBinding _binding;
    private MTUser currentUser;
    private final ActivityResultLauncher<Intent> gameDetailsLauncher;
    private boolean isCurrentUser;
    private final ActivityResultLauncher<Intent> setDetailsLauncher;
    private boolean shouldShowLoadMore;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private int userId = -1;
    private List<MTGame> games = new ArrayList();
    private List<MTFormat> formatsForFilter = CollectionsKt.emptyList();
    private FilterDefinition currentFilter = new FilterDefinition(null, null, null, null, null, null, 63, null);

    /* JADX INFO: compiled from: UserGamesFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/studiolaganne/lengendarylens/UserGamesFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/studiolaganne/lengendarylens/UserGamesFragment;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final UserGamesFragment newInstance() {
            UserGamesFragment userGamesFragment = new UserGamesFragment();
            userGamesFragment.setArguments(new Bundle());
            return userGamesFragment;
        }
    }

    public UserGamesFragment() {
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.UserGamesFragment$$ExternalSyntheticLambda5
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                UserGamesFragment.setDetailsLauncher$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.setDetailsLauncher = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.studiolaganne.lengendarylens.UserGamesFragment$$ExternalSyntheticLambda6
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                UserGamesFragment.gameDetailsLauncher$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(...)");
        this.gameDetailsLauncher = activityResultLauncherRegisterForActivityResult2;
    }

    static final void gameDetailsLauncher$lambda$0(UserGamesFragment userGamesFragment, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        int i = -1;
        if (result.getResultCode() == -1) {
            Intent data = result.getData();
            String stringExtra = data != null ? data.getStringExtra("updatedGame") : null;
            if (stringExtra != null) {
                MTGame mTGame = (MTGame) new Gson().fromJson(stringExtra, MTGame.class);
                Iterator<MTGame> it = userGamesFragment.games.iterator();
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
                    List<MTGame> list = userGamesFragment.games;
                    Intrinsics.checkNotNull(mTGame);
                    list.set(i, mTGame);
                    List<GameItemHolder> listGroupGamesWithSeparators = userGamesFragment.groupGamesWithSeparators(userGamesFragment.games);
                    RecyclerView.Adapter adapter = userGamesFragment.getBinding().gamesRecyclerView.getAdapter();
                    GamesAdapter gamesAdapter = adapter instanceof GamesAdapter ? (GamesAdapter) adapter : null;
                    if (gamesAdapter != null) {
                        gamesAdapter.updateGames(listGroupGamesWithSeparators);
                    }
                    userGamesFragment.getBinding().gamesRecyclerView.setLayoutManager(new LinearLayoutManager(userGamesFragment.getContext()));
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
        for (MTGame mTGame : CollectionsKt.sortedWith(newGames, new Comparator() { // from class: com.studiolaganne.lengendarylens.UserGamesFragment$groupNewGamesWithSeparators$$inlined$sortedByDescending$1
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
    public static final UserGamesFragment newInstance() {
        return INSTANCE.newInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onDeleteGameClicked$lambda$0$0(UserGamesFragment userGamesFragment, MTSet mTSet, String str, boolean z, CustomDeleteDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        if (userGamesFragment.getContext() == null || userGamesFragment._binding == null) {
            return Unit.INSTANCE;
        }
        Context contextRequireContext = userGamesFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (currentUser != null) {
            userGamesFragment.getBinding().loadingAnimationViewRecyclerView.setVisibility(0);
            MTApiKt.getMtApi().deleteSet(currentUser.getId(), mTSet.getId()).enqueue(new UserGamesFragment$onDeleteGameClicked$1$dialog$1$1$1(userGamesFragment, mTSet));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onDeleteGameClicked$lambda$0$1(CustomDeleteDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final Unit onDeleteGameClicked$lambda$1(UserGamesFragment userGamesFragment, MTGame mTGame, String str, boolean z, CustomDeleteDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        if (userGamesFragment.getContext() == null || userGamesFragment._binding == null) {
            return Unit.INSTANCE;
        }
        Context contextRequireContext = userGamesFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (currentUser != null) {
            userGamesFragment.getBinding().loadingAnimationViewRecyclerView.setVisibility(0);
            int id = mTGame.getId();
            MTApiKt.getMtApi().deleteGame(currentUser.getId(), id).enqueue(new UserGamesFragment$onDeleteGameClicked$dialog$1$1$1(userGamesFragment, id));
        }
        return Unit.INSTANCE;
    }

    static final Unit onDeleteGameClicked$lambda$2(CustomDeleteDialogFragment dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismiss();
        return Unit.INSTANCE;
    }

    static final void performSearch$lambda$0(final UserGamesFragment userGamesFragment, String str) {
        if (userGamesFragment.getContext() == null) {
            return;
        }
        Context contextRequireContext = userGamesFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        userGamesFragment.getBinding().loadingAnimationViewRecyclerView.setVisibility(0);
        userGamesFragment.getBinding().noGamesText.setVisibility(8);
        Call callSearchForGamesWithNote$default = MTApi.searchForGamesWithNote$default(MTApiKt.getMtApi(), currentUser != null ? currentUser.getId() : -1, str, null, null, 12, null);
        userGamesFragment.getBinding().noGamesText.setVisibility(8);
        callSearchForGamesWithNote$default.enqueue(new Callback<MTGamesResponse>() { // from class: com.studiolaganne.lengendarylens.UserGamesFragment$performSearch$1$1
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
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (this.this$0.getContext() == null || this.this$0._binding == null) {
                    return;
                }
                this.this$0.getBinding().loadingAnimationViewRecyclerView.setVisibility(8);
                MTGamesResponse mTGamesResponseBody = response.body();
                List<MTGame> games = mTGamesResponseBody != null ? mTGamesResponseBody.getGames() : null;
                if (games != null) {
                    UserGamesFragment userGamesFragment2 = this.this$0;
                    userGamesFragment2.shouldShowLoadMore = false;
                    List listGroupGamesWithSeparators = userGamesFragment2.groupGamesWithSeparators(games);
                    userGamesFragment2.getBinding().gamesRecyclerView.setAdapter(new GamesAdapter(CollectionsKt.toMutableList((Collection) listGroupGamesWithSeparators), false, userGamesFragment2, !userGamesFragment2.isCurrentUser));
                    if (listGroupGamesWithSeparators.isEmpty()) {
                        userGamesFragment2.getBinding().noGamesText.setVisibility(0);
                    } else {
                        userGamesFragment2.getBinding().noGamesText.setVisibility(8);
                    }
                }
            }
        });
    }

    static final void setDetailsLauncher$lambda$0(UserGamesFragment userGamesFragment, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == -1) {
            Intent data = result.getData();
            String stringExtra = data != null ? data.getStringExtra("updatedSet") : null;
            if (stringExtra != null) {
                MTSet mTSet = (MTSet) new Gson().fromJson(stringExtra, MTSet.class);
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = userGamesFragment.games.iterator();
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
                    MTSet set2 = userGamesFragment.games.get(iIntValue).getSet();
                    if (set2 != null) {
                        set2.setNote(mTSet.getNote());
                    }
                    MTSet set3 = userGamesFragment.games.get(iIntValue).getSet();
                    if (set3 != null) {
                        set3.setTags(mTSet.getTags());
                    }
                }
                List<GameItemHolder> listGroupGamesWithSeparators = userGamesFragment.groupGamesWithSeparators(userGamesFragment.games);
                RecyclerView.Adapter adapter = userGamesFragment.getBinding().gamesRecyclerView.getAdapter();
                GamesAdapter gamesAdapter = adapter instanceof GamesAdapter ? (GamesAdapter) adapter : null;
                if (gamesAdapter != null) {
                    gamesAdapter.updateGames(listGroupGamesWithSeparators);
                }
                userGamesFragment.getBinding().gamesRecyclerView.setLayoutManager(new LinearLayoutManager(userGamesFragment.getContext()));
            }
        }
    }

    private final void updateGames(List<MTGame> games, String lastTimestamp) {
        List<MTGame> list = games;
        this.games = CollectionsKt.toMutableList((Collection) CollectionsKt.sortedWith(list, new Comparator() { // from class: com.studiolaganne.lengendarylens.UserGamesFragment$updateGames$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((MTGame) t2).getEnded_at(), ((MTGame) t).getEnded_at());
            }
        }));
        DecksDBHelper.Companion companion = DecksDBHelper.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        List mutableList = CollectionsKt.toMutableList((Collection) companion.getInstance(contextRequireContext).getFormats());
        ArrayList arrayList = new ArrayList();
        for (Object obj : mutableList) {
            MTFormat mTFormat = (MTFormat) obj;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MTGameFormat format = ((MTGame) it.next()).getFormat();
                    if (format != null && format.getId() == mTFormat.getId()) {
                        arrayList.add(obj);
                        break;
                    }
                }
            }
        }
        this.formatsForFilter = CollectionsKt.toMutableList((Collection) arrayList);
        List<GameItemHolder> listGroupGamesWithSeparators = groupGamesWithSeparators(games);
        int i = 0;
        getBinding().gamesRecyclerView.setAdapter(new GamesAdapter(CollectionsKt.toMutableList((Collection) listGroupGamesWithSeparators), false, this, !this.isCurrentUser));
        getBinding().gamesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        if (games.isEmpty()) {
            getBinding().noGamesText.setVisibility(0);
        } else {
            getBinding().noGamesText.setVisibility(8);
        }
        if (lastTimestamp != null) {
            Iterator<GameItemHolder> it2 = listGroupGamesWithSeparators.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    i = -1;
                    break;
                }
                GameItemHolder next = it2.next();
                if (next.getType() == 1) {
                    MTGame game = next.getGame();
                    if (Intrinsics.areEqual(game != null ? game.getEnded_at() : null, lastTimestamp)) {
                        break;
                    }
                }
                i++;
            }
            if (i >= 0) {
                getBinding().gamesRecyclerView.scrollToPosition(i);
            }
        }
    }

    static /* synthetic */ void updateGames$default(UserGamesFragment userGamesFragment, List list, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        userGamesFragment.updateGames(list, str);
    }

    private final void updateGamesFromRemote() {
        MTUser mTUser = this.currentUser;
        if (mTUser != null) {
            getBinding().loadingAnimationViewRecyclerView.setVisibility(0);
            Call<MTGamesResponse> games = this.isCurrentUser ? MTApiKt.getMtApi().getGames(mTUser.getId(), this.currentFilter.getFormatId(), this.currentFilter.getSubformatId(), this.currentFilter.getTagId()) : MTApiKt.getMtApi().getUserGames(mTUser.getId(), this.userId, this.currentFilter.getFormatId(), this.currentFilter.getSubformatId(), this.currentFilter.getTagId());
            getBinding().noGamesText.setVisibility(8);
            games.enqueue(new Callback<MTGamesResponse>() { // from class: com.studiolaganne.lengendarylens.UserGamesFragment$updateGamesFromRemote$1$1
                @Override // retrofit2.Callback
                public void onFailure(Call<MTGamesResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    if (this.this$0.getContext() == null || this.this$0._binding == null) {
                        return;
                    }
                    this.this$0.getBinding().loadingAnimationViewRecyclerView.setVisibility(8);
                    this.this$0.getBinding().noGamesText.setVisibility(0);
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<MTGamesResponse> call, Response<MTGamesResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    this.this$0.getBinding().loadingAnimationViewRecyclerView.setVisibility(8);
                    if (!response.isSuccessful()) {
                        this.this$0.setPrivacyShared(false);
                        return;
                    }
                    MTGamesResponse mTGamesResponseBody = response.body();
                    List<MTGame> games2 = mTGamesResponseBody != null ? mTGamesResponseBody.getGames() : null;
                    if (games2 != null) {
                        UserGamesFragment userGamesFragment = this.this$0;
                        userGamesFragment.games = CollectionsKt.toMutableList((Collection) CollectionsKt.sortedWith(games2, new Comparator() { // from class: com.studiolaganne.lengendarylens.UserGamesFragment$updateGamesFromRemote$1$1$onResponse$lambda$0$$inlined$sortedByDescending$1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.util.Comparator
                            public final int compare(T t, T t2) {
                                return ComparisonsKt.compareValues(((MTGame) t2).getEnded_at(), ((MTGame) t).getEnded_at());
                            }
                        }));
                        userGamesFragment.shouldShowLoadMore = games2.size() >= 20;
                        UserGamesFragment.updateGames$default(userGamesFragment, games2, null, 2, null);
                    }
                }
            });
        }
    }

    public final FragmentUserGamesBinding getBinding() {
        FragmentUserGamesBinding fragmentUserGamesBinding = this._binding;
        Intrinsics.checkNotNull(fragmentUserGamesBinding);
        return fragmentUserGamesBinding;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.userId = arguments.getInt("userId");
            this.isCurrentUser = false;
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
            if (currentUser != null) {
                this.currentUser = currentUser;
                if (currentUser.getId() == this.userId) {
                    this.isCurrentUser = true;
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentUserGamesBinding.inflate(inflater, container, false);
        DecksDBHelper.Companion companion = DecksDBHelper.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        List mutableList = CollectionsKt.toMutableList((Collection) companion.getInstance(contextRequireContext).getFormats());
        ArrayList arrayList = new ArrayList();
        for (Object obj : mutableList) {
            MTFormat mTFormat = (MTFormat) obj;
            List<MTGame> list = this.games;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MTGameFormat format = ((MTGame) it.next()).getFormat();
                    if (format != null && format.getId() == mTFormat.getId()) {
                        arrayList.add(obj);
                        break;
                    }
                }
            }
        }
        this.formatsForFilter = CollectionsKt.toMutableList((Collection) arrayList);
        updateGamesFromRemote();
        return getBinding().getRoot();
    }

    @Override // com.studiolaganne.lengendarylens.GamesClickListener
    public void onDeleteGameClicked(final MTGame game) {
        Intrinsics.checkNotNullParameter(game, "game");
        if (!this.isCurrentUser || getContext() == null || this._binding == null) {
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
            title.setBody(string2).setPositiveButtonCallback(new Function3() { // from class: com.studiolaganne.lengendarylens.UserGamesFragment$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return UserGamesFragment.onDeleteGameClicked$lambda$0$0(this.f$0, set, (String) obj, ((Boolean) obj2).booleanValue(), (CustomDeleteDialogFragment) obj3);
                }
            }).setNegativeButtonCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.UserGamesFragment$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return UserGamesFragment.onDeleteGameClicked$lambda$0$1((CustomDeleteDialogFragment) obj);
                }
            }).build().show(getChildFragmentManager(), "delete_set_dialog");
            return;
        }
        CustomDeleteDialogFragment.Builder builder2 = new CustomDeleteDialogFragment.Builder();
        String string3 = getString(R.string.are_you_sure_title);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomDeleteDialogFragment.Builder title2 = builder2.setTitle(string3);
        String string4 = getString(R.string.delete_game_body);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        title2.setBody(string4).setPositiveButtonCallback(new Function3() { // from class: com.studiolaganne.lengendarylens.UserGamesFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return UserGamesFragment.onDeleteGameClicked$lambda$1(this.f$0, game, (String) obj, ((Boolean) obj2).booleanValue(), (CustomDeleteDialogFragment) obj3);
            }
        }).setNegativeButtonCallback(new Function1() { // from class: com.studiolaganne.lengendarylens.UserGamesFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UserGamesFragment.onDeleteGameClicked$lambda$2((CustomDeleteDialogFragment) obj);
            }
        }).build().show(getChildFragmentManager(), "delete_game_dialog");
    }

    @Override // com.studiolaganne.lengendarylens.GamesClickListener
    public void onGameClicked(MTGame game) {
        Intrinsics.checkNotNullParameter(game, "game");
        if (getContext() != null && this.isCurrentUser) {
            Intent intent = new Intent(requireContext(), (Class<?>) GameDetailsActivity.class);
            intent.putExtra("gameJson", new Gson().toJson(game));
            this.gameDetailsLauncher.launch(intent);
        }
    }

    @Override // com.studiolaganne.lengendarylens.GamesClickListener
    public void onGameItemExpanded() {
    }

    @Override // com.studiolaganne.lengendarylens.GamesClickListener
    public void onLoadMoreGamesClicked() {
        Call userGamesBeforeTimestamp$default;
        if (getContext() == null) {
            return;
        }
        MTGame mTGame = (MTGame) CollectionsKt.lastOrNull((List) this.games);
        String ended_at = mTGame != null ? mTGame.getEnded_at() : null;
        MTUser mTUser = this.currentUser;
        if (mTUser != null) {
            if (this.isCurrentUser) {
                userGamesBeforeTimestamp$default = MTApi.getGamesBeforeTimestamp$default(MTApiKt.getMtApi(), mTUser.getId(), ended_at == null ? "" : ended_at, null, null, null, 28, null);
            } else {
                userGamesBeforeTimestamp$default = MTApi.getUserGamesBeforeTimestamp$default(MTApiKt.getMtApi(), mTUser.getId(), this.userId, ended_at != null ? ended_at : "", null, null, null, 56, null);
            }
            userGamesBeforeTimestamp$default.enqueue(new Callback<MTGamesResponse>() { // from class: com.studiolaganne.lengendarylens.UserGamesFragment$onLoadMoreGamesClicked$1$1
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
                            UserGamesFragment userGamesFragment = this.this$0;
                            String ended_at2 = !userGamesFragment.games.isEmpty() ? ((MTGame) CollectionsKt.last(userGamesFragment.games)).getEnded_at() : null;
                            Log.d("onLoadMoreGamesClicked", "Received new games : " + games);
                            userGamesFragment.games.addAll(CollectionsKt.sortedWith(games, new Comparator() { // from class: com.studiolaganne.lengendarylens.UserGamesFragment$onLoadMoreGamesClicked$1$1$onResponse$lambda$0$$inlined$sortedByDescending$1
                                /* JADX WARN: Multi-variable type inference failed */
                                @Override // java.util.Comparator
                                public final int compare(T t, T t2) {
                                    return ComparisonsKt.compareValues(((MTGame) t2).getEnded_at(), ((MTGame) t).getEnded_at());
                                }
                            }));
                            userGamesFragment.shouldShowLoadMore = games.size() >= 20;
                            List<GameItemHolder> listGroupNewGamesWithSeparators = userGamesFragment.groupNewGamesWithSeparators(games, ended_at2);
                            RecyclerView.Adapter adapter = userGamesFragment.getBinding().gamesRecyclerView.getAdapter();
                            GamesAdapter gamesAdapter = adapter instanceof GamesAdapter ? (GamesAdapter) adapter : null;
                            if (gamesAdapter != null) {
                                gamesAdapter.addMoreGames(listGroupNewGamesWithSeparators);
                                gamesAdapter.setLoadMoreVisible(userGamesFragment.shouldShowLoadMore);
                            }
                        }
                    }
                }
            });
        }
    }

    @Override // com.studiolaganne.lengendarylens.GamesClickListener
    public void onPublishGameClicked(MTGame game) {
        Intrinsics.checkNotNullParameter(game, "game");
        if (!this.isCurrentUser || getContext() == null || this._binding == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (currentUser != null) {
            getBinding().loadingAnimationViewRecyclerView.setVisibility(0);
            MTSet set = game.getSet();
            if (set != null) {
                MTApiKt.getMtApi().publishSet(currentUser.getId(), set.getId()).enqueue(new UserGamesFragment$onPublishGameClicked$1$1$1(this, set));
            } else {
                MTApiKt.getMtApi().publishGame(currentUser.getId(), game.getId()).enqueue(new UserGamesFragment$onPublishGameClicked$1$2$1(this, this, game));
            }
        }
    }

    @Override // com.studiolaganne.lengendarylens.GamesClickListener
    public void onSetClicked(MTSet set, List<MTGame> subgames) {
        Intrinsics.checkNotNullParameter(set, "set");
        Intrinsics.checkNotNullParameter(subgames, "subgames");
        if (getContext() != null && this.isCurrentUser) {
            Intent intent = new Intent(requireContext(), (Class<?>) SetDetailsActivity.class);
            intent.putExtra("setJson", new Gson().toJson(set));
            MTSubgames mTSubgames = new MTSubgames(null, 1, null);
            mTSubgames.setSubgames(CollectionsKt.toMutableList((Collection) subgames));
            intent.putExtra("subgamesJson", new Gson().toJson(mTSubgames));
            this.setDetailsLauncher.launch(intent);
        }
    }

    @Override // com.studiolaganne.lengendarylens.GamesClickListener
    public void onUnpublishGameClicked(MTGame game) {
        Intrinsics.checkNotNullParameter(game, "game");
        if (!this.isCurrentUser || getContext() == null || this._binding == null) {
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MTUser currentUser = new PreferencesManager(contextRequireContext).getCurrentUser();
        if (currentUser != null) {
            getBinding().loadingAnimationViewRecyclerView.setVisibility(0);
            MTSet set = game.getSet();
            if (set != null) {
                MTApiKt.getMtApi().unpublishSet(currentUser.getId(), set.getId()).enqueue(new UserGamesFragment$onUnpublishGameClicked$1$1$1(this, set));
            } else {
                MTApiKt.getMtApi().unpublishGame(currentUser.getId(), game.getId()).enqueue(new UserGamesFragment$onUnpublishGameClicked$1$2$1(this, this, game));
            }
        }
    }

    public final void performSearch(final String query) {
        View view;
        Intrinsics.checkNotNullParameter(query, "query");
        if (!this.isCurrentUser || getContext() == null || (view = getView()) == null) {
            return;
        }
        view.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.UserGamesFragment$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                UserGamesFragment.performSearch$lambda$0(this.f$0, query);
            }
        });
    }

    public final void resetSearch() {
        if (getContext() == null) {
            return;
        }
        this.shouldShowLoadMore = true;
        List<GameItemHolder> listGroupGamesWithSeparators = groupGamesWithSeparators(this.games);
        getBinding().gamesRecyclerView.setAdapter(new GamesAdapter(CollectionsKt.toMutableList((Collection) listGroupGamesWithSeparators), false, this, true ^ this.isCurrentUser));
        if (listGroupGamesWithSeparators.isEmpty()) {
            getBinding().noGamesText.setVisibility(0);
        } else {
            getBinding().noGamesText.setVisibility(8);
        }
    }

    public final void setPrivacyShared(boolean shared) {
        if (this._binding == null || shared) {
            return;
        }
        getBinding().gamesRecyclerView.setVisibility(8);
        getBinding().loadingAnimationViewRecyclerView.setVisibility(8);
        getBinding().noGamesText.setVisibility(8);
        getBinding().privacyMessageText.setVisibility(0);
    }

    public final void updateFilter(FilterDefinition filter) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        this.currentFilter = filter;
        updateGamesFromRemote();
    }
}
