package com.google.android.play.core.assetpacks.internal;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class aq implements as {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f334a = new Object();
    private volatile as b;
    private volatile Object c = f334a;

    private aq(as asVar) {
        this.b = asVar;
    }

    public static as b(as asVar) {
        return asVar instanceof aq ? asVar : new aq(asVar);
    }

    public static aq c(as asVar) {
        return new aq(asVar);
    }

    private final synchronized Object d() {
        Object obj = this.c;
        Object obj2 = f334a;
        if (obj != obj2) {
            return obj;
        }
        Object objA = this.b.a();
        Object obj3 = this.c;
        if (obj3 != obj2 && obj3 != objA) {
            throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj3 + " & " + objA + ". This is likely due to a circular dependency.");
        }
        this.c = objA;
        this.b = null;
        return objA;
    }

    @Override // com.google.android.play.core.assetpacks.internal.aw, com.google.android.play.core.assetpacks.internal.av
    public final Object a() {
        Object obj = this.c;
        return obj == f334a ? d() : obj;
    }
}
