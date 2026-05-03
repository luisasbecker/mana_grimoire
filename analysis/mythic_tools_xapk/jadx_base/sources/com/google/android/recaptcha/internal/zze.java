package com.google.android.recaptcha.internal;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zze {
    private boolean zza;

    protected zzen zza(String str) {
        throw null;
    }

    protected zzen zzb() {
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d5, code lost:
    
        if (r14 != r7) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzc(String str, long j, Continuation continuation) throws zzbd {
        zza zzaVar;
        String str2;
        long j2;
        Exception exc;
        int i;
        zze zzeVar;
        zzen zzenVar;
        zze zzeVar2;
        zze zzeVar3;
        String str3;
        if (continuation instanceof zza) {
            zzaVar = (zza) continuation;
            int i2 = zzaVar.zze;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                zzaVar.zze = i2 - Integer.MIN_VALUE;
            } else {
                zzaVar = new zza(this, continuation);
            }
        }
        zza zzaVar2 = zzaVar;
        Object objZzd = zzaVar2.zzc;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = zzaVar2.zze;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objZzd);
            zzen zzenVarZza = zza(str);
            try {
                zzb zzbVar = new zzb(this, str, null);
                zzaVar2.zza = this;
                zzaVar2.zzf = str;
                zzaVar2.zzg = zzenVarZza;
                zzaVar2.zzb = j;
                zzaVar2.zze = 1;
                Object objWithTimeout = TimeoutKt.withTimeout(j, zzbVar, zzaVar2);
                if (objWithTimeout != coroutine_suspended) {
                    zzeVar2 = this;
                    zzenVar = zzenVarZza;
                    objZzd = objWithTimeout;
                }
            } catch (Exception e) {
                str2 = str;
                j2 = j;
                exc = e;
                i = 2;
                zzeVar = this;
                zzenVar = zzenVarZza;
                zzbd zzbdVarZza = zzf.zza(exc, new zzbd(zzbb.zzb, zzba.zzaa, exc.getMessage()));
                if (zzenVar != null) {
                }
                zzaVar2.zza = zzeVar;
                zzaVar2.zzf = str2;
                zzaVar2.zzg = null;
                zzaVar2.zze = i;
                if (zzeVar.zzi(str2, j2, exc, zzaVar2) != coroutine_suspended) {
                }
            }
            return coroutine_suspended;
        }
        if (i3 == 1) {
            j = zzaVar2.zzb;
            zzenVar = zzaVar2.zzg;
            str = zzaVar2.zzf;
            zzeVar2 = (zze) zzaVar2.zza;
            try {
                ResultKt.throwOnFailure(objZzd);
            } catch (Exception e2) {
                zze zzeVar4 = zzeVar2;
                str2 = str;
                i = 2;
                zzeVar = zzeVar4;
                j2 = j;
                exc = e2;
                zzbd zzbdVarZza2 = zzf.zza(exc, new zzbd(zzbb.zzb, zzba.zzaa, exc.getMessage()));
                if (zzenVar != null) {
                    zzenVar.zzb(zzbdVarZza2);
                }
                zzaVar2.zza = zzeVar;
                zzaVar2.zzf = str2;
                zzaVar2.zzg = null;
                zzaVar2.zze = i;
                if (zzeVar.zzi(str2, j2, exc, zzaVar2) != coroutine_suspended) {
                    zzeVar3 = zzeVar;
                    str3 = str2;
                    Result.Companion companion = Result.INSTANCE;
                    zzaVar2.zza = null;
                    zzaVar2.zzf = null;
                    zzaVar2.zze = 3;
                    objZzd = zzeVar3.zzd(str3, zzaVar2);
                }
                return coroutine_suspended;
            }
        } else {
            if (i3 != 2) {
                if (i3 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objZzd);
                return Result.m11445constructorimpl(objZzd);
            }
            str3 = zzaVar2.zzf;
            zzeVar3 = (zze) zzaVar2.zza;
            ResultKt.throwOnFailure(objZzd);
            Result.Companion companion2 = Result.INSTANCE;
            zzaVar2.zza = null;
            zzaVar2.zzf = null;
            zzaVar2.zze = 3;
            objZzd = zzeVar3.zzd(str3, zzaVar2);
        }
        Object value = ((Result) objZzd).getValue();
        ResultKt.throwOnFailure(value);
        zzsi zzsiVar = (zzsi) value;
        if (zzenVar != null) {
            zzenVar.zza();
        }
        return Result.m11445constructorimpl(zzsiVar);
    }

    protected abstract Object zzd(String str, Continuation continuation);

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0088, code lost:
    
        if (r9 != r1) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zze(long j, zzsc zzscVar, Continuation continuation) throws zzbd {
        zzc zzcVar;
        zzen zzenVarZzb;
        Object objWithTimeout;
        Exception e;
        Object objZzj;
        zze zzeVar;
        zzen zzenVar;
        zzbd zzbdVar;
        zzbd zzbdVar2;
        if (continuation instanceof zzc) {
            zzcVar = (zzc) continuation;
            int i = zzcVar.zzd;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzcVar.zzd = i - Integer.MIN_VALUE;
            } else {
                zzcVar = new zzc(this, continuation);
            }
        }
        Object obj = zzcVar.zzb;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzcVar.zzd;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            zzenVarZzb = zzb();
            if (this.zza) {
                zzenVarZzb.zza();
                Result.Companion companion = Result.INSTANCE;
                return Result.m11445constructorimpl(Unit.INSTANCE);
            }
            try {
                zzd zzdVar = new zzd(this, zzscVar, null);
                zzcVar.zza = this;
                zzcVar.zze = zzenVarZzb;
                zzcVar.zzd = 1;
                objWithTimeout = TimeoutKt.withTimeout(j, zzdVar, zzcVar);
            } catch (Exception e2) {
                e = e2;
                this.zza = false;
                zzcVar.zza = this;
                zzcVar.zze = zzenVarZzb;
                zzcVar.zzd = 2;
                objZzj = this.zzj(e, zzcVar);
                if (objZzj != coroutine_suspended) {
                }
            }
        } else {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    zzbdVar2 = (zzbd) zzcVar.zza;
                    ResultKt.throwOnFailure(obj);
                    Result.Companion companion2 = Result.INSTANCE;
                    return Result.m11445constructorimpl(ResultKt.createFailure(zzbdVar2));
                }
                zzenVar = zzcVar.zze;
                zzeVar = (zze) zzcVar.zza;
                ResultKt.throwOnFailure(obj);
                zzbdVar = (zzbd) obj;
                if (zzenVar != null) {
                    zzenVar.zzb(zzbdVar);
                }
                zzcVar.zza = zzbdVar;
                zzcVar.zze = null;
                zzcVar.zzd = 3;
                if (zzeVar.zzg(zzbdVar, zzcVar) != coroutine_suspended) {
                    zzbdVar2 = zzbdVar;
                    Result.Companion companion22 = Result.INSTANCE;
                    return Result.m11445constructorimpl(ResultKt.createFailure(zzbdVar2));
                }
                return coroutine_suspended;
            }
            zzen zzenVar2 = zzcVar.zze;
            zze zzeVar2 = (zze) zzcVar.zza;
            try {
                ResultKt.throwOnFailure(obj);
                zzenVarZzb = zzenVar2;
                this = zzeVar2;
                objWithTimeout = obj;
            } catch (Exception e3) {
                e = e3;
                zzenVarZzb = zzenVar2;
                this = zzeVar2;
                this.zza = false;
                zzcVar.zza = this;
                zzcVar.zze = zzenVarZzb;
                zzcVar.zzd = 2;
                objZzj = this.zzj(e, zzcVar);
                if (objZzj != coroutine_suspended) {
                    zzeVar = this;
                    zzenVar = zzenVarZzb;
                    obj = objZzj;
                    zzbdVar = (zzbd) obj;
                    if (zzenVar != null) {
                    }
                    zzcVar.zza = zzbdVar;
                    zzcVar.zze = null;
                    zzcVar.zzd = 3;
                    if (zzeVar.zzg(zzbdVar, zzcVar) != coroutine_suspended) {
                    }
                }
                return coroutine_suspended;
            }
        }
        ResultKt.throwOnFailure(((Result) objWithTimeout).getValue());
        Unit unit = Unit.INSTANCE;
        this.zza = true;
        if (zzenVarZzb != null) {
            zzenVarZzb.zza();
        }
        return Result.m11445constructorimpl(unit);
    }

    protected abstract Object zzf(String str, Continuation continuation) throws zzbd;

    protected Object zzg(zzbd zzbdVar, Continuation continuation) {
        return Unit.INSTANCE;
    }

    protected abstract Object zzh(zzsc zzscVar, Continuation continuation) throws zzbd;

    protected Object zzi(String str, long j, Exception exc, Continuation continuation) {
        return Unit.INSTANCE;
    }

    protected Object zzj(Exception exc, Continuation continuation) {
        return zzf.zza(exc, new zzbd(zzbb.zzb, zzba.zzap, exc.getMessage()));
    }

    protected void zzk(zzsr zzsrVar) {
    }

    public final boolean zzl() {
        return this.zza;
    }
}
