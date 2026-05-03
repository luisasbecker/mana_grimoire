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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: VideoComponentView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentViewKt$rememberVideoContentState$1$1", f = "VideoComponentView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class VideoComponentViewKt$rememberVideoContentState$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FileRepository $repository;
    final /* synthetic */ VideoUrls $videoUrls;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentViewKt$rememberVideoContentState$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: VideoComponentView.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.video.VideoComponentViewKt$rememberVideoContentState$1$1$1", f = "VideoComponentView.kt", i = {}, l = {148}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FileRepository $repository;
        final /* synthetic */ VideoUrls $videoUrls;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(VideoUrls videoUrls, FileRepository fileRepository, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$videoUrls = videoUrls;
            this.$repository = fileRepository;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$videoUrls, this.$repository, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (VideoComponentViewKt.cacheVideo(this.$videoUrls.getUrl(), this.$videoUrls.getChecksum(), this.$repository, this) == coroutine_suspended) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoComponentViewKt$rememberVideoContentState$1$1(VideoUrls videoUrls, FileRepository fileRepository, Continuation<? super VideoComponentViewKt$rememberVideoContentState$1$1> continuation) {
        super(2, continuation);
        this.$videoUrls = videoUrls;
        this.$repository = fileRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        VideoComponentViewKt$rememberVideoContentState$1$1 videoComponentViewKt$rememberVideoContentState$1$1 = new VideoComponentViewKt$rememberVideoContentState$1$1(this.$videoUrls, this.$repository, continuation);
        videoComponentViewKt$rememberVideoContentState$1$1.L$0 = obj;
        return videoComponentViewKt$rememberVideoContentState$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((VideoComponentViewKt$rememberVideoContentState$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(this.$videoUrls, this.$repository, null), 3, null);
        URL urlLowRes = this.$videoUrls.getUrlLowRes();
        if (urlLowRes != null) {
            if (Intrinsics.areEqual(urlLowRes, this.$videoUrls.getUrl())) {
                urlLowRes = null;
            }
            if (urlLowRes != null) {
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new VideoComponentViewKt$rememberVideoContentState$1$1$3$1(urlLowRes, this.$videoUrls, this.$repository, null), 3, null);
            }
        }
        return Unit.INSTANCE;
    }
}
