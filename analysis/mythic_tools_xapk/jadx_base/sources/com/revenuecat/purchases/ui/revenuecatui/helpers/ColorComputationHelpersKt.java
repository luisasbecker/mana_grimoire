package com.revenuecat.purchases.ui.revenuecatui.helpers;

import androidx.compose.ui.graphics.Color;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ColorComputationHelpers.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0004\u001a<\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00032\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0003H\u0000\u001a\"\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0006H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u001a\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0006H\u0000ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a*\u0010\r\u001a\u0004\u0018\u00010\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u000f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"colorDistance", "", "color1", "Lkotlin/Triple;", "color2", "contrastRatio", "Landroidx/compose/ui/graphics/Color;", "contrastRatio--OWjLjI", "(JJ)D", "relativeLuminance", "color", "relativeLuminance-8_81llA", "(J)D", "selectColorWithBestContrast", "from", "", "againstColor", "selectColorWithBestContrast-4WTKRHQ", "(Ljava/util/List;J)Landroidx/compose/ui/graphics/Color;", "revenuecatui_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ColorComputationHelpersKt {
    public static final double colorDistance(Triple<Double, Double, Double> color1, Triple<Double, Double, Double> color2) {
        Intrinsics.checkNotNullParameter(color1, "color1");
        Intrinsics.checkNotNullParameter(color2, "color2");
        double dDoubleValue = color1.component1().doubleValue();
        double dDoubleValue2 = color1.component2().doubleValue();
        double dDoubleValue3 = color1.component3().doubleValue();
        return Math.sqrt(Math.pow(dDoubleValue - color2.component1().doubleValue(), 2.0d) + Math.pow(dDoubleValue2 - color2.component2().doubleValue(), 2.0d) + Math.pow(dDoubleValue3 - color2.component3().doubleValue(), 2.0d));
    }

    /* JADX INFO: renamed from: contrastRatio--OWjLjI, reason: not valid java name */
    public static final double m10846contrastRatioOWjLjI(long j, long j2) {
        double dM10847relativeLuminance8_81llA = m10847relativeLuminance8_81llA(j);
        double dM10847relativeLuminance8_81llA2 = m10847relativeLuminance8_81llA(j2);
        return (Math.max(dM10847relativeLuminance8_81llA, dM10847relativeLuminance8_81llA2) + 0.05d) / (Math.min(dM10847relativeLuminance8_81llA, dM10847relativeLuminance8_81llA2) + 0.05d);
    }

    /* JADX INFO: renamed from: relativeLuminance-8_81llA, reason: not valid java name */
    public static final double m10847relativeLuminance8_81llA(long j) {
        return (relativeLuminance_8_81llA$adjust(Color.m6331getRedimpl(j)) * 0.2126d) + (relativeLuminance_8_81llA$adjust(Color.m6330getGreenimpl(j)) * 0.7152d) + (relativeLuminance_8_81llA$adjust(Color.m6328getBlueimpl(j)) * 0.0722d);
    }

    private static final double relativeLuminance_8_81llA$adjust(float f) {
        return f <= 0.03928f ? ((double) f) / 12.92d : Math.pow((((double) f) + 0.055d) / 1.055d, 2.4d);
    }

    /* JADX INFO: renamed from: selectColorWithBestContrast-4WTKRHQ, reason: not valid java name */
    public static final Color m10848selectColorWithBestContrast4WTKRHQ(List<Color> from, long j) {
        Object obj;
        Intrinsics.checkNotNullParameter(from, "from");
        Iterator<T> it = from.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                double dM10846contrastRatioOWjLjI = m10846contrastRatioOWjLjI(((Color) next).m6335unboximpl(), j);
                do {
                    Object next2 = it.next();
                    double dM10846contrastRatioOWjLjI2 = m10846contrastRatioOWjLjI(((Color) next2).m6335unboximpl(), j);
                    if (Double.compare(dM10846contrastRatioOWjLjI, dM10846contrastRatioOWjLjI2) < 0) {
                        next = next2;
                        dM10846contrastRatioOWjLjI = dM10846contrastRatioOWjLjI2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        return (Color) obj;
    }
}
