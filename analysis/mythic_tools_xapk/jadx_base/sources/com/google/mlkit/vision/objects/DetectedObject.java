package com.google.mlkit.vision.objects;

import android.graphics.Rect;
import com.google.android.gms.common.internal.Objects;
import java.util.List;

/* JADX INFO: compiled from: com.google.mlkit:object-detection-common@@18.0.0 */
/* JADX INFO: loaded from: classes5.dex */
public class DetectedObject {
    private final Rect zza;
    private final Integer zzb;
    private final List zzc;

    /* JADX INFO: compiled from: com.google.mlkit:object-detection-common@@18.0.0 */
    public static class Label {
        private final String zza;
        private final float zzb;
        private final int zzc;

        public Label(String str, float f, int i) {
            this.zza = str;
            this.zzb = f;
            this.zzc = i;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Label)) {
                return false;
            }
            Label label = (Label) obj;
            return Objects.equal(this.zza, label.zza) && Float.compare(this.zzb, label.getConfidence()) == 0 && this.zzc == label.getIndex();
        }

        public float getConfidence() {
            return this.zzb;
        }

        public int getIndex() {
            return this.zzc;
        }

        public String getText() {
            return this.zza;
        }

        public int hashCode() {
            return Objects.hashCode(this.zza, Float.valueOf(this.zzb), Integer.valueOf(this.zzc));
        }
    }

    public DetectedObject(Rect rect, Integer num, List<Label> list) {
        this.zza = rect;
        this.zzb = num;
        this.zzc = list;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DetectedObject)) {
            return false;
        }
        DetectedObject detectedObject = (DetectedObject) obj;
        return Objects.equal(this.zza, detectedObject.zza) && Objects.equal(this.zzb, detectedObject.zzb) && Objects.equal(this.zzc, detectedObject.zzc);
    }

    public Rect getBoundingBox() {
        return this.zza;
    }

    public List<Label> getLabels() {
        return this.zzc;
    }

    public Integer getTrackingId() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc);
    }
}
