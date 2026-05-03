package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbef;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbel;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public class zzbef<MessageType extends zzbel<MessageType, BuilderType>, BuilderType extends zzbef<MessageType, BuilderType>> extends zzbcj<MessageType, BuilderType> {
    protected zzbel zza;
    private final zzbel zzb;

    protected zzbef(MessageType messagetype) {
        this.zzb = messagetype;
        if (messagetype.zzU()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.zza = messagetype.zzF();
    }

    private static void zza(Object obj, Object obj2) {
        zzbgb.zza().zzb(obj.getClass()).zzg(obj, obj2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbft
    public final boolean zzA() {
        return zzbel.zzT(this.zza, false);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbcj
    protected final /* synthetic */ zzbcj zzo(zzbck zzbckVar) {
        zzs((zzbel) zzbckVar);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbcj, com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbfr
    public final /* bridge */ /* synthetic */ zzbfr zzq(zzbdj zzbdjVar, zzbdv zzbdvVar) throws IOException {
        if (!this.zza.zzU()) {
            zzz();
        }
        try {
            zzbgb.zza().zzb(this.zza.getClass()).zzh(this.zza, zzbdk.zzq(zzbdjVar), zzbdvVar);
            return this;
        } catch (RuntimeException e) {
            if (e.getCause() instanceof IOException) {
                throw ((IOException) e.getCause());
            }
            throw e;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbcj
    /* JADX INFO: renamed from: zzr, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final zzbef zzn() {
        zzbef zzbefVar = (zzbef) this.zzb.zzb(5, null, null);
        zzbefVar.zza = zzw();
        return zzbefVar;
    }

    public final zzbef zzs(zzbel zzbelVar) {
        if (!this.zzb.equals(zzbelVar)) {
            if (!this.zza.zzU()) {
                zzz();
            }
            zza(this.zza, zzbelVar);
        }
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbfr
    /* JADX INFO: renamed from: zzt, reason: merged with bridge method [inline-methods] */
    public final MessageType zzv() {
        MessageType messagetype = (MessageType) zzw();
        if (zzbel.zzT(messagetype, true)) {
            return messagetype;
        }
        throw new zzbhc(messagetype);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbfr
    /* JADX INFO: renamed from: zzu, reason: merged with bridge method [inline-methods] */
    public MessageType zzw() {
        boolean zZzU = this.zza.zzU();
        MessageType messagetype = (MessageType) this.zza;
        if (!zZzU) {
            return messagetype;
        }
        messagetype.zzP();
        return (MessageType) this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbft
    public final /* synthetic */ zzbfs zzx() {
        return this.zzb;
    }

    protected final void zzy() {
        if (this.zza.zzU()) {
            return;
        }
        zzz();
    }

    protected void zzz() {
        zzbel zzbelVarZzF = this.zzb.zzF();
        zza(zzbelVarZzF, this.zza);
        this.zza = zzbelVarZzF;
    }
}
