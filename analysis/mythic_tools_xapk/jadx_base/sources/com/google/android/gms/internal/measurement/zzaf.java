package com.google.android.gms.internal.measurement;

import androidx.camera.video.AudioStats;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaf implements zzao {
    private final boolean zza;

    public zzaf(Boolean bool) {
        this.zza = bool == null ? false : bool.booleanValue();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof zzaf) && this.zza == ((zzaf) obj).zza;
    }

    public final int hashCode() {
        return Boolean.valueOf(this.zza).hashCode();
    }

    public final String toString() {
        return String.valueOf(this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final String zzc() {
        return Boolean.toString(this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final zzao zzcG(String str, zzg zzgVar, List list) {
        boolean zEquals = InAppPurchaseConstants.METHOD_TO_STRING.equals(str);
        boolean z = this.zza;
        if (zEquals) {
            return new zzas(Boolean.toString(z));
        }
        throw new IllegalArgumentException(String.format("%s.%s is not a function.", Boolean.toString(z), str));
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Double zzd() {
        return Double.valueOf(true != this.zza ? AudioStats.AUDIO_AMPLITUDE_NONE : 1.0d);
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Boolean zze() {
        return Boolean.valueOf(this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Iterator zzf() {
        return null;
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final zzao zzt() {
        return new zzaf(Boolean.valueOf(this.zza));
    }
}
