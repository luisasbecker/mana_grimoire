package com.studiolaganne.lengendarylens;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.button.MaterialButton;
import com.studiolaganne.lengendarylens.PlayerListAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlayerListAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0015\u0016B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/studiolaganne/lengendarylens/PlayerListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "players", "", "Lcom/studiolaganne/lengendarylens/TournamentPlayer;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/studiolaganne/lengendarylens/PlayerListClickListener;", "<init>", "(Ljava/util/List;Lcom/studiolaganne/lengendarylens/PlayerListClickListener;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "getItemViewType", "Companion", "TypePlayerViewHolder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PlayerListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int TYPE_PLAYER = 2;
    private final PlayerListClickListener listener;
    private final List<TournamentPlayer> players;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: PlayerListAdapter.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/studiolaganne/lengendarylens/PlayerListAdapter$TypePlayerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "positionLabel", "Landroid/widget/TextView;", "nameLabel", "dropButton", "Lcom/google/android/material/button/MaterialButton;", "editImage", "Landroid/widget/ImageView;", "bind", "", "position", "", "rowData", "Lcom/studiolaganne/lengendarylens/TournamentPlayer;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/studiolaganne/lengendarylens/PlayerListClickListener;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class TypePlayerViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private final MaterialButton dropButton;
        private final ImageView editImage;
        private final TextView nameLabel;
        private final TextView positionLabel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TypePlayerViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View viewFindViewById = view.findViewById(R.id.position_label);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.positionLabel = (TextView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.player_name_label);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.nameLabel = (TextView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.drop_button);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            this.dropButton = (MaterialButton) viewFindViewById3;
            View viewFindViewById4 = view.findViewById(R.id.editPlayerImage);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
            this.editImage = (ImageView) viewFindViewById4;
        }

        static final Unit bind$lambda$0(TournamentPlayer tournamentPlayer, PlayerListClickListener playerListClickListener) {
            if (tournamentPlayer.getDroppedAfterRound() >= 0) {
                return Unit.INSTANCE;
            }
            playerListClickListener.playerDropClicked(tournamentPlayer);
            return Unit.INSTANCE;
        }

        static final Unit bind$lambda$1(PlayerListClickListener playerListClickListener, TournamentPlayer tournamentPlayer) {
            playerListClickListener.playerEditClicked(tournamentPlayer);
            return Unit.INSTANCE;
        }

        public final void bind(int position, final TournamentPlayer rowData, final PlayerListClickListener listener) {
            Intrinsics.checkNotNullParameter(rowData, "rowData");
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.positionLabel.setText((position + 1) + " - ");
            this.nameLabel.setText(rowData.getName());
            int droppedAfterRound = rowData.getDroppedAfterRound();
            MaterialButton materialButton = this.dropButton;
            if (droppedAfterRound >= 0) {
                materialButton.setText(this.itemView.getResources().getString(R.string.dropped));
                MaterialButton materialButton2 = this.dropButton;
                materialButton2.setBackground(ContextCompat.getDrawable(materialButton2.getContext(), R.drawable.custom_life_button_background_disabled));
            } else {
                materialButton.setText(this.itemView.getResources().getString(R.string.drop_player));
                MaterialButton materialButton3 = this.dropButton;
                materialButton3.setBackground(ContextCompat.getDrawable(materialButton3.getContext(), R.drawable.custom_life_button_background_small));
            }
            ViewExtensionsKt.setOnClickWithFade(this.dropButton, new Function0() { // from class: com.studiolaganne.lengendarylens.PlayerListAdapter$TypePlayerViewHolder$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PlayerListAdapter.TypePlayerViewHolder.bind$lambda$0(rowData, listener);
                }
            });
            ViewExtensionsKt.setOnClickWithFade(this.editImage, new Function0() { // from class: com.studiolaganne.lengendarylens.PlayerListAdapter$TypePlayerViewHolder$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PlayerListAdapter.TypePlayerViewHolder.bind$lambda$1(listener, rowData);
                }
            });
        }
    }

    public PlayerListAdapter(List<TournamentPlayer> players, PlayerListClickListener listener) {
        Intrinsics.checkNotNullParameter(players, "players");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.players = players;
        this.listener = listener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.players.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof TypePlayerViewHolder) {
            ((TypePlayerViewHolder) holder).bind(position, this.players.get(position), this.listener);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        if (viewType != 2) {
            throw new IllegalArgumentException("Invalid view type");
        }
        View viewInflate = layoutInflaterFrom.inflate(R.layout.playerlist_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        return new TypePlayerViewHolder(viewInflate);
    }
}
