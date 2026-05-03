package com.studiolaganne.lengendarylens;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ChargingStateReceiver.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/studiolaganne/lengendarylens/ChargingStateReceiver;", "Landroid/content/BroadcastReceiver;", "callback", "Lcom/studiolaganne/lengendarylens/ChargingStateReceiver$ChargingStateCallback;", "<init>", "(Lcom/studiolaganne/lengendarylens/ChargingStateReceiver$ChargingStateCallback;)V", "getCallback", "()Lcom/studiolaganne/lengendarylens/ChargingStateReceiver$ChargingStateCallback;", "isDeviceCharging", "", "context", "Landroid/content/Context;", "onReceive", "", "intent", "Landroid/content/Intent;", "ChargingStateCallback", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChargingStateReceiver extends BroadcastReceiver {
    public static final int $stable = 8;
    private final ChargingStateCallback callback;

    /* JADX INFO: compiled from: ChargingStateReceiver.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lcom/studiolaganne/lengendarylens/ChargingStateReceiver$ChargingStateCallback;", "", "onBatteryCharging", "", "onBatteryNotCharging", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface ChargingStateCallback {

        /* JADX INFO: compiled from: ChargingStateReceiver.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class DefaultImpls {
            @Deprecated
            public static void onBatteryNotCharging(ChargingStateCallback chargingStateCallback) {
                ChargingStateCallback.super.onBatteryNotCharging();
            }
        }

        void onBatteryCharging();

        default void onBatteryNotCharging() {
        }
    }

    public ChargingStateReceiver(ChargingStateCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
    }

    public final ChargingStateCallback getCallback() {
        return this.callback;
    }

    public final boolean isDeviceCharging(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentRegisterReceiver == null) {
            return false;
        }
        int intExtra = intentRegisterReceiver.getIntExtra("status", -1);
        return intExtra == 2 || intExtra == 5;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        String action = intent.getAction();
        if (action != null) {
            int iHashCode = action.hashCode();
            if (iHashCode == -1886648615) {
                if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                    this.callback.onBatteryNotCharging();
                }
            } else if (iHashCode == 1019184907 && action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                this.callback.onBatteryCharging();
            }
        }
    }
}
