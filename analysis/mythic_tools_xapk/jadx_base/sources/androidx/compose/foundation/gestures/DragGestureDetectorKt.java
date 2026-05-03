package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.muxer.MuxerUtil;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: DragGestureDetector.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aV\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000426\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0004\b\r\u0010\u000e\u001a0\u0010\u000f\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u0012H\u0086@¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0080\u0001\u0010\u0018\u001a\u00020\f*\u00020\u00192\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u00122\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u001c2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u001c26\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0002\u0010\u001f\u001aè\u0001\u0010\u0018\u001a\u00020\f*\u00020\u00192\b\u0010 \u001a\u0004\u0018\u00010!2M\b\u0002\u0010\u001a\u001aG\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b($\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\f0\"2#\b\u0002\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\f0\u00122\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u001c2\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00100\u001c26\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0002\u0010'\u001a\u0080\u0001\u0010(\u001a\u00020\f*\u00020\u00192\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u00122\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u001c2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u001c26\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0002\u0010\u001f\u001aV\u0010)\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000426\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110*¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0004\b+\u0010\u000e\u001a^\u0010,\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010-\u001a\u00020.26\u0010/\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110*¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0004\b0\u00101\u001a0\u00102\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u0012H\u0086@¢\u0006\u0004\b3\u0010\u0014\u001a\u001e\u00104\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b5\u0010\u0017\u001a\u0080\u0001\u00106\u001a\u00020\f*\u00020\u00192\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u00122\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u001c2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u001c26\u00107\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110*¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0002\u0010\u001f\u001aV\u00108\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000426\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110*¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0004\b9\u0010\u000e\u001a^\u0010:\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010-\u001a\u00020.26\u0010/\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110*¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0004\b;\u00101\u001a0\u0010<\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u0012H\u0086@¢\u0006\u0004\b=\u0010\u0014\u001a\u001e\u0010>\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b?\u0010\u0017\u001a\u0080\u0001\u0010@\u001a\u00020\f*\u00020\u00192\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u00122\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u001c2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u001c26\u0010A\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110*¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\f0\u0006H\u0086@¢\u0006\u0002\u0010\u001f\u001aP\u0010\u000f\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u00122\b\u0010B\u001a\u0004\u0018\u00010!2\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00100\u0012H\u0080H¢\u0006\u0004\bD\u0010E\u001a2\u0010F\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00100\u0012H\u0082H¢\u0006\u0004\bH\u0010\u0014\u001aT\u0010I\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010-\u001a\u00020.2\b\u0010B\u001a\u0004\u0018\u00010!2\b\b\u0002\u0010J\u001a\u00020\n2\u0018\u0010/\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u0006H\u0080H¢\u0006\u0004\bK\u0010L\u001a$\u0010M\u001a\u00020\u0010*\u00020\u00022\u0006\u0010J\u001a\u00020\u00012\b\b\u0002\u0010N\u001a\u00020OH\u0080@¢\u0006\u0002\u0010P\u001a\u001e\u0010Q\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@¢\u0006\u0004\bR\u0010\u0017\u001a\u001b\u0010S\u001a\u00020\u0010*\u00020T2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0004\bU\u0010V\u001a\u001b\u0010\\\u001a\u00020**\u00020]2\u0006\u0010-\u001a\u00020.H\u0000¢\u0006\u0004\b^\u0010_\"\u0010\u0010W\u001a\u00020XX\u0082\u0004¢\u0006\u0004\n\u0002\u0010Y\"\u0010\u0010Z\u001a\u00020XX\u0082\u0004¢\u0006\u0004\n\u0002\u0010Y\"\u000e\u0010[\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006`"}, d2 = {"awaitTouchSlopOrCancellation", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "onTouchSlopReached", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "change", "Landroidx/compose/ui/geometry/Offset;", "overSlop", "", "awaitTouchSlopOrCancellation-jO51t88", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "drag", "", "onDrag", "Lkotlin/Function1;", "drag-jO51t88", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitDragOrCancellation", "awaitDragOrCancellation-rnUCldI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectDragGestures", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onDragStart", "onDragEnd", "Lkotlin/Function0;", "onDragCancel", "dragAmount", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "orientationLock", "Landroidx/compose/foundation/gestures/Orientation;", "Lkotlin/Function3;", "down", "slopTriggerChange", "overSlopOffset", "shouldAwaitTouchSlop", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/gestures/Orientation;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectDragGesturesAfterLongPress", "awaitVerticalTouchSlopOrCancellation", "", "awaitVerticalTouchSlopOrCancellation-jO51t88", "awaitVerticalPointerSlopOrCancellation", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "onPointerSlopReached", "awaitVerticalPointerSlopOrCancellation-gDDlDlE", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "verticalDrag", "verticalDrag-jO51t88", "awaitVerticalDragOrCancellation", "awaitVerticalDragOrCancellation-rnUCldI", "detectVerticalDragGestures", "onVerticalDrag", "awaitHorizontalTouchSlopOrCancellation", "awaitHorizontalTouchSlopOrCancellation-jO51t88", "awaitHorizontalPointerSlopOrCancellation", "awaitHorizontalPointerSlopOrCancellation-gDDlDlE", "horizontalDrag", "horizontalDrag-jO51t88", "awaitHorizontalDragOrCancellation", "awaitHorizontalDragOrCancellation-rnUCldI", "detectHorizontalDragGestures", "onHorizontalDrag", "orientation", "motionConsumed", "drag-VnAYq1g", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function1;Landroidx/compose/foundation/gestures/Orientation;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitDragOrUp", "hasDragged", "awaitDragOrUp-jO51t88", "awaitPointerSlopOrCancellation", "initialPositionChange", "awaitPointerSlopOrCancellation-6ksA65w", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILandroidx/compose/foundation/gestures/Orientation;JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitAllPointersUpWithSlopDetection", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/ui/input/pointer/PointerInputChange;Landroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitLongPressOrCancellation", "awaitLongPressOrCancellation-rnUCldI", "isPointerUp", "Landroidx/compose/ui/input/pointer/PointerEvent;", "isPointerUp-DmW0f2w", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)Z", "mouseSlop", "Landroidx/compose/ui/unit/Dp;", "F", "defaultTouchSlop", "mouseToTouchSlopRatio", "pointerSlop", "Landroidx/compose/ui/platform/ViewConfiguration;", "pointerSlop-E8SPZFQ", "(Landroidx/compose/ui/platform/ViewConfiguration;I)F", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DragGestureDetectorKt {
    private static final float defaultTouchSlop;
    private static final float mouseSlop;
    private static final float mouseToTouchSlopRatio;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitAllPointersUpWithSlopDetection$1, reason: invalid class name */
    /* JADX INFO: compiled from: DragGestureDetector.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt", f = "DragGestureDetector.kt", i = {0, 0, 0, 0, 0, 0}, l = {897}, m = "awaitAllPointersUpWithSlopDetection", n = {"$this$awaitAllPointersUpWithSlopDetection", "pass", "pointer", "touchSlopDetector", "pointerSlopReached", "touchSlop"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "F$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        float F$0;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DragGestureDetectorKt.awaitAllPointersUpWithSlopDetection(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$13, reason: invalid class name */
    /* JADX INFO: compiled from: DragGestureDetector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$13", f = "DragGestureDetector.kt", i = {0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7}, l = {Imgcodecs.IMWRITE_PNG_ALL_FILTERS, 254, 1116, 1158, 279, 1197, 1240, 1252}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "initialDown", "awaitTouchSlop", "$this$awaitEachGesture", "down", "$this$awaitPointerSlopOrCancellation_u2d6ksA65w_u24default$iv", "pointer$iv", "touchSlopDetector$iv", "touchSlop$iv", "$this$awaitEachGesture", "down", "$this$awaitPointerSlopOrCancellation_u2d6ksA65w_u24default$iv", "pointer$iv", "touchSlopDetector$iv", "dragEvent$iv", "touchSlop$iv", "$this$awaitEachGesture", "down", "drag", "$this$awaitEachGesture", "down", "$this$awaitPointerSlopOrCancellation_u2d6ksA65w$iv", "pointer$iv", "touchSlopDetector$iv", "touchSlop$iv", "$this$awaitEachGesture", "down", "$this$awaitPointerSlopOrCancellation_u2d6ksA65w$iv", "pointer$iv", "touchSlopDetector$iv", "dragEvent$iv", "touchSlop$iv", "$this$drag_u2dVnAYq1g$iv", "$this$awaitDragOrUp_u2djO51t88$iv$iv", "pointer$iv$iv"}, s = {"L$0", "L$0", "L$1", "Z$0", "L$0", "L$1", "L$2", "L$4", "L$5", "F$0", "L$0", "L$1", "L$2", "L$4", "L$5", "L$6", "F$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$4", "L$5", "F$0", "L$0", "L$1", "L$2", "L$4", "L$5", "L$6", "F$0", "L$0", "L$2", "L$3"}, v = 1)
    static final class AnonymousClass13 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<PointerInputChange, Offset, Unit> $onDrag;
        final /* synthetic */ Function0<Unit> $onDragCancel;
        final /* synthetic */ Function1<PointerInputChange, Unit> $onDragEnd;
        final /* synthetic */ Function3<PointerInputChange, PointerInputChange, Offset, Unit> $onDragStart;
        final /* synthetic */ Orientation $orientationLock;
        final /* synthetic */ Ref.LongRef $overSlop;
        final /* synthetic */ Function0<Boolean> $shouldAwaitTouchSlop;
        float F$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass13(Function0<Boolean> function0, Ref.LongRef longRef, Orientation orientation, Function3<? super PointerInputChange, ? super PointerInputChange, ? super Offset, Unit> function3, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Function0<Unit> function02, Function1<? super PointerInputChange, Unit> function1, Continuation<? super AnonymousClass13> continuation) {
            super(2, continuation);
            this.$shouldAwaitTouchSlop = function0;
            this.$overSlop = longRef;
            this.$orientationLock = orientation;
            this.$onDragStart = function3;
            this.$onDrag = function2;
            this.$onDragCancel = function02;
            this.$onDragEnd = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass13 anonymousClass13 = new AnonymousClass13(this.$shouldAwaitTouchSlop, this.$overSlop, this.$orientationLock, this.$onDragStart, this.$onDrag, this.$onDragCancel, this.$onDragEnd, continuation);
            anonymousClass13.L$0 = obj;
            return anonymousClass13;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass13) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:171:0x055b, code lost:
        
            if (r7 == r1) goto L172;
         */
        /* JADX WARN: Code restructure failed: missing block: B:208:0x05e8, code lost:
        
            if (r7 == false) goto L209;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0198, code lost:
        
            if (r2 != r1) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x01a8, code lost:
        
            if (r6 != false) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:88:0x0324, code lost:
        
            if (r3 == r1) goto L172;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Path cross not found for [B:126:0x0434, B:128:0x043d], limit reached: 222 */
        /* JADX WARN: Path cross not found for [B:131:0x0444, B:126:0x0434], limit reached: 222 */
        /* JADX WARN: Path cross not found for [B:185:0x0595, B:196:0x05c2], limit reached: 222 */
        /* JADX WARN: Removed duplicated region for block: B:116:0x03f1  */
        /* JADX WARN: Removed duplicated region for block: B:119:0x0407  */
        /* JADX WARN: Removed duplicated region for block: B:133:0x044a  */
        /* JADX WARN: Removed duplicated region for block: B:144:0x047a  */
        /* JADX WARN: Removed duplicated region for block: B:157:0x04df  */
        /* JADX WARN: Removed duplicated region for block: B:159:0x04e6  */
        /* JADX WARN: Removed duplicated region for block: B:165:0x0507  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x017a  */
        /* JADX WARN: Removed duplicated region for block: B:218:0x05ff  */
        /* JADX WARN: Removed duplicated region for block: B:219:0x0605  */
        /* JADX WARN: Removed duplicated region for block: B:238:0x0429 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:242:0x022b A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x01c8  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x01fd  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0211  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0243  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0274  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x02d3  */
        /* JADX WARN: Removed duplicated region for block: B:80:0x02de  */
        /* JADX WARN: Removed duplicated region for block: B:82:0x02e7  */
        /* JADX WARN: Type inference failed for: r11v0 */
        /* JADX WARN: Type inference failed for: r11v10 */
        /* JADX WARN: Type inference failed for: r11v11 */
        /* JADX WARN: Type inference failed for: r11v12 */
        /* JADX WARN: Type inference failed for: r11v13 */
        /* JADX WARN: Type inference failed for: r11v14 */
        /* JADX WARN: Type inference failed for: r11v2 */
        /* JADX WARN: Type inference failed for: r11v26 */
        /* JADX WARN: Type inference failed for: r11v27 */
        /* JADX WARN: Type inference failed for: r11v28 */
        /* JADX WARN: Type inference failed for: r11v29 */
        /* JADX WARN: Type inference failed for: r11v30 */
        /* JADX WARN: Type inference failed for: r11v31 */
        /* JADX WARN: Type inference failed for: r11v5, types: [androidx.compose.ui.input.pointer.PointerEventPass, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r11v6 */
        /* JADX WARN: Type inference failed for: r11v7, types: [kotlin.jvm.internal.DefaultConstructorMarker] */
        /* JADX WARN: Type inference failed for: r11v8 */
        /* JADX WARN: Type inference failed for: r11v9, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v33 */
        /* JADX WARN: Type inference failed for: r2v45, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v49 */
        /* JADX WARN: Type inference failed for: r2v65 */
        /* JADX WARN: Type inference failed for: r2v66 */
        /* JADX WARN: Type inference failed for: r5v23, types: [androidx.compose.ui.input.pointer.PointerInputChange] */
        /* JADX WARN: Type inference failed for: r5v24 */
        /* JADX WARN: Type inference failed for: r5v37 */
        /* JADX WARN: Type inference failed for: r5v44 */
        /* JADX WARN: Type inference failed for: r5v49 */
        /* JADX WARN: Type inference failed for: r5v5 */
        /* JADX WARN: Type inference failed for: r5v50 */
        /* JADX WARN: Type inference failed for: r5v52, types: [androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r5v57 */
        /* JADX WARN: Type inference failed for: r5v59 */
        /* JADX WARN: Type inference failed for: r5v71 */
        /* JADX WARN: Type inference failed for: r5v72 */
        /* JADX WARN: Type inference failed for: r5v73 */
        /* JADX WARN: Type inference failed for: r6v46 */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:111:0x03b4 -> B:158:0x04e3). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:154:0x04d4 -> B:155:0x04d9). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:162:0x04f3 -> B:81:0x02e5). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:171:0x055b -> B:173:0x055e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x01c4 -> B:74:0x02d0). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0231 -> B:73:0x02ce). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x0239 -> B:73:0x02ce). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0265 -> B:73:0x02ce). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x0295 -> B:75:0x02d1). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x02c4 -> B:71:0x02c8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:97:0x035c -> B:87:0x030a). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            long j;
            long j2;
            AwaitPointerEventScope awaitPointerEventScope;
            Object objAwaitFirstDown;
            boolean zBooleanValue;
            AwaitPointerEventScope awaitPointerEventScope2;
            Object objAwaitFirstDown$default;
            ?? r5;
            PointerInputChange pointerInputChange;
            Ref.LongRef longRef;
            AwaitPointerEventScope awaitPointerEventScope3;
            PointerInputChange pointerInputChange2;
            Ref.LongRef longRef2;
            AwaitPointerEventScope awaitPointerEventScope4;
            TouchSlopDetector touchSlopDetector;
            float fM1695pointerSlopE8SPZFQ;
            PointerInputChange pointerInputChange3;
            PointerInputChange pointerInputChange4;
            PointerInputChange pointerInputChange5;
            AwaitPointerEventScope awaitPointerEventScope5;
            Object objAwaitPointerEvent;
            TouchSlopDetector touchSlopDetector2;
            PointerInputChange pointerInputChange6;
            Object objAwaitPointerEvent$default;
            float f;
            Ref.LongRef longRef3;
            AwaitPointerEventScope awaitPointerEventScope6;
            AwaitPointerEventScope awaitPointerEventScope7;
            Ref.LongRef longRef4;
            PointerEvent pointerEvent;
            int size;
            int i;
            PointerEvent pointerEvent2;
            TouchSlopDetector touchSlopDetector3;
            PointerInputChange pointerInputChange7;
            PointerInputChange pointerInputChange8;
            PointerInputChange pointerInputChange9;
            TouchSlopDetector touchSlopDetector4;
            AwaitPointerEventScope awaitPointerEventScope8;
            float f2;
            Ref.LongRef longRef5;
            TouchSlopDetector touchSlopDetector5;
            TouchSlopDetector touchSlopDetector6;
            Ref.LongRef longRef6;
            PointerInputChange pointerInputChange10;
            ?? r2;
            long id;
            Function2<PointerInputChange, Offset, Unit> function2;
            Orientation orientation;
            PointerInputChange pointerInputChange11;
            AwaitPointerEventScope awaitPointerEventScope9;
            AwaitPointerEventScope awaitPointerEventScope10;
            Ref.LongRef longRef7;
            Object objAwaitPointerEvent$default2;
            PointerInputChange pointerInputChange12;
            PointerInputChange pointerInputChange13;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = 0;
            int i3 = 1;
            ?? r11 = 0;
            ?? r112 = 0;
            r11 = 0;
            r11 = 0;
            switch (this.label) {
                case 0:
                    j = InlineClassHelperKt.UnspecifiedPackedFloats;
                    j2 = 9223372034707292159L;
                    ResultKt.throwOnFailure(obj);
                    awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                    this.L$0 = awaitPointerEventScope;
                    this.label = 1;
                    objAwaitFirstDown = TapGestureDetectorKt.awaitFirstDown(awaitPointerEventScope, false, PointerEventPass.Initial, this);
                    if (objAwaitFirstDown != coroutine_suspended) {
                        PointerInputChange pointerInputChange14 = (PointerInputChange) objAwaitFirstDown;
                        zBooleanValue = this.$shouldAwaitTouchSlop.invoke().booleanValue();
                        if (!zBooleanValue) {
                            pointerInputChange14.consume();
                        }
                        this.L$0 = awaitPointerEventScope;
                        this.L$1 = pointerInputChange14;
                        this.Z$0 = zBooleanValue;
                        this.label = 2;
                        awaitPointerEventScope2 = awaitPointerEventScope;
                        objAwaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope2, false, null, this, 2, null);
                        r5 = pointerInputChange14;
                        break;
                    }
                    return coroutine_suspended;
                case 1:
                    j = InlineClassHelperKt.UnspecifiedPackedFloats;
                    j2 = 9223372034707292159L;
                    awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    objAwaitFirstDown = obj;
                    PointerInputChange pointerInputChange142 = (PointerInputChange) objAwaitFirstDown;
                    zBooleanValue = this.$shouldAwaitTouchSlop.invoke().booleanValue();
                    if (!zBooleanValue) {
                    }
                    this.L$0 = awaitPointerEventScope;
                    this.L$1 = pointerInputChange142;
                    this.Z$0 = zBooleanValue;
                    this.label = 2;
                    awaitPointerEventScope2 = awaitPointerEventScope;
                    objAwaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope2, false, null, this, 2, null);
                    r5 = pointerInputChange142;
                    break;
                case 2:
                    j = InlineClassHelperKt.UnspecifiedPackedFloats;
                    j2 = 9223372034707292159L;
                    boolean z = this.Z$0;
                    PointerInputChange pointerInputChange15 = (PointerInputChange) this.L$1;
                    AwaitPointerEventScope awaitPointerEventScope11 = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    awaitPointerEventScope2 = awaitPointerEventScope11;
                    zBooleanValue = z;
                    objAwaitFirstDown$default = obj;
                    r5 = pointerInputChange15;
                    pointerInputChange = (PointerInputChange) objAwaitFirstDown$default;
                    this.$overSlop.element = Offset.INSTANCE.m6096getZeroF1C5BW0();
                    break;
                case 3:
                    j = InlineClassHelperKt.UnspecifiedPackedFloats;
                    j2 = 9223372034707292159L;
                    float f3 = this.F$0;
                    TouchSlopDetector touchSlopDetector7 = (TouchSlopDetector) this.L$5;
                    Ref.LongRef longRef8 = (Ref.LongRef) this.L$4;
                    Ref.LongRef longRef9 = (Ref.LongRef) this.L$3;
                    AwaitPointerEventScope awaitPointerEventScope12 = (AwaitPointerEventScope) this.L$2;
                    PointerInputChange pointerInputChange16 = (PointerInputChange) this.L$1;
                    AwaitPointerEventScope awaitPointerEventScope13 = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    float f4 = f3;
                    longRef = longRef8;
                    AwaitPointerEventScope awaitPointerEventScope14 = awaitPointerEventScope12;
                    pointerInputChange = pointerInputChange16;
                    awaitPointerEventScope3 = awaitPointerEventScope13;
                    Object objAwaitPointerEvent$default3 = obj;
                    Ref.LongRef longRef10 = longRef9;
                    TouchSlopDetector touchSlopDetector8 = touchSlopDetector7;
                    PointerEvent pointerEvent3 = (PointerEvent) objAwaitPointerEvent$default3;
                    List<PointerInputChange> changes = pointerEvent3.getChanges();
                    int size2 = changes.size();
                    int i4 = i2;
                    while (true) {
                        if (i4 >= size2) {
                            pointerInputChange2 = changes.get(i4);
                            if (!PointerId.m7620equalsimpl0(pointerInputChange2.getId(), longRef.element)) {
                                i4++;
                            }
                        } else {
                            pointerInputChange2 = null;
                        }
                    }
                    PointerInputChange pointerInputChange17 = pointerInputChange2;
                    if (pointerInputChange17 != null && !pointerInputChange17.isConsumed()) {
                        if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange17)) {
                            long jM1823addPositionsakrDWew = touchSlopDetector8.m1823addPositionsakrDWew(pointerInputChange17.getPosition(), pointerInputChange17.getPreviousPosition(), f4);
                            float f5 = f4;
                            if ((jM1823addPositionsakrDWew & j2) == j) {
                                this.L$0 = awaitPointerEventScope3;
                                this.L$1 = pointerInputChange;
                                this.L$2 = awaitPointerEventScope14;
                                this.L$3 = longRef10;
                                this.L$4 = longRef;
                                this.L$5 = touchSlopDetector8;
                                this.L$6 = pointerInputChange17;
                                this.F$0 = f5;
                                this.label = 4;
                                if (awaitPointerEventScope14.awaitPointerEvent(PointerEventPass.Final, this) != coroutine_suspended) {
                                    longRef2 = longRef10;
                                    awaitPointerEventScope4 = awaitPointerEventScope14;
                                    touchSlopDetector = touchSlopDetector8;
                                    fM1695pointerSlopE8SPZFQ = f5;
                                    pointerInputChange4 = pointerInputChange17;
                                    if (!pointerInputChange4.isConsumed()) {
                                        touchSlopDetector7 = touchSlopDetector;
                                        awaitPointerEventScope14 = awaitPointerEventScope4;
                                        i2 = 0;
                                        i3 = 1;
                                        longRef10 = longRef2;
                                    }
                                }
                                return coroutine_suspended;
                            }
                            pointerInputChange17.consume();
                            longRef10.element = jM1823addPositionsakrDWew;
                            if (pointerInputChange17.isConsumed()) {
                                awaitPointerEventScope2 = awaitPointerEventScope3;
                                r5 = pointerInputChange17;
                                if (r5 != 0 && !r5.isConsumed()) {
                                    i2 = 0;
                                    i3 = 1;
                                    long id2 = pointerInputChange.getId();
                                    int type = pointerInputChange.getType();
                                    Orientation orientation2 = this.$orientationLock;
                                    longRef10 = this.$overSlop;
                                    long jM6096getZeroF1C5BW0 = Offset.INSTANCE.m6096getZeroF1C5BW0();
                                    if (!DragGestureDetectorKt.m1694isPointerUpDmW0f2w(awaitPointerEventScope2.getCurrentEvent(), id2)) {
                                        fM1695pointerSlopE8SPZFQ = DragGestureDetectorKt.m1695pointerSlopE8SPZFQ(awaitPointerEventScope2.getViewConfiguration(), type);
                                        longRef = new Ref.LongRef();
                                        longRef.element = id2;
                                        touchSlopDetector7 = new TouchSlopDetector(orientation2, jM6096getZeroF1C5BW0, null);
                                        awaitPointerEventScope14 = awaitPointerEventScope2;
                                        awaitPointerEventScope3 = awaitPointerEventScope14;
                                    }
                                    r5 = 0;
                                    if (r5 != 0) {
                                        i2 = 0;
                                        i3 = 1;
                                        long id22 = pointerInputChange.getId();
                                        int type2 = pointerInputChange.getType();
                                        Orientation orientation22 = this.$orientationLock;
                                        longRef10 = this.$overSlop;
                                        long jM6096getZeroF1C5BW02 = Offset.INSTANCE.m6096getZeroF1C5BW0();
                                        if (!DragGestureDetectorKt.m1694isPointerUpDmW0f2w(awaitPointerEventScope2.getCurrentEvent(), id22)) {
                                        }
                                        r5 = 0;
                                        if (r5 != 0) {
                                        }
                                    }
                                }
                                if (r5 == 0) {
                                    List<PointerInputChange> changes2 = awaitPointerEventScope2.getCurrentEvent().getChanges();
                                    int size3 = changes2.size();
                                    int i5 = 0;
                                    r112 = r11;
                                    while (i5 < size3) {
                                        if (changes2.get(i5).getPressed()) {
                                            ?? r6 = r5;
                                            pointerInputChange5 = pointerInputChange;
                                            r2 = r6;
                                            awaitPointerEventScope5 = awaitPointerEventScope2;
                                            this.L$0 = awaitPointerEventScope5;
                                            this.L$1 = pointerInputChange5;
                                            this.L$2 = r2;
                                            this.L$3 = r112;
                                            this.L$4 = r112;
                                            this.L$5 = r112;
                                            this.L$6 = r112;
                                            this.label = 5;
                                            objAwaitPointerEvent = awaitPointerEventScope5.awaitPointerEvent(PointerEventPass.Final, this);
                                            r2 = r2;
                                            r112 = r112;
                                        } else {
                                            i5++;
                                            r112 = 0;
                                        }
                                        break;
                                    }
                                }
                                if (r5 != 0) {
                                    this.$onDragStart.invoke(pointerInputChange, r5, Offset.m6069boximpl(this.$overSlop.element));
                                    this.$onDrag.invoke(r5, Offset.m6069boximpl(this.$overSlop.element));
                                    id = r5.getId();
                                    function2 = this.$onDrag;
                                    if (!DragGestureDetectorKt.m1694isPointerUpDmW0f2w(awaitPointerEventScope2.getCurrentEvent(), id)) {
                                        orientation = null;
                                        Ref.LongRef longRef11 = new Ref.LongRef();
                                        longRef11.element = id;
                                        longRef7 = longRef11;
                                        awaitPointerEventScope10 = awaitPointerEventScope2;
                                        awaitPointerEventScope9 = awaitPointerEventScope10;
                                        this.L$0 = awaitPointerEventScope9;
                                        this.L$1 = function2;
                                        this.L$2 = awaitPointerEventScope10;
                                        this.L$3 = longRef7;
                                        this.L$4 = null;
                                        this.L$5 = null;
                                        this.L$6 = null;
                                        this.label = 8;
                                        objAwaitPointerEvent$default2 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope10, null, this, 1, null);
                                    }
                                    pointerInputChange11 = null;
                                    if (pointerInputChange11 != null) {
                                        this.$onDragCancel.invoke();
                                    } else {
                                        this.$onDragEnd.invoke(pointerInputChange11);
                                    }
                                    break;
                                }
                                return Unit.INSTANCE;
                            }
                            TouchSlopDetector.m1822resetk4lQ0M$default(touchSlopDetector8, 0L, 1, null);
                            touchSlopDetector7 = touchSlopDetector8;
                            fM1695pointerSlopE8SPZFQ = f5;
                            i2 = 0;
                            i3 = 1;
                        } else {
                            List<PointerInputChange> changes3 = pointerEvent3.getChanges();
                            int size4 = changes3.size();
                            int i6 = 0;
                            while (true) {
                                if (i6 < size4) {
                                    pointerInputChange3 = changes3.get(i6);
                                    if (!pointerInputChange3.getPressed()) {
                                        i6++;
                                    }
                                } else {
                                    pointerInputChange3 = null;
                                }
                            }
                            PointerInputChange pointerInputChange18 = pointerInputChange3;
                            if (pointerInputChange18 != null) {
                                longRef.element = pointerInputChange18.getId();
                                touchSlopDetector7 = touchSlopDetector8;
                                fM1695pointerSlopE8SPZFQ = f4;
                                i2 = 0;
                                i3 = 1;
                            }
                        }
                        this.L$0 = awaitPointerEventScope3;
                        this.L$1 = pointerInputChange;
                        this.L$2 = awaitPointerEventScope14;
                        this.L$3 = longRef10;
                        this.L$4 = longRef;
                        this.L$5 = touchSlopDetector7;
                        this.L$6 = null;
                        this.F$0 = fM1695pointerSlopE8SPZFQ;
                        this.label = 3;
                        objAwaitPointerEvent$default3 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope14, null, this, i3, null);
                        if (objAwaitPointerEvent$default3 != coroutine_suspended) {
                            f4 = fM1695pointerSlopE8SPZFQ;
                            TouchSlopDetector touchSlopDetector82 = touchSlopDetector7;
                            PointerEvent pointerEvent32 = (PointerEvent) objAwaitPointerEvent$default3;
                            List<PointerInputChange> changes4 = pointerEvent32.getChanges();
                            int size22 = changes4.size();
                            int i42 = i2;
                            while (true) {
                                if (i42 >= size22) {
                                }
                                i42++;
                            }
                            PointerInputChange pointerInputChange172 = pointerInputChange2;
                            if (pointerInputChange172 != null) {
                                if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange172)) {
                                }
                                this.L$0 = awaitPointerEventScope3;
                                this.L$1 = pointerInputChange;
                                this.L$2 = awaitPointerEventScope14;
                                this.L$3 = longRef10;
                                this.L$4 = longRef;
                                this.L$5 = touchSlopDetector7;
                                this.L$6 = null;
                                this.F$0 = fM1695pointerSlopE8SPZFQ;
                                this.label = 3;
                                objAwaitPointerEvent$default3 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope14, null, this, i3, null);
                                if (objAwaitPointerEvent$default3 != coroutine_suspended) {
                                }
                            }
                        }
                        return coroutine_suspended;
                    }
                    awaitPointerEventScope2 = awaitPointerEventScope3;
                    r5 = 0;
                    if (r5 != 0) {
                    }
                    if (r5 == 0) {
                    }
                    if (r5 != 0) {
                    }
                    return Unit.INSTANCE;
                case 4:
                    j = InlineClassHelperKt.UnspecifiedPackedFloats;
                    j2 = 9223372034707292159L;
                    float f6 = this.F$0;
                    PointerInputChange pointerInputChange19 = (PointerInputChange) this.L$6;
                    touchSlopDetector = (TouchSlopDetector) this.L$5;
                    Ref.LongRef longRef12 = (Ref.LongRef) this.L$4;
                    Ref.LongRef longRef13 = (Ref.LongRef) this.L$3;
                    awaitPointerEventScope4 = (AwaitPointerEventScope) this.L$2;
                    PointerInputChange pointerInputChange20 = (PointerInputChange) this.L$1;
                    AwaitPointerEventScope awaitPointerEventScope15 = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    longRef = longRef12;
                    longRef2 = longRef13;
                    awaitPointerEventScope3 = awaitPointerEventScope15;
                    fM1695pointerSlopE8SPZFQ = f6;
                    pointerInputChange = pointerInputChange20;
                    pointerInputChange4 = pointerInputChange19;
                    if (!pointerInputChange4.isConsumed()) {
                    }
                    awaitPointerEventScope2 = awaitPointerEventScope3;
                    r5 = 0;
                    if (r5 != 0) {
                    }
                    if (r5 == 0) {
                    }
                    if (r5 != 0) {
                    }
                    return Unit.INSTANCE;
                case 5:
                    j = InlineClassHelperKt.UnspecifiedPackedFloats;
                    j2 = 9223372034707292159L;
                    PointerInputChange pointerInputChange21 = (PointerInputChange) this.L$2;
                    pointerInputChange5 = (PointerInputChange) this.L$1;
                    awaitPointerEventScope5 = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    objAwaitPointerEvent = obj;
                    r2 = pointerInputChange21;
                    PointerEvent pointerEvent4 = (PointerEvent) objAwaitPointerEvent;
                    List<PointerInputChange> changes5 = pointerEvent4.getChanges();
                    int size5 = changes5.size();
                    int i7 = 0;
                    while (true) {
                        if (i7 < size5) {
                            if (changes5.get(i7).isConsumed()) {
                                List<PointerInputChange> changes6 = pointerEvent4.getChanges();
                                int size6 = changes6.size();
                                for (int i8 = 0; i8 < size6; i8++) {
                                    if (changes6.get(i8).getPressed()) {
                                    }
                                }
                            } else {
                                i7++;
                            }
                            break;
                        }
                    }
                    List<PointerInputChange> changes7 = pointerEvent4.getChanges();
                    int size7 = changes7.size();
                    int i9 = 0;
                    r11 = r112;
                    while (i9 < size7) {
                        if (changes7.get(i9).getPressed()) {
                            PointerInputChange pointerInputChange22 = (PointerInputChange) CollectionsKt.firstOrNull((List) pointerEvent4.getChanges());
                            long jM6084minusMKHz9U = Offset.m6084minusMKHz9U(pointerInputChange22 != null ? pointerInputChange22.getPosition() : Offset.INSTANCE.m6096getZeroF1C5BW0(), pointerInputChange5.getPosition());
                            long id3 = pointerInputChange5.getId();
                            int type3 = pointerInputChange5.getType();
                            Orientation orientation3 = this.$orientationLock;
                            longRef5 = this.$overSlop;
                            if (DragGestureDetectorKt.m1694isPointerUpDmW0f2w(awaitPointerEventScope5.getCurrentEvent(), id3)) {
                                pointerInputChange = pointerInputChange5;
                                awaitPointerEventScope2 = awaitPointerEventScope5;
                                r5 = r11;
                                r11 = 0;
                                if (r5 == 0) {
                                }
                                if (r5 != 0) {
                                }
                                return Unit.INSTANCE;
                            }
                            float fM1695pointerSlopE8SPZFQ2 = DragGestureDetectorKt.m1695pointerSlopE8SPZFQ(awaitPointerEventScope5.getViewConfiguration(), type3);
                            longRef6 = new Ref.LongRef();
                            longRef6.element = id3;
                            touchSlopDetector6 = new TouchSlopDetector(orientation3, jM6084minusMKHz9U, r11);
                            f2 = fM1695pointerSlopE8SPZFQ2;
                            awaitPointerEventScope7 = awaitPointerEventScope5;
                            this.L$0 = awaitPointerEventScope7;
                            this.L$1 = pointerInputChange5;
                            this.L$2 = awaitPointerEventScope5;
                            this.L$3 = longRef5;
                            this.L$4 = longRef6;
                            this.L$5 = touchSlopDetector6;
                            this.L$6 = r11;
                            this.F$0 = f2;
                            this.label = 6;
                            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope5, r11, this, 1, r11);
                            if (objAwaitPointerEvent$default != coroutine_suspended) {
                                longRef4 = longRef5;
                                longRef3 = longRef6;
                                f = f2;
                                pointerInputChange6 = pointerInputChange5;
                                awaitPointerEventScope6 = awaitPointerEventScope5;
                                touchSlopDetector2 = touchSlopDetector6;
                                pointerEvent = (PointerEvent) objAwaitPointerEvent$default;
                                List<PointerInputChange> changes8 = pointerEvent.getChanges();
                                size = changes8.size();
                                i = 0;
                                while (true) {
                                    if (i >= size) {
                                        pointerInputChange8 = changes8.get(i);
                                        pointerInputChange7 = pointerInputChange6;
                                        pointerEvent2 = pointerEvent;
                                        touchSlopDetector3 = touchSlopDetector2;
                                        if (!PointerId.m7620equalsimpl0(pointerInputChange8.getId(), longRef3.element)) {
                                            i++;
                                            touchSlopDetector2 = touchSlopDetector3;
                                            pointerEvent = pointerEvent2;
                                            pointerInputChange6 = pointerInputChange7;
                                        }
                                    } else {
                                        pointerEvent2 = pointerEvent;
                                        touchSlopDetector3 = touchSlopDetector2;
                                        pointerInputChange7 = pointerInputChange6;
                                        pointerInputChange8 = null;
                                    }
                                }
                                pointerInputChange9 = pointerInputChange8;
                                if (pointerInputChange9 != null && !pointerInputChange9.isConsumed()) {
                                    if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange9)) {
                                        touchSlopDetector4 = touchSlopDetector3;
                                        if ((touchSlopDetector4.m1823addPositionsakrDWew(pointerInputChange9.getPosition(), pointerInputChange9.getPreviousPosition(), f) & j2) != j) {
                                            pointerInputChange9.consume();
                                            longRef4.element = PointerEventKt.positionChange(pointerInputChange9);
                                            if (pointerInputChange9.isConsumed()) {
                                                r5 = pointerInputChange9;
                                                pointerInputChange = pointerInputChange7;
                                                awaitPointerEventScope2 = awaitPointerEventScope7;
                                                r11 = 0;
                                                if (r5 == 0) {
                                                }
                                                if (r5 != 0) {
                                                }
                                                return Unit.INSTANCE;
                                            }
                                            TouchSlopDetector.m1822resetk4lQ0M$default(touchSlopDetector4, 0L, 1, null);
                                        } else {
                                            this.L$0 = awaitPointerEventScope7;
                                            PointerInputChange pointerInputChange23 = pointerInputChange7;
                                            this.L$1 = pointerInputChange23;
                                            this.L$2 = awaitPointerEventScope6;
                                            this.L$3 = longRef4;
                                            this.L$4 = longRef3;
                                            this.L$5 = touchSlopDetector4;
                                            this.L$6 = pointerInputChange9;
                                            this.F$0 = f;
                                            this.label = 7;
                                            if (awaitPointerEventScope6.awaitPointerEvent(PointerEventPass.Final, this) != coroutine_suspended) {
                                                awaitPointerEventScope8 = awaitPointerEventScope6;
                                                f2 = f;
                                                longRef5 = longRef4;
                                                touchSlopDetector5 = touchSlopDetector4;
                                                pointerInputChange5 = pointerInputChange23;
                                                if (!pointerInputChange9.isConsumed()) {
                                                    awaitPointerEventScope2 = awaitPointerEventScope7;
                                                    pointerInputChange = pointerInputChange5;
                                                    r5 = 0;
                                                    r11 = 0;
                                                    if (r5 == 0) {
                                                    }
                                                    if (r5 != 0) {
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                                awaitPointerEventScope5 = awaitPointerEventScope8;
                                                touchSlopDetector6 = touchSlopDetector5;
                                                longRef6 = longRef3;
                                                r11 = 0;
                                                this.L$0 = awaitPointerEventScope7;
                                                this.L$1 = pointerInputChange5;
                                                this.L$2 = awaitPointerEventScope5;
                                                this.L$3 = longRef5;
                                                this.L$4 = longRef6;
                                                this.L$5 = touchSlopDetector6;
                                                this.L$6 = r11;
                                                this.F$0 = f2;
                                                this.label = 6;
                                                objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope5, r11, this, 1, r11);
                                                if (objAwaitPointerEvent$default != coroutine_suspended) {
                                                }
                                            }
                                        }
                                    } else {
                                        List<PointerInputChange> changes9 = pointerEvent2.getChanges();
                                        int size8 = changes9.size();
                                        int i10 = 0;
                                        while (true) {
                                            if (i10 < size8) {
                                                pointerInputChange10 = changes9.get(i10);
                                                if (!pointerInputChange10.getPressed()) {
                                                    i10++;
                                                }
                                            } else {
                                                pointerInputChange10 = null;
                                            }
                                        }
                                        PointerInputChange pointerInputChange24 = pointerInputChange10;
                                        if (pointerInputChange24 != null) {
                                            longRef3.element = pointerInputChange24.getId();
                                            touchSlopDetector4 = touchSlopDetector3;
                                        }
                                    }
                                    awaitPointerEventScope5 = awaitPointerEventScope6;
                                    touchSlopDetector6 = touchSlopDetector4;
                                    f2 = f;
                                    longRef5 = longRef4;
                                    longRef6 = longRef3;
                                    pointerInputChange5 = pointerInputChange7;
                                    r11 = 0;
                                    this.L$0 = awaitPointerEventScope7;
                                    this.L$1 = pointerInputChange5;
                                    this.L$2 = awaitPointerEventScope5;
                                    this.L$3 = longRef5;
                                    this.L$4 = longRef6;
                                    this.L$5 = touchSlopDetector6;
                                    this.L$6 = r11;
                                    this.F$0 = f2;
                                    this.label = 6;
                                    objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope5, r11, this, 1, r11);
                                    if (objAwaitPointerEvent$default != coroutine_suspended) {
                                    }
                                }
                                pointerInputChange = pointerInputChange7;
                                r5 = 0;
                                awaitPointerEventScope2 = awaitPointerEventScope7;
                                r11 = 0;
                                if (r5 == 0) {
                                }
                                if (r5 != 0) {
                                }
                                return Unit.INSTANCE;
                            }
                            return coroutine_suspended;
                        }
                        i9++;
                        r11 = 0;
                    }
                    PointerInputChange pointerInputChange25 = pointerInputChange5;
                    r5 = r2;
                    pointerInputChange = pointerInputChange25;
                    awaitPointerEventScope2 = awaitPointerEventScope5;
                    if (r5 == 0) {
                    }
                    if (r5 != 0) {
                    }
                    return Unit.INSTANCE;
                case 6:
                    j = InlineClassHelperKt.UnspecifiedPackedFloats;
                    j2 = 9223372034707292159L;
                    float f7 = this.F$0;
                    touchSlopDetector2 = (TouchSlopDetector) this.L$5;
                    Ref.LongRef longRef14 = (Ref.LongRef) this.L$4;
                    Ref.LongRef longRef15 = (Ref.LongRef) this.L$3;
                    AwaitPointerEventScope awaitPointerEventScope16 = (AwaitPointerEventScope) this.L$2;
                    pointerInputChange6 = (PointerInputChange) this.L$1;
                    AwaitPointerEventScope awaitPointerEventScope17 = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    objAwaitPointerEvent$default = obj;
                    f = f7;
                    longRef3 = longRef14;
                    awaitPointerEventScope6 = awaitPointerEventScope16;
                    awaitPointerEventScope7 = awaitPointerEventScope17;
                    longRef4 = longRef15;
                    pointerEvent = (PointerEvent) objAwaitPointerEvent$default;
                    List<PointerInputChange> changes82 = pointerEvent.getChanges();
                    size = changes82.size();
                    i = 0;
                    while (true) {
                        if (i >= size) {
                        }
                        i++;
                        touchSlopDetector2 = touchSlopDetector3;
                        pointerEvent = pointerEvent2;
                        pointerInputChange6 = pointerInputChange7;
                    }
                    pointerInputChange9 = pointerInputChange8;
                    if (pointerInputChange9 != null) {
                        if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange9)) {
                        }
                        awaitPointerEventScope5 = awaitPointerEventScope6;
                        touchSlopDetector6 = touchSlopDetector4;
                        f2 = f;
                        longRef5 = longRef4;
                        longRef6 = longRef3;
                        pointerInputChange5 = pointerInputChange7;
                        r11 = 0;
                        this.L$0 = awaitPointerEventScope7;
                        this.L$1 = pointerInputChange5;
                        this.L$2 = awaitPointerEventScope5;
                        this.L$3 = longRef5;
                        this.L$4 = longRef6;
                        this.L$5 = touchSlopDetector6;
                        this.L$6 = r11;
                        this.F$0 = f2;
                        this.label = 6;
                        objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope5, r11, this, 1, r11);
                        if (objAwaitPointerEvent$default != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    }
                    pointerInputChange = pointerInputChange7;
                    r5 = 0;
                    awaitPointerEventScope2 = awaitPointerEventScope7;
                    r11 = 0;
                    if (r5 == 0) {
                    }
                    if (r5 != 0) {
                    }
                    return Unit.INSTANCE;
                case 7:
                    f2 = this.F$0;
                    pointerInputChange9 = (PointerInputChange) this.L$6;
                    touchSlopDetector5 = (TouchSlopDetector) this.L$5;
                    longRef3 = (Ref.LongRef) this.L$4;
                    Ref.LongRef longRef16 = (Ref.LongRef) this.L$3;
                    j = InlineClassHelperKt.UnspecifiedPackedFloats;
                    AwaitPointerEventScope awaitPointerEventScope18 = (AwaitPointerEventScope) this.L$2;
                    PointerInputChange pointerInputChange26 = (PointerInputChange) this.L$1;
                    j2 = 9223372034707292159L;
                    AwaitPointerEventScope awaitPointerEventScope19 = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    awaitPointerEventScope8 = awaitPointerEventScope18;
                    pointerInputChange5 = pointerInputChange26;
                    awaitPointerEventScope7 = awaitPointerEventScope19;
                    longRef5 = longRef16;
                    if (!pointerInputChange9.isConsumed()) {
                    }
                    break;
                case 8:
                    longRef7 = (Ref.LongRef) this.L$3;
                    awaitPointerEventScope10 = (AwaitPointerEventScope) this.L$2;
                    function2 = (Function2) this.L$1;
                    AwaitPointerEventScope awaitPointerEventScope20 = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    objAwaitPointerEvent$default2 = obj;
                    awaitPointerEventScope9 = awaitPointerEventScope20;
                    orientation = null;
                    PointerEvent pointerEvent5 = (PointerEvent) objAwaitPointerEvent$default2;
                    List<PointerInputChange> changes10 = pointerEvent5.getChanges();
                    int size9 = changes10.size();
                    int i11 = 0;
                    while (true) {
                        if (i11 < size9) {
                            pointerInputChange12 = changes10.get(i11);
                            if (!PointerId.m7620equalsimpl0(pointerInputChange12.getId(), longRef7.element)) {
                                i11++;
                            }
                        } else {
                            pointerInputChange12 = null;
                        }
                    }
                    PointerInputChange pointerInputChange27 = pointerInputChange12;
                    if (pointerInputChange27 != null) {
                        if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange27)) {
                            List<PointerInputChange> changes11 = pointerEvent5.getChanges();
                            int size10 = changes11.size();
                            int i12 = 0;
                            while (true) {
                                if (i12 < size10) {
                                    pointerInputChange13 = changes11.get(i12);
                                    if (!pointerInputChange13.getPressed()) {
                                        i12++;
                                    }
                                } else {
                                    pointerInputChange13 = null;
                                }
                            }
                            PointerInputChange pointerInputChange28 = pointerInputChange13;
                            if (pointerInputChange28 != null) {
                                longRef7.element = pointerInputChange28.getId();
                                this.L$0 = awaitPointerEventScope9;
                                this.L$1 = function2;
                                this.L$2 = awaitPointerEventScope10;
                                this.L$3 = longRef7;
                                this.L$4 = null;
                                this.L$5 = null;
                                this.L$6 = null;
                                this.label = 8;
                                objAwaitPointerEvent$default2 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope10, null, this, 1, null);
                            }
                        } else {
                            long jPositionChangeIgnoreConsumed = PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange27);
                        }
                        break;
                    } else {
                        pointerInputChange27 = null;
                    }
                    if (pointerInputChange27 != null && !pointerInputChange27.isConsumed()) {
                        if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange27)) {
                            function2.invoke(pointerInputChange27, Offset.m6069boximpl(PointerEventKt.positionChange(pointerInputChange27)));
                            pointerInputChange27.consume();
                            id = pointerInputChange27.getId();
                            awaitPointerEventScope2 = awaitPointerEventScope9;
                            Ref.LongRef longRef112 = new Ref.LongRef();
                            longRef112.element = id;
                            longRef7 = longRef112;
                            awaitPointerEventScope10 = awaitPointerEventScope2;
                            awaitPointerEventScope9 = awaitPointerEventScope10;
                            this.L$0 = awaitPointerEventScope9;
                            this.L$1 = function2;
                            this.L$2 = awaitPointerEventScope10;
                            this.L$3 = longRef7;
                            this.L$4 = null;
                            this.L$5 = null;
                            this.L$6 = null;
                            this.label = 8;
                            objAwaitPointerEvent$default2 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope10, null, this, 1, null);
                        } else {
                            pointerInputChange11 = pointerInputChange27;
                        }
                        break;
                    } else {
                        pointerInputChange11 = null;
                    }
                    if (pointerInputChange11 != null) {
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5, reason: invalid class name */
    /* JADX INFO: compiled from: DragGestureDetector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5", f = "DragGestureDetector.kt", i = {0, 1, 2}, l = {359, 360, 365}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "$this$awaitEachGesture"}, s = {"L$0", "L$0", "L$0"}, v = 1)
    static final class AnonymousClass5 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<PointerInputChange, Offset, Unit> $onDrag;
        final /* synthetic */ Function0<Unit> $onDragCancel;
        final /* synthetic */ Function0<Unit> $onDragEnd;
        final /* synthetic */ Function1<Offset, Unit> $onDragStart;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass5(Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super AnonymousClass5> continuation) {
            super(2, continuation);
            this.$onDragStart = function1;
            this.$onDragEnd = function0;
            this.$onDragCancel = function02;
            this.$onDrag = function2;
        }

        static final Unit invokeSuspend$lambda$0(Function2 function2, PointerInputChange pointerInputChange) {
            function2.invoke(pointerInputChange, Offset.m6069boximpl(PointerEventKt.positionChange(pointerInputChange)));
            pointerInputChange.consume();
            return Unit.INSTANCE;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass5 anonymousClass5 = new AnonymousClass5(this.$onDragStart, this.$onDragEnd, this.$onDragCancel, this.$onDrag, continuation);
            anonymousClass5.L$0 = obj;
            return anonymousClass5;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass5) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x0065 A[Catch: CancellationException -> 0x00c6, TryCatch #0 {CancellationException -> 0x00c6, blocks: (B:8:0x0015, B:32:0x008c, B:34:0x0094, B:36:0x00a6, B:38:0x00b2, B:39:0x00b5, B:40:0x00b8, B:41:0x00be, B:13:0x0026, B:26:0x0061, B:28:0x0065, B:16:0x002e, B:23:0x004d, B:19:0x003a), top: B:47:0x0009 }] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0094 A[Catch: CancellationException -> 0x00c6, TryCatch #0 {CancellationException -> 0x00c6, blocks: (B:8:0x0015, B:32:0x008c, B:34:0x0094, B:36:0x00a6, B:38:0x00b2, B:39:0x00b5, B:40:0x00b8, B:41:0x00be, B:13:0x0026, B:26:0x0061, B:28:0x0065, B:16:0x002e, B:23:0x004d, B:19:0x003a), top: B:47:0x0009 }] */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00be A[Catch: CancellationException -> 0x00c6, TRY_LEAVE, TryCatch #0 {CancellationException -> 0x00c6, blocks: (B:8:0x0015, B:32:0x008c, B:34:0x0094, B:36:0x00a6, B:38:0x00b2, B:39:0x00b5, B:40:0x00b8, B:41:0x00be, B:13:0x0026, B:26:0x0061, B:28:0x0065, B:16:0x002e, B:23:0x004d, B:19:0x003a), top: B:47:0x0009 }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            AwaitPointerEventScope awaitPointerEventScope;
            PointerInputChange pointerInputChange;
            AwaitPointerEventScope awaitPointerEventScope2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                    this.L$0 = awaitPointerEventScope3;
                    this.label = 1;
                    obj = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope3, false, null, this, 2, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    awaitPointerEventScope = awaitPointerEventScope3;
                } else {
                    if (i != 1) {
                        if (i == 2) {
                            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            pointerInputChange = (PointerInputChange) obj;
                            if (pointerInputChange != null) {
                                this.$onDragStart.invoke(Offset.m6069boximpl(pointerInputChange.getPosition()));
                                long id = pointerInputChange.getId();
                                final Function2<PointerInputChange, Offset, Unit> function2 = this.$onDrag;
                                this.L$0 = awaitPointerEventScope;
                                this.label = 3;
                                obj = DragGestureDetectorKt.m1692dragjO51t88(awaitPointerEventScope, id, new Function1() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        return DragGestureDetectorKt.AnonymousClass5.invokeSuspend$lambda$0(function2, (PointerInputChange) obj2);
                                    }
                                }, this);
                                if (obj != coroutine_suspended) {
                                    awaitPointerEventScope2 = awaitPointerEventScope;
                                    if (((Boolean) obj).booleanValue()) {
                                    }
                                }
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        }
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        if (((Boolean) obj).booleanValue()) {
                            this.$onDragCancel.invoke();
                        } else {
                            List<PointerInputChange> changes = awaitPointerEventScope2.getCurrentEvent().getChanges();
                            int size = changes.size();
                            for (int i2 = 0; i2 < size; i2++) {
                                PointerInputChange pointerInputChange2 = changes.get(i2);
                                if (PointerEventKt.changedToUp(pointerInputChange2)) {
                                    pointerInputChange2.consume();
                                }
                            }
                            this.$onDragEnd.invoke();
                        }
                        return Unit.INSTANCE;
                    }
                    awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                this.L$0 = awaitPointerEventScope;
                this.label = 2;
                obj = DragGestureDetectorKt.m1682awaitLongPressOrCancellationrnUCldI(awaitPointerEventScope, ((PointerInputChange) obj).getId(), this);
                if (obj != coroutine_suspended) {
                    pointerInputChange = (PointerInputChange) obj;
                    if (pointerInputChange != null) {
                    }
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            } catch (CancellationException e) {
                this.$onDragCancel.invoke();
                throw e;
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DragGestureDetector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5", f = "DragGestureDetector.kt", i = {0, 1, 1}, l = {TypedValues.TransitionType.TYPE_TO, TypedValues.TransitionType.TYPE_INTERPOLATOR, 713}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "overSlop"}, s = {"L$0", "L$0", "L$1"}, v = 1)
    static final class C03215 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $onDragCancel;
        final /* synthetic */ Function0<Unit> $onDragEnd;
        final /* synthetic */ Function1<Offset, Unit> $onDragStart;
        final /* synthetic */ Function2<PointerInputChange, Float, Unit> $onHorizontalDrag;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C03215(Function1<? super Offset, Unit> function1, Function2<? super PointerInputChange, ? super Float, Unit> function2, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super C03215> continuation) {
            super(2, continuation);
            this.$onDragStart = function1;
            this.$onHorizontalDrag = function2;
            this.$onDragEnd = function0;
            this.$onDragCancel = function02;
        }

        static final Unit invokeSuspend$lambda$0(Ref.FloatRef floatRef, PointerInputChange pointerInputChange, float f) {
            pointerInputChange.consume();
            floatRef.element = f;
            return Unit.INSTANCE;
        }

        static final Unit invokeSuspend$lambda$1(Function2 function2, PointerInputChange pointerInputChange) {
            function2.invoke(pointerInputChange, Float.valueOf(Float.intBitsToFloat((int) (PointerEventKt.positionChange(pointerInputChange) >> 32))));
            pointerInputChange.consume();
            return Unit.INSTANCE;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C03215 c03215 = new C03215(this.$onDragStart, this.$onHorizontalDrag, this.$onDragEnd, this.$onDragCancel, continuation);
            c03215.L$0 = obj;
            return c03215;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((C03215) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x00a8, code lost:
        
            if (r12 == r0) goto L24;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0077  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            AwaitPointerEventScope awaitPointerEventScope;
            final Ref.FloatRef floatRef;
            AwaitPointerEventScope awaitPointerEventScope2;
            PointerInputChange pointerInputChange;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                this.L$0 = awaitPointerEventScope3;
                this.label = 1;
                obj = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope3, false, null, this, 2, null);
                if (obj != coroutine_suspended) {
                    awaitPointerEventScope = awaitPointerEventScope3;
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    if (((Boolean) obj).booleanValue()) {
                        this.$onDragEnd.invoke();
                    } else {
                        this.$onDragCancel.invoke();
                    }
                    return Unit.INSTANCE;
                }
                floatRef = (Ref.FloatRef) this.L$1;
                awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                pointerInputChange = (PointerInputChange) obj;
                if (pointerInputChange != null) {
                    this.$onDragStart.invoke(Offset.m6069boximpl(pointerInputChange.getPosition()));
                    this.$onHorizontalDrag.invoke(pointerInputChange, Boxing.boxFloat(floatRef.element));
                    long id = pointerInputChange.getId();
                    final Function2<PointerInputChange, Float, Unit> function2 = this.$onHorizontalDrag;
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 3;
                    obj = DragGestureDetectorKt.m1693horizontalDragjO51t88(awaitPointerEventScope2, id, new Function1() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return DragGestureDetectorKt.C03215.invokeSuspend$lambda$1(function2, (PointerInputChange) obj2);
                        }
                    }, this);
                }
                return Unit.INSTANCE;
            }
            AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            awaitPointerEventScope = awaitPointerEventScope4;
            PointerInputChange pointerInputChange2 = (PointerInputChange) obj;
            floatRef = new Ref.FloatRef();
            this.L$0 = awaitPointerEventScope;
            this.L$1 = floatRef;
            this.label = 2;
            obj = DragGestureDetectorKt.m1680awaitHorizontalPointerSlopOrCancellationgDDlDlE(awaitPointerEventScope, pointerInputChange2.getId(), pointerInputChange2.getType(), new Function2() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectHorizontalDragGestures$5$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return DragGestureDetectorKt.C03215.invokeSuspend$lambda$0(floatRef, (PointerInputChange) obj2, ((Float) obj3).floatValue());
                }
            }, this);
            if (obj != coroutine_suspended) {
                awaitPointerEventScope2 = awaitPointerEventScope;
                pointerInputChange = (PointerInputChange) obj;
                if (pointerInputChange != null) {
                }
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DragGestureDetector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5", f = "DragGestureDetector.kt", i = {0, 1, 1}, l = {Videoio.CAP_PROP_XI_SENSOR_CLOCK_FREQ_INDEX, Videoio.CAP_PROP_XI_COUNTER_SELECTOR, Videoio.CAP_PROP_XI_TRG_DELAY}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "overSlop"}, s = {"L$0", "L$0", "L$1"}, v = 1)
    static final class C03225 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $onDragCancel;
        final /* synthetic */ Function0<Unit> $onDragEnd;
        final /* synthetic */ Function1<Offset, Unit> $onDragStart;
        final /* synthetic */ Function2<PointerInputChange, Float, Unit> $onVerticalDrag;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C03225(Function1<? super Offset, Unit> function1, Function2<? super PointerInputChange, ? super Float, Unit> function2, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super C03225> continuation) {
            super(2, continuation);
            this.$onDragStart = function1;
            this.$onVerticalDrag = function2;
            this.$onDragEnd = function0;
            this.$onDragCancel = function02;
        }

        static final Unit invokeSuspend$lambda$0(Ref.FloatRef floatRef, PointerInputChange pointerInputChange, float f) {
            pointerInputChange.consume();
            floatRef.element = f;
            return Unit.INSTANCE;
        }

        static final Unit invokeSuspend$lambda$1(Function2 function2, PointerInputChange pointerInputChange) {
            function2.invoke(pointerInputChange, Float.valueOf(Float.intBitsToFloat((int) (PointerEventKt.positionChange(pointerInputChange) & MuxerUtil.UNSIGNED_INT_MAX_VALUE))));
            pointerInputChange.consume();
            return Unit.INSTANCE;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C03225 c03225 = new C03225(this.$onDragStart, this.$onVerticalDrag, this.$onDragEnd, this.$onDragCancel, continuation);
            c03225.L$0 = obj;
            return c03225;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((C03225) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x00a8, code lost:
        
            if (r12 == r0) goto L24;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0077  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            AwaitPointerEventScope awaitPointerEventScope;
            final Ref.FloatRef floatRef;
            AwaitPointerEventScope awaitPointerEventScope2;
            PointerInputChange pointerInputChange;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                this.L$0 = awaitPointerEventScope3;
                this.label = 1;
                obj = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope3, false, null, this, 2, null);
                if (obj != coroutine_suspended) {
                    awaitPointerEventScope = awaitPointerEventScope3;
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    if (((Boolean) obj).booleanValue()) {
                        this.$onDragEnd.invoke();
                    } else {
                        this.$onDragCancel.invoke();
                    }
                    return Unit.INSTANCE;
                }
                floatRef = (Ref.FloatRef) this.L$1;
                awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                pointerInputChange = (PointerInputChange) obj;
                if (pointerInputChange != null) {
                    this.$onDragStart.invoke(Offset.m6069boximpl(pointerInputChange.getPosition()));
                    this.$onVerticalDrag.invoke(pointerInputChange, Boxing.boxFloat(floatRef.element));
                    long id = pointerInputChange.getId();
                    final Function2<PointerInputChange, Float, Unit> function2 = this.$onVerticalDrag;
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 3;
                    obj = DragGestureDetectorKt.m1696verticalDragjO51t88(awaitPointerEventScope2, id, new Function1() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return DragGestureDetectorKt.C03225.invokeSuspend$lambda$1(function2, (PointerInputChange) obj2);
                        }
                    }, this);
                }
                return Unit.INSTANCE;
            }
            AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            awaitPointerEventScope = awaitPointerEventScope4;
            PointerInputChange pointerInputChange2 = (PointerInputChange) obj;
            floatRef = new Ref.FloatRef();
            this.L$0 = awaitPointerEventScope;
            this.L$1 = floatRef;
            this.label = 2;
            obj = DragGestureDetectorKt.m1688awaitVerticalPointerSlopOrCancellationgDDlDlE(awaitPointerEventScope, pointerInputChange2.getId(), pointerInputChange2.getType(), new Function2() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectVerticalDragGestures$5$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return DragGestureDetectorKt.C03225.invokeSuspend$lambda$0(floatRef, (PointerInputChange) obj2, ((Float) obj3).floatValue());
                }
            }, this);
            if (obj != coroutine_suspended) {
                awaitPointerEventScope2 = awaitPointerEventScope;
                pointerInputChange = (PointerInputChange) obj;
                if (pointerInputChange != null) {
                }
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        }
    }

    static {
        float fM9114constructorimpl = Dp.m9114constructorimpl(0.125f);
        mouseSlop = fM9114constructorimpl;
        float fM9114constructorimpl2 = Dp.m9114constructorimpl(18.0f);
        defaultTouchSlop = fM9114constructorimpl2;
        mouseToTouchSlopRatio = fM9114constructorimpl / fM9114constructorimpl2;
    }

    /* JADX WARN: Path cross not found for [B:32:0x00d5, B:38:0x00f9], limit reached: 70 */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00d0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0119 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x009c -> B:23:0x00a3). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object awaitAllPointersUpWithSlopDetection(AwaitPointerEventScope awaitPointerEventScope, PointerInputChange pointerInputChange, PointerEventPass pointerEventPass, Continuation<? super Boolean> continuation) {
        AnonymousClass1 anonymousClass1;
        Ref.LongRef longRef;
        int i;
        TouchSlopDetector touchSlopDetector;
        AwaitPointerEventScope awaitPointerEventScope2;
        float f;
        AnonymousClass1 anonymousClass12;
        PointerEventPass pointerEventPass2;
        Object objAwaitPointerEvent;
        PointerInputChange pointerInputChange2;
        int size;
        int i2;
        PointerInputChange pointerInputChange3;
        PointerInputChange pointerInputChange4;
        int size2;
        int i3;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = anonymousClass1.label;
        int i5 = 0;
        int i6 = 1;
        if (i4 != 0) {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            float f2 = anonymousClass1.F$0;
            int i7 = anonymousClass1.I$0;
            TouchSlopDetector touchSlopDetector2 = (TouchSlopDetector) anonymousClass1.L$3;
            Ref.LongRef longRef2 = (Ref.LongRef) anonymousClass1.L$2;
            PointerEventPass pointerEventPass3 = (PointerEventPass) anonymousClass1.L$1;
            AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            float f3 = f2;
            TouchSlopDetector touchSlopDetector3 = touchSlopDetector2;
            anonymousClass12 = anonymousClass1;
            pointerEventPass2 = pointerEventPass3;
            longRef = longRef2;
            PointerEvent pointerEvent = (PointerEvent) obj;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size3 = changes.size();
            int i8 = i5;
            while (true) {
                if (i8 < size3) {
                    pointerInputChange2 = null;
                    break;
                }
                PointerInputChange pointerInputChange5 = changes.get(i8);
                if (PointerId.m7620equalsimpl0(pointerInputChange5.getId(), longRef.element)) {
                    pointerInputChange2 = pointerInputChange5;
                    break;
                }
                i8++;
            }
            PointerInputChange pointerInputChange6 = pointerInputChange2;
            if (pointerInputChange6 == null && !PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange6)) {
                if ((touchSlopDetector3.m1823addPositionsakrDWew(pointerInputChange6.getPosition(), pointerInputChange6.getPreviousPosition(), f3) & 9223372034707292159L) != InlineClassHelperKt.UnspecifiedPackedFloats) {
                    i = 1;
                }
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                size2 = changes2.size();
                for (i3 = 0; i3 < size2; i3++) {
                    if (changes2.get(i3).getPressed()) {
                        awaitPointerEventScope2 = awaitPointerEventScope3;
                        touchSlopDetector = touchSlopDetector3;
                        f = f3;
                        i5 = 0;
                        i6 = 1;
                        anonymousClass12.L$0 = awaitPointerEventScope2;
                        anonymousClass12.L$1 = pointerEventPass2;
                        anonymousClass12.L$2 = longRef;
                        anonymousClass12.L$3 = touchSlopDetector;
                        anonymousClass12.I$0 = i;
                        anonymousClass12.F$0 = f;
                        anonymousClass12.label = i6;
                        objAwaitPointerEvent = awaitPointerEventScope2.awaitPointerEvent(pointerEventPass2, anonymousClass12);
                        if (objAwaitPointerEvent != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        awaitPointerEventScope3 = awaitPointerEventScope2;
                        obj = objAwaitPointerEvent;
                        f3 = f;
                        i7 = i;
                        touchSlopDetector3 = touchSlopDetector;
                        PointerEvent pointerEvent2 = (PointerEvent) obj;
                        List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                        int size32 = changes3.size();
                        int i82 = i5;
                        while (true) {
                            if (i82 < size32) {
                            }
                            i82++;
                        }
                        PointerInputChange pointerInputChange62 = pointerInputChange2;
                        if (pointerInputChange62 == null) {
                        }
                        List<PointerInputChange> changes4 = pointerEvent2.getChanges();
                        size = changes4.size();
                        i2 = 0;
                        while (true) {
                            if (i2 < size) {
                            }
                            i2++;
                        }
                        pointerInputChange4 = pointerInputChange3;
                        if (pointerInputChange4 != null) {
                        }
                    }
                }
                return Boxing.boxBoolean(i == 0);
            }
            List<PointerInputChange> changes42 = pointerEvent2.getChanges();
            size = changes42.size();
            i2 = 0;
            while (true) {
                if (i2 < size) {
                    pointerInputChange3 = null;
                    break;
                }
                PointerInputChange pointerInputChange7 = changes42.get(i2);
                if (pointerInputChange7.getPressed()) {
                    pointerInputChange3 = pointerInputChange7;
                    break;
                }
                i2++;
            }
            pointerInputChange4 = pointerInputChange3;
            if (pointerInputChange4 != null) {
                return Boxing.boxBoolean(i7 != 0);
            }
            longRef.element = pointerInputChange4.getId();
            i = i7;
            List<PointerInputChange> changes22 = pointerEvent2.getChanges();
            size2 = changes22.size();
            while (i3 < size2) {
            }
            return Boxing.boxBoolean(i == 0);
        }
        ResultKt.throwOnFailure(obj);
        if (ForEachGestureKt.allPointersUp(awaitPointerEventScope)) {
            return Boxing.boxBoolean(false);
        }
        Ref.LongRef longRef3 = new Ref.LongRef();
        longRef3.element = pointerInputChange.getId();
        float fM1695pointerSlopE8SPZFQ = m1695pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), pointerInputChange.getType());
        longRef = longRef3;
        i = 0;
        touchSlopDetector = new TouchSlopDetector(null, 0L, 3, null);
        awaitPointerEventScope2 = awaitPointerEventScope;
        f = fM1695pointerSlopE8SPZFQ;
        anonymousClass12 = anonymousClass1;
        pointerEventPass2 = pointerEventPass;
        anonymousClass12.L$0 = awaitPointerEventScope2;
        anonymousClass12.L$1 = pointerEventPass2;
        anonymousClass12.L$2 = longRef;
        anonymousClass12.L$3 = touchSlopDetector;
        anonymousClass12.I$0 = i;
        anonymousClass12.F$0 = f;
        anonymousClass12.label = i6;
        objAwaitPointerEvent = awaitPointerEventScope2.awaitPointerEvent(pointerEventPass2, anonymousClass12);
        if (objAwaitPointerEvent != coroutine_suspended) {
        }
    }

    public static /* synthetic */ Object awaitAllPointersUpWithSlopDetection$default(AwaitPointerEventScope awaitPointerEventScope, PointerInputChange pointerInputChange, PointerEventPass pointerEventPass, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            pointerEventPass = PointerEventPass.Main;
        }
        return awaitAllPointersUpWithSlopDetection(awaitPointerEventScope, pointerInputChange, pointerEventPass, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00d1, code lost:
    
        if (androidx.compose.ui.input.pointer.PointerEventKt.positionChangedIgnoreConsumed(r11) != false) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0067 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0095 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0068 -> B:22:0x006d). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: awaitDragOrCancellation-rnUCldI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m1677awaitDragOrCancellationrnUCldI(AwaitPointerEventScope awaitPointerEventScope, long j, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitDragOrCancellation$1 dragGestureDetectorKt$awaitDragOrCancellation$1;
        Ref.LongRef longRef;
        AwaitPointerEventScope awaitPointerEventScope2;
        Object objAwaitPointerEvent$default;
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        if (continuation instanceof DragGestureDetectorKt$awaitDragOrCancellation$1) {
            dragGestureDetectorKt$awaitDragOrCancellation$1 = (DragGestureDetectorKt$awaitDragOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitDragOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitDragOrCancellation$1.label -= Integer.MIN_VALUE;
            } else {
                dragGestureDetectorKt$awaitDragOrCancellation$1 = new DragGestureDetectorKt$awaitDragOrCancellation$1(continuation);
            }
        }
        Object obj = dragGestureDetectorKt$awaitDragOrCancellation$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = dragGestureDetectorKt$awaitDragOrCancellation$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Ref.LongRef longRef2 = (Ref.LongRef) dragGestureDetectorKt$awaitDragOrCancellation$1.L$1;
            AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitDragOrCancellation$1.L$0;
            ResultKt.throwOnFailure(obj);
            Ref.LongRef longRef3 = longRef2;
            awaitPointerEventScope2 = awaitPointerEventScope3;
            PointerEvent pointerEvent = (PointerEvent) obj;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 < size) {
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes.get(i3);
                if (PointerId.m7620equalsimpl0(pointerInputChange.getId(), longRef3.element)) {
                    break;
                }
                i3++;
            }
            PointerInputChange pointerInputChange3 = pointerInputChange;
            if (pointerInputChange3 == null) {
                if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                    List<PointerInputChange> changes2 = pointerEvent.getChanges();
                    int size2 = changes2.size();
                    while (true) {
                        if (i2 >= size2) {
                            pointerInputChange2 = null;
                            break;
                        }
                        pointerInputChange2 = changes2.get(i2);
                        if (pointerInputChange2.getPressed()) {
                            break;
                        }
                        i2++;
                    }
                    PointerInputChange pointerInputChange4 = pointerInputChange2;
                    if (pointerInputChange4 != null) {
                        longRef3.element = pointerInputChange4.getId();
                        longRef = longRef3;
                    }
                }
                dragGestureDetectorKt$awaitDragOrCancellation$1.L$0 = awaitPointerEventScope2;
                dragGestureDetectorKt$awaitDragOrCancellation$1.L$1 = longRef;
                dragGestureDetectorKt$awaitDragOrCancellation$1.label = 1;
                objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitDragOrCancellation$1, 1, null);
                if (objAwaitPointerEvent$default != coroutine_suspended) {
                    return coroutine_suspended;
                }
                Ref.LongRef longRef4 = longRef;
                obj = objAwaitPointerEvent$default;
                longRef3 = longRef4;
                PointerEvent pointerEvent2 = (PointerEvent) obj;
                List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                int size3 = changes3.size();
                int i22 = 0;
                int i32 = 0;
                while (true) {
                    if (i32 < size3) {
                    }
                    i32++;
                }
                PointerInputChange pointerInputChange32 = pointerInputChange;
                if (pointerInputChange32 == null) {
                    pointerInputChange32 = null;
                }
            }
            if (pointerInputChange32 == null || pointerInputChange32.isConsumed()) {
                return null;
            }
            return pointerInputChange32;
        }
        ResultKt.throwOnFailure(obj);
        if (m1694isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
            return null;
        }
        longRef = new Ref.LongRef();
        longRef.element = j;
        awaitPointerEventScope2 = awaitPointerEventScope;
        dragGestureDetectorKt$awaitDragOrCancellation$1.L$0 = awaitPointerEventScope2;
        dragGestureDetectorKt$awaitDragOrCancellation$1.L$1 = longRef;
        dragGestureDetectorKt$awaitDragOrCancellation$1.label = 1;
        objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitDragOrCancellation$1, 1, null);
        if (objAwaitPointerEvent$default != coroutine_suspended) {
        }
    }

    /* JADX INFO: renamed from: awaitDragOrUp-jO51t88, reason: not valid java name */
    private static final Object m1678awaitDragOrUpjO51t88(AwaitPointerEventScope awaitPointerEventScope, long j, Function1<? super PointerInputChange, Boolean> function1, Continuation<? super PointerInputChange> continuation) {
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = j;
        while (true) {
            PointerInputChange pointerInputChange3 = null;
            PointerEvent pointerEvent = (PointerEvent) AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, continuation, 1, null);
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes.get(i2);
                if (Boolean.valueOf(PointerId.m7620equalsimpl0(pointerInputChange.getId(), longRef.element)).booleanValue()) {
                    break;
                }
                i2++;
            }
            pointerInputChange2 = pointerInputChange;
            if (pointerInputChange2 == null) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                int size2 = changes2.size();
                while (true) {
                    if (i >= size2) {
                        break;
                    }
                    PointerInputChange pointerInputChange4 = changes2.get(i);
                    if (Boolean.valueOf(pointerInputChange4.getPressed()).booleanValue()) {
                        pointerInputChange3 = pointerInputChange4;
                        break;
                    }
                    i++;
                }
                PointerInputChange pointerInputChange5 = pointerInputChange3;
                if (pointerInputChange5 == null) {
                    break;
                }
                longRef.element = pointerInputChange5.getId();
            } else if (function1.invoke(pointerInputChange2).booleanValue()) {
                break;
            }
        }
        return pointerInputChange2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00df, code lost:
    
        if ((java.lang.Float.intBitsToFloat((int) (androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r11) >> 32)) == 0.0f ? 1 : 0) == 0) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0067 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0095 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0068 -> B:22:0x006d). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: awaitHorizontalDragOrCancellation-rnUCldI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m1679awaitHorizontalDragOrCancellationrnUCldI(AwaitPointerEventScope awaitPointerEventScope, long j, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1 dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1;
        Ref.LongRef longRef;
        AwaitPointerEventScope awaitPointerEventScope2;
        Object objAwaitPointerEvent$default;
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        if (continuation instanceof DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1) {
            dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1 = (DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.label -= Integer.MIN_VALUE;
            } else {
                dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1 = new DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1(continuation);
            }
        }
        Object obj = dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Ref.LongRef longRef2 = (Ref.LongRef) dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.L$1;
            AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.L$0;
            ResultKt.throwOnFailure(obj);
            Ref.LongRef longRef3 = longRef2;
            awaitPointerEventScope2 = awaitPointerEventScope3;
            PointerEvent pointerEvent = (PointerEvent) obj;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i2 = 0;
            while (true) {
                if (i2 < size) {
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes.get(i2);
                if (PointerId.m7620equalsimpl0(pointerInputChange.getId(), longRef3.element)) {
                    break;
                }
                i2++;
            }
            PointerInputChange pointerInputChange3 = pointerInputChange;
            if (pointerInputChange3 == null) {
                if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                    List<PointerInputChange> changes2 = pointerEvent.getChanges();
                    int size2 = changes2.size();
                    while (true) {
                        if (i >= size2) {
                            pointerInputChange2 = null;
                            break;
                        }
                        pointerInputChange2 = changes2.get(i);
                        if (pointerInputChange2.getPressed()) {
                            break;
                        }
                        i++;
                    }
                    PointerInputChange pointerInputChange4 = pointerInputChange2;
                    if (pointerInputChange4 != null) {
                        longRef3.element = pointerInputChange4.getId();
                        longRef = longRef3;
                    }
                }
                dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.L$0 = awaitPointerEventScope2;
                dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.L$1 = longRef;
                dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.label = 1;
                objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1, 1, null);
                if (objAwaitPointerEvent$default != coroutine_suspended) {
                    return coroutine_suspended;
                }
                Ref.LongRef longRef4 = longRef;
                obj = objAwaitPointerEvent$default;
                longRef3 = longRef4;
                PointerEvent pointerEvent2 = (PointerEvent) obj;
                List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                int size3 = changes3.size();
                int i22 = 0;
                while (true) {
                    if (i22 < size3) {
                    }
                    i22++;
                }
                PointerInputChange pointerInputChange32 = pointerInputChange;
                if (pointerInputChange32 == null) {
                    pointerInputChange32 = null;
                }
            }
            if (pointerInputChange32 == null || pointerInputChange32.isConsumed()) {
                return null;
            }
            return pointerInputChange32;
        }
        ResultKt.throwOnFailure(obj);
        if (m1694isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
            return null;
        }
        longRef = new Ref.LongRef();
        longRef.element = j;
        awaitPointerEventScope2 = awaitPointerEventScope;
        dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.L$0 = awaitPointerEventScope2;
        dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.L$1 = longRef;
        dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1.label = 1;
        objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitHorizontalDragOrCancellation$1, 1, null);
        if (objAwaitPointerEvent$default != coroutine_suspended) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0193 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x018c -> B:61:0x018d). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: awaitHorizontalPointerSlopOrCancellation-gDDlDlE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m1680awaitHorizontalPointerSlopOrCancellationgDDlDlE(AwaitPointerEventScope awaitPointerEventScope, long j, int i, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1 dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1;
        float fM1695pointerSlopE8SPZFQ;
        Ref.LongRef longRef;
        Function2<? super PointerInputChange, ? super Float, Unit> function22;
        TouchSlopDetector touchSlopDetector;
        AwaitPointerEventScope awaitPointerEventScope2;
        Function2<? super PointerInputChange, ? super Float, Unit> function23;
        AwaitPointerEventScope awaitPointerEventScope3;
        TouchSlopDetector touchSlopDetector2;
        float f;
        int size;
        int i2;
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        PointerInputChange pointerInputChange3;
        int i3;
        Object objAwaitPointerEvent$default;
        if (continuation instanceof DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1) {
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1 = (DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.label -= Integer.MIN_VALUE;
            } else {
                dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1 = new DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1(continuation);
            }
        }
        Object obj = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.label;
        int i5 = 1;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            Orientation orientation = Orientation.Horizontal;
            long jM6096getZeroF1C5BW0 = Offset.INSTANCE.m6096getZeroF1C5BW0();
            if (m1694isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
                return null;
            }
            fM1695pointerSlopE8SPZFQ = m1695pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), i);
            longRef = new Ref.LongRef();
            longRef.element = j;
            function22 = function2;
            touchSlopDetector = new TouchSlopDetector(orientation, jM6096getZeroF1C5BW0, null);
            awaitPointerEventScope2 = awaitPointerEventScope;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$0 = function22;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$2 = longRef;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$4 = null;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.F$0 = fM1695pointerSlopE8SPZFQ;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.label = i5;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1, i5, null);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i4 == 1) {
            f = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.F$0;
            touchSlopDetector2 = (TouchSlopDetector) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$3;
            Ref.LongRef longRef2 = (Ref.LongRef) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$2;
            awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$1;
            function23 = (Function2) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$0;
            ResultKt.throwOnFailure(obj);
            longRef = longRef2;
            PointerEvent pointerEvent = (PointerEvent) obj;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            size = changes.size();
            i2 = 0;
            while (true) {
                if (i2 < size) {
                }
                i2 = i3 + 1;
            }
            pointerInputChange2 = pointerInputChange;
            if (pointerInputChange2 != null) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
            }
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$0 = function22;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$2 = longRef;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$4 = null;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.F$0 = fM1695pointerSlopE8SPZFQ;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.label = i5;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1, i5, null);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i4 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        float f2 = dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.F$0;
        PointerInputChange pointerInputChange4 = (PointerInputChange) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$4;
        TouchSlopDetector touchSlopDetector3 = (TouchSlopDetector) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$3;
        Ref.LongRef longRef3 = (Ref.LongRef) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$2;
        AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$1;
        Function2<? super PointerInputChange, ? super Float, Unit> function24 = (Function2) dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$0;
        ResultKt.throwOnFailure(obj);
        touchSlopDetector = touchSlopDetector3;
        pointerInputChange2 = pointerInputChange4;
        char c = 2;
        float f3 = f2;
        awaitPointerEventScope2 = awaitPointerEventScope4;
        function23 = function24;
        longRef = longRef3;
        if (!pointerInputChange2.isConsumed()) {
            return null;
        }
        fM1695pointerSlopE8SPZFQ = f3;
        function22 = function23;
        dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$0 = function22;
        dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$1 = awaitPointerEventScope2;
        dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$2 = longRef;
        dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$3 = touchSlopDetector;
        dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$4 = null;
        dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.F$0 = fM1695pointerSlopE8SPZFQ;
        dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.label = i5;
        objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1, i5, null);
        if (objAwaitPointerEvent$default != coroutine_suspended) {
            function23 = function22;
            touchSlopDetector2 = touchSlopDetector;
            obj = objAwaitPointerEvent$default;
            awaitPointerEventScope3 = awaitPointerEventScope2;
            f = fM1695pointerSlopE8SPZFQ;
            PointerEvent pointerEvent2 = (PointerEvent) obj;
            List<PointerInputChange> changes2 = pointerEvent2.getChanges();
            size = changes2.size();
            i2 = 0;
            while (true) {
                if (i2 < size) {
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes2.get(i2);
                i3 = i2;
                if (PointerId.m7620equalsimpl0(pointerInputChange.getId(), longRef.element)) {
                    break;
                }
                i2 = i3 + 1;
            }
            pointerInputChange2 = pointerInputChange;
            if (pointerInputChange2 != null || pointerInputChange2.isConsumed()) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                float f4 = f;
                TouchSlopDetector touchSlopDetector4 = touchSlopDetector2;
                long jM1823addPositionsakrDWew = touchSlopDetector4.m1823addPositionsakrDWew(pointerInputChange2.getPosition(), pointerInputChange2.getPreviousPosition(), f4);
                touchSlopDetector = touchSlopDetector4;
                f3 = f4;
                if ((9223372034707292159L & jM1823addPositionsakrDWew) != InlineClassHelperKt.UnspecifiedPackedFloats) {
                    function23.invoke(pointerInputChange2, Boxing.boxFloat(Float.intBitsToFloat((int) (jM1823addPositionsakrDWew >> 32))));
                    if (pointerInputChange2.isConsumed()) {
                        return pointerInputChange2;
                    }
                    i5 = 1;
                    TouchSlopDetector.m1822resetk4lQ0M$default(touchSlopDetector, 0L, 1, null);
                    fM1695pointerSlopE8SPZFQ = f3;
                    awaitPointerEventScope2 = awaitPointerEventScope3;
                    function22 = function23;
                } else {
                    i5 = 1;
                    PointerEventPass pointerEventPass = PointerEventPass.Final;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$0 = function23;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$1 = awaitPointerEventScope3;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$2 = longRef;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$3 = touchSlopDetector;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$4 = pointerInputChange2;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.F$0 = f3;
                    c = 2;
                    dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.label = 2;
                    if (awaitPointerEventScope3.awaitPointerEvent(pointerEventPass, dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1) != coroutine_suspended) {
                        awaitPointerEventScope2 = awaitPointerEventScope3;
                        if (!pointerInputChange2.isConsumed()) {
                        }
                    }
                }
            } else {
                List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                int size2 = changes3.size();
                int i6 = 0;
                while (true) {
                    if (i6 >= size2) {
                        pointerInputChange3 = null;
                        break;
                    }
                    pointerInputChange3 = changes3.get(i6);
                    if (pointerInputChange3.getPressed()) {
                        break;
                    }
                    i6++;
                }
                PointerInputChange pointerInputChange5 = pointerInputChange3;
                if (pointerInputChange5 == null) {
                    return null;
                }
                longRef.element = pointerInputChange5.getId();
                touchSlopDetector = touchSlopDetector2;
                i5 = 1;
                fM1695pointerSlopE8SPZFQ = f;
                awaitPointerEventScope2 = awaitPointerEventScope3;
                function22 = function23;
            }
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$0 = function22;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$2 = longRef;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.L$4 = null;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.F$0 = fM1695pointerSlopE8SPZFQ;
            dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1.label = i5;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1, i5, null);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01a3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00f7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x0197 -> B:61:0x019b). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: awaitHorizontalTouchSlopOrCancellation-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m1681awaitHorizontalTouchSlopOrCancellationjO51t88(AwaitPointerEventScope awaitPointerEventScope, long j, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1;
        float fM1695pointerSlopE8SPZFQ;
        Ref.LongRef longRef;
        Function2<? super PointerInputChange, ? super Float, Unit> function22;
        DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12;
        TouchSlopDetector touchSlopDetector;
        AwaitPointerEventScope awaitPointerEventScope2;
        float f;
        TouchSlopDetector touchSlopDetector2;
        int size;
        int i;
        PointerEventPass pointerEventPass;
        Object obj;
        PointerInputChange pointerInputChange;
        Object obj2;
        int i2;
        Object objAwaitPointerEvent$default;
        if (continuation instanceof DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1) {
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 = (DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.label -= Integer.MIN_VALUE;
            } else {
                dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 = new DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1(continuation);
            }
        }
        Object obj3 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.label;
        int i4 = 1;
        PointerEventPass pointerEventPass2 = null;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj3);
            int iM7716getTouchT8wyACA = PointerType.INSTANCE.m7716getTouchT8wyACA();
            Orientation orientation = Orientation.Horizontal;
            long jM6096getZeroF1C5BW0 = Offset.INSTANCE.m6096getZeroF1C5BW0();
            if (m1694isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
                return null;
            }
            fM1695pointerSlopE8SPZFQ = m1695pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), iM7716getTouchT8wyACA);
            longRef = new Ref.LongRef();
            longRef.element = j;
            TouchSlopDetector touchSlopDetector3 = new TouchSlopDetector(orientation, jM6096getZeroF1C5BW0, null);
            function22 = function2;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1;
            touchSlopDetector = touchSlopDetector3;
            awaitPointerEventScope2 = awaitPointerEventScope;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$0 = function22;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$2 = longRef;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$4 = pointerEventPass2;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.F$0 = fM1695pointerSlopE8SPZFQ;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.label = i4;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12, i4, pointerEventPass2);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i3 == 1) {
            float f2 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.F$0;
            TouchSlopDetector touchSlopDetector4 = (TouchSlopDetector) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$3;
            Ref.LongRef longRef2 = (Ref.LongRef) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$2;
            AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$1;
            Function2<? super PointerInputChange, ? super Float, Unit> function23 = (Function2) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$0;
            ResultKt.throwOnFailure(obj3);
            f = f2;
            touchSlopDetector2 = touchSlopDetector4;
            longRef = longRef2;
            awaitPointerEventScope2 = awaitPointerEventScope3;
            function22 = function23;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1;
            PointerEvent pointerEvent = (PointerEvent) obj3;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            size = changes.size();
            int i5 = 0;
            i = 0;
            while (true) {
                if (i < size) {
                }
                i++;
                size = i2;
                pointerEventPass2 = pointerEventPass;
            }
            pointerInputChange = (PointerInputChange) obj;
            if (pointerInputChange != null) {
                return pointerEventPass;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
            }
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$0 = function22;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$2 = longRef;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$4 = pointerEventPass2;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.F$0 = fM1695pointerSlopE8SPZFQ;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.label = i4;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12, i4, pointerEventPass2);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i3 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        float f3 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.F$0;
        PointerInputChange pointerInputChange2 = (PointerInputChange) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$4;
        TouchSlopDetector touchSlopDetector5 = (TouchSlopDetector) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$3;
        Ref.LongRef longRef3 = (Ref.LongRef) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$2;
        AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$1;
        Function2<? super PointerInputChange, ? super Float, Unit> function24 = (Function2) dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1.L$0;
        ResultKt.throwOnFailure(obj3);
        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1;
        touchSlopDetector = touchSlopDetector5;
        fM1695pointerSlopE8SPZFQ = f3;
        int i6 = 1;
        awaitPointerEventScope2 = awaitPointerEventScope4;
        char c = 2;
        if (!pointerInputChange2.isConsumed()) {
            return null;
        }
        i4 = i6;
        function22 = function24;
        pointerEventPass2 = null;
        longRef = longRef3;
        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$0 = function22;
        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$2 = longRef;
        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$4 = pointerEventPass2;
        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.F$0 = fM1695pointerSlopE8SPZFQ;
        dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.label = i4;
        objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12, i4, pointerEventPass2);
        if (objAwaitPointerEvent$default != coroutine_suspended) {
            f = fM1695pointerSlopE8SPZFQ;
            touchSlopDetector2 = touchSlopDetector;
            obj3 = objAwaitPointerEvent$default;
            PointerEvent pointerEvent2 = (PointerEvent) obj3;
            List<PointerInputChange> changes2 = pointerEvent2.getChanges();
            size = changes2.size();
            int i52 = 0;
            i = 0;
            while (true) {
                if (i < size) {
                    pointerEventPass = pointerEventPass2;
                    obj = pointerEventPass;
                    break;
                }
                obj = changes2.get(i);
                pointerEventPass = pointerEventPass2;
                i2 = size;
                if (PointerId.m7620equalsimpl0(((PointerInputChange) obj).getId(), longRef.element)) {
                    break;
                }
                i++;
                size = i2;
                pointerEventPass2 = pointerEventPass;
            }
            pointerInputChange = (PointerInputChange) obj;
            if (pointerInputChange != null || pointerInputChange.isConsumed()) {
                return pointerEventPass;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                long jM1823addPositionsakrDWew = touchSlopDetector2.m1823addPositionsakrDWew(pointerInputChange.getPosition(), pointerInputChange.getPreviousPosition(), f);
                fM1695pointerSlopE8SPZFQ = f;
                if ((9223372034707292159L & jM1823addPositionsakrDWew) != InlineClassHelperKt.UnspecifiedPackedFloats) {
                    function22.invoke(pointerInputChange, Boxing.boxFloat(Float.intBitsToFloat((int) (jM1823addPositionsakrDWew >> 32))));
                    if (pointerInputChange.isConsumed()) {
                        return pointerInputChange;
                    }
                    TouchSlopDetector.m1822resetk4lQ0M$default(touchSlopDetector2, 0L, 1, pointerEventPass);
                    i4 = 1;
                    touchSlopDetector = touchSlopDetector2;
                    pointerEventPass2 = null;
                } else {
                    i6 = 1;
                    PointerEventPass pointerEventPass3 = PointerEventPass.Final;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$0 = function22;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$2 = longRef;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$3 = touchSlopDetector2;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$4 = pointerInputChange;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.F$0 = fM1695pointerSlopE8SPZFQ;
                    c = 2;
                    dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.label = 2;
                    if (awaitPointerEventScope2.awaitPointerEvent(pointerEventPass3, dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12) != coroutine_suspended) {
                        longRef3 = longRef;
                        function24 = function22;
                        pointerInputChange2 = pointerInputChange;
                        touchSlopDetector = touchSlopDetector2;
                        if (!pointerInputChange2.isConsumed()) {
                        }
                    }
                }
            } else {
                List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                int size2 = changes3.size();
                while (true) {
                    if (i52 >= size2) {
                        obj2 = pointerEventPass;
                        break;
                    }
                    obj2 = changes3.get(i52);
                    if (((PointerInputChange) obj2).getPressed()) {
                        break;
                    }
                    i52++;
                }
                PointerInputChange pointerInputChange3 = (PointerInputChange) obj2;
                if (pointerInputChange3 == null) {
                    return pointerEventPass;
                }
                longRef.element = pointerInputChange3.getId();
                fM1695pointerSlopE8SPZFQ = f;
                i4 = 1;
                touchSlopDetector = touchSlopDetector2;
                pointerEventPass2 = null;
            }
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$0 = function22;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$2 = longRef;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.L$4 = pointerEventPass2;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.F$0 = fM1695pointerSlopE8SPZFQ;
            dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12.label = i4;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$12, i4, pointerEventPass2);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r10v3, types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r11v3, types: [T, androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Object] */
    /* JADX INFO: renamed from: awaitLongPressOrCancellation-rnUCldI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m1682awaitLongPressOrCancellationrnUCldI(AwaitPointerEventScope awaitPointerEventScope, long j, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitLongPressOrCancellation$1 dragGestureDetectorKt$awaitLongPressOrCancellation$1;
        PointerInputChange pointerInputChange;
        Ref.BooleanRef booleanRef;
        Object obj;
        if (continuation instanceof DragGestureDetectorKt$awaitLongPressOrCancellation$1) {
            dragGestureDetectorKt$awaitLongPressOrCancellation$1 = (DragGestureDetectorKt$awaitLongPressOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitLongPressOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitLongPressOrCancellation$1.label -= Integer.MIN_VALUE;
            } else {
                dragGestureDetectorKt$awaitLongPressOrCancellation$1 = new DragGestureDetectorKt$awaitLongPressOrCancellation$1(continuation);
            }
        }
        Object obj2 = dragGestureDetectorKt$awaitLongPressOrCancellation$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = dragGestureDetectorKt$awaitLongPressOrCancellation$1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj2);
                if (m1694isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
                    return null;
                }
                List<PointerInputChange> changes = awaitPointerEventScope.getCurrentEvent().getChanges();
                int size = changes.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        pointerInputChange = null;
                        break;
                    }
                    pointerInputChange = changes.get(i2);
                    if (PointerId.m7620equalsimpl0(pointerInputChange.getId(), j)) {
                        break;
                    }
                    i2++;
                }
                PointerInputChange pointerInputChange2 = pointerInputChange;
                if (pointerInputChange2 == 0) {
                    return null;
                }
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                objectRef2.element = pointerInputChange2;
                long longPressTimeoutMillis = awaitPointerEventScope.getViewConfiguration().getLongPressTimeoutMillis();
                Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
                DragGestureDetectorKt$awaitLongPressOrCancellation$2 dragGestureDetectorKt$awaitLongPressOrCancellation$2 = new DragGestureDetectorKt$awaitLongPressOrCancellation$2(booleanRef2, objectRef2, objectRef, null);
                dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$0 = pointerInputChange2;
                dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$1 = objectRef;
                dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$2 = booleanRef2;
                dragGestureDetectorKt$awaitLongPressOrCancellation$1.label = 1;
                if (awaitPointerEventScope.withTimeout(longPressTimeoutMillis, dragGestureDetectorKt$awaitLongPressOrCancellation$2, dragGestureDetectorKt$awaitLongPressOrCancellation$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                booleanRef = booleanRef2;
                j = objectRef;
                obj = pointerInputChange2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                booleanRef = (Ref.BooleanRef) dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$2;
                Ref.ObjectRef objectRef3 = (Ref.ObjectRef) dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$1;
                PointerInputChange pointerInputChange3 = (PointerInputChange) dragGestureDetectorKt$awaitLongPressOrCancellation$1.L$0;
                ResultKt.throwOnFailure(obj2);
                j = objectRef3;
                obj = pointerInputChange3;
            }
            if (!booleanRef.element) {
                return null;
            }
            PointerInputChange pointerInputChange4 = (PointerInputChange) j.element;
            return pointerInputChange4 == null ? obj : pointerInputChange4;
        } catch (PointerEventTimeoutCancellationException unused) {
            PointerInputChange pointerInputChange5 = (PointerInputChange) j.element;
            return pointerInputChange5 == null ? obj : pointerInputChange5;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x019a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00f3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0190 -> B:62:0x0194). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: awaitPointerSlopOrCancellation-6ksA65w, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m1683awaitPointerSlopOrCancellation6ksA65w(AwaitPointerEventScope awaitPointerEventScope, long j, int i, Orientation orientation, long j2, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitPointerSlopOrCancellation$1 dragGestureDetectorKt$awaitPointerSlopOrCancellation$1;
        float fM1695pointerSlopE8SPZFQ;
        Function2<? super PointerInputChange, ? super Offset, Unit> function22;
        Ref.LongRef longRef;
        DragGestureDetectorKt$awaitPointerSlopOrCancellation$1 dragGestureDetectorKt$awaitPointerSlopOrCancellation$12;
        TouchSlopDetector touchSlopDetector;
        AwaitPointerEventScope awaitPointerEventScope2;
        Ref.LongRef longRef2;
        AwaitPointerEventScope awaitPointerEventScope3;
        Function2<? super PointerInputChange, ? super Offset, Unit> function23;
        TouchSlopDetector touchSlopDetector2;
        float f;
        int size;
        int i2;
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        int i3;
        PointerInputChange pointerInputChange3;
        int i4;
        Object objAwaitPointerEvent$default;
        if (continuation instanceof DragGestureDetectorKt$awaitPointerSlopOrCancellation$1) {
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$1 = (DragGestureDetectorKt$awaitPointerSlopOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.label -= Integer.MIN_VALUE;
            } else {
                dragGestureDetectorKt$awaitPointerSlopOrCancellation$1 = new DragGestureDetectorKt$awaitPointerSlopOrCancellation$1(continuation);
            }
        }
        Object obj = dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.label;
        int i6 = 1;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            if (m1694isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
                return null;
            }
            fM1695pointerSlopE8SPZFQ = m1695pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), i);
            Ref.LongRef longRef3 = new Ref.LongRef();
            longRef3.element = j;
            function22 = function2;
            longRef = longRef3;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12 = dragGestureDetectorKt$awaitPointerSlopOrCancellation$1;
            touchSlopDetector = new TouchSlopDetector(orientation, j2, null);
            awaitPointerEventScope2 = awaitPointerEventScope;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$0 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$1 = function22;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$2 = longRef;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$4 = null;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.F$0 = fM1695pointerSlopE8SPZFQ;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.label = i6;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitPointerSlopOrCancellation$12, i6, null);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i5 == 1) {
            f = dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.F$0;
            touchSlopDetector2 = (TouchSlopDetector) dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.L$3;
            Ref.LongRef longRef4 = (Ref.LongRef) dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.L$2;
            function23 = (Function2) dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.L$1;
            awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.L$0;
            ResultKt.throwOnFailure(obj);
            longRef2 = longRef4;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12 = dragGestureDetectorKt$awaitPointerSlopOrCancellation$1;
            Ref.LongRef longRef5 = longRef2;
            PointerEvent pointerEvent = (PointerEvent) obj;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            size = changes.size();
            i2 = 0;
            while (true) {
                if (i2 < size) {
                }
                i2 = i4 + 1;
            }
            pointerInputChange2 = pointerInputChange;
            if (pointerInputChange2 != null) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
            }
            i6 = i3;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$0 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$1 = function22;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$2 = longRef;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$4 = null;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.F$0 = fM1695pointerSlopE8SPZFQ;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.label = i6;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitPointerSlopOrCancellation$12, i6, null);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i5 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        float f2 = dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.F$0;
        PointerInputChange pointerInputChange4 = (PointerInputChange) dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.L$4;
        TouchSlopDetector touchSlopDetector3 = (TouchSlopDetector) dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.L$3;
        Ref.LongRef longRef6 = (Ref.LongRef) dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.L$2;
        Function2<? super PointerInputChange, ? super Offset, Unit> function24 = (Function2) dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.L$1;
        AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitPointerSlopOrCancellation$1.L$0;
        ResultKt.throwOnFailure(obj);
        pointerInputChange2 = pointerInputChange4;
        char c = 2;
        dragGestureDetectorKt$awaitPointerSlopOrCancellation$12 = dragGestureDetectorKt$awaitPointerSlopOrCancellation$1;
        touchSlopDetector = touchSlopDetector3;
        fM1695pointerSlopE8SPZFQ = f2;
        awaitPointerEventScope2 = awaitPointerEventScope4;
        i3 = 1;
        Ref.LongRef longRef7 = longRef6;
        function23 = function24;
        if (!pointerInputChange2.isConsumed()) {
            return null;
        }
        function22 = function23;
        longRef = longRef7;
        i6 = i3;
        dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$0 = awaitPointerEventScope2;
        dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$1 = function22;
        dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$2 = longRef;
        dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$3 = touchSlopDetector;
        dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$4 = null;
        dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.F$0 = fM1695pointerSlopE8SPZFQ;
        dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.label = i6;
        objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitPointerSlopOrCancellation$12, i6, null);
        if (objAwaitPointerEvent$default != coroutine_suspended) {
            awaitPointerEventScope3 = awaitPointerEventScope2;
            f = fM1695pointerSlopE8SPZFQ;
            obj = objAwaitPointerEvent$default;
            longRef2 = longRef;
            function23 = function22;
            touchSlopDetector2 = touchSlopDetector;
            Ref.LongRef longRef52 = longRef2;
            PointerEvent pointerEvent2 = (PointerEvent) obj;
            List<PointerInputChange> changes2 = pointerEvent2.getChanges();
            size = changes2.size();
            i2 = 0;
            while (true) {
                if (i2 < size) {
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes2.get(i2);
                i4 = i2;
                if (PointerId.m7620equalsimpl0(pointerInputChange.getId(), longRef52.element)) {
                    break;
                }
                i2 = i4 + 1;
            }
            pointerInputChange2 = pointerInputChange;
            if (pointerInputChange2 != null || pointerInputChange2.isConsumed()) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                float f3 = f;
                TouchSlopDetector touchSlopDetector4 = touchSlopDetector2;
                long jM1823addPositionsakrDWew = touchSlopDetector4.m1823addPositionsakrDWew(pointerInputChange2.getPosition(), pointerInputChange2.getPreviousPosition(), f3);
                fM1695pointerSlopE8SPZFQ = f3;
                if ((9223372034707292159L & jM1823addPositionsakrDWew) != InlineClassHelperKt.UnspecifiedPackedFloats) {
                    function23.invoke(pointerInputChange2, Offset.m6069boximpl(jM1823addPositionsakrDWew));
                    if (pointerInputChange2.isConsumed()) {
                        return pointerInputChange2;
                    }
                    i3 = 1;
                    TouchSlopDetector.m1822resetk4lQ0M$default(touchSlopDetector4, 0L, 1, null);
                    function22 = function23;
                    awaitPointerEventScope2 = awaitPointerEventScope3;
                    longRef = longRef52;
                    touchSlopDetector = touchSlopDetector4;
                } else {
                    i3 = 1;
                    PointerEventPass pointerEventPass = PointerEventPass.Final;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$0 = awaitPointerEventScope3;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$1 = function23;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$2 = longRef52;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$3 = touchSlopDetector4;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$4 = pointerInputChange2;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.F$0 = fM1695pointerSlopE8SPZFQ;
                    c = 2;
                    dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.label = 2;
                    if (awaitPointerEventScope3.awaitPointerEvent(pointerEventPass, dragGestureDetectorKt$awaitPointerSlopOrCancellation$12) != coroutine_suspended) {
                        longRef7 = longRef52;
                        touchSlopDetector = touchSlopDetector4;
                        awaitPointerEventScope2 = awaitPointerEventScope3;
                        if (!pointerInputChange2.isConsumed()) {
                        }
                    }
                }
            } else {
                List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                int size2 = changes3.size();
                int i7 = 0;
                while (true) {
                    if (i7 >= size2) {
                        pointerInputChange3 = null;
                        break;
                    }
                    pointerInputChange3 = changes3.get(i7);
                    if (pointerInputChange3.getPressed()) {
                        break;
                    }
                    i7++;
                }
                PointerInputChange pointerInputChange5 = pointerInputChange3;
                if (pointerInputChange5 == null) {
                    return null;
                }
                longRef52.element = pointerInputChange5.getId();
                fM1695pointerSlopE8SPZFQ = f;
                TouchSlopDetector touchSlopDetector5 = touchSlopDetector2;
                i3 = 1;
                function22 = function23;
                awaitPointerEventScope2 = awaitPointerEventScope3;
                longRef = longRef52;
                touchSlopDetector = touchSlopDetector5;
            }
            i6 = i3;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$0 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$1 = function22;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$2 = longRef;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.L$4 = null;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.F$0 = fM1695pointerSlopE8SPZFQ;
            dragGestureDetectorKt$awaitPointerSlopOrCancellation$12.label = i6;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitPointerSlopOrCancellation$12, i6, null);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
        }
        return coroutine_suspended;
    }

    /* JADX INFO: renamed from: awaitPointerSlopOrCancellation-6ksA65w$$forInline, reason: not valid java name */
    private static final Object m1684awaitPointerSlopOrCancellation6ksA65w$$forInline(AwaitPointerEventScope awaitPointerEventScope, long j, int i, Orientation orientation, long j2, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super PointerInputChange> continuation) {
        PointerInputChange pointerInputChange;
        TouchSlopDetector touchSlopDetector;
        float f;
        PointerInputChange pointerInputChange2;
        if (m1694isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
            return null;
        }
        float fM1695pointerSlopE8SPZFQ = m1695pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), i);
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = j;
        TouchSlopDetector touchSlopDetector2 = new TouchSlopDetector(orientation, j2, null);
        while (true) {
            PointerEvent pointerEvent = (PointerEvent) AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, continuation, 1, null);
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes.get(i2);
                int i3 = i2;
                if (Boolean.valueOf(PointerId.m7620equalsimpl0(pointerInputChange.getId(), longRef.element)).booleanValue()) {
                    break;
                }
                i2 = i3 + 1;
            }
            PointerInputChange pointerInputChange3 = pointerInputChange;
            if (pointerInputChange3 == null || pointerInputChange3.isConsumed()) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                int size2 = changes2.size();
                int i4 = 0;
                while (true) {
                    if (i4 >= size2) {
                        pointerInputChange2 = null;
                        break;
                    }
                    pointerInputChange2 = changes2.get(i4);
                    if (Boolean.valueOf(pointerInputChange2.getPressed()).booleanValue()) {
                        break;
                    }
                    i4++;
                }
                PointerInputChange pointerInputChange4 = pointerInputChange2;
                if (pointerInputChange4 == null) {
                    return null;
                }
                longRef.element = pointerInputChange4.getId();
                float f2 = fM1695pointerSlopE8SPZFQ;
                touchSlopDetector = touchSlopDetector2;
                f = f2;
            } else {
                TouchSlopDetector touchSlopDetector3 = touchSlopDetector2;
                float f3 = fM1695pointerSlopE8SPZFQ;
                long jM1823addPositionsakrDWew = touchSlopDetector3.m1823addPositionsakrDWew(pointerInputChange3.getPosition(), pointerInputChange3.getPreviousPosition(), f3);
                touchSlopDetector = touchSlopDetector3;
                f = f3;
                if ((9223372034707292159L & jM1823addPositionsakrDWew) != InlineClassHelperKt.UnspecifiedPackedFloats) {
                    function2.invoke(pointerInputChange3, Offset.m6069boximpl(jM1823addPositionsakrDWew));
                    if (pointerInputChange3.isConsumed()) {
                        return pointerInputChange3;
                    }
                    TouchSlopDetector.m1822resetk4lQ0M$default(touchSlopDetector, 0L, 1, null);
                } else {
                    awaitPointerEventScope.awaitPointerEvent(PointerEventPass.Final, continuation);
                    if (pointerInputChange3.isConsumed()) {
                        return null;
                    }
                }
            }
            TouchSlopDetector touchSlopDetector4 = touchSlopDetector;
            fM1695pointerSlopE8SPZFQ = f;
            touchSlopDetector2 = touchSlopDetector4;
        }
    }

    /* JADX INFO: renamed from: awaitPointerSlopOrCancellation-6ksA65w$default, reason: not valid java name */
    public static /* synthetic */ Object m1685awaitPointerSlopOrCancellation6ksA65w$default(AwaitPointerEventScope awaitPointerEventScope, long j, int i, Orientation orientation, long j2, Function2 function2, Continuation continuation, int i2, Object obj) {
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        long jM6096getZeroF1C5BW0 = (i2 & 8) != 0 ? Offset.INSTANCE.m6096getZeroF1C5BW0() : j2;
        long id = j;
        if (m1694isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), id)) {
            return null;
        }
        float fM1695pointerSlopE8SPZFQ = m1695pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), i);
        TouchSlopDetector touchSlopDetector = new TouchSlopDetector(orientation, jM6096getZeroF1C5BW0, null);
        while (true) {
            PointerEvent pointerEvent = (PointerEvent) AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, continuation, 1, null);
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i4 >= size) {
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes.get(i4);
                if (PointerId.m7620equalsimpl0(pointerInputChange.getId(), id)) {
                    break;
                }
                i4++;
            }
            PointerInputChange pointerInputChange3 = pointerInputChange;
            if (pointerInputChange3 == null || pointerInputChange3.isConsumed()) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                int size2 = changes2.size();
                while (true) {
                    if (i3 >= size2) {
                        pointerInputChange2 = null;
                        break;
                    }
                    pointerInputChange2 = changes2.get(i3);
                    if (pointerInputChange2.getPressed()) {
                        break;
                    }
                    i3++;
                }
                PointerInputChange pointerInputChange4 = pointerInputChange2;
                if (pointerInputChange4 == null) {
                    return null;
                }
                id = pointerInputChange4.getId();
            } else {
                float f = fM1695pointerSlopE8SPZFQ;
                TouchSlopDetector touchSlopDetector2 = touchSlopDetector;
                long jM1823addPositionsakrDWew = touchSlopDetector2.m1823addPositionsakrDWew(pointerInputChange3.getPosition(), pointerInputChange3.getPreviousPosition(), f);
                if ((9223372034707292159L & jM1823addPositionsakrDWew) != InlineClassHelperKt.UnspecifiedPackedFloats) {
                    function2.invoke(pointerInputChange3, Offset.m6069boximpl(jM1823addPositionsakrDWew));
                    if (pointerInputChange3.isConsumed()) {
                        return pointerInputChange3;
                    }
                    TouchSlopDetector.m1822resetk4lQ0M$default(touchSlopDetector2, 0L, 1, null);
                } else {
                    awaitPointerEventScope.awaitPointerEvent(PointerEventPass.Final, continuation);
                    if (pointerInputChange3.isConsumed()) {
                        return null;
                    }
                }
                fM1695pointerSlopE8SPZFQ = f;
                touchSlopDetector = touchSlopDetector2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x018d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ef A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x0181 -> B:61:0x0187). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: awaitTouchSlopOrCancellation-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m1686awaitTouchSlopOrCancellationjO51t88(AwaitPointerEventScope awaitPointerEventScope, long j, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitTouchSlopOrCancellation$1 dragGestureDetectorKt$awaitTouchSlopOrCancellation$1;
        float fM1695pointerSlopE8SPZFQ;
        Function2<? super PointerInputChange, ? super Offset, Unit> function22;
        Ref.LongRef longRef;
        DragGestureDetectorKt$awaitTouchSlopOrCancellation$1 dragGestureDetectorKt$awaitTouchSlopOrCancellation$12;
        TouchSlopDetector touchSlopDetector;
        AwaitPointerEventScope awaitPointerEventScope2;
        float f;
        TouchSlopDetector touchSlopDetector2;
        int size;
        int i;
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        PointerInputChange pointerInputChange3;
        int i2;
        Object objAwaitPointerEvent$default;
        if (continuation instanceof DragGestureDetectorKt$awaitTouchSlopOrCancellation$1) {
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$1 = (DragGestureDetectorKt$awaitTouchSlopOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.label -= Integer.MIN_VALUE;
            } else {
                dragGestureDetectorKt$awaitTouchSlopOrCancellation$1 = new DragGestureDetectorKt$awaitTouchSlopOrCancellation$1(continuation);
            }
        }
        Object obj = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.label;
        int i4 = 1;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            int iM7716getTouchT8wyACA = PointerType.INSTANCE.m7716getTouchT8wyACA();
            long jM6096getZeroF1C5BW0 = Offset.INSTANCE.m6096getZeroF1C5BW0();
            if (m1694isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
                return null;
            }
            fM1695pointerSlopE8SPZFQ = m1695pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), iM7716getTouchT8wyACA);
            Ref.LongRef longRef2 = new Ref.LongRef();
            longRef2.element = j;
            TouchSlopDetector touchSlopDetector3 = new TouchSlopDetector(null, jM6096getZeroF1C5BW0, null);
            function22 = function2;
            longRef = longRef2;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1;
            touchSlopDetector = touchSlopDetector3;
            awaitPointerEventScope2 = awaitPointerEventScope;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$0 = function22;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$2 = longRef;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$4 = null;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.F$0 = fM1695pointerSlopE8SPZFQ;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.label = i4;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitTouchSlopOrCancellation$12, i4, null);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i3 == 1) {
            float f2 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.F$0;
            TouchSlopDetector touchSlopDetector4 = (TouchSlopDetector) dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$3;
            Ref.LongRef longRef3 = (Ref.LongRef) dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$2;
            AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$1;
            Function2<? super PointerInputChange, ? super Offset, Unit> function23 = (Function2) dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$0;
            ResultKt.throwOnFailure(obj);
            f = f2;
            touchSlopDetector2 = touchSlopDetector4;
            awaitPointerEventScope2 = awaitPointerEventScope3;
            function22 = function23;
            longRef = longRef3;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1;
            PointerEvent pointerEvent = (PointerEvent) obj;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            size = changes.size();
            i = 0;
            while (true) {
                if (i < size) {
                }
                i = i2 + 1;
            }
            pointerInputChange2 = pointerInputChange;
            if (pointerInputChange2 != null) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
            }
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$0 = function22;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$2 = longRef;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$4 = null;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.F$0 = fM1695pointerSlopE8SPZFQ;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.label = i4;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitTouchSlopOrCancellation$12, i4, null);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i3 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        float f3 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.F$0;
        PointerInputChange pointerInputChange4 = (PointerInputChange) dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$4;
        TouchSlopDetector touchSlopDetector5 = (TouchSlopDetector) dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$3;
        longRef = (Ref.LongRef) dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$2;
        AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$1;
        Function2<? super PointerInputChange, ? super Offset, Unit> function24 = (Function2) dragGestureDetectorKt$awaitTouchSlopOrCancellation$1.L$0;
        ResultKt.throwOnFailure(obj);
        dragGestureDetectorKt$awaitTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitTouchSlopOrCancellation$1;
        touchSlopDetector = touchSlopDetector5;
        fM1695pointerSlopE8SPZFQ = f3;
        awaitPointerEventScope2 = awaitPointerEventScope4;
        int i5 = 1;
        char c = 2;
        if (!pointerInputChange4.isConsumed()) {
            return null;
        }
        i4 = i5;
        function22 = function24;
        dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$0 = function22;
        dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
        dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$2 = longRef;
        dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
        dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$4 = null;
        dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.F$0 = fM1695pointerSlopE8SPZFQ;
        dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.label = i4;
        objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitTouchSlopOrCancellation$12, i4, null);
        if (objAwaitPointerEvent$default != coroutine_suspended) {
            f = fM1695pointerSlopE8SPZFQ;
            touchSlopDetector2 = touchSlopDetector;
            obj = objAwaitPointerEvent$default;
            PointerEvent pointerEvent2 = (PointerEvent) obj;
            List<PointerInputChange> changes2 = pointerEvent2.getChanges();
            size = changes2.size();
            i = 0;
            while (true) {
                if (i < size) {
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes2.get(i);
                i2 = i;
                if (PointerId.m7620equalsimpl0(pointerInputChange.getId(), longRef.element)) {
                    break;
                }
                i = i2 + 1;
            }
            pointerInputChange2 = pointerInputChange;
            if (pointerInputChange2 != null || pointerInputChange2.isConsumed()) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                long jM1823addPositionsakrDWew = touchSlopDetector2.m1823addPositionsakrDWew(pointerInputChange2.getPosition(), pointerInputChange2.getPreviousPosition(), f);
                fM1695pointerSlopE8SPZFQ = f;
                if ((9223372034707292159L & jM1823addPositionsakrDWew) != InlineClassHelperKt.UnspecifiedPackedFloats) {
                    function22.invoke(pointerInputChange2, Offset.m6069boximpl(jM1823addPositionsakrDWew));
                    if (pointerInputChange2.isConsumed()) {
                        return pointerInputChange2;
                    }
                    TouchSlopDetector.m1822resetk4lQ0M$default(touchSlopDetector2, 0L, 1, null);
                    i4 = 1;
                    touchSlopDetector = touchSlopDetector2;
                } else {
                    i5 = 1;
                    PointerEventPass pointerEventPass = PointerEventPass.Final;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$0 = function22;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$2 = longRef;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$3 = touchSlopDetector2;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$4 = pointerInputChange2;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.F$0 = fM1695pointerSlopE8SPZFQ;
                    c = 2;
                    dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.label = 2;
                    if (awaitPointerEventScope2.awaitPointerEvent(pointerEventPass, dragGestureDetectorKt$awaitTouchSlopOrCancellation$12) != coroutine_suspended) {
                        TouchSlopDetector touchSlopDetector6 = touchSlopDetector2;
                        function24 = function22;
                        pointerInputChange4 = pointerInputChange2;
                        touchSlopDetector = touchSlopDetector6;
                        if (!pointerInputChange4.isConsumed()) {
                        }
                    }
                }
            } else {
                List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                int size2 = changes3.size();
                int i6 = 0;
                while (true) {
                    if (i6 >= size2) {
                        pointerInputChange3 = null;
                        break;
                    }
                    pointerInputChange3 = changes3.get(i6);
                    if (pointerInputChange3.getPressed()) {
                        break;
                    }
                    i6++;
                }
                PointerInputChange pointerInputChange5 = pointerInputChange3;
                if (pointerInputChange5 == null) {
                    return null;
                }
                longRef.element = pointerInputChange5.getId();
                fM1695pointerSlopE8SPZFQ = f;
                i4 = 1;
                touchSlopDetector = touchSlopDetector2;
            }
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$0 = function22;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$2 = longRef;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.L$4 = null;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.F$0 = fM1695pointerSlopE8SPZFQ;
            dragGestureDetectorKt$awaitTouchSlopOrCancellation$12.label = i4;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitTouchSlopOrCancellation$12, i4, null);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00e2, code lost:
    
        if ((java.lang.Float.intBitsToFloat((int) (androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r11) & androidx.media3.muxer.MuxerUtil.UNSIGNED_INT_MAX_VALUE)) == 0.0f ? 1 : 0) == 0) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0067 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0095 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0068 -> B:22:0x006d). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: awaitVerticalDragOrCancellation-rnUCldI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m1687awaitVerticalDragOrCancellationrnUCldI(AwaitPointerEventScope awaitPointerEventScope, long j, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitVerticalDragOrCancellation$1 dragGestureDetectorKt$awaitVerticalDragOrCancellation$1;
        Ref.LongRef longRef;
        AwaitPointerEventScope awaitPointerEventScope2;
        Object objAwaitPointerEvent$default;
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        if (continuation instanceof DragGestureDetectorKt$awaitVerticalDragOrCancellation$1) {
            dragGestureDetectorKt$awaitVerticalDragOrCancellation$1 = (DragGestureDetectorKt$awaitVerticalDragOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.label -= Integer.MIN_VALUE;
            } else {
                dragGestureDetectorKt$awaitVerticalDragOrCancellation$1 = new DragGestureDetectorKt$awaitVerticalDragOrCancellation$1(continuation);
            }
        }
        Object obj = dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Ref.LongRef longRef2 = (Ref.LongRef) dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.L$1;
            AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.L$0;
            ResultKt.throwOnFailure(obj);
            Ref.LongRef longRef3 = longRef2;
            awaitPointerEventScope2 = awaitPointerEventScope3;
            PointerEvent pointerEvent = (PointerEvent) obj;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i2 = 0;
            while (true) {
                if (i2 < size) {
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes.get(i2);
                if (PointerId.m7620equalsimpl0(pointerInputChange.getId(), longRef3.element)) {
                    break;
                }
                i2++;
            }
            PointerInputChange pointerInputChange3 = pointerInputChange;
            if (pointerInputChange3 == null) {
                if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                    List<PointerInputChange> changes2 = pointerEvent.getChanges();
                    int size2 = changes2.size();
                    while (true) {
                        if (i >= size2) {
                            pointerInputChange2 = null;
                            break;
                        }
                        pointerInputChange2 = changes2.get(i);
                        if (pointerInputChange2.getPressed()) {
                            break;
                        }
                        i++;
                    }
                    PointerInputChange pointerInputChange4 = pointerInputChange2;
                    if (pointerInputChange4 != null) {
                        longRef3.element = pointerInputChange4.getId();
                        longRef = longRef3;
                    }
                }
                dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.L$0 = awaitPointerEventScope2;
                dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.L$1 = longRef;
                dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.label = 1;
                objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitVerticalDragOrCancellation$1, 1, null);
                if (objAwaitPointerEvent$default != coroutine_suspended) {
                    return coroutine_suspended;
                }
                Ref.LongRef longRef4 = longRef;
                obj = objAwaitPointerEvent$default;
                longRef3 = longRef4;
                PointerEvent pointerEvent2 = (PointerEvent) obj;
                List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                int size3 = changes3.size();
                int i22 = 0;
                while (true) {
                    if (i22 < size3) {
                    }
                    i22++;
                }
                PointerInputChange pointerInputChange32 = pointerInputChange;
                if (pointerInputChange32 == null) {
                    pointerInputChange32 = null;
                }
            }
            if (pointerInputChange32 == null || pointerInputChange32.isConsumed()) {
                return null;
            }
            return pointerInputChange32;
        }
        ResultKt.throwOnFailure(obj);
        if (m1694isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
            return null;
        }
        longRef = new Ref.LongRef();
        longRef.element = j;
        awaitPointerEventScope2 = awaitPointerEventScope;
        dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.L$0 = awaitPointerEventScope2;
        dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.L$1 = longRef;
        dragGestureDetectorKt$awaitVerticalDragOrCancellation$1.label = 1;
        objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitVerticalDragOrCancellation$1, 1, null);
        if (objAwaitPointerEvent$default != coroutine_suspended) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0196 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x018f -> B:61:0x0190). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: awaitVerticalPointerSlopOrCancellation-gDDlDlE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m1688awaitVerticalPointerSlopOrCancellationgDDlDlE(AwaitPointerEventScope awaitPointerEventScope, long j, int i, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1 dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1;
        float fM1695pointerSlopE8SPZFQ;
        Ref.LongRef longRef;
        Function2<? super PointerInputChange, ? super Float, Unit> function22;
        TouchSlopDetector touchSlopDetector;
        AwaitPointerEventScope awaitPointerEventScope2;
        Function2<? super PointerInputChange, ? super Float, Unit> function23;
        AwaitPointerEventScope awaitPointerEventScope3;
        TouchSlopDetector touchSlopDetector2;
        float f;
        int size;
        int i2;
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        PointerInputChange pointerInputChange3;
        int i3;
        Object objAwaitPointerEvent$default;
        if (continuation instanceof DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1) {
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1 = (DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.label -= Integer.MIN_VALUE;
            } else {
                dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1 = new DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1(continuation);
            }
        }
        Object obj = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.label;
        int i5 = 1;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            Orientation orientation = Orientation.Vertical;
            long jM6096getZeroF1C5BW0 = Offset.INSTANCE.m6096getZeroF1C5BW0();
            if (m1694isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
                return null;
            }
            fM1695pointerSlopE8SPZFQ = m1695pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), i);
            longRef = new Ref.LongRef();
            longRef.element = j;
            function22 = function2;
            touchSlopDetector = new TouchSlopDetector(orientation, jM6096getZeroF1C5BW0, null);
            awaitPointerEventScope2 = awaitPointerEventScope;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$0 = function22;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$2 = longRef;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$4 = null;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.F$0 = fM1695pointerSlopE8SPZFQ;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.label = i5;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1, i5, null);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i4 == 1) {
            f = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.F$0;
            touchSlopDetector2 = (TouchSlopDetector) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$3;
            Ref.LongRef longRef2 = (Ref.LongRef) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$2;
            awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$1;
            function23 = (Function2) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$0;
            ResultKt.throwOnFailure(obj);
            longRef = longRef2;
            PointerEvent pointerEvent = (PointerEvent) obj;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            size = changes.size();
            i2 = 0;
            while (true) {
                if (i2 < size) {
                }
                i2 = i3 + 1;
            }
            pointerInputChange2 = pointerInputChange;
            if (pointerInputChange2 != null) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
            }
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$0 = function22;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$2 = longRef;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$4 = null;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.F$0 = fM1695pointerSlopE8SPZFQ;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.label = i5;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1, i5, null);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i4 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        float f2 = dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.F$0;
        PointerInputChange pointerInputChange4 = (PointerInputChange) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$4;
        TouchSlopDetector touchSlopDetector3 = (TouchSlopDetector) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$3;
        Ref.LongRef longRef3 = (Ref.LongRef) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$2;
        AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$1;
        Function2<? super PointerInputChange, ? super Float, Unit> function24 = (Function2) dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$0;
        ResultKt.throwOnFailure(obj);
        touchSlopDetector = touchSlopDetector3;
        pointerInputChange2 = pointerInputChange4;
        char c = 2;
        float f3 = f2;
        awaitPointerEventScope2 = awaitPointerEventScope4;
        function23 = function24;
        longRef = longRef3;
        if (!pointerInputChange2.isConsumed()) {
            return null;
        }
        fM1695pointerSlopE8SPZFQ = f3;
        function22 = function23;
        dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$0 = function22;
        dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$1 = awaitPointerEventScope2;
        dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$2 = longRef;
        dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$3 = touchSlopDetector;
        dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$4 = null;
        dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.F$0 = fM1695pointerSlopE8SPZFQ;
        dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.label = i5;
        objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1, i5, null);
        if (objAwaitPointerEvent$default != coroutine_suspended) {
            function23 = function22;
            touchSlopDetector2 = touchSlopDetector;
            obj = objAwaitPointerEvent$default;
            awaitPointerEventScope3 = awaitPointerEventScope2;
            f = fM1695pointerSlopE8SPZFQ;
            PointerEvent pointerEvent2 = (PointerEvent) obj;
            List<PointerInputChange> changes2 = pointerEvent2.getChanges();
            size = changes2.size();
            i2 = 0;
            while (true) {
                if (i2 < size) {
                    pointerInputChange = null;
                    break;
                }
                pointerInputChange = changes2.get(i2);
                i3 = i2;
                if (PointerId.m7620equalsimpl0(pointerInputChange.getId(), longRef.element)) {
                    break;
                }
                i2 = i3 + 1;
            }
            pointerInputChange2 = pointerInputChange;
            if (pointerInputChange2 != null || pointerInputChange2.isConsumed()) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                float f4 = f;
                TouchSlopDetector touchSlopDetector4 = touchSlopDetector2;
                long jM1823addPositionsakrDWew = touchSlopDetector4.m1823addPositionsakrDWew(pointerInputChange2.getPosition(), pointerInputChange2.getPreviousPosition(), f4);
                touchSlopDetector = touchSlopDetector4;
                f3 = f4;
                if ((9223372034707292159L & jM1823addPositionsakrDWew) != InlineClassHelperKt.UnspecifiedPackedFloats) {
                    function23.invoke(pointerInputChange2, Boxing.boxFloat(Float.intBitsToFloat((int) (jM1823addPositionsakrDWew & MuxerUtil.UNSIGNED_INT_MAX_VALUE))));
                    if (pointerInputChange2.isConsumed()) {
                        return pointerInputChange2;
                    }
                    i5 = 1;
                    TouchSlopDetector.m1822resetk4lQ0M$default(touchSlopDetector, 0L, 1, null);
                    fM1695pointerSlopE8SPZFQ = f3;
                    awaitPointerEventScope2 = awaitPointerEventScope3;
                    function22 = function23;
                } else {
                    i5 = 1;
                    PointerEventPass pointerEventPass = PointerEventPass.Final;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$0 = function23;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$1 = awaitPointerEventScope3;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$2 = longRef;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$3 = touchSlopDetector;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$4 = pointerInputChange2;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.F$0 = f3;
                    c = 2;
                    dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.label = 2;
                    if (awaitPointerEventScope3.awaitPointerEvent(pointerEventPass, dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1) != coroutine_suspended) {
                        awaitPointerEventScope2 = awaitPointerEventScope3;
                        if (!pointerInputChange2.isConsumed()) {
                        }
                    }
                }
            } else {
                List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                int size2 = changes3.size();
                int i6 = 0;
                while (true) {
                    if (i6 >= size2) {
                        pointerInputChange3 = null;
                        break;
                    }
                    pointerInputChange3 = changes3.get(i6);
                    if (pointerInputChange3.getPressed()) {
                        break;
                    }
                    i6++;
                }
                PointerInputChange pointerInputChange5 = pointerInputChange3;
                if (pointerInputChange5 == null) {
                    return null;
                }
                longRef.element = pointerInputChange5.getId();
                touchSlopDetector = touchSlopDetector2;
                i5 = 1;
                fM1695pointerSlopE8SPZFQ = f;
                awaitPointerEventScope2 = awaitPointerEventScope3;
                function22 = function23;
            }
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$0 = function22;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$2 = longRef;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.L$4 = null;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.F$0 = fM1695pointerSlopE8SPZFQ;
            dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1.label = i5;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, dragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1, i5, null);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01a6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00f7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x019a -> B:61:0x019e). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: awaitVerticalTouchSlopOrCancellation-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m1689awaitVerticalTouchSlopOrCancellationjO51t88(AwaitPointerEventScope awaitPointerEventScope, long j, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1 dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1;
        float fM1695pointerSlopE8SPZFQ;
        Ref.LongRef longRef;
        Function2<? super PointerInputChange, ? super Float, Unit> function22;
        DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1 dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12;
        TouchSlopDetector touchSlopDetector;
        AwaitPointerEventScope awaitPointerEventScope2;
        float f;
        TouchSlopDetector touchSlopDetector2;
        int size;
        int i;
        PointerEventPass pointerEventPass;
        Object obj;
        PointerInputChange pointerInputChange;
        Object obj2;
        int i2;
        Object objAwaitPointerEvent$default;
        if (continuation instanceof DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1) {
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1 = (DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1) continuation;
            if ((dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.label -= Integer.MIN_VALUE;
            } else {
                dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1 = new DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1(continuation);
            }
        }
        Object obj3 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.label;
        int i4 = 1;
        PointerEventPass pointerEventPass2 = null;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj3);
            int iM7716getTouchT8wyACA = PointerType.INSTANCE.m7716getTouchT8wyACA();
            Orientation orientation = Orientation.Vertical;
            long jM6096getZeroF1C5BW0 = Offset.INSTANCE.m6096getZeroF1C5BW0();
            if (m1694isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j)) {
                return null;
            }
            fM1695pointerSlopE8SPZFQ = m1695pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), iM7716getTouchT8wyACA);
            longRef = new Ref.LongRef();
            longRef.element = j;
            TouchSlopDetector touchSlopDetector3 = new TouchSlopDetector(orientation, jM6096getZeroF1C5BW0, null);
            function22 = function2;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1;
            touchSlopDetector = touchSlopDetector3;
            awaitPointerEventScope2 = awaitPointerEventScope;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$0 = function22;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$2 = longRef;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$4 = pointerEventPass2;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.F$0 = fM1695pointerSlopE8SPZFQ;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.label = i4;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12, i4, pointerEventPass2);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i3 == 1) {
            float f2 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.F$0;
            TouchSlopDetector touchSlopDetector4 = (TouchSlopDetector) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$3;
            Ref.LongRef longRef2 = (Ref.LongRef) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$2;
            AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$1;
            Function2<? super PointerInputChange, ? super Float, Unit> function23 = (Function2) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$0;
            ResultKt.throwOnFailure(obj3);
            f = f2;
            touchSlopDetector2 = touchSlopDetector4;
            longRef = longRef2;
            awaitPointerEventScope2 = awaitPointerEventScope3;
            function22 = function23;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1;
            PointerEvent pointerEvent = (PointerEvent) obj3;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            size = changes.size();
            int i5 = 0;
            i = 0;
            while (true) {
                if (i < size) {
                }
                i++;
                size = i2;
                pointerEventPass2 = pointerEventPass;
            }
            pointerInputChange = (PointerInputChange) obj;
            if (pointerInputChange != null) {
                return pointerEventPass;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
            }
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$0 = function22;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$2 = longRef;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$4 = pointerEventPass2;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.F$0 = fM1695pointerSlopE8SPZFQ;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.label = i4;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12, i4, pointerEventPass2);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i3 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        float f3 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.F$0;
        PointerInputChange pointerInputChange2 = (PointerInputChange) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$4;
        TouchSlopDetector touchSlopDetector5 = (TouchSlopDetector) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$3;
        Ref.LongRef longRef3 = (Ref.LongRef) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$2;
        AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$1;
        Function2<? super PointerInputChange, ? super Float, Unit> function24 = (Function2) dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1.L$0;
        ResultKt.throwOnFailure(obj3);
        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12 = dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1;
        touchSlopDetector = touchSlopDetector5;
        fM1695pointerSlopE8SPZFQ = f3;
        int i6 = 1;
        awaitPointerEventScope2 = awaitPointerEventScope4;
        char c = 2;
        if (!pointerInputChange2.isConsumed()) {
            return null;
        }
        i4 = i6;
        function22 = function24;
        pointerEventPass2 = null;
        longRef = longRef3;
        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$0 = function22;
        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$2 = longRef;
        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$4 = pointerEventPass2;
        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.F$0 = fM1695pointerSlopE8SPZFQ;
        dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.label = i4;
        objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12, i4, pointerEventPass2);
        if (objAwaitPointerEvent$default != coroutine_suspended) {
            f = fM1695pointerSlopE8SPZFQ;
            touchSlopDetector2 = touchSlopDetector;
            obj3 = objAwaitPointerEvent$default;
            PointerEvent pointerEvent2 = (PointerEvent) obj3;
            List<PointerInputChange> changes2 = pointerEvent2.getChanges();
            size = changes2.size();
            int i52 = 0;
            i = 0;
            while (true) {
                if (i < size) {
                    pointerEventPass = pointerEventPass2;
                    obj = pointerEventPass;
                    break;
                }
                obj = changes2.get(i);
                pointerEventPass = pointerEventPass2;
                i2 = size;
                if (PointerId.m7620equalsimpl0(((PointerInputChange) obj).getId(), longRef.element)) {
                    break;
                }
                i++;
                size = i2;
                pointerEventPass2 = pointerEventPass;
            }
            pointerInputChange = (PointerInputChange) obj;
            if (pointerInputChange != null || pointerInputChange.isConsumed()) {
                return pointerEventPass;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                long jM1823addPositionsakrDWew = touchSlopDetector2.m1823addPositionsakrDWew(pointerInputChange.getPosition(), pointerInputChange.getPreviousPosition(), f);
                fM1695pointerSlopE8SPZFQ = f;
                if ((9223372034707292159L & jM1823addPositionsakrDWew) != InlineClassHelperKt.UnspecifiedPackedFloats) {
                    function22.invoke(pointerInputChange, Boxing.boxFloat(Float.intBitsToFloat((int) (jM1823addPositionsakrDWew & MuxerUtil.UNSIGNED_INT_MAX_VALUE))));
                    if (pointerInputChange.isConsumed()) {
                        return pointerInputChange;
                    }
                    TouchSlopDetector.m1822resetk4lQ0M$default(touchSlopDetector2, 0L, 1, pointerEventPass);
                    i4 = 1;
                    touchSlopDetector = touchSlopDetector2;
                    pointerEventPass2 = null;
                } else {
                    i6 = 1;
                    PointerEventPass pointerEventPass3 = PointerEventPass.Final;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$0 = function22;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$2 = longRef;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$3 = touchSlopDetector2;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$4 = pointerInputChange;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.F$0 = fM1695pointerSlopE8SPZFQ;
                    c = 2;
                    dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.label = 2;
                    if (awaitPointerEventScope2.awaitPointerEvent(pointerEventPass3, dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12) != coroutine_suspended) {
                        longRef3 = longRef;
                        function24 = function22;
                        pointerInputChange2 = pointerInputChange;
                        touchSlopDetector = touchSlopDetector2;
                        if (!pointerInputChange2.isConsumed()) {
                        }
                    }
                }
            } else {
                List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                int size2 = changes3.size();
                while (true) {
                    if (i52 >= size2) {
                        obj2 = pointerEventPass;
                        break;
                    }
                    obj2 = changes3.get(i52);
                    if (((PointerInputChange) obj2).getPressed()) {
                        break;
                    }
                    i52++;
                }
                PointerInputChange pointerInputChange3 = (PointerInputChange) obj2;
                if (pointerInputChange3 == null) {
                    return pointerEventPass;
                }
                longRef.element = pointerInputChange3.getId();
                fM1695pointerSlopE8SPZFQ = f;
                i4 = 1;
                touchSlopDetector = touchSlopDetector2;
                pointerEventPass2 = null;
            }
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$0 = function22;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$2 = longRef;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$3 = touchSlopDetector;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.L$4 = pointerEventPass2;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.F$0 = fM1695pointerSlopE8SPZFQ;
            dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12.label = i4;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass2, dragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$12, i4, pointerEventPass2);
            if (objAwaitPointerEvent$default != coroutine_suspended) {
            }
        }
        return coroutine_suspended;
    }

    public static final Object detectDragGestures(PointerInputScope pointerInputScope, Orientation orientation, Function3<? super PointerInputChange, ? super PointerInputChange, ? super Offset, Unit> function3, Function1<? super PointerInputChange, Unit> function1, Function0<Unit> function0, Function0<Boolean> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super Unit> continuation) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new AnonymousClass13(function02, new Ref.LongRef(), orientation, function3, function2, function0, function1, null), continuation);
        return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
    }

    public static final Object detectDragGestures(PointerInputScope pointerInputScope, final Function1<? super Offset, Unit> function1, final Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super Unit> continuation) {
        Object objDetectDragGestures = detectDragGestures(pointerInputScope, null, new Function3() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return DragGestureDetectorKt.detectDragGestures$lambda$3(function1, (PointerInputChange) obj, (PointerInputChange) obj2, (Offset) obj3);
            }
        }, new Function1() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DragGestureDetectorKt.detectDragGestures$lambda$4(function0, (PointerInputChange) obj);
            }
        }, function02, new Function0() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(DragGestureDetectorKt.detectDragGestures$lambda$5());
            }
        }, function2, continuation);
        return objDetectDragGestures == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDetectDragGestures : Unit.INSTANCE;
    }

    public static /* synthetic */ Object detectDragGestures$default(PointerInputScope pointerInputScope, Orientation orientation, Function3 function3, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function3 = new Function3() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return Unit.INSTANCE;
                }
            };
        }
        Function3 function32 = function3;
        if ((i & 4) != 0) {
            function1 = new Function1() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return Unit.INSTANCE;
                }
            };
        }
        Function1 function12 = function1;
        if ((i & 8) != 0) {
            function0 = new Function0() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Unit.INSTANCE;
                }
            };
        }
        Function0 function03 = function0;
        if ((i & 16) != 0) {
            function02 = new Function0() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(DragGestureDetectorKt.detectDragGestures$lambda$9());
                }
            };
        }
        return detectDragGestures(pointerInputScope, orientation, function32, function12, function03, function02, function2, continuation);
    }

    public static /* synthetic */ Object detectDragGestures$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i & 2) != 0) {
            function0 = new Function0() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i & 4) != 0) {
            function02 = new Function0() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Unit.INSTANCE;
                }
            };
        }
        Function0 function03 = function02;
        return detectDragGestures(pointerInputScope, function1, function0, function03, function2, continuation);
    }

    static final Unit detectDragGestures$lambda$3(Function1 function1, PointerInputChange pointerInputChange, PointerInputChange pointerInputChange2, Offset offset) {
        function1.invoke(Offset.m6069boximpl(pointerInputChange2.getPosition()));
        return Unit.INSTANCE;
    }

    static final Unit detectDragGestures$lambda$4(Function0 function0, PointerInputChange pointerInputChange) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    static final boolean detectDragGestures$lambda$5() {
        return true;
    }

    static final boolean detectDragGestures$lambda$9() {
        return true;
    }

    public static final Object detectDragGesturesAfterLongPress(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super Unit> continuation) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new AnonymousClass5(function1, function0, function02, function2, null), continuation);
        return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
    }

    public static /* synthetic */ Object detectDragGesturesAfterLongPress$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i & 2) != 0) {
            function0 = new Function0() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i & 4) != 0) {
            function02 = new Function0() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Unit.INSTANCE;
                }
            };
        }
        Function0 function03 = function02;
        return detectDragGesturesAfterLongPress(pointerInputScope, function1, function0, function03, function2, continuation);
    }

    public static final Object detectHorizontalDragGestures(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super Unit> continuation) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new C03215(function1, function2, function0, function02, null), continuation);
        return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
    }

    public static /* synthetic */ Object detectHorizontalDragGestures$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i & 2) != 0) {
            function0 = new Function0() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i & 4) != 0) {
            function02 = new Function0() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Unit.INSTANCE;
                }
            };
        }
        Function0 function03 = function02;
        return detectHorizontalDragGestures(pointerInputScope, function1, function0, function03, function2, continuation);
    }

    public static final Object detectVerticalDragGestures(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super Unit> continuation) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new C03225(function1, function2, function0, function02, null), continuation);
        return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
    }

    public static /* synthetic */ Object detectVerticalDragGestures$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i & 2) != 0) {
            function0 = new Function0() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i & 4) != 0) {
            function02 = new Function0() { // from class: androidx.compose.foundation.gestures.DragGestureDetectorKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Unit.INSTANCE;
                }
            };
        }
        Function0 function03 = function02;
        return detectVerticalDragGestures(pointerInputScope, function1, function0, function03, function2, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x012c, code lost:
    
        if (((r3 != null ? r3 == androidx.compose.foundation.gestures.Orientation.Vertical ? java.lang.Float.intBitsToFloat((int) (r4 & androidx.media3.muxer.MuxerUtil.UNSIGNED_INT_MAX_VALUE)) : java.lang.Float.intBitsToFloat((int) (r4 >> 32)) : androidx.compose.ui.geometry.Offset.m6078getDistanceimpl(r4)) == 0.0f) == false) goto L58;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:35:0x00d4, B:46:0x0101], limit reached: 69 */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x008e -> B:23:0x0094). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: drag-VnAYq1g, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m1690dragVnAYq1g(AwaitPointerEventScope awaitPointerEventScope, long j, Function1<? super PointerInputChange, Unit> function1, Orientation orientation, Function1<? super PointerInputChange, Boolean> function12, Continuation<? super PointerInputChange> continuation) {
        DragGestureDetectorKt$drag$2 dragGestureDetectorKt$drag$2;
        long id;
        AwaitPointerEventScope awaitPointerEventScope2;
        Orientation orientation2;
        Function1<? super PointerInputChange, Boolean> function13;
        DragGestureDetectorKt$drag$2 dragGestureDetectorKt$drag$22;
        Function1<? super PointerInputChange, Unit> function14;
        Ref.LongRef longRef;
        AwaitPointerEventScope awaitPointerEventScope3;
        Object objAwaitPointerEvent$default;
        PointerEventPass pointerEventPass;
        Object obj;
        Object obj2;
        int i;
        if (continuation instanceof DragGestureDetectorKt$drag$2) {
            dragGestureDetectorKt$drag$2 = (DragGestureDetectorKt$drag$2) continuation;
            if ((dragGestureDetectorKt$drag$2.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$drag$2.label -= Integer.MIN_VALUE;
            } else {
                dragGestureDetectorKt$drag$2 = new DragGestureDetectorKt$drag$2(continuation);
            }
        }
        Object obj3 = dragGestureDetectorKt$drag$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = dragGestureDetectorKt$drag$2.label;
        int i3 = 1;
        PointerEventPass pointerEventPass2 = null;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj3);
            id = j;
            if (m1694isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), id)) {
                return null;
            }
            awaitPointerEventScope2 = awaitPointerEventScope;
            orientation2 = orientation;
            function13 = function12;
            dragGestureDetectorKt$drag$22 = dragGestureDetectorKt$drag$2;
            function14 = function1;
            longRef = new Ref.LongRef();
            longRef.element = id;
            awaitPointerEventScope3 = awaitPointerEventScope2;
            dragGestureDetectorKt$drag$22.L$0 = awaitPointerEventScope2;
            dragGestureDetectorKt$drag$22.L$1 = function14;
            dragGestureDetectorKt$drag$22.L$2 = orientation2;
            dragGestureDetectorKt$drag$22.L$3 = function13;
            dragGestureDetectorKt$drag$22.L$4 = awaitPointerEventScope3;
            dragGestureDetectorKt$drag$22.L$5 = longRef;
            dragGestureDetectorKt$drag$22.label = i3;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass2, dragGestureDetectorKt$drag$22, i3, pointerEventPass2);
            if (objAwaitPointerEvent$default == coroutine_suspended) {
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Ref.LongRef longRef2 = (Ref.LongRef) dragGestureDetectorKt$drag$2.L$5;
            awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$drag$2.L$4;
            Function1<? super PointerInputChange, Boolean> function15 = (Function1) dragGestureDetectorKt$drag$2.L$3;
            Orientation orientation3 = (Orientation) dragGestureDetectorKt$drag$2.L$2;
            Function1<? super PointerInputChange, Unit> function16 = (Function1) dragGestureDetectorKt$drag$2.L$1;
            AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) dragGestureDetectorKt$drag$2.L$0;
            ResultKt.throwOnFailure(obj3);
            dragGestureDetectorKt$drag$22 = dragGestureDetectorKt$drag$2;
            function14 = function16;
            Ref.LongRef longRef3 = longRef2;
            orientation2 = orientation3;
            function13 = function15;
            PointerEvent pointerEvent = (PointerEvent) obj3;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i4 = 0;
            while (true) {
                if (i4 < size) {
                    pointerEventPass = pointerEventPass2;
                    obj = pointerEventPass;
                    break;
                }
                obj = changes.get(i4);
                pointerEventPass = pointerEventPass2;
                i = i4;
                if (PointerId.m7620equalsimpl0(((PointerInputChange) obj).getId(), longRef3.element)) {
                    break;
                }
                i4 = i + 1;
                pointerEventPass2 = pointerEventPass;
            }
            PointerInputChange pointerInputChange = (PointerInputChange) obj;
            if (pointerInputChange == 0) {
                if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                    List<PointerInputChange> changes2 = pointerEvent.getChanges();
                    int size2 = changes2.size();
                    int i5 = 0;
                    while (true) {
                        if (i5 >= size2) {
                            obj2 = pointerEventPass;
                            break;
                        }
                        obj2 = changes2.get(i5);
                        if (((PointerInputChange) obj2).getPressed()) {
                            break;
                        }
                        i5++;
                    }
                    PointerInputChange pointerInputChange2 = (PointerInputChange) obj2;
                    if (pointerInputChange2 != null) {
                        longRef3.element = pointerInputChange2.getId();
                        awaitPointerEventScope2 = awaitPointerEventScope4;
                        pointerEventPass2 = pointerEventPass;
                        i3 = 1;
                        longRef = longRef3;
                        dragGestureDetectorKt$drag$22.L$0 = awaitPointerEventScope2;
                        dragGestureDetectorKt$drag$22.L$1 = function14;
                        dragGestureDetectorKt$drag$22.L$2 = orientation2;
                        dragGestureDetectorKt$drag$22.L$3 = function13;
                        dragGestureDetectorKt$drag$22.L$4 = awaitPointerEventScope3;
                        dragGestureDetectorKt$drag$22.L$5 = longRef;
                        dragGestureDetectorKt$drag$22.label = i3;
                        objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass2, dragGestureDetectorKt$drag$22, i3, pointerEventPass2);
                        if (objAwaitPointerEvent$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Ref.LongRef longRef4 = longRef;
                        awaitPointerEventScope4 = awaitPointerEventScope2;
                        obj3 = objAwaitPointerEvent$default;
                        longRef3 = longRef4;
                        PointerEvent pointerEvent2 = (PointerEvent) obj3;
                        List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                        int size3 = changes3.size();
                        int i42 = 0;
                        while (true) {
                            if (i42 < size3) {
                            }
                            i42 = i + 1;
                            pointerEventPass2 = pointerEventPass;
                        }
                        PointerInputChange pointerInputChange3 = (PointerInputChange) obj;
                        if (pointerInputChange3 == 0) {
                            pointerInputChange3 = pointerEventPass;
                        }
                    }
                } else {
                    long jPositionChangeIgnoreConsumed = PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange3);
                }
            }
            if (pointerInputChange3 == 0 || function13.invoke(pointerInputChange3).booleanValue()) {
                return pointerEventPass;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                return pointerInputChange3;
            }
            function14.invoke(pointerInputChange3);
            id = pointerInputChange3.getId();
            awaitPointerEventScope2 = awaitPointerEventScope4;
            pointerEventPass2 = pointerEventPass;
            i3 = 1;
            longRef = new Ref.LongRef();
            longRef.element = id;
            awaitPointerEventScope3 = awaitPointerEventScope2;
            dragGestureDetectorKt$drag$22.L$0 = awaitPointerEventScope2;
            dragGestureDetectorKt$drag$22.L$1 = function14;
            dragGestureDetectorKt$drag$22.L$2 = orientation2;
            dragGestureDetectorKt$drag$22.L$3 = function13;
            dragGestureDetectorKt$drag$22.L$4 = awaitPointerEventScope3;
            dragGestureDetectorKt$drag$22.L$5 = longRef;
            dragGestureDetectorKt$drag$22.label = i3;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass2, dragGestureDetectorKt$drag$22, i3, pointerEventPass2);
            if (objAwaitPointerEvent$default == coroutine_suspended) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: drag-VnAYq1g$$forInline, reason: not valid java name */
    private static final Object m1691dragVnAYq1g$$forInline(AwaitPointerEventScope awaitPointerEventScope, long j, Function1<? super PointerInputChange, Unit> function1, Orientation orientation, Function1<? super PointerInputChange, Boolean> function12, Continuation<? super PointerInputChange> continuation) {
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        PointerInputChange pointerInputChange3;
        long id = j;
        if (m1694isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), id)) {
            return null;
        }
        while (true) {
            Ref.LongRef longRef = new Ref.LongRef();
            longRef.element = id;
            while (true) {
                PointerEvent pointerEvent = (PointerEvent) AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, continuation, 1, null);
                List<PointerInputChange> changes = pointerEvent.getChanges();
                int size = changes.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        pointerInputChange = null;
                        break;
                    }
                    pointerInputChange = changes.get(i);
                    if (Boolean.valueOf(PointerId.m7620equalsimpl0(pointerInputChange.getId(), longRef.element)).booleanValue()) {
                        break;
                    }
                    i++;
                }
                pointerInputChange2 = pointerInputChange;
                if (pointerInputChange2 == null) {
                    pointerInputChange2 = null;
                    break;
                }
                if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                    List<PointerInputChange> changes2 = pointerEvent.getChanges();
                    int size2 = changes2.size();
                    while (true) {
                        if (i >= size2) {
                            pointerInputChange3 = null;
                            break;
                        }
                        pointerInputChange3 = changes2.get(i);
                        if (Boolean.valueOf(pointerInputChange3.getPressed()).booleanValue()) {
                            break;
                        }
                        i++;
                    }
                    PointerInputChange pointerInputChange4 = pointerInputChange3;
                    if (pointerInputChange4 == null) {
                        break;
                    }
                    longRef.element = pointerInputChange4.getId();
                } else {
                    long jPositionChangeIgnoreConsumed = PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange2);
                    if (Boolean.valueOf(1 ^ ((orientation == null ? Offset.m6078getDistanceimpl(jPositionChangeIgnoreConsumed) : orientation == Orientation.Vertical ? Float.intBitsToFloat((int) (jPositionChangeIgnoreConsumed & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) : Float.intBitsToFloat((int) (jPositionChangeIgnoreConsumed >> 32))) == 0.0f ? 1 : 0)).booleanValue()) {
                        break;
                    }
                }
            }
            if (pointerInputChange2 == null || function12.invoke(pointerInputChange2).booleanValue()) {
                return null;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                return pointerInputChange2;
            }
            function1.invoke(pointerInputChange2);
            id = pointerInputChange2.getId();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0049 -> B:18:0x004c). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: drag-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m1692dragjO51t88(AwaitPointerEventScope awaitPointerEventScope, long j, Function1<? super PointerInputChange, Unit> function1, Continuation<? super Boolean> continuation) {
        DragGestureDetectorKt$drag$1 dragGestureDetectorKt$drag$1;
        PointerInputChange pointerInputChange;
        if (continuation instanceof DragGestureDetectorKt$drag$1) {
            dragGestureDetectorKt$drag$1 = (DragGestureDetectorKt$drag$1) continuation;
            if ((dragGestureDetectorKt$drag$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$drag$1.label -= Integer.MIN_VALUE;
            } else {
                dragGestureDetectorKt$drag$1 = new DragGestureDetectorKt$drag$1(continuation);
            }
        }
        Object objM1677awaitDragOrCancellationrnUCldI = dragGestureDetectorKt$drag$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = dragGestureDetectorKt$drag$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objM1677awaitDragOrCancellationrnUCldI);
            dragGestureDetectorKt$drag$1.L$0 = awaitPointerEventScope;
            dragGestureDetectorKt$drag$1.L$1 = function1;
            dragGestureDetectorKt$drag$1.label = 1;
            objM1677awaitDragOrCancellationrnUCldI = m1677awaitDragOrCancellationrnUCldI(awaitPointerEventScope, j, dragGestureDetectorKt$drag$1);
            if (objM1677awaitDragOrCancellationrnUCldI == coroutine_suspended) {
            }
            pointerInputChange = (PointerInputChange) objM1677awaitDragOrCancellationrnUCldI;
            if (pointerInputChange == null) {
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Function1<? super PointerInputChange, Unit> function12 = (Function1) dragGestureDetectorKt$drag$1.L$1;
            AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) dragGestureDetectorKt$drag$1.L$0;
            ResultKt.throwOnFailure(objM1677awaitDragOrCancellationrnUCldI);
            function1 = function12;
            awaitPointerEventScope = awaitPointerEventScope2;
            pointerInputChange = (PointerInputChange) objM1677awaitDragOrCancellationrnUCldI;
            if (pointerInputChange == null) {
                if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                    return Boxing.boxBoolean(true);
                }
                function1.invoke(pointerInputChange);
                j = pointerInputChange.getId();
                dragGestureDetectorKt$drag$1.L$0 = awaitPointerEventScope;
                dragGestureDetectorKt$drag$1.L$1 = function1;
                dragGestureDetectorKt$drag$1.label = 1;
                objM1677awaitDragOrCancellationrnUCldI = m1677awaitDragOrCancellationrnUCldI(awaitPointerEventScope, j, dragGestureDetectorKt$drag$1);
                if (objM1677awaitDragOrCancellationrnUCldI == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pointerInputChange = (PointerInputChange) objM1677awaitDragOrCancellationrnUCldI;
                if (pointerInputChange == null) {
                    return Boxing.boxBoolean(false);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0118, code lost:
    
        if ((r0 == 0.0f) == false) goto L59;
     */
    /* JADX WARN: Path cross not found for [B:35:0x00c6, B:46:0x00f2], limit reached: 73 */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0083 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00b7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0084 -> B:23:0x008a). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: horizontalDrag-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m1693horizontalDragjO51t88(AwaitPointerEventScope awaitPointerEventScope, long j, Function1<? super PointerInputChange, Unit> function1, Continuation<? super Boolean> continuation) {
        DragGestureDetectorKt$horizontalDrag$1 dragGestureDetectorKt$horizontalDrag$1;
        long id;
        Orientation orientation;
        DragGestureDetectorKt$horizontalDrag$1 dragGestureDetectorKt$horizontalDrag$12;
        AwaitPointerEventScope awaitPointerEventScope2;
        Function1<? super PointerInputChange, Unit> function12;
        Orientation orientation2;
        AwaitPointerEventScope awaitPointerEventScope3;
        Ref.LongRef longRef;
        Object objAwaitPointerEvent$default;
        AwaitPointerEventScope awaitPointerEventScope4;
        PointerInputChange pointerInputChange;
        float fIntBitsToFloat;
        PointerInputChange pointerInputChange2;
        if (continuation instanceof DragGestureDetectorKt$horizontalDrag$1) {
            dragGestureDetectorKt$horizontalDrag$1 = (DragGestureDetectorKt$horizontalDrag$1) continuation;
            if ((dragGestureDetectorKt$horizontalDrag$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$horizontalDrag$1.label -= Integer.MIN_VALUE;
            } else {
                dragGestureDetectorKt$horizontalDrag$1 = new DragGestureDetectorKt$horizontalDrag$1(continuation);
            }
        }
        Object obj = dragGestureDetectorKt$horizontalDrag$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = dragGestureDetectorKt$horizontalDrag$1.label;
        int i2 = 1;
        PointerInputChange pointerInputChange3 = null;
        PointerEventPass pointerEventPass = null;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Orientation orientation3 = Orientation.Horizontal;
            id = j;
            if (!m1694isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), id)) {
                orientation = orientation3;
                dragGestureDetectorKt$horizontalDrag$12 = dragGestureDetectorKt$horizontalDrag$1;
                awaitPointerEventScope2 = awaitPointerEventScope;
                function12 = function1;
                Ref.LongRef longRef2 = new Ref.LongRef();
                longRef2.element = id;
                awaitPointerEventScope3 = awaitPointerEventScope2;
                orientation2 = orientation;
                longRef = longRef2;
                dragGestureDetectorKt$horizontalDrag$12.L$0 = function12;
                dragGestureDetectorKt$horizontalDrag$12.L$1 = awaitPointerEventScope2;
                dragGestureDetectorKt$horizontalDrag$12.L$2 = orientation2;
                dragGestureDetectorKt$horizontalDrag$12.L$3 = awaitPointerEventScope3;
                dragGestureDetectorKt$horizontalDrag$12.L$4 = longRef;
                dragGestureDetectorKt$horizontalDrag$12.label = i2;
                objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass, dragGestureDetectorKt$horizontalDrag$12, i2, pointerEventPass);
                if (objAwaitPointerEvent$default == coroutine_suspended) {
                }
            }
            return Boxing.boxBoolean(pointerInputChange3 == null);
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        longRef = (Ref.LongRef) dragGestureDetectorKt$horizontalDrag$1.L$4;
        awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$horizontalDrag$1.L$3;
        orientation2 = (Orientation) dragGestureDetectorKt$horizontalDrag$1.L$2;
        AwaitPointerEventScope awaitPointerEventScope5 = (AwaitPointerEventScope) dragGestureDetectorKt$horizontalDrag$1.L$1;
        Function1<? super PointerInputChange, Unit> function13 = (Function1) dragGestureDetectorKt$horizontalDrag$1.L$0;
        ResultKt.throwOnFailure(obj);
        DragGestureDetectorKt$horizontalDrag$1 dragGestureDetectorKt$horizontalDrag$13 = dragGestureDetectorKt$horizontalDrag$1;
        function12 = function13;
        PointerEvent pointerEvent = (PointerEvent) obj;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i3 = 0;
        while (true) {
            if (i3 < size) {
                awaitPointerEventScope4 = awaitPointerEventScope3;
                pointerInputChange = null;
                break;
            }
            pointerInputChange = changes.get(i3);
            awaitPointerEventScope4 = awaitPointerEventScope3;
            if (PointerId.m7620equalsimpl0(pointerInputChange.getId(), longRef.element)) {
                break;
            }
            i3++;
            awaitPointerEventScope3 = awaitPointerEventScope4;
        }
        PointerInputChange pointerInputChange4 = pointerInputChange;
        if (pointerInputChange4 == null) {
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange4)) {
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                int size2 = changes2.size();
                int i4 = 0;
                while (true) {
                    if (i4 >= size2) {
                        pointerInputChange2 = null;
                        break;
                    }
                    pointerInputChange2 = changes2.get(i4);
                    if (pointerInputChange2.getPressed()) {
                        break;
                    }
                    i4++;
                }
                PointerInputChange pointerInputChange5 = pointerInputChange2;
                if (pointerInputChange5 != null) {
                    longRef.element = pointerInputChange5.getId();
                    awaitPointerEventScope3 = awaitPointerEventScope4;
                    awaitPointerEventScope2 = awaitPointerEventScope5;
                    dragGestureDetectorKt$horizontalDrag$12 = dragGestureDetectorKt$horizontalDrag$13;
                    i2 = 1;
                    pointerEventPass = null;
                    dragGestureDetectorKt$horizontalDrag$12.L$0 = function12;
                    dragGestureDetectorKt$horizontalDrag$12.L$1 = awaitPointerEventScope2;
                    dragGestureDetectorKt$horizontalDrag$12.L$2 = orientation2;
                    dragGestureDetectorKt$horizontalDrag$12.L$3 = awaitPointerEventScope3;
                    dragGestureDetectorKt$horizontalDrag$12.L$4 = longRef;
                    dragGestureDetectorKt$horizontalDrag$12.label = i2;
                    objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass, dragGestureDetectorKt$horizontalDrag$12, i2, pointerEventPass);
                    if (objAwaitPointerEvent$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    DragGestureDetectorKt$horizontalDrag$1 dragGestureDetectorKt$horizontalDrag$14 = dragGestureDetectorKt$horizontalDrag$12;
                    awaitPointerEventScope5 = awaitPointerEventScope2;
                    obj = objAwaitPointerEvent$default;
                    dragGestureDetectorKt$horizontalDrag$13 = dragGestureDetectorKt$horizontalDrag$14;
                    PointerEvent pointerEvent2 = (PointerEvent) obj;
                    List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                    int size3 = changes3.size();
                    int i32 = 0;
                    while (true) {
                        if (i32 < size3) {
                        }
                        i32++;
                        awaitPointerEventScope3 = awaitPointerEventScope4;
                    }
                    PointerInputChange pointerInputChange42 = pointerInputChange;
                    if (pointerInputChange42 == null) {
                        pointerInputChange42 = null;
                    }
                }
            } else {
                long jPositionChangeIgnoreConsumed = PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange42);
                if (orientation2 != null) {
                    fIntBitsToFloat = Float.intBitsToFloat((int) (orientation2 == Orientation.Vertical ? jPositionChangeIgnoreConsumed & MuxerUtil.UNSIGNED_INT_MAX_VALUE : jPositionChangeIgnoreConsumed >> 32));
                } else {
                    fIntBitsToFloat = Offset.m6078getDistanceimpl(jPositionChangeIgnoreConsumed);
                }
            }
        }
        if (pointerInputChange42 == null || pointerInputChange42.isConsumed()) {
            pointerInputChange3 = null;
        } else if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange42)) {
            pointerInputChange3 = pointerInputChange42;
        } else {
            function12.invoke(pointerInputChange42);
            orientation = orientation2;
            id = pointerInputChange42.getId();
            awaitPointerEventScope2 = awaitPointerEventScope5;
            dragGestureDetectorKt$horizontalDrag$12 = dragGestureDetectorKt$horizontalDrag$13;
            i2 = 1;
            pointerEventPass = null;
            Ref.LongRef longRef22 = new Ref.LongRef();
            longRef22.element = id;
            awaitPointerEventScope3 = awaitPointerEventScope2;
            orientation2 = orientation;
            longRef = longRef22;
            dragGestureDetectorKt$horizontalDrag$12.L$0 = function12;
            dragGestureDetectorKt$horizontalDrag$12.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$horizontalDrag$12.L$2 = orientation2;
            dragGestureDetectorKt$horizontalDrag$12.L$3 = awaitPointerEventScope3;
            dragGestureDetectorKt$horizontalDrag$12.L$4 = longRef;
            dragGestureDetectorKt$horizontalDrag$12.label = i2;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass, dragGestureDetectorKt$horizontalDrag$12, i2, pointerEventPass);
            if (objAwaitPointerEvent$default == coroutine_suspended) {
            }
        }
        return Boxing.boxBoolean(pointerInputChange3 == null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: isPointerUp-DmW0f2w, reason: not valid java name */
    public static final boolean m1694isPointerUpDmW0f2w(PointerEvent pointerEvent, long j) {
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
    public static final float m1695pointerSlopE8SPZFQ(ViewConfiguration viewConfiguration, int i) {
        return PointerType.m7709equalsimpl0(i, PointerType.INSTANCE.m7714getMouseT8wyACA()) ? viewConfiguration.getTouchSlop() * mouseToTouchSlopRatio : viewConfiguration.getTouchSlop();
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0118, code lost:
    
        if ((r0 == 0.0f) == false) goto L59;
     */
    /* JADX WARN: Path cross not found for [B:35:0x00c6, B:46:0x00f2], limit reached: 73 */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0083 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00b7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0084 -> B:23:0x008a). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: verticalDrag-jO51t88, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m1696verticalDragjO51t88(AwaitPointerEventScope awaitPointerEventScope, long j, Function1<? super PointerInputChange, Unit> function1, Continuation<? super Boolean> continuation) {
        DragGestureDetectorKt$verticalDrag$1 dragGestureDetectorKt$verticalDrag$1;
        long id;
        Orientation orientation;
        DragGestureDetectorKt$verticalDrag$1 dragGestureDetectorKt$verticalDrag$12;
        AwaitPointerEventScope awaitPointerEventScope2;
        Function1<? super PointerInputChange, Unit> function12;
        Orientation orientation2;
        AwaitPointerEventScope awaitPointerEventScope3;
        Ref.LongRef longRef;
        Object objAwaitPointerEvent$default;
        AwaitPointerEventScope awaitPointerEventScope4;
        PointerInputChange pointerInputChange;
        float fIntBitsToFloat;
        PointerInputChange pointerInputChange2;
        if (continuation instanceof DragGestureDetectorKt$verticalDrag$1) {
            dragGestureDetectorKt$verticalDrag$1 = (DragGestureDetectorKt$verticalDrag$1) continuation;
            if ((dragGestureDetectorKt$verticalDrag$1.label & Integer.MIN_VALUE) != 0) {
                dragGestureDetectorKt$verticalDrag$1.label -= Integer.MIN_VALUE;
            } else {
                dragGestureDetectorKt$verticalDrag$1 = new DragGestureDetectorKt$verticalDrag$1(continuation);
            }
        }
        Object obj = dragGestureDetectorKt$verticalDrag$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = dragGestureDetectorKt$verticalDrag$1.label;
        int i2 = 1;
        PointerInputChange pointerInputChange3 = null;
        PointerEventPass pointerEventPass = null;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Orientation orientation3 = Orientation.Vertical;
            id = j;
            if (!m1694isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), id)) {
                orientation = orientation3;
                dragGestureDetectorKt$verticalDrag$12 = dragGestureDetectorKt$verticalDrag$1;
                awaitPointerEventScope2 = awaitPointerEventScope;
                function12 = function1;
                Ref.LongRef longRef2 = new Ref.LongRef();
                longRef2.element = id;
                awaitPointerEventScope3 = awaitPointerEventScope2;
                orientation2 = orientation;
                longRef = longRef2;
                dragGestureDetectorKt$verticalDrag$12.L$0 = function12;
                dragGestureDetectorKt$verticalDrag$12.L$1 = awaitPointerEventScope2;
                dragGestureDetectorKt$verticalDrag$12.L$2 = orientation2;
                dragGestureDetectorKt$verticalDrag$12.L$3 = awaitPointerEventScope3;
                dragGestureDetectorKt$verticalDrag$12.L$4 = longRef;
                dragGestureDetectorKt$verticalDrag$12.label = i2;
                objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass, dragGestureDetectorKt$verticalDrag$12, i2, pointerEventPass);
                if (objAwaitPointerEvent$default == coroutine_suspended) {
                }
            }
            return Boxing.boxBoolean(pointerInputChange3 == null);
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        longRef = (Ref.LongRef) dragGestureDetectorKt$verticalDrag$1.L$4;
        awaitPointerEventScope3 = (AwaitPointerEventScope) dragGestureDetectorKt$verticalDrag$1.L$3;
        orientation2 = (Orientation) dragGestureDetectorKt$verticalDrag$1.L$2;
        AwaitPointerEventScope awaitPointerEventScope5 = (AwaitPointerEventScope) dragGestureDetectorKt$verticalDrag$1.L$1;
        Function1<? super PointerInputChange, Unit> function13 = (Function1) dragGestureDetectorKt$verticalDrag$1.L$0;
        ResultKt.throwOnFailure(obj);
        DragGestureDetectorKt$verticalDrag$1 dragGestureDetectorKt$verticalDrag$13 = dragGestureDetectorKt$verticalDrag$1;
        function12 = function13;
        PointerEvent pointerEvent = (PointerEvent) obj;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i3 = 0;
        while (true) {
            if (i3 < size) {
                awaitPointerEventScope4 = awaitPointerEventScope3;
                pointerInputChange = null;
                break;
            }
            pointerInputChange = changes.get(i3);
            awaitPointerEventScope4 = awaitPointerEventScope3;
            if (PointerId.m7620equalsimpl0(pointerInputChange.getId(), longRef.element)) {
                break;
            }
            i3++;
            awaitPointerEventScope3 = awaitPointerEventScope4;
        }
        PointerInputChange pointerInputChange4 = pointerInputChange;
        if (pointerInputChange4 == null) {
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange4)) {
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                int size2 = changes2.size();
                int i4 = 0;
                while (true) {
                    if (i4 >= size2) {
                        pointerInputChange2 = null;
                        break;
                    }
                    pointerInputChange2 = changes2.get(i4);
                    if (pointerInputChange2.getPressed()) {
                        break;
                    }
                    i4++;
                }
                PointerInputChange pointerInputChange5 = pointerInputChange2;
                if (pointerInputChange5 != null) {
                    longRef.element = pointerInputChange5.getId();
                    awaitPointerEventScope3 = awaitPointerEventScope4;
                    awaitPointerEventScope2 = awaitPointerEventScope5;
                    dragGestureDetectorKt$verticalDrag$12 = dragGestureDetectorKt$verticalDrag$13;
                    i2 = 1;
                    pointerEventPass = null;
                    dragGestureDetectorKt$verticalDrag$12.L$0 = function12;
                    dragGestureDetectorKt$verticalDrag$12.L$1 = awaitPointerEventScope2;
                    dragGestureDetectorKt$verticalDrag$12.L$2 = orientation2;
                    dragGestureDetectorKt$verticalDrag$12.L$3 = awaitPointerEventScope3;
                    dragGestureDetectorKt$verticalDrag$12.L$4 = longRef;
                    dragGestureDetectorKt$verticalDrag$12.label = i2;
                    objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass, dragGestureDetectorKt$verticalDrag$12, i2, pointerEventPass);
                    if (objAwaitPointerEvent$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    DragGestureDetectorKt$verticalDrag$1 dragGestureDetectorKt$verticalDrag$14 = dragGestureDetectorKt$verticalDrag$12;
                    awaitPointerEventScope5 = awaitPointerEventScope2;
                    obj = objAwaitPointerEvent$default;
                    dragGestureDetectorKt$verticalDrag$13 = dragGestureDetectorKt$verticalDrag$14;
                    PointerEvent pointerEvent2 = (PointerEvent) obj;
                    List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                    int size3 = changes3.size();
                    int i32 = 0;
                    while (true) {
                        if (i32 < size3) {
                        }
                        i32++;
                        awaitPointerEventScope3 = awaitPointerEventScope4;
                    }
                    PointerInputChange pointerInputChange42 = pointerInputChange;
                    if (pointerInputChange42 == null) {
                        pointerInputChange42 = null;
                    }
                }
            } else {
                long jPositionChangeIgnoreConsumed = PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange42);
                if (orientation2 != null) {
                    fIntBitsToFloat = Float.intBitsToFloat((int) (orientation2 == Orientation.Vertical ? jPositionChangeIgnoreConsumed & MuxerUtil.UNSIGNED_INT_MAX_VALUE : jPositionChangeIgnoreConsumed >> 32));
                } else {
                    fIntBitsToFloat = Offset.m6078getDistanceimpl(jPositionChangeIgnoreConsumed);
                }
            }
        }
        if (pointerInputChange42 == null || pointerInputChange42.isConsumed()) {
            pointerInputChange3 = null;
        } else if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange42)) {
            pointerInputChange3 = pointerInputChange42;
        } else {
            function12.invoke(pointerInputChange42);
            orientation = orientation2;
            id = pointerInputChange42.getId();
            awaitPointerEventScope2 = awaitPointerEventScope5;
            dragGestureDetectorKt$verticalDrag$12 = dragGestureDetectorKt$verticalDrag$13;
            i2 = 1;
            pointerEventPass = null;
            Ref.LongRef longRef22 = new Ref.LongRef();
            longRef22.element = id;
            awaitPointerEventScope3 = awaitPointerEventScope2;
            orientation2 = orientation;
            longRef = longRef22;
            dragGestureDetectorKt$verticalDrag$12.L$0 = function12;
            dragGestureDetectorKt$verticalDrag$12.L$1 = awaitPointerEventScope2;
            dragGestureDetectorKt$verticalDrag$12.L$2 = orientation2;
            dragGestureDetectorKt$verticalDrag$12.L$3 = awaitPointerEventScope3;
            dragGestureDetectorKt$verticalDrag$12.L$4 = longRef;
            dragGestureDetectorKt$verticalDrag$12.label = i2;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope3, pointerEventPass, dragGestureDetectorKt$verticalDrag$12, i2, pointerEventPass);
            if (objAwaitPointerEvent$default == coroutine_suspended) {
            }
        }
        return Boxing.boxBoolean(pointerInputChange3 == null);
    }
}
