package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.constraintlayout.motion.widget.Key;
import androidx.media3.muxer.MuxerUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: TransformGestureDetector.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a~\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042`\u0010\u0005\u001a\\\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\f¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00010\u0006H\u0086@¢\u0006\u0002\u0010\u000f\u001a\n\u0010\u0010\u001a\u00020\f*\u00020\u0011\u001a\u0013\u0010\u0012\u001a\u00020\f*\u00020\u0007H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a\n\u0010\u0015\u001a\u00020\f*\u00020\u0011\u001a\u000f\u0010\u0016\u001a\u00020\u0007*\u00020\u0011¢\u0006\u0002\u0010\u0017\u001a\u0014\u0010\u0018\u001a\u00020\f*\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u001a\u0019\u0010\u001a\u001a\u00020\u0007*\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u0004¢\u0006\u0002\u0010\u001b¨\u0006\u001c"}, d2 = {"detectTransformGestures", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "panZoomLock", "", "onGesture", "Lkotlin/Function4;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", "name", "centroid", "pan", "", "zoom", Key.ROTATION, "(Landroidx/compose/ui/input/pointer/PointerInputScope;ZLkotlin/jvm/functions/Function4;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateRotation", "Landroidx/compose/ui/input/pointer/PointerEvent;", "angle", "angle-k-4lQ0M", "(J)F", "calculateZoom", "calculatePan", "(Landroidx/compose/ui/input/pointer/PointerEvent;)J", "calculateCentroidSize", "useCurrent", "calculateCentroid", "(Landroidx/compose/ui/input/pointer/PointerEvent;Z)J", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TransformGestureDetectorKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformGestureDetectorKt$detectTransformGestures$2, reason: invalid class name */
    /* JADX INFO: compiled from: TransformGestureDetector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformGestureDetectorKt$detectTransformGestures$2", f = "TransformGestureDetector.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {60, 62}, m = "invokeSuspend", n = {"$this$awaitEachGesture", Key.ROTATION, "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom", "$this$awaitEachGesture", Key.ROTATION, "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom"}, s = {"L$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1", "L$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1"}, v = 1)
    static final class AnonymousClass2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function4<Offset, Offset, Float, Float, Unit> $onGesture;
        final /* synthetic */ boolean $panZoomLock;
        float F$0;
        float F$1;
        float F$2;
        int I$0;
        int I$1;
        long J$0;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(boolean z, Function4<? super Offset, ? super Offset, ? super Float, ? super Float, Unit> function4, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$panZoomLock = z;
            this.$onGesture = function4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$panZoomLock, this.$onGesture, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x009a, code lost:
        
            if (r3 == r1) goto L16;
         */
        /* JADX WARN: Removed duplicated region for block: B:55:0x015d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x009a -> B:17:0x009d). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            float f;
            float f2;
            int i;
            long jM6085plusMKHz9U;
            AwaitPointerEventScope awaitPointerEventScope;
            float f3;
            int i2;
            Object objAwaitPointerEvent$default;
            int i3;
            Object obj2;
            float f4;
            int i4;
            int size;
            int i5;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i6 = this.label;
            int i7 = 2;
            float f5 = 1.0f;
            float f6 = 0.0f;
            int i8 = 1;
            if (i6 == 0) {
                ResultKt.throwOnFailure(obj);
                AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                long jM6096getZeroF1C5BW0 = Offset.INSTANCE.m6096getZeroF1C5BW0();
                float touchSlop = awaitPointerEventScope2.getViewConfiguration().getTouchSlop();
                this.L$0 = awaitPointerEventScope2;
                this.F$0 = 0.0f;
                this.F$1 = 1.0f;
                this.J$0 = jM6096getZeroF1C5BW0;
                this.I$0 = 0;
                this.F$2 = touchSlop;
                this.I$1 = 0;
                this.label = 1;
                if (TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope2, false, null, this, 2, null) != coroutine_suspended) {
                    f = 1.0f;
                    f2 = 0.0f;
                    i = 0;
                    jM6085plusMKHz9U = jM6096getZeroF1C5BW0;
                    awaitPointerEventScope = awaitPointerEventScope2;
                    f3 = touchSlop;
                    i2 = 0;
                }
                return coroutine_suspended;
            }
            if (i6 != 1) {
                if (i6 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i2 = this.I$1;
                f3 = this.F$2;
                i = this.I$0;
                jM6085plusMKHz9U = this.J$0;
                f = this.F$1;
                f2 = this.F$0;
                awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                objAwaitPointerEvent$default = obj;
                PointerEvent pointerEvent = (PointerEvent) objAwaitPointerEvent$default;
                List<PointerInputChange> changes = pointerEvent.getChanges();
                float f7 = f5;
                int size2 = changes.size();
                float f8 = f6;
                int i9 = 0;
                while (true) {
                    if (i9 >= size2) {
                        i3 = 0;
                        break;
                    }
                    if (changes.get(i9).isConsumed()) {
                        i3 = i8;
                        break;
                    }
                    i9++;
                }
                if (i3 == 0) {
                    float fCalculateZoom = TransformGestureDetectorKt.calculateZoom(pointerEvent);
                    float fCalculateRotation = TransformGestureDetectorKt.calculateRotation(pointerEvent);
                    f4 = f3;
                    long jCalculatePan = TransformGestureDetectorKt.calculatePan(pointerEvent);
                    if (i == 0) {
                        f *= fCalculateZoom;
                        f2 += fCalculateRotation;
                        jM6085plusMKHz9U = Offset.m6085plusMKHz9U(jM6085plusMKHz9U, jCalculatePan);
                        float fCalculateCentroidSize = TransformGestureDetectorKt.calculateCentroidSize(pointerEvent, false);
                        float fAbs = Math.abs(f7 - f) * fCalculateCentroidSize;
                        float fAbs2 = Math.abs(((3.1415927f * f2) * fCalculateCentroidSize) / 180.0f);
                        float fM6078getDistanceimpl = Offset.m6078getDistanceimpl(jM6085plusMKHz9U);
                        if (fAbs > f4 || fAbs2 > f4 || fM6078getDistanceimpl > f4) {
                            i2 = (!this.$panZoomLock || fAbs2 >= f4) ? 0 : 1;
                            i = 1;
                        }
                    }
                    if (i != 0) {
                        long jCalculateCentroid = TransformGestureDetectorKt.calculateCentroid(pointerEvent, false);
                        if (i2 != 0) {
                            fCalculateRotation = f8;
                        }
                        if (fCalculateRotation == f8 && fCalculateZoom == f7) {
                            obj2 = coroutine_suspended;
                            i4 = i2;
                            if (!Offset.m6077equalsimpl0(jCalculatePan, Offset.INSTANCE.m6096getZeroF1C5BW0())) {
                            }
                            List<PointerInputChange> changes2 = pointerEvent.getChanges();
                            size = changes2.size();
                            for (i5 = 0; i5 < size; i5++) {
                                PointerInputChange pointerInputChange = changes2.get(i5);
                                if (PointerEventKt.positionChanged(pointerInputChange)) {
                                    pointerInputChange.consume();
                                }
                            }
                        } else {
                            obj2 = coroutine_suspended;
                            i4 = i2;
                        }
                        this.$onGesture.invoke(Offset.m6069boximpl(jCalculateCentroid), Offset.m6069boximpl(jCalculatePan), Boxing.boxFloat(fCalculateZoom), Boxing.boxFloat(fCalculateRotation));
                        List<PointerInputChange> changes22 = pointerEvent.getChanges();
                        size = changes22.size();
                        while (i5 < size) {
                        }
                    } else {
                        obj2 = coroutine_suspended;
                        i4 = i2;
                    }
                    i2 = i4;
                } else {
                    obj2 = coroutine_suspended;
                    f4 = f3;
                }
                if (i3 == 0) {
                    List<PointerInputChange> changes3 = pointerEvent.getChanges();
                    int size3 = changes3.size();
                    for (int i10 = 0; i10 < size3; i10++) {
                        if (changes3.get(i10).getPressed()) {
                            f3 = f4;
                            f6 = f8;
                            f5 = f7;
                            coroutine_suspended = obj2;
                            i7 = 2;
                            i8 = 1;
                        }
                    }
                }
                return Unit.INSTANCE;
            }
            i2 = this.I$1;
            f3 = this.F$2;
            i = this.I$0;
            jM6085plusMKHz9U = this.J$0;
            f = this.F$1;
            f2 = this.F$0;
            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            this.L$0 = awaitPointerEventScope;
            this.F$0 = f2;
            this.F$1 = f;
            this.J$0 = jM6085plusMKHz9U;
            this.I$0 = i;
            this.F$2 = f3;
            this.I$1 = i2;
            this.label = i7;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, this, i8, null);
        }
    }

    /* JADX INFO: renamed from: angle-k-4lQ0M, reason: not valid java name */
    private static final float m1828anglek4lQ0M(long j) {
        if (Float.intBitsToFloat((int) (j >> 32)) == 0.0f && Float.intBitsToFloat((int) (j & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) == 0.0f) {
            return 0.0f;
        }
        return ((-((float) Math.atan2(Float.intBitsToFloat(r0), Float.intBitsToFloat((int) (j & MuxerUtil.UNSIGNED_INT_MAX_VALUE))))) * 180.0f) / 3.1415927f;
    }

    public static final long calculateCentroid(PointerEvent pointerEvent, boolean z) {
        long jM6096getZeroF1C5BW0 = Offset.INSTANCE.m6096getZeroF1C5BW0();
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            PointerInputChange pointerInputChange = changes.get(i2);
            if (pointerInputChange.getPressed() && pointerInputChange.getPreviousPressed()) {
                jM6096getZeroF1C5BW0 = Offset.m6085plusMKHz9U(jM6096getZeroF1C5BW0, z ? pointerInputChange.getPosition() : pointerInputChange.getPreviousPosition());
                i++;
            }
        }
        return i == 0 ? Offset.INSTANCE.m6095getUnspecifiedF1C5BW0() : Offset.m6075divtuRUvjQ(jM6096getZeroF1C5BW0, i);
    }

    public static /* synthetic */ long calculateCentroid$default(PointerEvent pointerEvent, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return calculateCentroid(pointerEvent, z);
    }

    public static final float calculateCentroidSize(PointerEvent pointerEvent, boolean z) {
        long jCalculateCentroid = calculateCentroid(pointerEvent, z);
        float fM6078getDistanceimpl = 0.0f;
        if (Offset.m6077equalsimpl0(jCalculateCentroid, Offset.INSTANCE.m6095getUnspecifiedF1C5BW0())) {
            return 0.0f;
        }
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            PointerInputChange pointerInputChange = changes.get(i2);
            if (pointerInputChange.getPressed() && pointerInputChange.getPreviousPressed()) {
                fM6078getDistanceimpl += Offset.m6078getDistanceimpl(Offset.m6084minusMKHz9U(z ? pointerInputChange.getPosition() : pointerInputChange.getPreviousPosition(), jCalculateCentroid));
                i++;
            }
        }
        return fM6078getDistanceimpl / i;
    }

    public static /* synthetic */ float calculateCentroidSize$default(PointerEvent pointerEvent, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return calculateCentroidSize(pointerEvent, z);
    }

    public static final long calculatePan(PointerEvent pointerEvent) {
        long jCalculateCentroid = calculateCentroid(pointerEvent, true);
        return Offset.m6077equalsimpl0(jCalculateCentroid, Offset.INSTANCE.m6095getUnspecifiedF1C5BW0()) ? Offset.INSTANCE.m6096getZeroF1C5BW0() : Offset.m6084minusMKHz9U(jCalculateCentroid, calculateCentroid(pointerEvent, false));
    }

    public static final float calculateRotation(PointerEvent pointerEvent) {
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = 1;
            if (i >= size) {
                break;
            }
            PointerInputChange pointerInputChange = changes.get(i);
            if (!pointerInputChange.getPreviousPressed() || !pointerInputChange.getPressed()) {
                i3 = 0;
            }
            i2 += i3;
            i++;
        }
        if (i2 < 2) {
            return 0.0f;
        }
        long jCalculateCentroid = calculateCentroid(pointerEvent, true);
        long jCalculateCentroid2 = calculateCentroid(pointerEvent, false);
        List<PointerInputChange> changes2 = pointerEvent.getChanges();
        int size2 = changes2.size();
        float f = 0.0f;
        float f2 = 0.0f;
        for (int i4 = 0; i4 < size2; i4++) {
            PointerInputChange pointerInputChange2 = changes2.get(i4);
            if (pointerInputChange2.getPressed() && pointerInputChange2.getPreviousPressed()) {
                long position = pointerInputChange2.getPosition();
                long jM6084minusMKHz9U = Offset.m6084minusMKHz9U(pointerInputChange2.getPreviousPosition(), jCalculateCentroid2);
                long jM6084minusMKHz9U2 = Offset.m6084minusMKHz9U(position, jCalculateCentroid);
                float fM1828anglek4lQ0M = m1828anglek4lQ0M(jM6084minusMKHz9U2) - m1828anglek4lQ0M(jM6084minusMKHz9U);
                float fM6078getDistanceimpl = Offset.m6078getDistanceimpl(Offset.m6085plusMKHz9U(jM6084minusMKHz9U2, jM6084minusMKHz9U)) / 2.0f;
                if (fM1828anglek4lQ0M > 180.0f) {
                    fM1828anglek4lQ0M -= 360.0f;
                } else if (fM1828anglek4lQ0M < -180.0f) {
                    fM1828anglek4lQ0M += 360.0f;
                }
                f2 += fM1828anglek4lQ0M * fM6078getDistanceimpl;
                f += fM6078getDistanceimpl;
            }
        }
        if (f == 0.0f) {
            return 0.0f;
        }
        return f2 / f;
    }

    public static final float calculateZoom(PointerEvent pointerEvent) {
        float fCalculateCentroidSize = calculateCentroidSize(pointerEvent, true);
        float fCalculateCentroidSize2 = calculateCentroidSize(pointerEvent, false);
        if (fCalculateCentroidSize == 0.0f || fCalculateCentroidSize2 == 0.0f) {
            return 1.0f;
        }
        return fCalculateCentroidSize / fCalculateCentroidSize2;
    }

    public static final Object detectTransformGestures(PointerInputScope pointerInputScope, boolean z, Function4<? super Offset, ? super Offset, ? super Float, ? super Float, Unit> function4, Continuation<? super Unit> continuation) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new AnonymousClass2(z, function4, null), continuation);
        return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
    }

    public static /* synthetic */ Object detectTransformGestures$default(PointerInputScope pointerInputScope, boolean z, Function4 function4, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return detectTransformGestures(pointerInputScope, z, function4, continuation);
    }
}
