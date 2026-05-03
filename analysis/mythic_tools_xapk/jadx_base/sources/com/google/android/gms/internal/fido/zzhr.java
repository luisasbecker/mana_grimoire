package com.google.android.gms.internal.fido;

import androidx.media3.muxer.WebmConstants;

/* JADX INFO: compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhr {
    private final byte zza;
    private final byte zzb;

    zzhr(int i) {
        this.zza = (byte) (i & WebmConstants.MkvEbmlElement.VIDEO);
        this.zzb = (byte) (i & 31);
    }

    public final byte zza() {
        return this.zzb;
    }

    public final byte zzb() {
        return this.zza;
    }

    public final int zzc() {
        return (this.zza >> 5) & 7;
    }
}
