package com.studiolaganne.lengendarylens;

import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

/* JADX INFO: compiled from: MTApi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/studiolaganne/lengendarylens/LoggingInterceptor;", "Lokhttp3/Interceptor;", "<init>", "()V", "bodyToString", "", "request", "Lokhttp3/RequestBody;", "bodyToHexString", "response", "Lokhttp3/ResponseBody;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LoggingInterceptor implements Interceptor {
    public static final int $stable = 0;

    private final String bodyToHexString(RequestBody request) {
        try {
            Buffer buffer = new Buffer();
            request.writeTo(buffer);
            return ArraysKt.joinToString$default(buffer.readByteArray(), (CharSequence) " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.studiolaganne.lengendarylens.LoggingInterceptor$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return LoggingInterceptor.bodyToHexString$lambda$0(((Byte) obj).byteValue());
                }
            }, 30, (Object) null);
        } catch (IOException unused) {
            return "did not work";
        }
    }

    private final String bodyToHexString(ResponseBody response) {
        try {
            BufferedSource source = response.getSource();
            source.request(Long.MAX_VALUE);
            return ArraysKt.joinToString$default(source.getBufferField().clone().readByteArray(), (CharSequence) " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.studiolaganne.lengendarylens.LoggingInterceptor$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return LoggingInterceptor.bodyToHexString$lambda$1(((Byte) obj).byteValue());
                }
            }, 30, (Object) null);
        } catch (IOException unused) {
            return "did not work";
        }
    }

    static final CharSequence bodyToHexString$lambda$0(byte b) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("0x%02X", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    static final CharSequence bodyToHexString$lambda$1(byte b) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("0x%02X", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str + "-'" + ((int) b) + "'";
    }

    private final String bodyToString(RequestBody request) {
        try {
            Buffer buffer = new Buffer();
            request.writeTo(buffer);
            return buffer.readUtf8();
        } catch (IOException unused) {
            return "did not work";
        }
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        RequestBody requestBodyBody = request.body();
        if (requestBodyBody != null) {
            Buffer buffer = new Buffer();
            requestBodyBody.writeTo(buffer);
            request = request.newBuilder().method(request.method(), RequestBody.Companion.create$default(RequestBody.INSTANCE, buffer.readByteArray(), requestBodyBody.getContentType(), 0, 0, 6, (Object) null)).build();
        }
        String strHeader = request.header(HttpHeaders.AUTHORIZATION);
        if (strHeader != null) {
            strHeader.length();
        }
        return chain.proceed(request);
    }
}
