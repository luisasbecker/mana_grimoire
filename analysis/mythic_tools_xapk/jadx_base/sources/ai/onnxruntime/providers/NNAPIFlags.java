package ai.onnxruntime.providers;

import ai.onnxruntime.OrtFlags;

/* JADX INFO: loaded from: classes.dex */
public enum NNAPIFlags implements OrtFlags {
    USE_FP16(1),
    USE_NCHW(2),
    CPU_DISABLED(4),
    CPU_ONLY(8);

    public final int value;

    NNAPIFlags(int i) {
        this.value = i;
    }

    @Override // ai.onnxruntime.OrtFlags
    public int getValue() {
        return this.value;
    }
}
