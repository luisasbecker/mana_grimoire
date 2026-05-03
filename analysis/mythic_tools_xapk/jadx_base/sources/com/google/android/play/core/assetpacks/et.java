package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.content.pm.PackageManager;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class et {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.google.android.play.core.assetpacks.internal.o f310a = new com.google.android.play.core.assetpacks.internal.o("PackageStateCache");
    private final Context b;
    private int c = -1;

    et(Context context) {
        this.b = context;
    }

    public final synchronized int a() {
        if (this.c == -1) {
            try {
                this.c = this.b.getPackageManager().getPackageInfo(this.b.getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException unused) {
                f310a.b("The current version of the app could not be retrieved", new Object[0]);
            }
        }
        return this.c;
    }
}
