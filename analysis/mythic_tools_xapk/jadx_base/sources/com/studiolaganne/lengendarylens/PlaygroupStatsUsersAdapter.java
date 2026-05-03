package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.studiolaganne.lengendarylens.ProfileBottomSheetFragment;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: PlaygroupStatsUsersAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u001cB\u001f\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bH\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\bH\u0016J\b\u0010\u0017\u001a\u00020\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0014H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0016J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH\u0016J\b\u0010\u001b\u001a\u00020\bH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/studiolaganne/lengendarylens/PlaygroupStatsUsersAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/studiolaganne/lengendarylens/ProfileCallback;", "unsortedUsers", "", "Lcom/studiolaganne/lengendarylens/MTUser;", "currentFormatId", "", "<init>", "(Ljava/util/List;Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "users", "currentProfileSheet", "Lcom/studiolaganne/lengendarylens/ProfileBottomSheetFragment;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "onProfileClose", "onProfileLogout", "onProfilePictureUpdated", "getItemViewType", "getItemCount", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PlaygroupStatsUsersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ProfileCallback {
    private static final int VIEW_TYPE_PLAYGROUP_USER = 1;
    private final Integer currentFormatId;
    private ProfileBottomSheetFragment currentProfileSheet;
    private final List<MTUser> unsortedUsers;
    private final List<MTUser> users;
    public static final int $stable = 8;

    public PlaygroupStatsUsersAdapter(List<MTUser> unsortedUsers, Integer num) {
        Intrinsics.checkNotNullParameter(unsortedUsers, "unsortedUsers");
        this.unsortedUsers = unsortedUsers;
        this.currentFormatId = num;
        this.users = CollectionsKt.sortedWith(unsortedUsers, new Comparator() { // from class: com.studiolaganne.lengendarylens.PlaygroupStatsUsersAdapter$special$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                String rate;
                String rate2;
                MTStats stats = ((MTUser) t2).getStats();
                float f = -1.0f;
                Float fValueOf = Float.valueOf((stats == null || (rate2 = stats.getRate()) == null) ? -1.0f : Float.parseFloat(rate2));
                MTStats stats2 = ((MTUser) t).getStats();
                if (stats2 != null && (rate = stats2.getRate()) != null) {
                    f = Float.parseFloat(rate);
                }
                return ComparisonsKt.compareValues(fValueOf, Float.valueOf(f));
            }
        });
    }

    static final Unit onBindViewHolder$lambda$2(PlaygroupStatsUsersAdapter playgroupStatsUsersAdapter, MTUser mTUser, PlaygroupStatsUserViewHolder playgroupStatsUserViewHolder) {
        ProfileBottomSheetFragment profileBottomSheetFragmentNewInstance$default = ProfileBottomSheetFragment.Companion.newInstance$default(ProfileBottomSheetFragment.INSTANCE, playgroupStatsUsersAdapter, mTUser, true, null, 8, null);
        playgroupStatsUsersAdapter.currentProfileSheet = profileBottomSheetFragmentNewInstance$default;
        Context context = playgroupStatsUserViewHolder.itemView.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.studiolaganne.lengendarylens.PlaygroupDetailsActivity");
        profileBottomSheetFragmentNewInstance$default.show(((PlaygroupDetailsActivity) context).getSupportFragmentManager(), ProfileBottomSheetFragment.TAG);
        return Unit.INSTANCE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.users.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final PlaygroupStatsUserViewHolder playgroupStatsUserViewHolder = (PlaygroupStatsUserViewHolder) holder;
        final MTUser mTUser = this.users.get(position);
        playgroupStatsUserViewHolder.getUserFirstName().setText(mTUser.getFirstname());
        playgroupStatsUserViewHolder.getUserName().setText("@" + mTUser.getUsername());
        playgroupStatsUserViewHolder.getProfileLayout().setOutlineProvider(new CircularOutlineProvider());
        playgroupStatsUserViewHolder.getProfileLayout().setClipToOutline(true);
        playgroupStatsUserViewHolder.getProfileIcon().setOutlineProvider(new CircularOutlineProvider());
        playgroupStatsUserViewHolder.getProfileIcon().setClipToOutline(true);
        String picture = mTUser.getPicture();
        String str = picture;
        if (str == null || str.length() == 0 || Intrinsics.areEqual(picture, AbstractJsonLexerKt.NULL)) {
            playgroupStatsUserViewHolder.getProfileIcon().setVisibility(4);
            playgroupStatsUserViewHolder.getNoPhotoIcon().setVisibility(0);
        } else {
            playgroupStatsUserViewHolder.getProfileIcon().setVisibility(0);
            playgroupStatsUserViewHolder.getNoPhotoIcon().setVisibility(4);
            playgroupStatsUserViewHolder.getProfileIcon().reset();
            playgroupStatsUserViewHolder.getProfileIcon().setAutoLoad(false);
            playgroupStatsUserViewHolder.getProfileIcon().loadImage(picture);
        }
        playgroupStatsUserViewHolder.getStatsLayout().setVisibility(0);
        MTStats stats = mTUser.getStats();
        if (stats != null) {
            if (stats.getGames() == 0) {
                playgroupStatsUserViewHolder.getWinRateValueLabel().setText("--");
                playgroupStatsUserViewHolder.getWinRateValueLabel().setTextColor(ContextCompat.getColor(playgroupStatsUserViewHolder.itemView.getContext(), R.color.text_color));
            } else {
                try {
                    float f = Float.parseFloat(stats.getRate());
                    if (Math.abs(f) <= Float.MAX_VALUE) {
                        playgroupStatsUserViewHolder.getWinRateValueLabel().setText(MathKt.roundToInt(f) + "%");
                        TextView winRateValueLabel = playgroupStatsUserViewHolder.getWinRateValueLabel();
                        GameUtils companion = GameUtils.INSTANCE.getInstance();
                        Context context = playgroupStatsUserViewHolder.itemView.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                        winRateValueLabel.setTextColor(companion.getWinRateColor(context, Float.parseFloat(stats.getRate()), this.currentFormatId));
                    } else {
                        playgroupStatsUserViewHolder.getWinRateValueLabel().setText("--");
                        playgroupStatsUserViewHolder.getWinRateValueLabel().setTextColor(ContextCompat.getColor(playgroupStatsUserViewHolder.itemView.getContext(), R.color.text_color));
                    }
                } catch (NumberFormatException unused) {
                    playgroupStatsUserViewHolder.getWinRateValueLabel().setText("--");
                    playgroupStatsUserViewHolder.getWinRateValueLabel().setTextColor(ContextCompat.getColor(playgroupStatsUserViewHolder.itemView.getContext(), R.color.text_color));
                }
            }
            playgroupStatsUserViewHolder.getGamesValueLabel().setText(String.valueOf(stats.getGames()));
            if (stats.getGames() == 0 || stats.getGames() == 1) {
                playgroupStatsUserViewHolder.getGamesLabel().setText(playgroupStatsUserViewHolder.itemView.getResources().getString(R.string.games_singular));
            } else {
                playgroupStatsUserViewHolder.getGamesLabel().setText(playgroupStatsUserViewHolder.itemView.getResources().getString(R.string.games_plural));
            }
            playgroupStatsUserViewHolder.getWinsValueLabel().setText(String.valueOf(stats.getWins()));
            playgroupStatsUserViewHolder.getWinsLabel().setText("-");
            playgroupStatsUserViewHolder.getLossesValueLabel().setText(String.valueOf(stats.getLosses()));
            playgroupStatsUserViewHolder.getLossesLabel().setText("-");
            playgroupStatsUserViewHolder.getDrawsValueLabel().setText(String.valueOf(stats.getDraws()));
        } else {
            playgroupStatsUserViewHolder.getStatsLayout().setVisibility(4);
        }
        ViewExtensionsKt.setOnClickWithFade(playgroupStatsUserViewHolder.getProfileLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.PlaygroupStatsUsersAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PlaygroupStatsUsersAdapter.onBindViewHolder$lambda$2(this.f$0, mTUser, playgroupStatsUserViewHolder);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 1) {
            throw new IllegalArgumentException("Invalid view type");
        }
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.playgroup_stats_member_item, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new PlaygroupStatsUserViewHolder(viewInflate);
    }

    @Override // com.studiolaganne.lengendarylens.ProfileCallback
    public void onProfileClose() {
        ProfileBottomSheetFragment profileBottomSheetFragment = this.currentProfileSheet;
        if (profileBottomSheetFragment != null) {
            profileBottomSheetFragment.dismiss();
        }
        this.currentProfileSheet = null;
    }

    @Override // com.studiolaganne.lengendarylens.ProfileCallback
    public void onProfileLogout() {
    }

    @Override // com.studiolaganne.lengendarylens.ProfileCallback
    public void onProfilePictureUpdated() {
    }
}
