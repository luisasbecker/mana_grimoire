package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
final class zzij implements ObjectEncoder {
    static final zzij zza = new zzij();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;
    private static final FieldDescriptor zzf;
    private static final FieldDescriptor zzg;
    private static final FieldDescriptor zzh;
    private static final FieldDescriptor zzi;
    private static final FieldDescriptor zzj;
    private static final FieldDescriptor zzk;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("durationMs");
        zzbu zzbuVar = new zzbu();
        zzbuVar.zza(1);
        zzb = builder.withProperty(zzbuVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("errorCode");
        zzbu zzbuVar2 = new zzbu();
        zzbuVar2.zza(2);
        zzc = builder2.withProperty(zzbuVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("isColdCall");
        zzbu zzbuVar3 = new zzbu();
        zzbuVar3.zza(3);
        zzd = builder3.withProperty(zzbuVar3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("autoManageModelOnBackground");
        zzbu zzbuVar4 = new zzbu();
        zzbuVar4.zza(4);
        zze = builder4.withProperty(zzbuVar4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("autoManageModelOnLowMemory");
        zzbu zzbuVar5 = new zzbu();
        zzbuVar5.zza(5);
        zzf = builder5.withProperty(zzbuVar5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("isNnApiEnabled");
        zzbu zzbuVar6 = new zzbu();
        zzbuVar6.zza(6);
        zzg = builder6.withProperty(zzbuVar6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("eventsCount");
        zzbu zzbuVar7 = new zzbu();
        zzbuVar7.zza(7);
        zzh = builder7.withProperty(zzbuVar7.zzb()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("otherErrors");
        zzbu zzbuVar8 = new zzbu();
        zzbuVar8.zza(8);
        zzi = builder8.withProperty(zzbuVar8.zzb()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("remoteConfigValueForAcceleration");
        zzbu zzbuVar9 = new zzbu();
        zzbuVar9.zza(9);
        zzj = builder9.withProperty(zzbuVar9.zzb()).build();
        FieldDescriptor.Builder builder10 = FieldDescriptor.builder("isAccelerated");
        zzbu zzbuVar10 = new zzbu();
        zzbuVar10.zza(10);
        zzk = builder10.withProperty(zzbuVar10.zzb()).build();
    }

    private zzij() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        zzop zzopVar = (zzop) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(zzb, zzopVar.zzh());
        objectEncoderContext2.add(zzc, zzopVar.zzb());
        objectEncoderContext2.add(zzd, zzopVar.zzf());
        objectEncoderContext2.add(zze, zzopVar.zzc());
        objectEncoderContext2.add(zzf, zzopVar.zzd());
        objectEncoderContext2.add(zzg, (Object) null);
        objectEncoderContext2.add(zzh, (Object) null);
        objectEncoderContext2.add(zzi, zzopVar.zza());
        objectEncoderContext2.add(zzj, zzopVar.zzg());
        objectEncoderContext2.add(zzk, zzopVar.zze());
    }
}
