package com.studiolaganne.lengendarylens;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SimpleMTFullCardListAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B)\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\b\u0010\u0016\u001a\u00020\u0010H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/studiolaganne/lengendarylens/SimpleMTFullCardListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "cards", "", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "clickListener", "Lcom/studiolaganne/lengendarylens/SimpleMTFullCardClickListener;", "container", "Lcom/studiolaganne/lengendarylens/MTCardContainer;", "<init>", "(Ljava/util/List;Lcom/studiolaganne/lengendarylens/SimpleMTFullCardClickListener;Lcom/studiolaganne/lengendarylens/MTCardContainer;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemViewType", "getItemCount", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SimpleMTFullCardListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int VIEW_TYPE_CARD = 0;
    private final List<MTFullCard> cards;
    private final SimpleMTFullCardClickListener clickListener;
    private final MTCardContainer container;
    public static final int $stable = 8;

    public SimpleMTFullCardListAdapter(List<MTFullCard> cards, SimpleMTFullCardClickListener clickListener, MTCardContainer mTCardContainer) {
        Intrinsics.checkNotNullParameter(cards, "cards");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.cards = cards;
        this.clickListener = clickListener;
        this.container = mTCardContainer;
    }

    public /* synthetic */ SimpleMTFullCardListAdapter(List list, SimpleMTFullCardClickListener simpleMTFullCardClickListener, MTCardContainer mTCardContainer, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, simpleMTFullCardClickListener, (i & 4) != 0 ? null : mTCardContainer);
    }

    static final Unit onBindViewHolder$lambda$0(SimpleMTFullCardViewHolder simpleMTFullCardViewHolder, final SimpleMTFullCardListAdapter simpleMTFullCardListAdapter, final MTFullCard mTFullCard, final int i) {
        View view = simpleMTFullCardViewHolder.itemView;
        if (view != null) {
            view.postDelayed(new Runnable() { // from class: com.studiolaganne.lengendarylens.SimpleMTFullCardListAdapter$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    SimpleMTFullCardListAdapter.onBindViewHolder$lambda$0$0(this.f$0, mTFullCard, i);
                }
            }, 100L);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0$0(SimpleMTFullCardListAdapter simpleMTFullCardListAdapter, MTFullCard mTFullCard, int i) {
        simpleMTFullCardListAdapter.clickListener.onMTFullCardClick(mTFullCard, i, simpleMTFullCardListAdapter.container);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.cards.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        String lowerCase;
        String border_crop;
        MTImageURIs mTImageURIs;
        MTImageURIs mTImageURIs2;
        MTImageURIs mTImageURIs3;
        String gatherer;
        MTImageURIs mTImageURIs4;
        String border_crop2;
        int iIntValue;
        Intrinsics.checkNotNullParameter(holder, "holder");
        final MTFullCard mTFullCard = this.cards.get(position);
        final SimpleMTFullCardViewHolder simpleMTFullCardViewHolder = (SimpleMTFullCardViewHolder) holder;
        ViewExtensionsKt.setOnClickWithFade(simpleMTFullCardViewHolder.getRootLayout(), new Function0() { // from class: com.studiolaganne.lengendarylens.SimpleMTFullCardListAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SimpleMTFullCardListAdapter.onBindViewHolder$lambda$0(simpleMTFullCardViewHolder, this, mTFullCard, position);
            }
        });
        LoadingImageView cardImage = simpleMTFullCardViewHolder.getCardImage();
        String set_code = mTFullCard.getSet_code();
        String gatherer2 = null;
        if (set_code != null) {
            lowerCase = set_code.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        cardImage.setAlpha(Intrinsics.areEqual(lowerCase, "lea"));
        simpleMTFullCardViewHolder.getCardImage().reset();
        simpleMTFullCardViewHolder.getCardImage().setAutoLoad(false);
        simpleMTFullCardViewHolder.getCornerView().setVisibility(8);
        simpleMTFullCardViewHolder.getQtyTextView().setVisibility(8);
        Integer quantity = mTFullCard.getQuantity();
        if (quantity != null && (iIntValue = quantity.intValue()) > 1) {
            simpleMTFullCardViewHolder.getCornerView().setVisibility(0);
            simpleMTFullCardViewHolder.getQtyTextView().setVisibility(0);
            simpleMTFullCardViewHolder.getQtyTextView().setText(String.valueOf(iIntValue));
        }
        List<MTImageURIs> images = mTFullCard.getImages();
        if (images != null && (mTImageURIs4 = (MTImageURIs) CollectionsKt.firstOrNull((List) images)) != null && (border_crop2 = mTImageURIs4.getBorder_crop()) != null) {
            if (border_crop2.length() > 0) {
                simpleMTFullCardViewHolder.getCardImage().loadImage(border_crop2);
                return;
            }
            return;
        }
        List<MTImageURIs> images2 = mTFullCard.getImages();
        if (images2 != null && (mTImageURIs3 = (MTImageURIs) CollectionsKt.firstOrNull((List) images2)) != null && (gatherer = mTImageURIs3.getGatherer()) != null) {
            if (gatherer.length() > 0) {
                simpleMTFullCardViewHolder.getCardImage().loadImage(gatherer);
                return;
            }
            return;
        }
        List<MTImageURIs> en_images = mTFullCard.getEn_images();
        if (en_images == null || (mTImageURIs2 = (MTImageURIs) CollectionsKt.firstOrNull((List) en_images)) == null || (border_crop = mTImageURIs2.getBorder_crop()) == null) {
            List<MTImageURIs> en_images2 = mTFullCard.getEn_images();
            if (en_images2 != null && (mTImageURIs = (MTImageURIs) CollectionsKt.firstOrNull((List) en_images2)) != null) {
                gatherer2 = mTImageURIs.getGatherer();
            }
            border_crop = gatherer2 == null ? "" : gatherer2;
        }
        if (border_crop.length() > 0) {
            simpleMTFullCardViewHolder.getCardImage().loadImage(border_crop);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 0) {
            throw new IllegalArgumentException("Invalid view type");
        }
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_mt_full_card, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new SimpleMTFullCardViewHolder(viewInflate, this.clickListener);
    }
}
