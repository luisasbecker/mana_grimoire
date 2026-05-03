package com.google.android.play.core.assetpacks;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class bv extends fj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f243a;
    private final long b;
    private final int c;
    private final boolean d;
    private final boolean e;
    private final byte[] f;

    bv(String str, long j, int i, boolean z, boolean z2, byte[] bArr) {
        this.f243a = str;
        this.b = j;
        this.c = i;
        this.d = z;
        this.e = z2;
        this.f = bArr;
    }

    @Override // com.google.android.play.core.assetpacks.fj
    final int a() {
        return this.c;
    }

    @Override // com.google.android.play.core.assetpacks.fj
    final long b() {
        return this.b;
    }

    @Override // com.google.android.play.core.assetpacks.fj
    final String c() {
        return this.f243a;
    }

    @Override // com.google.android.play.core.assetpacks.fj
    final boolean d() {
        return this.e;
    }

    @Override // com.google.android.play.core.assetpacks.fj
    final boolean e() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof fj) {
            fj fjVar = (fj) obj;
            String str = this.f243a;
            if (str != null ? str.equals(fjVar.c()) : fjVar.c() == null) {
                if (this.b == fjVar.b() && this.c == fjVar.a() && this.d == fjVar.e() && this.e == fjVar.d()) {
                    if (Arrays.equals(this.f, fjVar instanceof bv ? ((bv) fjVar).f : fjVar.f())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.play.core.assetpacks.fj
    final byte[] f() {
        return this.f;
    }

    public final int hashCode() {
        String str = this.f243a;
        int iHashCode = str == null ? 0 : str.hashCode();
        long j = this.b;
        int i = this.c;
        int i2 = true != this.d ? 1237 : 1231;
        int i3 = ((((iHashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ i;
        return Arrays.hashCode(this.f) ^ (((((i3 * 1000003) ^ i2) * 1000003) ^ (true == this.e ? 1231 : 1237)) * 1000003);
    }

    public final String toString() {
        return "ZipEntry{name=" + this.f243a + ", size=" + this.b + ", compressionMethod=" + this.c + ", isPartial=" + this.d + ", isEndOfArchive=" + this.e + ", headerBytes=" + Arrays.toString(this.f) + "}";
    }
}
