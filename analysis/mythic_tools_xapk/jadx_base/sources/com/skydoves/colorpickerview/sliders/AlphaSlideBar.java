package com.skydoves.colorpickerview.sliders;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.content.res.AppCompatResources;
import com.skydoves.colorpickerview.ColorPickerView;
import com.skydoves.colorpickerview.R;
import com.skydoves.colorpickerview.preference.ColorPickerPreferenceManager;

/* JADX INFO: loaded from: classes6.dex */
public class AlphaSlideBar extends AbstractSlider {
    private Bitmap backgroundBitmap;
    private final AlphaTileDrawable drawable;

    public AlphaSlideBar(Context context) {
        super(context);
        this.drawable = new AlphaTileDrawable();
    }

    public AlphaSlideBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.drawable = new AlphaTileDrawable();
    }

    public AlphaSlideBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.drawable = new AlphaTileDrawable();
    }

    public AlphaSlideBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.drawable = new AlphaTileDrawable();
    }

    @Override // com.skydoves.colorpickerview.sliders.AbstractSlider
    public int assembleColor() {
        float[] fArr = new float[3];
        Color.colorToHSV(getColor(), fArr);
        return Color.HSVToColor((int) (this.selectorPosition * 255.0f), fArr);
    }

    @Override // com.skydoves.colorpickerview.sliders.AbstractSlider
    public /* bridge */ /* synthetic */ void attachColorPickerView(ColorPickerView colorPickerView) {
        super.attachColorPickerView(colorPickerView);
    }

    @Override // com.skydoves.colorpickerview.sliders.AbstractSlider
    protected void getAttrs(AttributeSet attributeSet) {
        int resourceId;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.AlphaSlideBar);
        try {
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.AlphaSlideBar_selector_AlphaSlideBar) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlphaSlideBar_selector_AlphaSlideBar, -1)) != -1) {
                this.selectorDrawable = AppCompatResources.getDrawable(getContext(), resourceId);
            }
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.AlphaSlideBar_borderColor_AlphaSlideBar)) {
                this.borderColor = typedArrayObtainStyledAttributes.getColor(R.styleable.AlphaSlideBar_borderColor_AlphaSlideBar, this.borderColor);
            }
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.AlphaSlideBar_borderSize_AlphaSlideBar)) {
                this.borderSize = typedArrayObtainStyledAttributes.getInt(R.styleable.AlphaSlideBar_borderSize_AlphaSlideBar, this.borderSize);
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // com.skydoves.colorpickerview.sliders.AbstractSlider
    public /* bridge */ /* synthetic */ int getColor() {
        return super.getColor();
    }

    @Override // com.skydoves.colorpickerview.sliders.AbstractSlider
    public /* bridge */ /* synthetic */ String getPreferenceName() {
        return super.getPreferenceName();
    }

    @Override // com.skydoves.colorpickerview.sliders.AbstractSlider
    public /* bridge */ /* synthetic */ int getSelectedX() {
        return super.getSelectedX();
    }

    @Override // com.skydoves.colorpickerview.sliders.AbstractSlider
    public /* bridge */ /* synthetic */ void notifyColor() {
        super.notifyColor();
    }

    @Override // com.skydoves.colorpickerview.sliders.AbstractSlider, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(this.backgroundBitmap, 0.0f, 0.0f, (Paint) null);
        super.onDraw(canvas);
    }

    @Override // com.skydoves.colorpickerview.sliders.AbstractSlider
    public void onInflateFinished() {
        if (this.selectorPositionInitialized) {
            return;
        }
        int width = getWidth() - this.selector.getWidth();
        if (getPreferenceName() != null) {
            updateSelectorX(ColorPickerPreferenceManager.getInstance(getContext()).getAlphaSliderPosition(getPreferenceName(), width) + (getSelectorSize() / 2));
        } else {
            this.selector.setX(width);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.backgroundBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.backgroundBitmap);
        this.drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        this.drawable.draw(canvas);
    }

    @Override // com.skydoves.colorpickerview.sliders.AbstractSlider, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.skydoves.colorpickerview.sliders.AbstractSlider
    public /* bridge */ /* synthetic */ void setBorderColor(int i) {
        super.setBorderColor(i);
    }

    @Override // com.skydoves.colorpickerview.sliders.AbstractSlider
    public /* bridge */ /* synthetic */ void setBorderColorRes(int i) {
        super.setBorderColorRes(i);
    }

    @Override // com.skydoves.colorpickerview.sliders.AbstractSlider
    public /* bridge */ /* synthetic */ void setBorderSize(int i) {
        super.setBorderSize(i);
    }

    @Override // com.skydoves.colorpickerview.sliders.AbstractSlider
    public /* bridge */ /* synthetic */ void setBorderSizeRes(int i) {
        super.setBorderSizeRes(i);
    }

    @Override // com.skydoves.colorpickerview.sliders.AbstractSlider, android.view.View
    public /* bridge */ /* synthetic */ void setEnabled(boolean z) {
        super.setEnabled(z);
    }

    @Override // com.skydoves.colorpickerview.sliders.AbstractSlider
    public /* bridge */ /* synthetic */ void setPreferenceName(String str) {
        super.setPreferenceName(str);
    }

    @Override // com.skydoves.colorpickerview.sliders.AbstractSlider
    public /* bridge */ /* synthetic */ void setSelectorByHalfSelectorPosition(float f) {
        super.setSelectorByHalfSelectorPosition(f);
    }

    @Override // com.skydoves.colorpickerview.sliders.AbstractSlider
    public /* bridge */ /* synthetic */ void setSelectorDrawable(Drawable drawable) {
        super.setSelectorDrawable(drawable);
    }

    @Override // com.skydoves.colorpickerview.sliders.AbstractSlider
    public /* bridge */ /* synthetic */ void setSelectorDrawableRes(int i) {
        super.setSelectorDrawableRes(i);
    }

    @Override // com.skydoves.colorpickerview.sliders.AbstractSlider
    public /* bridge */ /* synthetic */ void setSelectorPosition(float f) {
        super.setSelectorPosition(f);
    }

    @Override // com.skydoves.colorpickerview.sliders.AbstractSlider
    public void updatePaint(Paint paint) {
        float[] fArr = new float[3];
        Color.colorToHSV(getColor(), fArr);
        paint.setShader(new LinearGradient(0.0f, 0.0f, getWidth(), getMeasuredHeight(), Color.HSVToColor(0, fArr), Color.HSVToColor(255, fArr), Shader.TileMode.CLAMP));
    }

    @Override // com.skydoves.colorpickerview.sliders.AbstractSlider
    public /* bridge */ /* synthetic */ void updateSelectorX(int i) {
        super.updateSelectorX(i);
    }
}
