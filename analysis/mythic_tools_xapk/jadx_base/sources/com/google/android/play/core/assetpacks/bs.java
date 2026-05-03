package com.google.android.play.core.assetpacks;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
final class bs extends AssetPackState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f240a;
    private final int b;
    private final int c;
    private final long d;
    private final long e;
    private final int f;
    private final int g;
    private final String h;
    private final String i;

    bs(String str, int i, int i2, long j, long j2, int i3, int i4, String str2, String str3) {
        if (str == null) {
            throw new NullPointerException("Null name");
        }
        this.f240a = str;
        this.b = i;
        this.c = i2;
        this.d = j;
        this.e = j2;
        this.f = i3;
        this.g = i4;
        if (str2 == null) {
            throw new NullPointerException("Null availableVersionTag");
        }
        this.h = str2;
        if (str3 == null) {
            throw new NullPointerException("Null installedVersionTag");
        }
        this.i = str3;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final String availableVersionTag() {
        return this.h;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final long bytesDownloaded() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssetPackState) {
            AssetPackState assetPackState = (AssetPackState) obj;
            if (this.f240a.equals(assetPackState.name()) && this.b == assetPackState.status() && this.c == assetPackState.errorCode() && this.d == assetPackState.bytesDownloaded() && this.e == assetPackState.totalBytesToDownload() && this.f == assetPackState.transferProgressPercentage() && this.g == assetPackState.updateAvailability() && this.h.equals(assetPackState.availableVersionTag()) && this.i.equals(assetPackState.installedVersionTag())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final int errorCode() {
        return this.c;
    }

    public final int hashCode() {
        int iHashCode = this.f240a.hashCode() ^ 1000003;
        long j = this.e;
        String str = this.h;
        long j2 = this.d;
        int iHashCode2 = (((((((((((((iHashCode * 1000003) ^ this.b) * 1000003) ^ this.c) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ this.f) * 1000003) ^ this.g) * 1000003) ^ str.hashCode();
        return this.i.hashCode() ^ (iHashCode2 * 1000003);
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final String installedVersionTag() {
        return this.i;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final String name() {
        return this.f240a;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final int status() {
        return this.b;
    }

    public final String toString() {
        return "AssetPackState{name=" + this.f240a + ", status=" + this.b + ", errorCode=" + this.c + ", bytesDownloaded=" + this.d + ", totalBytesToDownload=" + this.e + ", transferProgressPercentage=" + this.f + ", updateAvailability=" + this.g + ", availableVersionTag=" + this.h + ", installedVersionTag=" + this.i + "}";
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final long totalBytesToDownload() {
        return this.e;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final int transferProgressPercentage() {
        return this.f;
    }

    @Override // com.google.android.play.core.assetpacks.AssetPackState
    public final int updateAvailability() {
        return this.g;
    }
}
