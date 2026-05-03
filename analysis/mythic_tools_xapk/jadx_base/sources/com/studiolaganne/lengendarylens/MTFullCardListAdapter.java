package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.studiolaganne.lengendarylens.BrowseListCardItem;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTFullCardListAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002*+BS\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0007H\u0016J\u0018\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0007H\u0016J\b\u0010!\u001a\u00020\u0007H\u0016J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0016J\u0014\u0010#\u001a\u00020\u00182\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0014\u0010%\u001a\u00020\u00182\f\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u0004J\u0010\u0010(\u001a\u0004\u0018\u00010\u00052\u0006\u0010 \u001a\u00020\u0007J\u0010\u0010)\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTFullCardListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", FirebaseAnalytics.Param.ITEMS, "", "Lcom/studiolaganne/lengendarylens/BrowseListCardItem;", "listId", "", "clickHandler", "Lcom/studiolaganne/lengendarylens/OnMTFullCardClickListener;", "longPressHandler", "Lcom/studiolaganne/lengendarylens/OnCardLongPressListener;", "selectionHandler", "Lcom/studiolaganne/lengendarylens/OnCardSelectionListener;", "addToDeckHandler", "Lcom/studiolaganne/lengendarylens/OnCardAddToDeckListener;", "addedCardIds", "", "", "<init>", "(Ljava/util/List;ILcom/studiolaganne/lengendarylens/OnMTFullCardClickListener;Lcom/studiolaganne/lengendarylens/OnCardLongPressListener;Lcom/studiolaganne/lengendarylens/OnCardSelectionListener;Lcom/studiolaganne/lengendarylens/OnCardAddToDeckListener;Ljava/util/Set;)V", "selectionMode", "", "setSelectionMode", "", "enabled", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "getItemViewType", "updateItems", "newItems", "updateCards", "newCards", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "getItemAt", "onViewRecycled", "Companion", "SectionHeaderViewHolder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MTFullCardListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int VIEW_TYPE_CARD = 2;
    public static final int VIEW_TYPE_SECTION_HEADER = 1;
    private final OnCardAddToDeckListener addToDeckHandler;
    private final Set<String> addedCardIds;
    private final OnMTFullCardClickListener clickHandler;
    private List<? extends BrowseListCardItem> items;
    private final int listId;
    private final OnCardLongPressListener longPressHandler;
    private final OnCardSelectionListener selectionHandler;
    private boolean selectionMode;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: MTFullCardListAdapter.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTFullCardListAdapter$SectionHeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "typeIcon", "Landroid/widget/ImageView;", "typeName", "Landroid/widget/TextView;", "cardCount", "bind", "", "header", "Lcom/studiolaganne/lengendarylens/BrowseListCardItem$SectionHeader;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class SectionHeaderViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private final TextView cardCount;
        private final ImageView typeIcon;
        private final TextView typeName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SectionHeaderViewHolder(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View viewFindViewById = itemView.findViewById(R.id.typeIcon);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.typeIcon = (ImageView) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R.id.typeName);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.typeName = (TextView) viewFindViewById2;
            View viewFindViewById3 = itemView.findViewById(R.id.cardCount);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            this.cardCount = (TextView) viewFindViewById3;
        }

        public final void bind(BrowseListCardItem.SectionHeader header) {
            Intrinsics.checkNotNullParameter(header, "header");
            TextView textView = this.typeName;
            Context context = this.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            textView.setText(DeckCardItemKt.getCardTypeNameString(context, header.getType()));
            this.cardCount.setText(String.valueOf(header.getCount()));
            int cardTypeIconResource = DeckCardItemKt.getCardTypeIconResource(header.getType());
            boolean zShouldTintIconForCardType = DeckCardItemKt.shouldTintIconForCardType(header.getType());
            ImageView imageView = this.typeIcon;
            if (zShouldTintIconForCardType) {
                ImageViewCompat.setImageTintList(imageView, ColorStateList.valueOf(ContextCompat.getColor(this.itemView.getContext(), R.color.selected_color_new)));
            } else {
                ImageViewCompat.setImageTintList(imageView, null);
            }
            int i = R.drawable.type_unknown;
            ImageView imageView2 = this.typeIcon;
            if (cardTypeIconResource == i) {
                imageView2.setVisibility(8);
            } else {
                imageView2.setVisibility(0);
                this.typeIcon.setImageResource(cardTypeIconResource);
            }
        }
    }

    public MTFullCardListAdapter(List<? extends BrowseListCardItem> items, int i, OnMTFullCardClickListener clickHandler, OnCardLongPressListener longPressHandler, OnCardSelectionListener selectionHandler, OnCardAddToDeckListener onCardAddToDeckListener, Set<String> set) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(clickHandler, "clickHandler");
        Intrinsics.checkNotNullParameter(longPressHandler, "longPressHandler");
        Intrinsics.checkNotNullParameter(selectionHandler, "selectionHandler");
        this.items = items;
        this.listId = i;
        this.clickHandler = clickHandler;
        this.longPressHandler = longPressHandler;
        this.selectionHandler = selectionHandler;
        this.addToDeckHandler = onCardAddToDeckListener;
        this.addedCardIds = set;
    }

    public /* synthetic */ MTFullCardListAdapter(List list, int i, OnMTFullCardClickListener onMTFullCardClickListener, OnCardLongPressListener onCardLongPressListener, OnCardSelectionListener onCardSelectionListener, OnCardAddToDeckListener onCardAddToDeckListener, Set set, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, i, onMTFullCardClickListener, onCardLongPressListener, onCardSelectionListener, (i2 & 32) != 0 ? null : onCardAddToDeckListener, (i2 & 64) != 0 ? null : set);
    }

    public final BrowseListCardItem getItemAt(int position) {
        return (BrowseListCardItem) CollectionsKt.getOrNull(this.items, position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        BrowseListCardItem browseListCardItem = this.items.get(position);
        if (browseListCardItem instanceof BrowseListCardItem.SectionHeader) {
            return 1;
        }
        if (browseListCardItem instanceof BrowseListCardItem.Card) {
            return 2;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof SectionHeaderViewHolder) {
            BrowseListCardItem browseListCardItem = this.items.get(position);
            Intrinsics.checkNotNull(browseListCardItem, "null cannot be cast to non-null type com.studiolaganne.lengendarylens.BrowseListCardItem.SectionHeader");
            ((SectionHeaderViewHolder) holder).bind((BrowseListCardItem.SectionHeader) browseListCardItem);
            return;
        }
        if (holder instanceof MTFullCardListViewHolder) {
            BrowseListCardItem browseListCardItem2 = this.items.get(position);
            Intrinsics.checkNotNull(browseListCardItem2, "null cannot be cast to non-null type com.studiolaganne.lengendarylens.BrowseListCardItem.Card");
            BrowseListCardItem.Card card = (BrowseListCardItem.Card) browseListCardItem2;
            ((MTFullCardListViewHolder) holder).bind(this.listId, card.getCard(), card.getPosition(), this.selectionMode);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        if (viewType == 1) {
            View viewInflate = layoutInflaterFrom.inflate(R.layout.deck_card_section_header, parent, false);
            Intrinsics.checkNotNull(viewInflate);
            return new SectionHeaderViewHolder(viewInflate);
        }
        if (viewType != 2) {
            throw new IllegalArgumentException("Invalid view type: " + viewType);
        }
        View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.mt_full_card_list_view, parent, false);
        View viewFindViewById = viewInflate2.findViewById(R.id.cardImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        LoadingImageView loadingImageView = (LoadingImageView) viewFindViewById;
        View viewFindViewById2 = viewInflate2.findViewById(R.id.titleLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        ((TextView) viewFindViewById2).setVisibility(0);
        loadingImageView.setAutoLoad(false);
        loadingImageView.reset();
        OnMTFullCardClickListener onMTFullCardClickListener = this.clickHandler;
        OnCardLongPressListener onCardLongPressListener = this.longPressHandler;
        OnCardSelectionListener onCardSelectionListener = this.selectionHandler;
        Intrinsics.checkNotNull(viewInflate2);
        return new MTFullCardListViewHolder(onMTFullCardClickListener, onCardLongPressListener, onCardSelectionListener, viewInflate2, this.addToDeckHandler, this.addedCardIds);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewRecycled(holder);
        if (holder instanceof MTFullCardListViewHolder) {
            ((MTFullCardListViewHolder) holder).onRecycled();
        }
    }

    public final void setSelectionMode(boolean enabled) {
        if (this.selectionMode != enabled) {
            this.selectionMode = enabled;
            notifyDataSetChanged();
        }
    }

    public final void updateCards(List<MTFullCard> newCards) {
        Intrinsics.checkNotNullParameter(newCards, "newCards");
        this.items = BrowseListCardItemKt.toBrowseListCardItemsFromCards(newCards);
        notifyDataSetChanged();
    }

    public final void updateItems(List<? extends BrowseListCardItem> newItems) {
        Intrinsics.checkNotNullParameter(newItems, "newItems");
        this.items = newItems;
        notifyDataSetChanged();
    }
}
