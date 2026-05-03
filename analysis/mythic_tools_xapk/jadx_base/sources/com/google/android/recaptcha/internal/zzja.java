package com.google.android.recaptcha.internal;

import android.app.Application;
import android.webkit.WebView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.TimeoutCancellationException;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzja extends zze {
    public CompletableDeferred zza;
    public zzfo zzb;
    private final zzek zzc;
    private zzsc zzf;
    private final zzek zzj;
    private final Lazy zzk;
    private final Lazy zzl;
    private final Lazy zzm;
    private final Lazy zzn;
    private final Lazy zzo;
    private zzen zzp;
    private final zzbi zzq;
    private final Map zzd = zzjb.zza();
    private final Map zze = new LinkedHashMap();
    private final zzcb zzg = new zzcb(zzje.zza);
    private final zzjh zzh = zzjh.zzc();
    private final zzij zzi = new zzij(this);

    public zzja(zzek zzekVar, zzbi zzbiVar) {
        this.zzc = zzekVar;
        this.zzq = zzbiVar;
        zzek zzekVarZza = zzekVar.zza();
        zzekVarZza.zzc(zzekVar.zzd());
        this.zzj = zzekVarZza;
        int i = zzav.zza;
        this.zzk = LazyKt.lazy(zzis.zza);
        this.zzl = LazyKt.lazy(zzit.zza);
        this.zzm = LazyKt.lazy(zziu.zza);
        this.zzn = LazyKt.lazy(zziv.zza);
        this.zzo = LazyKt.lazy(zziw.zza);
    }

    private final Application zzD() {
        return (Application) this.zzo.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzE(zzsc zzscVar, Continuation continuation) {
        zzim zzimVar;
        if (continuation instanceof zzim) {
            zzimVar = (zzim) continuation;
            int i = zzimVar.zzc;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzimVar.zzc = i - Integer.MIN_VALUE;
            } else {
                zzimVar = new zzim(this, continuation);
            }
        }
        Object objZzd = zzimVar.zza;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzimVar.zzc;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objZzd);
                zzff zzffVar = (zzff) this.zzn.getValue();
                zzek zzekVar = this.zzj;
                zzimVar.zzd = this;
                zzimVar.zzc = 1;
                objZzd = zzffVar.zzd(zzscVar, zzekVar, zzimVar);
                if (objZzd == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                this = zzimVar.zzd;
                ResultKt.throwOnFailure(objZzd);
            }
            BuildersKt__Builders_commonKt.launch$default(this.zzq.zzb(), null, null, new zzin(this, (String) objZzd, null), 3, null);
        } catch (zzbd e) {
            this.zzA().completeExceptionally(e);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzF(String str, Continuation continuation) {
        zzio zzioVar;
        String str2;
        Exception exc;
        zzja zzjaVar;
        zzen zzenVar;
        if (continuation instanceof zzio) {
            zzioVar = (zzio) continuation;
            int i = zzioVar.zzc;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzioVar.zzc = i - Integer.MIN_VALUE;
            } else {
                zzioVar = new zzio(this, continuation);
            }
        }
        Object obj = zzioVar.zza;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzioVar.zzc;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            this.zzp = this.zzj.zzf(26);
            try {
                String strZza = ((zzbr) this.zzl.getValue()).zza();
                zzioVar.zzd = this;
                zzioVar.zze = str;
                zzioVar.zzf = strZza;
                zzioVar.zzc = 1;
                Object objZzw = zzw(zzioVar);
                if (objZzw == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str2 = strZza;
                obj = objZzw;
            } catch (Exception e) {
                zzjaVar = this;
                exc = e;
                zzbd zzbdVar = new zzbd(zzbb.zzb, zzba.zzU, exc.getMessage());
                zzenVar = zzjaVar.zzp;
                if (zzenVar != null) {
                    zzenVar.zzb(zzbdVar);
                }
                zzjaVar.zzp = null;
                zzjaVar.zzA().completeExceptionally(zzbdVar);
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            String str3 = zzioVar.zzf;
            str = zzioVar.zze;
            zzjaVar = zzioVar.zzd;
            try {
                ResultKt.throwOnFailure(obj);
                str2 = str3;
                this = zzjaVar;
            } catch (Exception e2) {
                exc = e2;
                zzbd zzbdVar2 = new zzbd(zzbb.zzb, zzba.zzU, exc.getMessage());
                zzenVar = zzjaVar.zzp;
                if (zzenVar != null) {
                }
                zzjaVar.zzp = null;
                zzjaVar.zzA().completeExceptionally(zzbdVar2);
            }
        }
        ((WebView) obj).loadDataWithBaseURL(str2, str, "text/html", "utf-8", null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzG(String str, Continuation continuation) {
        zzix zzixVar;
        zzja zzjaVar;
        String str2;
        if (continuation instanceof zzix) {
            zzixVar = (zzix) continuation;
            int i = zzixVar.zzc;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzixVar.zzc = i - Integer.MIN_VALUE;
            } else {
                zzixVar = new zzix(this, continuation);
            }
        }
        Object objZzb = zzixVar.zza;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzixVar.zzc;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objZzb);
            zzcb zzcbVar = this.zzg;
            zzje[] zzjeVarArr = {zzje.zzd, zzje.zzc, zzje.zzb};
            zzixVar.zzd = this;
            zzixVar.zze = str;
            zzixVar.zzc = 1;
            objZzb = zzcbVar.zzb(zzjeVarArr, zzixVar);
            if (objZzb != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str2 = zzixVar.zze;
            zzjaVar = zzixVar.zzd;
            ResultKt.throwOnFailure(objZzb);
            zzjaVar.zza = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
            zzek zzekVar = zzjaVar.zzj;
            zzekVar.zzc(str2);
            BuildersKt__Builders_commonKt.launch$default(zzjaVar.zzq.zza(), null, null, new zziz(zzjaVar, zzekVar.zzf(42), null), 3, null);
            return Unit.INSTANCE;
        }
        str = zzixVar.zze;
        this = zzixVar.zzd;
        ResultKt.throwOnFailure(objZzb);
        if (((Boolean) objZzb).booleanValue()) {
            return Unit.INSTANCE;
        }
        zzcb zzcbVar2 = this.zzg;
        zzje zzjeVar = zzje.zzb;
        zzixVar.zzd = this;
        zzixVar.zze = str;
        zzixVar.zzc = 2;
        if (zzcbVar2.zzc(zzjeVar, zzixVar) != coroutine_suspended) {
            String str3 = str;
            zzjaVar = this;
            str2 = str3;
            zzjaVar.zza = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
            zzek zzekVar2 = zzjaVar.zzj;
            zzekVar2.zzc(str2);
            BuildersKt__Builders_commonKt.launch$default(zzjaVar.zzq.zza(), null, null, new zziz(zzjaVar, zzekVar2.zzf(42), null), 3, null);
            return Unit.INSTANCE;
        }
        return coroutine_suspended;
    }

    public static final /* synthetic */ zzfk zzp(zzja zzjaVar) {
        return (zzfk) zzjaVar.zzm.getValue();
    }

    public final CompletableDeferred zzA() {
        CompletableDeferred completableDeferred = this.zza;
        if (completableDeferred != null) {
            return completableDeferred;
        }
        return null;
    }

    public final zzft zzC(zzsc zzscVar, zzcg zzcgVar, WebView webView) {
        zzfw zzfwVar = new zzfw(webView, this.zzq.zzb());
        zzhy zzhyVar = new zzhy();
        zzhyVar.zzb(CollectionsKt.toLongArray(zzscVar.zzP()));
        zzgf zzgfVar = new zzgf(zzfwVar, zzcgVar, new zzbo());
        zzhz zzhzVar = new zzhz(zzhyVar, new zzhw());
        zzgfVar.zze(3, zzD());
        zzgfVar.zze(5, zzig.zza());
        zzgfVar.zze(6, new zzia(zzD()));
        zzgfVar.zze(7, new zzic());
        zzgfVar.zze(8, new zzii(zzD()));
        zzgfVar.zze(9, new zzid(zzD()));
        zzgfVar.zze(10, new zzib(zzD()));
        return new zzft(this.zzq.zzd(), zzgfVar, zzhzVar, zzfn.zza());
    }

    @Override // com.google.android.recaptcha.internal.zze
    protected final zzen zza(String str) {
        zzek zzekVar = this.zzc;
        zzekVar.zzc(str);
        return zzekVar.zzf(33);
    }

    @Override // com.google.android.recaptcha.internal.zze
    protected final zzen zzb() {
        zzek zzekVar = this.zzc;
        zzekVar.zzc(zzekVar.zzd());
        return zzekVar.zzf(32);
    }

    @Override // com.google.android.recaptcha.internal.zze
    protected final Object zzd(String str, Continuation continuation) {
        zzsh zzshVarZzf = zzsi.zzf();
        zzshVarZzf.zze(str);
        return zzshVarZzf.zzk();
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fe A[Catch: Exception -> 0x017e, PHI: r1 r4
      0x00fe: PHI (r1v17 java.lang.String) = (r1v15 java.lang.String), (r1v29 java.lang.String) binds: [B:46:0x00fc, B:24:0x005d] A[DONT_GENERATE, DONT_INLINE]
      0x00fe: PHI (r4v7 com.google.android.recaptcha.internal.zzja) = (r4v5 com.google.android.recaptcha.internal.zzja), (r4v21 com.google.android.recaptcha.internal.zzja) binds: [B:46:0x00fc, B:24:0x005d] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #0 {Exception -> 0x017e, blocks: (B:47:0x00fe, B:45:0x00ee), top: B:60:0x00ee }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // com.google.android.recaptcha.internal.zze
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final Object zzf(String str, Continuation continuation) {
        zzip zzipVar;
        String str2;
        zzja zzjaVar;
        String str3;
        String str4;
        CompletableDeferred completableDeferredZzA;
        String str5;
        zzja zzjaVar2;
        Object objAwait;
        CompletableDeferred completableDeferred;
        zzja zzjaVar3 = this;
        if (continuation instanceof zzip) {
            zzipVar = (zzip) continuation;
            int i = zzipVar.zzc;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzipVar.zzc = i - Integer.MIN_VALUE;
            } else {
                zzipVar = new zzip(zzjaVar3, continuation);
            }
        }
        Object objZza = zzipVar.zza;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzipVar.zzc;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objZza);
            zzcb zzcbVar = zzjaVar3.zzg;
            zzje zzjeVar = zzje.zzd;
            zzipVar.zzd = zzjaVar3;
            str2 = str;
            zzipVar.zze = str2;
            zzipVar.zzc = 1;
            objZza = zzcbVar.zza(zzjeVar, zzipVar);
            if (objZza != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 == 2) {
                str3 = zzipVar.zze;
                zzjaVar = zzipVar.zzd;
                ResultKt.throwOnFailure(objZza);
                if (!((Boolean) objZza).booleanValue()) {
                    zzipVar.zzd = zzjaVar;
                    zzipVar.zze = str3;
                    zzipVar.zzc = 3;
                    if (zzjaVar.zzG(str3, zzipVar) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                str4 = str3;
                completableDeferredZzA = zzjaVar.zzA();
                zzipVar.zzd = zzjaVar;
                zzipVar.zze = str4;
                zzipVar.zzc = 4;
                if (completableDeferredZzA.await(zzipVar) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i2 == 3) {
                str3 = zzipVar.zze;
                zzjaVar = zzipVar.zzd;
                ResultKt.throwOnFailure(objZza);
                str4 = str3;
                try {
                    completableDeferredZzA = zzjaVar.zzA();
                    zzipVar.zzd = zzjaVar;
                    zzipVar.zze = str4;
                    zzipVar.zzc = 4;
                    if (completableDeferredZzA.await(zzipVar) != coroutine_suspended) {
                        CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
                        zzjaVar.zze.put(str4, completableDeferredCompletableDeferred$default);
                        zztp zztpVarZzf = zztq.zzf();
                        zztpVarZzf.zze(str4);
                        byte[] bArrZzd = ((zztq) zztpVarZzf.zzk()).zzd();
                        BuildersKt__Builders_commonKt.launch$default(zzjaVar.zzq.zzb(), null, null, new zziq(zzjaVar, zzkh.zzh().zzi(bArrZzd, 0, bArrZzd.length), null), 3, null);
                        zzipVar.zzd = zzjaVar;
                        zzipVar.zze = str4;
                        zzipVar.zzc = 5;
                        objAwait = completableDeferredCompletableDeferred$default.await(zzipVar);
                        if (objAwait != coroutine_suspended) {
                        }
                    }
                    return coroutine_suspended;
                } catch (Exception e) {
                    e = e;
                    str5 = str4;
                    zzjaVar2 = zzjaVar;
                    zzbd zzbdVarZza = zzf.zza(e, new zzbd(zzbb.zzb, zzba.zzW, e.getMessage()));
                    completableDeferred = (CompletableDeferred) zzjaVar2.zze.remove(str5);
                    if (completableDeferred != null) {
                        Boxing.boxBoolean(completableDeferred.completeExceptionally(zzbdVarZza));
                    }
                    Result.Companion companion = Result.INSTANCE;
                    return Result.m11445constructorimpl(ResultKt.createFailure(zzbdVarZza));
                }
            }
            if (i2 != 4) {
                if (i2 != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str5 = zzipVar.zze;
                zzjaVar2 = zzipVar.zzd;
                try {
                    ResultKt.throwOnFailure(objZza);
                    zzsi zzsiVar = (zzsi) objZza;
                    zzsh zzshVarZzf = zzsi.zzf();
                    zzshVarZzf.zze(str5);
                    zzsl zzslVarZzf = zzsm.zzf();
                    zzslVarZzf.zze(zzsiVar.zzl());
                    zzshVarZzf.zzq(zzslVarZzf);
                    zzsj zzsjVarZzf = zzsk.zzf();
                    zzsjVarZzf.zze(zzsiVar.zzj());
                    zzsjVarZzf.zzf(zzsiVar.zzM());
                    zzshVarZzf.zzr(zzsjVarZzf);
                    Result.Companion companion2 = Result.INSTANCE;
                    return Result.m11445constructorimpl(zzshVarZzf.zzk());
                } catch (Exception e2) {
                    e = e2;
                    zzbd zzbdVarZza2 = zzf.zza(e, new zzbd(zzbb.zzb, zzba.zzW, e.getMessage()));
                    completableDeferred = (CompletableDeferred) zzjaVar2.zze.remove(str5);
                    if (completableDeferred != null) {
                    }
                    Result.Companion companion3 = Result.INSTANCE;
                    return Result.m11445constructorimpl(ResultKt.createFailure(zzbdVarZza2));
                }
            }
            String str6 = zzipVar.zze;
            zzja zzjaVar4 = zzipVar.zzd;
            try {
                ResultKt.throwOnFailure(objZza);
                str4 = str6;
                zzjaVar = zzjaVar4;
                CompletableDeferred completableDeferredCompletableDeferred$default2 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
                zzjaVar.zze.put(str4, completableDeferredCompletableDeferred$default2);
                zztp zztpVarZzf2 = zztq.zzf();
                zztpVarZzf2.zze(str4);
                byte[] bArrZzd2 = ((zztq) zztpVarZzf2.zzk()).zzd();
                BuildersKt__Builders_commonKt.launch$default(zzjaVar.zzq.zzb(), null, null, new zziq(zzjaVar, zzkh.zzh().zzi(bArrZzd2, 0, bArrZzd2.length), null), 3, null);
                zzipVar.zzd = zzjaVar;
                zzipVar.zze = str4;
                zzipVar.zzc = 5;
                objAwait = completableDeferredCompletableDeferred$default2.await(zzipVar);
                if (objAwait != coroutine_suspended) {
                    str5 = str4;
                    zzjaVar2 = zzjaVar;
                    objZza = objAwait;
                    zzsi zzsiVar2 = (zzsi) objZza;
                    zzsh zzshVarZzf2 = zzsi.zzf();
                    zzshVarZzf2.zze(str5);
                    zzsl zzslVarZzf2 = zzsm.zzf();
                    zzslVarZzf2.zze(zzsiVar2.zzl());
                    zzshVarZzf2.zzq(zzslVarZzf2);
                    zzsj zzsjVarZzf2 = zzsk.zzf();
                    zzsjVarZzf2.zze(zzsiVar2.zzj());
                    zzsjVarZzf2.zzf(zzsiVar2.zzM());
                    zzshVarZzf2.zzr(zzsjVarZzf2);
                    Result.Companion companion22 = Result.INSTANCE;
                    return Result.m11445constructorimpl(zzshVarZzf2.zzk());
                }
                return coroutine_suspended;
            } catch (Exception e3) {
                e = e3;
                str5 = str6;
                zzjaVar2 = zzjaVar4;
                zzbd zzbdVarZza22 = zzf.zza(e, new zzbd(zzbb.zzb, zzba.zzW, e.getMessage()));
                completableDeferred = (CompletableDeferred) zzjaVar2.zze.remove(str5);
                if (completableDeferred != null) {
                }
                Result.Companion companion32 = Result.INSTANCE;
                return Result.m11445constructorimpl(ResultKt.createFailure(zzbdVarZza22));
            }
        }
        String str7 = zzipVar.zze;
        zzja zzjaVar5 = zzipVar.zzd;
        ResultKt.throwOnFailure(objZza);
        str2 = str7;
        zzjaVar3 = zzjaVar5;
        if (((Boolean) objZza).booleanValue()) {
            zzbd zzbdVar = new zzbd(zzbb.zzb, zzba.zzav, null);
            Result.Companion companion4 = Result.INSTANCE;
            return Result.m11445constructorimpl(ResultKt.createFailure(zzbdVar));
        }
        zzcb zzcbVar2 = zzjaVar3.zzg;
        zzje zzjeVar2 = zzje.zzc;
        zzipVar.zzd = zzjaVar3;
        zzipVar.zze = str2;
        zzipVar.zzc = 2;
        objZza = zzcbVar2.zza(zzjeVar2, zzipVar);
        if (objZza != coroutine_suspended) {
            zzjaVar = zzjaVar3;
            str3 = str2;
            if (!((Boolean) objZza).booleanValue()) {
            }
            str4 = str3;
            completableDeferredZzA = zzjaVar.zzA();
            zzipVar.zzd = zzjaVar;
            zzipVar.zze = str4;
            zzipVar.zzc = 4;
            if (completableDeferredZzA.await(zzipVar) != coroutine_suspended) {
            }
        }
        return coroutine_suspended;
    }

    @Override // com.google.android.recaptcha.internal.zze
    protected final Object zzg(zzbd zzbdVar, Continuation continuation) {
        if (Intrinsics.areEqual(zzbdVar.zza(), zzba.zzb)) {
            zzen zzenVar = this.zzp;
            if (zzenVar != null) {
                zzenVar.zzb(zzbdVar);
            }
            this.zzp = null;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x005c, code lost:
    
        if (zzG(r6, r0) != r1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0071, code lost:
    
        if (r5.zzc(r6, r0) == r1) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.google.android.recaptcha.internal.zze
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final Object zzh(zzsc zzscVar, Continuation continuation) {
        zzir zzirVar;
        if (continuation instanceof zzir) {
            zzirVar = (zzir) continuation;
            int i = zzirVar.zzc;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzirVar.zzc = i - Integer.MIN_VALUE;
            } else {
                zzirVar = new zzir(this, continuation);
            }
        }
        Object obj = zzirVar.zza;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzirVar.zzc;
        if (i2 != 0) {
            if (i2 == 1) {
                ResultKt.throwOnFailure(obj);
                Result.Companion companion = Result.INSTANCE;
                return Result.m11445constructorimpl(ResultKt.createFailure(new zzbd(zzbb.zzb, zzba.zzav, null)));
            }
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m11445constructorimpl(Unit.INSTANCE);
        }
        ResultKt.throwOnFailure(obj);
        if (zzscVar.zzT() && zzscVar.zzR() && zzscVar.zzQ()) {
            this.zzf = zzscVar;
            String strZzd = this.zzc.zzd();
            zzirVar.zzc = 2;
        } else {
            zzcb zzcbVar = this.zzg;
            zzje zzjeVar = zzje.zzd;
            zzirVar.zzc = 1;
        }
        return coroutine_suspended;
    }

    @Override // com.google.android.recaptcha.internal.zze
    protected final Object zzi(String str, long j, Exception exc, Continuation continuation) {
        exc.getMessage();
        CompletableDeferred completableDeferred = (CompletableDeferred) this.zze.remove(str);
        if (completableDeferred != null) {
            Boxing.boxBoolean(completableDeferred.completeExceptionally(exc));
        }
        return Unit.INSTANCE;
    }

    @Override // com.google.android.recaptcha.internal.zze
    protected final Object zzj(Exception exc, Continuation continuation) {
        return ((exc instanceof TimeoutCancellationException) && this.zzi.zza() == null) ? new zzbd(zzbb.zzc, zzba.zzH, null) : zzf.zza(exc, new zzbd(zzbb.zzb, zzba.zzV, exc.getMessage()));
    }

    public final zzcb zzm() {
        return this.zzg;
    }

    public final zzij zzq() {
        return this.zzi;
    }

    public final Object zzw(Continuation continuation) {
        return BuildersKt.withContext(this.zzq.zzb().getCoroutineContext(), new zzjc((zzjd) this.zzk.getValue(), zzD(), null), continuation);
    }

    public final Object zzx(Continuation continuation) {
        Object objWithContext = BuildersKt.withContext(this.zzq.zzb().getCoroutineContext(), new zzil(this, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }
}
