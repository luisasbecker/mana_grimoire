package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import java.io.IOException;
import java.io.StringReader;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaeq {
    public static zzael zza(zzafk zzafkVar) throws zzaes, zzaem {
        zzaet zzaetVarZzb = zzafkVar.zzb();
        if (zzaetVarZzb == zzaet.LEGACY_STRICT) {
            zzafkVar.zzk(zzaet.LENIENT);
        }
        try {
            try {
                return zzafg.zza(zzafkVar);
            } catch (OutOfMemoryError e) {
                throw new zzaep("Failed parsing JSON source: " + zzafkVar.toString() + " to Json", e);
            } catch (StackOverflowError e2) {
                throw new zzaep("Failed parsing JSON source: " + zzafkVar.toString() + " to Json", e2);
            }
        } finally {
            zzafkVar.zzk(zzaetVarZzb);
        }
    }

    public static zzael zzb(String str) throws zzaes {
        try {
            zzafk zzafkVar = new zzafk(new StringReader(str));
            zzael zzaelVarZza = zza(zzafkVar);
            if (!(zzaelVarZza instanceof zzaen) && zzafkVar.zzn() != 10) {
                throw new zzaes("Did not consume the entire document.");
            }
            return zzaelVarZza;
        } catch (zzafn e) {
            throw new zzaes(e);
        } catch (IOException e2) {
            throw new zzaem(e2);
        } catch (NumberFormatException e3) {
            throw new zzaes(e3);
        }
    }
}
