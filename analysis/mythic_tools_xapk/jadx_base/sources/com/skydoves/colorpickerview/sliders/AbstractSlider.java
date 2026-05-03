package com.skydoves.colorpickerview.sliders;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.skydoves.colorpickerview.ActionMode;
import com.skydoves.colorpickerview.ColorPickerView;

/* JADX INFO: loaded from: classes6.dex */
abstract class AbstractSlider extends FrameLayout {
    protected int borderColor;
    protected Paint borderPaint;
    protected int borderSize;
    protected int color;
    protected Paint colorPaint;
    public ColorPickerView colorPickerView;
    protected String preferenceName;
    protected int selectedX;
    protected ImageView selector;
    protected Drawable selectorDrawable;
    protected float selectorPosition;
    protected boolean selectorPositionInitialized;

    public AbstractSlider(Context context) {
        super(context);
        this.selectorPosition = 1.0f;
        this.selectedX = 0;
        this.borderSize = 2;
        this.borderColor = -16777216;
        this.color = -1;
        this.selectorPositionInitialized = false;
        onCreate();
    }

    public AbstractSlider(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.selectorPosition = 1.0f;
        this.selectedX = 0;
        this.borderSize = 2;
        this.borderColor = -16777216;
        this.color = -1;
        this.selectorPositionInitialized = false;
        getAttrs(attributeSet);
        onCreate();
    }

    public AbstractSlider(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.selectorPosition = 1.0f;
        this.selectedX = 0;
        this.borderSize = 2;
        this.borderColor = -16777216;
        this.color = -1;
        this.selectorPositionInitialized = false;
        getAttrs(attributeSet);
        onCreate();
    }

    public AbstractSlider(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.selectorPosition = 1.0f;
        this.selectedX = 0;
        this.borderSize = 2;
        this.borderColor = -16777216;
        this.color = -1;
        this.selectorPositionInitialized = false;
        getAttrs(attributeSet);
        onCreate();
    }

    private float getBoundaryX(float f) {
        float width = getWidth() - (this.selector.getWidth() / 2);
        if (f >= width) {
            return width;
        }
        if (f <= getSelectorSize() / 2.0f) {
            return 0.0f;
        }
        return f - (getSelectorSize() / 2.0f);
    }

