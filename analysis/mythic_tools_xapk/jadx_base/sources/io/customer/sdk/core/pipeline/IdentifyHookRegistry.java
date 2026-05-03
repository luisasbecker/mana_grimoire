package io.customer.sdk.core.pipeline;

import io.customer.base.internal.InternalCustomerIOApi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IdentifyHookRegistry.kt */
/* JADX INFO: loaded from: classes6.dex */
@InternalCustomerIOApi
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bJ\u0006\u0010\f\u001a\u00020\bR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lio/customer/sdk/core/pipeline/IdentifyHookRegistry;", "", "<init>", "()V", "hooks", "", "Lio/customer/sdk/core/pipeline/IdentifyHook;", "register", "", "hook", "getAll", "", "clear", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IdentifyHookRegistry {
    private final List<IdentifyHook> hooks = new ArrayList();

    public final synchronized void clear() {
        this.hooks.clear();
    }

    public final synchronized List<IdentifyHook> getAll() {
        return CollectionsKt.toList(this.hooks);
    }

    public final synchronized void register(IdentifyHook hook) {
        Intrinsics.checkNotNullParameter(hook, "hook");
        if (!this.hooks.contains(hook)) {
            this.hooks.add(hook);
        }
    }
}
