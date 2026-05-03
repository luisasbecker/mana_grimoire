package com.google.android.play.core.assetpacks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class r implements com.google.android.play.core.assetpacks.internal.as {
    @Override // com.google.android.play.core.assetpacks.internal.aw, com.google.android.play.core.assetpacks.internal.av
    public final /* synthetic */ Object a() {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.google.android.play.core.assetpacks.o
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "AssetPackBackgroundExecutor");
            }
        });
        com.google.android.play.core.assetpacks.internal.ar.a(executorServiceNewSingleThreadExecutor);
        return executorServiceNewSingleThreadExecutor;
    }
}
