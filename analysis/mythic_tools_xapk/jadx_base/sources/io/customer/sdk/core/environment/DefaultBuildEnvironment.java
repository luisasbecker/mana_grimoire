package io.customer.sdk.core.environment;

import kotlin.Metadata;

/* JADX INFO: compiled from: BuildEnvironment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/customer/sdk/core/environment/DefaultBuildEnvironment;", "Lio/customer/sdk/core/environment/BuildEnvironment;", "<init>", "()V", "debugModeEnabled", "", "getDebugModeEnabled", "()Z", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultBuildEnvironment implements BuildEnvironment {
    private final boolean debugModeEnabled;

    @Override // io.customer.sdk.core.environment.BuildEnvironment
    public boolean getDebugModeEnabled() {
        return this.debugModeEnabled;
    }
}
