package com.appsflyer.internal;

import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class AFa1nSDK extends HashMap<Integer, String> {
    private static AFa1nSDK AFAdRevenueData;
    private final Object getMonetizationNetwork = new Object();

    private AFa1nSDK() {
    }

    public static synchronized AFa1nSDK afErrorLog() {
        if (AFAdRevenueData == null) {
            AFAdRevenueData = new AFa1nSDK();
        }
        return AFAdRevenueData;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public String put(Integer num, String str) {
        String str2;
        synchronized (this.getMonetizationNetwork) {
            str2 = (String) super.put(num, str);
        }
        return str2;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public String remove(Object obj) {
        String str;
        synchronized (this.getMonetizationNetwork) {
            str = (String) super.remove(obj);
        }
        return str;
    }

    @Override // java.util.HashMap, java.util.Map
    public boolean remove(Object obj, Object obj2) {
        boolean zRemove;
        synchronized (this.getMonetizationNetwork) {
            zRemove = super.remove(obj, obj2);
        }
        return zRemove;
    }
}
