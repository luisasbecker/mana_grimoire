package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.studiolaganne.lengendarylens.MessagesDBHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: PlaygroupListAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/studiolaganne/lengendarylens/PlaygroupListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "playgroups", "", "Lcom/studiolaganne/lengendarylens/MTPlaygroup;", "clickListener", "Lcom/studiolaganne/lengendarylens/PlaygroupListClickListener;", "<init>", "(Ljava/util/List;Lcom/studiolaganne/lengendarylens/PlaygroupListClickListener;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemViewType", "getItemCount", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PlaygroupListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int VIEW_TYPE_PLAYGROUP = 1;
    private final PlaygroupListClickListener clickListener;
    private final List<MTPlaygroup> playgroups;
    public static final int $stable = 8;

    public PlaygroupListAdapter(List<MTPlaygroup> playgroups, PlaygroupListClickListener clickListener) {
        Intrinsics.checkNotNullParameter(playgroups, "playgroups");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.playgroups = playgroups;
        this.clickListener = clickListener;
    }

    static final Unit onBindViewHolder$lambda$2(PlaygroupListAdapter playgroupListAdapter, MTPlaygroup mTPlaygroup) {
        playgroupListAdapter.clickListener.onPlaygroupSelected(mTPlaygroup);
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
        PlaygroupListViewHolder playgroupListViewHolder = (PlaygroupListViewHolder) holder;
        final MTPlaygroup mTPlaygroup = this.playgroups.get(position);
        playgroupListViewHolder.getPlaygroupName().setText(mTPlaygroup.getName());
        playgroupListViewHolder.getProfileLayout().setOutlineProvider(new CircularOutlineProvider());
        playgroupListViewHolder.getProfileLayout().setClipToOutline(true);
        String picture = mTPlaygroup.getPicture();
        String str = picture;
        if (str == null || str.length() == 0 || Intrinsics.areEqual(picture, AbstractJsonLexerKt.NULL)) {
            playgroupListViewHolder.getProfileIcon().setVisibility(4);
            playgroupListViewHolder.getNoPhotoIcon().setVisibility(0);
        } else {
            playgroupListViewHolder.getProfileIcon().setVisibility(0);
            playgroupListViewHolder.getNoPhotoIcon().setVisibility(4);
            playgroupListViewHolder.getProfileIcon().reset();
            playgroupListViewHolder.getProfileIcon().setAutoLoad(false);
            playgroupListViewHolder.getProfileIcon().loadImage(picture);
        }
        if (Intrinsics.areEqual(mTPlaygroup.getStatus(), "pending")) {
            playgroupListViewHolder.getNotificationBubble().setVisibility(8);
            playgroupListViewHolder.getSecondaryText().setText(playgroupListViewHolder.itemView.getResources().getString(R.string.youve_been_invited));
            playgroupListViewHolder.getActionButtonLayout().setVisibility(0);
            playgroupListViewHolder.getActionButtonLayout().setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.PlaygroupListAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.clickListener.onPlaygroupPending(mTPlaygroup);
                }
            });
            return;
        }
        playgroupListViewHolder.getSecondaryText().setText(playgroupListViewHolder.itemView.getResources().getString(R.string.no_messages_yet));
        playgroupListViewHolder.getActionButtonLayout().setVisibility(8);
        MessagesDBHelper.Companion companion = MessagesDBHelper.INSTANCE;
        Context context = playgroupListViewHolder.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        MessagesDBHelper companion2 = companion.getInstance(context);
        MTMessage latestMessageForPlaygroup = companion2.getLatestMessageForPlaygroup(mTPlaygroup.getId());
        if (latestMessageForPlaygroup != null) {
            if (StringsKt.startsWith$default(latestMessageForPlaygroup.getContent(), "[[card:", false, 2, (Object) null)) {
                String string = playgroupListViewHolder.itemView.getResources().getString(R.string.card_message);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                playgroupListViewHolder.getSecondaryText().setText(latestMessageForPlaygroup.getFirstname() + ": " + string);
            } else {
                playgroupListViewHolder.getSecondaryText().setText(latestMessageForPlaygroup.getFirstname() + ": " + latestMessageForPlaygroup.getContent());
            }
        }
        playgroupListViewHolder.getNotificationBubble().setVisibility(8);
        int unreadMessagesCountForPlaygroup = companion2.getUnreadMessagesCountForPlaygroup(mTPlaygroup.getId());
        if (unreadMessagesCountForPlaygroup > 0) {
            playgroupListViewHolder.getNotificationBubble().setVisibility(0);
            if (unreadMessagesCountForPlaygroup < 9) {
                playgroupListViewHolder.getNotificationCount().setText(String.valueOf(unreadMessagesCountForPlaygroup));
            } else {
                playgroupListViewHolder.getNotificationCount().setText("9+");
            }
        }
        ViewExtensionsKt.setOnClickWithFade(playgroupListViewHolder.getRootLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.PlaygroupListAdapter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PlaygroupListAdapter.onBindViewHolder$lambda$2(this.f$0, mTPlaygroup);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 1) {
            throw new IllegalArgumentException("Invalid view type");
        }
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.playgroup_list_item, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new PlaygroupListViewHolder(viewInflate, this.clickListener);
    }
}
