package com.skydoves.colorpickerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.skydoves.colorpickerview.sliders.AlphaTileDrawable;

/* JADX INFO: loaded from: classes6.dex */
public class AlphaTileView extends View {
    private Bitmap backgroundBitmap;
    private final AlphaTileDrawable.Builder builder;
    private Paint colorPaint;

    public AlphaTileView(Context context) {
        super(context);
        this.builder = new AlphaTileDrawable.Builder();
        onCreate();
    }

    public AlphaTileView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.builder = new AlphaTileDrawable.Builder();
        onCreate();
        getAttrs(attributeSet);
    }

    public AlphaTileView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.builder = new AlphaTileDrawable.Builder();
        onCreate();
        getAttrs(attributeSet);
    }

    public AlphaTileView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.builder = new AlphaTileDrawable.Builder();
        onCreate();
        getAttrs(attributeSet);
    }

    private void getAttrs(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.AlphaTileView);
        try {
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.AlphaTileView_tileSize)) {
                this.builder.setTileSize(typedArrayObtainStyledAttributes.getInt(R.styleable.AlphaTileView_tileSize, this.builder.getTileSize()));
            }
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.AlphaTileView_tileOddColor)) {
                this.builder.setTileOddColor(typedArrayObtainStyledAttributes.getInt(R.styleable.AlphaTileView_tileOddColor, this.builder.getTileOddColor()));
            }
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.AlphaTileView_tileEvenColor)) {
                this.builder.setTileEvenColor(typedArrayObtainStyledAttributes.getInt(R.styleable.AlphaTileView_tileEvenColor, this.builder.getTileEvenColor()));
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private void onCreate() {
        this.colorPaint = new Paint(1);
        setBackgroundColor(-1);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(this.backgroundBitmap, 0.0f, 0.0f, (Paint) null);
        canvas.drawRect(0.0f, 0.0f, getWidth(), getMeasuredHeight(), this.colorPaint);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        AlphaTileDrawable alphaTileDrawableBuild = this.builder.build();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        this.backgroundBitmap = bitmapCreateBitmap;
        if (bitmapCreateBitmap == null || bitmapCreateBitmap.isRecycled()) {
            return;
        }
        Canvas canvas = new Canvas(this.backgroundBitmap);
        alphaTileDrawableBuild.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        alphaTileDrawableBuild.draw(canvas);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        setPaintColor(i);
    }

    public void setPaintColor(int i) {
        this.colorPaint.setColor(i);
        invalidate();
    }
}
