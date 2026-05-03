package com.vanniktech.emoji;

import android.content.Context;
import android.text.Spannable;
import kotlin.Metadata;

/* JADX INFO: compiled from: EmojiReplacer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0000H&¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/vanniktech/emoji/EmojiReplacer;", "", "replaceWithImages", "", "context", "Landroid/content/Context;", "text", "Landroid/text/Spannable;", "emojiSize", "", "fallback", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface EmojiReplacer {
    void replaceWithImages(Context context, Spannable text, float emojiSize, EmojiReplacer fallback);
}
