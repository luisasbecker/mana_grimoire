package com.studiolaganne.lengendarylens;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FilterListAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0016J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/studiolaganne/lengendarylens/FilterListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "lang", "", "elements", "Lcom/studiolaganne/lengendarylens/SearchGroup;", "handler", "Lcom/studiolaganne/lengendarylens/OnFilterClickListener;", "<init>", "(Ljava/lang/String;Lcom/studiolaganne/lengendarylens/SearchGroup;Lcom/studiolaganne/lengendarylens/OnFilterClickListener;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "getItemViewType", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FilterListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int TYPE_FILTER = 1;
    private final SearchGroup elements;
    private final OnFilterClickListener handler;
    private final String lang;
    public static final int $stable = 8;

    public FilterListAdapter(String lang, SearchGroup elements, OnFilterClickListener handler) {
        Intrinsics.checkNotNullParameter(lang, "lang");
        Intrinsics.checkNotNullParameter(elements, "elements");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.lang = lang;
        this.elements = elements;
        this.handler = handler;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.elements.getElements().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof FilterViewHolder) {
            ((FilterViewHolder) holder).bind(this.elements.getElements().get(position));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutInflater.from(parent.getContext());
        if (viewType != 1) {
            throw new IllegalArgumentException("Invalid view type");
        }
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.filter_view, parent, false);
        String str = this.lang;
        OnFilterClickListener onFilterClickListener = this.handler;
        Intrinsics.checkNotNull(viewInflate);
        return new FilterViewHolder(str, onFilterClickListener, viewInflate);
    }
}
