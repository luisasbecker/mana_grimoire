package io.customer.sdk.core.util;

import android.os.Handler;
import android.os.Looper;
import io.customer.base.internal.InternalCustomerIOApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MainThreadPoster.kt */
/* JADX INFO: loaded from: classes6.dex */
@InternalCustomerIOApi
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lio/customer/sdk/core/util/HandlerMainThreadPoster;", "Lio/customer/sdk/core/util/MainThreadPoster;", "<init>", "()V", "handler", "Landroid/os/Handler;", "post", "", "block", "Lkotlin/Function0;", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HandlerMainThreadPoster implements MainThreadPoster {
    private final Handler handler = new Handler(Looper.getMainLooper());

    @Override // io.customer.sdk.core.util.MainThreadPoster
    public void post(final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.handler.post(new Runnable() { // from class: io.customer.sdk.core.util.HandlerMainThreadPoster$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                block.invoke();
            }
        });
    }
}
