package com.google.android.gms.internal.play_billing;

import com.google.android.gms.internal.play_billing.zzfq;
import com.google.android.gms.internal.play_billing.zzfu;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.3.0 */
/* JADX INFO: loaded from: classes4.dex */
public class zzfq<MessageType extends zzfu<MessageType, BuilderType>, BuilderType extends zzfq<MessageType, BuilderType>> extends zzef<MessageType, BuilderType> {
    protected zzfu zza;
    private final zzfu zzb;

    protected zzfq(MessageType messagetype) {
        this.zzb = messagetype;
        if (messagetype.zzF()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.zza = messagetype.zzs();
    }

    private static void zza(Object obj, Object obj2) {
        zzhi.zza().zzb(obj.getClass()).zzg(obj, obj2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzef
    /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final zzfq clone() {
        zzfq zzfqVar = (zzfq) this.zzb.zzd(5, null, null);
        zzfqVar.zza = zzk();
        return zzfqVar;
    }

    public final zzfq zzh(zzfu zzfuVar) {
        if (!this.zzb.equals(zzfuVar)) {
            if (!this.zza.zzF()) {
                zzn();
            }
            zza(this.zza, zzfuVar);
        }
        return this;
    }

    public final MessageType zzi() {
        MessageType messagetype = (MessageType) zzk();
        if (messagetype.zzo()) {
            return messagetype;
        }
        throw new zzia(messagetype);
    }

    @Override // com.google.android.gms.internal.play_billing.zzha
    /* JADX INFO: renamed from: zzj, reason: merged with bridge method [inline-methods] */
    public MessageType zzk() {
        boolean zZzF = this.zza.zzF();
        MessageType messagetype = (MessageType) this.zza;
        if (!zZzF) {
            return messagetype;
        }
        messagetype.zzz();
        return (MessageType) this.zza;
    }

    @Override // com.google.android.gms.internal.play_billing.zzhc
    public final /* bridge */ /* synthetic */ zzhb zzl() {
        throw null;
    }

    protected final void zzm() {
        if (this.zza.zzF()) {
            return;
        }
        zzn();
    }

    protected void zzn() {
        zzfu zzfuVarZzs = this.zzb.zzs();
        zza(zzfuVarZzs, this.zza);
        this.zza = zzfuVarZzs;
    }

    @Override // com.google.android.gms.internal.play_billing.zzhc
    public final boolean zzo() {
        return zzfu.zzc(this.zza, false);
    }
}
