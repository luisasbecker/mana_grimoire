package androidx.camera.camera2.impl;

import androidx.camera.camera2.adapter.CoroutineAdaptersKt;
import androidx.camera.camera2.compat.workaround.UseFlashModeTorchFor3aUpdate;
import androidx.camera.camera2.config.CameraScope;
import androidx.camera.camera2.impl.TorchControl;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.core.CameraControl;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Logger;
import androidx.media3.muxer.WebmConstants;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: compiled from: FlashControl.kt */
/* JADX INFO: loaded from: classes.dex */
@CameraScope
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001:B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u001e\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00170'2\u0006\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010,\u001a\u00020-J\b\u0010.\u001a\u00020\u0017H\u0002J\u0010\u0010/\u001a\u00020\u00172\b\u0010\"\u001a\u0004\u0018\u00010!J\u000e\u00100\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u00101J\u001c\u00102\u001a\b\u0012\u0004\u0012\u00020\u00170'2\u0006\u00103\u001a\u000204H\u0082@¢\u0006\u0002\u00105J\u0010\u00106\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010'H\u0002J\u0010\u00107\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010'H\u0002J\u000e\u00108\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u00101J\u000e\u00109\u001a\u00020\u0019H\u0086@¢\u0006\u0002\u00101R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u001a\u0010\u001bR&\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u00198F@BX\u0086\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u001b\u001a\u0004\b\u001e\u0010\u001fR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010\u0010\u001a\u0004\u0018\u00010!8F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0016\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R,\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00170'2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00170'8F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u0006;"}, d2 = {"Landroidx/camera/camera2/impl/FlashControl;", "Landroidx/camera/camera2/impl/UseCaseCameraControl;", "cameraProperties", "Landroidx/camera/camera2/impl/CameraProperties;", "state3AControl", "Landroidx/camera/camera2/impl/State3AControl;", "threads", "Landroidx/camera/camera2/impl/UseCaseThreads;", "torchControl", "Landroidx/camera/camera2/impl/TorchControl;", "useFlashModeTorchFor3aUpdate", "Landroidx/camera/camera2/compat/workaround/UseFlashModeTorchFor3aUpdate;", "<init>", "(Landroidx/camera/camera2/impl/CameraProperties;Landroidx/camera/camera2/impl/State3AControl;Landroidx/camera/camera2/impl/UseCaseThreads;Landroidx/camera/camera2/impl/TorchControl;Landroidx/camera/camera2/compat/workaround/UseFlashModeTorchFor3aUpdate;)V", "_requestControl", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "value", "requestControl", "getRequestControl", "()Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "setRequestControl", "(Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;)V", "reset", "", "_flashMode", "", "get_flashMode$annotations", "()V", "flashMode", "getFlashMode$annotations", "getFlashMode", "()I", "_screenFlash", "Landroidx/camera/core/ImageCapture$ScreenFlash;", "screenFlash", "getScreenFlash", "()Landroidx/camera/core/ImageCapture$ScreenFlash;", "_updateSignal", "Lkotlinx/coroutines/CompletableDeferred;", "Lkotlinx/coroutines/Deferred;", "updateSignal", "getUpdateSignal", "()Lkotlinx/coroutines/Deferred;", "setFlashAsync", "cancelPreviousTask", "", "stopRunningTask", "setScreenFlash", "startScreenFlashCaptureTasks", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyScreenFlash", "timeoutMillis", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setExternalFlashAeModeAsync", "setTorchForScreenFlash", "stopScreenFlashCaptureTasks", "awaitFlashModeUpdate", "Bindings", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlashControl implements UseCaseCameraControl {
    private volatile int _flashMode;
    private UseCaseCameraRequestControl _requestControl;
    private volatile ImageCapture.ScreenFlash _screenFlash;
    private CompletableDeferred<Unit> _updateSignal;
    private final CameraProperties cameraProperties;
    private int flashMode;
    private ImageCapture.ScreenFlash screenFlash;
    private final State3AControl state3AControl;
    private final UseCaseThreads threads;
    private final TorchControl torchControl;
    private Deferred<Unit> updateSignal;
    private final UseFlashModeTorchFor3aUpdate useFlashModeTorchFor3aUpdate;

    /* JADX INFO: compiled from: FlashControl.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'¨\u0006\b"}, d2 = {"Landroidx/camera/camera2/impl/FlashControl$Bindings;", "", "<init>", "()V", "provideControls", "Landroidx/camera/camera2/impl/UseCaseCameraControl;", "flashControl", "Landroidx/camera/camera2/impl/FlashControl;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Module
    public static abstract class Bindings {
        @Binds
        @IntoSet
        public abstract UseCaseCameraControl provideControls(FlashControl flashControl);
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.FlashControl$applyScreenFlash$1, reason: invalid class name */
    /* JADX INFO: compiled from: FlashControl.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.FlashControl", f = "FlashControl.kt", i = {0, 0}, l = {WebmConstants.MkvEbmlElement.PREV_SIZE}, m = "applyScreenFlash", n = {"onApplyCompletedSignal", "timeoutMillis"}, s = {"L$0", "J$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
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
            return FlashControl.this.applyScreenFlash(0L, this);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.FlashControl$applyScreenFlash$2, reason: invalid class name */
    /* JADX INFO: compiled from: FlashControl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.FlashControl$applyScreenFlash$2", f = "FlashControl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ImageCapture.ScreenFlashListener $screenFlashListener;
        final /* synthetic */ long $timeoutMillis;
        int label;
        final /* synthetic */ FlashControl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(long j, FlashControl flashControl, ImageCapture.ScreenFlashListener screenFlashListener, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$timeoutMillis = j;
            this.this$0 = flashControl;
            this.$screenFlashListener = screenFlashListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$timeoutMillis, this.this$0, this.$screenFlashListener, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            long jCurrentTimeMillis = System.currentTimeMillis() + this.$timeoutMillis;
            ImageCapture.ScreenFlash screenFlash = this.this$0.get_screenFlash();
            if (screenFlash != null) {
                screenFlash.apply(jCurrentTimeMillis, this.$screenFlashListener);
            }
            Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "applyScreenFlash: ScreenFlash.apply() invoked, expirationTimeMillis = " + jCurrentTimeMillis);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.FlashControl$applyScreenFlash$3, reason: invalid class name */
    /* JADX INFO: compiled from: FlashControl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.FlashControl$applyScreenFlash$3", f = "FlashControl.kt", i = {}, l = {188}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CompletableDeferred<Unit> $onApplyCompletedSignal;
        final /* synthetic */ long $timeoutMillis;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(CompletableDeferred<Unit> completableDeferred, long j, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$onApplyCompletedSignal = completableDeferred;
            this.$timeoutMillis = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.$onApplyCompletedSignal, this.$timeoutMillis, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "applyScreenFlash: Waiting for ScreenFlashListener to be completed");
                }
                this.label = 1;
                obj = CoroutineAdaptersKt.awaitUntil(this.$onApplyCompletedSignal, this.$timeoutMillis, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (((Boolean) obj).booleanValue()) {
                Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "applyScreenFlash: ScreenFlashListener completed");
                }
            } else {
                Camera2Logger camera2Logger3 = Camera2Logger.INSTANCE;
                long j = this.$timeoutMillis;
                if (Logger.isWarnEnabled(Log.TAG)) {
                    android.util.Log.w(Camera2Logger.TRUNCATED_TAG, "applyScreenFlash: ScreenFlashListener completion timed out after " + j + " ms");
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.FlashControl$awaitFlashModeUpdate$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FlashControl.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.FlashControl", f = "FlashControl.kt", i = {0}, l = {284}, m = "awaitFlashModeUpdate", n = {"initialFlashMode"}, s = {"I$0"}, v = 1)
    static final class C02321 extends ContinuationImpl {
        int I$0;
        int label;
        /* synthetic */ Object result;

        C02321(Continuation<? super C02321> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlashControl.this.awaitFlashModeUpdate(this);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.FlashControl$startScreenFlashCaptureTasks$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FlashControl.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.FlashControl", f = "FlashControl.kt", i = {0}, l = {Imgproc.COLOR_RGB2YUV_YVYU, WebmConstants.MkvEbmlElement.BLOCK_GROUP}, m = "startScreenFlashCaptureTasks", n = {"pendingTasks"}, s = {"L$0"}, v = 1)
    static final class C02331 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C02331(Continuation<? super C02331> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlashControl.this.startScreenFlashCaptureTasks(this);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.FlashControl$stopScreenFlashCaptureTasks$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FlashControl.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.FlashControl", f = "FlashControl.kt", i = {}, l = {260}, m = "stopScreenFlashCaptureTasks", n = {}, s = {}, v = 1)
    static final class C02341 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C02341(Continuation<? super C02341> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlashControl.this.stopScreenFlashCaptureTasks(this);
        }
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.FlashControl$stopScreenFlashCaptureTasks$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FlashControl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.FlashControl$stopScreenFlashCaptureTasks$2", f = "FlashControl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C02352 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C02352(Continuation<? super C02352> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FlashControl.this.new C02352(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C02352) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ImageCapture.ScreenFlash screenFlash = FlashControl.this.get_screenFlash();
            if (screenFlash != null) {
                screenFlash.clear();
            }
            Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "screenFlashPostCapture: ScreenFlash.clear() invoked");
            }
            return Unit.INSTANCE;
        }
    }

    @Inject
    public FlashControl(CameraProperties cameraProperties, State3AControl state3AControl, UseCaseThreads threads, TorchControl torchControl, UseFlashModeTorchFor3aUpdate useFlashModeTorchFor3aUpdate) {
        Intrinsics.checkNotNullParameter(cameraProperties, "cameraProperties");
        Intrinsics.checkNotNullParameter(state3AControl, "state3AControl");
        Intrinsics.checkNotNullParameter(threads, "threads");
        Intrinsics.checkNotNullParameter(torchControl, "torchControl");
        Intrinsics.checkNotNullParameter(useFlashModeTorchFor3aUpdate, "useFlashModeTorchFor3aUpdate");
        this.cameraProperties = cameraProperties;
        this.state3AControl = state3AControl;
        this.threads = threads;
        this.torchControl = torchControl;
        this.useFlashModeTorchFor3aUpdate = useFlashModeTorchFor3aUpdate;
        this._flashMode = 2;
        this.flashMode = this._flashMode;
        this.screenFlash = this._screenFlash;
        this.updateSignal = CompletableDeferredKt.CompletableDeferred(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object applyScreenFlash(long j, Continuation<? super Deferred<Unit>> continuation) {
        AnonymousClass1 anonymousClass1;
        FlashControl flashControl;
        CompletableDeferred completableDeferred;
        long j2;
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
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
            ImageCapture.ScreenFlashListener screenFlashListener = new ImageCapture.ScreenFlashListener() { // from class: androidx.camera.camera2.impl.FlashControl$$ExternalSyntheticLambda1
                @Override // androidx.camera.core.ImageCapture.ScreenFlashListener
                public final void onCompleted() {
                    completableDeferredCompletableDeferred$default.complete(Unit.INSTANCE);
                }
            };
            MainCoroutineDispatcher main = Dispatchers.getMain();
            flashControl = this;
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(j, flashControl, screenFlashListener, null);
            anonymousClass1.L$0 = completableDeferredCompletableDeferred$default;
            anonymousClass1.J$0 = j;
            anonymousClass1.label = 1;
            if (BuildersKt.withContext(main, anonymousClass2, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            completableDeferred = completableDeferredCompletableDeferred$default;
            j2 = j;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j2 = anonymousClass1.J$0;
            completableDeferred = (CompletableDeferred) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            flashControl = this;
        }
        return BuildersKt__Builders_commonKt.async$default(flashControl.threads.getScope(), null, null, new AnonymousClass3(completableDeferred, j2, null), 3, null);
    }

    public static /* synthetic */ void getFlashMode$annotations() {
    }

    private static /* synthetic */ void get_flashMode$annotations() {
    }

    private final Deferred<Unit> setExternalFlashAeModeAsync() {
        boolean zIsExternalFlashAeModeSupported = CameraMetadataIntegrationKt.isExternalFlashAeModeSupported(this.cameraProperties.getMetadata());
        Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "setExternalFlashAeModeAsync: isExternalFlashAeModeSupported = " + zIsExternalFlashAeModeSupported);
        }
        if (!zIsExternalFlashAeModeSupported) {
            return null;
        }
        Deferred<Unit> tryExternalFlashAeModeAsync = this.state3AControl.setTryExternalFlashAeModeAsync(true);
        Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "setExternalFlashAeModeAsync: need to wait for state3AControl.updateSignal");
        }
        tryExternalFlashAeModeAsync.invokeOnCompletion(new Function1() { // from class: androidx.camera.camera2.impl.FlashControl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FlashControl.setExternalFlashAeModeAsync$lambda$1$1((Throwable) obj);
            }
        });
        return tryExternalFlashAeModeAsync;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setExternalFlashAeModeAsync$lambda$1$1(Throwable th) {
        Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "setExternalFlashAeModeAsync: state3AControl.updateSignal completed");
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Deferred setFlashAsync$default(FlashControl flashControl, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        return flashControl.setFlashAsync(i, z);
    }

    private final Deferred<Unit> setTorchForScreenFlash() {
        boolean zShouldUseFlashModeTorch = this.useFlashModeTorchFor3aUpdate.shouldUseFlashModeTorch();
        Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "setTorchIfRequired: shouldUseFlashModeTorch = " + zShouldUseFlashModeTorch);
        }
        if (!zShouldUseFlashModeTorch) {
            return null;
        }
        Deferred<Unit> deferredM100setTorchAsyncOup_wC0$camera_camera2$default = TorchControl.m100setTorchAsyncOup_wC0$camera_camera2$default(this.torchControl, TorchControl.TorchMode.INSTANCE.m114getUSED_AS_FLASHIRs_R8(), false, true, 2, null);
        Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "setTorchIfRequired: need to wait for torch control to be completed");
        }
        deferredM100setTorchAsyncOup_wC0$camera_camera2$default.invokeOnCompletion(new Function1() { // from class: androidx.camera.camera2.impl.FlashControl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FlashControl.setTorchForScreenFlash$lambda$1$1((Throwable) obj);
            }
        });
        return deferredM100setTorchAsyncOup_wC0$camera_camera2$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setTorchForScreenFlash$lambda$1$1(Throwable th) {
        Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "setTorchIfRequired: torch control completed");
        }
        return Unit.INSTANCE;
    }

    private final void stopRunningTask() {
        CompletableDeferred<Unit> completableDeferred = this._updateSignal;
        if (completableDeferred != null) {
            completableDeferred.completeExceptionally(new CameraControl.OperationCanceledException("There is a new flash mode being set or camera was closed"));
        }
        this._updateSignal = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object awaitFlashModeUpdate(Continuation<? super Integer> continuation) {
        C02321 c02321;
        int i;
        if (continuation instanceof C02321) {
            c02321 = (C02321) continuation;
            if ((c02321.label & Integer.MIN_VALUE) != 0) {
                c02321.label -= Integer.MIN_VALUE;
            } else {
                c02321 = new C02321(continuation);
            }
        }
        Object obj = c02321.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c02321.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "FlashControl: Waiting for any ongoing update to be completed");
            }
            int i3 = get_flashMode();
            Deferred<Unit> updateSignal = getUpdateSignal();
            c02321.I$0 = i3;
            c02321.label = 1;
            if (updateSignal.join(c02321) == coroutine_suspended) {
                return coroutine_suspended;
            }
            i = i3;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = c02321.I$0;
            ResultKt.throwOnFailure(obj);
        }
        Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "awaitFlashModeUpdate: initialFlashMode = " + i);
        }
        return Boxing.boxInt(i);
    }

    /* JADX INFO: renamed from: getFlashMode, reason: from getter */
    public final int get_flashMode() {
        return this._flashMode;
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraControl
    /* JADX INFO: renamed from: getRequestControl, reason: from getter */
    public UseCaseCameraRequestControl get_requestControl() {
        return this._requestControl;
    }

    /* JADX INFO: renamed from: getScreenFlash, reason: from getter */
    public final ImageCapture.ScreenFlash get_screenFlash() {
        return this._screenFlash;
    }

    public final Deferred<Unit> getUpdateSignal() {
        CompletableDeferred<Unit> completableDeferred = this._updateSignal;
        if (completableDeferred == null) {
            return CompletableDeferredKt.CompletableDeferred(Unit.INSTANCE);
        }
        Intrinsics.checkNotNull(completableDeferred);
        return completableDeferred;
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraControl
    public void reset() {
        this._flashMode = 2;
        this._screenFlash = null;
        stopRunningTask();
        setFlashAsync$default(this, 2, false, 2, null);
    }

    public final Deferred<Unit> setFlashAsync(int flashMode, boolean cancelPreviousTask) {
        Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "setFlashAsync: flashMode = " + flashMode + ", requestControl = " + get_requestControl());
        }
        CompletableDeferred<Unit> completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        if (get_requestControl() != null) {
            this._flashMode = flashMode;
            if (cancelPreviousTask) {
                stopRunningTask();
            } else {
                CompletableDeferred<Unit> completableDeferred = this._updateSignal;
                if (completableDeferred != null) {
                    CoroutineAdaptersKt.propagateTo(completableDeferredCompletableDeferred$default, completableDeferred);
                }
            }
            this._updateSignal = completableDeferredCompletableDeferred$default;
            CoroutineAdaptersKt.propagateTo(this.state3AControl.setFlashModeAsync(flashMode), completableDeferredCompletableDeferred$default);
        } else {
            completableDeferredCompletableDeferred$default.completeExceptionally(new CameraControl.OperationCanceledException("Camera is not active."));
        }
        return completableDeferredCompletableDeferred$default;
    }

    @Override // androidx.camera.camera2.impl.UseCaseCameraControl
    public void setRequestControl(UseCaseCameraRequestControl useCaseCameraRequestControl) {
        this._requestControl = useCaseCameraRequestControl;
        setFlashAsync(this._flashMode, false);
    }

    public final void setScreenFlash(ImageCapture.ScreenFlash screenFlash) {
        this._screenFlash = screenFlash;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x008c, code lost:
    
        if (kotlinx.coroutines.AwaitKt.awaitAll(r4, r0) == r1) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object startScreenFlashCaptureTasks(Continuation<? super Unit> continuation) {
        C02331 c02331;
        ArrayList arrayList;
        List list;
        if (continuation instanceof C02331) {
            c02331 = (C02331) continuation;
            if ((c02331.label & Integer.MIN_VALUE) != 0) {
                c02331.label -= Integer.MIN_VALUE;
            } else {
                c02331 = new C02331(continuation);
            }
        }
        Object objApplyScreenFlash = c02331.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c02331.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objApplyScreenFlash);
            arrayList = new ArrayList();
            long millis = TimeUnit.SECONDS.toMillis(3L);
            c02331.L$0 = arrayList;
            c02331.L$1 = arrayList;
            c02331.label = 1;
            objApplyScreenFlash = applyScreenFlash(millis, c02331);
            if (objApplyScreenFlash != coroutine_suspended) {
                list = arrayList;
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objApplyScreenFlash);
            return Unit.INSTANCE;
        }
        arrayList = (List) c02331.L$1;
        list = (List) c02331.L$0;
        ResultKt.throwOnFailure(objApplyScreenFlash);
        arrayList.add(objApplyScreenFlash);
        Deferred<Unit> externalFlashAeModeAsync = setExternalFlashAeModeAsync();
        if (externalFlashAeModeAsync != null) {
            Boxing.boxBoolean(list.add(externalFlashAeModeAsync));
        }
        Deferred<Unit> torchForScreenFlash = setTorchForScreenFlash();
        if (torchForScreenFlash != null) {
            Boxing.boxBoolean(list.add(torchForScreenFlash));
        }
        c02331.L$0 = null;
        c02331.L$1 = null;
        c02331.label = 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object stopScreenFlashCaptureTasks(Continuation<? super Unit> continuation) {
        C02341 c02341;
        if (continuation instanceof C02341) {
            c02341 = (C02341) continuation;
            if ((c02341.label & Integer.MIN_VALUE) != 0) {
                c02341.label -= Integer.MIN_VALUE;
            } else {
                c02341 = new C02341(continuation);
            }
        }
        Object obj = c02341.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c02341.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MainCoroutineDispatcher main = Dispatchers.getMain();
            C02352 c02352 = new C02352(null);
            c02341.label = 1;
            if (BuildersKt.withContext(main, c02352, c02341) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        if (CameraMetadataIntegrationKt.isExternalFlashAeModeSupported(this.cameraProperties.getMetadata())) {
            this.state3AControl.setTryExternalFlashAeModeAsync(false);
        }
        if (this.useFlashModeTorchFor3aUpdate.shouldUseFlashModeTorch()) {
            TorchControl.m100setTorchAsyncOup_wC0$camera_camera2$default(this.torchControl, TorchControl.TorchMode.INSTANCE.m112getOFFIRs_R8(), false, true, 2, null);
        }
        return Unit.INSTANCE;
    }
}
