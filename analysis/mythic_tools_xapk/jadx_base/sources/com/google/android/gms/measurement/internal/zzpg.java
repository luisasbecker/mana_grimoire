package com.google.android.gms.measurement.internal;

import android.app.BroadcastOptions;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.camera.video.AudioStats;
import androidx.collection.ArrayMap;
import androidx.collection.SieveCacheKt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzaeh;
import com.google.android.gms.internal.measurement.zzagr;
import com.google.android.gms.internal.measurement.zzahh;
import com.google.android.gms.internal.measurement.zzahk;
import com.google.android.gms.internal.measurement.zzaif;
import com.google.android.gms.internal.measurement.zzair;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.GZIPInputStream;
import kotlin.time.DurationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzpg implements zzjg {
    private static volatile zzpg zzb;
    private List zzA;
    private long zzB;
    private final Map zzC;
    private final Map zzD;
    private final Map zzE;
    private zzlu zzG;
    private String zzH;
    private zzaz zzI;
    private long zzJ;
    long zza;
    private final zzht zzc;
    private final zzgz zzd;
    private zzaw zze;
    private zzhb zzf;
    private zzok zzg;
    private zzad zzh;
    private final zzpk zzi;
    private zzlp zzj;
    private zznn zzk;
    private final zzou zzl;
    private zzhk zzm;
    private final zzic zzn;
    private boolean zzp;
    private List zzq;
    private int zzs;
    private int zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private FileLock zzx;
    private FileChannel zzy;
    private List zzz;
    private final AtomicBoolean zzo = new AtomicBoolean(false);
    private final Deque zzr = new LinkedList();
    private final Map zzF = new HashMap();
    private final zzpo zzK = new zzpb(this);

    zzpg(zzph zzphVar, zzic zzicVar) {
        Preconditions.checkNotNull(zzphVar);
        this.zzn = zzic.zzy(zzphVar.zza, null, null, null);
        this.zzB = -1L;
        this.zzl = new zzou(this);
        zzpk zzpkVar = new zzpk(this);
        zzpkVar.zzaz();
        this.zzi = zzpkVar;
        zzgz zzgzVar = new zzgz(this);
        zzgzVar.zzaz();
        this.zzd = zzgzVar;
        zzht zzhtVar = new zzht(this);
        zzhtVar.zzaz();
        this.zzc = zzhtVar;
        this.zzC = new HashMap();
        this.zzD = new HashMap();
        this.zzE = new HashMap();
        zzaX().zzj(new zzov(this, zzphVar));
    }

    public static zzpg zza(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (zzpg.class) {
                if (zzb == null) {
                    zzb = new zzpg((zzph) Preconditions.checkNotNull(new zzph(context)), null);
                }
            }
        }
        return zzb;
    }

    static final void zzaB(com.google.android.gms.internal.measurement.zzhr zzhrVar, int i, String str) {
        List listZza = zzhrVar.zza();
        for (int i2 = 0; i2 < listZza.size(); i2++) {
            if ("_err".equals(((com.google.android.gms.internal.measurement.zzhw) listZza.get(i2)).zzb())) {
                return;
            }
        }
        com.google.android.gms.internal.measurement.zzhv zzhvVarZzn = com.google.android.gms.internal.measurement.zzhw.zzn();
        zzhvVarZzn.zzb("_err");
        zzhvVarZzn.zzf(Long.valueOf(i).longValue());
        com.google.android.gms.internal.measurement.zzhw zzhwVar = (com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn.zzbd();
        com.google.android.gms.internal.measurement.zzhv zzhvVarZzn2 = com.google.android.gms.internal.measurement.zzhw.zzn();
        zzhvVarZzn2.zzb("_ev");
        zzhvVarZzn2.zzd(str);
        com.google.android.gms.internal.measurement.zzhw zzhwVar2 = (com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn2.zzbd();
        zzhrVar.zzf(zzhwVar);
        zzhrVar.zzf(zzhwVar2);
    }

    static final void zzaC(com.google.android.gms.internal.measurement.zzhr zzhrVar, String str) {
        List listZza = zzhrVar.zza();
        for (int i = 0; i < listZza.size(); i++) {
            if (str.equals(((com.google.android.gms.internal.measurement.zzhw) listZza.get(i)).zzb())) {
                zzhrVar.zzj(i);
                return;
            }
        }
    }

    private final int zzaD(String str, zzan zzanVar) {
        zzjk zzjkVar;
        zzji zzjiVarZzB;
        zzht zzhtVar = this.zzc;
        if (zzhtVar.zzy(str) == null) {
            zzanVar.zzc(zzjk.AD_PERSONALIZATION, zzam.FAILSAFE);
            return 1;
        }
        zzh zzhVarZzu = zzj().zzu(str);
        if (zzhVarZzu != null && zze.zzc(zzhVarZzu.zzaH()).zza() == zzji.POLICY && (zzjiVarZzB = zzhtVar.zzB(str, (zzjkVar = zzjk.AD_PERSONALIZATION))) != zzji.UNINITIALIZED) {
            zzanVar.zzc(zzjkVar, zzam.REMOTE_ENFORCED_DEFAULT);
            return zzjiVarZzB == zzji.GRANTED ? 0 : 1;
        }
        zzjk zzjkVar2 = zzjk.AD_PERSONALIZATION;
        zzanVar.zzc(zzjkVar2, zzam.REMOTE_DEFAULT);
        return zzhtVar.zzw(str, zzjkVar2) ? 0 : 1;
    }

    private final Map zzaE(com.google.android.gms.internal.measurement.zzhs zzhsVar) {
        HashMap map = new HashMap();
        zzp();
        for (Map.Entry entry : zzpk.zzL(zzhsVar, "gad_").entrySet()) {
            map.put((String) entry.getKey(), String.valueOf(entry.getValue()));
        }
        return map;
    }

    private final zzaz zzaF() {
        if (this.zzI == null) {
            this.zzI = new zzoy(this, this.zzn);
        }
        return this.zzI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzaG, reason: merged with bridge method [inline-methods] */
    public final void zzaw() {
        zzaX().zzg();
        if (this.zzr.isEmpty() || zzaF().zzc()) {
            return;
        }
        long jMax = Math.max(0L, ((long) ((Integer) zzfy.zzaA.zzb(null)).intValue()) - (zzba().elapsedRealtime() - this.zzJ));
        zzaW().zzk().zzb("Scheduling notify next app runnable, delay in ms", Long.valueOf(jMax));
        zzaF().zzb(jMax);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:139:0x045f A[Catch: all -> 0x0e3a, TryCatch #5 {all -> 0x0e3a, blocks: (B:3:0x0011, B:5:0x0028, B:8:0x0030, B:9:0x0044, B:12:0x005c, B:15:0x0084, B:17:0x00b9, B:20:0x00ca, B:22:0x00d4, B:229:0x06f4, B:25:0x0101, B:28:0x0117, B:30:0x011d, B:32:0x0123, B:34:0x0136, B:38:0x0143, B:40:0x014e, B:42:0x015a, B:44:0x0160, B:48:0x016b, B:49:0x0179, B:51:0x0187, B:54:0x01a7, B:56:0x01ad, B:58:0x01bd, B:60:0x01cb, B:62:0x01db, B:63:0x01e8, B:64:0x01eb, B:66:0x01f8, B:68:0x0202, B:69:0x0212, B:71:0x022f, B:73:0x0239, B:75:0x024d, B:76:0x0257, B:79:0x0262, B:80:0x026c, B:83:0x0274, B:86:0x0285, B:87:0x0288, B:89:0x029f, B:142:0x0490, B:143:0x0493, B:145:0x049d, B:148:0x04ae, B:150:0x04c1, B:152:0x04cd, B:185:0x0595, B:187:0x05a2, B:189:0x05a8, B:191:0x05ae, B:193:0x05be, B:194:0x05c1, B:195:0x05c6, B:197:0x05cc, B:198:0x05d8, B:200:0x05de, B:202:0x05ee, B:204:0x05f8, B:205:0x060d, B:207:0x0613, B:208:0x062e, B:210:0x0634, B:211:0x0652, B:212:0x065b, B:216:0x0680, B:213:0x065f, B:215:0x066d, B:217:0x0688, B:218:0x06a0, B:220:0x06a6, B:222:0x06b9, B:223:0x06c6, B:224:0x06ca, B:226:0x06d0, B:228:0x06de, B:157:0x04eb, B:159:0x04fb, B:162:0x050e, B:164:0x0521, B:166:0x052d, B:168:0x053d, B:170:0x0549, B:172:0x0555, B:174:0x055f, B:177:0x056c, B:179:0x0572, B:181:0x0582, B:182:0x058d, B:98:0x02c5, B:101:0x02cf, B:103:0x02dd, B:108:0x032a, B:104:0x02fb, B:106:0x030c, B:112:0x0338, B:114:0x0364, B:115:0x038e, B:117:0x03c5, B:119:0x03cb, B:122:0x03d7, B:124:0x040e, B:125:0x0429, B:127:0x042f, B:129:0x043d, B:133:0x0451, B:130:0x0445, B:136:0x0458, B:139:0x045f, B:140:0x0477, B:232:0x070a, B:234:0x0718, B:236:0x0721, B:247:0x0753, B:237:0x0729, B:239:0x0732, B:241:0x0738, B:244:0x0744, B:246:0x074e, B:248:0x0756, B:249:0x0762, B:252:0x076a, B:254:0x077c, B:255:0x0787, B:257:0x078f, B:261:0x07b5, B:263:0x07cf, B:265:0x07e4, B:267:0x07fe, B:269:0x0813, B:270:0x0821, B:272:0x0827, B:274:0x0837, B:275:0x083e, B:277:0x084a, B:278:0x0851, B:279:0x0854, B:281:0x0896, B:283:0x089c, B:289:0x08c3, B:291:0x08cb, B:292:0x08d4, B:294:0x08da, B:295:0x08e0, B:297:0x08f5, B:299:0x0905, B:301:0x0915, B:303:0x091d, B:304:0x0920, B:312:0x0994, B:314:0x09ad, B:316:0x09c3, B:318:0x09c8, B:320:0x09cc, B:322:0x09d0, B:324:0x09da, B:325:0x09e0, B:327:0x09e4, B:329:0x09ea, B:330:0x09f8, B:331:0x0a01, B:335:0x0a23, B:338:0x0a29, B:284:0x08aa, B:286:0x08b0, B:288:0x08b6, B:268:0x0810, B:264:0x07e1, B:258:0x0795, B:260:0x079b), top: B:493:0x0011, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0477 A[Catch: all -> 0x0e3a, TryCatch #5 {all -> 0x0e3a, blocks: (B:3:0x0011, B:5:0x0028, B:8:0x0030, B:9:0x0044, B:12:0x005c, B:15:0x0084, B:17:0x00b9, B:20:0x00ca, B:22:0x00d4, B:229:0x06f4, B:25:0x0101, B:28:0x0117, B:30:0x011d, B:32:0x0123, B:34:0x0136, B:38:0x0143, B:40:0x014e, B:42:0x015a, B:44:0x0160, B:48:0x016b, B:49:0x0179, B:51:0x0187, B:54:0x01a7, B:56:0x01ad, B:58:0x01bd, B:60:0x01cb, B:62:0x01db, B:63:0x01e8, B:64:0x01eb, B:66:0x01f8, B:68:0x0202, B:69:0x0212, B:71:0x022f, B:73:0x0239, B:75:0x024d, B:76:0x0257, B:79:0x0262, B:80:0x026c, B:83:0x0274, B:86:0x0285, B:87:0x0288, B:89:0x029f, B:142:0x0490, B:143:0x0493, B:145:0x049d, B:148:0x04ae, B:150:0x04c1, B:152:0x04cd, B:185:0x0595, B:187:0x05a2, B:189:0x05a8, B:191:0x05ae, B:193:0x05be, B:194:0x05c1, B:195:0x05c6, B:197:0x05cc, B:198:0x05d8, B:200:0x05de, B:202:0x05ee, B:204:0x05f8, B:205:0x060d, B:207:0x0613, B:208:0x062e, B:210:0x0634, B:211:0x0652, B:212:0x065b, B:216:0x0680, B:213:0x065f, B:215:0x066d, B:217:0x0688, B:218:0x06a0, B:220:0x06a6, B:222:0x06b9, B:223:0x06c6, B:224:0x06ca, B:226:0x06d0, B:228:0x06de, B:157:0x04eb, B:159:0x04fb, B:162:0x050e, B:164:0x0521, B:166:0x052d, B:168:0x053d, B:170:0x0549, B:172:0x0555, B:174:0x055f, B:177:0x056c, B:179:0x0572, B:181:0x0582, B:182:0x058d, B:98:0x02c5, B:101:0x02cf, B:103:0x02dd, B:108:0x032a, B:104:0x02fb, B:106:0x030c, B:112:0x0338, B:114:0x0364, B:115:0x038e, B:117:0x03c5, B:119:0x03cb, B:122:0x03d7, B:124:0x040e, B:125:0x0429, B:127:0x042f, B:129:0x043d, B:133:0x0451, B:130:0x0445, B:136:0x0458, B:139:0x045f, B:140:0x0477, B:232:0x070a, B:234:0x0718, B:236:0x0721, B:247:0x0753, B:237:0x0729, B:239:0x0732, B:241:0x0738, B:244:0x0744, B:246:0x074e, B:248:0x0756, B:249:0x0762, B:252:0x076a, B:254:0x077c, B:255:0x0787, B:257:0x078f, B:261:0x07b5, B:263:0x07cf, B:265:0x07e4, B:267:0x07fe, B:269:0x0813, B:270:0x0821, B:272:0x0827, B:274:0x0837, B:275:0x083e, B:277:0x084a, B:278:0x0851, B:279:0x0854, B:281:0x0896, B:283:0x089c, B:289:0x08c3, B:291:0x08cb, B:292:0x08d4, B:294:0x08da, B:295:0x08e0, B:297:0x08f5, B:299:0x0905, B:301:0x0915, B:303:0x091d, B:304:0x0920, B:312:0x0994, B:314:0x09ad, B:316:0x09c3, B:318:0x09c8, B:320:0x09cc, B:322:0x09d0, B:324:0x09da, B:325:0x09e0, B:327:0x09e4, B:329:0x09ea, B:330:0x09f8, B:331:0x0a01, B:335:0x0a23, B:338:0x0a29, B:284:0x08aa, B:286:0x08b0, B:288:0x08b6, B:268:0x0810, B:264:0x07e1, B:258:0x0795, B:260:0x079b), top: B:493:0x0011, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0729 A[Catch: all -> 0x0e3a, TryCatch #5 {all -> 0x0e3a, blocks: (B:3:0x0011, B:5:0x0028, B:8:0x0030, B:9:0x0044, B:12:0x005c, B:15:0x0084, B:17:0x00b9, B:20:0x00ca, B:22:0x00d4, B:229:0x06f4, B:25:0x0101, B:28:0x0117, B:30:0x011d, B:32:0x0123, B:34:0x0136, B:38:0x0143, B:40:0x014e, B:42:0x015a, B:44:0x0160, B:48:0x016b, B:49:0x0179, B:51:0x0187, B:54:0x01a7, B:56:0x01ad, B:58:0x01bd, B:60:0x01cb, B:62:0x01db, B:63:0x01e8, B:64:0x01eb, B:66:0x01f8, B:68:0x0202, B:69:0x0212, B:71:0x022f, B:73:0x0239, B:75:0x024d, B:76:0x0257, B:79:0x0262, B:80:0x026c, B:83:0x0274, B:86:0x0285, B:87:0x0288, B:89:0x029f, B:142:0x0490, B:143:0x0493, B:145:0x049d, B:148:0x04ae, B:150:0x04c1, B:152:0x04cd, B:185:0x0595, B:187:0x05a2, B:189:0x05a8, B:191:0x05ae, B:193:0x05be, B:194:0x05c1, B:195:0x05c6, B:197:0x05cc, B:198:0x05d8, B:200:0x05de, B:202:0x05ee, B:204:0x05f8, B:205:0x060d, B:207:0x0613, B:208:0x062e, B:210:0x0634, B:211:0x0652, B:212:0x065b, B:216:0x0680, B:213:0x065f, B:215:0x066d, B:217:0x0688, B:218:0x06a0, B:220:0x06a6, B:222:0x06b9, B:223:0x06c6, B:224:0x06ca, B:226:0x06d0, B:228:0x06de, B:157:0x04eb, B:159:0x04fb, B:162:0x050e, B:164:0x0521, B:166:0x052d, B:168:0x053d, B:170:0x0549, B:172:0x0555, B:174:0x055f, B:177:0x056c, B:179:0x0572, B:181:0x0582, B:182:0x058d, B:98:0x02c5, B:101:0x02cf, B:103:0x02dd, B:108:0x032a, B:104:0x02fb, B:106:0x030c, B:112:0x0338, B:114:0x0364, B:115:0x038e, B:117:0x03c5, B:119:0x03cb, B:122:0x03d7, B:124:0x040e, B:125:0x0429, B:127:0x042f, B:129:0x043d, B:133:0x0451, B:130:0x0445, B:136:0x0458, B:139:0x045f, B:140:0x0477, B:232:0x070a, B:234:0x0718, B:236:0x0721, B:247:0x0753, B:237:0x0729, B:239:0x0732, B:241:0x0738, B:244:0x0744, B:246:0x074e, B:248:0x0756, B:249:0x0762, B:252:0x076a, B:254:0x077c, B:255:0x0787, B:257:0x078f, B:261:0x07b5, B:263:0x07cf, B:265:0x07e4, B:267:0x07fe, B:269:0x0813, B:270:0x0821, B:272:0x0827, B:274:0x0837, B:275:0x083e, B:277:0x084a, B:278:0x0851, B:279:0x0854, B:281:0x0896, B:283:0x089c, B:289:0x08c3, B:291:0x08cb, B:292:0x08d4, B:294:0x08da, B:295:0x08e0, B:297:0x08f5, B:299:0x0905, B:301:0x0915, B:303:0x091d, B:304:0x0920, B:312:0x0994, B:314:0x09ad, B:316:0x09c3, B:318:0x09c8, B:320:0x09cc, B:322:0x09d0, B:324:0x09da, B:325:0x09e0, B:327:0x09e4, B:329:0x09ea, B:330:0x09f8, B:331:0x0a01, B:335:0x0a23, B:338:0x0a29, B:284:0x08aa, B:286:0x08b0, B:288:0x08b6, B:268:0x0810, B:264:0x07e1, B:258:0x0795, B:260:0x079b), top: B:493:0x0011, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:342:0x0a5e A[Catch: all -> 0x0e22, TryCatch #0 {all -> 0x0e22, blocks: (B:306:0x0962, B:307:0x0975, B:309:0x097b, B:399:0x0c38, B:333:0x0a0d, B:340:0x0a3e, B:342:0x0a5e, B:343:0x0a66, B:345:0x0a6c, B:347:0x0a7c, B:354:0x0aa4, B:355:0x0ac7, B:357:0x0ad3, B:359:0x0ae7, B:361:0x0b28, B:365:0x0b3e, B:367:0x0b45, B:369:0x0b54, B:371:0x0b58, B:373:0x0b5c, B:375:0x0b60, B:376:0x0b6c, B:377:0x0b71, B:379:0x0b77, B:381:0x0b93, B:382:0x0b98, B:398:0x0c35, B:383:0x0bb0, B:385:0x0bb6, B:389:0x0bd7, B:391:0x0bff, B:392:0x0c0a, B:393:0x0c1d, B:395:0x0c25, B:386:0x0bc0, B:352:0x0a90, B:400:0x0c41, B:402:0x0c4c, B:403:0x0c52, B:404:0x0c5a, B:406:0x0c60, B:408:0x0c75, B:410:0x0c85, B:430:0x0d06, B:411:0x0c9d, B:413:0x0ca3, B:415:0x0cad, B:417:0x0cb4, B:423:0x0cc4, B:425:0x0ccb, B:427:0x0cf7, B:429:0x0cfe, B:428:0x0cfb, B:424:0x0cc8, B:416:0x0cb1), top: B:484:0x0962 }] */
    /* JADX WARN: Removed duplicated region for block: B:352:0x0a90 A[Catch: all -> 0x0e22, EDGE_INSN: B:540:0x0a90->B:352:0x0a90 BREAK  A[LOOP:15: B:343:0x0a66->B:351:0x0a8d], TryCatch #0 {all -> 0x0e22, blocks: (B:306:0x0962, B:307:0x0975, B:309:0x097b, B:399:0x0c38, B:333:0x0a0d, B:340:0x0a3e, B:342:0x0a5e, B:343:0x0a66, B:345:0x0a6c, B:347:0x0a7c, B:354:0x0aa4, B:355:0x0ac7, B:357:0x0ad3, B:359:0x0ae7, B:361:0x0b28, B:365:0x0b3e, B:367:0x0b45, B:369:0x0b54, B:371:0x0b58, B:373:0x0b5c, B:375:0x0b60, B:376:0x0b6c, B:377:0x0b71, B:379:0x0b77, B:381:0x0b93, B:382:0x0b98, B:398:0x0c35, B:383:0x0bb0, B:385:0x0bb6, B:389:0x0bd7, B:391:0x0bff, B:392:0x0c0a, B:393:0x0c1d, B:395:0x0c25, B:386:0x0bc0, B:352:0x0a90, B:400:0x0c41, B:402:0x0c4c, B:403:0x0c52, B:404:0x0c5a, B:406:0x0c60, B:408:0x0c75, B:410:0x0c85, B:430:0x0d06, B:411:0x0c9d, B:413:0x0ca3, B:415:0x0cad, B:417:0x0cb4, B:423:0x0cc4, B:425:0x0ccb, B:427:0x0cf7, B:429:0x0cfe, B:428:0x0cfb, B:424:0x0cc8, B:416:0x0cb1), top: B:484:0x0962 }] */
    /* JADX WARN: Removed duplicated region for block: B:354:0x0aa4 A[Catch: all -> 0x0e22, TryCatch #0 {all -> 0x0e22, blocks: (B:306:0x0962, B:307:0x0975, B:309:0x097b, B:399:0x0c38, B:333:0x0a0d, B:340:0x0a3e, B:342:0x0a5e, B:343:0x0a66, B:345:0x0a6c, B:347:0x0a7c, B:354:0x0aa4, B:355:0x0ac7, B:357:0x0ad3, B:359:0x0ae7, B:361:0x0b28, B:365:0x0b3e, B:367:0x0b45, B:369:0x0b54, B:371:0x0b58, B:373:0x0b5c, B:375:0x0b60, B:376:0x0b6c, B:377:0x0b71, B:379:0x0b77, B:381:0x0b93, B:382:0x0b98, B:398:0x0c35, B:383:0x0bb0, B:385:0x0bb6, B:389:0x0bd7, B:391:0x0bff, B:392:0x0c0a, B:393:0x0c1d, B:395:0x0c25, B:386:0x0bc0, B:352:0x0a90, B:400:0x0c41, B:402:0x0c4c, B:403:0x0c52, B:404:0x0c5a, B:406:0x0c60, B:408:0x0c75, B:410:0x0c85, B:430:0x0d06, B:411:0x0c9d, B:413:0x0ca3, B:415:0x0cad, B:417:0x0cb4, B:423:0x0cc4, B:425:0x0ccb, B:427:0x0cf7, B:429:0x0cfe, B:428:0x0cfb, B:424:0x0cc8, B:416:0x0cb1), top: B:484:0x0962 }] */
    /* JADX WARN: Removed duplicated region for block: B:355:0x0ac7 A[Catch: all -> 0x0e22, TryCatch #0 {all -> 0x0e22, blocks: (B:306:0x0962, B:307:0x0975, B:309:0x097b, B:399:0x0c38, B:333:0x0a0d, B:340:0x0a3e, B:342:0x0a5e, B:343:0x0a66, B:345:0x0a6c, B:347:0x0a7c, B:354:0x0aa4, B:355:0x0ac7, B:357:0x0ad3, B:359:0x0ae7, B:361:0x0b28, B:365:0x0b3e, B:367:0x0b45, B:369:0x0b54, B:371:0x0b58, B:373:0x0b5c, B:375:0x0b60, B:376:0x0b6c, B:377:0x0b71, B:379:0x0b77, B:381:0x0b93, B:382:0x0b98, B:398:0x0c35, B:383:0x0bb0, B:385:0x0bb6, B:389:0x0bd7, B:391:0x0bff, B:392:0x0c0a, B:393:0x0c1d, B:395:0x0c25, B:386:0x0bc0, B:352:0x0a90, B:400:0x0c41, B:402:0x0c4c, B:403:0x0c52, B:404:0x0c5a, B:406:0x0c60, B:408:0x0c75, B:410:0x0c85, B:430:0x0d06, B:411:0x0c9d, B:413:0x0ca3, B:415:0x0cad, B:417:0x0cb4, B:423:0x0cc4, B:425:0x0ccb, B:427:0x0cf7, B:429:0x0cfe, B:428:0x0cfb, B:424:0x0cc8, B:416:0x0cb1), top: B:484:0x0962 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0187 A[Catch: all -> 0x0e3a, TryCatch #5 {all -> 0x0e3a, blocks: (B:3:0x0011, B:5:0x0028, B:8:0x0030, B:9:0x0044, B:12:0x005c, B:15:0x0084, B:17:0x00b9, B:20:0x00ca, B:22:0x00d4, B:229:0x06f4, B:25:0x0101, B:28:0x0117, B:30:0x011d, B:32:0x0123, B:34:0x0136, B:38:0x0143, B:40:0x014e, B:42:0x015a, B:44:0x0160, B:48:0x016b, B:49:0x0179, B:51:0x0187, B:54:0x01a7, B:56:0x01ad, B:58:0x01bd, B:60:0x01cb, B:62:0x01db, B:63:0x01e8, B:64:0x01eb, B:66:0x01f8, B:68:0x0202, B:69:0x0212, B:71:0x022f, B:73:0x0239, B:75:0x024d, B:76:0x0257, B:79:0x0262, B:80:0x026c, B:83:0x0274, B:86:0x0285, B:87:0x0288, B:89:0x029f, B:142:0x0490, B:143:0x0493, B:145:0x049d, B:148:0x04ae, B:150:0x04c1, B:152:0x04cd, B:185:0x0595, B:187:0x05a2, B:189:0x05a8, B:191:0x05ae, B:193:0x05be, B:194:0x05c1, B:195:0x05c6, B:197:0x05cc, B:198:0x05d8, B:200:0x05de, B:202:0x05ee, B:204:0x05f8, B:205:0x060d, B:207:0x0613, B:208:0x062e, B:210:0x0634, B:211:0x0652, B:212:0x065b, B:216:0x0680, B:213:0x065f, B:215:0x066d, B:217:0x0688, B:218:0x06a0, B:220:0x06a6, B:222:0x06b9, B:223:0x06c6, B:224:0x06ca, B:226:0x06d0, B:228:0x06de, B:157:0x04eb, B:159:0x04fb, B:162:0x050e, B:164:0x0521, B:166:0x052d, B:168:0x053d, B:170:0x0549, B:172:0x0555, B:174:0x055f, B:177:0x056c, B:179:0x0572, B:181:0x0582, B:182:0x058d, B:98:0x02c5, B:101:0x02cf, B:103:0x02dd, B:108:0x032a, B:104:0x02fb, B:106:0x030c, B:112:0x0338, B:114:0x0364, B:115:0x038e, B:117:0x03c5, B:119:0x03cb, B:122:0x03d7, B:124:0x040e, B:125:0x0429, B:127:0x042f, B:129:0x043d, B:133:0x0451, B:130:0x0445, B:136:0x0458, B:139:0x045f, B:140:0x0477, B:232:0x070a, B:234:0x0718, B:236:0x0721, B:247:0x0753, B:237:0x0729, B:239:0x0732, B:241:0x0738, B:244:0x0744, B:246:0x074e, B:248:0x0756, B:249:0x0762, B:252:0x076a, B:254:0x077c, B:255:0x0787, B:257:0x078f, B:261:0x07b5, B:263:0x07cf, B:265:0x07e4, B:267:0x07fe, B:269:0x0813, B:270:0x0821, B:272:0x0827, B:274:0x0837, B:275:0x083e, B:277:0x084a, B:278:0x0851, B:279:0x0854, B:281:0x0896, B:283:0x089c, B:289:0x08c3, B:291:0x08cb, B:292:0x08d4, B:294:0x08da, B:295:0x08e0, B:297:0x08f5, B:299:0x0905, B:301:0x0915, B:303:0x091d, B:304:0x0920, B:312:0x0994, B:314:0x09ad, B:316:0x09c3, B:318:0x09c8, B:320:0x09cc, B:322:0x09d0, B:324:0x09da, B:325:0x09e0, B:327:0x09e4, B:329:0x09ea, B:330:0x09f8, B:331:0x0a01, B:335:0x0a23, B:338:0x0a29, B:284:0x08aa, B:286:0x08b0, B:288:0x08b6, B:268:0x0810, B:264:0x07e1, B:258:0x0795, B:260:0x079b), top: B:493:0x0011, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x024d A[Catch: all -> 0x0e3a, TryCatch #5 {all -> 0x0e3a, blocks: (B:3:0x0011, B:5:0x0028, B:8:0x0030, B:9:0x0044, B:12:0x005c, B:15:0x0084, B:17:0x00b9, B:20:0x00ca, B:22:0x00d4, B:229:0x06f4, B:25:0x0101, B:28:0x0117, B:30:0x011d, B:32:0x0123, B:34:0x0136, B:38:0x0143, B:40:0x014e, B:42:0x015a, B:44:0x0160, B:48:0x016b, B:49:0x0179, B:51:0x0187, B:54:0x01a7, B:56:0x01ad, B:58:0x01bd, B:60:0x01cb, B:62:0x01db, B:63:0x01e8, B:64:0x01eb, B:66:0x01f8, B:68:0x0202, B:69:0x0212, B:71:0x022f, B:73:0x0239, B:75:0x024d, B:76:0x0257, B:79:0x0262, B:80:0x026c, B:83:0x0274, B:86:0x0285, B:87:0x0288, B:89:0x029f, B:142:0x0490, B:143:0x0493, B:145:0x049d, B:148:0x04ae, B:150:0x04c1, B:152:0x04cd, B:185:0x0595, B:187:0x05a2, B:189:0x05a8, B:191:0x05ae, B:193:0x05be, B:194:0x05c1, B:195:0x05c6, B:197:0x05cc, B:198:0x05d8, B:200:0x05de, B:202:0x05ee, B:204:0x05f8, B:205:0x060d, B:207:0x0613, B:208:0x062e, B:210:0x0634, B:211:0x0652, B:212:0x065b, B:216:0x0680, B:213:0x065f, B:215:0x066d, B:217:0x0688, B:218:0x06a0, B:220:0x06a6, B:222:0x06b9, B:223:0x06c6, B:224:0x06ca, B:226:0x06d0, B:228:0x06de, B:157:0x04eb, B:159:0x04fb, B:162:0x050e, B:164:0x0521, B:166:0x052d, B:168:0x053d, B:170:0x0549, B:172:0x0555, B:174:0x055f, B:177:0x056c, B:179:0x0572, B:181:0x0582, B:182:0x058d, B:98:0x02c5, B:101:0x02cf, B:103:0x02dd, B:108:0x032a, B:104:0x02fb, B:106:0x030c, B:112:0x0338, B:114:0x0364, B:115:0x038e, B:117:0x03c5, B:119:0x03cb, B:122:0x03d7, B:124:0x040e, B:125:0x0429, B:127:0x042f, B:129:0x043d, B:133:0x0451, B:130:0x0445, B:136:0x0458, B:139:0x045f, B:140:0x0477, B:232:0x070a, B:234:0x0718, B:236:0x0721, B:247:0x0753, B:237:0x0729, B:239:0x0732, B:241:0x0738, B:244:0x0744, B:246:0x074e, B:248:0x0756, B:249:0x0762, B:252:0x076a, B:254:0x077c, B:255:0x0787, B:257:0x078f, B:261:0x07b5, B:263:0x07cf, B:265:0x07e4, B:267:0x07fe, B:269:0x0813, B:270:0x0821, B:272:0x0827, B:274:0x0837, B:275:0x083e, B:277:0x084a, B:278:0x0851, B:279:0x0854, B:281:0x0896, B:283:0x089c, B:289:0x08c3, B:291:0x08cb, B:292:0x08d4, B:294:0x08da, B:295:0x08e0, B:297:0x08f5, B:299:0x0905, B:301:0x0915, B:303:0x091d, B:304:0x0920, B:312:0x0994, B:314:0x09ad, B:316:0x09c3, B:318:0x09c8, B:320:0x09cc, B:322:0x09d0, B:324:0x09da, B:325:0x09e0, B:327:0x09e4, B:329:0x09ea, B:330:0x09f8, B:331:0x0a01, B:335:0x0a23, B:338:0x0a29, B:284:0x08aa, B:286:0x08b0, B:288:0x08b6, B:268:0x0810, B:264:0x07e1, B:258:0x0795, B:260:0x079b), top: B:493:0x0011, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0262 A[Catch: all -> 0x0e3a, TryCatch #5 {all -> 0x0e3a, blocks: (B:3:0x0011, B:5:0x0028, B:8:0x0030, B:9:0x0044, B:12:0x005c, B:15:0x0084, B:17:0x00b9, B:20:0x00ca, B:22:0x00d4, B:229:0x06f4, B:25:0x0101, B:28:0x0117, B:30:0x011d, B:32:0x0123, B:34:0x0136, B:38:0x0143, B:40:0x014e, B:42:0x015a, B:44:0x0160, B:48:0x016b, B:49:0x0179, B:51:0x0187, B:54:0x01a7, B:56:0x01ad, B:58:0x01bd, B:60:0x01cb, B:62:0x01db, B:63:0x01e8, B:64:0x01eb, B:66:0x01f8, B:68:0x0202, B:69:0x0212, B:71:0x022f, B:73:0x0239, B:75:0x024d, B:76:0x0257, B:79:0x0262, B:80:0x026c, B:83:0x0274, B:86:0x0285, B:87:0x0288, B:89:0x029f, B:142:0x0490, B:143:0x0493, B:145:0x049d, B:148:0x04ae, B:150:0x04c1, B:152:0x04cd, B:185:0x0595, B:187:0x05a2, B:189:0x05a8, B:191:0x05ae, B:193:0x05be, B:194:0x05c1, B:195:0x05c6, B:197:0x05cc, B:198:0x05d8, B:200:0x05de, B:202:0x05ee, B:204:0x05f8, B:205:0x060d, B:207:0x0613, B:208:0x062e, B:210:0x0634, B:211:0x0652, B:212:0x065b, B:216:0x0680, B:213:0x065f, B:215:0x066d, B:217:0x0688, B:218:0x06a0, B:220:0x06a6, B:222:0x06b9, B:223:0x06c6, B:224:0x06ca, B:226:0x06d0, B:228:0x06de, B:157:0x04eb, B:159:0x04fb, B:162:0x050e, B:164:0x0521, B:166:0x052d, B:168:0x053d, B:170:0x0549, B:172:0x0555, B:174:0x055f, B:177:0x056c, B:179:0x0572, B:181:0x0582, B:182:0x058d, B:98:0x02c5, B:101:0x02cf, B:103:0x02dd, B:108:0x032a, B:104:0x02fb, B:106:0x030c, B:112:0x0338, B:114:0x0364, B:115:0x038e, B:117:0x03c5, B:119:0x03cb, B:122:0x03d7, B:124:0x040e, B:125:0x0429, B:127:0x042f, B:129:0x043d, B:133:0x0451, B:130:0x0445, B:136:0x0458, B:139:0x045f, B:140:0x0477, B:232:0x070a, B:234:0x0718, B:236:0x0721, B:247:0x0753, B:237:0x0729, B:239:0x0732, B:241:0x0738, B:244:0x0744, B:246:0x074e, B:248:0x0756, B:249:0x0762, B:252:0x076a, B:254:0x077c, B:255:0x0787, B:257:0x078f, B:261:0x07b5, B:263:0x07cf, B:265:0x07e4, B:267:0x07fe, B:269:0x0813, B:270:0x0821, B:272:0x0827, B:274:0x0837, B:275:0x083e, B:277:0x084a, B:278:0x0851, B:279:0x0854, B:281:0x0896, B:283:0x089c, B:289:0x08c3, B:291:0x08cb, B:292:0x08d4, B:294:0x08da, B:295:0x08e0, B:297:0x08f5, B:299:0x0905, B:301:0x0915, B:303:0x091d, B:304:0x0920, B:312:0x0994, B:314:0x09ad, B:316:0x09c3, B:318:0x09c8, B:320:0x09cc, B:322:0x09d0, B:324:0x09da, B:325:0x09e0, B:327:0x09e4, B:329:0x09ea, B:330:0x09f8, B:331:0x0a01, B:335:0x0a23, B:338:0x0a29, B:284:0x08aa, B:286:0x08b0, B:288:0x08b6, B:268:0x0810, B:264:0x07e1, B:258:0x0795, B:260:0x079b), top: B:493:0x0011, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x029f A[Catch: all -> 0x0e3a, TRY_LEAVE, TryCatch #5 {all -> 0x0e3a, blocks: (B:3:0x0011, B:5:0x0028, B:8:0x0030, B:9:0x0044, B:12:0x005c, B:15:0x0084, B:17:0x00b9, B:20:0x00ca, B:22:0x00d4, B:229:0x06f4, B:25:0x0101, B:28:0x0117, B:30:0x011d, B:32:0x0123, B:34:0x0136, B:38:0x0143, B:40:0x014e, B:42:0x015a, B:44:0x0160, B:48:0x016b, B:49:0x0179, B:51:0x0187, B:54:0x01a7, B:56:0x01ad, B:58:0x01bd, B:60:0x01cb, B:62:0x01db, B:63:0x01e8, B:64:0x01eb, B:66:0x01f8, B:68:0x0202, B:69:0x0212, B:71:0x022f, B:73:0x0239, B:75:0x024d, B:76:0x0257, B:79:0x0262, B:80:0x026c, B:83:0x0274, B:86:0x0285, B:87:0x0288, B:89:0x029f, B:142:0x0490, B:143:0x0493, B:145:0x049d, B:148:0x04ae, B:150:0x04c1, B:152:0x04cd, B:185:0x0595, B:187:0x05a2, B:189:0x05a8, B:191:0x05ae, B:193:0x05be, B:194:0x05c1, B:195:0x05c6, B:197:0x05cc, B:198:0x05d8, B:200:0x05de, B:202:0x05ee, B:204:0x05f8, B:205:0x060d, B:207:0x0613, B:208:0x062e, B:210:0x0634, B:211:0x0652, B:212:0x065b, B:216:0x0680, B:213:0x065f, B:215:0x066d, B:217:0x0688, B:218:0x06a0, B:220:0x06a6, B:222:0x06b9, B:223:0x06c6, B:224:0x06ca, B:226:0x06d0, B:228:0x06de, B:157:0x04eb, B:159:0x04fb, B:162:0x050e, B:164:0x0521, B:166:0x052d, B:168:0x053d, B:170:0x0549, B:172:0x0555, B:174:0x055f, B:177:0x056c, B:179:0x0572, B:181:0x0582, B:182:0x058d, B:98:0x02c5, B:101:0x02cf, B:103:0x02dd, B:108:0x032a, B:104:0x02fb, B:106:0x030c, B:112:0x0338, B:114:0x0364, B:115:0x038e, B:117:0x03c5, B:119:0x03cb, B:122:0x03d7, B:124:0x040e, B:125:0x0429, B:127:0x042f, B:129:0x043d, B:133:0x0451, B:130:0x0445, B:136:0x0458, B:139:0x045f, B:140:0x0477, B:232:0x070a, B:234:0x0718, B:236:0x0721, B:247:0x0753, B:237:0x0729, B:239:0x0732, B:241:0x0738, B:244:0x0744, B:246:0x074e, B:248:0x0756, B:249:0x0762, B:252:0x076a, B:254:0x077c, B:255:0x0787, B:257:0x078f, B:261:0x07b5, B:263:0x07cf, B:265:0x07e4, B:267:0x07fe, B:269:0x0813, B:270:0x0821, B:272:0x0827, B:274:0x0837, B:275:0x083e, B:277:0x084a, B:278:0x0851, B:279:0x0854, B:281:0x0896, B:283:0x089c, B:289:0x08c3, B:291:0x08cb, B:292:0x08d4, B:294:0x08da, B:295:0x08e0, B:297:0x08f5, B:299:0x0905, B:301:0x0915, B:303:0x091d, B:304:0x0920, B:312:0x0994, B:314:0x09ad, B:316:0x09c3, B:318:0x09c8, B:320:0x09cc, B:322:0x09d0, B:324:0x09da, B:325:0x09e0, B:327:0x09e4, B:329:0x09ea, B:330:0x09f8, B:331:0x0a01, B:335:0x0a23, B:338:0x0a29, B:284:0x08aa, B:286:0x08b0, B:288:0x08b6, B:268:0x0810, B:264:0x07e1, B:258:0x0795, B:260:0x079b), top: B:493:0x0011, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02c2  */
    /* JADX WARN: Type inference failed for: r10v28 */
    /* JADX WARN: Type inference failed for: r10v32 */
    /* JADX WARN: Type inference failed for: r10v33 */
    /* JADX WARN: Type inference failed for: r10v34 */
    /* JADX WARN: Type inference failed for: r10v35 */
    /* JADX WARN: Type inference failed for: r10v36 */
    /* JADX WARN: Type inference failed for: r10v41 */
    /* JADX WARN: Type inference failed for: r10v47 */
    /* JADX WARN: Type inference failed for: r10v51 */
    /* JADX WARN: Type inference failed for: r10v52 */
    /* JADX WARN: Type inference failed for: r10v53 */
    /* JADX WARN: Type inference failed for: r10v54 */
    /* JADX WARN: Type inference failed for: r10v55 */
    /* JADX WARN: Type inference failed for: r10v56 */
    /* JADX WARN: Type inference failed for: r10v57 */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v19 */
    /* JADX WARN: Type inference failed for: r13v20 */
    /* JADX WARN: Type inference failed for: r13v24 */
    /* JADX WARN: Type inference failed for: r13v25 */
    /* JADX WARN: Type inference failed for: r13v26 */
    /* JADX WARN: Type inference failed for: r13v27 */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v18 */
    /* JADX WARN: Type inference failed for: r15v19 */
    /* JADX WARN: Type inference failed for: r15v20 */
    /* JADX WARN: Type inference failed for: r15v21 */
    /* JADX WARN: Type inference failed for: r15v22 */
    /* JADX WARN: Type inference failed for: r15v24 */
    /* JADX WARN: Type inference failed for: r15v25 */
    /* JADX WARN: Type inference failed for: r15v26 */
    /* JADX WARN: Type inference failed for: r18v0, types: [com.google.android.gms.internal.measurement.zzadp, com.google.android.gms.internal.measurement.zzhr] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.google.android.gms.measurement.internal.zzpg] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.google.android.gms.measurement.internal.zzpg] */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r1v45 */
    /* JADX WARN: Type inference failed for: r25v2, types: [com.google.android.gms.internal.measurement.zzadp, com.google.android.gms.internal.measurement.zzhr] */
    /* JADX WARN: Type inference failed for: r29v1 */
    /* JADX WARN: Type inference failed for: r29v2 */
    /* JADX WARN: Type inference failed for: r29v3 */
    /* JADX WARN: Type inference failed for: r29v4 */
    /* JADX WARN: Type inference failed for: r29v5 */
    /* JADX WARN: Type inference failed for: r29v6 */
    /* JADX WARN: Type inference failed for: r29v7 */
    /* JADX WARN: Type inference failed for: r29v8 */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v106 */
    /* JADX WARN: Type inference failed for: r2v157 */
    /* JADX WARN: Type inference failed for: r2v159 */
    /* JADX WARN: Type inference failed for: r2v160 */
    /* JADX WARN: Type inference failed for: r2v162 */
    /* JADX WARN: Type inference failed for: r2v163 */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.google.android.gms.measurement.internal.zzpg] */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.google.android.gms.measurement.internal.zzpg] */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.google.android.gms.measurement.internal.zzpg] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v70 */
    /* JADX WARN: Type inference failed for: r4v109 */
    /* JADX WARN: Type inference failed for: r6v17, types: [com.google.android.gms.internal.measurement.zzic] */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21, types: [com.google.android.gms.internal.measurement.zzic] */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v25, types: [com.google.android.gms.internal.measurement.zzic] */
    /* JADX WARN: Type inference failed for: r6v46 */
    /* JADX WARN: Type inference failed for: r6v47 */
    /* JADX WARN: Type inference failed for: r6v48 */
    /* JADX WARN: Type inference failed for: r6v49 */
    /* JADX WARN: Type inference failed for: r6v50 */
    /* JADX WARN: Type inference failed for: r6v51 */
    /* JADX WARN: Type inference failed for: r6v52 */
    /* JADX WARN: Type inference failed for: r6v53 */
    /* JADX WARN: Type inference failed for: r6v54 */
    /* JADX WARN: Type inference failed for: r6v55 */
    /* JADX WARN: Type inference failed for: r6v56 */
    /* JADX WARN: Type inference failed for: r6v57 */
    /* JADX WARN: Type inference failed for: r6v7, types: [com.google.android.gms.internal.measurement.zzadp, com.google.android.gms.internal.measurement.zzic] */
    /* JADX WARN: Type inference failed for: r7v28, types: [com.google.android.gms.internal.measurement.zzadp, com.google.android.gms.internal.measurement.zzhr] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean zzaH(String str, long j) throws Throwable {
        boolean z;
        ?? r2;
        int i;
        long j2;
        int iZzn;
        long j3;
        zzpc zzpcVar;
        SecureRandom secureRandom;
        int i2;
        long jZzam;
        int i3;
        zzpg zzpgVar;
        boolean z2;
        zzh zzhVarZzu;
        ?? r29;
        int i4;
        String str2;
        ?? r292;
        zzal zzalVarZzd;
        zzfx zzfxVar;
        boolean zZzk;
        String str3;
        ?? r10;
        String str4;
        ?? r102;
        ?? r6;
        int i5;
        int i6;
        ?? r15;
        ?? r13;
        ?? r132;
        ?? r62;
        ?? r63;
        int i7;
        String str5;
        int i8;
        int i9;
        int i10;
        int i11;
        ?? r64;
        ?? r152;
        ?? r133;
        ?? r103;
        ?? r65;
        ?? r1 = this;
        ?? r22 = "_ai";
        String str6 = FirebaseAnalytics.Event.PURCHASE;
        String str7 = FirebaseAnalytics.Param.ITEMS;
        r1.zzj().zzb();
        try {
            zzpc zzpcVar2 = new zzpc(r1, null);
            r1.zzj().zzav(str, j, r1.zzB, zzpcVar2);
            List list = zzpcVar2.zzc;
            try {
                if (list == null || list.isEmpty()) {
                    ?? r23 = r1;
                    r23.zzj().zzc();
                    z = false;
                    r2 = r23;
                } else {
                    com.google.android.gms.internal.measurement.zzic zzicVar = (com.google.android.gms.internal.measurement.zzic) zzpcVar2.zza.zzco();
                    zzicVar.zzi();
                    ?? r134 = 0;
                    ?? r153 = 0;
                    int i12 = -1;
                    int i13 = 0;
                    int i14 = 0;
                    boolean z3 = false;
                    int i15 = -1;
                    boolean z4 = false;
                    ?? r24 = "_ai";
                    ?? r66 = zzicVar;
                    while (true) {
                        i = i14;
                        boolean z5 = z3;
                        ?? r18 = r134;
                        int i16 = i15;
                        if (i13 >= zzpcVar2.zzc.size()) {
                            break;
                        }
                        ?? r7 = (com.google.android.gms.internal.measurement.zzhr) ((com.google.android.gms.internal.measurement.zzhs) zzpcVar2.zzc.get(i13)).zzco();
                        ?? r25 = r153;
                        if (r1.zzh().zzj(zzpcVar2.zza.zzA(), r7.zzk())) {
                            r1.zzaW().zze().zzc("Dropping blocked raw event. appId", zzgu.zzl(zzpcVar2.zza.zzA()), r1.zzn.zzl().zza(r7.zzk()));
                            if (!r1.zzh().zzo(zzpcVar2.zza.zzA()) && !r1.zzh().zzp(zzpcVar2.zza.zzA()) && !"_err".equals(r7.zzk())) {
                                r1.zzt().zzP(r1.zzK, zzpcVar2.zza.zzA(), 11, "_ev", r7.zzk(), 0);
                            }
                            int i17 = i13;
                            str5 = str7;
                            i8 = i17;
                            r103 = r24;
                            str3 = str6;
                            r133 = r18;
                            i15 = i16;
                            r152 = r25;
                            i9 = i;
                            r65 = r66;
                        } else {
                            String strZzk = r7.zzk();
                            int i18 = i13;
                            String str8 = str7;
                            if (strZzk.equals(str6) || strZzk.equals("_iap") || strZzk.equals("ecommerce_purchase")) {
                                r29 = r66;
                                i4 = i12;
                                str2 = "_et";
                            } else {
                                str2 = "_et";
                                ?? r293 = r66;
                                i4 = i12;
                                r292 = r293;
                                if (r1.zzd().zzp(null, zzfy.zzbf)) {
                                    r292 = r293;
                                    if (strZzk.equals(FirebaseAnalytics.Event.IN_APP_PURCHASE)) {
                                        r29 = r293;
                                    }
                                }
                                if (r7.zzk().equals(zzjm.zza(r24))) {
                                    r7.zzl(r24);
                                    r1.zzaW().zzk().zza("Renaming ad_impression to _ai");
                                    if (Log.isLoggable(r1.zzaW().zzn(), 5)) {
                                        for (int i19 = 0; i19 < r7.zzb(); i19++) {
                                            if (FirebaseAnalytics.Param.AD_PLATFORM.equals(r7.zzc(i19).zzb()) && !r7.zzc(i19).zzd().isEmpty() && "admob".equalsIgnoreCase(r7.zzc(i19).zzd())) {
                                                r1.zzaW().zzh().zza("AdMob ad impression logged from app. Potentially duplicative.");
                                            }
                                        }
                                    }
                                }
                                zzalVarZzd = r1.zzd();
                                zzfxVar = zzfy.zzbf;
                                if (zzalVarZzd.zzp(null, zzfxVar) && r7.zzk().equals(FirebaseAnalytics.Event.IN_APP_PURCHASE)) {
                                    r7.zzl("_iap");
                                    r1.zzaW().zzk().zza("Renaming in_app_purchase to _iap");
                                }
                                zZzk = r1.zzh().zzk(zzpcVar2.zza.zzA(), r7.zzk());
                                if (r1.zzd().zzp(null, zzfxVar) && "_iap".equals(r7.zzk())) {
                                    zZzk = r1.zzV(r7);
                                    String strZzA = zzpcVar2.zza.zzA();
                                    if ("_iap".equals(r7.zzk())) {
                                        r1.zzaK(r7, "value", strZzA);
                                        r1.zzaK(r7, FirebaseAnalytics.Param.PRICE, strZzA);
                                    }
                                    if (!"_iap".equals(r7.zzk())) {
                                        ArrayList arrayList = new ArrayList(r7.zza());
                                        int i20 = 0;
                                        while (true) {
                                            if (i20 >= arrayList.size()) {
                                                com.google.android.gms.internal.measurement.zzhv zzhvVarZzn = com.google.android.gms.internal.measurement.zzhw.zzn();
                                                zzhvVarZzn.zzb(FirebaseAnalytics.Param.QUANTITY);
                                                zzhvVarZzn.zzf(1L);
                                                r7.zzf((com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn.zzbd());
                                                break;
                                            }
                                            if (FirebaseAnalytics.Param.QUANTITY.equals(((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i20)).zzb())) {
                                                break;
                                            }
                                            i20++;
                                        }
                                    }
                                }
                                if (zZzk) {
                                    r1.zzp();
                                    String strZzk2 = r7.zzk();
                                    Preconditions.checkNotEmpty(strZzk2);
                                    if (strZzk2.hashCode() == 95027 && strZzk2.equals("_ui")) {
                                        int i21 = 0;
                                        boolean z6 = false;
                                        boolean z7 = false;
                                        ?? r26 = r24;
                                        while (i21 < r7.zzb()) {
                                            if ("_c".equals(r7.zzc(i21).zzb())) {
                                                com.google.android.gms.internal.measurement.zzhv zzhvVar = (com.google.android.gms.internal.measurement.zzhv) r7.zzc(i21).zzco();
                                                r10 = r26;
                                                str4 = str6;
                                                zzhvVar.zzf(1L);
                                                r7.zzd(i21, (com.google.android.gms.internal.measurement.zzhw) zzhvVar.zzbd());
                                                z6 = true;
                                            } else {
                                                r10 = r26;
                                                str4 = str6;
                                                if ("_r".equals(r7.zzc(i21).zzb())) {
                                                    com.google.android.gms.internal.measurement.zzhv zzhvVar2 = (com.google.android.gms.internal.measurement.zzhv) r7.zzc(i21).zzco();
                                                    zzhvVar2.zzf(1L);
                                                    r7.zzd(i21, (com.google.android.gms.internal.measurement.zzhw) zzhvVar2.zzbd());
                                                    z6 = z6;
                                                    z7 = true;
                                                }
                                            }
                                            i21++;
                                            r26 = r10;
                                            str6 = str4;
                                        }
                                        ?? r104 = r26;
                                        str3 = str6;
                                        if (!z6 && zZzk) {
                                            r1.zzaW().zzk().zzb("Marking event as conversion", r1.zzn.zzl().zza(r7.zzk()));
                                            com.google.android.gms.internal.measurement.zzhv zzhvVarZzn2 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                            zzhvVarZzn2.zzb("_c");
                                            zzhvVarZzn2.zzf(1L);
                                            r7.zzg(zzhvVarZzn2);
                                        }
                                        if (!z7) {
                                            r1.zzaW().zzk().zzb("Marking event as real-time", r1.zzn.zzl().zza(r7.zzk()));
                                            com.google.android.gms.internal.measurement.zzhv zzhvVarZzn3 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                            zzhvVarZzn3.zzb("_r");
                                            zzhvVarZzn3.zzf(1L);
                                            r7.zzg(zzhvVarZzn3);
                                        }
                                        if (r1.zzj().zzw(r1.zzC(), zzpcVar2.zza.zzA(), false, false, false, false, true, false, false).zze > r1.zzd().zzm(zzpcVar2.zza.zzA(), zzfy.zzo)) {
                                            zzaC(r7, "_r");
                                        } else {
                                            z4 = true;
                                        }
                                        r102 = r104;
                                        r102 = r104;
                                        if (zzpp.zzh(r7.zzk()) && zZzk) {
                                            r102 = r104;
                                            if (r1.zzj().zzw(r1.zzC(), zzpcVar2.zza.zzA(), false, false, true, false, false, false, false).zzc > r1.zzd().zzm(zzpcVar2.zza.zzA(), zzfy.zzn)) {
                                                r1.zzaW().zze().zzb("Too many conversions. Not logging as conversion. appId", zzgu.zzl(zzpcVar2.zza.zzA()));
                                                boolean z8 = false;
                                                com.google.android.gms.internal.measurement.zzhv zzhvVar3 = null;
                                                int i22 = -1;
                                                for (int i23 = 0; i23 < r7.zzb(); i23++) {
                                                    com.google.android.gms.internal.measurement.zzhw zzhwVarZzc = r7.zzc(i23);
                                                    if ("_c".equals(zzhwVarZzc.zzb())) {
                                                        zzhvVar3 = (com.google.android.gms.internal.measurement.zzhv) zzhwVarZzc.zzco();
                                                        i22 = i23;
                                                    } else if ("_err".equals(zzhwVarZzc.zzb())) {
                                                        z8 = true;
                                                    }
                                                }
                                                if (z8) {
                                                    if (zzhvVar3 != null) {
                                                        r7.zzj(i22);
                                                        r102 = r104;
                                                    } else {
                                                        zzhvVar3 = null;
                                                        if (zzhvVar3 == null) {
                                                        }
                                                    }
                                                } else if (zzhvVar3 == null) {
                                                    com.google.android.gms.internal.measurement.zzhv zzhvVar4 = (com.google.android.gms.internal.measurement.zzhv) zzhvVar3.clone();
                                                    zzhvVar4.zzb("_err");
                                                    zzhvVar4.zzf(10L);
                                                    r7.zzd(i22, (com.google.android.gms.internal.measurement.zzhw) zzhvVar4.zzbd());
                                                    r102 = r104;
                                                } else {
                                                    r1.zzaW().zzb().zzb("Did not find conversion parameter. appId", zzgu.zzl(zzpcVar2.zza.zzA()));
                                                    r102 = r104;
                                                }
                                            }
                                        }
                                    } else {
                                        r102 = r24;
                                        str3 = str6;
                                        zZzk = false;
                                    }
                                    if (zZzk) {
                                        r1.zzV(r7);
                                    }
                                    if ("_e".equals(r7.zzk())) {
                                        r1.zzp();
                                        if (zzpk.zzI((com.google.android.gms.internal.measurement.zzhs) r7.zzbd(), "_fr") == null) {
                                            if (r25 != 0 && Math.abs(r25.zzn() - r7.zzn()) <= 1000) {
                                                com.google.android.gms.internal.measurement.zzhr zzhrVar = (com.google.android.gms.internal.measurement.zzhr) r25.clone();
                                                if (r1.zzaJ(r7, zzhrVar)) {
                                                    ?? r67 = r292;
                                                    i5 = i4;
                                                    r67.zzf(i5, zzhrVar);
                                                    i15 = i16;
                                                    r64 = r67;
                                                    r13 = 0;
                                                    r15 = 0;
                                                    r63 = r64;
                                                }
                                            }
                                            r62 = r292;
                                            i5 = i4;
                                            i15 = i;
                                            r132 = r7;
                                            r15 = r25;
                                            r63 = r62;
                                            r13 = r132;
                                        } else {
                                            r6 = r292;
                                            i5 = i4;
                                            i6 = i16;
                                            i15 = i6;
                                            r132 = r18;
                                            r62 = r6;
                                            r15 = r25;
                                            r63 = r62;
                                            r13 = r132;
                                        }
                                    } else {
                                        r6 = r292;
                                        i5 = i4;
                                        if ("_vs".equals(r7.zzk())) {
                                            r1.zzp();
                                            r6 = r6;
                                            if (zzpk.zzI((com.google.android.gms.internal.measurement.zzhs) r7.zzbd(), str2) == null) {
                                                if (r18 != 0 && Math.abs(r18.zzn() - r7.zzn()) <= 1000) {
                                                    com.google.android.gms.internal.measurement.zzhr zzhrVar2 = (com.google.android.gms.internal.measurement.zzhr) r18.clone();
                                                    if (r1.zzaJ(zzhrVar2, r7)) {
                                                        r6.zzf(i16, zzhrVar2);
                                                        i15 = i16;
                                                        r64 = r6;
                                                        r13 = 0;
                                                        r15 = 0;
                                                        r63 = r64;
                                                    }
                                                }
                                                i5 = i;
                                                i15 = i16;
                                                r15 = r7;
                                                r13 = r18;
                                                r63 = r6;
                                            }
                                            i6 = i16;
                                            i15 = i6;
                                            r132 = r18;
                                            r62 = r6;
                                            r15 = r25;
                                            r63 = r62;
                                            r13 = r132;
                                        } else {
                                            i6 = i16;
                                            if (("_f".equals(r7.zzk()) || "_v".equals(r7.zzk())) && ("_f".equals(r7.zzk()) || "_v".equals(r7.zzk()))) {
                                                int i24 = 0;
                                                while (true) {
                                                    if (i24 >= r7.zzb()) {
                                                        break;
                                                    }
                                                    com.google.android.gms.internal.measurement.zzhw zzhwVarZzc2 = r7.zzc(i24);
                                                    if ("_elt".equals(zzhwVarZzc2.zzb())) {
                                                        r7.zzr(zzhwVarZzc2.zzf());
                                                        r7.zzj(i24);
                                                        break;
                                                    }
                                                    i24++;
                                                }
                                            }
                                            i15 = i6;
                                            r132 = r18;
                                            r62 = r6;
                                            r15 = r25;
                                            r63 = r62;
                                            r13 = r132;
                                        }
                                    }
                                    if (r1.zzd().zzp(null, zzfy.zzbe) && r7.zzu() && !r7.zzs()) {
                                        long jZzE = r1.zzp().zzE(r7.zzv());
                                        if (jZzE != 0) {
                                            r7.zzt(jZzE);
                                        }
                                        r7.zzw(0L);
                                    }
                                    if (r7.zzb() != 0) {
                                        r1.zzp();
                                        Bundle bundleZzH = zzpk.zzH(r7.zza());
                                        int i25 = 0;
                                        while (i25 < r7.zzb()) {
                                            com.google.android.gms.internal.measurement.zzhw zzhwVarZzc3 = r7.zzc(i25);
                                            String str9 = str8;
                                            if (!zzhwVarZzc3.zzb().equals(str9) || zzhwVarZzc3.zzl().isEmpty()) {
                                                i10 = i25;
                                                i11 = i5;
                                                if (!zzhwVarZzc3.zzb().equals(str9)) {
                                                    r1.zzU(r7.zzk(), (com.google.android.gms.internal.measurement.zzhv) zzhwVarZzc3.zzco(), bundleZzH, zzpcVar2.zza.zzA());
                                                }
                                            } else {
                                                String strZzA2 = zzpcVar2.zza.zzA();
                                                List listZzl = zzhwVarZzc3.zzl();
                                                Bundle[] bundleArr = new Bundle[listZzl.size()];
                                                i10 = i25;
                                                i11 = i5;
                                                int i26 = 0;
                                                while (i26 < listZzl.size()) {
                                                    com.google.android.gms.internal.measurement.zzhw zzhwVar = (com.google.android.gms.internal.measurement.zzhw) listZzl.get(i26);
                                                    r1.zzp();
                                                    int i27 = i26;
                                                    Bundle bundleZzH2 = zzpk.zzH(zzhwVar.zzl());
                                                    for (Iterator it = zzhwVar.zzl().iterator(); it.hasNext(); it = it) {
                                                        r1.zzU(r7.zzk(), (com.google.android.gms.internal.measurement.zzhv) ((com.google.android.gms.internal.measurement.zzhw) it.next()).zzco(), bundleZzH2, strZzA2);
                                                        listZzl = listZzl;
                                                    }
                                                    bundleArr[i27] = bundleZzH2;
                                                    i26 = i27 + 1;
                                                    listZzl = listZzl;
                                                }
                                                bundleZzH.putParcelableArray(str9, bundleArr);
                                            }
                                            i25 = i10 + 1;
                                            str8 = str9;
                                            i5 = i11;
                                        }
                                        i7 = i5;
                                        str5 = str8;
                                        r7.zzi();
                                        zzpk zzpkVarZzp = r1.zzp();
                                        ArrayList arrayList2 = new ArrayList();
                                        for (String str10 : bundleZzH.keySet()) {
                                            com.google.android.gms.internal.measurement.zzhv zzhvVarZzn4 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                            zzhvVarZzn4.zzb(str10);
                                            Object obj = bundleZzH.get(str10);
                                            if (obj != null) {
                                                zzpkVarZzp.zzd(zzhvVarZzn4, obj);
                                                arrayList2.add((com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn4.zzbd());
                                            }
                                        }
                                        Iterator it2 = arrayList2.iterator();
                                        while (it2.hasNext()) {
                                            r7.zzf((com.google.android.gms.internal.measurement.zzhw) it2.next());
                                        }
                                    } else {
                                        i7 = i5;
                                        str5 = str8;
                                    }
                                    i8 = i18;
                                    zzpcVar2.zzc.set(i8, (com.google.android.gms.internal.measurement.zzhs) r7.zzbd());
                                    r63.zzg(r7);
                                    i9 = i + 1;
                                    i12 = i7;
                                    r65 = r63;
                                    r103 = r102;
                                    r133 = r13;
                                    r152 = r15;
                                }
                            }
                            com.google.android.gms.internal.measurement.zzhv zzhvVarZzn5 = com.google.android.gms.internal.measurement.zzhw.zzn();
                            zzhvVarZzn5.zzb("_ct");
                            if (!z5) {
                                String strZzA3 = zzpcVar2.zza.zzA();
                                String str11 = (r1.zzaQ(strZzA3, str6) && r1.zzaQ(strZzA3, "_iap") && r1.zzaQ(strZzA3, "ecommerce_purchase")) ? "new" : "returning";
                                zzhvVarZzn5.zzd(str11);
                                r7.zzf((com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn5.zzbd());
                                z5 = true;
                                r292 = r29;
                                if (r7.zzk().equals(zzjm.zza(r24))) {
                                }
                                zzalVarZzd = r1.zzd();
                                zzfxVar = zzfy.zzbf;
                                if (zzalVarZzd.zzp(null, zzfxVar)) {
                                    r7.zzl("_iap");
                                    r1.zzaW().zzk().zza("Renaming in_app_purchase to _iap");
                                }
                                zZzk = r1.zzh().zzk(zzpcVar2.zza.zzA(), r7.zzk());
                                if (r1.zzd().zzp(null, zzfxVar)) {
                                    zZzk = r1.zzV(r7);
                                    String strZzA4 = zzpcVar2.zza.zzA();
                                    if ("_iap".equals(r7.zzk())) {
                                    }
                                    if (!"_iap".equals(r7.zzk())) {
                                    }
                                }
                                if (zZzk) {
                                }
                            }
                        }
                        z3 = z5;
                        int i28 = i8 + 1;
                        ?? r4 = r103;
                        i14 = i9;
                        r24 = r4;
                        str7 = str5;
                        i13 = i28;
                        str6 = str3;
                        r66 = r65;
                        r134 = r133;
                        r153 = r152;
                    }
                    int i29 = i;
                    int i30 = 0;
                    long jLongValue = 0;
                    while (i30 < i29) {
                        com.google.android.gms.internal.measurement.zzhs zzhsVarZzd = r66.zzd(i30);
                        if ("_e".equals(zzhsVarZzd.zzd())) {
                            r1.zzp();
                            if (zzpk.zzI(zzhsVarZzd, "_fr") != null) {
                                r66.zzj(i30);
                                i29--;
                                i30--;
                            } else {
                                r1.zzp();
                                com.google.android.gms.internal.measurement.zzhw zzhwVarZzI = zzpk.zzI(zzhsVarZzd, "_et");
                                if (zzhwVarZzI != null) {
                                    Long lValueOf = zzhwVarZzI.zze() ? Long.valueOf(zzhwVarZzI.zzf()) : null;
                                    if (lValueOf != null && lValueOf.longValue() > 0) {
                                        jLongValue += lValueOf.longValue();
                                    }
                                }
                            }
                        }
                        i30++;
                    }
                    r1.zzaI(r66, jLongValue, false);
                    Iterator it3 = r66.zzb().iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            break;
                        }
                        if ("_s".equals(((com.google.android.gms.internal.measurement.zzhs) it3.next()).zzd())) {
                            r1.zzj().zzk(r66.zzK(), "_se");
                            break;
                        }
                    }
                    if (zzpk.zzx(r66, "_sid") >= 0) {
                        r1.zzaI(r66, jLongValue, true);
                    } else {
                        int iZzx = zzpk.zzx(r66, "_se");
                        if (iZzx >= 0) {
                            r66.zzr(iZzx);
                            r1.zzaW().zzb().zzb("Session engagement user property is in the bundle without session ID. appId", zzgu.zzl(zzpcVar2.zza.zzA()));
                        }
                    }
                    String strZzA5 = zzpcVar2.zza.zzA();
                    r1.zzaX().zzg();
                    r1.zzu();
                    zzh zzhVarZzu2 = r1.zzj().zzu(strZzA5);
                    if (zzhVarZzu2 == null) {
                        r1.zzaW().zzb().zzb("Cannot fix consent fields without appInfo. appId", zzgu.zzl(strZzA5));
                    } else {
                        r1.zzI(zzhVarZzu2, r66);
                    }
                    String strZzA6 = zzpcVar2.zza.zzA();
                    r1.zzaX().zzg();
                    r1.zzu();
                    zzh zzhVarZzu3 = r1.zzj().zzu(strZzA6);
                    if (zzhVarZzu3 == null) {
                        r1.zzaW().zze().zzb("Cannot populate ad_campaign_info without appInfo. appId", zzgu.zzl(strZzA6));
                    } else {
                        r1.zzJ(zzhVarZzu3, r66);
                    }
                    r66.zzv(Long.MAX_VALUE);
                    r66.zzx(Long.MIN_VALUE);
                    for (int i31 = 0; i31 < r66.zzc(); i31++) {
                        com.google.android.gms.internal.measurement.zzhs zzhsVarZzd2 = r66.zzd(i31);
                        if (zzhsVarZzd2.zzf() < r66.zzu()) {
                            r66.zzv(zzhsVarZzd2.zzf());
                        }
                        if (zzhsVarZzd2.zzf() > r66.zzw()) {
                            r66.zzx(zzhsVarZzd2.zzf());
                        }
                    }
                    r66.zzak();
                    zzjl zzjlVar = zzjl.zza;
                    zzjl zzjlVarZzs = r1.zzB(zzpcVar2.zza.zzA()).zzs(zzjl.zzf(zzpcVar2.zza.zzaf(), 100));
                    zzjl zzjlVarZzaf = r1.zzj().zzaf(zzpcVar2.zza.zzA());
                    r1.zzj().zzae(zzpcVar2.zza.zzA(), zzjlVarZzs);
                    zzjk zzjkVar = zzjk.ANALYTICS_STORAGE;
                    if (!zzjlVarZzs.zzo(zzjkVar) && zzjlVarZzaf.zzo(zzjkVar)) {
                        r1.zzj().zzi(zzpcVar2.zza.zzA());
                    } else if (zzjlVarZzs.zzo(zzjkVar) && !zzjlVarZzaf.zzo(zzjkVar)) {
                        r1.zzj().zzj(zzpcVar2.zza.zzA());
                    }
                    zzjk zzjkVar2 = zzjk.AD_STORAGE;
                    if (!zzjlVarZzs.zzo(zzjkVar2)) {
                        r66.zzR();
                        r66.zzU();
                        r66.zzan();
                    }
                    if (!zzjlVarZzs.zzo(zzjkVar)) {
                        r66.zzX();
                        r66.zzav();
                    }
                    zzaif.zza();
                    if (r1.zzd().zzp(zzpcVar2.zza.zzA(), zzfy.zzaO) && r1.zzt().zzZ(zzpcVar2.zza.zzA()) && r1.zzB(zzpcVar2.zza.zzA()).zzo(zzjkVar2) && zzpcVar2.zza.zzak()) {
                        r1.zzT(r66, zzpcVar2);
                    }
                    r66.zzag();
                    r66.zzaf(r1.zzm().zzb(r66.zzK(), r66.zzb(), r66.zzk(), Long.valueOf(r66.zzu()), Long.valueOf(r66.zzw()), !zzjlVarZzs.zzo(zzjkVar)));
                    if (r1.zzd().zzD(zzpcVar2.zza.zzA())) {
                        try {
                            HashMap map = new HashMap();
                            ArrayList arrayList3 = new ArrayList();
                            SecureRandom secureRandomZzf = r1.zzt().zzf();
                            int i32 = 0;
                            r1 = r1;
                            while (i32 < r66.zzc()) {
                                com.google.android.gms.internal.measurement.zzhr zzhrVar3 = (com.google.android.gms.internal.measurement.zzhr) r66.zzd(i32).zzco();
                                if (zzhrVar3.zzk().equals("_ep")) {
                                    r1.zzp();
                                    String str12 = (String) zzpk.zzM((com.google.android.gms.internal.measurement.zzhs) zzhrVar3.zzbd(), "_en");
                                    zzbd zzbdVarZzf = (zzbd) map.get(str12);
                                    if (zzbdVarZzf == null && (zzbdVarZzf = r1.zzj().zzf(zzpcVar2.zza.zzA(), (String) Preconditions.checkNotNull(str12))) != null) {
                                        map.put(str12, zzbdVarZzf);
                                    }
                                    if (zzbdVarZzf != null && zzbdVarZzf.zzi == null) {
                                        Long l = zzbdVarZzf.zzj;
                                        if (l != null && l.longValue() > 1) {
                                            r1.zzp();
                                            zzpk.zzF(zzhrVar3, "_sr", l);
                                        }
                                        Boolean bool = zzbdVarZzf.zzk;
                                        if (bool != null && bool.booleanValue()) {
                                            r1.zzp();
                                            zzpk.zzF(zzhrVar3, "_efs", 1L);
                                        }
                                        arrayList3.add((com.google.android.gms.internal.measurement.zzhs) zzhrVar3.zzbd());
                                    }
                                    r66.zzf(i32, zzhrVar3);
                                } else {
                                    zzht zzhtVarZzh = r1.zzh();
                                    String strZzA7 = zzpcVar2.zza.zzA();
                                    String strZza = zzhtVarZzh.zza(strZzA7, "measurement.account.time_zone_offset_minutes");
                                    if (TextUtils.isEmpty(strZza)) {
                                        j2 = 0;
                                        long jZzam2 = r1.zzt().zzam(zzhrVar3.zzn(), j2);
                                        com.google.android.gms.internal.measurement.zzhs zzhsVar = (com.google.android.gms.internal.measurement.zzhs) zzhrVar3.zzbd();
                                        Long l2 = 1L;
                                        if (TextUtils.isEmpty("_dbg")) {
                                        }
                                    } else {
                                        try {
                                            j2 = Long.parseLong(strZza);
                                        } catch (NumberFormatException e) {
                                            zzhtVarZzh.zzu.zzaW().zze().zzc("Unable to parse timezone offset. appId", zzgu.zzl(strZzA7), e);
                                            j2 = 0;
                                        }
                                        long jZzam22 = r1.zzt().zzam(zzhrVar3.zzn(), j2);
                                        com.google.android.gms.internal.measurement.zzhs zzhsVar2 = (com.google.android.gms.internal.measurement.zzhs) zzhrVar3.zzbd();
                                        Long l22 = 1L;
                                        if (TextUtils.isEmpty("_dbg")) {
                                            Iterator it4 = zzhsVar2.zza().iterator();
                                            while (true) {
                                                if (!it4.hasNext()) {
                                                    break;
                                                }
                                                com.google.android.gms.internal.measurement.zzhw zzhwVar2 = (com.google.android.gms.internal.measurement.zzhw) it4.next();
                                                if ("_dbg".equals(zzhwVar2.zzb())) {
                                                    if (l22.equals(Long.valueOf(zzhwVar2.zzf()))) {
                                                        iZzn = 1;
                                                    }
                                                }
                                            }
                                            iZzn = zzh().zzn(zzpcVar2.zza.zzA(), zzhrVar3.zzk());
                                            if (iZzn > 0) {
                                                zzaW().zze().zzc("Sample rate must be positive. event, rate", zzhrVar3.zzk(), Integer.valueOf(iZzn));
                                                arrayList3.add((com.google.android.gms.internal.measurement.zzhs) zzhrVar3.zzbd());
                                                r66.zzf(i32, zzhrVar3);
                                            } else {
                                                zzbd zzbdVarZzc = (zzbd) map.get(zzhrVar3.zzk());
                                                if (zzbdVarZzc == null && (zzbdVarZzc = zzj().zzf(zzpcVar2.zza.zzA(), zzhrVar3.zzk())) == null) {
                                                    j3 = j2;
                                                    zzaW().zze().zzc("Event being bundled has no eventAggregate. appId, eventName", zzpcVar2.zza.zzA(), zzhrVar3.zzk());
                                                    zzbdVarZzc = new zzbd(zzpcVar2.zza.zzA(), zzhrVar3.zzk(), 1L, 1L, 1L, zzhrVar3.zzn(), 0L, null, null, null, null);
                                                } else {
                                                    j3 = j2;
                                                }
                                                zzp();
                                                Long l3 = (Long) zzpk.zzM((com.google.android.gms.internal.measurement.zzhs) zzhrVar3.zzbd(), "_eid");
                                                Boolean boolValueOf = Boolean.valueOf(l3 != null);
                                                if (iZzn == 1) {
                                                    arrayList3.add((com.google.android.gms.internal.measurement.zzhs) zzhrVar3.zzbd());
                                                    if (boolValueOf.booleanValue() && (zzbdVarZzc.zzi != null || zzbdVarZzc.zzj != null || zzbdVarZzc.zzk != null)) {
                                                        map.put(zzhrVar3.zzk(), zzbdVarZzc.zzc(null, null, null));
                                                    }
                                                    r66.zzf(i32, zzhrVar3);
                                                } else {
                                                    if (secureRandomZzf.nextInt(iZzn) == 0) {
                                                        zzp();
                                                        Long lValueOf2 = Long.valueOf(iZzn);
                                                        zzpk.zzF(zzhrVar3, "_sr", lValueOf2);
                                                        arrayList3.add((com.google.android.gms.internal.measurement.zzhs) zzhrVar3.zzbd());
                                                        if (boolValueOf.booleanValue()) {
                                                            zzbdVarZzc = zzbdVarZzc.zzc(null, lValueOf2, null);
                                                        }
                                                        map.put(zzhrVar3.zzk(), zzbdVarZzc.zzb(zzhrVar3.zzn(), jZzam22));
                                                        secureRandom = secureRandomZzf;
                                                        i3 = i32;
                                                        zzpcVar = zzpcVar2;
                                                    } else {
                                                        Long l4 = zzbdVarZzc.zzh;
                                                        if (l4 != null) {
                                                            jZzam = l4.longValue();
                                                            secureRandom = secureRandomZzf;
                                                            i2 = i32;
                                                            zzpcVar = zzpcVar2;
                                                        } else {
                                                            zzpcVar = zzpcVar2;
                                                            secureRandom = secureRandomZzf;
                                                            i2 = i32;
                                                            jZzam = zzt().zzam(zzhrVar3.zzp(), j3);
                                                        }
                                                        if (jZzam != jZzam22) {
                                                            zzp();
                                                            zzpk.zzF(zzhrVar3, "_efs", 1L);
                                                            zzp();
                                                            Long lValueOf3 = Long.valueOf(iZzn);
                                                            zzpk.zzF(zzhrVar3, "_sr", lValueOf3);
                                                            arrayList3.add((com.google.android.gms.internal.measurement.zzhs) zzhrVar3.zzbd());
                                                            if (boolValueOf.booleanValue()) {
                                                                zzbdVarZzc = zzbdVarZzc.zzc(null, lValueOf3, true);
                                                            }
                                                            map.put(zzhrVar3.zzk(), zzbdVarZzc.zzb(zzhrVar3.zzn(), jZzam22));
                                                            i3 = i2;
                                                        } else {
                                                            if (boolValueOf.booleanValue()) {
                                                                map.put(zzhrVar3.zzk(), zzbdVarZzc.zzc(l3, null, null));
                                                            }
                                                            i3 = i2;
                                                        }
                                                    }
                                                    r66.zzf(i3, zzhrVar3);
                                                }
                                            }
                                        } else {
                                            iZzn = zzh().zzn(zzpcVar2.zza.zzA(), zzhrVar3.zzk());
                                            if (iZzn > 0) {
                                            }
                                        }
                                    }
                                    i32 = i3 + 1;
                                    r1 = this;
                                    secureRandomZzf = secureRandom;
                                    zzpcVar2 = zzpcVar;
                                }
                                secureRandom = secureRandomZzf;
                                i3 = i32;
                                zzpcVar = zzpcVar2;
                                i32 = i3 + 1;
                                r1 = this;
                                secureRandomZzf = secureRandom;
                                zzpcVar2 = zzpcVar;
                            }
                            zzpc zzpcVar3 = zzpcVar2;
                            if (arrayList3.size() < r66.zzc()) {
                                r66.zzi();
                                r66.zzh(arrayList3);
                            }
                            Iterator it5 = map.entrySet().iterator();
                            while (it5.hasNext()) {
                                zzj().zzh((zzbd) ((Map.Entry) it5.next()).getValue());
                            }
                            zzpcVar2 = zzpcVar3;
                        } catch (Throwable th) {
                            th = th;
                            r22 = this;
                            r22.zzj().zzd();
                            throw th;
                        }
                    }
                    String strZzA8 = zzpcVar2.zza.zzA();
                    zzh zzhVarZzu4 = zzj().zzu(strZzA8);
                    if (zzhVarZzu4 == null) {
                        zzaW().zzb().zzb("Bundling raw events w/o app info. appId", zzgu.zzl(zzpcVar2.zza.zzA()));
                    } else if (r66.zzc() > 0) {
                        long jZzp = zzhVarZzu4.zzp();
                        if (jZzp != 0) {
                            r66.zzA(jZzp);
                        } else {
                            r66.zzB();
                        }
                        long jZzn = zzhVarZzu4.zzn();
                        if (jZzn != 0) {
                            jZzp = jZzn;
                        }
                        if (jZzp != 0) {
                            r66.zzy(jZzp);
                        } else {
                            r66.zzz();
                        }
                        zzhVarZzu4.zzM(r66.zzc());
                        r66.zzaJ((int) zzhVarZzu4.zzaF());
                        r66.zzZ((int) zzhVarZzu4.zzG());
                        zzhVarZzu4.zzo(r66.zzu());
                        zzhVarZzu4.zzq(r66.zzw());
                        String strZzaa = zzhVarZzu4.zzaa();
                        if (strZzaa != null) {
                            r66.zzaa(strZzaa);
                        } else {
                            r66.zzab();
                        }
                        zzj().zzv(zzhVarZzu4, false, false);
                    }
                    if (r66.zzc() > 0) {
                        zzpg zzpgVar2 = this;
                        zzpgVar2.zzn.zzaV();
                        if (zzpgVar2.zzd().zzp(zzpcVar2.zza.zzA(), zzfy.zzbj)) {
                            String strZzK = r66.zzK();
                            if (!TextUtils.isEmpty(strZzK) && (zzhVarZzu = zzpgVar2.zzj().zzu(strZzK)) != null) {
                                long jCurrentTimeMillis = zzpgVar2.zzba().currentTimeMillis();
                                if (jCurrentTimeMillis - zzhVarZzu.zzaN() >= zzpgVar2.zzd().zzl(strZzK, zzfy.zzaB)) {
                                    List listZzac = zzpgVar2.zzj().zzac("");
                                    if (!listZzac.isEmpty()) {
                                        r66.zzaR(listZzac);
                                    }
                                    List listZzac2 = zzpgVar2.zzj().zzac(strZzK);
                                    if (!listZzac2.isEmpty()) {
                                        r66.zzaR(listZzac2);
                                    }
                                    zzhVarZzu.zzaM(jCurrentTimeMillis);
                                    zzpgVar2.zzj().zzv(zzhVarZzu, false, false);
                                }
                            }
                        }
                        com.google.android.gms.internal.measurement.zzgl zzglVarZzb = zzpgVar2.zzh().zzb(zzpcVar2.zza.zzA());
                        if (zzglVarZzb != null && zzglVarZzb.zza()) {
                            r66.zzal(zzglVarZzb.zzb());
                        } else if (zzpcVar2.zza.zzP().isEmpty()) {
                            r66.zzal(-1L);
                        } else {
                            zzpgVar2.zzaW().zze().zzb("Did not find measurement config or missing version info. appId", zzgu.zzl(zzpcVar2.zza.zzA()));
                        }
                        zzpgVar2.zzj().zzz((com.google.android.gms.internal.measurement.zzid) r66.zzbd(), z4);
                        zzpgVar = zzpgVar2;
                    } else {
                        zzpgVar = this;
                    }
                    zzpgVar.zzj().zzS(zzpcVar2.zzb);
                    zzaw zzawVarZzj = zzpgVar.zzj();
                    SQLiteDatabase sQLiteDatabaseZze = zzawVarZzj.zze();
                    try {
                        String[] strArr = new String[2];
                        strArr[0] = strZzA8;
                        z2 = true;
                        try {
                            strArr[1] = strZzA8;
                            sQLiteDatabaseZze.execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", strArr);
                        } catch (SQLiteException e2) {
                            e = e2;
                            zzawVarZzj.zzu.zzaW().zzb().zzc("Failed to remove unused event metadata. appId", zzgu.zzl(strZzA8), e);
                        }
                    } catch (SQLiteException e3) {
                        e = e3;
                        z2 = true;
                    }
                    zzpgVar.zzj().zzc();
                    z = z2;
                    r2 = zzpgVar;
                }
                r2.zzj().zzd();
                return z;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            r22 = r1;
            r22.zzj().zzd();
            throw th;
        }
    }

    private final void zzaI(com.google.android.gms.internal.measurement.zzic zzicVar, long j, boolean z) {
        Object obj;
        String str = true != z ? "_lte" : "_se";
        zzpn zzpnVarZzm = zzj().zzm(zzicVar.zzK(), str);
        zzpn zzpnVar = (zzpnVarZzm == null || (obj = zzpnVarZzm.zze) == null) ? new zzpn(zzicVar.zzK(), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, str, zzba().currentTimeMillis(), Long.valueOf(j)) : new zzpn(zzicVar.zzK(), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, str, zzba().currentTimeMillis(), Long.valueOf(((Long) obj).longValue() + j));
        com.google.android.gms.internal.measurement.zzit zzitVarZzm = com.google.android.gms.internal.measurement.zziu.zzm();
        zzitVarZzm.zzb(str);
        zzitVarZzm.zza(zzba().currentTimeMillis());
        Object obj2 = zzpnVar.zze;
        zzitVarZzm.zze(((Long) obj2).longValue());
        com.google.android.gms.internal.measurement.zziu zziuVar = (com.google.android.gms.internal.measurement.zziu) zzitVarZzm.zzbd();
        int iZzx = zzpk.zzx(zzicVar, str);
        if (iZzx >= 0) {
            zzicVar.zzn(iZzx, zziuVar);
        } else {
            zzicVar.zzo(zziuVar);
        }
        if (j > 0) {
            zzj().zzl(zzpnVar);
            zzaW().zzk().zzc("Updated engagement user property. scope, value", true != z ? "lifetime" : "session-scoped", obj2);
        }
    }

    private final boolean zzaJ(com.google.android.gms.internal.measurement.zzhr zzhrVar, com.google.android.gms.internal.measurement.zzhr zzhrVar2) {
        Preconditions.checkArgument("_e".equals(zzhrVar.zzk()));
        zzp();
        com.google.android.gms.internal.measurement.zzhw zzhwVarZzI = zzpk.zzI((com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbd(), "_sc");
        String strZzd = zzhwVarZzI == null ? null : zzhwVarZzI.zzd();
        zzp();
        com.google.android.gms.internal.measurement.zzhw zzhwVarZzI2 = zzpk.zzI((com.google.android.gms.internal.measurement.zzhs) zzhrVar2.zzbd(), "_pc");
        String strZzd2 = zzhwVarZzI2 != null ? zzhwVarZzI2.zzd() : null;
        if (strZzd2 == null || !strZzd2.equals(strZzd)) {
            return false;
        }
        Preconditions.checkArgument("_e".equals(zzhrVar.zzk()));
        zzp();
        com.google.android.gms.internal.measurement.zzhw zzhwVarZzI3 = zzpk.zzI((com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbd(), "_et");
        if (zzhwVarZzI3 == null || !zzhwVarZzI3.zze() || zzhwVarZzI3.zzf() <= 0) {
            return true;
        }
        long jZzf = zzhwVarZzI3.zzf();
        zzp();
        com.google.android.gms.internal.measurement.zzhw zzhwVarZzI4 = zzpk.zzI((com.google.android.gms.internal.measurement.zzhs) zzhrVar2.zzbd(), "_et");
        if (zzhwVarZzI4 != null && zzhwVarZzI4.zzf() > 0) {
            jZzf += zzhwVarZzI4.zzf();
        }
        zzp();
        zzpk.zzF(zzhrVar2, "_et", Long.valueOf(jZzf));
        zzp();
        zzpk.zzF(zzhrVar, "_fr", 1L);
        return true;
    }

    private final void zzaK(com.google.android.gms.internal.measurement.zzhr zzhrVar, String str, String str2) {
        ArrayList arrayList = new ArrayList(zzhrVar.zza());
        int i = 0;
        while (true) {
            if (i >= arrayList.size()) {
                i = -1;
                break;
            } else if (str.equals(((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i)).zzb())) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return;
        }
        double dZzk = zzhrVar.zzc(i).zzk() * 1000000.0d;
        if (dZzk == AudioStats.AUDIO_AMPLITUDE_NONE) {
            dZzk = zzhrVar.zzc(i).zzf() * 1000000.0d;
        }
        if (dZzk > 9.223372036854776E18d || dZzk < -9.223372036854776E18d) {
            zzaW().zze().zzc("Data lost. Purchase " + str + " is too big. appId", zzgu.zzl(str2), Double.valueOf(dZzk));
            return;
        }
        zzhrVar.zzj(i);
        com.google.android.gms.internal.measurement.zzhv zzhvVarZzn = com.google.android.gms.internal.measurement.zzhw.zzn();
        zzhvVarZzn.zzb(str);
        zzhvVarZzn.zzf(Math.round(dZzk));
        zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn.zzbd());
    }

    private final boolean zzaL() {
        zzaX().zzg();
        zzu();
        return zzj().zzP() || !TextUtils.isEmpty(zzj().zzF());
    }

    private final void zzaM() {
        long jMax;
        long jMax2;
        zzaX().zzg();
        zzu();
        if (this.zza > 0) {
            long jAbs = DurationKt.MILLIS_IN_HOUR - Math.abs(zzba().elapsedRealtime() - this.zza);
            if (jAbs > 0) {
                zzaW().zzk().zzb("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(jAbs));
                zzk().zzb();
                zzl().zzf();
                return;
            }
            this.zza = 0L;
        }
        if (!this.zzn.zzH() || !zzaL()) {
            zzaW().zzk().zza("Nothing to upload or uploading impossible");
            zzk().zzb();
            zzl().zzf();
            return;
        }
        long jCurrentTimeMillis = zzba().currentTimeMillis();
        zzd();
        long jMax3 = Math.max(0L, ((Long) zzfy.zzO.zzb(null)).longValue());
        boolean z = true;
        if (!zzj().zzR() && !zzj().zzG()) {
            z = false;
        }
        if (z) {
            String strZzA = zzd().zzA();
            if (TextUtils.isEmpty(strZzA) || ".none.".equals(strZzA)) {
                zzd();
                jMax = Math.max(0L, ((Long) zzfy.zzI.zzb(null)).longValue());
            } else {
                zzd();
                jMax = Math.max(0L, ((Long) zzfy.zzJ.zzb(null)).longValue());
            }
        } else {
            zzd();
            jMax = Math.max(0L, ((Long) zzfy.zzH.zzb(null)).longValue());
        }
        long jZza = this.zzk.zzd.zza();
        long jZza2 = this.zzk.zze.zza();
        long j = 0;
        boolean z2 = z;
        long jMax4 = Math.max(zzj().zzM(), zzj().zzO());
        if (jMax4 == 0) {
            jMax2 = 0;
        } else {
            long jAbs2 = jCurrentTimeMillis - Math.abs(jMax4 - jCurrentTimeMillis);
            long jAbs3 = jCurrentTimeMillis - Math.abs(jZza - jCurrentTimeMillis);
            long jAbs4 = jCurrentTimeMillis - Math.abs(jZza2 - jCurrentTimeMillis);
            jMax2 = jMax3 + jAbs2;
            long jMax5 = Math.max(jAbs3, jAbs4);
            if (z2 && jMax5 > 0) {
                jMax2 = Math.min(jAbs2, jMax5) + jMax;
            }
            if (!zzp().zzs(jMax5, jMax)) {
                jMax2 = jMax5 + jMax;
            }
            if (jAbs4 != 0 && jAbs4 >= jAbs2) {
                int i = 0;
                while (true) {
                    zzd();
                    if (i >= Math.min(20, Math.max(0, ((Integer) zzfy.zzQ.zzb(null)).intValue()))) {
                        jMax2 = 0;
                        break;
                    }
                    zzd();
                    jMax2 += Math.max(j, ((Long) zzfy.zzP.zzb(null)).longValue()) * (1 << i);
                    if (jMax2 > jAbs4) {
                        break;
                    }
                    i++;
                    j = 0;
                }
            }
            j = 0;
        }
        if (jMax2 == j) {
            zzaW().zzk().zza("Next upload time is 0");
            zzk().zzb();
            zzl().zzf();
            return;
        }
        if (!zzi().zzb()) {
            zzaW().zzk().zza("No network");
            zzk().zza();
            zzl().zzf();
            return;
        }
        long jZza3 = this.zzk.zzc.zza();
        zzd();
        long jMax6 = Math.max(0L, ((Long) zzfy.zzF.zzb(null)).longValue());
        if (!zzp().zzs(jZza3, jMax6)) {
            jMax2 = Math.max(jMax2, jZza3 + jMax6);
        }
        zzk().zzb();
        long jCurrentTimeMillis2 = jMax2 - zzba().currentTimeMillis();
        if (jCurrentTimeMillis2 <= 0) {
            zzd();
            jCurrentTimeMillis2 = Math.max(0L, ((Long) zzfy.zzK.zzb(null)).longValue());
            this.zzk.zzd.zzb(zzba().currentTimeMillis());
        }
        zzaW().zzk().zzb("Upload scheduled in approximately ms", Long.valueOf(jCurrentTimeMillis2));
        zzl().zzd(jCurrentTimeMillis2);
    }

    private final void zzaN() {
        zzaX().zzg();
        if (this.zzu || this.zzv || this.zzw) {
            zzaW().zzk().zzd("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzu), Boolean.valueOf(this.zzv), Boolean.valueOf(this.zzw));
            return;
        }
        zzaW().zzk().zza("Stopping uploading service(s)");
        List list = this.zzq;
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        ((List) Preconditions.checkNotNull(this.zzq)).clear();
    }

    private final Boolean zzaO(zzh zzhVar) {
        try {
            long jZzt = zzhVar.zzt();
            zzic zzicVar = this.zzn;
            if (jZzt != SieveCacheKt.NodeMetaAndPreviousMask) {
                if (zzhVar.zzt() == Wrappers.packageManager(zzicVar.zzaZ()).getPackageInfo(zzhVar.zzc(), 0).versionCode) {
                    return true;
                }
            } else {
                String str = Wrappers.packageManager(zzicVar.zzaZ()).getPackageInfo(zzhVar.zzc(), 0).versionName;
                String strZzr = zzhVar.zzr();
                if (strZzr != null && strZzr.equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private final zzr zzaP(String str) {
        zzh zzhVarZzu = zzj().zzu(str);
        if (zzhVarZzu == null || TextUtils.isEmpty(zzhVarZzu.zzr())) {
            zzaW().zzj().zzb("No app data available; dropping", str);
            return null;
        }
        Boolean boolZzaO = zzaO(zzhVarZzu);
        if (boolZzaO == null || boolZzaO.booleanValue()) {
            return new zzr(str, zzhVarZzu.zzf(), zzhVarZzu.zzr(), zzhVarZzu.zzt(), zzhVarZzu.zzv(), zzhVarZzu.zzx(), zzhVarZzu.zzz(), (String) null, zzhVarZzu.zzD(), false, zzhVarZzu.zzl(), 0L, 0, zzhVarZzu.zzac(), false, zzhVarZzu.zzae(), zzhVarZzu.zzB(), zzhVarZzu.zzag(), zzB(str).zzl(), "", (String) null, zzhVarZzu.zzai(), zzhVarZzu.zzak(), zzB(str).zzb(), zzx(str).zze(), zzhVarZzu.zzao(), zzhVarZzu.zzaw(), zzhVarZzu.zzay(), zzhVarZzu.zzaH(), 0L, zzhVarZzu.zzaL(), 0L);
        }
        zzaW().zzb().zzb("App version does not match; dropping. appId", zzgu.zzl(str));
        return null;
    }

    private final boolean zzaQ(String str, String str2) {
        zzbd zzbdVarZzf = zzj().zzf(str, str2);
        return zzbdVarZzf == null || zzbdVarZzf.zzc < 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzaR(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT < 34) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, null, BroadcastOptions.makeBasic().setShareIdentityEnabled(true).toBundle());
        }
    }

    private static final boolean zzaS(zzr zzrVar) {
        return !TextUtils.isEmpty(zzrVar.zzb);
    }

    private static final zzos zzaT(zzos zzosVar) {
        if (zzosVar == null) {
            throw new IllegalStateException("Upload Component not created");
        }
        if (zzosVar.zzax()) {
            return zzosVar;
        }
        String strValueOf = String.valueOf(zzosVar.getClass());
        String.valueOf(strValueOf);
        throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(strValueOf)));
    }

    private static final Boolean zzaU(zzr zzrVar) {
        Boolean bool = zzrVar.zzp;
        String str = zzrVar.zzC;
        if (!TextUtils.isEmpty(str)) {
            zzji zzjiVarZza = zze.zzc(str).zza();
            zzji zzjiVar = zzji.UNINITIALIZED;
            int iOrdinal = zzjiVarZza.ordinal();
            if (iOrdinal == 0 || iOrdinal == 1) {
                return null;
            }
            if (iOrdinal == 2) {
                return true;
            }
            if (iOrdinal == 3) {
                return false;
            }
        }
        return bool;
    }

    final void zzA(String str, zzjl zzjlVar) {
        zzaX().zzg();
        zzu();
        this.zzC.put(str, zzjlVar);
        zzj().zzaa(str, zzjlVar);
    }

    final zzjl zzB(String str) {
        zzjl zzjlVar = zzjl.zza;
        zzaX().zzg();
        zzu();
        zzjl zzjlVarZzY = (zzjl) this.zzC.get(str);
        if (zzjlVarZzY == null) {
            zzjlVarZzY = zzj().zzY(str);
            if (zzjlVarZzY == null) {
                zzjlVarZzY = zzjl.zza;
            }
            zzA(str, zzjlVarZzY);
        }
        return zzjlVarZzY;
    }

    final long zzC() {
        long jCurrentTimeMillis = zzba().currentTimeMillis();
        zznn zznnVar = this.zzk;
        zznnVar.zzay();
        zznnVar.zzg();
        zzhe zzheVar = zznnVar.zzf;
        long jZza = zzheVar.zza();
        if (jZza == 0) {
            jZza = ((long) zznnVar.zzu.zzk().zzf().nextInt(86400000)) + 1;
            zzheVar.zzb(jZza);
        }
        return ((((jCurrentTimeMillis + jZza) / 1000) / 60) / 60) / 24;
    }

    final void zzD(zzbh zzbhVar, String str) {
        zzh zzhVarZzu = zzj().zzu(str);
        if (zzhVarZzu == null || TextUtils.isEmpty(zzhVarZzu.zzr())) {
            zzaW().zzj().zzb("No app data available; dropping event", str);
            return;
        }
        Boolean boolZzaO = zzaO(zzhVarZzu);
        if (boolZzaO == null) {
            if (!"_ui".equals(zzbhVar.zza)) {
                zzaW().zze().zzb("Could not find package. appId", zzgu.zzl(str));
            }
        } else if (!boolZzaO.booleanValue()) {
            zzaW().zzb().zzb("App version does not match; dropping event. appId", zzgu.zzl(str));
            return;
        }
        zzE(zzbhVar, new zzr(str, zzhVarZzu.zzf(), zzhVarZzu.zzr(), zzhVarZzu.zzt(), zzhVarZzu.zzv(), zzhVarZzu.zzx(), zzhVarZzu.zzz(), (String) null, zzhVarZzu.zzD(), false, zzhVarZzu.zzl(), 0L, 0, zzhVarZzu.zzac(), false, zzhVarZzu.zzae(), zzhVarZzu.zzB(), zzhVarZzu.zzag(), zzB(str).zzl(), "", (String) null, zzhVarZzu.zzai(), zzhVarZzu.zzak(), zzB(str).zzb(), zzx(str).zze(), zzhVarZzu.zzao(), zzhVarZzu.zzaw(), zzhVarZzu.zzay(), zzhVarZzu.zzaH(), 0L, zzhVarZzu.zzaL(), 0L));
    }

    final void zzE(zzbh zzbhVar, zzr zzrVar) {
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        zzgv zzgvVarZza = zzgv.zza(zzbhVar);
        zzt().zzK(zzgvVarZza.zze, zzj().zzV(str));
        zzt().zzI(zzgvVarZza, zzd().zzd(str));
        zzbh zzbhVarZzb = zzgvVarZza.zzb();
        if (!zzd().zzp(null, zzfy.zzaZ) && Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(zzbhVarZzb.zza)) {
            zzbf zzbfVar = zzbhVarZzb.zzb;
            if ("referrer API v2".equals(zzbfVar.zzd("_cis"))) {
                String strZzd = zzbfVar.zzd("gclid");
                if (!TextUtils.isEmpty(strZzd)) {
                    zzad(new zzpl("_lgclid", zzbhVarZzb.zzd, strZzd, DebugKt.DEBUG_PROPERTY_VALUE_AUTO), zzrVar);
                }
            }
        }
        zzF(zzbhVarZzb, zzrVar);
    }

    final void zzF(zzbh zzbhVar, zzr zzrVar) {
        char c;
        List listZzt;
        List listZzt2;
        List<zzah> listZzt3;
        String str;
        Preconditions.checkNotNull(zzrVar);
        String str2 = zzrVar.zza;
        Preconditions.checkNotEmpty(str2);
        zzaX().zzg();
        zzu();
        long j = zzbhVar.zzd;
        long j2 = zzbhVar.zze;
        zzgv zzgvVarZza = zzgv.zza(zzbhVar);
        zzaX().zzg();
        zzlu zzluVar = this.zzG;
        if (zzluVar == null || (str = this.zzH) == null || !str.equals(str2)) {
            zzluVar = null;
        }
        zzpp.zzay(zzluVar, zzgvVarZza.zze, false);
        zzbh zzbhVarZzb = zzgvVarZza.zzb();
        zzp();
        if (zzpk.zzG(zzbhVarZzb, zzrVar)) {
            if (!zzrVar.zzh) {
                zzap(zzrVar);
                return;
            }
            List list = zzrVar.zzr;
            if (list != null) {
                String str3 = zzbhVarZzb.zza;
                if (!list.contains(str3)) {
                    zzaW().zzj().zzd("Dropping non-safelisted event. appId, event name, origin", str2, str3, zzbhVarZzb.zzc);
                    return;
                }
                Bundle bundleZzf = zzbhVarZzb.zzb.zzf();
                c = 0;
                bundleZzf.putLong("ga_safelisted", 1L);
                zzbhVarZzb = new zzbh(str3, new zzbf(bundleZzf), zzbhVarZzb.zzc, zzbhVarZzb.zzd, zzbhVarZzb.zze);
            } else {
                c = 0;
            }
            zzj().zzb();
            try {
                String str4 = zzbhVarZzb.zza;
                if ("_s".equals(str4) && !zzj().zzQ(str2, "_s") && zzbhVarZzb.zzb.zzb("_sid").longValue() != 0) {
                    if (zzj().zzQ(str2, "_f") || zzj().zzQ(str2, "_v")) {
                        zzj().zzX(str2, null, "_sid", zzG(str2, zzbhVarZzb));
                    } else {
                        zzj().zzX(str2, Long.valueOf(zzba().currentTimeMillis() - 15000), "_sid", zzG(str2, zzbhVarZzb));
                    }
                }
                zzaw zzawVarZzj = zzj();
                Preconditions.checkNotEmpty(str2);
                zzawVarZzj.zzg();
                zzawVarZzj.zzay();
                int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                boolean z = true;
                if (i < 0) {
                    zzawVarZzj.zzu.zzaW().zze().zzc("Invalid time querying timed out conditional properties", zzgu.zzl(str2), Long.valueOf(j));
                    listZzt = Collections.emptyList();
                } else {
                    String[] strArr = new String[2];
                    strArr[c] = str2;
                    strArr[1] = String.valueOf(j);
                    listZzt = zzawVarZzj.zzt("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", strArr);
                }
                Iterator it = listZzt.iterator();
                while (it.hasNext()) {
                    zzah zzahVar = (zzah) it.next();
                    if (zzahVar != null) {
                        boolean z2 = z;
                        Iterator it2 = it;
                        zzaW().zzk().zzd("User property timed out", zzahVar.zza, this.zzn.zzl().zzc(zzahVar.zzc.zzb), zzahVar.zzc.zza());
                        zzbh zzbhVar2 = zzahVar.zzg;
                        if (zzbhVar2 != null) {
                            zzH(new zzbh(zzbhVar2, j, j2), zzrVar);
                        }
                        zzj().zzr(str2, zzahVar.zzc.zzb);
                        z = z2;
                        it = it2;
                    }
                }
                boolean z3 = z;
                zzaw zzawVarZzj2 = zzj();
                Preconditions.checkNotEmpty(str2);
                zzawVarZzj2.zzg();
                zzawVarZzj2.zzay();
                if (i < 0) {
                    zzawVarZzj2.zzu.zzaW().zze().zzc("Invalid time querying expired conditional properties", zzgu.zzl(str2), Long.valueOf(j));
                    listZzt2 = Collections.emptyList();
                } else {
                    String[] strArr2 = new String[2];
                    strArr2[c] = str2;
                    strArr2[z3 ? 1 : 0] = String.valueOf(j);
                    listZzt2 = zzawVarZzj2.zzt("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", strArr2);
                }
                ArrayList arrayList = new ArrayList(listZzt2.size());
                Iterator it3 = listZzt2.iterator();
                while (it3.hasNext()) {
                    zzah zzahVar2 = (zzah) it3.next();
                    if (zzahVar2 != null) {
                        Iterator it4 = it3;
                        int i2 = i;
                        zzaW().zzk().zzd("User property expired", zzahVar2.zza, this.zzn.zzl().zzc(zzahVar2.zzc.zzb), zzahVar2.zzc.zza());
                        zzj().zzk(str2, zzahVar2.zzc.zzb);
                        zzbh zzbhVar3 = zzahVar2.zzk;
                        if (zzbhVar3 != null) {
                            arrayList.add(zzbhVar3);
                        }
                        zzj().zzr(str2, zzahVar2.zzc.zzb);
                        it3 = it4;
                        i = i2;
                    }
                }
                int i3 = i;
                Iterator it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    zzH(new zzbh((zzbh) it5.next(), j, j2), zzrVar);
                    j2 = j2;
                }
                long j3 = j2;
                zzaw zzawVarZzj3 = zzj();
                Preconditions.checkNotEmpty(str2);
                Preconditions.checkNotEmpty(str4);
                zzawVarZzj3.zzg();
                zzawVarZzj3.zzay();
                if (i3 < 0) {
                    zzic zzicVar = zzawVarZzj3.zzu;
                    zzicVar.zzaW().zze().zzd("Invalid time querying triggered conditional properties", zzgu.zzl(str2), zzicVar.zzl().zza(str4), Long.valueOf(j));
                    listZzt3 = Collections.emptyList();
                } else {
                    String[] strArr3 = new String[3];
                    strArr3[c] = str2;
                    strArr3[z3 ? 1 : 0] = str4;
                    strArr3[2] = String.valueOf(j);
                    listZzt3 = zzawVarZzj3.zzt("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", strArr3);
                }
                ArrayList arrayList2 = new ArrayList(listZzt3.size());
                for (zzah zzahVar3 : listZzt3) {
                    if (zzahVar3 != null) {
                        zzpl zzplVar = zzahVar3.zzc;
                        long j4 = j;
                        zzpn zzpnVar = new zzpn((String) Preconditions.checkNotNull(zzahVar3.zza), zzahVar3.zzb, zzplVar.zzb, j4, Preconditions.checkNotNull(zzplVar.zza()));
                        j = j4;
                        if (zzj().zzl(zzpnVar)) {
                            zzaW().zzk().zzd("User property triggered", zzahVar3.zza, this.zzn.zzl().zzc(zzpnVar.zzc), zzpnVar.zze);
                        } else {
                            zzaW().zzb().zzd("Too many active user properties, ignoring", zzgu.zzl(zzahVar3.zza), this.zzn.zzl().zzc(zzpnVar.zzc), zzpnVar.zze);
                        }
                        zzbh zzbhVar4 = zzahVar3.zzi;
                        if (zzbhVar4 != null) {
                            arrayList2.add(zzbhVar4);
                        }
                        zzahVar3.zzc = new zzpl(zzpnVar);
                        boolean z4 = z3 ? 1 : 0;
                        zzahVar3.zze = z4;
                        zzj().zzp(zzahVar3);
                        z3 = z4 ? 1 : 0;
                    }
                }
                zzH(zzbhVarZzb, zzrVar);
                Iterator it6 = arrayList2.iterator();
                while (it6.hasNext()) {
                    long j5 = j3;
                    zzH(new zzbh((zzbh) it6.next(), j, j5), zzrVar);
                    j3 = j5;
                }
                zzj().zzc();
            } finally {
                zzj().zzd();
            }
        }
    }

    final Bundle zzG(String str, zzbh zzbhVar) {
        Bundle bundle = new Bundle();
        bundle.putLong("_sid", zzbhVar.zzb.zzb("_sid").longValue());
        zzpn zzpnVarZzm = zzj().zzm(str, "_sno");
        if (zzpnVarZzm != null) {
            Object obj = zzpnVarZzm.zze;
            if (obj instanceof Long) {
                bundle.putLong("_sno", ((Long) obj).longValue());
            }
        }
        return bundle;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x037a A[Catch: all -> 0x0afc, TryCatch #7 {all -> 0x0afc, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:93:0x0303, B:102:0x0339, B:104:0x037a, B:106:0x037f, B:107:0x0396, B:109:0x03a1, B:111:0x03ba, B:113:0x03bf, B:114:0x03d6, B:117:0x03f4, B:121:0x0416, B:122:0x042d, B:123:0x0436, B:126:0x0453, B:127:0x0467, B:129:0x046f, B:131:0x047b, B:133:0x0481, B:134:0x0488, B:135:0x0495, B:137:0x04bb, B:146:0x04e1, B:147:0x04f6, B:149:0x0521, B:152:0x0538, B:154:0x0542, B:158:0x057f, B:160:0x05a8, B:162:0x05df, B:163:0x05e2, B:165:0x05ea, B:166:0x05ed, B:168:0x05f5, B:169:0x05f8, B:171:0x0600, B:172:0x0603, B:174:0x060c, B:175:0x0610, B:177:0x061d, B:178:0x0620, B:180:0x0654, B:182:0x065e, B:186:0x0675, B:191:0x0682, B:194:0x068b, B:198:0x069c, B:202:0x06aa, B:206:0x06b8, B:210:0x06c6, B:214:0x06d4, B:218:0x06e0, B:222:0x06ee, B:223:0x06fa, B:225:0x0700, B:226:0x0703, B:228:0x0719, B:229:0x0723, B:231:0x0730, B:233:0x073a, B:234:0x073d, B:236:0x0759, B:238:0x075d, B:241:0x0771, B:243:0x077c, B:244:0x0787, B:246:0x0793, B:248:0x079f, B:250:0x07a9, B:252:0x07af, B:254:0x07c1, B:256:0x07df, B:258:0x07e5, B:259:0x07ee, B:262:0x0801, B:264:0x083b, B:266:0x0845, B:267:0x0848, B:269:0x0852, B:271:0x086e, B:272:0x0877, B:274:0x08ad, B:276:0x08b5, B:278:0x08bf, B:279:0x08cc, B:281:0x08d6, B:282:0x08e3, B:283:0x08ec, B:285:0x08f2, B:287:0x092e, B:289:0x0938, B:291:0x094a, B:295:0x0955, B:296:0x099a, B:297:0x09a5, B:298:0x09b2, B:300:0x09b8, B:308:0x0a05, B:309:0x0a5b, B:311:0x0a6c, B:323:0x0acb, B:314:0x0a82, B:316:0x0a86, B:303:0x09c7, B:305:0x09f3, B:319:0x0a9d, B:320:0x0ab4, B:322:0x0ab6, B:159:0x059a, B:143:0x04c8, B:96:0x0317, B:97:0x031e, B:99:0x0324, B:101:0x0333, B:51:0x018c, B:54:0x019c, B:56:0x01b1, B:62:0x01cd, B:67:0x0201, B:69:0x0207, B:71:0x0215, B:73:0x022a, B:76:0x0231, B:89:0x02c9, B:91:0x02d3, B:78:0x025a, B:79:0x027c, B:81:0x0282, B:88:0x02af, B:87:0x029b, B:65:0x01d9, B:66:0x01f7), top: B:342:0x0155, inners: #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0436 A[Catch: all -> 0x0afc, TRY_LEAVE, TryCatch #7 {all -> 0x0afc, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:93:0x0303, B:102:0x0339, B:104:0x037a, B:106:0x037f, B:107:0x0396, B:109:0x03a1, B:111:0x03ba, B:113:0x03bf, B:114:0x03d6, B:117:0x03f4, B:121:0x0416, B:122:0x042d, B:123:0x0436, B:126:0x0453, B:127:0x0467, B:129:0x046f, B:131:0x047b, B:133:0x0481, B:134:0x0488, B:135:0x0495, B:137:0x04bb, B:146:0x04e1, B:147:0x04f6, B:149:0x0521, B:152:0x0538, B:154:0x0542, B:158:0x057f, B:160:0x05a8, B:162:0x05df, B:163:0x05e2, B:165:0x05ea, B:166:0x05ed, B:168:0x05f5, B:169:0x05f8, B:171:0x0600, B:172:0x0603, B:174:0x060c, B:175:0x0610, B:177:0x061d, B:178:0x0620, B:180:0x0654, B:182:0x065e, B:186:0x0675, B:191:0x0682, B:194:0x068b, B:198:0x069c, B:202:0x06aa, B:206:0x06b8, B:210:0x06c6, B:214:0x06d4, B:218:0x06e0, B:222:0x06ee, B:223:0x06fa, B:225:0x0700, B:226:0x0703, B:228:0x0719, B:229:0x0723, B:231:0x0730, B:233:0x073a, B:234:0x073d, B:236:0x0759, B:238:0x075d, B:241:0x0771, B:243:0x077c, B:244:0x0787, B:246:0x0793, B:248:0x079f, B:250:0x07a9, B:252:0x07af, B:254:0x07c1, B:256:0x07df, B:258:0x07e5, B:259:0x07ee, B:262:0x0801, B:264:0x083b, B:266:0x0845, B:267:0x0848, B:269:0x0852, B:271:0x086e, B:272:0x0877, B:274:0x08ad, B:276:0x08b5, B:278:0x08bf, B:279:0x08cc, B:281:0x08d6, B:282:0x08e3, B:283:0x08ec, B:285:0x08f2, B:287:0x092e, B:289:0x0938, B:291:0x094a, B:295:0x0955, B:296:0x099a, B:297:0x09a5, B:298:0x09b2, B:300:0x09b8, B:308:0x0a05, B:309:0x0a5b, B:311:0x0a6c, B:323:0x0acb, B:314:0x0a82, B:316:0x0a86, B:303:0x09c7, B:305:0x09f3, B:319:0x0a9d, B:320:0x0ab4, B:322:0x0ab6, B:159:0x059a, B:143:0x04c8, B:96:0x0317, B:97:0x031e, B:99:0x0324, B:101:0x0333, B:51:0x018c, B:54:0x019c, B:56:0x01b1, B:62:0x01cd, B:67:0x0201, B:69:0x0207, B:71:0x0215, B:73:0x022a, B:76:0x0231, B:89:0x02c9, B:91:0x02d3, B:78:0x025a, B:79:0x027c, B:81:0x0282, B:88:0x02af, B:87:0x029b, B:65:0x01d9, B:66:0x01f7), top: B:342:0x0155, inners: #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:260:0x07f9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x019c A[Catch: all -> 0x0afc, TRY_ENTER, TryCatch #7 {all -> 0x0afc, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:93:0x0303, B:102:0x0339, B:104:0x037a, B:106:0x037f, B:107:0x0396, B:109:0x03a1, B:111:0x03ba, B:113:0x03bf, B:114:0x03d6, B:117:0x03f4, B:121:0x0416, B:122:0x042d, B:123:0x0436, B:126:0x0453, B:127:0x0467, B:129:0x046f, B:131:0x047b, B:133:0x0481, B:134:0x0488, B:135:0x0495, B:137:0x04bb, B:146:0x04e1, B:147:0x04f6, B:149:0x0521, B:152:0x0538, B:154:0x0542, B:158:0x057f, B:160:0x05a8, B:162:0x05df, B:163:0x05e2, B:165:0x05ea, B:166:0x05ed, B:168:0x05f5, B:169:0x05f8, B:171:0x0600, B:172:0x0603, B:174:0x060c, B:175:0x0610, B:177:0x061d, B:178:0x0620, B:180:0x0654, B:182:0x065e, B:186:0x0675, B:191:0x0682, B:194:0x068b, B:198:0x069c, B:202:0x06aa, B:206:0x06b8, B:210:0x06c6, B:214:0x06d4, B:218:0x06e0, B:222:0x06ee, B:223:0x06fa, B:225:0x0700, B:226:0x0703, B:228:0x0719, B:229:0x0723, B:231:0x0730, B:233:0x073a, B:234:0x073d, B:236:0x0759, B:238:0x075d, B:241:0x0771, B:243:0x077c, B:244:0x0787, B:246:0x0793, B:248:0x079f, B:250:0x07a9, B:252:0x07af, B:254:0x07c1, B:256:0x07df, B:258:0x07e5, B:259:0x07ee, B:262:0x0801, B:264:0x083b, B:266:0x0845, B:267:0x0848, B:269:0x0852, B:271:0x086e, B:272:0x0877, B:274:0x08ad, B:276:0x08b5, B:278:0x08bf, B:279:0x08cc, B:281:0x08d6, B:282:0x08e3, B:283:0x08ec, B:285:0x08f2, B:287:0x092e, B:289:0x0938, B:291:0x094a, B:295:0x0955, B:296:0x099a, B:297:0x09a5, B:298:0x09b2, B:300:0x09b8, B:308:0x0a05, B:309:0x0a5b, B:311:0x0a6c, B:323:0x0acb, B:314:0x0a82, B:316:0x0a86, B:303:0x09c7, B:305:0x09f3, B:319:0x0a9d, B:320:0x0ab4, B:322:0x0ab6, B:159:0x059a, B:143:0x04c8, B:96:0x0317, B:97:0x031e, B:99:0x0324, B:101:0x0333, B:51:0x018c, B:54:0x019c, B:56:0x01b1, B:62:0x01cd, B:67:0x0201, B:69:0x0207, B:71:0x0215, B:73:0x022a, B:76:0x0231, B:89:0x02c9, B:91:0x02d3, B:78:0x025a, B:79:0x027c, B:81:0x0282, B:88:0x02af, B:87:0x029b, B:65:0x01d9, B:66:0x01f7), top: B:342:0x0155, inners: #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01f7 A[Catch: all -> 0x0afc, TryCatch #7 {all -> 0x0afc, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:93:0x0303, B:102:0x0339, B:104:0x037a, B:106:0x037f, B:107:0x0396, B:109:0x03a1, B:111:0x03ba, B:113:0x03bf, B:114:0x03d6, B:117:0x03f4, B:121:0x0416, B:122:0x042d, B:123:0x0436, B:126:0x0453, B:127:0x0467, B:129:0x046f, B:131:0x047b, B:133:0x0481, B:134:0x0488, B:135:0x0495, B:137:0x04bb, B:146:0x04e1, B:147:0x04f6, B:149:0x0521, B:152:0x0538, B:154:0x0542, B:158:0x057f, B:160:0x05a8, B:162:0x05df, B:163:0x05e2, B:165:0x05ea, B:166:0x05ed, B:168:0x05f5, B:169:0x05f8, B:171:0x0600, B:172:0x0603, B:174:0x060c, B:175:0x0610, B:177:0x061d, B:178:0x0620, B:180:0x0654, B:182:0x065e, B:186:0x0675, B:191:0x0682, B:194:0x068b, B:198:0x069c, B:202:0x06aa, B:206:0x06b8, B:210:0x06c6, B:214:0x06d4, B:218:0x06e0, B:222:0x06ee, B:223:0x06fa, B:225:0x0700, B:226:0x0703, B:228:0x0719, B:229:0x0723, B:231:0x0730, B:233:0x073a, B:234:0x073d, B:236:0x0759, B:238:0x075d, B:241:0x0771, B:243:0x077c, B:244:0x0787, B:246:0x0793, B:248:0x079f, B:250:0x07a9, B:252:0x07af, B:254:0x07c1, B:256:0x07df, B:258:0x07e5, B:259:0x07ee, B:262:0x0801, B:264:0x083b, B:266:0x0845, B:267:0x0848, B:269:0x0852, B:271:0x086e, B:272:0x0877, B:274:0x08ad, B:276:0x08b5, B:278:0x08bf, B:279:0x08cc, B:281:0x08d6, B:282:0x08e3, B:283:0x08ec, B:285:0x08f2, B:287:0x092e, B:289:0x0938, B:291:0x094a, B:295:0x0955, B:296:0x099a, B:297:0x09a5, B:298:0x09b2, B:300:0x09b8, B:308:0x0a05, B:309:0x0a5b, B:311:0x0a6c, B:323:0x0acb, B:314:0x0a82, B:316:0x0a86, B:303:0x09c7, B:305:0x09f3, B:319:0x0a9d, B:320:0x0ab4, B:322:0x0ab6, B:159:0x059a, B:143:0x04c8, B:96:0x0317, B:97:0x031e, B:99:0x0324, B:101:0x0333, B:51:0x018c, B:54:0x019c, B:56:0x01b1, B:62:0x01cd, B:67:0x0201, B:69:0x0207, B:71:0x0215, B:73:0x022a, B:76:0x0231, B:89:0x02c9, B:91:0x02d3, B:78:0x025a, B:79:0x027c, B:81:0x0282, B:88:0x02af, B:87:0x029b, B:65:0x01d9, B:66:0x01f7), top: B:342:0x0155, inners: #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0207 A[Catch: all -> 0x0afc, TryCatch #7 {all -> 0x0afc, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:93:0x0303, B:102:0x0339, B:104:0x037a, B:106:0x037f, B:107:0x0396, B:109:0x03a1, B:111:0x03ba, B:113:0x03bf, B:114:0x03d6, B:117:0x03f4, B:121:0x0416, B:122:0x042d, B:123:0x0436, B:126:0x0453, B:127:0x0467, B:129:0x046f, B:131:0x047b, B:133:0x0481, B:134:0x0488, B:135:0x0495, B:137:0x04bb, B:146:0x04e1, B:147:0x04f6, B:149:0x0521, B:152:0x0538, B:154:0x0542, B:158:0x057f, B:160:0x05a8, B:162:0x05df, B:163:0x05e2, B:165:0x05ea, B:166:0x05ed, B:168:0x05f5, B:169:0x05f8, B:171:0x0600, B:172:0x0603, B:174:0x060c, B:175:0x0610, B:177:0x061d, B:178:0x0620, B:180:0x0654, B:182:0x065e, B:186:0x0675, B:191:0x0682, B:194:0x068b, B:198:0x069c, B:202:0x06aa, B:206:0x06b8, B:210:0x06c6, B:214:0x06d4, B:218:0x06e0, B:222:0x06ee, B:223:0x06fa, B:225:0x0700, B:226:0x0703, B:228:0x0719, B:229:0x0723, B:231:0x0730, B:233:0x073a, B:234:0x073d, B:236:0x0759, B:238:0x075d, B:241:0x0771, B:243:0x077c, B:244:0x0787, B:246:0x0793, B:248:0x079f, B:250:0x07a9, B:252:0x07af, B:254:0x07c1, B:256:0x07df, B:258:0x07e5, B:259:0x07ee, B:262:0x0801, B:264:0x083b, B:266:0x0845, B:267:0x0848, B:269:0x0852, B:271:0x086e, B:272:0x0877, B:274:0x08ad, B:276:0x08b5, B:278:0x08bf, B:279:0x08cc, B:281:0x08d6, B:282:0x08e3, B:283:0x08ec, B:285:0x08f2, B:287:0x092e, B:289:0x0938, B:291:0x094a, B:295:0x0955, B:296:0x099a, B:297:0x09a5, B:298:0x09b2, B:300:0x09b8, B:308:0x0a05, B:309:0x0a5b, B:311:0x0a6c, B:323:0x0acb, B:314:0x0a82, B:316:0x0a86, B:303:0x09c7, B:305:0x09f3, B:319:0x0a9d, B:320:0x0ab4, B:322:0x0ab6, B:159:0x059a, B:143:0x04c8, B:96:0x0317, B:97:0x031e, B:99:0x0324, B:101:0x0333, B:51:0x018c, B:54:0x019c, B:56:0x01b1, B:62:0x01cd, B:67:0x0201, B:69:0x0207, B:71:0x0215, B:73:0x022a, B:76:0x0231, B:89:0x02c9, B:91:0x02d3, B:78:0x025a, B:79:0x027c, B:81:0x0282, B:88:0x02af, B:87:0x029b, B:65:0x01d9, B:66:0x01f7), top: B:342:0x0155, inners: #1, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0317 A[Catch: all -> 0x0afc, TryCatch #7 {all -> 0x0afc, blocks: (B:36:0x0155, B:39:0x0166, B:41:0x016e, B:46:0x0178, B:93:0x0303, B:102:0x0339, B:104:0x037a, B:106:0x037f, B:107:0x0396, B:109:0x03a1, B:111:0x03ba, B:113:0x03bf, B:114:0x03d6, B:117:0x03f4, B:121:0x0416, B:122:0x042d, B:123:0x0436, B:126:0x0453, B:127:0x0467, B:129:0x046f, B:131:0x047b, B:133:0x0481, B:134:0x0488, B:135:0x0495, B:137:0x04bb, B:146:0x04e1, B:147:0x04f6, B:149:0x0521, B:152:0x0538, B:154:0x0542, B:158:0x057f, B:160:0x05a8, B:162:0x05df, B:163:0x05e2, B:165:0x05ea, B:166:0x05ed, B:168:0x05f5, B:169:0x05f8, B:171:0x0600, B:172:0x0603, B:174:0x060c, B:175:0x0610, B:177:0x061d, B:178:0x0620, B:180:0x0654, B:182:0x065e, B:186:0x0675, B:191:0x0682, B:194:0x068b, B:198:0x069c, B:202:0x06aa, B:206:0x06b8, B:210:0x06c6, B:214:0x06d4, B:218:0x06e0, B:222:0x06ee, B:223:0x06fa, B:225:0x0700, B:226:0x0703, B:228:0x0719, B:229:0x0723, B:231:0x0730, B:233:0x073a, B:234:0x073d, B:236:0x0759, B:238:0x075d, B:241:0x0771, B:243:0x077c, B:244:0x0787, B:246:0x0793, B:248:0x079f, B:250:0x07a9, B:252:0x07af, B:254:0x07c1, B:256:0x07df, B:258:0x07e5, B:259:0x07ee, B:262:0x0801, B:264:0x083b, B:266:0x0845, B:267:0x0848, B:269:0x0852, B:271:0x086e, B:272:0x0877, B:274:0x08ad, B:276:0x08b5, B:278:0x08bf, B:279:0x08cc, B:281:0x08d6, B:282:0x08e3, B:283:0x08ec, B:285:0x08f2, B:287:0x092e, B:289:0x0938, B:291:0x094a, B:295:0x0955, B:296:0x099a, B:297:0x09a5, B:298:0x09b2, B:300:0x09b8, B:308:0x0a05, B:309:0x0a5b, B:311:0x0a6c, B:323:0x0acb, B:314:0x0a82, B:316:0x0a86, B:303:0x09c7, B:305:0x09f3, B:319:0x0a9d, B:320:0x0ab4, B:322:0x0ab6, B:159:0x059a, B:143:0x04c8, B:96:0x0317, B:97:0x031e, B:99:0x0324, B:101:0x0333, B:51:0x018c, B:54:0x019c, B:56:0x01b1, B:62:0x01cd, B:67:0x0201, B:69:0x0207, B:71:0x0215, B:73:0x022a, B:76:0x0231, B:89:0x02c9, B:91:0x02d3, B:78:0x025a, B:79:0x027c, B:81:0x0282, B:88:0x02af, B:87:0x029b, B:65:0x01d9, B:66:0x01f7), top: B:342:0x0155, inners: #1, #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void zzH(zzbh zzbhVar, zzr zzrVar) {
        String strZzd;
        int i;
        String str;
        long jLongValue;
        zzbh zzbhVar2;
        char c;
        zzpn zzpnVar;
        zzbf zzbfVar;
        long length;
        long jZzH;
        int i2;
        long jDelete;
        zzbc zzbcVar;
        zzbd zzbdVar;
        zzbc zzbcVar2;
        String str2;
        zzjk zzjkVar;
        long j;
        int i3;
        zzaw zzawVarZzj;
        com.google.android.gms.internal.measurement.zzid zzidVar;
        long jZzt;
        ContentValues contentValues;
        String str3;
        String str4;
        boolean z;
        zzh zzhVarZzu;
        List listZzm;
        long j2;
        boolean z2;
        zzpn zzpnVarZzm;
        Preconditions.checkNotNull(zzrVar);
        String str5 = zzrVar.zza;
        Preconditions.checkNotEmpty(str5);
        long jNanoTime = System.nanoTime();
        zzaX().zzg();
        zzu();
        zzp();
        if (zzpk.zzG(zzbhVar, zzrVar)) {
            if (!zzrVar.zzh) {
                zzap(zzrVar);
                return;
            }
            zzht zzhtVarZzh = zzh();
            String str6 = zzbhVar.zza;
            if (zzhtVarZzh.zzj(str5, str6)) {
                zzaW().zze().zzc("Dropping blocked event. appId", zzgu.zzl(str5), this.zzn.zzl().zza(str6));
                if (!zzh().zzo(str5) && !zzh().zzp(str5)) {
                    if ("_err".equals(str6)) {
                        return;
                    }
                    zzt().zzP(this.zzK, str5, 11, "_ev", str6, 0);
                    return;
                }
                zzh zzhVarZzu2 = zzj().zzu(str5);
                if (zzhVarZzu2 != null) {
                    long jAbs = Math.abs(zzba().currentTimeMillis() - Math.max(zzhVarZzu2.zzJ(), zzhVarZzu2.zzH()));
                    zzd();
                    if (jAbs > ((Long) zzfy.zzN.zzb(null)).longValue()) {
                        zzaW().zzj().zza("Fetching config for blocked app");
                        zzX(zzhVarZzu2);
                        return;
                    }
                    return;
                }
                return;
            }
            zzgv zzgvVarZza = zzgv.zza(zzbhVar);
            zzt().zzI(zzgvVarZza, zzd().zzd(str5));
            int iZzn = zzd().zzn(str5, zzfy.zzaf, 10, 35);
            Bundle bundle = zzgvVarZza.zze;
            for (String str7 : new TreeSet(bundle.keySet())) {
                if (FirebaseAnalytics.Param.ITEMS.equals(str7)) {
                    zzt().zzJ(bundle.getParcelableArray(str7), iZzn);
                }
            }
            zzbh zzbhVarZzb = zzgvVarZza.zzb();
            if (Log.isLoggable(zzaW().zzn(), 2)) {
                zzaW().zzk().zzb("Logging event", this.zzn.zzl().zzd(zzbhVarZzb));
            }
            zzj().zzb();
            try {
                zzap(zzrVar);
                String str8 = zzbhVarZzb.zza;
                boolean z3 = "ecommerce_purchase".equals(str8) || FirebaseAnalytics.Event.PURCHASE.equals(str8) || FirebaseAnalytics.Event.REFUND.equals(str8);
                if ("_iap".equals(str8)) {
                    zzbf zzbfVar2 = zzbhVarZzb.zzb;
                    strZzd = zzbfVar2.zzd(FirebaseAnalytics.Param.CURRENCY);
                    i = 0;
                    if (z3) {
                        str = "app_id";
                        jLongValue = zzbfVar2.zzb("value").longValue();
                    } else {
                        double dDoubleValue = zzbfVar2.zzc("value").doubleValue() * 1000000.0d;
                        if (dDoubleValue == AudioStats.AUDIO_AMPLITUDE_NONE) {
                            str = "app_id";
                            dDoubleValue = zzbfVar2.zzb("value").longValue() * 1000000.0d;
                        } else {
                            str = "app_id";
                        }
                        if (dDoubleValue > 9.223372036854776E18d || dDoubleValue < -9.223372036854776E18d) {
                            zzaW().zze().zzc("Data lost. Currency value is too big. appId", zzgu.zzl(str5), Double.valueOf(dDoubleValue));
                            zzj().zzc();
                        } else {
                            jLongValue = Math.round(dDoubleValue);
                            if (FirebaseAnalytics.Event.REFUND.equals(str8)) {
                                jLongValue = -jLongValue;
                            }
                        }
                    }
                    if (TextUtils.isEmpty(strZzd)) {
                        String upperCase = strZzd.toUpperCase(Locale.US);
                        if (upperCase.matches("[A-Z]{3}")) {
                            String.valueOf(upperCase);
                            String strConcat = "_ltv_".concat(String.valueOf(upperCase));
                            zzpn zzpnVarZzm2 = zzj().zzm(str5, strConcat);
                            if (zzpnVarZzm2 == null || !(zzpnVarZzm2.zze instanceof Long)) {
                                long j3 = jLongValue;
                                zzbhVar2 = zzbhVarZzb;
                                zzaw zzawVarZzj2 = zzj();
                                int iZzm = zzd().zzm(str5, zzfy.zzT) - 1;
                                Preconditions.checkNotEmpty(str5);
                                zzawVarZzj2.zzg();
                                zzawVarZzj2.zzay();
                                try {
                                    c = 2;
                                } catch (SQLiteException e) {
                                    e = e;
                                    c = 2;
                                }
                                try {
                                    zzawVarZzj2.zze().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '!_ltv!_%' escape '!'order by set_timestamp desc limit ?,10);", new String[]{str5, str5, String.valueOf(iZzm)});
                                } catch (SQLiteException e2) {
                                    e = e2;
                                    zzawVarZzj2.zzu.zzaW().zzb().zzc("Error pruning currencies. appId", zzgu.zzl(str5), e);
                                }
                                zzpnVar = new zzpn(str5, zzbhVar2.zzc, strConcat, zzba().currentTimeMillis(), Long.valueOf(j3));
                                str5 = str5;
                            } else {
                                long jLongValue2 = ((Long) zzpnVarZzm2.zze).longValue();
                                String str9 = zzbhVarZzb.zzc;
                                long jCurrentTimeMillis = zzba().currentTimeMillis();
                                Long lValueOf = Long.valueOf(jLongValue2 + jLongValue);
                                zzbhVar2 = zzbhVarZzb;
                                zzpnVar = new zzpn(str5, str9, strConcat, jCurrentTimeMillis, lValueOf);
                                str5 = str5;
                            }
                            zzpn zzpnVar2 = zzpnVar;
                            if (!zzj().zzl(zzpnVar2)) {
                                zzaW().zzb().zzd("Too many unique user properties are set. Ignoring user property. appId", zzgu.zzl(str5), this.zzn.zzl().zzc(zzpnVar2.zzc), zzpnVar2.zze);
                                zzt().zzP(this.zzK, str5, 9, null, null, 0);
                            }
                        } else {
                            zzbhVar2 = zzbhVarZzb;
                        }
                        String str10 = zzbhVar2.zza;
                        boolean zZzh = zzpp.zzh(str10);
                        boolean zEquals = "_err".equals(str10);
                        zzt();
                        zzbfVar = zzbhVar2.zzb;
                        if (zzbfVar != null) {
                            length = 0;
                        } else {
                            zzbe zzbeVar = new zzbe(zzbfVar);
                            length = 0;
                            while (zzbeVar.hasNext()) {
                                String next = zzbeVar.next();
                                String str11 = next;
                                Object objZza = zzbfVar.zza(next);
                                if (objZza instanceof Parcelable[]) {
                                    length += (long) ((Parcelable[]) objZza).length;
                                }
                            }
                        }
                        String str12 = str5;
                        zzar zzarVarZzx = zzj().zzx(zzC(), str12, length + 1, true, zZzh, false, zEquals, false, false, false);
                        long j4 = zzarVarZzx.zzb;
                        zzd();
                        jZzH = j4 - zzal.zzH();
                        if (jZzH <= 0) {
                            if (jZzH % 1000 == 1) {
                                zzaW().zzb().zzc("Data loss. Too many events logged. appId, count", zzgu.zzl(str12), Long.valueOf(zzarVarZzx.zzb));
                            }
                            zzj().zzc();
                        } else if (zZzh) {
                            long j5 = zzarVarZzx.zza;
                            zzd();
                            long jIntValue = j5 - ((long) ((Integer) zzfy.zzm.zzb(null)).intValue());
                            if (jIntValue > 0) {
                                if (jIntValue % 1000 == 1) {
                                    zzaW().zzb().zzc("Data loss. Too many public events logged. appId, count", zzgu.zzl(str12), Long.valueOf(zzarVarZzx.zza));
                                }
                                zzt().zzP(this.zzK, str12, 16, "_ev", zzbhVar2.zza, 0);
                                zzj().zzc();
                            } else if (zEquals) {
                                long jMax = zzarVarZzx.zzd - ((long) Math.max(i, Math.min(1000000, zzd().zzm(zzrVar.zza, zzfy.zzl))));
                                if (jMax <= 0) {
                                    Bundle bundleZzf = zzbfVar.zzf();
                                    zzt().zzO(bundleZzf, "_o", zzbhVar2.zzc);
                                    if (zzt().zzad(str12, zzrVar.zzB)) {
                                        zzt().zzO(bundleZzf, "_dbg", 1L);
                                        zzt().zzO(bundleZzf, "_r", 1L);
                                    }
                                    if ("_s".equals(str10) && (zzpnVarZzm = zzj().zzm(zzrVar.zza, "_sno")) != null) {
                                        Object obj = zzpnVarZzm.zze;
                                        if (obj instanceof Long) {
                                            zzt().zzO(bundleZzf, "_sno", obj);
                                        }
                                    }
                                    zzaw zzawVarZzj3 = zzj();
                                    Preconditions.checkNotEmpty(str12);
                                    zzawVarZzj3.zzg();
                                    zzawVarZzj3.zzay();
                                    try {
                                        SQLiteDatabase sQLiteDatabaseZze = zzawVarZzj3.zze();
                                        String strValueOf = String.valueOf(Math.max(0, Math.min(1000000, zzawVarZzj3.zzu.zzc().zzm(str12, zzfy.zzp))));
                                        String[] strArr = new String[2];
                                        strArr[0] = str12;
                                        i2 = 1;
                                        try {
                                            strArr[1] = strValueOf;
                                            jDelete = sQLiteDatabaseZze.delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", strArr);
                                        } catch (SQLiteException e3) {
                                            e = e3;
                                            zzawVarZzj3.zzu.zzaW().zzb().zzc("Error deleting over the limit events. appId", zzgu.zzl(str12), e);
                                            jDelete = 0;
                                        }
                                    } catch (SQLiteException e4) {
                                        e = e4;
                                        i2 = 1;
                                    }
                                    if (jDelete > 0) {
                                        zzaW().zze().zzc("Data lost. Too many events stored on disk, deleted. appId", zzgu.zzl(str12), Long.valueOf(jDelete));
                                    }
                                    zzic zzicVar = this.zzn;
                                    int i4 = i2;
                                    zzbc zzbcVar3 = new zzbc(zzicVar, zzbhVar2.zzc, str12, zzbhVar2.zza, zzbhVar2.zzd, zzbhVar2.zze, 0L, bundleZzf);
                                    zzaw zzawVarZzj4 = zzj();
                                    String str13 = zzbcVar3.zzb;
                                    zzbd zzbdVarZzf = zzawVarZzj4.zzf(str12, str13);
                                    if (zzbdVarZzf != null) {
                                        zzbc zzbcVarZza = zzbcVar3.zza(zzicVar, zzbdVarZzf.zzf);
                                        zzbd zzbdVarZza = zzbdVarZzf.zza(zzbcVarZza.zzd);
                                        zzbcVar = zzbcVarZza;
                                        zzbdVar = zzbdVarZza;
                                    } else if (zzj().zzT(str12) < zzd().zzh(str12) || !zZzh || zzt().zzq(str13)) {
                                        zzbdVar = new zzbd(str12, str13, 0L, 0L, 0L, zzbcVar3.zzd, 0L, null, null, null, null);
                                        zzbcVar = zzbcVar3;
                                    } else {
                                        zzaW().zzb().zzd("Too many event names used, ignoring event. appId, name, supported count", zzgu.zzl(str12), zzicVar.zzl().zza(str13), Integer.valueOf(zzd().zzh(str12)));
                                        zzt().zzP(this.zzK, str12, 8, null, null, 0);
                                    }
                                    zzj().zzh(zzbdVar);
                                    zzaX().zzg();
                                    zzu();
                                    Preconditions.checkNotNull(zzbcVar);
                                    Preconditions.checkNotNull(zzrVar);
                                    String str14 = zzbcVar.zza;
                                    Preconditions.checkNotEmpty(str14);
                                    String str15 = zzrVar.zza;
                                    Preconditions.checkArgument(str14.equals(str15));
                                    com.google.android.gms.internal.measurement.zzic zzicVarZzaE = com.google.android.gms.internal.measurement.zzid.zzaE();
                                    zzicVarZzaE.zza(i4);
                                    zzicVarZzaE.zzC(com.facebook.appevents.codeless.internal.Constants.PLATFORM);
                                    if (!TextUtils.isEmpty(str15)) {
                                        zzicVarZzaE.zzL(str15);
                                    }
                                    String str16 = zzrVar.zzd;
                                    if (!TextUtils.isEmpty(str16)) {
                                        zzicVarZzaE.zzJ(str16);
                                    }
                                    String str17 = zzrVar.zzc;
                                    if (!TextUtils.isEmpty(str17)) {
                                        zzicVarZzaE.zzM(str17);
                                    }
                                    String str18 = zzrVar.zzu;
                                    if (!TextUtils.isEmpty(str18)) {
                                        zzicVarZzaE.zzau(str18);
                                    }
                                    long j6 = zzrVar.zzj;
                                    if (j6 != SieveCacheKt.NodeMetaAndPreviousMask) {
                                        zzicVarZzaE.zzaj((int) j6);
                                    }
                                    long j7 = zzrVar.zze;
                                    zzicVarZzaE.zzN(j7);
                                    String str19 = zzrVar.zzb;
                                    if (!TextUtils.isEmpty(str19)) {
                                        zzicVarZzaE.zzad(str19);
                                    }
                                    zzjl zzjlVarZzB = zzB((String) Preconditions.checkNotNull(str15));
                                    String str20 = str18;
                                    String str21 = zzrVar.zzs;
                                    zzjl zzjlVarZzs = zzjlVarZzB.zzs(zzjl.zzf(str21, 100));
                                    zzicVarZzaE.zzat(zzjlVarZzs.zzk());
                                    zzaif.zza();
                                    if (zzd().zzp(str15, zzfy.zzaO) && zzt().zzZ(str15)) {
                                        zzicVarZzaE.zzaH(zzrVar.zzz);
                                        long j8 = zzrVar.zzA;
                                        if (!zzjlVarZzs.zzo(zzjk.AD_STORAGE) && j8 != 0) {
                                            j8 = (j8 & (-2)) | 32;
                                        }
                                        zzicVarZzaE.zzaz(j8 == 1);
                                        if (j8 != 0) {
                                            com.google.android.gms.internal.measurement.zzhd zzhdVarZzi = com.google.android.gms.internal.measurement.zzhe.zzi();
                                            if ((j8 & 1) != 0) {
                                                j2 = 32;
                                                z2 = true;
                                            } else {
                                                j2 = 32;
                                                z2 = false;
                                            }
                                            zzhdVarZzi.zza(z2);
                                            zzhdVarZzi.zzb((j8 & 2) != 0);
                                            zzhdVarZzi.zzc((j8 & 4) != 0);
                                            zzhdVarZzi.zzd((j8 & 8) != 0);
                                            zzhdVarZzi.zze((j8 & 16) != 0);
                                            zzhdVarZzi.zzf((j8 & j2) != 0);
                                            zzhdVarZzi.zzg((j8 & 64) != 0);
                                            zzicVarZzaE.zzaI((com.google.android.gms.internal.measurement.zzhe) zzhdVarZzi.zzbd());
                                        }
                                    }
                                    long j9 = zzrVar.zzf;
                                    if (j9 != 0) {
                                        zzicVarZzaE.zzY(j9);
                                    }
                                    long j10 = zzrVar.zzq;
                                    zzicVarZzaE.zzar(j10);
                                    if (zzd().zzp(null, zzfy.zzaU)) {
                                        zzd();
                                        zzicVarZzaE.zzaQ(zzagr.zza());
                                    }
                                    if (zzd().zzp(null, zzfy.zzaV) && (listZzm = zzh().zzm(str15)) != null) {
                                        zzicVarZzaE.zzaq(listZzm);
                                    }
                                    zzjl zzjlVarZzs2 = zzB((String) Preconditions.checkNotNull(str15)).zzs(zzjl.zzf(str21, 100));
                                    zzjk zzjkVar2 = zzjk.AD_STORAGE;
                                    if (zzjlVarZzs2.zzo(zzjkVar2) && (z = zzrVar.zzn)) {
                                        Pair pairZzc = this.zzk.zzc(zzrVar, zzjlVarZzs2);
                                        if (!TextUtils.isEmpty((CharSequence) pairZzc.first) && z) {
                                            zzicVarZzaE.zzQ((String) pairZzc.first);
                                            if (pairZzc.second != null) {
                                                zzicVarZzaE.zzT(((Boolean) pairZzc.second).booleanValue());
                                            }
                                            zzbcVar2 = zzbcVar;
                                            if (!zzbcVar.zzb.equals("_fx") && !((String) pairZzc.first).equals("00000000-0000-0000-0000-000000000000") && (zzhVarZzu = zzj().zzu(str15)) != null && zzhVarZzu.zzaq()) {
                                                zzR(str15, false, null, null);
                                                Bundle bundle2 = new Bundle();
                                                Long lZzas = zzhVarZzu.zzas();
                                                if (lZzas != null) {
                                                    j = j6;
                                                    str2 = str17;
                                                    zzjkVar = zzjkVar2;
                                                    bundle2.putLong("_pfo", Math.max(0L, lZzas.longValue()));
                                                } else {
                                                    str2 = str17;
                                                    zzjkVar = zzjkVar2;
                                                    j = j6;
                                                }
                                                Long lZzau = zzhVarZzu.zzau();
                                                if (lZzau != null) {
                                                    bundle2.putLong("_uwa", lZzau.longValue());
                                                }
                                                bundle2.putLong("_r", 1L);
                                                this.zzK.zza(str15, "_fx", bundle2);
                                            }
                                        }
                                        str2 = str17;
                                        zzjkVar = zzjkVar2;
                                        j = j6;
                                    } else {
                                        zzbcVar2 = zzbcVar;
                                        str2 = str17;
                                        zzjkVar = zzjkVar2;
                                        j = j6;
                                    }
                                    zzicVar.zzu().zzw();
                                    zzicVarZzaE.zzF(Build.MODEL);
                                    zzicVar.zzu().zzw();
                                    zzicVarZzaE.zzE(Build.VERSION.RELEASE);
                                    zzicVarZzaE.zzI((int) zzicVar.zzu().zzb());
                                    zzicVarZzaE.zzH(zzicVar.zzu().zzc());
                                    zzicVarZzaE.zzay(zzrVar.zzw);
                                    if (zzicVar.zzB()) {
                                        zzicVarZzaE.zzK();
                                        if (!TextUtils.isEmpty(null)) {
                                            zzicVarZzaE.zzam(null);
                                        }
                                    }
                                    zzh zzhVarZzu3 = zzj().zzu(str15);
                                    if (zzhVarZzu3 == null) {
                                        zzhVarZzu3 = new zzh(zzicVar, str15);
                                        zzhVarZzu3.zze(zzK(zzjlVarZzs2));
                                        zzhVarZzu3.zzm(zzrVar.zzk);
                                        zzhVarZzu3.zzg(str19);
                                        if (zzjlVarZzs2.zzo(zzjkVar)) {
                                            zzhVarZzu3.zzk(this.zzk.zzf(zzrVar, zzjlVarZzs2));
                                        }
                                        zzhVarZzu3.zzF(0L);
                                        zzhVarZzu3.zzo(0L);
                                        zzhVarZzu3.zzq(0L);
                                        zzhVarZzu3.zzs(str2);
                                        zzhVarZzu3.zzu(j);
                                        zzhVarZzu3.zzw(str16);
                                        zzhVarZzu3.zzy(j7);
                                        zzhVarZzu3.zzA(j9);
                                        zzhVarZzu3.zzE(zzrVar.zzh);
                                        zzhVarZzu3.zzC(j10);
                                        i3 = 0;
                                        zzj().zzv(zzhVarZzu3, false, false);
                                    } else {
                                        i3 = 0;
                                    }
                                    if (zzjlVarZzs2.zzo(zzjk.ANALYTICS_STORAGE) && !TextUtils.isEmpty(zzhVarZzu3.zzd())) {
                                        zzicVarZzaE.zzW((String) Preconditions.checkNotNull(zzhVarZzu3.zzd()));
                                    }
                                    if (!TextUtils.isEmpty(zzhVarZzu3.zzl())) {
                                        zzicVarZzaE.zzah((String) Preconditions.checkNotNull(zzhVarZzu3.zzl()));
                                    }
                                    List listZzn = zzj().zzn(str15);
                                    int i5 = i3;
                                    while (i5 < listZzn.size()) {
                                        com.google.android.gms.internal.measurement.zzit zzitVarZzm = com.google.android.gms.internal.measurement.zziu.zzm();
                                        zzitVarZzm.zzb(((zzpn) listZzn.get(i5)).zzc);
                                        zzitVarZzm.zza(((zzpn) listZzn.get(i5)).zzd);
                                        zzp().zzc(zzitVarZzm, ((zzpn) listZzn.get(i5)).zze);
                                        zzicVarZzaE.zzp(zzitVarZzm);
                                        if (!"_sid".equals(((zzpn) listZzn.get(i5)).zzc) || zzhVarZzu3.zzam() == 0) {
                                            str4 = str20;
                                        } else {
                                            str4 = str20;
                                            if (zzp().zzu(str4) != zzhVarZzu3.zzam()) {
                                                zzicVarZzaE.zzav();
                                            }
                                        }
                                        i5++;
                                        str20 = str4;
                                    }
                                    try {
                                        zzawVarZzj = zzj();
                                        zzidVar = (com.google.android.gms.internal.measurement.zzid) zzicVarZzaE.zzbd();
                                        zzawVarZzj.zzg();
                                        zzawVarZzj.zzay();
                                        Preconditions.checkNotNull(zzidVar);
                                        Preconditions.checkNotEmpty(zzidVar.zzA());
                                        byte[] bArrZzcd = zzidVar.zzcd();
                                        jZzt = zzawVarZzj.zzg.zzp().zzt(bArrZzcd);
                                        contentValues = new ContentValues();
                                        str3 = str;
                                        contentValues.put(str3, zzidVar.zzA());
                                        contentValues.put("metadata_fingerprint", Long.valueOf(jZzt));
                                        contentValues.put("metadata", bArrZzcd);
                                    } catch (IOException e5) {
                                        zzaW().zzb().zzc("Data loss. Failed to insert raw event metadata. appId", zzgu.zzl(zzicVarZzaE.zzK()), e5);
                                    }
                                    try {
                                        zzawVarZzj.zze().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
                                        zzaw zzawVarZzj5 = zzj();
                                        zzbc zzbcVar4 = zzbcVar2;
                                        zzbe zzbeVar2 = new zzbe(zzbcVar4.zzg);
                                        while (true) {
                                            if (zzbeVar2.hasNext()) {
                                                String next2 = zzbeVar2.next();
                                                String str22 = next2;
                                                if ("_r".equals(next2)) {
                                                    break;
                                                }
                                            } else {
                                                zzht zzhtVarZzh2 = zzh();
                                                String str23 = zzbcVar4.zza;
                                                boolean zZzk = zzhtVarZzh2.zzk(str23, zzbcVar4.zzb);
                                                zzar zzarVarZzw = zzj().zzw(zzC(), str23, false, false, false, false, false, false, false);
                                                if (zZzk && zzarVarZzw.zze < zzd().zzm(str23, zzfy.zzo)) {
                                                }
                                            }
                                        }
                                        i3 = 1;
                                        zzawVarZzj5.zzg();
                                        zzawVarZzj5.zzay();
                                        Preconditions.checkNotNull(zzbcVar4);
                                        String str24 = zzbcVar4.zza;
                                        Preconditions.checkNotEmpty(str24);
                                        byte[] bArrZzcd2 = zzawVarZzj5.zzg.zzp().zzh(zzbcVar4).zzcd();
                                        ContentValues contentValues2 = new ContentValues();
                                        contentValues2.put(str3, str24);
                                        contentValues2.put("name", zzbcVar4.zzb);
                                        contentValues2.put(DiagnosticsEntry.TIMESTAMP_KEY, Long.valueOf(zzbcVar4.zzd));
                                        contentValues2.put("metadata_fingerprint", Long.valueOf(jZzt));
                                        contentValues2.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, bArrZzcd2);
                                        contentValues2.put("realtime", Integer.valueOf(i3));
                                        contentValues2.put("elapsed_time", Long.valueOf(zzbcVar4.zze));
                                        try {
                                            if (zzawVarZzj5.zze().insert("raw_events", null, contentValues2) == -1) {
                                                zzawVarZzj5.zzu.zzaW().zzb().zzb("Failed to insert raw event (got -1). appId", zzgu.zzl(str24));
                                            } else {
                                                this.zza = 0L;
                                            }
                                        } catch (SQLiteException e6) {
                                            zzawVarZzj5.zzu.zzaW().zzb().zzc("Error storing raw event. appId", zzgu.zzl(zzbcVar4.zza), e6);
                                        }
                                        zzj().zzc();
                                        zzj().zzd();
                                        zzaM();
                                        zzaW().zzk().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                                        return;
                                    } catch (SQLiteException e7) {
                                        zzawVarZzj.zzu.zzaW().zzb().zzc("Error storing raw event metadata. appId", zzgu.zzl(zzidVar.zzA()), e7);
                                        throw e7;
                                    }
                                }
                                if (jMax == 1) {
                                    zzaW().zzb().zzc("Too many error events logged. appId, count", zzgu.zzl(str12), Long.valueOf(zzarVarZzx.zzd));
                                }
                                zzj().zzc();
                            }
                        }
                    }
                } else if (z3) {
                    z3 = true;
                    zzbf zzbfVar22 = zzbhVarZzb.zzb;
                    strZzd = zzbfVar22.zzd(FirebaseAnalytics.Param.CURRENCY);
                    i = 0;
                    if (z3) {
                    }
                    if (TextUtils.isEmpty(strZzd)) {
                    }
                } else {
                    str = "app_id";
                    zzbhVar2 = zzbhVarZzb;
                    i = 0;
                    String str102 = zzbhVar2.zza;
                    boolean zZzh2 = zzpp.zzh(str102);
                    boolean zEquals2 = "_err".equals(str102);
                    zzt();
                    zzbfVar = zzbhVar2.zzb;
                    if (zzbfVar != null) {
                    }
                    String str122 = str5;
                    zzar zzarVarZzx2 = zzj().zzx(zzC(), str122, length + 1, true, zZzh2, false, zEquals2, false, false, false);
                    long j42 = zzarVarZzx2.zzb;
                    zzd();
                    jZzH = j42 - zzal.zzH();
                    if (jZzH <= 0) {
                    }
                }
            } finally {
                zzj().zzd();
            }
        }
    }

    final void zzI(zzh zzhVar, com.google.android.gms.internal.measurement.zzic zzicVar) {
        com.google.android.gms.internal.measurement.zziu zziuVar;
        zzaX().zzg();
        zzu();
        zzan zzanVarZzd = zzan.zzd(zzicVar.zzaA());
        String strZzc = zzhVar.zzc();
        zzaX().zzg();
        zzu();
        zzjl zzjlVarZzB = zzB(strZzc);
        zzji zzjiVar = zzji.UNINITIALIZED;
        int iOrdinal = zzjlVarZzB.zzp().ordinal();
        if (iOrdinal == 1) {
            zzanVarZzd.zzc(zzjk.AD_STORAGE, zzam.REMOTE_ENFORCED_DEFAULT);
        } else if (iOrdinal == 2 || iOrdinal == 3) {
            zzanVarZzd.zzb(zzjk.AD_STORAGE, zzjlVarZzB.zzb());
        } else {
            zzanVarZzd.zzc(zzjk.AD_STORAGE, zzam.FAILSAFE);
        }
        int iOrdinal2 = zzjlVarZzB.zzq().ordinal();
        if (iOrdinal2 == 1) {
            zzanVarZzd.zzc(zzjk.ANALYTICS_STORAGE, zzam.REMOTE_ENFORCED_DEFAULT);
        } else if (iOrdinal2 == 2 || iOrdinal2 == 3) {
            zzanVarZzd.zzb(zzjk.ANALYTICS_STORAGE, zzjlVarZzB.zzb());
        } else {
            zzanVarZzd.zzc(zzjk.ANALYTICS_STORAGE, zzam.FAILSAFE);
        }
        String strZzc2 = zzhVar.zzc();
        zzaX().zzg();
        zzu();
        zzba zzbaVarZzz = zzz(strZzc2, zzx(strZzc2), zzB(strZzc2), zzanVarZzd);
        zzicVar.zzaD(((Boolean) Preconditions.checkNotNull(zzbaVarZzz.zzj())).booleanValue());
        if (!TextUtils.isEmpty(zzbaVarZzz.zzk())) {
            zzicVar.zzaF(zzbaVarZzz.zzk());
        }
        zzaX().zzg();
        zzu();
        Iterator it = zzicVar.zzk().iterator();
        while (true) {
            if (it.hasNext()) {
                zziuVar = (com.google.android.gms.internal.measurement.zziu) it.next();
                if ("_npa".equals(zziuVar.zzc())) {
                    break;
                }
            } else {
                zziuVar = null;
                break;
            }
        }
        if (zziuVar != null) {
            zzjk zzjkVar = zzjk.AD_PERSONALIZATION;
            if (zzanVarZzd.zza(zzjkVar) == zzam.UNSET) {
                zzpn zzpnVarZzm = zzj().zzm(zzhVar.zzc(), "_npa");
                if (zzpnVarZzm != null) {
                    String str = zzpnVarZzm.zzb;
                    if ("tcf".equals(str)) {
                        zzanVarZzd.zzc(zzjkVar, zzam.TCF);
                    } else if (AndroidContextPlugin.APP_KEY.equals(str)) {
                        zzanVarZzd.zzc(zzjkVar, zzam.API);
                    } else {
                        zzanVarZzd.zzc(zzjkVar, zzam.MANIFEST);
                    }
                } else {
                    Boolean boolZzae = zzhVar.zzae();
                    if (boolZzae == null || ((boolZzae.booleanValue() && zziuVar.zzh() != 1) || !(boolZzae.booleanValue() || zziuVar.zzh() == 0))) {
                        zzanVarZzd.zzc(zzjkVar, zzam.API);
                    } else {
                        zzanVarZzd.zzc(zzjkVar, zzam.MANIFEST);
                    }
                }
            }
        } else {
            int iZzaD = zzaD(zzhVar.zzc(), zzanVarZzd);
            com.google.android.gms.internal.measurement.zzit zzitVarZzm = com.google.android.gms.internal.measurement.zziu.zzm();
            zzitVarZzm.zzb("_npa");
            zzitVarZzm.zza(zzba().currentTimeMillis());
            zzitVarZzm.zze(iZzaD);
            zzicVar.zzo((com.google.android.gms.internal.measurement.zziu) zzitVarZzm.zzbd());
            zzaW().zzk().zzc("Setting user property", "non_personalized_ads(_npa)", Integer.valueOf(iZzaD));
        }
        zzicVar.zzaB(zzanVarZzd.toString());
        boolean zZzz = this.zzc.zzz(zzhVar.zzc());
        List listZzb = zzicVar.zzb();
        int i = 0;
        for (int i2 = 0; i2 < listZzb.size(); i2++) {
            if ("_tcf".equals(((com.google.android.gms.internal.measurement.zzhs) listZzb.get(i2)).zzd())) {
                com.google.android.gms.internal.measurement.zzhr zzhrVar = (com.google.android.gms.internal.measurement.zzhr) ((com.google.android.gms.internal.measurement.zzhs) listZzb.get(i2)).zzco();
                List listZza = zzhrVar.zza();
                int i3 = 0;
                while (true) {
                    if (i3 >= listZza.size()) {
                        break;
                    }
                    if ("_tcfd".equals(((com.google.android.gms.internal.measurement.zzhw) listZza.get(i3)).zzb())) {
                        String strZzd = ((com.google.android.gms.internal.measurement.zzhw) listZza.get(i3)).zzd();
                        if (zZzz && strZzd.length() > 4) {
                            char[] charArray = strZzd.toCharArray();
                            int i4 = 1;
                            while (true) {
                                if (i4 >= 64) {
                                    break;
                                }
                                if (charArray[4] == "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i4)) {
                                    i = i4;
                                    break;
                                }
                                i4++;
                            }
                            charArray[4] = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i | 1);
                            strZzd = String.valueOf(charArray);
                        }
                        com.google.android.gms.internal.measurement.zzhv zzhvVarZzn = com.google.android.gms.internal.measurement.zzhw.zzn();
                        zzhvVarZzn.zzb("_tcfd");
                        zzhvVarZzn.zzd(strZzd);
                        zzhrVar.zze(i3, zzhvVarZzn);
                    } else {
                        i3++;
                    }
                }
                zzicVar.zzf(i2, zzhrVar);
                return;
            }
        }
    }

    final void zzJ(zzh zzhVar, com.google.android.gms.internal.measurement.zzic zzicVar) {
        zzaX().zzg();
        zzu();
        com.google.android.gms.internal.measurement.zzgx zzgxVarZzt = com.google.android.gms.internal.measurement.zzha.zzt();
        byte[] bArrZzaJ = zzhVar.zzaJ();
        if (bArrZzaJ != null) {
            try {
                zzgxVarZzt = (com.google.android.gms.internal.measurement.zzgx) zzpk.zzw(zzgxVarZzt, bArrZzaJ);
            } catch (zzaeh unused) {
                zzaW().zze().zzb("Failed to parse locally stored ad campaign info. appId", zzgu.zzl(zzhVar.zzc()));
            }
        }
        for (com.google.android.gms.internal.measurement.zzhs zzhsVar : zzicVar.zzb()) {
            if (zzhsVar.zzd().equals(Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN)) {
                String str = (String) zzpk.zzN(zzhsVar, "gclid", "");
                String str2 = (String) zzpk.zzN(zzhsVar, "gbraid", "");
                String str3 = (String) zzpk.zzN(zzhsVar, "gad_source", "");
                String str4 = (String) zzpk.zzN(zzhsVar, "deep_link_url", "");
                String[] strArrSplit = ((String) zzfy.zzbb.zzb(null)).split(",");
                zzp();
                if (!zzpk.zzK(zzhsVar, strArrSplit).isEmpty()) {
                    long jLongValue = ((Long) zzpk.zzN(zzhsVar, "click_timestamp", 0L)).longValue();
                    if (jLongValue <= 0) {
                        jLongValue = zzhsVar.zzf();
                    }
                    if ("referrer API v2".equals(zzpk.zzM(zzhsVar, "_cis"))) {
                        if (jLongValue > zzgxVarZzt.zzo()) {
                            if (str.isEmpty()) {
                                zzgxVarZzt.zzj();
                            } else {
                                zzgxVarZzt.zzi(str);
                            }
                            if (str2.isEmpty()) {
                                zzgxVarZzt.zzl();
                            } else {
                                zzgxVarZzt.zzk(str2);
                            }
                            if (str3.isEmpty()) {
                                zzgxVarZzt.zzn();
                            } else {
                                zzgxVarZzt.zzm(str3);
                            }
                            zzgxVarZzt.zzp(jLongValue);
                            zzgxVarZzt.zzs();
                            zzgxVarZzt.zzt(zzaE(zzhsVar));
                        }
                    } else if (jLongValue > zzgxVarZzt.zzg()) {
                        if (str.isEmpty()) {
                            zzgxVarZzt.zzb();
                        } else {
                            zzgxVarZzt.zza(str);
                        }
                        if (str2.isEmpty()) {
                            zzgxVarZzt.zzd();
                        } else {
                            zzgxVarZzt.zzc(str2);
                        }
                        if (str3.isEmpty()) {
                            zzgxVarZzt.zzf();
                        } else {
                            zzgxVarZzt.zze(str3);
                        }
                        if (zzd().zzp(null, zzfy.zzba)) {
                            if (str4.isEmpty()) {
                                zzgxVarZzt.zzv();
                            } else {
                                zzgxVarZzt.zzu(str4);
                            }
                        }
                        zzgxVarZzt.zzh(jLongValue);
                        zzgxVarZzt.zzq();
                        zzgxVarZzt.zzr(zzaE(zzhsVar));
                    }
                }
            }
        }
        if (!((com.google.android.gms.internal.measurement.zzha) zzgxVarZzt.zzbd()).equals(com.google.android.gms.internal.measurement.zzha.zzu())) {
            zzicVar.zzaM((com.google.android.gms.internal.measurement.zzha) zzgxVarZzt.zzbd());
        }
        zzhVar.zzaI(((com.google.android.gms.internal.measurement.zzha) zzgxVarZzt.zzbd()).zzcd());
        if (zzhVar.zza()) {
            zzj().zzv(zzhVar, false, false);
        }
        if (zzd().zzp(null, zzfy.zzba)) {
            for (int i = 0; i < zzicVar.zzc(); i++) {
                com.google.android.gms.internal.measurement.zzhs zzhsVarZzd = zzicVar.zzd(i);
                if (Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(zzhsVarZzd.zzd())) {
                    com.google.android.gms.internal.measurement.zzhr zzhrVar = (com.google.android.gms.internal.measurement.zzhr) zzhsVarZzd.zzco();
                    List listZza = zzhrVar.zza();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= listZza.size()) {
                            break;
                        }
                        if ("deep_link_url".equals(((com.google.android.gms.internal.measurement.zzhw) listZza.get(i2)).zzb())) {
                            zzhrVar.zzj(i2);
                            zzicVar.zzf(i, zzhrVar);
                            break;
                        }
                        i2++;
                    }
                }
            }
        }
        if (zzd().zzp(null, zzfy.zzaZ)) {
            zzj().zzk(zzhVar.zzc(), "_lgclid");
        }
    }

    final String zzK(zzjl zzjlVar) {
        if (!zzjlVar.zzo(zzjk.ANALYTICS_STORAGE)) {
            return null;
        }
        byte[] bArr = new byte[16];
        zzt().zzf().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    final void zzL(List list) {
        Preconditions.checkArgument(!list.isEmpty());
        if (this.zzz != null) {
            zzaW().zzb().zza("Set uploading progress before finishing the previous upload");
        } else {
            this.zzz = new ArrayList(list);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0108 A[Catch: all -> 0x01b9, DONT_GENERATE, PHI: r0 r6 r8
      0x0108: PHI (r0v25 java.lang.Object) = (r0v34 java.lang.Object), (r0v35 java.lang.Object), (r0v36 java.lang.Object) binds: [B:43:0x0125, B:37:0x0110, B:33:0x0106] A[DONT_GENERATE, DONT_INLINE]
      0x0108: PHI (r6v10 long) = (r6v6 long), (r6v11 long), (r6v6 long) binds: [B:43:0x0125, B:37:0x0110, B:33:0x0106] A[DONT_GENERATE, DONT_INLINE]
      0x0108: PHI (r8v13 ??) = (r8v22 ??), (r8v23 ??), (r8v24 ??) binds: [B:43:0x0125, B:37:0x0110, B:33:0x0106] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x01b9, blocks: (B:3:0x000e, B:5:0x001d, B:6:0x002c, B:8:0x0032, B:9:0x0041, B:11:0x0049, B:12:0x004e, B:14:0x0059, B:15:0x0068, B:17:0x0072, B:18:0x0084, B:20:0x00a3, B:22:0x00a9, B:23:0x00ac, B:25:0x00c5, B:26:0x00dc, B:28:0x00ec, B:30:0x00f2, B:34:0x0108, B:45:0x0128, B:47:0x012d, B:48:0x0130, B:49:0x0131, B:50:0x0136, B:56:0x0173, B:70:0x0198, B:72:0x019e, B:74:0x01a8, B:80:0x01b5, B:81:0x01b8, B:31:0x00f6, B:36:0x010c, B:42:0x0116), top: B:92:0x000e, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0173 A[Catch: all -> 0x01b9, PHI: r0 r4 r8
      0x0173: PHI (r0v8 ??) = (r0v46 ??), (r0v47 ??), (r0v48 ??) binds: [B:59:0x017b, B:55:0x0171, B:68:0x0195] A[DONT_GENERATE, DONT_INLINE]
      0x0173: PHI (r4v5 ??) = (r4v17 ??), (r4v18 ??), (r4v19 ??) binds: [B:59:0x017b, B:55:0x0171, B:68:0x0195] A[DONT_GENERATE, DONT_INLINE]
      0x0173: PHI (r8v2 ??) = (r8v33 ??), (r8v17 ?? I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), (r8v34 ??) binds: [B:59:0x017b, B:55:0x0171, B:68:0x0195] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x01b9, blocks: (B:3:0x000e, B:5:0x001d, B:6:0x002c, B:8:0x0032, B:9:0x0041, B:11:0x0049, B:12:0x004e, B:14:0x0059, B:15:0x0068, B:17:0x0072, B:18:0x0084, B:20:0x00a3, B:22:0x00a9, B:23:0x00ac, B:25:0x00c5, B:26:0x00dc, B:28:0x00ec, B:30:0x00f2, B:34:0x0108, B:45:0x0128, B:47:0x012d, B:48:0x0130, B:49:0x0131, B:50:0x0136, B:56:0x0173, B:70:0x0198, B:72:0x019e, B:74:0x01a8, B:80:0x01b5, B:81:0x01b8, B:31:0x00f6, B:36:0x010c, B:42:0x0116), top: B:92:0x000e, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x019e A[Catch: all -> 0x01b9, TryCatch #5 {all -> 0x01b9, blocks: (B:3:0x000e, B:5:0x001d, B:6:0x002c, B:8:0x0032, B:9:0x0041, B:11:0x0049, B:12:0x004e, B:14:0x0059, B:15:0x0068, B:17:0x0072, B:18:0x0084, B:20:0x00a3, B:22:0x00a9, B:23:0x00ac, B:25:0x00c5, B:26:0x00dc, B:28:0x00ec, B:30:0x00f2, B:34:0x0108, B:45:0x0128, B:47:0x012d, B:48:0x0130, B:49:0x0131, B:50:0x0136, B:56:0x0173, B:70:0x0198, B:72:0x019e, B:74:0x01a8, B:80:0x01b5, B:81:0x01b8, B:31:0x00f6, B:36:0x010c, B:42:0x0116), top: B:92:0x000e, inners: #2 }] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12, types: [com.google.android.gms.measurement.internal.zzaw] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v41 */
    /* JADX WARN: Type inference failed for: r0v42 */
    /* JADX WARN: Type inference failed for: r0v43 */
    /* JADX WARN: Type inference failed for: r0v44 */
    /* JADX WARN: Type inference failed for: r0v45 */
    /* JADX WARN: Type inference failed for: r0v46 */
    /* JADX WARN: Type inference failed for: r0v47 */
    /* JADX WARN: Type inference failed for: r0v48 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v8, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.google.android.gms.measurement.internal.zzpg] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v4, types: [com.google.android.gms.measurement.internal.zzaw, com.google.android.gms.measurement.internal.zzje, com.google.android.gms.measurement.internal.zzos] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [com.google.android.gms.measurement.internal.zzje] */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v10, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r8v14, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v27 */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v29 */
    /* JADX WARN: Type inference failed for: r8v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r8v30 */
    /* JADX WARN: Type inference failed for: r8v31 */
    /* JADX WARN: Type inference failed for: r8v32 */
    /* JADX WARN: Type inference failed for: r8v33 */
    /* JADX WARN: Type inference failed for: r8v34 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:85:0x01ab -> B:93:0x01ab). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void zzM() {
        long jZzF;
        Throwable th;
        SQLiteException e;
        ?? r4;
        ?? r0;
        boolean zIsEmpty;
        ?? r8;
        Object obj;
        ?? r82;
        Object obj2;
        boolean zMoveToFirst;
        zzaX().zzg();
        zzu();
        ?? RawQuery = 1;
        this.zzw = true;
        try {
            zzic zzicVar = this.zzn;
            zzicVar.zzaV();
            Boolean boolZzJ = zzicVar.zzt().zzJ();
            if (boolZzJ == null) {
                zzaW().zze().zza("Upload data called on the client side before use of service was decided");
            } else if (boolZzJ.booleanValue()) {
                zzaW().zzb().zza("Upload called in the client side when service should be used");
            } else if (this.zza > 0) {
                zzaM();
            } else {
                zzaX().zzg();
                if (this.zzz != null) {
                    zzaW().zzk().zza("Uploading requested multiple times");
                } else if (zzi().zzb()) {
                    long jCurrentTimeMillis = zzba().currentTimeMillis();
                    ?? r83 = 0;
                    RawQuery = 0;
                    RawQuery = 0;
                    RawQuery = 0;
                    RawQuery = 0;
                    ?? r84 = 0;
                    RawQuery = 0;
                    ?? RawQuery2 = 0;
                    int iZzm = zzd().zzm(null, zzfy.zzah);
                    zzd();
                    long jZzF2 = jCurrentTimeMillis - zzal.zzF();
                    for (int i = 0; i < iZzm && zzaH(null, jZzF2); i++) {
                    }
                    zzaif.zza();
                    zzaX().zzg();
                    zzaw();
                    long jZza = this.zzk.zzd.zza();
                    if (jZza != 0) {
                        zzaW().zzj().zzb("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(jCurrentTimeMillis - jZza)));
                    }
                    ?? ZzF = zzj().zzF();
                    long j = -1;
                    if (TextUtils.isEmpty(ZzF)) {
                        try {
                            this.zzB = -1L;
                            ZzF = zzj();
                            zzd();
                            jZzF = jCurrentTimeMillis - zzal.zzF();
                            ZzF.zzg();
                            ZzF.zzay();
                        } catch (Throwable th2) {
                            th = th2;
                            r83 = RawQuery;
                        }
                        try {
                            RawQuery = ZzF.zze().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(jZzF)});
                            try {
                            } catch (SQLiteException e2) {
                                e = e2;
                                zzgs zzgsVarZzb = ZzF.zzu.zzaW().zzb();
                                String str = "Error selecting expired configs";
                                zzgsVarZzb.zzb("Error selecting expired configs", e);
                                ZzF = str;
                                RawQuery2 = RawQuery2;
                                r0 = RawQuery;
                                r4 = str;
                                r84 = RawQuery2;
                                if (RawQuery != 0) {
                                }
                            }
                        } catch (SQLiteException e3) {
                            e = e3;
                            RawQuery = 0;
                            zzgs zzgsVarZzb2 = ZzF.zzu.zzaW().zzb();
                            String str2 = "Error selecting expired configs";
                            zzgsVarZzb2.zzb("Error selecting expired configs", e);
                            ZzF = str2;
                            RawQuery2 = RawQuery2;
                            r0 = RawQuery;
                            r4 = str2;
                            r84 = RawQuery2;
                            if (RawQuery != 0) {
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            if (r83 != 0) {
                                r83.close();
                            }
                            throw th;
                        }
                        if (RawQuery.moveToFirst()) {
                            String string = RawQuery.getString(0);
                            ZzF = ZzF;
                            RawQuery2 = string;
                            r0 = RawQuery;
                            r4 = ZzF;
                            r84 = string;
                            if (RawQuery != 0) {
                            }
                            zIsEmpty = TextUtils.isEmpty(RawQuery2);
                            RawQuery = zIsEmpty;
                            if (!zIsEmpty) {
                            }
                        } else {
                            ZzF.zzu.zzaW().zzk().zza("No expired configs for apps with pending events");
                            ZzF = ZzF;
                            r0 = RawQuery;
                            r4 = ZzF;
                            if (RawQuery != 0) {
                                r0.close();
                                ZzF = r4;
                                RawQuery2 = r84;
                            }
                            zIsEmpty = TextUtils.isEmpty(RawQuery2);
                            RawQuery = zIsEmpty;
                            if (!zIsEmpty) {
                                zzh zzhVarZzu = zzj().zzu(RawQuery2);
                                RawQuery = zzhVarZzu;
                                if (zzhVarZzu != null) {
                                    zzX(zzhVarZzu);
                                    RawQuery = zzhVarZzu;
                                }
                            }
                        }
                    } else {
                        int i2 = (this.zzB > (-1L) ? 1 : (this.zzB == (-1L) ? 0 : -1));
                        RawQuery = i2;
                        if (i2 == 0) {
                            zzaw zzawVarZzj = zzj();
                            try {
                                try {
                                    RawQuery2 = zzawVarZzj.zze().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                                    zMoveToFirst = RawQuery2.moveToFirst();
                                    obj2 = zzawVarZzj;
                                    r82 = RawQuery2;
                                    obj = zzawVarZzj;
                                    r8 = RawQuery2;
                                } catch (SQLiteException e4) {
                                    zzgs zzgsVarZzb3 = zzawVarZzj.zzu.zzaW().zzb();
                                    zzgsVarZzb3.zzb("Error querying raw events", e4);
                                    obj2 = zzgsVarZzb3;
                                    r82 = RawQuery2;
                                    obj = zzgsVarZzb3;
                                    r8 = RawQuery2;
                                    if (RawQuery2 != 0) {
                                    }
                                    this.zzB = j;
                                    RawQuery = obj;
                                    RawQuery2 = r8;
                                    zzN(ZzF, jCurrentTimeMillis);
                                }
                                if (zMoveToFirst) {
                                    j = RawQuery2.getLong(0);
                                    obj2 = zzawVarZzj;
                                    r82 = RawQuery2;
                                    obj = zzawVarZzj;
                                    r8 = RawQuery2;
                                    if (RawQuery2 != 0) {
                                    }
                                    this.zzB = j;
                                    RawQuery = obj;
                                    RawQuery2 = r8;
                                } else {
                                    this.zzB = j;
                                    RawQuery = obj;
                                    RawQuery2 = r8;
                                }
                            } finally {
                                if (RawQuery2 != 0) {
                                    RawQuery2.close();
                                }
                            }
                        }
                        zzN(ZzF, jCurrentTimeMillis);
                    }
                } else {
                    zzaW().zzk().zza("Network not connected, ignoring upload request");
                    zzaM();
                }
            }
        } finally {
            this.zzw = false;
            zzaN();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0447 A[PHI: r10 r16 r17
      0x0447: PHI (r10v39 java.util.List) = (r10v51 java.util.List), (r10v38 java.util.List) binds: [B:167:0x0474, B:155:0x0445] A[DONT_GENERATE, DONT_INLINE]
      0x0447: PHI (r16v7 java.util.List) = (r16v12 java.util.List), (r16v14 java.util.List) binds: [B:167:0x0474, B:155:0x0445] A[DONT_GENERATE, DONT_INLINE]
      0x0447: PHI (r17v4 android.database.Cursor) = (r17v8 android.database.Cursor), (r17v11 android.database.Cursor) binds: [B:167:0x0474, B:155:0x0445] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0482  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0552  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x056d  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x05e9  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0612  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0774  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x0785  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x09b5  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x0a04  */
    /* JADX WARN: Removed duplicated region for block: B:453:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:455:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:456:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0214  */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v58 */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r32v0, types: [com.google.android.gms.measurement.internal.zzpg] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void zzN(String str, long j) throws Throwable {
        long j2;
        ?? r14;
        Cursor cursorQuery;
        List listEmptyList;
        List<Pair> listSubList;
        zzjl zzjlVarZzB;
        zzjk zzjkVar;
        com.google.android.gms.internal.measurement.zzhz zzhzVarZzi;
        int size;
        int i;
        boolean z;
        String strZzi;
        String string;
        zzot zzotVar;
        boolean z2;
        List list;
        boolean z3;
        int i2;
        String strZzG;
        Cursor cursor;
        List list2;
        Cursor cursor2;
        Iterator it;
        List list3;
        int i3;
        int i4;
        SQLiteDatabase sQLiteDatabaseZze;
        long jCurrentTimeMillis;
        Cursor cursorQuery2;
        byte[] blob;
        zzpk zzpkVarZzp;
        long jZzh;
        long jZzh2;
        int iZzm = zzd().zzm(str, zzfy.zzg);
        int i5 = 0;
        int iMax = Math.max(0, zzd().zzm(str, zzfy.zzh));
        zzaw zzawVarZzj = zzj();
        zzawVarZzj.zzg();
        zzawVarZzj.zzay();
        int i6 = 1;
        Preconditions.checkArgument(iZzm > 0);
        ?? r10 = iMax > 0 ? 1 : 0;
        Preconditions.checkArgument(r10);
        Preconditions.checkNotEmpty(str);
        try {
            try {
                try {
                    j2 = -1;
                    try {
                        cursorQuery = zzawVarZzj.zze().query("queue", new String[]{"rowid", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(iZzm));
                        try {
                        } catch (SQLiteException e) {
                            e = e;
                            zzawVarZzj.zzu.zzaW().zzb().zzc("Error querying bundles. appId", zzgu.zzl(str), e);
                            listEmptyList = Collections.emptyList();
                            if (cursorQuery != null) {
                            }
                            listSubList = listEmptyList;
                            if (!listSubList.isEmpty()) {
                            }
                        }
                    } catch (SQLiteException e2) {
                        e = e2;
                        cursorQuery = null;
                        zzawVarZzj.zzu.zzaW().zzb().zzc("Error querying bundles. appId", zzgu.zzl(str), e);
                        listEmptyList = Collections.emptyList();
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        listSubList = listEmptyList;
                        if (!listSubList.isEmpty()) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    r14 = r10;
                    if (r14 != 0) {
                        r14.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                r14 = 0;
                if (r14 != 0) {
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            j2 = -1;
        }
        if (cursorQuery.moveToFirst()) {
            listSubList = new ArrayList();
            int length = 0;
            while (true) {
                long j3 = cursorQuery.getLong(i5);
                try {
                    blob = cursorQuery.getBlob(i6);
                    zzpkVarZzp = zzawVarZzj.zzg.zzp();
                } catch (IOException e4) {
                    zzawVarZzj.zzu.zzaW().zzb().zzc("Failed to unzip queued bundle. appId", zzgu.zzl(str), e4);
                }
                try {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(blob);
                    GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i7 = gZIPInputStream.read(bArr);
                        if (i7 <= 0) {
                            break;
                        }
                        ByteArrayInputStream byteArrayInputStream2 = byteArrayInputStream;
                        byteArrayOutputStream.write(bArr, 0, i7);
                        byteArrayInputStream = byteArrayInputStream2;
                    }
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    if (!listSubList.isEmpty() && byteArray.length + length > iMax) {
                        break;
                    }
                    try {
                        com.google.android.gms.internal.measurement.zzic zzicVar = (com.google.android.gms.internal.measurement.zzic) zzpk.zzw(com.google.android.gms.internal.measurement.zzid.zzaE(), byteArray);
                        if (!listSubList.isEmpty()) {
                            com.google.android.gms.internal.measurement.zzid zzidVar = (com.google.android.gms.internal.measurement.zzid) ((Pair) listSubList.get(0)).first;
                            com.google.android.gms.internal.measurement.zzid zzidVar2 = (com.google.android.gms.internal.measurement.zzid) zzicVar.zzbd();
                            if (!zzidVar.zzaf().equals(zzidVar2.zzaf()) || !zzidVar.zzam().equals(zzidVar2.zzam()) || zzidVar.zzao() != zzidVar2.zzao() || !zzidVar.zzaq().equals(zzidVar2.zzaq())) {
                                break;
                            }
                            Iterator it2 = zzidVar.zzf().iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    jZzh = -1;
                                    break;
                                }
                                com.google.android.gms.internal.measurement.zziu zziuVar = (com.google.android.gms.internal.measurement.zziu) it2.next();
                                Iterator it3 = it2;
                                if ("_npa".equals(zziuVar.zzc())) {
                                    jZzh = zziuVar.zzh();
                                    break;
                                }
                                it2 = it3;
                            }
                            Iterator it4 = zzidVar2.zzf().iterator();
                            while (true) {
                                if (!it4.hasNext()) {
                                    jZzh2 = -1;
                                    break;
                                }
                                com.google.android.gms.internal.measurement.zziu zziuVar2 = (com.google.android.gms.internal.measurement.zziu) it4.next();
                                if ("_npa".equals(zziuVar2.zzc())) {
                                    jZzh2 = zziuVar2.zzh();
                                    break;
                                }
                            }
                            if (jZzh != jZzh2) {
                                break;
                            }
                        }
                        if (!cursorQuery.isNull(2)) {
                            zzicVar.zzao(cursorQuery.getInt(2));
                        }
                        length += byteArray.length;
                        listSubList.add(Pair.create((com.google.android.gms.internal.measurement.zzid) zzicVar.zzbd(), Long.valueOf(j3)));
                    } catch (IOException e5) {
                        zzawVarZzj.zzu.zzaW().zzb().zzc("Failed to merge queued bundle. appId", zzgu.zzl(str), e5);
                    }
                    if (!cursorQuery.moveToNext() || length > iMax) {
                        break;
                    }
                    i5 = 0;
                    i6 = 1;
                } catch (IOException e6) {
                    zzpkVarZzp.zzu.zzaW().zzb().zzb("Failed to ungzip content", e6);
                    throw e6;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            if (!listSubList.isEmpty()) {
            }
        } else {
            listEmptyList = Collections.emptyList();
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            listSubList = listEmptyList;
            if (!listSubList.isEmpty()) {
                return;
            }
            zzahh.zza();
            zzal zzalVarZzd = zzd();
            zzfx zzfxVar = zzfy.zzbc;
            if (zzalVarZzd.zzp(null, zzfxVar)) {
                zzahh.zza();
                if (zzd().zzp(null, zzfxVar)) {
                    if (zzB(str).zzo(zzjk.ANALYTICS_STORAGE) || !zzh().zzC(str)) {
                        ArrayList arrayList = new ArrayList(listSubList.size());
                        zzaw zzawVarZzj2 = zzj();
                        Preconditions.checkNotEmpty(str);
                        zzawVarZzj2.zzg();
                        zzawVarZzj2.zzay();
                        List arrayList2 = new ArrayList();
                        try {
                            try {
                                sQLiteDatabaseZze = zzawVarZzj2.zze();
                                jCurrentTimeMillis = zzawVarZzj2.zzu.zzba().currentTimeMillis();
                                cursorQuery2 = sQLiteDatabaseZze.query("no_data_mode_events", new String[]{Constants.ScionAnalytics.MessageType.DATA_MESSAGE}, "app_id=? AND timestamp_millis <= CAST(? AS INTEGER)", new String[]{str, String.valueOf(jCurrentTimeMillis)}, null, null, "rowid", null);
                                list2 = listSubList;
                            } catch (SQLiteException e7) {
                                e = e7;
                                list2 = listSubList;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            cursor = null;
                        }
                        try {
                        } catch (SQLiteException e8) {
                            e = e8;
                            cursor2 = cursorQuery2;
                            zzawVarZzj2.zzu.zzaW().zzb().zzc("Error flushing NO_DATA mode events. appId", zzgu.zzl(str), e);
                            arrayList2 = Collections.emptyList();
                            if (cursor2 != null) {
                            }
                            it = list2.iterator();
                            boolean z4 = true;
                            while (it.hasNext()) {
                            }
                            listSubList = arrayList;
                            if (listSubList.isEmpty()) {
                            }
                            zzjlVarZzB = zzB(str);
                            zzjkVar = zzjk.AD_STORAGE;
                            if (zzjlVarZzB.zzo(zzjkVar)) {
                            }
                            zzhzVarZzi = com.google.android.gms.internal.measurement.zzib.zzi();
                            size = listSubList.size();
                            ArrayList arrayList3 = new ArrayList(listSubList.size());
                            if (zzd().zzC(str)) {
                            }
                            boolean zZzo = zzB(str).zzo(zzjkVar);
                            boolean zZzo2 = zzB(str).zzo(zzjk.ANALYTICS_STORAGE);
                            zzair.zza();
                            boolean zZzp = zzd().zzp(str, zzfy.zzaM);
                            zzou zzouVar = this.zzl;
                            zzot zzotVarZza = zzouVar.zza(str);
                            i = 0;
                            while (i < size) {
                            }
                            if (zzhzVarZzi.zzb() != 0) {
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            cursor2 = cursorQuery2;
                            cursor = cursor2;
                            if (cursor != null) {
                            }
                            throw th;
                        }
                        if (cursorQuery2.moveToFirst()) {
                            while (true) {
                                try {
                                    arrayList2.add((com.google.android.gms.internal.measurement.zzhs) ((com.google.android.gms.internal.measurement.zzhr) zzpk.zzw(com.google.android.gms.internal.measurement.zzhs.zzp(), cursorQuery2.getBlob(0))).zzbd());
                                    cursor2 = cursorQuery2;
                                } catch (zzaeh e9) {
                                    cursor2 = cursorQuery2;
                                    try {
                                        try {
                                            zzawVarZzj2.zzu.zzaW().zzh().zzc("Failed to parse stored NO_DATA mode event, appId", zzgu.zzl(str), e9);
                                        } catch (SQLiteException e10) {
                                            e = e10;
                                            zzawVarZzj2.zzu.zzaW().zzb().zzc("Error flushing NO_DATA mode events. appId", zzgu.zzl(str), e);
                                            arrayList2 = Collections.emptyList();
                                            if (cursor2 != null) {
                                            }
                                        }
                                    } catch (Throwable th5) {
                                        th = th5;
                                        cursor = cursor2;
                                        if (cursor != null) {
                                        }
                                        throw th;
                                    }
                                }
                                if (!cursor2.moveToNext()) {
                                    break;
                                } else {
                                    cursorQuery2 = cursor2;
                                }
                                if (cursor != null) {
                                    cursor.close();
                                }
                                throw th;
                            }
                            cursor2.close();
                            try {
                                int iDelete = sQLiteDatabaseZze.delete("no_data_mode_events", "app_id=? AND timestamp_millis <= CAST(? AS INTEGER)", new String[]{str, String.valueOf(jCurrentTimeMillis)});
                                zzgs zzgsVarZzk = zzawVarZzj2.zzu.zzaW().zzk();
                                StringBuilder sb = new StringBuilder(String.valueOf(iDelete).length() + 34);
                                sb.append("Pruned ");
                                sb.append(iDelete);
                                sb.append(" NO_DATA mode events. appId");
                                zzgsVarZzk.zzb(sb.toString(), str);
                            } catch (SQLiteException e11) {
                                e = e11;
                                cursor2 = null;
                                zzawVarZzj2.zzu.zzaW().zzb().zzc("Error flushing NO_DATA mode events. appId", zzgu.zzl(str), e);
                                arrayList2 = Collections.emptyList();
                                if (cursor2 != null) {
                                }
                            }
                        } else {
                            cursor2 = cursorQuery2;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                        }
                        it = list2.iterator();
                        boolean z42 = true;
                        while (it.hasNext()) {
                            Pair pair = (Pair) it.next();
                            com.google.android.gms.internal.measurement.zzic zzicVar2 = (com.google.android.gms.internal.measurement.zzic) ((com.google.android.gms.internal.measurement.zzid) pair.first).zzco();
                            if (z42 && !arrayList2.isEmpty()) {
                                List listZzb = zzicVar2.zzb();
                                zzicVar2.zzi();
                                zzicVar2.zzh(arrayList2);
                                zzicVar2.zzh(listZzb);
                                z42 = false;
                            }
                            com.google.android.gms.internal.measurement.zzhh zzhhVarZzb = com.google.android.gms.internal.measurement.zzho.zzb();
                            com.google.android.gms.internal.measurement.zzgf zzgfVarZzy = zzh().zzy(str);
                            ArrayList arrayList4 = new ArrayList();
                            if (zzgfVarZzy != null) {
                                for (com.google.android.gms.internal.measurement.zzfu zzfuVar : zzgfVarZzy.zza()) {
                                    com.google.android.gms.internal.measurement.zzhk zzhkVarZza = com.google.android.gms.internal.measurement.zzhl.zza();
                                    int iZzb = zzfuVar.zzb();
                                    zzji zzjiVar = zzji.UNINITIALIZED;
                                    Iterator it5 = it;
                                    int i8 = iZzb - 1;
                                    boolean z5 = z42;
                                    if (i8 == 1) {
                                        list3 = arrayList2;
                                        i3 = 3;
                                        i4 = 2;
                                    } else if (i8 != 2) {
                                        list3 = arrayList2;
                                        i3 = 3;
                                        i4 = i8 != 3 ? i8 != 4 ? 1 : 5 : 4;
                                    } else {
                                        list3 = arrayList2;
                                        i3 = 3;
                                        i4 = 3;
                                    }
                                    zzhkVarZza.zza(i4);
                                    int iZzd = zzfuVar.zzd() - 1;
                                    zzhkVarZza.zzb(iZzd != 1 ? iZzd != 2 ? 1 : i3 : 2);
                                    arrayList4.add((com.google.android.gms.internal.measurement.zzhl) zzhkVarZza.zzbd());
                                    z42 = z5;
                                    it = it5;
                                    arrayList2 = list3;
                                }
                            }
                            Iterator it6 = it;
                            boolean z6 = z42;
                            List list4 = arrayList2;
                            zzhhVarZzb.zza(arrayList4);
                            zzicVar2.zzaP(zzhhVarZzb);
                            arrayList.add(Pair.create((com.google.android.gms.internal.measurement.zzid) zzicVar2.zzbd(), (Long) pair.second));
                            z42 = z6;
                            it = it6;
                            arrayList2 = list4;
                        }
                        listSubList = arrayList;
                    } else {
                        List listAsList = Arrays.asList(((String) zzfy.zzbd.zzb(null)).split(","));
                        for (Pair pair2 : listSubList) {
                            try {
                                zzj().zzH(((Long) pair2.second).longValue());
                                for (com.google.android.gms.internal.measurement.zzhs zzhsVar : ((com.google.android.gms.internal.measurement.zzid) pair2.first).zzc()) {
                                    if (listAsList.contains(zzhsVar.zzd())) {
                                        if (zzhsVar.zzd().equals("_f") || zzhsVar.zzd().equals("_v")) {
                                            com.google.android.gms.internal.measurement.zzhr zzhrVar = (com.google.android.gms.internal.measurement.zzhr) zzhsVar.zzco();
                                            zzp();
                                            zzpk.zzF(zzhrVar, "_dac", 1L);
                                            zzhsVar = (com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbd();
                                        }
                                        zzaw zzawVarZzj3 = zzj();
                                        zzawVarZzj3.zzg();
                                        zzawVarZzj3.zzay();
                                        Preconditions.checkNotNull(zzhsVar);
                                        Preconditions.checkNotEmpty(str);
                                        zzic zzicVar3 = zzawVarZzj3.zzu;
                                        zzicVar3.zzaW().zzk().zzb("Caching events in NO_DATA mode", zzhsVar);
                                        ContentValues contentValues = new ContentValues();
                                        contentValues.put("app_id", str);
                                        contentValues.put("name", zzhsVar.zzd());
                                        contentValues.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, zzhsVar.zzcd());
                                        contentValues.put("timestamp_millis", Long.valueOf(zzhsVar.zzf()));
                                        try {
                                            if (zzawVarZzj3.zze().insert("no_data_mode_events", null, contentValues) == j2) {
                                                zzicVar3.zzaW().zzb().zzb("Failed to insert NO_DATA mode event (got -1). appId", zzgu.zzl(str));
                                            }
                                        } catch (SQLiteException e12) {
                                            zzawVarZzj3.zzu.zzaW().zzb().zzc("Error storing NO_DATA mode event. appId", zzgu.zzl(str), e12);
                                        }
                                    }
                                }
                            } catch (SQLiteException unused) {
                                zzaW().zzh().zzb("Failed handling NO_DATA mode bundles. appId", str);
                            }
                        }
                        listSubList = Collections.emptyList();
                    }
                }
                if (listSubList.isEmpty()) {
                    return;
                }
            }
            zzjlVarZzB = zzB(str);
            zzjkVar = zzjk.AD_STORAGE;
            if (zzjlVarZzB.zzo(zzjkVar)) {
                Iterator it7 = listSubList.iterator();
                while (true) {
                    if (!it7.hasNext()) {
                        strZzG = null;
                        break;
                    }
                    com.google.android.gms.internal.measurement.zzid zzidVar3 = (com.google.android.gms.internal.measurement.zzid) ((Pair) it7.next()).first;
                    if (!zzidVar3.zzG().isEmpty()) {
                        strZzG = zzidVar3.zzG();
                        break;
                    }
                }
                if (strZzG != null) {
                    int i9 = 0;
                    while (true) {
                        if (i9 >= listSubList.size()) {
                            break;
                        }
                        com.google.android.gms.internal.measurement.zzid zzidVar4 = (com.google.android.gms.internal.measurement.zzid) ((Pair) listSubList.get(i9)).first;
                        if (!zzidVar4.zzG().isEmpty() && !zzidVar4.zzG().equals(strZzG)) {
                            listSubList = listSubList.subList(0, i9);
                            break;
                        }
                        i9++;
                    }
                }
            }
            zzhzVarZzi = com.google.android.gms.internal.measurement.zzib.zzi();
            size = listSubList.size();
            ArrayList arrayList32 = new ArrayList(listSubList.size());
            boolean z7 = !zzd().zzC(str) && zzB(str).zzo(zzjkVar);
            boolean zZzo3 = zzB(str).zzo(zzjkVar);
            boolean zZzo22 = zzB(str).zzo(zzjk.ANALYTICS_STORAGE);
            zzair.zza();
            boolean zZzp2 = zzd().zzp(str, zzfy.zzaM);
            zzou zzouVar2 = this.zzl;
            zzot zzotVarZza2 = zzouVar2.zza(str);
            i = 0;
            while (i < size) {
                boolean z8 = zZzo3;
                com.google.android.gms.internal.measurement.zzic zzicVar4 = (com.google.android.gms.internal.measurement.zzic) ((com.google.android.gms.internal.measurement.zzid) ((Pair) listSubList.get(i)).first).zzco();
                int i10 = size;
                arrayList32.add((Long) ((Pair) listSubList.get(i)).second);
                zzd().zzi();
                boolean z9 = z7;
                boolean z10 = zZzo22;
                zzicVar4.zzO(161000L);
                zzicVar4.zzs(j);
                this.zzn.zzaV();
                zzicVar4.zzae(false);
                if (!z9) {
                    zzicVar4.zzan();
                }
                if (!z8) {
                    zzicVar4.zzR();
                    zzicVar4.zzU();
                }
                if (!z10) {
                    zzicVar4.zzX();
                }
                zzS(str, zzicVar4);
                if (!zZzp2) {
                    zzicVar4.zzav();
                }
                if (!z10) {
                    zzicVar4.zzag();
                }
                String strZzP = zzicVar4.zzP();
                if (TextUtils.isEmpty(strZzP) || strZzP.equals("00000000-0000-0000-0000-000000000000")) {
                    ArrayList arrayList5 = new ArrayList(zzicVar4.zzb());
                    Iterator it8 = arrayList5.iterator();
                    z2 = z9;
                    Long lValueOf = null;
                    Long lValueOf2 = null;
                    boolean z11 = false;
                    boolean z12 = false;
                    while (it8.hasNext()) {
                        List list5 = listSubList;
                        com.google.android.gms.internal.measurement.zzhs zzhsVar2 = (com.google.android.gms.internal.measurement.zzhs) it8.next();
                        boolean z13 = zZzp2;
                        int i11 = i;
                        if ("_fx".equals(zzhsVar2.zzd())) {
                            it8.remove();
                            zZzp2 = z13;
                            listSubList = list5;
                            i = i11;
                            z11 = true;
                        } else if ("_f".equals(zzhsVar2.zzd())) {
                            zzp();
                            com.google.android.gms.internal.measurement.zzhw zzhwVarZzI = zzpk.zzI(zzhsVar2, "_pfo");
                            if (zzhwVarZzI != null) {
                                lValueOf = Long.valueOf(zzhwVarZzI.zzf());
                            }
                            zzp();
                            com.google.android.gms.internal.measurement.zzhw zzhwVarZzI2 = zzpk.zzI(zzhsVar2, "_uwa");
                            if (zzhwVarZzI2 != null) {
                                lValueOf2 = Long.valueOf(zzhwVarZzI2.zzf());
                            }
                            zZzp2 = z13;
                            listSubList = list5;
                            i = i11;
                        } else {
                            zZzp2 = z13;
                            listSubList = list5;
                            i = i11;
                        }
                        z12 = true;
                    }
                    list = listSubList;
                    z3 = zZzp2;
                    i2 = i;
                    if (z11) {
                        zzicVar4.zzi();
                        zzicVar4.zzh(arrayList5);
                    }
                    if (z12) {
                        zzR(zzicVar4.zzK(), true, lValueOf, lValueOf2);
                    }
                } else {
                    z2 = z9;
                    list = listSubList;
                    z3 = zZzp2;
                    i2 = i;
                }
                if (zzicVar4.zzc() != 0) {
                    if (zzd().zzp(str, zzfy.zzaC)) {
                        zzicVar4.zzas(zzp().zzt(((com.google.android.gms.internal.measurement.zzid) zzicVar4.zzbd()).zzcd()));
                    }
                    com.google.android.gms.internal.measurement.zzis zzisVarZzd = zzotVarZza2.zzd();
                    if (zzisVarZzd != null) {
                        zzicVar4.zzaN(zzisVarZzd);
                    }
                    zzhzVarZzi.zze(zzicVar4);
                }
                i = i2 + 1;
                zZzo22 = z10;
                zZzo3 = z8;
                size = i10;
                z7 = z2;
                zZzp2 = z3;
                listSubList = list;
            }
            if (zzhzVarZzi.zzb() != 0) {
                zzL(arrayList32);
                zzW(false, 204, null, null, str, Collections.emptyList(), null);
                return;
            }
            com.google.android.gms.internal.measurement.zzib zzibVar = (com.google.android.gms.internal.measurement.zzib) zzhzVarZzi.zzbd();
            ArrayList arrayList6 = new ArrayList();
            boolean z14 = zzotVarZza2.zzc() == zzls.SGTM_CLIENT;
            if (zzotVarZza2.zzc() == zzls.SGTM) {
                z = z14;
            } else {
                if (!z14) {
                    strZzi = null;
                    if (zzi().zzb()) {
                        return;
                    }
                    if (Log.isLoggable(zzaW().zzn(), 2)) {
                        strZzi = zzp().zzi(zzibVar);
                    }
                    zzp();
                    byte[] bArrZzcd = zzibVar.zzcd();
                    zzL(arrayList32);
                    this.zzk.zze.zzb(j);
                    zzaW().zzk().zzd("Uploading data. app, uncompressed size, data", str, Integer.valueOf(bArrZzcd.length), strZzi);
                    this.zzv = true;
                    zzi().zzc(str, zzotVarZza2, zzibVar, new zzow(this, str, arrayList6));
                    return;
                }
                z = true;
            }
            Iterator it9 = ((com.google.android.gms.internal.measurement.zzib) zzhzVarZzi.zzbd()).zza().iterator();
            while (true) {
                if (it9.hasNext()) {
                    if (((com.google.android.gms.internal.measurement.zzid) it9.next()).zzY()) {
                        string = UUID.randomUUID().toString();
                        break;
                    }
                } else {
                    string = null;
                    break;
                }
            }
            com.google.android.gms.internal.measurement.zzib zzibVar2 = (com.google.android.gms.internal.measurement.zzib) zzhzVarZzi.zzbd();
            zzaX().zzg();
            zzu();
            com.google.android.gms.internal.measurement.zzhz zzhzVarZzj = com.google.android.gms.internal.measurement.zzib.zzj(zzibVar2);
            if (!TextUtils.isEmpty(string)) {
                zzhzVarZzj.zzi(string);
            }
            String strZzc = zzh().zzc(str);
            if (!TextUtils.isEmpty(strZzc)) {
                zzhzVarZzj.zzj(strZzc);
            }
            ArrayList arrayList7 = new ArrayList();
            Iterator it10 = zzibVar2.zza().iterator();
            while (it10.hasNext()) {
                com.google.android.gms.internal.measurement.zzic zzicVarZzaF = com.google.android.gms.internal.measurement.zzid.zzaF((com.google.android.gms.internal.measurement.zzid) it10.next());
                zzicVarZzaF.zzan();
                arrayList7.add((com.google.android.gms.internal.measurement.zzid) zzicVarZzaF.zzbd());
            }
            zzhzVarZzj.zzg();
            zzhzVarZzj.zzf(arrayList7);
            zzaW().zzk().zzb("[sgtm] Processed MeasurementBatch for sGTM with sgtmJoinId: ", TextUtils.isEmpty(string) ? AbstractJsonLexerKt.NULL : zzhzVarZzj.zzh());
            com.google.android.gms.internal.measurement.zzib zzibVar3 = (com.google.android.gms.internal.measurement.zzib) zzhzVarZzj.zzbd();
            if (TextUtils.isEmpty(string)) {
                strZzi = null;
            } else {
                com.google.android.gms.internal.measurement.zzib zzibVar4 = (com.google.android.gms.internal.measurement.zzib) zzhzVarZzi.zzbd();
                zzaX().zzg();
                zzu();
                com.google.android.gms.internal.measurement.zzhz zzhzVarZzi2 = com.google.android.gms.internal.measurement.zzib.zzi();
                zzaW().zzk().zzb("[sgtm] Processing Google Signal, sgtmJoinId:", string);
                zzhzVarZzi2.zzi(string);
                for (com.google.android.gms.internal.measurement.zzid zzidVar5 : zzibVar4.zza()) {
                    com.google.android.gms.internal.measurement.zzic zzicVarZzaE = com.google.android.gms.internal.measurement.zzid.zzaE();
                    zzicVarZzaE.zzam(zzidVar5.zzZ());
                    zzicVarZzaE.zzaJ(zzidVar5.zzav());
                    zzhzVarZzi2.zze(zzicVarZzaE);
                }
                com.google.android.gms.internal.measurement.zzib zzibVar5 = (com.google.android.gms.internal.measurement.zzib) zzhzVarZzi2.zzbd();
                String strZzc2 = zzouVar2.zzg.zzh().zzc(str);
                if (TextUtils.isEmpty(strZzc2)) {
                    strZzi = null;
                    zzotVar = new zzot((String) zzfy.zzr.zzb(null), Collections.emptyMap(), z ? zzls.GOOGLE_SIGNAL_PENDING : zzls.GOOGLE_SIGNAL, null);
                } else {
                    Uri uri = Uri.parse((String) zzfy.zzr.zzb(null));
                    Uri.Builder builderBuildUpon = uri.buildUpon();
                    String authority = uri.getAuthority();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(strZzc2).length() + 1 + String.valueOf(authority).length());
                    sb2.append(strZzc2);
                    sb2.append(".");
                    sb2.append(authority);
                    builderBuildUpon.authority(sb2.toString());
                    strZzi = null;
                    zzotVar = new zzot(builderBuildUpon.build().toString(), Collections.emptyMap(), z ? zzls.GOOGLE_SIGNAL_PENDING : zzls.GOOGLE_SIGNAL, null);
                }
                arrayList6.add(Pair.create(zzibVar5, zzotVar));
            }
            if (z) {
                com.google.android.gms.internal.measurement.zzhz zzhzVar = (com.google.android.gms.internal.measurement.zzhz) zzibVar3.zzco();
                for (int i12 = 0; i12 < zzibVar3.zzb(); i12++) {
                    com.google.android.gms.internal.measurement.zzic zzicVar5 = (com.google.android.gms.internal.measurement.zzic) zzibVar3.zzc(i12).zzco();
                    zzicVar5.zzt();
                    zzicVar5.zzaO(j);
                    zzhzVar.zzd(i12, zzicVar5);
                }
                arrayList6.add(Pair.create((com.google.android.gms.internal.measurement.zzib) zzhzVar.zzbd(), zzotVarZza2));
                zzL(arrayList32);
                zzW(false, 204, null, null, str, arrayList6, null);
                if (zzO(str, zzotVarZza2.zza())) {
                    zzaW().zzk().zzb("[sgtm] Sending sgtm batches available notification to app", str);
                    Intent intent = new Intent();
                    intent.setAction("com.google.android.gms.measurement.BATCHES_AVAILABLE");
                    intent.setPackage(str);
                    zzaR(this.zzn.zzaZ(), intent);
                    return;
                }
                return;
            }
            zzibVar = zzibVar3;
            if (zzi().zzb()) {
            }
        }
    }

    final boolean zzO(String str, String str2) {
        zzh zzhVarZzu = zzj().zzu(str);
        if (zzhVarZzu != null && zzt().zzad(str, zzhVarZzu.zzay())) {
            this.zzF.remove(str2);
            return true;
        }
        zzpe zzpeVar = (zzpe) this.zzF.get(str2);
        if (zzpeVar == null) {
            return true;
        }
        return zzpeVar.zzb();
    }

    final void zzP(String str) {
        com.google.android.gms.internal.measurement.zzib zzibVarZzd;
        zzaX().zzg();
        zzu();
        this.zzw = true;
        try {
            zzic zzicVar = this.zzn;
            zzicVar.zzaV();
            Boolean boolZzJ = zzicVar.zzt().zzJ();
            if (boolZzJ == null) {
                zzaW().zze().zza("Upload data called on the client side before use of service was decided");
            } else if (boolZzJ.booleanValue()) {
                zzaW().zzb().zza("Upload called in the client side when service should be used");
            } else if (this.zza > 0) {
                zzaM();
            } else if (!zzi().zzb()) {
                zzaW().zzk().zza("Network not connected, ignoring upload request");
                zzaM();
            } else if (zzj().zzD(str)) {
                zzaw zzawVarZzj = zzj();
                Preconditions.checkNotEmpty(str);
                zzawVarZzj.zzg();
                zzawVarZzj.zzay();
                List listZzC = zzawVarZzj.zzC(str, zzoo.zza(zzls.GOOGLE_SIGNAL), 1);
                zzpj zzpjVar = listZzC.isEmpty() ? null : (zzpj) listZzC.get(0);
                if (zzpjVar != null && (zzibVarZzd = zzpjVar.zzd()) != null) {
                    zzaW().zzk().zzd("[sgtm] Uploading data from upload queue. appId, type, url", str, zzpjVar.zzf(), zzpjVar.zze());
                    byte[] bArrZzcd = zzibVarZzd.zzcd();
                    if (Log.isLoggable(zzaW().zzn(), 2)) {
                        zzaW().zzk().zzd("[sgtm] Uploading data from upload queue. appId, uncompressed size, data", str, Integer.valueOf(bArrZzcd.length), zzp().zzi(zzibVarZzd));
                    }
                    zzot zzotVarZza = zzpjVar.zza();
                    this.zzv = true;
                    zzi().zzc(str, zzotVarZza, zzibVarZzd, new zzox(this, str, zzpjVar));
                }
            } else {
                zzaW().zzk().zzb("[sgtm] Upload queue has no batches for appId", str);
            }
        } finally {
            this.zzw = false;
            zzaN();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001e A[Catch: all -> 0x0010, TryCatch #0 {all -> 0x0010, blocks: (B:4:0x000d, B:19:0x005a, B:22:0x0080, B:13:0x001e, B:15:0x0048, B:17:0x0052, B:18:0x0056), top: B:27:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void zzQ(String str, int i, Throwable th, byte[] bArr, zzpj zzpjVar) {
        zzaX().zzg();
        zzu();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzv = false;
                zzaN();
                throw th2;
            }
        }
        if (i != 200) {
            if (i == 204) {
                i = 204;
                if (th != null) {
                }
            }
            String str2 = new String(bArr, StandardCharsets.UTF_8);
            String strSubstring = str2.substring(0, Math.min(32, str2.length()));
            zzgs zzgsVarZzh = zzaW().zzh();
            Integer numValueOf = Integer.valueOf(i);
            Object obj = th;
            if (th == null) {
            }
            zzgsVarZzh.zzd("Network upload failed. Will retry later. appId, status, error", str, numValueOf, obj);
            zzj().zzK(Long.valueOf(zzpjVar.zzc()));
            zzaM();
        } else if (th != null) {
            zzj().zzE(Long.valueOf(zzpjVar.zzc()));
            zzaW().zzk().zzc("Successfully uploaded batch from upload queue. appId, status", str, Integer.valueOf(i));
            if (zzi().zzb() && zzj().zzD(str)) {
                zzP(str);
            } else {
                zzaM();
            }
        } else {
            String str22 = new String(bArr, StandardCharsets.UTF_8);
            String strSubstring2 = str22.substring(0, Math.min(32, str22.length()));
            zzgs zzgsVarZzh2 = zzaW().zzh();
            Integer numValueOf2 = Integer.valueOf(i);
            Object obj2 = th;
            if (th == null) {
                obj2 = strSubstring2;
            }
            zzgsVarZzh2.zzd("Network upload failed. Will retry later. appId, status, error", str, numValueOf2, obj2);
            zzj().zzK(Long.valueOf(zzpjVar.zzc()));
            zzaM();
        }
        this.zzv = false;
        zzaN();
    }

    final void zzR(String str, boolean z, Long l, Long l2) {
        zzh zzhVarZzu = zzj().zzu(str);
        if (zzhVarZzu != null) {
            zzhVarZzu.zzar(z);
            zzhVarZzu.zzat(l);
            zzhVarZzu.zzav(l2);
            if (zzhVarZzu.zza()) {
                zzj().zzv(zzhVarZzu, false, false);
            }
        }
    }

    final void zzS(String str, com.google.android.gms.internal.measurement.zzic zzicVar) {
        int iZzx;
        int iIndexOf;
        Set setZzl = zzh().zzl(str);
        if (setZzl != null) {
            zzicVar.zzaw(setZzl);
        }
        if (zzh().zzq(str)) {
            zzicVar.zzG();
        }
        if (zzh().zzr(str)) {
            String strZzD = zzicVar.zzD();
            if (!TextUtils.isEmpty(strZzD) && (iIndexOf = strZzD.indexOf(".")) != -1) {
                zzicVar.zzE(strZzD.substring(0, iIndexOf));
            }
        }
        if (zzh().zzs(str) && (iZzx = zzpk.zzx(zzicVar, "_id")) != -1) {
            zzicVar.zzr(iZzx);
        }
        if (zzh().zzt(str)) {
            zzicVar.zzan();
        }
        if (zzh().zzu(str)) {
            zzicVar.zzX();
            if (zzB(str).zzo(zzjk.ANALYTICS_STORAGE)) {
                Map map = this.zzE;
                zzpd zzpdVar = (zzpd) map.get(str);
                if (zzpdVar == null || zzpdVar.zzb + zzd().zzl(str, zzfy.zzaj) < zzba().elapsedRealtime()) {
                    zzpdVar = new zzpd(this, (byte[]) null);
                    map.put(str, zzpdVar);
                }
                zzicVar.zzax(zzpdVar.zza);
            }
        }
        if (zzh().zzv(str)) {
            zzicVar.zzav();
        }
    }

    final void zzT(com.google.android.gms.internal.measurement.zzic zzicVar, zzpc zzpcVar) {
        for (int i = 0; i < zzicVar.zzc(); i++) {
            com.google.android.gms.internal.measurement.zzhr zzhrVar = (com.google.android.gms.internal.measurement.zzhr) zzicVar.zzd(i).zzco();
            Iterator it = zzhrVar.zza().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if ("_c".equals(((com.google.android.gms.internal.measurement.zzhw) it.next()).zzb())) {
                    if (zzpcVar.zza.zzar() >= zzd().zzm(zzpcVar.zza.zzA(), zzfy.zzak)) {
                        int iZzm = zzd().zzm(zzpcVar.zza.zzA(), zzfy.zzax);
                        String strZzaz = null;
                        if (iZzm <= 0) {
                            if (zzd().zzp(zzpcVar.zza.zzA(), zzfy.zzaQ)) {
                                strZzaz = zzt().zzaz();
                                com.google.android.gms.internal.measurement.zzhv zzhvVarZzn = com.google.android.gms.internal.measurement.zzhw.zzn();
                                zzhvVarZzn.zzb("_tu");
                                zzhvVarZzn.zzd(strZzaz);
                                zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn.zzbd());
                            }
                            com.google.android.gms.internal.measurement.zzhv zzhvVarZzn2 = com.google.android.gms.internal.measurement.zzhw.zzn();
                            zzhvVarZzn2.zzb("_tr");
                            zzhvVarZzn2.zzf(1L);
                            zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn2.zzbd());
                            zzoh zzohVarZzf = zzp().zzf(zzpcVar.zza.zzA(), zzicVar, zzhrVar, strZzaz);
                            if (zzohVarZzf != null) {
                                zzaW().zzk().zzc("Generated trigger URI. appId, uri", zzpcVar.zza.zzA(), zzohVarZzf.zza);
                                zzj().zzZ(zzpcVar.zza.zzA(), zzohVarZzf);
                                Deque deque = this.zzr;
                                if (!deque.contains(zzpcVar.zza.zzA())) {
                                    deque.add(zzpcVar.zza.zzA());
                                }
                            }
                        } else if (zzj().zzw(zzC(), zzpcVar.zza.zzA(), false, false, false, false, false, false, true).zzg > iZzm) {
                            com.google.android.gms.internal.measurement.zzhv zzhvVarZzn3 = com.google.android.gms.internal.measurement.zzhw.zzn();
                            zzhvVarZzn3.zzb("_tnr");
                            zzhvVarZzn3.zzf(1L);
                            zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn3.zzbd());
                        } else {
                            if (zzd().zzp(zzpcVar.zza.zzA(), zzfy.zzaQ)) {
                                strZzaz = zzt().zzaz();
                                com.google.android.gms.internal.measurement.zzhv zzhvVarZzn4 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                zzhvVarZzn4.zzb("_tu");
                                zzhvVarZzn4.zzd(strZzaz);
                                zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn4.zzbd());
                            }
                            com.google.android.gms.internal.measurement.zzhv zzhvVarZzn5 = com.google.android.gms.internal.measurement.zzhw.zzn();
                            zzhvVarZzn5.zzb("_tr");
                            zzhvVarZzn5.zzf(1L);
                            zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn5.zzbd());
                            zzoh zzohVarZzf2 = zzp().zzf(zzpcVar.zza.zzA(), zzicVar, zzhrVar, strZzaz);
                            if (zzohVarZzf2 != null) {
                                zzaW().zzk().zzc("Generated trigger URI. appId, uri", zzpcVar.zza.zzA(), zzohVarZzf2.zza);
                                zzj().zzZ(zzpcVar.zza.zzA(), zzohVarZzf2);
                                Deque deque2 = this.zzr;
                                if (!deque2.contains(zzpcVar.zza.zzA())) {
                                    deque2.add(zzpcVar.zza.zzA());
                                }
                            }
                        }
                    }
                    zzicVar.zze(i, (com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbd());
                }
            }
        }
    }

    final void zzU(String str, com.google.android.gms.internal.measurement.zzhv zzhvVar, Bundle bundle, String str2) {
        List listListOf = zzd().zzp(str2, zzfy.zzba) ? CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si", "deep_link_url"}) : CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si"});
        long jZzf = (zzpp.zzac(zzhvVar.zza()) || zzpp.zzac(str)) ? zzd().zzf(str2, true) : zzd().zze(str2, true);
        long jCodePointCount = zzhvVar.zzc().codePointCount(0, zzhvVar.zzc().length());
        zzpp zzppVarZzt = zzt();
        String strZza = zzhvVar.zza();
        zzd();
        String strZzE = zzppVarZzt.zzE(strZza, 40, true);
        if (jCodePointCount <= jZzf || listListOf.contains(zzhvVar.zza())) {
            return;
        }
        if ("_ev".equals(zzhvVar.zza())) {
            bundle.putString("_ev", zzt().zzE(zzhvVar.zzc(), zzd().zzf(str2, true), true));
            return;
        }
        zzaW().zzh().zzc("Param value is too long; discarded. Name, value length", strZzE, Long.valueOf(jCodePointCount));
        if (bundle.getLong("_err") == 0) {
            bundle.putLong("_err", 4L);
            if (bundle.getString("_ev") == null) {
                bundle.putString("_ev", strZzE);
                bundle.putLong("_el", jCodePointCount);
            }
        }
        bundle.remove(zzhvVar.zza());
    }

    final boolean zzV(com.google.android.gms.internal.measurement.zzhr zzhrVar) {
        ArrayList arrayList = new ArrayList(zzhrVar.zza());
        int i = -1;
        int i2 = -1;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if ("value".equals(((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i3)).zzb())) {
                i = i3;
            } else if (FirebaseAnalytics.Param.CURRENCY.equals(((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i3)).zzb())) {
                i2 = i3;
            }
        }
        if (i == -1) {
            if (!zzd().zzp(null, zzfy.zzbf) || !"_iap".equals(zzhrVar.zzk())) {
                return true;
            }
            zzaC(zzhrVar, "_c");
            zzaB(zzhrVar, 18, "value");
            return false;
        }
        if (!((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i)).zze() && !((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i)).zzj()) {
            zzaW().zzh().zza("Value must be specified with a numeric type.");
            zzhrVar.zzj(i);
            zzaC(zzhrVar, "_c");
            zzaB(zzhrVar, 18, "value");
            return false;
        }
        if (i2 != -1) {
            String strZzd = ((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i2)).zzd();
            if (strZzd.length() == 3) {
                int iCharCount = 0;
                while (iCharCount < strZzd.length()) {
                    int iCodePointAt = strZzd.codePointAt(iCharCount);
                    if (Character.isLetter(iCodePointAt)) {
                        iCharCount += Character.charCount(iCodePointAt);
                    }
                }
                return true;
            }
        }
        zzaW().zzh().zza("Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter.");
        zzhrVar.zzj(i);
        zzaC(zzhrVar, "_c");
        zzaB(zzhrVar, 19, FirebaseAnalytics.Param.CURRENCY);
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0083 A[Catch: all -> 0x02a4, TryCatch #0 {all -> 0x02a4, blocks: (B:4:0x0013, B:6:0x0018, B:8:0x0025, B:9:0x002e, B:17:0x0046, B:22:0x0092, B:21:0x0083, B:23:0x009e, B:25:0x00b5, B:26:0x00c4, B:28:0x00d2, B:30:0x00f2, B:70:0x022a, B:72:0x023d, B:74:0x0247, B:82:0x0267, B:76:0x024d, B:78:0x0257, B:80:0x025d, B:81:0x0261, B:84:0x026b, B:85:0x0272, B:29:0x00e5, B:87:0x0274), top: B:93:0x0013, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009e A[Catch: all -> 0x02a4, PHI: r0
      0x009e: PHI (r0v2 int) = (r0v0 int), (r0v37 int) binds: [B:10:0x0039, B:16:0x0044] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #0 {all -> 0x02a4, blocks: (B:4:0x0013, B:6:0x0018, B:8:0x0025, B:9:0x002e, B:17:0x0046, B:22:0x0092, B:21:0x0083, B:23:0x009e, B:25:0x00b5, B:26:0x00c4, B:28:0x00d2, B:30:0x00f2, B:70:0x022a, B:72:0x023d, B:74:0x0247, B:82:0x0267, B:76:0x024d, B:78:0x0257, B:80:0x025d, B:81:0x0261, B:84:0x026b, B:85:0x0272, B:29:0x00e5, B:87:0x0274), top: B:93:0x0013, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d2 A[Catch: SQLiteException -> 0x0273, all -> 0x02a4, TryCatch #1 {SQLiteException -> 0x0273, blocks: (B:25:0x00b5, B:26:0x00c4, B:28:0x00d2, B:30:0x00f2, B:70:0x022a, B:72:0x023d, B:74:0x0247, B:82:0x0267, B:76:0x024d, B:78:0x0257, B:80:0x025d, B:81:0x0261, B:84:0x026b, B:85:0x0272, B:29:0x00e5), top: B:94:0x00b5, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e5 A[Catch: SQLiteException -> 0x0273, all -> 0x02a4, TryCatch #1 {SQLiteException -> 0x0273, blocks: (B:25:0x00b5, B:26:0x00c4, B:28:0x00d2, B:30:0x00f2, B:70:0x022a, B:72:0x023d, B:74:0x0247, B:82:0x0267, B:76:0x024d, B:78:0x0257, B:80:0x025d, B:81:0x0261, B:84:0x026b, B:85:0x0272, B:29:0x00e5), top: B:94:0x00b5, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x010a A[Catch: all -> 0x026a, TryCatch #3 {all -> 0x026a, blocks: (B:31:0x00f9, B:32:0x0102, B:34:0x010a, B:36:0x0121, B:40:0x014b, B:42:0x0155, B:44:0x0163, B:45:0x0168, B:47:0x016e, B:49:0x0185, B:51:0x01aa, B:53:0x01c5, B:55:0x01e8, B:56:0x01f9, B:57:0x01fd, B:59:0x0203, B:60:0x020a, B:63:0x0217, B:65:0x021b, B:68:0x0222, B:69:0x0223), top: B:97:0x00f9, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x016e A[Catch: all -> 0x026a, TryCatch #3 {all -> 0x026a, blocks: (B:31:0x00f9, B:32:0x0102, B:34:0x010a, B:36:0x0121, B:40:0x014b, B:42:0x0155, B:44:0x0163, B:45:0x0168, B:47:0x016e, B:49:0x0185, B:51:0x01aa, B:53:0x01c5, B:55:0x01e8, B:56:0x01f9, B:57:0x01fd, B:59:0x0203, B:60:0x020a, B:63:0x0217, B:65:0x021b, B:68:0x0222, B:69:0x0223), top: B:97:0x00f9, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01c5 A[Catch: all -> 0x026a, TryCatch #3 {all -> 0x026a, blocks: (B:31:0x00f9, B:32:0x0102, B:34:0x010a, B:36:0x0121, B:40:0x014b, B:42:0x0155, B:44:0x0163, B:45:0x0168, B:47:0x016e, B:49:0x0185, B:51:0x01aa, B:53:0x01c5, B:55:0x01e8, B:56:0x01f9, B:57:0x01fd, B:59:0x0203, B:60:0x020a, B:63:0x0217, B:65:0x021b, B:68:0x0222, B:69:0x0223), top: B:97:0x00f9, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0203 A[Catch: all -> 0x026a, TRY_LEAVE, TryCatch #3 {all -> 0x026a, blocks: (B:31:0x00f9, B:32:0x0102, B:34:0x010a, B:36:0x0121, B:40:0x014b, B:42:0x0155, B:44:0x0163, B:45:0x0168, B:47:0x016e, B:49:0x0185, B:51:0x01aa, B:53:0x01c5, B:55:0x01e8, B:56:0x01f9, B:57:0x01fd, B:59:0x0203, B:60:0x020a, B:63:0x0217, B:65:0x021b, B:68:0x0222, B:69:0x0223), top: B:97:0x00f9, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x024d A[Catch: SQLiteException -> 0x0273, all -> 0x02a4, TryCatch #1 {SQLiteException -> 0x0273, blocks: (B:25:0x00b5, B:26:0x00c4, B:28:0x00d2, B:30:0x00f2, B:70:0x022a, B:72:0x023d, B:74:0x0247, B:82:0x0267, B:76:0x024d, B:78:0x0257, B:80:0x025d, B:81:0x0261, B:84:0x026b, B:85:0x0272, B:29:0x00e5), top: B:94:0x00b5, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0261 A[Catch: SQLiteException -> 0x0273, all -> 0x02a4, TryCatch #1 {SQLiteException -> 0x0273, blocks: (B:25:0x00b5, B:26:0x00c4, B:28:0x00d2, B:30:0x00f2, B:70:0x022a, B:72:0x023d, B:74:0x0247, B:82:0x0267, B:76:0x024d, B:78:0x0257, B:80:0x025d, B:81:0x0261, B:84:0x026b, B:85:0x0272, B:29:0x00e5), top: B:94:0x00b5, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void zzW(boolean z, int i, Throwable th, byte[] bArr, String str, List list, Map map) {
        byte[] bArr2;
        Iterator it;
        Iterator it2;
        List listZzC;
        int i2 = i;
        zzaX().zzg();
        zzu();
        if (bArr == null) {
            try {
                bArr2 = new byte[0];
            } finally {
                this.zzv = false;
                zzaN();
            }
        } else {
            bArr2 = bArr;
        }
        if (zzd().zzp(null, zzfy.zzbe)) {
            zzp().zzD(map);
        }
        List<Long> list2 = (List) Preconditions.checkNotNull(this.zzz);
        this.zzz = null;
        if (!z) {
            zzgs zzgsVarZzk = zzaW().zzk();
            Integer numValueOf = Integer.valueOf(i2);
            zzgsVarZzk.zzc("Network upload successful with code, uploadAttempted", numValueOf, Boolean.valueOf(z));
            if (z) {
                try {
                    this.zzk.zzd.zzb(zzba().currentTimeMillis());
                    this.zzk.zze.zzb(0L);
                    zzaM();
                    if (z) {
                        zzaW().zzk().zza("Purged empty bundles");
                    } else {
                        zzaW().zzk().zzc("Successful upload. Got network response. code, size", numValueOf, Integer.valueOf(bArr2.length));
                    }
                    zzj().zzb();
                    try {
                        HashMap map2 = new HashMap();
                        it = list.iterator();
                        while (it.hasNext()) {
                            Pair pair = (Pair) it.next();
                            com.google.android.gms.internal.measurement.zzib zzibVar = (com.google.android.gms.internal.measurement.zzib) pair.first;
                            zzot zzotVar = (zzot) pair.second;
                            if (zzotVar.zzc() != zzls.SGTM_CLIENT) {
                                long jZzA = zzj().zzA(str, zzibVar, zzotVar.zza(), zzotVar.zzb(), zzotVar.zzc(), null);
                                if (zzotVar.zzc() == zzls.GOOGLE_SIGNAL_PENDING && jZzA != -1 && !zzibVar.zze().isEmpty()) {
                                    map2.put(zzibVar.zze(), Long.valueOf(jZzA));
                                }
                            }
                        }
                        it2 = list.iterator();
                        while (it2.hasNext()) {
                            Pair pair2 = (Pair) it2.next();
                            com.google.android.gms.internal.measurement.zzib zzibVar2 = (com.google.android.gms.internal.measurement.zzib) pair2.first;
                            zzot zzotVar2 = (zzot) pair2.second;
                            if (zzotVar2.zzc() == zzls.SGTM_CLIENT) {
                                zzj().zzA(str, zzibVar2, zzotVar2.zza(), zzotVar2.zzb(), zzotVar2.zzc(), (Long) map2.get(zzibVar2.zze()));
                            }
                        }
                        listZzC = zzj().zzC(str, zzoo.zza(zzls.SGTM_CLIENT), 1);
                        if (!listZzC.isEmpty()) {
                            long jZzg = ((zzpj) listZzC.get(0)).zzg();
                            if (zzba().currentTimeMillis() > ((Long) zzfy.zzE.zzb(null)).longValue() + jZzg) {
                                zzaW().zze().zzc("[sgtm] client batches are queued too long. appId, creationTime", str, Long.valueOf(jZzg));
                            }
                        }
                        for (Long l : list2) {
                            try {
                                zzj().zzH(l.longValue());
                            } catch (SQLiteException e) {
                                List list3 = this.zzA;
                                if (list3 == null || !list3.contains(l)) {
                                    throw e;
                                }
                            }
                        }
                        zzj().zzc();
                        zzj().zzd();
                        this.zzA = null;
                        if (!zzi().zzb() && zzj().zzD(str)) {
                            zzP(str);
                        } else if (zzi().zzb() || !zzaL()) {
                            this.zzB = -1L;
                            zzaM();
                        } else {
                            zzM();
                        }
                        this.zza = 0L;
                    } catch (Throwable th2) {
                        zzj().zzd();
                        throw th2;
                    }
                } catch (SQLiteException e2) {
                    zzaW().zzb().zzb("Database error while trying to delete uploaded bundles", e2);
                    this.zza = zzba().elapsedRealtime();
                    zzaW().zzk().zzb("Disable upload, time", Long.valueOf(this.zza));
                }
            } else {
                this.zzk.zze.zzb(0L);
                zzaM();
                if (z) {
                }
                zzj().zzb();
                HashMap map22 = new HashMap();
                it = list.iterator();
                while (it.hasNext()) {
                }
                it2 = list.iterator();
                while (it2.hasNext()) {
                }
                listZzC = zzj().zzC(str, zzoo.zza(zzls.SGTM_CLIENT), 1);
                if (!listZzC.isEmpty()) {
                }
                while (r2.hasNext()) {
                }
                zzj().zzc();
                zzj().zzd();
                this.zzA = null;
                if (!zzi().zzb()) {
                    if (zzi().zzb()) {
                        this.zzB = -1L;
                        zzaM();
                        this.zza = 0L;
                    }
                }
            }
        } else if (i2 != 200) {
            if (i2 == 204) {
                i2 = 204;
                if (th == null) {
                }
            }
            String str2 = new String(bArr2, StandardCharsets.UTF_8);
            zzaW().zzh().zzd("Network upload failed. Will retry later. code, error", Integer.valueOf(i2), th, str2.substring(0, Math.min(32, str2.length())));
            this.zzk.zze.zzb(zzba().currentTimeMillis());
            if (i2 != 503) {
                this.zzk.zzc.zzb(zzba().currentTimeMillis());
                zzj().zzJ(list2);
                zzaM();
            }
        } else if (th == null) {
            String str22 = new String(bArr2, StandardCharsets.UTF_8);
            zzaW().zzh().zzd("Network upload failed. Will retry later. code, error", Integer.valueOf(i2), th, str22.substring(0, Math.min(32, str22.length())));
            this.zzk.zze.zzb(zzba().currentTimeMillis());
            if (i2 != 503 || i2 == 429) {
                this.zzk.zzc.zzb(zzba().currentTimeMillis());
            }
            zzj().zzJ(list2);
            zzaM();
        }
    }

    final void zzX(zzh zzhVar) {
        zzaX().zzg();
        if (TextUtils.isEmpty(zzhVar.zzf())) {
            zzY((String) Preconditions.checkNotNull(zzhVar.zzc()), 204, null, null, null);
            return;
        }
        String str = (String) Preconditions.checkNotNull(zzhVar.zzc());
        zzaW().zzk().zzb("Fetching remote configuration", str);
        com.google.android.gms.internal.measurement.zzgl zzglVarZzb = zzh().zzb(str);
        String strZzd = zzh().zzd(str);
        ArrayMap arrayMap = null;
        if (zzglVarZzb != null) {
            if (!TextUtils.isEmpty(strZzd)) {
                ArrayMap arrayMap2 = new ArrayMap();
                arrayMap2.put(HttpHeaders.IF_MODIFIED_SINCE, strZzd);
                arrayMap = arrayMap2;
            }
            String strZze = zzh().zze(str);
            if (!TextUtils.isEmpty(strZze)) {
                if (arrayMap == null) {
                    arrayMap = new ArrayMap();
                }
                arrayMap.put(HttpHeaders.IF_NONE_MATCH, strZze);
            }
        }
        this.zzu = true;
        zzi().zzd(zzhVar, arrayMap, new zzgw() { // from class: com.google.android.gms.measurement.internal.zzpf
            @Override // com.google.android.gms.measurement.internal.zzgw
            public final /* synthetic */ void zza(String str2, int i, Throwable th, byte[] bArr, Map map) {
                this.zza.zzY(str2, i, th, bArr, map);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void zzY(String str, int i, Throwable th, byte[] bArr, Map map) {
        boolean z;
        zzaX().zzg();
        zzu();
        Preconditions.checkNotEmpty(str);
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } finally {
                this.zzu = false;
                zzaN();
            }
        }
        zzgs zzgsVarZzk = zzaW().zzk();
        Integer numValueOf = Integer.valueOf(bArr.length);
        zzgsVarZzk.zzb("onConfigFetched. Response size", numValueOf);
        if (zzd().zzp(null, zzfy.zzbe)) {
            zzp().zzD(map);
        }
        zzj().zzb();
        try {
            zzh zzhVarZzu = zzj().zzu(str);
            if (i == 200 || i == 204) {
                z = th != null;
            } else {
                if (i == 304) {
                    i = 304;
                    if (th != null) {
                    }
                }
            }
            if (zzhVarZzu == null) {
                zzaW().zze().zzb("App does not exist in onConfigFetched. appId", zzgu.zzl(str));
            } else if (z || i == 404) {
                zzp();
                String strZzJ = zzpk.zzJ(map, HttpHeaders.LAST_MODIFIED);
                zzp();
                String strZzJ2 = zzpk.zzJ(map, HttpHeaders.ETAG);
                if (i != 404 && i != 304) {
                    zzh().zzi(str, bArr, strZzJ, strZzJ2);
                } else if (zzh().zzb(str) == null) {
                    zzh().zzi(str, null, null, null);
                }
                zzhVarZzu.zzI(zzba().currentTimeMillis());
                zzj().zzv(zzhVarZzu, false, false);
                if (i == 404) {
                    zzaW().zzh().zzb("Config not found. Using empty config. appId", str);
                } else {
                    zzaW().zzk().zzc("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), numValueOf);
                }
                if (zzi().zzb() && zzaL()) {
                    zzM();
                } else if (zzi().zzb() && zzj().zzD(zzhVarZzu.zzc())) {
                    zzP(zzhVarZzu.zzc());
                } else {
                    zzaM();
                }
            } else {
                zzhVarZzu.zzK(zzba().currentTimeMillis());
                zzj().zzv(zzhVarZzu, false, false);
                zzaW().zzk().zzc("Fetching config failed. code, error", Integer.valueOf(i), th);
                zzh().zzf(str);
                this.zzk.zze.zzb(zzba().currentTimeMillis());
                if (i == 503 || i == 429) {
                    this.zzk.zzc.zzb(zzba().currentTimeMillis());
                }
                zzaM();
            }
            zzj().zzc();
        } finally {
            zzj().zzd();
        }
    }

    final void zzZ(Runnable runnable) {
        zzaX().zzg();
        if (this.zzq == null) {
            this.zzq = new ArrayList();
        }
        this.zzq.add(runnable);
    }

    final /* synthetic */ void zzaA(long j) {
        this.zzJ = j;
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final zzae zzaV() {
        return this.zzn.zzaV();
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final zzgu zzaW() {
        return ((zzic) Preconditions.checkNotNull(this.zzn)).zzaW();
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final zzhz zzaX() {
        return ((zzic) Preconditions.checkNotNull(this.zzn)).zzaX();
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final Context zzaZ() {
        return this.zzn.zzaZ();
    }

    final void zzaa() {
        zzaX().zzg();
        zzu();
        if (this.zzp) {
            return;
        }
        this.zzp = true;
        if (zzab()) {
            FileChannel fileChannel = this.zzy;
            zzaX().zzg();
            int i = 0;
            if (fileChannel == null || !fileChannel.isOpen()) {
                zzaW().zzb().zza("Bad channel to read from");
            } else {
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
                try {
                    fileChannel.position(0L);
                    int i2 = fileChannel.read(byteBufferAllocate);
                    if (i2 == 4) {
                        byteBufferAllocate.flip();
                        i = byteBufferAllocate.getInt();
                    } else if (i2 != -1) {
                        zzaW().zze().zzb("Unexpected data length. Bytes read", Integer.valueOf(i2));
                    }
                } catch (IOException e) {
                    zzaW().zzb().zzb("Failed to read from channel", e);
                }
            }
            int iZzm = this.zzn.zzv().zzm();
            zzaX().zzg();
            if (i > iZzm) {
                zzaW().zzb().zzc("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i), Integer.valueOf(iZzm));
                return;
            }
            if (i < iZzm) {
                FileChannel fileChannel2 = this.zzy;
                zzaX().zzg();
                if (fileChannel2 == null || !fileChannel2.isOpen()) {
                    zzaW().zzb().zza("Bad channel to read from");
                } else {
                    ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(4);
                    byteBufferAllocate2.putInt(iZzm);
                    byteBufferAllocate2.flip();
                    try {
                        fileChannel2.truncate(0L);
                        fileChannel2.write(byteBufferAllocate2);
                        fileChannel2.force(true);
                        if (fileChannel2.size() != 4) {
                            zzaW().zzb().zzb("Error writing to channel. Bytes written", Long.valueOf(fileChannel2.size()));
                        }
                        zzaW().zzk().zzc("Storage version upgraded. Previous, current version", Integer.valueOf(i), Integer.valueOf(iZzm));
                        return;
                    } catch (IOException e2) {
                        zzaW().zzb().zzb("Failed to write to channel", e2);
                    }
                }
                zzaW().zzb().zzc("Storage version upgrade failed. Previous, current version", Integer.valueOf(i), Integer.valueOf(iZzm));
            }
        }
    }

    final boolean zzab() {
        zzaX().zzg();
        FileLock fileLock = this.zzx;
        if (fileLock != null && fileLock.isValid()) {
            zzaW().zzk().zza("Storage concurrent access okay");
            return true;
        }
        this.zze.zzu.zzc();
        File filesDir = this.zzn.zzaZ().getFilesDir();
        com.google.android.gms.internal.measurement.zzby.zza();
        int i = com.google.android.gms.internal.measurement.zzcd.zza;
        try {
            FileChannel channel = new RandomAccessFile(new File(new File(filesDir, "google_app_measurement.db").getPath()), "rw").getChannel();
            this.zzy = channel;
            FileLock fileLockTryLock = channel.tryLock();
            this.zzx = fileLockTryLock;
            if (fileLockTryLock != null) {
                zzaW().zzk().zza("Storage concurrent access okay");
                return true;
            }
            zzaW().zzb().zza("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e) {
            zzaW().zzb().zzb("Failed to acquire storage lock", e);
            return false;
        } catch (IOException e2) {
            zzaW().zzb().zzb("Failed to access storage lock file", e2);
            return false;
        } catch (OverlappingFileLockException e3) {
            zzaW().zze().zzb("Storage lock already acquired", e3);
            return false;
        }
    }

    final void zzac(zzr zzrVar) {
        if (this.zzz != null) {
            ArrayList arrayList = new ArrayList();
            this.zzA = arrayList;
            arrayList.addAll(this.zzz);
        }
        zzaw zzawVarZzj = zzj();
        String str = (String) Preconditions.checkNotNull(zzrVar.zza);
        Preconditions.checkNotEmpty(str);
        zzawVarZzj.zzg();
        zzawVarZzj.zzay();
        try {
            SQLiteDatabase sQLiteDatabaseZze = zzawVarZzj.zze();
            String[] strArr = {str};
            int iDelete = sQLiteDatabaseZze.delete("apps", "app_id=?", strArr) + sQLiteDatabaseZze.delete("events", "app_id=?", strArr) + sQLiteDatabaseZze.delete("events_snapshot", "app_id=?", strArr) + sQLiteDatabaseZze.delete("user_attributes", "app_id=?", strArr) + sQLiteDatabaseZze.delete("conditional_properties", "app_id=?", strArr) + sQLiteDatabaseZze.delete("raw_events", "app_id=?", strArr) + sQLiteDatabaseZze.delete("raw_events_metadata", "app_id=?", strArr) + sQLiteDatabaseZze.delete("queue", "app_id=?", strArr) + sQLiteDatabaseZze.delete("audience_filter_values", "app_id=?", strArr) + sQLiteDatabaseZze.delete("main_event_params", "app_id=?", strArr) + sQLiteDatabaseZze.delete("default_event_params", "app_id=?", strArr) + sQLiteDatabaseZze.delete("trigger_uris", "app_id=?", strArr) + sQLiteDatabaseZze.delete("upload_queue", "app_id=?", strArr);
            zzahh.zza();
            zzic zzicVar = zzawVarZzj.zzu;
            if (zzicVar.zzc().zzp(null, zzfy.zzbc)) {
                iDelete += sQLiteDatabaseZze.delete("no_data_mode_events", "app_id=?", strArr);
            }
            int iDelete2 = iDelete + sQLiteDatabaseZze.delete("diagnostic_signals", "app_id=?", strArr);
            if (iDelete2 > 0) {
                zzicVar.zzaW().zzk().zzc("Reset analytics data. app, records", str, Integer.valueOf(iDelete2));
            }
        } catch (SQLiteException e) {
            zzawVarZzj.zzu.zzaW().zzb().zzc("Error resetting analytics data. appId, error", zzgu.zzl(str), e);
        }
        if (zzrVar.zzh) {
            zzai(zzrVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void zzad(zzpl zzplVar, zzr zzrVar) {
        zzpn zzpnVarZzm;
        long jLongValue;
        zzaX().zzg();
        zzu();
        if (zzaS(zzrVar)) {
            if (!zzrVar.zzh) {
                zzap(zzrVar);
                return;
            }
            zzpp zzppVarZzt = zzt();
            String str = zzplVar.zzb;
            int iZzs = zzppVarZzt.zzs(str);
            if (iZzs != 0) {
                zzpp zzppVarZzt2 = zzt();
                zzd();
                zzt().zzP(this.zzK, zzrVar.zza, iZzs, "_ev", zzppVarZzt2.zzE(str, 24, true), str != null ? str.length() : 0);
                return;
            }
            int iZzM = zzt().zzM(str, zzplVar.zza());
            if (iZzM != 0) {
                zzpp zzppVarZzt3 = zzt();
                zzd();
                String strZzE = zzppVarZzt3.zzE(str, 24, true);
                Object objZza = zzplVar.zza();
                if (objZza != null && ((objZza instanceof String) || (objZza instanceof CharSequence))) {
                    length = objZza.toString().length();
                }
                zzt().zzP(this.zzK, zzrVar.zza, iZzM, "_ev", strZzE, length);
                return;
            }
            Object objZzN = zzt().zzN(str, zzplVar.zza());
            if (objZzN != null) {
                if ("_sid".equals(str)) {
                    long j = zzplVar.zzc;
                    String str2 = zzplVar.zzf;
                    String str3 = (String) Preconditions.checkNotNull(zzrVar.zza);
                    zzpn zzpnVarZzm2 = zzj().zzm(str3, "_sno");
                    if (zzpnVarZzm2 != null) {
                        Object obj = zzpnVarZzm2.zze;
                        if (obj instanceof Long) {
                            jLongValue = ((Long) obj).longValue();
                        } else {
                            if (zzpnVarZzm2 != null) {
                                zzaW().zze().zzb("Retrieved last session number from database does not contain a valid (long) value", zzpnVarZzm2.zze);
                            }
                            zzbd zzbdVarZzf = zzj().zzf(str3, "_s");
                            if (zzbdVarZzf != null) {
                                zzgs zzgsVarZzk = zzaW().zzk();
                                long j2 = zzbdVarZzf.zzc;
                                zzgsVarZzk.zzb("Backfill the session number. Last used session number", Long.valueOf(j2));
                                jLongValue = j2;
                            } else {
                                jLongValue = 0;
                            }
                        }
                        zzad(new zzpl("_sno", j, Long.valueOf(jLongValue + 1), str2), zzrVar);
                    }
                }
                String str4 = zzrVar.zza;
                zzpn zzpnVar = new zzpn((String) Preconditions.checkNotNull(str4), (String) Preconditions.checkNotNull(zzplVar.zzf), str, zzplVar.zzc, objZzN);
                zzgs zzgsVarZzk2 = zzaW().zzk();
                zzic zzicVar = this.zzn;
                String str5 = zzpnVar.zzc;
                zzgsVarZzk2.zzc("Setting user property", zzicVar.zzl().zzc(str5), objZzN);
                zzj().zzb();
                try {
                    if ("_id".equals(str5) && (zzpnVarZzm = zzj().zzm(str4, "_id")) != null && !zzpnVar.zze.equals(zzpnVarZzm.zze)) {
                        zzj().zzk(str4, "_lair");
                    }
                    zzap(zzrVar);
                    boolean zZzl = zzj().zzl(zzpnVar);
                    if ("_sid".equals(str)) {
                        long jZzu = zzp().zzu(zzrVar.zzu);
                        zzh zzhVarZzu = zzj().zzu(str4);
                        if (zzhVarZzu != null) {
                            zzhVarZzu.zzan(jZzu);
                            if (zzhVarZzu.zza()) {
                                zzj().zzv(zzhVarZzu, false, false);
                            }
                        }
                    }
                    zzj().zzc();
                    if (!zZzl) {
                        zzaW().zzb().zzc("Too many unique user properties are set. Ignoring user property", zzicVar.zzl().zzc(str5), zzpnVar.zze);
                        zzt().zzP(this.zzK, str4, 9, null, null, 0);
                    }
                } finally {
                    zzj().zzd();
                }
            }
        }
    }

    final void zzae(String str, zzr zzrVar) {
        zzaX().zzg();
        zzu();
        if (zzaS(zzrVar)) {
            if (!zzrVar.zzh) {
                zzap(zzrVar);
                return;
            }
            Boolean boolZzaU = zzaU(zzrVar);
            if ("_npa".equals(str) && boolZzaU != null) {
                zzaW().zzj().zza("Falling back to manifest metadata value for ad personalization");
                zzad(new zzpl("_npa", zzba().currentTimeMillis(), Long.valueOf(true != boolZzaU.booleanValue() ? 0L : 1L), DebugKt.DEBUG_PROPERTY_VALUE_AUTO), zzrVar);
                return;
            }
            zzgs zzgsVarZzj = zzaW().zzj();
            zzic zzicVar = this.zzn;
            zzgsVarZzj.zzb("Removing user property", zzicVar.zzl().zzc(str));
            zzj().zzb();
            try {
                zzap(zzrVar);
                if ("_id".equals(str)) {
                    zzj().zzk((String) Preconditions.checkNotNull(zzrVar.zza), "_lair");
                }
                zzj().zzk((String) Preconditions.checkNotNull(zzrVar.zza), str);
                zzj().zzc();
                zzaW().zzj().zzb("User property removed", zzicVar.zzl().zzc(str));
            } finally {
                zzj().zzd();
            }
        }
    }

    final void zzaf() {
        this.zzs++;
    }

    final void zzag() {
        this.zzt++;
    }

    final zzic zzah() {
        return this.zzn;
    }

    final void zzai(zzr zzrVar) {
        long j;
        zzbd zzbdVarZzf;
        boolean z;
        String str;
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo;
        ApplicationInfo applicationInfo2;
        long j2;
        boolean z2;
        zzaX().zzg();
        zzu();
        Preconditions.checkNotNull(zzrVar);
        String str2 = zzrVar.zza;
        Preconditions.checkNotEmpty(str2);
        if (zzaS(zzrVar)) {
            zzh zzhVarZzu = zzj().zzu(str2);
            if (zzhVarZzu != null && TextUtils.isEmpty(zzhVarZzu.zzf()) && !TextUtils.isEmpty(zzrVar.zzb)) {
                zzhVarZzu.zzI(0L);
                zzj().zzv(zzhVarZzu, false, false);
                zzh().zzh(str2);
            }
            if (!zzrVar.zzh) {
                zzap(zzrVar);
                return;
            }
            long jCurrentTimeMillis = zzrVar.zzl;
            zzal zzalVarZzd = zzd();
            zzfx zzfxVar = zzfy.zzbe;
            long jElapsedRealtime = zzalVarZzd.zzp(null, zzfxVar) ? zzrVar.zzF : 0L;
            if (jCurrentTimeMillis == 0) {
                jCurrentTimeMillis = zzba().currentTimeMillis();
                jElapsedRealtime = zzd().zzp(null, zzfxVar) ? zzba().elapsedRealtime() : 0L;
            }
            long j3 = jElapsedRealtime;
            long j4 = jCurrentTimeMillis;
            int i = zzrVar.zzm;
            if (i != 0 && i != 1) {
                zzaW().zze().zzc("Incorrect app type, assuming installed app. appId, appType", zzgu.zzl(str2), Integer.valueOf(i));
                i = 0;
            }
            zzj().zzb();
            try {
                zzpn zzpnVarZzm = zzj().zzm(str2, "_npa");
                Boolean boolZzaU = zzaU(zzrVar);
                int i2 = i;
                if (zzpnVarZzm != null && !DebugKt.DEBUG_PROPERTY_VALUE_AUTO.equals(zzpnVarZzm.zzb)) {
                    j = j4;
                } else if (boolZzaU != null) {
                    zzpl zzplVar = new zzpl("_npa", j4, Long.valueOf(true != boolZzaU.booleanValue() ? 0L : 1L), DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
                    j = j4;
                    if (zzpnVarZzm == null || !zzpnVarZzm.zze.equals(zzplVar.zzd)) {
                        zzad(zzplVar, zzrVar);
                    }
                } else {
                    j = j4;
                    if (zzpnVarZzm != null) {
                        zzae("_npa", zzrVar);
                    }
                }
                if (zzd().zzp(null, zzfy.zzaW)) {
                    zzao(zzrVar, zzrVar.zzD);
                } else {
                    zzao(zzrVar, j);
                }
                zzap(zzrVar);
                if (i2 == 0) {
                    zzbdVarZzf = zzj().zzf(str2, "_f");
                    z = false;
                } else {
                    zzbdVarZzf = zzj().zzf(str2, "_v");
                    z = true;
                }
                if (zzbdVarZzf == null) {
                    long j5 = ((j / DurationKt.MILLIS_IN_HOUR) + 1) * DurationKt.MILLIS_IN_HOUR;
                    if (z) {
                        long j6 = j;
                        zzad(new zzpl("_fvt", j6, Long.valueOf(j5), DebugKt.DEBUG_PROPERTY_VALUE_AUTO), zzrVar);
                        zzaX().zzg();
                        zzu();
                        Bundle bundle = new Bundle();
                        bundle.putLong("_c", 1L);
                        bundle.putLong("_r", 1L);
                        bundle.putLong("_et", 1L);
                        if (zzrVar.zzo) {
                            bundle.putLong("_dac", 1L);
                        }
                        bundle.putLong("_elt", zzba().currentTimeMillis());
                        zzE(new zzbh("_v", new zzbf(bundle), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, j6, j3), zzrVar);
                    } else {
                        Long lValueOf = Long.valueOf(j5);
                        long j7 = j;
                        zzad(new zzpl("_fot", j7, lValueOf, DebugKt.DEBUG_PROPERTY_VALUE_AUTO), zzrVar);
                        zzaX().zzg();
                        zzhk zzhkVar = (zzhk) Preconditions.checkNotNull(this.zzm);
                        if (str2 == null || str2.isEmpty()) {
                            str = "_elt";
                            zzhkVar.zza.zzaW().zzf().zza("Install Referrer Reporter was called with invalid app package name");
                        } else {
                            zzic zzicVar = zzhkVar.zza;
                            zzicVar.zzaX().zzg();
                            if (zzhkVar.zza()) {
                                zzhj zzhjVar = new zzhj(zzhkVar, str2);
                                zzicVar.zzaX().zzg();
                                Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
                                str = "_elt";
                                intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
                                PackageManager packageManager = zzicVar.zzaZ().getPackageManager();
                                if (packageManager == null) {
                                    zzicVar.zzaW().zzf().zza("Failed to obtain Package Manager to verify binding conditions for Install Referrer");
                                } else {
                                    List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
                                    if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
                                        zzhkVar.zza.zzaW().zzi().zza("Play Service for fetching Install Referrer is unavailable on device");
                                    } else {
                                        ResolveInfo resolveInfo = listQueryIntentServices.get(0);
                                        if (resolveInfo.serviceInfo != null) {
                                            String str3 = resolveInfo.serviceInfo.packageName;
                                            if (resolveInfo.serviceInfo.name != null && "com.android.vending".equals(str3) && zzhkVar.zza()) {
                                                try {
                                                    zzicVar.zzaW().zzk().zzb("Install Referrer Service is", ConnectionTracker.getInstance().bindService(zzicVar.zzaZ(), new Intent(intent), zzhjVar, 1) ? "available" : "not available");
                                                } catch (RuntimeException e) {
                                                    zzhkVar.zza.zzaW().zzb().zzb("Exception occurred while binding to Install Referrer Service", e.getMessage());
                                                }
                                            } else {
                                                zzhkVar.zza.zzaW().zze().zza("Play Store version 8.3.73 or higher required for Install Referrer");
                                            }
                                        }
                                    }
                                }
                            } else {
                                zzicVar.zzaW().zzi().zza("Install Referrer Reporter is not available");
                                str = "_elt";
                            }
                        }
                        zzaX().zzg();
                        zzu();
                        Bundle bundle2 = new Bundle();
                        bundle2.putLong("_c", 1L);
                        bundle2.putLong("_r", 1L);
                        bundle2.putLong("_uwa", 0L);
                        bundle2.putLong("_pfo", 0L);
                        bundle2.putLong("_sys", 0L);
                        bundle2.putLong("_sysu", 0L);
                        bundle2.putLong("_et", 1L);
                        if (zzrVar.zzo) {
                            bundle2.putLong("_dac", 1L);
                        }
                        String str4 = (String) Preconditions.checkNotNull(zzrVar.zza);
                        zzaw zzawVarZzj = zzj();
                        Preconditions.checkNotEmpty(str4);
                        zzawVarZzj.zzg();
                        zzawVarZzj.zzay();
                        long jZzN = zzawVarZzj.zzN(str4, "first_open_count");
                        zzic zzicVar2 = this.zzn;
                        if (zzicVar2.zzaZ().getPackageManager() == null) {
                            zzaW().zzb().zzb("PackageManager is null, first open report might be inaccurate. appId", zzgu.zzl(str4));
                        } else {
                            try {
                                packageInfo = Wrappers.packageManager(zzicVar2.zzaZ()).getPackageInfo(str4, 0);
                            } catch (PackageManager.NameNotFoundException e2) {
                                zzaW().zzb().zzc("Package info is null, first open report might be inaccurate. appId", zzgu.zzl(str4), e2);
                                packageInfo = null;
                            }
                            if (packageInfo == null || packageInfo.firstInstallTime == 0) {
                                applicationInfo = null;
                                jZzN = jZzN;
                            } else {
                                if (packageInfo.firstInstallTime != packageInfo.lastUpdateTime) {
                                    applicationInfo = null;
                                    if (!zzd().zzp(null, zzfy.zzaI)) {
                                        bundle2.putLong("_uwa", 1L);
                                    } else if (jZzN == 0) {
                                        bundle2.putLong("_uwa", 1L);
                                        z2 = false;
                                        jZzN = 0;
                                    }
                                    jZzN = jZzN;
                                    z2 = false;
                                } else {
                                    applicationInfo = null;
                                    jZzN = jZzN;
                                    z2 = true;
                                }
                                zzad(new zzpl("_fi", j7, Long.valueOf(true != z2 ? 0L : 1L), DebugKt.DEBUG_PROPERTY_VALUE_AUTO), zzrVar);
                            }
                            try {
                                applicationInfo2 = Wrappers.packageManager(this.zzn.zzaZ()).getApplicationInfo(str4, 0);
                            } catch (PackageManager.NameNotFoundException e3) {
                                zzaW().zzb().zzc("Application info is null, first open report might be inaccurate. appId", zzgu.zzl(str4), e3);
                                applicationInfo2 = applicationInfo;
                            }
                            if (applicationInfo2 != null) {
                                if ((applicationInfo2.flags & 1) != 0) {
                                    j2 = 1;
                                    bundle2.putLong("_sys", 1L);
                                } else {
                                    j2 = 1;
                                }
                                if ((applicationInfo2.flags & 128) != 0) {
                                    bundle2.putLong("_sysu", j2);
                                }
                            }
                        }
                        if (jZzN >= 0) {
                            bundle2.putLong("_pfo", jZzN);
                        }
                        bundle2.putLong(str, zzba().currentTimeMillis());
                        zzE(new zzbh("_f", new zzbf(bundle2), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, j7, j3), zzrVar);
                    }
                } else {
                    long j8 = j;
                    if (zzrVar.zzi) {
                        zzE(new zzbh("_cd", new zzbf(new Bundle()), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, j8, 0L), zzrVar);
                    }
                }
                zzj().zzc();
            } finally {
                zzj().zzd();
            }
        }
    }

    final void zzaj(zzr zzrVar) throws Throwable {
        zzaX().zzg();
        zzu();
        Preconditions.checkNotNull(zzrVar);
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        int i = 0;
        if (zzd().zzp(null, zzfy.zzay)) {
            long jCurrentTimeMillis = zzba().currentTimeMillis();
            int iZzm = zzd().zzm(null, zzfy.zzah);
            zzd();
            long jZzF = jCurrentTimeMillis - zzal.zzF();
            while (i < iZzm && zzaH(null, jZzF)) {
                i++;
            }
        } else {
            zzd();
            long jZzH = zzal.zzH();
            while (i < jZzH && zzaH(str, 0L)) {
                i++;
            }
        }
        if (zzd().zzp(null, zzfy.zzaz)) {
            zzaX().zzg();
            zzaw();
        }
        if (this.zzl.zzc(str, com.google.android.gms.internal.measurement.zzin.zzb(zzrVar.zzE))) {
            zzaW().zzk().zzb("[sgtm] Going background, trigger client side upload. appId", str);
            zzN(str, zzba().currentTimeMillis());
        }
    }

    final void zzak(zzah zzahVar) {
        zzr zzrVarZzaP = zzaP((String) Preconditions.checkNotNull(zzahVar.zza));
        if (zzrVarZzaP != null) {
            zzal(zzahVar, zzrVarZzaP);
        }
    }

    final void zzal(zzah zzahVar, zzr zzrVar) {
        Preconditions.checkNotNull(zzahVar);
        Preconditions.checkNotEmpty(zzahVar.zza);
        Preconditions.checkNotNull(zzahVar.zzb);
        Preconditions.checkNotNull(zzahVar.zzc);
        Preconditions.checkNotEmpty(zzahVar.zzc.zzb);
        zzaX().zzg();
        zzu();
        if (zzaS(zzrVar)) {
            if (!zzrVar.zzh) {
                zzap(zzrVar);
                return;
            }
            zzah zzahVar2 = new zzah(zzahVar);
            boolean z = false;
            zzahVar2.zze = false;
            zzj().zzb();
            try {
                zzah zzahVarZzq = zzj().zzq((String) Preconditions.checkNotNull(zzahVar2.zza), zzahVar2.zzc.zzb);
                if (zzahVarZzq != null && !zzahVarZzq.zzb.equals(zzahVar2.zzb)) {
                    zzaW().zze().zzd("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzn.zzl().zzc(zzahVar2.zzc.zzb), zzahVar2.zzb, zzahVarZzq.zzb);
                }
                if (zzahVarZzq != null && zzahVarZzq.zze) {
                    zzahVar2.zzb = zzahVarZzq.zzb;
                    zzahVar2.zzd = zzahVarZzq.zzd;
                    zzahVar2.zzh = zzahVarZzq.zzh;
                    zzahVar2.zzf = zzahVarZzq.zzf;
                    zzahVar2.zzi = zzahVarZzq.zzi;
                    zzahVar2.zze = true;
                    zzpl zzplVar = zzahVar2.zzc;
                    zzahVar2.zzc = new zzpl(zzplVar.zzb, zzahVarZzq.zzc.zzc, zzplVar.zza(), zzahVarZzq.zzc.zzf);
                } else if (TextUtils.isEmpty(zzahVar2.zzf)) {
                    zzpl zzplVar2 = zzahVar2.zzc;
                    zzahVar2.zzc = new zzpl(zzplVar2.zzb, zzahVar2.zzd, zzplVar2.zza(), zzahVar2.zzc.zzf);
                    zzahVar2.zze = true;
                    z = true;
                }
                if (zzahVar2.zze) {
                    zzpl zzplVar3 = zzahVar2.zzc;
                    zzpn zzpnVar = new zzpn((String) Preconditions.checkNotNull(zzahVar2.zza), zzahVar2.zzb, zzplVar3.zzb, zzplVar3.zzc, Preconditions.checkNotNull(zzplVar3.zza()));
                    if (zzj().zzl(zzpnVar)) {
                        zzaW().zzj().zzd("User property updated immediately", zzahVar2.zza, this.zzn.zzl().zzc(zzpnVar.zzc), zzpnVar.zze);
                    } else {
                        zzaW().zzb().zzd("(2)Too many active user properties, ignoring", zzgu.zzl(zzahVar2.zza), this.zzn.zzl().zzc(zzpnVar.zzc), zzpnVar.zze);
                    }
                    if (z && zzahVar2.zzi != null) {
                        zzH(new zzbh(zzahVar2.zzi, zzahVar2.zzd, 0L), zzrVar);
                    }
                }
                if (zzj().zzp(zzahVar2)) {
                    zzaW().zzj().zzd("Conditional property added", zzahVar2.zza, this.zzn.zzl().zzc(zzahVar2.zzc.zzb), zzahVar2.zzc.zza());
                } else {
                    zzaW().zzb().zzd("Too many conditional properties, ignoring", zzgu.zzl(zzahVar2.zza), this.zzn.zzl().zzc(zzahVar2.zzc.zzb), zzahVar2.zzc.zza());
                }
                zzj().zzc();
            } finally {
                zzj().zzd();
            }
        }
    }

    final void zzam(zzah zzahVar) {
        zzr zzrVarZzaP = zzaP((String) Preconditions.checkNotNull(zzahVar.zza));
        if (zzrVarZzaP != null) {
            zzan(zzahVar, zzrVarZzaP);
        }
    }

    final void zzan(zzah zzahVar, zzr zzrVar) {
        Preconditions.checkNotNull(zzahVar);
        Preconditions.checkNotEmpty(zzahVar.zza);
        Preconditions.checkNotNull(zzahVar.zzc);
        Preconditions.checkNotEmpty(zzahVar.zzc.zzb);
        zzaX().zzg();
        zzu();
        if (zzaS(zzrVar)) {
            if (!zzrVar.zzh) {
                zzap(zzrVar);
                return;
            }
            zzj().zzb();
            try {
                zzap(zzrVar);
                String str = (String) Preconditions.checkNotNull(zzahVar.zza);
                zzah zzahVarZzq = zzj().zzq(str, zzahVar.zzc.zzb);
                if (zzahVarZzq != null) {
                    zzaW().zzj().zzc("Removing conditional user property", zzahVar.zza, this.zzn.zzl().zzc(zzahVar.zzc.zzb));
                    zzj().zzr(str, zzahVar.zzc.zzb);
                    if (zzahVarZzq.zze) {
                        zzj().zzk(str, zzahVar.zzc.zzb);
                    }
                    zzbh zzbhVar = zzahVar.zzk;
                    if (zzbhVar != null) {
                        zzbf zzbfVar = zzbhVar.zzb;
                        zzH((zzbh) Preconditions.checkNotNull(zzt().zzaf(str, ((zzbh) Preconditions.checkNotNull(zzbhVar)).zza, zzbfVar != null ? zzbfVar.zzf() : null, zzahVarZzq.zzb, zzbhVar.zzd, zzbhVar.zze, true, true)), zzrVar);
                    }
                } else {
                    zzaW().zze().zzc("Conditional user property doesn't exist", zzgu.zzl(zzahVar.zza), this.zzn.zzl().zzc(zzahVar.zzc.zzb));
                }
                zzj().zzc();
            } finally {
                zzj().zzd();
            }
        }
    }

    final void zzao(zzr zzrVar, long j) {
        zzh zzhVarZzu = zzj().zzu((String) Preconditions.checkNotNull(zzrVar.zza));
        if (zzhVarZzu != null && zzt().zzD(zzrVar.zzb, zzhVarZzu.zzf())) {
            zzaW().zze().zzb("New GMP App Id passed in. Removing cached database data. appId", zzgu.zzl(zzhVarZzu.zzc()));
            zzaw zzawVarZzj = zzj();
            String strZzc = zzhVarZzu.zzc();
            zzawVarZzj.zzay();
            zzawVarZzj.zzg();
            Preconditions.checkNotEmpty(strZzc);
            try {
                SQLiteDatabase sQLiteDatabaseZze = zzawVarZzj.zze();
                String[] strArr = {strZzc};
                int iDelete = sQLiteDatabaseZze.delete("events", "app_id=?", strArr) + sQLiteDatabaseZze.delete("user_attributes", "app_id=?", strArr) + sQLiteDatabaseZze.delete("conditional_properties", "app_id=?", strArr) + sQLiteDatabaseZze.delete("apps", "app_id=?", strArr) + sQLiteDatabaseZze.delete("raw_events", "app_id=?", strArr) + sQLiteDatabaseZze.delete("raw_events_metadata", "app_id=?", strArr) + sQLiteDatabaseZze.delete("event_filters", "app_id=?", strArr) + sQLiteDatabaseZze.delete("property_filters", "app_id=?", strArr) + sQLiteDatabaseZze.delete("audience_filter_values", "app_id=?", strArr) + sQLiteDatabaseZze.delete("consent_settings", "app_id=?", strArr) + sQLiteDatabaseZze.delete("default_event_params", "app_id=?", strArr) + sQLiteDatabaseZze.delete("trigger_uris", "app_id=?", strArr) + sQLiteDatabaseZze.delete("diagnostic_signals", "app_id=?", strArr);
                zzahh.zza();
                zzic zzicVar = zzawVarZzj.zzu;
                if (zzicVar.zzc().zzp(null, zzfy.zzbc)) {
                    iDelete += sQLiteDatabaseZze.delete("no_data_mode_events", "app_id=?", strArr);
                }
                if (iDelete > 0) {
                    zzicVar.zzaW().zzk().zzc("Deleted application data. app, records", strZzc, Integer.valueOf(iDelete));
                }
            } catch (SQLiteException e) {
                zzawVarZzj.zzu.zzaW().zzb().zzc("Error deleting application data. appId, error", zzgu.zzl(strZzc), e);
            }
            zzhVarZzu = null;
        }
        if (zzhVarZzu != null) {
            boolean z = (zzhVarZzu.zzt() == SieveCacheKt.NodeMetaAndPreviousMask || zzhVarZzu.zzt() == zzrVar.zzj) ? false : true;
            String strZzr = zzhVarZzu.zzr();
            if (z || ((zzhVarZzu.zzt() != SieveCacheKt.NodeMetaAndPreviousMask || strZzr == null || strZzr.equals(zzrVar.zzc)) ? false : true)) {
                Bundle bundle = new Bundle();
                bundle.putString("_pv", strZzr);
                zzbh zzbhVar = new zzbh("_au", new zzbf(bundle), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, j, 0L);
                if (zzd().zzp(null, zzfy.zzaX)) {
                    zzE(zzbhVar, zzrVar);
                } else {
                    zzF(zzbhVar, zzrVar);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final zzh zzap(zzr zzrVar) {
        boolean z;
        String str;
        long j;
        String str2;
        String str3;
        String str4;
        zzaX().zzg();
        zzu();
        Preconditions.checkNotNull(zzrVar);
        String str5 = zzrVar.zza;
        Preconditions.checkNotEmpty(str5);
        String str6 = zzrVar.zzt;
        byte[] bArr = null;
        if (!str6.isEmpty()) {
            this.zzE.put(str5, new zzpd(this, str6, bArr));
        }
        zzh zzhVarZzu = zzj().zzu(str5);
        zzjl zzjlVarZzs = zzB(str5).zzs(zzjl.zzf(zzrVar.zzs, 100));
        String strZzf = this.zzk.zzf(zzrVar, zzjlVarZzs);
        boolean z2 = true;
        if (zzhVarZzu == null) {
            zzh zzhVar = new zzh(this.zzn, str5);
            if (zzjlVarZzs.zzo(zzjk.ANALYTICS_STORAGE)) {
                zzhVar.zze(zzK(zzjlVarZzs));
            }
            if (zzjlVarZzs.zzo(zzjk.AD_STORAGE)) {
                zzhVar.zzk(strZzf);
            }
            zzhVarZzu = zzhVar;
        } else if (zzjlVarZzs.zzo(zzjk.AD_STORAGE) && strZzf != null && !strZzf.equals(zzhVarZzu.zzj())) {
            boolean zIsEmpty = TextUtils.isEmpty(zzhVarZzu.zzj());
            zzhVarZzu.zzk(strZzf);
            if (zzrVar.zzn && !"00000000-0000-0000-0000-000000000000".equals(this.zzk.zzc(zzrVar, zzjlVarZzs).first) && !zIsEmpty) {
                if (zzjlVarZzs.zzo(zzjk.ANALYTICS_STORAGE)) {
                    zzhVarZzu.zze(zzK(zzjlVarZzs));
                    z = false;
                } else {
                    z = true;
                }
                if (zzj().zzm(str5, "_id") != null && zzj().zzm(str5, "_lair") == null) {
                    zzj().zzl(new zzpn(str5, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_lair", zzba().currentTimeMillis(), 1L));
                }
                zzhVarZzu.zzg(zzrVar.zzb);
                str = zzrVar.zzk;
                if (!TextUtils.isEmpty(str)) {
                    zzhVarZzu.zzm(str);
                }
                j = zzrVar.zze;
                if (j != 0) {
                    zzhVarZzu.zzy(j);
                }
                str2 = zzrVar.zzc;
                if (!TextUtils.isEmpty(str2)) {
                    zzhVarZzu.zzs(str2);
                }
                zzhVarZzu.zzu(zzrVar.zzj);
                str3 = zzrVar.zzd;
                if (str3 != null) {
                    zzhVarZzu.zzw(str3);
                }
                zzhVarZzu.zzA(zzrVar.zzf);
                zzhVarZzu.zzE(zzrVar.zzh);
                str4 = zzrVar.zzg;
                if (!TextUtils.isEmpty(str4)) {
                    zzhVarZzu.zzab(str4);
                }
                zzhVarZzu.zzad(zzrVar.zzn);
                zzhVarZzu.zzaf(zzrVar.zzp);
                zzhVarZzu.zzC(zzrVar.zzq);
                zzhVarZzu.zzi(zzrVar.zzu);
                zzahk.zza();
                if (zzd().zzp(null, zzfy.zzaL)) {
                    zzahk.zza();
                    if (zzd().zzp(null, zzfy.zzaK)) {
                        zzhVarZzu.zzah(null);
                    }
                } else {
                    zzhVarZzu.zzah(zzrVar.zzr);
                }
                zzhVarZzu.zzaj(zzrVar.zzv);
                zzhVarZzu.zzaz(zzrVar.zzB);
                zzaif.zza();
                if (zzd().zzp(null, zzfy.zzaO)) {
                    zzhVarZzu.zzap(zzrVar.zzz);
                }
                zzhVarZzu.zzal(zzrVar.zzw);
                zzhVarZzu.zzaG(zzrVar.zzC);
                zzhVarZzu.zzaK(zzrVar.zzE);
                if (!zzhVarZzu.zza()) {
                    z2 = z;
                } else if (!z) {
                    return zzhVarZzu;
                }
                zzj().zzv(zzhVarZzu, z2, false);
                return zzhVarZzu;
            }
            if (TextUtils.isEmpty(zzhVarZzu.zzd()) && zzjlVarZzs.zzo(zzjk.ANALYTICS_STORAGE)) {
                zzhVarZzu.zze(zzK(zzjlVarZzs));
            }
        } else if (TextUtils.isEmpty(zzhVarZzu.zzd()) && zzjlVarZzs.zzo(zzjk.ANALYTICS_STORAGE)) {
            zzhVarZzu.zze(zzK(zzjlVarZzs));
        }
        z = false;
        zzhVarZzu.zzg(zzrVar.zzb);
        str = zzrVar.zzk;
        if (!TextUtils.isEmpty(str)) {
        }
        j = zzrVar.zze;
        if (j != 0) {
        }
        str2 = zzrVar.zzc;
        if (!TextUtils.isEmpty(str2)) {
        }
        zzhVarZzu.zzu(zzrVar.zzj);
        str3 = zzrVar.zzd;
        if (str3 != null) {
        }
        zzhVarZzu.zzA(zzrVar.zzf);
        zzhVarZzu.zzE(zzrVar.zzh);
        str4 = zzrVar.zzg;
        if (!TextUtils.isEmpty(str4)) {
        }
        zzhVarZzu.zzad(zzrVar.zzn);
        zzhVarZzu.zzaf(zzrVar.zzp);
        zzhVarZzu.zzC(zzrVar.zzq);
        zzhVarZzu.zzi(zzrVar.zzu);
        zzahk.zza();
        if (zzd().zzp(null, zzfy.zzaL)) {
        }
        zzhVarZzu.zzaj(zzrVar.zzv);
        zzhVarZzu.zzaz(zzrVar.zzB);
        zzaif.zza();
        if (zzd().zzp(null, zzfy.zzaO)) {
        }
        zzhVarZzu.zzal(zzrVar.zzw);
        zzhVarZzu.zzaG(zzrVar.zzC);
        zzhVarZzu.zzaK(zzrVar.zzE);
        if (!zzhVarZzu.zza()) {
        }
        zzj().zzv(zzhVarZzu, z2, false);
        return zzhVarZzu;
    }

    final String zzaq(zzr zzrVar) {
        try {
            return (String) zzaX().zzh(new zzoz(this, zzrVar)).get(30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzaW().zzb().zzc("Failed to get app instance id. appId", zzgu.zzl(zzrVar.zza), e);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00de  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final List zzar(zzr zzrVar, Bundle bundle) {
        int i;
        int i2;
        int i3;
        zzaX().zzg();
        zzaif.zza();
        zzal zzalVarZzd = zzd();
        String str = zzrVar.zza;
        if (!zzalVarZzd.zzp(str, zzfy.zzaO) || str == null) {
            return new ArrayList();
        }
        if (bundle != null) {
            int[] intArray = bundle.getIntArray("uriSources");
            long[] longArray = bundle.getLongArray("uriTimestamps");
            if (intArray == null) {
                i = 2;
                i2 = 0;
                i3 = 1;
            } else if (longArray == null || longArray.length != intArray.length) {
                i = 2;
                i2 = 0;
                i3 = 1;
                zzaW().zzb().zza("Uri sources and timestamps do not match");
            } else {
                for (int i4 = 0; i4 < intArray.length; i4++) {
                    zzaw zzawVarZzj = zzj();
                    int i5 = intArray[i4];
                    long j = longArray[i4];
                    Preconditions.checkNotEmpty(str);
                    zzawVarZzj.zzg();
                    zzawVarZzj.zzay();
                    try {
                        try {
                            int iDelete = zzawVarZzj.zze().delete("trigger_uris", "app_id=? and source=? and timestamp_millis<=?", new String[]{str, String.valueOf(i5), String.valueOf(j)});
                            zzgs zzgsVarZzk = zzawVarZzj.zzu.zzaW().zzk();
                            StringBuilder sb = new StringBuilder(String.valueOf(iDelete).length() + 46);
                            sb.append("Pruned ");
                            sb.append(iDelete);
                            sb.append(" trigger URIs. appId, source, timestamp");
                            zzgsVarZzk.zzd(sb.toString(), str, Integer.valueOf(i5), Long.valueOf(j));
                        } catch (SQLiteException e) {
                            e = e;
                            zzawVarZzj.zzu.zzaW().zzb().zzc("Error pruning trigger URIs. appId", zzgu.zzl(str), e);
                        }
                    } catch (SQLiteException e2) {
                        e = e2;
                    }
                }
                i = 2;
                i2 = 0;
                i3 = 1;
            }
        }
        zzaw zzawVarZzj2 = zzj();
        String str2 = zzrVar.zza;
        Preconditions.checkNotEmpty(str2);
        zzawVarZzj2.zzg();
        zzawVarZzj2.zzay();
        List arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseZze = zzawVarZzj2.zze();
                String[] strArr = new String[3];
                strArr[i2] = "trigger_uri";
                strArr[i3] = "timestamp_millis";
                strArr[i] = "source";
                String[] strArr2 = new String[i3];
                strArr2[i2] = str2;
                cursorQuery = sQLiteDatabaseZze.query("trigger_uris", strArr, "app_id=?", strArr2, null, null, "rowid", null);
                if (cursorQuery.moveToFirst()) {
                    int i6 = i2;
                    while (true) {
                        String string = cursorQuery.getString(i6);
                        if (string == null) {
                            string = "";
                        }
                        int i7 = i;
                        arrayList.add(new zzoh(string, cursorQuery.getLong(1), cursorQuery.getInt(i7)));
                        if (!cursorQuery.moveToNext()) {
                            break;
                        }
                        i = i7;
                    }
                }
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            zzawVarZzj2.zzu.zzaW().zzb().zzc("Error querying trigger uris. appId", zzgu.zzl(str2), e3);
            arrayList = Collections.emptyList();
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return arrayList;
    }

    final void zzas(String str, zzaf zzafVar) {
        zzaX().zzg();
        zzu();
        zzaw zzawVarZzj = zzj();
        long j = zzafVar.zza;
        zzpj zzpjVarZzB = zzawVarZzj.zzB(j);
        if (zzpjVarZzB == null) {
            zzaW().zze().zzc("[sgtm] Queued batch doesn't exist. appId, rowId", str, Long.valueOf(j));
            return;
        }
        String strZze = zzpjVarZzB.zze();
        if (zzafVar.zzb != zzlr.SUCCESS.zza()) {
            if (zzafVar.zzb == zzlr.BACKOFF.zza()) {
                Map map = this.zzF;
                zzpe zzpeVar = (zzpe) map.get(strZze);
                if (zzpeVar == null) {
                    zzpeVar = new zzpe(this);
                    map.put(strZze, zzpeVar);
                } else {
                    zzpeVar.zza();
                }
                zzaW().zzk().zzd("[sgtm] Putting sGTM server in backoff mode. appId, destination, nextRetryInSeconds", str, strZze, Long.valueOf((zzpeVar.zzc() - zzba().currentTimeMillis()) / 1000));
            }
            zzaw zzawVarZzj2 = zzj();
            Long lValueOf = Long.valueOf(zzafVar.zza);
            zzawVarZzj2.zzK(lValueOf);
            zzaW().zzk().zzc("[sgtm] increased batch retry count after failed client upload. appId, rowId", str, lValueOf);
            return;
        }
        Map map2 = this.zzF;
        if (map2.containsKey(strZze)) {
            map2.remove(strZze);
        }
        zzaw zzawVarZzj3 = zzj();
        Long lValueOf2 = Long.valueOf(j);
        zzawVarZzj3.zzE(lValueOf2);
        zzaW().zzk().zzc("[sgtm] queued batch deleted after successful client upload. appId, rowId", str, lValueOf2);
        long j2 = zzafVar.zzc;
        if (j2 > 0) {
            zzaw zzawVarZzj4 = zzj();
            zzawVarZzj4.zzg();
            zzawVarZzj4.zzay();
            Long lValueOf3 = Long.valueOf(j2);
            Preconditions.checkNotNull(lValueOf3);
            ContentValues contentValues = new ContentValues();
            contentValues.put("upload_type", Integer.valueOf(zzls.GOOGLE_SIGNAL.zza()));
            zzic zzicVar = zzawVarZzj4.zzu;
            contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzicVar.zzba().currentTimeMillis()));
            try {
                if (zzawVarZzj4.zze().update("upload_queue", contentValues, "rowid=? AND app_id=? AND upload_type=?", new String[]{String.valueOf(j2), str, String.valueOf(zzls.GOOGLE_SIGNAL_PENDING.zza())}) != 1) {
                    zzicVar.zzaW().zze().zzc("Google Signal pending batch not updated. appId, rowId", str, lValueOf3);
                }
                zzaW().zzk().zzc("[sgtm] queued Google Signal batch updated. appId, signalRowId", str, Long.valueOf(zzafVar.zzc));
                zzP(str);
            } catch (SQLiteException e) {
                zzawVarZzj4.zzu.zzaW().zzb().zzd("Failed to update google Signal pending batch. appid, rowId", str, Long.valueOf(j2), e);
                throw e;
            }
        }
    }

    final void zzat(boolean z) {
        zzaM();
    }

    public final void zzau(String str, zzlu zzluVar) {
        zzaX().zzg();
        String str2 = this.zzH;
        if (str2 == null || str2.equals(str) || zzluVar != null) {
            this.zzH = str;
            this.zzG = zzluVar;
        }
    }

    final /* synthetic */ void zzav(zzph zzphVar) {
        zzaX().zzg();
        this.zzm = new zzhk(this);
        zzaw zzawVar = new zzaw(this);
        zzawVar.zzaz();
        this.zze = zzawVar;
        zzd().zza((zzak) Preconditions.checkNotNull(this.zzc));
        zznn zznnVar = new zznn(this);
        zznnVar.zzaz();
        this.zzk = zznnVar;
        zzad zzadVar = new zzad(this);
        zzadVar.zzaz();
        this.zzh = zzadVar;
        zzlp zzlpVar = new zzlp(this);
        zzlpVar.zzaz();
        this.zzj = zzlpVar;
        zzok zzokVar = new zzok(this);
        zzokVar.zzaz();
        this.zzg = zzokVar;
        this.zzf = new zzhb(this);
        if (this.zzs != this.zzt) {
            zzaW().zzb().zzc("Not all upload components initialized", Integer.valueOf(this.zzs), Integer.valueOf(this.zzt));
        }
        this.zzo.set(true);
        zzaW().zzk().zza("UploadController is now fully initialized");
    }

    final /* synthetic */ zzic zzay() {
        return this.zzn;
    }

    final /* synthetic */ Deque zzaz() {
        return this.zzr;
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final Clock zzba() {
        return ((zzic) Preconditions.checkNotNull(this.zzn)).zzba();
    }

    protected final void zzc() {
        zzaX().zzg();
        zzj().zzI();
        zzaw zzawVarZzj = zzj();
        zzawVarZzj.zzg();
        zzawVarZzj.zzay();
        if (zzawVarZzj.zzai()) {
            zzfx zzfxVar = zzfy.zzau;
            if (((Long) zzfxVar.zzb(null)).longValue() != 0) {
                SQLiteDatabase sQLiteDatabaseZze = zzawVarZzj.zze();
                zzic zzicVar = zzawVarZzj.zzu;
                int iDelete = sQLiteDatabaseZze.delete("trigger_uris", "abs(timestamp_millis - ?) > cast(? as integer)", new String[]{String.valueOf(zzicVar.zzba().currentTimeMillis()), String.valueOf(zzfxVar.zzb(null))});
                if (iDelete > 0) {
                    zzicVar.zzaW().zzk().zzb("Deleted stale trigger uris. rowsDeleted", Integer.valueOf(iDelete));
                }
            }
        }
        if (this.zzk.zzd.zza() == 0) {
            this.zzk.zzd.zzb(zzba().currentTimeMillis());
        }
        zzaM();
    }

    public final zzal zzd() {
        return ((zzic) Preconditions.checkNotNull(this.zzn)).zzc();
    }

    public final zzou zzf() {
        return this.zzl;
    }

    public final zzht zzh() {
        zzht zzhtVar = this.zzc;
        zzaT(zzhtVar);
        return zzhtVar;
    }

    public final zzgz zzi() {
        zzgz zzgzVar = this.zzd;
        zzaT(zzgzVar);
        return zzgzVar;
    }

    public final zzaw zzj() {
        zzaw zzawVar = this.zze;
        zzaT(zzawVar);
        return zzawVar;
    }

    public final zzhb zzk() {
        zzhb zzhbVar = this.zzf;
        if (zzhbVar != null) {
            return zzhbVar;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public final zzok zzl() {
        zzok zzokVar = this.zzg;
        zzaT(zzokVar);
        return zzokVar;
    }

    public final zzad zzm() {
        zzad zzadVar = this.zzh;
        zzaT(zzadVar);
        return zzadVar;
    }

    public final zzlp zzn() {
        zzlp zzlpVar = this.zzj;
        zzaT(zzlpVar);
        return zzlpVar;
    }

    public final zzpk zzp() {
        zzpk zzpkVar = this.zzi;
        zzaT(zzpkVar);
        return zzpkVar;
    }

    public final zznn zzq() {
        return this.zzk;
    }

    public final zzgn zzs() {
        return this.zzn.zzl();
    }

    public final zzpp zzt() {
        return ((zzic) Preconditions.checkNotNull(this.zzn)).zzk();
    }

    final void zzu() {
        if (!this.zzo.get()) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    final void zzv(zzr zzrVar) {
        zzaX().zzg();
        zzu();
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        zzjl zzjlVarZzf = zzjl.zzf(zzrVar.zzs, zzrVar.zzx);
        zzB(str);
        zzaW().zzk().zzc("Setting storage consent for package", str, zzjlVarZzf);
        zzA(str, zzjlVarZzf);
    }

    final void zzw(zzr zzrVar) {
        zzaX().zzg();
        zzu();
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        zzba zzbaVarZzg = zzba.zzg(zzrVar.zzy);
        zzaW().zzk().zzc("Setting DMA consent for package", str, zzbaVarZzg);
        zzaX().zzg();
        zzu();
        zzji zzjiVarZzc = zzba.zzh(zzy(str), 100).zzc();
        this.zzD.put(str, zzbaVarZzg);
        zzj().zzad(str, zzbaVarZzg);
        zzji zzjiVarZzc2 = zzba.zzh(zzy(str), 100).zzc();
        zzaX().zzg();
        zzu();
        zzji zzjiVar = zzji.DENIED;
        boolean z = zzjiVarZzc == zzjiVar && zzjiVarZzc2 == zzji.GRANTED;
        boolean z2 = zzjiVarZzc == zzji.GRANTED && zzjiVarZzc2 == zzjiVar;
        if (z || z2) {
            zzaW().zzk().zzb("Generated _dcu event for", str);
            Bundle bundle = new Bundle();
            if (zzj().zzw(zzC(), str, false, false, false, false, false, false, false).zzf < zzd().zzm(str, zzfy.zzal)) {
                bundle.putLong("_r", 1L);
                zzaW().zzk().zzc("_dcu realtime event count", str, Long.valueOf(zzj().zzw(zzC(), str, false, false, false, false, false, true, false).zzf));
            }
            this.zzK.zza(str, "_dcu", bundle);
        }
    }

    final zzba zzx(String str) {
        zzaX().zzg();
        zzu();
        Map map = this.zzD;
        zzba zzbaVar = (zzba) map.get(str);
        if (zzbaVar != null) {
            return zzbaVar;
        }
        zzba zzbaVarZzab = zzj().zzab(str);
        map.put(str, zzbaVarZzab);
        return zzbaVarZzab;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    final Bundle zzy(String str) {
        zzaX().zzg();
        zzu();
        if (zzh().zzy(str) == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        zzjl zzjlVarZzB = zzB(str);
        bundle.putAll(zzjlVarZzB.zzn());
        bundle.putAll(zzz(str, zzx(str), zzjlVarZzB, new zzan()).zzf());
        zzpn zzpnVarZzm = zzj().zzm(str, "_npa");
        bundle.putString("ad_personalization", 1 != (zzpnVarZzm != null ? zzpnVarZzm.zze.equals(1L) : zzaD(str, new zzan())) ? "granted" : "denied");
        return bundle;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final zzba zzz(String str, zzba zzbaVar, zzjl zzjlVar, zzan zzanVar) {
        zzji zzjiVar;
        int iZzb = 90;
        if (zzh().zzy(str) == null) {
            if (zzbaVar.zzc() == zzji.DENIED) {
                iZzb = zzbaVar.zzb();
                zzanVar.zzb(zzjk.AD_USER_DATA, iZzb);
            } else {
                zzanVar.zzc(zzjk.AD_USER_DATA, zzam.FAILSAFE);
            }
            return new zzba((Boolean) false, iZzb, (Boolean) true, "-");
        }
        zzji zzjiVarZzc = zzbaVar.zzc();
        zzji zzjiVar2 = zzji.GRANTED;
        if (zzjiVarZzc == zzjiVar2 || zzjiVarZzc == (zzjiVar = zzji.DENIED)) {
            iZzb = zzbaVar.zzb();
            zzanVar.zzb(zzjk.AD_USER_DATA, iZzb);
        } else if (zzjiVarZzc == zzji.POLICY) {
            zzht zzhtVar = this.zzc;
            zzjk zzjkVar = zzjk.AD_USER_DATA;
            zzji zzjiVarZzB = zzhtVar.zzB(str, zzjkVar);
            if (zzjiVarZzB != zzji.UNINITIALIZED) {
                zzanVar.zzc(zzjkVar, zzam.REMOTE_ENFORCED_DEFAULT);
                zzjiVarZzc = zzjiVarZzB;
            } else {
                zzht zzhtVar2 = this.zzc;
                zzjk zzjkVar2 = zzjk.AD_USER_DATA;
                zzjk zzjkVarZzx = zzhtVar2.zzx(str, zzjkVar2);
                zzji zzjiVarZzp = zzjlVar.zzp();
                boolean z = zzjiVarZzp == zzjiVar2 || zzjiVarZzp == zzjiVar;
                if (zzjkVarZzx == zzjk.AD_STORAGE && z) {
                    zzanVar.zzc(zzjkVar2, zzam.REMOTE_DELEGATION);
                    zzjiVarZzc = zzjiVarZzp;
                } else {
                    zzanVar.zzc(zzjkVar2, zzam.REMOTE_DEFAULT);
                    zzjiVarZzc = true != zzhtVar2.zzw(str, zzjkVar2) ? zzjiVar : zzjiVar2;
                }
            }
        }
        boolean zZzz = this.zzc.zzz(str);
        SortedSet sortedSetZzA = zzh().zzA(str);
        if (zzjiVarZzc == zzji.DENIED || sortedSetZzA.isEmpty()) {
            return new zzba((Boolean) false, iZzb, Boolean.valueOf(zZzz), "-");
        }
        return new zzba((Boolean) true, iZzb, Boolean.valueOf(zZzz), zZzz ? TextUtils.join("", sortedSetZzA) : "");
    }
}
