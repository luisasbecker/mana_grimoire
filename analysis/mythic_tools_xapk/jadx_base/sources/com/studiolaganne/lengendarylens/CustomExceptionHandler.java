package com.studiolaganne.lengendarylens;

import java.lang.Thread;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomExceptionHandler.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/studiolaganne/lengendarylens/CustomExceptionHandler;", "Ljava/lang/Thread$UncaughtExceptionHandler;", "defaultHandler", "<init>", "(Ljava/lang/Thread$UncaughtExceptionHandler;)V", "uncaughtException", "", "thread", "Ljava/lang/Thread;", "exception", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CustomExceptionHandler implements Thread.UncaughtExceptionHandler {
    public static final int $stable = 8;
    private final Thread.UncaughtExceptionHandler defaultHandler;

    public CustomExceptionHandler(Thread.UncaughtExceptionHandler defaultHandler) {
        Intrinsics.checkNotNullParameter(defaultHandler, "defaultHandler");
        this.defaultHandler = defaultHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable exception) {
        Intrinsics.checkNotNullParameter(thread, "thread");
        Intrinsics.checkNotNullParameter(exception, "exception");
        Breadcrumbs.INSTANCE.logBreadcrumbs();
        this.defaultHandler.uncaughtException(thread, exception);
    }
}
