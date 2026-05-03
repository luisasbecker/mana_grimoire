package com.studiolaganne.lengendarylens;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MTGBorderColorDetector.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"extractBorderColorFromCard", "Lcom/studiolaganne/lengendarylens/BorderColorResult;", "cardBitmap", "Landroid/graphics/Bitmap;", "cleanupBorderDetector", "", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class MTGBorderColorDetectorKt {
    public static final void cleanupBorderDetector() {
        MTGBorderColorDetector.INSTANCE.cleanup();
    }

    public static final BorderColorResult extractBorderColorFromCard(Bitmap cardBitmap) {
        Intrinsics.checkNotNullParameter(cardBitmap, "cardBitmap");
        return new MTGBorderColorDetector().detectBorderColor(cardBitmap);
    }
}
