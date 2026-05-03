package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.messaging.Constants;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzau {
    final /* synthetic */ zzaw zza;
    private final String zzb;
    private long zzc;

    public zzau(zzaw zzawVar, String str) {
        Objects.requireNonNull(zzawVar);
        this.zza = zzawVar;
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
        this.zzc = -1L;
    }

    public zzau(zzaw zzawVar, String str, long j) {
        Objects.requireNonNull(zzawVar);
        this.zza = zzawVar;
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
        this.zzc = zzawVar.zzaj("select rowid from raw_events where app_id = ? and timestamp < ? order by rowid desc limit 1", new String[]{str, String.valueOf(j)}, -1L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0112  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List zza() throws Throwable {
        Cursor cursor;
        Cursor cursorQuery;
        List arrayList = new ArrayList();
        int i = 0;
        try {
            int i2 = 3;
            cursorQuery = this.zza.zze().query("raw_events", new String[]{"rowid", "name", DiagnosticsEntry.TIMESTAMP_KEY, "metadata_fingerprint", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "realtime", "elapsed_time"}, "app_id = ? and rowid > ?", new String[]{this.zzb, String.valueOf(this.zzc)}, null, null, "rowid", "1000");
            try {
                if (cursorQuery.moveToFirst()) {
                    while (true) {
                        long j = cursorQuery.getLong(i);
                        long j2 = cursorQuery.getLong(i2);
                        boolean z = cursorQuery.getLong(5) == 1 ? 1 : i;
                        long j3 = cursorQuery.getLong(6);
                        byte[] blob = cursorQuery.getBlob(4);
                        if (j > this.zzc) {
                            this.zzc = j;
                        }
                        try {
                            com.google.android.gms.internal.measurement.zzhr zzhrVar = (com.google.android.gms.internal.measurement.zzhr) zzpk.zzw(com.google.android.gms.internal.measurement.zzhs.zzp(), blob);
                            String string = cursorQuery.getString(1);
                            if (string == null) {
                                string = "";
                            }
                            zzhrVar.zzl(string);
                            zzhrVar.zzo(cursorQuery.getLong(2));
                            zzhrVar.zzw(j3);
                            arrayList.add(new zzat(j, j2, z, (com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbd()));
                        } catch (IOException e) {
                            this.zza.zzu.zzaW().zzb().zzc("Data loss. Failed to merge raw event. appId", zzgu.zzl(this.zzb), e);
                        }
                        if (!cursorQuery.moveToNext()) {
                            break;
                        }
                        i = 0;
                        i2 = 3;
                    }
                } else {
                    arrayList = Collections.emptyList();
                }
            } catch (SQLiteException e2) {
                e = e2;
                cursor = cursorQuery;
                try {
                    this.zza.zzu.zzaW().zzb().zzc("Data loss. Error querying raw events batch. appId", zzgu.zzl(this.zzb), e);
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
        } catch (SQLiteException e3) {
            e = e3;
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
}
