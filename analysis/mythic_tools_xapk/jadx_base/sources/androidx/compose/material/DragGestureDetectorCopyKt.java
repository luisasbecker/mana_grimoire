package androidx.compose.material;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: DragGestureDetectorCopy.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a^\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000626\u0010\u0007\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\bH\u0080@¢\u0006\u0004\b\u000f\u0010\u0010\u001aT\u0010\u0011\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000e0\b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\f0\u0013H\u0082H¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001b\u0010\u0017\u001a\u00020\u0018*\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001b\u0010!\u001a\u00020\f*\u00020\"2\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0004\b#\u0010$\"\u0010\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001e\"\u0010\u0010\u001f\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001e\"\u000e\u0010 \u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"awaitHorizontalPointerSlopOrCancellation", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "onPointerSlopReached", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "change", "", "overSlop", "", "awaitHorizontalPointerSlopOrCancellation-gDDlDlE", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitPointerSlopOrCancellation", "getDragDirectionValue", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "awaitPointerSlopOrCancellation-pn7EDYM", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isPointerUp", "", "Landroidx/compose/ui/input/pointer/PointerEvent;", "isPointerUp-DmW0f2w", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)Z", "mouseSlop", "Landroidx/compose/ui/unit/Dp;", "F", "defaultTouchSlop", "mouseToTouchSlopRatio", "pointerSlop", "Landroidx/compose/ui/platform/ViewConfiguration;", "pointerSlop-E8SPZFQ", "(Landroidx/compose/ui/platform/ViewConfiguration;I)F", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DragGestureDetectorCopyKt {
    private static final float defaultTouchSlop;
    private static final float mouseSlop;
    private static final float mouseToTouchSlopRatio;

    static {
        float fM9114constructorimpl = Dp.m9114constructorimpl(0.125f);
        mouseSlop = fM9114constructorimpl;
        float fM9114constructorimpl2 = Dp.m9114constructorimpl(18.0f);
        defaultTouchSlop = fM9114constructorimpl2;
        mouseToTouchSlopRatio = fM9114constructorimpl / fM9114constructorimpl2;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00fd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0174 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ec A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x012a -> B:56:0x0175). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x016c -> B:53:0x016e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x0190 -> B:56:0x0175). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: awaitHorizontalPointerSlopOrCancellation-gDDlDlE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m3017awaitHorizontalPointerSlopOrCancellationgDDlDlE(AwaitPointerEventScope awaitPointerEventScope, long j, int i, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1 dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1;
        AwaitPointerEventScope awaitPointerEventScope2;
        Function2<? super PointerInputChange, ? super Float, Unit> function22;
        Ref.LongRef longRef;
        DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1 dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$12;
        float f;
        float fIntBitsToFloat;
        Ref.LongRef longRef2;
        DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1 dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$13;
        float f2;
        float f3;
        int size;
        int i2;
        PointerEventPass pointerEventPass;
        Object obj;
        PointerInputChange pointerInputChange;
        Object obj2;
        int i3;
        Object objAwaitPointerEvent$default;
        if (continuation instanceof DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1) {
            dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1 = (DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1) continuation;
            if ((dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1.label -= Integer.MIN_VALUE;
            } else {
                dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1 = new DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1(continuation);
            }
        }
        Object obj3 = dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1.label;
        int i5 = 1;
        PointerEventPass pointerEventPass2 = null;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj3);
            if (m3019isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
                return null;
            }
            float fM3020pointerSlopE8SPZFQ = m3020pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), i);
            Ref.LongRef longRef3 = new Ref.LongRef();
            longRef3.element = j;
            awaitPointerEventScope2 = awaitPointerEventScope;
            function22 = function2;
            longRef = longRef3;
            dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$12 = dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1;
            f = fM3020pointerSlopE8SPZFQ;
            fIntBitsToFloat = 0.0f;
            dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$12.L$0 = function22;
            dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
            dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$12.L$2 = longRef;
            dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$12.L$3 = pointerEventPass2;
            dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$12.F$0 = f;
            dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$12.F$1 = fIntBitsToFloat;
            dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$12.label = i5;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$12, i5, pointerEventPass2);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i4 != 1) {
            if (i4 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            float f4 = dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1.F$1;
            float f5 = dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1.F$0;
            PointerInputChange pointerInputChange2 = (PointerInputChange) dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1.L$3;
            Ref.LongRef longRef4 = (Ref.LongRef) dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1.L$2;
            AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1.L$1;
            Function2<? super PointerInputChange, ? super Float, Unit> function23 = (Function2) dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1.L$0;
            ResultKt.throwOnFailure(obj3);
            fIntBitsToFloat = f4;
            pointerEventPass = null;
            awaitPointerEventScope2 = awaitPointerEventScope3;
            longRef2 = longRef4;
            dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$13 = dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1;
            f = f5;
            function22 = function23;
            if (pointerInputChange2.isConsumed()) {
                return pointerEventPass;
            }
            dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$12 = dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$13;
            longRef = longRef2;
            pointerEventPass2 = pointerEventPass;
            i5 = 1;
            dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$12.L$0 = function22;
            dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
            dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$12.L$2 = longRef;
            dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$12.L$3 = pointerEventPass2;
            dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$12.F$0 = f;
            dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$12.F$1 = fIntBitsToFloat;
            dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$12.label = i5;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$12, i5, pointerEventPass2);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
                float f6 = f;
                f3 = fIntBitsToFloat;
                obj3 = objAwaitPointerEvent$default;
                longRef2 = longRef;
                dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$13 = dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$12;
                f2 = f6;
                PointerEvent pointerEvent = (PointerEvent) obj3;
                List<PointerInputChange> changes = pointerEvent.getChanges();
                size = changes.size();
                i2 = 0;
                while (true) {
                    if (i2 < size) {
                        pointerEventPass = pointerEventPass2;
                        obj = pointerEventPass;
                        break;
                    }
                    obj = changes.get(i2);
                    pointerEventPass = pointerEventPass2;
                    i3 = i2;
                    if (PointerId.m7620equalsimpl0(((PointerInputChange) obj).getId(), longRef2.element)) {
                        break;
                    }
                    i2 = i3 + 1;
                    pointerEventPass2 = pointerEventPass;
                }
                Intrinsics.checkNotNull(obj);
                pointerInputChange = (PointerInputChange) obj;
                if (pointerInputChange.isConsumed()) {
                    return pointerEventPass;
                }
                if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                    List<PointerInputChange> changes2 = pointerEvent.getChanges();
                    int size2 = changes2.size();
                    int i6 = 0;
                    while (true) {
                        if (i6 >= size2) {
                            obj2 = pointerEventPass;
                            break;
                        }
                        obj2 = changes2.get(i6);
                        if (((PointerInputChange) obj2).getPressed()) {
                            break;
                        }
                        i6++;
                    }
                    PointerInputChange pointerInputChange3 = (PointerInputChange) obj2;
                    if (pointerInputChange3 == null) {
                        return pointerEventPass;
                    }
                    longRef2.element = pointerInputChange3.getId();
                    fIntBitsToFloat = f3;
                    f = f2;
                } else {
                    fIntBitsToFloat = f3 + (Float.intBitsToFloat((int) (pointerInputChange.getPosition() >> 32)) - Float.intBitsToFloat((int) (pointerInputChange.getPreviousPosition() >> 32)));
                    if (Math.abs(fIntBitsToFloat) < f2) {
                        PointerEventPass pointerEventPass3 = PointerEventPass.Final;
                        dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$13.L$0 = function22;
                        dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$13.L$1 = awaitPointerEventScope2;
                        dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$13.L$2 = longRef2;
                        dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$13.L$3 = pointerInputChange;
                        dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$13.F$0 = f2;
                        dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$13.F$1 = fIntBitsToFloat;
                        dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$13.label = 2;
                        if (awaitPointerEventScope2.awaitPointerEvent(pointerEventPass3, dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$13) != coroutine_suspended) {
                            f = f2;
                            pointerInputChange2 = pointerInputChange;
                            if (pointerInputChange2.isConsumed()) {
                            }
                        }
                    } else {
                        function22.invoke(pointerInputChange, Boxing.boxFloat(fIntBitsToFloat - (Math.signum(fIntBitsToFloat) * f2)));
                        if (pointerInputChange.isConsumed()) {
                            return pointerInputChange;
                        }
                        f = f2;
                        fIntBitsToFloat = 0.0f;
                    }
                }
                dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$12 = dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$13;
                longRef = longRef2;
                pointerEventPass2 = pointerEventPass;
                i5 = 1;
                dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$12.L$0 = function22;
                dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
                dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$12.L$2 = longRef;
                dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$12.L$3 = pointerEventPass2;
                dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$12.F$0 = f;
                dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$12.F$1 = fIntBitsToFloat;
                dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$12.label = i5;
                objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$12, i5, pointerEventPass2);
                if (objAwaitPointerEvent$default != coroutine_suspended) {
                }
            }
            return coroutine_suspended;
        }
        float f7 = dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1.F$1;
        float f8 = dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1.F$0;
        Ref.LongRef longRef5 = (Ref.LongRef) dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1.L$2;
        AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1.L$1;
        Function2<? super PointerInputChange, ? super Float, Unit> function24 = (Function2) dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1.L$0;
        ResultKt.throwOnFailure(obj3);
        DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1 dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$14 = dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1;
        f3 = f7;
        awaitPointerEventScope2 = awaitPointerEventScope4;
        dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$13 = dragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$14;
        f2 = f8;
        function22 = function24;
        longRef2 = longRef5;
        PointerEvent pointerEvent2 = (PointerEvent) obj3;
        List<PointerInputChange> changes3 = pointerEvent2.getChanges();
        size = changes3.size();
        i2 = 0;
        while (true) {
            if (i2 < size) {
            }
            i2 = i3 + 1;
            pointerEventPass2 = pointerEventPass;
        }
        Intrinsics.checkNotNull(obj);
        pointerInputChange = (PointerInputChange) obj;
        if (pointerInputChange.isConsumed()) {
        }
    }

    /* JADX INFO: renamed from: awaitPointerSlopOrCancellation-pn7EDYM, reason: not valid java name */
    private static final Object m3018awaitPointerSlopOrCancellationpn7EDYM(AwaitPointerEventScope awaitPointerEventScope, long j, int i, Function2<? super PointerInputChange, ? super Float, Unit> function2, Function1<? super Offset, Float> function1, Continuation<? super PointerInputChange> continuation) {
        float f;
        PointerInputChange pointerInputChange;
        float f2;
        PointerInputChange pointerInputChange2;
        if (m3019isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
            return null;
        }
        float fM3020pointerSlopE8SPZFQ = m3020pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), i);
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = j;
        float f3 = 0.0f;
        while (true) {
            PointerEvent pointerEvent = (PointerEvent) AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, continuation, 1, null);
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    f = f3;
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes.get(i3);
                f = f3;
                if (Boolean.valueOf(PointerId.m7620equalsimpl0(pointerInputChange.getId(), longRef.element)).booleanValue()) {
                    break;
                }
                i3++;
                f3 = f;
            }
            Intrinsics.checkNotNull(pointerInputChange);
            PointerInputChange pointerInputChange3 = pointerInputChange;
            if (pointerInputChange3.isConsumed()) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                int size2 = changes2.size();
                while (true) {
                    if (i2 >= size2) {
                        pointerInputChange2 = null;
                        break;
                    }
                    pointerInputChange2 = changes2.get(i2);
                    if (Boolean.valueOf(pointerInputChange2.getPressed()).booleanValue()) {
                        break;
                    }
                    i2++;
                }
                PointerInputChange pointerInputChange4 = pointerInputChange2;
                if (pointerInputChange4 == null) {
                    return null;
                }
                longRef.element = pointerInputChange4.getId();
                f2 = f;
            } else {
                float fFloatValue = f + (function1.invoke(Offset.m6069boximpl(pointerInputChange3.getPosition())).floatValue() - function1.invoke(Offset.m6069boximpl(pointerInputChange3.getPreviousPosition())).floatValue());
                if (Math.abs(fFloatValue) < fM3020pointerSlopE8SPZFQ) {
                    awaitPointerEventScope.awaitPointerEvent(PointerEventPass.Final, continuation);
                    if (pointerInputChange3.isConsumed()) {
                        return null;
                    }
                    f2 = fFloatValue;
                } else {
                    function2.invoke(pointerInputChange3, Float.valueOf(fFloatValue - (Math.signum(fFloatValue) * fM3020pointerSlopE8SPZFQ)));
                    if (pointerInputChange3.isConsumed()) {
                        return pointerInputChange3;
                    }
                    f2 = 0.0f;
                    f3 = f2;
                }
            }
            f3 = f2;
        }
    }

    /* JADX INFO: renamed from: isPointerUp-DmW0f2w, reason: not valid java name */
    private static final boolean m3019isPointerUpDmW0f2w(PointerEvent pointerEvent, long j) {
        PointerInputChange pointerInputChange;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                pointerInputChange = null;
                break;
            }
            pointerInputChange = changes.get(i);
            if (PointerId.m7620equalsimpl0(pointerInputChange.getId(), j)) {
                break;
            }
            i++;
        }
        PointerInputChange pointerInputChange2 = pointerInputChange;
        if (pointerInputChange2 != null && pointerInputChange2.getPressed()) {
            z = true;
        }
        return true ^ z;
    }

    /* JADX INFO: renamed from: pointerSlop-E8SPZFQ, reason: not valid java name */
    public static final float m3020pointerSlopE8SPZFQ(ViewConfiguration viewConfiguration, int i) {
        return PointerType.m7709equalsimpl0(i, PointerType.INSTANCE.m7714getMouseT8wyACA()) ? viewConfiguration.getTouchSlop() * mouseToTouchSlopRatio : viewConfiguration.getTouchSlop();
    }
}
