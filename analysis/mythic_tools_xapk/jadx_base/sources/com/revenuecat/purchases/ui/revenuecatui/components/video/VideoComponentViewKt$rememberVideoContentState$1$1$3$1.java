package com.revenuecat.purchases.ui.revenuecatui.components.video;

import com.revenuecat.purchases.paywalls.components.properties.VideoUrls;
import com.revenuecat.purchases.storage.FileRepository;
import java.net.URL;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: VideoComponentView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentViewKt$rememberVideoContentState$1$1$3$1", f = "VideoComponentView.kt", i = {}, l = {150}, m = "invokeSuspend", n = {}, s = {})
final class VideoComponentViewKt$rememberVideoContentState$1$1$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ URL $it;
    final /* synthetic */ FileRepository $repository;
    final /* synthetic */ VideoUrls $videoUrls;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoComponentViewKt$rememberVideoContentState$1$1$3$1(URL url, VideoUrls videoUrls, FileRepository fileRepository, Continuation<? super VideoComponentViewKt$rememberVideoContentState$1$1$3$1> continuation) {
        super(2, continuation);
        this.$it = url;
        this.$videoUrls = videoUrls;
        this.$repository = fileRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoComponentViewKt$rememberVideoContentState$1$1$3$1(this.$it, this.$videoUrls, this.$repository, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((VideoComponentViewKt$rememberVideoContentState$1$1$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (VideoComponentViewKt.cacheVideo(this.$it, this.$videoUrls.getChecksumLowRes(), this.$repository, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
