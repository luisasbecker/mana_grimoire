package com.revenuecat.purchases.storage;

import androidx.exifinterface.media.ExifInterface;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;

/* JADX INFO: compiled from: KeyedDeferredValueStore.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u000f\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J/\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\b2\u0006\u0010\f\u001a\u00028\u00002\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b0\u000eH\u0002¢\u0006\u0002\u0010\u000fJ-\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\b2\u0006\u0010\f\u001a\u00028\u00002\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b0\u000e¢\u0006\u0002\u0010\u000fR#\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/storage/KeyedDeferredValueStore;", "H", ExifInterface.GPS_DIRECTION_TRUE, "", "lock", "(Ljava/lang/Object;)V", "deferred", "", "Lkotlinx/coroutines/Deferred;", "getDeferred", "()Ljava/util/Map;", "forgettingFailure", SubscriberAttributeKt.JSON_NAME_KEY, "task", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/Deferred;", "getOrPut", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class KeyedDeferredValueStore<H, T> {
    private final Map<H, Deferred<T>> deferred;
    private final Object lock;

    /* JADX WARN: Illegal instructions before constructor call */
    public KeyedDeferredValueStore() {
        DefaultConstructorMarker defaultConstructorMarker = null;
        this(defaultConstructorMarker, 1, defaultConstructorMarker);
    }

    public KeyedDeferredValueStore(Object lock) {
        Intrinsics.checkNotNullParameter(lock, "lock");
        this.lock = lock;
        this.deferred = new LinkedHashMap();
    }

    public /* synthetic */ KeyedDeferredValueStore(Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Object() { // from class: com.revenuecat.purchases.storage.KeyedDeferredValueStore.1
        } : obj);
    }

    private final Deferred<T> forgettingFailure(final H key, Function0<? extends Deferred<? extends T>> task) {
        Deferred<? extends T> deferredInvoke = task.invoke();
        deferredInvoke.invokeOnCompletion(new Function1<Throwable, Unit>(this) { // from class: com.revenuecat.purchases.storage.KeyedDeferredValueStore$forgettingFailure$1$1
            final /* synthetic */ KeyedDeferredValueStore<H, T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                if (th != null) {
                    KeyedDeferredValueStore<H, T> keyedDeferredValueStore = this.this$0;
                    Object obj = key;
                    synchronized (((KeyedDeferredValueStore) keyedDeferredValueStore).lock) {
                        keyedDeferredValueStore.getDeferred().remove(obj);
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }
        });
        return deferredInvoke;
    }

    public final Map<H, Deferred<T>> getDeferred() {
        return this.deferred;
    }

    public final Deferred<T> getOrPut(H key, Function0<? extends Deferred<? extends T>> task) {
        Deferred<T> deferredForgettingFailure;
        Intrinsics.checkNotNullParameter(task, "task");
        synchronized (this.lock) {
            deferredForgettingFailure = this.deferred.get(key);
            if (deferredForgettingFailure == null) {
                deferredForgettingFailure = forgettingFailure(key, task);
                this.deferred.put(key, deferredForgettingFailure);
            }
        }
        return deferredForgettingFailure;
    }
}
