package com.segment.analytics.kotlin.android;

import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import com.segment.analytics.kotlin.core.Storage;
import com.segment.analytics.kotlin.core.utilities.EventStream;
import com.segment.analytics.kotlin.core.utilities.KVS;
import com.segment.analytics.kotlin.core.utilities.StorageImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import sovran.kotlin.Store;

/* JADX INFO: compiled from: Storage.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0011"}, d2 = {"Lcom/segment/analytics/kotlin/android/AndroidStorageImpl;", "Lcom/segment/analytics/kotlin/core/utilities/StorageImpl;", "propertiesFile", "Lcom/segment/analytics/kotlin/core/utilities/KVS;", "eventStream", "Lcom/segment/analytics/kotlin/core/utilities/EventStream;", ProductResponseJsonKeys.STORE, "Lsovran/kotlin/Store;", "writeKey", "", "fileIndexKey", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/segment/analytics/kotlin/core/utilities/KVS;Lcom/segment/analytics/kotlin/core/utilities/EventStream;Lsovran/kotlin/Store;Ljava/lang/String;Ljava/lang/String;Lkotlinx/coroutines/CoroutineDispatcher;)V", "read", SubscriberAttributeKt.JSON_NAME_KEY, "Lcom/segment/analytics/kotlin/core/Storage$Constants;", "android_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class AndroidStorageImpl extends StorageImpl {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidStorageImpl(KVS propertiesFile, EventStream eventStream, Store store, String writeKey, String fileIndexKey, CoroutineDispatcher ioDispatcher) {
        super(propertiesFile, eventStream, store, writeKey, fileIndexKey, ioDispatcher);
        Intrinsics.checkNotNullParameter(propertiesFile, "propertiesFile");
        Intrinsics.checkNotNullParameter(eventStream, "eventStream");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(writeKey, "writeKey");
        Intrinsics.checkNotNullParameter(fileIndexKey, "fileIndexKey");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
    }

    @Override // com.segment.analytics.kotlin.core.utilities.StorageImpl, com.segment.analytics.kotlin.core.Storage
    public String read(Storage.Constants key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (key != Storage.Constants.LegacyAppBuild) {
            return super.read(key);
        }
        int i = getPropertiesFile().get(key.getRawVal(), -1);
        if (i != -1) {
            return String.valueOf(i);
        }
        return null;
    }
}
