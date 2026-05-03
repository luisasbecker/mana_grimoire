package io.customer.sdk.core.module;

import io.customer.sdk.core.module.CustomerIOModuleConfig;
import kotlin.Metadata;

/* JADX INFO: compiled from: CustomerIOModule.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\b\u0010\u000b\u001a\u00020\fH&R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lio/customer/sdk/core/module/CustomerIOModule;", "Config", "Lio/customer/sdk/core/module/CustomerIOModuleConfig;", "", "moduleName", "", "getModuleName", "()Ljava/lang/String;", "moduleConfig", "getModuleConfig", "()Lio/customer/sdk/core/module/CustomerIOModuleConfig;", "initialize", "", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface CustomerIOModule<Config extends CustomerIOModuleConfig> {
    Config getModuleConfig();

    String getModuleName();

    void initialize();
}
