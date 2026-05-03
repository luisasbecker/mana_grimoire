package com.appsflyer.internal;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import com.appsflyer.AFLogger;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public final class AFj1mSDK implements AFj1oSDK {
    private static final BitSet component4;
    final Handler AFAdRevenueData;
    private final SensorManager areAllFieldsValid;
    private final Map<AFj1tSDK, Map<String, Object>> component1;
    private final Map<AFj1tSDK, AFj1tSDK> component2;
    private final ExecutorService component3;
    private boolean copydefault;
    final Runnable getCurrencyIso4217Code;
    boolean getMediationNetwork;
    final Runnable getMonetizationNetwork;
    final Object getRevenue;
    private final Runnable hashCode;

    static {
        BitSet bitSet = new BitSet(6);
        component4 = bitSet;
        bitSet.set(1);
        bitSet.set(2);
        bitSet.set(4);
    }

    public AFj1mSDK(Context context, ExecutorService executorService) {
        SensorManager sensorManager = (SensorManager) context.getApplicationContext().getSystemService("sensor");
        HandlerThread handlerThread = new HandlerThread("internal");
        handlerThread.start();
        this(sensorManager, new Handler(handlerThread.getLooper()), executorService);
    }

    private AFj1mSDK(SensorManager sensorManager, Handler handler, ExecutorService executorService) {
        this.getRevenue = new Object();
        BitSet bitSet = component4;
        this.component2 = new HashMap(bitSet.size());
        this.component1 = new ConcurrentHashMap(bitSet.size());
        this.getCurrencyIso4217Code = new Runnable() { // from class: com.appsflyer.internal.AFj1mSDK.2
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (AFj1mSDK.this.getRevenue) {
                    AFj1mSDK.this.getRevenue();
                    AFj1mSDK.this.AFAdRevenueData.postDelayed(AFj1mSDK.this.getMonetizationNetwork, 150L);
                    AFj1mSDK.this.getMediationNetwork = true;
                }
            }
        };
        this.getMonetizationNetwork = new Runnable() { // from class: com.appsflyer.internal.AFj1mSDK$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.component1();
            }
        };
        this.hashCode = new Runnable() { // from class: com.appsflyer.internal.AFj1mSDK.1
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (AFj1mSDK.this.getRevenue) {
                    if (AFj1mSDK.this.getMediationNetwork) {
                        AFj1mSDK.this.AFAdRevenueData.removeCallbacks(AFj1mSDK.this.getCurrencyIso4217Code);
                        AFj1mSDK.this.AFAdRevenueData.removeCallbacks(AFj1mSDK.this.getMonetizationNetwork);
                        AFj1mSDK.this.getCurrencyIso4217Code();
                        AFj1mSDK.this.getMediationNetwork = false;
                    }
                }
            }
        };
        this.areAllFieldsValid = sensorManager;
        this.AFAdRevenueData = handler;
        this.component3 = executorService;
    }

    private List<Map<String, Object>> areAllFieldsValid() {
        synchronized (this.getRevenue) {
            if (!this.component2.isEmpty() && this.copydefault) {
                Iterator<AFj1tSDK> it = this.component2.values().iterator();
                while (it.hasNext()) {
                    it.next().getMediationNetwork(this.component1, false);
                }
            }
            if (this.component1.isEmpty()) {
                return new CopyOnWriteArrayList(Collections.emptyList());
            }
            return new CopyOnWriteArrayList(this.component1.values());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void component1() {
        synchronized (this.getRevenue) {
            this.AFAdRevenueData.post(new AFj1mSDK$$ExternalSyntheticLambda1(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void component2() {
        try {
            if (!this.component2.isEmpty()) {
                for (AFj1tSDK aFj1tSDK : this.component2.values()) {
                    this.areAllFieldsValid.unregisterListener(aFj1tSDK);
                    aFj1tSDK.getMediationNetwork(this.component1, true);
                }
            }
        } catch (Throwable th) {
            AFLogger.afErrorLogForExcManagerOnly("error while unregistering listeners", th);
        }
        this.copydefault = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void component3() {
        try {
            for (Sensor sensor : this.areAllFieldsValid.getSensorList(-1)) {
                if (getMediationNetwork(sensor.getType())) {
                    AFj1tSDK aFj1tSDK = new AFj1tSDK(sensor, this.component3);
                    if (!this.component2.containsKey(aFj1tSDK)) {
                        this.component2.put(aFj1tSDK, aFj1tSDK);
                    }
                    this.areAllFieldsValid.registerListener(this.component2.get(aFj1tSDK), sensor, 1, this.AFAdRevenueData);
                }
            }
        } catch (Throwable th) {
            AFLogger.afErrorLogForExcManagerOnly("registerListeners error", th);
        }
        this.copydefault = true;
    }

    private List<Map<String, Object>> component4() {
        synchronized (this.getRevenue) {
            Iterator<AFj1tSDK> it = this.component2.values().iterator();
            while (it.hasNext()) {
                it.next().getMediationNetwork(this.component1, true);
            }
            if (this.component1.isEmpty()) {
                return new CopyOnWriteArrayList(Collections.emptyList());
            }
            return new CopyOnWriteArrayList(this.component1.values());
        }
    }

    private static boolean getMediationNetwork(int i) {
        return i >= 0 && component4.get(i);
    }

    @Override // com.appsflyer.internal.AFj1oSDK
    public final Map<String, Object> AFAdRevenueData() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        List<Map<String, Object>> listAreAllFieldsValid = areAllFieldsValid();
        if (!listAreAllFieldsValid.isEmpty()) {
            concurrentHashMap.put("sensors", listAreAllFieldsValid);
            return concurrentHashMap;
        }
        List<Map<String, Object>> listComponent4 = component4();
        if (!listComponent4.isEmpty()) {
            concurrentHashMap.put("sensors", listComponent4);
        }
        return concurrentHashMap;
    }

    final void getCurrencyIso4217Code() {
        this.AFAdRevenueData.post(new AFj1mSDK$$ExternalSyntheticLambda1(this));
    }

    @Override // com.appsflyer.internal.AFj1oSDK
    public final synchronized void getMediationNetwork() {
        this.AFAdRevenueData.post(this.hashCode);
    }

    @Override // com.appsflyer.internal.AFj1oSDK
    public final void getMonetizationNetwork() {
        this.AFAdRevenueData.post(this.hashCode);
        this.AFAdRevenueData.post(this.getCurrencyIso4217Code);
    }

    final void getRevenue() {
        this.AFAdRevenueData.post(new Runnable() { // from class: com.appsflyer.internal.AFj1mSDK$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.component3();
            }
        });
    }
}
