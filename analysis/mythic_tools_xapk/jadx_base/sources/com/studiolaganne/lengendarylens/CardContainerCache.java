package com.studiolaganne.lengendarylens;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CardContainerCache.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010%\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\u0014\u001a\u00020\u0005J\u001c\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0018\u001a\u00020\u0005J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001a\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\u0007J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001d\u001a\u00020\u0005J\u0016\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\rJ\u0016\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0018\u001a\u00020\u0005J\u0010\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u0014\u001a\u00020\u0005J\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050#J\u000e\u0010$\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0005J\u000e\u0010%\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0005J\u0006\u0010&\u001a\u00020\u0005J\u0006\u0010'\u001a\u00020\u0016J\u0006\u0010(\u001a\u00020\u0005J\u0006\u0010)\u001a\u00020\u0016J\u0006\u0010*\u001a\u00020\u0005J\u0006\u0010+\u001a\u00020\u0016J\u000e\u0010,\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0005J\u0006\u0010-\u001a\u00020\u0016J\u0006\u0010.\u001a\u00020\u0016J\b\u0010/\u001a\u00020\u0016H\u0002J\u0006\u00100\u001a\u000201R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/studiolaganne/lengendarylens/CardContainerCache;", "", "<init>", "()V", "MAX_CACHE_SIZE", "", "DEFAULT_MAX_AGE_MS", "", "previewCards", "", "", "Lcom/studiolaganne/lengendarylens/MTFullCard;", "cachedContainers", "Lcom/studiolaganne/lengendarylens/CacheKey;", "Lcom/studiolaganne/lengendarylens/CachedContainer;", "containerVersions", "collectionVersion", "listsVersion", "decksVersion", "getCardsForContainer", "withId", "set", "", "cards", "forContainerWithId", "getIfValid", SubscriberAttributeKt.JSON_NAME_KEY, "maxAgeMs", "getLatestForContainer", "containerId", "setCachedContainer", "container", "Lcom/studiolaganne/lengendarylens/MTCardContainer;", "getCachedContainer", "getAllContainerIds", "", "getContainerVersion", "incrementContainerVersion", "getCollectionVersion", "incrementCollectionVersion", "getListsVersion", "incrementListsVersion", "getDecksVersion", "incrementDecksVersion", "invalidate", "invalidateAll", "clearCache", "evictIfNeeded", "getCacheStats", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CardContainerCache {
    private static final long DEFAULT_MAX_AGE_MS = 300000;
    private static final int MAX_CACHE_SIZE = 50;
    private static volatile int collectionVersion;
    private static volatile int decksVersion;
    private static volatile int listsVersion;
    public static final CardContainerCache INSTANCE = new CardContainerCache();
    private static final Map<Integer, List<MTFullCard>> previewCards = new ConcurrentHashMap();
    private static final Map<CacheKey, CachedContainer> cachedContainers = new ConcurrentHashMap();
    private static final Map<Integer, Integer> containerVersions = new ConcurrentHashMap();
    public static final int $stable = 8;

    private CardContainerCache() {
    }

    private final void evictIfNeeded() {
        Map<CacheKey, CachedContainer> map = cachedContainers;
        if (map.size() > 50) {
            Iterator it = CollectionsKt.take(CollectionsKt.sortedWith(map.entrySet(), new Comparator() { // from class: com.studiolaganne.lengendarylens.CardContainerCache$evictIfNeeded$$inlined$sortedBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Long.valueOf(((CachedContainer) ((Map.Entry) t).getValue()).getTimestamp()), Long.valueOf(((CachedContainer) ((Map.Entry) t2).getValue()).getTimestamp()));
                }
            }), map.size() - 40).iterator();
            while (it.hasNext()) {
                cachedContainers.remove(((Map.Entry) it.next()).getKey());
            }
        }
    }

    public static /* synthetic */ CachedContainer getIfValid$default(CardContainerCache cardContainerCache, CacheKey cacheKey, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 300000;
        }
        return cardContainerCache.getIfValid(cacheKey, j);
    }

    public final void clearCache() {
        previewCards.clear();
        cachedContainers.clear();
        containerVersions.clear();
        collectionVersion = 0;
        listsVersion = 0;
        decksVersion = 0;
    }

    public final Set<Integer> getAllContainerIds() {
        Collection<CachedContainer> collectionValues = cachedContainers.values();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collectionValues, 10));
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((CachedContainer) it.next()).getKey().getContainerId()));
        }
        return CollectionsKt.toSet(arrayList);
    }

    public final String getCacheStats() {
        return "CardContainerCache: " + cachedContainers.size() + " containers, " + previewCards.size() + " previews, versions(collection=" + collectionVersion + ", lists=" + listsVersion + ", decks=" + decksVersion + ")";
    }

    public final MTCardContainer getCachedContainer(int withId) {
        CachedContainer latestForContainer = getLatestForContainer(withId);
        if (latestForContainer != null) {
            return latestForContainer.getContainer();
        }
        return null;
    }

    public final List<MTFullCard> getCardsForContainer(int withId) {
        return previewCards.get(Integer.valueOf(withId));
    }

    public final int getCollectionVersion() {
        return collectionVersion;
    }

    public final int getContainerVersion(int containerId) {
        Integer num = containerVersions.get(Integer.valueOf(containerId));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public final int getDecksVersion() {
        return decksVersion;
    }

    public final CachedContainer getIfValid(CacheKey key, long maxAgeMs) {
        Intrinsics.checkNotNullParameter(key, "key");
        CachedContainer cachedContainer = cachedContainers.get(key);
        if (cachedContainer == null) {
            return null;
        }
        Integer num = containerVersions.get(Integer.valueOf(key.getContainerId()));
        if (cachedContainer.getVersion() >= (num != null ? num.intValue() : 0) && System.currentTimeMillis() - cachedContainer.getTimestamp() <= maxAgeMs) {
            return cachedContainer;
        }
        return null;
    }

    public final CachedContainer getLatestForContainer(int containerId) {
        Object obj;
        Collection<CachedContainer> collectionValues = cachedContainers.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : collectionValues) {
            if (((CachedContainer) obj2).getKey().getContainerId() == containerId) {
                arrayList.add(obj2);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                long timestamp = ((CachedContainer) next).getTimestamp();
                do {
                    Object next2 = it.next();
                    long timestamp2 = ((CachedContainer) next2).getTimestamp();
                    if (timestamp < timestamp2) {
                        next = next2;
                        timestamp = timestamp2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        return (CachedContainer) obj;
    }

    public final int getListsVersion() {
        return listsVersion;
    }

    public final void incrementCollectionVersion() {
        collectionVersion++;
    }

    public final void incrementContainerVersion(int containerId) {
        Map<Integer, Integer> map = containerVersions;
        Integer numValueOf = Integer.valueOf(containerId);
        Integer num = map.get(Integer.valueOf(containerId));
        map.put(numValueOf, Integer.valueOf((num != null ? num.intValue() : 0) + 1));
    }

    public final void incrementDecksVersion() {
        decksVersion++;
    }

    public final void incrementListsVersion() {
        listsVersion++;
    }

    public final void invalidate(int containerId) {
        incrementContainerVersion(containerId);
    }

    public final void invalidateAll() {
        collectionVersion++;
        listsVersion++;
        decksVersion++;
        containerVersions.clear();
        cachedContainers.clear();
    }

    public final void set(List<MTFullCard> cards, int forContainerWithId) {
        Intrinsics.checkNotNullParameter(cards, "cards");
        previewCards.put(Integer.valueOf(forContainerWithId), cards);
    }

    public final void setCachedContainer(MTCardContainer container, int forContainerWithId) {
        Intrinsics.checkNotNullParameter(container, "container");
        setCachedContainer(container, new CacheKey(forContainerWithId, null, null, null, null, null, 0, 126, null));
    }

    public final void setCachedContainer(MTCardContainer container, CacheKey key) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(key, "key");
        Integer num = containerVersions.get(Integer.valueOf(key.getContainerId()));
        cachedContainers.put(key, new CachedContainer(container, key, System.currentTimeMillis(), num != null ? num.intValue() : 0));
        evictIfNeeded();
    }
}
