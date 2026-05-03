package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
final class zzalb implements ObjectEncoder {
    static final zzalb zza = new zzalb();

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("screenName");
        zznn zznnVar = new zznn();
        zznnVar.zza(1);
        builder.withProperty(zznnVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("sessionId");
        zznn zznnVar2 = new zznn();
        zznnVar2.zza(2);
        builder2.withProperty(zznnVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("timestampMs");
        zznn zznnVar3 = new zznn();
        zznnVar3.zza(3);
        builder3.withProperty(zznnVar3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("options");
        zznn zznnVar4 = new zznn();
        zznnVar4.zza(4);
        builder4.withProperty(zznnVar4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("elementName");
        zznn zznnVar5 = new zznn();
        zznnVar5.zza(5);
        builder5.withProperty(zznnVar5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("isAutoCaptureMode");
        zznn zznnVar6 = new zznn();
        zznnVar6.zza(6);
        builder6.withProperty(zznnVar6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("pageIndex");
        zznn zznnVar7 = new zznn();
        zznnVar7.zza(7);
        builder7.withProperty(zznnVar7.zzb()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("appliedToAllPages");
        zznn zznnVar8 = new zznn();
        zznnVar8.zza(8);
        builder8.withProperty(zznnVar8.zzb()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("errorCode");
        zznn zznnVar9 = new zznn();
        zznnVar9.zza(9);
        builder9.withProperty(zznnVar9.zzb()).build();
        FieldDescriptor.Builder builder10 = FieldDescriptor.builder("callerAppId");
        zznn zznnVar10 = new zznn();
        zznnVar10.zza(10);
        builder10.withProperty(zznnVar10.zzb()).build();
        FieldDescriptor.Builder builder11 = FieldDescriptor.builder("cleanUpStrokeSize");
        zznn zznnVar11 = new zznn();
        zznnVar11.zza(11);
        builder11.withProperty(zznnVar11.zzb()).build();
    }

    private zzalb() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
