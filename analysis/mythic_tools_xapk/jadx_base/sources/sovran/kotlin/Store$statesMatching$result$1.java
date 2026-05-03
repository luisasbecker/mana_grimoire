package sovran.kotlin;

import androidx.exifinterface.media.ExifInterface;
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
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CoroutineScope;
import sovran.kotlin.Store;

/* JADX INFO: compiled from: Store.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004*\u00020\u0005H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "Lsovran/kotlin/Store$Container;", ExifInterface.GPS_DIRECTION_TRUE, "Lsovran/kotlin/State;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "sovran.kotlin.Store$statesMatching$result$1", f = "Store.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class Store$statesMatching$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Store.Container>>, Object> {
    final /* synthetic */ KClass $clazz;
    int label;
    final /* synthetic */ Store this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Store$statesMatching$result$1(Store store, KClass kClass, Continuation continuation) {
        super(2, continuation);
        this.this$0 = store;
        this.$clazz = kClass;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new Store$statesMatching$result$1(this.this$0, this.$clazz, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Store.Container>> continuation) {
        return ((Store$statesMatching$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        List<Store.Container> states$lib = this.this$0.getStates$lib();
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : states$lib) {
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(((Store.Container) obj2).getState().getClass()), this.$clazz)) {
                arrayList.add(obj2);
            }
        }
        return arrayList;
    }
}
