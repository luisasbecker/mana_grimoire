package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgw implements ObjectEncoder {
    static final zzgw zza = new zzgw();

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("cameraSource");
        zzbu zzbuVar = new zzbu();
        zzbuVar.zza(1);
        builder.withProperty(zzbuVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("eventType");
        zzbu zzbuVar2 = new zzbu();
        zzbuVar2.zza(2);
        builder2.withProperty(zzbuVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("requestedPreviewHeight");
        zzbu zzbuVar3 = new zzbu();
        zzbuVar3.zza(3);
        builder3.withProperty(zzbuVar3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("requestedPreviewWidth");
        zzbu zzbuVar4 = new zzbu();
        zzbuVar4.zza(4);
        builder4.withProperty(zzbuVar4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("actualPreviewHeight");
        zzbu zzbuVar5 = new zzbu();
        zzbuVar5.zza(5);
        builder5.withProperty(zzbuVar5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("actualPreviewWidth");
        zzbu zzbuVar6 = new zzbu();
        zzbuVar6.zza(6);
        builder6.withProperty(zzbuVar6.zzb()).build();
    }

    private zzgw() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
