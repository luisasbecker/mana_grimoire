package com.vanniktech.ui.view;

import android.text.InputFilter;
import android.text.Spanned;
import com.vanniktech.ui.ColorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ColorComponentInputFilter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J<\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/vanniktech/ui/view/ColorComponentInputFilter;", "Landroid/text/InputFilter;", "<init>", "()V", "filter", "", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ColorComponentInputFilter implements InputFilter {
    public static final ColorComponentInputFilter INSTANCE = new ColorComponentInputFilter();

    private ColorComponentInputFilter() {
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        Intrinsics.checkNotNullParameter(source, "source");
        String string = new StringBuilder().append((Object) dest).append((Object) source.subSequence(start, end)).toString();
        IntRange color_component_range = ColorKt.getCOLOR_COMPONENT_RANGE();
        Integer intOrNull = StringsKt.toIntOrNull(string);
        if (intOrNull == null || !color_component_range.contains(intOrNull.intValue())) {
            return "";
        }
        return null;
    }
}
