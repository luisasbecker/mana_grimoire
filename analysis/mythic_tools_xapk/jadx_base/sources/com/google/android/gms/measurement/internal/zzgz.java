package com.google.android.gms.measurement.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.codeless.internal.Constants;
import com.google.android.gms.common.internal.Preconditions;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgz extends zzos {
    public zzgz(zzpg zzpgVar) {
        super(zzpgVar);
    }

    public final boolean zzb() {
        zzay();
        ConnectivityManager connectivityManager = (ConnectivityManager) this.zzu.zzaZ().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = null;
        if (connectivityManager != null) {
            try {
                activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException unused) {
            }
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override // com.google.android.gms.measurement.internal.zzos
    protected final boolean zzbc() {
        return false;
    }

    public final void zzc(String str, zzot zzotVar, com.google.android.gms.internal.measurement.zzib zzibVar, zzgw zzgwVar) {
        zzgz zzgzVar;
        String str2;
        URL url;
        byte[] bArrZzcd;
        zzg();
        zzay();
        try {
            url = new URI(zzotVar.zza()).toURL();
            this.zzg.zzp();
            bArrZzcd = zzibVar.zzcd();
            zzgzVar = this;
            str2 = str;
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused) {
            zzgzVar = this;
            str2 = str;
        }
        try {
            this.zzu.zzaX().zzm(new zzgy(zzgzVar, str2, url, bArrZzcd, zzotVar.zzb(), zzgwVar));
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused2) {
            zzgzVar.zzu.zzaW().zzb().zzc("Failed to parse URL. Not uploading MeasurementBatch. appId", zzgu.zzl(str2), zzotVar.zza());
        }
    }

    public final void zzd(zzh zzhVar, Map map, zzgw zzgwVar) {
        zzgz zzgzVar;
        URL url;
        zzg();
        zzay();
        Preconditions.checkNotNull(zzhVar);
        Preconditions.checkNotNull(zzgwVar);
        zzou zzouVarZzf = this.zzg.zzf();
        Uri.Builder builder = new Uri.Builder();
        String strZzf = zzhVar.zzf();
        Uri.Builder builderEncodedAuthority = builder.scheme((String) zzfy.zze.zzb(null)).encodedAuthority((String) zzfy.zzf.zzb(null));
        String.valueOf(strZzf);
        Uri.Builder builderAppendQueryParameter = builderEncodedAuthority.path("config/app/".concat(String.valueOf(strZzf))).appendQueryParameter("platform", Constants.PLATFORM);
        zzouVarZzf.zzu.zzc().zzi();
        builderAppendQueryParameter.appendQueryParameter("gmp_version", String.valueOf(161000L)).appendQueryParameter("runtime_version", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        String string = builder.build().toString();
        try {
            url = new URI(string).toURL();
            zzgzVar = this;
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused) {
            zzgzVar = this;
        }
        try {
            this.zzu.zzaX().zzm(new zzgy(zzgzVar, zzhVar.zzc(), url, null, map, zzgwVar));
        } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused2) {
            zzgzVar.zzu.zzaW().zzb().zzc("Failed to parse config URL. Not fetching. appId", zzgu.zzl(zzhVar.zzc()), string);
        }
    }
}
