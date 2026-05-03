package com.vanniktech.emoji.internal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vanniktech.emoji.Emoji;
import com.vanniktech.emoji.EmojiTheming;
import com.vanniktech.emoji.R;
import com.vanniktech.emoji.listeners.OnEmojiClickListener;
import com.vanniktech.emoji.variant.VariantEmoji;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EmojiArrayAdapter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BA\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0014\u0010\u0018\u001a\u00020\u00192\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/vanniktech/emoji/internal/EmojiArrayAdapter;", "Landroid/widget/ArrayAdapter;", "Lcom/vanniktech/emoji/Emoji;", "context", "Landroid/content/Context;", "emojis", "", "variantEmoji", "Lcom/vanniktech/emoji/variant/VariantEmoji;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/vanniktech/emoji/listeners/OnEmojiClickListener;", "longListener", "Lcom/vanniktech/emoji/internal/OnEmojiLongClickListener;", "theming", "Lcom/vanniktech/emoji/EmojiTheming;", "<init>", "(Landroid/content/Context;Ljava/util/Collection;Lcom/vanniktech/emoji/variant/VariantEmoji;Lcom/vanniktech/emoji/listeners/OnEmojiClickListener;Lcom/vanniktech/emoji/internal/OnEmojiLongClickListener;Lcom/vanniktech/emoji/EmojiTheming;)V", "getView", "Landroid/view/View;", "position", "", "convertView", "parent", "Landroid/view/ViewGroup;", "updateEmojis", "", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class EmojiArrayAdapter extends ArrayAdapter<Emoji> {
    private final OnEmojiClickListener listener;
    private final OnEmojiLongClickListener longListener;
    private final EmojiTheming theming;
    private final VariantEmoji variantEmoji;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiArrayAdapter(Context context, Collection<? extends Emoji> emojis, VariantEmoji variantEmoji, OnEmojiClickListener onEmojiClickListener, OnEmojiLongClickListener onEmojiLongClickListener, EmojiTheming theming) {
        super(context, 0, CollectionsKt.toMutableList((Collection) emojis));
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(emojis, "emojis");
        Intrinsics.checkNotNullParameter(variantEmoji, "variantEmoji");
        Intrinsics.checkNotNullParameter(theming, "theming");
        this.variantEmoji = variantEmoji;
        this.listener = onEmojiClickListener;
        this.longListener = onEmojiLongClickListener;
        this.theming = theming;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        EmojiImageView emojiImageView = convertView instanceof EmojiImageView ? (EmojiImageView) convertView : null;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        if (emojiImageView == null) {
            View viewInflate = LayoutInflater.from(context).inflate(R.layout.emoji_adapter_item_emoji, parent, false);
            Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type com.vanniktech.emoji.internal.EmojiImageView");
            emojiImageView = (EmojiImageView) viewInflate;
            emojiImageView.setClickListener$emoji_release(this.listener);
            emojiImageView.setLongClickListener$emoji_release(this.longListener);
        }
        EmojiTheming emojiTheming = this.theming;
        Emoji item = getItem(position);
        Intrinsics.checkNotNull(item);
        emojiImageView.setEmoji(emojiTheming, item, this.variantEmoji);
        return emojiImageView;
    }

    public final void updateEmojis(Collection<? extends Emoji> emojis) {
        Intrinsics.checkNotNullParameter(emojis, "emojis");
        clear();
        addAll(emojis);
        notifyDataSetChanged();
    }
}
