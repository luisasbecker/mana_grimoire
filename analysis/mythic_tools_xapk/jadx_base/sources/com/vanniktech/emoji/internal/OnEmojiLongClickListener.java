package com.vanniktech.emoji.internal;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.vanniktech.emoji.Emoji;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: OnEmojiLongClickListener.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\bà\u0080\u0001\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tH&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/vanniktech/emoji/internal/OnEmojiLongClickListener;", "", "onEmojiLongClick", "", ViewHierarchyConstants.VIEW_KEY, "Lcom/vanniktech/emoji/internal/EmojiImageView;", "emoji", "Lcom/vanniktech/emoji/Emoji;", "variants", "", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface OnEmojiLongClickListener {
    void onEmojiLongClick(EmojiImageView view, Emoji emoji, List<? extends Emoji> variants);
}
