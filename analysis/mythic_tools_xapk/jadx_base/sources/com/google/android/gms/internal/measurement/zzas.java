package com.google.android.gms.internal.measurement;

import androidx.camera.video.AudioStats;
import androidx.collection.SieveCacheKt;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzas implements Iterable, zzao {
    private final String zza;

    public zzas(String str) {
        if (str == null) {
            throw new IllegalArgumentException("StringValue cannot be null.");
        }
        this.zza = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzas) {
            return this.zza.equals(((zzas) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new zzar(this);
    }

    public final String toString() {
        String str = this.zza;
        StringBuilder sb = new StringBuilder(str.length() + 2);
        sb.append("\"");
        sb.append(str);
        sb.append("\"");
        return sb.toString();
    }

    final /* synthetic */ String zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final String zzc() {
        return this.zza;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02d5 A[PHI: r5
      0x02d5: PHI (r5v8 boolean) = (r5v17 boolean), (r5v18 boolean), (r5v21 boolean) binds: [B:99:0x02c1, B:100:0x02c3, B:102:0x02d3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02df A[LOOP:0: B:107:0x02dd->B:108:0x02df, LOOP_END] */
    @Override // com.google.android.gms.internal.measurement.zzao
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzao zzcG(String str, zzg zzgVar, List list) {
        String str2;
        String str3;
        String strZzc;
        int i;
        zzas zzasVar;
        int i2;
        int i3;
        zzg zzgVar2;
        if ("charAt".equals(str) || "concat".equals(str) || "hasOwnProperty".equals(str) || "indexOf".equals(str) || "lastIndexOf".equals(str) || "match".equals(str) || "replace".equals(str) || FirebaseAnalytics.Event.SEARCH.equals(str) || "slice".equals(str) || "split".equals(str) || "substring".equals(str) || "toLowerCase".equals(str) || "toLocaleLowerCase".equals(str) || InAppPurchaseConstants.METHOD_TO_STRING.equals(str) || "toUpperCase".equals(str) || "toLocaleUpperCase".equals(str)) {
            str2 = "hasOwnProperty";
            str3 = "trim";
        } else {
            str2 = "hasOwnProperty";
            str3 = "trim";
            if (!str3.equals(str)) {
                throw new IllegalArgumentException(String.format("%s is not a String function", str));
            }
        }
        strZzc = "undefined";
        z = false;
        boolean z = false;
        switch (str.hashCode()) {
            case -1789698943:
                String str4 = str2;
                if (str.equals(str4)) {
                    zzh.zza(str4, 1, list);
                    String str5 = this.zza;
                    zzao zzaoVarZza = zzgVar.zza((zzao) list.get(0));
                    if ("length".equals(zzaoVarZza.zzc())) {
                        return zzaf.zzk;
                    }
                    double dDoubleValue = zzaoVarZza.zzd().doubleValue();
                    return (dDoubleValue != Math.floor(dDoubleValue) || (i = (int) dDoubleValue) < 0 || i >= str5.length()) ? zzaf.zzl : zzaf.zzk;
                }
                throw new IllegalArgumentException("Command not supported");
            case -1776922004:
                if (str.equals(InAppPurchaseConstants.METHOD_TO_STRING)) {
                    zzh.zza(InAppPurchaseConstants.METHOD_TO_STRING, 0, list);
                    return this;
                }
                throw new IllegalArgumentException("Command not supported");
            case -1464939364:
                if (str.equals("toLocaleLowerCase")) {
                    zzh.zza("toLocaleLowerCase", 0, list);
                    return new zzas(this.zza.toLowerCase());
                }
                throw new IllegalArgumentException("Command not supported");
            case -1361633751:
                if (str.equals("charAt")) {
                    zzh.zzc("charAt", 1, list);
                    int iZzi = list.isEmpty() ? 0 : (int) zzh.zzi(zzgVar.zza((zzao) list.get(0)).zzd().doubleValue());
                    String str6 = this.zza;
                    return (iZzi < 0 || iZzi >= str6.length()) ? zzao.zzm : new zzas(String.valueOf(str6.charAt(iZzi)));
                }
                throw new IllegalArgumentException("Command not supported");
            case -1354795244:
                zzasVar = this;
                if (str.equals("concat")) {
                    if (!list.isEmpty()) {
                        StringBuilder sb = new StringBuilder(zzasVar.zza);
                        for (int i4 = 0; i4 < list.size(); i4++) {
                            sb.append(zzgVar.zza((zzao) list.get(i4)).zzc());
                        }
                        return new zzas(sb.toString());
                    }
                    return zzasVar;
                }
                throw new IllegalArgumentException("Command not supported");
            case -1137582698:
                if (str.equals("toLowerCase")) {
                    zzh.zza("toLowerCase", 0, list);
                    return new zzas(this.zza.toLowerCase(Locale.ENGLISH));
                }
                throw new IllegalArgumentException("Command not supported");
            case -906336856:
                if (str.equals(FirebaseAnalytics.Event.SEARCH)) {
                    zzh.zzc(FirebaseAnalytics.Event.SEARCH, 1, list);
                    return Pattern.compile(list.isEmpty() ? "undefined" : zzgVar.zza((zzao) list.get(0)).zzc()).matcher(this.zza).find() ? new zzah(Double.valueOf(r0.start())) : new zzah(Double.valueOf(-1.0d));
                }
                throw new IllegalArgumentException("Command not supported");
            case -726908483:
                if (str.equals("toLocaleUpperCase")) {
                    zzh.zza("toLocaleUpperCase", 0, list);
                    return new zzas(this.zza.toUpperCase());
                }
                throw new IllegalArgumentException("Command not supported");
            case -467511597:
                if (str.equals("lastIndexOf")) {
                    zzh.zzc("lastIndexOf", 2, list);
                    String str7 = this.zza;
                    String strZzc2 = list.size() > 0 ? zzgVar.zza((zzao) list.get(0)).zzc() : "undefined";
                    return new zzah(Double.valueOf(str7.lastIndexOf(strZzc2, (int) (Double.isNaN(list.size() < 2 ? Double.NaN : zzgVar.zza((zzao) list.get(1)).zzd().doubleValue()) ? Double.POSITIVE_INFINITY : zzh.zzi(r3)))));
                }
                throw new IllegalArgumentException("Command not supported");
            case -399551817:
                if (str.equals("toUpperCase")) {
                    zzh.zza("toUpperCase", 0, list);
                    return new zzas(this.zza.toUpperCase(Locale.ENGLISH));
                }
                throw new IllegalArgumentException("Command not supported");
            case 3568674:
                if (str.equals(str3)) {
                    zzh.zza("toUpperCase", 0, list);
                    return new zzas(this.zza.trim());
                }
                throw new IllegalArgumentException("Command not supported");
            case 103668165:
                if (str.equals("match")) {
                    zzh.zzc("match", 1, list);
                    Matcher matcher = Pattern.compile(list.size() <= 0 ? "" : zzgVar.zza((zzao) list.get(0)).zzc()).matcher(this.zza);
                    return matcher.find() ? new zzae(Arrays.asList(new zzas(matcher.group()))) : zzao.zzg;
                }
                throw new IllegalArgumentException("Command not supported");
            case 109526418:
                if (str.equals("slice")) {
                    zzh.zzc("slice", 2, list);
                    String str8 = this.zza;
                    double dZzi = zzh.zzi(!list.isEmpty() ? zzgVar.zza((zzao) list.get(0)).zzd().doubleValue() : 0.0d);
                    double dMax = dZzi < AudioStats.AUDIO_AMPLITUDE_NONE ? Math.max(((double) str8.length()) + dZzi, AudioStats.AUDIO_AMPLITUDE_NONE) : Math.min(dZzi, str8.length());
                    double dZzi2 = zzh.zzi(list.size() > 1 ? zzgVar.zza((zzao) list.get(1)).zzd().doubleValue() : str8.length());
                    int i5 = (int) dMax;
                    return new zzas(str8.substring(i5, Math.max(0, ((int) (dZzi2 < AudioStats.AUDIO_AMPLITUDE_NONE ? Math.max(((double) str8.length()) + dZzi2, AudioStats.AUDIO_AMPLITUDE_NONE) : Math.min(dZzi2, str8.length()))) - i5) + i5));
                }
                throw new IllegalArgumentException("Command not supported");
            case 109648666:
                if (str.equals("split")) {
                    zzh.zzc("split", 2, list);
                    String str9 = this.zza;
                    if (str9.length() == 0) {
                        return new zzae(Arrays.asList(this));
                    }
                    ArrayList arrayList = new ArrayList();
                    if (list.isEmpty()) {
                        arrayList.add(this);
                    } else {
                        String strZzc3 = zzgVar.zza((zzao) list.get(0)).zzc();
                        long jZzh = list.size() > 1 ? zzh.zzh(zzgVar.zza((zzao) list.get(1)).zzd().doubleValue()) : SieveCacheKt.NodeLinkMask;
                        if (jZzh == 0) {
                            return new zzae();
                        }
                        String[] strArrSplit = str9.split(Pattern.quote(strZzc3), ((int) jZzh) + 1);
                        int length = strArrSplit.length;
                        if (!strZzc3.isEmpty() || length <= 0) {
                            i2 = length;
                            i3 = z;
                            if (length > jZzh) {
                                i2--;
                            }
                            while (i3 < i2) {
                                arrayList.add(new zzas(strArrSplit[i3]));
                                i3++;
                            }
                        } else {
                            boolean zIsEmpty = strArrSplit[0].isEmpty();
                            i2 = length - 1;
                            i3 = zIsEmpty;
                            z = zIsEmpty;
                            if (!strArrSplit[i2].isEmpty()) {
                            }
                            if (length > jZzh) {
                            }
                            while (i3 < i2) {
                            }
                        }
                    }
                    return new zzae(arrayList);
                }
                throw new IllegalArgumentException("Command not supported");
            case 530542161:
                if (str.equals("substring")) {
                    zzh.zzc("substring", 2, list);
                    String str10 = this.zza;
                    int iZzi2 = !list.isEmpty() ? (int) zzh.zzi(zzgVar.zza((zzao) list.get(0)).zzd().doubleValue()) : 0;
                    int iZzi3 = list.size() > 1 ? (int) zzh.zzi(zzgVar.zza((zzao) list.get(1)).zzd().doubleValue()) : str10.length();
                    int iMin = Math.min(Math.max(iZzi2, 0), str10.length());
                    int iMin2 = Math.min(Math.max(iZzi3, 0), str10.length());
                    return new zzas(str10.substring(Math.min(iMin, iMin2), Math.max(iMin, iMin2)));
                }
                throw new IllegalArgumentException("Command not supported");
            case 1094496948:
                zzasVar = this;
                if (str.equals("replace")) {
                    zzh.zzc("replace", 2, list);
                    zzao zzaoVarZza2 = zzao.zzf;
                    if (!list.isEmpty()) {
                        strZzc = zzgVar.zza((zzao) list.get(0)).zzc();
                        if (list.size() > 1) {
                            zzaoVarZza2 = zzgVar.zza((zzao) list.get(1));
                        }
                    }
                    String str11 = strZzc;
                    String str12 = zzasVar.zza;
                    int iIndexOf = str12.indexOf(str11);
                    if (iIndexOf >= 0) {
                        if (zzaoVarZza2 instanceof zzai) {
                            zzaoVarZza2 = ((zzai) zzaoVarZza2).zza(zzgVar, Arrays.asList(new zzas(str11), new zzah(Double.valueOf(iIndexOf)), zzasVar));
                        }
                        String strSubstring = str12.substring(0, iIndexOf);
                        String strZzc4 = zzaoVarZza2.zzc();
                        String strSubstring2 = str12.substring(iIndexOf + str11.length());
                        StringBuilder sb2 = new StringBuilder(String.valueOf(strSubstring).length() + String.valueOf(strZzc4).length() + String.valueOf(strSubstring2).length());
                        sb2.append(strSubstring);
                        sb2.append(strZzc4);
                        sb2.append(strSubstring2);
                        return new zzas(sb2.toString());
                    }
                    return zzasVar;
                }
                throw new IllegalArgumentException("Command not supported");
            case 1943291465:
                if (str.equals("indexOf")) {
                    zzh.zzc("indexOf", 2, list);
                    String str13 = this.zza;
                    if (list.size() <= 0) {
                        zzgVar2 = zzgVar;
                    } else {
                        zzgVar2 = zzgVar;
                        strZzc = zzgVar2.zza((zzao) list.get(0)).zzc();
                    }
                    return new zzah(Double.valueOf(str13.indexOf(strZzc, (int) zzh.zzi(list.size() < 2 ? 0.0d : zzgVar2.zza((zzao) list.get(1)).zzd().doubleValue()))));
                }
                throw new IllegalArgumentException("Command not supported");
            default:
                throw new IllegalArgumentException("Command not supported");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Double zzd() {
        String str = this.zza;
        if (str.isEmpty()) {
            return Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        }
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException unused) {
            return Double.valueOf(Double.NaN);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Boolean zze() {
        return Boolean.valueOf(!this.zza.isEmpty());
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Iterator zzf() {
        return new zzaq(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final zzao zzt() {
        return new zzas(this.zza);
    }
}
