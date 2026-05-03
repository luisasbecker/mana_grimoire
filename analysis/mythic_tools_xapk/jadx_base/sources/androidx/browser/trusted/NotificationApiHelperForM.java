package androidx.browser.trusted;

import android.app.NotificationManager;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class NotificationApiHelperForM {
    private NotificationApiHelperForM() {
    }

    static Parcelable[] getActiveNotifications(NotificationManager notificationManager) {
        return notificationManager.getActiveNotifications();
    }
}
