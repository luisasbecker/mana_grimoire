package com.google.android.gms.internal.mlkit_vision_internal_vkp;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzkl extends zzkn {
    final /* synthetic */ zzkm zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzkl(zzkm zzkmVar, zzko zzkoVar, CharSequence charSequence) {
        super(zzkoVar, charSequence);
        this.zza = zzkmVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzkn
    public final int zzc(int i) {
        return i + this.zza.zza.length();
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0026, code lost:
    
        r7 = r7 + 1;
     */
    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzkn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zzd(int i) {
        int length = this.zzb.length();
        int length2 = this.zza.zza.length();
        int i2 = length - length2;
        while (i <= i2) {
            for (int i3 = 0; i3 < length2; i3++) {
                if (this.zzb.charAt(i3 + i) != this.zza.zza.charAt(i3)) {
                    break;
                }
            }
            return i;
        }
        return -1;
    }
}
