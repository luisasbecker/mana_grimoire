package com.revenuecat.purchases.ui.revenuecatui.helpers;

import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.codec.language.Soundex;

/* JADX INFO: compiled from: LocaleHelpers.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"createLocaleFromString", "Ljava/util/Locale;", "localeString", "", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LocaleHelpersKt {
    public static final Locale createLocaleFromString(String localeString) {
        Intrinsics.checkNotNullParameter(localeString, "localeString");
        String str = localeString;
        if (!StringsKt.contains$default((CharSequence) str, Soundex.SILENT_MARKER, false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) str, '_', false, 2, (Object) null)) {
            return new Locale(localeString);
        }
        List listSplit$default = StringsKt.contains$default((CharSequence) str, Soundex.SILENT_MARKER, false, 2, (Object) null) ? StringsKt.split$default((CharSequence) str, new char[]{Soundex.SILENT_MARKER}, false, 2, 2, (Object) null) : StringsKt.split$default((CharSequence) str, new char[]{'_'}, false, 2, 2, (Object) null);
        return listSplit$default.size() >= 2 ? new Locale((String) listSplit$default.get(0), (String) listSplit$default.get(1)) : new Locale((String) listSplit$default.get(0));
    }
}
