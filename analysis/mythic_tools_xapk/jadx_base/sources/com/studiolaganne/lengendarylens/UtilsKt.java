package com.studiolaganne.lengendarylens;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.segment.analytics.kotlin.android.plugins.AndroidContextPlugin;
import java.text.Normalizer;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0018\u0010\u0004\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00050\u00062\u0006\u0010\u0007\u001a\u00020\u0001\u001a#\u0010\b\u001a\u0002H\t\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u00062\u0006\u0010\u0007\u001a\u00020\u0001¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"removeDiacritics", "", AndroidContextPlugin.LOCALE_KEY, "Ljava/util/Locale;", "measureTime", "", "Lkotlin/Function0;", ViewHierarchyConstants.TAG_KEY, "measureTimeForResult", ExifInterface.GPS_DIRECTION_TRUE, "(Lkotlin/jvm/functions/Function0;Ljava/lang/String;)Ljava/lang/Object;", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class UtilsKt {
    public static final void measureTime(Function0<Unit> function0, String tag) {
        Intrinsics.checkNotNullParameter(function0, "<this>");
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (!CombinedAnalyzerKt.getDEBUG_TIMING()) {
            function0.invoke();
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        function0.invoke();
        Log.d(CombinedAnalyzer.TAG, tag + " = " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
    }

    public static final <T> T measureTimeForResult(Function0<? extends T> function0, String tag) {
        Intrinsics.checkNotNullParameter(function0, "<this>");
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (!CombinedAnalyzerKt.getDEBUG_TIMING()) {
            return function0.invoke();
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        T tInvoke = function0.invoke();
        Log.d(CombinedAnalyzer.TAG, tag + " = " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
        return tInvoke;
    }

    public static final String removeDiacritics(String str, Locale locale) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        String strNormalize = Normalizer.normalize(str, Normalizer.Form.NFD);
        Intrinsics.checkNotNull(strNormalize);
        return new Regex("\\p{M}").replace(strNormalize, "");
    }
}
