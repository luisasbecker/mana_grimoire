package com.segment.analytics.kotlin.android;

import android.content.Context;
import android.content.SharedPreferences;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.segment.analytics.kotlin.android.utilities.AndroidKVS;
import com.segment.analytics.kotlin.core.utilities.FileEventStream;
import java.io.File;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import org.apache.commons.io.FilenameUtils;
import sovran.kotlin.Store;

/* JADX INFO: compiled from: Storage.kt */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated(message = "Use StorageProvider to create storage for Android instead")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/segment/analytics/kotlin/android/AndroidStorage;", "Lcom/segment/analytics/kotlin/android/AndroidStorageImpl;", "context", "Landroid/content/Context;", ProductResponseJsonKeys.STORE, "Lsovran/kotlin/Store;", "writeKey", "", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "directory", "subject", "(Landroid/content/Context;Lsovran/kotlin/Store;Ljava/lang/String;Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/String;Ljava/lang/String;)V", "android_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidStorage extends AndroidStorageImpl {
    public AndroidStorage(Context context, Store store, String writeKey, CoroutineDispatcher ioDispatcher, String str, String str2) {
        StringBuilder sb;
        StringBuilder sbAppend;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(writeKey, "writeKey");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        SharedPreferences sharedPreferences = context.getSharedPreferences("analytics-android-" + writeKey, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…y\", Context.MODE_PRIVATE)");
        AndroidKVS androidKVS = new AndroidKVS(sharedPreferences);
        File dir = context.getDir(str == null ? "segment-disk-queue" : str, 0);
        Intrinsics.checkNotNullExpressionValue(dir, "context.getDir(directory…e\", Context.MODE_PRIVATE)");
        FileEventStream fileEventStream = new FileEventStream(dir);
        if (str2 == null) {
            sb = new StringBuilder("segment.events.file.index.");
            sbAppend = sb.append(writeKey);
        } else {
            sb = new StringBuilder("segment.events.file.index.");
            sbAppend = sb.append(writeKey).append(FilenameUtils.EXTENSION_SEPARATOR).append(str2);
        }
        super(androidKVS, fileEventStream, store, writeKey, sbAppend.toString(), ioDispatcher);
    }

    public /* synthetic */ AndroidStorage(Context context, Store store, String str, CoroutineDispatcher coroutineDispatcher, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, store, str, coroutineDispatcher, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : str3);
    }
}
