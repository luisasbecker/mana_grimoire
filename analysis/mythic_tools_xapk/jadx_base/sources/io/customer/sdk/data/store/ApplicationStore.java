package io.customer.sdk.data.store;

import kotlin.Metadata;

/* JADX INFO: compiled from: ApplicationStore.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\f¨\u0006\r"}, d2 = {"Lio/customer/sdk/data/store/ApplicationStore;", "", "customerAppName", "", "getCustomerAppName", "()Ljava/lang/String;", "customerAppVersion", "getCustomerAppVersion", "customerPackageName", "getCustomerPackageName", "isPushEnabled", "", "()Z", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ApplicationStore {
    String getCustomerAppName();

    String getCustomerAppVersion();

    String getCustomerPackageName();

    boolean isPushEnabled();
}
