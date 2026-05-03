package com.google.android.recaptcha.internal;

import android.content.Context;
import com.google.android.play.core.integrity.StandardIntegrityManager;
import java.util.Timer;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.6.1 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzan {
    public CompletableDeferred zza;
    private final CoroutineScope zzb;
    private final zzek zzc;
    private final StandardIntegrityManager zzd;
    private long zzf;
    private boolean zzh;
    private zzao zze = zzao.zza;
    private final Mutex zzg = MutexKt.Mutex$default(false, 1, null);

    public zzan(Context context, CoroutineScope coroutineScope, zzek zzekVar, StandardIntegrityManager standardIntegrityManager, long j) {
        this.zzb = coroutineScope;
        this.zzc = zzekVar;
        this.zzd = standardIntegrityManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzi(Continuation continuation) throws Exception {
        zzag zzagVar;
        if (continuation instanceof zzag) {
            zzagVar = (zzag) continuation;
            int i = zzagVar.zzc;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzagVar.zzc = i - Integer.MIN_VALUE;
            } else {
                zzagVar = new zzag(this, continuation);
            }
        }
        Object obj = zzagVar.zza;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzagVar.zzc;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        Deferred deferredZza = zzbx.zza(this.zzd.prepareIntegrityToken(StandardIntegrityManager.PrepareIntegrityTokenRequest.builder().setCloudProjectNumber(this.zzf).build()));
        zzagVar.zzc = 1;
        Object objAwait = deferredZza.await(zzagVar);
        return objAwait == coroutine_suspended ? coroutine_suspended : objAwait;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006d, code lost:
    
        if (r7 == r1) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzj(String str, Continuation continuation) throws Exception {
        zzah zzahVar;
        if (continuation instanceof zzah) {
            zzahVar = (zzah) continuation;
            int i = zzahVar.zzc;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzahVar.zzc = i - Integer.MIN_VALUE;
            } else {
                zzahVar = new zzah(this, continuation);
            }
        }
        Object objAwait = zzahVar.zza;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzahVar.zzc;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objAwait);
            CompletableDeferred completableDeferredZzf = zzf();
            zzahVar.zzd = str;
            zzahVar.zzc = 1;
            objAwait = completableDeferredZzf.await(zzahVar);
            if (objAwait != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objAwait);
            return ((StandardIntegrityManager.StandardIntegrityToken) objAwait).token();
        }
        str = zzahVar.zzd;
        ResultKt.throwOnFailure(objAwait);
        Deferred deferredZza = zzbx.zza(((StandardIntegrityManager.StandardIntegrityTokenProvider) objAwait).request(StandardIntegrityManager.StandardIntegrityTokenRequest.builder().setRequestHash(str).build()));
        zzahVar.zzd = null;
        zzahVar.zzc = 2;
        objAwait = deferredZza.await(zzahVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0081, code lost:
    
        if (r9 != r1) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzc(String str, Continuation continuation) throws Exception {
        zzaf zzafVar;
        zzan zzanVar;
        String str2;
        if (continuation instanceof zzaf) {
            zzafVar = (zzaf) continuation;
            int i = zzafVar.zzc;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzafVar.zzc = i - Integer.MIN_VALUE;
            } else {
                zzafVar = new zzaf(this, continuation);
            }
        }
        Object objZzj = zzafVar.zza;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzafVar.zzc;
        try {
        } catch (Exception unused) {
            zzafVar.zzd = this;
            zzafVar.zze = str;
            zzafVar.zzc = 2;
            if (this.zze(zzafVar) != coroutine_suspended) {
                String str3 = str;
                zzanVar = this;
                str2 = str3;
            }
            return coroutine_suspended;
        }
        if (i2 == 0) {
            ResultKt.throwOnFailure(objZzj);
            zzafVar.zzd = this;
            zzafVar.zze = str;
            zzafVar.zzc = 1;
            objZzj = zzj(str, zzafVar);
            if (objZzj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 == 1) {
            str = zzafVar.zze;
            this = zzafVar.zzd;
            ResultKt.throwOnFailure(objZzj);
        } else {
            if (i2 != 2) {
                if (i2 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objZzj);
                return (String) objZzj;
            }
            str2 = zzafVar.zze;
            zzanVar = zzafVar.zzd;
            ResultKt.throwOnFailure(objZzj);
            zzafVar.zzd = null;
            zzafVar.zze = null;
            zzafVar.zzc = 3;
            objZzj = zzanVar.zzj(str2, zzafVar);
        }
        return (String) objZzj;
    }

    public final Object zzd(long j, Continuation continuation) {
        this.zzf = j;
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ba, code lost:
    
        if (kotlin.Unit.INSTANCE == r1) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zze(Continuation continuation) {
        zzak zzakVar;
        Mutex mutex;
        if (continuation instanceof zzak) {
            zzakVar = (zzak) continuation;
            int i = zzakVar.zzd;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzakVar.zzd = i - Integer.MIN_VALUE;
            } else {
                zzakVar = new zzak(this, continuation);
            }
        }
        Object obj = zzakVar.zzb;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzakVar.zzd;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = this.zzg;
                zzakVar.zze = this;
                zzakVar.zza = mutex;
                zzakVar.zzd = 1;
                if (mutex.lock(null, zzakVar) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            Mutex mutex2 = (Mutex) zzakVar.zza;
            zzan zzanVar = zzakVar.zze;
            ResultKt.throwOnFailure(obj);
            mutex = mutex2;
            this = zzanVar;
            if (!Intrinsics.areEqual(this.zze, zzao.zza)) {
                return Unit.INSTANCE;
            }
            this.zze = zzao.zzb;
            Unit unit = Unit.INSTANCE;
            mutex.unlock(null);
            zzek zzekVar = this.zzc;
            zzekVar.zzc(zzekVar.zzd());
            zzekVar.zzb(2);
            zzen zzenVarZzf = zzekVar.zzf(38);
            this.zza = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
            BuildersKt__Builders_commonKt.launch$default(this.zzb, null, null, new zzam(this, zzenVarZzf, null), 3, null);
            zzakVar.zze = null;
            zzakVar.zza = null;
            zzakVar.zzd = 2;
            if (!this.zzh) {
                new Timer().schedule(new zzai(this), 28800000L, 28800000L);
                this.zzh = true;
            }
        } finally {
            mutex.unlock(null);
        }
    }

    public final CompletableDeferred zzf() {
        CompletableDeferred completableDeferred = this.zza;
        if (completableDeferred != null) {
            return completableDeferred;
        }
        return null;
    }
}
