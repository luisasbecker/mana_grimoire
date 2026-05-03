package androidx.core.text;

import android.icu.util.ULocale;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class ICUCompat {
    private static final String TAG = "ICUCompat";
    private static Method sAddLikelySubtagsMethod;

    static class Api24Impl {
        private Api24Impl() {
        }

        static ULocale addLikelySubtags(Object obj) {
            return ULocale.addLikelySubtags((ULocale) obj);
        }

        static ULocale forLocale(Locale locale) {
            return ULocale.forLocale(locale);
        }

        static String getScript(Object obj) {
            return ((ULocale) obj).getScript();
        }
    }

    private ICUCompat() {
    }

    public static String maximizeAndGetScript(Locale locale) {
        return Api24Impl.getScript(Api24Impl.addLikelySubtags(Api24Impl.forLocale(locale)));
    }
}
