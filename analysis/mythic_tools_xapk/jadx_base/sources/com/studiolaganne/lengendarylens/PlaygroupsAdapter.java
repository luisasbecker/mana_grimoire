package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.studiolaganne.lengendarylens.MessagesDBHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: PlaygroupsAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/studiolaganne/lengendarylens/PlaygroupsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "playgroups", "", "Lcom/studiolaganne/lengendarylens/MTPlaygroup;", "clickListener", "Lcom/studiolaganne/lengendarylens/PlaygroupsClickListener;", "<init>", "(Ljava/util/List;Lcom/studiolaganne/lengendarylens/PlaygroupsClickListener;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemViewType", "getItemCount", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PlaygroupsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int VIEW_TYPE_PLAYGROUP = 1;
    private final PlaygroupsClickListener clickListener;
    private final List<MTPlaygroup> playgroups;
    public static final int $stable = 8;

    public PlaygroupsAdapter(List<MTPlaygroup> playgroups, PlaygroupsClickListener clickListener) {
        Intrinsics.checkNotNullParameter(playgroups, "playgroups");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.playgroups = playgroups;
        this.clickListener = clickListener;
    }

    static final Unit onBindViewHolder$lambda$0(PlaygroupsAdapter playgroupsAdapter, MTPlaygroup mTPlaygroup) {
        playgroupsAdapter.clickListener.onPlaygroupSelected(mTPlaygroup);
        return Unit.INSTANCE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.playgroups.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        PlaygroupViewHolder playgroupViewHolder = (PlaygroupViewHolder) holder;
        final MTPlaygroup mTPlaygroup = this.playgroups.get(position);
        playgroupViewHolder.getProfileIcon().setOutlineProvider(new CircularOutlineProvider());
        playgroupViewHolder.getProfileIcon().setClipToOutline(true);
        playgroupViewHolder.getPlaygroupName().setText(mTPlaygroup.getName());
        playgroupViewHolder.getPlaygroupDescription().setText(mTPlaygroup.getDescription());
        playgroupViewHolder.getUsersCount().setText(String.valueOf(mTPlaygroup.getUsers().size()));
        playgroupViewHolder.getNotificationsView().setVisibility(8);
        MessagesDBHelper.Companion companion = MessagesDBHelper.INSTANCE;
        Context context = playgroupViewHolder.getRootLayout().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        int unreadMessagesCountForPlaygroup = companion.getInstance(context).getUnreadMessagesCountForPlaygroup(mTPlaygroup.getId());
        Log.d("PlaygroupsAdapter", "Unread messages for playgroup " + mTPlaygroup.getId() + ": " + unreadMessagesCountForPlaygroup);
        if (unreadMessagesCountForPlaygroup > 0) {
            playgroupViewHolder.getNotificationsView().setVisibility(0);
            if (unreadMessagesCountForPlaygroup < 9) {
                playgroupViewHolder.getNotificationCount().setText(String.valueOf(unreadMessagesCountForPlaygroup));
            } else {
                playgroupViewHolder.getNotificationCount().setText("9+");
            }
        }
        String picture = mTPlaygroup.getPicture();
        String str = picture;
        if (str == null || str.length() == 0 || Intrinsics.areEqual(picture, AbstractJsonLexerKt.NULL)) {
            playgroupViewHolder.getDefaultProfileImage().setVisibility(0);
            playgroupViewHolder.getProfileImage().setVisibility(8);
        } else {
            playgroupViewHolder.getDefaultProfileImage().setVisibility(8);
            playgroupViewHolder.getProfileImage().setVisibility(0);
            playgroupViewHolder.getProfileImage().setAutoLoad(false);
            playgroupViewHolder.getProfileImage().reset();
            playgroupViewHolder.getProfileImage().loadImage(picture);
        }
        ViewExtensionsKt.setOnClickWithFade(playgroupViewHolder.getRootLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.PlaygroupsAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PlaygroupsAdapter.onBindViewHolder$lambda$0(this.f$0, mTPlaygroup);
            }
        });
        if (Intrinsics.areEqual(mTPlaygroup.getStatus(), "pending")) {
            playgroupViewHolder.getPendingText().setVisibility(0);
        } else {
            playgroupViewHolder.getPendingText().setVisibility(8);
        }
        List listTake = CollectionsKt.take(mTPlaygroup.getUsers(), 4);
        boolean z = mTPlaygroup.getUsers().size() > 4;
        playgroupViewHolder.getUsersRecyclerView().setAdapter(new SmallUsersAdapter(listTake, z, z ? mTPlaygroup.getUsers().size() - 4 : 0));
        playgroupViewHolder.getUsersRecyclerView().setLayoutManager(new LinearLayoutManager(playgroupViewHolder.itemView.getContext(), 0, false));
        GameUtils companion2 = GameUtils.INSTANCE.getInstance();
        Context context2 = playgroupViewHolder.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        OverlapDecoration overlapDecoration = new OverlapDecoration(companion2.dpToPx(12, context2));
        int itemDecorationCount = playgroupViewHolder.getUsersRecyclerView().getItemDecorationCount();
        for (int i = 0; i < itemDecorationCount; i++) {
            playgroupViewHolder.getUsersRecyclerView().removeItemDecorationAt(0);
        }
        playgroupViewHolder.getUsersRecyclerView().addItemDecoration(overlapDecoration);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 1) {
            throw new IllegalArgumentException("Invalid view type");
        }
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.playgroup_item, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new PlaygroupViewHolder(viewInflate, this.clickListener);
    }
}
