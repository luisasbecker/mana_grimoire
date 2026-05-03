package com.studiolaganne.lengendarylens;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.window.reflection.WindowExtensionsConstants;
import com.bumptech.glide.load.Key;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.messaging.Constants;
import com.studiolaganne.lengendarylens.CardPriceAdapter;
import java.net.URLEncoder;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CardPriceAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u0013\u0014\u0015\u0016B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/studiolaganne/lengendarylens/CardPriceAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "cardRows", "", "Lcom/studiolaganne/lengendarylens/CardPriceRow;", "<init>", "(Ljava/util/List;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "getItemViewType", "Companion", "Type1ViewHolder", "Type2ViewHolder", "Type3ViewHolder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CardPriceAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int TYPE_BUTTONS = 3;
    public static final int TYPE_PRICE = 2;
    public static final int TYPE_TITLE = 1;
    private final List<CardPriceRow> cardRows;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: CardPriceAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/studiolaganne/lengendarylens/CardPriceAdapter$Type1ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "bind", "", "rowData", "Lcom/studiolaganne/lengendarylens/CardPriceRow;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Type1ViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Type1ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
        }

        public final void bind(CardPriceRow rowData) {
            Intrinsics.checkNotNullParameter(rowData, "rowData");
        }
    }

    /* JADX INFO: compiled from: CardPriceAdapter.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/studiolaganne/lengendarylens/CardPriceAdapter$Type2ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", Constants.ScionAnalytics.PARAM_LABEL, "Landroid/widget/TextView;", "eurLabel", "usdLabel", WindowExtensionsConstants.LAYOUT_PACKAGE, "Landroid/widget/LinearLayout;", "bind", "", "rowData", "Lcom/studiolaganne/lengendarylens/CardPriceRow;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Type2ViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private final TextView eurLabel;
        private final TextView label;
        private final LinearLayout layout;
        private final TextView usdLabel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Type2ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View viewFindViewById = view.findViewById(R.id.label);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.label = (TextView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.price_eur);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.eurLabel = (TextView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.price_usd);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            this.usdLabel = (TextView) viewFindViewById3;
            View viewFindViewById4 = view.findViewById(R.id.root_linear_layout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
            this.layout = (LinearLayout) viewFindViewById4;
        }

        public final void bind(CardPriceRow rowData) {
            Intrinsics.checkNotNullParameter(rowData, "rowData");
            this.label.setText(rowData.getLabel());
            this.eurLabel.setText(rowData.getEur());
            this.usdLabel.setText(rowData.getUsd());
            Boolean selected = rowData.getSelected();
            if (selected == null) {
                this.layout.setBackgroundColor(ContextCompat.getColor(this.itemView.getContext(), R.color.lighter_grey));
                return;
            }
            boolean zBooleanValue = selected.booleanValue();
            LinearLayout linearLayout = this.layout;
            if (zBooleanValue) {
                linearLayout.setBackgroundColor(ContextCompat.getColor(this.itemView.getContext(), R.color.lighter_blue));
            } else {
                linearLayout.setBackgroundColor(ContextCompat.getColor(this.itemView.getContext(), R.color.lighter_grey));
            }
        }
    }

    /* JADX INFO: compiled from: CardPriceAdapter.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/studiolaganne/lengendarylens/CardPriceAdapter$Type3ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "eurButton", "Landroidx/cardview/widget/CardView;", "kotlin.jvm.PlatformType", "usdButton", "openWebActivity", "", "url", "", "bind", "rowData", "Lcom/studiolaganne/lengendarylens/CardPriceRow;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Type3ViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private final CardView eurButton;
        private final CardView usdButton;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Type3ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.eurButton = (CardView) view.findViewById(R.id.buy_eur_button);
            this.usdButton = (CardView) view.findViewById(R.id.buy_usd_button);
        }

        static final Unit bind$lambda$0(CardPriceRow cardPriceRow, Type3ViewHolder type3ViewHolder) {
            String cardName;
            String purchaseURLCardMarket = cardPriceRow.getPurchaseURLCardMarket();
            if (purchaseURLCardMarket.length() == 0 && (cardName = cardPriceRow.getCardName()) != null && cardName.length() > 0) {
                purchaseURLCardMarket = "https://www.cardmarket.com/en/Magic/Products/Search?searchString=" + URLEncoder.encode(cardName, Key.STRING_CHARSET_NAME) + "&utm_campaign=card_prices&utm_medium=text";
            }
            if (purchaseURLCardMarket.length() > 0) {
                type3ViewHolder.openWebActivity(purchaseURLCardMarket);
            }
            return Unit.INSTANCE;
        }

        static final Unit bind$lambda$1(CardPriceRow cardPriceRow, Type3ViewHolder type3ViewHolder) {
            String purchaseURLTCGPlayer = cardPriceRow.getPurchaseURLTCGPlayer();
            if (purchaseURLTCGPlayer.length() == 0) {
                purchaseURLTCGPlayer = "https://www.tcgplayer.com/product/" + cardPriceRow.getTcgPlayerId();
            }
            type3ViewHolder.openWebActivity(purchaseURLTCGPlayer);
            return Unit.INSTANCE;
        }

        private final void openWebActivity(String url) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
            if (intent.resolveActivity(this.itemView.getContext().getPackageManager()) != null) {
                this.itemView.getContext().startActivity(intent);
                return;
            }
            Intent intent2 = new Intent(this.itemView.getContext(), (Class<?>) WebActivity.class);
            intent2.setFlags(603979776);
            intent2.putExtra("url", url);
            this.itemView.getContext().startActivity(intent2);
        }

        public final void bind(final CardPriceRow rowData) {
            Intrinsics.checkNotNullParameter(rowData, "rowData");
            CardView eurButton = this.eurButton;
            Intrinsics.checkNotNullExpressionValue(eurButton, "eurButton");
            ViewExtensionsKt.setOnClickWithFade(eurButton, new Function0() { // from class: com.studiolaganne.lengendarylens.CardPriceAdapter$Type3ViewHolder$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return CardPriceAdapter.Type3ViewHolder.bind$lambda$0(rowData, this);
                }
            });
            CardView usdButton = this.usdButton;
            Intrinsics.checkNotNullExpressionValue(usdButton, "usdButton");
            ViewExtensionsKt.setOnClickWithFade(usdButton, new Function0() { // from class: com.studiolaganne.lengendarylens.CardPriceAdapter$Type3ViewHolder$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return CardPriceAdapter.Type3ViewHolder.bind$lambda$1(rowData, this);
                }
            });
        }
    }

    public CardPriceAdapter(List<CardPriceRow> cardRows) {
        Intrinsics.checkNotNullParameter(cardRows, "cardRows");
        this.cardRows = cardRows;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.cardRows.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.cardRows.get(position).getType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        CardPriceRow cardPriceRow = this.cardRows.get(position);
        if (holder instanceof Type1ViewHolder) {
            ((Type1ViewHolder) holder).bind(cardPriceRow);
        } else if (holder instanceof Type2ViewHolder) {
            ((Type2ViewHolder) holder).bind(cardPriceRow);
        } else if (holder instanceof Type3ViewHolder) {
            ((Type3ViewHolder) holder).bind(cardPriceRow);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        if (viewType == 1) {
            View viewInflate = layoutInflaterFrom.inflate(R.layout.price_row_type_title, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
            return new Type1ViewHolder(viewInflate);
        }
        if (viewType == 2) {
            View viewInflate2 = layoutInflaterFrom.inflate(R.layout.price_row_type_price, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate2, "inflate(...)");
            return new Type2ViewHolder(viewInflate2);
        }
        if (viewType != 3) {
            throw new IllegalArgumentException("Invalid view type");
        }
        View viewInflate3 = layoutInflaterFrom.inflate(R.layout.price_row_type_buttons, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate3, "inflate(...)");
        return new Type3ViewHolder(viewInflate3);
    }
}
