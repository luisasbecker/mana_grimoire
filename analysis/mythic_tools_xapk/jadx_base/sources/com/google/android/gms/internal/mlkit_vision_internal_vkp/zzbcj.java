package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbcj;
import com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbck;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzbcj<MessageType extends zzbck<MessageType, BuilderType>, BuilderType extends zzbcj<MessageType, BuilderType>> implements zzbfr {
    @Override // 
    public abstract zzbcj zzn();

    protected abstract zzbcj zzo(zzbck zzbckVar);

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbfr
    public final /* bridge */ /* synthetic */ zzbfr zzp(zzbfs zzbfsVar) {
        if (zzx().getClass().isInstance(zzbfsVar)) {
            return zzo((zzbck) zzbfsVar);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_internal_vkp.zzbfr
    public /* bridge */ /* synthetic */ zzbfr zzq(zzbdj zzbdjVar, zzbdv zzbdvVar) throws IOException {
        throw null;
    }
}
