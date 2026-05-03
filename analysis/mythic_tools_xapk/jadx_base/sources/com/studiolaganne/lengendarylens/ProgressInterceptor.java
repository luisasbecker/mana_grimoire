package com.studiolaganne.lengendarylens;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: ProgressInterceptor.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/studiolaganne/lengendarylens/ProgressInterceptor;", "Lokhttp3/Interceptor;", "progressListener", "Lcom/studiolaganne/lengendarylens/ProgressListener;", "<init>", "(Lcom/studiolaganne/lengendarylens/ProgressListener;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ProgressInterceptor implements Interceptor {
    public static final int $stable = 8;
    private final ProgressListener progressListener;

    public ProgressInterceptor(ProgressListener progressListener) {
        Intrinsics.checkNotNullParameter(progressListener, "progressListener");
        this.progressListener = progressListener;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Response responseProceed = chain.proceed(chain.request());
        ResponseBody responseBodyBody = responseProceed.body();
        return responseBodyBody == null ? responseProceed : responseProceed.newBuilder().body(new ProgressResponseBody(responseBodyBody, this.progressListener)).build();
    }
}
