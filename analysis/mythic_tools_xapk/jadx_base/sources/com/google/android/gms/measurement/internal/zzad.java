package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzahn;
import com.google.firebase.messaging.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzad extends zzos {
    private String zza;
    private Set zzb;
    private Map zzc;
    private Long zzd;
    private Long zze;

    zzad(zzpg zzpgVar) {
        super(zzpgVar);
    }

    private final zzy zzc(Integer num) {
        if (this.zzc.containsKey(num)) {
            return (zzy) this.zzc.get(num);
        }
        zzy zzyVar = new zzy(this, this.zza, null);
        this.zzc.put(num, zzyVar);
        return zzyVar;
    }

    private final boolean zzd(int i, int i2) {
        zzy zzyVar = (zzy) this.zzc.get(Integer.valueOf(i));
        if (zzyVar == null) {
            return false;
        }
        return zzyVar.zzc().get(i2);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(22:0|2|(2:3|(2:5|(2:508|7)(1:509))(2:507|8))|9|(3:11|456|12)|16|(1:65)(9:19|465|20|472|21|478|(16:(8:23|24|454|25|26|(1:28)(3:29|(2:31|32)(1:33)|34)|39|(1:510)(1:44))|(1:42)|43|67|488|68|498|69|(3:71|(1:73)|74)(4:75|(6:76|479|77|78|85|(1:588)(1:90))|(1:88)|89)|106|(5:109|(9:111|464|112|113|503|114|489|115|(5:(4:117|(1:119)|120|(1:545)(1:124))|(1:123)|140|(3:143|(3:146|(5:549|168|169|553|551)(2:151|(11:550|153|(4:156|(2:158|555)(1:556)|159|154)|554|160|(4:163|(3:558|165|561)(1:560)|559|161)|557|166|169|553|551)(4:547|167|552|551))|144)|546)|170)(5:125|(0)|140|(0)|170))(1:176)|177|(10:180|(3:185|(4:188|(5:570|190|(1:192)(1:193)|194|573)(1:572)|571|186)|569)|195|(3:200|(4:203|(1:579)(3:576|207|580)|577|201)|574)|208|(3:210|(6:213|(3:215|(2:217|583)|220)(1:218)|219|582|220|211)|581)|221|(1:568)(3:231|(8:234|(1:236)|237|(1:239)|240|(3:584|242|587)(1:586)|585|232)|567)|243|178)|562)|108|244|(3:247|(4:250|(3:530|252|(8:531|254|(15:256|257|258|476|259|260|486|261|262|483|263|458|264|(4:266|(10:494|267|490|268|269|270|(3:272|499|273)(1:274)|275|278|(1:536)(1:283))|(1:281)|282)(3:286|287|(1:289))|316)(1:321)|322|(4:325|(3:539|327|542)(6:538|328|(2:329|(2:331|(1:333)(2:544|334))(2:543|335))|(1:337)|338|541)|540|323)|537|339|535)(1:534))(1:533)|532|248)|529)|246|(6:341|(3:344|(6:347|(7:349|505|350|470|351|(3:(9:353|468|354|355|356|(1:358)(1:359)|360|365|(1:514)(1:370))|(1:368)|369)(3:371|372|(1:374))|389)(1:394)|395|(2:396|(2:398|(3:515|400|513)(8:401|(2:402|(4:404|(3:406|(1:408)(1:409)|410)(1:411)|412|(1:521)(2:417|(1:419)(2:518|420)))(2:519|426))|421|(1:423)(1:424)|425|428|516|429))(0))|430|345)|511)|431|(10:434|474|435|436|466|437|524|(3:523|439|527)(1:526)|525|432)|522|446)(2:447|448))(3:45|46|(1:48))|59|(0))|66|67|488|68|498|69|(0)(0)|106|(0)|108|244|(0)|246|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x0257, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0258, code lost:
    
        r19 = r2 ? 1 : 0;
        r20 = "audience_id";
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:427:0x0a09, code lost:
    
        if (r10 != false) goto L517;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x024d, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x024e, code lost:
    
        r19 = r2 ? 1 : 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0253, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0254, code lost:
    
        r5 = 0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02f0 A[PHI: r0 r2
      0x02f0: PHI (r0v57 java.util.Map) = (r0v43 java.util.Map), (r0v59 java.util.Map), (r0v37 java.util.Map) binds: [B:138:0x0320, B:126:0x02fa, B:122:0x02ee] A[DONT_GENERATE, DONT_INLINE]
      0x02f0: PHI (r2v43 android.database.Cursor) = (r2v41 android.database.Cursor), (r2v45 android.database.Cursor), (r2v45 android.database.Cursor) binds: [B:138:0x0320, B:126:0x02fa, B:122:0x02ee] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0442  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x05d8  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x0721  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x072b  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x0745  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x07df  */
    /* JADX WARN: Removed duplicated region for block: B:392:0x08ea  */
    /* JADX WARN: Removed duplicated region for block: B:447:0x0ac4  */
    /* JADX WARN: Removed duplicated region for block: B:452:0x0ace  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x016a A[PHI: r0 r5 r7 r40 r41
      0x016a: PHI (r0v191 java.util.Map) = (r0v193 java.util.Map), (r0v198 java.util.Map) binds: [B:60:0x0196, B:47:0x0168] A[DONT_GENERATE, DONT_INLINE]
      0x016a: PHI (r5v68 android.database.Cursor) = (r5v69 android.database.Cursor), (r5v71 android.database.Cursor) binds: [B:60:0x0196, B:47:0x0168] A[DONT_GENERATE, DONT_INLINE]
      0x016a: PHI (r7v45 java.lang.Object) = (r7v55 java.lang.Object), (r7v56 java.lang.Object) binds: [B:60:0x0196, B:47:0x0168] A[DONT_GENERATE, DONT_INLINE]
      0x016a: PHI (r40v6 ??) = (r40v16 ??), (r40v17 ??) binds: [B:60:0x0196, B:47:0x0168] A[DONT_GENERATE, DONT_INLINE]
      0x016a: PHI (r41v6 ??) = (r41v23 ??), (r41v24 ??) binds: [B:60:0x0196, B:47:0x0168] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01dd A[Catch: SQLiteException -> 0x024d, all -> 0x0aca, TRY_LEAVE, TryCatch #27 {all -> 0x0aca, blocks: (B:69:0x01d7, B:71:0x01dd, B:75:0x01ed, B:76:0x01f4, B:77:0x01fd, B:78:0x020d, B:85:0x0235, B:80:0x021a, B:82:0x0228, B:84:0x022e, B:102:0x025d), top: B:488:0x01b9 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01ed A[Catch: SQLiteException -> 0x024d, all -> 0x0aca, TRY_ENTER, TryCatch #27 {all -> 0x0aca, blocks: (B:69:0x01d7, B:71:0x01dd, B:75:0x01ed, B:76:0x01f4, B:77:0x01fd, B:78:0x020d, B:85:0x0235, B:80:0x021a, B:82:0x0228, B:84:0x022e, B:102:0x025d), top: B:488:0x01b9 }] */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v26 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8, types: [int] */
    /* JADX WARN: Type inference failed for: r18v10 */
    /* JADX WARN: Type inference failed for: r18v11 */
    /* JADX WARN: Type inference failed for: r18v13 */
    /* JADX WARN: Type inference failed for: r18v14 */
    /* JADX WARN: Type inference failed for: r18v15 */
    /* JADX WARN: Type inference failed for: r18v16 */
    /* JADX WARN: Type inference failed for: r18v17 */
    /* JADX WARN: Type inference failed for: r18v18 */
    /* JADX WARN: Type inference failed for: r18v20 */
    /* JADX WARN: Type inference failed for: r18v21 */
    /* JADX WARN: Type inference failed for: r18v22 */
    /* JADX WARN: Type inference failed for: r18v23 */
    /* JADX WARN: Type inference failed for: r18v24 */
    /* JADX WARN: Type inference failed for: r18v25, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r18v26 */
    /* JADX WARN: Type inference failed for: r18v27 */
    /* JADX WARN: Type inference failed for: r18v28 */
    /* JADX WARN: Type inference failed for: r18v35 */
    /* JADX WARN: Type inference failed for: r18v36 */
    /* JADX WARN: Type inference failed for: r18v37 */
    /* JADX WARN: Type inference failed for: r18v38 */
    /* JADX WARN: Type inference failed for: r18v39 */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARN: Type inference failed for: r18v40 */
    /* JADX WARN: Type inference failed for: r18v41 */
    /* JADX WARN: Type inference failed for: r18v42 */
    /* JADX WARN: Type inference failed for: r18v43 */
    /* JADX WARN: Type inference failed for: r18v44 */
    /* JADX WARN: Type inference failed for: r18v45 */
    /* JADX WARN: Type inference failed for: r18v46 */
    /* JADX WARN: Type inference failed for: r18v47 */
    /* JADX WARN: Type inference failed for: r18v48 */
    /* JADX WARN: Type inference failed for: r18v49 */
    /* JADX WARN: Type inference failed for: r18v5 */
    /* JADX WARN: Type inference failed for: r18v50 */
    /* JADX WARN: Type inference failed for: r18v51 */
    /* JADX WARN: Type inference failed for: r18v52 */
    /* JADX WARN: Type inference failed for: r18v53 */
    /* JADX WARN: Type inference failed for: r18v54 */
    /* JADX WARN: Type inference failed for: r18v6 */
    /* JADX WARN: Type inference failed for: r18v7 */
    /* JADX WARN: Type inference failed for: r18v8 */
    /* JADX WARN: Type inference failed for: r18v9 */
    /* JADX WARN: Type inference failed for: r40v0, types: [java.lang.Long] */
    /* JADX WARN: Type inference failed for: r40v1 */
    /* JADX WARN: Type inference failed for: r40v10 */
    /* JADX WARN: Type inference failed for: r40v11 */
    /* JADX WARN: Type inference failed for: r40v12 */
    /* JADX WARN: Type inference failed for: r40v13 */
    /* JADX WARN: Type inference failed for: r40v14 */
    /* JADX WARN: Type inference failed for: r40v15 */
    /* JADX WARN: Type inference failed for: r40v16 */
    /* JADX WARN: Type inference failed for: r40v17 */
    /* JADX WARN: Type inference failed for: r40v2 */
    /* JADX WARN: Type inference failed for: r40v3 */
    /* JADX WARN: Type inference failed for: r40v5 */
    /* JADX WARN: Type inference failed for: r40v6 */
    /* JADX WARN: Type inference failed for: r40v7 */
    /* JADX WARN: Type inference failed for: r40v8 */
    /* JADX WARN: Type inference failed for: r41v0, types: [java.lang.Long] */
    /* JADX WARN: Type inference failed for: r41v1 */
    /* JADX WARN: Type inference failed for: r41v10 */
    /* JADX WARN: Type inference failed for: r41v18 */
    /* JADX WARN: Type inference failed for: r41v19 */
    /* JADX WARN: Type inference failed for: r41v2 */
    /* JADX WARN: Type inference failed for: r41v20 */
    /* JADX WARN: Type inference failed for: r41v21 */
    /* JADX WARN: Type inference failed for: r41v22 */
    /* JADX WARN: Type inference failed for: r41v23 */
    /* JADX WARN: Type inference failed for: r41v24 */
    /* JADX WARN: Type inference failed for: r41v3 */
    /* JADX WARN: Type inference failed for: r41v5 */
    /* JADX WARN: Type inference failed for: r41v6 */
    /* JADX WARN: Type inference failed for: r41v7 */
    /* JADX WARN: Type inference failed for: r41v8 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v29, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r5v35, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v39 */
    /* JADX WARN: Type inference failed for: r5v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v65 */
    /* JADX WARN: Type inference failed for: r5v67, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v75 */
    /* JADX WARN: Type inference failed for: r5v76 */
    /* JADX WARN: Type inference failed for: r5v77 */
    /* JADX WARN: Type inference failed for: r5v78 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v42, types: [int] */
    /* JADX WARN: Type inference failed for: r7v43, types: [android.database.Cursor] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final List zzb(String str, List list, List list2, Long l, Long l2, boolean z) throws Throwable {
        boolean z2;
        ?? r11;
        boolean z3;
        ?? r41;
        ?? r40;
        Object obj;
        Map map;
        ?? r412;
        ?? r402;
        Object obj2;
        String str2;
        boolean z4;
        String str3;
        ?? Query;
        Map map2;
        boolean z5;
        ?? r18;
        HashSet hashSet;
        Map map3;
        Iterator it;
        List<com.google.android.gms.internal.measurement.zzff> list3;
        boolean z6;
        ?? r5;
        Cursor cursorRawQuery;
        Map map4;
        Iterator it2;
        int i;
        zzz zzzVar;
        Iterator it3;
        zzbd zzbdVar;
        String str4;
        Iterator it4;
        Map map5;
        long j;
        ?? r52;
        ?? r182;
        ?? r183;
        ?? r184;
        ?? r185;
        List arrayList;
        Iterator it5;
        Map map6;
        String str5;
        com.google.android.gms.internal.measurement.zzfn zzfnVar;
        zzic zzicVar;
        Cursor cursor;
        List arrayList2;
        Cursor cursorQuery;
        ?? r413;
        ?? r403;
        Object obj3;
        boolean z7;
        boolean z8;
        List arrayList3;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(list2);
        this.zza = str;
        this.zzb = new HashSet();
        this.zzc = new ArrayMap();
        this.zzd = l;
        this.zze = l2;
        Iterator it6 = list.iterator();
        while (true) {
            z2 = false;
            z2 = false;
            r11 = 1;
            r11 = 1;
            if (!it6.hasNext()) {
                z3 = false;
                break;
            }
            if ("_s".equals(((com.google.android.gms.internal.measurement.zzhs) it6.next()).zzd())) {
                z3 = true;
                break;
            }
        }
        zzahn.zza();
        zzic zzicVar2 = this.zzu;
        zzal zzalVarZzc = zzicVar2.zzc();
        String str6 = this.zza;
        zzfx zzfxVar = zzfy.zzaF;
        boolean zZzp = zzalVarZzc.zzp(str6, zzfxVar);
        zzahn.zza();
        boolean zZzp2 = zzicVar2.zzc().zzp(this.zza, zzfy.zzaE);
        ?? r53 = zzfxVar;
        if (z3) {
            zzaw zzawVarZzj = this.zzg.zzj();
            String str7 = this.zza;
            zzawVarZzj.zzay();
            zzawVarZzj.zzg();
            Preconditions.checkNotEmpty(str7);
            ContentValues contentValues = new ContentValues();
            contentValues.put("current_session_count", (Integer) 0);
            try {
                SQLiteDatabase sQLiteDatabaseZze = zzawVarZzj.zze();
                sQLiteDatabaseZze.update("events", contentValues, "app_id = ?", new String[]{str7});
                r53 = sQLiteDatabaseZze;
            } catch (SQLiteException e) {
                zzawVarZzj.zzu.zzaW().zzb().zzc("Error resetting session-scoped event counts. appId", zzgu.zzl(str7), e);
                r53 = "Error resetting session-scoped event counts. appId";
            }
        }
        Map mapEmptyMap = Collections.emptyMap();
        String str8 = "audience_id";
        try {
            if (zZzp2 && zZzp) {
                zzaw zzawVarZzj2 = this.zzg.zzj();
                String str9 = this.zza;
                Preconditions.checkNotEmpty(str9);
                ArrayMap arrayMap = new ArrayMap();
                try {
                    try {
                        str2 = "event_filters";
                        cursorQuery = zzawVarZzj2.zze().query("event_filters", new String[]{"audience_id", Constants.ScionAnalytics.MessageType.DATA_MESSAGE}, "app_id=?", new String[]{str9}, null, null, null);
                        try {
                            try {
                            } catch (SQLiteException e2) {
                                e = e2;
                            }
                        } catch (SQLiteException e3) {
                            e = e3;
                            l2 = z2;
                            l = r11;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (r53 != 0) {
                            r53.close();
                        }
                        throw th;
                    }
                } catch (SQLiteException e4) {
                    e = e4;
                    l2 = 0;
                    l = 1;
                    cursorQuery = null;
                } catch (Throwable th2) {
                    th = th2;
                    r53 = 0;
                    if (r53 != 0) {
                    }
                    throw th;
                }
                if (cursorQuery.moveToFirst()) {
                    while (true) {
                        byte[] blob = cursorQuery.getBlob(r11 == true ? 1 : 0);
                        l = r11 == true ? 1 : 0;
                        try {
                            try {
                                com.google.android.gms.internal.measurement.zzff zzffVar = (com.google.android.gms.internal.measurement.zzff) ((com.google.android.gms.internal.measurement.zzfe) zzpk.zzw(com.google.android.gms.internal.measurement.zzff.zzn(), blob)).zzbd();
                                if (zzffVar.zzh()) {
                                    Integer numValueOf = Integer.valueOf(cursorQuery.getInt(z2 ? 1 : 0));
                                    List list4 = (List) arrayMap.get(numValueOf);
                                    if (list4 == null) {
                                        z8 = z2 ? 1 : 0;
                                        arrayList3 = new ArrayList();
                                        arrayMap.put(numValueOf, arrayList3);
                                    } else {
                                        z8 = z2 ? 1 : 0;
                                        arrayList3 = list4;
                                    }
                                    arrayList3.add(zzffVar);
                                    z7 = z8;
                                } else {
                                    z7 = z2 ? 1 : 0;
                                }
                            } catch (IOException e5) {
                                z7 = z2 ? 1 : 0;
                                zzawVarZzj2.zzu.zzaW().zzb().zzc("Failed to merge filter. appId", zzgu.zzl(str9), e5);
                            }
                            if (!cursorQuery.moveToNext()) {
                                break;
                            }
                            r11 = l;
                            z2 = z7;
                        } catch (SQLiteException e6) {
                            e = e6;
                            l2 = z2 ? 1 : 0;
                            zzgs zzgsVarZzb = zzawVarZzj2.zzu.zzaW().zzb();
                            Object objZzl = zzgu.zzl(str9);
                            zzgsVarZzb.zzc("Database error querying filters. appId", objZzl, e);
                            mapEmptyMap = Collections.emptyMap();
                            obj = objZzl;
                            r40 = l;
                            r41 = l2;
                            obj3 = objZzl;
                            r403 = l;
                            r413 = l2;
                            if (cursorQuery != null) {
                            }
                            map = mapEmptyMap;
                            obj2 = obj;
                            r402 = r40;
                            r412 = r41;
                        }
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    map = arrayMap;
                    obj2 = str9;
                    r402 = l;
                    r412 = z7;
                    zzaw zzawVarZzj3 = this.zzg.zzj();
                    String str10 = this.zza;
                    zzawVarZzj3.zzay();
                    zzawVarZzj3.zzg();
                    Preconditions.checkNotEmpty(str10);
                    SQLiteDatabase sQLiteDatabaseZze2 = zzawVarZzj3.zze();
                    str2 = "audience_filter_values";
                    String[] strArr = new String[2];
                    strArr[r412] = "audience_id";
                    strArr[r402] = "current_results";
                    String[] strArr2 = new String[r402];
                    strArr2[r412] = str10;
                    Query = sQLiteDatabaseZze2.query("audience_filter_values", strArr, "app_id=?", strArr2, null, null, null);
                    if (Query.moveToFirst()) {
                        Map mapEmptyMap2 = Collections.emptyMap();
                        if (Query != 0) {
                            Query.close();
                        }
                        map2 = mapEmptyMap2;
                        z5 = z3 ? 1 : 0;
                        str3 = "audience_id";
                        r18 = "audience_filter_values";
                    } else {
                        ArrayMap arrayMap2 = new ArrayMap();
                        ?? r112 = r412;
                        boolean z9 = z3;
                        while (true) {
                            int i2 = Query.getInt(r112);
                            try {
                                arrayMap2.put(Integer.valueOf(i2), (com.google.android.gms.internal.measurement.zzii) ((com.google.android.gms.internal.measurement.zzih) zzpk.zzw(com.google.android.gms.internal.measurement.zzii.zzj(), Query.getBlob(1))).zzbd());
                                z4 = z9;
                                str3 = str8;
                            } catch (IOException e7) {
                                z4 = z9;
                                try {
                                    str3 = str8;
                                    try {
                                        zzawVarZzj3.zzu.zzaW().zzb().zzd("Failed to merge filter results. appId, audienceId, error", zzgu.zzl(str10), Integer.valueOf(i2), e7);
                                        z4 = z4;
                                    } catch (SQLiteException e8) {
                                        e = e8;
                                        zzawVarZzj3.zzu.zzaW().zzb().zzc("Database error querying filter results. appId", zzgu.zzl(str10), e);
                                        Map mapEmptyMap3 = Collections.emptyMap();
                                        if (Query != 0) {
                                            Query.close();
                                        }
                                        map2 = mapEmptyMap3;
                                        r18 = str2;
                                        z5 = z4;
                                    }
                                } catch (SQLiteException e9) {
                                    e = e9;
                                    str3 = str8;
                                    zzawVarZzj3.zzu.zzaW().zzb().zzc("Database error querying filter results. appId", zzgu.zzl(str10), e);
                                    Map mapEmptyMap32 = Collections.emptyMap();
                                    if (Query != 0) {
                                    }
                                    map2 = mapEmptyMap32;
                                    r18 = str2;
                                    z5 = z4;
                                }
                            }
                            if (!Query.moveToNext()) {
                                break;
                            }
                            z9 = z4 ? 1 : 0;
                            str8 = str3;
                            r112 = 0;
                        }
                        if (Query != 0) {
                            Query.close();
                        }
                        map2 = arrayMap2;
                        r18 = "audience_filter_values";
                        z5 = z4;
                    }
                    if (!map2.isEmpty()) {
                        HashSet hashSet2 = new HashSet(map2.keySet());
                        if (z5) {
                            String str11 = this.zza;
                            zzaw zzawVarZzj4 = this.zzg.zzj();
                            String str12 = this.zza;
                            zzawVarZzj4.zzay();
                            zzawVarZzj4.zzg();
                            Preconditions.checkNotEmpty(str12);
                            Map arrayMap3 = new ArrayMap();
                            try {
                                hashSet = hashSet2;
                            } catch (Throwable th3) {
                                th = th3;
                                r5 = hashSet2;
                            }
                            try {
                                i = 0;
                                cursorRawQuery = zzawVarZzj4.zze().rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str12, str12});
                                try {
                                } catch (SQLiteException e10) {
                                    e = e10;
                                    zzawVarZzj4.zzu.zzaW().zzb().zzc("Database error querying scoped filters. appId", zzgu.zzl(str12), e);
                                    arrayMap3 = Collections.emptyMap();
                                    if (cursorRawQuery != null) {
                                    }
                                    Preconditions.checkNotEmpty(str11);
                                    Preconditions.checkNotNull(map2);
                                    ArrayMap arrayMap4 = new ArrayMap();
                                    if (!map2.isEmpty()) {
                                    }
                                    map3 = arrayMap4;
                                    it = hashSet.iterator();
                                    while (it.hasNext()) {
                                    }
                                    String str13 = str3;
                                    byte[] bArr = null;
                                    String str14 = "Skipping failed audience ID";
                                    if (!list.isEmpty()) {
                                    }
                                    String str15 = str13;
                                    if (z) {
                                    }
                                }
                            } catch (SQLiteException e11) {
                                e = e11;
                                cursorRawQuery = null;
                            } catch (Throwable th4) {
                                th = th4;
                                r5 = 0;
                                if (r5 != 0) {
                                    r5.close();
                                }
                                throw th;
                            }
                            if (cursorRawQuery.moveToFirst()) {
                                while (true) {
                                    Integer numValueOf2 = Integer.valueOf(cursorRawQuery.getInt(i));
                                    List arrayList4 = (List) arrayMap3.get(numValueOf2);
                                    if (arrayList4 == null) {
                                        arrayList4 = new ArrayList();
                                        arrayMap3.put(numValueOf2, arrayList4);
                                    }
                                    arrayList4.add(Integer.valueOf(cursorRawQuery.getInt(1)));
                                    if (!cursorRawQuery.moveToNext()) {
                                        break;
                                    }
                                    i = 0;
                                }
                                if (cursorRawQuery != null) {
                                    cursorRawQuery.close();
                                }
                                Preconditions.checkNotEmpty(str11);
                                Preconditions.checkNotNull(map2);
                                ArrayMap arrayMap42 = new ArrayMap();
                                if (!map2.isEmpty()) {
                                    Iterator it7 = map2.keySet().iterator();
                                    while (it7.hasNext()) {
                                        int iIntValue = ((Integer) it7.next()).intValue();
                                        Integer numValueOf3 = Integer.valueOf(iIntValue);
                                        com.google.android.gms.internal.measurement.zzii zziiVar = (com.google.android.gms.internal.measurement.zzii) map2.get(numValueOf3);
                                        List list5 = (List) arrayMap3.get(numValueOf3);
                                        if (list5 == null || list5.isEmpty()) {
                                            map4 = arrayMap3;
                                            it2 = it7;
                                            arrayMap42.put(numValueOf3, zziiVar);
                                            arrayMap3 = map4;
                                            it7 = it2;
                                        } else {
                                            zzpg zzpgVar = this.zzg;
                                            map4 = arrayMap3;
                                            List listZzq = zzpgVar.zzp().zzq(zziiVar.zzc(), list5);
                                            if (listZzq.isEmpty()) {
                                                arrayMap3 = map4;
                                            } else {
                                                com.google.android.gms.internal.measurement.zzih zzihVar = (com.google.android.gms.internal.measurement.zzih) zziiVar.zzco();
                                                zzihVar.zzd();
                                                zzihVar.zzc(listZzq);
                                                List listZzq2 = zzpgVar.zzp().zzq(zziiVar.zza(), list5);
                                                zzihVar.zzb();
                                                zzihVar.zza(listZzq2);
                                                ArrayList arrayList5 = new ArrayList();
                                                for (com.google.android.gms.internal.measurement.zzhq zzhqVar : zziiVar.zze()) {
                                                    Iterator it8 = it7;
                                                    int i3 = iIntValue;
                                                    if (!list5.contains(Integer.valueOf(zzhqVar.zzb()))) {
                                                        arrayList5.add(zzhqVar);
                                                    }
                                                    it7 = it8;
                                                    iIntValue = i3;
                                                }
                                                it2 = it7;
                                                int i4 = iIntValue;
                                                zzihVar.zzf();
                                                zzihVar.zze(arrayList5);
                                                ArrayList arrayList6 = new ArrayList();
                                                for (com.google.android.gms.internal.measurement.zzik zzikVar : zziiVar.zzh()) {
                                                    if (!list5.contains(Integer.valueOf(zzikVar.zzb()))) {
                                                        arrayList6.add(zzikVar);
                                                    }
                                                }
                                                zzihVar.zzh();
                                                zzihVar.zzg(arrayList6);
                                                arrayMap42.put(Integer.valueOf(i4), (com.google.android.gms.internal.measurement.zzii) zzihVar.zzbd());
                                                arrayMap3 = map4;
                                                it7 = it2;
                                            }
                                        }
                                    }
                                }
                                map3 = arrayMap42;
                            } else {
                                arrayMap3 = Collections.emptyMap();
                                if (cursorRawQuery != null) {
                                }
                                Preconditions.checkNotEmpty(str11);
                                Preconditions.checkNotNull(map2);
                                ArrayMap arrayMap422 = new ArrayMap();
                                if (!map2.isEmpty()) {
                                }
                                map3 = arrayMap422;
                            }
                        } else {
                            hashSet = hashSet2;
                            map3 = map2;
                        }
                        it = hashSet.iterator();
                        while (it.hasNext()) {
                            int iIntValue2 = ((Integer) it.next()).intValue();
                            com.google.android.gms.internal.measurement.zzii zziiVar2 = (com.google.android.gms.internal.measurement.zzii) map3.get(Integer.valueOf(iIntValue2));
                            BitSet bitSet = new BitSet();
                            BitSet bitSet2 = new BitSet();
                            ArrayMap arrayMap5 = new ArrayMap();
                            if (zziiVar2 != null && zziiVar2.zzf() != 0) {
                                for (com.google.android.gms.internal.measurement.zzhq zzhqVar2 : zziiVar2.zze()) {
                                    if (zzhqVar2.zza()) {
                                        arrayMap5.put(Integer.valueOf(zzhqVar2.zzb()), zzhqVar2.zzc() ? Long.valueOf(zzhqVar2.zzd()) : null);
                                    }
                                }
                            }
                            ArrayMap arrayMap6 = new ArrayMap();
                            if (zziiVar2 != null && zziiVar2.zzi() != 0) {
                                for (com.google.android.gms.internal.measurement.zzik zzikVar2 : zziiVar2.zzh()) {
                                    if (zzikVar2.zza() && zzikVar2.zzd() > 0) {
                                        arrayMap6.put(Integer.valueOf(zzikVar2.zzb()), Long.valueOf(zzikVar2.zze(zzikVar2.zzd() - 1)));
                                        map3 = map3;
                                        zziiVar2 = zziiVar2;
                                    }
                                }
                            }
                            Map map7 = map3;
                            com.google.android.gms.internal.measurement.zzii zziiVar3 = zziiVar2;
                            if (zziiVar3 != null) {
                                int i5 = 0;
                                while (i5 < zziiVar3.zzb() * 64) {
                                    if (zzpk.zzn(zziiVar3.zza(), i5)) {
                                        z6 = zZzp;
                                        this.zzu.zzaW().zzk().zzc("Filter already evaluated. audience ID, filter ID", Integer.valueOf(iIntValue2), Integer.valueOf(i5));
                                        bitSet2.set(i5);
                                        if (zzpk.zzn(zziiVar3.zzc(), i5)) {
                                            bitSet.set(i5);
                                        }
                                        i5++;
                                        zZzp = z6;
                                    } else {
                                        z6 = zZzp;
                                    }
                                    arrayMap5.remove(Integer.valueOf(i5));
                                    i5++;
                                    zZzp = z6;
                                }
                            }
                            boolean z10 = zZzp;
                            Integer numValueOf4 = Integer.valueOf(iIntValue2);
                            com.google.android.gms.internal.measurement.zzii zziiVar4 = (com.google.android.gms.internal.measurement.zzii) map2.get(numValueOf4);
                            if (zZzp2 && z10 && (list3 = (List) map.get(numValueOf4)) != null && this.zze != null && this.zzd != null) {
                                for (com.google.android.gms.internal.measurement.zzff zzffVar2 : list3) {
                                    int iZzb = zzffVar2.zzb();
                                    long jLongValue = this.zze.longValue() / 1000;
                                    if (zzffVar2.zzk()) {
                                        jLongValue = this.zzd.longValue() / 1000;
                                    }
                                    Integer numValueOf5 = Integer.valueOf(iZzb);
                                    if (arrayMap5.containsKey(numValueOf5)) {
                                        arrayMap5.put(numValueOf5, Long.valueOf(jLongValue));
                                    }
                                    if (arrayMap6.containsKey(numValueOf5)) {
                                        arrayMap6.put(numValueOf5, Long.valueOf(jLongValue));
                                    }
                                }
                            }
                            this.zzc.put(Integer.valueOf(iIntValue2), new zzy(this, this.zza, zziiVar4, bitSet, bitSet2, arrayMap5, arrayMap6, null));
                            zZzp = z10;
                            map3 = map7;
                        }
                    }
                    String str132 = str3;
                    byte[] bArr2 = null;
                    String str142 = "Skipping failed audience ID";
                    if (!list.isEmpty()) {
                        zzz zzzVar2 = new zzz(this, bArr2);
                        ArrayMap arrayMap7 = new ArrayMap();
                        Iterator it9 = list.iterator();
                        while (it9.hasNext()) {
                            com.google.android.gms.internal.measurement.zzhs zzhsVar = (com.google.android.gms.internal.measurement.zzhs) it9.next();
                            com.google.android.gms.internal.measurement.zzhs zzhsVarZza = zzzVar2.zza(this.zza, zzhsVar);
                            if (zzhsVarZza != null) {
                                zzpg zzpgVar2 = this.zzg;
                                zzbd zzbdVarZzah = zzpgVar2.zzj().zzah(this.zza, zzhsVar, zzhsVarZza.zzd());
                                zzpgVar2.zzj().zzh(zzbdVarZzah);
                                if (z) {
                                    continue;
                                } else {
                                    long j2 = zzbdVarZzah.zzc;
                                    String strZzd = zzhsVarZza.zzd();
                                    Map mapEmptyMap4 = (Map) arrayMap7.get(strZzd);
                                    if (mapEmptyMap4 == null) {
                                        zzaw zzawVarZzj5 = zzpgVar2.zzj();
                                        String str16 = this.zza;
                                        zzawVarZzj5.zzay();
                                        zzawVarZzj5.zzg();
                                        Preconditions.checkNotEmpty(str16);
                                        Preconditions.checkNotEmpty(strZzd);
                                        ArrayMap arrayMap8 = new ArrayMap();
                                        SQLiteDatabase sQLiteDatabaseZze3 = zzawVarZzj5.zze();
                                        zzzVar = zzzVar2;
                                        try {
                                            try {
                                                String[] strArr3 = new String[2];
                                                str4 = str132;
                                                try {
                                                    strArr3[0] = str4;
                                                    it3 = it9;
                                                    try {
                                                        strArr3[1] = Constants.ScionAnalytics.MessageType.DATA_MESSAGE;
                                                        Cursor cursorQuery2 = sQLiteDatabaseZze3.query("event_filters", strArr3, "app_id=? AND event_name=?", new String[]{str16, strZzd}, null, null, null);
                                                        try {
                                                            try {
                                                                if (cursorQuery2.moveToFirst()) {
                                                                    zzbdVar = zzbdVarZzah;
                                                                    int i6 = 1;
                                                                    ?? r54 = cursorQuery2;
                                                                    r184 = r18;
                                                                    while (true) {
                                                                        try {
                                                                            try {
                                                                                com.google.android.gms.internal.measurement.zzff zzffVar3 = (com.google.android.gms.internal.measurement.zzff) ((com.google.android.gms.internal.measurement.zzfe) zzpk.zzw(com.google.android.gms.internal.measurement.zzff.zzn(), r54.getBlob(i6))).zzbd();
                                                                                Integer numValueOf6 = Integer.valueOf(r54.getInt(0));
                                                                                List list6 = (List) arrayMap8.get(numValueOf6);
                                                                                if (list6 == null) {
                                                                                    r184 = r54;
                                                                                    try {
                                                                                        arrayList = new ArrayList();
                                                                                        arrayMap8.put(numValueOf6, arrayList);
                                                                                        r185 = r184;
                                                                                    } catch (SQLiteException e12) {
                                                                                        e = e12;
                                                                                        r52 = r184;
                                                                                        r182 = r184;
                                                                                        try {
                                                                                            zzawVarZzj5.zzu.zzaW().zzb().zzc("Database error querying filters. appId", zzgu.zzl(str16), e);
                                                                                            mapEmptyMap4 = Collections.emptyMap();
                                                                                            r183 = r182;
                                                                                            if (r52 != 0) {
                                                                                            }
                                                                                        } catch (Throwable th5) {
                                                                                            th = th5;
                                                                                            if (r52 != 0) {
                                                                                                r52.close();
                                                                                            }
                                                                                            throw th;
                                                                                        }
                                                                                    } catch (Throwable th6) {
                                                                                        th = th6;
                                                                                        r52 = r184;
                                                                                        if (r52 != 0) {
                                                                                        }
                                                                                        throw th;
                                                                                    }
                                                                                } else {
                                                                                    r185 = r54;
                                                                                    arrayList = list6;
                                                                                }
                                                                                arrayList.add(zzffVar3);
                                                                                r184 = r185;
                                                                            } catch (IOException e13) {
                                                                                r184 = r54;
                                                                                zzawVarZzj5.zzu.zzaW().zzb().zzc("Failed to merge filter. appId", zzgu.zzl(str16), e13);
                                                                            }
                                                                            if (!r184.moveToNext()) {
                                                                                break;
                                                                            }
                                                                            r54 = r184;
                                                                            i6 = 1;
                                                                            r184 = r184;
                                                                        } catch (SQLiteException e14) {
                                                                            e = e14;
                                                                            r184 = r54;
                                                                        }
                                                                    }
                                                                    if (r184 != 0) {
                                                                        r184.close();
                                                                    }
                                                                    mapEmptyMap4 = arrayMap8;
                                                                    r183 = r184;
                                                                } else {
                                                                    Cursor cursor2 = cursorQuery2;
                                                                    zzbdVar = zzbdVarZzah;
                                                                    mapEmptyMap4 = Collections.emptyMap();
                                                                    r183 = cursor2;
                                                                    if (cursor2 != null) {
                                                                        cursor2.close();
                                                                        r183 = cursor2;
                                                                    }
                                                                }
                                                            } catch (Throwable th7) {
                                                                th = th7;
                                                                r184 = cursorQuery2;
                                                            }
                                                        } catch (SQLiteException e15) {
                                                            e = e15;
                                                            r184 = cursorQuery2;
                                                            zzbdVar = zzbdVarZzah;
                                                        }
                                                    } catch (SQLiteException e16) {
                                                        e = e16;
                                                        zzbdVar = zzbdVarZzah;
                                                        r52 = 0;
                                                        r182 = r18;
                                                        zzawVarZzj5.zzu.zzaW().zzb().zzc("Database error querying filters. appId", zzgu.zzl(str16), e);
                                                        mapEmptyMap4 = Collections.emptyMap();
                                                        r183 = r182;
                                                        if (r52 != 0) {
                                                            r52.close();
                                                            r183 = r182;
                                                        }
                                                        arrayMap7.put(strZzd, mapEmptyMap4);
                                                        r18 = r183;
                                                        it4 = mapEmptyMap4.keySet().iterator();
                                                        while (it4.hasNext()) {
                                                        }
                                                        it9 = it3;
                                                        str132 = str4;
                                                        zzzVar2 = zzzVar;
                                                    }
                                                } catch (SQLiteException e17) {
                                                    e = e17;
                                                    it3 = it9;
                                                }
                                            } catch (Throwable th8) {
                                                th = th8;
                                                r52 = 0;
                                            }
                                        } catch (SQLiteException e18) {
                                            e = e18;
                                            it3 = it9;
                                            zzbdVar = zzbdVarZzah;
                                            str4 = str132;
                                        }
                                        arrayMap7.put(strZzd, mapEmptyMap4);
                                        r18 = r183;
                                    } else {
                                        zzzVar = zzzVar2;
                                        it3 = it9;
                                        zzbdVar = zzbdVarZzah;
                                        str4 = str132;
                                        r18 = r18;
                                    }
                                    it4 = mapEmptyMap4.keySet().iterator();
                                    while (it4.hasNext()) {
                                        int iIntValue3 = ((Integer) it4.next()).intValue();
                                        Set set = this.zzb;
                                        Integer numValueOf7 = Integer.valueOf(iIntValue3);
                                        if (set.contains(numValueOf7)) {
                                            this.zzu.zzaW().zzk().zzb("Skipping failed audience ID", numValueOf7);
                                        } else {
                                            Iterator it10 = ((List) mapEmptyMap4.get(numValueOf7)).iterator();
                                            boolean zZzd = true;
                                            ?? r186 = r18;
                                            while (true) {
                                                if (!it10.hasNext()) {
                                                    map5 = mapEmptyMap4;
                                                    j = j2;
                                                    r18 = r186;
                                                    break;
                                                }
                                                com.google.android.gms.internal.measurement.zzff zzffVar4 = (com.google.android.gms.internal.measurement.zzff) it10.next();
                                                zzaa zzaaVar = new zzaa(this, this.zza, iIntValue3, zzffVar4);
                                                map5 = mapEmptyMap4;
                                                j = j2;
                                                Long l3 = this.zzd;
                                                zZzd = zzaaVar.zzd(l3, this.zze, zzhsVarZza, j, zzbdVar, zzd(iIntValue3, zzffVar4.zzb()));
                                                if (!zZzd) {
                                                    this.zzb.add(Integer.valueOf(iIntValue3));
                                                    r18 = l3;
                                                    break;
                                                }
                                                zzc(Integer.valueOf(iIntValue3)).zza(zzaaVar);
                                                j2 = j;
                                                mapEmptyMap4 = map5;
                                                r186 = l3;
                                            }
                                            if (!zZzd) {
                                                this.zzb.add(Integer.valueOf(iIntValue3));
                                            }
                                            j2 = j;
                                            mapEmptyMap4 = map5;
                                        }
                                    }
                                    it9 = it3;
                                    str132 = str4;
                                    zzzVar2 = zzzVar;
                                }
                            }
                        }
                    }
                    String str152 = str132;
                    if (z) {
                        return new ArrayList();
                    }
                    if (!list2.isEmpty()) {
                        ArrayMap arrayMap9 = new ArrayMap();
                        Iterator it11 = list2.iterator();
                        while (it11.hasNext()) {
                            com.google.android.gms.internal.measurement.zziu zziuVar = (com.google.android.gms.internal.measurement.zziu) it11.next();
                            String strZzc = zziuVar.zzc();
                            Map mapEmptyMap5 = (Map) arrayMap9.get(strZzc);
                            if (mapEmptyMap5 == null) {
                                zzaw zzawVarZzj6 = this.zzg.zzj();
                                String str17 = this.zza;
                                zzawVarZzj6.zzay();
                                zzawVarZzj6.zzg();
                                Preconditions.checkNotEmpty(str17);
                                Preconditions.checkNotEmpty(strZzc);
                                ArrayMap arrayMap10 = new ArrayMap();
                                try {
                                    int i7 = 1;
                                    Cursor cursorQuery3 = zzawVarZzj6.zze().query("property_filters", new String[]{str152, Constants.ScionAnalytics.MessageType.DATA_MESSAGE}, "app_id=? AND property_name=?", new String[]{str17, strZzc}, null, null, null);
                                    try {
                                        try {
                                            if (cursorQuery3.moveToFirst()) {
                                                while (true) {
                                                    try {
                                                        com.google.android.gms.internal.measurement.zzfn zzfnVar2 = (com.google.android.gms.internal.measurement.zzfn) ((com.google.android.gms.internal.measurement.zzfm) zzpk.zzw(com.google.android.gms.internal.measurement.zzfn.zzj(), cursorQuery3.getBlob(i7))).zzbd();
                                                        Integer numValueOf8 = Integer.valueOf(cursorQuery3.getInt(0));
                                                        List list7 = (List) arrayMap10.get(numValueOf8);
                                                        if (list7 == null) {
                                                            arrayList2 = new ArrayList();
                                                            arrayMap10.put(numValueOf8, arrayList2);
                                                        } else {
                                                            arrayList2 = list7;
                                                        }
                                                        arrayList2.add(zzfnVar2);
                                                        it5 = it11;
                                                    } catch (IOException e19) {
                                                        it5 = it11;
                                                        try {
                                                            zzawVarZzj6.zzu.zzaW().zzb().zzc("Failed to merge filter", zzgu.zzl(str17), e19);
                                                        } catch (SQLiteException e20) {
                                                            e = e20;
                                                            cursor = cursorQuery3;
                                                            try {
                                                                zzawVarZzj6.zzu.zzaW().zzb().zzc("Database error querying filters. appId", zzgu.zzl(str17), e);
                                                                mapEmptyMap5 = Collections.emptyMap();
                                                                if (cursor != null) {
                                                                    cursor.close();
                                                                }
                                                            } catch (Throwable th9) {
                                                                th = th9;
                                                                if (cursor != null) {
                                                                    cursor.close();
                                                                }
                                                                throw th;
                                                            }
                                                        }
                                                    }
                                                    if (!cursorQuery3.moveToNext()) {
                                                        break;
                                                    }
                                                    it11 = it5;
                                                    i7 = 1;
                                                }
                                                if (cursorQuery3 != null) {
                                                    cursorQuery3.close();
                                                }
                                                mapEmptyMap5 = arrayMap10;
                                            } else {
                                                it5 = it11;
                                                mapEmptyMap5 = Collections.emptyMap();
                                                if (cursorQuery3 != null) {
                                                    cursorQuery3.close();
                                                }
                                            }
                                        } catch (Throwable th10) {
                                            th = th10;
                                            cursor = cursorQuery3;
                                            if (cursor != null) {
                                            }
                                            throw th;
                                        }
                                    } catch (SQLiteException e21) {
                                        e = e21;
                                        it5 = it11;
                                    }
                                } catch (SQLiteException e22) {
                                    e = e22;
                                    it5 = it11;
                                    cursor = null;
                                } catch (Throwable th11) {
                                    th = th11;
                                    cursor = null;
                                }
                                arrayMap9.put(strZzc, mapEmptyMap5);
                            } else {
                                it5 = it11;
                            }
                            Iterator it12 = mapEmptyMap5.keySet().iterator();
                            while (true) {
                                if (it12.hasNext()) {
                                    int iIntValue4 = ((Integer) it12.next()).intValue();
                                    Set set2 = this.zzb;
                                    Integer numValueOf9 = Integer.valueOf(iIntValue4);
                                    if (set2.contains(numValueOf9)) {
                                        this.zzu.zzaW().zzk().zzb(str142, numValueOf9);
                                        break;
                                    }
                                    Iterator it13 = ((List) mapEmptyMap5.get(numValueOf9)).iterator();
                                    boolean zZzd2 = true;
                                    while (true) {
                                        if (!it13.hasNext()) {
                                            map6 = mapEmptyMap5;
                                            str5 = str142;
                                            break;
                                        }
                                        zzfnVar = (com.google.android.gms.internal.measurement.zzfn) it13.next();
                                        zzicVar = this.zzu;
                                        if (Log.isLoggable(zzicVar.zzaW().zzn(), 2)) {
                                            map6 = mapEmptyMap5;
                                            str5 = str142;
                                            zzicVar.zzaW().zzk().zzd("Evaluating filter. audience, filter, property", Integer.valueOf(iIntValue4), zzfnVar.zza() ? Integer.valueOf(zzfnVar.zzb()) : null, zzicVar.zzl().zzc(zzfnVar.zzc()));
                                            zzicVar.zzaW().zzk().zzb("Filter definition", this.zzg.zzp().zzk(zzfnVar));
                                        } else {
                                            map6 = mapEmptyMap5;
                                            str5 = str142;
                                        }
                                        if (!zzfnVar.zza() || zzfnVar.zzb() > 256) {
                                            break;
                                        }
                                        zzac zzacVar = new zzac(this, this.zza, iIntValue4, zzfnVar);
                                        zZzd2 = zzacVar.zzd(this.zzd, this.zze, zziuVar, zzd(iIntValue4, zzfnVar.zzb()));
                                        if (!zZzd2) {
                                            this.zzb.add(Integer.valueOf(iIntValue4));
                                            break;
                                        }
                                        zzc(Integer.valueOf(iIntValue4)).zza(zzacVar);
                                        mapEmptyMap5 = map6;
                                        str142 = str5;
                                    }
                                    zzicVar.zzaW().zze().zzc("Invalid property filter ID. appId, id", zzgu.zzl(this.zza), String.valueOf(zzfnVar.zza() ? Integer.valueOf(zzfnVar.zzb()) : null));
                                    this.zzb.add(Integer.valueOf(iIntValue4));
                                    mapEmptyMap5 = map6;
                                    str142 = str5;
                                }
                            }
                            it11 = it5;
                        }
                    }
                    ArrayList arrayList7 = new ArrayList();
                    Set setKeySet = this.zzc.keySet();
                    setKeySet.removeAll(this.zzb);
                    Iterator it14 = setKeySet.iterator();
                    while (it14.hasNext()) {
                        int iIntValue5 = ((Integer) it14.next()).intValue();
                        Map map8 = this.zzc;
                        Integer numValueOf10 = Integer.valueOf(iIntValue5);
                        zzy zzyVar = (zzy) map8.get(numValueOf10);
                        Preconditions.checkNotNull(zzyVar);
                        com.google.android.gms.internal.measurement.zzhg zzhgVarZzb = zzyVar.zzb(iIntValue5);
                        arrayList7.add(zzhgVarZzb);
                        zzaw zzawVarZzj7 = this.zzg.zzj();
                        String str18 = this.zza;
                        com.google.android.gms.internal.measurement.zzii zziiVarZzc = zzhgVarZzb.zzc();
                        zzawVarZzj7.zzay();
                        zzawVarZzj7.zzg();
                        Preconditions.checkNotEmpty(str18);
                        Preconditions.checkNotNull(zziiVarZzc);
                        byte[] bArrZzcd = zziiVarZzc.zzcd();
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("app_id", str18);
                        contentValues2.put(str152, numValueOf10);
                        contentValues2.put("current_results", bArrZzcd);
                        try {
                            try {
                                if (zzawVarZzj7.zze().insertWithOnConflict("audience_filter_values", null, contentValues2, 5) == -1) {
                                    zzawVarZzj7.zzu.zzaW().zzb().zzb("Failed to insert filter results (got -1). appId", zzgu.zzl(str18));
                                }
                            } catch (SQLiteException e23) {
                                e = e23;
                                zzawVarZzj7.zzu.zzaW().zzb().zzc("Error storing filter results. appId", zzgu.zzl(str18), e);
                            }
                        } catch (SQLiteException e24) {
                            e = e24;
                        }
                    }
                    return arrayList7;
                }
                mapEmptyMap = Collections.emptyMap();
                obj = str9;
                r40 = true;
                r41 = false;
                obj3 = str9;
                r403 = true;
                r413 = false;
                if (cursorQuery != null) {
                    cursorQuery.close();
                    obj = obj3;
                    r40 = r403;
                    r41 = r413;
                }
                zzgs zzgsVarZzb2 = zzawVarZzj2.zzu.zzaW().zzb();
                Object objZzl2 = zzgu.zzl(str9);
                zzgsVarZzb2.zzc("Database error querying filters. appId", objZzl2, e);
                mapEmptyMap = Collections.emptyMap();
                obj = objZzl2;
                r40 = l;
                r41 = l2;
                obj3 = objZzl2;
                r403 = l;
                r413 = l2;
                if (cursorQuery != null) {
                }
            } else {
                r41 = 0;
                r40 = 1;
                obj = "app_id = ?";
            }
            str2 = "audience_filter_values";
            String[] strArr4 = new String[2];
            strArr4[r412] = "audience_id";
            strArr4[r402] = "current_results";
            String[] strArr22 = new String[r402];
            strArr22[r412] = str10;
            Query = sQLiteDatabaseZze2.query("audience_filter_values", strArr4, "app_id=?", strArr22, null, null, null);
            if (Query.moveToFirst()) {
            }
            if (!map2.isEmpty()) {
            }
            String str1322 = str3;
            byte[] bArr22 = null;
            String str1422 = "Skipping failed audience ID";
            if (!list.isEmpty()) {
            }
            String str1522 = str1322;
            if (z) {
            }
        } catch (Throwable th12) {
            th = th12;
            ?? r55 = obj2;
            if (r55 != 0) {
                r55.close();
            }
            throw th;
        }
        map = mapEmptyMap;
        obj2 = obj;
        r402 = r40;
        r412 = r41;
        zzaw zzawVarZzj32 = this.zzg.zzj();
        String str102 = this.zza;
        zzawVarZzj32.zzay();
        zzawVarZzj32.zzg();
        Preconditions.checkNotEmpty(str102);
        SQLiteDatabase sQLiteDatabaseZze22 = zzawVarZzj32.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzos
    protected final boolean zzbc() {
        return false;
    }
}