    private void initializeSelector() {
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.skydoves.colorpickerview.sliders.AbstractSlider.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                AbstractSlider.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                AbstractSlider.this.onInflateFinished();
            }
        });
    }

    private void onCreate() {
        this.colorPaint = new Paint(1);
        Paint paint = new Paint(1);
        this.borderPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.borderPaint.setStrokeWidth(this.borderSize);
        this.borderPaint.setColor(this.borderColor);
        setBackgroundColor(-1);
        this.selector = new ImageView(getContext());
        Drawable drawable = this.selectorDrawable;
        if (drawable != null) {
            setSelectorDrawable(drawable);
        }
        initializeSelector();
    }

    private void onTouchReceived(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float width = this.selector.getWidth() / 2.0f;
        float width2 = getWidth() - width;
        if (x > width2) {
            x = width2;
        }
        float f = (x - width) / (width2 - width);
        this.selectorPosition = f;
        if (f < 0.0f) {
            this.selectorPosition = 0.0f;
        }
        if (this.selectorPosition > 1.0f) {
            this.selectorPosition = 1.0f;
        }
        int boundaryX = (int) getBoundaryX(new Point((int) motionEvent.getX(), (int) motionEvent.getY()).x);
        this.selectedX = boundaryX;
        this.selector.setX(boundaryX);
        if (this.colorPickerView.getActionMode() != ActionMode.LAST || motionEvent.getAction() == 1) {
            this.colorPickerView.fireColorListener(assembleColor(), true);
        }
        if (this.colorPickerView.getFlagView() != null) {
            this.colorPickerView.getFlagView().receiveOnTouchEvent(motionEvent);
        }
        float width3 = getWidth() - this.selector.getWidth();
        if (this.selector.getX() >= width3) {
            this.selector.setX(width3);
        }
        if (this.selector.getX() <= 0.0f) {
            this.selector.setX(0.0f);
        }
    }

    public abstract int assembleColor();

    public void attachColorPickerView(ColorPickerView colorPickerView) {
        this.colorPickerView = colorPickerView;
    }

    protected abstract void getAttrs(AttributeSet attributeSet);

    protected int getBorderHalfSize() {
        return (int) (this.borderSize * 0.5f);
    }

    public int getColor() {
        return this.color;
    }

    public String getPreferenceName() {
        return this.preferenceName;
    }

    public int getSelectedX() {
        return this.selectedX;
    }

    protected float getSelectorPosition() {
        return this.selectorPosition;
    }

    protected int getSelectorSize() {
        return this.selector.getWidth();
    }

    public void notifyColor() {
        this.color = this.colorPickerView.getPureColor();
        updatePaint(this.colorPaint);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float width = getWidth();
        float measuredHeight = getMeasuredHeight();
        canvas.drawRect(0.0f, 0.0f, width, measuredHeight, this.colorPaint);
        canvas.drawRect(0.0f, 0.0f, width, measuredHeight, this.borderPaint);
    }

    public abstract void onInflateFinished();

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled() && this.colorPickerView != null) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0 && actionMasked != 1 && actionMasked != 2) {
                this.selector.setPressed(false);
                return false;
            }
            this.selector.setPressed(true);
            if (motionEvent.getX() <= getWidth() && motionEvent.getX() >= 0.0f) {
                onTouchReceived(motionEvent);
                return true;
            }
        }
        return false;
    }

    public void setBorderColor(int i) {
        this.borderColor = i;
        this.borderPaint.setColor(i);
        invalidate();
    }

    public void setBorderColorRes(int i) {
        setBorderColor(ContextCompat.getColor(getContext(), i));
    }

    public void setBorderSize(int i) {
        this.borderSize = i;
        this.borderPaint.setStrokeWidth(i);
        invalidate();
    }

    public void setBorderSizeRes(int i) {
        setBorderSize((int) getContext().getResources().getDimension(i));
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.selector.setVisibility(z ? 0 : 4);
        setClickable(z);
    }

    public void setPreferenceName(String str) {
        this.preferenceName = str;
    }

    public void setSelectorByHalfSelectorPosition(float f) {
        this.selectorPosition = Math.min(f, 1.0f);
        int boundaryX = (int) getBoundaryX(((getWidth() * f) - (getSelectorSize() * 0.5f)) - getBorderHalfSize());
        this.selectedX = boundaryX;
        this.selector.setX(boundaryX);
        this.selectorPositionInitialized = true;
    }

    public void setSelectorDrawable(Drawable drawable) {
        removeView(this.selector);
        this.selectorDrawable = drawable;
        this.selector.setImageDrawable(drawable);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        addView(this.selector, layoutParams);
    }

    public void setSelectorDrawableRes(int i) {
        setSelectorDrawable(ResourcesCompat.getDrawable(getContext().getResources(), i, null));
    }

    public void setSelectorPosition(float f) {
        this.selectorPosition = Math.min(f, 1.0f);
        int boundaryX = (int) getBoundaryX(((getWidth() * f) - getSelectorSize()) - getBorderHalfSize());
        this.selectedX = boundaryX;
        this.selector.setX(boundaryX);
        this.selectorPositionInitialized = true;
    }

    protected abstract void updatePaint(Paint paint);

    public void updateSelectorX(int i) {
        float width = this.selector.getWidth() / 2.0f;
        float f = i;
        float width2 = (f - width) / ((getWidth() - width) - width);
        this.selectorPosition = width2;
        if (width2 < 0.0f) {
            this.selectorPosition = 0.0f;
        }
        if (this.selectorPosition > 1.0f) {
            this.selectorPosition = 1.0f;
        }
        int boundaryX = (int) getBoundaryX(f);
        this.selectedX = boundaryX;
        this.selector.setX(boundaryX);
        this.colorPickerView.fireColorListener(assembleColor(), false);
    }
}
