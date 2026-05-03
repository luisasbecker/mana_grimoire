package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
final class zzh extends zzaz {
    final /* synthetic */ zzj zza;

    zzh(zzj zzjVar) {
        this.zza = zzjVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzaz, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@CheckForNull Object obj) {
        Set setEntrySet = this.zza.zza.entrySet();
        setEntrySet.getClass();
        try {
            return setEntrySet.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new zzi(this.zza);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzaz, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(@CheckForNull Object obj) {
        if (!contains(obj)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) Objects.requireNonNull((Map.Entry) obj);
        zzj zzjVar = this.zza;
        zzr.zzk(zzjVar.zzb, entry.getKey());
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzaz
    final Map zza() {
        return this.zza;
    }
}
