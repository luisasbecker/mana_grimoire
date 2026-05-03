package com.google.android.play.core.integrity;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.play:integrity@@1.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s f411a = this;
    private final com.google.android.play.integrity.internal.an b;
    private final com.google.android.play.integrity.internal.an c;
    private final com.google.android.play.integrity.internal.an d;
    private final com.google.android.play.integrity.internal.an e;
    private final com.google.android.play.integrity.internal.an f;

    /* synthetic */ s(Context context, r rVar) {
        com.google.android.play.integrity.internal.ak akVarB = com.google.android.play.integrity.internal.al.b(context);
        this.b = akVarB;
        com.google.android.play.integrity.internal.an anVarB = com.google.android.play.integrity.internal.aj.b(ac.f366a);
        this.c = anVarB;
        au auVar = new au(akVarB, l.f406a);
        this.d = auVar;
        com.google.android.play.integrity.internal.an anVarB2 = com.google.android.play.integrity.internal.aj.b(new al(akVarB, anVarB, auVar, l.f406a));
        this.e = anVarB2;
        this.f = com.google.android.play.integrity.internal.aj.b(new ab(anVarB2));
    }

    public final IntegrityManager a() {
        return (IntegrityManager) this.f.a();
    }
}
