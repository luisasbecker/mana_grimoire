package com.studiolaganne.lengendarylens;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.ResponseBody;
import retrofit2.Response;

/* JADX INFO: compiled from: MTGDBHelperLocalized.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/studiolaganne/lengendarylens/UpdatableMTGHelper$downloadDBFile$1$onResponse$1$1", "Lokhttp3/Callback;", "onFailure", "", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "e", "Ljava/io/IOException;", "onResponse", "response", "Lokhttp3/Response;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UpdatableMTGHelper$downloadDBFile$1$onResponse$1$1 implements Callback {
    final /* synthetic */ Function1<String, Unit> $errorCallback;
    final /* synthetic */ String $filename;
    final /* synthetic */ FirebaseAnalytics $firebaseAnalytics;
    final /* synthetic */ Bundle $params;
    final /* synthetic */ Response<MTDBResponse> $response;
    final /* synthetic */ Function0<Unit> $successCallback;
    final /* synthetic */ UpdatableMTGHelper this$0;

    /* JADX WARN: Multi-variable type inference failed */
    UpdatableMTGHelper$downloadDBFile$1$onResponse$1$1(FirebaseAnalytics firebaseAnalytics, UpdatableMTGHelper updatableMTGHelper, Response<MTDBResponse> response, Bundle bundle, Function1<? super String, Unit> function1, String str, Function0<Unit> function0) {
        this.$firebaseAnalytics = firebaseAnalytics;
        this.this$0 = updatableMTGHelper;
        this.$response = response;
        this.$params = bundle;
        this.$errorCallback = function1;
        this.$filename = str;
        this.$successCallback = function0;
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, final IOException e) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(e, "e");
        Handler handler = new Handler(Looper.getMainLooper());
        final Function1<String, Unit> function1 = this.$errorCallback;
        final Response<MTDBResponse> response = this.$response;
        handler.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.UpdatableMTGHelper$downloadDBFile$1$onResponse$1$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                function1.invoke("Download failed with: " + e.getLocalizedMessage() + " - " + response.code());
            }
        });
        this.$firebaseAnalytics.logEvent("download_db_" + this.this$0.getDbType() + "_" + this.this$0.getLocale() + "_dl_error_http_" + this.$response.code(), this.$params);
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, final okhttp3.Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        if (!response.isSuccessful()) {
            Handler handler = new Handler(Looper.getMainLooper());
            final Function1<String, Unit> function1 = this.$errorCallback;
            handler.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.UpdatableMTGHelper$downloadDBFile$1$onResponse$1$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    function1.invoke("Download failed with code: " + response.code());
                }
            });
            this.$firebaseAnalytics.logEvent("download_db_" + this.this$0.getDbType() + "_" + this.this$0.getLocale() + "_dl_error_http_" + response.code(), this.$params);
            return;
        }
        ResponseBody responseBodyBody = response.body();
        if (responseBodyBody == null) {
            FirebaseAnalytics firebaseAnalytics = this.$firebaseAnalytics;
            UpdatableMTGHelper updatableMTGHelper = this.this$0;
            Bundle bundle = this.$params;
            final Function1<String, Unit> function12 = this.$errorCallback;
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.studiolaganne.lengendarylens.UpdatableMTGHelper$downloadDBFile$1$onResponse$1$1$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    function12.invoke("Download failed with empty response body");
                }
            });
            firebaseAnalytics.logEvent("download_db_" + updatableMTGHelper.getDbType() + "_" + updatableMTGHelper.getLocale() + "_error_invalid_dl_response", bundle);
            return;
        }
        UpdatableMTGHelper updatableMTGHelper2 = this.this$0;
        String str = this.$filename;
        FirebaseAnalytics firebaseAnalytics2 = this.$firebaseAnalytics;
        Bundle bundle2 = this.$params;
        final Function0<Unit> function0 = this.$successCallback;
        final Function1<String, Unit> function13 = this.$errorCallback;
        InputStream inputStreamByteStream = responseBodyBody.byteStream();
        File file = new File(updatableMTGHelper2.context.getDatabasePath(str).getPath());
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            ByteStreamsKt.copyTo$default(inputStreamByteStream, fileOutputStream, 0, 2, null);
            CloseableKt.closeFinally(fileOutputStream, null);
            updatableMTGHelper2.initialize();
            if (updatableMTGHelper2.isValid()) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.studiolaganne.lengendarylens.UpdatableMTGHelper$downloadDBFile$1$onResponse$1$1$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        function0.invoke();
                    }
                });
                return;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.studiolaganne.lengendarylens.UpdatableMTGHelper$downloadDBFile$1$onResponse$1$1$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    function13.invoke("Download failed with invalid database");
                }
            });
            firebaseAnalytics2.logEvent("download_db_" + updatableMTGHelper2.getDbType() + "_" + updatableMTGHelper2.getLocale() + "_error_invalid_download", bundle2);
        } finally {
        }
    }
}
