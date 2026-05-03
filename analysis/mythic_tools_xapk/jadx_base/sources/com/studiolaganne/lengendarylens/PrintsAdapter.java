package com.studiolaganne.lengendarylens;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PrintsAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BK\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000bH\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u000bH\u0016J\u0014\u0010\u001a\u001a\u00020\u00172\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u0006J\u0014\u0010\u001c\u001a\u00020\u00172\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006J\u0014\u0010\u001d\u001a\u00020\u00172\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J\b\u0010!\u001a\u00020\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/studiolaganne/lengendarylens/PrintsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/studiolaganne/lengendarylens/PrintViewHolder;", "printClickListener", "Lcom/studiolaganne/lengendarylens/OnPrintClickListener;", "cardSets", "", "Lcom/studiolaganne/lengendarylens/CardSet;", "currentMTCardId", "", "currentFace", "", "cards", "Lcom/studiolaganne/lengendarylens/Card;", "mtCards", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "<init>", "(Lcom/studiolaganne/lengendarylens/OnPrintClickListener;Ljava/util/List;Ljava/lang/String;ILjava/util/List;Ljava/util/List;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "updateData", "newCards", "updateMTData", "updateSets", "newSets", "onViewRecycled", "onViewDetachedFromWindow", "getItemCount", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PrintsAdapter extends RecyclerView.Adapter<PrintViewHolder> {
    public static final int $stable = 8;
    private List<CardSet> cardSets;
    private List<Card> cards;
    private final int currentFace;
    private final String currentMTCardId;
    private List<MTFullCard> mtCards;
    private final OnPrintClickListener printClickListener;

    public PrintsAdapter(OnPrintClickListener printClickListener, List<CardSet> cardSets, String str, int i, List<Card> cards, List<MTFullCard> mtCards) {
        Intrinsics.checkNotNullParameter(printClickListener, "printClickListener");
        Intrinsics.checkNotNullParameter(cardSets, "cardSets");
        Intrinsics.checkNotNullParameter(cards, "cards");
        Intrinsics.checkNotNullParameter(mtCards, "mtCards");
        this.printClickListener = printClickListener;
        this.cardSets = cardSets;
        this.currentMTCardId = str;
        this.currentFace = i;
        this.cards = cards;
        this.mtCards = mtCards;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return (this.currentMTCardId != null ? this.mtCards : this.cards).size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(PrintViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (this.currentMTCardId != null) {
            holder.bind(this.mtCards.get(position));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public PrintViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.print_view, parent, false);
        View viewFindViewById = viewInflate.findViewById(R.id.cardImage);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        LoadingImageView loadingImageView = (LoadingImageView) viewFindViewById;
        loadingImageView.setAutoLoad(false);
        loadingImageView.reset();
        View viewFindViewById2 = viewInflate.findViewById(R.id.titleLabel);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        ((TextView) viewFindViewById2).setVisibility(8);
        OnPrintClickListener onPrintClickListener = this.printClickListener;
        List<CardSet> list = this.cardSets;
        String str = this.currentMTCardId;
        int i = this.currentFace;
        Intrinsics.checkNotNull(viewInflate);
        return new PrintViewHolder(onPrintClickListener, list, str, i, viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(PrintViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewDetachedFromWindow(holder);
        holder.onRecycled();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(PrintViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewRecycled(holder);
        holder.onRecycled();
    }

    public final void updateData(List<Card> newCards) {
        Intrinsics.checkNotNullParameter(newCards, "newCards");
        this.cards = newCards;
        notifyDataSetChanged();
    }

    public final void updateMTData(List<MTFullCard> newCards) {
        Intrinsics.checkNotNullParameter(newCards, "newCards");
        this.mtCards = newCards;
        notifyDataSetChanged();
    }

    public final void updateSets(List<CardSet> newSets) {
        Intrinsics.checkNotNullParameter(newSets, "newSets");
        this.cardSets = newSets;
    }
}
