package com.google.android.play.core.assetpacks;

import android.content.Context;
import java.io.File;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class ee implements com.google.android.play.core.assetpacks.internal.as {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.play.core.assetpacks.internal.aw f296a;
    private final com.google.android.play.core.assetpacks.internal.aw b;
    private final com.google.android.play.core.assetpacks.internal.aw c;
    private final com.google.android.play.core.assetpacks.internal.aw d;
    private final com.google.android.play.core.assetpacks.internal.aw e;
    private final com.google.android.play.core.assetpacks.internal.aw f;
    private final com.google.android.play.core.assetpacks.internal.aw g;

    public ee(com.google.android.play.core.assetpacks.internal.aw awVar, com.google.android.play.core.assetpacks.internal.aw awVar2, com.google.android.play.core.assetpacks.internal.aw awVar3, com.google.android.play.core.assetpacks.internal.aw awVar4, com.google.android.play.core.assetpacks.internal.aw awVar5, com.google.android.play.core.assetpacks.internal.aw awVar6, com.google.android.play.core.assetpacks.internal.aw awVar7) {
        this.f296a = awVar;
        this.b = awVar2;
        this.c = awVar3;
        this.d = awVar4;
        this.e = awVar5;
        this.f = awVar6;
        this.g = awVar7;
    }

    @Override // com.google.android.play.core.assetpacks.internal.aw, com.google.android.play.core.assetpacks.internal.av
    public final /* bridge */ /* synthetic */ Object a() {
        String str = (String) this.f296a.a();
        Object objA = this.b.a();
        Object objA2 = this.c.a();
        Context contextB = ((u) this.d).b();
        Object objA3 = this.e.a();
        return new ed(str != null ? new File(contextB.getExternalFilesDir(null), str) : contextB.getExternalFilesDir(null), (bc) objA, (dd) objA2, contextB, (et) objA3, com.google.android.play.core.assetpacks.internal.aq.c(com.google.android.play.core.assetpacks.internal.au.a(this.f)), (er) this.g.a());
    }
}
