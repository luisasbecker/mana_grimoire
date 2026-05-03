package com.studiolaganne.lengendarylens;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.window.reflection.WindowExtensionsConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.studiolaganne.lengendarylens.MTCardPriceRow;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTCardPriceAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0013\u0014\u0015B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardPriceAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "cardRows", "", "Lcom/studiolaganne/lengendarylens/MTCardPriceRow;", "<init>", "(Ljava/util/List;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "getItemViewType", "Companion", "TypeHeaderViewHolder", "TypePriceViewHolder", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MTCardPriceAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int TYPE_HEADER = 1;
    public static final int TYPE_PRICE = 2;
    private final List<MTCardPriceRow> cardRows;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: MTCardPriceAdapter.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardPriceAdapter$TypeHeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "marketplaceIcon", "Landroid/widget/ImageView;", "marketplaceName", "Landroid/widget/TextView;", WindowExtensionsConstants.LAYOUT_PACKAGE, "Landroid/widget/LinearLayout;", "bind", "", "rowData", "Lcom/studiolaganne/lengendarylens/MTCardPriceRow$MarketplaceHeader;", FirebaseAnalytics.Param.INDEX, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class TypeHeaderViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private final LinearLayout layout;
        private final ImageView marketplaceIcon;
        private final TextView marketplaceName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TypeHeaderViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View viewFindViewById = view.findViewById(R.id.marketplace_icon);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.marketplaceIcon = (ImageView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.marketplace_name);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.marketplaceName = (TextView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.root_linear_layout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            this.layout = (LinearLayout) viewFindViewById3;
        }

        public final void bind(MTCardPriceRow.MarketplaceHeader rowData, int index) {
            Intrinsics.checkNotNullParameter(rowData, "rowData");
            this.marketplaceIcon.setImageResource(rowData.getMarketplaceIconRes());
            this.marketplaceName.setText(rowData.getMarketplaceName());
            int i = index % 2;
            LinearLayout linearLayout = this.layout;
            if (i == 0) {
                linearLayout.setBackgroundColor(ContextCompat.getColor(this.itemView.getContext(), R.color.background_color));
            } else {
                linearLayout.setBackgroundColor(ContextCompat.getColor(this.itemView.getContext(), R.color.darker_background));
            }
        }
    }

    /* JADX INFO: compiled from: MTCardPriceAdapter.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/studiolaganne/lengendarylens/MTCardPriceAdapter$TypePriceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", Constants.ScionAnalytics.PARAM_LABEL, "Landroid/widget/TextView;", FirebaseAnalytics.Param.PRICE, "foilImage", "Landroid/widget/ImageView;", WindowExtensionsConstants.LAYOUT_PACKAGE, "Landroid/widget/LinearLayout;", "bind", "", "rowData", "Lcom/studiolaganne/lengendarylens/MTCardPriceRow$PriceRow;", FirebaseAnalytics.Param.INDEX, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class TypePriceViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private final ImageView foilImage;
        private final TextView label;
        private final LinearLayout layout;
        private final TextView price;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TypePriceViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View viewFindViewById = view.findViewById(R.id.label);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.label = (TextView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.price);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.price = (TextView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.foilImage);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
            this.foilImage = (ImageView) viewFindViewById3;
            View viewFindViewById4 = view.findViewById(R.id.root_linear_layout);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
            this.layout = (LinearLayout) viewFindViewById4;
        }

        public final void bind(MTCardPriceRow.PriceRow rowData, int index) {
            Intrinsics.checkNotNullParameter(rowData, "rowData");
            this.label.setText(rowData.getFinishLabel());
            TextView textView = this.price;
            String price = rowData.getPrice();
            if (price == null) {
                price = "---";
            }
            textView.setText(price);
            this.foilImage.setVisibility(rowData.isFoil() ? 0 : 4);
            int i = index % 2;
            LinearLayout linearLayout = this.layout;
            if (i == 0) {
                linearLayout.setBackgroundColor(ContextCompat.getColor(this.itemView.getContext(), R.color.background_color));
            } else {
                linearLayout.setBackgroundColor(ContextCompat.getColor(this.itemView.getContext(), R.color.darker_background));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MTCardPriceAdapter(List<? extends MTCardPriceRow> cardRows) {
        Intrinsics.checkNotNullParameter(cardRows, "cardRows");
        this.cardRows = cardRows;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.cardRows.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        MTCardPriceRow mTCardPriceRow = this.cardRows.get(position);
        if (mTCardPriceRow instanceof MTCardPriceRow.MarketplaceHeader) {
            return 1;
        }
        if (mTCardPriceRow instanceof MTCardPriceRow.PriceRow) {
            return 2;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        MTCardPriceRow mTCardPriceRow = this.cardRows.get(position);
        if (holder instanceof TypeHeaderViewHolder) {
            Intrinsics.checkNotNull(mTCardPriceRow, "null cannot be cast to non-null type com.studiolaganne.lengendarylens.MTCardPriceRow.MarketplaceHeader");
            ((TypeHeaderViewHolder) holder).bind((MTCardPriceRow.MarketplaceHeader) mTCardPriceRow, position);
        } else if (holder instanceof TypePriceViewHolder) {
            Intrinsics.checkNotNull(mTCardPriceRow, "null cannot be cast to non-null type com.studiolaganne.lengendarylens.MTCardPriceRow.PriceRow");
            ((TypePriceViewHolder) holder).bind((MTCardPriceRow.PriceRow) mTCardPriceRow, position);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        if (viewType == 1) {
            View viewInflate = layoutInflaterFrom.inflate(R.layout.mt_price_row_header, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
            return new TypeHeaderViewHolder(viewInflate);
        }
        if (viewType != 2) {
            throw new IllegalArgumentException("Invalid view type");
        }
        View viewInflate2 = layoutInflaterFrom.inflate(R.layout.mt_price_row, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate2, "inflate(...)");
        return new TypePriceViewHolder(viewInflate2);
    }
}
