package com.vanniktech.emoji;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;

/* JADX INFO: compiled from: EmojiManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\u001bJ\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0000¢\u0006\u0002\b!J\u0017\u0010\"\u001a\u0004\u0018\u00010\n2\u0006\u0010#\u001a\u00020 H\u0000¢\u0006\u0002\b$J\r\u0010%\u001a\u00020&H\u0000¢\u0006\u0002\b'J\u0010\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020\fH\u0007J\b\u0010*\u001a\u00020&H\u0007J\b\u0010+\u001a\u00020&H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/vanniktech/emoji/EmojiManager;", "", "<init>", "()V", "GUESSED_UNICODE_AMOUNT", "", "GUESSED_TOTAL_PATTERN_LENGTH", "emojiMap", "", "", "Lcom/vanniktech/emoji/Emoji;", "emojiProvider", "Lcom/vanniktech/emoji/EmojiProvider;", "categories", "", "Lcom/vanniktech/emoji/EmojiCategory;", "[Lcom/vanniktech/emoji/EmojiCategory;", "emojiPattern", "Lkotlin/text/Regex;", "getEmojiPattern$emoji_release", "()Lkotlin/text/Regex;", "setEmojiPattern$emoji_release", "(Lkotlin/text/Regex;)V", "LOCK", "Lcom/vanniktech/emoji/Lock;", "categories$emoji_release", "()[Lcom/vanniktech/emoji/EmojiCategory;", "emojiProvider$emoji_release", "findAllEmojis", "", "Lcom/vanniktech/emoji/EmojiRange;", "text", "", "findAllEmojis$emoji_release", "findEmoji", "candidate", "findEmoji$emoji_release", "verifyInstalled", "", "verifyInstalled$emoji_release", "install", "provider", "destroy", "release", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class EmojiManager {
    private static final int GUESSED_TOTAL_PATTERN_LENGTH = 12000;
    private static final int GUESSED_UNICODE_AMOUNT = 3000;
    private static EmojiCategory[] categories;
    private static Regex emojiPattern;
    private static EmojiProvider emojiProvider;
    public static final EmojiManager INSTANCE = new EmojiManager();
    private static final Map<String, Emoji> emojiMap = new LinkedHashMap(3000);
    private static final Lock LOCK = new Lock();

    private EmojiManager() {
    }

    @JvmStatic
    public static final void destroy() {
        Lock lock = LOCK;
        try {
            lock.lock();
            release();
            emojiMap.clear();
            emojiProvider = null;
            categories = null;
            emojiPattern = null;
            Unit unit = Unit.INSTANCE;
        } finally {
            lock.unlock();
        }
    }

    static final EmojiRange findAllEmojis$lambda$0(MatchResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Emoji emojiFindEmoji$emoji_release = INSTANCE.findEmoji$emoji_release(it.getValue());
        if (emojiFindEmoji$emoji_release != null) {
            return new EmojiRange(emojiFindEmoji$emoji_release, it.getRange());
        }
        return null;
    }

    @JvmStatic
    public static final void install(EmojiProvider provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        Lock lock = LOCK;
        try {
            lock.lock();
            categories = provider.getCategories();
            emojiProvider = provider;
            emojiMap.clear();
            ArrayList arrayList = new ArrayList(3000);
            int length = provider.getCategories().length;
            for (int i = 0; i < length; i++) {
                List<Emoji> emojis = provider.getCategories()[i].getEmojis();
                int size = emojis.size();
                for (int i2 = 0; i2 < size; i2++) {
                    Emoji emoji = emojis.get(i2);
                    String unicode = emoji.getUnicode();
                    List<Emoji> variants = emoji.getVariants();
                    emojiMap.put(unicode, emoji);
                    arrayList.add(unicode);
                    int size2 = variants.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        Emoji emoji2 = variants.get(i3);
                        String unicode2 = emoji2.getUnicode();
                        emojiMap.put(unicode2, emoji2);
                        arrayList.add(unicode2);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                throw new IllegalArgumentException("Your EmojiProvider must at least have one category with at least one emoji.".toString());
            }
            final Function2 function2 = new Function2() { // from class: com.vanniktech.emoji.EmojiManager$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Integer.valueOf(EmojiManager.install$lambda$0$1((String) obj, (String) obj2));
                }
            };
            CollectionsKt.sortWith(arrayList, new Comparator() { // from class: com.vanniktech.emoji.EmojiManager$$ExternalSyntheticLambda1
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return EmojiManager.install$lambda$0$2(function2, obj, obj2);
                }
            });
            StringBuilder sb = new StringBuilder(GUESSED_TOTAL_PATTERN_LENGTH);
            int size3 = arrayList.size();
            for (int i4 = 0; i4 < size3; i4++) {
                sb.append(Regex.INSTANCE.escape((String) arrayList.get(i4))).append('|');
            }
            StringBuilder sbDeleteCharAt = sb.deleteCharAt(sb.length() - 1);
            Intrinsics.checkNotNullExpressionValue(sbDeleteCharAt, "deleteCharAt(...)");
            String string = sbDeleteCharAt.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            emojiPattern = new Regex(string, RegexOption.IGNORE_CASE);
            Unit unit = Unit.INSTANCE;
        } finally {
            lock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int install$lambda$0$1(String str, String str2) {
        return Intrinsics.compare(str2.length(), str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int install$lambda$0$2(Function2 function2, Object obj, Object obj2) {
        return ((Number) function2.invoke(obj, obj2)).intValue();
    }

    @JvmStatic
    public static final void release() {
        Lock lock = LOCK;
        try {
            lock.lock();
            EmojiProvider emojiProvider2 = emojiProvider;
            if (emojiProvider2 != null) {
                emojiProvider2.release();
                Unit unit = Unit.INSTANCE;
            }
        } finally {
            lock.unlock();
        }
    }

    public final EmojiCategory[] categories$emoji_release() {
        verifyInstalled$emoji_release();
        EmojiCategory[] emojiCategoryArr = categories;
        Intrinsics.checkNotNull(emojiCategoryArr);
        return emojiCategoryArr;
    }

    public final EmojiProvider emojiProvider$emoji_release() {
        verifyInstalled$emoji_release();
        EmojiProvider emojiProvider2 = emojiProvider;
        Intrinsics.checkNotNull(emojiProvider2);
        return emojiProvider2;
    }

    public final List<EmojiRange> findAllEmojis$emoji_release(CharSequence text) {
        Sequence sequenceFindAll$default;
        verifyInstalled$emoji_release();
        if (text == null || text.length() == 0) {
            return CollectionsKt.emptyList();
        }
        Regex regex = emojiPattern;
        Sequence sequenceEmptySequence = null;
        if (regex != null && (sequenceFindAll$default = Regex.findAll$default(regex, text, 0, 2, null)) != null) {
            sequenceEmptySequence = SequencesKt.mapNotNull(sequenceFindAll$default, new Function1() { // from class: com.vanniktech.emoji.EmojiManager$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return EmojiManager.findAllEmojis$lambda$0((MatchResult) obj);
                }
            });
        }
        if (sequenceEmptySequence == null) {
            sequenceEmptySequence = SequencesKt.emptySequence();
        }
        return SequencesKt.toList(sequenceEmptySequence);
    }

    public final Emoji findEmoji$emoji_release(CharSequence candidate) {
        Intrinsics.checkNotNullParameter(candidate, "candidate");
        verifyInstalled$emoji_release();
        return emojiMap.get(candidate.toString());
    }

    public final Regex getEmojiPattern$emoji_release() {
        return emojiPattern;
    }

    public final void setEmojiPattern$emoji_release(Regex regex) {
        emojiPattern = regex;
    }

    public final void verifyInstalled$emoji_release() {
        if (categories == null) {
            throw new IllegalStateException("Please install an EmojiProvider through the EmojiManager.install() method first.".toString());
        }
    }
}
