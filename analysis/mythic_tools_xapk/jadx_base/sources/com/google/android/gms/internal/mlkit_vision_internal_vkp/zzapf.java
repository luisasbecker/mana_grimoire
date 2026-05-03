package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import com.facebook.internal.NativeProtocol;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzapf implements ObjectEncoder {
    static final zzapf zza = new zzapf();

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("deviceInfo");
        zznn zznnVar = new zznn();
        zznnVar.zza(1);
        builder.withProperty(zznnVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("nnapiInfo");
        zznn zznnVar2 = new zznn();
        zznnVar2.zza(2);
        builder2.withProperty(zznnVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("gpuInfo");
        zznn zznnVar3 = new zznn();
        zznnVar3.zza(3);
        builder3.withProperty(zznnVar3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("pipelineIdentifier");
        zznn zznnVar4 = new zznn();
        zznnVar4.zza(4);
        builder4.withProperty(zznnVar4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("acceptedConfigurations");
        zznn zznnVar5 = new zznn();
        zznnVar5.zza(5);
        builder5.withProperty(zznnVar5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder(NativeProtocol.WEB_DIALOG_ACTION);
        zznn zznnVar6 = new zznn();
        zznnVar6.zza(6);
        builder6.withProperty(zznnVar6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("status");
        zznn zznnVar7 = new zznn();
        zznnVar7.zza(7);
        builder7.withProperty(zznnVar7.zzb()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("customErrors");
        zznn zznnVar8 = new zznn();
        zznnVar8.zza(8);
        builder8.withProperty(zznnVar8.zzb()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("benchmarkStatus");
        zznn zznnVar9 = new zznn();
        zznnVar9.zza(9);
        builder9.withProperty(zznnVar9.zzb()).build();
        FieldDescriptor.Builder builder10 = FieldDescriptor.builder("validationTestResult");
        zznn zznnVar10 = new zznn();
        zznnVar10.zza(10);
        builder10.withProperty(zznnVar10.zzb()).build();
        FieldDescriptor.Builder builder11 = FieldDescriptor.builder("timestampUs");
        zznn zznnVar11 = new zznn();
        zznnVar11.zza(11);
        builder11.withProperty(zznnVar11.zzb()).build();
        FieldDescriptor.Builder builder12 = FieldDescriptor.builder("elapsedUs");
        zznn zznnVar12 = new zznn();
        zznnVar12.zza(12);
        builder12.withProperty(zznnVar12.zzb()).build();
    }

    private zzapf() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
