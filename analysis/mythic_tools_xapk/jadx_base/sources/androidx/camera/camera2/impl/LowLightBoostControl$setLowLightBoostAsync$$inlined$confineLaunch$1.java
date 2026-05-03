package androidx.camera.camera2.impl;

import androidx.camera.camera2.adapter.CoroutineAdaptersKt;
import androidx.camera.core.CameraControl;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: compiled from: UseCaseThreads.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "androidx/camera/camera2/impl/UseCaseThreads$confineLaunch$1"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "androidx.camera.camera2.impl.LowLightBoostControl$setLowLightBoostAsync$$inlined$confineLaunch$1", f = "LowLightBoostControl.kt", i = {}, l = {201}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class LowLightBoostControl$setLowLightBoostAsync$$inlined$confineLaunch$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $cancelPreviousTask$inlined;
    final /* synthetic */ boolean $lowLightBoost$inlined;
    final /* synthetic */ CompletableDeferred $signal$inlined;
    int label;
    final /* synthetic */ LowLightBoostControl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LowLightBoostControl$setLowLightBoostAsync$$inlined$confineLaunch$1(Continuation continuation, LowLightBoostControl lowLightBoostControl, CompletableDeferred completableDeferred, boolean z, boolean z2) {
        super(2, continuation);
        this.this$0 = lowLightBoostControl;
        this.$signal$inlined = completableDeferred;
        this.$lowLightBoost$inlined = z;
        this.$cancelPreviousTask$inlined = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LowLightBoostControl$setLowLightBoostAsync$$inlined$confineLaunch$1(continuation, this.this$0, this.$signal$inlined, this.$lowLightBoost$inlined, this.$cancelPreviousTask$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LowLightBoostControl$setLowLightBoostAsync$$inlined$confineLaunch$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c7  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        boolean zBooleanValue;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Deferred<Boolean> checkFrameRateJob$camera_camera2 = this.this$0.getCheckFrameRateJob$camera_camera2();
            if (checkFrameRateJob$camera_camera2 == null) {
                zBooleanValue = false;
                LowLightBoostControl lowLightBoostControl = this.this$0;
                if (zBooleanValue) {
                    lowLightBoostControl.isLowLightBoostOn = this.$lowLightBoost$inlined;
                    if (!this.$lowLightBoost$inlined) {
                        LowLightBoostControl lowLightBoostControl2 = this.this$0;
                        lowLightBoostControl2.setLiveDataValue(lowLightBoostControl2._lowLightBoostState, -1);
                    }
                    if (this.this$0.get_requestControl() == null) {
                        this.this$0.createFailureResult(this.$signal$inlined, new CameraControl.OperationCanceledException("Camera is not active."));
                        Unit unit = Unit.INSTANCE;
                    } else {
                        if (this.$lowLightBoost$inlined) {
                            LowLightBoostControl lowLightBoostControl3 = this.this$0;
                            lowLightBoostControl3.setLiveDataValue(lowLightBoostControl3._lowLightBoostState, 0);
                        }
                        boolean z = this.$cancelPreviousTask$inlined;
                        LowLightBoostControl lowLightBoostControl4 = this.this$0;
                        if (z) {
                            lowLightBoostControl4.stopRunningTaskInternal();
                        } else {
                            CompletableDeferred completableDeferred = lowLightBoostControl4._updateSignal;
                            if (completableDeferred != null) {
                                CoroutineAdaptersKt.propagateTo(this.$signal$inlined, completableDeferred);
                            }
                        }
                        this.this$0._updateSignal = this.$signal$inlined;
                        CoroutineAdaptersKt.propagateTo(this.this$0.state3AControl.setPreferredAeModeAsync(this.$lowLightBoost$inlined ? Boxing.boxInt(6) : null), this.$signal$inlined);
                        CompletableDeferred completableDeferred2 = this.$signal$inlined;
                        final CompletableDeferred completableDeferred3 = this.$signal$inlined;
                        final LowLightBoostControl lowLightBoostControl5 = this.this$0;
                        if (completableDeferred2.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.camera.camera2.impl.LowLightBoostControl$setLowLightBoostAsync$2$1$2
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                                invoke2(th);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Throwable th) {
                                if (Intrinsics.areEqual(completableDeferred3, lowLightBoostControl5._updateSignal)) {
                                    lowLightBoostControl5._updateSignal = null;
                                }
                            }
                        }) == null) {
                        }
                    }
                } else {
                    lowLightBoostControl.setLiveDataValue(lowLightBoostControl._lowLightBoostState, -1);
                    this.this$0.createFailureResult(this.$signal$inlined, new IllegalStateException("Low Light Boost is disabled when expected frame rate range exceeds 30."));
                }
                return Unit.INSTANCE;
            }
            this.label = 1;
            obj = checkFrameRateJob$camera_camera2.await(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        zBooleanValue = ((Boolean) obj).booleanValue();
        LowLightBoostControl lowLightBoostControl6 = this.this$0;
        if (zBooleanValue) {
        }
        return Unit.INSTANCE;
    }
}
