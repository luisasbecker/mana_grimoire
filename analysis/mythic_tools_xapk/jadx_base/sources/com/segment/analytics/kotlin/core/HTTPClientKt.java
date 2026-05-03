package com.segment.analytics.kotlin.core;

import com.google.common.net.HttpHeaders;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: HTTPClient.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0003H\u0000\u001a\f\u0010\u0006\u001a\u00020\u0005*\u00020\u0003H\u0000¨\u0006\u0007"}, d2 = {"safeGetInputStream", "Ljava/io/InputStream;", "connection", "Ljava/net/HttpURLConnection;", "createGetConnection", "Lcom/segment/analytics/kotlin/core/Connection;", "createPostConnection", "core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class HTTPClientKt {
    public static final Connection createGetConnection(HttpURLConnection httpURLConnection) {
        Intrinsics.checkNotNullParameter(httpURLConnection, "<this>");
        return new Connection(httpURLConnection, safeGetInputStream(httpURLConnection)) { // from class: com.segment.analytics.kotlin.core.HTTPClientKt.createGetConnection.1
            @Override // com.segment.analytics.kotlin.core.Connection, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                super.close();
                InputStream inputStream = getInputStream();
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        };
    }

    public static final Connection createPostConnection(HttpURLConnection httpURLConnection) {
        GZIPOutputStream outputStream;
        Intrinsics.checkNotNullParameter(httpURLConnection, "<this>");
        String requestProperty = httpURLConnection.getRequestProperty(HttpHeaders.CONTENT_ENCODING);
        if (requestProperty == null) {
            requestProperty = "";
        }
        if (StringsKt.contains$default((CharSequence) requestProperty, (CharSequence) "gzip", false, 2, (Object) null)) {
            outputStream = new GZIPOutputStream(httpURLConnection.getOutputStream());
        } else {
            outputStream = httpURLConnection.getOutputStream();
            Intrinsics.checkNotNullExpressionValue(outputStream, "{\n            this.outputStream\n        }");
        }
        return new Connection(httpURLConnection, outputStream) { // from class: com.segment.analytics.kotlin.core.HTTPClientKt.createPostConnection.1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Not initialized variable reg: 3, insn: 0x008f: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:37:0x008f */
            /* JADX WARN: Removed duplicated region for block: B:39:0x0092 A[Catch: all -> 0x00a3, TryCatch #4 {all -> 0x00a3, blocks: (B:3:0x0002, B:25:0x004c, B:34:0x006e, B:35:0x008d, B:39:0x0092, B:40:0x0095), top: B:55:0x0002 }] */
            @Override // com.segment.analytics.kotlin.core.Connection, java.io.Closeable, java.lang.AutoCloseable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void close() throws IOException {
                OutputStream outputStream2;
                InputStream inputStreamSafeGetInputStream;
                IOException e;
                InputStream inputStream;
                try {
                    int responseCode = getConnection().getResponseCode();
                    if (responseCode < 300) {
                        if (outputStream2 != null) {
                            return;
                        } else {
                            return;
                        }
                    }
                    InputStream inputStream2 = null;
                    String str = null;
                    try {
                        try {
                            inputStreamSafeGetInputStream = HTTPClientKt.safeGetInputStream(getConnection());
                            if (inputStreamSafeGetInputStream != null) {
                                try {
                                    InputStreamReader inputStreamReader = new InputStreamReader(inputStreamSafeGetInputStream, Charsets.UTF_8);
                                    BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                                    try {
                                        String text = TextStreamsKt.readText(bufferedReader);
                                        CloseableKt.closeFinally(bufferedReader, null);
                                        str = text;
                                    } catch (Throwable th) {
                                        try {
                                            throw th;
                                        } catch (Throwable th2) {
                                            CloseableKt.closeFinally(bufferedReader, th);
                                            throw th2;
                                        }
                                    }
                                } catch (IOException e2) {
                                    e = e2;
                                    ErrorsKt.reportInternalError(Analytics.INSTANCE, e);
                                    str = "Could not read response body for rejected message: " + e;
                                    if (inputStreamSafeGetInputStream != null) {
                                    }
                                    String responseMessage = getConnection().getResponseMessage();
                                    Intrinsics.checkNotNullExpressionValue(responseMessage, "connection.responseMessage");
                                    Map<String, List<String>> headerFields = getConnection().getHeaderFields();
                                    Intrinsics.checkNotNullExpressionValue(headerFields, "connection.headerFields");
                                    throw new HTTPException(responseCode, responseMessage, str, headerFields);
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            inputStream2 = inputStream;
                            if (inputStream2 != null) {
                                inputStream2.close();
                            }
                            throw th;
                        }
                    } catch (IOException e3) {
                        inputStreamSafeGetInputStream = null;
                        e = e3;
                    } catch (Throwable th4) {
                        th = th4;
                        if (inputStream2 != null) {
                        }
                        throw th;
                    }
                    if (inputStreamSafeGetInputStream != null) {
                        inputStreamSafeGetInputStream.close();
                    }
                    String responseMessage2 = getConnection().getResponseMessage();
                    Intrinsics.checkNotNullExpressionValue(responseMessage2, "connection.responseMessage");
                    Map<String, List<String>> headerFields2 = getConnection().getHeaderFields();
                    Intrinsics.checkNotNullExpressionValue(headerFields2, "connection.headerFields");
                    throw new HTTPException(responseCode, responseMessage2, str, headerFields2);
                } finally {
                    super.close();
                    OutputStream outputStream3 = getOutputStream();
                    if (outputStream3 != null) {
                        outputStream3.close();
                    }
                }
            }
        };
    }

    public static final InputStream safeGetInputStream(HttpURLConnection connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        try {
            return connection.getInputStream();
        } catch (IOException unused) {
            return connection.getErrorStream();
        }
    }
}
