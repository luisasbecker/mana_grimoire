package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.studiolaganne.lengendarylens.UpdatableMTGHelper;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: compiled from: MTGDBHelperLocalized.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0007H&J\b\u0010\u0015\u001a\u00020\u0016H\u0016J<\u0010\u0017\u001a\u00020\u00132\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00130\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00130\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/studiolaganne/lengendarylens/UpdatableMTGHelper;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "dbType", "", "getDbType", "()Ljava/lang/String;", "setDbType", "(Ljava/lang/String;)V", "currentVersion", "", "getCurrentVersion", "()I", "setCurrentVersion", "(I)V", "initialize", "", "getLang", "isValid", "", "downloadDBFile", "progressCallback", "Lkotlin/Function1;", "successCallback", "Lkotlin/Function0;", "errorCallback", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class UpdatableMTGHelper {
    public static final int $stable = 8;
    private final Context context;
    private int currentVersion;
    private String dbType;

    /* JADX INFO: renamed from: com.studiolaganne.lengendarylens.UpdatableMTGHelper$downloadDBFile$1, reason: invalid class name */
    /* JADX INFO: compiled from: MTGDBHelperLocalized.kt */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/studiolaganne/lengendarylens/UpdatableMTGHelper$downloadDBFile$1", "Lretrofit2/Callback;", "Lcom/studiolaganne/lengendarylens/MTDBResponse;", "onResponse", "", NotificationCompat.CATEGORY_CALL, "Lretrofit2/Call;", "response", "Lretrofit2/Response;", "onFailure", "t", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class AnonymousClass1 implements Callback<MTDBResponse> {
        final /* synthetic */ Function1<String, Unit> $errorCallback;
        final /* synthetic */ FirebaseAnalytics $firebaseAnalytics;
        final /* synthetic */ Bundle $params;
        final /* synthetic */ Function1<Integer, Unit> $progressCallback;
        final /* synthetic */ Function0<Unit> $successCallback;
        final /* synthetic */ UpdatableMTGHelper this$0;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function1<? super String, Unit> function1, FirebaseAnalytics firebaseAnalytics, UpdatableMTGHelper updatableMTGHelper, Bundle bundle, Function1<? super Integer, Unit> function12, Function0<Unit> function0) {
            this.$errorCallback = function1;
            this.$firebaseAnalytics = firebaseAnalytics;
            this.this$0 = updatableMTGHelper;
            this.$params = bundle;
            this.$progressCallback = function12;
            this.$successCallback = function0;
        }

        static final void onFailure$lambda$2(Function1 function1, Throwable th) {
            String localizedMessage = th.getLocalizedMessage();
            Intrinsics.checkNotNullExpressionValue(localizedMessage, "getLocalizedMessage(...)");
            function1.invoke(localizedMessage);
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<MTDBResponse> call, final Throwable t) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(t, "t");
            Handler handler = new Handler(Looper.getMainLooper());
            final Function1<String, Unit> function1 = this.$errorCallback;
            handler.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.UpdatableMTGHelper$downloadDBFile$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    UpdatableMTGHelper.AnonymousClass1.onFailure$lambda$2(function1, t);
                }
            });
            this.$firebaseAnalytics.logEvent("download_db_" + this.this$0.getDbType() + "_" + this.this$0.getLocale() + "_error_api_failure", this.$params);
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<MTDBResponse> call, Response<MTDBResponse> response) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            if (!response.isSuccessful()) {
                this.$errorCallback.invoke("Download failed with code: " + response.code());
                this.$firebaseAnalytics.logEvent("download_db_" + this.this$0.getDbType() + "_" + this.this$0.getLocale() + "_api_error_http_" + response.code(), this.$params);
                return;
            }
            MTDBResponse mTDBResponseBody = response.body();
            if (mTDBResponseBody == null) {
                FirebaseAnalytics firebaseAnalytics = this.$firebaseAnalytics;
                UpdatableMTGHelper updatableMTGHelper = this.this$0;
                Bundle bundle = this.$params;
                final Function1<String, Unit> function1 = this.$errorCallback;
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.studiolaganne.lengendarylens.UpdatableMTGHelper$downloadDBFile$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        function1.invoke("Download failed with empty response body");
                    }
                });
                firebaseAnalytics.logEvent("download_db_" + updatableMTGHelper.getDbType() + "_" + updatableMTGHelper.getLocale() + "_error_invalid_api_response", bundle);
                return;
            }
            Function1<Integer, Unit> function12 = this.$progressCallback;
            FirebaseAnalytics firebaseAnalytics2 = this.$firebaseAnalytics;
            UpdatableMTGHelper updatableMTGHelper2 = this.this$0;
            Bundle bundle2 = this.$params;
            Function1<String, Unit> function13 = this.$errorCallback;
            Function0<Unit> function0 = this.$successCallback;
            String filename = mTDBResponseBody.getFilename();
            new OkHttpClient.Builder().dns(new Dns() { // from class: com.studiolaganne.lengendarylens.UpdatableMTGHelper$downloadDBFile$1$onResponse$1$ipv4OnlyDns$1
                @Override // okhttp3.Dns
                public List<InetAddress> lookup(String hostname) throws UnknownHostException {
                    Intrinsics.checkNotNullParameter(hostname, "hostname");
                    InetAddress[] allByName = InetAddress.getAllByName(hostname);
                    Intrinsics.checkNotNullExpressionValue(allByName, "getAllByName(...)");
                    ArrayList arrayList = new ArrayList();
                    for (InetAddress inetAddress : allByName) {
                        if (inetAddress instanceof Inet4Address) {
                            arrayList.add(inetAddress);
                        }
                    }
                    return arrayList;
                }
            }).readTimeout(15L, TimeUnit.MINUTES).writeTimeout(15L, TimeUnit.MINUTES).connectTimeout(10L, TimeUnit.SECONDS).addInterceptor(new ProgressInterceptor(new UpdatableMTGHelper$downloadDBFile$1$onResponse$1$okHttpClientWithProgress$1(function12))).build().newCall(new Request.Builder().url(mTDBResponseBody.getUrl()).build()).enqueue(new UpdatableMTGHelper$downloadDBFile$1$onResponse$1$1(firebaseAnalytics2, updatableMTGHelper2, response, bundle2, function13, filename, function0));
        }
    }

    public UpdatableMTGHelper(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.dbType = "";
    }

    public final void downloadDBFile(Function1<? super Integer, Unit> progressCallback, Function0<Unit> successCallback, Function1<? super String, Unit> errorCallback) {
        Intrinsics.checkNotNullParameter(progressCallback, "progressCallback");
        Intrinsics.checkNotNullParameter(successCallback, "successCallback");
        Intrinsics.checkNotNullParameter(errorCallback, "errorCallback");
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(this.context);
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        Bundle bundle = new Bundle();
        bundle.putString("language_code", getLocale());
        Breadcrumbs.INSTANCE.leaveBreadcrumb("download_db_" + this.dbType + "_" + getLocale());
        firebaseAnalytics.logEvent("download_db_" + this.dbType + "_" + getLocale(), bundle);
        MTApiKt.getMtApi().downloadDB(this.dbType, getLocale()).enqueue(new AnonymousClass1(errorCallback, firebaseAnalytics, this, bundle, progressCallback, successCallback));
    }

    public final int getCurrentVersion() {
        return this.currentVersion;
    }

    public final String getDbType() {
        return this.dbType;
    }

    /* JADX INFO: renamed from: getLang */
    public abstract String getLocale();

    public void initialize() {
    }

    public boolean isValid() {
        return false;
    }

    public final void setCurrentVersion(int i) {
        this.currentVersion = i;
    }

    public final void setDbType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dbType = str;
    }
}
