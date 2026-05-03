package com.studiolaganne.lengendarylens;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.graphics.drawable.DrawableKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RightFocusedImageView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u000e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/studiolaganne/lengendarylens/RightFocusedImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "imageMatrix", "Landroid/graphics/Matrix;", "focusX", "", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "configureMatrix", "drawable", "Landroid/graphics/drawable/Drawable;", "adjustFocusBasedOnAspectRatio", Key.ROTATION, "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RightFocusedImageView extends AppCompatImageView {
    public static final int $stable = 8;
    private float focusX;
    private final Matrix imageMatrix;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RightFocusedImageView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RightFocusedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RightFocusedImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.imageMatrix = new Matrix();
        this.focusX = 0.5f;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.RightFocusedImageView, 0, 0);
        try {
            this.focusX = typedArrayObtainStyledAttributes.getFloat(R.styleable.RightFocusedImageView_focusX, 0.5f);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public /* synthetic */ RightFocusedImageView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void configureMatrix(Drawable drawable) {
        float f;
        float f2;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int i = intrinsicWidth * height;
        int i2 = width * intrinsicHeight;
        float f3 = this.focusX;
        float f4 = 0.0f;
        if (i > i2) {
            f2 = height / intrinsicHeight;
            float f5 = (width - (intrinsicWidth * f2)) * f3;
            f = 0.0f;
            f4 = f5;
        } else {
            float f6 = width / intrinsicWidth;
            f = (height - (intrinsicHeight * f6)) * f3;
            f2 = f6;
        }
        this.imageMatrix.setScale(f2, f2);
        this.imageMatrix.postTranslate(f4, f);
    }

    public final void adjustFocusBasedOnAspectRatio(int rotation) {
        float f = 0.5f;
        if (rotation == 90) {
            float height = getHeight() / getWidth();
            this.focusX = height > 1.0f ? height >= 2.0f ? 0.5f : 0.75f - ((height - 1.0f) * 0.5f) : 0.75f;
            return;
        }
        if (rotation == 180) {
            float width = getWidth() / getHeight();
            if (width <= 1.0f) {
                f = 0.25f;
            } else if (width < 2.0f) {
                f = ((width - 1.0f) * 0.25f) + 0.25f;
            }
            this.focusX = f;
            return;
        }
        if (rotation != 270) {
            float width2 = getWidth() / getHeight();
            this.focusX = width2 > 1.0f ? width2 >= 2.0f ? 0.5f : 0.75f - ((width2 - 1.0f) * 0.5f) : 0.75f;
            return;
        }
        float height2 = getHeight() / getWidth();
        if (height2 <= 1.0f) {
            f = 0.25f;
        } else if (height2 < 2.0f) {
            f = ((height2 - 1.0f) * 0.25f) + 0.25f;
        }
        this.focusX = f;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Drawable drawable = getDrawable();
        if (drawable == null || getWidth() == 0 || getHeight() == 0) {
            return;
        }
        configureMatrix(drawable);
        canvas.drawBitmap(DrawableKt.toBitmap$default(drawable, 0, 0, null, 7, null), this.imageMatrix, null);
    }
}
