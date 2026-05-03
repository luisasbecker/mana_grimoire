package com.vanniktech.emoji.internal;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.vanniktech.emoji.EmojiTextView;
import com.vanniktech.emoji.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EmojiSearchDialog.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/vanniktech/emoji/internal/EmojiViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "textView", "Lcom/vanniktech/emoji/EmojiTextView;", "getTextView", "()Lcom/vanniktech/emoji/EmojiTextView;", "textView$delegate", "Lkotlin/Lazy;", "shortCodes", "Landroid/widget/TextView;", "getShortCodes", "()Landroid/widget/TextView;", "shortCodes$delegate", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class EmojiViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: shortCodes$delegate, reason: from kotlin metadata */
    private final Lazy shortCodes;

    /* JADX INFO: renamed from: textView$delegate, reason: from kotlin metadata */
    private final Lazy textView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiViewHolder(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.emoji_adapter_item_emoji_search, parent, false));
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.textView = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0() { // from class: com.vanniktech.emoji.internal.EmojiViewHolder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EmojiViewHolder.textView_delegate$lambda$0(this.f$0);
            }
        });
        this.shortCodes = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0() { // from class: com.vanniktech.emoji.internal.EmojiViewHolder$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EmojiViewHolder.shortCodes_delegate$lambda$0(this.f$0);
            }
        });
    }

    static final TextView shortCodes_delegate$lambda$0(EmojiViewHolder emojiViewHolder) {
        return (TextView) emojiViewHolder.itemView.findViewById(R.id.shortCodes);
    }

    static final EmojiTextView textView_delegate$lambda$0(EmojiViewHolder emojiViewHolder) {
        return (EmojiTextView) emojiViewHolder.itemView.findViewById(R.id.textView);
    }

    public final TextView getShortCodes() {
        Object value = this.shortCodes.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (TextView) value;
    }

    public final EmojiTextView getTextView() {
        Object value = this.textView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (EmojiTextView) value;
    }
}
