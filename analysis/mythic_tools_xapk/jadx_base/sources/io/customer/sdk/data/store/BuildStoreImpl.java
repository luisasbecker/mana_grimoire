package io.customer.sdk.data.store;

import android.os.Build;
import java.util.Locale;
import kotlin.Metadata;

/* JADX INFO: compiled from: BuildStore.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0016\u0010\f\u001a\u0004\u0018\u00010\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0012"}, d2 = {"Lio/customer/sdk/data/store/BuildStoreImpl;", "Lio/customer/sdk/data/store/BuildStore;", "<init>", "()V", "deviceBrand", "", "getDeviceBrand", "()Ljava/lang/String;", "deviceModel", "getDeviceModel", "deviceManufacturer", "getDeviceManufacturer", "deviceOSVersion", "", "getDeviceOSVersion", "()Ljava/lang/Integer;", "deviceLocale", "getDeviceLocale", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BuildStoreImpl implements BuildStore {
    @Override // io.customer.sdk.data.store.BuildStore
    public String getDeviceBrand() {
        return Build.BRAND;
    }

    @Override // io.customer.sdk.data.store.BuildStore
    public String getDeviceLocale() {
        return Locale.getDefault().toLanguageTag();
    }

    @Override // io.customer.sdk.data.store.BuildStore
    public String getDeviceManufacturer() {
        return Build.MANUFACTURER;
    }

    @Override // io.customer.sdk.data.store.BuildStore
    public String getDeviceModel() {
        return Build.MODEL;
    }

    @Override // io.customer.sdk.data.store.BuildStore
    public Integer getDeviceOSVersion() {
        return Integer.valueOf(Build.VERSION.SDK_INT);
    }
}
