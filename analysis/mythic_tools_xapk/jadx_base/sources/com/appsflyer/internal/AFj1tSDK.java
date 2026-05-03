package com.appsflyer.internal;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Looper;
import androidx.camera.video.AudioStats;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public final class AFj1tSDK implements SensorEventListener {
    private final int AFAdRevenueData;
    private long component1;
    private final Executor component4;
    private double getCurrencyIso4217Code;
    private final String getMediationNetwork;
    private final String getMonetizationNetwork;
    private final int getRevenue;
    private final float[][] component2 = new float[2][];
    private final long[] areAllFieldsValid = new long[2];

    AFj1tSDK(Sensor sensor, ExecutorService executorService) {
        int type = sensor.getType();
        this.AFAdRevenueData = type;
        String name = sensor.getName();
        name = name == null ? "" : name;
        this.getMediationNetwork = name;
        String vendor = sensor.getVendor();
        String str = vendor != null ? vendor : "";
        this.getMonetizationNetwork = str;
        this.getRevenue = ((((type + 31) * 31) + name.hashCode()) * 31) + str.hashCode();
        this.component4 = executorService;
    }

    private boolean AFAdRevenueData(int i, String str, String str2) {
        return this.AFAdRevenueData == i && this.getMediationNetwork.equals(str) && this.getMonetizationNetwork.equals(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: F_, reason: merged with bridge method [inline-methods] */
    public void G_(SensorEvent sensorEvent) {
        long j = sensorEvent.timestamp;
        float[] fArr = sensorEvent.values;
        long jCurrentTimeMillis = System.currentTimeMillis();
        float[][] fArr2 = this.component2;
        float[] fArr3 = fArr2[0];
        if (fArr3 == null) {
            fArr2[0] = Arrays.copyOf(fArr, fArr.length);
            this.areAllFieldsValid[0] = jCurrentTimeMillis;
            return;
        }
        float[] fArr4 = fArr2[1];
        if (fArr4 == null) {
            float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
            this.component2[1] = fArrCopyOf;
            this.areAllFieldsValid[1] = jCurrentTimeMillis;
            this.getCurrencyIso4217Code = getCurrencyIso4217Code(fArr3, fArrCopyOf);
            return;
        }
        if (50000000 <= j - this.component1) {
            this.component1 = j;
            if (Arrays.equals(fArr4, fArr)) {
                this.areAllFieldsValid[1] = jCurrentTimeMillis;
                return;
            }
            double currencyIso4217Code = getCurrencyIso4217Code(fArr3, fArr);
            if (currencyIso4217Code > this.getCurrencyIso4217Code) {
                this.component2[1] = Arrays.copyOf(fArr, fArr.length);
                this.areAllFieldsValid[1] = jCurrentTimeMillis;
                this.getCurrencyIso4217Code = currencyIso4217Code;
            }
        }
    }

    private static double getCurrencyIso4217Code(float[] fArr, float[] fArr2) {
        int iMin = Math.min(fArr.length, fArr2.length);
        double dPow = AudioStats.AUDIO_AMPLITUDE_NONE;
        for (int i = 0; i < iMin; i++) {
            dPow += StrictMath.pow(fArr[i] - fArr2[i], 2.0d);
        }
        return Math.sqrt(dPow);
    }

    private boolean getMediationNetwork() {
        return this.component2[0] != null;
    }

    private static List<Float> getMonetizationNetwork(float[] fArr) {
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f : fArr) {
            arrayList.add(Float.valueOf(f));
        }
        return arrayList;
    }

    private Map<String, Object> getMonetizationNetwork() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(7);
        concurrentHashMap.put("sT", Integer.valueOf(this.AFAdRevenueData));
        concurrentHashMap.put("sN", this.getMediationNetwork);
        concurrentHashMap.put("sV", this.getMonetizationNetwork);
        float[] fArr = this.component2[0];
        if (fArr != null) {
            concurrentHashMap.put("sVS", getMonetizationNetwork(fArr));
        }
        float[] fArr2 = this.component2[1];
        if (fArr2 != null) {
            concurrentHashMap.put("sVE", getMonetizationNetwork(fArr2));
        }
        return concurrentHashMap;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AFj1tSDK)) {
            return false;
        }
        AFj1tSDK aFj1tSDK = (AFj1tSDK) obj;
        return AFAdRevenueData(aFj1tSDK.AFAdRevenueData, aFj1tSDK.getMediationNetwork, aFj1tSDK.getMonetizationNetwork);
    }

    final void getMediationNetwork(Map<AFj1tSDK, Map<String, Object>> map, boolean z) {
        if (!getMediationNetwork()) {
            if (map.containsKey(this)) {
                return;
            }
            map.put(this, getMonetizationNetwork());
            return;
        }
        map.put(this, getMonetizationNetwork());
        if (z) {
            int length = this.component2.length;
            for (int i = 0; i < length; i++) {
                this.component2[i] = null;
            }
            int length2 = this.areAllFieldsValid.length;
            for (int i2 = 0; i2 < length2; i2++) {
                this.areAllFieldsValid[i2] = 0;
            }
            this.getCurrencyIso4217Code = AudioStats.AUDIO_AMPLITUDE_NONE;
            this.component1 = 0L;
        }
    }

    public final int hashCode() {
        return this.getRevenue;
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(final SensorEvent sensorEvent) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.component4.execute(new Runnable() { // from class: com.appsflyer.internal.AFj1tSDK$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.G_(sensorEvent);
                }
            });
        } else {
            G_(sensorEvent);
        }
    }
}
