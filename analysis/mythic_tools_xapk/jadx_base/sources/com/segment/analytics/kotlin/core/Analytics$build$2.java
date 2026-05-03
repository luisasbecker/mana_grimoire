package com.segment.analytics.kotlin.core;

import com.segment.analytics.kotlin.core.platform.plugins.SegmentDestination;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.opencv.imgproc.Imgproc;
import sovran.kotlin.Store;

/* JADX INFO: compiled from: Analytics.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.segment.analytics.kotlin.core.Analytics$build$2", f = "Analytics.kt", i = {0}, l = {127, 128, 131, Imgproc.COLOR_BGR2YUV_YV12, 139}, m = "invokeSuspend", n = {"it"}, s = {"L$2"})
final class Analytics$build$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ Analytics this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Analytics$build$2(Analytics analytics, Continuation<? super Analytics$build$2> continuation) {
        super(2, continuation);
        this.this$0 = analytics;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Analytics$build$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Analytics$build$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00e5, code lost:
    
        if (com.segment.analytics.kotlin.core.SettingsKt.checkSettings(r11.this$0, r11) != r0) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00cc  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Store store;
        Analytics analytics;
        Store store2;
        Analytics analytics2;
        Store store3;
        Storage storage;
        Store store4;
        Telemetry telemetry;
        Store store5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            store = this.this$0.getStore();
            Analytics analytics3 = this.this$0;
            UserInfo userInfo = analytics3.getUserInfo();
            this.L$0 = store;
            this.L$1 = analytics3;
            this.L$2 = store;
            this.label = 1;
            if (store.provide(userInfo, this) != coroutine_suspended) {
                analytics = analytics3;
                store2 = store;
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            store = (Store) this.L$2;
            analytics = (Analytics) this.L$1;
            store2 = (Store) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            if (i == 2) {
                analytics2 = (Analytics) this.L$1;
                store3 = (Store) this.L$0;
                ResultKt.throwOnFailure(obj);
                storage = analytics2.getStorage();
                this.L$0 = store3;
                this.L$1 = analytics2;
                this.label = 3;
                if (storage.initialize(this) != coroutine_suspended) {
                    store4 = store3;
                    telemetry = Telemetry.INSTANCE;
                    store5 = analytics2.getStore();
                    this.L$0 = store4;
                    this.L$1 = null;
                    this.label = 4;
                    if (telemetry.subscribe$core(store5, this) != coroutine_suspended) {
                    }
                }
                return coroutine_suspended;
            }
            if (i == 3) {
                analytics2 = (Analytics) this.L$1;
                store4 = (Store) this.L$0;
                ResultKt.throwOnFailure(obj);
                telemetry = Telemetry.INSTANCE;
                store5 = analytics2.getStore();
                this.L$0 = store4;
                this.L$1 = null;
                this.label = 4;
                if (telemetry.subscribe$core(store5, this) != coroutine_suspended) {
                    if (this.this$0.getConfiguration().getAutoAddSegmentDestination()) {
                    }
                    this.L$0 = null;
                    this.label = 5;
                }
                return coroutine_suspended;
            }
            if (i != 4) {
                if (i != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            if (this.this$0.getConfiguration().getAutoAddSegmentDestination()) {
                this.this$0.add(new SegmentDestination());
            }
            this.L$0 = null;
            this.label = 5;
        }
        System systemDefaultState = System.INSTANCE.defaultState(analytics.getConfiguration(), analytics.getStorage());
        this.L$0 = store2;
        this.L$1 = analytics;
        this.L$2 = null;
        this.label = 2;
        if (store.provide(systemDefaultState, this) != coroutine_suspended) {
            analytics2 = analytics;
            store3 = store2;
            storage = analytics2.getStorage();
            this.L$0 = store3;
            this.L$1 = analytics2;
            this.label = 3;
            if (storage.initialize(this) != coroutine_suspended) {
            }
        }
        return coroutine_suspended;
    }
}
