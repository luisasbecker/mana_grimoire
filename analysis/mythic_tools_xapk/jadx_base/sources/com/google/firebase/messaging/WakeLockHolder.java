package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.stats.WakeLock;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
final class WakeLockHolder {
    private static final String EXTRA_WAKEFUL_INTENT = "com.google.firebase.iid.WakeLockHolder.wakefulintent";
    static final long WAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS = TimeUnit.MINUTES.toMillis(1);
    private static final Object syncObject = new Object();
    private static WakeLock wakeLock;

    WakeLockHolder() {
    }

    static void acquireWakeLock(Intent intent, long j) {
        synchronized (syncObject) {
            if (wakeLock != null) {
                setAsWakefulIntent(intent, true);
                wakeLock.acquire(j);
            }
        }
    }

    private static void checkAndInitWakeLock(Context context) {
        if (wakeLock == null) {
            WakeLock wakeLock2 = new WakeLock(context, 1, "wake:com.google.firebase.iid.WakeLockHolder");
            wakeLock = wakeLock2;
            wakeLock2.setReferenceCounted(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void completeWakefulIntent(Intent intent) {
        synchronized (syncObject) {
            if (wakeLock != null && isWakefulIntent(intent)) {
                setAsWakefulIntent(intent, false);
                wakeLock.release();
            }
        }
    }

    static void initWakeLock(Context context) {
        synchronized (syncObject) {
            checkAndInitWakeLock(context);
        }
    }

    static boolean isWakefulIntent(Intent intent) {
        return intent.getBooleanExtra(EXTRA_WAKEFUL_INTENT, false);
    }

    static void reset() {
        synchronized (syncObject) {
            wakeLock = null;
        }
    }

    static void sendWakefulServiceIntent(Context context, WithinAppServiceConnection withinAppServiceConnection, final Intent intent) {
        synchronized (syncObject) {
            checkAndInitWakeLock(context);
            boolean zIsWakefulIntent = isWakefulIntent(intent);
            setAsWakefulIntent(intent, true);
            if (!zIsWakefulIntent) {
                wakeLock.acquire(WAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS);
            }
            withinAppServiceConnection.sendIntent(intent).addOnCompleteListener(new OnCompleteListener() { // from class: com.google.firebase.messaging.WakeLockHolder$$ExternalSyntheticLambda0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    WakeLockHolder.completeWakefulIntent(intent);
                }
            });
        }
    }

    private static void setAsWakefulIntent(Intent intent, boolean z) {
        intent.putExtra(EXTRA_WAKEFUL_INTENT, z);
    }

    static ComponentName startWakefulService(Context context, Intent intent) {
        synchronized (syncObject) {
            checkAndInitWakeLock(context);
            boolean zIsWakefulIntent = isWakefulIntent(intent);
            setAsWakefulIntent(intent, true);
            ComponentName componentNameStartService = context.startService(intent);
            if (componentNameStartService == null) {
                return null;
            }
            if (!zIsWakefulIntent) {
                wakeLock.acquire(WAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS);
            }
            return componentNameStartService;
        }
    }
}
