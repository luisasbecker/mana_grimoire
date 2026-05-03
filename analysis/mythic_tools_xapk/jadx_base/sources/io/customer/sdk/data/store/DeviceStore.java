package io.customer.sdk.data.store;

import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: DeviceStore.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u000b\u001a\u00020\bH&J\u0016\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rH&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lio/customer/sdk/data/store/DeviceStore;", "Lio/customer/sdk/data/store/BuildStore;", "Lio/customer/sdk/data/store/ApplicationStore;", "customerIOClient", "Lio/customer/sdk/data/store/Client;", "getCustomerIOClient", "()Lio/customer/sdk/data/store/Client;", "customerIOVersion", "", "getCustomerIOVersion", "()Ljava/lang/String;", "buildUserAgent", "buildDeviceAttributes", "", "", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface DeviceStore extends BuildStore, ApplicationStore {
    Map<String, Object> buildDeviceAttributes();

    String buildUserAgent();

    Client getCustomerIOClient();

    String getCustomerIOVersion();
}
