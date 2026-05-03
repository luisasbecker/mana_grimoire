package io.customer.sdk.data.store;

import kotlin.Metadata;

/* JADX INFO: compiled from: BuildStore.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005¨\u0006\u0010"}, d2 = {"Lio/customer/sdk/data/store/BuildStore;", "", "deviceBrand", "", "getDeviceBrand", "()Ljava/lang/String;", "deviceModel", "getDeviceModel", "deviceManufacturer", "getDeviceManufacturer", "deviceOSVersion", "", "getDeviceOSVersion", "()Ljava/lang/Integer;", "deviceLocale", "getDeviceLocale", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface BuildStore {
    String getDeviceBrand();

    String getDeviceLocale();

    String getDeviceManufacturer();

    String getDeviceModel();

    Integer getDeviceOSVersion();
}
