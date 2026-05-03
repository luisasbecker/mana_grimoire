package com.vanniktech.emoji;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Emojis.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0000\u001a\u000e\u0010\u0007\u001a\u00020\u0005*\u0004\u0018\u00010\bH\u0007\u001a\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n*\u0004\u0018\u00010\bH\u0007\u001a\u000e\u0010\f\u001a\u00020\r*\u0004\u0018\u00010\bH\u0007\u001a\n\u0010\u000e\u001a\u00020\u000f*\u00020\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"SPACE_REMOVAL", "Lkotlin/text/Regex;", "VARIANT_SELECTOR_16", "", "isVariantSelector16", "", "Lcom/vanniktech/emoji/Emoji;", "isOnlyEmojis", "", "emojis", "", "Lcom/vanniktech/emoji/EmojiRange;", "emojisCount", "", "emojiInformation", "Lcom/vanniktech/emoji/EmojiInformation;", "emoji_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class Emojis {
    private static final Regex SPACE_REMOVAL = new Regex("[\\s]");
    public static final char VARIANT_SELECTOR_16 = 65039;

    public static final EmojiInformation emojiInformation(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        List<EmojiRange> listFindAllEmojis$emoji_release = EmojiManager.INSTANCE.findAllEmojis$emoji_release(charSequence);
        int length = charSequence.length();
        List<EmojiRange> list = listFindAllEmojis$emoji_release;
        boolean z = false;
        int last = 0;
        for (EmojiRange emojiRange : list) {
            last += (emojiRange.range.getLast() + 1) - emojiRange.range.getFirst();
        }
        int size = (length - last) + listFindAllEmojis$emoji_release.size();
        if (!StringsKt.isBlank(charSequence)) {
            Iterator it = CollectionsKt.reversed(list).iterator();
            while (it.hasNext()) {
                charSequence = StringsKt.removeRange(charSequence, ((EmojiRange) it.next()).range);
            }
            if (StringsKt.isBlank(charSequence)) {
                z = true;
            }
        }
        return new EmojiInformation(size, z, listFindAllEmojis$emoji_release);
    }

    @Deprecated(message = "Please use emojiInformation() function", replaceWith = @ReplaceWith(expression = "this.emojiInformation().emojiRanges", imports = {}))
    public static final List<EmojiRange> emojis(CharSequence charSequence) {
        return EmojiManager.INSTANCE.findAllEmojis$emoji_release(charSequence);
    }

    @Deprecated(message = "Please use emojiInformation() function", replaceWith = @ReplaceWith(expression = "this.emojiInformation().emojiCount", imports = {}))
    public static final int emojisCount(CharSequence charSequence) {
        return EmojiManager.INSTANCE.findAllEmojis$emoji_release(charSequence).size();
    }

    @Deprecated(message = "Please use emojiInformation() function", replaceWith = @ReplaceWith(expression = "this.emojiInformation().isOnlyEmojis", imports = {}))
    public static final boolean isOnlyEmojis(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() != 0) {
            String strReplace = SPACE_REMOVAL.replace(charSequence, "");
            Regex emojiPattern$emoji_release = EmojiManager.INSTANCE.getEmojiPattern$emoji_release();
            Intrinsics.checkNotNull(emojiPattern$emoji_release);
            Iterator it = CollectionsKt.reversed(SequencesKt.toList(SequencesKt.map(Regex.findAll$default(emojiPattern$emoji_release, strReplace, 0, 2, null), new Function1() { // from class: com.vanniktech.emoji.Emojis$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Emojis.isOnlyEmojis$lambda$0((MatchResult) obj);
                }
            }))).iterator();
            while (it.hasNext()) {
                strReplace = StringsKt.removeRange((CharSequence) strReplace, (IntRange) it.next()).toString();
            }
            if (strReplace.length() == 0) {
                return true;
            }
        }
        return false;
    }

    static final IntRange isOnlyEmojis$lambda$0(MatchResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getRange();
    }

    public static final boolean isVariantSelector16(Emoji emoji) {
        Intrinsics.checkNotNullParameter(emoji, "<this>");
        if (emoji.getVariants().isEmpty()) {
            return false;
        }
        List<Emoji> variants = emoji.getVariants();
        if ((variants instanceof Collection) && variants.isEmpty()) {
            return true;
        }
        Iterator<T> it = variants.iterator();
        while (it.hasNext()) {
            if (!Intrinsics.areEqual(((Emoji) it.next()).getUnicode(), emoji.getUnicode() + "️")) {
                return false;
            }
        }
        return true;
    }
}
