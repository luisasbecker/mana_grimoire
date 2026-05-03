package com.studiolaganne.lengendarylens;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ManaProductionAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\tH\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/studiolaganne/lengendarylens/ManaProductionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/studiolaganne/lengendarylens/ManaProductionAdapter$ViewHolder;", "entries", "", "Lcom/studiolaganne/lengendarylens/MTManaCostProductionEntry;", "<init>", "(Ljava/util/List;)V", "maxCost", "", "maxProduction", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "getItemCount", "ViewHolder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ManaProductionAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final int $stable = 8;
    private final List<MTManaCostProductionEntry> entries;
    private final int maxCost;
    private final int maxProduction;

    /* JADX INFO: compiled from: ManaProductionAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/studiolaganne/lengendarylens/ManaProductionAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "getView", "()Landroid/view/View;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private final View view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.view = view;
        }

        public final View getView() {
            return this.view;
        }
    }

    public ManaProductionAdapter(List<MTManaCostProductionEntry> entries) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        this.entries = entries;
        Iterator<T> it = entries.iterator();
        int symbols = 0;
        while (it.hasNext()) {
            MTProductionEntry costs = ((MTManaCostProductionEntry) it.next()).getCosts();
            symbols += costs != null ? costs.getSymbols() : 0;
        }
        this.maxCost = symbols;
        Iterator<T> it2 = this.entries.iterator();
        int symbols2 = 0;
        while (it2.hasNext()) {
            MTProductionEntry production = ((MTManaCostProductionEntry) it2.next()).getProduction();
            symbols2 += production != null ? production.getSymbols() : 0;
        }
        this.maxProduction = symbols2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.entries.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ManaCostProductionViewHelper.INSTANCE.bindDataToView(holder.getView(), this.entries.get(position), this.maxCost, this.maxProduction);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_mana_cost_production, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new ViewHolder(viewInflate);
    }
}
