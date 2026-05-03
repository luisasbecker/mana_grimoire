package com.vanniktech.emoji;

import android.content.Context;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;

/* JADX INFO: compiled from: EmojiAndroidProvider.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/vanniktech/emoji/EmojiAndroidProvider;", "Lcom/vanniktech/emoji/EmojiProvider;", "getIcon", "", "emojiCategory", "Lcom/vanniktech/emoji/EmojiCategory;", "getDrawable", "Landroid/graphics/drawable/Drawable;", "emoji", "Lcom/vanniktech/emoji/Emoji;", "context", "Landroid/content/Context;", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface EmojiAndroidProvider extends EmojiProvider {
    Drawable getDrawable(Emoji emoji, Context context);

    int getIcon(EmojiCategory emojiCategory);
}
