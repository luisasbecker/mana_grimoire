package com.google.mlkit.vision.objects.defaults.internal;

import com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzpa;
import com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzuv;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.vkp.VkpStatus;
import java.util.List;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class zzc {
    public final /* synthetic */ zze zza;
    public final /* synthetic */ List zzb;
    public final /* synthetic */ long zzc;
    public final /* synthetic */ zzpa zzd;
    public final /* synthetic */ VkpStatus zze;
    public final /* synthetic */ boolean zzf;
    public final /* synthetic */ Boolean zzg;
    public final /* synthetic */ InputImage zzh;

    public /* synthetic */ zzc(zze zzeVar, List list, long j, zzpa zzpaVar, VkpStatus vkpStatus, boolean z, Boolean bool, InputImage inputImage) {
        this.zza = zzeVar;
        this.zzb = list;
        this.zzc = j;
        this.zzd = zzpaVar;
        this.zze = vkpStatus;
        this.zzf = z;
        this.zzg = bool;
        this.zzh = inputImage;
    }

    public final zzuv zza() {
        return this.zza.zzc(this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh);
    }
}
