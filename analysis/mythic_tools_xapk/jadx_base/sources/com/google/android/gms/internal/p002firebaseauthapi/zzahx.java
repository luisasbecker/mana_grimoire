package com.google.android.gms.internal.p002firebaseauthapi;

import com.bumptech.glide.load.Key;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzahx {
    public static long zza(String str) {
        zzahw zzahwVarZzb = zzb(str);
        return zzahwVarZzb.zza().longValue() - zzahwVarZzb.zzb().longValue();
    }

    private static zzahw zzb(String str) {
        Preconditions.checkNotEmpty(str);
        List<String> listZza = zzt.zza(FilenameUtils.EXTENSION_SEPARATOR).zza((CharSequence) str);
        if (listZza.size() < 2) {
            throw new RuntimeException("Invalid idToken " + str);
        }
        try {
            return zzahw.zza(new String(Base64Utils.decodeUrlSafeNoPadding(listZza.get(1)), Key.STRING_CHARSET_NAME));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Unable to decode token", e);
        }
    }
}
