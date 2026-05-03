package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzapa implements ObjectEncoder {
    static final zzapa zza = new zzapa();

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("languageOption");
        zznn zznnVar = new zznn();
        zznnVar.zza(3);
        builder.withProperty(zznnVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("isUsingLegacyApi");
        zznn zznnVar2 = new zznn();
        zznnVar2.zza(4);
        builder2.withProperty(zznnVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("sdkVersion");
        zznn zznnVar3 = new zznn();
        zznnVar3.zza(5);
        builder3.withProperty(zznnVar3.zzb()).build();
    }

    private zzapa() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
