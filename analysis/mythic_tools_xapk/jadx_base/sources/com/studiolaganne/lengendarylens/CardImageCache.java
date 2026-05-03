package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CardImageCache.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J \u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eJ&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/studiolaganne/lengendarylens/CardImageCache;", "", "<init>", "()V", "PREFS_NAME", "", "KEY_PREFIX", "getSharedPreferences", "Landroid/content/SharedPreferences;", "context", "Landroid/content/Context;", "getImageUrl", "cardId", OptionalModuleUtils.FACE, "", "saveImageUrl", "", "imageUrl", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CardImageCache {
    public static final int $stable = 0;
    public static final CardImageCache INSTANCE = new CardImageCache();
    private static final String KEY_PREFIX = "card_image_";
    private static final String PREFS_NAME = "card_image_cache";

    private CardImageCache() {
    }

    private final SharedPreferences getSharedPreferences(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(PREFS_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        return sharedPreferences;
    }

    public final String getImageUrl(Context context, String cardId, int face) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cardId, "cardId");
        return getSharedPreferences(context).getString(KEY_PREFIX + cardId + "_" + face, null);
    }

    public final void saveImageUrl(Context context, String cardId, String imageUrl, int face) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cardId, "cardId");
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        getSharedPreferences(context).edit().putString(KEY_PREFIX + cardId + "_" + face, imageUrl).apply();
    }
}
