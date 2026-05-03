package com.vanniktech.emoji;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Lock.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a)\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0080\bø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0006"}, d2 = {"use", "R", "Lcom/vanniktech/emoji/Lock;", "block", "Lkotlin/Function0;", "(Lcom/vanniktech/emoji/Lock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "emoji_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class LockKt {
    public static final <R> R use(Lock lock, Function0<? extends R> block) {
        Intrinsics.checkNotNullParameter(lock, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            lock.lock();
            return block.invoke();
        } finally {
            lock.unlock();
        }
    }
}
