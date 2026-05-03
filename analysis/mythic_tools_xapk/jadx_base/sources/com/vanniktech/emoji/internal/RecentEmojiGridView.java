package com.vanniktech.emoji.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListAdapter;
import com.vanniktech.emoji.EmojiTheming;
import com.vanniktech.emoji.listeners.OnEmojiClickListener;
import com.vanniktech.emoji.recent.RecentEmoji;
import com.vanniktech.emoji.variant.NoVariantEmoji;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecentEmojiGridView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\f\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bJ\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/vanniktech/emoji/internal/RecentEmojiGridView;", "Lcom/vanniktech/emoji/internal/EmojiGridView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "emojiArrayAdapter", "Lcom/vanniktech/emoji/internal/EmojiArrayAdapter;", "recentEmojis", "Lcom/vanniktech/emoji/recent/RecentEmoji;", "init", "onEmojiClickListener", "Lcom/vanniktech/emoji/listeners/OnEmojiClickListener;", "onEmojiLongClickListener", "Lcom/vanniktech/emoji/internal/OnEmojiLongClickListener;", "theming", "Lcom/vanniktech/emoji/EmojiTheming;", "recentEmoji", "invalidateEmojis", "", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RecentEmojiGridView extends EmojiGridView {
    private EmojiArrayAdapter emojiArrayAdapter;
    private RecentEmoji recentEmojis;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RecentEmojiGridView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecentEmojiGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ RecentEmojiGridView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public final RecentEmojiGridView init(OnEmojiClickListener onEmojiClickListener, OnEmojiLongClickListener onEmojiLongClickListener, EmojiTheming theming, RecentEmoji recentEmoji) {
        Intrinsics.checkNotNullParameter(theming, "theming");
        Intrinsics.checkNotNullParameter(recentEmoji, "recentEmoji");
        this.recentEmojis = recentEmoji;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        EmojiArrayAdapter emojiArrayAdapter = new EmojiArrayAdapter(context, recentEmoji.getRecentEmojis(), NoVariantEmoji.INSTANCE, onEmojiClickListener, onEmojiLongClickListener, theming);
        this.emojiArrayAdapter = emojiArrayAdapter;
        setAdapter((ListAdapter) emojiArrayAdapter);
        return this;
    }

    public final void invalidateEmojis() {
        EmojiArrayAdapter emojiArrayAdapter = this.emojiArrayAdapter;
        RecentEmoji recentEmoji = null;
        if (emojiArrayAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emojiArrayAdapter");
            emojiArrayAdapter = null;
        }
        RecentEmoji recentEmoji2 = this.recentEmojis;
        if (recentEmoji2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recentEmojis");
        } else {
            recentEmoji = recentEmoji2;
        }
        emojiArrayAdapter.updateEmojis(recentEmoji.getRecentEmojis());
    }
}
