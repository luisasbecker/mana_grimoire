package com.segment.analytics.kotlin.core.platform;

import com.segment.analytics.kotlin.core.Analytics;
import com.segment.analytics.kotlin.core.Settings;
import com.segment.analytics.kotlin.core.System;
import com.segment.analytics.kotlin.core.platform.Plugin;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CoroutineScope;
import org.opencv.imgproc.Imgproc;
import sovran.kotlin.Store;

/* JADX INFO: compiled from: Timeline.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.segment.analytics.kotlin.core.platform.Timeline$add$2$1", f = "Timeline.kt", i = {}, l = {88, Imgproc.COLOR_YUV2BGRA_NV12}, m = "invokeSuspend", n = {}, s = {})
final class Timeline$add$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Plugin $plugin;
    final /* synthetic */ Analytics $this_with;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Timeline$add$2$1(Analytics analytics, Plugin plugin, Continuation<? super Timeline$add$2$1> continuation) {
        super(2, continuation);
        this.$this_with = analytics;
        this.$plugin = plugin;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Timeline$add$2$1(this.$this_with, this.$plugin, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Timeline$add$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x007d, code lost:
    
        if (r6.dispatch(r1, r3, r5) == r0) goto L22;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.$this_with.getStore().currentState(Reflection.getOrCreateKotlinClass(System.class), this);
            if (obj != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        System system = (System) obj;
        Settings settings = system != null ? system.getSettings() : null;
        if (settings != null) {
            Plugin plugin = this.$plugin;
            Analytics analytics = this.$this_with;
            if (!system.getInitializedPlugins().isEmpty()) {
                plugin.update(settings, Plugin.UpdateType.Initial);
                Store store = analytics.getStore();
                System.AddInitializedPlugins addInitializedPlugins = new System.AddInitializedPlugins(SetsKt.setOf(Boxing.boxInt(plugin.hashCode())));
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(System.class);
                this.label = 2;
            }
        }
        return Unit.INSTANCE;
    }
}
