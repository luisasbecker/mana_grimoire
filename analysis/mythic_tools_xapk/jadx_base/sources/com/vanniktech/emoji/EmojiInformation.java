package com.vanniktech.emoji;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EmojiInformation.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J2\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÀ\u0001¢\u0006\u0002\b\u0012J\u0014\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/vanniktech/emoji/EmojiInformation;", "", "visualLength", "", "isOnlyEmojis", "", "emojiRanges", "", "Lcom/vanniktech/emoji/EmojiRange;", "<init>", "(IZLjava/util/List;)V", "emojiCount", "getEmojiCount", "()I", "component1", "component2", "component3", "copy", "copy$emoji_release", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class EmojiInformation {
    private final int emojiCount;
    public final List<EmojiRange> emojiRanges;
    public final boolean isOnlyEmojis;
    public final int visualLength;

    public EmojiInformation(int i, boolean z, List<EmojiRange> emojiRanges) {
        Intrinsics.checkNotNullParameter(emojiRanges, "emojiRanges");
        this.visualLength = i;
        this.isOnlyEmojis = z;
        this.emojiRanges = emojiRanges;
        this.emojiCount = emojiRanges.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EmojiInformation copy$emoji_release$default(EmojiInformation emojiInformation, int i, boolean z, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = emojiInformation.visualLength;
        }
        if ((i2 & 2) != 0) {
            z = emojiInformation.isOnlyEmojis;
        }
        if ((i2 & 4) != 0) {
            list = emojiInformation.emojiRanges;
        }
        return emojiInformation.copy$emoji_release(i, z, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getVisualLength() {
        return this.visualLength;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsOnlyEmojis() {
        return this.isOnlyEmojis;
    }

    public final List<EmojiRange> component3() {
        return this.emojiRanges;
    }

    public final EmojiInformation copy$emoji_release(int visualLength, boolean isOnlyEmojis, List<EmojiRange> emojiRanges) {
        Intrinsics.checkNotNullParameter(emojiRanges, "emojiRanges");
        return new EmojiInformation(visualLength, isOnlyEmojis, emojiRanges);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmojiInformation)) {
            return false;
        }
        EmojiInformation emojiInformation = (EmojiInformation) other;
        return this.visualLength == emojiInformation.visualLength && this.isOnlyEmojis == emojiInformation.isOnlyEmojis && Intrinsics.areEqual(this.emojiRanges, emojiInformation.emojiRanges);
    }

    public final int getEmojiCount() {
        return this.emojiCount;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.visualLength) * 31) + Boolean.hashCode(this.isOnlyEmojis)) * 31) + this.emojiRanges.hashCode();
    }

    public String toString() {
        return "EmojiInformation(visualLength=" + this.visualLength + ", isOnlyEmojis=" + this.isOnlyEmojis + ", emojiRanges=" + this.emojiRanges + ")";
    }
}
