package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaon implements ObjectEncoder {
    static final zzaon zza = new zzaon();

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("inferenceCommonLogEvent");
        zznn zznnVar = new zznn();
        zznnVar.zza(1);
        builder.withProperty(zznnVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("imageInfo");
        zznn zznnVar2 = new zznn();
        zznnVar2.zza(2);
        builder2.withProperty(zznnVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("detectorOptions");
        zznn zznnVar3 = new zznn();
        zznnVar3.zza(3);
        builder3.withProperty(zznnVar3.zzb()).build();
    }

    private zzaon() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
