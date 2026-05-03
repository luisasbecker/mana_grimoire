package com.vanniktech.emoji.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;
import com.vanniktech.emoji.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EmojiGridView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/vanniktech/emoji/internal/EmojiGridView;", "Landroid/widget/GridView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class EmojiGridView extends GridView {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public EmojiGridView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.emoji_grid_view_column_width);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.emoji_grid_view_spacing);
        setColumnWidth(dimensionPixelSize);
        setHorizontalSpacing(dimensionPixelSize2);
        setVerticalSpacing(dimensionPixelSize2);
        setPadding(dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2);
        setNumColumns(-1);
        setClipToPadding(false);
        setVerticalScrollBarEnabled(false);
    }

    public /* synthetic */ EmojiGridView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }
}
