package io.customer.sdk.data.store;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import io.customer.sdk.data.model.Settings;
import kotlin.Metadata;

/* JADX INFO: compiled from: GlobalPreferenceStore.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\n\u0010\t\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\n\u001a\u0004\u0018\u00010\bH&J\b\u0010\u000b\u001a\u00020\u0003H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0005H&J\b\u0010\u000e\u001a\u00020\u0003H&¨\u0006\u000f"}, d2 = {"Lio/customer/sdk/data/store/GlobalPreferenceStore;", "", "saveDeviceToken", "", "token", "", "saveSettings", "value", "Lio/customer/sdk/data/model/Settings;", "getDeviceToken", "getSettings", "removeDeviceToken", "clear", SubscriberAttributeKt.JSON_NAME_KEY, "clearAll", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface GlobalPreferenceStore {
    void clear(String key);

    void clearAll();

    String getDeviceToken();

    Settings getSettings();

    void removeDeviceToken();

    void saveDeviceToken(String token);

    void saveSettings(Settings value);
}
