package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: NestedScrollModifier.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020#¢\u0006\u0004\b$\u0010%J%\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020#¢\u0006\u0004\b(\u0010)J\u0018\u0010*\u001a\u00020+2\u0006\u0010!\u001a\u00020+H\u0086@¢\u0006\u0004\b,\u0010-J \u0010.\u001a\u00020+2\u0006\u0010'\u001a\u00020+2\u0006\u0010!\u001a\u00020+H\u0086@¢\u0006\u0004\b/\u00100R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001c8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u00061"}, d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "", "<init>", "()V", "nestedScrollNode", "Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "getNestedScrollNode$ui", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "setNestedScrollNode$ui", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;)V", "lastKnownParentNode", "getLastKnownParentNode$ui", "setLastKnownParentNode$ui", "calculateNestedScrollScope", "Lkotlin/Function0;", "Lkotlinx/coroutines/CoroutineScope;", "getCalculateNestedScrollScope$ui", "()Lkotlin/jvm/functions/Function0;", "setCalculateNestedScrollScope$ui", "(Lkotlin/jvm/functions/Function0;)V", "scope", "getScope$ui", "()Lkotlinx/coroutines/CoroutineScope;", "setScope$ui", "(Lkotlinx/coroutines/CoroutineScope;)V", "coroutineScope", "getCoroutineScope", "parent", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getParent$ui", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "dispatchPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "dispatchPreScroll-OzD1aCk", "(JI)J", "dispatchPostScroll", "consumed", "dispatchPostScroll-DzOQY0M", "(JJI)J", "dispatchPreFling", "Landroidx/compose/ui/unit/Velocity;", "dispatchPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchPostFling", "dispatchPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NestedScrollDispatcher {
    public static final int $stable = 8;
    private Function0<? extends CoroutineScope> calculateNestedScrollScope = new Function0<CoroutineScope>() { // from class: androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$calculateNestedScrollScope$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final CoroutineScope invoke() {
            return this.this$0.getScope();
        }
    };
    private NestedScrollNode lastKnownParentNode;
    private NestedScrollNode nestedScrollNode;
    private CoroutineScope scope;

    /* JADX WARN: Code restructure failed: missing block: B:21:0x004d, code lost:
    
        if (r0 == r1) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006a, code lost:
    
        if (r0 == r1) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006c, code lost:
    
        return r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX INFO: renamed from: dispatchPostFling-RZ2iAVY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m7499dispatchPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
        NestedScrollDispatcher$dispatchPostFling$1 nestedScrollDispatcher$dispatchPostFling$1;
        long jM9363getZero9UxMQ8M;
        if (continuation instanceof NestedScrollDispatcher$dispatchPostFling$1) {
            nestedScrollDispatcher$dispatchPostFling$1 = (NestedScrollDispatcher$dispatchPostFling$1) continuation;
            if ((nestedScrollDispatcher$dispatchPostFling$1.label & Integer.MIN_VALUE) != 0) {
                nestedScrollDispatcher$dispatchPostFling$1.label -= Integer.MIN_VALUE;
            } else {
                nestedScrollDispatcher$dispatchPostFling$1 = new NestedScrollDispatcher$dispatchPostFling$1(this, continuation);
            }
        }
        NestedScrollDispatcher$dispatchPostFling$1 nestedScrollDispatcher$dispatchPostFling$12 = nestedScrollDispatcher$dispatchPostFling$1;
        Object objMo1791onPostFlingRZ2iAVY = nestedScrollDispatcher$dispatchPostFling$12.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = nestedScrollDispatcher$dispatchPostFling$12.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objMo1791onPostFlingRZ2iAVY);
            if (getParent$ui() == null) {
                NestedScrollNode nestedScrollNode = this.lastKnownParentNode;
                if (nestedScrollNode != null) {
                    nestedScrollDispatcher$dispatchPostFling$12.label = 1;
                    objMo1791onPostFlingRZ2iAVY = nestedScrollNode.mo1791onPostFlingRZ2iAVY(j, j2, nestedScrollDispatcher$dispatchPostFling$12);
                } else {
                    jM9363getZero9UxMQ8M = Velocity.INSTANCE.m9363getZero9UxMQ8M();
                }
            } else {
                NestedScrollConnection parent$ui = getParent$ui();
                if (parent$ui != null) {
                    nestedScrollDispatcher$dispatchPostFling$12.label = 2;
                    objMo1791onPostFlingRZ2iAVY = parent$ui.mo1791onPostFlingRZ2iAVY(j, j2, nestedScrollDispatcher$dispatchPostFling$12);
                } else {
                    jM9363getZero9UxMQ8M = Velocity.INSTANCE.m9363getZero9UxMQ8M();
                }
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(objMo1791onPostFlingRZ2iAVY);
            jM9363getZero9UxMQ8M = ((Velocity) objMo1791onPostFlingRZ2iAVY).getPackedValue();
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objMo1791onPostFlingRZ2iAVY);
            jM9363getZero9UxMQ8M = ((Velocity) objMo1791onPostFlingRZ2iAVY).getPackedValue();
        }
        return Velocity.m9343boximpl(jM9363getZero9UxMQ8M);
    }

    /* JADX INFO: renamed from: dispatchPostScroll-DzOQY0M, reason: not valid java name */
    public final long m7500dispatchPostScrollDzOQY0M(long consumed, long available, int source) {
        NestedScrollConnection parent$ui = getParent$ui();
        return parent$ui != null ? parent$ui.mo1792onPostScrollDzOQY0M(consumed, available, source) : Offset.INSTANCE.m6096getZeroF1C5BW0();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX INFO: renamed from: dispatchPreFling-QWom1Mo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m7501dispatchPreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation) {
        NestedScrollDispatcher$dispatchPreFling$1 nestedScrollDispatcher$dispatchPreFling$1;
        long jM9363getZero9UxMQ8M;
        if (continuation instanceof NestedScrollDispatcher$dispatchPreFling$1) {
            nestedScrollDispatcher$dispatchPreFling$1 = (NestedScrollDispatcher$dispatchPreFling$1) continuation;
            if ((nestedScrollDispatcher$dispatchPreFling$1.label & Integer.MIN_VALUE) != 0) {
                nestedScrollDispatcher$dispatchPreFling$1.label -= Integer.MIN_VALUE;
            } else {
                nestedScrollDispatcher$dispatchPreFling$1 = new NestedScrollDispatcher$dispatchPreFling$1(this, continuation);
            }
        }
        Object objMo2114onPreFlingQWom1Mo = nestedScrollDispatcher$dispatchPreFling$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = nestedScrollDispatcher$dispatchPreFling$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objMo2114onPreFlingQWom1Mo);
            NestedScrollConnection parent$ui = getParent$ui();
            if (parent$ui == null) {
                jM9363getZero9UxMQ8M = Velocity.INSTANCE.m9363getZero9UxMQ8M();
                return Velocity.m9343boximpl(jM9363getZero9UxMQ8M);
            }
            nestedScrollDispatcher$dispatchPreFling$1.label = 1;
            objMo2114onPreFlingQWom1Mo = parent$ui.mo2114onPreFlingQWom1Mo(j, nestedScrollDispatcher$dispatchPreFling$1);
            if (objMo2114onPreFlingQWom1Mo == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objMo2114onPreFlingQWom1Mo);
        }
        jM9363getZero9UxMQ8M = ((Velocity) objMo2114onPreFlingQWom1Mo).getPackedValue();
        return Velocity.m9343boximpl(jM9363getZero9UxMQ8M);
    }

    /* JADX INFO: renamed from: dispatchPreScroll-OzD1aCk, reason: not valid java name */
    public final long m7502dispatchPreScrollOzD1aCk(long available, int source) {
        NestedScrollConnection parent$ui = getParent$ui();
        return parent$ui != null ? parent$ui.mo2115onPreScrollOzD1aCk(available, source) : Offset.INSTANCE.m6096getZeroF1C5BW0();
    }

    public final Function0<CoroutineScope> getCalculateNestedScrollScope$ui() {
        return this.calculateNestedScrollScope;
    }

    public final CoroutineScope getCoroutineScope() {
        CoroutineScope coroutineScopeInvoke = this.calculateNestedScrollScope.invoke();
        if (coroutineScopeInvoke != null) {
            return coroutineScopeInvoke;
        }
        throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
    }

    /* JADX INFO: renamed from: getLastKnownParentNode$ui, reason: from getter */
    public final NestedScrollNode getLastKnownParentNode() {
        return this.lastKnownParentNode;
    }

    /* JADX INFO: renamed from: getNestedScrollNode$ui, reason: from getter */
    public final NestedScrollNode getNestedScrollNode() {
        return this.nestedScrollNode;
    }

    public final NestedScrollConnection getParent$ui() {
        NestedScrollNode nestedScrollNode = this.nestedScrollNode;
        return nestedScrollNode != null ? nestedScrollNode.getParentNestedScrollNode$ui() : null;
    }

    /* JADX INFO: renamed from: getScope$ui, reason: from getter */
    public final CoroutineScope getScope() {
        return this.scope;
    }

    public final void setCalculateNestedScrollScope$ui(Function0<? extends CoroutineScope> function0) {
        this.calculateNestedScrollScope = function0;
    }

    public final void setLastKnownParentNode$ui(NestedScrollNode nestedScrollNode) {
        this.lastKnownParentNode = nestedScrollNode;
    }

    public final void setNestedScrollNode$ui(NestedScrollNode nestedScrollNode) {
        this.nestedScrollNode = nestedScrollNode;
    }

    public final void setScope$ui(CoroutineScope coroutineScope) {
        this.scope = coroutineScope;
    }
}
