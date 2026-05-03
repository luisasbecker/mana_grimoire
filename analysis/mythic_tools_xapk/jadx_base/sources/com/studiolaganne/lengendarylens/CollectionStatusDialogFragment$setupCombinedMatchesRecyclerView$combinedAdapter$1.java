package com.studiolaganne.lengendarylens;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.studiolaganne.lengendarylens.CardMatchAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: CollectionStatusDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016¨\u0006\r"}, d2 = {"com/studiolaganne/lengendarylens/CollectionStatusDialogFragment$setupCombinedMatchesRecyclerView$combinedAdapter$1", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/studiolaganne/lengendarylens/CardMatchAdapter$MatchViewHolder;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CollectionStatusDialogFragment$setupCombinedMatchesRecyclerView$combinedAdapter$1 extends RecyclerView.Adapter<CardMatchAdapter.MatchViewHolder> {
    final /* synthetic */ List<MTCollectionCardMatch> $allMatches;
    final /* synthetic */ Ref.IntRef $currentSelectedPosition;
    final /* synthetic */ List<Boolean> $isExactFlags;
    final /* synthetic */ CollectionStatusDialogFragment this$0;

    CollectionStatusDialogFragment$setupCombinedMatchesRecyclerView$combinedAdapter$1(Ref.IntRef intRef, CollectionStatusDialogFragment collectionStatusDialogFragment, List<MTCollectionCardMatch> list, List<Boolean> list2) {
        this.$currentSelectedPosition = intRef;
        this.this$0 = collectionStatusDialogFragment;
        this.$allMatches = list;
        this.$isExactFlags = list2;
    }

    static final Unit onCreateViewHolder$lambda$0(Ref.IntRef intRef, CollectionStatusDialogFragment collectionStatusDialogFragment, CollectionStatusDialogFragment$setupCombinedMatchesRecyclerView$combinedAdapter$1 collectionStatusDialogFragment$setupCombinedMatchesRecyclerView$combinedAdapter$1, int i, MTCollectionCardMatch match) {
        Intrinsics.checkNotNullParameter(match, "match");
        intRef.element = i;
        collectionStatusDialogFragment.selectedMatch = match;
        collectionStatusDialogFragment$setupCombinedMatchesRecyclerView$combinedAdapter$1.notifyDataSetChanged();
        collectionStatusDialogFragment.updateSaveButtonState();
        return Unit.INSTANCE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.$allMatches.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(CardMatchAdapter.MatchViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.$allMatches.get(position), this.$isExactFlags.get(position).booleanValue(), position == this.$currentSelectedPosition.element);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public CardMatchAdapter.MatchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_match_item, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        final Ref.IntRef intRef = this.$currentSelectedPosition;
        final CollectionStatusDialogFragment collectionStatusDialogFragment = this.this$0;
        return new CardMatchAdapter.MatchViewHolder(viewInflate, new Function2() { // from class: com.studiolaganne.lengendarylens.CollectionStatusDialogFragment$setupCombinedMatchesRecyclerView$combinedAdapter$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return CollectionStatusDialogFragment$setupCombinedMatchesRecyclerView$combinedAdapter$1.onCreateViewHolder$lambda$0(intRef, collectionStatusDialogFragment, this, ((Integer) obj).intValue(), (MTCollectionCardMatch) obj2);
            }
        });
    }
}
