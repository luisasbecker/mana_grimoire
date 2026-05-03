package com.skydoves.colorpickerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.skydoves.colorpickerview.flag.FlagMode;
import com.skydoves.colorpickerview.flag.FlagView;
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener;
import com.skydoves.colorpickerview.listeners.ColorListener;
import com.skydoves.colorpickerview.listeners.ColorPickerViewListener;
import com.skydoves.colorpickerview.preference.ColorPickerPreferenceManager;
import com.skydoves.colorpickerview.sliders.AlphaSlideBar;
import com.skydoves.colorpickerview.sliders.BrightnessSlideBar;

/* JADX INFO: loaded from: classes6.dex */
public class ColorPickerView extends FrameLayout implements LifecycleObserver {
    private boolean VISIBLE_FLAG;
    private ActionMode actionMode;
    private AlphaSlideBar alphaSlideBar;
    private BrightnessSlideBar brightnessSlider;
    public ColorPickerViewListener colorListener;
    private long debounceDuration;
    private final Handler debounceHandler;
    private FlagView flagView;
    private float flag_alpha;
    private boolean flag_isFlipAble;
    private ImageView palette;
    private Drawable paletteDrawable;
    private final ColorPickerPreferenceManager preferenceManager;
    private String preferenceName;
    private boolean resetBrightnessOnLowSaturation;
    private int selectedColor;
    private Point selectedPoint;
    private int selectedPureColor;
    private ImageView selector;
    private Drawable selectorDrawable;
    private boolean selectorPointValidation;
    private int selectorSize;
    private float selector_alpha;

    public static class Builder {
        private AlphaSlideBar alphaSlideBar;
        private BrightnessSlideBar brightnessSlider;
        private ColorPickerViewListener colorPickerViewListener;
        private final Context context;
        private FlagView flagView;
        private LifecycleOwner lifecycleOwner;
        private Drawable paletteDrawable;
        private String preferenceName;
        private Drawable selectorDrawable;
        private int debounceDuration = 0;
        private ActionMode actionMode = ActionMode.ALWAYS;
        private int initialColor = 0;
        private float selector_alpha = 1.0f;
        private float flag_alpha = 1.0f;
        private boolean flag_isFlipAble = false;

        @Dp
        private int selectorSize = 0;

        @Dp
        private int width = -1;

        @Dp
        private int height = -1;
        private boolean selectorPointValidation = true;
        private boolean resetBrightnessOnLowSaturation = true;

        public Builder(Context context) {
            this.context = context;
        }

        public ColorPickerView build() {
            ColorPickerView colorPickerView = new ColorPickerView(this.context);
            colorPickerView.onCreateByBuilder(this);
            return colorPickerView;
        }

        public Builder setActionMode(ActionMode actionMode) {
            this.actionMode = actionMode;
            return this;
        }

        public Builder setAlphaSlideBar(AlphaSlideBar alphaSlideBar) {
            this.alphaSlideBar = alphaSlideBar;
            return this;
        }

        public Builder setBrightnessSlideBar(BrightnessSlideBar brightnessSlideBar) {
            this.brightnessSlider = brightnessSlideBar;
            return this;
        }

        public Builder setColorListener(ColorPickerViewListener colorPickerViewListener) {
            this.colorPickerViewListener = colorPickerViewListener;
            return this;
        }

        public Builder setDebounceDuration(int i) {
            this.debounceDuration = i;
            return this;
        }

        public Builder setFlagAlpha(float f) {
            this.flag_alpha = f;
            return this;
        }

        public Builder setFlagIsFlipAble(boolean z) {
            this.flag_isFlipAble = z;
            return this;
        }

        public Builder setFlagView(FlagView flagView) {
            this.flagView = flagView;
            return this;
        }

        public Builder setHeight(@Dp int i) {
            this.height = i;
            return this;
        }

        public Builder setInitialColor(int i) {
            this.initialColor = i;
            return this;
        }

        public Builder setInitialColorRes(int i) {
            this.initialColor = ContextCompat.getColor(this.context, i);
            return this;
        }

        public Builder setLifecycleOwner(LifecycleOwner lifecycleOwner) {
            this.lifecycleOwner = lifecycleOwner;
            return this;
        }

        public Builder setPaletteDrawable(Drawable drawable) {
            this.paletteDrawable = drawable;
            return this;
        }

