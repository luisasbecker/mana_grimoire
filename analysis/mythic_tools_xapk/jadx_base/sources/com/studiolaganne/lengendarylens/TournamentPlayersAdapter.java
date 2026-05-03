package com.studiolaganne.lengendarylens;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TournamentPlayersAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u000bH\u0016J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bH\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/studiolaganne/lengendarylens/TournamentPlayersAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "players", "", "Lcom/studiolaganne/lengendarylens/TournamentPlayer;", "clickListener", "Lcom/studiolaganne/lengendarylens/TournamentPlayerClickListener;", "<init>", "(Ljava/util/List;Lcom/studiolaganne/lengendarylens/TournamentPlayerClickListener;)V", "getPlayerIndexById", "", "id", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "getItemViewType", "getItemCount", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TournamentPlayersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int VIEW_TYPE_ADD_PLAYER = 1;
    private static final int VIEW_TYPE_PLAYER = 0;
    private final TournamentPlayerClickListener clickListener;
    private final List<TournamentPlayer> players;
    public static final int $stable = 8;

    public TournamentPlayersAdapter(List<TournamentPlayer> players, TournamentPlayerClickListener clickListener) {
        Intrinsics.checkNotNullParameter(players, "players");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.players = players;
        this.clickListener = clickListener;
    }

    static final Unit onBindViewHolder$lambda$0(TournamentPlayerViewHolder tournamentPlayerViewHolder, TournamentPlayer tournamentPlayer) {
        tournamentPlayerViewHolder.getClickListener().onPlayerRemoved(tournamentPlayer.getId(), tournamentPlayer.getName());
        return Unit.INSTANCE;
    }

    static final Unit onBindViewHolder$lambda$1(AddTournamentPlayerViewHolder addTournamentPlayerViewHolder) {
        addTournamentPlayerViewHolder.getClickListener().onAddPlayerClick();
        return Unit.INSTANCE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.players.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return position < this.players.size() ? 0 : 1;
    }

    public final int getPlayerIndexById(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        Iterator<TournamentPlayer> it = this.players.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next().getId(), id)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (getItemViewType(position) == 0) {
            final TournamentPlayerViewHolder tournamentPlayerViewHolder = (TournamentPlayerViewHolder) holder;
            final TournamentPlayer tournamentPlayer = this.players.get(position);
            tournamentPlayerViewHolder.getPlayerPosition().setText((position + 1) + ".");
            tournamentPlayerViewHolder.getPlayerName().setText(tournamentPlayer.getName());
            tournamentPlayerViewHolder.getCardView().setStrokeColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.darker_blue));
            tournamentPlayerViewHolder.getCardView().setStrokeWidth(2);
            tournamentPlayerViewHolder.getCloseImage().setRotation(45.0f);
            ViewExtensionsKt.setOnClickWithFade(tournamentPlayerViewHolder.getCloseImage(), new Function0() { // from class: com.studiolaganne.lengendarylens.TournamentPlayersAdapter$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return TournamentPlayersAdapter.onBindViewHolder$lambda$0(tournamentPlayerViewHolder, tournamentPlayer);
                }
            });
        }
        if (getItemViewType(position) == 1) {
            final AddTournamentPlayerViewHolder addTournamentPlayerViewHolder = (AddTournamentPlayerViewHolder) holder;
            ViewExtensionsKt.setOnClickWithBounce(addTournamentPlayerViewHolder.getRootLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.TournamentPlayersAdapter$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return TournamentPlayersAdapter.onBindViewHolder$lambda$1(addTournamentPlayerViewHolder);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.tournament_player_item, parent, false);
            Intrinsics.checkNotNull(viewInflate);
            return new TournamentPlayerViewHolder(viewInflate, this.clickListener);
        }
        if (viewType != 1) {
            throw new IllegalArgumentException("Invalid view type");
        }
        View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.add_tournament_player_item, parent, false);
        Intrinsics.checkNotNull(viewInflate2);
        return new AddTournamentPlayerViewHolder(viewInflate2, this.clickListener);
    }
}
