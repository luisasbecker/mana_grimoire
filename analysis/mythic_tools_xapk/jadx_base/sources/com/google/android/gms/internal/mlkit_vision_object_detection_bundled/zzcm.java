package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import java.io.IOException;
import java.io.StringReader;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcm {
    public static zzch zza(zzdg zzdgVar) throws zzci, zzco {
        zzcp zzcpVarZzb = zzdgVar.zzb();
        if (zzcpVarZzb == zzcp.LEGACY_STRICT) {
            zzdgVar.zzk(zzcp.LENIENT);
        }
        try {
            try {
                return zzdc.zza(zzdgVar);
            } catch (OutOfMemoryError e) {
                throw new zzcl("Failed parsing JSON source: " + zzdgVar.toString() + " to Json", e);
            } catch (StackOverflowError e2) {
                throw new zzcl("Failed parsing JSON source: " + zzdgVar.toString() + " to Json", e2);
            }
        } finally {
            zzdgVar.zzk(zzcpVarZzb);
        }
    }

    public static zzch zzb(String str) throws zzco {
        try {
            zzdg zzdgVar = new zzdg(new StringReader(str));
            zzch zzchVarZza = zza(zzdgVar);
            if (!(zzchVarZza instanceof zzcj) && zzdgVar.zzn() != 10) {
                throw new zzco("Did not consume the entire document.");
            }
            return zzchVarZza;
        } catch (zzdj e) {
            throw new zzco(e);
        } catch (IOException e2) {
            throw new zzci(e2);
        } catch (NumberFormatException e3) {
            throw new zzco(e3);
        }
    }
}
