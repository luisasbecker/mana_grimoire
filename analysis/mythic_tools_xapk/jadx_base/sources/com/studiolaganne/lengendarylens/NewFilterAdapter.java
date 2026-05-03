package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.studiolaganne.lengendarylens.SearchKeyword;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NewFilterDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u001f\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/studiolaganne/lengendarylens/NewFilterAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/studiolaganne/lengendarylens/NewFilterAdapter$FilterViewHolder;", "filters", "", "Lcom/studiolaganne/lengendarylens/SearchKeyword;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/studiolaganne/lengendarylens/NewFilterDialogListener;", "<init>", "(Ljava/util/List;Lcom/studiolaganne/lengendarylens/NewFilterDialogListener;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "FilterViewHolder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NewFilterAdapter extends RecyclerView.Adapter<FilterViewHolder> {
    public static final int $stable = 8;
    private final List<SearchKeyword> filters;
    private final NewFilterDialogListener listener;

    /* JADX INFO: compiled from: NewFilterDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/studiolaganne/lengendarylens/NewFilterAdapter$FilterViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "getView", "()Landroid/view/View;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class FilterViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private final View view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FilterViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.view = view;
        }

        public final View getView() {
            return this.view;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NewFilterAdapter(List<? extends SearchKeyword> filters, NewFilterDialogListener newFilterDialogListener) {
        Intrinsics.checkNotNullParameter(filters, "filters");
        this.filters = filters;
        this.listener = newFilterDialogListener;
    }

    static final Unit onBindViewHolder$lambda$0(NewFilterAdapter newFilterAdapter, int i) {
        NewFilterDialogListener newFilterDialogListener = newFilterAdapter.listener;
        if (newFilterDialogListener != null) {
            newFilterDialogListener.onFilterSelected(newFilterAdapter.filters.get(i));
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.filters.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(FilterViewHolder holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        TextView textView = (TextView) holder.getView().findViewById(R.id.filterNameTextView);
        SearchKeyword.Companion companion = SearchKeyword.INSTANCE;
        SearchKeyword searchKeyword = this.filters.get(position);
        Context context = holder.getView().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        textView.setText(companion.keywordDisplayName(searchKeyword, context));
        ViewExtensionsKt.setOnClickWithFade(holder.getView(), new Function0() { // from class: com.studiolaganne.lengendarylens.NewFilterAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NewFilterAdapter.onBindViewHolder$lambda$0(this.f$0, position);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public FilterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.filter_type_item, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new FilterViewHolder(viewInflate);
    }
}
