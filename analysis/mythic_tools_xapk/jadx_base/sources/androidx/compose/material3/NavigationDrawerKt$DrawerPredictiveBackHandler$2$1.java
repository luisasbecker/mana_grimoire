package androidx.compose.material3;

import androidx.activity.BackEventCompat;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.material3.NavigationDrawerKt$DrawerPredictiveBackHandler$2$1;
import androidx.compose.material3.internal.PredictiveBack;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: NavigationDrawer.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0010\u0010\u0002\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u0003H\n"}, d2 = {"<anonymous>", "", "progress", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/activity/BackEventCompat;", "Landroidx/compose/material3/internal/BackEventCompat;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$DrawerPredictiveBackHandler$2$1", f = "NavigationDrawer.kt", i = {}, l = {957, 983, 983, 983}, m = "invokeSuspend", n = {}, s = {})
final class NavigationDrawerKt$DrawerPredictiveBackHandler$2$1 extends SuspendLambda implements Function2<Flow<? extends BackEventCompat>, Continuation<? super Unit>, Object> {
    final /* synthetic */ DrawerPredictiveBackState $drawerPredictiveBackState;
    final /* synthetic */ DrawerState $drawerState;
    final /* synthetic */ boolean $isRtl;
    final /* synthetic */ Ref.FloatRef $maxScaleXDistanceGrow;
    final /* synthetic */ Ref.FloatRef $maxScaleXDistanceShrink;
    final /* synthetic */ Ref.FloatRef $maxScaleYDistance;
    final /* synthetic */ CoroutineScope $scope;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: androidx.compose.material3.NavigationDrawerKt$DrawerPredictiveBackHandler$2$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: NavigationDrawer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$DrawerPredictiveBackHandler$2$1$2", f = "NavigationDrawer.kt", i = {}, l = {974}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DrawerPredictiveBackState $drawerPredictiveBackState;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(DrawerPredictiveBackState drawerPredictiveBackState, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$drawerPredictiveBackState = drawerPredictiveBackState;
        }

        static final Unit invokeSuspend$lambda$0(DrawerPredictiveBackState drawerPredictiveBackState, float f, float f2) {
            drawerPredictiveBackState.setScaleXDistance(f);
            return Unit.INSTANCE;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$drawerPredictiveBackState, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                float scaleXDistance = this.$drawerPredictiveBackState.getScaleXDistance();
                final DrawerPredictiveBackState drawerPredictiveBackState = this.$drawerPredictiveBackState;
                this.label = 1;
                if (SuspendAnimationKt.animate$default(scaleXDistance, 0.0f, 0.0f, null, new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$DrawerPredictiveBackHandler$2$1$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return NavigationDrawerKt$DrawerPredictiveBackHandler$2$1.AnonymousClass2.invokeSuspend$lambda$0(drawerPredictiveBackState, ((Float) obj2).floatValue(), ((Float) obj3).floatValue());
                    }
                }, this, 12, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.$drawerPredictiveBackState.clear();
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NavigationDrawerKt$DrawerPredictiveBackHandler$2$1(DrawerPredictiveBackState drawerPredictiveBackState, CoroutineScope coroutineScope, DrawerState drawerState, boolean z, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, Ref.FloatRef floatRef3, Continuation<? super NavigationDrawerKt$DrawerPredictiveBackHandler$2$1> continuation) {
        super(2, continuation);
        this.$drawerPredictiveBackState = drawerPredictiveBackState;
        this.$scope = coroutineScope;
        this.$drawerState = drawerState;
        this.$isRtl = z;
        this.$maxScaleXDistanceGrow = floatRef;
        this.$maxScaleXDistanceShrink = floatRef2;
        this.$maxScaleYDistance = floatRef3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        NavigationDrawerKt$DrawerPredictiveBackHandler$2$1 navigationDrawerKt$DrawerPredictiveBackHandler$2$1 = new NavigationDrawerKt$DrawerPredictiveBackHandler$2$1(this.$drawerPredictiveBackState, this.$scope, this.$drawerState, this.$isRtl, this.$maxScaleXDistanceGrow, this.$maxScaleXDistanceShrink, this.$maxScaleYDistance, continuation);
        navigationDrawerKt$DrawerPredictiveBackHandler$2$1.L$0 = obj;
        return navigationDrawerKt$DrawerPredictiveBackHandler$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Flow<? extends BackEventCompat> flow, Continuation<? super Unit> continuation) {
        return invoke2((Flow<BackEventCompat>) flow, continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Flow<BackEventCompat> flow, Continuation<? super Unit> continuation) {
        return ((NavigationDrawerKt$DrawerPredictiveBackHandler$2$1) create(flow, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x007e, code lost:
    
        if (r13.$drawerState.close(r13) == r1) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ac, code lost:
    
        if (r13.$drawerState.close(r13) != r1) goto L33;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            try {
            } catch (CancellationException unused) {
                this.$drawerPredictiveBackState.clear();
                if (this.$drawerPredictiveBackState.getSwipeEdgeMatchesDrawer()) {
                    BuildersKt__Builders_commonKt.launch$default(this.$scope, null, null, new AnonymousClass2(this.$drawerPredictiveBackState, null), 3, null);
                }
                this.label = 3;
            }
        } catch (Throwable th) {
            if (this.$drawerPredictiveBackState.getSwipeEdgeMatchesDrawer()) {
                BuildersKt__Builders_commonKt.launch$default(this.$scope, null, null, new AnonymousClass2(this.$drawerPredictiveBackState, null), 3, null);
            }
            this.L$0 = th;
            this.label = 4;
            if (this.$drawerState.close(this) != coroutine_suspended) {
                throw th;
            }
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow flow = (Flow) this.L$0;
            final DrawerPredictiveBackState drawerPredictiveBackState = this.$drawerPredictiveBackState;
            final boolean z = this.$isRtl;
            final Ref.FloatRef floatRef = this.$maxScaleXDistanceGrow;
            final Ref.FloatRef floatRef2 = this.$maxScaleXDistanceShrink;
            final Ref.FloatRef floatRef3 = this.$maxScaleYDistance;
            this.label = 1;
            if (flow.collect(new FlowCollector() { // from class: androidx.compose.material3.NavigationDrawerKt$DrawerPredictiveBackHandler$2$1.1
                public final Object emit(BackEventCompat backEventCompat, Continuation<? super Unit> continuation) {
                    drawerPredictiveBackState.update(PredictiveBack.INSTANCE.transform$material3(backEventCompat.getProgress()), backEventCompat.getSwipeEdge() == 0, z, floatRef.element, floatRef2.element, floatRef3.element);
                    return Unit.INSTANCE;
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((BackEventCompat) obj2, (Continuation<? super Unit>) continuation);
                }
            }, this) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i == 2 || i == 3) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            if (i != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Throwable th2 = (Throwable) this.L$0;
            ResultKt.throwOnFailure(obj);
            throw th2;
        }
        ResultKt.throwOnFailure(obj);
        if (this.$drawerPredictiveBackState.getSwipeEdgeMatchesDrawer()) {
            BuildersKt__Builders_commonKt.launch$default(this.$scope, null, null, new AnonymousClass2(this.$drawerPredictiveBackState, null), 3, null);
        }
        this.label = 2;
    }
}
