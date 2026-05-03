package com.vanniktech.emoji.search;

import com.google.android.gms.actions.SearchIntents;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchEmoji.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/vanniktech/emoji/search/SearchEmoji;", "", FirebaseAnalytics.Event.SEARCH, "", "Lcom/vanniktech/emoji/search/SearchEmojiResult;", SearchIntents.EXTRA_QUERY, "", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface SearchEmoji {
    List<SearchEmojiResult> search(String query);
}
