package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.studiolaganne.lengendarylens.DecksDBHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GameFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/studiolaganne/lengendarylens/GameFragment$gameFinished$playerResultsAdapter$1", "Lcom/studiolaganne/lengendarylens/PlayerResultClickListener;", "onPlayerResultTapped", "", "item", "Lcom/studiolaganne/lengendarylens/PlayerResultItem;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GameFragment$gameFinished$playerResultsAdapter$1 implements PlayerResultClickListener {
    final /* synthetic */ MTUser $currentUser;
    final /* synthetic */ ConstraintLayout $endOfGameLayout;
    final /* synthetic */ List<PlayerResultItem> $playerResults;
    final /* synthetic */ PreferencesManager $prefs;
    final /* synthetic */ GameFragment this$0;

    GameFragment$gameFinished$playerResultsAdapter$1(ConstraintLayout constraintLayout, GameFragment gameFragment, MTUser mTUser, PreferencesManager preferencesManager, List<PlayerResultItem> list) {
        this.$endOfGameLayout = constraintLayout;
        this.this$0 = gameFragment;
        this.$currentUser = mTUser;
        this.$prefs = preferencesManager;
        this.$playerResults = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x011f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit onPlayerResultTapped$lambda$0$0(GameFragment gameFragment, MTUser mTUser, PreferencesManager preferencesManager, ConstraintLayout constraintLayout) {
        Object next;
        MTUser mTUser2;
        List<MTUser> users;
        Object next2;
        MTDeck mTDeck;
        Object next3;
        Object next4;
        MTCreateGame mTCreateGameCreateMTGameForUpload = GameUtils.INSTANCE.getInstance().createMTGameForUpload(gameFragment.getSharedViewModel().getGameState(), mTUser != null ? mTUser.getId() : -1);
        MTPlaygroup value = gameFragment.getSharedViewModel().getPlaygroup().getValue();
        Map<Integer, List<MTDeck>> allUsersDecks = preferencesManager.getAllUsersDecks();
        List<MTDeck> currentUserDecks = preferencesManager.getCurrentUserDecks();
        Map<Integer, MTDeck> gameSelectedDecks = preferencesManager.getGameSelectedDecks();
        List<MTUser> currentUserCache = preferencesManager.getCurrentUserCache();
        DecksDBHelper.Companion companion = DecksDBHelper.INSTANCE;
        Context contextRequireContext = gameFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        companion.getInstance(contextRequireContext).getFormats();
        List<Player> players = gameFragment.getSharedViewModel().getGameState().getPlayers();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(players, 10));
        int i = 0;
        for (Object obj : players) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Player player = (Player) obj;
            if (player.getUserId() > 0) {
                if (value == null || (users = value.getUsers()) == null) {
                    Iterator<T> it = currentUserCache.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                        if (((MTUser) next).getId() == player.getUserId()) {
                            break;
                        }
                    }
                    mTUser2 = (MTUser) next;
                    if (mTUser2 == null) {
                        mTUser2 = (mTUser == null || player.getUserId() != mTUser.getId()) ? null : mTUser;
                    }
                } else {
                    Iterator<T> it2 = users.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it2.next();
                        if (((MTUser) next2).getId() == player.getUserId()) {
                            break;
                        }
                    }
                    mTUser2 = (MTUser) next2;
                    if (mTUser2 == null) {
                    }
                }
            }
            if (player.getDeckId() > 0) {
                List<MTDeck> list = allUsersDecks.get(Integer.valueOf(player.getUserId()));
                if (list != null) {
                    Iterator<T> it3 = list.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            next4 = null;
                            break;
                        }
                        next4 = it3.next();
                        if (((MTDeck) next4).getId() == player.getDeckId()) {
                            break;
                        }
                    }
                    MTDeck mTDeck2 = (MTDeck) next4;
                    if (mTDeck2 == null) {
                        Iterator<T> it4 = currentUserDecks.iterator();
                        while (true) {
                            if (!it4.hasNext()) {
                                next3 = null;
                                break;
                            }
                            next3 = it4.next();
                            if (((MTDeck) next3).getId() == player.getDeckId()) {
                                break;
                            }
                        }
                        mTDeck = (MTDeck) next3;
                        if (mTDeck == null) {
                            mTDeck = gameSelectedDecks.get(Integer.valueOf(player.getDeckId()));
                        }
                    } else {
                        mTDeck = mTDeck2;
                    }
                }
            } else {
                mTDeck = null;
            }
            MTCreateGamePlayer mTCreateGamePlayer = (MTCreateGamePlayer) CollectionsKt.getOrNull(mTCreateGameCreateMTGameForUpload.getPlayers(), i);
            arrayList.add(new PlayerResultItem(player, mTUser2, mTDeck, mTCreateGamePlayer != null ? mTCreateGamePlayer.getResultid() : 0));
            i = i2;
        }
        ArrayList arrayList2 = arrayList;
        RecyclerView.Adapter adapter = gameFragment.getBinding().playerResultsRecyclerView.getAdapter();
        PlayerResultsAdapter playerResultsAdapter = adapter instanceof PlayerResultsAdapter ? (PlayerResultsAdapter) adapter : null;
        if (playerResultsAdapter != null) {
            playerResultsAdapter.updatePlayerResults(arrayList2);
        }
        constraintLayout.setVisibility(0);
        return Unit.INSTANCE;
    }

    @Override // com.studiolaganne.lengendarylens.PlayerResultClickListener
    public void onPlayerResultTapped(PlayerResultItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.$endOfGameLayout.setVisibility(8);
        View view = this.this$0.getView();
        ConstraintLayout constraintLayout = view != null ? (ConstraintLayout) view.findViewById(R.id.startGameButtonLayout) : null;
        View view2 = this.this$0.getView();
        TextView textView = view2 != null ? (TextView) view2.findViewById(R.id.startGameButtonText) : null;
        if (constraintLayout != null) {
            final GameFragment gameFragment = this.this$0;
            final MTUser mTUser = this.$currentUser;
            final PreferencesManager preferencesManager = this.$prefs;
            final ConstraintLayout constraintLayout2 = this.$endOfGameLayout;
            constraintLayout.setVisibility(0);
            if (textView != null) {
                textView.setText(gameFragment.getString(R.string.done));
            }
            ViewExtensionsKt.setOnClickWithBounce(constraintLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.GameFragment$gameFinished$playerResultsAdapter$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return GameFragment$gameFinished$playerResultsAdapter$1.onPlayerResultTapped$lambda$0$0(gameFragment, mTUser, preferencesManager, constraintLayout2);
                }
            });
        }
        this.this$0.gamePlayerResultsMode = true;
        GameFragmentBase gameFragmentBase = this.this$0.currentGameFragment;
        if (gameFragmentBase != null) {
            gameFragmentBase.enterGamePlayerSummaryMode(this.$playerResults);
        }
    }
}
