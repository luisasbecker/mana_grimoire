package dagger.internal;

import dagger.Lazy;
import dagger.internal.AbstractMapFactory;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public final class MapProviderFactory<K, V> extends AbstractMapFactory<K, V, Provider<V>> implements Lazy<Map<K, Provider<V>>> {

    public static final class Builder<K, V> extends AbstractMapFactory.Builder<K, V, Provider<V>> {
        private Builder(int i) {
            super(i);
        }

        public MapProviderFactory<K, V> build() {
            return new MapProviderFactory<>(this.map);
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
        public Builder<K, V> putAll(Provider<Map<K, Provider<V>>> provider) {
            super.putAll((Provider) provider);
            return this;
        }

        @Deprecated
        public Builder<K, V> putAll(final javax.inject.Provider<Map<K, javax.inject.Provider<V>>> provider) {
            return putAll((Provider) new Provider<Map<K, Provider<V>>>() { // from class: dagger.internal.MapProviderFactory.Builder.1
                @Override // javax.inject.Provider, jakarta.inject.Provider
                public Map<K, Provider<V>> get() {
                    Map map = (Map) provider.get();
                    if (map.isEmpty()) {
                        return Collections.emptyMap();
                    }
                    LinkedHashMap linkedHashMapNewLinkedHashMapWithExpectedSize = DaggerCollections.newLinkedHashMapWithExpectedSize(map.size());
                    for (Map.Entry<K, V> entry : map.entrySet()) {
                        linkedHashMapNewLinkedHashMapWithExpectedSize.put(entry.getKey(), Providers.asDaggerProvider((javax.inject.Provider) entry.getValue()));
                    }
                    return Collections.unmodifiableMap(linkedHashMapNewLinkedHashMapWithExpectedSize);
                }
            });
        }
    }

    private MapProviderFactory(Map<K, Provider<V>> map) {
        super(map);
    }

    public static <K, V> Builder<K, V> builder(int i) {
        return new Builder<>(i);
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Map<K, Provider<V>> get() {
        return contributingMap();
    }
}
