package com.google.android.play.core.assetpacks;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class cz extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f266a;

    cz(String str) {
        super(str);
        this.f266a = -1;
    }

    cz(String str, int i) {
        super(str);
        this.f266a = i;
    }

    cz(String str, Exception exc) {
        super(str, exc);
        this.f266a = -1;
    }

    cz(String str, Exception exc, int i) {
        super(str, exc);
        this.f266a = i;
    }
}
