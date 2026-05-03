package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzapi implements ObjectEncoder {
    static final zzapi zza = new zzapi();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;
    private static final FieldDescriptor zzf;

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
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("httpResponseCode");
        zznn zznnVar5 = new zznn();
        zznnVar5.zza(5);
        zzf = builder5.withProperty(zznnVar5.zzb()).build();
    }

    private zzapi() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        zzavg zzavgVar = (zzavg) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(zzb, zzavgVar.zze());
        objectEncoderContext2.add(zzc, zzavgVar.zza());
        objectEncoderContext2.add(zzd, zzavgVar.zzb());
        objectEncoderContext2.add(zze, zzavgVar.zzc());
        objectEncoderContext2.add(zzf, zzavgVar.zzd());
    }
}
