package com.vanniktech.emoji.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.DynamicDrawableSpan;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.vanniktech.emoji.Emoji;
import com.vanniktech.emoji.EmojiManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: EmojiSpan.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u000bH\u0016J2\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016JP\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006#"}, d2 = {"Lcom/vanniktech/emoji/internal/EmojiSpan;", "Landroid/text/style/DynamicDrawableSpan;", "context", "Landroid/content/Context;", "emoji", "Lcom/vanniktech/emoji/Emoji;", "size", "", "<init>", "(Landroid/content/Context;Lcom/vanniktech/emoji/Emoji;F)V", "deferredDrawable", "Landroid/graphics/drawable/Drawable;", "getDeferredDrawable", "()Landroid/graphics/drawable/Drawable;", "deferredDrawable$delegate", "Lkotlin/Lazy;", "getDrawable", "getSize", "", "paint", "Landroid/graphics/Paint;", "text", "", "start", "end", "fontMetrics", "Landroid/graphics/Paint$FontMetricsInt;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "x", ViewHierarchyConstants.DIMENSION_TOP_KEY, "y", "bottom", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class EmojiSpan extends DynamicDrawableSpan {
    private final Context context;

    /* JADX INFO: renamed from: deferredDrawable$delegate, reason: from kotlin metadata */
    private final Lazy deferredDrawable;
    private final Emoji emoji;
    private final float size;

    public EmojiSpan(Context context, Emoji emoji, float f) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        this.context = context;
        this.emoji = emoji;
        this.size = f;
        this.deferredDrawable = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0() { // from class: com.vanniktech.emoji.internal.EmojiSpan$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EmojiSpan.deferredDrawable_delegate$lambda$0(this.f$0);
            }
        });
    }

    static final Drawable deferredDrawable_delegate$lambda$0(EmojiSpan emojiSpan) {
        Drawable drawable = UtilsKt.emojiDrawableProvider(EmojiManager.INSTANCE).getDrawable(emojiSpan.emoji, emojiSpan.context);
        float f = emojiSpan.size;
        drawable.setBounds(0, 0, (int) f, (int) f);
        return drawable;
    }

    private final Drawable getDeferredDrawable() {
        return (Drawable) this.deferredDrawable.getValue();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Drawable drawable = getDrawable();
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f = ((y + fontMetrics.descent) - ((fontMetrics.descent - fontMetrics.ascent) / 2.0f)) - (this.size / 2.0f);
        int iSave = canvas.save();
        canvas.translate(x, f);
        try {
            drawable.draw(canvas);
        } finally {
            canvas.restoreToCount(iSave);
        }
    }

    @Override // android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        return getDeferredDrawable();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fontMetrics) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(text, "text");
        if (fontMetrics != null) {
            Paint.FontMetrics fontMetrics2 = paint.getFontMetrics();
            float f = fontMetrics2.ascent;
            float f2 = fontMetrics2.descent;
            if (MathKt.roundToInt(this.size) == MathKt.roundToInt(Math.abs(f) + Math.abs(f2))) {
                fontMetrics.ascent = (int) f;
                fontMetrics.descent = (int) f2;
                fontMetrics.top = (int) fontMetrics2.top;
                fontMetrics.bottom = (int) fontMetrics2.bottom;
            } else {
                float f3 = fontMetrics2.ascent + ((fontMetrics2.descent - fontMetrics2.ascent) / 2.0f);
                fontMetrics.ascent = (int) (f3 - (this.size / 2.0f));
                fontMetrics.top = fontMetrics.ascent;
                fontMetrics.bottom = (int) (f3 + (this.size / 2.0f));
                fontMetrics.descent = fontMetrics.bottom;
            }
        }
        return (int) this.size;
    }
}
