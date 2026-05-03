package com.google.android.play.core.assetpacks;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class AssetPackManagerFactory {
    private AssetPackManagerFactory() {
    }

    public static synchronized AssetPackManager getInstance(Context context) {
        return d.a(context).a();
    }
}
