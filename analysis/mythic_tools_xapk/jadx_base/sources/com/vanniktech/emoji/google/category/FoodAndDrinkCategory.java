package com.vanniktech.emoji.google.category;

import com.google.mlkit.vision.objects.defaults.PredefinedCategory;
import com.vanniktech.emoji.EmojiCategory;
import com.vanniktech.emoji.google.GoogleEmoji;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FoodAndDrinkCategory.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/vanniktech/emoji/google/category/FoodAndDrinkCategory;", "Lcom/vanniktech/emoji/EmojiCategory;", "<init>", "()V", "categoryNames", "", "", "getCategoryNames", "()Ljava/util/Map;", "emojis", "", "Lcom/vanniktech/emoji/google/GoogleEmoji;", "getEmojis", "()Ljava/util/List;", "Companion", "emoji-google_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FoodAndDrinkCategory implements EmojiCategory {
    private final List<GoogleEmoji> emojis = ALL_EMOJIS;
    private static final Companion Companion = new Companion(null);
    private static final List<GoogleEmoji> ALL_EMOJIS = CollectionsKt.plus((Collection) FoodAndDrinkCategoryChunk0.INSTANCE.getEMOJIS$emoji_google_release(), (Iterable) FoodAndDrinkCategoryChunk1.INSTANCE.getEMOJIS$emoji_google_release());

    /* JADX INFO: compiled from: FoodAndDrinkCategory.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/vanniktech/emoji/google/category/FoodAndDrinkCategory$Companion;", "", "<init>", "()V", "ALL_EMOJIS", "", "Lcom/vanniktech/emoji/google/GoogleEmoji;", "getALL_EMOJIS", "()Ljava/util/List;", "emoji-google_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List<GoogleEmoji> getALL_EMOJIS() {
            return FoodAndDrinkCategory.ALL_EMOJIS;
        }
    }

    @Override // com.vanniktech.emoji.EmojiCategory
    public Map<String, String> getCategoryNames() {
        return MapsKt.mapOf(TuplesKt.to("en", PredefinedCategory.FOOD), TuplesKt.to("de", "Essen"));
    }

    @Override // com.vanniktech.emoji.EmojiCategory
    public List<GoogleEmoji> getEmojis() {
        return this.emojis;
    }
}
