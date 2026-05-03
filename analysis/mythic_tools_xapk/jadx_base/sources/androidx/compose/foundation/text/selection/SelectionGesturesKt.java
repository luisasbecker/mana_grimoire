package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEvent_androidKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.ViewConfiguration;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: compiled from: SelectionGestures.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0000\u001a\"\u0010\b\u001a\u00020\u0007*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0080@¢\u0006\u0002\u0010\u000e\u001a\"\u0010\u000f\u001a\u00020\u0007*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0080@¢\u0006\u0002\u0010\u0014\u001a*\u0010\u0015\u001a\u00020\u0007*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0001H\u0082@¢\u0006\u0002\u0010\u0017\u001a*\u0010\u0018\u001a\u00020\u0007*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0013H\u0080@¢\u0006\u0002\u0010\u001c\u001a\u0012\u0010\u001d\u001a\u00020\u0013*\u00020\u0010H\u0082@¢\u0006\u0002\u0010\u001e\u001a \u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"STATIC_KEY", "", "updateSelectionTouchMode", "Landroidx/compose/ui/Modifier;", "updateTouchMode", "Lkotlin/Function1;", "", "", "awaitSelectionGestures", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "mouseSelectionObserver", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "textDragObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/text/selection/MouseSelectionObserver;Landroidx/compose/foundation/text/TextDragObserver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "touchSelectionFirstPress", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "observer", "downEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/foundation/text/TextDragObserver;Landroidx/compose/ui/input/pointer/PointerEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "touchSelectionSubsequentPress", "clicks", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/foundation/text/TextDragObserver;Landroidx/compose/ui/input/pointer/PointerEvent;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mouseSelection", "clicksCounter", "Landroidx/compose/foundation/text/selection/ClicksCounter;", "down", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/foundation/text/selection/MouseSelectionObserver;Landroidx/compose/foundation/text/selection/ClicksCounter;Landroidx/compose/ui/input/pointer/PointerEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitDown", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "distanceIsTolerable", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "change1", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "change2", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SelectionGesturesKt {
    private static final int STATIC_KEY = 8675309;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1, reason: invalid class name */
    /* JADX INFO: compiled from: SelectionGestures.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt", f = "SelectionGestures.kt", i = {0}, l = {340}, m = "awaitDown", n = {"$this$awaitDown"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SelectionGesturesKt.awaitDown(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitSelectionGestures$2, reason: invalid class name */
    /* JADX INFO: compiled from: SelectionGestures.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitSelectionGestures$2", f = "SelectionGestures.kt", i = {0}, l = {111, 119, Imgproc.COLOR_YUV2BGRA_YVYU, 124}, m = "invokeSuspend", n = {"$this$awaitEachGesture"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ClicksCounter $clicksCounter;
        final /* synthetic */ MouseSelectionObserver $mouseSelectionObserver;
        final /* synthetic */ TextDragObserver $textDragObserver;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ClicksCounter clicksCounter, MouseSelectionObserver mouseSelectionObserver, TextDragObserver textDragObserver, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$clicksCounter = clicksCounter;
            this.$mouseSelectionObserver = mouseSelectionObserver;
            this.$textDragObserver = textDragObserver;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$clicksCounter, this.$mouseSelectionObserver, this.$textDragObserver, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x0086, code lost:
        
            if (androidx.compose.foundation.text.selection.SelectionGesturesKt.mouseSelection(r1, r12.$mouseSelectionObserver, r12.$clicksCounter, r13, r12) == r0) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00a0, code lost:
        
            if (androidx.compose.foundation.text.selection.SelectionGesturesKt.touchSelectionFirstPress(r1, r6, r13, r12) == r0) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00b4, code lost:
        
            if (androidx.compose.foundation.text.selection.SelectionGesturesKt.touchSelectionSubsequentPress(r1, r6, r13, r12.$clicksCounter.getClicks(), r12) == r0) goto L37;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            AwaitPointerEventScope awaitPointerEventScope;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                this.L$0 = awaitPointerEventScope;
                this.label = 1;
                obj = SelectionGesturesKt.awaitDown(awaitPointerEventScope, this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2 && i != 3 && i != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            PointerEvent pointerEvent = (PointerEvent) obj;
            this.$clicksCounter.update(pointerEvent);
            boolean zIsMouseOrTouchPad = SelectionGestures_androidKt.isMouseOrTouchPad(pointerEvent);
            if (zIsMouseOrTouchPad && PointerEvent_androidKt.m7611isPrimaryPressedaHzCxE(pointerEvent.getButtons())) {
                List<PointerInputChange> changes = pointerEvent.getChanges();
                int size = changes.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (!changes.get(i2).isConsumed()) {
                    }
                }
                this.L$0 = null;
                this.label = 2;
            }
            if (!zIsMouseOrTouchPad) {
                int clicks = this.$clicksCounter.getClicks();
                TextDragObserver textDragObserver = this.$textDragObserver;
                if (clicks == 1) {
                    this.L$0 = null;
                    this.label = 3;
                } else {
                    this.L$0 = null;
                    this.label = 4;
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$mouseSelection$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SelectionGestures.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt", f = "SelectionGestures.kt", i = {0, 0, 1, 1, 1}, l = {267, 294}, m = "mouseSelection", n = {"$this$mouseSelection", "observer", "$this$mouseSelection", "observer", "dragConsumed"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"}, v = 1)
    static final class C04081 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C04081(Continuation<? super C04081> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SelectionGesturesKt.mouseSelection(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionFirstPress$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SelectionGestures.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt", f = "SelectionGestures.kt", i = {0, 0, 0, 1, 1}, l = {141, 145}, m = "touchSelectionFirstPress", n = {"$this$touchSelectionFirstPress", "observer", "firstDown", "$this$touchSelectionFirstPress", "observer"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1"}, v = 1)
    static final class C04091 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C04091(Continuation<? super C04091> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SelectionGesturesKt.touchSelectionFirstPress(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionSubsequentPress$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SelectionGestures.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt", f = "SelectionGestures.kt", i = {0, 0, 0, 0, 1, 1}, l = {193, 232}, m = "touchSelectionSubsequentPress", n = {"$this$touchSelectionSubsequentPress", "observer", "overSlop", "pointerId", "$this$touchSelectionSubsequentPress", "observer"}, s = {"L$0", "L$1", "L$2", "J$0", "L$0", "L$1"}, v = 1)
    static final class C04101 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C04101(Continuation<? super C04101> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SelectionGesturesKt.touchSelectionSubsequentPress(null, null, null, 0, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0045 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0043 -> B:18:0x0046). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object awaitDown(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super PointerEvent> continuation) {
        AnonymousClass1 anonymousClass1;
        int size;
        int i;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object objAwaitPointerEvent = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objAwaitPointerEvent);
            PointerEventPass pointerEventPass = PointerEventPass.Main;
            anonymousClass1.L$0 = awaitPointerEventScope;
            anonymousClass1.label = 1;
            objAwaitPointerEvent = awaitPointerEventScope.awaitPointerEvent(pointerEventPass, anonymousClass1);
            if (objAwaitPointerEvent == coroutine_suspended) {
            }
            PointerEvent pointerEvent = (PointerEvent) objAwaitPointerEvent;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            size = changes.size();
            i = 0;
            while (i < size) {
            }
            return pointerEvent;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        awaitPointerEventScope = (AwaitPointerEventScope) anonymousClass1.L$0;
        ResultKt.throwOnFailure(objAwaitPointerEvent);
        PointerEvent pointerEvent2 = (PointerEvent) objAwaitPointerEvent;
        List<PointerInputChange> changes2 = pointerEvent2.getChanges();
        size = changes2.size();
        i = 0;
        while (i < size) {
            if (PointerEventKt.changedToDown(changes2.get(i))) {
                i++;
            } else {
                PointerEventPass pointerEventPass2 = PointerEventPass.Main;
                anonymousClass1.L$0 = awaitPointerEventScope;
                anonymousClass1.label = 1;
                objAwaitPointerEvent = awaitPointerEventScope.awaitPointerEvent(pointerEventPass2, anonymousClass1);
                if (objAwaitPointerEvent == coroutine_suspended) {
                    return coroutine_suspended;
                }
                PointerEvent pointerEvent22 = (PointerEvent) objAwaitPointerEvent;
                List<PointerInputChange> changes22 = pointerEvent22.getChanges();
                size = changes22.size();
                i = 0;
                while (i < size) {
                }
            }
        }
        return pointerEvent22;
    }

    public static final Object awaitSelectionGestures(PointerInputScope pointerInputScope, MouseSelectionObserver mouseSelectionObserver, TextDragObserver textDragObserver, Continuation<? super Unit> continuation) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new AnonymousClass2(new ClicksCounter(pointerInputScope.getViewConfiguration()), mouseSelectionObserver, textDragObserver, null), continuation);
        return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean distanceIsTolerable(ViewConfiguration viewConfiguration, PointerInputChange pointerInputChange, PointerInputChange pointerInputChange2) {
        return Offset.m6078getDistanceimpl(Offset.m6084minusMKHz9U(pointerInputChange.getPosition(), pointerInputChange2.getPosition())) < DragGestureDetectorKt.m1695pointerSlopE8SPZFQ(viewConfiguration, pointerInputChange.getType());
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0098 A[Catch: all -> 0x0053, TryCatch #0 {all -> 0x0053, blocks: (B:20:0x004f, B:31:0x0090, B:33:0x0098, B:35:0x00a9, B:37:0x00b5, B:28:0x0076), top: B:69:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0138 A[Catch: all -> 0x003b, TryCatch #1 {all -> 0x003b, blocks: (B:13:0x0036, B:54:0x011b, B:56:0x0123, B:58:0x0127, B:60:0x0138, B:62:0x0144, B:50:0x00ee), top: B:69:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object mouseSelection(AwaitPointerEventScope awaitPointerEventScope, final MouseSelectionObserver mouseSelectionObserver, ClicksCounter clicksCounter, PointerEvent pointerEvent, Continuation<? super Unit> continuation) {
        C04081 c04081;
        AwaitPointerEventScope awaitPointerEventScope2;
        Ref.BooleanRef booleanRef;
        int size;
        if (continuation instanceof C04081) {
            c04081 = (C04081) continuation;
            if ((c04081.label & Integer.MIN_VALUE) != 0) {
                c04081.label -= Integer.MIN_VALUE;
            } else {
                c04081 = new C04081(continuation);
            }
        }
        Object objM1692dragjO51t88 = c04081.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c04081.label;
        int i2 = 0;
        try {
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(objM1692dragjO51t88);
                    PointerInputChange pointerInputChange = pointerEvent.getChanges().get(0);
                    if (!PointerEvent_androidKt.m7614isShiftPressed5xRPYO0(pointerEvent.getKeyboardModifiers())) {
                        int clicks = clicksCounter.getClicks();
                        final SelectionAdjustment paragraph = clicks != 1 ? clicks != 2 ? SelectionAdjustment.INSTANCE.getParagraph() : SelectionAdjustment.INSTANCE.getWord() : SelectionAdjustment.INSTANCE.getNone();
                        if (mouseSelectionObserver.mo2735onStart9KIMszo(pointerInputChange.getPosition(), paragraph, clicksCounter.getClicks())) {
                            final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
                            booleanRef2.element = !Intrinsics.areEqual(paragraph, SelectionAdjustment.INSTANCE.getNone());
                            long id = pointerInputChange.getId();
                            Function1 function1 = new Function1() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return SelectionGesturesKt.mouseSelection$lambda$2(mouseSelectionObserver, paragraph, booleanRef2, (PointerInputChange) obj);
                                }
                            };
                            c04081.L$0 = awaitPointerEventScope;
                            c04081.L$1 = mouseSelectionObserver;
                            c04081.L$2 = booleanRef2;
                            c04081.label = 2;
                            objM1692dragjO51t88 = DragGestureDetectorKt.m1692dragjO51t88(awaitPointerEventScope, id, function1, c04081);
                            if (objM1692dragjO51t88 != coroutine_suspended) {
                                awaitPointerEventScope2 = awaitPointerEventScope;
                                booleanRef = booleanRef2;
                                if (((Boolean) objM1692dragjO51t88).booleanValue()) {
                                    List<PointerInputChange> changes = awaitPointerEventScope2.getCurrentEvent().getChanges();
                                    size = changes.size();
                                    while (i2 < size) {
                                    }
                                }
                                mouseSelectionObserver.onDragDone();
                            }
                            return coroutine_suspended;
                        }
                    } else if (mouseSelectionObserver.mo2733onExtendk4lQ0M(pointerInputChange.getPosition())) {
                        pointerInputChange.consume();
                        long id2 = pointerInputChange.getId();
                        Function1 function12 = new Function1() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SelectionGesturesKt.mouseSelection$lambda$0(mouseSelectionObserver, (PointerInputChange) obj);
                            }
                        };
                        c04081.L$0 = awaitPointerEventScope;
                        c04081.L$1 = mouseSelectionObserver;
                        c04081.label = 1;
                        objM1692dragjO51t88 = DragGestureDetectorKt.m1692dragjO51t88(awaitPointerEventScope, id2, function12, c04081);
                        if (objM1692dragjO51t88 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (((Boolean) objM1692dragjO51t88).booleanValue()) {
                        }
                    }
                } else if (i == 1) {
                    mouseSelectionObserver = (MouseSelectionObserver) c04081.L$1;
                    awaitPointerEventScope = (AwaitPointerEventScope) c04081.L$0;
                    ResultKt.throwOnFailure(objM1692dragjO51t88);
                    if (((Boolean) objM1692dragjO51t88).booleanValue()) {
                        List<PointerInputChange> changes2 = awaitPointerEventScope.getCurrentEvent().getChanges();
                        int size2 = changes2.size();
                        while (i2 < size2) {
                            PointerInputChange pointerInputChange2 = changes2.get(i2);
                            if (PointerEventKt.changedToUp(pointerInputChange2)) {
                                pointerInputChange2.consume();
                            }
                            i2++;
                        }
                    }
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    booleanRef = (Ref.BooleanRef) c04081.L$2;
                    mouseSelectionObserver = (MouseSelectionObserver) c04081.L$1;
                    awaitPointerEventScope2 = (AwaitPointerEventScope) c04081.L$0;
                    ResultKt.throwOnFailure(objM1692dragjO51t88);
                    if (((Boolean) objM1692dragjO51t88).booleanValue() && booleanRef.element) {
                        List<PointerInputChange> changes3 = awaitPointerEventScope2.getCurrentEvent().getChanges();
                        size = changes3.size();
                        while (i2 < size) {
                            PointerInputChange pointerInputChange3 = changes3.get(i2);
                            if (PointerEventKt.changedToUp(pointerInputChange3)) {
                                pointerInputChange3.consume();
                            }
                            i2++;
                        }
                    }
                    mouseSelectionObserver.onDragDone();
                }
                return Unit.INSTANCE;
            } finally {
            }
        } finally {
        }
    }

    static final Unit mouseSelection$lambda$0(MouseSelectionObserver mouseSelectionObserver, PointerInputChange pointerInputChange) {
        if (mouseSelectionObserver.mo2734onExtendDragk4lQ0M(pointerInputChange.getPosition())) {
            pointerInputChange.consume();
        }
        return Unit.INSTANCE;
    }

    static final Unit mouseSelection$lambda$2(MouseSelectionObserver mouseSelectionObserver, SelectionAdjustment selectionAdjustment, Ref.BooleanRef booleanRef, PointerInputChange pointerInputChange) {
        if (mouseSelectionObserver.mo2732onDrag3MmeM6k(pointerInputChange.getPosition(), selectionAdjustment)) {
            pointerInputChange.consume();
            booleanRef.element = true;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a3, code lost:
    
        if (r11 == r1) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object touchSelectionFirstPress(AwaitPointerEventScope awaitPointerEventScope, final TextDragObserver textDragObserver, PointerEvent pointerEvent, Continuation<? super Unit> continuation) {
        C04091 c04091;
        PointerInputChange pointerInputChange;
        if (continuation instanceof C04091) {
            c04091 = (C04091) continuation;
            if ((c04091.label & Integer.MIN_VALUE) != 0) {
                c04091.label -= Integer.MIN_VALUE;
            } else {
                c04091 = new C04091(continuation);
            }
        }
        Object objM1682awaitLongPressOrCancellationrnUCldI = c04091.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c04091.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objM1682awaitLongPressOrCancellationrnUCldI);
                pointerInputChange = (PointerInputChange) CollectionsKt.first((List) pointerEvent.getChanges());
                long id = pointerInputChange.getId();
                c04091.L$0 = awaitPointerEventScope;
                c04091.L$1 = textDragObserver;
                c04091.L$2 = pointerInputChange;
                c04091.label = 1;
                objM1682awaitLongPressOrCancellationrnUCldI = DragGestureDetectorKt.m1682awaitLongPressOrCancellationrnUCldI(awaitPointerEventScope, id, c04091);
                if (objM1682awaitLongPressOrCancellationrnUCldI == coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                textDragObserver = (TextDragObserver) c04091.L$1;
                awaitPointerEventScope = (AwaitPointerEventScope) c04091.L$0;
                ResultKt.throwOnFailure(objM1682awaitLongPressOrCancellationrnUCldI);
                if (((Boolean) objM1682awaitLongPressOrCancellationrnUCldI).booleanValue()) {
                    List<PointerInputChange> changes = awaitPointerEventScope.getCurrentEvent().getChanges();
                    int size = changes.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        PointerInputChange pointerInputChange2 = changes.get(i2);
                        if (PointerEventKt.changedToUp(pointerInputChange2)) {
                            pointerInputChange2.consume();
                        }
                    }
                    textDragObserver.onStop();
                } else {
                    textDragObserver.onCancel();
                }
                return Unit.INSTANCE;
            }
            PointerInputChange pointerInputChange3 = (PointerInputChange) c04091.L$2;
            textDragObserver = (TextDragObserver) c04091.L$1;
            AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) c04091.L$0;
            ResultKt.throwOnFailure(objM1682awaitLongPressOrCancellationrnUCldI);
            pointerInputChange = pointerInputChange3;
            awaitPointerEventScope = awaitPointerEventScope2;
            PointerInputChange pointerInputChange4 = (PointerInputChange) objM1682awaitLongPressOrCancellationrnUCldI;
            if (pointerInputChange4 != null && distanceIsTolerable(awaitPointerEventScope.getViewConfiguration(), pointerInputChange, pointerInputChange4)) {
                textDragObserver.mo2474onStart3MmeM6k(pointerInputChange4.getPosition(), SelectionAdjustment.INSTANCE.getWord());
                long id2 = pointerInputChange4.getId();
                Function1 function1 = new Function1() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SelectionGesturesKt.touchSelectionFirstPress$lambda$0(textDragObserver, (PointerInputChange) obj);
                    }
                };
                c04091.L$0 = awaitPointerEventScope;
                c04091.L$1 = textDragObserver;
                c04091.L$2 = null;
                c04091.label = 2;
                objM1682awaitLongPressOrCancellationrnUCldI = DragGestureDetectorKt.m1692dragjO51t88(awaitPointerEventScope, id2, function1, c04091);
            }
            return Unit.INSTANCE;
        } catch (CancellationException e) {
            textDragObserver.onCancel();
            throw e;
        }
    }

    static final Unit touchSelectionFirstPress$lambda$0(TextDragObserver textDragObserver, PointerInputChange pointerInputChange) {
        textDragObserver.mo2473onDragk4lQ0M(PointerEventKt.positionChange(pointerInputChange));
        pointerInputChange.consume();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e1, code lost:
    
        if (r14 == r1) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object touchSelectionSubsequentPress(AwaitPointerEventScope awaitPointerEventScope, final TextDragObserver textDragObserver, PointerEvent pointerEvent, int i, Continuation<? super Unit> continuation) {
        C04101 c04101;
        long id;
        Ref.LongRef longRef;
        if (continuation instanceof C04101) {
            c04101 = (C04101) continuation;
            if ((c04101.label & Integer.MIN_VALUE) != 0) {
                c04101.label -= Integer.MIN_VALUE;
            } else {
                c04101 = new C04101(continuation);
            }
        }
        Object objWithTimeoutOrNull = c04101.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c04101.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objWithTimeoutOrNull);
                PointerInputChange pointerInputChange = (PointerInputChange) CollectionsKt.first((List) pointerEvent.getChanges());
                id = pointerInputChange.getId();
                textDragObserver.mo2474onStart3MmeM6k(pointerInputChange.getPosition(), i > 2 ? SelectionAdjustment.INSTANCE.getParagraph() : SelectionAdjustment.INSTANCE.getWord());
                longRef = new Ref.LongRef();
                longRef.element = Offset.INSTANCE.m6095getUnspecifiedF1C5BW0();
                long longPressTimeoutMillis = awaitPointerEventScope.getViewConfiguration().getLongPressTimeoutMillis();
                SelectionGesturesKt$touchSelectionSubsequentPress$downResolution$1 selectionGesturesKt$touchSelectionSubsequentPress$downResolution$1 = new SelectionGesturesKt$touchSelectionSubsequentPress$downResolution$1(id, longRef, null);
                c04101.L$0 = awaitPointerEventScope;
                c04101.L$1 = textDragObserver;
                c04101.L$2 = longRef;
                c04101.J$0 = id;
                c04101.label = 1;
                objWithTimeoutOrNull = awaitPointerEventScope.withTimeoutOrNull(longPressTimeoutMillis, selectionGesturesKt$touchSelectionSubsequentPress$downResolution$1, c04101);
                if (objWithTimeoutOrNull == coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                textDragObserver = (TextDragObserver) c04101.L$1;
                awaitPointerEventScope = (AwaitPointerEventScope) c04101.L$0;
                ResultKt.throwOnFailure(objWithTimeoutOrNull);
                if (((Boolean) objWithTimeoutOrNull).booleanValue()) {
                    List<PointerInputChange> changes = awaitPointerEventScope.getCurrentEvent().getChanges();
                    int size = changes.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        PointerInputChange pointerInputChange2 = changes.get(i3);
                        if (PointerEventKt.changedToUp(pointerInputChange2)) {
                            pointerInputChange2.consume();
                        }
                    }
                    textDragObserver.onStop();
                } else {
                    textDragObserver.onCancel();
                }
                return Unit.INSTANCE;
            }
            long j = c04101.J$0;
            longRef = (Ref.LongRef) c04101.L$2;
            TextDragObserver textDragObserver2 = (TextDragObserver) c04101.L$1;
            AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) c04101.L$0;
            try {
                ResultKt.throwOnFailure(objWithTimeoutOrNull);
                id = j;
                textDragObserver = textDragObserver2;
                awaitPointerEventScope = awaitPointerEventScope2;
            } catch (CancellationException e) {
                e = e;
                textDragObserver = textDragObserver2;
                textDragObserver.onCancel();
                throw e;
            }
            DownResolution downResolution = (DownResolution) objWithTimeoutOrNull;
            if (downResolution == null) {
                downResolution = DownResolution.Timeout;
            }
            if (downResolution == DownResolution.Cancel) {
                textDragObserver.onCancel();
                return Unit.INSTANCE;
            }
            if (downResolution == DownResolution.Up) {
                textDragObserver.onStop();
                return Unit.INSTANCE;
            }
            if (downResolution == DownResolution.Drag) {
                textDragObserver.mo2473onDragk4lQ0M(longRef.element);
            }
            Function1 function1 = new Function1() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return SelectionGesturesKt.touchSelectionSubsequentPress$lambda$0(textDragObserver, (PointerInputChange) obj);
                }
            };
            c04101.L$0 = awaitPointerEventScope;
            c04101.L$1 = textDragObserver;
            c04101.L$2 = null;
            c04101.label = 2;
            objWithTimeoutOrNull = DragGestureDetectorKt.m1692dragjO51t88(awaitPointerEventScope, id, function1, c04101);
        } catch (CancellationException e2) {
            e = e2;
        }
    }

    static final Unit touchSelectionSubsequentPress$lambda$0(TextDragObserver textDragObserver, PointerInputChange pointerInputChange) {
        textDragObserver.mo2473onDragk4lQ0M(PointerEventKt.positionChange(pointerInputChange));
        pointerInputChange.consume();
        return Unit.INSTANCE;
    }

    public static final Modifier updateSelectionTouchMode(Modifier modifier, final Function1<? super Boolean, Unit> function1) {
        return SuspendingPointerInputFilterKt.pointerInput(modifier, Integer.valueOf(STATIC_KEY), new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt.updateSelectionTouchMode.1

            /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$updateSelectionTouchMode$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: SelectionGestures.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt$updateSelectionTouchMode$1$1", f = "SelectionGestures.kt", i = {0}, l = {Imgproc.COLOR_YUV2RGBA_NV12}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope"}, s = {"L$0"}, v = 1)
            static final class C00511 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Function1<Boolean, Unit> $updateTouchMode;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C00511(Function1<? super Boolean, Unit> function1, Continuation<? super C00511> continuation) {
                    super(2, continuation);
                    this.$updateTouchMode = function1;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C00511 c00511 = new C00511(this.$updateTouchMode, continuation);
                    c00511.L$0 = obj;
                    return c00511;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                    return ((C00511) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Removed duplicated region for block: B:11:0x0032 A[RETURN] */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0030 -> B:12:0x0033). Please report as a decompilation issue!!! */
                /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                    jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
                    	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                    	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                    	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                    */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r5) {
                    /*
                        r4 = this;
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r1 = r4.label
                        r2 = 1
                        if (r1 == 0) goto L1b
                        if (r1 != r2) goto L13
                        java.lang.Object r1 = r4.L$0
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                        kotlin.ResultKt.throwOnFailure(r5)
                        goto L33
                    L13:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r5)
                        throw r4
                    L1b:
                        kotlin.ResultKt.throwOnFailure(r5)
                        java.lang.Object r5 = r4.L$0
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
                        r1 = r5
                    L23:
                        androidx.compose.ui.input.pointer.PointerEventPass r5 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
                        r3 = r4
                        kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                        r4.L$0 = r1
                        r4.label = r2
                        java.lang.Object r5 = r1.awaitPointerEvent(r5, r3)
                        if (r5 != r0) goto L33
                        return r0
                    L33:
                        androidx.compose.ui.input.pointer.PointerEvent r5 = (androidx.compose.ui.input.pointer.PointerEvent) r5
                        kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> r3 = r4.$updateTouchMode
                        boolean r5 = androidx.compose.foundation.text.selection.SelectionGestures_androidKt.isMouseOrTouchPad(r5)
                        r5 = r5 ^ r2
                        java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
                        r3.invoke(r5)
                        goto L23
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionGesturesKt.C04111.C00511.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                Object objAwaitPointerEventScope = pointerInputScope.awaitPointerEventScope(new C00511(function1, null), continuation);
                return objAwaitPointerEventScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitPointerEventScope : Unit.INSTANCE;
            }
        });
    }
}
