package com.vanniktech.ui.view;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.vanniktech.ui.Color;
import com.vanniktech.ui.ColorKt;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ColorHexInputFilter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"inferColor", "Lcom/vanniktech/ui/Color;", TypedValues.Custom.S_STRING, "", "supportsAlpha", "", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ColorHexInputFilterKt {
    public static final Color inferColor(String string, boolean z) {
        Intrinsics.checkNotNullParameter(string, "string");
        Integer[] numArr = new Integer[4];
        numArr[0] = 3;
        num.intValue();
        numArr[1] = z ? 4 : null;
        numArr[2] = 6;
        num.intValue();
        numArr[3] = z ? 8 : null;
        Set of = SetsKt.setOf((Object[]) numArr);
        String strRemovePrefix = StringsKt.removePrefix(string, (CharSequence) ColorKt.HEX_PREFIX);
        Color colorM11390fromHexOrNullTUbRjns = Color.INSTANCE.m11390fromHexOrNullTUbRjns(strRemovePrefix);
        if (of.contains(Integer.valueOf(strRemovePrefix.length()))) {
            return colorM11390fromHexOrNullTUbRjns;
        }
        return null;
    }
}
