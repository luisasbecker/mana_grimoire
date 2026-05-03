package com.studiolaganne.lengendarylens;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.studiolaganne.lengendarylens.MainActivity$downloadDatabasesSequentially$1$1$deferred$1", f = "MainActivity.kt", i = {}, l = {2015}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class MainActivity$downloadDatabasesSequentially$1$1$deferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.IntRef $currentDb;
    final /* synthetic */ UpdatableMTGHelper $helper;
    final /* synthetic */ int $totalDbs;
    int label;
    final /* synthetic */ MainActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MainActivity$downloadDatabasesSequentially$1$1$deferred$1(MainActivity mainActivity, UpdatableMTGHelper updatableMTGHelper, Ref.IntRef intRef, int i, Continuation<? super MainActivity$downloadDatabasesSequentially$1$1$deferred$1> continuation) {
        super(2, continuation);
        this.this$0 = mainActivity;
        this.$helper = updatableMTGHelper;
        this.$currentDb = intRef;
        this.$totalDbs = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivity$downloadDatabasesSequentially$1$1$deferred$1(this.this$0, this.$helper, this.$currentDb, this.$totalDbs, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainActivity$downloadDatabasesSequentially$1$1$deferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.downloadDatabase(this.$helper, this.$currentDb.element, this.$totalDbs, this) == coroutine_suspended) {
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
