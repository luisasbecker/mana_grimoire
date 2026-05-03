package com.vanniktech.emoji.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListAdapter;
import com.vanniktech.emoji.EmojiCategory;
import com.vanniktech.emoji.EmojiTheming;
import com.vanniktech.emoji.listeners.OnEmojiClickListener;
import com.vanniktech.emoji.variant.VariantEmoji;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CategoryGridView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0010\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J2\u0010\b\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012¨\u0006\u0013"}, d2 = {"Lcom/vanniktech/emoji/internal/CategoryGridView;", "Lcom/vanniktech/emoji/internal/EmojiGridView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "init", "onEmojiClickListener", "Lcom/vanniktech/emoji/listeners/OnEmojiClickListener;", "onEmojiLongClickListener", "Lcom/vanniktech/emoji/internal/OnEmojiLongClickListener;", "theming", "Lcom/vanniktech/emoji/EmojiTheming;", "category", "Lcom/vanniktech/emoji/EmojiCategory;", "variantManager", "Lcom/vanniktech/emoji/variant/VariantEmoji;", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class CategoryGridView extends EmojiGridView {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CategoryGridView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CategoryGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ CategoryGridView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public final CategoryGridView init(OnEmojiClickListener onEmojiClickListener, OnEmojiLongClickListener onEmojiLongClickListener, EmojiTheming theming, EmojiCategory category, VariantEmoji variantManager) {
        Intrinsics.checkNotNullParameter(theming, "theming");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(variantManager, "variantManager");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        setAdapter((ListAdapter) new EmojiArrayAdapter(context, category.getEmojis(), variantManager, onEmojiClickListener, onEmojiLongClickListener, theming));
        return this;
    }
}
