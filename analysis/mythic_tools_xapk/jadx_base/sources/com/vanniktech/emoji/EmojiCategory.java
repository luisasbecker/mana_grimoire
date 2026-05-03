package com.vanniktech.emoji;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: EmojiCategory.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/vanniktech/emoji/EmojiCategory;", "", "emojis", "", "Lcom/vanniktech/emoji/Emoji;", "getEmojis", "()Ljava/util/List;", "categoryNames", "", "", "getCategoryNames", "()Ljava/util/Map;", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface EmojiCategory {
    Map<String, String> getCategoryNames();

    List<Emoji> getEmojis();
}
