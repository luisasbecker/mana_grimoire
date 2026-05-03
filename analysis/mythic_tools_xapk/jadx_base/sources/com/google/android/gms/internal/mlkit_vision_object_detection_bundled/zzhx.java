package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhx implements ObjectEncoder {
    static final zzhx zza = new zzhx();

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("initialImageUriCount");
        zzbu zzbuVar = new zzbu();
        zzbuVar.zza(1);
        builder.withProperty(zzbuVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("defaultCaptureMode");
        zzbu zzbuVar2 = new zzbu();
        zzbuVar2.zza(2);
        builder2.withProperty(zzbuVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("flashModeChangeAllowed");
        zzbu zzbuVar3 = new zzbu();
        zzbuVar3.zza(3);
        builder3.withProperty(zzbuVar3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("galleryImportAllowed");
        zzbu zzbuVar4 = new zzbu();
        zzbuVar4.zza(4);
        builder4.withProperty(zzbuVar4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("multiPageAllowed");
        zzbu zzbuVar5 = new zzbu();
        zzbuVar5.zza(5);
        builder5.withProperty(zzbuVar5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("filterAllowed");
        zzbu zzbuVar6 = new zzbu();
        zzbuVar6.zza(6);
        builder6.withProperty(zzbuVar6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("targetResolutionWidth");
        zzbu zzbuVar7 = new zzbu();
        zzbuVar7.zza(7);
        builder7.withProperty(zzbuVar7.zzb()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("targetResolutionHeight");
        zzbu zzbuVar8 = new zzbu();
        zzbuVar8.zza(8);
        builder8.withProperty(zzbuVar8.zzb()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("resultFormats");
        zzbu zzbuVar9 = new zzbu();
        zzbuVar9.zza(9);
        builder9.withProperty(zzbuVar9.zzb()).build();
        FieldDescriptor.Builder builder10 = FieldDescriptor.builder("pageEditListenerSet");
        zzbu zzbuVar10 = new zzbu();
        zzbuVar10.zza(10);
        builder10.withProperty(zzbuVar10.zzb()).build();
        FieldDescriptor.Builder builder11 = FieldDescriptor.builder("shadowRemovalAllowed");
        zzbu zzbuVar11 = new zzbu();
        zzbuVar11.zza(11);
        builder11.withProperty(zzbuVar11.zzb()).build();
        FieldDescriptor.Builder builder12 = FieldDescriptor.builder("stainRemovalAllowed");
        zzbu zzbuVar12 = new zzbu();
        zzbuVar12.zza(12);
        builder12.withProperty(zzbuVar12.zzb()).build();
        FieldDescriptor.Builder builder13 = FieldDescriptor.builder("enableAllNewFeaturesByDefault");
        zzbu zzbuVar13 = new zzbu();
        zzbuVar13.zza(13);
        builder13.withProperty(zzbuVar13.zzb()).build();
        FieldDescriptor.Builder builder14 = FieldDescriptor.builder("pageLimitMax");
        zzbu zzbuVar14 = new zzbu();
        zzbuVar14.zza(14);
        builder14.withProperty(zzbuVar14.zzb()).build();
        FieldDescriptor.Builder builder15 = FieldDescriptor.builder("enableGalleryImportAutoTransform");
        zzbu zzbuVar15 = new zzbu();
        zzbuVar15.zza(15);
        builder15.withProperty(zzbuVar15.zzb()).build();
    }

    private zzhx() {
    }

    @Override // com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
