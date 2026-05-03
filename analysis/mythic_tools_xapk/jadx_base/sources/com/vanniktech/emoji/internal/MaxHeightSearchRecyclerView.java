package com.vanniktech.emoji.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EdgeEffect;
import androidx.recyclerview.widget.RecyclerView;
import com.vanniktech.emoji.EmojiTheming;
import com.vanniktech.emoji.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MaxHeightSearchRecyclerView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0014J\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f¨\u0006\u0010"}, d2 = {"Lcom/vanniktech/emoji/internal/MaxHeightSearchRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onMeasure", "", "widthMeasureSpec", "", "heightMeasureSpec", "tint", "emojiTheming", "Lcom/vanniktech/emoji/EmojiTheming;", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MaxHeightSearchRecyclerView extends RecyclerView {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MaxHeightSearchRecyclerView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaxHeightSearchRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        setClipToPadding(false);
    }

    public /* synthetic */ MaxHeightSearchRecyclerView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(getContext().getResources().getDimensionPixelSize(R.dimen.emoji_search_max_height), Integer.MIN_VALUE));
    }

    public final void tint(final EmojiTheming emojiTheming) {
        Intrinsics.checkNotNullParameter(emojiTheming, "emojiTheming");
        setBackgroundColor(emojiTheming.backgroundColor);
        setEdgeEffectFactory(new RecyclerView.EdgeEffectFactory() { // from class: com.vanniktech.emoji.internal.MaxHeightSearchRecyclerView.tint.1
            @Override // androidx.recyclerview.widget.RecyclerView.EdgeEffectFactory
            protected EdgeEffect createEdgeEffect(RecyclerView view, int direction) {
                Intrinsics.checkNotNullParameter(view, "view");
                EdgeEffect edgeEffect = new EdgeEffect(view.getContext());
                edgeEffect.setColor(emojiTheming.secondaryColor);
                return edgeEffect;
            }
        });
    }
}
