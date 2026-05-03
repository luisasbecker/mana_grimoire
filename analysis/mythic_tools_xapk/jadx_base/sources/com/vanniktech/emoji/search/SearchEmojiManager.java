package com.vanniktech.emoji.search;

import com.google.android.gms.actions.SearchIntents;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.vanniktech.emoji.Emoji;
import com.vanniktech.emoji.EmojiCategory;
import com.vanniktech.emoji.EmojiManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SearchEmojiManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/vanniktech/emoji/search/SearchEmojiManager;", "Lcom/vanniktech/emoji/search/SearchEmoji;", "<init>", "()V", FirebaseAnalytics.Event.SEARCH, "", "Lcom/vanniktech/emoji/search/SearchEmojiResult;", SearchIntents.EXTRA_QUERY, "", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SearchEmojiManager implements SearchEmoji {
    static final Comparable search$lambda$2(SearchEmojiResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Integer.valueOf(it.range.getFirst());
    }

    static final Comparable search$lambda$3(SearchEmojiResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.shortcode;
    }

    @Override // com.vanniktech.emoji.search.SearchEmoji
    public List<SearchEmojiResult> search(String query) {
        SearchEmojiResult searchEmojiResult;
        Intrinsics.checkNotNullParameter(query, "query");
        EmojiCategory[] emojiCategoryArrCategories$emoji_release = EmojiManager.INSTANCE.categories$emoji_release();
        String string = StringsKt.trim((CharSequence) query).toString();
        if (string.length() <= 1) {
            return CollectionsKt.emptyList();
        }
        ArrayList<Emoji> arrayList = new ArrayList();
        for (EmojiCategory emojiCategory : emojiCategoryArrCategories$emoji_release) {
            CollectionsKt.addAll(arrayList, CollectionsKt.toList(emojiCategory.getEmojis()));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Emoji emoji : arrayList) {
            Iterator<T> it = emoji.getShortcodes().iterator();
            do {
                searchEmojiResult = null;
                if (!it.hasNext()) {
                    break;
                }
                String str = (String) it.next();
                int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, string, 0, true, 2, (Object) null);
                if (iIndexOf$default >= 0) {
                    searchEmojiResult = new SearchEmojiResult(emoji, str, RangesKt.until(iIndexOf$default, string.length() + iIndexOf$default));
                }
            } while (searchEmojiResult == null);
            if (searchEmojiResult != null) {
                arrayList2.add(searchEmojiResult);
            }
        }
        return CollectionsKt.sortedWith(arrayList2, ComparisonsKt.compareBy(new Function1() { // from class: com.vanniktech.emoji.search.SearchEmojiManager$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SearchEmojiManager.search$lambda$2((SearchEmojiResult) obj);
            }
        }, new Function1() { // from class: com.vanniktech.emoji.search.SearchEmojiManager$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SearchEmojiManager.search$lambda$3((SearchEmojiResult) obj);
            }
        }));
    }
}
