package com.vanniktech.emoji.recent;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.vanniktech.emoji.Emoji;
import com.vanniktech.emoji.EmojiManager;
import com.vanniktech.emoji.recent.RecentEmojiManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: RecentEmojiManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0003\u0014\u0015\u0016B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/vanniktech/emoji/recent/RecentEmojiManager;", "Lcom/vanniktech/emoji/recent/RecentEmoji;", "context", "Landroid/content/Context;", "maxRecents", "", "<init>", "(Landroid/content/Context;I)V", "emojiList", "Lcom/vanniktech/emoji/recent/RecentEmojiManager$EmojiList;", "sharedPreferences", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getRecentEmojis", "", "Lcom/vanniktech/emoji/Emoji;", "addEmoji", "", "emoji", "persist", "EmojiList", "RecentEmojiData", "Companion", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RecentEmojiManager implements RecentEmoji {
    private static final String EMOJI_DELIMITER = "~";
    public static final int EMOJI_GUESS_SIZE = 5;
    private static final String PREFERENCE_NAME = "emoji-recent-manager";
    private static final String RECENT_EMOJIS = "recent-emojis";
    private static final String TIME_DELIMITER = ";";
    private EmojiList emojiList;
    private final int maxRecents;
    private final SharedPreferences sharedPreferences;

    /* JADX INFO: compiled from: RecentEmojiManager.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eJ\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0010J\u0006\u0010\u0011\u001a\u00020\u0006J\u0011\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0006H\u0086\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/vanniktech/emoji/recent/RecentEmojiManager$EmojiList;", "", "emojis", "", "Lcom/vanniktech/emoji/recent/RecentEmojiManager$RecentEmojiData;", "maxRecents", "", "<init>", "(Ljava/util/List;I)V", "add", "", "emoji", "Lcom/vanniktech/emoji/Emoji;", DiagnosticsEntry.TIMESTAMP_KEY, "", "getEmojis", "", "size", "get", FirebaseAnalytics.Param.INDEX, "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class EmojiList {
        private List<RecentEmojiData> emojis;
        private final int maxRecents;

        public EmojiList(List<RecentEmojiData> emojis, int i) {
            Intrinsics.checkNotNullParameter(emojis, "emojis");
            this.emojis = emojis;
            this.maxRecents = i;
        }

        public static /* synthetic */ void add$default(EmojiList emojiList, Emoji emoji, long j, int i, Object obj) {
            if ((i & 2) != 0) {
                j = System.currentTimeMillis();
            }
            emojiList.add(emoji, j);
        }

        public final void add(Emoji emoji, long timestamp) {
            Intrinsics.checkNotNullParameter(emoji, "emoji");
            Iterator<RecentEmojiData> it = this.emojis.iterator();
            Emoji base = emoji.getBase();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(it.next().getEmoji().getBase(), base)) {
                    it.remove();
                }
            }
            this.emojis.add(0, new RecentEmojiData(emoji, timestamp));
            int size = this.emojis.size();
            int i = this.maxRecents;
            if (size > i) {
                this.emojis.remove(i);
            }
        }

        public final RecentEmojiData get(int index) {
            return this.emojis.get(index);
        }

        public final List<Emoji> getEmojis() {
            List listSortedWith = CollectionsKt.sortedWith(this.emojis, new Comparator() { // from class: com.vanniktech.emoji.recent.RecentEmojiManager$EmojiList$getEmojis$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Long.valueOf(((RecentEmojiManager.RecentEmojiData) t2).getTimestamp()), Long.valueOf(((RecentEmojiManager.RecentEmojiData) t).getTimestamp()));
                }
            });
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSortedWith, 10));
            Iterator it = listSortedWith.iterator();
            while (it.hasNext()) {
                arrayList.add(((RecentEmojiData) it.next()).getEmoji());
            }
            return arrayList;
        }

        public final int size() {
            return this.emojis.size();
        }
    }

    /* JADX INFO: compiled from: RecentEmojiManager.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/vanniktech/emoji/recent/RecentEmojiManager$RecentEmojiData;", "", "emoji", "Lcom/vanniktech/emoji/Emoji;", DiagnosticsEntry.TIMESTAMP_KEY, "", "<init>", "(Lcom/vanniktech/emoji/Emoji;J)V", "getEmoji", "()Lcom/vanniktech/emoji/Emoji;", "getTimestamp", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class RecentEmojiData {
        private final Emoji emoji;
        private final long timestamp;

        public RecentEmojiData(Emoji emoji, long j) {
            Intrinsics.checkNotNullParameter(emoji, "emoji");
            this.emoji = emoji;
            this.timestamp = j;
        }

        public static /* synthetic */ RecentEmojiData copy$default(RecentEmojiData recentEmojiData, Emoji emoji, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                emoji = recentEmojiData.emoji;
            }
            if ((i & 2) != 0) {
                j = recentEmojiData.timestamp;
            }
            return recentEmojiData.copy(emoji, j);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Emoji getEmoji() {
            return this.emoji;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        public final RecentEmojiData copy(Emoji emoji, long timestamp) {
            Intrinsics.checkNotNullParameter(emoji, "emoji");
            return new RecentEmojiData(emoji, timestamp);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RecentEmojiData)) {
                return false;
            }
            RecentEmojiData recentEmojiData = (RecentEmojiData) other;
            return Intrinsics.areEqual(this.emoji, recentEmojiData.emoji) && this.timestamp == recentEmojiData.timestamp;
        }

        public final Emoji getEmoji() {
            return this.emoji;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public int hashCode() {
            return (this.emoji.hashCode() * 31) + Long.hashCode(this.timestamp);
        }

        public String toString() {
            return "RecentEmojiData(emoji=" + this.emoji + ", timestamp=" + this.timestamp + ")";
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecentEmojiManager(Context context) {
        this(context, 0, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public RecentEmojiManager(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.maxRecents = i;
        this.emojiList = new EmojiList(new ArrayList(), i);
        this.sharedPreferences = context.getApplicationContext().getSharedPreferences(PREFERENCE_NAME, 0);
    }

    public /* synthetic */ RecentEmojiManager(Context context, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? 40 : i);
    }

    @Override // com.vanniktech.emoji.recent.RecentEmoji
    public void addEmoji(Emoji emoji) {
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        EmojiList.add$default(this.emojiList, emoji, 0L, 2, null);
    }

    @Override // com.vanniktech.emoji.recent.RecentEmoji
    public Collection<Emoji> getRecentEmojis() {
        Emoji emojiFindEmoji$emoji_release;
        if (this.emojiList.size() == 0) {
            String string = this.sharedPreferences.getString(RECENT_EMOJIS, "");
            String str = string != null ? string : "";
            if (str.length() > 0) {
                List listSplit$default = StringsKt.split$default((CharSequence) str, new String[]{EMOJI_DELIMITER}, false, 0, 6, (Object) null);
                ArrayList arrayList = new ArrayList();
                Iterator it = listSplit$default.iterator();
                while (it.hasNext()) {
                    String[] strArr = (String[]) StringsKt.split$default((CharSequence) it.next(), new String[]{TIME_DELIMITER}, false, 0, 6, (Object) null).toArray(new String[0]);
                    RecentEmojiData recentEmojiData = null;
                    if (strArr.length == 2 && (emojiFindEmoji$emoji_release = EmojiManager.INSTANCE.findEmoji$emoji_release(strArr[0])) != null) {
                        recentEmojiData = new RecentEmojiData(emojiFindEmoji$emoji_release, Long.parseLong(strArr[1]));
                    }
                    if (recentEmojiData != null) {
                        arrayList.add(recentEmojiData);
                    }
                }
                this.emojiList = new EmojiList(CollectionsKt.toMutableList((Collection) CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.vanniktech.emoji.recent.RecentEmojiManager$getRecentEmojis$$inlined$sortedByDescending$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Long.valueOf(((RecentEmojiManager.RecentEmojiData) t2).getTimestamp()), Long.valueOf(((RecentEmojiManager.RecentEmojiData) t).getTimestamp()));
                    }
                })), this.maxRecents);
            }
        }
        return this.emojiList.getEmojis();
    }

    @Override // com.vanniktech.emoji.recent.RecentEmoji
    public void persist() {
        if (this.emojiList.size() > 0) {
            StringBuilder sb = new StringBuilder(this.emojiList.size() * 5);
            int size = this.emojiList.size();
            for (int i = 0; i < size; i++) {
                RecentEmojiData recentEmojiData = this.emojiList.get(i);
                sb.append(recentEmojiData.getEmoji().getUnicode()).append(TIME_DELIMITER).append(recentEmojiData.getTimestamp()).append(EMOJI_DELIMITER);
            }
            sb.setLength(sb.length() - 1);
            SharedPreferences sharedPreferences = this.sharedPreferences;
            Intrinsics.checkNotNullExpressionValue(sharedPreferences, "sharedPreferences");
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString(RECENT_EMOJIS, sb.toString());
            editorEdit.apply();
        }
    }
}
