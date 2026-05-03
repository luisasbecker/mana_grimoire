package com.segment.analytics.kotlin.core;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HTTPClient.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/segment/analytics/kotlin/core/Connection;", "Ljava/io/Closeable;", "connection", "Ljava/net/HttpURLConnection;", "inputStream", "Ljava/io/InputStream;", "outputStream", "Ljava/io/OutputStream;", "(Ljava/net/HttpURLConnection;Ljava/io/InputStream;Ljava/io/OutputStream;)V", "getConnection", "()Ljava/net/HttpURLConnection;", "getInputStream", "()Ljava/io/InputStream;", "getOutputStream", "()Ljava/io/OutputStream;", "close", "", "core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class Connection implements Closeable {
    private final HttpURLConnection connection;
    private final InputStream inputStream;
    private final OutputStream outputStream;

    public Connection(HttpURLConnection connection, InputStream inputStream, OutputStream outputStream) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        this.connection = connection;
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.connection.disconnect();
    }

    public final HttpURLConnection getConnection() {
        return this.connection;
    }

    public final InputStream getInputStream() {
        return this.inputStream;
    }

    public final OutputStream getOutputStream() {
        return this.outputStream;
    }
}
