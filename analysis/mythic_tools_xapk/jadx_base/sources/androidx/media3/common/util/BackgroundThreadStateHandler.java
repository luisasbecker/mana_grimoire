package androidx.media3.common.util;

import android.os.Looper;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;

/* JADX INFO: loaded from: classes3.dex */
public final class BackgroundThreadStateHandler<T> {
    private final HandlerWrapper backgroundHandler;
    private T backgroundState;
    private final HandlerWrapper foregroundHandler;
    private T foregroundState;
    private final StateChangeListener<T> onStateChanged;
    private int pendingOperations;

    public interface StateChangeListener<T> {
        void onStateChanged(T t, T t2);
    }

    public BackgroundThreadStateHandler(T t, Looper looper, Looper looper2, Clock clock, StateChangeListener<T> stateChangeListener) {
        this.backgroundHandler = clock.createHandler(looper, null);
        this.foregroundHandler = clock.createHandler(looper2, null);
        this.foregroundState = t;
        this.backgroundState = t;
        this.onStateChanged = stateChangeListener;
    }

    private void runInForeground(Runnable runnable) {
        if (this.foregroundHandler.getLooper().getThread().isAlive()) {
            this.foregroundHandler.post(runnable);
        }
    }

    private void updateStateInForeground(T t) {
        T t2 = this.foregroundState;
        this.foregroundState = t;
        if (t2.equals(t)) {
            return;
        }
        this.onStateChanged.onStateChanged(t2, t);
    }

    public T get() {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper == this.foregroundHandler.getLooper()) {
            return this.foregroundState;
        }
        Preconditions.checkState(looperMyLooper == this.backgroundHandler.getLooper());
        return this.backgroundState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: lambda$setStateInBackground$2$androidx-media3-common-util-BackgroundThreadStateHandler, reason: not valid java name */
    /* synthetic */ void m9738x5a135e8b(Object obj) {
        if (this.pendingOperations == 0) {
            updateStateInForeground(obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: lambda$updateStateAsync$0$androidx-media3-common-util-BackgroundThreadStateHandler, reason: not valid java name */
    /* synthetic */ void m9739xc8d4fb9b(Object obj) {
        int i = this.pendingOperations - 1;
        this.pendingOperations = i;
        if (i == 0) {
            updateStateInForeground(obj);
        }
    }

    /* JADX INFO: renamed from: lambda$updateStateAsync$1$androidx-media3-common-util-BackgroundThreadStateHandler, reason: not valid java name */
    /* synthetic */ void m9740x55c212ba(Function function) {
        final T t = (T) function.apply(this.backgroundState);
        this.backgroundState = t;
        runInForeground(new Runnable() { // from class: androidx.media3.common.util.BackgroundThreadStateHandler$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m9739xc8d4fb9b(t);
            }
        });
    }

    public void runInBackground(Runnable runnable) {
        if (this.backgroundHandler.getLooper().getThread().isAlive()) {
            this.backgroundHandler.post(runnable);
        }
    }

    public void setStateInBackground(final T t) {
        this.backgroundState = t;
        runInForeground(new Runnable() { // from class: androidx.media3.common.util.BackgroundThreadStateHandler$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m9738x5a135e8b(t);
            }
        });
    }

    public void updateStateAsync(Function<T, T> function, final Function<T, T> function2) {
        Preconditions.checkState(Looper.myLooper() == this.foregroundHandler.getLooper());
        this.pendingOperations++;
        runInBackground(new Runnable() { // from class: androidx.media3.common.util.BackgroundThreadStateHandler$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m9740x55c212ba(function2);
            }
        });
        updateStateInForeground(function.apply(this.foregroundState));
    }
}
