package com.segment.analytics.kotlin.core;

import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import sovran.kotlin.Store;

/* JADX INFO: compiled from: Configuration.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0012\u0010\f\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/segment/analytics/kotlin/core/CoroutineConfiguration;", "", "analyticsDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getAnalyticsDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "analyticsScope", "Lkotlinx/coroutines/CoroutineScope;", "getAnalyticsScope", "()Lkotlinx/coroutines/CoroutineScope;", "fileIODispatcher", "getFileIODispatcher", "networkIODispatcher", "getNetworkIODispatcher", ProductResponseJsonKeys.STORE, "Lsovran/kotlin/Store;", "getStore", "()Lsovran/kotlin/Store;", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface CoroutineConfiguration {
    CoroutineDispatcher getAnalyticsDispatcher();

    CoroutineScope getAnalyticsScope();

    CoroutineDispatcher getFileIODispatcher();

    CoroutineDispatcher getNetworkIODispatcher();

    Store getStore();
}
