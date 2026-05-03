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

/* JADX INFO: compiled from: CollectionMatchesViewerDialogFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/studiolaganne/lengendarylens/ReadOnlyCardMatchAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/studiolaganne/lengendarylens/CardMatchAdapter$MatchViewHolder;", "matches", "", "Lcom/studiolaganne/lengendarylens/MTCollectionCardMatch;", "isExactFlags", "", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
final class ReadOnlyCardMatchAdapter extends RecyclerView.Adapter<CardMatchAdapter.MatchViewHolder> {
    private final List<Boolean> isExactFlags;
    private final List<MTCollectionCardMatch> matches;

    public ReadOnlyCardMatchAdapter(List<MTCollectionCardMatch> matches, List<Boolean> isExactFlags) {
        Intrinsics.checkNotNullParameter(matches, "matches");
        Intrinsics.checkNotNullParameter(isExactFlags, "isExactFlags");
        this.matches = matches;
        this.isExactFlags = isExactFlags;
    }

    static final Unit onCreateViewHolder$lambda$0(int i, MTCollectionCardMatch mTCollectionCardMatch) {
        Intrinsics.checkNotNullParameter(mTCollectionCardMatch, "<unused var>");
        return Unit.INSTANCE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.matches.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(CardMatchAdapter.MatchViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.matches.get(position), this.isExactFlags.get(position).booleanValue(), false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public CardMatchAdapter.MatchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_match_item, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new CardMatchAdapter.MatchViewHolder(viewInflate, new Function2() { // from class: com.studiolaganne.lengendarylens.ReadOnlyCardMatchAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ReadOnlyCardMatchAdapter.onCreateViewHolder$lambda$0(((Integer) obj).intValue(), (MTCollectionCardMatch) obj2);
            }
        });
    }
}
