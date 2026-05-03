package com.vanniktech.emoji;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import com.vanniktech.emoji.internal.EmojiSpan;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: EmojiManagers.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b\"\u0014\u0010\t\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"replaceWithImages", "", "Lcom/vanniktech/emoji/EmojiManager;", "context", "Landroid/content/Context;", "text", "Landroid/text/Spannable;", "emojiSize", "", "defaultEmojiReplacer", "Lcom/vanniktech/emoji/EmojiReplacer;", "getDefaultEmojiReplacer", "()Lcom/vanniktech/emoji/EmojiReplacer;", "emoji_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class EmojiManagers {
    private static final EmojiReplacer defaultEmojiReplacer = new EmojiReplacer() { // from class: com.vanniktech.emoji.EmojiManagers$$ExternalSyntheticLambda0
        @Override // com.vanniktech.emoji.EmojiReplacer
        public final void replaceWithImages(Context context, Spannable spannable, float f, EmojiReplacer emojiReplacer) {
            EmojiManagers.defaultEmojiReplacer$lambda$0(context, spannable, f, emojiReplacer);
        }
    };

    static final void defaultEmojiReplacer$lambda$0(Context context, Spannable text, float f, EmojiReplacer emojiReplacer) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(text, "text");
        EmojiSpan[] emojiSpanArr = (EmojiSpan[]) text.getSpans(0, text.length(), EmojiSpan.class);
        ArrayList arrayList = new ArrayList(emojiSpanArr.length);
        for (EmojiSpan emojiSpan : emojiSpanArr) {
            arrayList.add(Integer.valueOf(text.getSpanStart(emojiSpan)));
        }
        List<EmojiRange> listFindAllEmojis$emoji_release = EmojiManager.INSTANCE.findAllEmojis$emoji_release(text);
        int size = listFindAllEmojis$emoji_release.size();
        for (int i = 0; i < size; i++) {
            EmojiRange emojiRange = listFindAllEmojis$emoji_release.get(i);
            Emoji emoji = emojiRange.getEmoji();
            IntRange range = emojiRange.getRange();
            if (!arrayList.contains(Integer.valueOf(range.getFirst()))) {
                text.setSpan(new EmojiSpan(context, emoji, f), range.getFirst(), range.getLast() + 1, 33);
            }
        }
    }

    public static final EmojiReplacer getDefaultEmojiReplacer() {
        return defaultEmojiReplacer;
    }

    public static final void replaceWithImages(EmojiManager emojiManager, Context context, Spannable spannable, float f) {
        Intrinsics.checkNotNullParameter(emojiManager, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        EmojiProvider emojiProviderEmojiProvider$emoji_release = emojiManager.emojiProvider$emoji_release();
        EmojiReplacer emojiReplacer = emojiProviderEmojiProvider$emoji_release instanceof EmojiReplacer ? (EmojiReplacer) emojiProviderEmojiProvider$emoji_release : null;
        if (emojiReplacer == null) {
            emojiReplacer = defaultEmojiReplacer;
        }
        if (spannable == null) {
            spannable = new SpannableStringBuilder("");
        }
        emojiReplacer.replaceWithImages(context, spannable, f, defaultEmojiReplacer);
    }
}
