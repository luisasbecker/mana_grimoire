package sovran.kotlin;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CoroutineScope;
import sovran.kotlin.Store;

/* JADX INFO: compiled from: Store.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00020\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0003*\u00020\u0005H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "Lsovran/kotlin/Store$Subscription;", "Lsovran/kotlin/State;", "StateT", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "sovran.kotlin.Store$subscribersForState$result$1", f = "Store.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class Store$subscribersForState$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Store.Subscription<? extends State>>>, Object> {
    final /* synthetic */ KClass $stateClazz;
    int label;
    final /* synthetic */ Store this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Store$subscribersForState$result$1(Store store, KClass kClass, Continuation continuation) {
        super(2, continuation);
        this.this$0 = store;
        this.$stateClazz = kClass;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new Store$subscribersForState$result$1(this.this$0, this.$stateClazz, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Store.Subscription<? extends State>>> continuation) {
        return ((Store$subscribersForState$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        List<Store.Subscription<? extends State>> subscriptions$lib = this.this$0.getSubscriptions$lib();
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : subscriptions$lib) {
            if (Intrinsics.areEqual(((Store.Subscription) obj2).getKey(), this.$stateClazz)) {
                arrayList.add(obj2);
            }
        }
        return arrayList;
    }
}
