package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.studiolaganne.lengendarylens.EmbeddingsLoader;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: EmbeddingsLoader.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.studiolaganne.lengendarylens.EmbeddingsLoader$startBackgroundLoading$1$1", f = "EmbeddingsLoader.kt", i = {0}, l = {70}, m = "invokeSuspend", n = {"cardEmbeddings"}, s = {"L$0"}, v = 1)
final class EmbeddingsLoader$startBackgroundLoading$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EmbeddingsLoader$startBackgroundLoading$1$1(Context context, Continuation<? super EmbeddingsLoader$startBackgroundLoading$1$1> continuation) {
        super(2, continuation);
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EmbeddingsLoader$startBackgroundLoading$1$1(this.$context, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((EmbeddingsLoader$startBackgroundLoading$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Process.setThreadPriority(10);
                    Log.d("EmbeddingsLoader", "Starting background loading of embeddings...");
                    EmbeddingsLoader.INSTANCE.updateState(EmbeddingsLoader.LoadingState.LOADING_CARD_EMBEDDINGS);
                    Context applicationContext = this.$context.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                    CardEmbeddings cardEmbeddings = new CardEmbeddings(applicationContext);
                    EmbeddingsLoader.cardEmbeddingsRef.set(cardEmbeddings);
                    Log.d("EmbeddingsLoader", "Card embeddings loaded");
                    this.L$0 = SpillingKt.nullOutSpilledVariable(cardEmbeddings);
                    this.label = 1;
                    if (DelayKt.delay(100L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                EmbeddingsLoader.INSTANCE.updateState(EmbeddingsLoader.LoadingState.LOADING_SET_EMBEDDINGS);
                Context applicationContext2 = this.$context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
                EmbeddingsLoader.setSymbolEmbeddingsRef.set(new SetSymbolEmbeddings(applicationContext2));
                Log.d("EmbeddingsLoader", "Set symbol embeddings loaded");
                EmbeddingsLoader.INSTANCE.updateState(EmbeddingsLoader.LoadingState.COMPLETED);
                Log.d("EmbeddingsLoader", "All embeddings loaded successfully");
            } catch (Exception e) {
                Log.e("EmbeddingsLoader", "Failed to load embeddings", e);
                EmbeddingsLoader.INSTANCE.updateState(EmbeddingsLoader.LoadingState.FAILED);
            }
            EmbeddingsLoader.isLoading.set(false);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            EmbeddingsLoader.isLoading.set(false);
            throw th;
        }
    }
}
