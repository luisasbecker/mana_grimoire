package androidx.room;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.ThreadContextElementKt;

/* JADX INFO: compiled from: RoomDatabaseExt.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\t\u001a9\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b*\u00020\b2\u001c\u0010\f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\rH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"acquireTransactionThread", "Lkotlin/coroutines/ContinuationInterceptor;", "Ljava/util/concurrent/Executor;", "controlJob", "Lkotlinx/coroutines/Job;", "(Ljava/util/concurrent/Executor;Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createTransactionContext", "Lkotlin/coroutines/CoroutineContext;", "Landroidx/room/RoomDatabase;", "(Landroidx/room/RoomDatabase;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTransaction", "R", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Landroidx/room/RoomDatabase;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "room-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class RoomDatabaseKt {

    /* JADX INFO: renamed from: androidx.room.RoomDatabaseKt$createTransactionContext$1, reason: invalid class name */
    /* JADX INFO: compiled from: RoomDatabaseExt.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "androidx.room.RoomDatabaseKt", f = "RoomDatabaseExt.kt", i = {0, 0}, l = {100}, m = "createTransactionContext", n = {"$this$createTransactionContext", "controlJob"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RoomDatabaseKt.createTransactionContext(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.room.RoomDatabaseKt$withTransaction$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RoomDatabaseExt.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "androidx.room.RoomDatabaseKt", f = "RoomDatabaseExt.kt", i = {0, 0}, l = {51, 52}, m = "withTransaction", n = {"$this$withTransaction", "block"}, s = {"L$0", "L$1"})
    static final class C05591<R> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C05591(Continuation<? super C05591> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RoomDatabaseKt.withTransaction(null, null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.room.RoomDatabaseKt$withTransaction$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RoomDatabaseExt.kt */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "androidx.room.RoomDatabaseKt$withTransaction$2", f = "RoomDatabaseExt.kt", i = {0}, l = {59}, m = "invokeSuspend", n = {"transactionElement"}, s = {"L$0"})
    static final class C05602<R> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
        final /* synthetic */ Function1<Continuation<? super R>, Object> $block;
        final /* synthetic */ RoomDatabase $this_withTransaction;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C05602(RoomDatabase roomDatabase, Function1<? super Continuation<? super R>, ? extends Object> function1, Continuation<? super C05602> continuation) {
            super(2, continuation);
            this.$this_withTransaction = roomDatabase;
            this.$block = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C05602 c05602 = new C05602(this.$this_withTransaction, this.$block, continuation);
            c05602.L$0 = obj;
            return c05602;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super R> continuation) {
            return ((C05602) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            TransactionElement transactionElement;
            Throwable th;
            TransactionElement transactionElement2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineContext.Element element = ((CoroutineScope) this.L$0).getCoroutineContext().get(TransactionElement.INSTANCE);
                    Intrinsics.checkNotNull(element);
                    transactionElement = (TransactionElement) element;
                    transactionElement.acquire();
                    try {
                        this.$this_withTransaction.beginTransaction();
                        try {
                            Function1<Continuation<? super R>, Object> function1 = this.$block;
                            this.L$0 = transactionElement;
                            this.label = 1;
                            Object objInvoke = function1.invoke(this);
                            if (objInvoke == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            transactionElement2 = transactionElement;
                            obj = objInvoke;
                        } catch (Throwable th2) {
                            th = th2;
                            this.$this_withTransaction.endTransaction();
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        transactionElement.release();
                        throw th;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    TransactionElement transactionElement3 = (TransactionElement) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        transactionElement2 = transactionElement3;
                    } catch (Throwable th4) {
                        th = th4;
                        this.$this_withTransaction.endTransaction();
                        throw th;
                    }
                }
                this.$this_withTransaction.setTransactionSuccessful();
                this.$this_withTransaction.endTransaction();
                transactionElement2.release();
                return obj;
            } catch (Throwable th5) {
                th = th5;
                transactionElement = coroutine_suspended;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object acquireTransactionThread(Executor executor, final Job job, Continuation<? super ContinuationInterceptor> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.room.RoomDatabaseKt$acquireTransactionThread$2$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
        });
        try {
            executor.execute(new Runnable() { // from class: androidx.room.RoomDatabaseKt$acquireTransactionThread$2$2

                /* JADX INFO: renamed from: androidx.room.RoomDatabaseKt$acquireTransactionThread$2$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: RoomDatabaseExt.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "androidx.room.RoomDatabaseKt$acquireTransactionThread$2$2$1", f = "RoomDatabaseExt.kt", i = {}, l = {125}, m = "invokeSuspend", n = {}, s = {})
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ CancellableContinuation<ContinuationInterceptor> $continuation;
                    final /* synthetic */ Job $controlJob;
                    private /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    AnonymousClass1(CancellableContinuation<? super ContinuationInterceptor> cancellableContinuation, Job job, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$continuation = cancellableContinuation;
                        this.$controlJob = job;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$continuation, this.$controlJob, continuation);
                        anonymousClass1.L$0 = obj;
                        return anonymousClass1;
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
                            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                            CancellableContinuation<ContinuationInterceptor> cancellableContinuation = this.$continuation;
                            Result.Companion companion = Result.INSTANCE;
                            CoroutineContext.Element element = coroutineScope.getCoroutineContext().get(ContinuationInterceptor.INSTANCE);
                            Intrinsics.checkNotNull(element);
                            cancellableContinuation.resumeWith(Result.m11445constructorimpl(element));
                            this.label = 1;
                            if (this.$controlJob.join(this) == coroutine_suspended) {
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

                @Override // java.lang.Runnable
                public final void run() throws InterruptedException {
                    BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass1(cancellableContinuationImpl2, job, null), 1, null);
                }
            });
        } catch (RejectedExecutionException e) {
            cancellableContinuationImpl2.cancel(new IllegalStateException("Unable to acquire a thread to perform the database transaction.", e));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object createTransactionContext(RoomDatabase roomDatabase, Continuation<? super CoroutineContext> continuation) {
        AnonymousClass1 anonymousClass1;
        RoomDatabase roomDatabase2;
        CompletableJob completableJob;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final CompletableJob completableJobJob$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
            Job job = (Job) anonymousClass1.get$context().get(Job.INSTANCE);
            if (job != null) {
                job.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.room.RoomDatabaseKt.createTransactionContext.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th) {
                        Job.DefaultImpls.cancel$default((Job) completableJobJob$default, (CancellationException) null, 1, (Object) null);
                    }
                });
            }
            anonymousClass1.L$0 = roomDatabase;
            anonymousClass1.L$1 = completableJobJob$default;
            anonymousClass1.label = 1;
            Object objAcquireTransactionThread = acquireTransactionThread(roomDatabase.getTransactionExecutor(), completableJobJob$default, anonymousClass1);
            if (objAcquireTransactionThread == coroutine_suspended) {
                return coroutine_suspended;
            }
            roomDatabase2 = roomDatabase;
            completableJob = completableJobJob$default;
            obj = objAcquireTransactionThread;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            completableJob = (CompletableJob) anonymousClass1.L$1;
            roomDatabase2 = (RoomDatabase) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) obj;
        return continuationInterceptor.plus(new TransactionElement(completableJob, continuationInterceptor)).plus(ThreadContextElementKt.asContextElement(roomDatabase2.getSuspendingTransactionId(), Boxing.boxInt(System.identityHashCode(completableJob))));
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0068, code lost:
    
        if (r7 == r1) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0081 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0082 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <R> Object withTransaction(RoomDatabase roomDatabase, Function1<? super Continuation<? super R>, ? extends Object> function1, Continuation<? super R> continuation) {
        C05591 c05591;
        ContinuationInterceptor transactionDispatcher;
        ContinuationInterceptor continuationInterceptor;
        if (continuation instanceof C05591) {
            c05591 = (C05591) continuation;
            if ((c05591.label & Integer.MIN_VALUE) != 0) {
                c05591.label -= Integer.MIN_VALUE;
            } else {
                c05591 = new C05591(continuation);
            }
        }
        Object objCreateTransactionContext = c05591.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c05591.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objCreateTransactionContext);
            TransactionElement transactionElement = (TransactionElement) c05591.get$context().get(TransactionElement.INSTANCE);
            if (transactionElement != null && (transactionDispatcher = transactionElement.getTransactionDispatcher()) != null) {
                continuationInterceptor = transactionDispatcher;
                C05602 c05602 = new C05602(roomDatabase, function1, null);
                c05591.L$0 = null;
                c05591.L$1 = null;
                c05591.label = 2;
                Object objWithContext = BuildersKt.withContext(continuationInterceptor, c05602, c05591);
                return objWithContext != coroutine_suspended ? coroutine_suspended : objWithContext;
            }
            c05591.L$0 = roomDatabase;
            c05591.L$1 = function1;
            c05591.label = 1;
            objCreateTransactionContext = createTransactionContext(roomDatabase, c05591);
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objCreateTransactionContext);
                return objCreateTransactionContext;
            }
            function1 = (Function1) c05591.L$1;
            roomDatabase = (RoomDatabase) c05591.L$0;
            ResultKt.throwOnFailure(objCreateTransactionContext);
        }
        continuationInterceptor = (CoroutineContext) objCreateTransactionContext;
        C05602 c056022 = new C05602(roomDatabase, function1, null);
        c05591.L$0 = null;
        c05591.L$1 = null;
        c05591.label = 2;
        Object objWithContext2 = BuildersKt.withContext(continuationInterceptor, c056022, c05591);
        if (objWithContext2 != coroutine_suspended) {
        }
    }
}
