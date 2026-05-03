package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzda extends AbstractMap implements Serializable {
    private static final Comparator zze = new zzct();
    zzcz zza;
    int zzb;
    int zzc;
    final zzcz zzd;
    private final Comparator zzf;
    private final boolean zzg;
    private zzcv zzh;
    private zzcx zzi;

    public zzda() {
        this(zze, true);
    }

    public zzda(Comparator comparator, boolean z) {
        this.zzb = 0;
        this.zzc = 0;
        this.zzf = comparator;
        this.zzg = z;
        this.zzd = new zzcz(z);
    }

    public zzda(boolean z) {
        this(zze, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0084 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0084 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0080 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0080 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zzf(zzcz zzczVar, boolean z) {
        while (zzczVar != null) {
            zzcz zzczVar2 = zzczVar.zzb;
            zzcz zzczVar3 = zzczVar.zzc;
            boolean z2 = false;
            int i = zzczVar2 != null ? zzczVar2.zzi : 0;
            int i2 = zzczVar3 != null ? zzczVar3.zzi : 0;
            int i3 = i - i2;
            boolean z3 = true;
            if (i3 == -2) {
                zzcz zzczVar4 = zzczVar3.zzb;
                zzcz zzczVar5 = zzczVar3.zzc;
                int i4 = (zzczVar4 != null ? zzczVar4.zzi : 0) - (zzczVar5 != null ? zzczVar5.zzi : 0);
                if (i4 != -1) {
                    if (i4 == 0) {
                        if (!z) {
                        }
                        if (z3) {
                            return;
                        }
                    } else {
                        z3 = z;
                    }
                    zzi(zzczVar3);
                    zzh(zzczVar);
                    if (z3) {
                    }
                } else {
                    z2 = z;
                }
                zzh(zzczVar);
                z3 = z2;
                if (z3) {
                }
            } else if (i3 == 2) {
                zzcz zzczVar6 = zzczVar2.zzb;
                zzcz zzczVar7 = zzczVar2.zzc;
                int i5 = (zzczVar6 != null ? zzczVar6.zzi : 0) - (zzczVar7 != null ? zzczVar7.zzi : 0);
                if (i5 != 1) {
                    if (i5 == 0) {
                        if (!z) {
                        }
                        if (z3) {
                            return;
                        }
                    } else {
                        z3 = z;
                    }
                    zzh(zzczVar2);
                    zzi(zzczVar);
                    if (z3) {
                    }
                } else {
                    z2 = z;
                }
                zzi(zzczVar);
                z3 = z2;
                if (z3) {
                }
            } else if (i3 == 0) {
                zzczVar.zzi = i + 1;
                if (z) {
                    return;
                }
            } else {
                zzczVar.zzi = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            zzczVar = zzczVar.zza;
        }
    }

    private final void zzg(zzcz zzczVar, zzcz zzczVar2) {
        zzcz zzczVar3 = zzczVar.zza;
        zzczVar.zza = null;
        if (zzczVar2 != null) {
            zzczVar2.zza = zzczVar3;
        }
        if (zzczVar3 == null) {
            this.zza = zzczVar2;
        } else if (zzczVar3.zzb == zzczVar) {
            zzczVar3.zzb = zzczVar2;
        } else {
            zzczVar3.zzc = zzczVar2;
        }
    }

    private final void zzh(zzcz zzczVar) {
        zzcz zzczVar2 = zzczVar.zzb;
        zzcz zzczVar3 = zzczVar.zzc;
        zzcz zzczVar4 = zzczVar3.zzb;
        zzcz zzczVar5 = zzczVar3.zzc;
        zzczVar.zzc = zzczVar4;
        if (zzczVar4 != null) {
            zzczVar4.zza = zzczVar;
        }
        zzg(zzczVar, zzczVar3);
        zzczVar3.zzb = zzczVar;
        zzczVar.zza = zzczVar3;
        int iMax = Math.max(zzczVar2 != null ? zzczVar2.zzi : 0, zzczVar4 != null ? zzczVar4.zzi : 0) + 1;
        zzczVar.zzi = iMax;
        zzczVar3.zzi = Math.max(iMax, zzczVar5 != null ? zzczVar5.zzi : 0) + 1;
    }

    private final void zzi(zzcz zzczVar) {
        zzcz zzczVar2 = zzczVar.zzb;
        zzcz zzczVar3 = zzczVar.zzc;
        zzcz zzczVar4 = zzczVar2.zzb;
        zzcz zzczVar5 = zzczVar2.zzc;
        zzczVar.zzb = zzczVar5;
        if (zzczVar5 != null) {
            zzczVar5.zza = zzczVar;
        }
        zzg(zzczVar, zzczVar2);
        zzczVar2.zzc = zzczVar;
        zzczVar.zza = zzczVar2;
        int iMax = Math.max(zzczVar3 != null ? zzczVar3.zzi : 0, zzczVar5 != null ? zzczVar5.zzi : 0) + 1;
        zzczVar.zzi = iMax;
        zzczVar2.zzi = Math.max(iMax, zzczVar4 != null ? zzczVar4.zzi : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.zza = null;
        this.zzb = 0;
        this.zzc++;
        zzcz zzczVar = this.zzd;
        zzczVar.zze = zzczVar;
        zzczVar.zzd = zzczVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return zzc(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        zzcv zzcvVar = this.zzh;
        if (zzcvVar != null) {
            return zzcvVar;
        }
        zzcv zzcvVar2 = new zzcv(this);
        this.zzh = zzcvVar2;
        return zzcvVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        zzcz zzczVarZzc = zzc(obj);
        if (zzczVarZzc != null) {
            return zzczVarZzc.zzh;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        zzcx zzcxVar = this.zzi;
        if (zzcxVar != null) {
            return zzcxVar;
        }
        zzcx zzcxVar2 = new zzcx(this);
        this.zzi = zzcxVar2;
        return zzcxVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        if (obj2 == null && !this.zzg) {
            throw new NullPointerException("value == null");
        }
        zzcz zzczVarZza = zza(obj, true);
        Object obj3 = zzczVarZza.zzh;
        zzczVarZza.zzh = obj2;
        return obj3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        zzcz zzczVarZzd = zzd(obj);
        if (zzczVarZzd != null) {
            return zzczVarZzd.zzh;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.zzb;
    }

    final zzcz zza(Object obj, boolean z) {
        int iCompareTo;
        zzcz zzczVar;
        Comparator comparator = this.zzf;
        zzcz zzczVar2 = this.zza;
        if (zzczVar2 != null) {
            Comparable comparable = comparator == zze ? (Comparable) obj : null;
            while (true) {
                iCompareTo = comparable != null ? comparable.compareTo(zzczVar2.zzf) : comparator.compare(obj, zzczVar2.zzf);
                if (iCompareTo == 0) {
                    return zzczVar2;
                }
                zzcz zzczVar3 = iCompareTo < 0 ? zzczVar2.zzb : zzczVar2.zzc;
                if (zzczVar3 == null) {
                    break;
                }
                zzczVar2 = zzczVar3;
            }
        } else {
            iCompareTo = 0;
        }
        int i = iCompareTo;
        if (!z) {
            return null;
        }
        zzcz zzczVar4 = this.zzd;
        if (zzczVar2 != null) {
            zzcz zzczVar5 = zzczVar2;
            zzczVar = new zzcz(this.zzg, zzczVar5, obj, zzczVar4, zzczVar4.zze);
            if (i < 0) {
                zzczVar5.zzb = zzczVar;
            } else {
                zzczVar5.zzc = zzczVar;
            }
            zzf(zzczVar5, true);
        } else {
            if (comparator == zze && !(obj instanceof Comparable)) {
                throw new ClassCastException(String.valueOf(obj.getClass().getName()).concat(" is not Comparable"));
            }
            zzczVar = new zzcz(this.zzg, null, obj, zzczVar4, zzczVar4.zze);
            this.zza = zzczVar;
        }
        this.zzb++;
        this.zzc++;
        return zzczVar;
    }

    final zzcz zzb(Map.Entry entry) {
        zzcz zzczVarZzc = zzc(entry.getKey());
        if (zzczVarZzc == null || !Objects.equals(zzczVarZzc.zzh, entry.getValue())) {
            return null;
        }
        return zzczVarZzc;
    }

    final zzcz zzc(Object obj) {
        if (obj != null) {
            try {
                return zza(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        return null;
    }

    final zzcz zzd(Object obj) {
        zzcz zzczVarZzc = zzc(obj);
        if (zzczVarZzc != null) {
            zze(zzczVarZzc, true);
        }
        return zzczVarZzc;
    }

    final void zze(zzcz zzczVar, boolean z) {
        zzcz zzczVar2;
        zzcz zzczVar3;
        int i;
        if (z) {
            zzcz zzczVar4 = zzczVar.zze;
            zzczVar4.zzd = zzczVar.zzd;
            zzczVar.zzd.zze = zzczVar4;
        }
        zzcz zzczVar5 = zzczVar.zzb;
        zzcz zzczVar6 = zzczVar.zzc;
        zzcz zzczVar7 = zzczVar.zza;
        int i2 = 0;
        if (zzczVar5 == null || zzczVar6 == null) {
            if (zzczVar5 != null) {
                zzg(zzczVar, zzczVar5);
                zzczVar.zzb = null;
            } else if (zzczVar6 != null) {
                zzg(zzczVar, zzczVar6);
                zzczVar.zzc = null;
            } else {
                zzg(zzczVar, null);
            }
            zzf(zzczVar7, false);
            this.zzb--;
            this.zzc++;
            return;
        }
        if (zzczVar5.zzi > zzczVar6.zzi) {
            do {
                zzczVar3 = zzczVar5;
                zzczVar5 = zzczVar5.zzc;
            } while (zzczVar5 != null);
        } else {
            do {
                zzczVar2 = zzczVar6;
                zzczVar6 = zzczVar6.zzb;
            } while (zzczVar6 != null);
            zzczVar3 = zzczVar2;
        }
        zze(zzczVar3, false);
        zzcz zzczVar8 = zzczVar.zzb;
        if (zzczVar8 != null) {
            i = zzczVar8.zzi;
            zzczVar3.zzb = zzczVar8;
            zzczVar8.zza = zzczVar3;
            zzczVar.zzb = null;
        } else {
            i = 0;
        }
        zzcz zzczVar9 = zzczVar.zzc;
        if (zzczVar9 != null) {
            i2 = zzczVar9.zzi;
            zzczVar3.zzc = zzczVar9;
            zzczVar9.zza = zzczVar3;
            zzczVar.zzc = null;
        }
        zzczVar3.zzi = Math.max(i, i2) + 1;
        zzg(zzczVar, zzczVar3);
    }
}
