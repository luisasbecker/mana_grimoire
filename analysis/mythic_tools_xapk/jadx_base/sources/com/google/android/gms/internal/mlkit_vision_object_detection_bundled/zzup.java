package com.google.android.gms.internal.mlkit_vision_object_detection_bundled;

import android.content.Context;
import android.util.Log;
import androidx.core.content.ContextCompat;
import androidx.core.util.AtomicFile;
import com.bumptech.glide.load.Key;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Dependency;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: com.google.mlkit:object-detection@@17.0.2 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzup {
    private static final Object zza;
    private final Context zzb;

    static {
        Component.builder(zzup.class).add(Dependency.required((Class<?>) Context.class)).factory(new ComponentFactory() { // from class: com.google.android.gms.internal.mlkit_vision_object_detection_bundled.zzuo
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return new zzup((Context) componentContainer.get(Context.class));
            }
        }).build();
        zza = new Object();
    }

    public zzup(Context context) {
        this.zzb = context;
    }

    public final zzuq zza(zzum zzumVar) {
        zzuq zzuqVar;
        zzuq zzuqVar2;
        zzck zzckVar;
        zzuf zzufVar;
        String strZze;
        String strZze2;
        long jZzc;
        synchronized (zza) {
            File fileZzb = zzb(zzumVar);
            try {
                String str = new String(new AtomicFile(fileZzb).readFully(), Charset.forName(Key.STRING_CHARSET_NAME));
                try {
                    zzch zzchVarZzb = zzcm.zzb(str);
                    if (zzchVarZzb instanceof zzck) {
                        zzck zzckVarZzb = zzchVarZzb.zzb();
                        try {
                            zzufVar = new zzuf(zzckVarZzb.zzc("fid").zze());
                            strZze = zzckVarZzb.zzc("refreshToken").zze();
                            strZze2 = zzckVarZzb.zzc("temporaryToken").zze();
                            zzuqVar = null;
                            try {
                                jZzc = zzckVarZzb.zzc("temporaryTokenExpiryTimestamp").zzc();
                                zzckVar = zzckVarZzb;
                            } catch (ClassCastException | IllegalStateException | NullPointerException e) {
                                e = e;
                                zzckVar = zzckVarZzb;
                            }
                        } catch (ClassCastException | IllegalStateException | NullPointerException e2) {
                            e = e2;
                            zzckVar = zzckVarZzb;
                            zzuqVar = null;
                        }
                        try {
                            Log.d("MLKitInstallationIdSaver", "fid: " + zzufVar.toString());
                            Log.d("MLKitInstallationIdSaver", "refresh_token: " + strZze);
                            Log.d("MLKitInstallationIdSaver", "temporary_token: " + strZze2);
                            Log.d("MLKitInstallationIdSaver", "temporary token expiry: " + jZzc);
                            zzuqVar2 = new zzuq(zzufVar, strZze, strZze2, jZzc);
                        } catch (ClassCastException e3) {
                            e = e3;
                            zzumVar.zzc(zzsw.FILE_READ_RETURNED_INVALID_DATA);
                            Log.e("MLKitInstallationIdSaver", "Error traversing installation info JSON object:\nraw json:\n" + str + "\nparsed json:\n" + zzckVar.toString(), e);
                            zzuqVar2 = zzuqVar;
                        } catch (IllegalStateException e4) {
                            e = e4;
                            zzumVar.zzc(zzsw.FILE_READ_RETURNED_INVALID_DATA);
                            Log.e("MLKitInstallationIdSaver", "Error traversing installation info JSON object:\nraw json:\n" + str + "\nparsed json:\n" + zzckVar.toString(), e);
                            zzuqVar2 = zzuqVar;
                        } catch (NullPointerException e5) {
                            e = e5;
                            zzumVar.zzc(zzsw.FILE_READ_RETURNED_INVALID_DATA);
                            Log.e("MLKitInstallationIdSaver", "Error traversing installation info JSON object:\nraw json:\n" + str + "\nparsed json:\n" + zzckVar.toString(), e);
                            zzuqVar2 = zzuqVar;
                        }
                    } else {
                        Log.e("MLKitInstallationIdSaver", "Error parsing installation info JSON element:\n".concat(String.valueOf(String.valueOf(zzchVarZzb))));
                        zzumVar.zzc(zzsw.FILE_READ_RETURNED_MALFORMED_DATA);
                        zzuqVar2 = null;
                    }
                } catch (zzco e6) {
                    zzuqVar = null;
                    Log.e("MLKitInstallationIdSaver", "Error parsing installation info JSON object:\n".concat(str), e6);
                    zzumVar.zzc(zzsw.FILE_READ_RETURNED_MALFORMED_DATA);
                }
            } catch (IOException e7) {
                if (!fileZzb.exists()) {
                    Log.i("MLKitInstallationIdSaver", "Installation id file not yet present: " + fileZzb.toString());
                    return null;
                }
                zzumVar.zzc(zzsw.FILE_READ_FAILED);
                Log.w("MLKitInstallationIdSaver", "Error reading installation id file: " + fileZzb.toString(), e7);
                return null;
            }
        }
        return zzuqVar2;
    }

    final File zzb(zzum zzumVar) {
        File noBackupFilesDir = ContextCompat.getNoBackupFilesDir(this.zzb);
        if (noBackupFilesDir == null || !noBackupFilesDir.isDirectory()) {
            Log.w("MLKitInstallationIdSaver", "noBackupFilesDir doesn't exist, using regular files directory instead");
            noBackupFilesDir = this.zzb.getFilesDir();
            if (noBackupFilesDir != null && !noBackupFilesDir.isDirectory()) {
                try {
                    if (!noBackupFilesDir.mkdirs()) {
                        Log.w("MLKitInstallationIdSaver", "mkdirs failed: " + noBackupFilesDir.toString());
                        zzumVar.zzd(zzsw.DIRECTORY_CREATION_FAILED);
                    }
                } catch (SecurityException e) {
                    Log.w("MLKitInstallationIdSaver", "mkdirs threw an exception: ".concat(noBackupFilesDir.toString()), e);
                    zzumVar.zzd(zzsw.DIRECTORY_CREATION_FAILED);
                }
            }
        }
        return new File(noBackupFilesDir, "com.google.mlkit.InstallationId");
    }

    public final void zzc(zzuq zzuqVar, zzum zzumVar) {
        File fileZzb;
        String str = String.format("{\n \"fid\": \"%s\",\n \"refreshToken\": \"%s\",\n \"temporaryToken\": \"%s\",\n \"temporaryTokenExpiryTimestamp\": \"%d\"\n}\n", zzuqVar.zzb().zza(), zzuqVar.zzc(), zzuqVar.zzd(), Long.valueOf(zzuqVar.zza()));
        synchronized (zza) {
            try {
                fileZzb = zzb(zzumVar);
            } catch (IOException e) {
                e = e;
                fileZzb = null;
            }
            try {
                Log.i("MLKitInstallationIdSaver", "Creating installation id: " + fileZzb.toString());
                AtomicFile atomicFile = new AtomicFile(fileZzb);
                FileOutputStream fileOutputStreamStartWrite = atomicFile.startWrite();
                try {
                    PrintWriter printWriter = new PrintWriter(fileOutputStreamStartWrite);
                    printWriter.println(str);
                    printWriter.flush();
                    atomicFile.finishWrite(fileOutputStreamStartWrite);
                    Log.d("MLKitInstallationIdSaver", "Succeeded writing installation id: " + fileZzb.toString() + ":\n" + str);
                } catch (Throwable th) {
                    atomicFile.failWrite(fileOutputStreamStartWrite);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                zzumVar.zzc(zzsw.FILE_WRITE_FAILED);
                Log.e("MLKitInstallationIdSaver", "Error writing to installation id file " + String.valueOf(fileZzb), e);
            }
        }
    }
}
