package com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel;

import com.revenuecat.purchases.PurchasesException;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenViewState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: VirtualCurrencyBalancesScreenViewModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/revenuecat/purchases/ui/revenuecatui/customercenter/views/VirtualCurrencyBalancesScreenViewState;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.VirtualCurrencyBalancesScreenViewModel$viewState$1", f = "VirtualCurrencyBalancesScreenViewModel.kt", i = {0, 1, 2}, l = {24, 28, 31, 33}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "$this$flow"}, s = {"L$0", "L$0", "L$0"})
final class VirtualCurrencyBalancesScreenViewModel$viewState$1 extends SuspendLambda implements Function2<FlowCollector<? super VirtualCurrencyBalancesScreenViewState>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ VirtualCurrencyBalancesScreenViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VirtualCurrencyBalancesScreenViewModel$viewState$1(VirtualCurrencyBalancesScreenViewModel virtualCurrencyBalancesScreenViewModel, Continuation<? super VirtualCurrencyBalancesScreenViewModel$viewState$1> continuation) {
        super(2, continuation);
        this.this$0 = virtualCurrencyBalancesScreenViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        VirtualCurrencyBalancesScreenViewModel$viewState$1 virtualCurrencyBalancesScreenViewModel$viewState$1 = new VirtualCurrencyBalancesScreenViewModel$viewState$1(this.this$0, continuation);
        virtualCurrencyBalancesScreenViewModel$viewState$1.L$0 = obj;
        return virtualCurrencyBalancesScreenViewModel$viewState$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super VirtualCurrencyBalancesScreenViewState> flowCollector, Continuation<? super Unit> continuation) {
        return ((VirtualCurrencyBalancesScreenViewModel$viewState$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0098, code lost:
    
        if (r1.emit(new com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenViewState.Loaded(kotlin.collections.CollectionsKt.sortedWith(((com.revenuecat.purchases.virtualcurrencies.VirtualCurrencies) r8).getAll().values(), new com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.VirtualCurrencyBalancesScreenViewModel$viewState$1$invokeSuspend$$inlined$sortedByDescending$1())), r7) != r0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b0, code lost:
    
        if (r1.emit(new com.revenuecat.purchases.ui.revenuecatui.customercenter.views.VirtualCurrencyBalancesScreenViewState.Error(r8.getError()), r7) != r0) goto L34;
     */
    /* JADX WARN: Type inference failed for: r1v0, types: [int, kotlinx.coroutines.flow.FlowCollector] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    jadx.core.utils.exceptions.JadxRuntimeException: Not class type: int
    	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:59)
    	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:32)
    	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:508)
    	at jadx.core.dex.nodes.utils.TypeUtils.getClassTypeVars(TypeUtils.java:53)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:175)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r1 = this.label;
        try {
        } catch (PurchasesException e) {
            this.L$0 = null;
            this.label = 4;
        }
        if (r1 == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector2 = (FlowCollector) this.L$0;
            this.L$0 = flowCollector2;
            this.label = 1;
            if (flowCollector2.emit(VirtualCurrencyBalancesScreenViewState.Loading.INSTANCE, this) != coroutine_suspended) {
                flowCollector = flowCollector2;
            }
            return coroutine_suspended;
        }
        if (r1 == 1) {
            flowCollector = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            if (r1 != 2) {
                if (r1 == 3) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (r1 != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
            flowCollector = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
            this.L$0 = flowCollector;
            this.label = 3;
        }
        this.this$0.purchases.invalidateVirtualCurrenciesCache();
        this.L$0 = flowCollector;
        this.label = 2;
        obj = this.this$0.purchases.awaitGetVirtualCurrencies(this);
        if (obj != coroutine_suspended) {
            this.L$0 = flowCollector;
            this.label = 3;
        }
        return coroutine_suspended;
    }
}
