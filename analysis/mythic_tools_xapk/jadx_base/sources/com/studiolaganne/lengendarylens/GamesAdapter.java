package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: GamesAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'B/\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0014\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010J\u0014\u0010\u0011\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010J\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0007J8\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0018\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0018\u0010#\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\"H\u0016J\u0010\u0010%\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"H\u0016J\b\u0010&\u001a\u00020\"H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/studiolaganne/lengendarylens/GamesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "games", "", "Lcom/studiolaganne/lengendarylens/GameItemHolder;", "isPlaygroupAdmin", "", "clickListener", "Lcom/studiolaganne/lengendarylens/GamesClickListener;", "disableClicks", "<init>", "(Ljava/util/List;ZLcom/studiolaganne/lengendarylens/GamesClickListener;Z)V", "updateGames", "", "newGames", "", "addMoreGames", "setLoadMoreVisible", "visible", "setupSubgame", "holder", "game1player1RecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "game1player2RecyclerView", "game1player1WinnerHeaderLabel", "Landroid/widget/TextView;", "game1player2WinnerHeaderLabel", "game1", "Lcom/studiolaganne/lengendarylens/MTGame;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "position", "getItemViewType", "getItemCount", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GamesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int VIEW_TYPE_DUEL_GAME = 4;
    public static final int VIEW_TYPE_GAME = 1;
    public static final int VIEW_TYPE_LOAD_MORE = 3;
    public static final int VIEW_TYPE_SEPARATOR = 2;
    private final GamesClickListener clickListener;
    private final boolean disableClicks;
    private List<GameItemHolder> games;
    private final boolean isPlaygroupAdmin;
    public static final int $stable = 8;

    public GamesAdapter(List<GameItemHolder> games, boolean z, GamesClickListener clickListener, boolean z2) {
        Intrinsics.checkNotNullParameter(games, "games");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.games = games;
        this.isPlaygroupAdmin = z;
        this.clickListener = clickListener;
        this.disableClicks = z2;
    }

    public /* synthetic */ GamesAdapter(List list, boolean z, GamesClickListener gamesClickListener, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, z, gamesClickListener, (i & 8) != 0 ? false : z2);
    }

    static final Unit onBindViewHolder$lambda$13(RecyclerView.ViewHolder viewHolder, PreferencesManager preferencesManager, final MTGame mTGame, final GamesAdapter gamesAdapter) {
        Boolean published;
        Context context = viewHolder.itemView.getContext();
        MTUser currentUser = preferencesManager.getCurrentUser();
        List<MTRole> roles = currentUser != null ? currentUser.getRoles() : null;
        boolean zBooleanValue = true;
        boolean z = false;
        if (roles != null) {
            List<MTRole> list = roles;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                for (MTRole mTRole : list) {
                    if (Intrinsics.areEqual(mTRole.getName(), PreferencesManager.USER_ROLE_ADMIN) || Intrinsics.areEqual(mTRole.getName(), PreferencesManager.USER_ROLE_CREATOR)) {
                        z = true;
                        break;
                    }
                }
            }
        }
        if (mTGame != null && (published = mTGame.getPublished()) != null) {
            zBooleanValue = published.booleanValue();
        }
        Intrinsics.checkNotNull(context);
        IconPopupMenu iconPopupMenu = new IconPopupMenu(context);
        if (z) {
            if (zBooleanValue) {
                IconPopupMenu.addItem$default(iconPopupMenu, R.string.unpublish_game, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.GamesAdapter$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return GamesAdapter.onBindViewHolder$lambda$13$1(mTGame, gamesAdapter);
                    }
                }, 30, (Object) null);
            } else {
                IconPopupMenu.addItem$default(iconPopupMenu, R.string.publish_game, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.GamesAdapter$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return GamesAdapter.onBindViewHolder$lambda$13$2(mTGame, gamesAdapter);
                    }
                }, 30, (Object) null);
            }
            iconPopupMenu.addDivider();
        }
        IconPopupMenu.addItem$default(iconPopupMenu, R.string.delete_game_long, "\uf2ed", true, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.GamesAdapter$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GamesAdapter.onBindViewHolder$lambda$13$3(mTGame, gamesAdapter);
            }
        }, 24, (Object) null);
        iconPopupMenu.show(((GameDuelViewHolder) viewHolder).getDotsLayout());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$13$1(MTGame mTGame, GamesAdapter gamesAdapter) {
        if (mTGame != null) {
            gamesAdapter.clickListener.onUnpublishGameClicked(mTGame);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$13$2(MTGame mTGame, GamesAdapter gamesAdapter) {
        if (mTGame != null) {
            gamesAdapter.clickListener.onPublishGameClicked(mTGame);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$13$3(MTGame mTGame, GamesAdapter gamesAdapter) {
        if (mTGame != null) {
            gamesAdapter.clickListener.onDeleteGameClicked(mTGame);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$14$0(MTSet mTSet, GamesAdapter gamesAdapter, List list) {
        if (mTSet != null) {
            gamesAdapter.clickListener.onSetClicked(mTSet, list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$14$7(RecyclerView.ViewHolder viewHolder) {
        ((GameDuelViewHolder) viewHolder).getPlaygroupName().setVisibility(8);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$14$8$0(GamesAdapter gamesAdapter, MTGame mTGame) {
        gamesAdapter.clickListener.onGameClicked(mTGame);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$14$8$1(GamesAdapter gamesAdapter, MTGame mTGame) {
        gamesAdapter.clickListener.onGameClicked(mTGame);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$14$8$2(GamesAdapter gamesAdapter, MTGame mTGame) {
        gamesAdapter.clickListener.onGameClicked(mTGame);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$14$8$3(GamesAdapter gamesAdapter, MTGame mTGame) {
        gamesAdapter.clickListener.onGameClicked(mTGame);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$14$8$4(GamesAdapter gamesAdapter, MTGame mTGame) {
        gamesAdapter.clickListener.onGameClicked(mTGame);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$14$9(GameItemHolder gameItemHolder, GamesAdapter gamesAdapter, int i, View view) {
        gameItemHolder.setExpanded(!gameItemHolder.getExpanded());
        gamesAdapter.notifyItemChanged(i);
        gamesAdapter.clickListener.onGameItemExpanded();
    }

    static final Unit onBindViewHolder$lambda$16(GamesAdapter gamesAdapter) {
        gamesAdapter.clickListener.onLoadMoreGamesClicked();
        return Unit.INSTANCE;
    }

    static final Unit onBindViewHolder$lambda$5(RecyclerView.ViewHolder viewHolder, PreferencesManager preferencesManager, final MTGame mTGame, final GamesAdapter gamesAdapter) {
        Boolean published;
        Context context = viewHolder.itemView.getContext();
        MTUser currentUser = preferencesManager.getCurrentUser();
        List<MTRole> roles = currentUser != null ? currentUser.getRoles() : null;
        boolean zBooleanValue = true;
        boolean z = false;
        if (roles != null) {
            List<MTRole> list = roles;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                for (MTRole mTRole : list) {
                    if (Intrinsics.areEqual(mTRole.getName(), PreferencesManager.USER_ROLE_ADMIN) || Intrinsics.areEqual(mTRole.getName(), PreferencesManager.USER_ROLE_CREATOR)) {
                        z = true;
                        break;
                    }
                }
            }
        }
        if (mTGame != null && (published = mTGame.getPublished()) != null) {
            zBooleanValue = published.booleanValue();
        }
        Intrinsics.checkNotNull(context);
        IconPopupMenu iconPopupMenu = new IconPopupMenu(context);
        if (z) {
            if (zBooleanValue) {
                IconPopupMenu.addItem$default(iconPopupMenu, R.string.unpublish_game, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.GamesAdapter$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return GamesAdapter.onBindViewHolder$lambda$5$1(mTGame, gamesAdapter);
                    }
                }, 30, (Object) null);
            } else {
                IconPopupMenu.addItem$default(iconPopupMenu, R.string.publish_game, (String) null, false, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.GamesAdapter$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return GamesAdapter.onBindViewHolder$lambda$5$2(mTGame, gamesAdapter);
                    }
                }, 30, (Object) null);
            }
            iconPopupMenu.addDivider();
        }
        IconPopupMenu.addItem$default(iconPopupMenu, R.string.delete_game_long, "\uf2ed", true, false, (Integer) null, new Function0() { // from class: com.studiolaganne.lengendarylens.GamesAdapter$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GamesAdapter.onBindViewHolder$lambda$5$3(mTGame, gamesAdapter);
            }
        }, 24, (Object) null);
        iconPopupMenu.show(((GameViewHolder) viewHolder).getDotsLayout());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$5$1(MTGame mTGame, GamesAdapter gamesAdapter) {
        if (mTGame != null) {
            gamesAdapter.clickListener.onUnpublishGameClicked(mTGame);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$5$2(MTGame mTGame, GamesAdapter gamesAdapter) {
        if (mTGame != null) {
            gamesAdapter.clickListener.onPublishGameClicked(mTGame);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$5$3(MTGame mTGame, GamesAdapter gamesAdapter) {
        if (mTGame != null) {
            gamesAdapter.clickListener.onDeleteGameClicked(mTGame);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$6$0(GamesAdapter gamesAdapter, MTGame mTGame) {
        gamesAdapter.clickListener.onGameClicked(mTGame);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onBindViewHolder$lambda$6$5(RecyclerView.ViewHolder viewHolder) {
        ((GameViewHolder) viewHolder).getPlaygroupName().setVisibility(8);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence onBindViewHolder$lambda$6$6(MTGamePlayer it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getFirstname();
    }

    private final void setupSubgame(RecyclerView.ViewHolder holder, RecyclerView game1player1RecyclerView, RecyclerView game1player2RecyclerView, TextView game1player1WinnerHeaderLabel, TextView game1player2WinnerHeaderLabel, MTGame game1) {
        Integer resultid;
        game1player1RecyclerView.setAdapter(new SmallGamePlayerAdapter(CollectionsKt.listOf(game1.getPlayers().get(0)), false, 0));
        game1player1RecyclerView.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext(), 0, false));
        game1player2RecyclerView.setAdapter(new SmallGamePlayerAdapter(CollectionsKt.listOf(game1.getPlayers().get(1)), false, 0));
        game1player2RecyclerView.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext(), 0, false));
        Integer resultid2 = game1.getPlayers().get(0).getResultid();
        if (resultid2 != null && resultid2.intValue() == 1) {
            game1player1WinnerHeaderLabel.setVisibility(0);
            game1player1WinnerHeaderLabel.setText(holder.itemView.getResources().getString(R.string.winner));
            game1player1WinnerHeaderLabel.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.almost_black));
            game1player1WinnerHeaderLabel.setBackgroundResource(R.drawable.green_box);
            game1player2WinnerHeaderLabel.setVisibility(4);
        } else {
            Integer resultid3 = game1.getPlayers().get(1).getResultid();
            if (resultid3 != null && resultid3.intValue() == 1) {
                game1player2WinnerHeaderLabel.setVisibility(0);
                game1player2WinnerHeaderLabel.setText(holder.itemView.getResources().getString(R.string.winner));
                game1player2WinnerHeaderLabel.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.almost_black));
                game1player2WinnerHeaderLabel.setBackgroundResource(R.drawable.green_box);
                game1player1WinnerHeaderLabel.setVisibility(4);
            }
        }
        Integer resultid4 = game1.getPlayers().get(0).getResultid();
        if (resultid4 != null && resultid4.intValue() == 2) {
            game1player1WinnerHeaderLabel.setVisibility(0);
            game1player1WinnerHeaderLabel.setText(holder.itemView.getResources().getString(R.string.conceded));
            game1player1WinnerHeaderLabel.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.almost_white));
            game1player1WinnerHeaderLabel.setBackgroundResource(R.drawable.red_box);
            game1player2WinnerHeaderLabel.setVisibility(4);
        }
        Integer resultid5 = game1.getPlayers().get(1).getResultid();
        if (resultid5 != null && resultid5.intValue() == 2) {
            game1player2WinnerHeaderLabel.setVisibility(0);
            game1player2WinnerHeaderLabel.setText(holder.itemView.getResources().getString(R.string.conceded));
            game1player2WinnerHeaderLabel.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.almost_white));
            game1player2WinnerHeaderLabel.setBackgroundResource(R.drawable.red_box);
            game1player1WinnerHeaderLabel.setVisibility(4);
        }
        Integer resultid6 = game1.getPlayers().get(0).getResultid();
        if ((resultid6 != null && resultid6.intValue() == 3) || ((resultid = game1.getPlayers().get(1).getResultid()) != null && resultid.intValue() == 3)) {
            game1player1WinnerHeaderLabel.setVisibility(0);
            game1player1WinnerHeaderLabel.setText(holder.itemView.getResources().getString(R.string.draw));
            game1player1WinnerHeaderLabel.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.almost_white));
            game1player1WinnerHeaderLabel.setBackgroundResource(R.drawable.orange_box);
            game1player2WinnerHeaderLabel.setVisibility(0);
            game1player2WinnerHeaderLabel.setText(holder.itemView.getResources().getString(R.string.draw));
            game1player2WinnerHeaderLabel.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.almost_white));
            game1player2WinnerHeaderLabel.setBackgroundResource(R.drawable.orange_box);
        }
    }

    public final void addMoreGames(List<GameItemHolder> newGames) {
        Intrinsics.checkNotNullParameter(newGames, "newGames");
        GameItemHolder gameItemHolder = (GameItemHolder) CollectionsKt.lastOrNull((List) this.games);
        if (gameItemHolder != null && gameItemHolder.getType() == 3) {
            int lastIndex = CollectionsKt.getLastIndex(this.games);
            this.games.remove(lastIndex);
            notifyItemRemoved(lastIndex);
        }
        int size = this.games.size();
        this.games.addAll(newGames);
        notifyItemRangeInserted(size, newGames.size());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.games.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.games.get(position).getType();
    }

    /* JADX WARN: Removed duplicated region for block: B:162:0x04e0  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x04ea  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0506  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0531  */
    /* JADX WARN: Removed duplicated region for block: B:398:0x0e5f  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x0e8a  */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        int i;
        GameItemHolder gameItemHolder;
        GameDuelViewHolder gameDuelViewHolder;
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z;
        boolean z2;
        Integer resultid;
        Integer resultid2;
        MTUser currentUser;
        List<MTTag> tags;
        GameItemHolder gameItemHolder2;
        GameDuelViewHolder gameDuelViewHolder2;
        String strValueOf;
        GameViewHolder gameViewHolder;
        int i6;
        boolean z3;
        int i7;
        boolean z4;
        List<MTGamePlayer> players;
        Iterator<T> it;
        boolean z5;
        MTUser currentUser2;
        List<MTTag> tags2;
        GameViewHolder gameViewHolder2;
        String strValueOf2;
        Intrinsics.checkNotNullParameter(holder, "holder");
        GameItemHolder gameItemHolder3 = this.games.get(position);
        String str = "en";
        ViewGroup viewGroup = null;
        int i8 = 0;
        if (!(holder instanceof GameViewHolder)) {
            if (!(holder instanceof GameDuelViewHolder)) {
                if (!(holder instanceof GameSeparatorViewHolder)) {
                    if (holder instanceof GameLoadMoreViewHolder) {
                        ViewExtensionsKt.setOnClickWithFade(((GameLoadMoreViewHolder) holder).getRootLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.GamesAdapter$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return GamesAdapter.onBindViewHolder$lambda$16(this.f$0);
                            }
                        });
                        return;
                    }
                    return;
                } else {
                    String separator = gameItemHolder3.getSeparator();
                    if (separator != null) {
                        ((GameSeparatorViewHolder) holder).getSeparatorText().setText(separator);
                        Unit unit = Unit.INSTANCE;
                        Unit unit2 = Unit.INSTANCE;
                        return;
                    }
                    return;
                }
            }
            int bestof = gameItemHolder3.getBestof();
            if (bestof == 1) {
                ((GameDuelViewHolder) holder).getBestOfLabel().setText(holder.itemView.getResources().getString(R.string.match_type_bo1));
                Unit unit3 = Unit.INSTANCE;
            } else if (bestof == 3) {
                ((GameDuelViewHolder) holder).getBestOfLabel().setText(holder.itemView.getResources().getString(R.string.match_type_bo3));
                Unit unit4 = Unit.INSTANCE;
            } else if (bestof != 5) {
                ((GameDuelViewHolder) holder).getBestOfLabel().setText(holder.itemView.getResources().getString(R.string.match_type_bo1));
                Unit unit5 = Unit.INSTANCE;
            } else {
                ((GameDuelViewHolder) holder).getBestOfLabel().setText(holder.itemView.getResources().getString(R.string.match_type_bo5));
                Unit unit6 = Unit.INSTANCE;
            }
            List<MTGame> subgames = gameItemHolder3.getSubgames();
            final List<MTGame> listSortedWith = subgames != null ? CollectionsKt.sortedWith(subgames, new Comparator() { // from class: com.studiolaganne.lengendarylens.GamesAdapter$onBindViewHolder$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    MTSet set = ((MTGame) t).getSet();
                    Integer numValueOf = set != null ? Integer.valueOf(set.getGame()) : null;
                    MTSet set2 = ((MTGame) t2).getSet();
                    return ComparisonsKt.compareValues(numValueOf, set2 != null ? Integer.valueOf(set2.getGame()) : null);
                }
            }) : null;
            final MTGame mTGame = listSortedWith != null ? (MTGame) CollectionsKt.firstOrNull(listSortedWith) : null;
            final MTSet set = gameItemHolder3.getSet();
            if (mTGame == null || mTGame.getPlaygroup() == null) {
                i = 8;
                GameDuelViewHolder gameDuelViewHolder3 = (GameDuelViewHolder) holder;
                gameDuelViewHolder3.getDotsLayout().setVisibility(8);
                gameDuelViewHolder3.getProfileLayout().setVisibility(8);
                gameDuelViewHolder3.getPlaygroupName().setVisibility(8);
                Unit unit7 = Unit.INSTANCE;
            } else {
                GameDuelViewHolder gameDuelViewHolder4 = (GameDuelViewHolder) holder;
                gameDuelViewHolder4.getProfileLayout().setVisibility(0);
                if (this.isPlaygroupAdmin) {
                    gameDuelViewHolder4.getDotsLayout().setVisibility(0);
                    i = 8;
                } else {
                    i = 8;
                    gameDuelViewHolder4.getDotsLayout().setVisibility(8);
                }
                Unit unit8 = Unit.INSTANCE;
                Unit unit9 = Unit.INSTANCE;
            }
            GameDuelViewHolder gameDuelViewHolder5 = (GameDuelViewHolder) holder;
            gameDuelViewHolder5.getTagsFlexboxLayout().setVisibility(i);
            if (set == null || (tags = set.getTags()) == null) {
                gameItemHolder = gameItemHolder3;
                gameDuelViewHolder = gameDuelViewHolder5;
            } else {
                if (tags.isEmpty()) {
                    gameItemHolder = gameItemHolder3;
                    gameDuelViewHolder = gameDuelViewHolder5;
                } else {
                    gameDuelViewHolder5.getTagsFlexboxLayout().removeAllViews();
                    Iterator<MTTag> it2 = tags.iterator();
                    while (it2.hasNext()) {
                        MTTag next = it2.next();
                        String str2 = str;
                        Iterator<MTTag> it3 = it2;
                        View viewInflate = LayoutInflater.from(holder.itemView.getContext()).inflate(R.layout.tag_item, (ViewGroup) null);
                        TextView textView = (TextView) viewInflate.findViewById(R.id.tagName);
                        String name = next.getName();
                        if (name.length() > 0) {
                            gameDuelViewHolder2 = gameDuelViewHolder5;
                            StringBuilder sb = new StringBuilder();
                            gameItemHolder2 = gameItemHolder3;
                            char cCharAt = name.charAt(0);
                            if (Character.isLowerCase(cCharAt)) {
                                Locale localeForLanguageTag = Locale.forLanguageTag(str2);
                                Intrinsics.checkNotNullExpressionValue(localeForLanguageTag, "forLanguageTag(...)");
                                strValueOf = CharsKt.titlecase(cCharAt, localeForLanguageTag);
                            } else {
                                strValueOf = String.valueOf(cCharAt);
                            }
                            StringBuilder sbAppend = sb.append((Object) strValueOf);
                            String strSubstring = name.substring(1);
                            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                            name = sbAppend.append(strSubstring).toString();
                        } else {
                            gameItemHolder2 = gameItemHolder3;
                            gameDuelViewHolder2 = gameDuelViewHolder5;
                        }
                        textView.setText(name);
                        gameDuelViewHolder2.getTagsFlexboxLayout().addView(viewInflate);
                        str = str2;
                        it2 = it3;
                        gameDuelViewHolder5 = gameDuelViewHolder2;
                        gameItemHolder3 = gameItemHolder2;
                    }
                    gameItemHolder = gameItemHolder3;
                    gameDuelViewHolder = gameDuelViewHolder5;
                    gameDuelViewHolder.getTagsFlexboxLayout().setVisibility(0);
                }
                Unit unit10 = Unit.INSTANCE;
                Unit unit11 = Unit.INSTANCE;
            }
            gameDuelViewHolder.getNoteImage().setVisibility(8);
            if (set != null && set.getNote() != null) {
                gameDuelViewHolder.getNoteImage().setVisibility(0);
                Unit unit12 = Unit.INSTANCE;
                Unit unit13 = Unit.INSTANCE;
            }
            Context context = holder.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            final PreferencesManager preferencesManager = new PreferencesManager(context);
            if (mTGame == null || (currentUser = preferencesManager.getCurrentUser()) == null) {
                i2 = 8;
            } else {
                MTUser created_by = mTGame.getCreated_by();
                if (created_by == null || created_by.getId() != currentUser.getId()) {
                    i2 = 8;
                    gameDuelViewHolder.getDotsLayout().setVisibility(8);
                } else {
                    gameDuelViewHolder.getDotsLayout().setVisibility(0);
                    i2 = 8;
                }
                Unit unit14 = Unit.INSTANCE;
                Unit unit15 = Unit.INSTANCE;
            }
            if (this.disableClicks) {
                gameDuelViewHolder.getDotsLayout().setVisibility(i2);
            }
            ViewExtensionsKt.setOnClickWithFade(gameDuelViewHolder.getDotsLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.GamesAdapter$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return GamesAdapter.onBindViewHolder$lambda$13(holder, preferencesManager, mTGame, this);
                }
            });
            gameDuelViewHolder.getProfileLayout().setOutlineProvider(new CircularOutlineProvider());
            gameDuelViewHolder.getProfileLayout().setClipToOutline(true);
            gameDuelViewHolder.getProfileIcon().setOutlineProvider(new CircularOutlineProvider());
            gameDuelViewHolder.getProfileIcon().setClipToOutline(true);
            if (mTGame != null) {
                if (!this.disableClicks) {
                    ViewExtensionsKt.setOnClickWithFade(gameDuelViewHolder.getRootLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.GamesAdapter$$ExternalSyntheticLambda19
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return GamesAdapter.onBindViewHolder$lambda$14$0(set, this, listSortedWith);
                        }
                    });
                }
                MTGamePlayer mTGamePlayer = mTGame.getPlayers().get(0);
                MTGamePlayer mTGamePlayer2 = mTGame.getPlayers().get(1);
                if (listSortedWith != null) {
                    i3 = 0;
                    i4 = 0;
                    for (MTGame mTGame2 : listSortedWith) {
                        if (mTGame2.getPlayers().size() == 2) {
                            MTGamePlayer mTGamePlayer3 = mTGame2.getPlayers().get(0);
                            MTGamePlayer mTGamePlayer4 = mTGame2.getPlayers().get(1);
                            Integer resultid3 = mTGamePlayer3.getResultid();
                            if ((resultid3 == null || resultid3.intValue() != 1) && ((resultid = mTGamePlayer4.getResultid()) == null || resultid.intValue() != 2)) {
                                Integer resultid4 = mTGamePlayer4.getResultid();
                                if ((resultid4 != null && resultid4.intValue() == 1) || ((resultid2 = mTGamePlayer3.getResultid()) != null && resultid2.intValue() == 2)) {
                                    if (mTGamePlayer.getId() == mTGamePlayer4.getId()) {
                                        i3++;
                                    } else {
                                        i4++;
                                    }
                                }
                            } else if (mTGamePlayer.getId() == mTGamePlayer3.getId()) {
                                i3++;
                            } else {
                                i4++;
                            }
                        }
                    }
                    Unit unit16 = Unit.INSTANCE;
                    Unit unit17 = Unit.INSTANCE;
                } else {
                    i3 = 0;
                    i4 = 0;
                }
                gameDuelViewHolder.getPlayer1WinnerHeader().setVisibility(4);
                gameDuelViewHolder.getPlayer2WinnerHeader().setVisibility(4);
                boolean z6 = i3 > i4;
                boolean z7 = i3 == i4;
                gameDuelViewHolder.getPlayer1ScoreLabel().setText(String.valueOf(i3));
                gameDuelViewHolder.getPlayer2ScoreLabel().setText(String.valueOf(i4));
                if (z7) {
                    gameDuelViewHolder.getPlayer1NameLabel().setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.draw_orange));
                    gameDuelViewHolder.getPlayer2NameLabel().setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.draw_orange));
                    gameDuelViewHolder.getPlayer2ScoreLabel().setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.draw_orange));
                    gameDuelViewHolder.getPlayer1ScoreLabel().setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.draw_orange));
                    gameDuelViewHolder.getPlayer1WinnerHeader().setVisibility(4);
                    gameDuelViewHolder.getPlayer2WinnerHeader().setVisibility(4);
                } else if (z6) {
                    gameDuelViewHolder.getPlayer1NameLabel().setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.winner_green));
                    gameDuelViewHolder.getPlayer2NameLabel().setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.loser_red));
                    gameDuelViewHolder.getPlayer1ScoreLabel().setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.winner_green));
                    gameDuelViewHolder.getPlayer2ScoreLabel().setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.loser_red));
                    gameDuelViewHolder.getPlayer1WinnerHeader().setVisibility(0);
                    gameDuelViewHolder.getPlayer2WinnerHeader().setVisibility(4);
                } else {
                    gameDuelViewHolder.getPlayer1NameLabel().setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.loser_red));
                    gameDuelViewHolder.getPlayer2NameLabel().setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.winner_green));
                    gameDuelViewHolder.getPlayer2ScoreLabel().setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.winner_green));
                    gameDuelViewHolder.getPlayer1ScoreLabel().setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.loser_red));
                    gameDuelViewHolder.getPlayer1WinnerHeader().setVisibility(4);
                    gameDuelViewHolder.getPlayer2WinnerHeader().setVisibility(0);
                }
                gameDuelViewHolder.getPlayer1NameLabel().setText(mTGamePlayer.getFirstname());
                gameDuelViewHolder.getPlayer2NameLabel().setText(mTGamePlayer2.getFirstname());
                gameDuelViewHolder.getPlayer1RecyclerView().setAdapter(new MiddleGamePlayerAdapter(CollectionsKt.listOf(mTGamePlayer)));
                gameDuelViewHolder.getPlayer1RecyclerView().setLayoutManager(new LinearLayoutManager(holder.itemView.getContext(), 0, false));
                gameDuelViewHolder.getPlayer2RecyclerView().setAdapter(new MiddleGamePlayerAdapter(CollectionsKt.listOf(mTGamePlayer2)));
                gameDuelViewHolder.getPlayer2RecyclerView().setLayoutManager(new LinearLayoutManager(holder.itemView.getContext(), 0, false));
                MTUser currentUser3 = preferencesManager.getCurrentUser();
                if (currentUser3 != null) {
                    Boolean published = mTGame.getPublished();
                    if (published != null) {
                        z = !published.booleanValue();
                        Unit unit18 = Unit.INSTANCE;
                        Unit unit19 = Unit.INSTANCE;
                    } else {
                        z = false;
                    }
                    boolean z8 = (z6 && mTGamePlayer.getId() == currentUser3.getId()) || (!z6 && mTGamePlayer2.getId() == currentUser3.getId());
                    List<MTGamePlayer> players2 = mTGame.getPlayers();
                    if ((players2 instanceof Collection) && players2.isEmpty()) {
                        z2 = false;
                        TextView victoryLabel = gameDuelViewHolder.getVictoryLabel();
                        if (!z) {
                        }
                        Unit unit20 = Unit.INSTANCE;
                        Unit unit21 = Unit.INSTANCE;
                    } else {
                        Iterator<T> it4 = players2.iterator();
                        while (it4.hasNext()) {
                            if (((MTGamePlayer) it4.next()).getId() == currentUser3.getId()) {
                                z2 = true;
                                break;
                            }
                        }
                        z2 = false;
                        TextView victoryLabel2 = gameDuelViewHolder.getVictoryLabel();
                        if (!z) {
                            victoryLabel2.setText(holder.itemView.getResources().getString(R.string.unpublished_caps));
                            victoryLabel2.setBackgroundResource(R.drawable.grey_box);
                            victoryLabel2.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.almost_white));
                            victoryLabel2.setVisibility(0);
                        } else if (z7) {
                            victoryLabel2.setText(holder.itemView.getResources().getString(R.string.draw));
                            victoryLabel2.setBackgroundResource(R.drawable.orange_box);
                            victoryLabel2.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.almost_white));
                            victoryLabel2.setVisibility(0);
                        } else if (z8) {
                            victoryLabel2.setText(holder.itemView.getResources().getString(R.string.victory));
                            victoryLabel2.setBackgroundResource(R.drawable.green_box);
                            victoryLabel2.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.almost_black));
                            victoryLabel2.setVisibility(0);
                        } else if (z2) {
                            victoryLabel2.setText(holder.itemView.getResources().getString(R.string.defeat));
                            victoryLabel2.setBackgroundResource(R.drawable.red_box);
                            victoryLabel2.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.almost_white));
                            victoryLabel2.setVisibility(0);
                        } else {
                            victoryLabel2.setVisibility(4);
                        }
                        Unit unit202 = Unit.INSTANCE;
                        Unit unit212 = Unit.INSTANCE;
                    }
                }
                MTGameFormat format = mTGame.getFormat();
                if (format != null) {
                    gameDuelViewHolder.getGameName().setText(format.getName());
                    Unit unit22 = Unit.INSTANCE;
                } else {
                    gameDuelViewHolder.getGameName().setText(holder.itemView.getResources().getString(R.string.game_title));
                    Unit unit23 = Unit.INSTANCE;
                }
                MTGameSubformat subformat = mTGame.getSubformat();
                if (subformat != null) {
                    if (subformat.getId() > 0) {
                        if (subformat.getName().length() > 0) {
                            gameDuelViewHolder.getGameName().setText(subformat.getName());
                            if (subformat.getId() == 5) {
                                gameDuelViewHolder.getGameName().setText(holder.itemView.getResources().getString(R.string.two_headed_giant));
                            }
                            if (subformat.getId() == 6) {
                                gameDuelViewHolder.getGameName().setText(holder.itemView.getResources().getString(R.string.three_headed_giant));
                            }
                        }
                    }
                    Unit unit24 = Unit.INSTANCE;
                    Unit unit25 = Unit.INSTANCE;
                }
                MTGamePlaygroup playgroup = mTGame.getPlaygroup();
                if (playgroup != null) {
                    gameDuelViewHolder.getPlaygroupName().setVisibility(0);
                    gameDuelViewHolder.getPlaygroupName().setText("@ " + playgroup.getName());
                    String picture = playgroup.getPicture();
                    String str3 = picture;
                    if ((str3 == null || str3.length() == 0) || Intrinsics.areEqual(picture, AbstractJsonLexerKt.NULL)) {
                        gameDuelViewHolder.getNoPhotoIcon().setVisibility(0);
                        gameDuelViewHolder.getProfileIcon().setVisibility(8);
                    } else {
                        gameDuelViewHolder.getNoPhotoIcon().setVisibility(8);
                        gameDuelViewHolder.getProfileIcon().setVisibility(0);
                        gameDuelViewHolder.getProfileIcon().setAutoLoad(false);
                        gameDuelViewHolder.getProfileIcon().reset();
                        gameDuelViewHolder.getProfileIcon().loadImage(picture);
                    }
                    Unit unit26 = Unit.INSTANCE;
                    Unit unit27 = Unit.INSTANCE;
                } else {
                    new Function0() { // from class: com.studiolaganne.lengendarylens.GamesAdapter$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return GamesAdapter.onBindViewHolder$lambda$14$7(holder);
                        }
                    };
                }
                gameDuelViewHolder.getTimeLabel().setText(ServerUtils.INSTANCE.getInstance().parseAndFormatTimestamp(mTGame.getStarted_at()));
                if (listSortedWith != null) {
                    listSortedWith.size();
                    List list = listSortedWith;
                    if (list.isEmpty()) {
                        i5 = 0;
                    } else {
                        final MTGame mTGame3 = (MTGame) listSortedWith.get(0);
                        if (mTGame3.getPlayers().size() == 2) {
                            i5 = 0;
                            setupSubgame(holder, gameDuelViewHolder.getGame1player1RecyclerView(), gameDuelViewHolder.getGame1player2RecyclerView(), gameDuelViewHolder.getGame1player1WinnerHeaderLabel(), gameDuelViewHolder.getGame1player2WinnerHeaderLabel(), mTGame3);
                        } else {
                            i5 = 0;
                        }
                        if (!this.disableClicks) {
                            ViewExtensionsKt.setOnClickWithFade(gameDuelViewHolder.getGame1Layout(), new Function0() { // from class: com.studiolaganne.lengendarylens.GamesAdapter$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return GamesAdapter.onBindViewHolder$lambda$14$8$0(this.f$0, mTGame3);
                                }
                            });
                        }
                    }
                    if (list.size() > 1) {
                        final MTGame mTGame4 = (MTGame) listSortedWith.get(1);
                        if (mTGame4.getPlayers().size() == 2) {
                            setupSubgame(holder, gameDuelViewHolder.getGame2player1RecyclerView(), gameDuelViewHolder.getGame2player2RecyclerView(), gameDuelViewHolder.getGame2player1WinnerHeaderLabel(), gameDuelViewHolder.getGame2player2WinnerHeaderLabel(), mTGame4);
                        }
                        if (!this.disableClicks) {
                            ViewExtensionsKt.setOnClickWithFade(gameDuelViewHolder.getGame2Layout(), new Function0() { // from class: com.studiolaganne.lengendarylens.GamesAdapter$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return GamesAdapter.onBindViewHolder$lambda$14$8$1(this.f$0, mTGame4);
                                }
                            });
                        }
                    }
                    if (list.size() > 2) {
                        final MTGame mTGame5 = (MTGame) listSortedWith.get(2);
                        if (mTGame5.getPlayers().size() == 2) {
                            setupSubgame(holder, gameDuelViewHolder.getGame3player1RecyclerView(), gameDuelViewHolder.getGame3player2RecyclerView(), gameDuelViewHolder.getGame3player1WinnerHeaderLabel(), gameDuelViewHolder.getGame3player2WinnerHeaderLabel(), mTGame5);
                        }
                        if (!this.disableClicks) {
                            ViewExtensionsKt.setOnClickWithFade(gameDuelViewHolder.getGame3Layout(), new Function0() { // from class: com.studiolaganne.lengendarylens.GamesAdapter$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return GamesAdapter.onBindViewHolder$lambda$14$8$2(this.f$0, mTGame5);
                                }
                            });
                        }
                    }
                    if (list.size() > 3) {
                        final MTGame mTGame6 = (MTGame) listSortedWith.get(3);
                        if (mTGame6.getPlayers().size() == 2) {
                            setupSubgame(holder, gameDuelViewHolder.getGame4player1RecyclerView(), gameDuelViewHolder.getGame4player2RecyclerView(), gameDuelViewHolder.getGame4player1WinnerHeaderLabel(), gameDuelViewHolder.getGame4player2WinnerHeaderLabel(), mTGame6);
                        }
                        if (!this.disableClicks) {
                            ViewExtensionsKt.setOnClickWithFade(gameDuelViewHolder.getGame4Layout(), new Function0() { // from class: com.studiolaganne.lengendarylens.GamesAdapter$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return GamesAdapter.onBindViewHolder$lambda$14$8$3(this.f$0, mTGame6);
                                }
                            });
                        }
                    }
                    if (list.size() > 4) {
                        final MTGame mTGame7 = (MTGame) listSortedWith.get(4);
                        if (mTGame7.getPlayers().size() == 2) {
                            setupSubgame(holder, gameDuelViewHolder.getGame5player1RecyclerView(), gameDuelViewHolder.getGame5player2RecyclerView(), gameDuelViewHolder.getGame5player1WinnerHeaderLabel(), gameDuelViewHolder.getGame5player2WinnerHeaderLabel(), mTGame7);
                        }
                        if (!this.disableClicks) {
                            ViewExtensionsKt.setOnClickWithFade(gameDuelViewHolder.getGame5Layout(), new Function0() { // from class: com.studiolaganne.lengendarylens.GamesAdapter$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return GamesAdapter.onBindViewHolder$lambda$14$8$4(this.f$0, mTGame7);
                                }
                            });
                        }
                    }
                    Unit unit28 = Unit.INSTANCE;
                    Unit unit29 = Unit.INSTANCE;
                } else {
                    i5 = 0;
                }
                final GameItemHolder gameItemHolder4 = gameItemHolder;
                gameDuelViewHolder.getBottomLayout().setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.GamesAdapter$$ExternalSyntheticLambda13
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        GamesAdapter.onBindViewHolder$lambda$14$9(gameItemHolder4, this, position, view);
                    }
                });
                if (gameItemHolder4.getExpanded()) {
                    List<MTGame> subgames2 = gameItemHolder4.getSubgames();
                    gameDuelViewHolder.expand(subgames2 != null ? subgames2.size() : i5);
                } else {
                    gameDuelViewHolder.collapse();
                }
                Unit unit30 = Unit.INSTANCE;
                Unit unit31 = Unit.INSTANCE;
                return;
            }
            return;
        }
        final MTGame game = gameItemHolder3.getGame();
        GameViewHolder gameViewHolder3 = (GameViewHolder) holder;
        gameViewHolder3.getLeaderImage().setVisibility(8);
        gameViewHolder3.getGuardianImage().setVisibility(8);
        gameViewHolder3.getAssassinsImage().setVisibility(8);
        gameViewHolder3.getTraitorsImage().setVisibility(8);
        if (game == null || game.getPlaygroup() == null) {
            gameViewHolder3.getDotsLayout().setVisibility(8);
            gameViewHolder3.getProfileLayout().setVisibility(8);
            gameViewHolder3.getPlaygroupName().setVisibility(8);
            Unit unit32 = Unit.INSTANCE;
        } else {
            gameViewHolder3.getProfileLayout().setVisibility(0);
            if (this.isPlaygroupAdmin) {
                gameViewHolder3.getDotsLayout().setVisibility(0);
            } else {
                gameViewHolder3.getDotsLayout().setVisibility(8);
            }
            Unit unit33 = Unit.INSTANCE;
            Unit unit34 = Unit.INSTANCE;
        }
        gameViewHolder3.getTagsFlexboxLayout().setVisibility(8);
        if (game == null || (tags2 = game.getTags()) == null) {
            gameViewHolder = gameViewHolder3;
        } else {
            if (tags2.isEmpty()) {
                gameViewHolder = gameViewHolder3;
            } else {
                gameViewHolder3.getTagsFlexboxLayout().removeAllViews();
                for (MTTag mTTag : tags2) {
                    View viewInflate2 = LayoutInflater.from(holder.itemView.getContext()).inflate(R.layout.tag_item, viewGroup);
                    TextView textView2 = (TextView) viewInflate2.findViewById(R.id.tagName);
                    String name2 = mTTag.getName();
                    if (name2.length() > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        gameViewHolder2 = gameViewHolder3;
                        char cCharAt2 = name2.charAt(i8);
                        if (Character.isLowerCase(cCharAt2)) {
                            Locale localeForLanguageTag2 = Locale.forLanguageTag("en");
                            Intrinsics.checkNotNullExpressionValue(localeForLanguageTag2, "forLanguageTag(...)");
                            strValueOf2 = CharsKt.titlecase(cCharAt2, localeForLanguageTag2);
                        } else {
                            strValueOf2 = String.valueOf(cCharAt2);
                        }
                        StringBuilder sbAppend2 = sb2.append((Object) strValueOf2);
                        String strSubstring2 = name2.substring(1);
                        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                        name2 = sbAppend2.append(strSubstring2).toString();
                    } else {
                        gameViewHolder2 = gameViewHolder3;
                    }
                    textView2.setText(name2);
                    gameViewHolder2.getTagsFlexboxLayout().addView(viewInflate2);
                    gameViewHolder3 = gameViewHolder2;
                    i8 = 0;
                    viewGroup = null;
                }
                gameViewHolder = gameViewHolder3;
                gameViewHolder.getTagsFlexboxLayout().setVisibility(0);
            }
            Unit unit35 = Unit.INSTANCE;
            Unit unit36 = Unit.INSTANCE;
        }
        gameViewHolder.getNoteImage().setVisibility(8);
        if (game != null && game.getNote() != null) {
            gameViewHolder.getNoteImage().setVisibility(0);
            Unit unit37 = Unit.INSTANCE;
            Unit unit38 = Unit.INSTANCE;
        }
        Context context2 = holder.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        final PreferencesManager preferencesManager2 = new PreferencesManager(context2);
        if (game != null && (currentUser2 = preferencesManager2.getCurrentUser()) != null) {
            MTUser created_by2 = game.getCreated_by();
            if (created_by2 != null && created_by2.getId() == currentUser2.getId()) {
                gameViewHolder.getDotsLayout().setVisibility(0);
            } else if (game.getPlaygroup() != null && !this.isPlaygroupAdmin) {
                gameViewHolder.getDotsLayout().setVisibility(8);
            }
            Unit unit39 = Unit.INSTANCE;
            Unit unit40 = Unit.INSTANCE;
        }
        if (this.disableClicks) {
            gameViewHolder.getDotsLayout().setVisibility(8);
        }
        ViewExtensionsKt.setOnClickWithFade(gameViewHolder.getDotsLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.GamesAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GamesAdapter.onBindViewHolder$lambda$5(holder, preferencesManager2, game, this);
            }
        });
        gameViewHolder.getProfileLayout().setOutlineProvider(new CircularOutlineProvider());
        gameViewHolder.getProfileLayout().setClipToOutline(true);
        gameViewHolder.getProfileIcon().setOutlineProvider(new CircularOutlineProvider());
        gameViewHolder.getProfileIcon().setClipToOutline(true);
        if (game != null) {
            if (!this.disableClicks) {
                ViewExtensionsKt.setOnClickWithFade(gameViewHolder.getRootLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.GamesAdapter$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return GamesAdapter.onBindViewHolder$lambda$6$0(this.f$0, game);
                    }
                });
            }
            MTGameFormat format2 = game.getFormat();
            if (format2 != null) {
                gameViewHolder.getGameName().setText(format2.getName());
                Unit unit41 = Unit.INSTANCE;
            } else {
                gameViewHolder.getGameName().setText(holder.itemView.getResources().getString(R.string.game_title));
                Unit unit42 = Unit.INSTANCE;
            }
            MTGameSubformat subformat2 = game.getSubformat();
            if (subformat2 != null) {
                if (subformat2.getId() > 0 && subformat2.getName().length() > 0) {
                    gameViewHolder.getGameName().setText(subformat2.getName());
                    if (subformat2.getId() == 5) {
                        gameViewHolder.getGameName().setText(holder.itemView.getResources().getString(R.string.two_headed_giant));
                    }
                    if (subformat2.getId() == 6) {
                        gameViewHolder.getGameName().setText(holder.itemView.getResources().getString(R.string.three_headed_giant));
                    }
                }
                Unit unit43 = Unit.INSTANCE;
                Unit unit44 = Unit.INSTANCE;
            }
            MTGamePlaygroup playgroup2 = game.getPlaygroup();
            if (playgroup2 != null) {
                gameViewHolder.getPlaygroupName().setVisibility(0);
                gameViewHolder.getPlaygroupName().setText("@ " + playgroup2.getName());
                String picture2 = playgroup2.getPicture();
                String str4 = picture2;
                if (str4 == null || str4.length() == 0 || Intrinsics.areEqual(picture2, AbstractJsonLexerKt.NULL)) {
                    gameViewHolder.getNoPhotoIcon().setVisibility(0);
                    gameViewHolder.getProfileIcon().setVisibility(8);
                } else {
                    gameViewHolder.getNoPhotoIcon().setVisibility(8);
                    gameViewHolder.getProfileIcon().setVisibility(0);
                    gameViewHolder.getProfileIcon().setAutoLoad(false);
                    gameViewHolder.getProfileIcon().reset();
                    gameViewHolder.getProfileIcon().loadImage(picture2);
                }
                Unit unit45 = Unit.INSTANCE;
                Unit unit46 = Unit.INSTANCE;
            } else {
                new Function0() { // from class: com.studiolaganne.lengendarylens.GamesAdapter$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return GamesAdapter.onBindViewHolder$lambda$6$5(holder);
                    }
                };
            }
            gameViewHolder.getTimeLabel().setText(ServerUtils.INSTANCE.getInstance().parseAndFormatTimestamp(game.getStarted_at()));
            ArrayList arrayList = new ArrayList();
            for (MTGamePlayer mTGamePlayer5 : game.getPlayers()) {
                Integer resultid5 = mTGamePlayer5.getResultid();
                if (resultid5 != null && resultid5.intValue() == 1) {
                    arrayList.add(mTGamePlayer5);
                }
            }
            int size = arrayList.size();
            if (size > 0) {
                gameViewHolder.getWinnersHeaderLabel().setVisibility(0);
                gameViewHolder.getWinnersRecyclerView().setVisibility(0);
                gameViewHolder.getWinnerNamesLabel().setVisibility(0);
                gameViewHolder.getWinnersRecyclerView().setAdapter(new BigGamePlayerAdapter(arrayList));
                gameViewHolder.getWinnersRecyclerView().setLayoutManager(new LinearLayoutManager(holder.itemView.getContext(), 0, false));
                GameUtils companion = GameUtils.INSTANCE.getInstance();
                Context context3 = holder.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
                OverlapDecoration overlapDecoration = new OverlapDecoration(companion.dpToPx(22, context3));
                int itemDecorationCount = gameViewHolder.getWinnersRecyclerView().getItemDecorationCount();
                for (int i9 = 0; i9 < itemDecorationCount; i9++) {
                    gameViewHolder.getWinnersRecyclerView().removeItemDecorationAt(0);
                }
                gameViewHolder.getWinnersRecyclerView().addItemDecoration(overlapDecoration);
                if (size > 1) {
                    gameViewHolder.getWinnersHeaderLabel().setText(holder.itemView.getResources().getString(R.string.winners));
                } else {
                    gameViewHolder.getWinnersHeaderLabel().setText(holder.itemView.getResources().getString(R.string.winner));
                }
                gameViewHolder.getWinnerNamesLabel().setText(CollectionsKt.joinToString$default(arrayList, " & ", null, null, 0, null, new Function1() { // from class: com.studiolaganne.lengendarylens.GamesAdapter$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GamesAdapter.onBindViewHolder$lambda$6$6((MTGamePlayer) obj);
                    }
                }, 30, null));
            } else {
                gameViewHolder.getWinnersHeaderLabel().setVisibility(8);
                gameViewHolder.getWinnersRecyclerView().setVisibility(8);
                gameViewHolder.getWinnerNamesLabel().setVisibility(8);
            }
            MTUser currentUser4 = preferencesManager2.getCurrentUser();
            if (currentUser4 != null) {
                Boolean published2 = game.getPublished();
                if (published2 != null) {
                    z3 = !published2.booleanValue();
                    Unit unit47 = Unit.INSTANCE;
                    Unit unit48 = Unit.INSTANCE;
                } else {
                    z3 = false;
                }
                List<MTGamePlayer> players3 = game.getPlayers();
                if ((players3 instanceof Collection) && players3.isEmpty()) {
                    i7 = 0;
                } else {
                    Iterator<T> it5 = players3.iterator();
                    i7 = 0;
                    while (it5.hasNext()) {
                        Integer resultid6 = ((MTGamePlayer) it5.next()).getResultid();
                        if ((resultid6 != null && resultid6.intValue() == 3) && (i7 = i7 + 1) < 0) {
                            CollectionsKt.throwCountOverflow();
                        }
                    }
                }
                boolean z9 = i7 >= 2;
                ArrayList arrayList2 = arrayList;
                if ((arrayList2 instanceof Collection) && arrayList2.isEmpty()) {
                    z4 = false;
                    players = game.getPlayers();
                    if (players instanceof Collection) {
                        it = players.iterator();
                        while (it.hasNext()) {
                        }
                        z5 = false;
                        TextView victoryLabel3 = gameViewHolder.getVictoryLabel();
                        if (z3) {
                        }
                        Unit unit49 = Unit.INSTANCE;
                        Unit unit50 = Unit.INSTANCE;
                    }
                } else {
                    Iterator it6 = arrayList2.iterator();
                    while (it6.hasNext()) {
                        if (((MTGamePlayer) it6.next()).getId() == currentUser4.getId()) {
                            z4 = true;
                            break;
                        }
                    }
                    z4 = false;
                    players = game.getPlayers();
                    if ((players instanceof Collection) || !players.isEmpty()) {
                        it = players.iterator();
                        while (it.hasNext()) {
                            if (((MTGamePlayer) it.next()).getId() == currentUser4.getId()) {
                                z5 = true;
                                break;
                            }
                        }
                        z5 = false;
                        TextView victoryLabel32 = gameViewHolder.getVictoryLabel();
                        if (z3) {
                            victoryLabel32.setText(holder.itemView.getResources().getString(R.string.unpublished_caps));
                            victoryLabel32.setBackgroundResource(R.drawable.grey_box);
                            victoryLabel32.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.almost_white));
                            victoryLabel32.setVisibility(0);
                        } else if (z9) {
                            victoryLabel32.setText(holder.itemView.getResources().getString(R.string.draw));
                            victoryLabel32.setBackgroundResource(R.drawable.orange_box);
                            victoryLabel32.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.almost_white));
                            victoryLabel32.setVisibility(0);
                        } else if (z4) {
                            victoryLabel32.setText(holder.itemView.getResources().getString(R.string.victory));
                            victoryLabel32.setBackgroundResource(R.drawable.green_box);
                            victoryLabel32.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.almost_black));
                            victoryLabel32.setVisibility(0);
                        } else if (z5) {
                            victoryLabel32.setText(holder.itemView.getResources().getString(R.string.defeat));
                            victoryLabel32.setBackgroundResource(R.drawable.red_box);
                            victoryLabel32.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.almost_white));
                            victoryLabel32.setVisibility(0);
                        } else {
                            victoryLabel32.setVisibility(4);
                        }
                        Unit unit492 = Unit.INSTANCE;
                        Unit unit502 = Unit.INSTANCE;
                    } else {
                        z5 = false;
                        TextView victoryLabel322 = gameViewHolder.getVictoryLabel();
                        if (z3) {
                        }
                        Unit unit4922 = Unit.INSTANCE;
                        Unit unit5022 = Unit.INSTANCE;
                    }
                }
            }
            gameViewHolder.getInterLabel1().setVisibility(8);
            List<MTGamePlayer> players4 = game.getPlayers();
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(players4, 10));
            Iterator<T> it7 = players4.iterator();
            while (it7.hasNext()) {
                arrayList3.add(((MTGamePlayer) it7.next()).getTeamid());
            }
            List listSortedWith2 = CollectionsKt.sortedWith(CollectionsKt.distinct(arrayList3), new Comparator() { // from class: com.studiolaganne.lengendarylens.GamesAdapter$onBindViewHolder$lambda$6$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues((Integer) t, (Integer) t2);
                }
            });
            if (listSortedWith2.isEmpty() || listSortedWith2.size() == 1) {
                gameViewHolder.getSmallUsersRecyclerView1().setAdapter(new SmallGamePlayerAdapter(CollectionsKt.toMutableList((Collection) game.getPlayers()), false, 0));
                gameViewHolder.getSmallUsersRecyclerView1().setLayoutManager(new LinearLayoutManager(holder.itemView.getContext(), 0, false));
                GameUtils companion2 = GameUtils.INSTANCE.getInstance();
                Context context4 = holder.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
                OverlapDecoration overlapDecoration2 = new OverlapDecoration(companion2.dpToPx(16, context4));
                int itemDecorationCount2 = gameViewHolder.getSmallUsersRecyclerView1().getItemDecorationCount();
                for (int i10 = 0; i10 < itemDecorationCount2; i10++) {
                    gameViewHolder.getSmallUsersRecyclerView1().removeItemDecorationAt(0);
                }
                gameViewHolder.getSmallUsersRecyclerView1().setVisibility(0);
                gameViewHolder.getSmallUsersRecyclerView1().addItemDecoration(overlapDecoration2);
                if (game.getPlayers().size() > 2) {
                    gameViewHolder.getInterLabel1().setVisibility(0);
                    gameViewHolder.getInterLabel1().setText("FFA");
                }
                gameViewHolder.getSmallUsersRecyclerView2().setVisibility(8);
                gameViewHolder.getInterLabel2().setVisibility(8);
                gameViewHolder.getSmallUsersRecyclerView3().setVisibility(8);
            } else {
                List list2 = listSortedWith2;
                if (list2.size() >= 2) {
                    gameViewHolder.getSmallUsersRecyclerView1().setVisibility(0);
                    gameViewHolder.getInterLabel1().setVisibility(0);
                    gameViewHolder.getSmallUsersRecyclerView2().setVisibility(0);
                    gameViewHolder.getInterLabel2().setVisibility(8);
                    gameViewHolder.getSmallUsersRecyclerView3().setVisibility(8);
                    gameViewHolder.getInterLabel1().setText("vs");
                    List<MTGamePlayer> players5 = game.getPlayers();
                    ArrayList arrayList4 = new ArrayList();
                    for (Object obj : players5) {
                        if (Intrinsics.areEqual(((MTGamePlayer) obj).getTeamid(), listSortedWith2.get(0))) {
                            arrayList4.add(obj);
                        }
                    }
                    gameViewHolder.getSmallUsersRecyclerView1().setAdapter(new SmallGamePlayerAdapter(arrayList4, false, 0));
                    gameViewHolder.getSmallUsersRecyclerView1().setLayoutManager(new LinearLayoutManager(holder.itemView.getContext(), 0, false));
                    GameUtils companion3 = GameUtils.INSTANCE.getInstance();
                    Context context5 = holder.itemView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context5, "getContext(...)");
                    OverlapDecoration overlapDecoration3 = new OverlapDecoration(companion3.dpToPx(16, context5));
                    int itemDecorationCount3 = gameViewHolder.getSmallUsersRecyclerView1().getItemDecorationCount();
                    for (int i11 = 0; i11 < itemDecorationCount3; i11++) {
                        gameViewHolder.getSmallUsersRecyclerView1().removeItemDecorationAt(0);
                    }
                    gameViewHolder.getSmallUsersRecyclerView1().setVisibility(0);
                    gameViewHolder.getSmallUsersRecyclerView1().addItemDecoration(overlapDecoration3);
                    List<MTGamePlayer> players6 = game.getPlayers();
                    ArrayList arrayList5 = new ArrayList();
                    for (Object obj2 : players6) {
                        if (Intrinsics.areEqual(((MTGamePlayer) obj2).getTeamid(), listSortedWith2.get(1))) {
                            arrayList5.add(obj2);
                        }
                    }
                    gameViewHolder.getSmallUsersRecyclerView2().setAdapter(new SmallGamePlayerAdapter(arrayList5, false, 0));
                    gameViewHolder.getSmallUsersRecyclerView2().setLayoutManager(new LinearLayoutManager(holder.itemView.getContext(), 0, false));
                    GameUtils companion4 = GameUtils.INSTANCE.getInstance();
                    Context context6 = holder.itemView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context6, "getContext(...)");
                    OverlapDecoration overlapDecoration4 = new OverlapDecoration(companion4.dpToPx(16, context6));
                    int itemDecorationCount4 = gameViewHolder.getSmallUsersRecyclerView2().getItemDecorationCount();
                    for (int i12 = 0; i12 < itemDecorationCount4; i12++) {
                        gameViewHolder.getSmallUsersRecyclerView2().removeItemDecorationAt(0);
                    }
                    i6 = 0;
                    gameViewHolder.getSmallUsersRecyclerView2().setVisibility(0);
                    gameViewHolder.getSmallUsersRecyclerView2().addItemDecoration(overlapDecoration4);
                } else {
                    i6 = 0;
                }
                if (list2.size() >= 3) {
                    gameViewHolder.getSmallUsersRecyclerView1().setVisibility(i6);
                    gameViewHolder.getInterLabel1().setVisibility(i6);
                    gameViewHolder.getSmallUsersRecyclerView2().setVisibility(i6);
                    gameViewHolder.getInterLabel2().setVisibility(i6);
                    gameViewHolder.getSmallUsersRecyclerView3().setVisibility(i6);
                    gameViewHolder.getInterLabel2().setText("vs");
                    List<MTGamePlayer> players7 = game.getPlayers();
                    ArrayList arrayList6 = new ArrayList();
                    for (Object obj3 : players7) {
                        if (Intrinsics.areEqual(((MTGamePlayer) obj3).getTeamid(), listSortedWith2.get(2))) {
                            arrayList6.add(obj3);
                        }
                    }
                    gameViewHolder.getSmallUsersRecyclerView3().setAdapter(new SmallGamePlayerAdapter(arrayList6, false, 0));
                    gameViewHolder.getSmallUsersRecyclerView3().setLayoutManager(new LinearLayoutManager(holder.itemView.getContext(), 0, false));
                    GameUtils companion5 = GameUtils.INSTANCE.getInstance();
                    Context context7 = holder.itemView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context7, "getContext(...)");
                    OverlapDecoration overlapDecoration5 = new OverlapDecoration(companion5.dpToPx(16, context7));
                    int itemDecorationCount5 = gameViewHolder.getSmallUsersRecyclerView3().getItemDecorationCount();
                    for (int i13 = 0; i13 < itemDecorationCount5; i13++) {
                        gameViewHolder.getSmallUsersRecyclerView3().removeItemDecorationAt(0);
                    }
                    gameViewHolder.getSmallUsersRecyclerView3().setVisibility(0);
                    gameViewHolder.getSmallUsersRecyclerView3().addItemDecoration(overlapDecoration5);
                }
                MTGameSubformat subformat3 = game.getSubformat();
                if (subformat3 != null && subformat3.getId() == 3) {
                    gameViewHolder.getLeaderImage().setVisibility(0);
                    gameViewHolder.getGuardianImage().setVisibility(0);
                    gameViewHolder.getAssassinsImage().setVisibility(0);
                    gameViewHolder.getTraitorsImage().setVisibility(0);
                }
            }
            Unit unit51 = Unit.INSTANCE;
            Unit unit52 = Unit.INSTANCE;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_item, parent, false);
            Intrinsics.checkNotNull(viewInflate);
            return new GameViewHolder(viewInflate, this.clickListener);
        }
        if (viewType == 2) {
            View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_separator_item, parent, false);
            Intrinsics.checkNotNull(viewInflate2);
            return new GameSeparatorViewHolder(viewInflate2, this.clickListener);
        }
        if (viewType == 3) {
            View viewInflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.load_more_item, parent, false);
            Intrinsics.checkNotNull(viewInflate3);
            return new GameLoadMoreViewHolder(viewInflate3, this.clickListener);
        }
        if (viewType != 4) {
            throw new IllegalArgumentException("Invalid view type");
        }
        View viewInflate4 = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_item_duel, parent, false);
        Intrinsics.checkNotNull(viewInflate4);
        return new GameDuelViewHolder(viewInflate4, this.clickListener);
    }

    public final void setLoadMoreVisible(boolean visible) {
        GameItemHolder gameItemHolder = (GameItemHolder) CollectionsKt.lastOrNull((List) this.games);
        boolean z = false;
        if (gameItemHolder != null && gameItemHolder.getType() == 3) {
            z = true;
        }
        if (visible && !z) {
            this.games.add(new GameItemHolder(3, null, null, 0, null, null, false, 126, null));
            notifyItemInserted(this.games.size() - 1);
        } else {
            if (visible || !z) {
                return;
            }
            int lastIndex = CollectionsKt.getLastIndex(this.games);
            this.games.remove(lastIndex);
            notifyItemRemoved(lastIndex);
        }
    }

    public final void updateGames(List<GameItemHolder> newGames) {
        Intrinsics.checkNotNullParameter(newGames, "newGames");
        this.games.clear();
        this.games.addAll(newGames);
        notifyDataSetChanged();
    }
}
