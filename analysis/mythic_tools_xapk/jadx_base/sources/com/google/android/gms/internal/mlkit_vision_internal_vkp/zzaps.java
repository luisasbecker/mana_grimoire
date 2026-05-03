package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaps implements ObjectEncoder {
    static final zzaps zza = new zzaps();
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
    private static final FieldDescriptor zzl;
    private static final FieldDescriptor zzm;
    private static final FieldDescriptor zzn;
    private static final FieldDescriptor zzo;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("appId");
        zznn zznnVar = new zznn();
        zznnVar.zza(1);
        zzb = builder.withProperty(zznnVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("appVersion");
        zznn zznnVar2 = new zznn();
        zznnVar2.zza(2);
        zzc = builder2.withProperty(zznnVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("firebaseProjectId");
        zznn zznnVar3 = new zznn();
        zznnVar3.zza(3);
        zzd = builder3.withProperty(zznnVar3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("mlSdkVersion");
        zznn zznnVar4 = new zznn();
        zznnVar4.zza(4);
        zze = builder4.withProperty(zznnVar4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("tfliteSchemaVersion");
        zznn zznnVar5 = new zznn();
        zznnVar5.zza(5);
        zzf = builder5.withProperty(zznnVar5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("gcmSenderId");
        zznn zznnVar6 = new zznn();
        zznnVar6.zza(6);
        zzg = builder6.withProperty(zznnVar6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("apiKey");
        zznn zznnVar7 = new zznn();
        zznnVar7.zza(7);
        zzh = builder7.withProperty(zznnVar7.zzb()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("languages");
        zznn zznnVar8 = new zznn();
        zznnVar8.zza(8);
        zzi = builder8.withProperty(zznnVar8.zzb()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("mlSdkInstanceId");
        zznn zznnVar9 = new zznn();
        zznnVar9.zza(9);
        zzj = builder9.withProperty(zznnVar9.zzb()).build();
        FieldDescriptor.Builder builder10 = FieldDescriptor.builder("isClearcutClient");
        zznn zznnVar10 = new zznn();
        zznnVar10.zza(10);
        zzk = builder10.withProperty(zznnVar10.zzb()).build();
        FieldDescriptor.Builder builder11 = FieldDescriptor.builder("isStandaloneMlkit");
        zznn zznnVar11 = new zznn();
        zznnVar11.zza(11);
        zzl = builder11.withProperty(zznnVar11.zzb()).build();
        FieldDescriptor.Builder builder12 = FieldDescriptor.builder("isJsonLogging");
        zznn zznnVar12 = new zznn();
        zznnVar12.zza(12);
        zzm = builder12.withProperty(zznnVar12.zzb()).build();
        FieldDescriptor.Builder builder13 = FieldDescriptor.builder("buildLevel");
        zznn zznnVar13 = new zznn();
        zznnVar13.zza(13);
        zzn = builder13.withProperty(zznnVar13.zzb()).build();
        FieldDescriptor.Builder builder14 = FieldDescriptor.builder("optionalModuleVersion");
        zznn zznnVar14 = new zznn();
        zznnVar14.zza(14);
        zzo = builder14.withProperty(zznnVar14.zzb()).build();
    }

    private zzaps() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        zzavs zzavsVar = (zzavs) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(zzb, zzavsVar.zzg());
        objectEncoderContext2.add(zzc, zzavsVar.zzh());
        objectEncoderContext2.add(zzd, (Object) null);
        objectEncoderContext2.add(zze, zzavsVar.zzj());
        objectEncoderContext2.add(zzf, zzavsVar.zzk());
        objectEncoderContext2.add(zzg, (Object) null);
        objectEncoderContext2.add(zzh, (Object) null);
        objectEncoderContext2.add(zzi, zzavsVar.zza());
        objectEncoderContext2.add(zzj, zzavsVar.zzi());
        objectEncoderContext2.add(zzk, zzavsVar.zzb());
        objectEncoderContext2.add(zzl, zzavsVar.zzd());
        objectEncoderContext2.add(zzm, zzavsVar.zzc());
        objectEncoderContext2.add(zzn, zzavsVar.zze());
        objectEncoderContext2.add(zzo, zzavsVar.zzf());
    }
}
