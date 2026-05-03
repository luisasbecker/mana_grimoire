package com.google.android.gms.internal.fido;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhn extends zzhp {
    private final String zza;

    zzhn(String str) {
        this.zza = str;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzhp zzhpVar = (zzhp) obj;
        if (zzd((byte) 96) != zzhpVar.zza()) {
            return zzd((byte) 96) - zzhpVar.zza();
        }
        String str = this.zza;
        String str2 = ((zzhn) zzhpVar).zza;
        if (str.length() == str2.length()) {
            return str.compareTo(str2);
        }
        return str.length() - str2.length();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return this.zza.equals(((zzhn) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(zzd((byte) 96)), this.zza});
    }

    public final String toString() {
        return "\"" + this.zza + "\"";
    }

    @Override // com.google.android.gms.internal.fido.zzhp
    protected final int zza() {
        return zzd((byte) 96);
    }
}
