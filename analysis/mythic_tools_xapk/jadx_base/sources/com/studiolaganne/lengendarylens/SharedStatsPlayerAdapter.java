package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.autofill.HintConstants;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: SharedStatsPlayerAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/studiolaganne/lengendarylens/SharedStatsPlayerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/studiolaganne/lengendarylens/SharedStatsPlayerAdapter$ViewHolder;", "context", "Landroid/content/Context;", "players", "", "Lcom/studiolaganne/lengendarylens/SharedStatsPlayerItem;", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "ViewHolder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SharedStatsPlayerAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final int $stable = 8;
    private final Context context;
    private final List<SharedStatsPlayerItem> players;

    /* JADX INFO: compiled from: SharedStatsPlayerAdapter.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\u0016\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\u0018\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\u001a\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R\u0011\u0010\u001c\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/studiolaganne/lengendarylens/SharedStatsPlayerAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "profileIcon", "Lcom/studiolaganne/lengendarylens/CachedImageView;", "getProfileIcon", "()Lcom/studiolaganne/lengendarylens/CachedImageView;", "noPhotoIcon", "Landroid/widget/ImageView;", "getNoPhotoIcon", "()Landroid/widget/ImageView;", "firstname", "Landroid/widget/TextView;", "getFirstname", "()Landroid/widget/TextView;", HintConstants.AUTOFILL_HINT_USERNAME, "getUsername", "winrate", "getWinrate", "winsValue", "getWinsValue", "lossesValue", "getLossesValue", "drawsValue", "getDrawsValue", "gamesCount", "getGamesCount", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private final TextView drawsValue;
        private final TextView firstname;
        private final TextView gamesCount;
        private final TextView lossesValue;
        private final ImageView noPhotoIcon;
        private final CachedImageView profileIcon;
        private final TextView username;
        private final TextView winrate;
        private final TextView winsValue;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View viewFindViewById = view.findViewById(R.id.profileIcon);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.profileIcon = (CachedImageView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.noPhotoIcon);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.noPhotoIcon = (ImageView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.firstname);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            this.firstname = (TextView) viewFindViewById3;
            View viewFindViewById4 = view.findViewById(R.id.username);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
            this.username = (TextView) viewFindViewById4;
            View viewFindViewById5 = view.findViewById(R.id.winrate);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
            this.winrate = (TextView) viewFindViewById5;
            View viewFindViewById6 = view.findViewById(R.id.winsValue);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
            this.winsValue = (TextView) viewFindViewById6;
            View viewFindViewById7 = view.findViewById(R.id.lossesValue);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
            this.lossesValue = (TextView) viewFindViewById7;
            View viewFindViewById8 = view.findViewById(R.id.drawsValue);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
            this.drawsValue = (TextView) viewFindViewById8;
            View viewFindViewById9 = view.findViewById(R.id.gamesCount);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
            this.gamesCount = (TextView) viewFindViewById9;
        }

        public final TextView getDrawsValue() {
            return this.drawsValue;
        }

        public final TextView getFirstname() {
            return this.firstname;
        }

        public final TextView getGamesCount() {
            return this.gamesCount;
        }

        public final TextView getLossesValue() {
            return this.lossesValue;
        }

        public final ImageView getNoPhotoIcon() {
            return this.noPhotoIcon;
        }

        public final CachedImageView getProfileIcon() {
            return this.profileIcon;
        }

        public final TextView getUsername() {
            return this.username;
        }

        public final TextView getWinrate() {
            return this.winrate;
        }

        public final TextView getWinsValue() {
            return this.winsValue;
        }
    }

    public SharedStatsPlayerAdapter(Context context, List<SharedStatsPlayerItem> players) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(players, "players");
        this.context = context;
        this.players = players;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.players.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        SharedStatsPlayerItem sharedStatsPlayerItem = this.players.get(position);
        holder.getProfileIcon().setOutlineProvider(new CircularOutlineProvider());
        holder.getProfileIcon().setClipToOutline(true);
        String picture = sharedStatsPlayerItem.getPicture();
        if (picture == null || picture.length() == 0) {
            holder.getProfileIcon().setVisibility(4);
            holder.getNoPhotoIcon().setVisibility(0);
        } else {
            holder.getProfileIcon().setAutoLoad(false);
            holder.getProfileIcon().loadImage(sharedStatsPlayerItem.getPicture());
            holder.getProfileIcon().setVisibility(0);
            holder.getNoPhotoIcon().setVisibility(4);
        }
        TextView firstname = holder.getFirstname();
        String firstname2 = sharedStatsPlayerItem.getFirstname();
        firstname.setText(firstname2 != null ? firstname2 : "");
        TextView username = holder.getUsername();
        String username2 = sharedStatsPlayerItem.getUsername();
        username.setText((username2 == null || username2.length() == 0) ? "" : "@" + sharedStatsPlayerItem.getUsername());
        try {
            float f = Float.parseFloat(sharedStatsPlayerItem.getRate());
            if (Math.abs(f) > Float.MAX_VALUE || sharedStatsPlayerItem.getGames() <= 0) {
                holder.getWinrate().setText("--");
                holder.getWinrate().setTextColor(ContextCompat.getColor(this.context, R.color.text_color));
            } else {
                holder.getWinrate().setText(MathKt.roundToInt(f) + "%");
                holder.getWinrate().setTextColor(GameUtils.INSTANCE.getInstance().getWinRateColor(this.context, f, sharedStatsPlayerItem.getFormatId()));
            }
        } catch (NumberFormatException unused) {
            holder.getWinrate().setText("--");
            holder.getWinrate().setTextColor(ContextCompat.getColor(this.context, R.color.text_color));
        }
        holder.getWinsValue().setText(String.valueOf(sharedStatsPlayerItem.getWins()));
        holder.getLossesValue().setText(String.valueOf(sharedStatsPlayerItem.getLosses()));
        holder.getDrawsValue().setText(String.valueOf(sharedStatsPlayerItem.getDraws()));
        int games = sharedStatsPlayerItem.getGames();
        Context context = this.context;
        String string = games == 1 ? context.getString(R.string.games_singular) : context.getString(R.string.games_plural);
        Intrinsics.checkNotNull(string);
        holder.getGamesCount().setText(sharedStatsPlayerItem.getGames() + " " + string);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.item_shared_stats_player, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new ViewHolder(viewInflate);
    }
}
