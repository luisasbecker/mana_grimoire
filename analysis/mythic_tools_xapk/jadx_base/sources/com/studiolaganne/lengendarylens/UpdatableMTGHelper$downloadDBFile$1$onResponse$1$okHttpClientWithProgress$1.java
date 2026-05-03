package com.studiolaganne.lengendarylens;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTGDBHelperLocalized.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/studiolaganne/lengendarylens/UpdatableMTGHelper$downloadDBFile$1$onResponse$1$okHttpClientWithProgress$1", "Lcom/studiolaganne/lengendarylens/ProgressListener;", "onProgressUpdate", "", "percentage", "", "onDownloadComplete", "onDownloadFailed", "error", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UpdatableMTGHelper$downloadDBFile$1$onResponse$1$okHttpClientWithProgress$1 implements ProgressListener {
    final /* synthetic */ Function1<Integer, Unit> $progressCallback;

    /* JADX WARN: Multi-variable type inference failed */
    UpdatableMTGHelper$downloadDBFile$1$onResponse$1$okHttpClientWithProgress$1(Function1<? super Integer, Unit> function1) {
        this.$progressCallback = function1;
    }

    @Override // com.studiolaganne.lengendarylens.ProgressListener
    public void onDownloadComplete() {
    }

    @Override // com.studiolaganne.lengendarylens.ProgressListener
    public void onDownloadFailed(String error) {
        Intrinsics.checkNotNullParameter(error, "error");
    }

    @Override // com.studiolaganne.lengendarylens.ProgressListener
    public void onProgressUpdate(final int percentage) {
        Handler handler = new Handler(Looper.getMainLooper());
        final Function1<Integer, Unit> function1 = this.$progressCallback;
        handler.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.UpdatableMTGHelper$downloadDBFile$1$onResponse$1$okHttpClientWithProgress$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                function1.invoke(Integer.valueOf(percentage));
            }
        });
    }
}
