package com.studiolaganne.lengendarylens;

import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.studiolaganne.lengendarylens.CardMatchAdapter;
import com.vanniktech.ui.ColorKt;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CardMatchAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aBA\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\tH\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016J\u000e\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\tJ\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/studiolaganne/lengendarylens/CardMatchAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/studiolaganne/lengendarylens/CardMatchAdapter$MatchViewHolder;", "matches", "", "Lcom/studiolaganne/lengendarylens/MTCollectionCardMatch;", "isExactMatch", "", "selectedPosition", "", "onMatchSelected", "Lkotlin/Function2;", "", "<init>", "(Ljava/util/List;ZILkotlin/jvm/functions/Function2;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "updateSelection", "newPosition", "getSelectedMatch", "MatchViewHolder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CardMatchAdapter extends RecyclerView.Adapter<MatchViewHolder> {
    public static final int $stable = 8;
    private final boolean isExactMatch;
    private final List<MTCollectionCardMatch> matches;
    private final Function2<Integer, MTCollectionCardMatch, Unit> onMatchSelected;
    private int selectedPosition;

    /* JADX INFO: compiled from: CardMatchAdapter.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cR \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/studiolaganne/lengendarylens/CardMatchAdapter$MatchViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "onMatchSelected", "Lkotlin/Function2;", "", "Lcom/studiolaganne/lengendarylens/MTCollectionCardMatch;", "", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function2;)V", "rootLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "cardImage", "Lcom/studiolaganne/lengendarylens/LoadingImageView;", "cardName", "Landroid/widget/TextView;", "setCode", "collectorNumber", "exactMatchLabel", "containerLabel", "collectionLayout", "Landroid/widget/LinearLayout;", "foilEffectImage", "Landroid/widget/ImageView;", "bind", "match", "isExactMatch", "", "isSelected", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class MatchViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private final LoadingImageView cardImage;
        private final TextView cardName;
        private final LinearLayout collectionLayout;
        private final TextView collectorNumber;
        private final TextView containerLabel;
        private final TextView exactMatchLabel;
        private final ImageView foilEffectImage;
        private final Function2<Integer, MTCollectionCardMatch, Unit> onMatchSelected;
        private final ConstraintLayout rootLayout;
        private final TextView setCode;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public MatchViewHolder(View itemView, Function2<? super Integer, ? super MTCollectionCardMatch, Unit> onMatchSelected) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(onMatchSelected, "onMatchSelected");
            this.onMatchSelected = onMatchSelected;
            View viewFindViewById = itemView.findViewById(R.id.rootLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.rootLayout = (ConstraintLayout) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R.id.cardImage);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.cardImage = (LoadingImageView) viewFindViewById2;
            View viewFindViewById3 = itemView.findViewById(R.id.cardName);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            this.cardName = (TextView) viewFindViewById3;
            View viewFindViewById4 = itemView.findViewById(R.id.setCode);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
            this.setCode = (TextView) viewFindViewById4;
            View viewFindViewById5 = itemView.findViewById(R.id.collectorNumber);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
            this.collectorNumber = (TextView) viewFindViewById5;
            View viewFindViewById6 = itemView.findViewById(R.id.exactMatchLabel);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
            this.exactMatchLabel = (TextView) viewFindViewById6;
            View viewFindViewById7 = itemView.findViewById(R.id.containerLabel);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
            this.containerLabel = (TextView) viewFindViewById7;
            View viewFindViewById8 = itemView.findViewById(R.id.collectionLayout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
            this.collectionLayout = (LinearLayout) viewFindViewById8;
            View viewFindViewById9 = itemView.findViewById(R.id.foilEffectImage);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
            this.foilEffectImage = (ImageView) viewFindViewById9;
        }

        static final Unit bind$lambda$5(MatchViewHolder matchViewHolder, MTCollectionCardMatch mTCollectionCardMatch) {
            matchViewHolder.onMatchSelected.invoke(Integer.valueOf(matchViewHolder.getBindingAdapterPosition()), mTCollectionCardMatch);
            return Unit.INSTANCE;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void bind(final MTCollectionCardMatch match, boolean isExactMatch, boolean isSelected) {
            String str;
            String gatherer;
            String name;
            String normal;
            Intrinsics.checkNotNullParameter(match, "match");
            MTCardMatch card = match.getCard();
            if (card == null) {
                return;
            }
            TextView textView = this.cardName;
            String printed_name = card.getPrinted_name();
            textView.setText((printed_name == null && (printed_name = card.getName()) == null) ? "" : printed_name);
            TextView textView2 = this.setCode;
            String set_code = card.getSet_code();
            if (set_code != null) {
                String upperCase = set_code.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                str = upperCase != null ? upperCase : "";
            }
            textView2.setText(str);
            TextView textView3 = this.collectorNumber;
            String collector_number = card.getCollector_number();
            if (collector_number == null) {
                collector_number = "---";
            }
            textView3.setText(ColorKt.HEX_PREFIX + collector_number);
            this.exactMatchLabel.setVisibility(isExactMatch ? 0 : 8);
            this.cardImage.setAutoLoad(false);
            this.cardImage.reset();
            MTImageURIs images = card.getImages();
            if (images == null || (normal = images.getNormal()) == null) {
                MTImageURIs images2 = card.getImages();
                if (images2 != null && (gatherer = images2.getGatherer()) != null) {
                    this.cardImage.loadImage(gatherer);
                }
            } else {
                this.cardImage.loadImage(normal);
            }
            if (Intrinsics.areEqual(card.getFinish(), "foil") || Intrinsics.areEqual(card.getFinish(), "etched")) {
                this.foilEffectImage.setVisibility(0);
            } else {
                this.foilEffectImage.setVisibility(8);
            }
            MTCardContainer list = match.getList();
            if (list == null || (name = list.getName()) == null) {
                this.collectionLayout.setVisibility(8);
            } else {
                if (Intrinsics.areEqual(name, "bulk")) {
                    name = this.itemView.getContext().getString(R.string.list_bulk);
                    Intrinsics.checkNotNullExpressionValue(name, "getString(...)");
                }
                this.containerLabel.setText(name);
                this.collectionLayout.setVisibility(0);
            }
            int color = isSelected ? ContextCompat.getColor(this.itemView.getContext(), R.color.selected_color_new) : ContextCompat.getColor(this.itemView.getContext(), R.color.text_color);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(ContextCompat.getColor(this.itemView.getContext(), android.R.color.transparent));
            gradientDrawable.setStroke((int) (2.0f * this.itemView.getContext().getResources().getDisplayMetrics().density), color);
            gradientDrawable.setCornerRadius(this.itemView.getContext().getResources().getDisplayMetrics().density * 8.0f);
            this.rootLayout.setBackground(gradientDrawable);
            ViewExtensionsKt.setOnClickWithFade(this.rootLayout, new Function0() { // from class: com.studiolaganne.lengendarylens.CardMatchAdapter$MatchViewHolder$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return CardMatchAdapter.MatchViewHolder.bind$lambda$5(this.f$0, match);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CardMatchAdapter(List<MTCollectionCardMatch> matches, boolean z, int i, Function2<? super Integer, ? super MTCollectionCardMatch, Unit> onMatchSelected) {
        Intrinsics.checkNotNullParameter(matches, "matches");
        Intrinsics.checkNotNullParameter(onMatchSelected, "onMatchSelected");
        this.matches = matches;
        this.isExactMatch = z;
        this.selectedPosition = i;
        this.onMatchSelected = onMatchSelected;
    }

    public /* synthetic */ CardMatchAdapter(List list, boolean z, int i, Function2 function2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, z, (i2 & 4) != 0 ? -1 : i, function2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.matches.size();
    }

    public final MTCollectionCardMatch getSelectedMatch() {
        int i = this.selectedPosition;
        if (i < 0 || i >= this.matches.size()) {
            return null;
        }
        return this.matches.get(this.selectedPosition);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MatchViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.matches.get(position), this.isExactMatch, position == this.selectedPosition);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MatchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_match_item, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new MatchViewHolder(viewInflate, this.onMatchSelected);
    }

    public final void updateSelection(int newPosition) {
        int i = this.selectedPosition;
        this.selectedPosition = newPosition;
        if (i != -1) {
            notifyItemChanged(i);
        }
        if (newPosition != -1) {
            notifyItemChanged(newPosition);
        }
    }
}
