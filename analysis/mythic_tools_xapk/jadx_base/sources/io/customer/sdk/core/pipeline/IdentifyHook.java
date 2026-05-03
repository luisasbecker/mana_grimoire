package io.customer.sdk.core.pipeline;

import io.customer.base.internal.InternalCustomerIOApi;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: IdentifyHook.kt */
/* JADX INFO: loaded from: classes6.dex */
@InternalCustomerIOApi
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lio/customer/sdk/core/pipeline/IdentifyHook;", "", "getIdentifyContext", "", "", "resetContext", "", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IdentifyHook {

    /* JADX INFO: compiled from: IdentifyHook.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void resetContext(IdentifyHook identifyHook) {
        }
    }

    Map<String, Object> getIdentifyContext();

    void resetContext();
}
