package com.vanniktech.emoji;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;

/* JADX INFO: compiled from: Lock.android.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/vanniktech/emoji/Lock;", "", "<init>", "()V", "mutex", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "", "unlock", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class Lock {
    private final ReentrantLock mutex = new ReentrantLock();

    public final void lock() {
        this.mutex.lock();
    }

    public final void unlock() {
        this.mutex.unlock();
    }
}
