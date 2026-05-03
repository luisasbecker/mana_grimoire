package com.revenuecat.purchases.subscriberattributes.caching;

import android.content.SharedPreferences;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttribute;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributesFactoriesKt;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.apache.commons.io.FilenameUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: SubscriberAttributesMigrationExtensions.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a0\u0010\u0000\u001a&\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0001j\u0002`\u00050\u0001j\u0002`\u0006*\u00020\u0007H\u0000\u001a\u0014\u0010\b\u001a\u00020\u0002*\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0000\u001a@\u0010\n\u001a\u00020\u000b*\u00020\u00072*\u0010\f\u001a&\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0001j\u0002`\u00050\u0001j\u0002`\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0000\u001a\u0014\u0010\u000f\u001a\u00020\u000b*\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0000¨\u0006\u0010"}, d2 = {"getAllLegacyStoredSubscriberAttributes", "", "", "Lcom/revenuecat/purchases/subscriberattributes/caching/AppUserID;", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttribute;", "Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributeMap;", "Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributesPerAppUserIDMap;", "Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributesCache;", "legacySubscriberAttributesCacheKey", "appUserID", "migrateSubscriberAttributes", "", "legacySubscriberAttributesForAppUserID", "cacheEditor", "Landroid/content/SharedPreferences$Editor;", "migrateSubscriberAttributesIfNeeded", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SubscriberAttributesMigrationExtensionsKt {
    public static final synchronized Map<String, Map<String, SubscriberAttribute>> getAllLegacyStoredSubscriberAttributes(SubscriberAttributesCache subscriberAttributesCache) {
        LinkedHashMap linkedHashMap;
        Map<String, SubscriberAttribute> mapEmptyMap;
        Intrinsics.checkNotNullParameter(subscriberAttributesCache, "<this>");
        String strLegacySubscriberAttributesCacheKey = legacySubscriberAttributesCacheKey(subscriberAttributesCache, "");
        Set<String> setFindKeysThatStartWith$purchases_defaultsBc8Release = subscriberAttributesCache.getDeviceCache().findKeysThatStartWith$purchases_defaultsBc8Release(strLegacySubscriberAttributesCacheKey);
        linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setFindKeysThatStartWith$purchases_defaultsBc8Release, 10)), 16));
        for (String str : setFindKeysThatStartWith$purchases_defaultsBc8Release) {
            String str2 = (String) StringsKt.split$default((CharSequence) str, new String[]{strLegacySubscriberAttributesCacheKey}, false, 0, 6, (Object) null).get(1);
            JSONObject jSONObjectOrNull$purchases_defaultsBc8Release = subscriberAttributesCache.getDeviceCache().getJSONObjectOrNull$purchases_defaultsBc8Release(str);
            if (jSONObjectOrNull$purchases_defaultsBc8Release == null || (mapEmptyMap = SubscriberAttributesFactoriesKt.buildLegacySubscriberAttributes(jSONObjectOrNull$purchases_defaultsBc8Release)) == null) {
                mapEmptyMap = MapsKt.emptyMap();
            }
            Pair pair = TuplesKt.to(str2, mapEmptyMap);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    public static final String legacySubscriberAttributesCacheKey(SubscriberAttributesCache subscriberAttributesCache, String appUserID) {
        Intrinsics.checkNotNullParameter(subscriberAttributesCache, "<this>");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        return subscriberAttributesCache.getSubscriberAttributesCacheKey$purchases_defaultsBc8Release() + FilenameUtils.EXTENSION_SEPARATOR + appUserID;
    }

    public static final synchronized void migrateSubscriberAttributes(SubscriberAttributesCache subscriberAttributesCache, Map<String, ? extends Map<String, SubscriberAttribute>> legacySubscriberAttributesForAppUserID, SharedPreferences.Editor cacheEditor) {
        Intrinsics.checkNotNullParameter(subscriberAttributesCache, "<this>");
        Intrinsics.checkNotNullParameter(legacySubscriberAttributesForAppUserID, "legacySubscriberAttributesForAppUserID");
        Intrinsics.checkNotNullParameter(cacheEditor, "cacheEditor");
        Map<String, Map<String, SubscriberAttribute>> allStoredSubscriberAttributes = subscriberAttributesCache.getAllStoredSubscriberAttributes();
        Map mutableMap = MapsKt.toMutableMap(allStoredSubscriberAttributes);
        for (Map.Entry<String, ? extends Map<String, SubscriberAttribute>> entry : legacySubscriberAttributesForAppUserID.entrySet()) {
            String key = entry.getKey();
            Map<String, SubscriberAttribute> value = entry.getValue();
            Map<String, SubscriberAttribute> mapEmptyMap = allStoredSubscriberAttributes.get(key);
            if (mapEmptyMap == null) {
                mapEmptyMap = MapsKt.emptyMap();
            }
            mutableMap.put(key, MapsKt.plus(value, mapEmptyMap));
            cacheEditor.remove(legacySubscriberAttributesCacheKey(subscriberAttributesCache, key));
        }
        cacheEditor.putString(subscriberAttributesCache.getSubscriberAttributesCacheKey$purchases_defaultsBc8Release(), CachingHelpersKt.toJSONObject(mutableMap).toString());
    }

    public static final synchronized void migrateSubscriberAttributesIfNeeded(SubscriberAttributesCache subscriberAttributesCache, SharedPreferences.Editor cacheEditor) {
        Intrinsics.checkNotNullParameter(subscriberAttributesCache, "<this>");
        Intrinsics.checkNotNullParameter(cacheEditor, "cacheEditor");
        Map<String, Map<String, SubscriberAttribute>> allLegacyStoredSubscriberAttributes = getAllLegacyStoredSubscriberAttributes(subscriberAttributesCache);
        if (allLegacyStoredSubscriberAttributes.isEmpty()) {
            allLegacyStoredSubscriberAttributes = null;
        }
        if (allLegacyStoredSubscriberAttributes != null) {
            migrateSubscriberAttributes(subscriberAttributesCache, allLegacyStoredSubscriberAttributes, cacheEditor);
        }
    }
}
