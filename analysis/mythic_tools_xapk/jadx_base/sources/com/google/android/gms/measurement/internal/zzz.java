package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzz {
    final /* synthetic */ zzad zza;
    private com.google.android.gms.internal.measurement.zzhs zzb;
    private Long zzc;
    private long zzd;

    /* synthetic */ zzz(zzad zzadVar, byte[] bArr) {
        Objects.requireNonNull(zzadVar);
        this.zza = zzadVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0114 A[PHI: r14 r16 r17
      0x0114: PHI (r14v3 android.database.Cursor) = (r14v2 android.database.Cursor), (r14v5 android.database.Cursor) binds: [B:51:0x0112, B:39:0x00ea] A[DONT_GENERATE, DONT_INLINE]
      0x0114: PHI (r16v3 com.google.android.gms.internal.measurement.zzhs) = (r16v2 com.google.android.gms.internal.measurement.zzhs), (r16v9 com.google.android.gms.internal.measurement.zzhs) binds: [B:51:0x0112, B:39:0x00ea] A[DONT_GENERATE, DONT_INLINE]
      0x0114: PHI (r17v3 long) = (r17v2 long), (r17v7 long) binds: [B:51:0x0112, B:39:0x00ea] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01f9  */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16, types: [android.util.Pair] */
    /* JADX WARN: Type inference failed for: r0v67 */
    /* JADX WARN: Type inference failed for: r14v7, types: [long] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final com.google.android.gms.internal.measurement.zzhs zza(String str, com.google.android.gms.internal.measurement.zzhs zzhsVar) {
        ?? r7;
        com.google.android.gms.internal.measurement.zzhs zzhsVar2;
        long j;
        Cursor cursorRawQuery;
        ?? r0;
        Pair pair;
        long j2;
        ArrayList arrayList;
        ?? LongValue;
        String strZzd = zzhsVar.zzd();
        List listZza = zzhsVar.zza();
        zzad zzadVar = this.zza;
        zzpg zzpgVar = zzadVar.zzg;
        zzpgVar.zzp();
        Long l = (Long) zzpk.zzM(zzhsVar, "_eid");
        if (l != null) {
            if (strZzd.equals("_ep")) {
                Preconditions.checkNotNull(l);
                zzpgVar.zzp();
                String str2 = (String) zzpk.zzM(zzhsVar, "_en");
                if (TextUtils.isEmpty(str2)) {
                    zzadVar.zzu.zzaW().zzc().zzb("Extra parameter without an event name. eventId", l);
                    return null;
                }
                if (this.zzb == null || this.zzc == null) {
                    zzaw zzawVarZzj = zzpgVar.zzj();
                    zzawVarZzj.zzg();
                    zzawVarZzj.zzay();
                    try {
                        try {
                            cursorRawQuery = zzawVarZzj.zze().rawQuery("select main_event, children_to_process from main_event_params where app_id=? and event_id=?", new String[]{str, l.toString()});
                            try {
                                if (cursorRawQuery.moveToFirst()) {
                                    zzhsVar2 = null;
                                    try {
                                        try {
                                            Pair pairCreate = Pair.create((com.google.android.gms.internal.measurement.zzhs) ((com.google.android.gms.internal.measurement.zzhr) zzpk.zzw(com.google.android.gms.internal.measurement.zzhs.zzp(), cursorRawQuery.getBlob(0))).zzbd(), Long.valueOf(cursorRawQuery.getLong(1)));
                                            pair = pairCreate;
                                            if (cursorRawQuery != null) {
                                                cursorRawQuery.close();
                                                pair = pairCreate;
                                            }
                                        } catch (IOException e) {
                                            j = 0;
                                            try {
                                                zzawVarZzj.zzu.zzaW().zzb().zzd("Failed to merge main event. appId, eventId", zzgu.zzl(str), l, e);
                                            } catch (SQLiteException e2) {
                                                e = e2;
                                                zzawVarZzj.zzu.zzaW().zzb().zzb("Error selecting main event", e);
                                                if (cursorRawQuery != null) {
                                                }
                                                r0 = zzhsVar2;
                                                if (r0 != 0) {
                                                }
                                                this.zza.zzu.zzaW().zzc().zzc("Extra parameter without existing main event. eventName, eventId", str2, l);
                                                return zzhsVar2;
                                            }
                                            if (cursorRawQuery != null) {
                                                cursorRawQuery.close();
                                            }
                                            r0 = zzhsVar2;
                                        }
                                    } catch (SQLiteException e3) {
                                        e = e3;
                                        j = 0;
                                        zzawVarZzj.zzu.zzaW().zzb().zzb("Error selecting main event", e);
                                        if (cursorRawQuery != null) {
                                        }
                                        r0 = zzhsVar2;
                                        if (r0 != 0) {
                                        }
                                        this.zza.zzu.zzaW().zzc().zzc("Extra parameter without existing main event. eventName, eventId", str2, l);
                                        return zzhsVar2;
                                    }
                                } else {
                                    zzawVarZzj.zzu.zzaW().zzk().zza("Main event not found");
                                    if (cursorRawQuery != null) {
                                        cursorRawQuery.close();
                                    }
                                    pair = null;
                                    zzhsVar2 = null;
                                }
                                j = 0;
                                r0 = pair;
                            } catch (SQLiteException e4) {
                                e = e4;
                                zzhsVar2 = null;
                            }
                        } catch (Throwable th) {
                            th = th;
                            r7 = LongValue;
                            if (r7 != 0) {
                                r7.close();
                            }
                            throw th;
                        }
                    } catch (SQLiteException e5) {
                        e = e5;
                        zzhsVar2 = null;
                        j = 0;
                        cursorRawQuery = null;
                    } catch (Throwable th2) {
                        th = th2;
                        r7 = 0;
                        if (r7 != 0) {
                        }
                        throw th;
                    }
                    if (r0 != 0 || ((Pair) r0).first == null) {
                        this.zza.zzu.zzaW().zzc().zzc("Extra parameter without existing main event. eventName, eventId", str2, l);
                        return zzhsVar2;
                    }
                    this.zzb = (com.google.android.gms.internal.measurement.zzhs) ((Pair) r0).first;
                    this.zzd = ((Long) ((Pair) r0).second).longValue();
                    this.zza.zzg.zzp();
                    this.zzc = (Long) zzpk.zzM(this.zzb, "_eid");
                    j2 = this.zzd - 1;
                    this.zzd = j2;
                    zzad zzadVar2 = this.zza;
                    if (j2 > j) {
                        zzaw zzawVarZzj2 = zzadVar2.zzg.zzj();
                        zzawVarZzj2.zzg();
                        zzawVarZzj2.zzu.zzaW().zzk().zzb("Clearing complex main event info. appId", str);
                        try {
                            zzawVarZzj2.zze().execSQL("delete from main_event_params where app_id=?", new String[]{str});
                        } catch (SQLiteException e6) {
                            zzawVarZzj2.zzu.zzaW().zzb().zzb("Error clearing complex main event", e6);
                        }
                    } else {
                        zzadVar2.zzg.zzj().zzU(str, l, this.zzd, this.zzb);
                    }
                    arrayList = new ArrayList();
                    for (com.google.android.gms.internal.measurement.zzhw zzhwVar : this.zzb.zza()) {
                        this.zza.zzg.zzp();
                        if (zzpk.zzI(zzhsVar, zzhwVar.zzb()) == null) {
                            arrayList.add(zzhwVar);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        arrayList.addAll(listZza);
                        listZza = arrayList;
                    } else {
                        this.zza.zzu.zzaW().zzc().zzb("No unique parameters in main event. eventName", str2);
                    }
                    strZzd = str2;
                } else {
                    LongValue = l.longValue();
                    if (LongValue == this.zzc.longValue()) {
                        j = 0;
                    }
                    j2 = this.zzd - 1;
                    this.zzd = j2;
                    zzad zzadVar22 = this.zza;
                    if (j2 > j) {
                    }
                    arrayList = new ArrayList();
                    while (r2.hasNext()) {
                    }
                    if (arrayList.isEmpty()) {
                    }
                    strZzd = str2;
                }
            } else {
                this.zzc = l;
                this.zzb = zzhsVar;
                zzpgVar.zzp();
                long jLongValue = ((Long) zzpk.zzN(zzhsVar, "_epc", 0L)).longValue();
                this.zzd = jLongValue;
                if (jLongValue <= 0) {
                    zzadVar.zzu.zzaW().zzc().zzb("Complex event with zero extra param count. eventName", strZzd);
                } else {
                    zzpgVar.zzj().zzU(str, (Long) Preconditions.checkNotNull(l), this.zzd, zzhsVar);
                }
            }
        }
        com.google.android.gms.internal.measurement.zzhr zzhrVar = (com.google.android.gms.internal.measurement.zzhr) zzhsVar.zzco();
        zzhrVar.zzl(strZzd);
        zzhrVar.zzi();
        zzhrVar.zzh(listZza);
        return (com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbd();
    }
}
