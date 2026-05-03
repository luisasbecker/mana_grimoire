package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FontUtils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/studiolaganne/lengendarylens/FontUtils;", "", "<init>", "()V", "getFont", "Landroid/graphics/Typeface;", "context", "Landroid/content/Context;", "fontName", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FontUtils {
    public static final int $stable = 0;
    public static final FontUtils INSTANCE = new FontUtils();

    private FontUtils() {
    }

    public final Typeface getFont(Context context, String fontName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fontName, "fontName");
        return ResourcesCompat.getFont(context, context.getResources().getIdentifier(fontName, "font", context.getPackageName()));
    }
}
