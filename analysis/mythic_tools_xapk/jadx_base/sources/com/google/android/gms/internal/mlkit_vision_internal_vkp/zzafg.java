package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzafg {
    public static zzael zza(zzafk zzafkVar) throws zzaep {
        boolean z;
        try {
            try {
                zzafkVar.zzn();
                z = false;
            } catch (EOFException e) {
                e = e;
                z = true;
            }
            try {
                return (zzael) zzafi.zza.zza(zzafkVar);
            } catch (EOFException e2) {
                e = e2;
                if (z) {
                    return zzaen.zza;
                }
                throw new zzaes(e);
            }
        } catch (zzafn e3) {
            throw new zzaes(e3);
        } catch (IOException e4) {
            throw new zzaem(e4);
        } catch (NumberFormatException e5) {
            throw new zzaes(e5);
        }
    }
}
