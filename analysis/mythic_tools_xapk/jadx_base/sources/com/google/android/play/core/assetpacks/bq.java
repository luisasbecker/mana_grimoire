package com.google.android.play.core.assetpacks;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class bq extends AssetLocation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f239a;
    private final long b;
    private final long c;

    bq(String str, long j, long j2) {
        if (str == null) {
            throw new NullPointerException("Null path");
        }
        this.f239a = str;
        this.b = j;
        this.c = j2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssetLocation) {
            AssetLocation assetLocation = (AssetLocation) obj;
            if (this.f239a.equals(assetLocation.path()) && this.b == assetLocation.offset() && this.c == assetLocation.size()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.f239a.hashCode() ^ 1000003;
        long j = this.c;
        long j2 = j ^ (j >>> 32);
        long j3 = this.b;
        return ((((int) ((j3 >>> 32) ^ j3)) ^ (iHashCode * 1000003)) * 1000003) ^ ((int) j2);
    }

    @Override // com.google.android.play.core.assetpacks.AssetLocation
    public final long offset() {
        return this.b;
    }

    @Override // com.google.android.play.core.assetpacks.AssetLocation
    public final String path() {
        return this.f239a;
    }

    @Override // com.google.android.play.core.assetpacks.AssetLocation
    public final long size() {
        return this.c;
    }

    public final String toString() {
        return "AssetLocation{path=" + this.f239a + ", offset=" + this.b + ", size=" + this.c + "}";
    }
}
