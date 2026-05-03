package io.customer.datapipelines.util;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UiThreadRunner.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lio/customer/datapipelines/util/UiThreadRunner;", "", "<init>", "()V", "mainThreadHandler", "Landroid/os/Handler;", "run", "", "block", "Lkotlin/Function0;", "datapipelines_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UiThreadRunner {
    private final Handler mainThreadHandler = new Handler(Looper.getMainLooper());

    public final void run(final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.mainThreadHandler.post(new Runnable() { // from class: io.customer.datapipelines.util.UiThreadRunner$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                block.invoke();
            }
        });
    }
}
