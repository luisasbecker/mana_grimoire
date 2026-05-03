package com.studiolaganne.lengendarylens;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MythicUsersAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/studiolaganne/lengendarylens/MythicEmptyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MythicEmptyViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    private final TextView textView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MythicEmptyViewHolder(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View viewFindViewWithTag = itemView.findViewWithTag("emptyText");
        Intrinsics.checkNotNullExpressionValue(viewFindViewWithTag, "findViewWithTag(...)");
        this.textView = (TextView) viewFindViewWithTag;
    }

    public final TextView getTextView() {
        return this.textView;
    }
}
