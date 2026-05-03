package com.google.android.gms.measurement.internal;

import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzahn;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaa extends zzab {
    final /* synthetic */ zzad zza;
    private final com.google.android.gms.internal.measurement.zzff zzh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzaa(zzad zzadVar, String str, int i, com.google.android.gms.internal.measurement.zzff zzffVar) {
        super(str, i);
        Objects.requireNonNull(zzadVar);
        this.zza = zzadVar;
        this.zzh = zzffVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzab
    final int zza() {
        return this.zzh.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzab
    final boolean zzb() {
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzab
    final boolean zzc() {
        return this.zzh.zzh();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final boolean zzd(Long l, Long l2, com.google.android.gms.internal.measurement.zzhs zzhsVar, long j, zzbd zzbdVar, boolean z) {
        Boolean boolZzi;
        zzahn.zza();
        zzad zzadVar = this.zza;
        zzic zzicVar = zzadVar.zzu;
        zzal zzalVarZzc = zzicVar.zzc();
        String str = this.zzb;
        boolean zZzp = zzalVarZzc.zzp(str, zzfy.zzaF);
        com.google.android.gms.internal.measurement.zzff zzffVar = this.zzh;
        long j2 = zzffVar.zzm() ? zzbdVar.zze : j;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        Boolean bool = null;
        if (Log.isLoggable(zzicVar.zzaW().zzn(), 2)) {
            zzicVar.zzaW().zzk().zzd("Evaluating filter. audience, filter, event", Integer.valueOf(this.zzc), zzffVar.zza() ? Integer.valueOf(zzffVar.zzb()) : null, zzicVar.zzl().zza(zzffVar.zzc()));
            zzicVar.zzaW().zzk().zzb("Filter definition", zzadVar.zzg.zzp().zzj(zzffVar));
        }
        if (!zzffVar.zza() || zzffVar.zzb() > 256) {
            zzicVar.zzaW().zze().zzc("Invalid event filter ID. appId, id", zzgu.zzl(str), String.valueOf(zzffVar.zza() ? Integer.valueOf(zzffVar.zzb()) : null));
            return false;
        }
        Object[] objArr = zzffVar.zzj() || zzffVar.zzk() || zzffVar.zzm();
        if (z && objArr != true) {
            zzicVar.zzaW().zzk().zzc("Event filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.zzc), zzffVar.zza() ? Integer.valueOf(zzffVar.zzb()) : null);
            return true;
        }
        String strZzd = zzhsVar.zzd();
        if (!zzffVar.zzh()) {
            HashSet hashSet = new HashSet();
            Iterator it = zzffVar.zzd().iterator();
            while (true) {
                if (!it.hasNext()) {
                    ArrayMap arrayMap = new ArrayMap();
                    Iterator it2 = zzhsVar.zza().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            Iterator it3 = zzffVar.zzd().iterator();
                            while (true) {
                                if (!it3.hasNext()) {
                                    bool = true;
                                    break;
                                }
                                com.google.android.gms.internal.measurement.zzfh zzfhVar = (com.google.android.gms.internal.measurement.zzfh) it3.next();
                                boolean z2 = zzfhVar.zze() && zzfhVar.zzf();
                                String strZzi = zzfhVar.zzi();
                                if (strZzi.isEmpty()) {
                                    zzicVar.zzaW().zze().zzb("Event has empty param name. event", zzicVar.zzl().zza(strZzd));
                                    break;
                                }
                                V v = arrayMap.get(strZzi);
                                if (v instanceof Long) {
                                    if (!zzfhVar.zzc()) {
                                        zzicVar.zzaW().zze().zzc("No number filter for long param. event, param", zzicVar.zzl().zza(strZzd), zzicVar.zzl().zzb(strZzi));
                                        break;
                                    }
                                    Boolean boolZzg = zzg(((Long) v).longValue(), zzfhVar.zzd());
                                    if (boolZzg == null) {
                                        break;
                                    }
                                    if (boolZzg.booleanValue() == z2) {
                                        bool = false;
                                        break;
                                    }
                                } else if (v instanceof Double) {
                                    if (!zzfhVar.zzc()) {
                                        zzicVar.zzaW().zze().zzc("No number filter for double param. event, param", zzicVar.zzl().zza(strZzd), zzicVar.zzl().zzb(strZzi));
                                        break;
                                    }
                                    Boolean boolZzh = zzh(((Double) v).doubleValue(), zzfhVar.zzd());
                                    if (boolZzh == null) {
                                        break;
                                    }
                                    if (boolZzh.booleanValue() == z2) {
                                        bool = false;
                                        break;
                                    }
                                } else if (v instanceof String) {
                                    if (!zzfhVar.zza()) {
                                        if (!zzfhVar.zzc()) {
                                            zzicVar.zzaW().zze().zzc("No filter for String param. event, param", zzicVar.zzl().zza(strZzd), zzicVar.zzl().zzb(strZzi));
                                            break;
                                        }
                                        String str2 = (String) v;
                                        if (!zzpk.zzm(str2)) {
                                            zzicVar.zzaW().zze().zzc("Invalid param value for number filter. event, param", zzicVar.zzl().zza(strZzd), zzicVar.zzl().zzb(strZzi));
                                            break;
                                        }
                                        boolZzi = zzi(str2, zzfhVar.zzd());
                                    } else {
                                        boolZzi = zzf((String) v, zzfhVar.zzb(), zzicVar.zzaW());
                                    }
                                    if (boolZzi == null) {
                                        break;
                                    }
                                    if (boolZzi.booleanValue() == z2) {
                                        bool = false;
                                        break;
                                    }
                                } else if (v == 0) {
                                    zzicVar.zzaW().zzk().zzc("Missing param for filter. event, param", zzicVar.zzl().zza(strZzd), zzicVar.zzl().zzb(strZzi));
                                    bool = false;
                                } else {
                                    zzicVar.zzaW().zze().zzc("Unknown param type. event, param", zzicVar.zzl().zza(strZzd), zzicVar.zzl().zzb(strZzi));
                                }
                            }
                        } else {
                            com.google.android.gms.internal.measurement.zzhw zzhwVar = (com.google.android.gms.internal.measurement.zzhw) it2.next();
                            if (hashSet.contains(zzhwVar.zzb())) {
                                if (!zzhwVar.zze()) {
                                    if (!zzhwVar.zzj()) {
                                        if (!zzhwVar.zzc()) {
                                            zzicVar.zzaW().zze().zzc("Unknown value for param. event, param", zzicVar.zzl().zza(strZzd), zzicVar.zzl().zzb(zzhwVar.zzb()));
                                            break;
                                        }
                                        arrayMap.put(zzhwVar.zzb(), zzhwVar.zzd());
                                    } else {
                                        arrayMap.put(zzhwVar.zzb(), zzhwVar.zzj() ? Double.valueOf(zzhwVar.zzk()) : null);
                                    }
                                } else {
                                    arrayMap.put(zzhwVar.zzb(), zzhwVar.zze() ? Long.valueOf(zzhwVar.zzf()) : null);
                                }
                            }
                        }
                    }
                } else {
                    com.google.android.gms.internal.measurement.zzfh zzfhVar2 = (com.google.android.gms.internal.measurement.zzfh) it.next();
                    if (zzfhVar2.zzi().isEmpty()) {
                        zzicVar.zzaW().zze().zzb("null or empty param name in filter. event", zzicVar.zzl().zza(strZzd));
                        break;
                    }
                    hashSet.add(zzfhVar2.zzi());
                }
            }
        } else {
            Boolean boolZzg2 = zzg(j2, zzffVar.zzi());
            if (boolZzg2 != null) {
                if (!boolZzg2.booleanValue()) {
                    bool = false;
                }
            }
        }
        zzicVar.zzaW().zzk().zzb("Event filter result", bool == null ? AbstractJsonLexerKt.NULL : bool);
        if (bool == null) {
            return false;
        }
        this.zzd = true;
        if (!bool.booleanValue()) {
            return true;
        }
        this.zze = true;
        if (objArr != false && zzhsVar.zze()) {
            Long lValueOf = Long.valueOf(zzhsVar.zzf());
            if (zzffVar.zzk()) {
                if (zZzp && zzffVar.zzh()) {
                    lValueOf = l;
                }
                this.zzg = lValueOf;
            } else {
                if (zZzp && zzffVar.zzh()) {
                    lValueOf = l2;
                }
                this.zzf = lValueOf;
            }
        }
        return true;
    }
}
