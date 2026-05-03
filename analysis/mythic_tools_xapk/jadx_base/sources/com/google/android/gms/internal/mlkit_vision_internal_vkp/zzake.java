package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzake implements ObjectEncoder {
    static final zzake zza = new zzake();

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("maxResults");
        zznn zznnVar = new zznn();
        zznnVar.zza(1);
        builder.withProperty(zznnVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("modelType");
        zznn zznnVar2 = new zznn();
        zznnVar2.zza(2);
        builder2.withProperty(zznnVar2.zzb()).build();
    }

    private zzake() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
