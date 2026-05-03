package com.revenuecat.purchases.ui.revenuecatui.components.video;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: VideoView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.video.VideoViewKt$Video$1$1", f = "VideoView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class VideoViewKt$Video$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $autoPlay;
    final /* synthetic */ MutableState<TextureVideoView> $videoView;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoViewKt$Video$1$1(MutableState<TextureVideoView> mutableState, boolean z, Continuation<? super VideoViewKt$Video$1$1> continuation) {
        super(2, continuation);
        this.$videoView = mutableState;
        this.$autoPlay = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoViewKt$Video$1$1(this.$videoView, this.$autoPlay, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((VideoViewKt$Video$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        TextureVideoView value = this.$videoView.getValue();
        if (value != null) {
            value.setAutoStart(this.$autoPlay);
            value.startIfNeeded();
        }
        return Unit.INSTANCE;
    }
}
