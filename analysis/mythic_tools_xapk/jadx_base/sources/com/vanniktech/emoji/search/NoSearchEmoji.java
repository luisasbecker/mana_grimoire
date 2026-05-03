package com.vanniktech.emoji.search;

import com.google.android.gms.actions.SearchIntents;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoSearchEmoji.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/vanniktech/emoji/search/NoSearchEmoji;", "Lcom/vanniktech/emoji/search/SearchEmoji;", "<init>", "()V", FirebaseAnalytics.Event.SEARCH, "", "Lcom/vanniktech/emoji/search/SearchEmojiResult;", SearchIntents.EXTRA_QUERY, "", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NoSearchEmoji implements SearchEmoji {
    public static final NoSearchEmoji INSTANCE = new NoSearchEmoji();

    private NoSearchEmoji() {
    }

    @Override // com.vanniktech.emoji.search.SearchEmoji
    public List<SearchEmojiResult> search(String query) {
        Intrinsics.checkNotNullParameter(query, "query");
        return CollectionsKt.emptyList();
    }
}
