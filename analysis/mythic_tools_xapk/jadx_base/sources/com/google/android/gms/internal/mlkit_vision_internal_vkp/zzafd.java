package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import java.util.Map;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzafd implements Map.Entry {
    zzafd zza;
    zzafd zzb;
    zzafd zzc;
    zzafd zzd;
    zzafd zze;
    final Object zzf;
    final boolean zzg;
    Object zzh;
    int zzi;

    zzafd(boolean z) {
        this.zzf = null;
        this.zzg = z;
        this.zze = this;
        this.zzd = this;
    }

    zzafd(boolean z, zzafd zzafdVar, Object obj, zzafd zzafdVar2, zzafd zzafdVar3) {
        this.zza = zzafdVar;
        this.zzf = obj;
        this.zzg = z;
        this.zzi = 1;
        this.zzd = zzafdVar2;
        this.zze = zzafdVar3;
        zzafdVar3.zzd = this;
        zzafdVar2.zze = this;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = this.zzf;
            if (obj2 != null ? obj2.equals(entry.getKey()) : entry.getKey() == null) {
                Object obj3 = this.zzh;
                if (obj3 == null) {
                    if (entry.getValue() == null) {
                        return true;
                    }
                } else if (obj3.equals(entry.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.zzf;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.zzh;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object obj = this.zzf;
        int iHashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.zzh;
        return iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj == null && !this.zzg) {
            throw new NullPointerException("value == null");
        }
        Object obj2 = this.zzh;
        this.zzh = obj;
        return obj2;
    }

    public final String toString() {
        return String.valueOf(this.zzf) + "=" + String.valueOf(this.zzh);
    }
}
