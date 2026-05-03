package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
final class zzlc implements ObjectEncoder {
    static final zzlc zza = new zzlc();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;
    private static final FieldDescriptor zzf;
    private static final FieldDescriptor zzg;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("detectorMode");
        zzbu zzbuVar = new zzbu();
        zzbuVar.zza(1);
        zzb = builder.withProperty(zzbuVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("multipleObjectsEnabled");
        zzbu zzbuVar2 = new zzbu();
        zzbuVar2.zza(2);
        zzc = builder2.withProperty(zzbuVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("classificationEnabled");
        zzbu zzbuVar3 = new zzbu();
        zzbuVar3.zza(3);
        zzd = builder3.withProperty(zzbuVar3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("maxPerObjectLabelCount");
        zzbu zzbuVar4 = new zzbu();
        zzbuVar4.zza(4);
        zze = builder4.withProperty(zzbuVar4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("classificationConfidenceThreshold");
        zzbu zzbuVar5 = new zzbu();
        zzbuVar5.zza(5);
        zzf = builder5.withProperty(zzbuVar5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("customLocalModelOptions");
        zzbu zzbuVar6 = new zzbu();
        zzbuVar6.zza(6);
        zzg = builder6.withProperty(zzbuVar6.zzb()).build();
    }

    private zzlc() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        zzrs zzrsVar = (zzrs) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(zzb, zzrsVar.zza());
        objectEncoderContext2.add(zzc, zzrsVar.zzc());
        objectEncoderContext2.add(zzd, zzrsVar.zzb());
        objectEncoderContext2.add(zze, (Object) null);
        objectEncoderContext2.add(zzf, (Object) null);
        objectEncoderContext2.add(zzg, (Object) null);
    }
}
