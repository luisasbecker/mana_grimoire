package com.segment.analytics.kotlin.core.compat;

import com.segment.analytics.kotlin.core.compat.Builders;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Builders.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* synthetic */ class Builders$Companion$buildJsonObject$1 extends FunctionReferenceImpl implements Function1<Builders.JsonObjectBuilder, Unit> {
    Builders$Companion$buildJsonObject$1(Object obj) {
        super(1, obj, Consumer.class, "accept", "accept(Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Builders.JsonObjectBuilder jsonObjectBuilder) {
        invoke2(jsonObjectBuilder);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Builders.JsonObjectBuilder p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((Consumer) this.receiver).accept(p0);
    }
}
