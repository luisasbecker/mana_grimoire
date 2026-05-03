package com.google.android.libraries.vision.visionkit.pipeline;

import android.graphics.Bitmap;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbdv;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbew;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
class NativePipelineImpl implements zzbt {
    private zzbdv zza;
    private zzcd zzb;
    private zzcj zzc;
    private zzci zzd;

    public NativePipelineImpl(zzcd zzcdVar, zzcj zzcjVar, zzci zzciVar, zzbdv zzbdvVar) {
        this.zzb = zzcdVar;
        this.zzc = zzcjVar;
        this.zzd = zzciVar;
        this.zza = zzbdvVar;
    }

    public NativePipelineImpl(String str, zzcd zzcdVar, zzcj zzcjVar, zzci zzciVar, zzbdv zzbdvVar) {
        this(zzcdVar, zzcjVar, zzciVar, zzbdvVar);
        System.loadLibrary("mlkitcommonpipeline");
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.zzbt
    public native void close(long j, long j2, long j3, long j4, long j5);

    public void closeFileDescriptor(int i) {
        this.zzd.zze(i);
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.zzbt
    public native byte[] getAnalyticsLogs(long j);

    @Override // com.google.android.libraries.vision.visionkit.pipeline.zzbt
    public native long initialize(byte[] bArr, long j, long j2, long j3, long j4, long j5);

    @Override // com.google.android.libraries.vision.visionkit.pipeline.zzbt
    public native long initializeFrameBufferReleaseCallback(long j);

    @Override // com.google.android.libraries.vision.visionkit.pipeline.zzbt
    public native long initializeFrameManager();

    @Override // com.google.android.libraries.vision.visionkit.pipeline.zzbt
    public native long initializeIsolationCallback();

    @Override // com.google.android.libraries.vision.visionkit.pipeline.zzbt
    public native long initializeResultsCallback();

    public void onReleaseAtTimestampUs(long j) {
        this.zzb.zzf(j);
    }

    public void onResult(byte[] bArr) {
        try {
            this.zzc.zzg(zzdf.zzd(bArr, this.zza));
        } catch (zzbew e) {
            com.google.android.gms.internal.mlkit_vision_internal_vkp.zzcp.zza.zza(e, "Error in result from JNI layer", new Object[0]);
        }
    }

    public int openFileDescriptor(String str) {
        this.zzd.zza(str);
        return -1;
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.zzbt
    public native byte[] process(long j, long j2, long j3, byte[] bArr, int i, int i2, int i3, int i4);

    @Override // com.google.android.libraries.vision.visionkit.pipeline.zzbt
    public native byte[] processBitmap(long j, long j2, Bitmap bitmap, int i, int i2, int i3, int i4);

    @Override // com.google.android.libraries.vision.visionkit.pipeline.zzbt
    public native byte[] processYuvFrame(long j, long j2, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i, int i2, int i3, int i4, int i5, int i6);

    @Override // com.google.android.libraries.vision.visionkit.pipeline.zzbt
    public native void start(long j) throws PipelineException;

    @Override // com.google.android.libraries.vision.visionkit.pipeline.zzbt
    public native boolean stop(long j);

    @Override // com.google.android.libraries.vision.visionkit.pipeline.zzbt
    public native void waitUntilIdle(long j) throws PipelineException;

    @Override // com.google.android.libraries.vision.visionkit.pipeline.zzbt
    public final void zza() {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
    }
}
