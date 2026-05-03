package com.appsflyer.internal;

import android.net.TrafficStats;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AFe1uSDK<Result> implements Comparable<AFe1uSDK<?>>, Callable<AFe1rSDK> {
    private static final AtomicInteger component2 = new AtomicInteger();
    public AFe1rSDK AFAdRevenueData;
    private final int areAllFieldsValid;
    private final String component1;
    private Throwable component3;
    private long component4;
    public volatile int getCurrencyIso4217Code;
    public final Set<AFe1lSDK> getMediationNetwork;
    public final AFe1lSDK getMonetizationNetwork;
    public final Set<AFe1lSDK> getRevenue;
    private boolean toString;

    public AFe1uSDK(AFe1lSDK aFe1lSDK, AFe1lSDK[] aFe1lSDKArr, String str) {
        HashSet hashSet = new HashSet();
        this.getRevenue = hashSet;
        this.getMediationNetwork = new HashSet();
        int iIncrementAndGet = component2.incrementAndGet();
        this.areAllFieldsValid = iIncrementAndGet;
        this.toString = false;
        this.getCurrencyIso4217Code = 0;
        this.getMonetizationNetwork = aFe1lSDK;
        Collections.addAll(hashSet, aFe1lSDKArr);
        if (str != null) {
            this.component1 = str;
        } else {
            this.component1 = String.valueOf(iIncrementAndGet);
        }
    }

    protected abstract boolean AFAdRevenueData();

    public final Throwable component2() {
        return this.component3;
    }

    protected final boolean component3() {
        return this.toString;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: component4, reason: merged with bridge method [inline-methods] */
    public final AFe1rSDK call() throws Exception {
        TrafficStats.setThreadStatsTag("AppsFlyer".hashCode());
        this.AFAdRevenueData = null;
        this.component3 = null;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.getCurrencyIso4217Code++;
        try {
            AFe1rSDK mediationNetwork = getMediationNetwork();
            this.AFAdRevenueData = mediationNetwork;
            return mediationNetwork;
        } finally {
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AFe1uSDK aFe1uSDK = (AFe1uSDK) obj;
        if (this.getMonetizationNetwork != aFe1uSDK.getMonetizationNetwork) {
            return false;
        }
        return this.component1.equals(aFe1uSDK.component1);
    }

    public void getCurrencyIso4217Code() {
        this.toString = true;
    }

    protected abstract AFe1rSDK getMediationNetwork() throws Exception;

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: getMonetizationNetwork, reason: merged with bridge method [inline-methods] */
    public final int compareTo(AFe1uSDK<?> aFe1uSDK) {
        int i = this.getMonetizationNetwork.unregisterClient - aFe1uSDK.getMonetizationNetwork.unregisterClient;
        if (i != 0) {
            return i;
        }
        if (this.component1.equals(aFe1uSDK.component1)) {
            return 0;
        }
        return this.areAllFieldsValid - aFe1uSDK.areAllFieldsValid;
    }

    protected void getMonetizationNetwork() {
    }

    protected void getMonetizationNetwork(Throwable th) {
    }

    protected abstract long getRevenue();

    public final int hashCode() {
        return (this.getMonetizationNetwork.hashCode() * 31) + this.component1.hashCode();
    }

    public String toString() {
        String string = new StringBuilder().append(this.getMonetizationNetwork).append("-").append(this.component1).toString();
        return !String.valueOf(this.areAllFieldsValid).equals(this.component1) ? new StringBuilder().append(string).append("-").append(this.areAllFieldsValid).toString() : string;
    }
}
