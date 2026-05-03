package com.vanniktech.emoji;

import android.content.Context;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EmojiButton.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0017J\b\u0010\u0011\u001a\u00020\nH\u0016J\u0012\u0010\u0012\u001a\u00020\f2\b\b\u0001\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0012\u001a\u00020\f2\b\b\u0001\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\f2\b\b\u0001\u0010\u0018\u001a\u00020\u0014H\u0016J\u001a\u0010\u0017\u001a\u00020\f2\b\b\u0001\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0012\u0010\t\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/vanniktech/emoji/EmojiButton;", "Landroidx/appcompat/widget/AppCompatButton;", "Lcom/vanniktech/emoji/EmojiDisplayable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "emojiSize", "", "setText", "", "rawText", "", "type", "Landroid/widget/TextView$BufferType;", "getEmojiSize", "setEmojiSize", "pixels", "", "shouldInvalidate", "", "setEmojiSizeRes", "res", "emoji_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class EmojiButton extends AppCompatButton implements EmojiDisplayable {
    private float emojiSize;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public EmojiButton(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        int[] EmojiButton = R.styleable.EmojiButton;
        Intrinsics.checkNotNullExpressionValue(EmojiButton, "EmojiButton");
        this.emojiSize = EmojiTextViews.init(this, attributeSet, EmojiButton, R.styleable.EmojiButton_emojiSize);
    }

    public /* synthetic */ EmojiButton(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    @Override // com.vanniktech.emoji.EmojiDisplayable
    public float getEmojiSize() {
        return this.emojiSize;
    }

    @Override // com.vanniktech.emoji.EmojiDisplayable
    public void setEmojiSize(int pixels) {
        setEmojiSize(pixels, true);
    }

    @Override // com.vanniktech.emoji.EmojiDisplayable
    public void setEmojiSize(int pixels, boolean shouldInvalidate) {
        this.emojiSize = pixels;
        if (shouldInvalidate) {
            setText(getText());
        }
    }

    @Override // com.vanniktech.emoji.EmojiDisplayable
    public void setEmojiSizeRes(int res) {
        setEmojiSizeRes(res, true);
    }

    @Override // com.vanniktech.emoji.EmojiDisplayable
    public void setEmojiSizeRes(int res, boolean shouldInvalidate) {
        setEmojiSize(getResources().getDimensionPixelSize(res), shouldInvalidate);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence rawText, TextView.BufferType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (isInEditMode()) {
            super.setText(rawText, type);
            return;
        }
        if (rawText == null) {
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(rawText);
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        float f = fontMetrics.descent - fontMetrics.ascent;
        EmojiManager emojiManager = EmojiManager.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        float f2 = this.emojiSize;
        if (f2 != 0.0f) {
            f = f2;
        }
        EmojiManagers.replaceWithImages(emojiManager, context, spannableStringBuilder2, f);
        super.setText(spannableStringBuilder, type);
    }
}
