package com.vanniktech.ui;

import kotlin.Metadata;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: Color.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006\"\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\"\u0014\u0010\u000b\u001a\u00020\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u000e\u0010\u000f\u001a\u00020\u0010X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"color", "Lcom/vanniktech/ui/Color;", "", "getColor", "(I)I", "", "(J)I", "COLOR_COMPONENT_RANGE", "Lkotlin/ranges/IntRange;", "getCOLOR_COMPONENT_RANGE", "()Lkotlin/ranges/IntRange;", "FLOAT_VALUE", "", "getFLOAT_VALUE", "()F", "HEX_PREFIX", "", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ColorKt {
    private static final IntRange COLOR_COMPONENT_RANGE = new IntRange(0, 255);
    private static final float FLOAT_VALUE;
    public static final String HEX_PREFIX = "#";

    static {
        FLOAT_VALUE = r0.getLast();
    }

    public static final IntRange getCOLOR_COMPONENT_RANGE() {
        return COLOR_COMPONENT_RANGE;
    }

    public static final int getColor(int i) {
        return Color.m11372constructorimpl(i);
    }

    public static final int getColor(long j) {
        return Color.m11372constructorimpl((int) j);
    }

    public static final float getFLOAT_VALUE() {
        return FLOAT_VALUE;
    }
}
