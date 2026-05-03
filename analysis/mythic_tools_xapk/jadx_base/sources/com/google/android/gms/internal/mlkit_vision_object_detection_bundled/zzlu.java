package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
final class zzlu implements ObjectEncoder {
    static final zzlu zza = new zzlu();

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("languageOption");
        zzbu zzbuVar = new zzbu();
        zzbuVar.zza(3);
        builder.withProperty(zzbuVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("isUsingLegacyApi");
        zzbu zzbuVar2 = new zzbu();
        zzbuVar2.zza(4);
        builder2.withProperty(zzbuVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("sdkVersion");
        zzbu zzbuVar3 = new zzbu();
        zzbuVar3.zza(5);
        builder3.withProperty(zzbuVar3.zzb()).build();
    }

    private zzlu() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
