package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
final class zzlw implements ObjectEncoder {
    static final zzlw zza = new zzlw();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("errorSpace");
        zzbu zzbuVar = new zzbu();
        zzbuVar.zza(1);
        zzb = builder.withProperty(zzbuVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("errorCode");
        zzbu zzbuVar2 = new zzbu();
        zzbuVar2.zza(2);
        zzc = builder2.withProperty(zzbuVar2.zzb()).build();
    }

    private zzlw() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        zzst zzstVar = (zzst) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(zzb, zzstVar.zza());
        objectEncoderContext2.add(zzc, zzstVar.zzb());
    }
}
