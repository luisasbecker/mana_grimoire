package com.google.android.gms.internal.play_billing;

import java.util.Arrays;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.3.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbf {
    private final String zza;
    private final zzbe zzb;
    private zzbe zzc;

    /* synthetic */ zzbf(String str, zzbg zzbgVar) {
        zzbe zzbeVar = new zzbe();
        this.zzb = zzbeVar;
        this.zzc = zzbeVar;
        str.getClass();
        this.zza = str;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
        zzbe zzbeVar = this.zzb.zzb;
        String str = "";
        while (zzbeVar != null) {
            Object obj = zzbeVar.zza;
            sb.append(str);
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                sb.append((CharSequence) Arrays.deepToString(new Object[]{obj}), 1, r1.length() - 1);
            }
            zzbeVar = zzbeVar.zzb;
            str = ", ";
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }

    public final zzbf zza(Object obj) {
        zzbe zzbeVar = new zzbe();
        this.zzc.zzb = zzbeVar;
        this.zzc = zzbeVar;
        zzbeVar.zza = obj;
        return this;
    }
}
