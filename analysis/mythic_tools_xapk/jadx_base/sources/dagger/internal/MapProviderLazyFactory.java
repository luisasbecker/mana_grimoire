package dagger.internal;

import dagger.Lazy;
import dagger.internal.AbstractMapFactory;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public final class MapProviderLazyFactory<K, V> extends AbstractMapFactory<K, V, Provider<Lazy<V>>> {
    private static final Provider<Map<Object, Object>> EMPTY = InstanceFactory.create(Collections.emptyMap());

    public static final class Builder<K, V> extends AbstractMapFactory.Builder<K, V, Provider<Lazy<V>>> {
        private Builder(int i) {
            super(i);
        }

        public MapProviderLazyFactory<K, V> build() {
            return new MapProviderLazyFactory<>(this.map);
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
        public Builder<K, V> putAll(Provider<Map<K, Provider<Lazy<V>>>> provider) {
            super.putAll((Provider) provider);
            return this;
        }

        @Deprecated
        public Builder<K, V> putAll(javax.inject.Provider<Map<K, Provider<Lazy<V>>>> provider) {
            return putAll((Provider) Providers.asDaggerProvider(provider));
        }
    }

    private MapProviderLazyFactory(Map<K, Provider<V>> map) {
        super(map);
    }

    public static <K, V> Builder<K, V> builder(int i) {
        return new Builder<>(i);
    }

    public static <K, V> Provider<Map<K, Provider<Lazy<V>>>> emptyMapProvider() {
        return (Provider<Map<K, Provider<Lazy<V>>>>) EMPTY;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Map<K, Provider<Lazy<V>>> get() {
        LinkedHashMap linkedHashMapNewLinkedHashMapWithExpectedSize = DaggerCollections.newLinkedHashMapWithExpectedSize(contributingMap().size());
        for (final Map.Entry<K, Provider<V>> entry : contributingMap().entrySet()) {
            linkedHashMapNewLinkedHashMapWithExpectedSize.put(entry.getKey(), new Provider() { // from class: dagger.internal.MapProviderLazyFactory$$ExternalSyntheticLambda0
                @Override // javax.inject.Provider, jakarta.inject.Provider
                public final Object get() {
                    return DoubleCheck.lazy((Provider) entry.getValue());
                }
            });
        }
        return Collections.unmodifiableMap(linkedHashMapNewLinkedHashMapWithExpectedSize);
    }
}
