package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.TransformEvent;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventType;
import androidx.compose.ui.input.pointer.PointerEvent_androidKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.app.NotificationCompat;
import androidx.media3.muxer.MuxerUtil;
import com.appsflyer.AppsFlyerProperties;
import com.facebook.internal.ServerProtocol;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelResult;
import org.opencv.imgcodecs.Imgcodecs;

/* JADX INFO: compiled from: Transformable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u001a:\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\b2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u001a(\u0010\f\u001a\u00020\r*\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010\u0014\u001a\u001a\u0010\u0015\u001a\u00020\t*\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010\u0017\u001a\u001c\u0010\u0018\u001a\u0004\u0018\u00010\t*\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010\u0017\u001a<\u0010\u0019\u001a\u00020\r*\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\bH\u0082@¢\u0006\u0002\u0010\u001b\"\u000e\u0010\n\u001a\u00020\u000bX\u0080T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"transformable", "Landroidx/compose/ui/Modifier;", ServerProtocol.DIALOG_PARAM_STATE, "Landroidx/compose/foundation/gestures/TransformableState;", "lockRotationOnZoomPan", "", "enabled", "canPan", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "SCROLL_FACTOR", "", "detectZoomByCtrlMouseScroll", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", AppsFlyerProperties.CHANNEL, "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/gestures/TransformEvent;", "scrollConfig", "Landroidx/compose/foundation/gestures/ScrollConfig;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlinx/coroutines/channels/Channel;Landroidx/compose/foundation/gestures/ScrollConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirstCtrlMouseScroll", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/foundation/gestures/ScrollConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitCtrlMouseScrollOrNull", "detectZoom", "panZoomLock", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;ZLkotlinx/coroutines/channels/Channel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TransformableKt {
    public static final float SCROLL_FACTOR = 545.0f;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableKt$awaitCtrlMouseScrollOrNull$1, reason: invalid class name */
    /* JADX INFO: compiled from: Transformable.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableKt", f = "Transformable.kt", i = {0, 0}, l = {312}, m = "awaitCtrlMouseScrollOrNull", n = {"$this$awaitCtrlMouseScrollOrNull", "scrollConfig"}, s = {"L$0", "L$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TransformableKt.awaitCtrlMouseScrollOrNull(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableKt$awaitFirstCtrlMouseScroll$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Transformable.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableKt", f = "Transformable.kt", i = {0, 0}, l = {299}, m = "awaitFirstCtrlMouseScroll", n = {"$this$awaitFirstCtrlMouseScroll", "scrollConfig"}, s = {"L$0", "L$1"}, v = 1)
    static final class C03491 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C03491(Continuation<? super C03491> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TransformableKt.awaitFirstCtrlMouseScroll(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableKt$detectZoom$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Transformable.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableKt", f = "Transformable.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {337, 339, 385}, m = "detectZoom", n = {"$this$detectZoom", AppsFlyerProperties.CHANNEL, "canPan", "panZoomLock", Key.ROTATION, "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom", "$this$detectZoom", AppsFlyerProperties.CHANNEL, "canPan", "panZoomLock", Key.ROTATION, "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom", "$this$detectZoom", AppsFlyerProperties.CHANNEL, "canPan", NotificationCompat.CATEGORY_EVENT, "panZoomLock", Key.ROTATION, "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom", "canceled"}, s = {"L$0", "L$1", "L$2", "Z$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1", "L$0", "L$1", "L$2", "Z$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1", "L$0", "L$1", "L$2", "L$3", "Z$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1", "I$2"}, v = 1)
    static final class C03501 extends ContinuationImpl {
        float F$0;
        float F$1;
        float F$2;
        int I$0;
        int I$1;
        int I$2;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C03501(Continuation<? super C03501> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TransformableKt.detectZoom(null, false, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableKt$detectZoomByCtrlMouseScroll$2, reason: invalid class name */
    /* JADX INFO: compiled from: Transformable.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableKt$detectZoomByCtrlMouseScroll$2", f = "Transformable.kt", i = {0, 1}, l = {Imgcodecs.IMWRITE_JPEG2000_COMPRESSION_X1000, 284}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope", "$this$awaitPointerEventScope"}, s = {"L$0", "L$0"}, v = 1)
    static final class AnonymousClass2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Channel<TransformEvent> $channel;
        final /* synthetic */ CoroutineContext $currentContext;
        final /* synthetic */ ScrollConfig $scrollConfig;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(CoroutineContext coroutineContext, ScrollConfig scrollConfig, Channel<TransformEvent> channel, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$currentContext = coroutineContext;
            this.$scrollConfig = scrollConfig;
            this.$channel = channel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$currentContext, this.$scrollConfig, this.$channel, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x008e, code lost:
        
            if (r13 == r0) goto L25;
         */
        /* JADX WARN: Removed duplicated region for block: B:19:0x003b A[Catch: all -> 0x0027, TRY_ENTER, TryCatch #0 {all -> 0x0027, blocks: (B:7:0x0012, B:26:0x0091, B:28:0x0095, B:23:0x0058, B:19:0x003b, B:22:0x004b, B:12:0x0023), top: B:35:0x0008 }] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00aa  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x008e -> B:26:0x0091). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            AwaitPointerEventScope awaitPointerEventScope;
            long jM6090unboximpl;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                    if (JobKt.isActive(this.$currentContext)) {
                    }
                } else if (i == 1) {
                    awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    jM6090unboximpl = ((Offset) obj).m6090unboximpl();
                    this.$channel.mo12955trySendJP2dKIU(TransformEvent.TransformStarted.INSTANCE);
                    this.$channel.mo12955trySendJP2dKIU(new TransformEvent.TransformDelta((float) Math.pow(2.0d, Float.intBitsToFloat((int) (jM6090unboximpl & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) / 545.0f), Offset.INSTANCE.m6096getZeroF1C5BW0(), 0.0f, null));
                    this.L$0 = awaitPointerEventScope;
                    this.label = 2;
                    obj = TransformableKt.awaitCtrlMouseScrollOrNull(awaitPointerEventScope, this.$scrollConfig, this);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    Offset offset = (Offset) obj;
                    if (offset != null) {
                        jM6090unboximpl = offset.m6090unboximpl();
                        this.$channel.mo12955trySendJP2dKIU(new TransformEvent.TransformDelta((float) Math.pow(2.0d, Float.intBitsToFloat((int) (jM6090unboximpl & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) / 545.0f), Offset.INSTANCE.m6096getZeroF1C5BW0(), 0.0f, null));
                        this.L$0 = awaitPointerEventScope;
                        this.label = 2;
                        obj = TransformableKt.awaitCtrlMouseScrollOrNull(awaitPointerEventScope, this.$scrollConfig, this);
                    } else {
                        this.$channel.mo12955trySendJP2dKIU(TransformEvent.TransformStopped.INSTANCE);
                        if (JobKt.isActive(this.$currentContext)) {
                            return Unit.INSTANCE;
                        }
                        this.L$0 = awaitPointerEventScope;
                        this.label = 1;
                        obj = TransformableKt.awaitFirstCtrlMouseScroll(awaitPointerEventScope, this.$scrollConfig, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        jM6090unboximpl = ((Offset) obj).m6090unboximpl();
                        this.$channel.mo12955trySendJP2dKIU(TransformEvent.TransformStarted.INSTANCE);
                        this.$channel.mo12955trySendJP2dKIU(new TransformEvent.TransformDelta((float) Math.pow(2.0d, Float.intBitsToFloat((int) (jM6090unboximpl & MuxerUtil.UNSIGNED_INT_MAX_VALUE)) / 545.0f), Offset.INSTANCE.m6096getZeroF1C5BW0(), 0.0f, null));
                        this.L$0 = awaitPointerEventScope;
                        this.label = 2;
                        obj = TransformableKt.awaitCtrlMouseScrollOrNull(awaitPointerEventScope, this.$scrollConfig, this);
                    }
                }
            } catch (Throwable th) {
                this.$channel.mo12955trySendJP2dKIU(TransformEvent.TransformStopped.INSTANCE);
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object awaitCtrlMouseScrollOrNull(AwaitPointerEventScope awaitPointerEventScope, ScrollConfig scrollConfig, Continuation<? super Offset> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object objAwaitPointerEvent$default = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAwaitPointerEvent$default);
            anonymousClass1.L$0 = awaitPointerEventScope;
            anonymousClass1.L$1 = scrollConfig;
            anonymousClass1.label = 1;
            objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, anonymousClass1, 1, null);
            if (objAwaitPointerEvent$default == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            scrollConfig = (ScrollConfig) anonymousClass1.L$1;
            awaitPointerEventScope = (AwaitPointerEventScope) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objAwaitPointerEvent$default);
        }
        PointerEvent pointerEvent = (PointerEvent) objAwaitPointerEvent$default;
        if (!PointerEvent_androidKt.m7605isCtrlPressed5xRPYO0(pointerEvent.getKeyboardModifiers()) || !PointerEventType.m7587equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m7596getScroll7fucELk())) {
            return null;
        }
        long jMo1645calculateMouseWheelScroll8xgXZGE = scrollConfig.mo1645calculateMouseWheelScroll8xgXZGE(awaitPointerEventScope, pointerEvent, awaitPointerEventScope.mo7534getSizeYbymL2g());
        if (Offset.m6077equalsimpl0(jMo1645calculateMouseWheelScroll8xgXZGE, Offset.INSTANCE.m6096getZeroF1C5BW0())) {
            return null;
        }
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        for (int i2 = 0; i2 < size; i2++) {
            changes.get(i2).consume();
        }
        return Offset.m6069boximpl(jMo1645calculateMouseWheelScroll8xgXZGE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0051 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004a -> B:18:0x004d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final java.lang.Object awaitFirstCtrlMouseScroll(androidx.compose.ui.input.pointer.AwaitPointerEventScope r5, androidx.compose.foundation.gestures.ScrollConfig r6, kotlin.coroutines.Continuation<? super androidx.compose.ui.geometry.Offset> r7) {
        /*
            boolean r0 = r7 instanceof androidx.compose.foundation.gestures.TransformableKt.C03491
            if (r0 == 0) goto L14
            r0 = r7
            androidx.compose.foundation.gestures.TransformableKt$awaitFirstCtrlMouseScroll$1 r0 = (androidx.compose.foundation.gestures.TransformableKt.C03491) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            androidx.compose.foundation.gestures.TransformableKt$awaitFirstCtrlMouseScroll$1 r0 = new androidx.compose.foundation.gestures.TransformableKt$awaitFirstCtrlMouseScroll$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r5 = r0.L$1
            androidx.compose.foundation.gestures.ScrollConfig r5 = (androidx.compose.foundation.gestures.ScrollConfig) r5
            java.lang.Object r6 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r6 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r6
            kotlin.ResultKt.throwOnFailure(r7)
            r4 = r6
            r6 = r5
            r5 = r4
            goto L4d
        L35:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3d:
            kotlin.ResultKt.throwOnFailure(r7)
        L40:
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r7 = awaitCtrlMouseScrollOrNull(r5, r6, r0)
            if (r7 != r1) goto L4d
            return r1
        L4d:
            androidx.compose.ui.geometry.Offset r7 = (androidx.compose.ui.geometry.Offset) r7
            if (r7 == 0) goto L40
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableKt.awaitFirstCtrlMouseScroll(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.foundation.gestures.ScrollConfig, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x02c8, code lost:
    
        if (r6 != 0) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x02ca, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x02cf A[EDGE_INSN: B:100:0x02cf->B:89:0x02cf BREAK  A[LOOP:0: B:83:0x02ba->B:88:0x02cc], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x014a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02e2  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x029a -> B:82:0x02a9). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object detectZoom(AwaitPointerEventScope awaitPointerEventScope, boolean z, Channel<TransformEvent> channel, Function1<? super Offset, Boolean> function1, Continuation<? super Unit> continuation) {
        C03501 c03501;
        Channel<TransformEvent> channel2;
        Function1<? super Offset, Boolean> function12;
        boolean z2;
        float f;
        long j;
        int i;
        int i2;
        float f2;
        float f3;
        AwaitPointerEventScope awaitPointerEventScope2;
        Function1<? super Offset, Boolean> function13;
        AwaitPointerEventScope awaitPointerEventScope3;
        int size;
        int i3;
        int i4;
        int i5;
        float f4;
        long j2;
        int i6;
        float f5;
        Object objAwaitPointerEvent;
        float f6;
        int i7;
        float f7;
        AwaitPointerEventScope awaitPointerEventScope4;
        PointerEvent pointerEvent;
        float f8;
        long j3;
        int i8;
        float f9;
        int i9;
        float f10;
        int size2;
        int i10;
        int size3;
        int i11;
        int size4;
        int i12;
        if (continuation instanceof C03501) {
            c03501 = (C03501) continuation;
            if ((c03501.label & Integer.MIN_VALUE) != 0) {
                c03501.label -= Integer.MIN_VALUE;
            } else {
                c03501 = new C03501(continuation);
            }
        }
        C03501 c035012 = c03501;
        Object objAwaitPointerEvent$default = c035012.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i13 = c035012.label;
        if (i13 == 0) {
            ResultKt.throwOnFailure(objAwaitPointerEvent$default);
            long jM6096getZeroF1C5BW0 = Offset.INSTANCE.m6096getZeroF1C5BW0();
            float touchSlop = awaitPointerEventScope.getViewConfiguration().getTouchSlop();
            c035012.L$0 = awaitPointerEventScope;
            channel2 = channel;
            c035012.L$1 = channel2;
            function12 = function1;
            c035012.L$2 = function12;
            z2 = z;
            c035012.Z$0 = z2;
            c035012.F$0 = 0.0f;
            c035012.F$1 = 1.0f;
            c035012.J$0 = jM6096getZeroF1C5BW0;
            c035012.I$0 = 0;
            c035012.F$2 = touchSlop;
            c035012.I$1 = 0;
            c035012.label = 1;
            if (TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope, false, null, c035012, 2, null) != coroutine_suspended) {
                f = touchSlop;
                j = jM6096getZeroF1C5BW0;
                i = 0;
                i2 = 0;
                f2 = 1.0f;
                f3 = 0.0f;
                awaitPointerEventScope2 = awaitPointerEventScope;
            }
            return coroutine_suspended;
        }
        if (i13 != 1) {
            if (i13 != 2) {
                if (i13 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i4 = c035012.I$2;
                i7 = c035012.I$1;
                f6 = c035012.F$2;
                i6 = c035012.I$0;
                j2 = c035012.J$0;
                float f11 = c035012.F$1;
                float f12 = c035012.F$0;
                boolean z3 = c035012.Z$0;
                pointerEvent = (PointerEvent) c035012.L$3;
                Function1<? super Offset, Boolean> function14 = (Function1) c035012.L$2;
                channel2 = (Channel) c035012.L$1;
                AwaitPointerEventScope awaitPointerEventScope5 = (AwaitPointerEventScope) c035012.L$0;
                ResultKt.throwOnFailure(objAwaitPointerEvent$default);
                f2 = f11;
                f7 = f12;
                awaitPointerEventScope4 = awaitPointerEventScope5;
                function12 = function14;
                z2 = z3;
                objAwaitPointerEvent = objAwaitPointerEvent$default;
                List<PointerInputChange> changes = ((PointerEvent) objAwaitPointerEvent).getChanges();
                size3 = changes.size();
                Object obj = coroutine_suspended;
                i11 = 0;
                while (true) {
                    if (i11 >= size3) {
                        break;
                    }
                    if (changes.get(i11).isConsumed()) {
                        break;
                    }
                    i11++;
                }
                boolean z4 = false;
                if (i4 == 0 && !z4) {
                    List<PointerInputChange> changes2 = pointerEvent.getChanges();
                    size4 = changes2.size();
                    for (i12 = 0; i12 < size4; i12++) {
                        if (changes2.get(i12).getPressed()) {
                            i = i7;
                            f = f6;
                            i2 = i6;
                            f3 = f7;
                            j = j2;
                            awaitPointerEventScope2 = awaitPointerEventScope4;
                            coroutine_suspended = obj;
                        }
                    }
                }
                return Unit.INSTANCE;
            }
            i = c035012.I$1;
            f = c035012.F$2;
            i2 = c035012.I$0;
            j = c035012.J$0;
            f2 = c035012.F$1;
            f3 = c035012.F$0;
            boolean z5 = c035012.Z$0;
            Function1<? super Offset, Boolean> function15 = (Function1) c035012.L$2;
            Channel<TransformEvent> channel3 = (Channel) c035012.L$1;
            AwaitPointerEventScope awaitPointerEventScope6 = (AwaitPointerEventScope) c035012.L$0;
            ResultKt.throwOnFailure(objAwaitPointerEvent$default);
            z2 = z5;
            channel2 = channel3;
            function13 = function15;
            awaitPointerEventScope3 = awaitPointerEventScope6;
            PointerEvent pointerEvent2 = (PointerEvent) objAwaitPointerEvent$default;
            List<PointerInputChange> changes3 = pointerEvent2.getChanges();
            size = changes3.size();
            int i14 = i;
            i3 = 0;
            while (true) {
                if (i3 >= size) {
                    i4 = 0;
                    break;
                }
                if (changes3.get(i3).isConsumed()) {
                    i4 = 1;
                    break;
                }
                i3++;
            }
            if (i4 != 0) {
                float fCalculateZoom = TransformGestureDetectorKt.calculateZoom(pointerEvent2);
                float fCalculateRotation = TransformGestureDetectorKt.calculateRotation(pointerEvent2);
                float f13 = f2;
                float f14 = f3;
                long jCalculatePan = TransformGestureDetectorKt.calculatePan(pointerEvent2);
                if (i2 == 0) {
                    f8 = f13 * fCalculateZoom;
                    float f15 = f14 + fCalculateRotation;
                    long jM6085plusMKHz9U = Offset.m6085plusMKHz9U(j, jCalculatePan);
                    int i15 = i2;
                    float fCalculateCentroidSize = TransformGestureDetectorKt.calculateCentroidSize(pointerEvent2, false);
                    float fAbs = Math.abs(1.0f - f8) * fCalculateCentroidSize;
                    float fAbs2 = Math.abs(((3.1415927f * f15) * fCalculateCentroidSize) / 180.0f);
                    float fM6078getDistanceimpl = Offset.m6078getDistanceimpl(jM6085plusMKHz9U);
                    if (fAbs > f || fAbs2 > f || (fM6078getDistanceimpl > f && function13.invoke(Offset.m6069boximpl(jCalculatePan)).booleanValue())) {
                        int i16 = (!z2 || fAbs2 >= f) ? 0 : 1;
                        channel2.mo12955trySendJP2dKIU(TransformEvent.TransformStarted.INSTANCE);
                        f9 = f15;
                        j3 = jM6085plusMKHz9U;
                        i5 = i16;
                        i8 = 1;
                    } else {
                        f9 = f15;
                        j3 = jM6085plusMKHz9U;
                        i5 = i14;
                        i8 = i15;
                    }
                } else {
                    int i17 = i2;
                    i5 = i14;
                    f8 = f13;
                    j3 = j;
                    i8 = i17;
                    f9 = f14;
                }
                if (i8 == 0) {
                    i9 = i8;
                    f10 = f9;
                } else {
                    float f16 = i5 != 0 ? 0.0f : fCalculateRotation;
                    if (f16 == 0.0f && fCalculateZoom == 1.0f) {
                        i9 = i8;
                        f10 = f9;
                        if (!Offset.m6077equalsimpl0(jCalculatePan, Offset.INSTANCE.m6096getZeroF1C5BW0()) && function13.invoke(Offset.m6069boximpl(jCalculatePan)).booleanValue()) {
                        }
                        List<PointerInputChange> changes4 = pointerEvent2.getChanges();
                        size2 = changes4.size();
                        for (i10 = 0; i10 < size2; i10++) {
                            PointerInputChange pointerInputChange = changes4.get(i10);
                            if (PointerEventKt.positionChanged(pointerInputChange)) {
                                pointerInputChange.consume();
                            }
                        }
                    } else {
                        i9 = i8;
                        f10 = f9;
                    }
                    channel2.mo12955trySendJP2dKIU(new TransformEvent.TransformDelta(fCalculateZoom, jCalculatePan, f16, null));
                    List<PointerInputChange> changes42 = pointerEvent2.getChanges();
                    size2 = changes42.size();
                    while (i10 < size2) {
                    }
                }
                i6 = i9;
                f4 = f10;
                f5 = f8;
                j2 = j3;
            } else {
                int i18 = i2;
                float f17 = f2;
                ChannelResult.m12969boximpl(channel2.mo12955trySendJP2dKIU(TransformEvent.TransformStopped.INSTANCE));
                i5 = i14;
                f4 = f3;
                j2 = j;
                i6 = i18;
                f5 = f17;
            }
            PointerEventPass pointerEventPass = PointerEventPass.Final;
            c035012.L$0 = awaitPointerEventScope3;
            c035012.L$1 = channel2;
            c035012.L$2 = function13;
            c035012.L$3 = pointerEvent2;
            c035012.Z$0 = z2;
            c035012.F$0 = f4;
            c035012.F$1 = f5;
            c035012.J$0 = j2;
            c035012.I$0 = i6;
            c035012.F$2 = f;
            c035012.I$1 = i5;
            c035012.I$2 = i4;
            c035012.label = 3;
            objAwaitPointerEvent = awaitPointerEventScope3.awaitPointerEvent(pointerEventPass, c035012);
            if (objAwaitPointerEvent != coroutine_suspended) {
                int i19 = i5;
                f6 = f;
                i7 = i19;
                float f18 = f4;
                f2 = f5;
                f7 = f18;
                awaitPointerEventScope4 = awaitPointerEventScope3;
                function12 = function13;
                pointerEvent = pointerEvent2;
                List<PointerInputChange> changes5 = ((PointerEvent) objAwaitPointerEvent).getChanges();
                size3 = changes5.size();
                Object obj2 = coroutine_suspended;
                i11 = 0;
                while (true) {
                    if (i11 >= size3) {
                    }
                    i11++;
                }
                boolean z42 = false;
                if (i4 == 0) {
                    List<PointerInputChange> changes22 = pointerEvent.getChanges();
                    size4 = changes22.size();
                    while (i12 < size4) {
                    }
                }
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        }
        i = c035012.I$1;
        f = c035012.F$2;
        i2 = c035012.I$0;
        j = c035012.J$0;
        f2 = c035012.F$1;
        f3 = c035012.F$0;
        boolean z6 = c035012.Z$0;
        function12 = (Function1) c035012.L$2;
        Channel<TransformEvent> channel4 = (Channel) c035012.L$1;
        awaitPointerEventScope2 = (AwaitPointerEventScope) c035012.L$0;
        ResultKt.throwOnFailure(objAwaitPointerEvent$default);
        z2 = z6;
        channel2 = channel4;
        c035012.L$0 = awaitPointerEventScope2;
        c035012.L$1 = channel2;
        c035012.L$2 = function12;
        c035012.L$3 = null;
        c035012.Z$0 = z2;
        c035012.F$0 = f3;
        c035012.F$1 = f2;
        c035012.J$0 = j;
        c035012.I$0 = i2;
        c035012.F$2 = f;
        c035012.I$1 = i;
        c035012.label = 2;
        objAwaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, c035012, 1, null);
        if (objAwaitPointerEvent$default != coroutine_suspended) {
            AwaitPointerEventScope awaitPointerEventScope7 = awaitPointerEventScope2;
            function13 = function12;
            awaitPointerEventScope3 = awaitPointerEventScope7;
            PointerEvent pointerEvent22 = (PointerEvent) objAwaitPointerEvent$default;
            List<PointerInputChange> changes32 = pointerEvent22.getChanges();
            size = changes32.size();
            int i142 = i;
            i3 = 0;
            while (true) {
                if (i3 >= size) {
                }
                i3++;
            }
            if (i4 != 0) {
            }
            PointerEventPass pointerEventPass2 = PointerEventPass.Final;
            c035012.L$0 = awaitPointerEventScope3;
            c035012.L$1 = channel2;
            c035012.L$2 = function13;
            c035012.L$3 = pointerEvent22;
            c035012.Z$0 = z2;
            c035012.F$0 = f4;
            c035012.F$1 = f5;
            c035012.J$0 = j2;
            c035012.I$0 = i6;
            c035012.F$2 = f;
            c035012.I$1 = i5;
            c035012.I$2 = i4;
            c035012.label = 3;
            objAwaitPointerEvent = awaitPointerEventScope3.awaitPointerEvent(pointerEventPass2, c035012);
            if (objAwaitPointerEvent != coroutine_suspended) {
            }
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object detectZoomByCtrlMouseScroll(PointerInputScope pointerInputScope, Channel<TransformEvent> channel, ScrollConfig scrollConfig, Continuation<? super Unit> continuation) {
        Object objAwaitPointerEventScope = pointerInputScope.awaitPointerEventScope(new AnonymousClass2(continuation.get$context(), scrollConfig, channel, null), continuation);
        return objAwaitPointerEventScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitPointerEventScope : Unit.INSTANCE;
    }

    public static final Modifier transformable(Modifier modifier, TransformableState transformableState, Function1<? super Offset, Boolean> function1, boolean z, boolean z2) {
        return modifier.then(new TransformableElement(transformableState, function1, z, z2));
    }

    public static final Modifier transformable(Modifier modifier, TransformableState transformableState, boolean z, boolean z2) {
        return transformable(modifier, transformableState, new Function1() { // from class: androidx.compose.foundation.gestures.TransformableKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(TransformableKt.transformable$lambda$0((Offset) obj));
            }
        }, z, z2);
    }

    public static /* synthetic */ Modifier transformable$default(Modifier modifier, TransformableState transformableState, Function1 function1, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            z2 = true;
        }
        return transformable(modifier, transformableState, function1, z, z2);
    }

    public static /* synthetic */ Modifier transformable$default(Modifier modifier, TransformableState transformableState, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        return transformable(modifier, transformableState, z, z2);
    }

    static final boolean transformable$lambda$0(Offset offset) {
        return true;
    }
}
