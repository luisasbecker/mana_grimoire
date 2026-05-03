package dagger.internal;

import dagger.Lazy;
import dagger.internal.AbstractMapFactory;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public final class MapLazyFactory<K, V> extends AbstractMapFactory<K, V, Lazy<V>> {
    private static final Provider<Map<Object, Object>> EMPTY = InstanceFactory.create(Collections.emptyMap());

    public static final class Builder<K, V> extends AbstractMapFactory.Builder<K, V, Lazy<V>> {
        private Builder(int i) {
            super(i);
        }

        public MapLazyFactory<K, V> build() {
            return new MapLazyFactory<>(this.map);
        }

        @Override // dagger.internal.AbstractMapFactory.Builder
        public Builder<K, V> put(K k, Provider<V> provider) {
            super.put((Object) k, (Provider) provider);
            return this;
        }

        @Deprecated
        public Builder<K, V> put(K k, javax.inject.Provider<V> provider) {
            return put((Object) k, (Provider) Providers.asDaggerProvider(provider));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // dagger.internal.AbstractMapFactory.Builder
        public Builder<K, V> putAll(Provider<Map<K, Lazy<V>>> provider) {
            super.putAll((Provider) provider);
            return this;
        }

        @Deprecated
        public Builder<K, V> putAll(javax.inject.Provider<Map<K, Lazy<V>>> provider) {
            return putAll((Provider) Providers.asDaggerProvider(provider));
        }
    }

    private MapLazyFactory(Map<K, Provider<V>> map) {
        super(map);
    }

    public static <K, V> Builder<K, V> builder(int i) {
        return new Builder<>(i);
    }

    public static <K, V> Provider<Map<K, Lazy<V>>> emptyMapProvider() {
        return (Provider<Map<K, Lazy<V>>>) EMPTY;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Map<K, Lazy<V>> get() {
        LinkedHashMap linkedHashMapNewLinkedHashMapWithExpectedSize = DaggerCollections.newLinkedHashMapWithExpectedSize(contributingMap().size());
        for (Map.Entry<K, Provider<V>> entry : contributingMap().entrySet()) {
            linkedHashMapNewLinkedHashMapWithExpectedSize.put(entry.getKey(), DoubleCheck.lazy((Provider) entry.getValue()));
        }
        return Collections.unmodifiableMap(linkedHashMapNewLinkedHashMapWithExpectedSize);
    }
}
