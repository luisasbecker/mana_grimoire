package com.vanniktech.emoji;

import kotlin.Metadata;

/* JADX INFO: compiled from: EmojiDisplayable.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0012\u0010\n\u001a\u00020\u00052\b\b\u0001\u0010\u000b\u001a\u00020\u0007H&J\u001a\u0010\n\u001a\u00020\u00052\b\b\u0001\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/vanniktech/emoji/EmojiDisplayable;", "", "getEmojiSize", "", "setEmojiSize", "", "pixels", "", "shouldInvalidate", "", "setEmojiSizeRes", "res", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface EmojiDisplayable {
    float getEmojiSize();

    void setEmojiSize(int pixels);

    void setEmojiSize(int pixels, boolean shouldInvalidate);

    void setEmojiSizeRes(int res);

    void setEmojiSizeRes(int res, boolean shouldInvalidate);
}
