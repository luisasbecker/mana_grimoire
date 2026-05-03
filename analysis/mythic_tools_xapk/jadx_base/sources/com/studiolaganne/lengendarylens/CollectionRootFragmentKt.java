package com.studiolaganne.lengendarylens;

import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.text.NumberFormat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionRootFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"formatCurrency", "", "", AndroidContextPlugin.LOCALE_KEY, "Ljava/util/Locale;", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CollectionRootFragmentKt {
    public static final String formatCurrency(double d, Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        try {
            String str = NumberFormat.getCurrencyInstance(locale).format(d);
            Intrinsics.checkNotNull(str);
            return str;
        } catch (Exception unused) {
            return "--";
        }
    }
}
