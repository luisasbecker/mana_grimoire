package io.customer.datapipelines.migration;

import com.segment.analytics.kotlin.core.Analytics;
import com.segment.analytics.kotlin.core.System;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import sovran.kotlin.Store;

/* JADX INFO: compiled from: TrackingMigrationProcessor.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "io.customer.datapipelines.migration.TrackingMigrationProcessor$1$1", f = "TrackingMigrationProcessor.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
final class TrackingMigrationProcessor$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Analytics $this_with;
    int label;
    final /* synthetic */ TrackingMigrationProcessor this$0;

    /* JADX INFO: renamed from: io.customer.datapipelines.migration.TrackingMigrationProcessor$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: TrackingMigrationProcessor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.customer.datapipelines.migration.TrackingMigrationProcessor$1$1$1", f = "TrackingMigrationProcessor.kt", i = {}, l = {54}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ TrackingMigrationProcessor this$0;

        /* JADX INFO: renamed from: io.customer.datapipelines.migration.TrackingMigrationProcessor$1$1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: TrackingMigrationProcessor.kt */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* synthetic */ class C02121 extends FunctionReferenceImpl implements Function2<System, Continuation<? super Unit>, Object>, SuspendFunction {
            C02121(Object obj) {
                super(2, obj, TrackingMigrationProcessor.class, "start", "start(Lcom/segment/analytics/kotlin/core/System;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(System system, Continuation<? super Unit> continuation) {
                return ((TrackingMigrationProcessor) this.receiver).start(system, continuation);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TrackingMigrationProcessor trackingMigrationProcessor, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = trackingMigrationProcessor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (Store.subscribe$default(this.this$0.analytics.getStore(), this.this$0, Reflection.getOrCreateKotlinClass(System.class), true, null, new C02121(this.this$0), this, 8, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TrackingMigrationProcessor$1$1(Analytics analytics, TrackingMigrationProcessor trackingMigrationProcessor, Continuation<? super TrackingMigrationProcessor$1$1> continuation) {
        super(2, continuation);
        this.$this_with = analytics;
        this.this$0 = trackingMigrationProcessor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TrackingMigrationProcessor$1$1(this.$this_with, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TrackingMigrationProcessor$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (BuildersKt.withContext(this.$this_with.getAnalyticsDispatcher(), new AnonymousClass1(this.this$0, null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
