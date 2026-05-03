package com.google.android.play.core.assetpacks;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class br extends AssetPackLocation {
    private final int b;
    private final String c;
    private final String d;

    br(int i, String str, String str2) {
        this.b = i;
        this.c = str;
        this.d = str2;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackLocation
    public final String assetsPath() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssetPackLocation) {
            AssetPackLocation assetPackLocation = (AssetPackLocation) obj;
            if (this.b == assetPackLocation.packStorageMethod() && ((str = this.c) != null ? str.equals(assetPackLocation.path()) : assetPackLocation.path() == null) && ((str2 = this.d) != null ? str2.equals(assetPackLocation.assetsPath()) : assetPackLocation.assetsPath() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.c;
        int iHashCode = str == null ? 0 : str.hashCode();
        int i = this.b;
        String str2 = this.d;
        return ((iHashCode ^ ((i ^ 1000003) * 1000003)) * 1000003) ^ (str2 != null ? str2.hashCode() : 0);
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackLocation
    public final int packStorageMethod() {
        return this.b;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackLocation
    public final String path() {
        return this.c;
    }

    public final String toString() {
        return "AssetPackLocation{packStorageMethod=" + this.b + ", path=" + this.c + ", assetsPath=" + this.d + "}";
    }
}
