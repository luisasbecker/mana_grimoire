package com.studiolaganne.lengendarylens;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CardContainerAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/studiolaganne/lengendarylens/CardContainerSeparatorViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "clickListener", "Lcom/studiolaganne/lengendarylens/CardContainerClickListener;", "<init>", "(Landroid/view/View;Lcom/studiolaganne/lengendarylens/CardContainerClickListener;)V", "getClickListener", "()Lcom/studiolaganne/lengendarylens/CardContainerClickListener;", "separatorText", "Landroid/widget/TextView;", "getSeparatorText", "()Landroid/widget/TextView;", "setSeparatorText", "(Landroid/widget/TextView;)V", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CardContainerSeparatorViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    private final CardContainerClickListener clickListener;
    private TextView separatorText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardContainerSeparatorViewHolder(View itemView, CardContainerClickListener clickListener) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.clickListener = clickListener;
        View viewFindViewById = itemView.findViewById(R.id.separatorText);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.separatorText = (TextView) viewFindViewById;
    }

    public final CardContainerClickListener getClickListener() {
        return this.clickListener;
    }

    public final TextView getSeparatorText() {
        return this.separatorText;
    }

    public final void setSeparatorText(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.separatorText = textView;
    }
}
