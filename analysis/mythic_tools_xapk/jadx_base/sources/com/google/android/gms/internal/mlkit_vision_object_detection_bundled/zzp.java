package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
final class zzp extends zzn implements ListIterator {
    final /* synthetic */ zzq zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzp(zzq zzqVar) {
        super(zzqVar);
        this.zzd = zzqVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzp(zzq zzqVar, int i) {
        super(zzqVar, ((List) zzqVar.zzb).listIterator(i));
        this.zzd = zzqVar;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        boolean zIsEmpty = this.zzd.isEmpty();
        zza();
        ((ListIterator) this.zza).add(obj);
        this.zzd.zzf.zzb++;
        if (zIsEmpty) {
            this.zzd.zza();
        }
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        zza();
        return ((ListIterator) this.zza).hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        zza();
        return ((ListIterator) this.zza).nextIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        zza();
        return ((ListIterator) this.zza).previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        zza();
        return ((ListIterator) this.zza).previousIndex();
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        zza();
        ((ListIterator) this.zza).set(obj);
    }
}
