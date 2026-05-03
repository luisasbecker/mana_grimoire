package com.appsflyer.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class AFj1eSDK {
    private static final Object getCurrencyIso4217Code(Object obj) {
        if (obj instanceof JSONArray) {
            return getCurrencyIso4217Code((JSONArray) obj);
        }
        if (obj instanceof JSONObject) {
            return getMonetizationNetwork((JSONObject) obj);
        }
        if (Intrinsics.areEqual(obj, JSONObject.NULL)) {
            return null;
        }
        return obj;
    }

    private static final List<Object> getCurrencyIso4217Code(JSONArray jSONArray) throws JSONException {
        IntRange intRangeUntil = RangesKt.until(0, jSONArray.length());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
        Iterator<Integer> it = intRangeUntil.iterator();
        while (it.hasNext()) {
            Object obj = jSONArray.get(((IntIterator) it).nextInt());
            Intrinsics.checkNotNullExpressionValue(obj, "");
            arrayList.add(getCurrencyIso4217Code(obj));
        }
        return arrayList;
    }

    public static final Map<String, Object> getMonetizationNetwork(JSONObject jSONObject) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "");
        Iterator<String> itKeys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(itKeys, "");
        Sequence sequenceAsSequence = SequencesKt.asSequence(itKeys);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : sequenceAsSequence) {
            Object obj2 = jSONObject.get((String) obj);
            Intrinsics.checkNotNullExpressionValue(obj2, "");
            linkedHashMap.put(obj, getCurrencyIso4217Code(obj2));
        }
        return linkedHashMap;
    }
}
