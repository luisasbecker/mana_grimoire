package com.vanniktech.emoji.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.vanniktech.emoji.Emoji;
import com.vanniktech.emoji.EmojiAndroidProvider;
import com.vanniktech.emoji.EmojiManager;
import com.vanniktech.emoji.EmojiTheming;
import com.vanniktech.emoji.listeners.OnEmojiClickListener;
import com.vanniktech.emoji.variant.VariantEmoji;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EmojiImageView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 82\u00020\u0001:\u00018B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0016J(\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020%2\u0006\u0010+\u001a\u00020%H\u0014J\u0010\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020.H\u0014J\b\u0010/\u001a\u00020#H\u0014J\b\u00100\u001a\u00020#H\u0002J\u001e\u00101\u001a\u00020#2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\t2\u0006\u00105\u001a\u000206J\u000e\u00107\u001a\u00020#2\u0006\u00104\u001a\u00020\tR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/vanniktech/emoji/internal/EmojiImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "currentEmoji", "Lcom/vanniktech/emoji/Emoji;", "clickListener", "Lcom/vanniktech/emoji/listeners/OnEmojiClickListener;", "getClickListener$emoji_release", "()Lcom/vanniktech/emoji/listeners/OnEmojiClickListener;", "setClickListener$emoji_release", "(Lcom/vanniktech/emoji/listeners/OnEmojiClickListener;)V", "longClickListener", "Lcom/vanniktech/emoji/internal/OnEmojiLongClickListener;", "getLongClickListener$emoji_release", "()Lcom/vanniktech/emoji/internal/OnEmojiLongClickListener;", "setLongClickListener$emoji_release", "(Lcom/vanniktech/emoji/internal/OnEmojiLongClickListener;)V", "variantIndicatorPaint", "Landroid/graphics/Paint;", "variantIndicatorPath", "Landroid/graphics/Path;", "variantIndicatorTop", "Landroid/graphics/Point;", "variantIndicatorBottomRight", "variantIndicatorBottomLeft", "hasVariants", "", "imageLoadingTask", "Lcom/vanniktech/emoji/internal/ImageLoadingTask;", "onMeasure", "", "widthMeasureSpec", "", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onDetachedFromWindow", "cancelFuture", "setEmoji", "theming", "Lcom/vanniktech/emoji/EmojiTheming;", "emoji", "variantEmoji", "Lcom/vanniktech/emoji/variant/VariantEmoji;", "updateEmoji", "Companion", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class EmojiImageView extends AppCompatImageView {
    private static final int VARIANT_INDICATOR_PART = 5;
    private static final int VARIANT_INDICATOR_PART_AMOUNT = 6;
    private OnEmojiClickListener clickListener;
    private Emoji currentEmoji;
    private boolean hasVariants;
    private ImageLoadingTask imageLoadingTask;
    private OnEmojiLongClickListener longClickListener;
    private final Point variantIndicatorBottomLeft;
    private final Point variantIndicatorBottomRight;
    private final Paint variantIndicatorPaint;
    private final Path variantIndicatorPath;
    private final Point variantIndicatorTop;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public EmojiImageView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        this.variantIndicatorPaint = paint;
        this.variantIndicatorPath = new Path();
        this.variantIndicatorTop = new Point();
        this.variantIndicatorBottomRight = new Point();
        this.variantIndicatorBottomLeft = new Point();
    }

    public /* synthetic */ EmojiImageView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    private final void cancelFuture() {
        ImageLoadingTask imageLoadingTask = this.imageLoadingTask;
        if (imageLoadingTask != null) {
            imageLoadingTask.cancel();
        }
        this.imageLoadingTask = null;
    }

    static final void setEmoji$lambda$0(EmojiImageView emojiImageView, View view) {
        OnEmojiClickListener onEmojiClickListener = emojiImageView.clickListener;
        if (onEmojiClickListener != null) {
            Emoji emoji = emojiImageView.currentEmoji;
            Intrinsics.checkNotNull(emoji);
            onEmojiClickListener.onEmojiClick(emoji);
        }
    }

    static final boolean setEmoji$lambda$1(EmojiImageView emojiImageView, Emoji emoji, List list, View view) {
        OnEmojiLongClickListener onEmojiLongClickListener = emojiImageView.longClickListener;
        if (onEmojiLongClickListener == null) {
            return true;
        }
        onEmojiLongClickListener.onEmojiLongClick(emojiImageView, emoji, list);
        return true;
    }

    /* JADX INFO: renamed from: getClickListener$emoji_release, reason: from getter */
    public final OnEmojiClickListener getClickListener() {
        return this.clickListener;
    }

    /* JADX INFO: renamed from: getLongClickListener$emoji_release, reason: from getter */
    public final OnEmojiLongClickListener getLongClickListener() {
        return this.longClickListener;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cancelFuture();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (!this.hasVariants || getDrawable() == null) {
            return;
        }
        canvas.drawPath(this.variantIndicatorPath, this.variantIndicatorPaint);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measuredWidth = getMeasuredWidth();
        setMeasuredDimension(measuredWidth, measuredWidth);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.variantIndicatorTop.x = w;
        this.variantIndicatorTop.y = (h / 6) * 5;
        this.variantIndicatorBottomRight.x = w;
        this.variantIndicatorBottomRight.y = h;
        this.variantIndicatorBottomLeft.x = (w / 6) * 5;
        this.variantIndicatorBottomLeft.y = h;
        this.variantIndicatorPath.rewind();
        this.variantIndicatorPath.moveTo(this.variantIndicatorTop.x, this.variantIndicatorTop.y);
        this.variantIndicatorPath.lineTo(this.variantIndicatorBottomRight.x, this.variantIndicatorBottomRight.y);
        this.variantIndicatorPath.lineTo(this.variantIndicatorBottomLeft.x, this.variantIndicatorBottomLeft.y);
        this.variantIndicatorPath.close();
    }

    public final void setClickListener$emoji_release(OnEmojiClickListener onEmojiClickListener) {
        this.clickListener = onEmojiClickListener;
    }

    public final void setEmoji(EmojiTheming theming, final Emoji emoji, VariantEmoji variantEmoji) {
        Intrinsics.checkNotNullParameter(theming, "theming");
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        Intrinsics.checkNotNullParameter(variantEmoji, "variantEmoji");
        this.variantIndicatorPaint.setColor(theming.dividerColor);
        postInvalidate();
        Emoji variant = variantEmoji.getVariant(emoji);
        if (Intrinsics.areEqual(variant, this.currentEmoji)) {
            return;
        }
        setContentDescription(variant.getUnicode());
        setImageDrawable(null);
        this.currentEmoji = variant;
        final List<Emoji> variants = variantEmoji.getVariants(emoji);
        this.hasVariants = !variants.isEmpty();
        cancelFuture();
        setOnClickListener(new View.OnClickListener() { // from class: com.vanniktech.emoji.internal.EmojiImageView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmojiImageView.setEmoji$lambda$0(this.f$0, view);
            }
        });
        setOnLongClickListener(this.hasVariants ? new View.OnLongClickListener() { // from class: com.vanniktech.emoji.internal.EmojiImageView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return EmojiImageView.setEmoji$lambda$1(this.f$0, emoji, variants, view);
            }
        } : null);
        ImageLoadingTask imageLoadingTask = new ImageLoadingTask(this);
        this.imageLoadingTask = imageLoadingTask;
        imageLoadingTask.start(variant);
    }

    public final void setLongClickListener$emoji_release(OnEmojiLongClickListener onEmojiLongClickListener) {
        this.longClickListener = onEmojiLongClickListener;
    }

    public final void updateEmoji(Emoji emoji) {
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        if (Intrinsics.areEqual(emoji, this.currentEmoji)) {
            return;
        }
        this.currentEmoji = emoji;
        setContentDescription(emoji.getUnicode());
        EmojiAndroidProvider emojiAndroidProviderEmojiDrawableProvider = UtilsKt.emojiDrawableProvider(EmojiManager.INSTANCE);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        setImageDrawable(emojiAndroidProviderEmojiDrawableProvider.getDrawable(emoji, context));
    }
}
