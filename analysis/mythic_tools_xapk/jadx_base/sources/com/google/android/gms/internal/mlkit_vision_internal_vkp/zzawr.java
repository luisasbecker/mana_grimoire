package com.google.android.gms.internal.mlkit_vision_internal_vkp;

import android.content.Context;
import android.util.Log;
import androidx.core.content.ContextCompat;
import androidx.core.util.AtomicFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzawr {
    private static final Object zza = new Object();
    private final Context zzb;

    public zzawr(Context context) {
        this.zzb = context;
    }

    public final zzbhx zza(String str, String str2, String str3, int i, zzawy zzawyVar, long j) {
        File fileZzb;
        synchronized (zza) {
            try {
                try {
                    fileZzb = zzb(str, "com.google.perception", 2);
                    try {
                        byte[] fully = new AtomicFile(fileZzb).readFully();
                        if (fully == null) {
                            return null;
                        }
                        try {
                            zzawx zzawxVarZzd = zzawx.zzd(fully, zzbdv.zza());
                            if (!zzawxVarZzd.zzk()) {
                                Log.w("AccelerationAllowlistPersistence", "No persistence time in cached entry, discarding it");
                            } else if (System.currentTimeMillis() / 1000 <= zzawxVarZzd.zze().zzc() + j) {
                                if (zzawxVarZzd.zzg().equals(str2)) {
                                    return zzawxVarZzd.zzf();
                                }
                                Log.i("AccelerationAllowlistPersistence", "Different client library version, discarding cached content");
                                return null;
                            }
                            Log.i("AccelerationAllowlistPersistence", "Cache expired");
                            return null;
                        } catch (zzbew e) {
                            Log.e("AccelerationAllowlistPersistence", "Invalid cached data in file: " + fileZzb.toString(), e);
                            zzawyVar.zzc(zzags.FILE_READ_RETURNED_MALFORMED_DATA);
                            return null;
                        }
                    } catch (IOException e2) {
                        e = e2;
                        if (fileZzb == null) {
                            Log.w("AccelerationAllowlistPersistence", "Unable to access acceleration allowlist cache file: null", e);
                            zzawyVar.zzc(zzags.FILE_READ_FAILED);
                        } else if (fileZzb.exists()) {
                            Log.w("AccelerationAllowlistPersistence", "Error reading acceleration allowlist cache file: " + fileZzb.toString(), e);
                            zzawyVar.zzc(zzags.FILE_READ_FAILED);
                        } else {
                            Log.i("AccelerationAllowlistPersistence", "No acceleration allowlist cache file at: " + fileZzb.toString());
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                fileZzb = null;
            }
        }
    }

    final File zzb(String str, String str2, int i) throws IOException {
        String str3 = String.format("com.google.mlkit.AccelerationAllowList.%s.%s.%s", str, "com.google.perception", "NNAPI");
        File noBackupFilesDir = ContextCompat.getNoBackupFilesDir(this.zzb);
        if (noBackupFilesDir == null || !noBackupFilesDir.isDirectory()) {
            Log.w("AccelerationAllowlistPersistence", "noBackupFilesDir doesn't exist, using regular files directory instead");
            noBackupFilesDir = this.zzb.getFilesDir();
            if (!noBackupFilesDir.isDirectory()) {
                try {
                    if (!noBackupFilesDir.mkdirs()) {
                        Log.w("AccelerationAllowlistPersistence", "mkdirs failed: " + String.valueOf(noBackupFilesDir));
                        throw new IOException("Unable to create persistence dir " + String.valueOf(noBackupFilesDir));
                    }
                } catch (SecurityException e) {
                    Log.w("AccelerationAllowlistPersistence", "mkdirs threw an exception: ".concat(String.valueOf(String.valueOf(noBackupFilesDir))), e);
                    throw new IOException("Unable to create persistence dir ".concat(String.valueOf(String.valueOf(noBackupFilesDir))), e);
                }
            }
        }
        return new File(noBackupFilesDir, str3);
    }

    public final void zzc(zzbhx zzbhxVar, String str, String str2, String str3, int i, zzawy zzawyVar) {
        File fileZzb;
        zzaww zzawwVarZza = zzawx.zza();
        zzawwVarZza.zza(zzbhxVar);
        zzbha zzbhaVarZze = zzbhb.zze();
        zzbhaVarZze.zza(System.currentTimeMillis() / 1000);
        zzawwVarZza.zzc((zzbhb) zzbhaVarZze.zzv());
        zzawwVarZza.zzb(str2);
        zzawx zzawxVar = (zzawx) zzawwVarZza.zzv();
        synchronized (zza) {
            try {
                fileZzb = zzb(str, "com.google.perception", 2);
            } catch (IOException e) {
                e = e;
                fileZzb = null;
            }
            try {
                Log.i("AccelerationAllowlistPersistence", "Saving nnapi allowlist cache to: " + fileZzb.toString());
                AtomicFile atomicFile = new AtomicFile(fileZzb);
                FileOutputStream fileOutputStreamStartWrite = atomicFile.startWrite();
                try {
                    zzawxVar.zzv(fileOutputStreamStartWrite);
                    atomicFile.finishWrite(fileOutputStreamStartWrite);
                    Log.d("AccelerationAllowlistPersistence", "Succeeded storing allowlist to file " + fileZzb.toString());
                } catch (Throwable th) {
                    atomicFile.failWrite(fileOutputStreamStartWrite);
                    zzawyVar.zzc(zzags.FILE_WRITE_FAILED);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                Log.e("AccelerationAllowlistPersistence", "Error writing to nnapi allowlist cache file " + String.valueOf(fileZzb), e);
                zzawyVar.zzc(zzags.FILE_WRITE_FAILED);
            }
        }
    }
}
