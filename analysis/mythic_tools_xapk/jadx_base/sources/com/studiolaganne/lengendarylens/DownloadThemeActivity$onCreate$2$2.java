package com.studiolaganne.lengendarylens;

import android.widget.ProgressBar;
import android.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DownloadThemeActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/studiolaganne/lengendarylens/DownloadThemeActivity$onCreate$2$2", "Lcom/studiolaganne/lengendarylens/ProgressListener;", "onProgressUpdate", "", "percentage", "", "onDownloadComplete", "onDownloadFailed", "error", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DownloadThemeActivity$onCreate$2$2 implements ProgressListener {
    final /* synthetic */ ProgressBar $progressBar;
    final /* synthetic */ DownloadThemeActivity this$0;

    DownloadThemeActivity$onCreate$2$2(ProgressBar progressBar, DownloadThemeActivity downloadThemeActivity) {
        this.$progressBar = progressBar;
        this.this$0 = downloadThemeActivity;
    }

    @Override // com.studiolaganne.lengendarylens.ProgressListener
    public void onDownloadComplete() {
        final DownloadThemeActivity downloadThemeActivity = this.this$0;
        downloadThemeActivity.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.DownloadThemeActivity$onCreate$2$2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Toast.makeText(downloadThemeActivity, "Download Complete", 0).show();
            }
        });
    }

    @Override // com.studiolaganne.lengendarylens.ProgressListener
    public void onDownloadFailed(final String error) {
        Intrinsics.checkNotNullParameter(error, "error");
        final DownloadThemeActivity downloadThemeActivity = this.this$0;
        downloadThemeActivity.runOnUiThread(new Runnable() { // from class: com.studiolaganne.lengendarylens.DownloadThemeActivity$onCreate$2$2$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                Toast.makeText(downloadThemeActivity, "Download failed: " + error, 0).show();
            }
        });
    }

    @Override // com.studiolaganne.lengendarylens.ProgressListener
    public void onProgressUpdate(int percentage) {
        this.$progressBar.setProgress(percentage);
    }
}
