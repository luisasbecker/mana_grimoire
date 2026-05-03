package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzafe extends AbstractMap implements Serializable {
    private static final Comparator zze = new zzaex();
    zzafd zza;
    int zzb;
    int zzc;
    final zzafd zzd;
    private final Comparator zzf;
    private final boolean zzg;
    private zzaez zzh;
    private zzafb zzi;

    public zzafe() {
        this(zze, true);
    }

    public zzafe(Comparator comparator, boolean z) {
        this.zzb = 0;
        this.zzc = 0;
        this.zzf = comparator;
        this.zzg = z;
        this.zzd = new zzafd(z);
    }

    public zzafe(boolean z) {
        this(zze, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0084 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0084 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0080 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0080 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zzf(zzafd zzafdVar, boolean z) {
        while (zzafdVar != null) {
            zzafd zzafdVar2 = zzafdVar.zzb;
            zzafd zzafdVar3 = zzafdVar.zzc;
            boolean z2 = false;
            int i = zzafdVar2 != null ? zzafdVar2.zzi : 0;
            int i2 = zzafdVar3 != null ? zzafdVar3.zzi : 0;
            int i3 = i - i2;
            boolean z3 = true;
            if (i3 == -2) {
                zzafd zzafdVar4 = zzafdVar3.zzb;
                zzafd zzafdVar5 = zzafdVar3.zzc;
                int i4 = (zzafdVar4 != null ? zzafdVar4.zzi : 0) - (zzafdVar5 != null ? zzafdVar5.zzi : 0);
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
                    zzi(zzafdVar3);
                    zzh(zzafdVar);
                    if (z3) {
                    }
                } else {
                    z2 = z;
                }
                zzh(zzafdVar);
                z3 = z2;
                if (z3) {
                }
            } else if (i3 == 2) {
                zzafd zzafdVar6 = zzafdVar2.zzb;
                zzafd zzafdVar7 = zzafdVar2.zzc;
                int i5 = (zzafdVar6 != null ? zzafdVar6.zzi : 0) - (zzafdVar7 != null ? zzafdVar7.zzi : 0);
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
                    zzh(zzafdVar2);
                    zzi(zzafdVar);
                    if (z3) {
                    }
                } else {
                    z2 = z;
                }
                zzi(zzafdVar);
                z3 = z2;
                if (z3) {
                }
            } else if (i3 == 0) {
                zzafdVar.zzi = i + 1;
                if (z) {
                    return;
                }
            } else {
                zzafdVar.zzi = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            zzafdVar = zzafdVar.zza;
        }
    }

    private final void zzg(zzafd zzafdVar, zzafd zzafdVar2) {
        zzafd zzafdVar3 = zzafdVar.zza;
        zzafdVar.zza = null;
        if (zzafdVar2 != null) {
            zzafdVar2.zza = zzafdVar3;
        }
        if (zzafdVar3 == null) {
            this.zza = zzafdVar2;
        } else if (zzafdVar3.zzb == zzafdVar) {
            zzafdVar3.zzb = zzafdVar2;
        } else {
            zzafdVar3.zzc = zzafdVar2;
        }
    }

    private final void zzh(zzafd zzafdVar) {
        zzafd zzafdVar2 = zzafdVar.zzb;
        zzafd zzafdVar3 = zzafdVar.zzc;
        zzafd zzafdVar4 = zzafdVar3.zzb;
        zzafd zzafdVar5 = zzafdVar3.zzc;
        zzafdVar.zzc = zzafdVar4;
        if (zzafdVar4 != null) {
            zzafdVar4.zza = zzafdVar;
        }
        zzg(zzafdVar, zzafdVar3);
        zzafdVar3.zzb = zzafdVar;
        zzafdVar.zza = zzafdVar3;
        int iMax = Math.max(zzafdVar2 != null ? zzafdVar2.zzi : 0, zzafdVar4 != null ? zzafdVar4.zzi : 0) + 1;
        zzafdVar.zzi = iMax;
        zzafdVar3.zzi = Math.max(iMax, zzafdVar5 != null ? zzafdVar5.zzi : 0) + 1;
    }

    private final void zzi(zzafd zzafdVar) {
        zzafd zzafdVar2 = zzafdVar.zzb;
        zzafd zzafdVar3 = zzafdVar.zzc;
        zzafd zzafdVar4 = zzafdVar2.zzb;
        zzafd zzafdVar5 = zzafdVar2.zzc;
        zzafdVar.zzb = zzafdVar5;
        if (zzafdVar5 != null) {
            zzafdVar5.zza = zzafdVar;
        }
        zzg(zzafdVar, zzafdVar2);
        zzafdVar2.zzc = zzafdVar;
        zzafdVar.zza = zzafdVar2;
        int iMax = Math.max(zzafdVar3 != null ? zzafdVar3.zzi : 0, zzafdVar5 != null ? zzafdVar5.zzi : 0) + 1;
        zzafdVar.zzi = iMax;
        zzafdVar2.zzi = Math.max(iMax, zzafdVar4 != null ? zzafdVar4.zzi : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.zza = null;
        this.zzb = 0;
        this.zzc++;
        zzafd zzafdVar = this.zzd;
        zzafdVar.zze = zzafdVar;
        zzafdVar.zzd = zzafdVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return zzc(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        zzaez zzaezVar = this.zzh;
        if (zzaezVar != null) {
            return zzaezVar;
        }
        zzaez zzaezVar2 = new zzaez(this);
        this.zzh = zzaezVar2;
        return zzaezVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        zzafd zzafdVarZzc = zzc(obj);
        if (zzafdVarZzc != null) {
            return zzafdVarZzc.zzh;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        zzafb zzafbVar = this.zzi;
        if (zzafbVar != null) {
            return zzafbVar;
        }
        zzafb zzafbVar2 = new zzafb(this);
        this.zzi = zzafbVar2;
        return zzafbVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        if (obj2 == null && !this.zzg) {
            throw new NullPointerException("value == null");
        }
        zzafd zzafdVarZza = zza(obj, true);
        Object obj3 = zzafdVarZza.zzh;
        zzafdVarZza.zzh = obj2;
        return obj3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        zzafd zzafdVarZzd = zzd(obj);
        if (zzafdVarZzd != null) {
            return zzafdVarZzd.zzh;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.zzb;
    }

    final zzafd zza(Object obj, boolean z) {
        int iCompareTo;
        zzafd zzafdVar;
        Comparator comparator = this.zzf;
        zzafd zzafdVar2 = this.zza;
        if (zzafdVar2 != null) {
            Comparable comparable = comparator == zze ? (Comparable) obj : null;
            while (true) {
                iCompareTo = comparable != null ? comparable.compareTo(zzafdVar2.zzf) : comparator.compare(obj, zzafdVar2.zzf);
                if (iCompareTo == 0) {
                    return zzafdVar2;
                }
                zzafd zzafdVar3 = iCompareTo < 0 ? zzafdVar2.zzb : zzafdVar2.zzc;
                if (zzafdVar3 == null) {
                    break;
                }
                zzafdVar2 = zzafdVar3;
            }
        } else {
            iCompareTo = 0;
        }
        int i = iCompareTo;
        if (!z) {
            return null;
        }
        zzafd zzafdVar4 = this.zzd;
        if (zzafdVar2 != null) {
            zzafd zzafdVar5 = zzafdVar2;
            zzafdVar = new zzafd(this.zzg, zzafdVar5, obj, zzafdVar4, zzafdVar4.zze);
            if (i < 0) {
                zzafdVar5.zzb = zzafdVar;
            } else {
                zzafdVar5.zzc = zzafdVar;
            }
            zzf(zzafdVar5, true);
        } else {
            if (comparator == zze && !(obj instanceof Comparable)) {
                throw new ClassCastException(String.valueOf(obj.getClass().getName()).concat(" is not Comparable"));
            }
            zzafdVar = new zzafd(this.zzg, null, obj, zzafdVar4, zzafdVar4.zze);
            this.zza = zzafdVar;
        }
        this.zzb++;
        this.zzc++;
        return zzafdVar;
    }

    final zzafd zzb(Map.Entry entry) {
        zzafd zzafdVarZzc = zzc(entry.getKey());
        if (zzafdVarZzc == null || !Objects.equals(zzafdVarZzc.zzh, entry.getValue())) {
            return null;
        }
        return zzafdVarZzc;
    }

    final zzafd zzc(Object obj) {
        if (obj != null) {
            try {
                return zza(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        return null;
    }

    final zzafd zzd(Object obj) {
        zzafd zzafdVarZzc = zzc(obj);
        if (zzafdVarZzc != null) {
            zze(zzafdVarZzc, true);
        }
        return zzafdVarZzc;
    }

    final void zze(zzafd zzafdVar, boolean z) {
        zzafd zzafdVar2;
        zzafd zzafdVar3;
        int i;
        if (z) {
            zzafd zzafdVar4 = zzafdVar.zze;
            zzafdVar4.zzd = zzafdVar.zzd;
            zzafdVar.zzd.zze = zzafdVar4;
        }
        zzafd zzafdVar5 = zzafdVar.zzb;
        zzafd zzafdVar6 = zzafdVar.zzc;
        zzafd zzafdVar7 = zzafdVar.zza;
        int i2 = 0;
        if (zzafdVar5 == null || zzafdVar6 == null) {
            if (zzafdVar5 != null) {
                zzg(zzafdVar, zzafdVar5);
                zzafdVar.zzb = null;
            } else if (zzafdVar6 != null) {
                zzg(zzafdVar, zzafdVar6);
                zzafdVar.zzc = null;
            } else {
                zzg(zzafdVar, null);
            }
            zzf(zzafdVar7, false);
            this.zzb--;
            this.zzc++;
            return;
        }
        if (zzafdVar5.zzi > zzafdVar6.zzi) {
            do {
                zzafdVar3 = zzafdVar5;
                zzafdVar5 = zzafdVar5.zzc;
            } while (zzafdVar5 != null);
        } else {
            do {
                zzafdVar2 = zzafdVar6;
                zzafdVar6 = zzafdVar6.zzb;
            } while (zzafdVar6 != null);
            zzafdVar3 = zzafdVar2;
        }
        zze(zzafdVar3, false);
        zzafd zzafdVar8 = zzafdVar.zzb;
        if (zzafdVar8 != null) {
            i = zzafdVar8.zzi;
            zzafdVar3.zzb = zzafdVar8;
            zzafdVar8.zza = zzafdVar3;
            zzafdVar.zzb = null;
        } else {
            i = 0;
        }
        zzafd zzafdVar9 = zzafdVar.zzc;
        if (zzafdVar9 != null) {
            i2 = zzafdVar9.zzi;
            zzafdVar3.zzc = zzafdVar9;
            zzafdVar9.zza = zzafdVar3;
            zzafdVar.zzc = null;
        }
        zzafdVar3.zzi = Math.max(i, i2) + 1;
        zzg(zzafdVar, zzafdVar3);
    }
}
