package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: compiled from: PlayerResultsAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B3\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/studiolaganne/lengendarylens/PlayerResultsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/studiolaganne/lengendarylens/PlayerResultViewHolder;", FirebaseAnalytics.Param.ITEMS, "", "Lcom/studiolaganne/lengendarylens/PlayerResultItem;", "formats", "Lcom/studiolaganne/lengendarylens/MTFormat;", "context", "Landroid/content/Context;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/studiolaganne/lengendarylens/PlayerResultClickListener;", "<init>", "(Ljava/util/List;Ljava/util/List;Landroid/content/Context;Lcom/studiolaganne/lengendarylens/PlayerResultClickListener;)V", "updatePlayerResults", "", "newItems", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PlayerResultsAdapter extends RecyclerView.Adapter<PlayerResultViewHolder> {
    public static final int $stable = 8;
    private final Context context;
    private final List<MTFormat> formats;
    private final List<PlayerResultItem> items;
    private final PlayerResultClickListener listener;

    public PlayerResultsAdapter(List<PlayerResultItem> items, List<MTFormat> formats, Context context, PlayerResultClickListener listener) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(formats, "formats");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.items = items;
        this.formats = formats;
        this.context = context;
        this.listener = listener;
    }

    static final Unit onBindViewHolder$lambda$0(PlayerResultsAdapter playerResultsAdapter, PlayerResultItem playerResultItem) {
        playerResultsAdapter.listener.onPlayerResultTapped(playerResultItem);
        return Unit.INSTANCE;
    }

    static final Unit onBindViewHolder$lambda$2(PlayerResultViewHolder playerResultViewHolder, MTDeckData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.getDeckImageURL().length() > 0) {
            playerResultViewHolder.getDeckImage().setVisibility(0);
            playerResultViewHolder.getDeckImage().setImageUrl(data.getDeckImageURL());
            playerResultViewHolder.getDeckImage().setAutoLoad(false);
            playerResultViewHolder.getDeckImage().setArtCrop(data.isArtCrop());
            playerResultViewHolder.getDeckImage().loadSingleImage(data.getDeckImageURL());
        } else {
            playerResultViewHolder.getDeckImage().setVisibility(8);
        }
        return Unit.INSTANCE;
    }

    static final Unit onBindViewHolder$lambda$3(PlayerResultViewHolder playerResultViewHolder, String str) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        playerResultViewHolder.getDeckImage().setVisibility(8);
        return Unit.INSTANCE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final PlayerResultViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final PlayerResultItem playerResultItem = this.items.get(position);
        Player player = playerResultItem.getPlayer();
        MTUser user = playerResultItem.getUser();
        MTDeck deck = playerResultItem.getDeck();
        ViewExtensionsKt.setOnClickWithFade(holder.getRootLineLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.PlayerResultsAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PlayerResultsAdapter.onBindViewHolder$lambda$0(this.f$0, playerResultItem);
            }
        });
        holder.getRootLineLayout().setClipToOutline(true);
        holder.getRootLineLayout().setClipChildren(true);
        holder.getProfileIconSummary().setOutlineProvider(new CircularOutlineProvider());
        holder.getProfileIconSummary().setClipToOutline(true);
        if (user != null) {
            TextView firstnameTextView = holder.getFirstnameTextView();
            String firstname = user.getFirstname();
            firstnameTextView.setText(firstname != null ? firstname : player.getName());
            String username = user.getUsername();
            if (username == null || username.length() == 0) {
                holder.getUsernameTextView().setVisibility(8);
            } else {
                holder.getUsernameTextView().setText("(@" + user.getUsername() + ")");
                holder.getUsernameTextView().setVisibility(0);
            }
            String picture = user.getPicture();
            String str = picture;
            if (str == null || str.length() == 0) {
                holder.getProfileIconSummary().setVisibility(4);
                holder.getNoPhotoIconSummary().setVisibility(0);
            } else {
                holder.getProfileIconSummary().setVisibility(0);
                holder.getNoPhotoIconSummary().setVisibility(4);
                holder.getProfileIconSummary().setAutoLoad(false);
                holder.getProfileIconSummary().reset();
                holder.getProfileIconSummary().loadImage(picture);
            }
        } else {
            TextView firstnameTextView2 = holder.getFirstnameTextView();
            String name = player.getName();
            if (name.length() == 0) {
                name = "Guest";
            }
            firstnameTextView2.setText(name);
            holder.getUsernameTextView().setVisibility(8);
            holder.getProfileIconSummary().setVisibility(4);
            holder.getNoPhotoIconSummary().setVisibility(0);
        }
        int resultId = playerResultItem.getResultId();
        if (resultId == 0) {
            holder.getResultTextView().setText(this.context.getString(R.string.lose));
            holder.getResultTextView().setBackgroundResource(R.drawable.custom_loser_background);
        } else if (resultId == 1) {
            holder.getResultTextView().setText(this.context.getString(R.string.win));
            holder.getResultTextView().setBackgroundResource(R.drawable.custom_winner_background);
        } else if (resultId == 2) {
            holder.getResultTextView().setText(this.context.getString(R.string.conceded));
            holder.getResultTextView().setBackgroundResource(R.drawable.custom_loser_background);
        } else if (resultId != 3) {
            holder.getResultTextView().setText(this.context.getString(R.string.lose));
            holder.getResultTextView().setBackgroundResource(R.drawable.custom_loser_background);
        } else {
            holder.getResultTextView().setText(this.context.getString(R.string.draw));
            holder.getResultTextView().setBackgroundResource(R.drawable.custom_draw_background);
        }
        holder.getDeckName().setText("");
        holder.getDeckImage().setScaleX(-1.0f);
        if (deck != null) {
            holder.getDeckName().setText(deck.getName());
            holder.getDeckName().setTextColor(holder.itemView.getContext().getColor(R.color.selected_color_new));
            DeckUtils.INSTANCE.getInstance().fetchDeckData(this.context, deck, new Function1() { // from class: com.studiolaganne.lengendarylens.PlayerResultsAdapter$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PlayerResultsAdapter.onBindViewHolder$lambda$2(holder, (MTDeckData) obj);
                }
            }, new Function1() { // from class: com.studiolaganne.lengendarylens.PlayerResultsAdapter$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PlayerResultsAdapter.onBindViewHolder$lambda$3(holder, (String) obj);
                }
            });
        } else {
            holder.getDeckImage().setVisibility(8);
            holder.getDeckName().setTextColor(holder.itemView.getContext().getColor(R.color.text_color));
            holder.getDeckName().setText(this.context.getString(R.string.no_deck_selected));
        }
        holder.getEditIconTextView().setVisibility(0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public PlayerResultViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_player_result_item, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new PlayerResultViewHolder(viewInflate);
    }

    public final void updatePlayerResults(List<PlayerResultItem> newItems) {
        Intrinsics.checkNotNullParameter(newItems, "newItems");
        List<PlayerResultItem> list = this.items;
        Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.MutableList<com.studiolaganne.lengendarylens.PlayerResultItem>");
        TypeIntrinsics.asMutableList(list).clear();
        this.items.addAll(newItems);
        notifyDataSetChanged();
    }
}
