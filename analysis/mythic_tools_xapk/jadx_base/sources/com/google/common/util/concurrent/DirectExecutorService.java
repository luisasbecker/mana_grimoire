package com.google.common.util.concurrent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
@ElementTypesAreNonnullByDefault
final class DirectExecutorService extends AbstractListeningExecutorService {
    private final Object lock = new Object();
    private int runningTasks = 0;
    private boolean shutdown = false;

    DirectExecutorService() {
    }

    private void endTask() {
        synchronized (this.lock) {
            int i = this.runningTasks - 1;
            this.runningTasks = i;
            if (i == 0) {
                this.lock.notifyAll();
            }
        }
    }

    private void startTask() {
        synchronized (this.lock) {
            if (this.shutdown) {
                throw new RejectedExecutionException("Executor already shutdown");
            }
            this.runningTasks++;
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j);
        synchronized (this.lock) {
            while (true) {
                if (this.shutdown && this.runningTasks == 0) {
                    return true;
                }
                if (nanos <= 0) {
                    return false;
                }
                long jNanoTime = System.nanoTime();
                TimeUnit.NANOSECONDS.timedWait(this.lock, nanos);
                nanos -= System.nanoTime() - jNanoTime;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        startTask();
        try {
            runnable.run();
        } finally {
            endTask();
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        boolean z;
        synchronized (this.lock) {
            z = this.shutdown;
        }
        return z;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        boolean z;
        synchronized (this.lock) {
            z = this.shutdown && this.runningTasks == 0;
        }
        return z;
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        synchronized (this.lock) {
            this.shutdown = true;
            if (this.runningTasks == 0) {
                this.lock.notifyAll();
            }
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        shutdown();
        return Collections.emptyList();
    }
}
