package com.skydoves.colorpickerview.sliders;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes6.dex */
public class AlphaTileDrawable extends Drawable {
    private Paint paint = new Paint(1);
    private int tileEvenColor;
    private int tileOddColor;
    private int tileSize;

    public static class Builder {
        private int tileSize = 25;
        private int tileOddColor = -1;
        private int tileEvenColor = -3421237;

        public AlphaTileDrawable build() {
            return new AlphaTileDrawable(this);
        }

        public int getTileEvenColor() {
            return this.tileEvenColor;
        }

        public int getTileOddColor() {
            return this.tileOddColor;
        }

        public int getTileSize() {
            return this.tileSize;
        }

        public Builder setTileEvenColor(int i) {
            this.tileEvenColor = i;
            return this;
        }

        public Builder setTileOddColor(int i) {
            this.tileOddColor = i;
            return this;
        }

        public Builder setTileSize(int i) {
            this.tileSize = i;
            return this;
        }
    }

    public AlphaTileDrawable() {
        Builder builder = new Builder();
        this.tileSize = builder.tileSize;
        this.tileOddColor = builder.tileOddColor;
        this.tileEvenColor = builder.tileEvenColor;
        drawTiles();
    }

    public AlphaTileDrawable(Builder builder) {
        this.tileSize = builder.tileSize;
        this.tileOddColor = builder.tileOddColor;
        this.tileEvenColor = builder.tileEvenColor;
        drawTiles();
    }

    private void drawTile(Canvas canvas, Rect rect, Paint paint, int i, int i2) {
        rect.offset(i, i2);
        canvas.drawRect(rect, paint);
    }

    private void drawTiles() {
        int i = this.tileSize;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i * 2, i * 2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        int i2 = this.tileSize;
        Rect rect = new Rect(0, 0, i2, i2);
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(this.tileOddColor);
        drawTile(canvas, rect, paint, 0, 0);
        int i3 = this.tileSize;
        drawTile(canvas, rect, paint, i3, i3);
        paint.setColor(this.tileEvenColor);
        drawTile(canvas, rect, paint, -this.tileSize, 0);
        int i4 = this.tileSize;
        drawTile(canvas, rect, paint, i4, -i4);
        this.paint.setShader(new BitmapShader(bitmapCreateBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.drawPaint(this.paint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.paint.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }
}
