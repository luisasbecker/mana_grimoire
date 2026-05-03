package com.vanniktech.emoji.search;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.vanniktech.emoji.Emoji;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: SearchEmojiResult.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\t\u0010\f\u001a\u00020\u0007HÆ\u0003J'\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0005HÖ\u0081\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/vanniktech/emoji/search/SearchEmojiResult;", "", "emoji", "Lcom/vanniktech/emoji/Emoji;", "shortcode", "", "range", "Lkotlin/ranges/IntRange;", "<init>", "(Lcom/vanniktech/emoji/Emoji;Ljava/lang/String;Lkotlin/ranges/IntRange;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class SearchEmojiResult {
    public final Emoji emoji;
    public final IntRange range;
    public final String shortcode;

    public SearchEmojiResult(Emoji emoji, String shortcode, IntRange range) {
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        Intrinsics.checkNotNullParameter(shortcode, "shortcode");
        Intrinsics.checkNotNullParameter(range, "range");
        this.emoji = emoji;
        this.shortcode = shortcode;
        this.range = range;
        int length = shortcode.length();
        int first = range.getFirst();
        if (first < 0 || first >= length) {
            throw new IllegalArgumentException(("Index " + range.getFirst() + " is out of bounds in " + shortcode).toString());
        }
        int length2 = shortcode.length();
        int last = range.getLast();
        if (last < 0 || last >= length2) {
            throw new IllegalArgumentException(("Index " + range.getLast() + " is out of bounds in " + shortcode).toString());
        }
    }

    public static /* synthetic */ SearchEmojiResult copy$default(SearchEmojiResult searchEmojiResult, Emoji emoji, String str, IntRange intRange, int i, Object obj) {
        if ((i & 1) != 0) {
            emoji = searchEmojiResult.emoji;
        }
        if ((i & 2) != 0) {
            str = searchEmojiResult.shortcode;
        }
        if ((i & 4) != 0) {
            intRange = searchEmojiResult.range;
        }
        return searchEmojiResult.copy(emoji, str, intRange);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Emoji getEmoji() {
        return this.emoji;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getShortcode() {
        return this.shortcode;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final IntRange getRange() {
        return this.range;
    }

    public final SearchEmojiResult copy(Emoji emoji, String shortcode, IntRange range) {
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        Intrinsics.checkNotNullParameter(shortcode, "shortcode");
        Intrinsics.checkNotNullParameter(range, "range");
        return new SearchEmojiResult(emoji, shortcode, range);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchEmojiResult)) {
            return false;
        }
        SearchEmojiResult searchEmojiResult = (SearchEmojiResult) other;
        return Intrinsics.areEqual(this.emoji, searchEmojiResult.emoji) && Intrinsics.areEqual(this.shortcode, searchEmojiResult.shortcode) && Intrinsics.areEqual(this.range, searchEmojiResult.range);
    }

    public int hashCode() {
        return (((this.emoji.hashCode() * 31) + this.shortcode.hashCode()) * 31) + this.range.hashCode();
    }

    public String toString() {
        return "SearchEmojiResult(emoji=" + this.emoji + ", shortcode=" + this.shortcode + ", range=" + this.range + ")";
    }
}
