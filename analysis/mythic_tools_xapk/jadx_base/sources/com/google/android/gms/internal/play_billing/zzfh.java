package com.google.android.gms.internal.play_billing;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.3.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfh {
    static final zzfh zza = new zzfh(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private final Map zzd;

    zzfh() {
        this.zzd = new HashMap();
    }

    zzfh(boolean z) {
        this.zzd = Collections.emptyMap();
    }

    public final zzft zza(zzhb zzhbVar, int i) {
        return (zzft) this.zzd.get(new zzfg(zzhbVar, i));
    }
}
