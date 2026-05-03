package com.google.android.libraries.vision.visionkit.pipeline;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbu implements zzbt {
    public zzbu(zzcd zzcdVar) {
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.zzbt
    public final void close(long j, long j2, long j3, long j4, long j5) {
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.zzbt
    public final byte[] getAnalyticsLogs(long j) {
        return new byte[0];
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.zzbt
    public final long initialize(byte[] bArr, long j, long j2, long j3, long j4, long j5) {
        return 1L;
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.zzbt
    public final long initializeFrameBufferReleaseCallback(long j) {
        return 1L;
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.zzbt
    public final long initializeFrameManager() {
        return 1L;
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.zzbt
    public final long initializeIsolationCallback() {
        return 1L;
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.zzbt
    public final long initializeResultsCallback() {
        return 1L;
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.zzbt
    public final byte[] process(long j, long j2, long j3, byte[] bArr, int i, int i2, int i3, int i4) {
        return zzdf.zzc().zzw();
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.zzbt
    public final byte[] processBitmap(long j, long j2, Bitmap bitmap, int i, int i2, int i3, int i4) {
        return zzdf.zzc().zzw();
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.zzbt
    public final byte[] processYuvFrame(long j, long j2, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i, int i2, int i3, int i4, int i5, int i6) {
        return zzdf.zzc().zzw();
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.zzbt
    public final void start(long j) throws PipelineException {
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.zzbt
    public final boolean stop(long j) {
        return true;
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.zzbt
    public final void waitUntilIdle(long j) throws PipelineException {
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.zzbt
    public final void zza() {
    }
}
