package com.studiolaganne.lengendarylens;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BatteryMonitor.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000'\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\t\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000eB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/studiolaganne/lengendarylens/BatteryMonitor;", "", "context", "Landroid/content/Context;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/studiolaganne/lengendarylens/BatteryMonitor$BatteryLevelListener;", "<init>", "(Landroid/content/Context;Lcom/studiolaganne/lengendarylens/BatteryMonitor$BatteryLevelListener;)V", "batteryReceiver", "com/studiolaganne/lengendarylens/BatteryMonitor$batteryReceiver$1", "Lcom/studiolaganne/lengendarylens/BatteryMonitor$batteryReceiver$1;", "startMonitoring", "", "stopMonitoring", "BatteryLevelListener", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BatteryMonitor {
    public static final int $stable = 8;
    private final BatteryMonitor$batteryReceiver$1 batteryReceiver;
    private final Context context;
    private final BatteryLevelListener listener;

    /* JADX INFO: compiled from: BatteryMonitor.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/studiolaganne/lengendarylens/BatteryMonitor$BatteryLevelListener;", "", "onBatteryLevelChanged", "", FirebaseAnalytics.Param.LEVEL, "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface BatteryLevelListener {
        void onBatteryLevelChanged(int level);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.studiolaganne.lengendarylens.BatteryMonitor$batteryReceiver$1] */
    public BatteryMonitor(Context context, BatteryLevelListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.context = context;
        this.listener = listener;
        this.batteryReceiver = new BroadcastReceiver() { // from class: com.studiolaganne.lengendarylens.BatteryMonitor$batteryReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (intent == null) {
                    return;
                }
                int intExtra = intent.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
                int intExtra2 = intent.getIntExtra("scale", -1);
                if (intExtra == -1 || intExtra2 == -1) {
                    return;
                }
                this.this$0.listener.onBatteryLevelChanged((int) ((intExtra / intExtra2) * 100.0f));
            }
        };
    }

    public final void startMonitoring() {
        this.context.registerReceiver(this.batteryReceiver, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    public final void stopMonitoring() {
        this.context.unregisterReceiver(this.batteryReceiver);
    }
}
