package com.google.mlkit.vision.objects.defaults;

import com.google.mlkit.vision.objects.ObjectDetectorOptionsBase;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes5.dex */
public class ObjectDetectorOptions extends ObjectDetectorOptionsBase {
    public static final ObjectDetectorOptions DEFAULT_OPTIONS = new Builder().build();

    /* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
    public static class Builder extends ObjectDetectorOptionsBase.Builder<Builder> {
        @Override // com.google.mlkit.vision.objects.ObjectDetectorOptionsBase.Builder
        public ObjectDetectorOptions build() {
            return new ObjectDetectorOptions(this, null);
        }

        @Override // com.google.mlkit.vision.objects.ObjectDetectorOptionsBase.Builder
        public Builder enableClassification() {
            return (Builder) super.enableClassification();
        }

        @Override // com.google.mlkit.vision.objects.ObjectDetectorOptionsBase.Builder
        public Builder enableMultipleObjects() {
            return (Builder) super.enableMultipleObjects();
        }

        @Override // com.google.mlkit.vision.objects.ObjectDetectorOptionsBase.Builder
        public Builder setDetectorMode(int i) {
            return (Builder) super.setDetectorMode(i);
        }

        @Override // com.google.mlkit.vision.objects.ObjectDetectorOptionsBase.Builder
        public Builder setExecutor(Executor executor) {
            return (Builder) super.setExecutor(executor);
        }
    }

    /* synthetic */ ObjectDetectorOptions(Builder builder, zza zzaVar) {
        super(builder);
    }
}
