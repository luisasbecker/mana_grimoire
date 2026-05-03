package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaik implements ObjectEncoder {
    static final zzaik zza = new zzaik();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;
    private static final FieldDescriptor zzf;
    private static final FieldDescriptor zzg;
    private static final FieldDescriptor zzh;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("durationMs");
        zznn zznnVar = new zznn();
        zznnVar.zza(1);
        zzb = builder.withProperty(zznnVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("handledErrors");
        zznn zznnVar2 = new zznn();
        zznnVar2.zza(2);
        zzc = builder2.withProperty(zznnVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("partiallyHandledErrors");
        zznn zznnVar3 = new zznn();
        zznnVar3.zza(3);
        zzd = builder3.withProperty(zznnVar3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("unhandledErrors");
        zznn zznnVar4 = new zznn();
        zznnVar4.zza(4);
        zze = builder4.withProperty(zznnVar4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("modelNamespace");
        zznn zznnVar5 = new zznn();
        zznnVar5.zza(5);
        zzf = builder5.withProperty(zznnVar5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("delegateFilter");
        zznn zznnVar6 = new zznn();
        zznnVar6.zza(6);
        zzg = builder6.withProperty(zznnVar6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("httpResponseCode");
        zznn zznnVar7 = new zznn();
        zznnVar7.zza(7);
        zzh = builder7.withProperty(zznnVar7.zzb()).build();
    }

    private zzaik() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        zzagu zzaguVar = (zzagu) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(zzb, zzaguVar.zze());
        objectEncoderContext2.add(zzc, zzaguVar.zza());
        objectEncoderContext2.add(zzd, zzaguVar.zzb());
        objectEncoderContext2.add(zze, zzaguVar.zzc());
        objectEncoderContext2.add(zzf, zzaguVar.zzf());
        objectEncoderContext2.add(zzg, zzaguVar.zzd());
        objectEncoderContext2.add(zzh, (Object) null);
    }
}
