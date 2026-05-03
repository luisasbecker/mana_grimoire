package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.SieveCacheKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.webkit.ProxyConfig;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzahk;
import com.google.android.gms.internal.measurement.zzaif;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.messaging.Constants;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaw extends zzos {
    private final zzav zzm;
    private final zzog zzn;
    private static final String[] zzb = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    static final String[] zza = {"associated_row_id", "ALTER TABLE upload_queue ADD COLUMN associated_row_id INTEGER;", "last_upload_timestamp", "ALTER TABLE upload_queue ADD COLUMN last_upload_timestamp INTEGER;"};
    private static final String[] zzc = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    private static final String[] zzd = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;", "sgtm_upload_enabled", "ALTER TABLE apps ADD COLUMN sgtm_upload_enabled INTEGER;", "target_os_version", "ALTER TABLE apps ADD COLUMN target_os_version INTEGER;", "session_stitching_token_hash", "ALTER TABLE apps ADD COLUMN session_stitching_token_hash INTEGER;", "ad_services_version", "ALTER TABLE apps ADD COLUMN ad_services_version INTEGER;", "unmatched_first_open_without_ad_id", "ALTER TABLE apps ADD COLUMN unmatched_first_open_without_ad_id INTEGER;", "npa_metadata_value", "ALTER TABLE apps ADD COLUMN npa_metadata_value INTEGER;", "attribution_eligibility_status", "ALTER TABLE apps ADD COLUMN attribution_eligibility_status INTEGER;", "sgtm_preview_key", "ALTER TABLE apps ADD COLUMN sgtm_preview_key TEXT;", "dma_consent_state", "ALTER TABLE apps ADD COLUMN dma_consent_state INTEGER;", "daily_realtime_dcu_count", "ALTER TABLE apps ADD COLUMN daily_realtime_dcu_count INTEGER;", "bundle_delivery_index", "ALTER TABLE apps ADD COLUMN bundle_delivery_index INTEGER;", "serialized_npa_metadata", "ALTER TABLE apps ADD COLUMN serialized_npa_metadata TEXT;", "unmatched_pfo", "ALTER TABLE apps ADD COLUMN unmatched_pfo INTEGER;", "unmatched_uwa", "ALTER TABLE apps ADD COLUMN unmatched_uwa INTEGER;", "ad_campaign_info", "ALTER TABLE apps ADD COLUMN ad_campaign_info BLOB;", "daily_registered_triggers_count", "ALTER TABLE apps ADD COLUMN daily_registered_triggers_count INTEGER;", "client_upload_eligibility", "ALTER TABLE apps ADD COLUMN client_upload_eligibility INTEGER;", "gmp_version_for_remote_config", "ALTER TABLE apps ADD COLUMN gmp_version_for_remote_config INTEGER;", "last_diagnostics_signal_upload_timestamp", "ALTER TABLE apps ADD COLUMN last_diagnostics_signal_upload_timestamp INTEGER;"};
    private static final String[] zze = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;", "elapsed_time", "ALTER TABLE raw_events ADD COLUMN elapsed_time INTEGER;"};
    private static final String[] zzf = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    private static final String[] zzh = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzi = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzj = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private static final String[] zzk = {"consent_source", "ALTER TABLE consent_settings ADD COLUMN consent_source INTEGER;", "dma_consent_settings", "ALTER TABLE consent_settings ADD COLUMN dma_consent_settings TEXT;", "storage_consent_at_bundling", "ALTER TABLE consent_settings ADD COLUMN storage_consent_at_bundling TEXT;"};
    private static final String[] zzl = {"idempotent", "CREATE INDEX IF NOT EXISTS trigger_uris_index ON trigger_uris (app_id);"};

    zzaw(zzpg zzpgVar) {
        super(zzpgVar);
        this.zzn = new zzog(this.zzu.zzba());
        this.zzu.zzc();
        this.zzm = new zzav(this, this.zzu.zzaZ(), "google_app_measurement.db");
    }

    private final long zzaA(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = zze().rawQuery(str, strArr);
                if (!cursorRawQuery.moveToFirst()) {
                    throw new SQLiteException("Database returned empty set");
                }
                long j = cursorRawQuery.getLong(0);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return j;
            } catch (SQLiteException e) {
                this.zzu.zzaW().zzb().zzc("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    private final long zzaB(String str, String[] strArr, long j) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = zze().rawQuery(str, strArr);
                if (cursorRawQuery.moveToFirst()) {
                    j = cursorRawQuery.getLong(0);
                }
                return j;
            } catch (SQLiteException e) {
                this.zzu.zzaW().zzb().zzc("Database error", str, e);
                throw e;
            }
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }

    private final String zzaC(String str, String[] strArr, String str2) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = zze().rawQuery(str, strArr);
                if (cursorRawQuery.moveToFirst()) {
                    return cursorRawQuery.getString(0);
                }
                if (cursorRawQuery == null) {
                    return "";
                }
                cursorRawQuery.close();
                return "";
            } catch (SQLiteException e) {
                this.zzu.zzaW().zzb().zzc("Database error", str, e);
                throw e;
            }
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }

    private final void zzaD(String str, String str2, ContentValues contentValues) {
        try {
            SQLiteDatabase sQLiteDatabaseZze = zze();
            if (contentValues.getAsString("app_id") == null) {
                this.zzu.zzaW().zzd().zzb("Value of the primary key is not set.", zzgu.zzl("app_id"));
                return;
            }
            new StringBuilder(10).append("app_id = ?");
            if (sQLiteDatabaseZze.update("consent_settings", contentValues, r3.toString(), new String[]{r2}) == 0 && sQLiteDatabaseZze.insertWithOnConflict("consent_settings", null, contentValues, 5) == -1) {
                this.zzu.zzaW().zzb().zzc("Failed to insert/update table (got -1). key", zzgu.zzl("consent_settings"), zzgu.zzl("app_id"));
            }
        } catch (SQLiteException e) {
            this.zzu.zzaW().zzb().zzd("Error storing into table. key", zzgu.zzl("consent_settings"), zzgu.zzl("app_id"), e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0173  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final zzbd zzaE(String str, String str2, String str3) throws Throwable {
        String str4;
        Cursor cursorQuery;
        Cursor cursor;
        Boolean boolValueOf;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        zzg();
        zzay();
        Cursor cursor2 = null;
        try {
            cursorQuery = zze().query(str, (String[]) new ArrayList(Arrays.asList("lifetime_count", "current_bundle_count", "last_fire_timestamp", "last_bundled_timestamp", "last_bundled_day", "last_sampled_complex_event_id", "last_sampling_rate", "last_exempt_from_sampling", "current_session_count")).toArray(new String[0]), "app_id=? and name=?", new String[]{str2, str3}, null, null, null);
            try {
            } catch (SQLiteException e) {
                e = e;
                str4 = str3;
                cursor = cursorQuery;
            } catch (Throwable th) {
                th = th;
                cursor = cursorQuery;
            }
        } catch (SQLiteException e2) {
            e = e2;
            str4 = str3;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            if (!cursorQuery.moveToFirst()) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return null;
            }
            long j = cursorQuery.getLong(0);
            long j2 = cursorQuery.getLong(1);
            long j3 = cursorQuery.getLong(2);
            long j4 = cursorQuery.isNull(3) ? 0L : cursorQuery.getLong(3);
            Long lValueOf = cursorQuery.isNull(4) ? null : Long.valueOf(cursorQuery.getLong(4));
            Long lValueOf2 = cursorQuery.isNull(5) ? null : Long.valueOf(cursorQuery.getLong(5));
            Long lValueOf3 = cursorQuery.isNull(6) ? null : Long.valueOf(cursorQuery.getLong(6));
            if (cursorQuery.isNull(7)) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(cursorQuery.getLong(7) == 1);
            }
            try {
                cursor = cursorQuery;
                Long l = lValueOf2;
                str4 = str3;
                try {
                    zzbd zzbdVar = new zzbd(str2, str4, j, j2, cursorQuery.isNull(8) ? 0L : cursorQuery.getLong(8), j3, j4, lValueOf, l, lValueOf3, boolValueOf);
                    if (cursor.moveToNext()) {
                        this.zzu.zzaW().zzb().zzb("Got multiple records for event aggregates, expected one. appId", zzgu.zzl(str2));
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return zzbdVar;
                } catch (SQLiteException e3) {
                    e = e3;
                } catch (Throwable th3) {
                    th = th3;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                    }
                    throw th;
                }
            } catch (SQLiteException e4) {
                e = e4;
                str4 = str3;
                cursor = cursorQuery;
            } catch (Throwable th4) {
                th = th4;
                cursor = cursorQuery;
            }
            zzic zzicVar = this.zzu;
            zzicVar.zzaW().zzb().zzd("Error querying events. appId", zzgu.zzl(str2), zzicVar.zzl().zza(str4), e);
            if (cursorQuery != null) {
            }
            return null;
        } catch (Throwable th5) {
            th = th5;
            cursor2 = cursorQuery;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
        cursorQuery = cursor;
    }

    private final void zzaF(String str, zzbd zzbdVar) {
        Preconditions.checkNotNull(zzbdVar);
        zzg();
        zzay();
        ContentValues contentValues = new ContentValues();
        String str2 = zzbdVar.zza;
        contentValues.put("app_id", str2);
        contentValues.put("name", zzbdVar.zzb);
        contentValues.put("lifetime_count", Long.valueOf(zzbdVar.zzc));
        contentValues.put("current_bundle_count", Long.valueOf(zzbdVar.zzd));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzbdVar.zzf));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzbdVar.zzg));
        contentValues.put("last_bundled_day", zzbdVar.zzh);
        contentValues.put("last_sampled_complex_event_id", zzbdVar.zzi);
        contentValues.put("last_sampling_rate", zzbdVar.zzj);
        contentValues.put("current_session_count", Long.valueOf(zzbdVar.zze));
        Boolean bool = zzbdVar.zzk;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (zze().insertWithOnConflict(str, null, contentValues, 5) == -1) {
                this.zzu.zzaW().zzb().zzb("Failed to insert/update event aggregates (got -1). appId", zzgu.zzl(str2));
            }
        } catch (SQLiteException e) {
            this.zzu.zzaW().zzb().zzc("Error storing event aggregates. appId", zzgu.zzl(zzbdVar.zza), e);
        }
    }

    private final void zzaG(String str, String str2) {
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzay();
        try {
            zze().delete(str, "app_id=?", new String[]{str2});
        } catch (SQLiteException e) {
            this.zzu.zzaW().zzb().zzc("Error deleting snapshot. appId", zzgu.zzl(str2), e);
        }
    }

    private final zzpj zzaH(String str, long j, byte[] bArr, String str2, String str3, int i, int i2, long j2, long j3, long j4) {
        if (TextUtils.isEmpty(str2)) {
            this.zzu.zzaW().zzj().zza("Upload uri is null or empty. Destination is unknown. Dropping batch. ");
            return null;
        }
        try {
            com.google.android.gms.internal.measurement.zzhz zzhzVar = (com.google.android.gms.internal.measurement.zzhz) zzpk.zzw(com.google.android.gms.internal.measurement.zzib.zzi(), bArr);
            zzls zzlsVarZzb = zzls.zzb(i);
            if (zzlsVarZzb != zzls.GOOGLE_SIGNAL && zzlsVarZzb != zzls.GOOGLE_SIGNAL_PENDING && i2 > 0) {
                ArrayList arrayList = new ArrayList();
                Iterator it = zzhzVar.zza().iterator();
                while (it.hasNext()) {
                    com.google.android.gms.internal.measurement.zzic zzicVar = (com.google.android.gms.internal.measurement.zzic) ((com.google.android.gms.internal.measurement.zzid) it.next()).zzco();
                    zzicVar.zzao(i2);
                    arrayList.add((com.google.android.gms.internal.measurement.zzid) zzicVar.zzbd());
                }
                zzhzVar.zzg();
                zzhzVar.zzf(arrayList);
            }
            HashMap map = new HashMap();
            if (str3 != null) {
                String[] strArrSplit = str3.split("\r\n");
                int length = strArrSplit.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    String str4 = strArrSplit[i3];
                    if (str4.isEmpty()) {
                        break;
                    }
                    String[] strArrSplit2 = str4.split("=", 2);
                    if (strArrSplit2.length != 2) {
                        this.zzu.zzaW().zzb().zzb("Invalid upload header: ", str4);
                        break;
                    }
                    map.put(strArrSplit2[0], strArrSplit2[1]);
                    i3++;
                }
            }
            zzpi zzpiVar = new zzpi();
            zzpiVar.zzb(j);
            zzpiVar.zzc((com.google.android.gms.internal.measurement.zzib) zzhzVar.zzbd());
            zzpiVar.zzd(str2);
            zzpiVar.zze(map);
            zzpiVar.zzf(zzlsVarZzb);
            zzpiVar.zzg(j2);
            zzpiVar.zzh(j3);
            zzpiVar.zzi(j4);
            zzpiVar.zzj(i2);
            return zzpiVar.zza();
        } catch (IOException e) {
            this.zzu.zzaW().zzb().zzc("Failed to queued MeasurementBatch from upload_queue. appId", str, e);
            return null;
        }
    }

    private final String zzaI() {
        zzic zzicVar = this.zzu;
        long jCurrentTimeMillis = zzicVar.zzba().currentTimeMillis();
        Locale locale = Locale.US;
        zzls zzlsVar = zzls.GOOGLE_SIGNAL;
        Integer numValueOf = Integer.valueOf(zzlsVar.zza());
        Long lValueOf = Long.valueOf(jCurrentTimeMillis);
        zzicVar.zzc();
        String str = String.format(locale, "(upload_type = %d AND ABS(creation_timestamp - %d) > %d)", numValueOf, lValueOf, Long.valueOf(((Long) zzfy.zzS.zzb(null)).longValue()));
        Locale locale2 = Locale.US;
        Integer numValueOf2 = Integer.valueOf(zzlsVar.zza());
        zzicVar.zzc();
        String str2 = String.format(locale2, "(upload_type != %d AND ABS(creation_timestamp - %d) > %d)", numValueOf2, lValueOf, Long.valueOf(zzal.zzI()));
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 5 + String.valueOf(str2).length() + 1);
        sb.append("(");
        sb.append(str);
        sb.append(" OR ");
        sb.append(str2);
        sb.append(")");
        return sb.toString();
    }

    private static final String zzaJ(List list) {
        return list.isEmpty() ? "" : String.format(" AND (upload_type IN (%s))", TextUtils.join(", ", list));
    }

    static final void zzaw(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty("value");
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put("value", (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put("value", (Long) obj);
        } else {
            if (!(obj instanceof Double)) {
                throw new IllegalArgumentException("Invalid value type");
            }
            contentValues.put("value", (Double) obj);
        }
    }

    public final long zzA(String str, com.google.android.gms.internal.measurement.zzib zzibVar, String str2, Map map, zzls zzlsVar, Long l) {
        int iDelete;
        zzg();
        zzay();
        Preconditions.checkNotNull(zzibVar);
        Preconditions.checkNotEmpty(str);
        zzg();
        zzay();
        if (zzai()) {
            zzpg zzpgVar = this.zzg;
            long jZza = zzpgVar.zzq().zzb.zza();
            zzic zzicVar = this.zzu;
            long jElapsedRealtime = zzicVar.zzba().elapsedRealtime();
            long jAbs = Math.abs(jElapsedRealtime - jZza);
            zzicVar.zzc();
            if (jAbs > zzal.zzJ()) {
                zzpgVar.zzq().zzb.zzb(jElapsedRealtime);
                zzg();
                zzay();
                if (zzai() && (iDelete = zze().delete("upload_queue", zzaI(), new String[0])) > 0) {
                    zzicVar.zzaW().zzk().zzb("Deleted stale MeasurementBatch rows from upload_queue. rowsDeleted", Integer.valueOf(iDelete));
                }
                Preconditions.checkNotEmpty(str);
                zzg();
                zzay();
                try {
                    int iZzm = zzicVar.zzc().zzm(str, zzfy.zzz);
                    if (iZzm > 0) {
                        zze().delete("upload_queue", "rowid in (SELECT rowid FROM upload_queue WHERE app_id=? ORDER BY rowid DESC LIMIT -1 OFFSET ?)", new String[]{str, String.valueOf(iZzm)});
                    }
                } catch (SQLiteException e) {
                    this.zzu.zzaW().zzb().zzc("Error deleting over the limit queued batches. appId", zzgu.zzl(str), e);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            String str3 = (String) entry.getKey();
            String str4 = (String) entry.getValue();
            StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 1 + String.valueOf(str4).length());
            sb.append(str3);
            sb.append("=");
            sb.append(str4);
            arrayList.add(sb.toString());
        }
        byte[] bArrZzcd = zzibVar.zzcd();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("measurement_batch", bArrZzcd);
        contentValues.put("upload_uri", str2);
        contentValues.put("upload_headers", TextUtils.join("\r\n", arrayList));
        contentValues.put("upload_type", Integer.valueOf(zzlsVar.zza()));
        zzic zzicVar2 = this.zzu;
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzicVar2.zzba().currentTimeMillis()));
        contentValues.put("retry_count", (Integer) 0);
        if (l != null) {
            contentValues.put("associated_row_id", l);
        }
        try {
            long jInsert = zze().insert("upload_queue", null, contentValues);
            if (jInsert != -1) {
                return jInsert;
            }
            zzicVar2.zzaW().zzb().zzb("Failed to insert MeasurementBatch (got -1) to upload_queue. appId", str);
            return -1L;
        } catch (SQLiteException e2) {
            this.zzu.zzaW().zzb().zzc("Error storing MeasurementBatch to upload_queue. appId", str, e2);
            return -1L;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00da  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzpj zzB(long j) throws Throwable {
        zzpj zzpjVar;
        ?? r1;
        ?? Query;
        ?? r2;
        zzg();
        zzay();
        try {
            zzpjVar = null;
        } catch (SQLiteException e) {
            e = e;
            zzpjVar = null;
        } catch (Throwable th) {
            th = th;
            zzpjVar = null;
        }
        try {
            Query = zze().query("upload_queue", new String[]{"rowId", "app_id", "measurement_batch", "upload_uri", "upload_headers", "upload_type", "retry_count", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "associated_row_id", "last_upload_timestamp"}, "rowId=?", new String[]{String.valueOf(j)}, null, null, null, "1");
            try {
                try {
                    if (Query.moveToFirst()) {
                        zzpj zzpjVarZzaH = zzaH((String) Preconditions.checkNotNull(Query.getString(1)), j, Query.getBlob(2), Query.getString(3), Query.getString(4), Query.getInt(5), Query.getInt(6), Query.getLong(7), Query.getLong(8), Query.getLong(9));
                        if (Query != 0) {
                            Query.close();
                        }
                        return zzpjVarZzaH;
                    }
                    r2 = Query;
                } catch (SQLiteException e2) {
                    e = e2;
                    this.zzu.zzaW().zzb().zzc("Error to querying MeasurementBatch from upload_queue. rowId", Long.valueOf(j), e);
                    r2 = Query;
                }
            } catch (Throwable th2) {
                th = th2;
                r1 = Query;
                if (r1 != 0) {
                    r1.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            Query = zzpjVar;
            this.zzu.zzaW().zzb().zzc("Error to querying MeasurementBatch from upload_queue. rowId", Long.valueOf(j), e);
            r2 = Query;
            if (r2 != 0) {
            }
            return zzpjVar;
        } catch (Throwable th3) {
            th = th3;
            r1 = zzpjVar;
            if (r1 != 0) {
            }
            throw th;
        }
        if (r2 != 0) {
            r2.close();
        }
        return zzpjVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0148  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List zzC(String str, zzoo zzooVar, int i) {
        Cursor cursor;
        String str2;
        Cursor cursor2;
        List listEmptyList;
        Cursor cursorQuery;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        Preconditions.checkNotEmpty(str);
        zzg();
        zzay();
        try {
            try {
                SQLiteDatabase sQLiteDatabaseZze = zze();
                i2 = 0;
                i3 = 2;
                i4 = 3;
                String[] strArr = {"rowId", "app_id", "measurement_batch", "upload_uri", "upload_headers", "upload_type", "retry_count", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "associated_row_id", "last_upload_timestamp"};
                String strZzaJ = zzaJ(zzooVar.zza);
                String strZzaI = zzaI();
                StringBuilder sb = new StringBuilder(String.valueOf(strZzaJ).length() + 17 + strZzaI.length());
                sb.append("app_id=?");
                sb.append(strZzaJ);
                sb.append(" AND NOT ");
                sb.append(strZzaI);
                i5 = 7;
                i6 = 8;
                i7 = 6;
                i8 = 5;
                cursorQuery = sQLiteDatabaseZze.query("upload_queue", strArr, sb.toString(), new String[]{str}, null, null, "creation_timestamp ASC", i > 0 ? String.valueOf(i) : null);
            } catch (Throwable th) {
                th = th;
            }
            try {
                listEmptyList = new ArrayList();
                while (cursorQuery.moveToNext()) {
                    long j = cursorQuery.getLong(i2);
                    byte[] blob = cursorQuery.getBlob(i3);
                    String string = cursorQuery.getString(i4);
                    String string2 = cursorQuery.getString(4);
                    int i9 = cursorQuery.getInt(i8);
                    int i10 = cursorQuery.getInt(i7);
                    long j2 = cursorQuery.getLong(i5);
                    int i11 = i2;
                    int i12 = i3;
                    long j3 = cursorQuery.getLong(i6);
                    int i13 = i4;
                    int i14 = i8;
                    int i15 = i5;
                    cursor2 = cursorQuery;
                    int i16 = i7;
                    str2 = str;
                    List list = listEmptyList;
                    try {
                        zzpj zzpjVarZzaH = zzaH(str2, j, blob, string, string2, i9, i10, j2, j3, cursorQuery.getLong(9));
                        if (zzpjVarZzaH != null) {
                            list.add(zzpjVarZzaH);
                        }
                        listEmptyList = list;
                        cursorQuery = cursor2;
                        i5 = i15;
                        i7 = i16;
                        i8 = i14;
                        i4 = i13;
                        i3 = i12;
                        i2 = i11;
                        i6 = 8;
                    } catch (SQLiteException e) {
                        e = e;
                        this.zzu.zzaW().zzb().zzc("Error to querying MeasurementBatch from upload_queue. appId", str2, e);
                        listEmptyList = Collections.emptyList();
                        cursorQuery = cursor2;
                        if (cursorQuery != null) {
                        }
                        return listEmptyList;
                    }
                }
            } catch (SQLiteException e2) {
                e = e2;
                str2 = str;
                cursor2 = cursorQuery;
            } catch (Throwable th2) {
                th = th2;
                Cursor cursor3 = cursorQuery;
                cursor = cursor3;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            str2 = str;
            cursor2 = null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            if (cursor != null) {
            }
            throw th;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return listEmptyList;
    }

    public final boolean zzD(String str) {
        zzls[] zzlsVarArr = {zzls.GOOGLE_SIGNAL};
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Integer.valueOf(zzlsVarArr[0].zza()));
        String strZzaJ = zzaJ(arrayList);
        String strZzaI = zzaI();
        StringBuilder sb = new StringBuilder(String.valueOf(strZzaJ).length() + 61 + strZzaI.length());
        sb.append("SELECT COUNT(1) > 0 FROM upload_queue WHERE app_id=?");
        sb.append(strZzaJ);
        sb.append(" AND NOT ");
        sb.append(strZzaI);
        return zzaA(sb.toString(), new String[]{str}) != 0;
    }

    public final void zzE(Long l) {
        zzg();
        zzay();
        Preconditions.checkNotNull(l);
        try {
            if (zze().delete("upload_queue", "rowid=?", new String[]{l.toString()}) != 1) {
                this.zzu.zzaW().zze().zza("Deleted fewer rows from upload_queue than expected");
            }
        } catch (SQLiteException e) {
            this.zzu.zzaW().zzb().zzb("Failed to delete a MeasurementBatch in a upload_queue table", e);
            throw e;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003c  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String zzF() throws Throwable {
        SQLiteException e;
        Cursor cursorRawQuery;
        SQLiteDatabase sQLiteDatabaseZze = zze();
        ?? r1 = 0;
        try {
            try {
                cursorRawQuery = sQLiteDatabaseZze.rawQuery("select app_id from queue order by has_realtime desc, rowid asc limit 1;", null);
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        String string = cursorRawQuery.getString(0);
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        return string;
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    this.zzu.zzaW().zzb().zzb("Database error getting next bundle app id", e);
                }
            } catch (Throwable th) {
                th = th;
                r1 = sQLiteDatabaseZze;
                if (r1 != 0) {
                    r1.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursorRawQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (r1 != 0) {
            }
            throw th;
        }
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        return null;
    }

    public final boolean zzG() {
        return zzaA("select count(1) > 0 from queue where has_realtime = 1", null) != 0;
    }

    public final void zzH(long j) {
        zzg();
        zzay();
        try {
            if (zze().delete("queue", "rowid=?", new String[]{String.valueOf(j)}) == 1) {
            } else {
                throw new SQLiteException("Deleted fewer rows from queue than expected");
            }
        } catch (SQLiteException e) {
            this.zzu.zzaW().zzb().zzb("Failed to delete a bundle in a queue table", e);
            throw e;
        }
    }

    final void zzI() {
        zzg();
        zzay();
        if (zzai()) {
            zzpg zzpgVar = this.zzg;
            long jZza = zzpgVar.zzq().zza.zza();
            zzic zzicVar = this.zzu;
            long jElapsedRealtime = zzicVar.zzba().elapsedRealtime();
            long jAbs = Math.abs(jElapsedRealtime - jZza);
            zzicVar.zzc();
            if (jAbs > zzal.zzJ()) {
                zzpgVar.zzq().zza.zzb(jElapsedRealtime);
                zzg();
                zzay();
                if (zzai()) {
                    SQLiteDatabase sQLiteDatabaseZze = zze();
                    zzicVar.zzc();
                    int iDelete = sQLiteDatabaseZze.delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzicVar.zzba().currentTimeMillis()), String.valueOf(zzal.zzI())});
                    if (iDelete > 0) {
                        zzicVar.zzaW().zzk().zzb("Deleted stale rows. rowsDeleted", Integer.valueOf(iDelete));
                    }
                }
            }
        }
    }

    final void zzJ(List list) {
        zzg();
        zzay();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzai()) {
            String strJoin = TextUtils.join(",", list);
            StringBuilder sb = new StringBuilder(String.valueOf(strJoin).length() + 2);
            sb.append("(");
            sb.append(strJoin);
            sb.append(")");
            String string = sb.toString();
            StringBuilder sb2 = new StringBuilder(string.length() + 80);
            sb2.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
            sb2.append(string);
            sb2.append(" AND retry_count =  2147483647 LIMIT 1");
            if (zzaA(sb2.toString(), null) > 0) {
                this.zzu.zzaW().zze().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase sQLiteDatabaseZze = zze();
                StringBuilder sb3 = new StringBuilder(string.length() + 127);
                sb3.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb3.append(string);
                sb3.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                sQLiteDatabaseZze.execSQL(sb3.toString());
            } catch (SQLiteException e) {
                this.zzu.zzaW().zzb().zzb("Error incrementing retry count. error", e);
            }
        }
    }

    final void zzK(Long l) {
        zzg();
        zzay();
        Preconditions.checkNotNull(l);
        if (zzai()) {
            StringBuilder sb = new StringBuilder(l.toString().length() + 86);
            sb.append("SELECT COUNT(1) FROM upload_queue WHERE rowid = ");
            sb.append(l);
            sb.append(" AND retry_count =  2147483647 LIMIT 1");
            if (zzaA(sb.toString(), null) > 0) {
                this.zzu.zzaW().zze().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase sQLiteDatabaseZze = zze();
                long jCurrentTimeMillis = this.zzu.zzba().currentTimeMillis();
                StringBuilder sb2 = new StringBuilder(String.valueOf(jCurrentTimeMillis).length() + 60);
                sb2.append(" SET retry_count = retry_count + 1, last_upload_timestamp = ");
                sb2.append(jCurrentTimeMillis);
                String string = sb2.toString();
                StringBuilder sb3 = new StringBuilder(string.length() + 34 + l.toString().length() + 29);
                sb3.append("UPDATE upload_queue");
                sb3.append(string);
                sb3.append(" WHERE rowid = ");
                sb3.append(l);
                sb3.append(" AND retry_count < 2147483647");
                sQLiteDatabaseZze.execSQL(sb3.toString());
            } catch (SQLiteException e) {
                this.zzu.zzaW().zzb().zzb("Error incrementing retry count. error", e);
            }
        }
    }

    final Object zzL(Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 0) {
            this.zzu.zzaW().zzb().zza("Loaded invalid null value from database");
            return null;
        }
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i));
        }
        if (type == 3) {
            return cursor.getString(i);
        }
        if (type != 4) {
            this.zzu.zzaW().zzb().zzb("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
            return null;
        }
        this.zzu.zzaW().zzb().zza("Loaded invalid blob type value, ignoring it");
        return null;
    }

    public final long zzM() {
        return zzaB("select max(bundle_end_timestamp) from queue", null, 0L);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x008f A[Catch: SQLiteException -> 0x00a8, all -> 0x00ab, TryCatch #0 {SQLiteException -> 0x00a8, blocks: (B:11:0x006e, B:13:0x008f, B:14:0x00a3), top: B:28:0x006e }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00a3 A[Catch: SQLiteException -> 0x00a8, all -> 0x00ab, TRY_LEAVE, TryCatch #0 {SQLiteException -> 0x00a8, blocks: (B:11:0x006e, B:13:0x008f, B:14:0x00a3), top: B:28:0x006e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final long zzN(String str, String str2) {
        long j;
        long jZzaB;
        ContentValues contentValues;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty("first_open_count");
        zzg();
        zzay();
        SQLiteDatabase sQLiteDatabaseZze = zze();
        sQLiteDatabaseZze.beginTransaction();
        long j2 = 0;
        try {
            try {
                StringBuilder sb = new StringBuilder(48);
                sb.append("select first_open_count from app2 where app_id=?");
                j = -1;
                jZzaB = zzaB(sb.toString(), new String[]{str}, -1L);
            } finally {
                sQLiteDatabaseZze.endTransaction();
            }
        } catch (SQLiteException e) {
            e = e;
        }
        if (jZzaB == -1) {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("app_id", str);
            contentValues2.put("first_open_count", (Integer) 0);
            contentValues2.put("previous_install_count", (Integer) 0);
            if (sQLiteDatabaseZze.insertWithOnConflict("app2", null, contentValues2, 5) == -1) {
                this.zzu.zzaW().zzb().zzc("Failed to insert column (got -1). appId", zzgu.zzl(str), "first_open_count");
            } else {
                jZzaB = 0;
                try {
                    contentValues = new ContentValues();
                    contentValues.put("app_id", str);
                    contentValues.put("first_open_count", Long.valueOf(1 + jZzaB));
                    if (sQLiteDatabaseZze.update("app2", contentValues, "app_id = ?", new String[]{str}) != 0) {
                        this.zzu.zzaW().zzb().zzc("Failed to update column (got 0). appId", zzgu.zzl(str), "first_open_count");
                    } else {
                        sQLiteDatabaseZze.setTransactionSuccessful();
                        j = jZzaB;
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    j2 = jZzaB;
                    this.zzu.zzaW().zzb().zzd("Error inserting column. appId", zzgu.zzl(str), "first_open_count", e);
                    j = j2;
                }
            }
            this.zzu.zzaW().zzb().zzd("Error inserting column. appId", zzgu.zzl(str), "first_open_count", e);
            j = j2;
        } else {
            contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("first_open_count", Long.valueOf(1 + jZzaB));
            if (sQLiteDatabaseZze.update("app2", contentValues, "app_id = ?", new String[]{str}) != 0) {
            }
        }
        return j;
    }

    public final long zzO() {
        return zzaB("select max(timestamp) from raw_events", null, 0L);
    }

    public final boolean zzP() {
        return zzaA("select count(1) > 0 from raw_events", null) != 0;
    }

    public final boolean zzQ(String str, String str2) {
        return zzaA("select count(1) from raw_events where app_id = ? and name = ?", new String[]{str, str2}) > 0;
    }

    public final boolean zzR() {
        return zzaA("select count(1) > 0 from raw_events where realtime = 1", null) != 0;
    }

    public final void zzS(List list) {
        Preconditions.checkNotNull(list);
        zzg();
        zzay();
        StringBuilder sb = new StringBuilder("rowid in (");
        for (int i = 0; i < list.size(); i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(((Long) list.get(i)).longValue());
        }
        sb.append(")");
        int iDelete = zze().delete("raw_events", sb.toString(), null);
        if (iDelete != list.size()) {
            this.zzu.zzaW().zzb().zzc("Deleted fewer rows from raw events table than expected", Integer.valueOf(iDelete), Integer.valueOf(list.size()));
        }
    }

    public final long zzT(String str) {
        Preconditions.checkNotEmpty(str);
        return zzaB("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    public final boolean zzU(String str, Long l, long j, com.google.android.gms.internal.measurement.zzhs zzhsVar) {
        zzg();
        zzay();
        Preconditions.checkNotNull(zzhsVar);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        zzic zzicVar = this.zzu;
        byte[] bArrZzcd = zzhsVar.zzcd();
        zzicVar.zzaW().zzk().zzc("Saving complex main event, appId, data size", zzicVar.zzl().zza(str), Integer.valueOf(bArrZzcd.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", bArrZzcd);
        try {
            if (zze().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            zzicVar.zzaW().zzb().zzb("Failed to insert complex main event (got -1). appId", zzgu.zzl(str));
            return false;
        } catch (SQLiteException e) {
            this.zzu.zzaW().zzb().zzc("Error storing complex main event. appId", zzgu.zzl(str), e);
            return false;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0085: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:27:0x0085 */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Bundle zzV(String str) throws Throwable {
        Cursor cursorRawQuery;
        Cursor cursor;
        zzg();
        zzay();
        Cursor cursor2 = null;
        try {
            try {
                cursorRawQuery = zze().rawQuery("select parameters from default_event_params where app_id=?", new String[]{str});
                try {
                    if (cursorRawQuery.moveToFirst()) {
                        try {
                            com.google.android.gms.internal.measurement.zzhs zzhsVar = (com.google.android.gms.internal.measurement.zzhs) ((com.google.android.gms.internal.measurement.zzhr) zzpk.zzw(com.google.android.gms.internal.measurement.zzhs.zzp(), cursorRawQuery.getBlob(0))).zzbd();
                            this.zzg.zzp();
                            Bundle bundleZzH = zzpk.zzH(zzhsVar.zza());
                            if (cursorRawQuery != null) {
                                cursorRawQuery.close();
                            }
                            return bundleZzH;
                        } catch (IOException e) {
                            this.zzu.zzaW().zzb().zzc("Failed to retrieve default event parameters. appId", zzgu.zzl(str), e);
                        }
                    } else {
                        this.zzu.zzaW().zzk().zza("Default event parameters not found");
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    this.zzu.zzaW().zzb().zzb("Error selecting default event parameters", e);
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursorRawQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        return null;
    }

    final boolean zzW(String str, long j) {
        try {
            if (zzaB("select count(*) from raw_events where app_id=? and timestamp >= ? and name not like '!_%' escape '!' limit 1;", new String[]{str, String.valueOf(j)}, 0L) > 0) {
                return false;
            }
            return zzaB("select count(*) from raw_events where app_id=? and timestamp >= ? and name like '!_%' escape '!' limit 1;", new String[]{str, String.valueOf(j)}, 0L) > 0;
        } catch (SQLiteException e) {
            this.zzu.zzaW().zzb().zzb("Error checking backfill conditions", e);
            return false;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(18:12|(7:14|102|15|110|16|(3:18|(1:20)|(3:49|(3:52|(1:IC)(1:120)|50)|116)(1:115))(10:21|104|22|106|23|(1:25)|26|(1:28)|47|(0)(0))|117)(1:114)|58|(4:61|(2:63|122)(2:65|(2:67|123)(2:68|(2:70|124)(2:71|(2:73|125)(2:74|(2:76|126)(2:77|127)))))|64|59)|121|78|(1:80)|81|(1:83)(3:85|(4:88|(2:90|129)(1:130)|91|86)|128)|84|92|108|93|(1:95)|99|119|117|10) */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x02ef, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x02f0, code lost:
    
        r25.zzu.zzaW().zzb().zzc("Error updating raw event. appId", com.google.android.gms.measurement.internal.zzgu.zzl(r2.zza), r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:115:0x012c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0104  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzX(String str, Long l, String str2, Bundle bundle) {
        Bundle bundle2;
        com.google.android.gms.internal.measurement.zzid zzidVar;
        Cursor cursorQuery;
        String str3 = str;
        Preconditions.checkNotNull(bundle);
        zzg();
        zzay();
        zzau zzauVar = l != null ? new zzau(this, str3, l.longValue()) : new zzau(this, str3);
        List listZza = zzauVar.zza();
        while (!listZza.isEmpty()) {
            Iterator it = listZza.iterator();
            while (it.hasNext()) {
                zzat zzatVar = (zzat) it.next();
                if (!TextUtils.isEmpty(str2)) {
                    Cursor cursor = null;
                    zzidVar = null;
                    zzidVar = null;
                    com.google.android.gms.internal.measurement.zzid zzidVar2 = null;
                    Cursor cursor2 = null;
                    try {
                        try {
                            cursorQuery = zze().query("raw_events_metadata", new String[]{"metadata"}, "app_id = ? and metadata_fingerprint = ?", new String[]{str3, Long.toString(zzatVar.zzb)}, null, null, "rowid", ExifInterface.GPS_MEASUREMENT_2D);
                        } catch (SQLiteException e) {
                            e = e;
                            zzidVar = null;
                        }
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        try {
                        } catch (SQLiteException e2) {
                            e = e2;
                            zzidVar = null;
                        }
                        if (cursorQuery.moveToFirst()) {
                            try {
                                zzidVar = (com.google.android.gms.internal.measurement.zzid) ((com.google.android.gms.internal.measurement.zzic) zzpk.zzw(com.google.android.gms.internal.measurement.zzid.zzaE(), cursorQuery.getBlob(0))).zzbd();
                                try {
                                    if (cursorQuery.moveToNext()) {
                                        this.zzu.zzaW().zze().zzb("Get multiple raw event metadata records, expected one. appId", zzgu.zzl(str3));
                                    }
                                    cursorQuery.close();
                                    if (cursorQuery != null) {
                                        cursorQuery.close();
                                    }
                                } catch (SQLiteException e3) {
                                    e = e3;
                                    cursor2 = cursorQuery;
                                    this.zzu.zzaW().zzb().zzc("Data loss. Error selecting raw event. appId", zzgu.zzl(str3), e);
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                }
                                zzidVar2 = zzidVar;
                            } catch (IOException e4) {
                                this.zzu.zzaW().zzb().zzc("Data loss. Failed to merge raw event metadata. appId", zzgu.zzl(str3), e4);
                                if (cursorQuery != null) {
                                }
                            }
                            if (zzidVar2 == null) {
                            }
                        } else {
                            this.zzu.zzaW().zzb().zzb("Raw event metadata record is missing. appId", zzgu.zzl(str3));
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            if (zzidVar2 == null) {
                                Iterator it2 = zzidVar2.zzf().iterator();
                                while (it2.hasNext()) {
                                    if (((com.google.android.gms.internal.measurement.zziu) it2.next()).zzc().equals(str2)) {
                                        break;
                                    }
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = cursorQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                zzpg zzpgVar = this.zzg;
                zzpk zzpkVarZzp = zzpgVar.zzp();
                com.google.android.gms.internal.measurement.zzhs zzhsVar = zzatVar.zzd;
                Bundle bundle3 = new Bundle();
                for (com.google.android.gms.internal.measurement.zzhw zzhwVar : zzhsVar.zza()) {
                    if (zzhwVar.zzj()) {
                        bundle3.putDouble(zzhwVar.zzb(), zzhwVar.zzk());
                    } else if (zzhwVar.zzh()) {
                        bundle3.putFloat(zzhwVar.zzb(), zzhwVar.zzi());
                    } else if (zzhwVar.zze()) {
                        bundle3.putLong(zzhwVar.zzb(), zzhwVar.zzf());
                    } else if (zzhwVar.zzc()) {
                        bundle3.putString(zzhwVar.zzb(), zzhwVar.zzd());
                    } else if (zzhwVar.zzl().isEmpty()) {
                        zzpkVarZzp.zzu.zzaW().zzb().zzb("Unexpected parameter type for parameter", zzhwVar);
                    } else {
                        bundle3.putParcelableArray(zzhwVar.zzb(), zzpk.zzy(zzhwVar.zzl()));
                    }
                }
                String string = bundle3.getString("_o");
                bundle3.remove("_o");
                String strZzd = zzhsVar.zzd();
                if (string == null) {
                    string = "";
                }
                zzgv zzgvVar = new zzgv(strZzd, string, bundle3, zzhsVar.zzf(), zzhsVar.zzo());
                zzic zzicVar = this.zzu;
                Bundle bundle4 = zzgvVar.zze;
                String str4 = zzgvVar.zza;
                zzpp zzppVarZzk = zzicVar.zzk();
                if (str4.equals(Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN)) {
                    bundle2 = new Bundle(bundle);
                    for (String str5 : bundle.keySet()) {
                        zzpg zzpgVar2 = zzpgVar;
                        if (str5.startsWith("gad_")) {
                            bundle2.remove(str5);
                        }
                        zzpgVar = zzpgVar2;
                    }
                } else {
                    bundle2 = bundle;
                }
                zzpg zzpgVar3 = zzpgVar;
                zzppVarZzk.zzK(bundle4, bundle2);
                zzau zzauVar2 = zzauVar;
                Iterator it3 = it;
                zzbc zzbcVar = new zzbc(this.zzu, zzgvVar.zzb, str3, zzhsVar.zzd(), zzhsVar.zzf(), zzhsVar.zzo(), zzhsVar.zzi(), bundle4);
                long j = zzatVar.zza;
                long j2 = zzatVar.zzb;
                boolean z = zzatVar.zzc;
                zzg();
                zzay();
                Preconditions.checkNotNull(zzbcVar);
                String str6 = zzbcVar.zza;
                Preconditions.checkNotEmpty(str6);
                byte[] bArrZzcd = zzpgVar3.zzp().zzh(zzbcVar).zzcd();
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str6);
                contentValues.put("name", zzbcVar.zzb);
                contentValues.put(DiagnosticsEntry.TIMESTAMP_KEY, Long.valueOf(zzbcVar.zzd));
                contentValues.put("metadata_fingerprint", Long.valueOf(j2));
                contentValues.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, bArrZzcd);
                contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
                contentValues.put("elapsed_time", Long.valueOf(zzbcVar.zze));
                long jUpdate = zze().update("raw_events", contentValues, "rowid = ?", new String[]{String.valueOf(j)});
                if (jUpdate != 1) {
                    zzicVar.zzaW().zzb().zzc("Failed to update raw event. appId, updatedRows", zzgu.zzl(str6), Long.valueOf(jUpdate));
                }
                str3 = str;
                zzauVar = zzauVar2;
                it = it3;
            }
            listZza = zzauVar.zza();
            str3 = str;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0057, code lost:
    
        if (r6 != 0) goto L20;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0069  */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.google.android.gms.measurement.internal.zzaw, com.google.android.gms.measurement.internal.zzje, com.google.android.gms.measurement.internal.zzos] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v4, types: [com.google.android.gms.measurement.internal.zzje] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v10, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9, types: [android.database.Cursor] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0057 -> B:20:0x0059). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzjl zzY(String str) {
        SQLiteException e;
        ?? r6;
        ?? r5;
        Preconditions.checkNotNull(str);
        zzg();
        zzay();
        String[] strArr = {str};
        ?? RawQuery = "select consent_state, consent_source from consent_settings where app_id=? limit 1;";
        ?? r3 = 0;
        zzjlVarZzf = null;
        zzjlVarZzf = null;
        zzjlVarZzf = null;
        zzjl zzjlVarZzf = null;
        try {
            try {
                RawQuery = zze().rawQuery("select consent_state, consent_source from consent_settings where app_id=? limit 1;", strArr);
                try {
                } catch (SQLiteException e2) {
                    e = e2;
                    zzgs zzgsVarZzb = this.zzu.zzaW().zzb();
                    zzgsVarZzb.zzb("Error querying database.", e);
                    r5 = zzgsVarZzb;
                    r6 = RawQuery;
                }
            } catch (Throwable th) {
                th = th;
                r3 = RawQuery;
                if (r3 != 0) {
                    r3.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            RawQuery = 0;
            zzgs zzgsVarZzb2 = this.zzu.zzaW().zzb();
            zzgsVarZzb2.zzb("Error querying database.", e);
            r5 = zzgsVarZzb2;
            r6 = RawQuery;
        } catch (Throwable th2) {
            th = th2;
            if (r3 != 0) {
            }
            throw th;
        }
        if (RawQuery.moveToFirst()) {
            zzjlVarZzf = zzjl.zzf(RawQuery.getString(0), RawQuery.getInt(1));
            this = this;
            r6 = RawQuery;
            this = this;
            RawQuery = RawQuery;
            if (RawQuery != 0) {
                r6.close();
                this = r5;
                RawQuery = r6;
            }
        } else {
            this.zzu.zzaW().zzk().zza("No data found");
            this = this;
            RawQuery = RawQuery;
            if (RawQuery != 0) {
                this = this;
                r6 = RawQuery;
                r6.close();
                this = r5;
                RawQuery = r6;
            }
        }
        return zzjlVarZzf == null ? zzjl.zza : zzjlVarZzf;
    }

    public final boolean zzZ(String str, zzoh zzohVar) {
        zzg();
        zzay();
        Preconditions.checkNotNull(zzohVar);
        Preconditions.checkNotEmpty(str);
        zzic zzicVar = this.zzu;
        long jCurrentTimeMillis = zzicVar.zzba().currentTimeMillis();
        zzfx zzfxVar = zzfy.zzau;
        long jLongValue = jCurrentTimeMillis - ((Long) zzfxVar.zzb(null)).longValue();
        long j = zzohVar.zzb;
        if (j < jLongValue || j > ((Long) zzfxVar.zzb(null)).longValue() + jCurrentTimeMillis) {
            zzicVar.zzaW().zze().zzd("Storing trigger URI outside of the max retention time span. appId, now, timestamp", zzgu.zzl(str), Long.valueOf(jCurrentTimeMillis), Long.valueOf(j));
        }
        zzicVar.zzaW().zzk().zza("Saving trigger URI");
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("trigger_uri", zzohVar.zza);
        contentValues.put("source", Integer.valueOf(zzohVar.zzc));
        contentValues.put("timestamp_millis", Long.valueOf(j));
        try {
            if (zze().insert("trigger_uris", null, contentValues) != -1) {
                return true;
            }
            zzicVar.zzaW().zzb().zzb("Failed to insert trigger URI (got -1). appId", zzgu.zzl(str));
            return false;
        } catch (SQLiteException e) {
            this.zzu.zzaW().zzb().zzc("Error storing trigger URI. appId", zzgu.zzl(str), e);
            return false;
        }
    }

    public final void zzaa(String str, zzjl zzjlVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzjlVar);
        zzg();
        zzay();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", zzjlVar.zzl());
        contentValues.put("consent_source", Integer.valueOf(zzjlVar.zzb()));
        zzaD("consent_settings", "app_id", contentValues);
    }

    public final zzba zzab(String str) {
        Preconditions.checkNotNull(str);
        zzg();
        zzay();
        return zzba.zzg(zzaC("select dma_consent_settings from consent_settings where app_id=? limit 1;", new String[]{str}, ""));
    }

    public final List zzac(String str) {
        zzg();
        zzay();
        List arrayList = new ArrayList();
        try {
            SQLiteDatabase sQLiteDatabaseZze = zze();
            sQLiteDatabaseZze.beginTransaction();
            Cursor cursorQuery = null;
            try {
                try {
                    cursorQuery = sQLiteDatabaseZze.query("diagnostic_signals", new String[]{"signal_name", "metadata", "count"}, "app_id=?", new String[]{str}, null, null, "rowid", null);
                    if (cursorQuery.moveToFirst()) {
                        boolean zIsEmpty = str.isEmpty();
                        do {
                            String string = cursorQuery.getString(0);
                            String str2 = cursorQuery.isNull(1) ? "" : (String) Preconditions.checkNotNull(cursorQuery.getString(1));
                            if (string == null) {
                                this.zzu.zzaW().zzb().zzb("Read null value from diagnostic signals table, ignoring it. appId", zzgu.zzl(str));
                            } else {
                                long j = cursorQuery.getLong(2);
                                com.google.android.gms.internal.measurement.zzfa zzfaVarZza = com.google.android.gms.internal.measurement.zzfb.zza();
                                zzfaVarZza.zza(string);
                                zzfaVarZza.zzd(j);
                                zzfaVarZza.zzc(str2);
                                if (zIsEmpty) {
                                    zzfaVarZza.zzb(true);
                                }
                                arrayList.add((com.google.android.gms.internal.measurement.zzfb) zzfaVarZza.zzbd());
                            }
                        } while (cursorQuery.moveToNext());
                        sQLiteDatabaseZze.delete("diagnostic_signals", "app_id=?", new String[]{str});
                        sQLiteDatabaseZze.setTransactionSuccessful();
                    } else {
                        sQLiteDatabaseZze.setTransactionSuccessful();
                    }
                } catch (SQLiteException e) {
                    this.zzu.zzaW().zzb().zzc("Error querying or deleting diagnostic signals. appId", zzgu.zzl(str), e);
                    arrayList = Collections.emptyList();
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                sQLiteDatabaseZze.endTransaction();
                return arrayList;
            } catch (Throwable th) {
                if (0 != 0) {
                    cursorQuery.close();
                }
                sQLiteDatabaseZze.endTransaction();
                throw th;
            }
        } catch (SQLiteException e2) {
            this.zzu.zzaW().zzb().zzc("Error opening database for diagnostic signals. appId", zzgu.zzl(str), e2);
            return Collections.emptyList();
        }
    }

    public final void zzad(String str, zzba zzbaVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzbaVar);
        zzg();
        zzay();
        zzjl zzjlVarZzY = zzY(str);
        zzjl zzjlVar = zzjl.zza;
        if (zzjlVarZzY == zzjlVar) {
            zzaa(str, zzjlVar);
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("dma_consent_settings", zzbaVar.zze());
        zzaD("consent_settings", "app_id", contentValues);
    }

    public final void zzae(String str, zzjl zzjlVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzjlVar);
        zzg();
        zzay();
        zzaa(str, zzY(str));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("storage_consent_at_bundling", zzjlVar.zzl());
        zzaD("consent_settings", "app_id", contentValues);
    }

    public final zzjl zzaf(String str) {
        Preconditions.checkNotNull(str);
        zzg();
        zzay();
        return zzjl.zzf(zzaC("select storage_consent_at_bundling from consent_settings where app_id=? limit 1;", new String[]{str}, ""), 100);
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x0345, code lost:
    
        if (zze().insertWithOnConflict("property_filters", null, r13, 5) != (-1)) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0347, code lost:
    
        r25.zzu.zzaW().zzb().zzb("Failed to insert property filter (got -1). appId", com.google.android.gms.measurement.internal.zzgu.zzl(r26));
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x035b, code lost:
    
        r0 = r22;
        r3 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0361, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0362, code lost:
    
        r25.zzu.zzaW().zzb().zzc("Error storing property filter. appId", com.google.android.gms.measurement.internal.zzgu.zzl(r26), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0375, code lost:
    
        zzay();
        zzg();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r26);
        r0 = zze();
        r0.delete("property_filters", "app_id=? and audience_id=?", new java.lang.String[]{r26, java.lang.String.valueOf(r11)});
        r0.delete("event_filters", "app_id=? and audience_id=?", new java.lang.String[]{r26, java.lang.String.valueOf(r11)});
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x039f, code lost:
    
        r7 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x049e, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x04a3, code lost:
    
        r23.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x04a6, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0174, code lost:
    
        r12 = r0.zzc().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0180, code lost:
    
        if (r12.hasNext() == false) goto L166;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x018c, code lost:
    
        if (((com.google.android.gms.internal.measurement.zzfn) r12.next()).zza() != false) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x018e, code lost:
    
        r25.zzu.zzaW().zze().zzc("Property filter with no ID. Audience definition ignored. appId, audienceId", com.google.android.gms.measurement.internal.zzgu.zzl(r26), java.lang.Integer.valueOf(r11));
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x01a7, code lost:
    
        r12 = r0.zzf().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01b3, code lost:
    
        r22 = r0;
        r0 = "app_id";
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x01c1, code lost:
    
        if (r12.hasNext() == false) goto L175;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x01c3, code lost:
    
        r13 = (com.google.android.gms.internal.measurement.zzff) r12.next();
        zzay();
        zzg();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r26);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x01dd, code lost:
    
        if (r13.zzc().isEmpty() == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01df, code lost:
    
        r0 = r25.zzu.zzaW().zze();
        r10 = com.google.android.gms.measurement.internal.zzgu.zzl(r26);
        r12 = java.lang.Integer.valueOf(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01f7, code lost:
    
        if (r13.zza() == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01f9, code lost:
    
        r13 = java.lang.Integer.valueOf(r13.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0202, code lost:
    
        r13 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0203, code lost:
    
        r0.zzd("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", r10, r12, java.lang.String.valueOf(r13));
        r23 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x020e, code lost:
    
        r3 = r13.zzcd();
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0212, code lost:
    
        r23 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0214, code lost:
    
        r7 = new android.content.ContentValues();
        r7.put("app_id", r26);
        r7.put("audience_id", java.lang.Integer.valueOf(r11));
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0227, code lost:
    
        if (r13.zza() == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0229, code lost:
    
        r0 = java.lang.Integer.valueOf(r13.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0232, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0233, code lost:
    
        r7.put("filter_id", r0);
        r7.put("event_name", r13.zzc());
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0243, code lost:
    
        if (r13.zzl() == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0245, code lost:
    
        r0 = java.lang.Boolean.valueOf(r13.zzm());
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x024e, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x024f, code lost:
    
        r7.put("session_scoped", r0);
        r7.put(com.google.firebase.messaging.Constants.ScionAnalytics.MessageType.DATA_MESSAGE, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0261, code lost:
    
        if (zze().insertWithOnConflict("event_filters", null, r7, 5) != (-1)) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0263, code lost:
    
        r25.zzu.zzaW().zzb().zzb("Failed to insert event filter (got -1). appId", com.google.android.gms.measurement.internal.zzgu.zzl(r26));
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0276, code lost:
    
        r0 = r22;
        r7 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x027e, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x027f, code lost:
    
        r25.zzu.zzaW().zzb().zzc("Error storing event filter. appId", com.google.android.gms.measurement.internal.zzgu.zzl(r26), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0294, code lost:
    
        r23 = r7;
        r3 = r22.zzc().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x02a2, code lost:
    
        if (r3.hasNext() == false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x02a4, code lost:
    
        r7 = (com.google.android.gms.internal.measurement.zzfn) r3.next();
        zzay();
        zzg();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r26);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x02be, code lost:
    
        if (r7.zzc().isEmpty() == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x02c0, code lost:
    
        r0 = r25.zzu.zzaW().zze();
        r9 = com.google.android.gms.measurement.internal.zzgu.zzl(r26);
        r10 = java.lang.Integer.valueOf(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x02d8, code lost:
    
        if (r7.zza() == false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x02da, code lost:
    
        r21 = java.lang.Integer.valueOf(r7.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x02e5, code lost:
    
        r21 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x02e7, code lost:
    
        r0.zzd("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", r9, r10, java.lang.String.valueOf(r21));
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x02f0, code lost:
    
        r12 = r7.zzcd();
        r13 = new android.content.ContentValues();
        r13.put(r0, r26);
        r22 = r0;
        r13.put("audience_id", java.lang.Integer.valueOf(r11));
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0309, code lost:
    
        if (r7.zza() == false) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x030b, code lost:
    
        r0 = java.lang.Integer.valueOf(r7.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0314, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0315, code lost:
    
        r13.put("filter_id", r0);
        r24 = r3;
        r13.put("property_name", r7.zzc());
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0327, code lost:
    
        if (r7.zzh() == false) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0329, code lost:
    
        r0 = java.lang.Boolean.valueOf(r7.zzi());
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0332, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0333, code lost:
    
        r13.put("session_scoped", r0);
        r13.put(com.google.firebase.messaging.Constants.ScionAnalytics.MessageType.DATA_MESSAGE, r12);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void zzag(String str, List list) throws Throwable {
        SQLiteDatabase sQLiteDatabase;
        boolean z;
        Preconditions.checkNotNull(list);
        for (int i = 0; i < list.size(); i++) {
            com.google.android.gms.internal.measurement.zzfc zzfcVar = (com.google.android.gms.internal.measurement.zzfc) ((com.google.android.gms.internal.measurement.zzfd) list.get(i)).zzco();
            if (zzfcVar.zzd() != 0) {
                for (int i2 = 0; i2 < zzfcVar.zzd(); i2++) {
                    com.google.android.gms.internal.measurement.zzfe zzfeVar = (com.google.android.gms.internal.measurement.zzfe) zzfcVar.zze(i2).zzco();
                    com.google.android.gms.internal.measurement.zzfe zzfeVar2 = (com.google.android.gms.internal.measurement.zzfe) zzfeVar.clone();
                    String strZzb = zzjm.zzb(zzfeVar.zza());
                    if (strZzb != null) {
                        zzfeVar2.zzb(strZzb);
                        z = true;
                    } else {
                        z = false;
                    }
                    int i3 = 0;
                    while (i3 < zzfeVar.zzc()) {
                        com.google.android.gms.internal.measurement.zzfh zzfhVarZzd = zzfeVar.zzd(i3);
                        com.google.android.gms.internal.measurement.zzfe zzfeVar3 = zzfeVar;
                        String strZzc = zzlt.zzc(zzfhVarZzd.zzi(), zzjn.zza, zzjn.zzb);
                        if (strZzc != null) {
                            com.google.android.gms.internal.measurement.zzfg zzfgVar = (com.google.android.gms.internal.measurement.zzfg) zzfhVarZzd.zzco();
                            zzfgVar.zza(strZzc);
                            zzfeVar2.zze(i3, (com.google.android.gms.internal.measurement.zzfh) zzfgVar.zzbd());
                            z = true;
                        }
                        i3++;
                        zzfeVar = zzfeVar3;
                    }
                    if (z) {
                        zzfcVar.zzf(i2, zzfeVar2);
                        list.set(i, (com.google.android.gms.internal.measurement.zzfd) zzfcVar.zzbd());
                    }
                }
            }
            if (zzfcVar.zza() != 0) {
                for (int i4 = 0; i4 < zzfcVar.zza(); i4++) {
                    com.google.android.gms.internal.measurement.zzfn zzfnVarZzb = zzfcVar.zzb(i4);
                    String strZzc2 = zzlt.zzc(zzfnVarZzb.zzc(), zzjo.zza, zzjo.zzb);
                    if (strZzc2 != null) {
                        com.google.android.gms.internal.measurement.zzfm zzfmVar = (com.google.android.gms.internal.measurement.zzfm) zzfnVarZzb.zzco();
                        zzfmVar.zza(strZzc2);
                        zzfcVar.zzc(i4, zzfmVar);
                        list.set(i, (com.google.android.gms.internal.measurement.zzfd) zzfcVar.zzbd());
                    }
                }
            }
        }
        zzay();
        zzg();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        SQLiteDatabase sQLiteDatabaseZze = zze();
        sQLiteDatabaseZze.beginTransaction();
        try {
            zzay();
            zzg();
            Preconditions.checkNotEmpty(str);
            SQLiteDatabase sQLiteDatabaseZze2 = zze();
            sQLiteDatabaseZze2.delete("property_filters", "app_id=?", new String[]{str});
            sQLiteDatabaseZze2.delete("event_filters", "app_id=?", new String[]{str});
            Iterator it = list.iterator();
            while (it.hasNext()) {
                com.google.android.gms.internal.measurement.zzfd zzfdVar = (com.google.android.gms.internal.measurement.zzfd) it.next();
                zzay();
                zzg();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(zzfdVar);
                if (zzfdVar.zza()) {
                    int iZzb = zzfdVar.zzb();
                    Iterator it2 = zzfdVar.zzf().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (!((com.google.android.gms.internal.measurement.zzff) it2.next()).zza()) {
                                this.zzu.zzaW().zze().zzc("Event filter with no ID. Audience definition ignored. appId, audienceId", zzgu.zzl(str), Integer.valueOf(iZzb));
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                } else {
                    this.zzu.zzaW().zze().zzb("Audience with no ID. appId", zzgu.zzl(str));
                }
            }
            sQLiteDatabase = sQLiteDatabaseZze;
            ArrayList arrayList = new ArrayList();
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                com.google.android.gms.internal.measurement.zzfd zzfdVar2 = (com.google.android.gms.internal.measurement.zzfd) it3.next();
                arrayList.add(zzfdVar2.zza() ? Integer.valueOf(zzfdVar2.zzb()) : null);
            }
            Preconditions.checkNotEmpty(str);
            zzay();
            zzg();
            SQLiteDatabase sQLiteDatabaseZze3 = zze();
            try {
                long jZzaA = zzaA("select count(1) from audience_filter_values where app_id=?", new String[]{str});
                int iMax = Math.max(0, Math.min(2000, this.zzu.zzc().zzm(str, zzfy.zzU)));
                if (jZzaA > iMax) {
                    ArrayList arrayList2 = new ArrayList();
                    int i5 = 0;
                    while (true) {
                        if (i5 >= arrayList.size()) {
                            String strJoin = TextUtils.join(",", arrayList2);
                            StringBuilder sb = new StringBuilder(String.valueOf(strJoin).length() + 2);
                            sb.append("(");
                            sb.append(strJoin);
                            sb.append(")");
                            String string = sb.toString();
                            StringBuilder sb2 = new StringBuilder(string.length() + 140);
                            sb2.append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
                            sb2.append(string);
                            sb2.append(" order by rowid desc limit -1 offset ?)");
                            sQLiteDatabaseZze3.delete("audience_filter_values", sb2.toString(), new String[]{str, Integer.toString(iMax)});
                            break;
                        }
                        Integer num = (Integer) arrayList.get(i5);
                        if (num == null) {
                            break;
                        }
                        arrayList2.add(Integer.toString(num.intValue()));
                        i5++;
                    }
                }
            } catch (SQLiteException e) {
                this.zzu.zzaW().zzb().zzc("Database error querying filters. appId", zzgu.zzl(str), e);
            }
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
        } catch (Throwable th) {
            th = th;
            sQLiteDatabase = sQLiteDatabaseZze;
        }
    }

    final zzbd zzah(String str, com.google.android.gms.internal.measurement.zzhs zzhsVar, String str2) throws Throwable {
        zzbd zzbdVarZzaE = zzaE("events", str, zzhsVar.zzd());
        if (zzbdVarZzaE == null) {
            zzic zzicVar = this.zzu;
            zzicVar.zzaW().zze().zzc("Event aggregate wasn't created during raw event logging. appId, event", zzgu.zzl(str), zzicVar.zzl().zza(str2));
            return new zzbd(str, zzhsVar.zzd(), 1L, 1L, 1L, zzhsVar.zzf(), 0L, null, null, null, null);
        }
        long j = zzbdVarZzaE.zze + 1;
        long j2 = zzbdVarZzaE.zzd + 1;
        return new zzbd(zzbdVarZzaE.zza, zzbdVarZzaE.zzb, zzbdVarZzaE.zzc + 1, j2, j, zzbdVarZzaE.zzf, zzbdVarZzaE.zzg, zzbdVarZzaE.zzh, zzbdVarZzaE.zzi, zzbdVarZzaE.zzj, zzbdVarZzaE.zzk);
    }

    protected final boolean zzai() {
        zzic zzicVar = this.zzu;
        Context contextZzaZ = zzicVar.zzaZ();
        zzicVar.zzc();
        return contextZzaZ.getDatabasePath("google_app_measurement.db").exists();
    }

    final /* synthetic */ long zzaj(String str, String[] strArr, long j) {
        return zzaB("select rowid from raw_events where app_id = ? and timestamp < ? order by rowid desc limit 1", strArr, -1L);
    }

    final /* synthetic */ zzog zzau() {
        return this.zzn;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00eb A[Catch: SQLiteException -> 0x0076, all -> 0x0079, TryCatch #2 {SQLiteException -> 0x0076, blocks: (B:16:0x006e, B:33:0x00c0, B:35:0x00eb, B:36:0x0100, B:37:0x0104, B:38:0x0114, B:40:0x011a, B:41:0x012d, B:52:0x0163, B:55:0x016b, B:56:0x0179, B:58:0x01a8, B:59:0x01b5, B:61:0x01c1, B:66:0x01f7, B:65:0x01e1, B:70:0x0201, B:46:0x014e, B:72:0x0216), top: B:86:0x006e }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0100 A[Catch: SQLiteException -> 0x0076, all -> 0x0079, TRY_LEAVE, TryCatch #2 {SQLiteException -> 0x0076, blocks: (B:16:0x006e, B:33:0x00c0, B:35:0x00eb, B:36:0x0100, B:37:0x0104, B:38:0x0114, B:40:0x011a, B:41:0x012d, B:52:0x0163, B:55:0x016b, B:56:0x0179, B:58:0x01a8, B:59:0x01b5, B:61:0x01c1, B:66:0x01f7, B:65:0x01e1, B:70:0x0201, B:46:0x014e, B:72:0x0216), top: B:86:0x006e }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01a8 A[Catch: SQLiteException -> 0x0076, all -> 0x0079, LOOP:0: B:58:0x01a8->B:69:0x01fe, LOOP_START, PHI: r18
      0x01a8: PHI (r18v1 int) = (r18v0 int), (r18v2 int) binds: [B:57:0x01a6, B:69:0x01fe] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #2 {SQLiteException -> 0x0076, blocks: (B:16:0x006e, B:33:0x00c0, B:35:0x00eb, B:36:0x0100, B:37:0x0104, B:38:0x0114, B:40:0x011a, B:41:0x012d, B:52:0x0163, B:55:0x016b, B:56:0x0179, B:58:0x01a8, B:59:0x01b5, B:61:0x01c1, B:66:0x01f7, B:65:0x01e1, B:70:0x0201, B:46:0x014e, B:72:0x0216), top: B:86:0x006e }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0201 A[Catch: SQLiteException -> 0x0076, all -> 0x0079, TryCatch #2 {SQLiteException -> 0x0076, blocks: (B:16:0x006e, B:33:0x00c0, B:35:0x00eb, B:36:0x0100, B:37:0x0104, B:38:0x0114, B:40:0x011a, B:41:0x012d, B:52:0x0163, B:55:0x016b, B:56:0x0179, B:58:0x01a8, B:59:0x01b5, B:61:0x01c1, B:66:0x01f7, B:65:0x01e1, B:70:0x0201, B:46:0x014e, B:72:0x0216), top: B:86:0x006e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzav(String str, long j, long j2, zzpc zzpcVar) {
        String string;
        String str2;
        String string2;
        long j3;
        String[] strArr;
        String str3;
        int i;
        com.google.android.gms.internal.measurement.zzhr zzhrVar;
        Preconditions.checkNotNull(zzpcVar);
        zzg();
        zzay();
        Cursor cursorRawQuery = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseZze = zze();
                if (TextUtils.isEmpty(str)) {
                    String[] strArr2 = j2 != -1 ? new String[]{String.valueOf(j2), String.valueOf(j)} : new String[]{String.valueOf(j)};
                    str2 = j2 != -1 ? "rowid <= ? and " : "";
                    StringBuilder sb = new StringBuilder(str2.length() + 148);
                    sb.append("select app_id, metadata_fingerprint from raw_events where ");
                    sb.append(str2);
                    sb.append("app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;");
                    cursorRawQuery = sQLiteDatabaseZze.rawQuery(sb.toString(), strArr2);
                    if (cursorRawQuery.moveToFirst()) {
                        string = cursorRawQuery.getString(0);
                        try {
                            string2 = cursorRawQuery.getString(1);
                            cursorRawQuery.close();
                            int i2 = 1;
                            cursorRawQuery = sQLiteDatabaseZze.query("raw_events_metadata", new String[]{"metadata"}, "app_id = ? and metadata_fingerprint = ?", new String[]{string, string2}, null, null, "rowid", ExifInterface.GPS_MEASUREMENT_2D);
                            if (cursorRawQuery.moveToFirst()) {
                                this.zzu.zzaW().zzb().zzb("Raw event metadata record is missing. appId", zzgu.zzl(string));
                            } else {
                                try {
                                    com.google.android.gms.internal.measurement.zzid zzidVar = (com.google.android.gms.internal.measurement.zzid) ((com.google.android.gms.internal.measurement.zzic) zzpk.zzw(com.google.android.gms.internal.measurement.zzid.zzaE(), cursorRawQuery.getBlob(0))).zzbd();
                                    if (cursorRawQuery.moveToNext()) {
                                        this.zzu.zzaW().zze().zzb("Get multiple raw event metadata records, expected one. appId", zzgu.zzl(string));
                                    }
                                    cursorRawQuery.close();
                                    Preconditions.checkNotNull(zzidVar);
                                    zzpcVar.zza = zzidVar;
                                    long jZzaB = zzaB("select (rowid - 1) as max_rowid from raw_events where app_id = ? and metadata_fingerprint != ? order by rowid limit 1;", new String[]{string, string2}, -1L);
                                    if (j2 != -1) {
                                        j3 = j2;
                                    } else if (jZzaB != -1) {
                                        j3 = -1;
                                    } else {
                                        str3 = "app_id = ? and metadata_fingerprint = ?";
                                        strArr = new String[]{string, string2};
                                        cursorRawQuery = sQLiteDatabaseZze.query("raw_events", new String[]{"rowid", "name", DiagnosticsEntry.TIMESTAMP_KEY, Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "elapsed_time"}, str3, strArr, null, null, "rowid", null);
                                        if (cursorRawQuery.moveToFirst()) {
                                            this.zzu.zzaW().zze().zzb("Raw event data disappeared while in transaction. appId", zzgu.zzl(string));
                                        } else {
                                            while (true) {
                                                long j4 = cursorRawQuery.getLong(0);
                                                byte[] blob = cursorRawQuery.getBlob(3);
                                                long j5 = cursorRawQuery.getLong(4);
                                                try {
                                                    zzhrVar = (com.google.android.gms.internal.measurement.zzhr) zzpk.zzw(com.google.android.gms.internal.measurement.zzhs.zzp(), blob);
                                                    i = i2;
                                                    zzhrVar.zzl(cursorRawQuery.getString(i));
                                                    zzhrVar.zzo(cursorRawQuery.getLong(2));
                                                    zzhrVar.zzw(j5);
                                                } catch (IOException e) {
                                                    i = i2;
                                                    this.zzu.zzaW().zzb().zzc("Data loss. Failed to merge raw event. appId", zzgu.zzl(string), e);
                                                }
                                                if (!zzpcVar.zza(j4, (com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbd())) {
                                                    break;
                                                } else if (!cursorRawQuery.moveToNext()) {
                                                    break;
                                                } else {
                                                    i2 = i;
                                                }
                                            }
                                        }
                                    }
                                    if (j3 != -1 && jZzaB != -1) {
                                        jZzaB = Math.min(j3, jZzaB);
                                    } else if (j3 != -1) {
                                        jZzaB = j3;
                                    }
                                    str3 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?";
                                    strArr = new String[]{string, string2, String.valueOf(jZzaB)};
                                    cursorRawQuery = sQLiteDatabaseZze.query("raw_events", new String[]{"rowid", "name", DiagnosticsEntry.TIMESTAMP_KEY, Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "elapsed_time"}, str3, strArr, null, null, "rowid", null);
                                    if (cursorRawQuery.moveToFirst()) {
                                    }
                                } catch (IOException e2) {
                                    this.zzu.zzaW().zzb().zzc("Data loss. Failed to merge raw event metadata. appId", zzgu.zzl(string), e2);
                                }
                            }
                        } catch (SQLiteException e3) {
                            e = e3;
                            this.zzu.zzaW().zzb().zzc("Data loss. Error selecting raw event. appId", zzgu.zzl(string), e);
                        }
                    }
                } else {
                    String[] strArr3 = j2 != -1 ? new String[]{str, String.valueOf(j2)} : new String[]{str};
                    str2 = j2 != -1 ? " and rowid <= ?" : "";
                    StringBuilder sb2 = new StringBuilder(str2.length() + 84);
                    sb2.append("select metadata_fingerprint from raw_events where app_id = ?");
                    sb2.append(str2);
                    sb2.append(" order by rowid limit 1;");
                    cursorRawQuery = sQLiteDatabaseZze.rawQuery(sb2.toString(), strArr3);
                    if (cursorRawQuery.moveToFirst()) {
                        string2 = cursorRawQuery.getString(0);
                        cursorRawQuery.close();
                        string = str;
                        int i22 = 1;
                        cursorRawQuery = sQLiteDatabaseZze.query("raw_events_metadata", new String[]{"metadata"}, "app_id = ? and metadata_fingerprint = ?", new String[]{string, string2}, null, null, "rowid", ExifInterface.GPS_MEASUREMENT_2D);
                        if (cursorRawQuery.moveToFirst()) {
                        }
                    }
                }
            } catch (SQLiteException e4) {
                e = e4;
                string = str;
            }
        } finally {
            if (0 != 0) {
                cursorRawQuery.close();
            }
        }
    }

    public final void zzb() {
        zzay();
        zze().beginTransaction();
    }

    @Override // com.google.android.gms.measurement.internal.zzos
    protected final boolean zzbc() {
        zzic zzicVar = this.zzu;
        if (!zzicVar.zzc().zzp(null, zzfy.zzbe)) {
            return false;
        }
        zzicVar.zzaX().zzj(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzas
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzaw zzawVar = this.zza;
                try {
                    SQLiteDatabase sQLiteDatabaseZze = zzawVar.zze();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("elapsed_time", (Long) 0L);
                    sQLiteDatabaseZze.update("raw_events", contentValues, null, null);
                } catch (SQLiteException e) {
                    zzawVar.zzu.zzaW().zzb().zzb("Failed to remove elapsed times from raw events table", e);
                }
            }
        });
        return false;
    }

    public final void zzc() {
        zzay();
        zze().setTransactionSuccessful();
    }

    public final void zzd() {
        zzay();
        zze().endTransaction();
    }

    final SQLiteDatabase zze() {
        zzg();
        try {
            return this.zzm.getWritableDatabase();
        } catch (SQLiteException e) {
            this.zzu.zzaW().zze().zzb("Error opening database", e);
            throw e;
        }
    }

    public final zzbd zzf(String str, String str2) {
        return zzaE("events", str, str2);
    }

    public final void zzh(zzbd zzbdVar) {
        zzaF("events", zzbdVar);
    }

    public final void zzi(String str) {
        zzbd zzbdVarZzaE;
        zzaG("events_snapshot", str);
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = zze().query("events", (String[]) Collections.singletonList("name").toArray(new String[0]), "app_id=?", new String[]{str}, null, null, null);
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(0);
                        if (string != null && (zzbdVarZzaE = zzaE("events", str, string)) != null) {
                            zzaF("events_snapshot", zzbdVarZzaE);
                        }
                    } while (cursorQuery.moveToNext());
                }
            } catch (SQLiteException e) {
                this.zzu.zzaW().zzb().zzc("Error creating snapshot. appId", zzgu.zzl(str), e);
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzj(String str) throws Throwable {
        boolean z;
        zzbd zzbdVarZzaE;
        boolean z2 = false;
        ArrayList arrayList = new ArrayList(Arrays.asList("name", "lifetime_count"));
        zzbd zzbdVarZzaE2 = zzaE("events", str, "_f");
        zzbd zzbdVarZzaE3 = zzaE("events", str, "_v");
        zzaG("events", str);
        Cursor cursorQuery = null;
        try {
            cursorQuery = zze().query("events_snapshot", (String[]) arrayList.toArray(new String[0]), "app_id=?", new String[]{str}, null, null, null);
        } catch (SQLiteException e) {
            e = e;
            z = false;
        } catch (Throwable th) {
            th = th;
            z = false;
        }
        if (!cursorQuery.moveToFirst()) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            if (zzbdVarZzaE2 != null) {
                zzaF("events", zzbdVarZzaE2);
            } else if (zzbdVarZzaE3 != null) {
                zzaF("events", zzbdVarZzaE3);
            }
            zzaG("events_snapshot", str);
        }
        boolean z3 = false;
        z = false;
        do {
            try {
                String string = cursorQuery.getString(0);
                if (cursorQuery.getLong(1) >= 1) {
                    if ("_f".equals(string)) {
                        z3 = true;
                    } else if ("_v".equals(string)) {
                        z = true;
                    }
                }
                if (string != null && (zzbdVarZzaE = zzaE("events_snapshot", str, string)) != null) {
                    zzaF("events", zzbdVarZzaE);
                }
            } catch (SQLiteException e2) {
                e = e2;
                z2 = z3;
                try {
                    this.zzu.zzaW().zzb().zzc("Error querying snapshot. appId", zzgu.zzl(str), e);
                    z3 = z2;
                } catch (Throwable th2) {
                    th = th2;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    if (z2 && zzbdVarZzaE2 != null) {
                        zzaF("events", zzbdVarZzaE2);
                    } else if (!z && zzbdVarZzaE3 != null) {
                        zzaF("events", zzbdVarZzaE3);
                    }
                    zzaG("events_snapshot", str);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                z2 = z3;
                if (cursorQuery != null) {
                }
                if (z2) {
                    if (!z) {
                        zzaF("events", zzbdVarZzaE3);
                    }
                }
                zzaG("events_snapshot", str);
                throw th;
            }
        } while (cursorQuery.moveToNext());
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        if (z3 || zzbdVarZzaE2 == null) {
            if (!z && zzbdVarZzaE3 != null) {
            }
        }
        zzaG("events_snapshot", str);
    }

    public final void zzk(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzay();
        try {
            zze().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzic zzicVar = this.zzu;
            zzicVar.zzaW().zzb().zzd("Error deleting user property. appId", zzgu.zzl(str), zzicVar.zzl().zzc(str2), e);
        }
    }

    public final boolean zzl(zzpn zzpnVar) {
        Preconditions.checkNotNull(zzpnVar);
        zzg();
        zzay();
        String str = zzpnVar.zza;
        String str2 = zzpnVar.zzc;
        if (zzm(str, str2) == null) {
            if (zzpp.zzh(str2)) {
                if (zzaA("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{str}) >= this.zzu.zzc().zzn(str, zzfy.zzV, 25, 100)) {
                    return false;
                }
            } else if (!"_npa".equals(str2)) {
                long jZzaA = zzaA("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{str, zzpnVar.zzb});
                this.zzu.zzc();
                if (jZzaA >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", zzpnVar.zzb);
        contentValues.put("name", str2);
        contentValues.put("set_timestamp", Long.valueOf(zzpnVar.zzd));
        zzaw(contentValues, "value", zzpnVar.zze);
        try {
            if (zze().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                this.zzu.zzaW().zzb().zzb("Failed to insert/update user property (got -1). appId", zzgu.zzl(str));
            }
        } catch (SQLiteException e) {
            this.zzu.zzaW().zzb().zzc("Error storing user property. appId", zzgu.zzl(zzpnVar.zza), e);
        }
        return true;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x00a3: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:32:0x00a2 */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzpn zzm(String str, String str2) {
        Throwable th;
        String str3;
        String str4;
        SQLiteException sQLiteException;
        Cursor cursorQuery;
        Cursor cursor;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzay();
        Cursor cursor2 = null;
        try {
            try {
                cursorQuery = zze().query("user_attributes", new String[]{"set_timestamp", "value", "origin"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
                try {
                } catch (SQLiteException e) {
                    e = e;
                    str3 = str;
                    str4 = str2;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor2 = cursor;
                if (cursor2 != null) {
                    throw th;
                }
                cursor2.close();
                throw th;
            }
        } catch (SQLiteException e2) {
            str3 = str;
            str4 = str2;
            sQLiteException = e2;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
            }
        }
        if (cursorQuery.moveToFirst()) {
            long j = cursorQuery.getLong(0);
            Object objZzL = zzL(cursorQuery, 1);
            if (objZzL != null) {
                str3 = str;
                str4 = str2;
                try {
                    zzpn zzpnVar = new zzpn(str3, cursorQuery.getString(2), str4, j, objZzL);
                    if (cursorQuery.moveToNext()) {
                        this.zzu.zzaW().zzb().zzb("Got multiple records for user property, expected one. appId", zzgu.zzl(str3));
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return zzpnVar;
                } catch (SQLiteException e3) {
                    e = e3;
                }
            }
            sQLiteException = e;
            zzic zzicVar = this.zzu;
            zzicVar.zzaW().zzb().zzd("Error querying user property. appId", zzgu.zzl(str3), zzicVar.zzl().zzc(str4), sQLiteException);
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return null;
    }

    public final List zzn(String str) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzay();
        List arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                zzic zzicVar = this.zzu;
                zzicVar.zzc();
                cursorQuery = zze().query("user_attributes", new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(0);
                        String string2 = cursorQuery.getString(1);
                        if (string2 == null) {
                            string2 = "";
                        }
                        String str2 = string2;
                        long j = cursorQuery.getLong(2);
                        Object objZzL = zzL(cursorQuery, 3);
                        if (objZzL == null) {
                            zzicVar.zzaW().zzb().zzb("Read invalid user property value, ignoring it. appId", zzgu.zzl(str));
                        } else {
                            arrayList.add(new zzpn(str, str2, string, j, objZzL));
                        }
                    } while (cursorQuery.moveToNext());
                }
            } catch (SQLiteException e) {
                this.zzu.zzaW().zzb().zzc("Error querying user properties. appId", zzgu.zzl(str), e);
                arrayList = Collections.emptyList();
            }
            return arrayList;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00b9, code lost:
    
        r0 = r13.zzaW().zzb();
        r13.zzc();
        r0.zzb("Read more than the max allowed user properties, ignoring excess", 1000);
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0147  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List zzo(String str, String str2, String str3) throws Throwable {
        Cursor cursor;
        String str4;
        Cursor cursorQuery;
        String str5;
        Preconditions.checkNotEmpty(str);
        zzg();
        zzay();
        List arrayList = new ArrayList();
        try {
            try {
                ArrayList arrayList2 = new ArrayList(3);
                String str6 = str;
                arrayList2.add(str6);
                StringBuilder sb = new StringBuilder("app_id=?");
                if (TextUtils.isEmpty(str2)) {
                    str4 = str2;
                } else {
                    str4 = str2;
                    try {
                        arrayList2.add(str4);
                        sb.append(" and origin=?");
                    } catch (SQLiteException e) {
                        e = e;
                        cursor = null;
                        try {
                            this.zzu.zzaW().zzb().zzd("(2)Error querying user properties", zzgu.zzl(str), str4, e);
                            arrayList = Collections.emptyList();
                            cursorQuery = cursor;
                            if (cursorQuery != null) {
                            }
                            return arrayList;
                        } catch (Throwable th) {
                            th = th;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    }
                }
                if (!TextUtils.isEmpty(str3)) {
                    StringBuilder sb2 = new StringBuilder(String.valueOf(str3).length() + 1);
                    sb2.append(str3);
                    sb2.append(ProxyConfig.MATCH_ALL_SCHEMES);
                    arrayList2.add(sb2.toString());
                    sb.append(" and name glob ?");
                }
                String[] strArr = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
                String string = sb.toString();
                zzic zzicVar = this.zzu;
                zzicVar.zzc();
                cursorQuery = zze().query("user_attributes", new String[]{"name", "set_timestamp", "value", "origin"}, string, strArr, null, null, "rowid", "1001");
                try {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            while (true) {
                                int size = arrayList.size();
                                zzicVar.zzc();
                                if (size >= 1000) {
                                    break;
                                }
                                String string2 = cursorQuery.getString(0);
                                long j = cursorQuery.getLong(1);
                                Object objZzL = zzL(cursorQuery, 2);
                                String string3 = cursorQuery.getString(3);
                                if (objZzL == null) {
                                    try {
                                        zzicVar.zzaW().zzb().zzd("(2)Read invalid user property value, ignoring it", zzgu.zzl(str6), string3, str3);
                                        str5 = string3;
                                    } catch (SQLiteException e2) {
                                        e = e2;
                                        str5 = string3;
                                        cursor = cursorQuery;
                                        str4 = str5;
                                        this.zzu.zzaW().zzb().zzd("(2)Error querying user properties", zzgu.zzl(str), str4, e);
                                        arrayList = Collections.emptyList();
                                        cursorQuery = cursor;
                                    }
                                } else {
                                    str5 = string3;
                                    try {
                                        arrayList.add(new zzpn(str6, str5, string2, j, objZzL));
                                    } catch (SQLiteException e3) {
                                        e = e3;
                                        cursor = cursorQuery;
                                        str4 = str5;
                                        this.zzu.zzaW().zzb().zzd("(2)Error querying user properties", zzgu.zzl(str), str4, e);
                                        arrayList = Collections.emptyList();
                                        cursorQuery = cursor;
                                    }
                                }
                                if (!cursorQuery.moveToNext()) {
                                    break;
                                }
                                str6 = str;
                                str4 = str5;
                            }
                        }
                    } catch (SQLiteException e4) {
                        e = e4;
                        cursor = cursorQuery;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = cursorQuery;
                    if (cursor != null) {
                    }
                    throw th;
                }
            } catch (SQLiteException e5) {
                e = e5;
                str4 = str2;
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    public final boolean zzp(zzah zzahVar) {
        Preconditions.checkNotNull(zzahVar);
        zzg();
        zzay();
        String str = zzahVar.zza;
        Preconditions.checkNotNull(str);
        if (zzm(str, zzahVar.zzc.zzb) == null) {
            long jZzaA = zzaA("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str});
            this.zzu.zzc();
            if (jZzaA >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", zzahVar.zzb);
        contentValues.put("name", zzahVar.zzc.zzb);
        zzaw(contentValues, "value", Preconditions.checkNotNull(zzahVar.zzc.zza()));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, Boolean.valueOf(zzahVar.zze));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzahVar.zzf);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.valueOf(zzahVar.zzh));
        zzic zzicVar = this.zzu;
        contentValues.put("timed_out_event", zzicVar.zzk().zzah(zzahVar.zzg));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzahVar.zzd));
        contentValues.put("triggered_event", zzicVar.zzk().zzah(zzahVar.zzi));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.valueOf(zzahVar.zzc.zzc));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.valueOf(zzahVar.zzj));
        contentValues.put("expired_event", zzicVar.zzk().zzah(zzahVar.zzk));
        try {
            if (zze().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                zzicVar.zzaW().zzb().zzb("Failed to insert/update conditional user property (got -1)", zzgu.zzl(str));
            }
        } catch (SQLiteException e) {
            this.zzu.zzaW().zzb().zzc("Error storing conditional user property", zzgu.zzl(str), e);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x0157: MOVE (r8 I:??[OBJECT, ARRAY]) = (r9 I:??[OBJECT, ARRAY]), block:B:43:0x0157 */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x015a  */
    /* JADX WARN: Type inference failed for: r33v0, types: [com.google.android.gms.measurement.internal.zzaw, com.google.android.gms.measurement.internal.zzje, com.google.android.gms.measurement.internal.zzol, com.google.android.gms.measurement.internal.zzos] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r9v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzah zzq(String str, String str2) throws Throwable {
        zzah zzahVar;
        String str3;
        Object obj;
        ?? r8;
        ?? Query;
        ?? r9;
        SQLiteDatabase sQLiteDatabaseZze;
        String[] strArr;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzay();
        try {
            try {
                sQLiteDatabaseZze = zze();
                strArr = new String[11];
                strArr[0] = "origin";
                strArr[1] = "value";
                strArr[2] = AppMeasurementSdk.ConditionalUserProperty.ACTIVE;
                strArr[3] = AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME;
                strArr[4] = AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT;
                strArr[5] = "timed_out_event";
                strArr[6] = AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP;
                strArr[7] = "triggered_event";
                strArr[8] = AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP;
                strArr[9] = AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE;
                zzahVar = null;
            } catch (Throwable th) {
                th = th;
                r8 = obj;
                if (r8 != 0) {
                    r8.close();
                }
                throw th;
            }
            try {
                strArr[10] = "expired_event";
                Query = sQLiteDatabaseZze.query("conditional_properties", strArr, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
                try {
                } catch (SQLiteException e) {
                    e = e;
                    str3 = str2;
                }
            } catch (SQLiteException e2) {
                e = e2;
                str3 = str2;
                Query = zzahVar;
            } catch (Throwable th2) {
                th = th2;
                r8 = zzahVar;
                if (r8 != 0) {
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            str3 = str2;
            zzahVar = null;
        } catch (Throwable th3) {
            th = th3;
            zzahVar = null;
        }
        if (!Query.moveToFirst()) {
            r9 = Query;
            if (r9 != 0) {
                r9.close();
            }
            return zzahVar;
        }
        String string = Query.getString(0);
        if (string == null) {
            string = "";
        }
        Object objZzL = zzL(Query, 1);
        boolean z = Query.getInt(2) != 0;
        String string2 = Query.getString(3);
        long j = Query.getLong(4);
        zzpg zzpgVar = this.zzg;
        str3 = str2;
        String str4 = string;
        try {
            zzah zzahVar2 = new zzah(str, str4, new zzpl(str3, Query.getLong(8), objZzL, str4), Query.getLong(6), z, string2, (zzbh) zzpgVar.zzp().zzl(Query.getBlob(5), zzbh.CREATOR), j, (zzbh) zzpgVar.zzp().zzl(Query.getBlob(7), zzbh.CREATOR), Query.getLong(9), (zzbh) zzpgVar.zzp().zzl(Query.getBlob(10), zzbh.CREATOR));
            if (Query.moveToNext()) {
                zzic zzicVar = this.zzu;
                zzicVar.zzaW().zzb().zzc("Got multiple records for conditional property, expected one", zzgu.zzl(str), zzicVar.zzl().zzc(str3));
            }
            if (Query != 0) {
                Query.close();
            }
            return zzahVar2;
        } catch (SQLiteException e4) {
            e = e4;
        }
        zzic zzicVar2 = this.zzu;
        zzicVar2.zzaW().zzb().zzd("Error querying conditional property", zzgu.zzl(str), zzicVar2.zzl().zzc(str3), e);
        r9 = Query;
        if (r9 != 0) {
        }
        return zzahVar;
    }

    public final int zzr(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzay();
        try {
            return zze().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzic zzicVar = this.zzu;
            zzicVar.zzaW().zzb().zzd("Error deleting conditional property", zzgu.zzl(str), zzicVar.zzl().zzc(str2), e);
            return 0;
        }
    }

    public final List zzs(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzay();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            String.valueOf(str3);
            arrayList.add(String.valueOf(str3).concat(ProxyConfig.MATCH_ALL_SCHEMES));
            sb.append(" and name glob ?");
        }
        return zzt(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0086, code lost:
    
        r3 = r11.zzaW().zzb();
        r11.zzc();
        r3.zzb("Read more than the max allowed conditional properties, ignoring extra", 1000);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x016a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List zzt(String str, String[] strArr) throws Throwable {
        Cursor cursor;
        Cursor cursorQuery;
        zzg();
        zzay();
        List arrayList = new ArrayList();
        try {
            SQLiteDatabase sQLiteDatabaseZze = zze();
            int i = 0;
            int i2 = 1;
            String[] strArr2 = {"app_id", "origin", "name", "value", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, "timed_out_event", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "triggered_event", AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, "expired_event"};
            zzic zzicVar = this.zzu;
            zzicVar.zzc();
            cursorQuery = sQLiteDatabaseZze.query("conditional_properties", strArr2, str, strArr, null, null, "rowid", "1001");
            try {
                if (cursorQuery.moveToFirst()) {
                    while (true) {
                        int size = arrayList.size();
                        zzicVar.zzc();
                        if (size >= 1000) {
                            break;
                        }
                        String string = cursorQuery.getString(i);
                        String string2 = cursorQuery.getString(i2);
                        String string3 = cursorQuery.getString(2);
                        Object objZzL = zzL(cursorQuery, 3);
                        boolean z = cursorQuery.getInt(4) != 0 ? i2 : i;
                        String string4 = cursorQuery.getString(5);
                        long j = cursorQuery.getLong(6);
                        zzpg zzpgVar = this.zzg;
                        arrayList.add(new zzah(string, string2, new zzpl(string3, cursorQuery.getLong(10), objZzL, string2), cursorQuery.getLong(8), z, string4, (zzbh) zzpgVar.zzp().zzl(cursorQuery.getBlob(7), zzbh.CREATOR), j, (zzbh) zzpgVar.zzp().zzl(cursorQuery.getBlob(9), zzbh.CREATOR), cursorQuery.getLong(11), (zzbh) zzpgVar.zzp().zzl(cursorQuery.getBlob(12), zzbh.CREATOR)));
                        if (!cursorQuery.moveToNext()) {
                            break;
                        }
                        i = 0;
                        i2 = 1;
                    }
                }
            } catch (SQLiteException e) {
                e = e;
                cursor = cursorQuery;
                try {
                    this.zzu.zzaW().zzb().zzb("Error querying conditional user property value", e);
                    arrayList = Collections.emptyList();
                    cursorQuery = cursor;
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorQuery;
                if (cursor != null) {
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x03e2: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:106:0x03e2 */
    /* JADX WARN: Removed duplicated region for block: B:103:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x03e5  */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r4v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzh zzu(String str) {
        zzh zzhVar;
        Object obj;
        ?? r3;
        ?? Query;
        ?? r4;
        SQLiteDatabase sQLiteDatabaseZze;
        String[] strArr;
        Boolean boolValueOf;
        Preconditions.checkNotEmpty(str);
        zzg();
        zzay();
        try {
            try {
                sQLiteDatabaseZze = zze();
                strArr = new String[46];
                strArr[0] = "app_instance_id";
                strArr[1] = "gmp_app_id";
                strArr[2] = "resettable_device_id_hash";
                strArr[3] = "last_bundle_index";
                strArr[4] = "last_bundle_start_timestamp";
                strArr[5] = "last_bundle_end_timestamp";
                strArr[6] = "app_version";
                strArr[7] = "app_store";
                strArr[8] = "gmp_version";
                strArr[9] = "dev_cert_hash";
                strArr[10] = "measurement_enabled";
                strArr[11] = "day";
                strArr[12] = "daily_public_events_count";
                strArr[13] = "daily_events_count";
                strArr[14] = "daily_conversions_count";
                strArr[15] = "config_fetched_time";
                strArr[16] = "failed_config_fetch_time";
                zzhVar = null;
            } catch (Throwable th) {
                th = th;
                r3 = obj;
                if (r3 != 0) {
                    r3.close();
                }
                throw th;
            }
        } catch (SQLiteException e) {
            e = e;
            zzhVar = null;
        } catch (Throwable th2) {
            th = th2;
            zzhVar = null;
        }
        try {
            strArr[17] = "app_version_int";
            strArr[18] = "firebase_instance_id";
            strArr[19] = "daily_error_events_count";
            strArr[20] = "daily_realtime_events_count";
            strArr[21] = "health_monitor_sample";
            strArr[22] = "android_id";
            strArr[23] = "adid_reporting_enabled";
            strArr[24] = "admob_app_id";
            strArr[25] = "dynamite_version";
            strArr[26] = "safelisted_events";
            strArr[27] = "ga_app_id";
            strArr[28] = "session_stitching_token";
            strArr[29] = "sgtm_upload_enabled";
            strArr[30] = "target_os_version";
            strArr[31] = "session_stitching_token_hash";
            strArr[32] = "ad_services_version";
            strArr[33] = "unmatched_first_open_without_ad_id";
            strArr[34] = "npa_metadata_value";
            strArr[35] = "attribution_eligibility_status";
            strArr[36] = "sgtm_preview_key";
            strArr[37] = "dma_consent_state";
            strArr[38] = "daily_realtime_dcu_count";
            strArr[39] = "bundle_delivery_index";
            strArr[40] = "serialized_npa_metadata";
            strArr[41] = "unmatched_pfo";
            strArr[42] = "unmatched_uwa";
            strArr[43] = "ad_campaign_info";
            strArr[44] = "client_upload_eligibility";
            strArr[45] = "last_diagnostics_signal_upload_timestamp";
            Query = sQLiteDatabaseZze.query("apps", strArr, "app_id=?", new String[]{str}, null, null, null);
            try {
                if (Query.moveToFirst()) {
                    zzpg zzpgVar = this.zzg;
                    zzh zzhVar2 = new zzh(zzpgVar.zzah(), str);
                    zzjl zzjlVarZzB = zzpgVar.zzB(str);
                    zzjk zzjkVar = zzjk.ANALYTICS_STORAGE;
                    if (zzjlVarZzB.zzo(zzjkVar)) {
                        zzhVar2.zze(Query.getString(0));
                    }
                    zzhVar2.zzg(Query.getString(1));
                    if (zzpgVar.zzB(str).zzo(zzjk.AD_STORAGE)) {
                        zzhVar2.zzk(Query.getString(2));
                    }
                    zzhVar2.zzF(Query.getLong(3));
                    zzhVar2.zzo(Query.getLong(4));
                    zzhVar2.zzq(Query.getLong(5));
                    zzhVar2.zzs(Query.getString(6));
                    zzhVar2.zzw(Query.getString(7));
                    zzhVar2.zzy(Query.getLong(8));
                    zzhVar2.zzA(Query.getLong(9));
                    zzhVar2.zzE(Query.isNull(10) || Query.getInt(10) != 0);
                    zzhVar2.zzO(Query.getLong(11));
                    zzhVar2.zzQ(Query.getLong(12));
                    zzhVar2.zzS(Query.getLong(13));
                    zzhVar2.zzU(Query.getLong(14));
                    zzhVar2.zzI(Query.getLong(15));
                    zzhVar2.zzK(Query.getLong(16));
                    zzhVar2.zzu(Query.isNull(17) ? SieveCacheKt.NodeMetaAndPreviousMask : Query.getInt(17));
                    zzhVar2.zzm(Query.getString(18));
                    zzhVar2.zzY(Query.getLong(19));
                    zzhVar2.zzW(Query.getLong(20));
                    zzhVar2.zzab(Query.getString(21));
                    zzhVar2.zzad(Query.isNull(23) || Query.getInt(23) != 0);
                    zzhVar2.zzC(Query.isNull(25) ? 0L : Query.getLong(25));
                    if (!Query.isNull(26)) {
                        zzhVar2.zzah(Arrays.asList(Query.getString(26).split(",", -1)));
                    }
                    if (zzpgVar.zzB(str).zzo(zzjkVar)) {
                        zzhVar2.zzi(Query.getString(28));
                    }
                    zzhVar2.zzaj((Query.isNull(29) || Query.getInt(29) == 0) ? false : true);
                    zzhVar2.zzaE(Query.getLong(39));
                    zzhVar2.zzaz(Query.getString(36));
                    zzhVar2.zzal(Query.getLong(30));
                    zzhVar2.zzan(Query.getLong(31));
                    zzaif.zza();
                    zzic zzicVar = this.zzu;
                    if (zzicVar.zzc().zzp(str, zzfy.zzaO)) {
                        zzhVar2.zzap(Query.getInt(32));
                        zzhVar2.zzax(Query.getLong(35));
                    }
                    zzhVar2.zzar((Query.isNull(33) || Query.getInt(33) == 0) ? false : true);
                    if (Query.isNull(34)) {
                        boolValueOf = null;
                    } else {
                        boolValueOf = Boolean.valueOf(Query.getInt(34) != 0);
                    }
                    zzhVar2.zzaf(boolValueOf);
                    zzhVar2.zzaB(Query.getInt(37));
                    zzhVar2.zzaD(Query.getInt(38));
                    zzhVar2.zzaG(Query.isNull(40) ? "" : (String) Preconditions.checkNotNull(Query.getString(40)));
                    if (!Query.isNull(41)) {
                        zzhVar2.zzat(Long.valueOf(Query.getLong(41)));
                    }
                    if (!Query.isNull(42)) {
                        zzhVar2.zzav(Long.valueOf(Query.getLong(42)));
                    }
                    zzhVar2.zzaI(Query.getBlob(43));
                    if (!Query.isNull(44)) {
                        zzhVar2.zzaK(Query.getInt(44));
                    }
                    if (zzicVar.zzc().zzp(str, zzfy.zzbj) && !Query.isNull(45)) {
                        zzhVar2.zzaM(Query.getLong(45));
                    }
                    zzhVar2.zzb();
                    if (Query.moveToNext()) {
                        zzicVar.zzaW().zzb().zzb("Got multiple records for app, expected one. appId", zzgu.zzl(str));
                    }
                    if (Query != 0) {
                        Query.close();
                    }
                    return zzhVar2;
                }
                r4 = Query;
            } catch (SQLiteException e2) {
                e = e2;
                this.zzu.zzaW().zzb().zzc("Error querying app. appId", zzgu.zzl(str), e);
                r4 = Query;
            }
        } catch (SQLiteException e3) {
            e = e3;
            Query = zzhVar;
            this.zzu.zzaW().zzb().zzc("Error querying app. appId", zzgu.zzl(str), e);
            r4 = Query;
            if (r4 != 0) {
            }
            return zzhVar;
        } catch (Throwable th3) {
            th = th3;
            r3 = zzhVar;
            if (r3 != 0) {
            }
            throw th;
        }
        if (r4 != 0) {
            r4.close();
        }
        return zzhVar;
    }

    public final void zzv(zzh zzhVar, boolean z, boolean z2) {
        Preconditions.checkNotNull(zzhVar);
        zzg();
        zzay();
        String strZzc = zzhVar.zzc();
        Preconditions.checkNotNull(strZzc);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", strZzc);
        if (z) {
            contentValues.put("app_instance_id", (String) null);
        } else if (this.zzg.zzB(strZzc).zzo(zzjk.ANALYTICS_STORAGE)) {
            contentValues.put("app_instance_id", zzhVar.zzd());
        }
        contentValues.put("gmp_app_id", zzhVar.zzf());
        zzpg zzpgVar = this.zzg;
        if (zzpgVar.zzB(strZzc).zzo(zzjk.AD_STORAGE)) {
            contentValues.put("resettable_device_id_hash", zzhVar.zzj());
        }
        contentValues.put("last_bundle_index", Long.valueOf(zzhVar.zzG()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzhVar.zzn()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzhVar.zzp()));
        contentValues.put("app_version", zzhVar.zzr());
        contentValues.put("app_store", zzhVar.zzv());
        contentValues.put("gmp_version", Long.valueOf(zzhVar.zzx()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzhVar.zzz()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzhVar.zzD()));
        contentValues.put("day", Long.valueOf(zzhVar.zzN()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzhVar.zzP()));
        contentValues.put("daily_events_count", Long.valueOf(zzhVar.zzR()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzhVar.zzT()));
        contentValues.put("config_fetched_time", Long.valueOf(zzhVar.zzH()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzhVar.zzJ()));
        contentValues.put("app_version_int", Long.valueOf(zzhVar.zzt()));
        contentValues.put("firebase_instance_id", zzhVar.zzl());
        contentValues.put("daily_error_events_count", Long.valueOf(zzhVar.zzX()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzhVar.zzV()));
        contentValues.put("health_monitor_sample", zzhVar.zzZ());
        contentValues.put("android_id", (Long) 0L);
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzhVar.zzac()));
        contentValues.put("dynamite_version", Long.valueOf(zzhVar.zzB()));
        if (zzpgVar.zzB(strZzc).zzo(zzjk.ANALYTICS_STORAGE)) {
            contentValues.put("session_stitching_token", zzhVar.zzh());
        }
        contentValues.put("sgtm_upload_enabled", Boolean.valueOf(zzhVar.zzai()));
        contentValues.put("target_os_version", Long.valueOf(zzhVar.zzak()));
        contentValues.put("session_stitching_token_hash", Long.valueOf(zzhVar.zzam()));
        zzaif.zza();
        zzic zzicVar = this.zzu;
        if (zzicVar.zzc().zzp(strZzc, zzfy.zzaO)) {
            contentValues.put("ad_services_version", Integer.valueOf(zzhVar.zzao()));
            contentValues.put("attribution_eligibility_status", Long.valueOf(zzhVar.zzaw()));
        }
        contentValues.put("unmatched_first_open_without_ad_id", Boolean.valueOf(zzhVar.zzaq()));
        contentValues.put("npa_metadata_value", zzhVar.zzae());
        contentValues.put("bundle_delivery_index", Long.valueOf(zzhVar.zzaF()));
        contentValues.put("sgtm_preview_key", zzhVar.zzay());
        contentValues.put("dma_consent_state", Integer.valueOf(zzhVar.zzaA()));
        contentValues.put("daily_realtime_dcu_count", Integer.valueOf(zzhVar.zzaC()));
        contentValues.put("serialized_npa_metadata", zzhVar.zzaH());
        contentValues.put("client_upload_eligibility", Integer.valueOf(zzhVar.zzaL()));
        List listZzag = zzhVar.zzag();
        if (listZzag != null) {
            if (listZzag.isEmpty()) {
                zzicVar.zzaW().zze().zzb("Safelisted events should not be an empty list. appId", strZzc);
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", listZzag));
            }
        }
        zzahk.zza();
        if (zzicVar.zzc().zzp(null, zzfy.zzaK) && !contentValues.containsKey("safelisted_events")) {
            contentValues.put("safelisted_events", (String) null);
        }
        contentValues.put("unmatched_pfo", zzhVar.zzas());
        contentValues.put("unmatched_uwa", zzhVar.zzau());
        contentValues.put("ad_campaign_info", zzhVar.zzaJ());
        if (zzicVar.zzc().zzp(strZzc, zzfy.zzbj)) {
            contentValues.put("last_diagnostics_signal_upload_timestamp", Long.valueOf(zzhVar.zzaN()));
        }
        try {
            SQLiteDatabase sQLiteDatabaseZze = zze();
            if (sQLiteDatabaseZze.update("apps", contentValues, "app_id = ?", new String[]{strZzc}) == 0 && sQLiteDatabaseZze.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzicVar.zzaW().zzb().zzb("Failed to insert/update app (got -1). appId", zzgu.zzl(strZzc));
            }
        } catch (SQLiteException e) {
            this.zzu.zzaW().zzb().zzc("Error storing app. appId", zzgu.zzl(strZzc), e);
        }
    }

    public final zzar zzw(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        return zzx(j, str, 1L, false, false, z3, false, z5, z6, z7);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0164  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzar zzx(long j, String str, long j2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) throws Throwable {
        Cursor cursor;
        Cursor cursorQuery;
        String[] strArr;
        Preconditions.checkNotEmpty(str);
        zzg();
        zzay();
        String[] strArr2 = {str};
        zzar zzarVar = new zzar();
        try {
            try {
                SQLiteDatabase sQLiteDatabaseZze = zze();
                cursorQuery = sQLiteDatabaseZze.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count", "daily_realtime_dcu_count", "daily_registered_triggers_count"}, "app_id=?", new String[]{str}, null, null, null);
                try {
                    if (cursorQuery.moveToFirst()) {
                        if (cursorQuery.getLong(0) == j) {
                            strArr = strArr2;
                            zzarVar.zzb = cursorQuery.getLong(1);
                            zzarVar.zza = cursorQuery.getLong(2);
                            zzarVar.zzc = cursorQuery.getLong(3);
                            zzarVar.zzd = cursorQuery.getLong(4);
                            zzarVar.zze = cursorQuery.getLong(5);
                            zzarVar.zzf = cursorQuery.getLong(6);
                            zzarVar.zzg = cursorQuery.getLong(7);
                        } else {
                            strArr = strArr2;
                        }
                        if (z) {
                            zzarVar.zzb += j2;
                        }
                        if (z2) {
                            zzarVar.zza += j2;
                        }
                        if (z3) {
                            zzarVar.zzc += j2;
                        }
                        if (z4) {
                            zzarVar.zzd += j2;
                        }
                        if (z5) {
                            zzarVar.zze += j2;
                        }
                        if (z6) {
                            zzarVar.zzf += j2;
                        }
                        if (z7) {
                            zzarVar.zzg += j2;
                        }
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("day", Long.valueOf(j));
                        contentValues.put("daily_public_events_count", Long.valueOf(zzarVar.zza));
                        contentValues.put("daily_events_count", Long.valueOf(zzarVar.zzb));
                        contentValues.put("daily_conversions_count", Long.valueOf(zzarVar.zzc));
                        contentValues.put("daily_error_events_count", Long.valueOf(zzarVar.zzd));
                        contentValues.put("daily_realtime_events_count", Long.valueOf(zzarVar.zze));
                        contentValues.put("daily_realtime_dcu_count", Long.valueOf(zzarVar.zzf));
                        contentValues.put("daily_registered_triggers_count", Long.valueOf(zzarVar.zzg));
                        sQLiteDatabaseZze.update("apps", contentValues, "app_id=?", strArr);
                    } else {
                        this.zzu.zzaW().zze().zzb("Not updating daily counts, app is not known. appId", zzgu.zzl(str));
                    }
                } catch (SQLiteException e) {
                    e = e;
                    this.zzu.zzaW().zzb().zzc("Error updating daily counts. appId", zzgu.zzl(str), e);
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (0 != 0) {
            }
            throw th;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return zzarVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzaq zzy(String str) throws Throwable {
        Throwable th;
        Cursor cursorQuery;
        Preconditions.checkNotEmpty(str);
        zzg();
        zzay();
        Cursor cursor = null;
        try {
            cursorQuery = zze().query("apps", new String[]{"remote_config", "config_last_modified_time", "e_tag"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                try {
                    if (cursorQuery.moveToFirst()) {
                        byte[] blob = cursorQuery.getBlob(0);
                        String string = cursorQuery.getString(1);
                        String string2 = cursorQuery.getString(2);
                        if (cursorQuery.moveToNext()) {
                            this.zzu.zzaW().zzb().zzb("Got multiple records for app config, expected one. appId", zzgu.zzl(str));
                        }
                        if (blob != null) {
                            zzaq zzaqVar = new zzaq(blob, string, string2);
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            return zzaqVar;
                        }
                    }
                } catch (SQLiteException e) {
                    e = e;
                    this.zzu.zzaW().zzb().zzc("Error querying remote config. appId", zzgu.zzl(str), e);
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorQuery;
                if (cursor != null) {
                    throw th;
                }
                cursor.close();
                throw th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzz(com.google.android.gms.internal.measurement.zzid zzidVar, boolean z) {
        zzg();
        zzay();
        Preconditions.checkNotNull(zzidVar);
        Preconditions.checkNotEmpty(zzidVar.zzA());
        Preconditions.checkState(zzidVar.zzn());
        zzI();
        zzic zzicVar = this.zzu;
        long jCurrentTimeMillis = zzicVar.zzba().currentTimeMillis();
        long jZzo = zzidVar.zzo();
        zzicVar.zzc();
        if (jZzo >= jCurrentTimeMillis - zzal.zzI()) {
            long jZzo2 = zzidVar.zzo();
            zzicVar.zzc();
            if (jZzo2 > zzal.zzI() + jCurrentTimeMillis) {
                zzicVar.zzaW().zze().zzd("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzgu.zzl(zzidVar.zzA()), Long.valueOf(jCurrentTimeMillis), Long.valueOf(zzidVar.zzo()));
            }
        }
        try {
            byte[] bArrZzv = this.zzg.zzp().zzv(zzidVar.zzcd());
            zzic zzicVar2 = this.zzu;
            zzicVar2.zzaW().zzk().zzb("Saving bundle, size", Integer.valueOf(bArrZzv.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzidVar.zzA());
            contentValues.put("bundle_end_timestamp", Long.valueOf(zzidVar.zzo()));
            contentValues.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, bArrZzv);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (zzidVar.zzaa()) {
                contentValues.put("retry_count", Integer.valueOf(zzidVar.zzab()));
            }
            try {
                if (zze().insert("queue", null, contentValues) != -1) {
                    return true;
                }
                zzicVar2.zzaW().zzb().zzb("Failed to insert bundle (got -1). appId", zzgu.zzl(zzidVar.zzA()));
                return false;
            } catch (SQLiteException e) {
                this.zzu.zzaW().zzb().zzc("Error storing bundle. appId", zzgu.zzl(zzidVar.zzA()), e);
                return false;
            }
        } catch (IOException e2) {
            this.zzu.zzaW().zzb().zzc("Data loss. Failed to serialize bundle. appId", zzgu.zzl(zzidVar.zzA()), e2);
            return false;
        }
    }
}
