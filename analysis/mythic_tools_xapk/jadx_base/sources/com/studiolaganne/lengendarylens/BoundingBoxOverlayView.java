package com.studiolaganne.lengendarylens;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: BoundingBoxOverlayView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ>\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010-\u001a\u00020\u0017JX\u0010.\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010/\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u0007J\u0006\u00100\u001a\u00020+J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u000202H\u0002J\u0010\u00104\u001a\u0002022\u0006\u00103\u001a\u000202H\u0002J\u001e\u00105\u001a\u00020+2\u0006\u00106\u001a\u0002072\f\u00108\u001a\b\u0012\u0004\u0012\u00020209H\u0002J\u0010\u0010:\u001a\u00020+2\u0006\u00106\u001a\u000207H\u0014J\u0012\u0010;\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u000bH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/studiolaganne/lengendarylens/BoundingBoxOverlayView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cardSegmentation", "Lcom/studiolaganne/lengendarylens/CardSegmentation;", "debugImage", "Landroid/graphics/Bitmap;", "debugInfo", "", "debugMaskBitmap", "debugCardClass", "viewFinderWidth", "viewFinderHeight", "bitmapWidth", "bitmapHeight", "drawPolygon", "", "flashCardSegmentation", "flashBitmapWidth", "flashBitmapHeight", "flashViewFinderWidth", "flashViewFinderHeight", "flashAlpha", "", "flashScale", "isFlashing", "flashAnimator", "Landroid/animation/ValueAnimator;", "flashPaint", "Landroid/graphics/Paint;", "polygonPaint", "cornerPaint", "textPaint", "debugPaint", "flashSegmentationOwnsBitmaps", "flashCardDetection", "", "segmentation", "ownsSegmentation", "updateCardDetection", "debugMask", "removePolygons", "mapToScreenCoordinates", "Landroid/graphics/PointF;", "point", "mapToScreenCoordinatesFlash", "drawFlashCornerLines", "canvas", "Landroid/graphics/Canvas;", "corners", "", "onDraw", "recycleCardSegmentationBitmaps", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoundingBoxOverlayView extends View {
    public static final int $stable = 8;
    private int bitmapHeight;
    private int bitmapWidth;
    private CardSegmentation cardSegmentation;
    private final Paint cornerPaint;
    private String debugCardClass;
    private Bitmap debugImage;
    private String debugInfo;
    private Bitmap debugMaskBitmap;
    private final Paint debugPaint;
    private boolean drawPolygon;
    private float flashAlpha;
    private ValueAnimator flashAnimator;
    private int flashBitmapHeight;
    private int flashBitmapWidth;
    private CardSegmentation flashCardSegmentation;
    private final Paint flashPaint;
    private float flashScale;
    private boolean flashSegmentationOwnsBitmaps;
    private int flashViewFinderHeight;
    private int flashViewFinderWidth;
    private boolean isFlashing;
    private final Paint polygonPaint;
    private final Paint textPaint;
    private int viewFinderHeight;
    private int viewFinderWidth;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BoundingBoxOverlayView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BoundingBoxOverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BoundingBoxOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.debugInfo = "";
        this.debugCardClass = "";
        this.flashScale = 1.0f;
        Paint paint = new Paint();
        paint.setColor(-16711936);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10.0f);
        paint.setAntiAlias(true);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);
        this.flashPaint = paint;
        Paint paint2 = new Paint();
        paint2.setColor(-16711936);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(8.0f);
        paint2.setAntiAlias(true);
        this.polygonPaint = paint2;
        Paint paint3 = new Paint();
        paint3.setColor(-16776961);
        paint3.setStyle(Paint.Style.FILL);
        paint3.setAntiAlias(true);
        this.cornerPaint = paint3;
        Paint paint4 = new Paint();
        paint4.setColor(-1);
        paint4.setTextSize(36.0f);
        paint4.setAntiAlias(true);
        paint4.setShadowLayer(5.0f, 0.0f, 0.0f, -16777216);
        this.textPaint = paint4;
        Paint paint5 = new Paint();
        paint5.setColor(-256);
        paint5.setTextSize(24.0f);
        paint5.setAntiAlias(true);
        paint5.setShadowLayer(3.0f, 0.0f, 0.0f, -16777216);
        this.debugPaint = paint5;
        this.flashSegmentationOwnsBitmaps = true;
    }

    public /* synthetic */ BoundingBoxOverlayView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void drawFlashCornerLines(Canvas canvas, List<? extends PointF> corners) {
        if (corners.size() < 4) {
            return;
        }
        List<? extends PointF> list = corners;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(mapToScreenCoordinatesFlash((PointF) it.next()));
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            arrayList4.add(Float.valueOf(((PointF) it2.next()).x));
        }
        float fAverageOfFloat = (float) CollectionsKt.averageOfFloat(arrayList4);
        ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        Iterator it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            arrayList5.add(Float.valueOf(((PointF) it3.next()).y));
        }
        float fAverageOfFloat2 = (float) CollectionsKt.averageOfFloat(arrayList5);
        canvas.save();
        float f = this.flashScale;
        canvas.scale(f, f, fAverageOfFloat, fAverageOfFloat2);
        this.flashPaint.setAlpha((int) (this.flashAlpha * 255.0f));
        canvas.drawLine(((PointF) arrayList2.get(0)).x, ((PointF) arrayList2.get(0)).y, ((PointF) arrayList2.get(1)).x, ((PointF) arrayList2.get(1)).y, this.flashPaint);
        canvas.drawLine(((PointF) arrayList2.get(1)).x, ((PointF) arrayList2.get(1)).y, ((PointF) arrayList2.get(2)).x, ((PointF) arrayList2.get(2)).y, this.flashPaint);
        canvas.drawLine(((PointF) arrayList2.get(2)).x, ((PointF) arrayList2.get(2)).y, ((PointF) arrayList2.get(3)).x, ((PointF) arrayList2.get(3)).y, this.flashPaint);
        canvas.drawLine(((PointF) arrayList2.get(3)).x, ((PointF) arrayList2.get(3)).y, ((PointF) arrayList2.get(0)).x, ((PointF) arrayList2.get(0)).y, this.flashPaint);
        canvas.restore();
    }

    public static /* synthetic */ void flashCardDetection$default(BoundingBoxOverlayView boundingBoxOverlayView, CardSegmentation cardSegmentation, int i, int i2, int i3, int i4, boolean z, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            i3 = boundingBoxOverlayView.getWidth();
        }
        int i6 = i3;
        if ((i5 & 16) != 0) {
            i4 = boundingBoxOverlayView.getHeight();
        }
        int i7 = i4;
        if ((i5 & 32) != 0) {
            z = true;
        }
        boundingBoxOverlayView.flashCardDetection(cardSegmentation, i, i2, i6, i7, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void flashCardDetection$lambda$1$0(BoundingBoxOverlayView boundingBoxOverlayView, ValueAnimator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        Object animatedValue = animator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue = ((Float) animatedValue).floatValue();
        if (fFloatValue <= 0.2f) {
            float f = fFloatValue / 0.2f;
            boundingBoxOverlayView.flashAlpha = f;
            boundingBoxOverlayView.flashScale = (f * 0.2f) + 0.8f;
        } else if (fFloatValue <= 0.7f) {
            boundingBoxOverlayView.flashAlpha = 1.0f;
            boundingBoxOverlayView.flashScale = 1.0f;
        } else {
            float f2 = 1.0f - ((fFloatValue - 0.7f) / 0.3f);
            boundingBoxOverlayView.flashAlpha = f2;
            boundingBoxOverlayView.flashScale = ((1.0f - f2) * 0.1f) + 1.0f;
        }
        boundingBoxOverlayView.invalidate();
    }

    private final PointF mapToScreenCoordinates(PointF point) {
        float f = point.x * (this.bitmapWidth / 480.0f);
        float f2 = point.y;
        int i = this.bitmapHeight;
        float f3 = f2 * (i / 480.0f);
        float fMin = Math.min(this.viewFinderWidth / this.bitmapWidth, this.viewFinderHeight / i);
        return new PointF((f * fMin) + ((this.viewFinderWidth - (this.bitmapWidth * fMin)) / 2.0f), (f3 * fMin) + ((this.viewFinderHeight - (this.bitmapHeight * fMin)) / 2.0f));
    }

    private final PointF mapToScreenCoordinatesFlash(PointF point) {
        float f = point.x * (this.flashBitmapWidth / 480.0f);
        float f2 = point.y;
        int i = this.flashBitmapHeight;
        float f3 = f2 * (i / 480.0f);
        float fMin = Math.min(this.flashViewFinderWidth / this.flashBitmapWidth, this.flashViewFinderHeight / i);
        return new PointF((f * fMin) + ((this.flashViewFinderWidth - (this.flashBitmapWidth * fMin)) / 2.0f), (f3 * fMin) + ((this.flashViewFinderHeight - (this.flashBitmapHeight * fMin)) / 2.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void recycleCardSegmentationBitmaps(CardSegmentation segmentation) {
        if (segmentation == null) {
            return;
        }
        try {
            Bitmap cardBitmap = segmentation.getCardBitmap();
            if (cardBitmap != null) {
                cardBitmap.recycle();
            }
            Bitmap enhancedCardBitmap = segmentation.getEnhancedCardBitmap();
            if (enhancedCardBitmap != null) {
                enhancedCardBitmap.recycle();
            }
            Bitmap titleRegionBitmap = segmentation.getTitleRegionBitmap();
            if (titleRegionBitmap != null) {
                titleRegionBitmap.recycle();
            }
            Bitmap bottomTextRegionBitmap = segmentation.getBottomTextRegionBitmap();
            if (bottomTextRegionBitmap != null) {
                bottomTextRegionBitmap.recycle();
            }
            Bitmap setSymbolBitmap = segmentation.getSetSymbolBitmap();
            if (setSymbolBitmap != null) {
                setSymbolBitmap.recycle();
            }
            Bitmap pListBitmap = segmentation.getPListBitmap();
            if (pListBitmap != null) {
                pListBitmap.recycle();
            }
        } catch (Exception unused) {
        }
    }

    public final void flashCardDetection(final CardSegmentation segmentation, final int bitmapWidth, final int bitmapHeight, final int viewFinderWidth, final int viewFinderHeight, final boolean ownsSegmentation) {
        if (!Intrinsics.areEqual(Thread.currentThread(), getContext().getMainLooper().getThread())) {
            post(new Runnable() { // from class: com.studiolaganne.lengendarylens.BoundingBoxOverlayView$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.flashCardDetection(segmentation, bitmapWidth, bitmapHeight, viewFinderWidth, viewFinderHeight, ownsSegmentation);
                }
            });
            return;
        }
        ValueAnimator valueAnimator = this.flashAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (segmentation == null) {
            return;
        }
        if (this.flashSegmentationOwnsBitmaps) {
            recycleCardSegmentationBitmaps(this.flashCardSegmentation);
        }
        this.flashCardSegmentation = segmentation;
        this.flashSegmentationOwnsBitmaps = ownsSegmentation;
        this.flashBitmapWidth = bitmapWidth;
        this.flashBitmapHeight = bitmapHeight;
        this.flashViewFinderWidth = viewFinderWidth;
        this.flashViewFinderHeight = viewFinderHeight;
        this.isFlashing = true;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(600L);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.studiolaganne.lengendarylens.BoundingBoxOverlayView$$ExternalSyntheticLambda1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                BoundingBoxOverlayView.flashCardDetection$lambda$1$0(this.f$0, valueAnimator2);
            }
        });
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.studiolaganne.lengendarylens.BoundingBoxOverlayView$flashCardDetection$2$2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.this$0.isFlashing = false;
                if (this.this$0.flashSegmentationOwnsBitmaps) {
                    BoundingBoxOverlayView boundingBoxOverlayView = this.this$0;
                    boundingBoxOverlayView.recycleCardSegmentationBitmaps(boundingBoxOverlayView.flashCardSegmentation);
                }
                this.this$0.flashCardSegmentation = null;
                this.this$0.invalidate();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.this$0.isFlashing = false;
                if (this.this$0.flashSegmentationOwnsBitmaps) {
                    BoundingBoxOverlayView boundingBoxOverlayView = this.this$0;
                    boundingBoxOverlayView.recycleCardSegmentationBitmaps(boundingBoxOverlayView.flashCardSegmentation);
                }
                this.this$0.flashCardSegmentation = null;
                this.this$0.invalidate();
            }
        });
        valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
        valueAnimatorOfFloat.start();
        this.flashAnimator = valueAnimatorOfFloat;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float height;
        int i;
        float f;
        Bitmap pListBitmap;
        Bitmap pListBitmap2;
        Bitmap setSymbolBitmap;
        Bitmap setSymbolBitmap2;
        Bitmap bottomTextRegionBitmap;
        Bitmap bottomTextRegionBitmap2;
        Bitmap titleRegionBitmap;
        Bitmap titleRegionBitmap2;
        Bitmap cardBitmap;
        CardSegmentation cardSegmentation;
        Bitmap cardBitmap2;
        CardSegmentation cardSegmentation2;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.isFlashing && (cardSegmentation2 = this.flashCardSegmentation) != null) {
            if (cardSegmentation2 == null || cardSegmentation2.getCorners().size() < 4) {
                return;
            }
            drawFlashCornerLines(canvas, cardSegmentation2.getCorners());
            return;
        }
        Bitmap bitmap = this.debugImage;
        if (bitmap != null) {
            int width = (int) (bitmap.getWidth() * 0.2f);
            int height2 = (int) (bitmap.getHeight() * 0.2f);
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, width, height2, true);
            RectF rectF = new RectF(10.0f, 10.0f, width + 10.0f, height2 + 10.0f);
            Paint paint = new Paint();
            paint.setColor(-1);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(2.0f);
            Unit unit = Unit.INSTANCE;
            canvas.drawRect(rectF, paint);
            canvas.drawBitmap(bitmapCreateScaledBitmap, 10.0f, 10.0f, (Paint) null);
        }
        Bitmap bitmap2 = this.debugMaskBitmap;
        float f2 = 20.0f;
        if (bitmap2 != null) {
            int width2 = (int) (bitmap2.getWidth() * 0.2f);
            int height3 = (int) (bitmap2.getHeight() * 0.2f);
            Bitmap bitmapCreateScaledBitmap2 = Bitmap.createScaledBitmap(bitmap2, width2, height3, true);
            height = this.debugImage != null ? (r12.getHeight() * 0.2f) + 20.0f + 10.0f : 10.0f;
            RectF rectF2 = new RectF(10.0f, height, width2 + 10.0f, height3 + height);
            Paint paint2 = new Paint();
            paint2.setColor(-1);
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setStrokeWidth(2.0f);
            Unit unit2 = Unit.INSTANCE;
            canvas.drawRect(rectF2, paint2);
            canvas.drawBitmap(bitmapCreateScaledBitmap2, 10.0f, height, (Paint) null);
        } else {
            height = 10.0f;
        }
        CardSegmentation cardSegmentation3 = this.cardSegmentation;
        if (cardSegmentation3 != null && (cardBitmap2 = cardSegmentation3.getCardBitmap()) != null) {
            int width3 = (int) (cardBitmap2.getWidth() * 0.35f);
            int height4 = (int) (cardBitmap2.getHeight() * 0.35f);
            Bitmap bitmapCreateScaledBitmap3 = Bitmap.createScaledBitmap(cardBitmap2, width3, height4, true);
            if (this.debugMaskBitmap != null) {
                height += (r14.getHeight() * 0.2f) + 20.0f;
            }
            RectF rectF3 = new RectF(10.0f, height, width3 + 10.0f, height4 + height);
            Paint paint3 = new Paint();
            paint3.setColor(-1);
            paint3.setStyle(Paint.Style.STROKE);
            paint3.setStrokeWidth(2.0f);
            Unit unit3 = Unit.INSTANCE;
            canvas.drawRect(rectF3, paint3);
            canvas.drawBitmap(bitmapCreateScaledBitmap3, 10.0f, height, (Paint) null);
        }
        int i2 = 0;
        if (!this.drawPolygon || (cardSegmentation = this.cardSegmentation) == null) {
            i = 0;
            f = 20.0f;
        } else {
            Path path = new Path();
            List<PointF> polygonPoints = cardSegmentation.getPolygonPoints();
            if (polygonPoints.isEmpty()) {
                i = 0;
                f = 20.0f;
            } else {
                PointF pointFMapToScreenCoordinates = mapToScreenCoordinates(polygonPoints.get(0));
                path.moveTo(pointFMapToScreenCoordinates.x, pointFMapToScreenCoordinates.y);
                int size = polygonPoints.size();
                int i3 = 1;
                while (i3 < size) {
                    int i4 = i2;
                    PointF pointFMapToScreenCoordinates2 = mapToScreenCoordinates(polygonPoints.get(i3));
                    path.lineTo(pointFMapToScreenCoordinates2.x, pointFMapToScreenCoordinates2.y);
                    i3++;
                    f2 = f2;
                    i2 = i4;
                }
                i = i2;
                f = f2;
                path.close();
                canvas.drawPath(path, this.polygonPaint);
            }
            Iterator<PointF> it = cardSegmentation.getCorners().iterator();
            while (it.hasNext()) {
                PointF pointFMapToScreenCoordinates3 = mapToScreenCoordinates(it.next());
                canvas.drawCircle(pointFMapToScreenCoordinates3.x, pointFMapToScreenCoordinates3.y, 10.0f, this.cornerPaint);
            }
        }
        CardSegmentation cardSegmentation4 = this.cardSegmentation;
        if (cardSegmentation4 != null && (cardBitmap = cardSegmentation4.getCardBitmap()) != null) {
            height += (cardBitmap.getHeight() * 0.35f) + f;
        }
        CardSegmentation cardSegmentation5 = this.cardSegmentation;
        if (cardSegmentation5 != null && (titleRegionBitmap2 = cardSegmentation5.getTitleRegionBitmap()) != null) {
            int width4 = (int) (titleRegionBitmap2.getWidth() * 0.25f);
            int height5 = (int) (titleRegionBitmap2.getHeight() * 0.25f);
            Bitmap bitmapCreateScaledBitmap4 = Bitmap.createScaledBitmap(titleRegionBitmap2, width4, height5, true);
            RectF rectF4 = new RectF(10.0f, height, width4 + 10.0f, height5 + height);
            Paint paint4 = new Paint();
            paint4.setColor(-1);
            paint4.setStyle(Paint.Style.STROKE);
            paint4.setStrokeWidth(2.0f);
            Unit unit4 = Unit.INSTANCE;
            canvas.drawRect(rectF4, paint4);
            canvas.drawBitmap(bitmapCreateScaledBitmap4, 10.0f, height, (Paint) null);
        }
        CardSegmentation cardSegmentation6 = this.cardSegmentation;
        if (cardSegmentation6 != null && (titleRegionBitmap = cardSegmentation6.getTitleRegionBitmap()) != null) {
            height += (titleRegionBitmap.getHeight() * 0.25f) + f;
        }
        CardSegmentation cardSegmentation7 = this.cardSegmentation;
        if (cardSegmentation7 != null && (bottomTextRegionBitmap2 = cardSegmentation7.getBottomTextRegionBitmap()) != null) {
            int width5 = (int) (bottomTextRegionBitmap2.getWidth() * 0.25f);
            int height6 = (int) (bottomTextRegionBitmap2.getHeight() * 0.25f);
            Bitmap bitmapCreateScaledBitmap5 = Bitmap.createScaledBitmap(bottomTextRegionBitmap2, width5, height6, true);
            RectF rectF5 = new RectF(10.0f, height, width5 + 10.0f, height6 + height);
            Paint paint5 = new Paint();
            paint5.setColor(-1);
            paint5.setStyle(Paint.Style.STROKE);
            paint5.setStrokeWidth(2.0f);
            Unit unit5 = Unit.INSTANCE;
            canvas.drawRect(rectF5, paint5);
            canvas.drawBitmap(bitmapCreateScaledBitmap5, 10.0f, height, (Paint) null);
        }
        CardSegmentation cardSegmentation8 = this.cardSegmentation;
        if (cardSegmentation8 != null && (bottomTextRegionBitmap = cardSegmentation8.getBottomTextRegionBitmap()) != null) {
            height += (bottomTextRegionBitmap.getHeight() * 0.25f) + f;
        }
        CardSegmentation cardSegmentation9 = this.cardSegmentation;
        if (cardSegmentation9 != null && (setSymbolBitmap2 = cardSegmentation9.getSetSymbolBitmap()) != null) {
            RectF rectF6 = new RectF(10.0f, height, setSymbolBitmap2.getWidth() + 10.0f, setSymbolBitmap2.getHeight() + height);
            Paint paint6 = new Paint();
            paint6.setColor(-1);
            paint6.setStyle(Paint.Style.STROKE);
            paint6.setStrokeWidth(2.0f);
            Unit unit6 = Unit.INSTANCE;
            canvas.drawRect(rectF6, paint6);
            canvas.drawBitmap(setSymbolBitmap2, 10.0f, height, (Paint) null);
        }
        CardSegmentation cardSegmentation10 = this.cardSegmentation;
        if (cardSegmentation10 != null && (setSymbolBitmap = cardSegmentation10.getSetSymbolBitmap()) != null) {
            height += (setSymbolBitmap.getHeight() * 1.0f) + f;
        }
        CardSegmentation cardSegmentation11 = this.cardSegmentation;
        if (cardSegmentation11 != null && (pListBitmap2 = cardSegmentation11.getPListBitmap()) != null) {
            RectF rectF7 = new RectF(10.0f, height, pListBitmap2.getWidth() + 10.0f, pListBitmap2.getHeight() + height);
            Paint paint7 = new Paint();
            paint7.setColor(-1);
            paint7.setStyle(Paint.Style.STROKE);
            paint7.setStrokeWidth(2.0f);
            Unit unit7 = Unit.INSTANCE;
            canvas.drawRect(rectF7, paint7);
            canvas.drawBitmap(pListBitmap2, 10.0f, height, (Paint) null);
        }
        CardSegmentation cardSegmentation12 = this.cardSegmentation;
        if (cardSegmentation12 != null && (pListBitmap = cardSegmentation12.getPListBitmap()) != null) {
            height += (pListBitmap.getHeight() * 0.5f) + f;
        }
        String str = this.debugInfo;
        String[] strArr = new String[1];
        strArr[i] = "\n";
        List listSplit$default = StringsKt.split$default((CharSequence) str, strArr, false, 0, 6, (Object) null);
        int size2 = listSplit$default.size();
        for (int i5 = i; i5 < size2; i5++) {
            canvas.drawText((String) listSplit$default.get(i5), 10.0f, (i5 * 30.0f) + height + 30.0f, this.debugPaint);
        }
        canvas.drawText(this.debugCardClass, 10.0f, height + 120.0f, this.debugPaint);
    }

    public final void removePolygons() {
        this.drawPolygon = false;
        ValueAnimator valueAnimator = this.flashAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.isFlashing = false;
        invalidate();
    }

    public final void updateCardDetection(CardSegmentation segmentation, Bitmap debugImage, Bitmap debugMask, String debugInfo, String debugCardClass, int bitmapWidth, int bitmapHeight, int viewFinderWidth, int viewFinderHeight) {
        Intrinsics.checkNotNullParameter(debugInfo, "debugInfo");
        Intrinsics.checkNotNullParameter(debugCardClass, "debugCardClass");
        this.drawPolygon = true;
        recycleCardSegmentationBitmaps(this.cardSegmentation);
        this.cardSegmentation = segmentation;
        this.debugImage = debugImage;
        this.debugMaskBitmap = debugMask;
        this.debugInfo = debugInfo;
        this.bitmapWidth = bitmapWidth;
        this.bitmapHeight = bitmapHeight;
        this.viewFinderWidth = viewFinderWidth;
        this.viewFinderHeight = viewFinderHeight;
        this.debugCardClass = debugCardClass;
        invalidate();
    }
}
