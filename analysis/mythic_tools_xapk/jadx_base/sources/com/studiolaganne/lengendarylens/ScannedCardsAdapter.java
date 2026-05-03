package com.studiolaganne.lengendarylens;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScannedCardsAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\n\b\u0007\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002!\"B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0014\u0010\u0017\u001a\u00020\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u0019J\u000e\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\tJ\u000e\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000eJ\u0016\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\tJ\u0006\u0010\u001f\u001a\u00020\u0010J\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\u0019R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/studiolaganne/lengendarylens/ScannedCardsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "clickHandler", "Lcom/studiolaganne/lengendarylens/OnScannedCardClickListener;", "<init>", "(Lcom/studiolaganne/lengendarylens/OnScannedCardClickListener;)V", "cards", "", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "onViewRecycled", "onViewDetachedFromWindow", "getItemCount", "getItemViewType", "updateCards", "newCards", "", "addCard", "card", "removeCard", "updateCard", "updatedCard", "clearCards", "getCurrentCards", "Companion", "CardDiffCallback", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ScannedCardsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int TYPE_CARD = 1;
    private List<MTFullCard> cards;
    private final OnScannedCardClickListener clickHandler;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: ScannedCardsAdapter.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/studiolaganne/lengendarylens/ScannedCardsAdapter$CardDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "newList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class CardDiffCallback extends DiffUtil.Callback {
        private final List<MTFullCard> newList;
        private final List<MTFullCard> oldList;

        public CardDiffCallback(List<MTFullCard> oldList, List<MTFullCard> newList) {
            Intrinsics.checkNotNullParameter(oldList, "oldList");
            Intrinsics.checkNotNullParameter(newList, "newList");
            this.oldList = oldList;
            this.newList = newList;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            MTFullCard mTFullCard = this.oldList.get(oldItemPosition);
            MTFullCard mTFullCard2 = this.newList.get(newItemPosition);
            return Intrinsics.areEqual(mTFullCard.getQuantity(), mTFullCard2.getQuantity()) && Intrinsics.areEqual(mTFullCard.getCondition(), mTFullCard2.getCondition()) && Intrinsics.areEqual(mTFullCard.getFinish(), mTFullCard2.getFinish()) && Intrinsics.areEqual(mTFullCard.getLang(), mTFullCard2.getLang()) && Intrinsics.areEqual(mTFullCard.getAltered(), mTFullCard2.getAltered()) && Intrinsics.areEqual(mTFullCard.getSigned(), mTFullCard2.getSigned()) && Intrinsics.areEqual(mTFullCard.getMissprint(), mTFullCard2.getMissprint()) && Intrinsics.areEqual(mTFullCard.getCurrent_value_usd(), mTFullCard2.getCurrent_value_usd()) && Intrinsics.areEqual(mTFullCard.getCurrent_value_eur(), mTFullCard2.getCurrent_value_eur()) && Intrinsics.areEqual(mTFullCard.getValues(), mTFullCard2.getValues()) && Intrinsics.areEqual(mTFullCard.getCollection(), mTFullCard2.getCollection());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            return Intrinsics.areEqual(this.oldList.get(oldItemPosition).getCardid(), this.newList.get(newItemPosition).getCardid());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            return this.newList.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            return this.oldList.size();
        }
    }

    public ScannedCardsAdapter(OnScannedCardClickListener clickHandler) {
        Intrinsics.checkNotNullParameter(clickHandler, "clickHandler");
        this.clickHandler = clickHandler;
        this.cards = new ArrayList();
    }

    public final void addCard(MTFullCard card) {
        Intrinsics.checkNotNullParameter(card, "card");
        int size = this.cards.size() - 1;
        this.cards.add(card);
        int size2 = this.cards.size() - 1;
        if (size >= 0) {
            notifyItemChanged(size);
        }
        notifyItemInserted(size2);
    }

    public final void clearCards() {
        int size = this.cards.size();
        this.cards.clear();
        notifyItemRangeRemoved(0, size);
    }

    public final List<MTFullCard> getCurrentCards() {
        return CollectionsKt.toList(this.cards);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.cards.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof ScannedCardViewHolder) {
            ((ScannedCardViewHolder) holder).bind(this.cards.get(position), position, position == this.cards.size() - 1);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 1) {
            throw new IllegalArgumentException("Invalid view type");
        }
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.scanned_card_view, parent, false);
        View viewFindViewById = viewInflate.findViewById(R.id.cardImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        LoadingImageView loadingImageView = (LoadingImageView) viewFindViewById;
        loadingImageView.setAutoLoad(false);
        loadingImageView.setSkipMemoryCache(true);
        loadingImageView.reset();
        OnScannedCardClickListener onScannedCardClickListener = this.clickHandler;
        Intrinsics.checkNotNull(viewInflate);
        return new ScannedCardViewHolder(onScannedCardClickListener, viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewDetachedFromWindow(holder);
        if (holder instanceof ScannedCardViewHolder) {
            ((ScannedCardViewHolder) holder).cleanup();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewRecycled(holder);
        if (holder instanceof ScannedCardViewHolder) {
            ((ScannedCardViewHolder) holder).cleanup();
        }
    }

    public final void removeCard(int position) {
        if (position < 0 || position >= this.cards.size()) {
            return;
        }
        boolean z = position == this.cards.size() - 1;
        this.cards.remove(position);
        notifyItemRemoved(position);
        if (!z || this.cards.isEmpty()) {
            return;
        }
        notifyItemChanged(this.cards.size() - 1);
    }

    public final void updateCard(int position, MTFullCard updatedCard) {
        Intrinsics.checkNotNullParameter(updatedCard, "updatedCard");
        if (position < 0 || position >= this.cards.size()) {
            return;
        }
        this.cards.set(position, updatedCard);
        notifyItemChanged(position);
    }

    public final void updateCards(List<MTFullCard> newCards) {
        Intrinsics.checkNotNullParameter(newCards, "newCards");
        DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new CardDiffCallback(CollectionsKt.toList(this.cards), newCards));
        Intrinsics.checkNotNullExpressionValue(diffResultCalculateDiff, "calculateDiff(...)");
        this.cards.clear();
        this.cards.addAll(newCards);
        diffResultCalculateDiff.dispatchUpdatesTo(this);
    }
}
