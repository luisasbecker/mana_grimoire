package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.util.Log;
import com.google.common.net.HttpHeaders;
import com.google.firebase.auth.FirebaseAuth;
import com.google.gson.Gson;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: TokenRefreshInterceptor.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/studiolaganne/lengendarylens/TokenRefreshInterceptor;", "Lokhttp3/Interceptor;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "TAG", "", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "buildAuthErrorResponse", "originalRequest", "Lokhttp3/Request;", "originalResponse", "errorCode", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TokenRefreshInterceptor implements Interceptor {
    public static final int $stable = 8;
    private final String TAG;
    private final Context context;

    public TokenRefreshInterceptor(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.TAG = "TokenRefreshInterceptor";
    }

    private final Response buildAuthErrorResponse(Request originalRequest, Response originalResponse, int errorCode) {
        Response.Builder builderMessage = new Response.Builder().request(originalRequest).protocol(originalResponse.protocol()).code(401).message("Unauthorized - Authentication failed");
        ResponseBody.Companion companion = ResponseBody.INSTANCE;
        String str = "{\"code\":" + errorCode + ",\"message\":\"Firebase authentication failed. Please sign in again.\"}";
        ResponseBody responseBodyBody = originalResponse.body();
        return builderMessage.body(companion.create(str, responseBodyBody != null ? responseBodyBody.get$contentType() : null)).build();
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        Response responseProceed = chain.proceed(request);
        if (responseProceed.code() == 401) {
            try {
                MTResponse mTResponse = (MTResponse) new Gson().fromJson(responseProceed.peekBody(4096L).string(), MTResponse.class);
                if (mTResponse.getCode() == MTError.FIREBASE_TOKEN_EXPIRED.getCode() || mTResponse.getCode() == MTError.FIREBASE_ERROR.getCode()) {
                    Log.d(this.TAG, "Firebase auth error detected (code " + mTResponse.getCode() + "), attempting refresh");
                    if (FirebaseAuth.getInstance().getCurrentUser() == null) {
                        Log.w(this.TAG, "Firebase currentUser is null - cannot refresh token");
                        responseProceed.close();
                        AuthErrorHandler.INSTANCE.broadcastAuthError(this.context, mTResponse.getCode(), "Firebase session expired. Please sign in again.");
                        return buildAuthErrorResponse(request, responseProceed, mTResponse.getCode());
                    }
                    responseProceed.close();
                    TokenRefreshResult tokenRefreshResult = (TokenRefreshResult) BuildersKt__BuildersKt.runBlocking$default(null, new TokenRefreshInterceptor$intercept$refreshResult$1(this, null), 1, null);
                    String token = tokenRefreshResult.getToken();
                    String str = this.TAG;
                    if (token != null) {
                        Log.d(str, "Token refreshed successfully, retrying request");
                        return chain.proceed(request.newBuilder().removeHeader(HttpHeaders.AUTHORIZATION).addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + StringsKt.trimEnd(StringsKt.trim((CharSequence) tokenRefreshResult.getToken()).toString(), AbstractJsonLexerKt.COMMA)).build());
                    }
                    Log.w(str, "Failed to refresh token: " + tokenRefreshResult.getFailureReason());
                    AuthErrorHandler authErrorHandler = AuthErrorHandler.INSTANCE;
                    Context context = this.context;
                    int code = mTResponse.getCode();
                    String failureReason = tokenRefreshResult.getFailureReason();
                    if (failureReason == null) {
                        failureReason = "Token refresh failed";
                    }
                    authErrorHandler.broadcastAuthError(context, code, failureReason);
                    return buildAuthErrorResponse(request, responseProceed, mTResponse.getCode());
                }
            } catch (Exception e) {
                Log.e(this.TAG, "Error parsing response JSON: " + e.getMessage(), e);
            }
        }
        return responseProceed;
    }
}
