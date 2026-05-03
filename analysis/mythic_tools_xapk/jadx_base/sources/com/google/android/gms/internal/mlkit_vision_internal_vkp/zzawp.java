package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzawp {
    private static final ExecutorService zza = Executors.newSingleThreadExecutor();
    private static final long zzb = TimeUnit.DAYS.toSeconds(7);
    private static final long zzc = TimeUnit.HOURS.toSeconds(12);
    private static zzawp zzd;
    private final zzawr zze;
    private final ExecutorService zzf;
    private final zzawq zzg;
    private final zzawz zzh;
    private final long zzi;
    private final long zzj;
    private final Object zzk;
    private final zzaxg zzl;

    private zzawp(zzaxg zzaxgVar, ExecutorService executorService, zzawr zzawrVar, zzawq zzawqVar, long j, long j2) {
        zzaxb zzaxbVar = new zzaxb();
        this.zzk = new Object();
        this.zzl = zzaxgVar;
        this.zzf = executorService;
        this.zze = zzawrVar;
        this.zzh = zzaxbVar;
        this.zzg = zzawqVar;
        this.zzi = j;
        this.zzj = j2;
    }

    public static synchronized zzawp zza(Context context) {
        if (zzd == null) {
            zzd = new zzawp(zzaxg.zzb(context), zza, new zzawr(context), new zzawq(), zzb, zzc);
        }
        return zzd;
    }

    public final Task zzb(final String str, final String str2, String str3, int i) {
        String strZzj = zzawt.zza().zza().zzc().zzj();
        try {
            if (Integer.parseInt(strZzj) < 29) {
                Log.d("AccelerationAllowlist", "Unable to retrieve NNAPI info required by AllowlistServer before Android Q, skipping allowlist fetch.");
                return Tasks.forResult(null);
            }
            Log.d("AccelerationAllowlist", "fetchAccelerationAllowlist");
            final String str4 = "com.google.perception";
            final zzawy zzawyVar = new zzawy("com.google.perception", 2);
            zzawyVar.zzf();
            final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            final int i2 = 2;
            this.zzf.execute(new Runnable(str, str2, str4, i2, zzawyVar, taskCompletionSource) { // from class: com.google.android.gms.internal.mlkit_vision_internal_vkp.zzawn
                public final /* synthetic */ String zzb;
                public final /* synthetic */ String zzc;
                public final /* synthetic */ String zzd = "com.google.perception";
                public final /* synthetic */ zzawy zze;
                public final /* synthetic */ TaskCompletionSource zzf;

                {
                    this.zze = zzawyVar;
                    this.zzf = taskCompletionSource;
                }

                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    this.zza.zzd(this.zzb, this.zzc, this.zzd, 2, this.zze, this.zzf);
                }
            });
            return taskCompletionSource.getTask();
        } catch (NumberFormatException e) {
            Log.e("AccelerationAllowlist", String.format("Unable to parse OS version returned by the AndroidSystemInfoProvider '%s'", strZzj), e);
            return Tasks.forException(e);
        }
    }

    public final zzbhx zzc(String str, String str2, String str3, int i) {
        zzawy zzawyVar = new zzawy("com.google.perception", 2);
        zzawyVar.zzf();
        try {
            return this.zze.zza(str, str2, "com.google.perception", 2, zzawyVar, this.zzi);
        } finally {
            zzawyVar.zze();
            this.zzg.zzb(zzawyVar);
        }
    }

    /* JADX WARN: Finally extract failed */
    final /* synthetic */ void zzd(String str, String str2, String str3, int i, zzawy zzawyVar, TaskCompletionSource taskCompletionSource) throws Throwable {
        zzawy zzawyVar2;
        zzawy zzawyVar3;
        Throwable th;
        Exception exc;
        zzaxc zzaxcVarZza;
        zzbhx zzbhxVar;
        try {
            try {
                zzawyVar3 = zzawyVar;
                try {
                    zzbhx zzbhxVarZza = this.zze.zza(str, str2, "com.google.perception", 2, zzawyVar3, this.zzj);
                    if (zzbhxVarZza != null) {
                        try {
                            Log.d("AccelerationAllowlist", "Cached copy available, not calling the server");
                            taskCompletionSource.setResult(zzbhxVarZza);
                            zzawyVar3 = zzawyVar;
                        } catch (IOException e) {
                            e = e;
                            exc = e;
                            zzawyVar3 = zzawyVar;
                            zzawyVar3.zzd(zzags.RPC_ERROR);
                            taskCompletionSource.setException(exc);
                        } catch (InterruptedException e2) {
                            e = e2;
                            exc = e;
                            zzawyVar3 = zzawyVar;
                            zzawyVar3.zzd(zzags.RPC_ERROR);
                            taskCompletionSource.setException(exc);
                        } catch (Throwable th2) {
                            th = th2;
                            zzawyVar2 = zzawyVar;
                            zzawyVar2.zze();
                            this.zzg.zzb(zzawyVar2);
                            throw th;
                        }
                    } else {
                        Log.d("AccelerationAllowlist", "fetching allowlist");
                        zzaws zzawsVarZza = zzawt.zza();
                        synchronized (this.zzk) {
                            try {
                                this.zzl.zzc();
                                zzaxcVarZza = this.zzl.zza();
                            } catch (Throwable th3) {
                                th = th3;
                                while (true) {
                                    try {
                                        throw th;
                                    } catch (Throwable th4) {
                                        th = th4;
                                    }
                                }
                            }
                        }
                        try {
                            zzawo zzawoVar = new zzawo(zzawyVar, str, str2, "com.google.perception", 2, zzawsVarZza, zzaxcVarZza, this.zzh, this.zzg);
                            if (zzaym.zza(zzawoVar)) {
                                Log.d("AccelerationAllowlist", "Saving allowlist");
                                zzbhx zzbhxVarZza2 = zzawoVar.zza();
                                try {
                                    this.zze.zzc(zzbhxVarZza2, str, str2, "com.google.perception", 2, zzawyVar);
                                    zzawyVar3 = zzawyVar;
                                    zzbhxVar = zzbhxVarZza2;
                                } catch (IOException e3) {
                                    e = e3;
                                    zzawyVar3 = zzawyVar;
                                    exc = e;
                                    zzawyVar3.zzd(zzags.RPC_ERROR);
                                    taskCompletionSource.setException(exc);
                                } catch (InterruptedException e4) {
                                    e = e4;
                                    zzawyVar3 = zzawyVar;
                                    exc = e;
                                    zzawyVar3.zzd(zzags.RPC_ERROR);
                                    taskCompletionSource.setException(exc);
                                } catch (Throwable th5) {
                                    th = th5;
                                    zzawyVar2 = zzawyVar;
                                    th = th;
                                    zzawyVar2.zze();
                                    this.zzg.zzb(zzawyVar2);
                                    throw th;
                                }
                            } else {
                                try {
                                    zzawyVar.zzd(zzags.RPC_EXPONENTIAL_BACKOFF_FAILED);
                                    zzbhxVar = null;
                                    zzawyVar3 = zzawyVar;
                                } catch (IOException e5) {
                                    e = e5;
                                    exc = e;
                                    zzawyVar3 = zzawyVar;
                                    zzawyVar3.zzd(zzags.RPC_ERROR);
                                    taskCompletionSource.setException(exc);
                                } catch (InterruptedException e6) {
                                    e = e6;
                                    exc = e;
                                    zzawyVar3 = zzawyVar;
                                    zzawyVar3.zzd(zzags.RPC_ERROR);
                                    taskCompletionSource.setException(exc);
                                } catch (Throwable th6) {
                                    th = th6;
                                    zzawyVar2 = zzawyVar;
                                    zzawyVar2.zze();
                                    this.zzg.zzb(zzawyVar2);
                                    throw th;
                                }
                            }
                            taskCompletionSource.setResult(zzbhxVar);
                        } catch (IOException e7) {
                            e = e7;
                            zzawyVar3 = zzawyVar;
                            exc = e;
                            zzawyVar3.zzd(zzags.RPC_ERROR);
                            taskCompletionSource.setException(exc);
                            zzawyVar3.zze();
                            this.zzg.zzb(zzawyVar3);
                        } catch (InterruptedException e8) {
                            e = e8;
                            zzawyVar3 = zzawyVar;
                            exc = e;
                            zzawyVar3.zzd(zzags.RPC_ERROR);
                            taskCompletionSource.setException(exc);
                            zzawyVar3.zze();
                            this.zzg.zzb(zzawyVar3);
                        } catch (Throwable th7) {
                            th = th7;
                            zzawyVar2 = zzawyVar;
                        }
                    }
                } catch (IOException e9) {
                    e = e9;
                } catch (InterruptedException e10) {
                    e = e10;
                }
            } catch (Throwable th8) {
                th = th8;
            }
        } catch (IOException e11) {
            e = e11;
            zzawyVar3 = zzawyVar;
            exc = e;
            zzawyVar3.zzd(zzags.RPC_ERROR);
            taskCompletionSource.setException(exc);
            zzawyVar3.zze();
            this.zzg.zzb(zzawyVar3);
        } catch (InterruptedException e12) {
            e = e12;
            zzawyVar3 = zzawyVar;
            exc = e;
            zzawyVar3.zzd(zzags.RPC_ERROR);
            taskCompletionSource.setException(exc);
            zzawyVar3.zze();
            this.zzg.zzb(zzawyVar3);
        } catch (Throwable th9) {
            th = th9;
            zzawyVar2 = zzawyVar;
        }
        zzawyVar3.zze();
        this.zzg.zzb(zzawyVar3);
    }
}
