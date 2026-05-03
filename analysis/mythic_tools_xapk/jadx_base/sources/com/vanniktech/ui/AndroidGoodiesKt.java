package com.vanniktech.ui;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: AndroidGoodies.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002\u001a\u0012\u0010\u0005\u001a\u00020\u0004*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a\u0012\u0010\u0005\u001a\u00020\u0004*\u00020\t2\u0006\u0010\u0007\u001a\u00020\b\u001a\n\u0010\n\u001a\u00020\u000b*\u00020\u0002\u001a\u0010\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\r*\u00020\u000b\u001a\u0012\u0010\u000e\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b\u001a\u0012\u0010\u000f\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b\u001a\u001a\u0010\u0010\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012\u001a\u0014\u0010\u0013\u001a\u00020\u0004*\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u001a \u0010\u0017\u001a\u00020\u0018*\u00020\u00192\b\b\u0001\u0010\u001a\u001a\u00020\u00122\b\b\u0002\u0010\u001b\u001a\u00020\u0018H\u0007¨\u0006\u001c"}, d2 = {"backgroundColor", "Lcom/vanniktech/ui/Color;", "Landroid/view/View;", "click", "", "show", "Lcom/google/android/material/floatingactionbutton/ExtendedFloatingActionButton;", "isVisible", "", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "parentViewGroup", "Landroid/view/ViewGroup;", "children", "", "visibleGone", "visibleInvisible", "visibleElse", "other", "", "setText", "Landroidx/appcompat/app/ActionBar;", TypedValues.Custom.S_STRING, "", "setTextSizeRes", "", "Landroid/widget/TextView;", "value", "factor", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidGoodiesKt {
    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0040 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Color backgroundColor(View view) {
        Integer numValueOf;
        int resolvedTintColor;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Drawable background = view.getBackground();
        ColorDrawable colorDrawable = background instanceof ColorDrawable ? (ColorDrawable) background : null;
        if (colorDrawable != null) {
            resolvedTintColor = colorDrawable.getColor();
        } else {
            Drawable background2 = view.getBackground();
            MaterialShapeDrawable materialShapeDrawable = background2 instanceof MaterialShapeDrawable ? (MaterialShapeDrawable) background2 : null;
            if (materialShapeDrawable == null) {
                numValueOf = null;
                if (numValueOf == null) {
                    return Color.m11370boximpl(ColorKt.getColor(numValueOf.intValue()));
                }
                return null;
            }
            resolvedTintColor = materialShapeDrawable.getResolvedTintColor();
        }
        numValueOf = Integer.valueOf(resolvedTintColor);
        if (numValueOf == null) {
        }
    }

    public static final List<View> children(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        IntRange intRangeUntil = RangesKt.until(0, viewGroup.getChildCount());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
        Iterator<Integer> it = intRangeUntil.iterator();
        while (it.hasNext()) {
            arrayList.add(viewGroup.getChildAt(((IntIterator) it).nextInt()));
        }
        return arrayList;
    }

    public static final void click(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (view.isEnabled()) {
            view.performClick();
        }
    }

    public static final ViewGroup parentViewGroup(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewParent parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        return (ViewGroup) parent;
    }

    public static final void setText(ActionBar actionBar, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(actionBar, "<this>");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayUseLogoEnabled(false);
        actionBar.setTitle(charSequence);
    }

    public static final float setTextSizeRes(TextView textView, int i, float f) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        float dimension = textView.getResources().getDimension(i) * f;
        textView.setTextSize(0, dimension);
        return dimension;
    }

    public static /* synthetic */ float setTextSizeRes$default(TextView textView, int i, float f, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            f = 1.0f;
        }
        return setTextSizeRes(textView, i, f);
    }

    public static final void show(ExtendedFloatingActionButton extendedFloatingActionButton, boolean z) {
        Intrinsics.checkNotNullParameter(extendedFloatingActionButton, "<this>");
        if (z) {
            extendedFloatingActionButton.show();
        } else {
            extendedFloatingActionButton.hide();
        }
    }

    public static final void show(FloatingActionButton floatingActionButton, boolean z) {
        Intrinsics.checkNotNullParameter(floatingActionButton, "<this>");
        if (z) {
            floatingActionButton.show();
        } else {
            floatingActionButton.hide();
        }
    }

    public static final void visibleElse(View view, boolean z, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (z) {
            i = 0;
        }
        view.setVisibility(i);
    }

    public static final void visibleGone(View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        visibleElse(view, z, 8);
    }

    public static final void visibleInvisible(View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        visibleElse(view, z, 4);
    }
}
