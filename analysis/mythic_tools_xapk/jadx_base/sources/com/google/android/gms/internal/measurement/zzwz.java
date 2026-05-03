package com.google.android.gms.internal.measurement;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzwz implements Runnable {
    final /* synthetic */ Ref.ObjectRef zza;
    final /* synthetic */ zzws zzb;
    final /* synthetic */ Runnable zzc;

    zzwz(Ref.ObjectRef objectRef, zzws zzwsVar, Runnable runnable) {
        this.zza = objectRef;
        this.zzb = zzwsVar;
        this.zzc = runnable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        if (((zzxe) this.zza.element) != null) {
            throw null;
        }
        zzws zzwsVar = this.zzb;
        Intrinsics.checkNotNull(zzwsVar, "null cannot be cast to non-null type com.google.apps.tiktok.tracing.Trace");
        Runnable runnable = this.zzc;
        zzws zzwsVarZzc = zzvy.zzc(zzvy.zzd(), zzwsVar);
        try {
            runnable.run();
            Unit unit = Unit.INSTANCE;
        } finally {
        }
    }

    public final String toString() {
        Runnable runnable = this.zzc;
        StringBuilder sb = new StringBuilder(runnable.toString().length() + 14);
        sb.append("propagating=[");
        sb.append(runnable);
        sb.append("]");
        return sb.toString();
    }
}
