package io.customer.sdk.core.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: ScopeProvider.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0014\u0010\u000e\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\t¨\u0006\u0010"}, d2 = {"Lio/customer/sdk/core/util/SdkScopeProvider;", "Lio/customer/sdk/core/util/ScopeProvider;", "dispatchers", "Lio/customer/sdk/core/util/DispatchersProvider;", "<init>", "(Lio/customer/sdk/core/util/DispatchersProvider;)V", "eventBusScope", "Lkotlinx/coroutines/CoroutineScope;", "getEventBusScope", "()Lkotlinx/coroutines/CoroutineScope;", "lifecycleListenerScope", "getLifecycleListenerScope", "inAppLifecycleScope", "getInAppLifecycleScope", "locationScope", "getLocationScope", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SdkScopeProvider implements ScopeProvider {
    private final DispatchersProvider dispatchers;

    public SdkScopeProvider(DispatchersProvider dispatchers) {
        Intrinsics.checkNotNullParameter(dispatchers, "dispatchers");
        this.dispatchers = dispatchers;
    }

    @Override // io.customer.sdk.core.util.ScopeProvider
    public CoroutineScope getEventBusScope() {
        return CoroutineScopeKt.CoroutineScope(this.dispatchers.getDefault().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
    }

    @Override // io.customer.sdk.core.util.ScopeProvider
    public CoroutineScope getInAppLifecycleScope() {
        return CoroutineScopeKt.CoroutineScope(this.dispatchers.getDefault().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
    }

    @Override // io.customer.sdk.core.util.ScopeProvider
    public CoroutineScope getLifecycleListenerScope() {
        return CoroutineScopeKt.CoroutineScope(this.dispatchers.getDefault().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
    }

    @Override // io.customer.sdk.core.util.ScopeProvider
    public CoroutineScope getLocationScope() {
        return CoroutineScopeKt.CoroutineScope(this.dispatchers.getDefault().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
    }
}
