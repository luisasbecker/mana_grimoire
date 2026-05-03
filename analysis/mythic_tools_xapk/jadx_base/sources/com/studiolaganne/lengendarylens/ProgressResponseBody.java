package com.studiolaganne.lengendarylens;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;

/* JADX INFO: compiled from: ProgressInterceptor.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/studiolaganne/lengendarylens/ProgressResponseBody;", "Lokhttp3/ResponseBody;", "responseBody", "progressListener", "Lcom/studiolaganne/lengendarylens/ProgressListener;", "<init>", "(Lokhttp3/ResponseBody;Lcom/studiolaganne/lengendarylens/ProgressListener;)V", "bufferedSource", "Lokio/BufferedSource;", "contentType", "Lokhttp3/MediaType;", "contentLength", "", "source", "Lokio/ForwardingSource;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ProgressResponseBody extends ResponseBody {
    public static final int $stable = 8;
    private BufferedSource bufferedSource;
    private final ProgressListener progressListener;
    private final ResponseBody responseBody;

    public ProgressResponseBody(ResponseBody responseBody, ProgressListener progressListener) {
        Intrinsics.checkNotNullParameter(responseBody, "responseBody");
        Intrinsics.checkNotNullParameter(progressListener, "progressListener");
        this.responseBody = responseBody;
        this.progressListener = progressListener;
    }

    private final ForwardingSource source(BufferedSource source) {
        return new ForwardingSource(source, this) { // from class: com.studiolaganne.lengendarylens.ProgressResponseBody.source.1
            final /* synthetic */ ProgressResponseBody this$0;
            private long totalBytesRead;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(source);
                this.this$0 = this;
            }

            public final long getTotalBytesRead() {
                return this.totalBytesRead;
            }

            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer sink, long byteCount) throws IOException {
                Intrinsics.checkNotNullParameter(sink, "sink");
                long j = super.read(sink, byteCount);
                this.totalBytesRead += j != -1 ? j : 0L;
                if (this.this$0.responseBody.getContentLength() <= 0) {
                    this.this$0.progressListener.onDownloadFailed("Invalid content length");
                    return j;
                }
                this.this$0.progressListener.onProgressUpdate((int) ((100 * this.totalBytesRead) / this.this$0.responseBody.getContentLength()));
                return j;
            }

            public final void setTotalBytesRead(long j) {
                this.totalBytesRead = j;
            }
        };
    }

    @Override // okhttp3.ResponseBody
    /* JADX INFO: renamed from: contentLength */
    public long getContentLength() {
        return this.responseBody.getContentLength();
    }

    @Override // okhttp3.ResponseBody
    /* JADX INFO: renamed from: contentType */
    public MediaType get$contentType() {
        return this.responseBody.get$contentType();
    }

    @Override // okhttp3.ResponseBody
    /* JADX INFO: renamed from: source */
    public BufferedSource getBodySource() {
        if (this.bufferedSource == null) {
            this.bufferedSource = Okio.buffer(source(this.responseBody.getBodySource()));
        }
        BufferedSource bufferedSource = this.bufferedSource;
        Intrinsics.checkNotNull(bufferedSource);
        return bufferedSource;
    }
}
