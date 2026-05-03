package com.studiolaganne.lengendarylens;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: ViewExtensions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a&\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007\u001a\u0018\u0010\t\u001a\u00020\u0004*\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007\u001a\u0018\u0010\u000b\u001a\u00020\u0004*\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007\u001a6\u0010\f\u001a\u00020\u0004*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0007\u001a-\u0010\r\u001a\u00020\u0004*\u00020\u00052!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00040\u000e\u001a\u0018\u0010\u0013\u001a\u00020\u0004*\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007¨\u0006\u0014"}, d2 = {"getScaledDensity", "", "Landroid/content/Context;", "setOnManualSwipeListener", "", "Landroid/view/View;", "onSwipeLeft", "Lkotlin/Function0;", "onSwipeRight", "setOnClickWithBounce", "onClick", "setOnClickWithFade", "setOnSwipeAndClickListener", "setOnClickTopOrBottomHalf", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isTopHalf", "setOnClickWithBounceTransparent", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ViewExtensionsKt {
    public static final float getScaledDensity(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return context.getResources().getDisplayMetrics().scaledDensity;
    }

    public static final void setOnClickTopOrBottomHalf(View view, final Function1<? super Boolean, Unit> onClick) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.studiolaganne.lengendarylens.ViewExtensionsKt$$ExternalSyntheticLambda5
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return ViewExtensionsKt.setOnClickTopOrBottomHalf$lambda$0(onClick, view2, motionEvent);
            }
        });
    }

    static final boolean setOnClickTopOrBottomHalf$lambda$0(Function1 function1, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            function1.invoke(Boolean.valueOf(motionEvent.getY() < ((float) view.getHeight()) / 2.0f));
        }
        return true;
    }

    public static final void setOnClickWithBounce(final View view, final Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        view.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.ViewExtensionsKt$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ViewExtensionsKt.setOnClickWithBounce$lambda$0(view, onClick, view2);
            }
        });
    }

    static final void setOnClickWithBounce$lambda$0(View view, Function0 function0, View view2) {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "scaleX", 1.1f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 1.1f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, "scaleX", 1.0f);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f);
        objectAnimatorOfFloat.setDuration(100L);
        objectAnimatorOfFloat2.setDuration(100L);
        objectAnimatorOfFloat3.setDuration(100L);
        objectAnimatorOfFloat4.setDuration(100L);
        animatorSet.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2).before(objectAnimatorOfFloat3).before(objectAnimatorOfFloat4);
        animatorSet.start();
        function0.invoke();
    }

    public static final void setOnClickWithBounceTransparent(final View view, final Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.studiolaganne.lengendarylens.ViewExtensionsKt$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return ViewExtensionsKt.setOnClickWithBounceTransparent$lambda$0(view, onClick, view2, motionEvent);
            }
        });
    }

    static final boolean setOnClickWithBounceTransparent$lambda$0(View view, Function0 function0, View view2, MotionEvent motionEvent) {
        ImageView imageView;
        Drawable drawable;
        BitmapDrawable bitmapDrawable;
        Bitmap bitmap;
        Bitmap bitmap2;
        if (motionEvent.getAction() == 0 && (view2 instanceof ImageView)) {
            ImageView imageView2 = (ImageView) view2;
            Drawable drawable2 = imageView2.getDrawable();
            if (drawable2 == null) {
                return false;
            }
            bitmapDrawable = drawable2 instanceof BitmapDrawable ? (BitmapDrawable) drawable2 : null;
            if (bitmapDrawable != null && (bitmap2 = bitmapDrawable.getBitmap()) != null) {
                Matrix imageMatrix = imageView2.getImageMatrix();
                Matrix matrix = new Matrix();
                imageMatrix.invert(matrix);
                float[] fArr = {motionEvent.getX(), motionEvent.getY()};
                matrix.mapPoints(fArr);
                int i = (int) fArr[0];
                int i2 = (int) fArr[1];
                if (i >= 0 && i < bitmap2.getWidth() && i2 >= 0 && i2 < bitmap2.getHeight() && Color.alpha(bitmap2.getPixel(i, i2)) > 0) {
                    return true;
                }
            }
            return false;
        }
        if (motionEvent.getAction() != 1 || !(view2 instanceof ImageView) || (drawable = (imageView = (ImageView) view2).getDrawable()) == null) {
            return false;
        }
        bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
        if (bitmapDrawable != null && (bitmap = bitmapDrawable.getBitmap()) != null) {
            Matrix imageMatrix2 = imageView.getImageMatrix();
            Matrix matrix2 = new Matrix();
            imageMatrix2.invert(matrix2);
            float[] fArr2 = {motionEvent.getX(), motionEvent.getY()};
            matrix2.mapPoints(fArr2);
            int i3 = (int) fArr2[0];
            int i4 = (int) fArr2[1];
            if (i3 >= 0 && i3 < bitmap.getWidth() && i4 >= 0 && i4 < bitmap.getHeight() && Color.alpha(bitmap.getPixel(i3, i4)) > 0) {
                AnimatorSet animatorSet = new AnimatorSet();
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "scaleX", 1.1f);
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 1.1f);
                ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, "scaleX", 1.0f);
                ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f);
                objectAnimatorOfFloat.setDuration(100L);
                objectAnimatorOfFloat2.setDuration(100L);
                objectAnimatorOfFloat3.setDuration(100L);
                objectAnimatorOfFloat4.setDuration(100L);
                animatorSet.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2).before(objectAnimatorOfFloat3).before(objectAnimatorOfFloat4);
                animatorSet.start();
                view.performClick();
                function0.invoke();
                return true;
            }
        }
        return false;
    }

    public static final void setOnClickWithFade(final View view, final Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        view.setOnClickListener(new View.OnClickListener() { // from class: com.studiolaganne.lengendarylens.ViewExtensionsKt$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ViewExtensionsKt.setOnClickWithFade$lambda$0(view, onClick, view2);
            }
        });
    }

    static final void setOnClickWithFade$lambda$0(View view, Function0 function0, View view2) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.5f, 1.0f);
        objectAnimatorOfFloat.setDuration(200L);
        objectAnimatorOfFloat.start();
        function0.invoke();
    }

    public static final void setOnManualSwipeListener(View view, final Function0<Unit> onSwipeLeft, final Function0<Unit> onSwipeRight) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(onSwipeLeft, "onSwipeLeft");
        Intrinsics.checkNotNullParameter(onSwipeRight, "onSwipeRight");
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        final Ref.FloatRef floatRef2 = new Ref.FloatRef();
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.studiolaganne.lengendarylens.ViewExtensionsKt$$ExternalSyntheticLambda2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return ViewExtensionsKt.setOnManualSwipeListener$lambda$0(floatRef, floatRef2, onSwipeRight, onSwipeLeft, view2, motionEvent);
            }
        });
    }

    static final boolean setOnManualSwipeListener$lambda$0(Ref.FloatRef floatRef, Ref.FloatRef floatRef2, Function0 function0, Function0 function02, View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            floatRef.element = motionEvent.getX();
            floatRef2.element = motionEvent.getY();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        } else if (action == 1) {
            ViewParent parent2 = view.getParent();
            if (parent2 != null) {
                parent2.requestDisallowInterceptTouchEvent(false);
            }
            float x = motionEvent.getX() - floatRef.element;
            if (Math.abs(x) > Math.abs(motionEvent.getY() - floatRef2.element) && Math.abs(x) > 100.0f) {
                if (x > 0.0f) {
                    function0.invoke();
                } else {
                    function02.invoke();
                }
                return true;
            }
        }
        return false;
    }

    public static final void setOnSwipeAndClickListener(View view, final Function0<Unit> onSwipeLeft, final Function0<Unit> onSwipeRight, final Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(onSwipeLeft, "onSwipeLeft");
        Intrinsics.checkNotNullParameter(onSwipeRight, "onSwipeRight");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        final Ref.FloatRef floatRef2 = new Ref.FloatRef();
        final Ref.LongRef longRef = new Ref.LongRef();
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final int i = 10;
        final long j = 200;
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.studiolaganne.lengendarylens.ViewExtensionsKt$$ExternalSyntheticLambda3
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return ViewExtensionsKt.setOnSwipeAndClickListener$lambda$0(floatRef, floatRef2, longRef, booleanRef, i, j, onClick, onSwipeRight, onSwipeLeft, view2, motionEvent);
            }
        });
    }

    static final boolean setOnSwipeAndClickListener$lambda$0(Ref.FloatRef floatRef, Ref.FloatRef floatRef2, Ref.LongRef longRef, Ref.BooleanRef booleanRef, int i, long j, Function0 function0, Function0 function02, Function0 function03, View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            floatRef.element = motionEvent.getX();
            floatRef2.element = motionEvent.getY();
            longRef.element = System.currentTimeMillis();
            booleanRef.element = false;
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            return true;
        }
        if (action != 1) {
            if (action == 2) {
                float x = motionEvent.getX() - floatRef.element;
                float y = motionEvent.getY() - floatRef2.element;
                if (Math.abs(x) > Math.abs(y)) {
                    booleanRef.element = true;
                    ViewParent parent2 = view.getParent();
                    if (parent2 != null) {
                        parent2.requestDisallowInterceptTouchEvent(true);
                    }
                } else if (Math.abs(y) > i * 2) {
                    ViewParent parent3 = view.getParent();
                    if (parent3 != null) {
                        parent3.requestDisallowInterceptTouchEvent(false);
                    }
                    return false;
                }
                return true;
            }
            if (action != 3) {
                return false;
            }
        }
        ViewParent parent4 = view.getParent();
        if (parent4 != null) {
            parent4.requestDisallowInterceptTouchEvent(false);
        }
        if (motionEvent.getAction() == 3) {
            return false;
        }
        float x2 = motionEvent.getX() - floatRef.element;
        float y2 = motionEvent.getY() - floatRef2.element;
        long jCurrentTimeMillis = System.currentTimeMillis() - longRef.element;
        float f = i;
        if (Math.abs(x2) < f && Math.abs(y2) < f && jCurrentTimeMillis < j) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.5f, 1.0f);
            objectAnimatorOfFloat.setDuration(200L);
            objectAnimatorOfFloat.start();
            function0.invoke();
            return true;
        }
        if (Math.abs(x2) <= Math.abs(y2) || Math.abs(x2) <= 100.0f) {
            return false;
        }
        if (x2 > 0.0f) {
            function02.invoke();
        } else {
            function03.invoke();
        }
        return true;
    }
}
