package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.studiolaganne.lengendarylens.ConditionAdapter;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CardLanguageAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/studiolaganne/lengendarylens/ConditionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "cardConditions", "", "", "clickListener", "Lcom/studiolaganne/lengendarylens/ConditionClickListener;", "<init>", "(Ljava/util/List;Lcom/studiolaganne/lengendarylens/ConditionClickListener;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "ConditionViewHolder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ConditionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int $stable = 8;
    private final List<String> cardConditions;
    private final ConditionClickListener clickListener;

    /* JADX INFO: compiled from: CardLanguageAdapter.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/studiolaganne/lengendarylens/ConditionAdapter$ConditionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "clickListener", "Lcom/studiolaganne/lengendarylens/ConditionClickListener;", "<init>", "(Landroid/view/View;Lcom/studiolaganne/lengendarylens/ConditionClickListener;)V", "titleLabel", "Landroid/widget/TextView;", "condLabel", "bind", "", "rowData", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ConditionViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private final ConditionClickListener clickListener;
        private final TextView condLabel;
        private final TextView titleLabel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ConditionViewHolder(View view, ConditionClickListener clickListener) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(clickListener, "clickListener");
            this.clickListener = clickListener;
            View viewFindViewById = view.findViewById(R.id.title_textview);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.titleLabel = (TextView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.conditionTextView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.condLabel = (TextView) viewFindViewById2;
        }

        static final void bind$lambda$0(ConditionViewHolder conditionViewHolder, String str, View view) {
            ConditionClickListener conditionClickListener = conditionViewHolder.clickListener;
            String upperCase = str.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            conditionClickListener.onConditionClick(upperCase);
        }

        public final void bind(final String rowData) {
            Intrinsics.checkNotNullParameter(rowData, "rowData");
            TextView textView = this.titleLabel;
            GameUtils companion = GameUtils.INSTANCE.getInstance();
            Context context = this.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            String upperCase = rowData.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            textView.setText(companion.nameForCardCondition(context, upperCase));
            TextView textView2 = this.condLabel;
            GameUtils companion2 = GameUtils.INSTANCE.getInstance();
            Context context2 = this.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            String upperCase2 = rowData.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
            textView2.setTextColor(companion2.colorForCardCondition(context2, upperCase2));
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.ConditionAdapter$ConditionViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ConditionAdapter.ConditionViewHolder.bind$lambda$0(this.f$0, rowData, view);
                }
            });
        }
    }

    public ConditionAdapter(List<String> cardConditions, ConditionClickListener clickListener) {
        Intrinsics.checkNotNullParameter(cardConditions, "cardConditions");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.cardConditions = cardConditions;
        this.clickListener = clickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.cardConditions.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        String str = this.cardConditions.get(position);
        if (holder instanceof ConditionViewHolder) {
            ((ConditionViewHolder) holder).bind(str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.condition_menu_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        return new ConditionViewHolder(viewInflate, this.clickListener);
    }
}
