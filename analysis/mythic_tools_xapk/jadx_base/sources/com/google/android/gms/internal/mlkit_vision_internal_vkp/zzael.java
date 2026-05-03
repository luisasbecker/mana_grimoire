package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import java.io.IOException;
import java.io.StringWriter;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public class zzael {
    @Deprecated
    public zzael() {
    }

    public final String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            zzafm zzafmVar = new zzafm(stringWriter);
            zzafmVar.zzj(zzaet.LENIENT);
            zzafi.zza.zzb(zzafmVar, this);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public final zzaeo zzb() {
        if (this instanceof zzaeo) {
            return (zzaeo) this;
        }
        throw new IllegalStateException("Not a JSON Object: ".concat(toString()));
    }
}
