package com.studiolaganne.lengendarylens;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.Constants;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SectionHeaderViewHolder.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/studiolaganne/lengendarylens/SectionHeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "stripe", Constants.GP_IAP_TITLE, "Landroid/widget/TextView;", "count", "bind", "", "category", "Lcom/studiolaganne/lengendarylens/MTCardRankingCategory;", "itemCount", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SectionHeaderViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    private final TextView count;
    private final View stripe;
    private final TextView title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SectionHeaderViewHolder(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View viewFindViewById = itemView.findViewById(R.id.sectionStripe);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.stripe = viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R.id.sectionTitle);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.title = (TextView) viewFindViewById2;
        View viewFindViewById3 = itemView.findViewById(R.id.sectionCount);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.count = (TextView) viewFindViewById3;
    }

    public final void bind(MTCardRankingCategory category, int itemCount) {
        Intrinsics.checkNotNullParameter(category, "category");
        int iCategoryAccent = MTRankingHelpers.INSTANCE.categoryAccent(category);
        this.stripe.setBackgroundColor(iCategoryAccent);
        this.title.setTextColor(iCategoryAccent);
        TextView textView = this.title;
        String string = this.itemView.getContext().getString(MTRankingHelpers.INSTANCE.categoryLabelResId(category));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String upperCase = string.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        textView.setText(upperCase);
        this.count.setText(String.valueOf(itemCount));
    }
}
