package com.vanniktech.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RotateDrawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.collection.ArrayMap;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidThemingHacks.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001b\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\b\u0010\u0006\u001a+\u0010\t\u001a\u0004\u0018\u00010\n*\u0006\u0012\u0002\b\u00030\u000b2\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r\"\u00020\u000eH\u0000¢\u0006\u0002\u0010\u000f\u001a\u0019\u0010\u0010\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0019\u0010\u0014\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0018\u0010\u0017\u001a\u00020\u0018*\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002¨\u0006\u001c"}, d2 = {"setHandlesColor", "", "Landroid/widget/TextView;", "color", "Lcom/vanniktech/ui/Color;", "setHandlesColor-xAbW3D8", "(Landroid/widget/TextView;I)V", "setCursorDrawableColor", "setCursorDrawableColor-xAbW3D8", "getFieldByName", "Ljava/lang/reflect/Field;", "Ljava/lang/Class;", "name", "", "", "(Ljava/lang/Class;[Ljava/lang/String;)Ljava/lang/reflect/Field;", "setTint", "Landroid/graphics/drawable/Drawable;", "setTint-xAbW3D8", "(Landroid/graphics/drawable/Drawable;I)V", "tinted", "tinted-xAbW3D8", "(Landroid/graphics/drawable/Drawable;I)Landroid/graphics/drawable/Drawable;", "spToPx", "", "", "context", "Landroid/content/Context;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidThemingHacksKt {
    public static final Field getFieldByName(Class<?> cls, String... name) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        for (String str : name) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                declaredField.setAccessible(true);
                return declaredField;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: setCursorDrawableColor-xAbW3D8, reason: not valid java name */
    public static final void m11330setCursorDrawableColorxAbW3D8(TextView setCursorDrawableColor, int i) {
        Object obj;
        Drawable drawable;
        Drawable drawableM11333tintedxAbW3D8;
        Intrinsics.checkNotNullParameter(setCursorDrawableColor, "$this$setCursorDrawableColor");
        if (Build.VERSION.SDK_INT >= 29) {
            CursorDrawable cursorDrawable = new CursorDrawable(i, null);
            cursorDrawable.setSize((int) spToPx((Number) 2, setCursorDrawableColor.getContext()), (int) setCursorDrawableColor.getTextSize());
            setCursorDrawableColor.setTextCursorDrawable(cursorDrawable);
            return;
        }
        try {
            Field fieldByName = getFieldByName(TextView.class, "mEditor");
            if (fieldByName == null || (obj = fieldByName.get(setCursorDrawableColor)) == null) {
                obj = setCursorDrawableColor;
            }
            Class cls = fieldByName != null ? obj.getClass() : TextView.class;
            Field fieldByName2 = getFieldByName(TextView.class, "mCursorDrawableRes");
            Object obj2 = fieldByName2 != null ? fieldByName2.get(setCursorDrawableColor) : null;
            Integer num = obj2 instanceof Integer ? (Integer) obj2 : null;
            if (num != null && (drawable = ContextCompat.getDrawable(setCursorDrawableColor.getContext(), num.intValue())) != null && (drawableM11333tintedxAbW3D8 = m11333tintedxAbW3D8(drawable, i)) != null) {
                Field fieldByName3 = Build.VERSION.SDK_INT >= 28 ? getFieldByName(cls, "mDrawableForCursor") : null;
                if (fieldByName3 != null) {
                    fieldByName3.set(obj, drawableM11333tintedxAbW3D8);
                    return;
                }
                Field fieldByName4 = getFieldByName(cls, "mCursorDrawable", "mDrawableForCursor");
                if (fieldByName4 != null) {
                    fieldByName4.set(obj, new Drawable[]{drawableM11333tintedxAbW3D8, drawableM11333tintedxAbW3D8});
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: setHandlesColor-xAbW3D8, reason: not valid java name */
    public static final void m11331setHandlesColorxAbW3D8(TextView setHandlesColor, int i) {
        Object obj;
        Class cls;
        Intrinsics.checkNotNullParameter(setHandlesColor, "$this$setHandlesColor");
        if (Build.VERSION.SDK_INT >= 29) {
            int iSpToPx = (int) spToPx((Number) 22, setHandlesColor.getContext());
            float f = iSpToPx / 2.0f;
            int iSpToPx2 = (int) spToPx((Number) 10, setHandlesColor.getContext());
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{i, i});
            gradientDrawable.setSize(iSpToPx, iSpToPx);
            gradientDrawable.setCornerRadii(new float[]{f, f, 0.0f, 0.0f, f, f, f, f});
            setHandlesColor.setTextSelectHandleLeft(new InsetDrawable((Drawable) gradientDrawable, iSpToPx2, 0, iSpToPx2, iSpToPx2));
            GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{i, i});
            gradientDrawable2.setSize(iSpToPx, iSpToPx);
            gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, f, f, f, f, f, f});
            setHandlesColor.setTextSelectHandleRight(new InsetDrawable((Drawable) gradientDrawable2, iSpToPx2, 0, iSpToPx2, iSpToPx2));
            GradientDrawable gradientDrawable3 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{i, i});
            gradientDrawable3.setSize(iSpToPx, iSpToPx);
            gradientDrawable3.setCornerRadii(new float[]{0.0f, 0.0f, f, f, f, f, f, f});
            int iSqrt = (int) ((((float) Math.sqrt(2.0d)) * f) - f);
            InsetDrawable insetDrawable = new InsetDrawable((Drawable) gradientDrawable3, iSqrt, iSqrt, iSqrt, iSqrt);
            RotateDrawable rotateDrawable = new RotateDrawable();
            rotateDrawable.setDrawable(insetDrawable);
            rotateDrawable.setToDegrees(45.0f);
            rotateDrawable.setLevel(10000);
            setHandlesColor.setTextSelectHandle(rotateDrawable);
            return;
        }
        try {
            Field fieldByName = getFieldByName(TextView.class, "mEditor");
            if (fieldByName == null || (obj = fieldByName.get(setHandlesColor)) == null) {
                obj = setHandlesColor;
            }
            if (fieldByName != null) {
                cls = Class.forName("android.widget.Editor");
                Intrinsics.checkNotNullExpressionValue(cls, "forName(...)");
            } else {
                cls = TextView.class;
            }
            ArrayMap arrayMap = new ArrayMap(3);
            arrayMap.put("mSelectHandleLeft", "mTextSelectHandleLeftRes");
            arrayMap.put("mSelectHandleRight", "mTextSelectHandleRightRes");
            arrayMap.put("mSelectHandleCenter", "mTextSelectHandleRes");
            int size = arrayMap.getSize();
            for (int i2 = 0; i2 < size; i2++) {
                Field fieldByName2 = getFieldByName(cls, arrayMap.keyAt(i2));
                if (fieldByName2 != null) {
                    Object obj2 = fieldByName2.get(obj);
                    Drawable drawable = null;
                    Drawable drawable2 = obj2 instanceof Drawable ? (Drawable) obj2 : null;
                    if (drawable2 == null) {
                        Field fieldByName3 = getFieldByName(TextView.class, arrayMap.valueAt(i2));
                        if (fieldByName3 != null) {
                            drawable = ContextCompat.getDrawable(setHandlesColor.getContext(), fieldByName3.getInt(setHandlesColor));
                        }
                    } else {
                        drawable = drawable2;
                    }
                    if (drawable != null) {
                        fieldByName2.set(obj, m11333tintedxAbW3D8(drawable, i));
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: setTint-xAbW3D8, reason: not valid java name */
    public static final void m11332setTintxAbW3D8(Drawable setTint, int i) {
        Intrinsics.checkNotNullParameter(setTint, "$this$setTint");
        setTint.setTint(i);
    }

    private static final float spToPx(Number number, Context context) {
        Resources system;
        if (context == null || (system = context.getResources()) == null) {
            system = Resources.getSystem();
        }
        return TypedValue.applyDimension(2, number.floatValue(), system.getDisplayMetrics());
    }

    static /* synthetic */ float spToPx$default(Number number, Context context, int i, Object obj) {
        if ((i & 1) != 0) {
            context = null;
        }
        return spToPx(number, context);
    }

    /* JADX INFO: renamed from: tinted-xAbW3D8, reason: not valid java name */
    public static final Drawable m11333tintedxAbW3D8(Drawable tinted, int i) {
        Intrinsics.checkNotNullParameter(tinted, "$this$tinted");
        if (tinted instanceof VectorDrawableCompat) {
            ((VectorDrawableCompat) tinted).setTintList(AndroidColorKt.m11319colorStateListXxRhnUA(i));
            return tinted;
        }
        if (tinted instanceof VectorDrawable) {
            ((VectorDrawable) tinted).setTintList(AndroidColorKt.m11319colorStateListXxRhnUA(i));
            return tinted;
        }
        Drawable drawableWrap = DrawableCompat.wrap(tinted);
        DrawableCompat.setTint(drawableWrap, i);
        Drawable drawableUnwrap = DrawableCompat.unwrap(drawableWrap);
        Intrinsics.checkNotNullExpressionValue(drawableUnwrap, "let(...)");
        return drawableUnwrap;
    }
}
