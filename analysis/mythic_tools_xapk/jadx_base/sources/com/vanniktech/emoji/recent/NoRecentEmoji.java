package com.vanniktech.emoji.recent;

import com.vanniktech.emoji.Emoji;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoRecentEmoji.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\bH\u0016¨\u0006\u000b"}, d2 = {"Lcom/vanniktech/emoji/recent/NoRecentEmoji;", "Lcom/vanniktech/emoji/recent/RecentEmoji;", "<init>", "()V", "getRecentEmojis", "", "Lcom/vanniktech/emoji/Emoji;", "addEmoji", "", "emoji", "persist", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NoRecentEmoji implements RecentEmoji {
    public static final NoRecentEmoji INSTANCE = new NoRecentEmoji();

    private NoRecentEmoji() {
    }

    @Override // com.vanniktech.emoji.recent.RecentEmoji
    public void addEmoji(Emoji emoji) {
        Intrinsics.checkNotNullParameter(emoji, "emoji");
    }

    @Override // com.vanniktech.emoji.recent.RecentEmoji
    public Collection<Emoji> getRecentEmojis() {
        return CollectionsKt.emptyList();
    }

    @Override // com.vanniktech.emoji.recent.RecentEmoji
    public void persist() {
    }
}
