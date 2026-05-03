package androidx.lifecycle;

import androidx.arch.core.internal.SafeIterableMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class MediatorLiveData<T> extends MutableLiveData<T> {
    private SafeIterableMap<LiveData<?>, Source<?>> mSources;

    private static class Source<V> implements Observer<V> {
        final LiveData<V> mLiveData;
        final Observer<? super V> mObserver;
        int mVersion = -1;

        Source(LiveData<V> liveData, Observer<? super V> observer) {
            this.mLiveData = liveData;
            this.mObserver = observer;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(V v) {
            if (this.mVersion != this.mLiveData.getVersion()) {
                this.mVersion = this.mLiveData.getVersion();
                this.mObserver.onChanged(v);
            }
        }

        void plug() {
            this.mLiveData.observeForever(this);
        }

        void unplug() {
            this.mLiveData.removeObserver(this);
        }
    }

    public MediatorLiveData() {
        this.mSources = new SafeIterableMap<>();
    }

    public MediatorLiveData(T t) {
        super(t);
        this.mSources = new SafeIterableMap<>();
    }

    public <S> void addSource(LiveData<S> liveData, Observer<? super S> observer) {
        if (liveData == null) {
            throw new NullPointerException("source cannot be null");
        }
        Source<?> source = new Source<>(liveData, observer);
        Source<?> sourcePutIfAbsent = this.mSources.putIfAbsent(liveData, source);
        if (sourcePutIfAbsent != null && sourcePutIfAbsent.mObserver != observer) {
            throw new IllegalArgumentException("This source was already added with the different observer");
        }
        if (sourcePutIfAbsent == null && hasActiveObservers()) {
            source.plug();
        }
    }

    @Override // androidx.lifecycle.LiveData
    protected void onActive() {
        Iterator<Map.Entry<LiveData<?>, Source<?>>> it = this.mSources.iterator();
        while (it.hasNext()) {
            it.next().getValue().plug();
        }
    }

    @Override // androidx.lifecycle.LiveData
    protected void onInactive() {
        Iterator<Map.Entry<LiveData<?>, Source<?>>> it = this.mSources.iterator();
        while (it.hasNext()) {
            it.next().getValue().unplug();
        }
    }

    public <S> void removeSource(LiveData<S> liveData) {
        Source<?> sourceRemove = this.mSources.remove(liveData);
        if (sourceRemove != null) {
            sourceRemove.unplug();
        }
    }
}
