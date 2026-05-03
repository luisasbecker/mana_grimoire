package com.google.android.play.core.assetpacks;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AssetPackState {
    public static AssetPackState a(String str, int i, int i2, long j, long j2, double d, int i3, String str2, String str3) {
        return new bs(str, i, i2, j, j2, (int) Math.rint(100.0d * d), i3, str2, str3);
    }

    static AssetPackState b(Bundle bundle, String str, dd ddVar, er erVar) {
        return c(bundle, str, ddVar, erVar, new bf() { // from class: com.google.android.play.core.assetpacks.be
            @Override // com.google.android.play.core.assetpacks.bf
            public final int a(int i, String str2) {
                return i;
            }
        });
    }

    static AssetPackState c(Bundle bundle, String str, dd ddVar, er erVar, bf bfVar) {
        int iA = bfVar.a(bundle.getInt(com.google.android.play.core.assetpacks.model.b.a("status", str)), str);
        int i = bundle.getInt(com.google.android.play.core.assetpacks.model.b.a("error_code", str));
        long j = bundle.getLong(com.google.android.play.core.assetpacks.model.b.a("bytes_downloaded", str));
        long j2 = bundle.getLong(com.google.android.play.core.assetpacks.model.b.a("total_bytes_to_download", str));
        double dA = ddVar.a(str);
        long j3 = bundle.getLong(com.google.android.play.core.assetpacks.model.b.a("pack_version", str));
        long j4 = bundle.getLong(com.google.android.play.core.assetpacks.model.b.a("pack_base_version", str));
        int i2 = 1;
        if (iA == 4) {
            if (j4 != 0 && j4 != j3) {
                i2 = 2;
            }
            iA = 4;
        }
        return a(str, iA, i, j, j2, dA, i2, bundle.getString(com.google.android.play.core.assetpacks.model.b.a("pack_version_tag", str), String.valueOf(bundle.getInt("app_version_code"))), erVar.a(str));
    }

    public abstract String availableVersionTag();

    public abstract long bytesDownloaded();

    public abstract int errorCode();

    public abstract String installedVersionTag();

    public abstract String name();

    public abstract int status();

    public abstract long totalBytesToDownload();

    public abstract int transferProgressPercentage();

    public abstract int updateAvailability();
}
