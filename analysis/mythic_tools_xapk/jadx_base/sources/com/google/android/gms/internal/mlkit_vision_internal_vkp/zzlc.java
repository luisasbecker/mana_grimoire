package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzlc extends zzkt {
    public zzlc() {
        super(4);
    }

    public final zzlc zzb(Object obj) {
        super.zza(obj);
        return this;
    }

    public final zzld zzc() {
        int i = this.zzb;
        if (i == 0) {
            return zzlm.zza;
        }
        if (i == 1) {
            return new zzlo(Objects.requireNonNull(this.zza[0]));
        }
        zzld zzldVarZzl = zzld.zzl(i, this.zza);
        this.zzb = zzldVarZzl.size();
        this.zzc = true;
        return zzldVarZzl;
    }
}
