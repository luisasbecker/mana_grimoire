package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: BottomSheetScaffold.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$1$1", f = "BottomSheetScaffold.kt", i = {}, l = {344, 346}, m = "invokeSuspend", n = {}, s = {})
final class BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SheetState $state;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$1$1(SheetState sheetState, Continuation<? super BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$1$1> continuation) {
        super(2, continuation);
        this.$state = sheetState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$1$1(this.$state, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0031, code lost:
    
        if (r1.hide(r4) == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003d, code lost:
    
        if (r1.partialExpand(r4) == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003f, code lost:
    
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            boolean skipHiddenState = this.$state.getSkipHiddenState();
            SheetState sheetState = this.$state;
            if (skipHiddenState) {
                this.label = 2;
            } else {
                this.label = 1;
            }
        } else {
            if (i != 1 && i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
