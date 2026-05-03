package com.google.android.play.core.assetpacks.internal;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class ap implements as {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private as f333a;

    public static void b(as asVar, as asVar2) {
        ap apVar = (ap) asVar;
        if (apVar.f333a != null) {
            throw new IllegalStateException();
        }
        apVar.f333a = asVar2;
    }

    @Override // com.google.android.play.core.assetpacks.internal.aw, com.google.android.play.core.assetpacks.internal.av
    public final Object a() {
        as asVar = this.f333a;
        if (asVar != null) {
            return asVar.a();
        }
        throw new IllegalStateException();
    }
}
