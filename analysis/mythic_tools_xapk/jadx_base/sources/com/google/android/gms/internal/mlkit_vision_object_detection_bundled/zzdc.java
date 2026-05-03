package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdc {
    public static zzch zza(zzdg zzdgVar) throws zzcl {
        boolean z;
        try {
            try {
                zzdgVar.zzn();
                z = false;
            } catch (EOFException e) {
                e = e;
                z = true;
            }
            try {
                return (zzch) zzde.zza.zza(zzdgVar);
            } catch (EOFException e2) {
                e = e2;
                if (z) {
                    return zzcj.zza;
                }
                throw new zzco(e);
            }
        } catch (zzdj e3) {
            throw new zzco(e3);
        } catch (IOException e4) {
            throw new zzci(e4);
        } catch (NumberFormatException e5) {
            throw new zzco(e5);
        }
    }
}
