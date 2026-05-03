package com.google.android.play.core.assetpacks;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class bt extends AssetPackStates {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f241a;
    private final Map b;

    bt(long j, Map map) {
        this.f241a = j;
        this.b = map;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssetPackStates) {
            AssetPackStates assetPackStates = (AssetPackStates) obj;
            if (this.f241a == assetPackStates.totalBytes() && this.b.equals(assetPackStates.packStates())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.f241a;
        return this.b.hashCode() ^ ((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003);
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackStates
    public final Map<String, AssetPackState> packStates() {
        return this.b;
    }

    public final String toString() {
        return "AssetPackStates{totalBytes=" + this.f241a + ", packStates=" + this.b.toString() + "}";
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackStates
    public final long totalBytes() {
        return this.f241a;
    }
}
