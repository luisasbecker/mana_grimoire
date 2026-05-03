package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.RecaptchaAction;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzef implements zzcn {
    private final zzdt zza;
    private zzcm zzb = zzcm.zza;
    private zzsc zzc;

    public zzef(zzdt zzdtVar) {
        this.zza = zzdtVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    @Override // com.google.android.recaptcha.internal.zzcn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zza(String str, RecaptchaAction recaptchaAction, long j, Continuation continuation) throws zzbd {
        zzed zzedVar;
        RecaptchaAction recaptchaAction2;
        double d;
        zzef zzefVar;
        String str2;
        zzef zzefVar2 = this;
        String str3 = str;
        if (continuation instanceof zzed) {
            zzedVar = (zzed) continuation;
            int i = zzedVar.zzd;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzedVar.zzd = i - Integer.MIN_VALUE;
            } else {
                zzedVar = new zzed(zzefVar2, continuation);
            }
        }
        Object objZzl = zzedVar.zzb;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzedVar.zzd;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objZzl);
                if (!Intrinsics.areEqual(zzefVar2.zzb, zzcm.zzb)) {
                    throw new zzbd(zzbb.zzb, zzba.zzar, null);
                }
                double d2 = j;
                zzdt zzdtVar = zzefVar2.zza;
                double d3 = 0.45d * d2;
                zzedVar.zze = zzefVar2;
                zzedVar.zzf = str3;
                recaptchaAction2 = recaptchaAction;
                zzedVar.zzg = recaptchaAction2;
                d = d2 * 0.55d;
                zzedVar.zza = d;
                zzedVar.zzd = 1;
                objZzl = zzdtVar.zzl(str3, (long) d3, zzedVar);
                if (objZzl != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str2 = zzedVar.zzf;
                zzefVar = zzedVar.zze;
                ResultKt.throwOnFailure(objZzl);
                zzsr zzsrVar = (zzsr) objZzl;
                zzefVar.zza.zzq(str2, zzsrVar);
                return zzsrVar.zzj();
            }
            double d4 = zzedVar.zza;
            recaptchaAction2 = zzedVar.zzg;
            String str4 = zzedVar.zzf;
            zzef zzefVar3 = zzedVar.zze;
            ResultKt.throwOnFailure(objZzl);
            zzefVar2 = zzefVar3;
            d = d4;
            str3 = str4;
            zzsi zzsiVar = (zzsi) objZzl;
            zzdt zzdtVar2 = zzefVar2.zza;
            zzsc zzscVar = zzefVar2.zzc;
            if (zzscVar == null) {
                zzscVar = null;
            }
            zzsp zzspVarZzi = zzdtVar2.zzi(recaptchaAction2, zzsiVar, zzscVar);
            zzedVar.zze = zzefVar2;
            zzedVar.zzf = str3;
            zzedVar.zzg = null;
            zzedVar.zzd = 2;
            String str5 = str3;
            objZzl = zzefVar2.zza.zzm(zzspVarZzi, str5, (long) d, zzedVar);
            if (objZzl != coroutine_suspended) {
                zzefVar = zzefVar2;
                str2 = str5;
                zzsr zzsrVar2 = (zzsr) objZzl;
                zzefVar.zza.zzq(str2, zzsrVar2);
                return zzsrVar2.zzj();
            }
            return coroutine_suspended;
        } catch (zzbd e) {
            throw e;
        } catch (Exception e2) {
            throw new zzbd(zzbb.zzb, zzba.zzaz, e2.getMessage());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x009d, code lost:
    
        if (r11.zza.zzn(r14, (long) r12, r0) != r1) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.google.android.recaptcha.internal.zzcn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzb(long j, Continuation continuation) throws zzbd {
        zzee zzeeVar;
        double d;
        if (continuation instanceof zzee) {
            zzeeVar = (zzee) continuation;
            int i = zzeeVar.zzd;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzeeVar.zzd = i - Integer.MIN_VALUE;
            } else {
                zzeeVar = new zzee(this, continuation);
            }
        }
        Object objZzo = zzeeVar.zzb;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzeeVar.zzd;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objZzo);
                if (Intrinsics.areEqual(this.zzb, zzcm.zzb) || Intrinsics.areEqual(this.zzb, zzcm.zzd)) {
                    return Unit.INSTANCE;
                }
                this.zzb = zzcm.zzc;
                double d2 = j;
                zzdt zzdtVar = this.zza;
                double d3 = 0.6d * d2;
                zzeeVar.zze = this;
                d = d2 * 0.4d;
                zzeeVar.zza = d;
                zzeeVar.zzd = 1;
                objZzo = zzdtVar.zzo((long) d3, zzeeVar);
                if (objZzo != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                this = zzeeVar.zze;
                ResultKt.throwOnFailure(objZzo);
                this.zzb = zzcm.zzb;
                return Unit.INSTANCE;
            }
            double d4 = zzeeVar.zza;
            zzef zzefVar = zzeeVar.zze;
            try {
                ResultKt.throwOnFailure(objZzo);
                this = zzefVar;
                d = d4;
            } catch (zzbd e) {
                e = e;
                this = zzefVar;
                this.zzb = zzcm.zzd;
                throw e;
            }
            zzsc zzscVar = (zzsc) objZzo;
            this.zzc = zzscVar;
            zzeeVar.zze = this;
            zzeeVar.zzd = 2;
        } catch (zzbd e2) {
            e = e2;
        }
    }
}
