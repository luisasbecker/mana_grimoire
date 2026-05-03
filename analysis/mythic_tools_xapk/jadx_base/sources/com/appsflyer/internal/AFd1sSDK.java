package com.appsflyer.internal;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public final class AFd1sSDK {
    public static final JSONArray getMediationNetwork(List<AFc1bSDK> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<AFc1bSDK> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((AFc1bSDK) it.next()).getMonetizationNetwork());
        }
        return new JSONArray((Collection) arrayList);
    }

    public static final boolean getMediationNetwork(HttpURLConnection httpURLConnection) {
        Intrinsics.checkNotNullParameter(httpURLConnection, "");
        return httpURLConnection.getResponseCode() / 100 == 2;
    }
}
