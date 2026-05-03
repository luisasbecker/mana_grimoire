package com.google.android.gms.internal.play_billing;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzig extends zzih {
    zzig(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.play_billing.zzih
    public final double zza(Object obj, long j) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j));
    }

    @Override // com.google.android.gms.internal.play_billing.zzih
    public final float zzb(Object obj, long j) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j));
    }

    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.play_billing.zzii.zzi(java.lang.Object, long, boolean):void */
    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.play_billing.zzii.zzj(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r4v0 boolean)' in method call: com.google.android.gms.internal.play_billing.zzii.zzi(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r4v0 boolean)' in method call: com.google.android.gms.internal.play_billing.zzii.zzj(java.lang.Object, long, boolean):void */
    @Override // com.google.android.gms.internal.play_billing.zzih
    public final void zzc(Object obj, long j, boolean z) {
        if (zzii.zzb) {
            zzii.zzi(obj, j, z);
        } else {
            zzii.zzj(obj, j, z);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzih
    public final void zzd(Object obj, long j, byte b) {
        if (zzii.zzb) {
            zzii.zzD(obj, j, b);
        } else {
            zzii.zzE(obj, j, b);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzih
    public final void zze(Object obj, long j, double d) {
        this.zza.putLong(obj, j, Double.doubleToLongBits(d));
    }

    @Override // com.google.android.gms.internal.play_billing.zzih
    public final void zzf(Object obj, long j, float f) {
        this.zza.putInt(obj, j, Float.floatToIntBits(f));
    }

    @Override // com.google.android.gms.internal.play_billing.zzih
    public final boolean zzg(Object obj, long j) {
        return zzii.zzb ? zzii.zzt(obj, j) : zzii.zzu(obj, j);
    }
}
