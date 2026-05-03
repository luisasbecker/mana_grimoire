package io.customer.sdk.core.util;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: DispatchersProvider.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007¨\u0006\f"}, d2 = {"Lio/customer/sdk/core/util/SdkDispatchers;", "Lio/customer/sdk/core/util/DispatchersProvider;", "<init>", "()V", "background", "Lkotlinx/coroutines/CoroutineDispatcher;", "getBackground", "()Lkotlinx/coroutines/CoroutineDispatcher;", "main", "getMain", "default", "getDefault", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SdkDispatchers implements DispatchersProvider {
    @Override // io.customer.sdk.core.util.DispatchersProvider
    public CoroutineDispatcher getBackground() {
        return Dispatchers.getIO();
    }

    @Override // io.customer.sdk.core.util.DispatchersProvider
    public CoroutineDispatcher getDefault() {
        return Dispatchers.getDefault();
    }

    @Override // io.customer.sdk.core.util.DispatchersProvider
    public CoroutineDispatcher getMain() {
        return Dispatchers.getMain();
    }
}
