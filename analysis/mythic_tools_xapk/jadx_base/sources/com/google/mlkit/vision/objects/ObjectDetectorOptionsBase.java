package com.google.mlkit.vision.objects;

import com.google.android.gms.common.internal.Objects;
import com.google.mlkit.vision.common.internal.MultiFlavorDetectorCreator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.mlkit:object-detection-common@@18.0.0 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class ObjectDetectorOptionsBase implements MultiFlavorDetectorCreator.DetectorOptions<ObjectDetector> {
    public static final int SINGLE_IMAGE_MODE = 2;
    public static final int STREAM_MODE = 1;
    private final int zza;
    private final boolean zzb;
    private final boolean zzc;
    private final Executor zzd;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: compiled from: com.google.mlkit:object-detection-common@@18.0.0 */
    public static abstract class Builder<B extends Builder<B>> {
        private int zza = 1;
        private boolean zzb = false;
        private boolean zzc = false;
        private Executor zzd;

        protected Builder() {
        }

        protected abstract ObjectDetectorOptionsBase build();

        public B enableClassification() {
            this.zzc = true;
            return this;
        }

        public B enableMultipleObjects() {
            this.zzb = true;
            return this;
        }

        public B setDetectorMode(int i) {
            this.zza = i;
            return this;
        }

        public B setExecutor(Executor executor) {
            this.zzd = executor;
            return this;
        }
    }

    /* JADX INFO: compiled from: com.google.mlkit:object-detection-common@@18.0.0 */
    @Retention(RetentionPolicy.CLASS)
    public @interface DetectorMode {
    }

    protected ObjectDetectorOptionsBase(Builder<?> builder) {
        this.zza = ((Builder) builder).zza;
        this.zzb = ((Builder) builder).zzb;
        this.zzc = ((Builder) builder).zzc;
        this.zzd = ((Builder) builder).zzd;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ObjectDetectorOptionsBase)) {
            return false;
        }
        ObjectDetectorOptionsBase objectDetectorOptionsBase = (ObjectDetectorOptionsBase) obj;
        return getClass().equals(objectDetectorOptionsBase.getClass()) && objectDetectorOptionsBase.zza == this.zza && objectDetectorOptionsBase.zzc == this.zzc && objectDetectorOptionsBase.zzb == this.zzb && Objects.equal(objectDetectorOptionsBase.zzd, this.zzd);
    }

    public int getDetectorMode() {
        return this.zza;
    }

    public Executor getExecutor() {
        return this.zzd;
    }

    public int hashCode() {
        return Objects.hashCode(getClass(), Integer.valueOf(this.zza), Boolean.valueOf(this.zzc), Boolean.valueOf(this.zzb), this.zzd);
    }

    public boolean isClassificationEnabled() {
        return this.zzc;
    }

    public boolean isMultipleObjectsEnabled() {
        return this.zzb;
    }
}
