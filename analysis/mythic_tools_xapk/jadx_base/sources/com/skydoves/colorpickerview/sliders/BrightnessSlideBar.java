package com.skydoves.colorpickerview.sliders;

import android.content.Context;
import android.content.res.TypedArray;
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
public class BrightnessSlideBar extends AbstractSlider {
    public BrightnessSlideBar(Context context) {
        super(context);
    }

    public BrightnessSlideBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BrightnessSlideBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public BrightnessSlideBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onInflateFinished$0() {
        if (this.selectorPositionInitialized) {
            return;
        }
        int width = getWidth() - this.selector.getWidth();
        if (getPreferenceName() != null) {
            updateSelectorX(ColorPickerPreferenceManager.getInstance(getContext()).getBrightnessSliderPosition(getPreferenceName(), width) + (getSelectorSize() / 2));
        } else {
            this.selector.setX(width);
        }
    }

    @Override // com.skydoves.colorpickerview.sliders.AbstractSlider
    public int assembleColor() {
        float[] fArr = {0.0f, 0.0f, this.selectorPosition};
        Color.colorToHSV(getColor(), fArr);
        return (this.colorPickerView == null || this.colorPickerView.getAlphaSlideBar() == null) ? Color.HSVToColor(fArr) : Color.HSVToColor((int) (this.colorPickerView.getAlphaSlideBar().getSelectorPosition() * 255.0f), fArr);
    }

    @Override // com.skydoves.colorpickerview.sliders.AbstractSlider
    public /* bridge */ /* synthetic */ void attachColorPickerView(ColorPickerView colorPickerView) {
        super.attachColorPickerView(colorPickerView);
    }

    @Override // com.skydoves.colorpickerview.sliders.AbstractSlider
    protected void getAttrs(AttributeSet attributeSet) {
        int resourceId;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BrightnessSlideBar);
        try {
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.BrightnessSlideBar_selector_BrightnessSlider) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.BrightnessSlideBar_selector_BrightnessSlider, -1)) != -1) {
                this.selectorDrawable = AppCompatResources.getDrawable(getContext(), resourceId);
            }
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.BrightnessSlideBar_borderColor_BrightnessSlider)) {
                this.borderColor = typedArrayObtainStyledAttributes.getColor(R.styleable.BrightnessSlideBar_borderColor_BrightnessSlider, this.borderColor);
            }
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.BrightnessSlideBar_borderSize_BrightnessSlider)) {
                this.borderSize = typedArrayObtainStyledAttributes.getInt(R.styleable.BrightnessSlideBar_borderSize_BrightnessSlider, this.borderSize);
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

    @Override // com.skydoves.colorpickerview.sliders.AbstractSlider
    public void onInflateFinished() {
        this.selector.post(new Runnable() { // from class: com.skydoves.colorpickerview.sliders.BrightnessSlideBar$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onInflateFinished$0();
            }
        });
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
    protected void updatePaint(Paint paint) {
        float[] fArr = {0.0f, 0.0f, 0.0f};
        Color.colorToHSV(getColor(), fArr);
        int iHSVToColor = Color.HSVToColor(fArr);
        fArr[2] = 1.0f;
        paint.setShader(new LinearGradient(0.0f, 0.0f, getWidth(), getHeight(), iHSVToColor, Color.HSVToColor(fArr), Shader.TileMode.CLAMP));
    }

    @Override // com.skydoves.colorpickerview.sliders.AbstractSlider
    public /* bridge */ /* synthetic */ void updateSelectorX(int i) {
        super.updateSelectorX(i);
    }
}
