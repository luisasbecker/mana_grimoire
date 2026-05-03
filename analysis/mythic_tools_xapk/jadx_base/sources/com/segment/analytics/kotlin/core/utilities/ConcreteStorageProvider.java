package com.segment.analytics.kotlin.core.utilities;

import com.facebook.internal.NativeProtocol;
import com.segment.analytics.kotlin.core.Analytics;
import com.segment.analytics.kotlin.core.Configuration;
import com.segment.analytics.kotlin.core.Storage;
import com.segment.analytics.kotlin.core.StorageProvider;
import java.io.File;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import sovran.kotlin.Store;

/* JADX INFO: compiled from: StorageImpl.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0016¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/segment/analytics/kotlin/core/utilities/ConcreteStorageProvider;", "Lcom/segment/analytics/kotlin/core/StorageProvider;", "()V", "createStorage", "Lcom/segment/analytics/kotlin/core/Storage;", NativeProtocol.WEB_DIALOG_PARAMS, "", "", "([Ljava/lang/Object;)Lcom/segment/analytics/kotlin/core/Storage;", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ConcreteStorageProvider implements StorageProvider {
    public static final ConcreteStorageProvider INSTANCE = new ConcreteStorageProvider();

    private ConcreteStorageProvider() {
    }

    @Override // com.segment.analytics.kotlin.core.StorageProvider
    public Storage createStorage(Object... params) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (params.length != 0) {
            Object obj = params[0];
            if (obj instanceof Analytics) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.segment.analytics.kotlin.core.Analytics");
                Analytics analytics = (Analytics) obj;
                Configuration configuration = analytics.getConfiguration();
                File file = new File("/tmp/analytics-kotlin/" + configuration.getWriteKey());
                File file2 = new File(file, "events");
                return new StorageImpl(new PropertiesFile(new File(file, "analytics-kotlin-" + configuration.getWriteKey() + ".properties")), new FileEventStream(file2), analytics.getStore(), configuration.getWriteKey(), "segment.events.file.index." + configuration.getWriteKey(), analytics.getFileIODispatcher());
            }
        }
        throw new IllegalArgumentException("Invalid parameters for ConcreteStorageProvider. ConcreteStorageProvider requires at least 1 parameter and the first argument has to be an instance of Analytics");
    }

    @Override // com.segment.analytics.kotlin.core.StorageProvider
    @Deprecated(message = "Deprecated in favor of create which takes vararg params", replaceWith = @ReplaceWith(expression = "createStorage(analytics, store, writeKey, ioDispatcher, application)", imports = {}))
    public Storage getStorage(Analytics analytics, Store store, String str, CoroutineDispatcher coroutineDispatcher, Object obj) {
        return StorageProvider.DefaultImpls.getStorage(this, analytics, store, str, coroutineDispatcher, obj);
    }
}
