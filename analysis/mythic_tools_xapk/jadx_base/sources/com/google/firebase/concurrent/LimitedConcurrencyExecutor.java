package com.google.firebase.concurrent;

import com.google.firebase.components.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes5.dex */
class LimitedConcurrencyExecutor implements Executor {
    private final Executor delegate;
    private final LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
    private final Semaphore semaphore;

    LimitedConcurrencyExecutor(Executor executor, int i) {
        Preconditions.checkArgument(i > 0, "concurrency must be positive.");
        this.delegate = executor;
        this.semaphore = new Semaphore(i, true);
    }

    private Runnable decorate(final Runnable runnable) {
        return new Runnable() { // from class: com.google.firebase.concurrent.LimitedConcurrencyExecutor$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m10184x96c64136(runnable);
            }
        };
    }

    private void maybeEnqueueNext() {
        while (this.semaphore.tryAcquire()) {
            Runnable runnablePoll = this.queue.poll();
            if (runnablePoll == null) {
                this.semaphore.release();
                return;
            }
            this.delegate.execute(decorate(runnablePoll));
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.queue.offer(runnable);
        maybeEnqueueNext();
    }

    /* JADX INFO: renamed from: lambda$decorate$0$com-google-firebase-concurrent-LimitedConcurrencyExecutor, reason: not valid java name */
    /* synthetic */ void m10184x96c64136(Runnable runnable) {
        try {
            runnable.run();
        } finally {
            this.semaphore.release();
            maybeEnqueueNext();
        }
    }
}
