package retrofit2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import retrofit2.CallAdapter;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes7.dex */
class BuiltInFactories {

    static final class Java8 extends BuiltInFactories {
        Java8() {
        }

        @Override // retrofit2.BuiltInFactories
        List<? extends CallAdapter.Factory> createDefaultCallAdapterFactories(@Nullable Executor executor) {
            return Arrays.asList(new CompletableFutureCallAdapterFactory(), new DefaultCallAdapterFactory(executor));
        }

        @Override // retrofit2.BuiltInFactories
        List<? extends Converter.Factory> createDefaultConverterFactories() {
            return Collections.singletonList(new OptionalConverterFactory());
        }
    }

    BuiltInFactories() {
    }

    List<? extends CallAdapter.Factory> createDefaultCallAdapterFactories(@Nullable Executor executor) {
        return Collections.singletonList(new DefaultCallAdapterFactory(executor));
    }

    List<? extends Converter.Factory> createDefaultConverterFactories() {
        return Collections.emptyList();
    }
}
