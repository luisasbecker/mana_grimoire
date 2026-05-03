package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
final class zzlv implements ObjectEncoder {
    static final zzlv zza = new zzlv();

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("inferenceCommonLogEvent");
        zzbu zzbuVar = new zzbu();
        zzbuVar.zza(1);
        builder.withProperty(zzbuVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("options");
        zzbu zzbuVar2 = new zzbu();
        zzbuVar2.zza(2);
        builder2.withProperty(zzbuVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("inputLength");
        zzbu zzbuVar3 = new zzbu();
        zzbuVar3.zza(3);
        builder3.withProperty(zzbuVar3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("outputLength");
        zzbu zzbuVar4 = new zzbu();
        zzbuVar4.zza(4);
        builder4.withProperty(zzbuVar4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("loadDictionaryErrorCode");
        zzbu zzbuVar5 = new zzbu();
        zzbuVar5.zza(5);
        builder5.withProperty(zzbuVar5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("translateResultStatusCode");
        zzbu zzbuVar6 = new zzbu();
        zzbuVar6.zza(6);
        builder6.withProperty(zzbuVar6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("status");
        zzbu zzbuVar7 = new zzbu();
        zzbuVar7.zza(7);
        builder7.withProperty(zzbuVar7.zzb()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("downloadHttpResponseCode");
        zzbu zzbuVar8 = new zzbu();
        zzbuVar8.zza(8);
        builder8.withProperty(zzbuVar8.zzb()).build();
    }

    private zzlv() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
