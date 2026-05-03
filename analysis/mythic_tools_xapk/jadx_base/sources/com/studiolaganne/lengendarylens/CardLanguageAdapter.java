package com.studiolaganne.lengendarylens;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.studiolaganne.lengendarylens.CardLanguageAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CardLanguageAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/studiolaganne/lengendarylens/CardLanguageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "cardRows", "", "Lcom/studiolaganne/lengendarylens/CardLanguageRow;", "languageClickListener", "Lcom/studiolaganne/lengendarylens/CardLanguageClickListener;", "<init>", "(Ljava/util/List;Lcom/studiolaganne/lengendarylens/CardLanguageClickListener;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "LangViewHolder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CardLanguageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int $stable = 8;
    private final List<CardLanguageRow> cardRows;
    private final CardLanguageClickListener languageClickListener;

    /* JADX INFO: compiled from: CardLanguageAdapter.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/studiolaganne/lengendarylens/CardLanguageAdapter$LangViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "languageClickListener", "Lcom/studiolaganne/lengendarylens/CardLanguageClickListener;", "<init>", "(Landroid/view/View;Lcom/studiolaganne/lengendarylens/CardLanguageClickListener;)V", "titleLabel", "Landroid/widget/TextView;", "flagImage", "Landroid/widget/ImageView;", "bind", "", "rowData", "Lcom/studiolaganne/lengendarylens/CardLanguageRow;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class LangViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private final ImageView flagImage;
        private final CardLanguageClickListener languageClickListener;
        private final TextView titleLabel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LangViewHolder(View view, CardLanguageClickListener languageClickListener) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(languageClickListener, "languageClickListener");
            this.languageClickListener = languageClickListener;
            View viewFindViewById = view.findViewById(R.id.title_textview);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.titleLabel = (TextView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.flag_image);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.flagImage = (ImageView) viewFindViewById2;
        }

        public final void bind(final CardLanguageRow rowData) {
            Intrinsics.checkNotNullParameter(rowData, "rowData");
            this.titleLabel.setText(rowData.getTitle());
            String lang = rowData.getLang();
            if (Intrinsics.areEqual(rowData.getLang(), UserDataStore.PHONE)) {
                lang = "en";
            }
            this.flagImage.setImageResource(this.itemView.getResources().getIdentifier("flag_" + lang, "drawable", this.flagImage.getContext().getPackageName()));
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.CardLanguageAdapter$LangViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CardLanguageAdapter.LangViewHolder langViewHolder = this.f$0;
                    CardLanguageRow cardLanguageRow = rowData;
                    langViewHolder.languageClickListener.onCardLanguageClick(cardLanguageRow.getScryfallId(), cardLanguageRow.getOracleId(), cardLanguageRow.getTitle(), cardLanguageRow.getLang(), cardLanguageRow.getTypeLine(), cardLanguageRow.getOracleText());
                }
            });
        }
    }

    public CardLanguageAdapter(List<CardLanguageRow> cardRows, CardLanguageClickListener languageClickListener) {
        Intrinsics.checkNotNullParameter(cardRows, "cardRows");
        Intrinsics.checkNotNullParameter(languageClickListener, "languageClickListener");
        this.cardRows = cardRows;
        this.languageClickListener = languageClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.cardRows.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        CardLanguageRow cardLanguageRow = this.cardRows.get(position);
        if (holder instanceof LangViewHolder) {
            ((LangViewHolder) holder).bind(cardLanguageRow);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.language_menu_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        return new LangViewHolder(viewInflate, this.languageClickListener);
    }
}
