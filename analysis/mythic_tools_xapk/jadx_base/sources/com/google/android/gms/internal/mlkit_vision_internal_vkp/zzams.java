package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzams implements ObjectEncoder {
    static final zzams zza = new zzams();

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("useRecognition");
        zznn zznnVar = new zznn();
        zznnVar.zza(1);
        builder.withProperty(zznnVar.zzb()).build();
    }

    private zzams() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
