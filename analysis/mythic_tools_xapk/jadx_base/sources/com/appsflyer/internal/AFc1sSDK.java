package com.appsflyer.internal;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class AFc1sSDK {
    final List<AFc1uSDK> getRevenue;

    public AFc1sSDK(List<AFc1uSDK> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.getRevenue = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AFc1sSDK) && Intrinsics.areEqual(this.getRevenue, ((AFc1sSDK) obj).getRevenue);
    }

    public final int hashCode() {
        return this.getRevenue.hashCode();
    }

    public final String toString() {
        return "StorageConfig(typeEntries=" + this.getRevenue + ")";
    }
}
