package com.google.android.play.core.assetpacks;

/* JADX INFO: compiled from: com.google.android.play:asset-delivery@@2.3.0 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AssetPackLocation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f209a = 0;
    private static final AssetPackLocation b = new br(1, null, null);

    public static AssetPackLocation a() {
        return b;
    }

    public abstract String assetsPath();

    public abstract int packStorageMethod();

    public abstract String path();
}
