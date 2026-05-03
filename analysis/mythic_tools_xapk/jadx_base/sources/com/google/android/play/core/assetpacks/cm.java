package com.google.android.play.core.assetpacks;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class cm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private p f254a;

    private cm() {
        throw null;
    }

    /* synthetic */ cm(cn cnVar) {
    }

    public final a a() {
        p pVar = this.f254a;
        if (pVar != null) {
            return new cl(pVar, null);
        }
        throw new IllegalStateException(String.valueOf(p.class.getCanonicalName()).concat(" must be set"));
    }

    public final cm b(p pVar) {
        this.f254a = pVar;
        return this;
    }
}
