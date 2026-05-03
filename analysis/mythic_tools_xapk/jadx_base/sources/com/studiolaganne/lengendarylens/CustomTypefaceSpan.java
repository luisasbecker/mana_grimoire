package com.studiolaganne.lengendarylens;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.style.ReplacementSpan;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomTypefaceSpan.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J2\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016JP\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/studiolaganne/lengendarylens/CustomTypefaceSpan;", "Landroid/text/style/ReplacementSpan;", "typeface", "Landroid/graphics/Typeface;", "<init>", "(Landroid/graphics/Typeface;)V", "getSize", "", "paint", "Landroid/graphics/Paint;", "text", "", "start", "end", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "x", "", ViewHierarchyConstants.DIMENSION_TOP_KEY, "y", "bottom", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CustomTypefaceSpan extends ReplacementSpan {
    public static final int $stable = 8;
    private final Typeface typeface;

    public CustomTypefaceSpan(Typeface typeface) {
        Intrinsics.checkNotNullParameter(typeface, "typeface");
        this.typeface = typeface;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Typeface typeface = paint.getTypeface();
        paint.setTypeface(this.typeface);
        canvas.drawText(text, start, end, x, y, paint);
        paint.setTypeface(typeface);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(text, "text");
        Typeface typeface = paint.getTypeface();
        paint.setTypeface(this.typeface);
        float fMeasureText = paint.measureText(text, start, end);
        paint.setTypeface(typeface);
        return (int) fMeasureText;
    }
}