        public Builder setPreferenceName(String str) {
            this.preferenceName = str;
            return this;
        }

        public Builder setResetBrightnessOnLowSaturation(boolean z) {
            this.resetBrightnessOnLowSaturation = z;
            return this;
        }

        public Builder setSelectorAlpha(float f) {
            this.selector_alpha = f;
            return this;
        }

        public Builder setSelectorDrawable(Drawable drawable) {
            this.selectorDrawable = drawable;
            return this;
        }

        public Builder setSelectorPointValidation(boolean z) {
            this.selectorPointValidation = z;
            return this;
        }

        public Builder setSelectorSize(@Dp int i) {
            this.selectorSize = i;
            return this;
        }

        public Builder setWidth(@Dp int i) {
            this.width = i;
            return this;
        }
    }

    public ColorPickerView(Context context) {
        super(context);
        this.debounceDuration = 0L;
        this.debounceHandler = new Handler();
        this.actionMode = ActionMode.ALWAYS;
        this.selector_alpha = 1.0f;
        this.flag_alpha = 1.0f;
        this.flag_isFlipAble = true;
        this.selectorSize = 0;
        this.VISIBLE_FLAG = false;
        this.selectorPointValidation = true;
        this.resetBrightnessOnLowSaturation = true;
        this.preferenceManager = ColorPickerPreferenceManager.getInstance(getContext());
    }

