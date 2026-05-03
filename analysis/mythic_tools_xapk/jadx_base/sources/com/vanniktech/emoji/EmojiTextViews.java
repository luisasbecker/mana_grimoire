package com.vanniktech.emoji;

import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EmojiTextViews.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"init", "", "Landroid/widget/TextView;", "attrs", "Landroid/util/AttributeSet;", "styleable", "", "emojiSizeAttr", "", "emoji_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class EmojiTextViews {
    public static final float init(TextView textView, AttributeSet attributeSet, int[] styleable, int i) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(styleable, "styleable");
        if (!textView.isInEditMode()) {
            EmojiManager.INSTANCE.verifyInstalled$emoji_release();
        }
        Paint.FontMetrics fontMetrics = textView.getPaint().getFontMetrics();
        float dimension = fontMetrics.descent - fontMetrics.ascent;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = textView.getContext().obtainStyledAttributes(attributeSet, styleable);
            Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
            try {
                dimension = typedArrayObtainStyledAttributes.getDimension(i, dimension);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
        textView.setText(textView.getText());
        return dimension;
    }
}
