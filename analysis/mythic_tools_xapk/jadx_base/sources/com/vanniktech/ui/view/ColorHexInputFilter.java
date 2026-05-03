package com.vanniktech.ui.view;

import android.text.InputFilter;
import android.text.Spanned;
import com.vanniktech.ui.Color;
import com.vanniktech.ui.ColorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ColorHexInputFilter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J:\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/vanniktech/ui/view/ColorHexInputFilter;", "Landroid/text/InputFilter;", "supportsAlpha", "", "<init>", "(Z)V", "filter", "", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ColorHexInputFilter implements InputFilter {
    private final boolean supportsAlpha;

    public ColorHexInputFilter(boolean z) {
        this.supportsAlpha = z;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(dest, "dest");
        int i = 0;
        String str = dest.subSequence(0, dstart).toString() + ((Object) source.subSequence(start, end)) + ((Object) dest.subSequence(dend, dest.length()));
        if (ColorHexInputFilterKt.inferColor(str, this.supportsAlpha) != null) {
            if (StringsKt.startsWith$default(str, ColorKt.HEX_PREFIX, false, 2, (Object) null)) {
                return StringsKt.removePrefix(str, (CharSequence) ColorKt.HEX_PREFIX);
            }
            return null;
        }
        int i2 = this.supportsAlpha ? 8 : 6;
        String str2 = str;
        while (true) {
            if (i < str2.length()) {
                if (!Color.INSTANCE.getHEX_DIGITS$ui_release().contains(Character.valueOf(str2.charAt(i)))) {
                    break;
                }
                i++;
            } else if (str.length() <= i2) {
                return null;
            }
        }
        return "";
    }
}