    public ColorPickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.debounceDuration = 0L;
        this.debounceHandler = new Handler();
        this.actionMode = ActionMode.ALWAYS;
        this.selector_alpha = 1.0f;
        this.flag_alpha = 1.0f;
        this.flag_isFlipAble = true;
        this.selectorSize = 0;
        this.VISIBLE_FLAG = false;
        this.selectorPointValidation = true;
        this.resetBrightnessOnLowSaturation = true;
        this.preferenceManager = ColorPickerPreferenceManager.getInstance(getContext());
        getAttrs(attributeSet);
        onCreate();
    }

    public ColorPickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.debounceDuration = 0L;
        this.debounceHandler = new Handler();
        this.actionMode = ActionMode.ALWAYS;
        this.selector_alpha = 1.0f;
        this.flag_alpha = 1.0f;
        this.flag_isFlipAble = true;
        this.selectorSize = 0;
        this.VISIBLE_FLAG = false;
        this.selectorPointValidation = true;
        this.resetBrightnessOnLowSaturation = true;
        this.preferenceManager = ColorPickerPreferenceManager.getInstance(getContext());
        getAttrs(attributeSet);
        onCreate();
    }

    public ColorPickerView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.debounceDuration = 0L;
        this.debounceHandler = new Handler();
        this.actionMode = ActionMode.ALWAYS;
        this.selector_alpha = 1.0f;
        this.flag_alpha = 1.0f;
        this.flag_isFlipAble = true;
        this.selectorSize = 0;
        this.VISIBLE_FLAG = false;
        this.selectorPointValidation = true;
        this.resetBrightnessOnLowSaturation = true;
        this.preferenceManager = ColorPickerPreferenceManager.getInstance(getContext());
        getAttrs(attributeSet);
        onCreate();
    }

    private void getAttrs(AttributeSet attributeSet) {
        int resourceId;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ColorPickerView);
        try {
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ColorPickerView_palette)) {
                this.paletteDrawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ColorPickerView_palette);
            }
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ColorPickerView_selector) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ColorPickerView_selector, -1)) != -1) {
                this.selectorDrawable = AppCompatResources.getDrawable(getContext(), resourceId);
            }
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ColorPickerView_selector_alpha)) {
                this.selector_alpha = typedArrayObtainStyledAttributes.getFloat(R.styleable.ColorPickerView_selector_alpha, this.selector_alpha);
            }
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ColorPickerView_selector_size)) {
                this.selectorSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ColorPickerView_selector_size, this.selectorSize);
            }
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ColorPickerView_flag_alpha)) {
                this.flag_alpha = typedArrayObtainStyledAttributes.getFloat(R.styleable.ColorPickerView_flag_alpha, this.flag_alpha);
            }
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ColorPickerView_flag_isFlipAble)) {
                this.flag_isFlipAble = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ColorPickerView_flag_isFlipAble, this.flag_isFlipAble);
            }
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ColorPickerView_actionMode)) {
                int integer = typedArrayObtainStyledAttributes.getInteger(R.styleable.ColorPickerView_actionMode, 0);
                if (integer == 0) {
                    this.actionMode = ActionMode.ALWAYS;
                } else if (integer == 1) {
                    this.actionMode = ActionMode.LAST;
                }
            }
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ColorPickerView_debounceDuration)) {
                this.debounceDuration = typedArrayObtainStyledAttributes.getInteger(R.styleable.ColorPickerView_debounceDuration, (int) this.debounceDuration);
            }
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ColorPickerView_preferenceName)) {
                this.preferenceName = typedArrayObtainStyledAttributes.getString(R.styleable.ColorPickerView_preferenceName);
            }
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ColorPickerView_initialColor)) {
                setInitialColor(typedArrayObtainStyledAttributes.getColor(R.styleable.ColorPickerView_initialColor, -1));
            }
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ColorPickerView_selectorPointValidation)) {
                this.selectorPointValidation = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ColorPickerView_selectorPointValidation, this.selectorPointValidation);
            }
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.ColorPickerView_resetBrightnessOnLowSaturation)) {
                this.resetBrightnessOnLowSaturation = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ColorPickerView_resetBrightnessOnLowSaturation, this.resetBrightnessOnLowSaturation);
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private Point getCenterPoint(int i, int i2) {
        return new Point(i - (this.selector.getWidth() / 2), i2 - (this.selector.getMeasuredHeight() / 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyColorChanged$1() {
        fireColorListener(getColor(), true);
        notifyToFlagView(this.selectedPoint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onFinishInflated$0(int i) {
        try {
            selectByHsvColor(i);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setInitialColor$2(int i) {
        try {
            selectByHsvColor(i);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void notifyColorChanged() {
        this.debounceHandler.removeCallbacksAndMessages(null);
        this.debounceHandler.postDelayed(new Runnable() { // from class: com.skydoves.colorpickerview.ColorPickerView$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$notifyColorChanged$1();
            }
        }, this.debounceDuration);
    }

    private void notifyToFlagView(Point point) {
        Point centerPoint = getCenterPoint(point.x, point.y);
        FlagView flagView = this.flagView;
        if (flagView != null) {
            if (flagView.getFlagMode() == FlagMode.ALWAYS) {
                this.flagView.visible();
            }
            int width = (centerPoint.x - (this.flagView.getWidth() / 2)) + (this.selector.getWidth() / 2);
            if (this.flagView.isFlipAble()) {
                int height = centerPoint.y - this.flagView.getHeight();
                FlagView flagView2 = this.flagView;
                if (height > 0) {
                    flagView2.setRotation(0.0f);
                    this.flagView.setX(width);
                    this.flagView.setY(centerPoint.y - this.flagView.getHeight());
                    this.flagView.onFlipped(false);
                } else {
                    flagView2.setRotation(180.0f);
                    this.flagView.setX(width);
                    this.flagView.setY((centerPoint.y + this.flagView.getHeight()) - (this.selector.getHeight() * 0.5f));
                    this.flagView.onFlipped(true);
                }
            } else {
                this.flagView.setRotation(0.0f);
                this.flagView.setX(width);
                this.flagView.setY(centerPoint.y - this.flagView.getHeight());
            }
            this.flagView.onRefresh(getColorEnvelope());
            if (width < 0) {
                this.flagView.setX(0.0f);
            }
            if (width + this.flagView.getWidth() > getWidth()) {
                this.flagView.setX(getWidth() - this.flagView.getWidth());
            }
        }
    }

    private void notifyToSlideBars() {
        AlphaSlideBar alphaSlideBar = this.alphaSlideBar;
        if (alphaSlideBar != null) {
            alphaSlideBar.notifyColor();
        }
        BrightnessSlideBar brightnessSlideBar = this.brightnessSlider;
        if (brightnessSlideBar != null) {
            brightnessSlideBar.notifyColor();
            if (this.brightnessSlider.assembleColor() != -1) {
                this.selectedColor = this.brightnessSlider.assembleColor();
                return;
            }
            AlphaSlideBar alphaSlideBar2 = this.alphaSlideBar;
            if (alphaSlideBar2 != null) {
                this.selectedColor = alphaSlideBar2.assembleColor();
            }
        }
    }

    private void onCreate() {
        setPadding(0, 0, 0, 0);
        ImageView imageView = new ImageView(getContext());
        this.palette = imageView;
        Drawable drawable = this.paletteDrawable;
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(this.palette, layoutParams);
        ImageView imageView2 = new ImageView(getContext());
        this.selector = imageView2;
        Drawable drawable2 = this.selectorDrawable;
        if (drawable2 != null) {
            imageView2.setImageDrawable(drawable2);
        } else {
            imageView2.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.colorpickerview_wheel));
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        if (this.selectorSize != 0) {
            layoutParams2.width = SizeUtils.dp2Px(getContext(), this.selectorSize);
            layoutParams2.height = SizeUtils.dp2Px(getContext(), this.selectorSize);
        }
        layoutParams2.gravity = 17;
        addView(this.selector, layoutParams2);
        this.selector.setAlpha(this.selector_alpha);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.skydoves.colorpickerview.ColorPickerView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                ColorPickerView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                ColorPickerView.this.onFinishInflated();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFinishInflated() {
        if (getParent() != null && (getParent() instanceof ViewGroup)) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
        if (getPreferenceName() == null) {
            selectCenter();
            return;
        }
        this.preferenceManager.restoreColorPickerData(this);
        final int color = this.preferenceManager.getColor(getPreferenceName(), -1);
        if (!(this.palette.getDrawable() instanceof ColorHsvPalette) || color == -1) {
            return;
        }
        post(new Runnable() { // from class: com.skydoves.colorpickerview.ColorPickerView$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onFinishInflated$0(color);
            }
        });
    }

    private boolean onTouchReceived(MotionEvent motionEvent) {
        Point colorPoint = PointMapper.getColorPoint(this, new Point((int) motionEvent.getX(), (int) motionEvent.getY()));
        int colorFromBitmap = getColorFromBitmap(colorPoint.x, colorPoint.y);
        this.selectedPureColor = colorFromBitmap;
        this.selectedColor = colorFromBitmap;
        this.selectedPoint = PointMapper.getColorPoint(this, new Point(colorPoint.x, colorPoint.y));
        setCoordinate(colorPoint.x, colorPoint.y);
        if (this.resetBrightnessOnLowSaturation && isHuePalette() && this.brightnessSlider != null) {
            float[] fArr = new float[3];
            Color.colorToHSV(colorFromBitmap, fArr);
            if (fArr[1] < 0.05f) {
                this.brightnessSlider.setSelectorByHalfSelectorPosition(1.0f);
            }
        }
        if (this.actionMode == ActionMode.LAST) {
            notifyToFlagView(this.selectedPoint);
            if (motionEvent.getAction() == 1) {
                notifyColorChanged();
            }
        } else {
            notifyColorChanged();
        }
        return true;
    }

    public void attachAlphaSlider(AlphaSlideBar alphaSlideBar) {
        this.alphaSlideBar = alphaSlideBar;
        alphaSlideBar.attachColorPickerView(this);
        alphaSlideBar.notifyColor();
        if (getPreferenceName() != null) {
            alphaSlideBar.setPreferenceName(getPreferenceName());
        }
    }

    public void attachBrightnessSlider(BrightnessSlideBar brightnessSlideBar) {
        this.brightnessSlider = brightnessSlideBar;
        brightnessSlideBar.attachColorPickerView(this);
        brightnessSlideBar.notifyColor();
        if (getPreferenceName() != null) {
            brightnessSlideBar.setPreferenceName(getPreferenceName());
        }
    }

    public void fireColorListener(int i, boolean z) {
        this.selectedColor = i;
        if (getAlphaSlideBar() != null) {
            getAlphaSlideBar().notifyColor();
            this.selectedColor = getAlphaSlideBar().assembleColor();
        }
        if (getBrightnessSlider() != null) {
            getBrightnessSlider().notifyColor();
            this.selectedColor = getBrightnessSlider().assembleColor();
        }
        ColorPickerViewListener colorPickerViewListener = this.colorListener;
        if (colorPickerViewListener != null) {
            if (colorPickerViewListener instanceof ColorListener) {
                ((ColorListener) colorPickerViewListener).onColorSelected(this.selectedColor, z);
            } else if (colorPickerViewListener instanceof ColorEnvelopeListener) {
                ((ColorEnvelopeListener) this.colorListener).onColorSelected(new ColorEnvelope(this.selectedColor), z);
            }
        }
        FlagView flagView = this.flagView;
        if (flagView != null) {
            flagView.onRefresh(getColorEnvelope());
            invalidate();
        }
        if (this.VISIBLE_FLAG) {
            this.VISIBLE_FLAG = false;
            ImageView imageView = this.selector;
            if (imageView != null) {
                imageView.setAlpha(this.selector_alpha);
            }
            FlagView flagView2 = this.flagView;
            if (flagView2 != null) {
                flagView2.setAlpha(this.flag_alpha);
            }
        }
    }

    public ActionMode getActionMode() {
        return this.actionMode;
    }

    @Override // android.view.View
    public float getAlpha() {
        return Color.alpha(getColor()) / 255.0f;
    }

    public AlphaSlideBar getAlphaSlideBar() {
        return this.alphaSlideBar;
    }

    public BrightnessSlideBar getBrightnessSlider() {
        return this.brightnessSlider;
    }

    public int getColor() {
        return this.selectedColor;
    }

    public ColorEnvelope getColorEnvelope() {
        return new ColorEnvelope(getColor());
    }

    protected int getColorFromBitmap(float f, float f2) {
        Matrix matrix = new Matrix();
        this.palette.getImageMatrix().invert(matrix);
        float[] fArr = {f, f2};
        matrix.mapPoints(fArr);
        if (this.palette.getDrawable() != null && (this.palette.getDrawable() instanceof BitmapDrawable)) {
            float f3 = fArr[0];
            if (f3 >= 0.0f && fArr[1] >= 0.0f && f3 < this.palette.getDrawable().getIntrinsicWidth() && fArr[1] < this.palette.getDrawable().getIntrinsicHeight()) {
                invalidate();
                if (!(this.palette.getDrawable() instanceof ColorHsvPalette)) {
                    Rect bounds = this.palette.getDrawable().getBounds();
                    return ((BitmapDrawable) this.palette.getDrawable()).getBitmap().getPixel((int) ((fArr[0] / bounds.width()) * ((BitmapDrawable) this.palette.getDrawable()).getBitmap().getWidth()), (int) ((fArr[1] / bounds.height()) * ((BitmapDrawable) this.palette.getDrawable()).getBitmap().getHeight()));
                }
                float width = f - (getWidth() * 0.5f);
                float height = f2 - (getHeight() * 0.5f);
                float[] fArr2 = {0.0f, 0.0f, 1.0f};
                fArr2[0] = ((float) ((Math.atan2(height, -width) / 3.141592653589793d) * 180.0d)) + 180.0f;
                fArr2[1] = Math.max(0.0f, Math.min(1.0f, (float) (Math.sqrt((width * width) + (height * height)) / ((double) (Math.min(getWidth(), getHeight()) * 0.5f)))));
                return Color.HSVToColor(fArr2);
            }
        }
        return 0;
    }

    public long getDebounceDuration() {
        return this.debounceDuration;
    }

    public FlagView getFlagView() {
        return this.flagView;
    }

    public String getPreferenceName() {
        return this.preferenceName;
    }

    public int getPureColor() {
        return this.selectedPureColor;
    }

    public Point getSelectedPoint() {
        return this.selectedPoint;
    }

    public ImageView getSelector() {
        return this.selector;
    }

    public float getSelectorX() {
        return this.selector.getX() - (this.selector.getWidth() * 0.5f);
    }

    public float getSelectorY() {
        return this.selector.getY() - (this.selector.getMeasuredHeight() * 0.5f);
    }

    public boolean isHuePalette() {
        return this.palette.getDrawable() != null && (this.palette.getDrawable() instanceof ColorHsvPalette);
    }

    public boolean isResetBrightnessOnLowSaturationEnabled() {
        return this.resetBrightnessOnLowSaturation;
    }

    public boolean isSelectorPointValidationEnabled() {
        return this.selectorPointValidation;
    }

    public void moveSelectorPoint(int i, int i2, int i3) {
        this.selectedPureColor = i3;
        this.selectedColor = i3;
        this.selectedPoint = new Point(i, i2);
        setCoordinate(i, i2);
        fireColorListener(getColor(), false);
        notifyToFlagView(this.selectedPoint);
    }

    protected void onCreateByBuilder(Builder builder) {
        setLayoutParams(new FrameLayout.LayoutParams(SizeUtils.dp2Px(getContext(), builder.width), SizeUtils.dp2Px(getContext(), builder.height)));
        this.paletteDrawable = builder.paletteDrawable;
        this.selectorDrawable = builder.selectorDrawable;
        this.selector_alpha = builder.selector_alpha;
        this.flag_alpha = builder.flag_alpha;
        this.selectorSize = SizeUtils.dp2Px(getContext(), builder.selectorSize);
        this.debounceDuration = builder.debounceDuration;
        onCreate();
        if (builder.colorPickerViewListener != null) {
            setColorListener(builder.colorPickerViewListener);
        }
        if (builder.alphaSlideBar != null) {
            attachAlphaSlider(builder.alphaSlideBar);
        }
        if (builder.brightnessSlider != null) {
            attachBrightnessSlider(builder.brightnessSlider);
        }
        if (builder.actionMode != null) {
            this.actionMode = builder.actionMode;
        }
        if (builder.flagView != null) {
            setFlagView(builder.flagView);
        }
        if (builder.preferenceName != null) {
            setPreferenceName(builder.preferenceName);
        }
        if (builder.initialColor != 0) {
            setInitialColor(builder.initialColor);
        }
        if (builder.lifecycleOwner != null) {
            setLifecycleOwner(builder.lifecycleOwner);
        }
        this.selectorPointValidation = builder.selectorPointValidation;
        this.resetBrightnessOnLowSaturation = builder.resetBrightnessOnLowSaturation;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        this.preferenceManager.saveColorPickerData(this);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.palette.getDrawable() == null) {
            this.palette.setImageDrawable(new ColorHsvPalette(getResources(), Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888)));
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0 && actionMasked != 1 && actionMasked != 2) {
            this.selector.setPressed(false);
            return false;
        }
        if (getFlagView() != null) {
            getFlagView().receiveOnTouchEvent(motionEvent);
        }
        this.selector.setPressed(true);
        return onTouchReceived(motionEvent);
    }

    public void removeLifecycleOwner(LifecycleOwner lifecycleOwner) {
        lifecycleOwner.getLifecycle().removeObserver(this);
    }

    public void selectByHsvColor(int i) throws IllegalAccessException {
        if (!(this.palette.getDrawable() instanceof ColorHsvPalette)) {
            throw new IllegalAccessException("selectByHsvColor(@ColorInt int color) can be called only when the palette is an instance of ColorHsvPalette. Use setHsvPaletteDrawable();");
        }
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        float width = getWidth() * 0.5f;
        float height = getHeight() * 0.5f;
        float fMin = fArr[1] * Math.min(width, height);
        Point colorPoint = PointMapper.getColorPoint(this, new Point((int) ((((double) fMin) * Math.cos(Math.toRadians(fArr[0]))) + ((double) width)), (int) ((((double) (-fMin)) * Math.sin(Math.toRadians(fArr[0]))) + ((double) height))));
        this.selectedPureColor = i;
        this.selectedColor = i;
        this.selectedPoint = new Point(colorPoint.x, colorPoint.y);
        if (getAlphaSlideBar() != null) {
            getAlphaSlideBar().setSelectorByHalfSelectorPosition(getAlpha());
        }
        if (getBrightnessSlider() != null) {
            getBrightnessSlider().setSelectorByHalfSelectorPosition(fArr[2]);
        }
        setCoordinate(colorPoint.x, colorPoint.y);
        fireColorListener(getColor(), false);
        notifyToFlagView(this.selectedPoint);
    }

    public void selectByHsvColorRes(int i) throws IllegalAccessException {
        selectByHsvColor(ContextCompat.getColor(getContext(), i));
    }

    public void selectCenter() {
        BrightnessSlideBar brightnessSlideBar;
        setSelectorPoint(getWidth() / 2, getMeasuredHeight() / 2);
        if (!isHuePalette() || (brightnessSlideBar = this.brightnessSlider) == null) {
            return;
        }
        brightnessSlideBar.setSelectorByHalfSelectorPosition(1.0f);
        fireColorListener(getColor(), false);
    }

    public void selectWhite() {
        if (isHuePalette()) {
            setSelectorPoint(getWidth() / 2, getMeasuredHeight() / 2);
            BrightnessSlideBar brightnessSlideBar = this.brightnessSlider;
            if (brightnessSlideBar != null) {
                brightnessSlideBar.setSelectorByHalfSelectorPosition(1.0f);
            }
            AlphaSlideBar alphaSlideBar = this.alphaSlideBar;
            if (alphaSlideBar != null) {
                alphaSlideBar.setSelectorByHalfSelectorPosition(1.0f);
            }
            fireColorListener(getColor(), false);
        }
    }

    public void setActionMode(ActionMode actionMode) {
        this.actionMode = actionMode;
    }

    public void setColorListener(ColorPickerViewListener colorPickerViewListener) {
        this.colorListener = colorPickerViewListener;
    }

    public void setCoordinate(int i, int i2) {
        this.selector.setX(i - (r0.getWidth() * 0.5f));
        this.selector.setY(i2 - (r3.getMeasuredHeight() * 0.5f));
    }

    public void setDebounceDuration(long j) {
        this.debounceDuration = j;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.selector.setVisibility(z ? 0 : 4);
        if (getAlphaSlideBar() != null) {
            getAlphaSlideBar().setEnabled(z);
        }
        if (getBrightnessSlider() != null) {
            getBrightnessSlider().setEnabled(z);
        }
        if (z) {
            this.palette.clearColorFilter();
        } else {
            this.palette.setColorFilter(Color.argb(70, 255, 255, 255));
        }
    }

    public void setFlagView(FlagView flagView) {
        flagView.gone();
        addView(flagView);
        this.flagView = flagView;
        flagView.setAlpha(this.flag_alpha);
        flagView.setFlipAble(this.flag_isFlipAble);
    }

    public void setHsvPaletteDrawable() {
        setPaletteDrawable(new ColorHsvPalette(getResources(), Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888)));
    }

    public void setInitialColor(final int i) {
        if (getPreferenceName() == null || (getPreferenceName() != null && this.preferenceManager.getColor(getPreferenceName(), -1) == -1)) {
            post(new Runnable() { // from class: com.skydoves.colorpickerview.ColorPickerView$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setInitialColor$2(i);
                }
            });
        }
    }

    public void setInitialColorRes(int i) {
        setInitialColor(ContextCompat.getColor(getContext(), i));
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        lifecycleOwner.getLifecycle().addObserver(this);
    }

    public void setPaletteDrawable(Drawable drawable) {
        removeView(this.palette);
        ImageView imageView = new ImageView(getContext());
        this.palette = imageView;
        this.paletteDrawable = drawable;
        imageView.setImageDrawable(drawable);
        addView(this.palette);
        removeView(this.selector);
        addView(this.selector);
        this.selectedPureColor = -1;
        notifyToSlideBars();
        FlagView flagView = this.flagView;
        if (flagView != null) {
            removeView(flagView);
            addView(this.flagView);
        }
        if (this.VISIBLE_FLAG) {
            return;
        }
        this.VISIBLE_FLAG = true;
        ImageView imageView2 = this.selector;
        if (imageView2 != null) {
            this.selector_alpha = imageView2.getAlpha();
            this.selector.setAlpha(0.0f);
        }
        FlagView flagView2 = this.flagView;
        if (flagView2 != null) {
            this.flag_alpha = flagView2.getAlpha();
            this.flagView.setAlpha(0.0f);
        }
    }

    public void setPreferenceName(String str) {
        this.preferenceName = str;
        AlphaSlideBar alphaSlideBar = this.alphaSlideBar;
        if (alphaSlideBar != null) {
            alphaSlideBar.setPreferenceName(str);
        }
        BrightnessSlideBar brightnessSlideBar = this.brightnessSlider;
        if (brightnessSlideBar != null) {
            brightnessSlideBar.setPreferenceName(str);
        }
    }

    public void setPureColor(int i) {
        this.selectedPureColor = i;
    }

    public void setResetBrightnessOnLowSaturation(boolean z) {
        this.resetBrightnessOnLowSaturation = z;
    }

    public void setSelectorDrawable(Drawable drawable) {
        this.selector.setImageDrawable(drawable);
    }

    public void setSelectorPoint(int i, int i2) {
        Point colorPoint = PointMapper.getColorPoint(this, new Point(i, i2));
        int colorFromBitmap = getColorFromBitmap(colorPoint.x, colorPoint.y);
        this.selectedPureColor = colorFromBitmap;
        this.selectedColor = colorFromBitmap;
        this.selectedPoint = new Point(colorPoint.x, colorPoint.y);
        setCoordinate(colorPoint.x, colorPoint.y);
        fireColorListener(getColor(), false);
        notifyToFlagView(this.selectedPoint);
    }

    public void setSelectorPointValidation(boolean z) {
        this.selectorPointValidation = z;
    }
}
