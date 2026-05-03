package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
/* JADX INFO: loaded from: classes4.dex */
final class zzalv implements zzalw {
    zzalv() {
    }

    private static <E> zzalm<E> zzc(Object obj, long j) {
        return (zzalm) zzanz.zze(obj, j);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalw
    public final <L> List<L> zza(Object obj, long j) {
        zzalm zzalmVarZzc = zzc(obj, j);
        if (zzalmVarZzc.zzc()) {
            return zzalmVarZzc;
        }
        int size = zzalmVarZzc.size();
        zzalm zzalmVarZza = zzalmVarZzc.zza(size == 0 ? 10 : size << 1);
        zzanz.zza(obj, j, zzalmVarZza);
        return zzalmVarZza;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.google.android.gms.internal.firebase-auth-api.zzalm] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.google.android.gms.internal.firebase-auth-api.zzalm, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v3 */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalw
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzalm zzalmVarZzc = zzc(obj, j);
        ?? Zzc = zzc(obj2, j);
        int size = zzalmVarZzc.size();
        int size2 = Zzc.size();
        ?? r3 = zzalmVarZzc;
        r3 = zzalmVarZzc;
        if (size > 0 && size2 > 0) {
            boolean zZzc = zzalmVarZzc.zzc();
            ?? Zza = zzalmVarZzc;
            if (!zZzc) {
                Zza = zzalmVarZzc.zza(size2 + size);
            }
            Zza.addAll(Zzc);
            r3 = Zza;
        }
        if (size > 0) {
            Zzc = r3;
        }
        zzanz.zza(obj, j, (Object) Zzc);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalw
    public final void zzb(Object obj, long j) {
        zzc(obj, j).zzb();
    }
}
