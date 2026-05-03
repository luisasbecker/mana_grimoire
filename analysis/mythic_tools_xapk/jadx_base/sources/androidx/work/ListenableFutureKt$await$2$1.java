package androidx.work;

import androidx.media3.muxer.WebmConstants;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CancellableContinuation;

/* JADX INFO: compiled from: ListenableFuture.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "R", "run"}, k = 3, mv = {1, 8, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
public final class ListenableFutureKt$await$2$1 implements Runnable {
    final /* synthetic */ CancellableContinuation<R> $cancellableContinuation;
    final /* synthetic */ ListenableFuture<R> $this_await;

    /* JADX WARN: Multi-variable type inference failed */
    public ListenableFutureKt$await$2$1(CancellableContinuation<? super R> cancellableContinuation, ListenableFuture<R> listenableFuture) {
        this.$cancellableContinuation = cancellableContinuation;
        this.$this_await = listenableFuture;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Continuation continuation = this.$cancellableContinuation;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m11445constructorimpl(this.$this_await.get()));
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                cause = th;
            }
            boolean z = th instanceof CancellationException;
            CancellableContinuation<R> cancellableContinuation = this.$cancellableContinuation;
            if (z) {
                cancellableContinuation.cancel(cause);
            } else {
                Result.Companion companion2 = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m11445constructorimpl(ResultKt.createFailure(cause)));
            }
        }
    }
}
