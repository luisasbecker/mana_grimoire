package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import com.facebook.internal.NativeProtocol;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzajq implements ObjectEncoder {
    static final zzajq zza = new zzajq();

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("errorCode");
        zznn zznnVar = new zznn();
        zznnVar.zza(1);
        builder.withProperty(zznnVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("imageInfo");
        zznn zznnVar2 = new zznn();
        zznnVar2.zza(2);
        builder2.withProperty(zznnVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("isColdCall");
        zznn zznnVar3 = new zznn();
        zznnVar3.zza(3);
        builder3.withProperty(zznnVar3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder(NativeProtocol.WEB_DIALOG_PARAMS);
        zznn zznnVar4 = new zznn();
        zznnVar4.zza(4);
        builder4.withProperty(zznnVar4.zzb()).build();
    }

    private zzajq() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
