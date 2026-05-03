package com.vanniktech.emoji;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: EmojiRange.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\t\u0010\t\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/vanniktech/emoji/EmojiRange;", "", "emoji", "Lcom/vanniktech/emoji/Emoji;", "range", "Lkotlin/ranges/IntRange;", "<init>", "(Lcom/vanniktech/emoji/Emoji;Lkotlin/ranges/IntRange;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class EmojiRange {
    public final Emoji emoji;
    public final IntRange range;

    public EmojiRange(Emoji emoji, IntRange range) {
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        Intrinsics.checkNotNullParameter(range, "range");
        this.emoji = emoji;
        this.range = range;
    }

    public static /* synthetic */ EmojiRange copy$default(EmojiRange emojiRange, Emoji emoji, IntRange intRange, int i, Object obj) {
        if ((i & 1) != 0) {
            emoji = emojiRange.emoji;
        }
        if ((i & 2) != 0) {
            intRange = emojiRange.range;
        }
        return emojiRange.copy(emoji, intRange);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Emoji getEmoji() {
        return this.emoji;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final IntRange getRange() {
        return this.range;
    }

    public final EmojiRange copy(Emoji emoji, IntRange range) {
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        Intrinsics.checkNotNullParameter(range, "range");
        return new EmojiRange(emoji, range);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmojiRange)) {
            return false;
        }
        EmojiRange emojiRange = (EmojiRange) other;
        return Intrinsics.areEqual(this.emoji, emojiRange.emoji) && Intrinsics.areEqual(this.range, emojiRange.range);
    }

    public int hashCode() {
        return (this.emoji.hashCode() * 31) + this.range.hashCode();
    }

    public String toString() {
        return "EmojiRange(emoji=" + this.emoji + ", range=" + this.range + ")";
    }
}
