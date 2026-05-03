package com.studiolaganne.lengendarylens;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MoveCardDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0018\u0019B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\u0014\u0010\u0015\u001a\u00020\u00112\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/studiolaganne/lengendarylens/DeckAdapter$DeckViewHolder;", "decks", "", "Lcom/studiolaganne/lengendarylens/DeckItem;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/studiolaganne/lengendarylens/DeckAdapter$DeckSelectionListener;", "<init>", "(Ljava/util/List;Lcom/studiolaganne/lengendarylens/DeckAdapter$DeckSelectionListener;)V", "selectedPosition", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "getItemCount", "updateData", "newDecks", "", "DeckSelectionListener", "DeckViewHolder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeckAdapter extends RecyclerView.Adapter<DeckViewHolder> {
    public static final int $stable = 8;
    private List<DeckItem> decks;
    private final DeckSelectionListener listener;
    private int selectedPosition;

    /* JADX INFO: compiled from: MoveCardDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckAdapter$DeckSelectionListener;", "", "onDeckSelected", "", "deck", "Lcom/studiolaganne/lengendarylens/MTDeck;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface DeckSelectionListener {
        void onDeckSelected(MTDeck deck);
    }

    /* JADX INFO: compiled from: MoveCardDialogFragment.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/studiolaganne/lengendarylens/DeckAdapter$DeckViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "radioButton", "Landroid/widget/RadioButton;", "getRadioButton", "()Landroid/widget/RadioButton;", "deckNameTextView", "Landroid/widget/TextView;", "bind", "", "deckItem", "Lcom/studiolaganne/lengendarylens/DeckItem;", "isSelected", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class DeckViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private final TextView deckNameTextView;
        private final RadioButton radioButton;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DeckViewHolder(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View viewFindViewById = itemView.findViewById(R.id.deckRadioButton);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.radioButton = (RadioButton) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R.id.deckNameTextView);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.deckNameTextView = (TextView) viewFindViewById2;
        }

        public final void bind(DeckItem deckItem, boolean isSelected) {
            Intrinsics.checkNotNullParameter(deckItem, "deckItem");
            this.deckNameTextView.setText(deckItem.getName());
            this.radioButton.setChecked(isSelected);
        }

        public final RadioButton getRadioButton() {
            return this.radioButton;
        }
    }

    public DeckAdapter(List<DeckItem> decks, DeckSelectionListener listener) {
        Intrinsics.checkNotNullParameter(decks, "decks");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.decks = decks;
        this.listener = listener;
        this.selectedPosition = -1;
    }

    static final void onBindViewHolder$lambda$0(DeckAdapter deckAdapter, DeckViewHolder deckViewHolder, DeckItem deckItem, View view) {
        int i = deckAdapter.selectedPosition;
        deckAdapter.selectedPosition = deckViewHolder.getBindingAdapterPosition();
        deckAdapter.notifyItemChanged(i);
        deckAdapter.notifyItemChanged(deckAdapter.selectedPosition);
        deckAdapter.listener.onDeckSelected(deckItem.getDeck());
    }

    static final Unit onBindViewHolder$lambda$1(DeckAdapter deckAdapter, DeckViewHolder deckViewHolder, DeckItem deckItem) {
        int i = deckAdapter.selectedPosition;
        deckAdapter.selectedPosition = deckViewHolder.getBindingAdapterPosition();
        deckAdapter.notifyItemChanged(i);
        deckAdapter.notifyItemChanged(deckAdapter.selectedPosition);
        deckAdapter.listener.onDeckSelected(deckItem.getDeck());
        return Unit.INSTANCE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.decks.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final DeckViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final DeckItem deckItem = this.decks.get(position);
        holder.bind(deckItem, position == this.selectedPosition);
        holder.getRadioButton().setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.DeckAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeckAdapter.onBindViewHolder$lambda$0(this.f$0, holder, deckItem, view);
            }
        });
        View itemView = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        ViewExtensionsKt.setOnClickWithFade(itemView, new Function0() { // from class: com.studiolaganne.lengendarylens.DeckAdapter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeckAdapter.onBindViewHolder$lambda$1(this.f$0, holder, deckItem);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DeckViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.deck_selection_item, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new DeckViewHolder(viewInflate);
    }

    public final void updateData(List<DeckItem> newDecks) {
        Intrinsics.checkNotNullParameter(newDecks, "newDecks");
        this.decks.clear();
        this.decks.addAll(newDecks);
        this.selectedPosition = -1;
        notifyDataSetChanged();
    }
}
