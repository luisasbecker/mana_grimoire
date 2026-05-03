package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.p002firebaseauthapi.zzaen;
import com.google.android.gms.internal.p002firebaseauthapi.zzajb;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbl {
    private static long zza = 3600000;
    private static final com.google.android.gms.internal.p002firebaseauthapi.zzah<String> zzb = com.google.android.gms.internal.p002firebaseauthapi.zzah.zza("firebaseAppName", "firebaseUserUid", "operation", "tenantId", "verifyAssertionRequest", "statusCode", "statusMessage", DiagnosticsEntry.TIMESTAMP_KEY);
    private static final zzbl zzc = new zzbl();
    private Task<AuthResult> zzd;
    private Task<String> zze;
    private long zzf = 0;

    private zzbl() {
    }

    public static void zza(Context context, Status status) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        editorEdit.putInt("statusCode", status.getStatusCode());
        editorEdit.putString("statusMessage", status.getStatusMessage());
        editorEdit.putLong(DiagnosticsEntry.TIMESTAMP_KEY, DefaultClock.getInstance().currentTimeMillis());
        editorEdit.commit();
    }

    public static void zza(Context context, zzajb zzajbVar, String str, String str2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        editorEdit.putString("verifyAssertionRequest", SafeParcelableSerializer.serializeToString(zzajbVar));
        editorEdit.putString("operation", str);
        editorEdit.putString("tenantId", str2);
        editorEdit.putLong(DiagnosticsEntry.TIMESTAMP_KEY, DefaultClock.getInstance().currentTimeMillis());
        editorEdit.commit();
    }

    public static void zza(Context context, FirebaseAuth firebaseAuth) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(firebaseAuth);
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        editorEdit.putString("firebaseAppName", firebaseAuth.getApp().getName());
        editorEdit.commit();
    }

    public static void zza(Context context, FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(firebaseAuth);
        Preconditions.checkNotNull(firebaseUser);
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        editorEdit.putString("firebaseAppName", firebaseAuth.getApp().getName());
        editorEdit.putString("firebaseUserUid", firebaseUser.getUid());
        editorEdit.commit();
    }

    public static void zza(Context context, String str, String str2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        editorEdit.putString("recaptchaToken", str);
        editorEdit.putString("operation", str2);
        editorEdit.putLong(DiagnosticsEntry.TIMESTAMP_KEY, DefaultClock.getInstance().currentTimeMillis());
        editorEdit.commit();
    }

    private static void zza(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        com.google.android.gms.internal.p002firebaseauthapi.zzah<String> zzahVar = zzb;
        int size = zzahVar.size();
        int i = 0;
        while (i < size) {
            String str = zzahVar.get(i);
            i++;
            editorEdit.remove(str);
        }
        editorEdit.commit();
    }

    public static zzbl zzc() {
        return zzc;
    }

    public final Task<AuthResult> zza() {
        if (DefaultClock.getInstance().currentTimeMillis() - this.zzf < zza) {
            return this.zzd;
        }
        return null;
    }

    public final void zza(Context context) {
        Preconditions.checkNotNull(context);
        zza(context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0));
        this.zzd = null;
        this.zzf = 0L;
    }

    public final void zza(FirebaseAuth firebaseAuth) {
        zzajb zzajbVar;
        String string;
        Preconditions.checkNotNull(firebaseAuth);
        SharedPreferences sharedPreferences = firebaseAuth.getApp().getApplicationContext().getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0);
        if (firebaseAuth.getApp().getName().equals(sharedPreferences.getString("firebaseAppName", ""))) {
            if (!sharedPreferences.contains("verifyAssertionRequest")) {
                if (sharedPreferences.contains("recaptchaToken")) {
                    String string2 = sharedPreferences.getString("recaptchaToken", "");
                    String string3 = sharedPreferences.getString("operation", "");
                    this.zzf = sharedPreferences.getLong(DiagnosticsEntry.TIMESTAMP_KEY, 0L);
                    string3.hashCode();
                    this.zze = string3.equals("com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA") ? Tasks.forResult(string2) : null;
                    zza(sharedPreferences);
                    return;
                }
                if (sharedPreferences.contains("statusCode")) {
                    Status status = new Status(sharedPreferences.getInt("statusCode", 17062), sharedPreferences.getString("statusMessage", ""));
                    this.zzf = sharedPreferences.getLong(DiagnosticsEntry.TIMESTAMP_KEY, 0L);
                    zza(sharedPreferences);
                    this.zzd = Tasks.forException(zzaen.zza(status));
                    return;
                }
                return;
            }
            zzajbVar = (zzajb) SafeParcelableSerializer.deserializeFromString(sharedPreferences.getString("verifyAssertionRequest", ""), zzajb.CREATOR);
            String string4 = sharedPreferences.getString("operation", "");
            String string5 = sharedPreferences.getString("tenantId", null);
            string = sharedPreferences.getString("firebaseUserUid", "");
            this.zzf = sharedPreferences.getLong(DiagnosticsEntry.TIMESTAMP_KEY, 0L);
            if (string5 != null) {
                firebaseAuth.setTenantId(string5);
                zzajbVar.zzb(string5);
            }
            string4.hashCode();
            switch (string4) {
                case "com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE":
                    if (!firebaseAuth.getCurrentUser().getUid().equals(string)) {
                        this.zzd = null;
                        break;
                    } else {
                        this.zzd = firebaseAuth.zzc(firebaseAuth.getCurrentUser(), com.google.firebase.auth.zze.zza(zzajbVar));
                        break;
                    }
                    break;
                case "com.google.firebase.auth.internal.NONGMSCORE_LINK":
                    if (!firebaseAuth.getCurrentUser().getUid().equals(string)) {
                        this.zzd = null;
                        break;
                    } else {
                        this.zzd = firebaseAuth.zza(firebaseAuth.getCurrentUser(), com.google.firebase.auth.zze.zza(zzajbVar));
                        break;
                    }
                    break;
                case "com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN":
                    this.zzd = firebaseAuth.signInWithCredential(com.google.firebase.auth.zze.zza(zzajbVar));
                    break;
                default:
                    this.zzd = null;
                    break;
            }
            zza(sharedPreferences);
        }
    }

    public final Task<String> zzb() {
        if (DefaultClock.getInstance().currentTimeMillis() - this.zzf < zza) {
            return this.zze;
        }
        return null;
    }
}
