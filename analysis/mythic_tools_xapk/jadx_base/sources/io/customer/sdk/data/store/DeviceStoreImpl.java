package io.customer.sdk.data.store;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeviceStore.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010'\u001a\u00020\tH\u0016J\u0016\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010*0)H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000eR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u000eR\u0016\u0010\u0019\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u000eR\u0016\u0010\u001b\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u000eR\u0014\u0010\u001d\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001fR\u0014\u0010 \u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u000eR\u0014\u0010\"\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u000e¨\u0006+"}, d2 = {"Lio/customer/sdk/data/store/DeviceStoreImpl;", "Lio/customer/sdk/data/store/DeviceStore;", "buildStore", "Lio/customer/sdk/data/store/BuildStore;", "applicationStore", "Lio/customer/sdk/data/store/ApplicationStore;", "client", "Lio/customer/sdk/data/store/Client;", "version", "", "<init>", "(Lio/customer/sdk/data/store/BuildStore;Lio/customer/sdk/data/store/ApplicationStore;Lio/customer/sdk/data/store/Client;Ljava/lang/String;)V", "deviceBrand", "getDeviceBrand", "()Ljava/lang/String;", "deviceModel", "getDeviceModel", "deviceManufacturer", "getDeviceManufacturer", "deviceOSVersion", "", "getDeviceOSVersion", "()Ljava/lang/Integer;", "deviceLocale", "getDeviceLocale", "customerAppName", "getCustomerAppName", "customerAppVersion", "getCustomerAppVersion", "isPushEnabled", "", "()Z", "customerPackageName", "getCustomerPackageName", "customerIOClient", "getCustomerIOClient", "()Lio/customer/sdk/data/store/Client;", "customerIOVersion", "getCustomerIOVersion", "buildUserAgent", "buildDeviceAttributes", "", "", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeviceStoreImpl implements DeviceStore {
    private final ApplicationStore applicationStore;
    private final BuildStore buildStore;
    private final Client customerIOClient;
    private final String customerIOVersion;

    public DeviceStoreImpl(BuildStore buildStore, ApplicationStore applicationStore, Client client, String version) {
        Intrinsics.checkNotNullParameter(buildStore, "buildStore");
        Intrinsics.checkNotNullParameter(applicationStore, "applicationStore");
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(version, "version");
        this.buildStore = buildStore;
        this.applicationStore = applicationStore;
        this.customerIOClient = client;
        this.customerIOVersion = version;
    }

    public /* synthetic */ DeviceStoreImpl(BuildStore buildStore, ApplicationStore applicationStore, Client client, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(buildStore, applicationStore, client, (i & 8) != 0 ? client.getSdkVersion() : str);
    }

    @Override // io.customer.sdk.data.store.DeviceStore
    public Map<String, Object> buildDeviceAttributes() {
        Pair[] pairArr = new Pair[7];
        pairArr[0] = TuplesKt.to("device_os", getDeviceOSVersion());
        pairArr[1] = TuplesKt.to("device_model", getDeviceModel());
        pairArr[2] = TuplesKt.to("device_manufacturer", getDeviceManufacturer());
        String customerAppVersion = getCustomerAppVersion();
        if (customerAppVersion == null) {
            customerAppVersion = "";
        }
        pairArr[3] = TuplesKt.to("app_version", customerAppVersion);
        pairArr[4] = TuplesKt.to("cio_sdk_version", getCustomerIOVersion());
        pairArr[5] = TuplesKt.to("device_locale", getDeviceLocale());
        pairArr[6] = TuplesKt.to("push_enabled", Boolean.valueOf(isPushEnabled()));
        return MapsKt.mapOf(pairArr);
    }

    @Override // io.customer.sdk.data.store.DeviceStore
    public String buildUserAgent() {
        StringBuilder sb = new StringBuilder();
        sb.append("Customer.io " + getCustomerIOClient());
        sb.append(" (" + getDeviceManufacturer() + " " + getDeviceModel() + "; " + getDeviceOSVersion() + ")");
        String customerPackageName = getCustomerPackageName();
        String customerAppVersion = getCustomerAppVersion();
        if (customerAppVersion == null) {
            customerAppVersion = "0.0.0";
        }
        sb.append(" " + customerPackageName + DomExceptionUtils.SEPARATOR + customerAppVersion);
        return sb.toString();
    }

    @Override // io.customer.sdk.data.store.ApplicationStore
    public String getCustomerAppName() {
        return this.applicationStore.getCustomerAppName();
    }

    @Override // io.customer.sdk.data.store.ApplicationStore
    public String getCustomerAppVersion() {
        return this.applicationStore.getCustomerAppVersion();
    }

    @Override // io.customer.sdk.data.store.DeviceStore
    public Client getCustomerIOClient() {
        return this.customerIOClient;
    }

    @Override // io.customer.sdk.data.store.DeviceStore
    public String getCustomerIOVersion() {
        return this.customerIOVersion;
    }

    @Override // io.customer.sdk.data.store.ApplicationStore
    public String getCustomerPackageName() {
        return this.applicationStore.getCustomerPackageName();
    }

    @Override // io.customer.sdk.data.store.BuildStore
    public String getDeviceBrand() {
        return this.buildStore.getDeviceBrand();
    }

    @Override // io.customer.sdk.data.store.BuildStore
    public String getDeviceLocale() {
        return this.buildStore.getDeviceLocale();
    }

    @Override // io.customer.sdk.data.store.BuildStore
    public String getDeviceManufacturer() {
        return this.buildStore.getDeviceManufacturer();
    }

    @Override // io.customer.sdk.data.store.BuildStore
    public String getDeviceModel() {
        return this.buildStore.getDeviceModel();
    }

    @Override // io.customer.sdk.data.store.BuildStore
    public Integer getDeviceOSVersion() {
        return this.buildStore.getDeviceOSVersion();
    }

    @Override // io.customer.sdk.data.store.ApplicationStore
    public boolean isPushEnabled() {
        return this.applicationStore.isPushEnabled();
    }
}
