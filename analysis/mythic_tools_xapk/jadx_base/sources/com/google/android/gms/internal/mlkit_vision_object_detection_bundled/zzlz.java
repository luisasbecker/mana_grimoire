package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import com.facebook.internal.NativeProtocol;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
final class zzlz implements ObjectEncoder {
    static final zzlz zza = new zzlz();

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("deviceInfo");
        zzbu zzbuVar = new zzbu();
        zzbuVar.zza(1);
        builder.withProperty(zzbuVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("nnapiInfo");
        zzbu zzbuVar2 = new zzbu();
        zzbuVar2.zza(2);
        builder2.withProperty(zzbuVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("gpuInfo");
        zzbu zzbuVar3 = new zzbu();
        zzbuVar3.zza(3);
        builder3.withProperty(zzbuVar3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("pipelineIdentifier");
        zzbu zzbuVar4 = new zzbu();
        zzbuVar4.zza(4);
        builder4.withProperty(zzbuVar4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("acceptedConfigurations");
        zzbu zzbuVar5 = new zzbu();
        zzbuVar5.zza(5);
        builder5.withProperty(zzbuVar5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder(NativeProtocol.WEB_DIALOG_ACTION);
        zzbu zzbuVar6 = new zzbu();
        zzbuVar6.zza(6);
        builder6.withProperty(zzbuVar6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("status");
        zzbu zzbuVar7 = new zzbu();
        zzbuVar7.zza(7);
        builder7.withProperty(zzbuVar7.zzb()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("customErrors");
        zzbu zzbuVar8 = new zzbu();
        zzbuVar8.zza(8);
        builder8.withProperty(zzbuVar8.zzb()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("benchmarkStatus");
        zzbu zzbuVar9 = new zzbu();
        zzbuVar9.zza(9);
        builder9.withProperty(zzbuVar9.zzb()).build();
        FieldDescriptor.Builder builder10 = FieldDescriptor.builder("validationTestResult");
        zzbu zzbuVar10 = new zzbu();
        zzbuVar10.zza(10);
        builder10.withProperty(zzbuVar10.zzb()).build();
        FieldDescriptor.Builder builder11 = FieldDescriptor.builder("timestampUs");
        zzbu zzbuVar11 = new zzbu();
        zzbuVar11.zza(11);
        builder11.withProperty(zzbuVar11.zzb()).build();
        FieldDescriptor.Builder builder12 = FieldDescriptor.builder("elapsedUs");
        zzbu zzbuVar12 = new zzbu();
        zzbuVar12.zza(12);
        builder12.withProperty(zzbuVar12.zzb()).build();
    }

    private zzlz() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
