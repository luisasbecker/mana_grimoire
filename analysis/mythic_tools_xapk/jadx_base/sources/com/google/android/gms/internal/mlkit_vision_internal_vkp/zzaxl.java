package com.google.android.gms.internal.mlkit_vision_internal_vkp;

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

/* JADX INFO: compiled from: com.google.mlkit:vision-internal-vkp@@18.2.3 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaxl {
    private static final Object zza;
    private final Context zzb;

    static {
        Component.builder(zzaxl.class).add(Dependency.required((Class<?>) Context.class)).factory(new ComponentFactory() { // from class: com.google.android.gms.internal.mlkit_vision_internal_vkp.zzaxk
            @Override // com.google.firebase.components.ComponentFactory
            public final Object create(ComponentContainer componentContainer) {
                return new zzaxl((Context) componentContainer.get(Context.class));
            }
        }).build();
        zza = new Object();
    }

    public zzaxl(Context context) {
        this.zzb = context;
    }

    public final zzaxm zza(zzaxi zzaxiVar) {
        zzaxm zzaxmVar;
        zzaxm zzaxmVar2;
        zzaeo zzaeoVar;
        zzaxc zzaxcVar;
        String strZze;
        String strZze2;
        long jZzc;
        synchronized (zza) {
            File fileZzb = zzb(zzaxiVar);
            try {
                String str = new String(new AtomicFile(fileZzb).readFully(), Charset.forName(Key.STRING_CHARSET_NAME));
                try {
                    zzael zzaelVarZzb = zzaeq.zzb(str);
                    if (zzaelVarZzb instanceof zzaeo) {
                        zzaeo zzaeoVarZzb = zzaelVarZzb.zzb();
                        try {
                            zzaxcVar = new zzaxc(zzaeoVarZzb.zzc("fid").zze());
                            strZze = zzaeoVarZzb.zzc("refreshToken").zze();
                            strZze2 = zzaeoVarZzb.zzc("temporaryToken").zze();
                            zzaxmVar = null;
                            try {
                                jZzc = zzaeoVarZzb.zzc("temporaryTokenExpiryTimestamp").zzc();
                                zzaeoVar = zzaeoVarZzb;
                            } catch (ClassCastException | IllegalStateException | NullPointerException e) {
                                e = e;
                                zzaeoVar = zzaeoVarZzb;
                            }
                        } catch (ClassCastException | IllegalStateException | NullPointerException e2) {
                            e = e2;
                            zzaeoVar = zzaeoVarZzb;
                            zzaxmVar = null;
                        }
                        try {
                            Log.d("MLKitInstallationIdSaver", "fid: " + zzaxcVar.toString());
                            Log.d("MLKitInstallationIdSaver", "refresh_token: " + strZze);
                            Log.d("MLKitInstallationIdSaver", "temporary_token: " + strZze2);
                            Log.d("MLKitInstallationIdSaver", "temporary token expiry: " + jZzc);
                            zzaxmVar2 = new zzaxm(zzaxcVar, strZze, strZze2, jZzc);
                        } catch (ClassCastException e3) {
                            e = e3;
                            zzaxiVar.zzc(zzave.FILE_READ_RETURNED_INVALID_DATA);
                            Log.e("MLKitInstallationIdSaver", "Error traversing installation info JSON object:\nraw json:\n" + str + "\nparsed json:\n" + zzaeoVar.toString(), e);
                            zzaxmVar2 = zzaxmVar;
                        } catch (IllegalStateException e4) {
                            e = e4;
                            zzaxiVar.zzc(zzave.FILE_READ_RETURNED_INVALID_DATA);
                            Log.e("MLKitInstallationIdSaver", "Error traversing installation info JSON object:\nraw json:\n" + str + "\nparsed json:\n" + zzaeoVar.toString(), e);
                            zzaxmVar2 = zzaxmVar;
                        } catch (NullPointerException e5) {
                            e = e5;
                            zzaxiVar.zzc(zzave.FILE_READ_RETURNED_INVALID_DATA);
                            Log.e("MLKitInstallationIdSaver", "Error traversing installation info JSON object:\nraw json:\n" + str + "\nparsed json:\n" + zzaeoVar.toString(), e);
                            zzaxmVar2 = zzaxmVar;
                        }
                    } else {
                        Log.e("MLKitInstallationIdSaver", "Error parsing installation info JSON element:\n".concat(String.valueOf(String.valueOf(zzaelVarZzb))));
                        zzaxiVar.zzc(zzave.FILE_READ_RETURNED_MALFORMED_DATA);
                        zzaxmVar2 = null;
                    }
                } catch (zzaes e6) {
                    zzaxmVar = null;
                    Log.e("MLKitInstallationIdSaver", "Error parsing installation info JSON object:\n".concat(str), e6);
                    zzaxiVar.zzc(zzave.FILE_READ_RETURNED_MALFORMED_DATA);
                }
            } catch (IOException e7) {
                if (!fileZzb.exists()) {
                    Log.i("MLKitInstallationIdSaver", "Installation id file not yet present: " + fileZzb.toString());
                    return null;
                }
                zzaxiVar.zzc(zzave.FILE_READ_FAILED);
                Log.w("MLKitInstallationIdSaver", "Error reading installation id file: " + fileZzb.toString(), e7);
                return null;
            }
        }
        return zzaxmVar2;
    }

    final File zzb(zzaxi zzaxiVar) {
        File noBackupFilesDir = ContextCompat.getNoBackupFilesDir(this.zzb);
        if (noBackupFilesDir == null || !noBackupFilesDir.isDirectory()) {
            Log.w("MLKitInstallationIdSaver", "noBackupFilesDir doesn't exist, using regular files directory instead");
            noBackupFilesDir = this.zzb.getFilesDir();
            if (noBackupFilesDir != null && !noBackupFilesDir.isDirectory()) {
                try {
                    if (!noBackupFilesDir.mkdirs()) {
                        Log.w("MLKitInstallationIdSaver", "mkdirs failed: " + noBackupFilesDir.toString());
                        zzaxiVar.zzd(zzave.DIRECTORY_CREATION_FAILED);
                    }
                } catch (SecurityException e) {
                    Log.w("MLKitInstallationIdSaver", "mkdirs threw an exception: ".concat(noBackupFilesDir.toString()), e);
                    zzaxiVar.zzd(zzave.DIRECTORY_CREATION_FAILED);
                }
            }
        }
        return new File(noBackupFilesDir, "com.google.mlkit.InstallationId");
    }

    public final void zzc(zzaxm zzaxmVar, zzaxi zzaxiVar) {
        File fileZzb;
        String str = String.format("{\n \"fid\": \"%s\",\n \"refreshToken\": \"%s\",\n \"temporaryToken\": \"%s\",\n \"temporaryTokenExpiryTimestamp\": \"%d\"\n}\n", zzaxmVar.zzb().zza(), zzaxmVar.zzc(), zzaxmVar.zzd(), Long.valueOf(zzaxmVar.zza()));
        synchronized (zza) {
            try {
                fileZzb = zzb(zzaxiVar);
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
                zzaxiVar.zzc(zzave.FILE_WRITE_FAILED);
                Log.e("MLKitInstallationIdSaver", "Error writing to installation id file " + String.valueOf(fileZzb), e);
            }
        }
    }
}
