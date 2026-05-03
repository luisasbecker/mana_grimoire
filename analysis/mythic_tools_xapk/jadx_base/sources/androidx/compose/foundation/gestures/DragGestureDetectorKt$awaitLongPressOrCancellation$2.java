package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.core.app.NotificationCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import org.opencv.imgcodecs.Imgcodecs;

/* JADX INFO: compiled from: DragGestureDetector.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$2", f = "DragGestureDetector.kt", i = {0, 0, 1, 1, 1}, l = {Imgcodecs.IMWRITE_GIF_QUALITY, 1048}, m = "invokeSuspend", n = {"$this$withTimeout", "finished", "$this$withTimeout", NotificationCompat.CATEGORY_EVENT, "finished"}, s = {"L$0", "I$0", "L$0", "L$1", "I$0"}, v = 1)
final class DragGestureDetectorKt$awaitLongPressOrCancellation$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<PointerInputChange> $currentDown;
    final /* synthetic */ Ref.BooleanRef $deepPress;
    final /* synthetic */ Ref.ObjectRef<PointerInputChange> $longPress;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DragGestureDetectorKt$awaitLongPressOrCancellation$2(Ref.BooleanRef booleanRef, Ref.ObjectRef<PointerInputChange> objectRef, Ref.ObjectRef<PointerInputChange> objectRef2, Continuation<? super DragGestureDetectorKt$awaitLongPressOrCancellation$2> continuation) {
        super(2, continuation);
        this.$deepPress = booleanRef;
        this.$currentDown = objectRef;
        this.$longPress = objectRef2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DragGestureDetectorKt$awaitLongPressOrCancellation$2 dragGestureDetectorKt$awaitLongPressOrCancellation$2 = new DragGestureDetectorKt$awaitLongPressOrCancellation$2(this.$deepPress, this.$currentDown, this.$longPress, continuation);
        dragGestureDetectorKt$awaitLongPressOrCancellation$2.L$0 = obj;
        return dragGestureDetectorKt$awaitLongPressOrCancellation$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((DragGestureDetectorKt$awaitLongPressOrCancellation$2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a4, code lost:
    
        r2 = r6 ? 1 : 0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e8 A[EDGE_INSN: B:68:0x00e8->B:44:0x00e8 BREAK  A[LOOP:0: B:39:0x00d5->B:43:0x00e5], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0076 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v10, types: [T] */
    /* JADX WARN: Type inference failed for: r9v11, types: [T, androidx.compose.ui.input.pointer.PointerInputChange] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00c4 -> B:38:0x00c7). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        AwaitPointerEventScope awaitPointerEventScope;
        int i;
        Object objAwaitPointerEvent;
        PointerEvent pointerEvent;
        int size;
        int i2;
        int size2;
        int i3;
        Object objAwaitPointerEvent2;
        T t;
        PointerInputChange pointerInputChange;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.label;
        Object obj2 = null;
        boolean z = true;
        z = true;
        z = true;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
            i = 0;
            if (i != 0) {
            }
        } else {
            if (i4 == 1) {
                i = this.I$0;
                awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                objAwaitPointerEvent = obj;
                pointerEvent = (PointerEvent) objAwaitPointerEvent;
                List<PointerInputChange> changes = pointerEvent.getChanges();
                size = changes.size();
                i2 = 0;
                while (true) {
                    if (i2 >= size) {
                    }
                    i2++;
                }
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                size2 = changes2.size();
                while (i3 < size2) {
                }
                if (TapGestureDetector_androidKt.isDeepPress(pointerEvent)) {
                }
                this.L$0 = awaitPointerEventScope;
                this.L$1 = pointerEvent;
                this.I$0 = i;
                this.label = 2;
                objAwaitPointerEvent2 = awaitPointerEventScope.awaitPointerEvent(PointerEventPass.Final, this);
                if (objAwaitPointerEvent2 != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i4 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = this.I$0;
            PointerEvent pointerEvent2 = (PointerEvent) this.L$1;
            AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            objAwaitPointerEvent2 = obj;
            List<PointerInputChange> changes3 = ((PointerEvent) objAwaitPointerEvent2).getChanges();
            int size3 = changes3.size();
            int i5 = 0;
            while (true) {
                if (i5 >= size3) {
                    break;
                }
                if (changes3.get(i5).isConsumed()) {
                    i = z ? 1 : 0;
                    break;
                }
                i5++;
            }
            if (!DragGestureDetectorKt.m1694isPointerUpDmW0f2w(pointerEvent2, this.$currentDown.element.getId())) {
                List<PointerInputChange> changes4 = pointerEvent2.getChanges();
                int size4 = changes4.size();
                int i6 = 0;
                while (true) {
                    if (i6 >= size4) {
                        pointerInputChange = null;
                        break;
                    }
                    pointerInputChange = changes4.get(i6);
                    if (pointerInputChange.getPressed()) {
                        break;
                    }
                    i6++;
                }
                PointerInputChange pointerInputChange2 = pointerInputChange;
                if (pointerInputChange2 == 0) {
                    i = z ? 1 : 0;
                    awaitPointerEventScope = awaitPointerEventScope2;
                    obj2 = null;
                    if (i != 0) {
                        return Unit.INSTANCE;
                    }
                    this.L$0 = awaitPointerEventScope;
                    this.L$1 = obj2;
                    this.I$0 = i;
                    this.label = z ? 1 : 0;
                    objAwaitPointerEvent = awaitPointerEventScope.awaitPointerEvent(PointerEventPass.Main, this);
                    if (objAwaitPointerEvent != coroutine_suspended) {
                        pointerEvent = (PointerEvent) objAwaitPointerEvent;
                        List<PointerInputChange> changes5 = pointerEvent.getChanges();
                        size = changes5.size();
                        i2 = 0;
                        while (true) {
                            if (i2 >= size) {
                                i = z ? 1 : 0;
                                break;
                            }
                            if (!PointerEventKt.changedToUpIgnoreConsumed(changes5.get(i2))) {
                                break;
                            }
                            i2++;
                        }
                        List<PointerInputChange> changes22 = pointerEvent.getChanges();
                        size2 = changes22.size();
                        for (i3 = 0; i3 < size2; i3++) {
                            PointerInputChange pointerInputChange3 = changes22.get(i3);
                            if (pointerInputChange3.isConsumed() || PointerEventKt.m7583isOutOfBoundsjwHxaWs(pointerInputChange3, awaitPointerEventScope.mo7534getSizeYbymL2g(), awaitPointerEventScope.mo7533getExtendedTouchPaddingNHjbRc())) {
                                break;
                            }
                        }
                        if (TapGestureDetector_androidKt.isDeepPress(pointerEvent)) {
                            this.$deepPress.element = z;
                            i = z ? 1 : 0;
                        }
                        this.L$0 = awaitPointerEventScope;
                        this.L$1 = pointerEvent;
                        this.I$0 = i;
                        this.label = 2;
                        objAwaitPointerEvent2 = awaitPointerEventScope.awaitPointerEvent(PointerEventPass.Final, this);
                        if (objAwaitPointerEvent2 != coroutine_suspended) {
                            awaitPointerEventScope2 = awaitPointerEventScope;
                            pointerEvent2 = pointerEvent;
                            List<PointerInputChange> changes32 = ((PointerEvent) objAwaitPointerEvent2).getChanges();
                            int size32 = changes32.size();
                            int i52 = 0;
                            while (true) {
                                if (i52 >= size32) {
                                }
                                i52++;
                            }
                            if (!DragGestureDetectorKt.m1694isPointerUpDmW0f2w(pointerEvent2, this.$currentDown.element.getId())) {
                                Ref.ObjectRef<PointerInputChange> objectRef = this.$longPress;
                                List<PointerInputChange> changes6 = pointerEvent2.getChanges();
                                Ref.ObjectRef<PointerInputChange> objectRef2 = this.$currentDown;
                                int size5 = changes6.size();
                                int i7 = 0;
                                while (true) {
                                    if (i7 >= size5) {
                                        t = 0;
                                        break;
                                    }
                                    t = changes6.get(i7);
                                    Ref.ObjectRef<PointerInputChange> objectRef3 = objectRef2;
                                    if (PointerId.m7620equalsimpl0(((PointerInputChange) t).getId(), objectRef2.element.getId())) {
                                        break;
                                    }
                                    i7++;
                                    objectRef2 = objectRef3;
                                }
                                objectRef.element = t;
                            }
                        }
                    }
                    return coroutine_suspended;
                }
                this.$currentDown.element = pointerInputChange2;
                this.$longPress.element = this.$currentDown.element;
            }
            awaitPointerEventScope = awaitPointerEventScope2;
            obj2 = null;
            z = true;
            if (i != 0) {
            }
        }
    }
}
