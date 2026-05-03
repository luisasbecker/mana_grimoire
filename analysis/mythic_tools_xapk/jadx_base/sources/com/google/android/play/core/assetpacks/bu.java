package com.google.android.play.core.assetpacks;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class bu extends fc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f242a;
    private final String b;
    private final long c;
    private final long d;
    private final int e;

    bu(int i, String str, long j, long j2, int i2) {
        this.f242a = i;
        this.b = str;
        this.c = j;
        this.d = j2;
        this.e = i2;
    }

    @Override // com.google.android.play.core.assetpacks.fc
    final int a() {
        return this.f242a;
    }

    @Override // com.google.android.play.core.assetpacks.fc
    final int b() {
        return this.e;
    }

    @Override // com.google.android.play.core.assetpacks.fc
    final long c() {
        return this.c;
    }

    @Override // com.google.android.play.core.assetpacks.fc
    final long d() {
        return this.d;
    }

    @Override // com.google.android.play.core.assetpacks.fc
    final String e() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof fc) {
            fc fcVar = (fc) obj;
            if (this.f242a == fcVar.a() && ((str = this.b) != null ? str.equals(fcVar.e()) : fcVar.e() == null) && this.c == fcVar.c() && this.d == fcVar.d() && this.e == fcVar.b()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.b;
        int iHashCode = str == null ? 0 : str.hashCode();
        int i = this.f242a;
        long j = this.c;
        long j2 = this.d;
        return this.e ^ ((((((iHashCode ^ ((i ^ 1000003) * 1000003)) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003);
    }

    public final String toString() {
        return "SliceCheckpoint{fileExtractionStatus=" + this.f242a + ", filePath=" + this.b + ", fileOffset=" + this.c + ", remainingBytes=" + this.d + ", previousChunk=" + this.e + "}";
    }
}
