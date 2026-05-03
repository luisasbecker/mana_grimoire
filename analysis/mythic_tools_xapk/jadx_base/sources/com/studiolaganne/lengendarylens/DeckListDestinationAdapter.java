package com.studiolaganne.lengendarylens;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DeckMoveCardDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0018\u0019B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\u0014\u0010\u0015\u001a\u00020\u00112\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckListDestinationAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/studiolaganne/lengendarylens/DeckListDestinationAdapter$DeckListDestinationViewHolder;", "deckLists", "", "Lcom/studiolaganne/lengendarylens/DeckListItem;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/studiolaganne/lengendarylens/DeckListDestinationAdapter$DeckListSelectionListener;", "<init>", "(Ljava/util/List;Lcom/studiolaganne/lengendarylens/DeckListDestinationAdapter$DeckListSelectionListener;)V", "selectedPosition", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "getItemCount", "updateData", "newDeckLists", "", "DeckListSelectionListener", "DeckListDestinationViewHolder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeckListDestinationAdapter extends RecyclerView.Adapter<DeckListDestinationViewHolder> {
    public static final int $stable = 8;
    private List<DeckListItem> deckLists;
    private final DeckListSelectionListener listener;
    private int selectedPosition;

    /* JADX INFO: compiled from: DeckMoveCardDialogFragment.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckListDestinationAdapter$DeckListDestinationViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "radioButton", "Landroid/widget/RadioButton;", "getRadioButton", "()Landroid/widget/RadioButton;", "rootLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getRootLayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "nameTextView", "Landroid/widget/TextView;", "countTextView", "iconImageView", "Landroid/widget/ImageView;", "bind", "", "deckList", "Lcom/studiolaganne/lengendarylens/DeckListItem;", "isSelected", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class DeckListDestinationViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private final TextView countTextView;
        private final ImageView iconImageView;
        private final TextView nameTextView;
        private final RadioButton radioButton;
        private final ConstraintLayout rootLayout;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DeckListDestinationViewHolder(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View viewFindViewById = itemView.findViewById(R.id.deckListRadioButton);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.radioButton = (RadioButton) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R.id.rootLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.rootLayout = (ConstraintLayout) viewFindViewById2;
            View viewFindViewById3 = itemView.findViewById(R.id.deckListName);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            this.nameTextView = (TextView) viewFindViewById3;
            View viewFindViewById4 = itemView.findViewById(R.id.deckListCount);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
            this.countTextView = (TextView) viewFindViewById4;
            View viewFindViewById5 = itemView.findViewById(R.id.deckListIcon);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
            this.iconImageView = (ImageView) viewFindViewById5;
        }

        public final void bind(DeckListItem deckList, boolean isSelected) {
            String strReplace$default;
            Intrinsics.checkNotNullParameter(deckList, "deckList");
            this.nameTextView.setText(deckList.getName());
            TextView textView = this.countTextView;
            if (deckList.getCardCount() == 1) {
                strReplace$default = this.itemView.getContext().getString(R.string.one_card_count);
            } else if (deckList.getCardCount() == 0) {
                strReplace$default = this.itemView.getContext().getString(R.string.no_cards_list);
            } else {
                String string = this.itemView.getContext().getString(R.string.cards_count);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                strReplace$default = StringsKt.replace$default(string, "{1}", String.valueOf(deckList.getCardCount()), false, 4, (Object) null);
            }
            textView.setText(strReplace$default);
            this.iconImageView.setImageResource(deckList.getIcon());
            this.radioButton.setChecked(isSelected);
        }

        public final RadioButton getRadioButton() {
            return this.radioButton;
        }

        public final ConstraintLayout getRootLayout() {
            return this.rootLayout;
        }
    }

    /* JADX INFO: compiled from: DeckMoveCardDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckListDestinationAdapter$DeckListSelectionListener;", "", "onDeckListSelected", "", "listId", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface DeckListSelectionListener {
        void onDeckListSelected(int listId);
    }

    public DeckListDestinationAdapter(List<DeckListItem> deckLists, DeckListSelectionListener listener) {
        Intrinsics.checkNotNullParameter(deckLists, "deckLists");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.deckLists = deckLists;
        this.listener = listener;
        this.selectedPosition = -1;
    }

    static final void onBindViewHolder$lambda$0(DeckListDestinationAdapter deckListDestinationAdapter, DeckListDestinationViewHolder deckListDestinationViewHolder, DeckListItem deckListItem, View view) {
        int i = deckListDestinationAdapter.selectedPosition;
        deckListDestinationAdapter.selectedPosition = deckListDestinationViewHolder.getBindingAdapterPosition();
        deckListDestinationAdapter.notifyItemChanged(i);
        deckListDestinationAdapter.notifyItemChanged(deckListDestinationAdapter.selectedPosition);
        deckListDestinationAdapter.listener.onDeckListSelected(deckListItem.getId());
    }

    static final Unit onBindViewHolder$lambda$1(DeckListDestinationAdapter deckListDestinationAdapter, DeckListDestinationViewHolder deckListDestinationViewHolder, DeckListItem deckListItem) {
        int i = deckListDestinationAdapter.selectedPosition;
        deckListDestinationAdapter.selectedPosition = deckListDestinationViewHolder.getBindingAdapterPosition();
        deckListDestinationAdapter.notifyItemChanged(i);
        deckListDestinationAdapter.notifyItemChanged(deckListDestinationAdapter.selectedPosition);
        deckListDestinationAdapter.listener.onDeckListSelected(deckListItem.getId());
        return Unit.INSTANCE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.deckLists.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final DeckListDestinationViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final DeckListItem deckListItem = this.deckLists.get(position);
        holder.bind(deckListItem, position == this.selectedPosition);
        holder.getRadioButton().setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.DeckListDestinationAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeckListDestinationAdapter.onBindViewHolder$lambda$0(this.f$0, holder, deckListItem, view);
            }
        });
        ViewExtensionsKt.setOnClickWithFade(holder.getRootLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.DeckListDestinationAdapter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckListDestinationAdapter.onBindViewHolder$lambda$1(this.f$0, holder, deckListItem);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DeckListDestinationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.deck_list_destination_item, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new DeckListDestinationViewHolder(viewInflate);
    }

    public final void updateData(List<DeckListItem> newDeckLists) {
        Intrinsics.checkNotNullParameter(newDeckLists, "newDeckLists");
        this.deckLists.clear();
        this.deckLists.addAll(newDeckLists);
        this.selectedPosition = -1;
        notifyDataSetChanged();
    }
}
