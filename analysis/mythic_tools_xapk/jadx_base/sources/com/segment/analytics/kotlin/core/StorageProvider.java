package com.segment.analytics.kotlin.core;

import androidx.media3.common.MimeTypes;
import com.facebook.internal.NativeProtocol;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import sovran.kotlin.Store;

/* JADX INFO: compiled from: Storage.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0005\"\u00020\u0001H&¢\u0006\u0002\u0010\u0006J0\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0001H\u0017¨\u0006\u0011"}, d2 = {"Lcom/segment/analytics/kotlin/core/StorageProvider;", "", "createStorage", "Lcom/segment/analytics/kotlin/core/Storage;", NativeProtocol.WEB_DIALOG_PARAMS, "", "([Ljava/lang/Object;)Lcom/segment/analytics/kotlin/core/Storage;", "getStorage", "analytics", "Lcom/segment/analytics/kotlin/core/Analytics;", ProductResponseJsonKeys.STORE, "Lsovran/kotlin/Store;", "writeKey", "", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", MimeTypes.BASE_TYPE_APPLICATION, "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface StorageProvider {

    /* JADX INFO: compiled from: Storage.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated(message = "Deprecated in favor of create which takes vararg params", replaceWith = @ReplaceWith(expression = "createStorage(analytics, store, writeKey, ioDispatcher, application)", imports = {}))
        public static Storage getStorage(StorageProvider storageProvider, Analytics analytics, Store store, String writeKey, CoroutineDispatcher ioDispatcher, Object application) {
            Intrinsics.checkNotNullParameter(analytics, "analytics");
            Intrinsics.checkNotNullParameter(store, "store");
            Intrinsics.checkNotNullParameter(writeKey, "writeKey");
            Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
            Intrinsics.checkNotNullParameter(application, "application");
            return storageProvider.createStorage(analytics, store, writeKey, ioDispatcher, application);
        }
    }

    Storage createStorage(Object... params);

    @Deprecated(message = "Deprecated in favor of create which takes vararg params", replaceWith = @ReplaceWith(expression = "createStorage(analytics, store, writeKey, ioDispatcher, application)", imports = {}))
    Storage getStorage(Analytics analytics, Store store, String writeKey, CoroutineDispatcher ioDispatcher, Object application);
}
