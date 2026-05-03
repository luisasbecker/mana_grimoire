package com.studiolaganne.lengendarylens;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTEvaluationCardsAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\"#B%\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0011H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0016J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\u0014\u0010\u001c\u001a\u00020\u00182\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0014\u0010\u001e\u001a\u00020\u00182\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u000e\u0010 \u001a\u00020!2\u0006\u0010\u0012\u001a\u00020\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTEvaluationCardsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "initialItems", "", "Lcom/studiolaganne/lengendarylens/MTEvaluationCardsAdapter$Item;", "clickListener", "Lcom/studiolaganne/lengendarylens/OnEvaluationCardClickListener;", "actionListener", "Lcom/studiolaganne/lengendarylens/OnEvaluationCardActionListener;", "<init>", "(Ljava/util/List;Lcom/studiolaganne/lengendarylens/OnEvaluationCardClickListener;Lcom/studiolaganne/lengendarylens/OnEvaluationCardActionListener;)V", FirebaseAnalytics.Param.ITEMS, "actedCardIds", "", "", "getItemViewType", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "getItemCount", "onViewRecycled", "updateItems", "newItems", "setActedCardIds", "ids", "isHeaderAt", "", "Item", "ItemType", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MTEvaluationCardsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int $stable = 8;
    private Set<String> actedCardIds;
    private final OnEvaluationCardActionListener actionListener;
    private final OnEvaluationCardClickListener clickListener;
    private List<? extends Item> items;

    /* JADX INFO: compiled from: MTEvaluationCardsAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTEvaluationCardsAdapter$Item;", "", "<init>", "()V", "viewType", "", "getViewType", "()I", "Card", "SectionHeader", "Lcom/studiolaganne/lengendarylens/MTEvaluationCardsAdapter$Item$Card;", "Lcom/studiolaganne/lengendarylens/MTEvaluationCardsAdapter$Item$SectionHeader;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Item {
        public static final int $stable = 0;

        /* JADX INFO: compiled from: MTEvaluationCardsAdapter.kt */
        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\rHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTEvaluationCardsAdapter$Item$Card;", "Lcom/studiolaganne/lengendarylens/MTEvaluationCardsAdapter$Item;", "card", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "category", "Lcom/studiolaganne/lengendarylens/MTCardRankingCategory;", "<init>", "(Lcom/studiolaganne/lengendarylens/MTFullCard;Lcom/studiolaganne/lengendarylens/MTCardRankingCategory;)V", "getCard", "()Lcom/studiolaganne/lengendarylens/MTFullCard;", "getCategory", "()Lcom/studiolaganne/lengendarylens/MTCardRankingCategory;", "viewType", "", "getViewType", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Card extends Item {
            public static final int $stable = MTFullCard.$stable;
            private final MTFullCard card;
            private final MTCardRankingCategory category;
            private final int viewType;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Card(MTFullCard card, MTCardRankingCategory category) {
                super(null);
                Intrinsics.checkNotNullParameter(card, "card");
                Intrinsics.checkNotNullParameter(category, "category");
                this.card = card;
                this.category = category;
            }

            public static /* synthetic */ Card copy$default(Card card, MTFullCard mTFullCard, MTCardRankingCategory mTCardRankingCategory, int i, Object obj) {
                if ((i & 1) != 0) {
                    mTFullCard = card.card;
                }
                if ((i & 2) != 0) {
                    mTCardRankingCategory = card.category;
                }
                return card.copy(mTFullCard, mTCardRankingCategory);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final MTFullCard getCard() {
                return this.card;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final MTCardRankingCategory getCategory() {
                return this.category;
            }

            public final Card copy(MTFullCard card, MTCardRankingCategory category) {
                Intrinsics.checkNotNullParameter(card, "card");
                Intrinsics.checkNotNullParameter(category, "category");
                return new Card(card, category);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Card)) {
                    return false;
                }
                Card card = (Card) other;
                return Intrinsics.areEqual(this.card, card.card) && this.category == card.category;
            }

            public final MTFullCard getCard() {
                return this.card;
            }

            public final MTCardRankingCategory getCategory() {
                return this.category;
            }

            @Override // com.studiolaganne.lengendarylens.MTEvaluationCardsAdapter.Item
            public int getViewType() {
                return this.viewType;
            }

            public int hashCode() {
                return (this.card.hashCode() * 31) + this.category.hashCode();
            }

            public String toString() {
                return "Card(card=" + this.card + ", category=" + this.category + ")";
            }
        }

        /* JADX INFO: compiled from: MTEvaluationCardsAdapter.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTEvaluationCardsAdapter$Item$SectionHeader;", "Lcom/studiolaganne/lengendarylens/MTEvaluationCardsAdapter$Item;", "category", "Lcom/studiolaganne/lengendarylens/MTCardRankingCategory;", "count", "", "<init>", "(Lcom/studiolaganne/lengendarylens/MTCardRankingCategory;I)V", "getCategory", "()Lcom/studiolaganne/lengendarylens/MTCardRankingCategory;", "getCount", "()I", "viewType", "getViewType", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SectionHeader extends Item {
            public static final int $stable = 0;
            private final MTCardRankingCategory category;
            private final int count;
            private final int viewType;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SectionHeader(MTCardRankingCategory category, int i) {
                super(null);
                Intrinsics.checkNotNullParameter(category, "category");
                this.category = category;
                this.count = i;
                this.viewType = 1;
            }

            public static /* synthetic */ SectionHeader copy$default(SectionHeader sectionHeader, MTCardRankingCategory mTCardRankingCategory, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    mTCardRankingCategory = sectionHeader.category;
                }
                if ((i2 & 2) != 0) {
                    i = sectionHeader.count;
                }
                return sectionHeader.copy(mTCardRankingCategory, i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final MTCardRankingCategory getCategory() {
                return this.category;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final int getCount() {
                return this.count;
            }

            public final SectionHeader copy(MTCardRankingCategory category, int count) {
                Intrinsics.checkNotNullParameter(category, "category");
                return new SectionHeader(category, count);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SectionHeader)) {
                    return false;
                }
                SectionHeader sectionHeader = (SectionHeader) other;
                return this.category == sectionHeader.category && this.count == sectionHeader.count;
            }

            public final MTCardRankingCategory getCategory() {
                return this.category;
            }

            public final int getCount() {
                return this.count;
            }

            @Override // com.studiolaganne.lengendarylens.MTEvaluationCardsAdapter.Item
            public int getViewType() {
                return this.viewType;
            }

            public int hashCode() {
                return (this.category.hashCode() * 31) + Integer.hashCode(this.count);
            }

            public String toString() {
                return "SectionHeader(category=" + this.category + ", count=" + this.count + ")";
            }
        }

        private Item() {
        }

        public /* synthetic */ Item(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract int getViewType();
    }

    /* JADX INFO: compiled from: MTEvaluationCardsAdapter.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTEvaluationCardsAdapter$ItemType;", "", "<init>", "()V", "CARD", "", "SECTION_HEADER", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ItemType {
        public static final int $stable = 0;
        public static final int CARD = 0;
        public static final ItemType INSTANCE = new ItemType();
        public static final int SECTION_HEADER = 1;

        private ItemType() {
        }
    }

    public MTEvaluationCardsAdapter(List<? extends Item> initialItems, OnEvaluationCardClickListener clickListener, OnEvaluationCardActionListener actionListener) {
        Intrinsics.checkNotNullParameter(initialItems, "initialItems");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        Intrinsics.checkNotNullParameter(actionListener, "actionListener");
        this.clickListener = clickListener;
        this.actionListener = actionListener;
        this.items = initialItems;
        this.actedCardIds = SetsKt.emptySet();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.items.get(position).getViewType();
    }

    public final boolean isHeaderAt(int position) {
        return position >= 0 && position < this.items.size() && (this.items.get(position) instanceof Item.SectionHeader);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Item item = this.items.get(position);
        if (item instanceof Item.Card) {
            Item.Card card = (Item.Card) item;
            MTFullCard card2 = card.getCard();
            ((MTEvaluationCardViewHolder) holder).bind(card2, position, card2.getOracleid() != null && CollectionsKt.contains(this.actedCardIds, card2.getOracleid()), card.getCategory());
        } else {
            if (!(item instanceof Item.SectionHeader)) {
                throw new NoWhenBranchMatchedException();
            }
            Item.SectionHeader sectionHeader = (Item.SectionHeader) item;
            ((SectionHeaderViewHolder) holder).bind(sectionHeader.getCategory(), sectionHeader.getCount());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        if (viewType == 1) {
            View viewInflate = layoutInflaterFrom.inflate(R.layout.mt_evaluation_section_header, parent, false);
            Intrinsics.checkNotNull(viewInflate);
            return new SectionHeaderViewHolder(viewInflate);
        }
        View viewInflate2 = layoutInflaterFrom.inflate(R.layout.mt_evaluation_card_view, parent, false);
        Intrinsics.checkNotNull(viewInflate2);
        return new MTEvaluationCardViewHolder(viewInflate2, this.clickListener, this.actionListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewRecycled(holder);
        MTEvaluationCardViewHolder mTEvaluationCardViewHolder = holder instanceof MTEvaluationCardViewHolder ? (MTEvaluationCardViewHolder) holder : null;
        if (mTEvaluationCardViewHolder != null) {
            mTEvaluationCardViewHolder.onRecycled();
        }
    }

    public final void setActedCardIds(Set<String> ids) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        this.actedCardIds = ids;
        notifyDataSetChanged();
    }

    public final void updateItems(List<? extends Item> newItems) {
        Intrinsics.checkNotNullParameter(newItems, "newItems");
        this.items = newItems;
        notifyDataSetChanged();
    }
}
