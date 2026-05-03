package androidx.camera.camera2.pipe;

import androidx.camera.camera2.pipe.Frame;
import androidx.camera.camera2.pipe.core.AutoCloseables;
import androidx.media3.muxer.AacWriter$$ExternalSyntheticBackport0;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;

/* JADX INFO: compiled from: Frame.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00132\u00060\u0001j\u0002`\u0002:\u0001\u0013J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fH¦@¢\u0006\u0002\u0010\rJ\n\u0010\u000e\u001a\u0004\u0018\u00010\fH&J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/FrameCapture;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "request", "Landroidx/camera/camera2/pipe/Request;", "getRequest", "()Landroidx/camera/camera2/pipe/Request;", "status", "Landroidx/camera/camera2/pipe/OutputStatus;", "getStatus-U7r42EA", "()I", "awaitFrame", "Landroidx/camera/camera2/pipe/Frame;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFrame", "addListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroidx/camera/camera2/pipe/Frame$Listener;", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface FrameCapture extends AutoCloseable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: Frame.kt */
    @kotlin.Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\tH\u0086\bø\u0001\u0000J0\u0010\n\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00070\u00062\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u000bH\u0086\bø\u0001\u0000J.\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e*\u00020\u00072\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u0002H\u000e0\tH\u0086H¢\u0006\u0002\u0010\u0010J.\u0010\u0011\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00070\u00062\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u00050\tH\u0086H¢\u0006\u0002\u0010\u0012J4\u0010\u0013\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00070\u00062\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u00050\u000bH\u0086H¢\u0006\u0002\u0010\u0014Je\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\u00160\u0006\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0017\u001a\u00020\u001821\b\u0004\u0010\b\u001a+\b\u0001\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019¢\u0006\u0002\b\u001bH\u0086H¢\u0006\u0002\u0010\u001cJk\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\u00160\u0006\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0017\u001a\u00020\u001827\b\u0004\u0010\b\u001a1\b\u0001\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001e¢\u0006\u0002\b\u001bH\u0086H¢\u0006\u0002\u0010\u001f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006 "}, d2 = {"Landroidx/camera/camera2/pipe/FrameCapture$Companion;", "", "<init>", "()V", "useEach", "", "", "Landroidx/camera/camera2/pipe/FrameCapture;", NativeProtocol.WEB_DIALOG_ACTION, "Lkotlin/Function1;", "useEachIndexed", "Lkotlin/Function2;", "", "useFrame", "R", "Landroidx/camera/camera2/pipe/Frame;", "(Landroidx/camera/camera2/pipe/FrameCapture;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "useEachFrame", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "useEachFrameIndexed", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "useEachFrameAsync", "Lkotlinx/coroutines/Deferred;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Ljava/util/List;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "useEachFrameIndexedAsync", "Lkotlin/Function4;", "(Ljava/util/List;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function4;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        private final Object useEachFrame$$forInline(List<? extends FrameCapture> list, Function1<? super Frame, Unit> function1, Continuation<? super Unit> continuation) {
            AutoCloseables autoCloseables = AutoCloseables.INSTANCE;
            Ref.IntRef intRef = new Ref.IntRef();
            while (intRef.element < list.size()) {
                try {
                    FrameCapture frameCapture = list.get(intRef.element);
                    try {
                        int i = intRef.element;
                        intRef.element = i + 1;
                        Integer.valueOf(i).intValue();
                        FrameCapture frameCapture2 = frameCapture;
                        frameCapture = (AutoCloseable) frameCapture2.awaitFrame(null);
                        try {
                            frameCapture2.close();
                            function1.invoke((Frame) frameCapture);
                            Unit unit = Unit.INSTANCE;
                            AutoCloseableKt.closeFinally(frameCapture, null);
                            Unit unit2 = Unit.INSTANCE;
                            Unit unit3 = Unit.INSTANCE;
                            Unit unit4 = Unit.INSTANCE;
                            AutoCloseableKt.closeFinally(frameCapture, null);
                        } finally {
                        }
                    } finally {
                    }
                } finally {
                }
            }
            while (intRef.element < list.size()) {
                try {
                    int i2 = intRef.element;
                    intRef.element = i2 + 1;
                    AacWriter$$ExternalSyntheticBackport0.m9753m((Object) list.get(i2));
                    Unit unit5 = Unit.INSTANCE;
                } catch (Throwable unused) {
                }
            }
            return Unit.INSTANCE;
        }

        private final <R> Object useEachFrameAsync$$forInline(List<? extends FrameCapture> list, CoroutineScope coroutineScope, Function3<? super CoroutineScope, ? super Frame, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super List<? extends Deferred<? extends R>>> continuation) {
            AutoCloseables autoCloseables = AutoCloseables.INSTANCE;
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            int i = 0;
            while (i < size) {
                FrameCapture frameCapture = list.get(i);
                CoroutineScope coroutineScope2 = coroutineScope;
                arrayList.add(BuildersKt__Builders_commonKt.async$default(coroutineScope2, null, CoroutineStart.UNDISPATCHED, new FrameCapture$Companion$useEachFrameAsync$$inlined$useEachFrameIndexedAsync$1(frameCapture, i, null, function3), 1, null));
                i++;
                coroutineScope = coroutineScope2;
            }
            return arrayList;
        }

        private final Object useEachFrameIndexed$$forInline(List<? extends FrameCapture> list, Function2<? super Integer, ? super Frame, Unit> function2, Continuation<? super Unit> continuation) {
            AutoCloseables autoCloseables = AutoCloseables.INSTANCE;
            Ref.IntRef intRef = new Ref.IntRef();
            while (intRef.element < list.size()) {
                try {
                    FrameCapture frameCapture = list.get(intRef.element);
                    try {
                        int i = intRef.element;
                        intRef.element = i + 1;
                        FrameCapture frameCapture2 = frameCapture;
                        int iIntValue = Integer.valueOf(i).intValue();
                        frameCapture = (AutoCloseable) frameCapture2.awaitFrame(null);
                        try {
                            frameCapture2.close();
                            function2.invoke(Integer.valueOf(iIntValue), (Frame) frameCapture);
                            Unit unit = Unit.INSTANCE;
                            AutoCloseableKt.closeFinally(frameCapture, null);
                            Unit unit2 = Unit.INSTANCE;
                            Unit unit3 = Unit.INSTANCE;
                            AutoCloseableKt.closeFinally(frameCapture, null);
                        } finally {
                        }
                    } finally {
                    }
                } finally {
                }
            }
            while (intRef.element < list.size()) {
                try {
                    int i2 = intRef.element;
                    intRef.element = i2 + 1;
                    AacWriter$$ExternalSyntheticBackport0.m9753m((Object) list.get(i2));
                    Unit unit4 = Unit.INSTANCE;
                } catch (Throwable unused) {
                }
            }
            return Unit.INSTANCE;
        }

        private final <R> Object useEachFrameIndexedAsync$$forInline(List<? extends FrameCapture> list, CoroutineScope coroutineScope, Function4<? super CoroutineScope, ? super Integer, ? super Frame, ? super Continuation<? super R>, ? extends Object> function4, Continuation<? super List<? extends Deferred<? extends R>>> continuation) {
            AutoCloseables autoCloseables = AutoCloseables.INSTANCE;
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            int i = 0;
            while (i < size) {
                FrameCapture frameCapture = list.get(i);
                CoroutineScope coroutineScope2 = coroutineScope;
                arrayList.add(BuildersKt__Builders_commonKt.async$default(coroutineScope2, null, CoroutineStart.UNDISPATCHED, new FrameCapture$Companion$useEachFrameIndexedAsync$$inlined$useEachIndexedAsync$1(frameCapture, i, null, function4), 1, null));
                i++;
                coroutineScope = coroutineScope2;
            }
            return arrayList;
        }

        private final <R> Object useFrame$$forInline(FrameCapture frameCapture, Function1<? super Frame, ? extends R> function1, Continuation<? super R> continuation) throws Exception {
            FrameCapture frameCapture2 = frameCapture;
            try {
                FrameCapture frameCapture3 = frameCapture2;
                frameCapture2 = (AutoCloseable) frameCapture3.awaitFrame(null);
                try {
                    frameCapture3.close();
                    R rInvoke = function1.invoke((Frame) frameCapture2);
                    AutoCloseableKt.closeFinally(frameCapture2, null);
                    AutoCloseableKt.closeFinally(frameCapture2, null);
                    return rInvoke;
                } finally {
                }
            } finally {
            }
        }

        public final void useEach(List<? extends FrameCapture> list, Function1<? super FrameCapture, Unit> action) {
            Intrinsics.checkNotNullParameter(list, "<this>");
            Intrinsics.checkNotNullParameter(action, "action");
            AutoCloseables autoCloseables = AutoCloseables.INSTANCE;
            int i = 0;
            while (i < list.size()) {
                try {
                    FrameCapture frameCapture = list.get(i);
                    i++;
                    try {
                        action.invoke(frameCapture);
                        Unit unit = Unit.INSTANCE;
                        AutoCloseableKt.closeFinally(frameCapture, null);
                    } finally {
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        while (i < list.size()) {
                            int i2 = i + 1;
                            try {
                                AacWriter$$ExternalSyntheticBackport0.m9753m((Object) list.get(i));
                            } catch (Throwable th3) {
                                ExceptionsKt.addSuppressed(th, th3);
                            }
                            i = i2;
                        }
                        throw th2;
                    }
                }
            }
            while (i < list.size()) {
                int i3 = i + 1;
                try {
                    AacWriter$$ExternalSyntheticBackport0.m9753m((Object) list.get(i));
                } catch (Throwable unused) {
                }
                i = i3;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0064 A[Catch: all -> 0x00e5, TRY_LEAVE, TryCatch #3 {all -> 0x00e5, blocks: (B:19:0x005c, B:21:0x0064), top: B:72:0x005c }] */
        /* JADX WARN: Removed duplicated region for block: B:48:0x00c3 A[LOOP:1: B:48:0x00c3->B:96:0x00c3, LOOP_START] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0087 -> B:71:0x008e). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object useEachFrame(List<? extends FrameCapture> list, Function1<? super Frame, Unit> function1, Continuation<? super Unit> continuation) {
            FrameCapture$Companion$useEachFrame$1 frameCapture$Companion$useEachFrame$1;
            Ref.IntRef intRef;
            Throwable th;
            Throwable th2;
            Throwable th3;
            if (continuation instanceof FrameCapture$Companion$useEachFrame$1) {
                frameCapture$Companion$useEachFrame$1 = (FrameCapture$Companion$useEachFrame$1) continuation;
                if ((frameCapture$Companion$useEachFrame$1.label & Integer.MIN_VALUE) != 0) {
                    frameCapture$Companion$useEachFrame$1.label -= Integer.MIN_VALUE;
                } else {
                    frameCapture$Companion$useEachFrame$1 = new FrameCapture$Companion$useEachFrame$1(this, continuation);
                }
            }
            Object obj = frameCapture$Companion$useEachFrame$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = frameCapture$Companion$useEachFrame$1.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AutoCloseables autoCloseables = AutoCloseables.INSTANCE;
                intRef = new Ref.IntRef();
                th = null;
                if (intRef.element < list.size()) {
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                FrameCapture frameCapture = (FrameCapture) frameCapture$Companion$useEachFrame$1.L$4;
                AutoCloseable autoCloseable = (AutoCloseable) frameCapture$Companion$useEachFrame$1.L$3;
                intRef = (Ref.IntRef) frameCapture$Companion$useEachFrame$1.L$2;
                List<? extends FrameCapture> list2 = (List) frameCapture$Companion$useEachFrame$1.L$1;
                Function1<? super Frame, Unit> function12 = (Function1) frameCapture$Companion$useEachFrame$1.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    Ref.IntRef intRef2 = intRef;
                    FrameCapture$Companion$useEachFrame$1 frameCapture$Companion$useEachFrame$12 = frameCapture$Companion$useEachFrame$1;
                    AutoCloseable autoCloseable2 = autoCloseable;
                    function1 = function12;
                    FrameCapture frameCapture2 = frameCapture;
                    Throwable th4 = null;
                    try {
                        try {
                            try {
                                try {
                                    frameCapture2.close();
                                    function1.invoke((Frame) autoCloseable);
                                    Unit unit = Unit.INSTANCE;
                                    AutoCloseableKt.closeFinally(autoCloseable2, null);
                                    if (intRef.element < list.size()) {
                                        FrameCapture frameCapture3 = list.get(intRef.element);
                                        try {
                                            intRef.element++;
                                            frameCapture2 = frameCapture3;
                                            frameCapture$Companion$useEachFrame$1.L$0 = function1;
                                            frameCapture$Companion$useEachFrame$1.L$1 = list;
                                            frameCapture$Companion$useEachFrame$1.L$2 = intRef;
                                            frameCapture$Companion$useEachFrame$1.L$3 = frameCapture3;
                                            frameCapture$Companion$useEachFrame$1.L$4 = frameCapture2;
                                            frameCapture$Companion$useEachFrame$1.label = 1;
                                            Object objAwaitFrame = frameCapture2.awaitFrame(frameCapture$Companion$useEachFrame$1);
                                            if (objAwaitFrame == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            List<? extends FrameCapture> list3 = list;
                                            th4 = th;
                                            obj = objAwaitFrame;
                                            intRef2 = intRef;
                                            frameCapture$Companion$useEachFrame$12 = frameCapture$Companion$useEachFrame$1;
                                            autoCloseable2 = frameCapture3;
                                            list2 = list3;
                                            AutoCloseable autoCloseable3 = (AutoCloseable) obj;
                                            frameCapture2.close();
                                            function1.invoke((Frame) autoCloseable3);
                                            Unit unit2 = Unit.INSTANCE;
                                            AutoCloseableKt.closeFinally(autoCloseable3, null);
                                            Unit unit3 = Unit.INSTANCE;
                                            AutoCloseableKt.closeFinally(autoCloseable2, null);
                                            th = th4;
                                            frameCapture$Companion$useEachFrame$1 = frameCapture$Companion$useEachFrame$12;
                                            list = list2;
                                            intRef = intRef2;
                                            if (intRef.element < list.size()) {
                                                while (intRef.element < list.size()) {
                                                    try {
                                                        int i2 = intRef.element;
                                                        intRef.element = i2 + 1;
                                                        AacWriter$$ExternalSyntheticBackport0.m9753m((Object) list.get(i2));
                                                    } catch (Throwable th5) {
                                                        if (th != null) {
                                                            ExceptionsKt.addSuppressed(th, th5);
                                                        }
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        } catch (Throwable th6) {
                                            th3 = th6;
                                            autoCloseable = frameCapture3;
                                            list2 = list;
                                            try {
                                                throw th3;
                                            } catch (Throwable th7) {
                                                try {
                                                    AutoCloseableKt.closeFinally(autoCloseable, th3);
                                                    throw th7;
                                                } catch (Throwable th8) {
                                                    th2 = th8;
                                                    list = list2;
                                                    try {
                                                        throw th2;
                                                    } finally {
                                                        while (intRef.element < list.size()) {
                                                            try {
                                                                int i3 = intRef.element;
                                                                intRef.element = i3 + 1;
                                                                AacWriter$$ExternalSyntheticBackport0.m9753m((Object) list.get(i3));
                                                            } catch (Throwable th9) {
                                                                ExceptionsKt.addSuppressed(th2, th9);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (Throwable th10) {
                                    th3 = th10;
                                    autoCloseable = autoCloseable2;
                                    intRef = intRef2;
                                    throw th3;
                                }
                            } catch (Throwable th11) {
                                th2 = th11;
                                throw th2;
                            }
                            th = th4;
                            frameCapture$Companion$useEachFrame$1 = frameCapture$Companion$useEachFrame$12;
                            list = list2;
                            intRef = intRef2;
                        } catch (Throwable th12) {
                            th2 = th12;
                            list = list2;
                            intRef = intRef2;
                            throw th2;
                        }
                        AutoCloseableKt.closeFinally(autoCloseable3, null);
                        Unit unit32 = Unit.INSTANCE;
                    } finally {
                    }
                    AutoCloseable autoCloseable32 = (AutoCloseable) obj;
                } catch (Throwable th13) {
                    th3 = th13;
                    throw th3;
                }
            }
        }

        public final <R> Object useEachFrameAsync(List<? extends FrameCapture> list, CoroutineScope coroutineScope, Function3<? super CoroutineScope, ? super Frame, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super List<? extends Deferred<? extends R>>> continuation) {
            AutoCloseables autoCloseables = AutoCloseables.INSTANCE;
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            int i = 0;
            while (i < size) {
                FrameCapture frameCapture = list.get(i);
                CoroutineScope coroutineScope2 = coroutineScope;
                arrayList.add(BuildersKt__Builders_commonKt.async$default(coroutineScope2, null, CoroutineStart.UNDISPATCHED, new FrameCapture$Companion$useEachFrameAsync$$inlined$useEachFrameIndexedAsync$1(frameCapture, i, null, function3), 1, null));
                i++;
                coroutineScope = coroutineScope2;
            }
            return arrayList;
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0068 A[Catch: all -> 0x00f2, TRY_LEAVE, TryCatch #1 {all -> 0x00f2, blocks: (B:19:0x0060, B:21:0x0068), top: B:68:0x0060 }] */
        /* JADX WARN: Removed duplicated region for block: B:48:0x00d0 A[LOOP:1: B:48:0x00d0->B:96:0x00d0, LOOP_START] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x008e -> B:67:0x0096). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object useEachFrameIndexed(List<? extends FrameCapture> list, Function2<? super Integer, ? super Frame, Unit> function2, Continuation<? super Unit> continuation) {
            FrameCapture$Companion$useEachFrameIndexed$1 frameCapture$Companion$useEachFrameIndexed$1;
            Ref.IntRef intRef;
            Throwable th;
            Throwable th2;
            Throwable th3;
            if (continuation instanceof FrameCapture$Companion$useEachFrameIndexed$1) {
                frameCapture$Companion$useEachFrameIndexed$1 = (FrameCapture$Companion$useEachFrameIndexed$1) continuation;
                if ((frameCapture$Companion$useEachFrameIndexed$1.label & Integer.MIN_VALUE) != 0) {
                    frameCapture$Companion$useEachFrameIndexed$1.label -= Integer.MIN_VALUE;
                } else {
                    frameCapture$Companion$useEachFrameIndexed$1 = new FrameCapture$Companion$useEachFrameIndexed$1(this, continuation);
                }
            }
            Object obj = frameCapture$Companion$useEachFrameIndexed$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = frameCapture$Companion$useEachFrameIndexed$1.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AutoCloseables autoCloseables = AutoCloseables.INSTANCE;
                intRef = new Ref.IntRef();
                th = null;
                if (intRef.element < list.size()) {
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = frameCapture$Companion$useEachFrameIndexed$1.I$0;
                FrameCapture frameCapture = (FrameCapture) frameCapture$Companion$useEachFrameIndexed$1.L$4;
                FrameCapture frameCapture2 = (AutoCloseable) frameCapture$Companion$useEachFrameIndexed$1.L$3;
                intRef = (Ref.IntRef) frameCapture$Companion$useEachFrameIndexed$1.L$2;
                List<? extends FrameCapture> list2 = (List) frameCapture$Companion$useEachFrameIndexed$1.L$1;
                Function2<? super Integer, ? super Frame, Unit> function22 = (Function2) frameCapture$Companion$useEachFrameIndexed$1.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    Ref.IntRef intRef2 = intRef;
                    AutoCloseable autoCloseable = frameCapture2;
                    FrameCapture$Companion$useEachFrameIndexed$1 frameCapture$Companion$useEachFrameIndexed$12 = frameCapture$Companion$useEachFrameIndexed$1;
                    Function2<? super Integer, ? super Frame, Unit> function23 = function22;
                    FrameCapture frameCapture3 = frameCapture;
                    List<? extends FrameCapture> list3 = list2;
                    int i3 = i2;
                    Throwable th4 = null;
                    try {
                        try {
                            try {
                                try {
                                    frameCapture3.close();
                                    function23.invoke(Boxing.boxInt(i3), (Frame) autoCloseable);
                                    Unit unit = Unit.INSTANCE;
                                    AutoCloseableKt.closeFinally(autoCloseable, null);
                                    if (intRef.element < list.size()) {
                                        frameCapture2 = list.get(intRef.element);
                                        try {
                                            i3 = intRef.element;
                                            intRef.element = i3 + 1;
                                            frameCapture3 = frameCapture2;
                                            frameCapture$Companion$useEachFrameIndexed$1.L$0 = function2;
                                            frameCapture$Companion$useEachFrameIndexed$1.L$1 = list;
                                            frameCapture$Companion$useEachFrameIndexed$1.L$2 = intRef;
                                            frameCapture$Companion$useEachFrameIndexed$1.L$3 = frameCapture2;
                                            frameCapture$Companion$useEachFrameIndexed$1.L$4 = frameCapture3;
                                            frameCapture$Companion$useEachFrameIndexed$1.I$0 = i3;
                                            frameCapture$Companion$useEachFrameIndexed$1.label = 1;
                                            Object objAwaitFrame = frameCapture3.awaitFrame(frameCapture$Companion$useEachFrameIndexed$1);
                                            if (objAwaitFrame == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            List<? extends FrameCapture> list4 = list;
                                            th4 = th;
                                            obj = objAwaitFrame;
                                            intRef2 = intRef;
                                            autoCloseable = frameCapture2;
                                            frameCapture$Companion$useEachFrameIndexed$12 = frameCapture$Companion$useEachFrameIndexed$1;
                                            function23 = function2;
                                            list3 = list4;
                                            AutoCloseable autoCloseable2 = (AutoCloseable) obj;
                                            frameCapture3.close();
                                            function23.invoke(Boxing.boxInt(i3), (Frame) autoCloseable2);
                                            Unit unit2 = Unit.INSTANCE;
                                            AutoCloseableKt.closeFinally(autoCloseable2, null);
                                            Unit unit3 = Unit.INSTANCE;
                                            AutoCloseableKt.closeFinally(autoCloseable, null);
                                            th = th4;
                                            list = list3;
                                            function2 = function23;
                                            frameCapture$Companion$useEachFrameIndexed$1 = frameCapture$Companion$useEachFrameIndexed$12;
                                            intRef = intRef2;
                                            if (intRef.element < list.size()) {
                                                while (intRef.element < list.size()) {
                                                    try {
                                                        int i4 = intRef.element;
                                                        intRef.element = i4 + 1;
                                                        AacWriter$$ExternalSyntheticBackport0.m9753m((Object) list.get(i4));
                                                    } catch (Throwable th5) {
                                                        if (th != null) {
                                                            ExceptionsKt.addSuppressed(th, th5);
                                                        }
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        } catch (Throwable th6) {
                                            th3 = th6;
                                            list2 = list;
                                            try {
                                                throw th3;
                                            } catch (Throwable th7) {
                                                try {
                                                    AutoCloseableKt.closeFinally(frameCapture2, th3);
                                                    throw th7;
                                                } catch (Throwable th8) {
                                                    th2 = th8;
                                                    list = list2;
                                                    try {
                                                        throw th2;
                                                    } finally {
                                                        while (intRef.element < list.size()) {
                                                            try {
                                                                int i5 = intRef.element;
                                                                intRef.element = i5 + 1;
                                                                AacWriter$$ExternalSyntheticBackport0.m9753m((Object) list.get(i5));
                                                            } catch (Throwable th9) {
                                                                ExceptionsKt.addSuppressed(th2, th9);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (Throwable th10) {
                                    th3 = th10;
                                    list2 = list3;
                                    frameCapture2 = autoCloseable;
                                    intRef = intRef2;
                                    throw th3;
                                }
                            } catch (Throwable th11) {
                                th2 = th11;
                                throw th2;
                            }
                            th = th4;
                            list = list3;
                            function2 = function23;
                            frameCapture$Companion$useEachFrameIndexed$1 = frameCapture$Companion$useEachFrameIndexed$12;
                            intRef = intRef2;
                        } catch (Throwable th12) {
                            th2 = th12;
                            list = list3;
                            intRef = intRef2;
                            throw th2;
                        }
                        AutoCloseableKt.closeFinally(autoCloseable2, null);
                        Unit unit32 = Unit.INSTANCE;
                    } finally {
                    }
                    AutoCloseable autoCloseable22 = (AutoCloseable) obj;
                } catch (Throwable th13) {
                    th3 = th13;
                    throw th3;
                }
            }
        }

        public final <R> Object useEachFrameIndexedAsync(List<? extends FrameCapture> list, CoroutineScope coroutineScope, Function4<? super CoroutineScope, ? super Integer, ? super Frame, ? super Continuation<? super R>, ? extends Object> function4, Continuation<? super List<? extends Deferred<? extends R>>> continuation) {
            AutoCloseables autoCloseables = AutoCloseables.INSTANCE;
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            int i = 0;
            while (i < size) {
                FrameCapture frameCapture = list.get(i);
                CoroutineScope coroutineScope2 = coroutineScope;
                arrayList.add(BuildersKt__Builders_commonKt.async$default(coroutineScope2, null, CoroutineStart.UNDISPATCHED, new FrameCapture$Companion$useEachFrameIndexedAsync$$inlined$useEachIndexedAsync$1(frameCapture, i, null, function4), 1, null));
                i++;
                coroutineScope = coroutineScope2;
            }
            return arrayList;
        }

        public final void useEachIndexed(List<? extends FrameCapture> list, Function2<? super Integer, ? super FrameCapture, Unit> action) {
            int i;
            Throwable th;
            Intrinsics.checkNotNullParameter(list, "<this>");
            Intrinsics.checkNotNullParameter(action, "action");
            AutoCloseables autoCloseables = AutoCloseables.INSTANCE;
            int i2 = 0;
            while (i2 < list.size()) {
                try {
                    FrameCapture frameCapture = list.get(i2);
                    i = i2 + 1;
                    try {
                        action.invoke(Integer.valueOf(i2), frameCapture);
                        Unit unit = Unit.INSTANCE;
                        try {
                            AutoCloseableKt.closeFinally(frameCapture, null);
                            i2 = i;
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                throw th;
                            } finally {
                                while (i < list.size()) {
                                    int i3 = i + 1;
                                    try {
                                        AacWriter$$ExternalSyntheticBackport0.m9753m((Object) list.get(i));
                                    } catch (Throwable th3) {
                                        ExceptionsKt.addSuppressed(th, th3);
                                    }
                                    i = i3;
                                }
                            }
                        }
                    } finally {
                    }
                } catch (Throwable th4) {
                    i = i2;
                    th = th4;
                }
            }
            while (i2 < list.size()) {
                int i4 = i2 + 1;
                try {
                    AacWriter$$ExternalSyntheticBackport0.m9753m((Object) list.get(i2));
                } catch (Throwable unused) {
                }
                i2 = i4;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final <R> Object useFrame(FrameCapture frameCapture, Function1<? super Frame, ? extends R> function1, Continuation<? super R> continuation) throws Exception {
            FrameCapture$Companion$useFrame$1 frameCapture$Companion$useFrame$1;
            AutoCloseable autoCloseable;
            Throwable th;
            FrameCapture frameCapture2;
            AutoCloseable autoCloseable2;
            if (continuation instanceof FrameCapture$Companion$useFrame$1) {
                frameCapture$Companion$useFrame$1 = (FrameCapture$Companion$useFrame$1) continuation;
                if ((frameCapture$Companion$useFrame$1.label & Integer.MIN_VALUE) != 0) {
                    frameCapture$Companion$useFrame$1.label -= Integer.MIN_VALUE;
                } else {
                    frameCapture$Companion$useFrame$1 = new FrameCapture$Companion$useFrame$1(this, continuation);
                }
            }
            Object obj = frameCapture$Companion$useFrame$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = frameCapture$Companion$useFrame$1.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FrameCapture frameCapture3 = frameCapture;
                try {
                    frameCapture2 = frameCapture3;
                    frameCapture$Companion$useFrame$1.L$0 = function1;
                    frameCapture$Companion$useFrame$1.L$1 = frameCapture3;
                    frameCapture$Companion$useFrame$1.L$2 = frameCapture2;
                    frameCapture$Companion$useFrame$1.label = 1;
                    Object objAwaitFrame = frameCapture2.awaitFrame(frameCapture$Companion$useFrame$1);
                    if (objAwaitFrame == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    autoCloseable2 = frameCapture3;
                    obj = objAwaitFrame;
                    AutoCloseable autoCloseable3 = (AutoCloseable) obj;
                    frameCapture2.close();
                    R rInvoke = function1.invoke((Frame) autoCloseable3);
                    AutoCloseableKt.closeFinally(autoCloseable3, null);
                    AutoCloseableKt.closeFinally(autoCloseable2, null);
                    return rInvoke;
                } catch (Throwable th2) {
                    autoCloseable = frameCapture3;
                    th = th2;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                frameCapture2 = (FrameCapture) frameCapture$Companion$useFrame$1.L$2;
                autoCloseable = (AutoCloseable) frameCapture$Companion$useFrame$1.L$1;
                Function1<? super Frame, ? extends R> function12 = (Function1) frameCapture$Companion$useFrame$1.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    autoCloseable2 = autoCloseable;
                    function1 = function12;
                    try {
                        AutoCloseable autoCloseable32 = (AutoCloseable) obj;
                        try {
                            frameCapture2.close();
                            R rInvoke2 = function1.invoke((Frame) autoCloseable32);
                            AutoCloseableKt.closeFinally(autoCloseable32, null);
                            AutoCloseableKt.closeFinally(autoCloseable2, null);
                            return rInvoke2;
                        } finally {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        autoCloseable = autoCloseable2;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            }
            try {
                throw th;
            } catch (Throwable th5) {
                AutoCloseableKt.closeFinally(autoCloseable, th);
                throw th5;
            }
        }
    }

    void addListener(Frame.Listener listener);

    Object awaitFrame(Continuation<? super Frame> continuation);

    Frame getFrame();

    Request getRequest();

    /* JADX INFO: renamed from: getStatus-U7r42EA, reason: not valid java name */
    int mo471getStatusU7r42EA();
}
