package com.google.android.play.core.assetpacks;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f267a;

    static synchronized a a(Context context) {
        if (f267a == null) {
            cm cmVar = new cm(null);
            cmVar.b(new p(com.google.android.play.core.assetpacks.internal.ag.a(context)));
            f267a = cmVar.a();
        }
        return f267a;
    }
}
