package com.studiolaganne.lengendarylens;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: TagsAndThemesManager.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0014\u001a\u00020\u0015R*\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR*\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\n0\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR6\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00060\r2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00060\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R6\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n0\r2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n0\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/studiolaganne/lengendarylens/TagsAndThemesManager;", "", "<init>", "()V", "value", "", "Lcom/studiolaganne/lengendarylens/MTCardTag;", "tags", "getTags", "()Ljava/util/List;", "Lcom/studiolaganne/lengendarylens/MTDeckTheme;", "themes", "getThemes", "", "", "tagsByName", "getTagsByName", "()Ljava/util/Map;", "themesById", "getThemesById", "load", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TagsAndThemesManager {
    public static final TagsAndThemesManager INSTANCE = new TagsAndThemesManager();
    private static List<MTCardTag> tags = CollectionsKt.emptyList();
    private static List<MTDeckTheme> themes = CollectionsKt.emptyList();
    private static Map<String, MTCardTag> tagsByName = MapsKt.emptyMap();
    private static Map<String, MTDeckTheme> themesById = MapsKt.emptyMap();
    public static final int $stable = 8;

    private TagsAndThemesManager() {
    }

    public final List<MTCardTag> getTags() {
        return tags;
    }

    public final Map<String, MTCardTag> getTagsByName() {
        return tagsByName;
    }

    public final List<MTDeckTheme> getThemes() {
        return themes;
    }

    public final Map<String, MTDeckTheme> getThemesById() {
        return themesById;
    }

    public final void load() {
        try {
            DecksDBHelper companion = DecksDBHelper.INSTANCE.getInstance(LegendaryLensApplication.INSTANCE.applicationContext());
            tags = companion.getAllTags();
            themes = companion.getAllThemes();
            List<MTCardTag> list = tags;
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
            for (Object obj : list) {
                linkedHashMap.put(((MTCardTag) obj).getTagName(), obj);
            }
            tagsByName = linkedHashMap;
            List<MTDeckTheme> list2 = themes;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list2, 10)), 16));
            for (Object obj2 : list2) {
                linkedHashMap2.put(((MTDeckTheme) obj2).getThemeId(), obj2);
            }
            themesById = linkedHashMap2;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
