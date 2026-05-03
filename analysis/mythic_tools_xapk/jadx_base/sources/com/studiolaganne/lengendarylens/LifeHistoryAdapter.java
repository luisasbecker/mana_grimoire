package com.studiolaganne.lengendarylens;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LifeHistoryAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u001f\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/studiolaganne/lengendarylens/LifeHistoryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "entries", "", "Lcom/studiolaganne/lengendarylens/LifeHistoryEntry;", Key.ROTATION, "", "<init>", "(Ljava/util/List;I)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "getItemViewType", "getItemCount", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LifeHistoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int VIEW_TYPE_ENTRY = 1;
    private final List<LifeHistoryEntry> entries;
    private final int rotation;
    public static final int $stable = 8;

    public LifeHistoryAdapter(List<LifeHistoryEntry> entries, int i) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        this.entries = entries;
        this.rotation = i;
    }

    public /* synthetic */ LifeHistoryAdapter(List list, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i2 & 2) != 0 ? 0 : i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.entries.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        LifeHistoryViewHolder lifeHistoryViewHolder = (LifeHistoryViewHolder) holder;
        LifeHistoryEntry lifeHistoryEntry = this.entries.get(position);
        lifeHistoryViewHolder.getRootLayout().setRotation(this.rotation);
        lifeHistoryViewHolder.getLifeTotalTextView().setText(String.valueOf(lifeHistoryEntry.getLifeTotal()));
        Integer offset = lifeHistoryEntry.getOffset();
        if (offset == null) {
            lifeHistoryViewHolder.getOffsetTextView().setVisibility(8);
            lifeHistoryViewHolder.getStrikeThrough().setVisibility(8);
            lifeHistoryViewHolder.getStrikeThroughShadow().setVisibility(8);
            return;
        }
        int iIntValue = offset.intValue();
        lifeHistoryViewHolder.getOffsetTextView().setVisibility(0);
        lifeHistoryViewHolder.getStrikeThrough().setVisibility(0);
        lifeHistoryViewHolder.getStrikeThroughShadow().setVisibility(0);
        if (iIntValue > 0) {
            lifeHistoryViewHolder.getOffsetTextView().setText("+" + iIntValue);
            lifeHistoryViewHolder.getOffsetTextView().setTextColor(ContextCompat.getColor(lifeHistoryViewHolder.getRootLayout().getContext(), R.color.winner_green));
        } else {
            lifeHistoryViewHolder.getOffsetTextView().setText(String.valueOf(iIntValue));
            lifeHistoryViewHolder.getOffsetTextView().setTextColor(ContextCompat.getColor(lifeHistoryViewHolder.getRootLayout().getContext(), R.color.loser_red));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LifeHistoryViewHolder lifeHistoryViewHolder;
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 1) {
            throw new IllegalArgumentException("Invalid view type");
        }
        int i = this.rotation;
        if (i == 90 || i == 270) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.life_event_item_rotated, parent, false);
            Intrinsics.checkNotNull(viewInflate);
            lifeHistoryViewHolder = new LifeHistoryViewHolder(viewInflate);
        } else {
            View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.life_event_item, parent, false);
            Intrinsics.checkNotNull(viewInflate2);
            lifeHistoryViewHolder = new LifeHistoryViewHolder(viewInflate2);
        }
        return lifeHistoryViewHolder;
    }
}
