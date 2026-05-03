package com.segment.analytics.kotlin.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Storage.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\u0004"}, d2 = {"parseFilePaths", "", "", "filePathStr", "core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class StorageKt {
    public static final List<String> parseFilePaths(String str) {
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return CollectionsKt.emptyList();
        }
        List listSplit$default = StringsKt.split$default((CharSequence) str2, new String[]{","}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit$default, 10));
        Iterator it = listSplit$default.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt.trim((CharSequence) it.next()).toString());
        }
        return arrayList;
    }
}
