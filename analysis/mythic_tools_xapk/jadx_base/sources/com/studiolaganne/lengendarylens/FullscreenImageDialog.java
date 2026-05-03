package com.studiolaganne.lengendarylens;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FullscreenImageDialog.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0002\u001d\u001eB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001c\u001a\u00020\u001aH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/studiolaganne/lengendarylens/FullscreenImageDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "bitmap", "Landroid/graphics/Bitmap;", "<init>", "(Landroid/content/Context;Landroid/graphics/Bitmap;)V", "imageView", "Landroid/widget/ImageView;", "scaleGestureDetector", "Landroid/view/ScaleGestureDetector;", "gestureDetector", "Landroid/view/GestureDetector;", "matrix", "Landroid/graphics/Matrix;", "savedMatrix", "scaleFactor", "", "translateX", "translateY", "imageWidth", "imageHeight", "viewWidth", "viewHeight", "centerImage", "", "constrainTranslation", "applyMatrix", "ScaleListener", "GestureListener", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FullscreenImageDialog extends Dialog {
    public static final int $stable = 8;
    private final Bitmap bitmap;
    private final GestureDetector gestureDetector;
    private float imageHeight;
    private final ImageView imageView;
    private float imageWidth;
    private final Matrix matrix;
    private final Matrix savedMatrix;
    private float scaleFactor;
    private final ScaleGestureDetector scaleGestureDetector;
    private float translateX;
    private float translateY;
    private float viewHeight;
    private float viewWidth;

    /* JADX INFO: compiled from: FullscreenImageDialog.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"Lcom/studiolaganne/lengendarylens/FullscreenImageDialog$GestureListener;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "<init>", "(Lcom/studiolaganne/lengendarylens/FullscreenImageDialog;)V", "onScroll", "", "e1", "Landroid/view/MotionEvent;", "e2", "distanceX", "", "distanceY", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private final class GestureListener extends GestureDetector.SimpleOnGestureListener {
        public GestureListener() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            Intrinsics.checkNotNullParameter(e2, "e2");
            if (FullscreenImageDialog.this.scaleFactor <= 1.0f) {
                return false;
            }
            FullscreenImageDialog.this.translateX -= distanceX;
            FullscreenImageDialog.this.translateY -= distanceY;
            FullscreenImageDialog.this.constrainTranslation();
            FullscreenImageDialog.this.applyMatrix();
            return true;
        }
    }

    /* JADX INFO: compiled from: FullscreenImageDialog.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/studiolaganne/lengendarylens/FullscreenImageDialog$ScaleListener;", "Landroid/view/ScaleGestureDetector$SimpleOnScaleGestureListener;", "<init>", "(Lcom/studiolaganne/lengendarylens/FullscreenImageDialog;)V", "lastFocusX", "", "lastFocusY", "onScaleBegin", "", "detector", "Landroid/view/ScaleGestureDetector;", "onScale", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private final class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private float lastFocusX;
        private float lastFocusY;

        public ScaleListener() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector detector) {
            Intrinsics.checkNotNullParameter(detector, "detector");
            float fMax = Math.max(1.0f, Math.min(FullscreenImageDialog.this.scaleFactor * detector.getScaleFactor(), 5.0f));
            if (fMax == FullscreenImageDialog.this.scaleFactor) {
                return true;
            }
            FullscreenImageDialog.this.matrix.set(FullscreenImageDialog.this.savedMatrix);
            FullscreenImageDialog.this.matrix.postScale(fMax / FullscreenImageDialog.this.scaleFactor, fMax / FullscreenImageDialog.this.scaleFactor, this.lastFocusX, this.lastFocusY);
            FullscreenImageDialog.this.scaleFactor = fMax;
            float[] fArr = new float[9];
            FullscreenImageDialog.this.matrix.getValues(fArr);
            FullscreenImageDialog.this.translateX = fArr[2];
            FullscreenImageDialog.this.translateY = fArr[5];
            float f = FullscreenImageDialog.this.scaleFactor;
            FullscreenImageDialog fullscreenImageDialog = FullscreenImageDialog.this;
            if (f == 1.0f) {
                fullscreenImageDialog.centerImage();
                return true;
            }
            fullscreenImageDialog.constrainTranslation();
            FullscreenImageDialog.this.applyMatrix();
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            Intrinsics.checkNotNullParameter(detector, "detector");
            this.lastFocusX = detector.getFocusX();
            this.lastFocusY = detector.getFocusY();
            FullscreenImageDialog.this.savedMatrix.set(FullscreenImageDialog.this.matrix);
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullscreenImageDialog(Context context, Bitmap bitmap) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.bitmap = bitmap;
        this.matrix = new Matrix();
        this.savedMatrix = new Matrix();
        this.scaleFactor = 1.0f;
        requestWindowFeature(1);
        ConstraintLayout constraintLayout = new ConstraintLayout(context);
        constraintLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        constraintLayout.setBackgroundColor(Color.parseColor("#E6000000"));
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.FullscreenImageDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.dismiss();
            }
        });
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        boolean z = displayMetrics.widthPixels < displayMetrics.heightPixels;
        ImageView imageView = new ImageView(context);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(z ? -1 : -2, z ? -2 : -1);
        layoutParams.startToStart = 0;
        layoutParams.endToEnd = 0;
        layoutParams.topToTop = 0;
        layoutParams.bottomToBottom = 0;
        imageView.setLayoutParams(layoutParams);
        imageView.setAdjustViewBounds(true);
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        imageView.setImageBitmap(bitmap);
        imageView.setImageMatrix(imageView.getMatrix());
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.FullscreenImageDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FullscreenImageDialog.lambda$1$1(view);
            }
        });
        this.imageView = imageView;
        constraintLayout.addView(imageView);
        setContentView(constraintLayout);
        Window window = getWindow();
        if (window != null) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        imageView.post(new Runnable() { // from class: com.studiolaganne.lengendarylens.FullscreenImageDialog$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                FullscreenImageDialog._init_$lambda$3(this.f$0);
            }
        });
        this.scaleGestureDetector = new ScaleGestureDetector(context, new ScaleListener());
        this.gestureDetector = new GestureDetector(context, new GestureListener());
        imageView.setOnTouchListener(new View.OnTouchListener() { // from class: com.studiolaganne.lengendarylens.FullscreenImageDialog$$ExternalSyntheticLambda3
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return FullscreenImageDialog._init_$lambda$4(this.f$0, view, motionEvent);
            }
        });
    }

    static final void _init_$lambda$3(FullscreenImageDialog fullscreenImageDialog) {
        fullscreenImageDialog.viewWidth = fullscreenImageDialog.imageView.getWidth();
        fullscreenImageDialog.viewHeight = fullscreenImageDialog.imageView.getHeight();
        fullscreenImageDialog.imageWidth = fullscreenImageDialog.bitmap.getWidth();
        fullscreenImageDialog.imageHeight = fullscreenImageDialog.bitmap.getHeight();
        fullscreenImageDialog.centerImage();
        fullscreenImageDialog.imageView.setClipToOutline(true);
        fullscreenImageDialog.imageView.setOutlineProvider(new RoundedOutlineProvider(fullscreenImageDialog.imageView.getWidth() * 0.055f));
    }

    static final boolean _init_$lambda$4(FullscreenImageDialog fullscreenImageDialog, View view, MotionEvent motionEvent) {
        boolean zOnTouchEvent = fullscreenImageDialog.scaleGestureDetector.onTouchEvent(motionEvent);
        return !fullscreenImageDialog.scaleGestureDetector.isInProgress() ? fullscreenImageDialog.gestureDetector.onTouchEvent(motionEvent) || zOnTouchEvent : zOnTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyMatrix() {
        this.imageView.setImageMatrix(this.matrix);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void centerImage() {
        float fMin = Math.min(this.viewWidth / this.imageWidth, this.viewHeight / this.imageHeight);
        float f = this.imageWidth * fMin;
        float f2 = this.imageHeight * fMin;
        this.translateX = (this.viewWidth - f) / 2.0f;
        this.translateY = (this.viewHeight - f2) / 2.0f;
        this.scaleFactor = 1.0f;
        this.matrix.reset();
        this.matrix.postScale(fMin, fMin);
        this.matrix.postTranslate(this.translateX, this.translateY);
        applyMatrix();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void constrainTranslation() {
        float fMin = Math.min(this.viewWidth / this.imageWidth, this.viewHeight / this.imageHeight);
        float f = this.imageWidth * fMin;
        float f2 = this.scaleFactor;
        float f3 = f * f2;
        float f4 = this.imageHeight * fMin * f2;
        float fMax = Math.max(0.0f, (f3 - this.viewWidth) / 2.0f);
        float fMax2 = Math.max(0.0f, (f4 - this.viewHeight) / 2.0f);
        float fMin2 = Math.min(0.0f, this.viewWidth - f3) / 2.0f;
        float fMin3 = Math.min(0.0f, this.viewHeight - f4) / 2.0f;
        this.translateX = Math.max(fMin2 - fMax, Math.min(this.translateX, fMin2 + fMax));
        this.translateY = Math.max(fMin3 - fMax2, Math.min(this.translateY, fMin3 + fMax2));
        float fMin4 = Math.min(this.viewWidth / this.imageWidth, this.viewHeight / this.imageHeight);
        this.matrix.reset();
        Matrix matrix = this.matrix;
        float f5 = this.scaleFactor;
        matrix.postScale(fMin4 * f5, fMin4 * f5);
        this.matrix.postTranslate(this.translateX, this.translateY);
    }

    static final void lambda$1$1(View view) {
    }
}
