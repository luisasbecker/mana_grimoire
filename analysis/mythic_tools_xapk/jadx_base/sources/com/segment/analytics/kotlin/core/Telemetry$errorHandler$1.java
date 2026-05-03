package com.segment.analytics.kotlin.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Telemetry.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* synthetic */ class Telemetry$errorHandler$1 extends FunctionReferenceImpl implements Function1<Throwable, Unit> {
    public static final Telemetry$errorHandler$1 INSTANCE = new Telemetry$errorHandler$1();

    Telemetry$errorHandler$1() {
        super(1, TelemetryKt.class, "logError", "logError(Ljava/lang/Throwable;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        TelemetryKt.logError(p0);
    }
}
