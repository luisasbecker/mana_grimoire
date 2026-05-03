package com.tbuonomo.viewpagerdotsindicator;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Extensions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0016\u0010\u0007\u001a\u00020\b*\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\f\u0010\f\u001a\u00020\r*\u00020\u000eH\u0000\u001a*\u0010\u000f\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0010*\u0012\u0012\u0004\u0012\u0002H\u00100\u0011j\b\u0012\u0004\u0012\u0002H\u0010`\u00122\u0006\u0010\u0013\u001a\u00020\rH\u0000\u001a\u0011\u0010\u0014\u001a\u00020\t*\u00020\bH\u0007¢\u0006\u0002\u0010\u000b\u001a\u0011\u0010\u0014\u001a\u00020\t*\u00020\rH\u0007¢\u0006\u0002\u0010\u0015\u001a\u0014\u0010\u0016\u001a\u00020\u0017*\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u001a\u0014\u0010\u001b\u001a\u00020\u0017*\u00020\u00182\u0006\u0010\u001c\u001a\u00020\rH\u0000\u001a\u0014\u0010\u001d\u001a\u00020\u0017*\u00020\u00182\u0006\u0010\u001c\u001a\u00020\rH\u0000\u001a\u0014\u0010\u001e\u001a\u00020\u0017*\u00020\u00182\u0006\u0010\u001f\u001a\u00020\rH\u0000\"\u001a\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u001a\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0005\"\u0018\u0010\u0006\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0003\"\u0018\u0010\u0006\u001a\u00020\u0001*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0005\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006 "}, d2 = {"isEmpty", "", "Landroidx/viewpager/widget/ViewPager;", "(Landroidx/viewpager/widget/ViewPager;)Z", "Landroidx/viewpager2/widget/ViewPager2;", "(Landroidx/viewpager2/widget/ViewPager2;)Z", "isNotEmpty", "dpToPx", "", "Landroidx/compose/ui/unit/Dp;", "dpToPx-8Feqmps", "(FLandroidx/compose/runtime/Composer;I)F", "getThemePrimaryColor", "", "Landroid/content/Context;", "isInBounds", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", FirebaseAnalytics.Param.INDEX, "pxToDp", "(ILandroidx/compose/runtime/Composer;I)F", "setBackgroundCompat", "", "Landroid/view/View;", "background", "Landroid/graphics/drawable/Drawable;", "setPaddingHorizontal", "padding", "setPaddingVertical", "setWidth", "width", "viewpagerdotsindicator_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ExtensionsKt {
    /* JADX INFO: renamed from: dpToPx-8Feqmps, reason: not valid java name */
    public static final float m11282dpToPx8Feqmps(float f, Composer composer, int i) {
        composer.startReplaceGroup(141686460);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(141686460, i, -1, "com.tbuonomo.viewpagerdotsindicator.dpToPx (Extensions.kt:50)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        float fMo1624toPx0680j_4 = ((Density) objConsume).mo1624toPx0680j_4(f);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return fMo1624toPx0680j_4;
    }

    public static final int getThemePrimaryColor(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, typedValue, true);
        return typedValue.data;
    }

    public static final boolean isEmpty(ViewPager viewPager) {
        PagerAdapter adapter;
        return (viewPager == null || (adapter = viewPager.getAdapter()) == null || adapter.getCount() != 0) ? false : true;
    }

    public static final boolean isEmpty(ViewPager2 viewPager2) {
        RecyclerView.Adapter adapter;
        return (viewPager2 == null || (adapter = viewPager2.getAdapter()) == null || adapter.getItemCount() != 0) ? false : true;
    }

    public static final <T> boolean isInBounds(ArrayList<T> arrayList, int i) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        return i >= 0 && i < arrayList.size();
    }

    public static final boolean isNotEmpty(ViewPager viewPager) {
        Intrinsics.checkNotNullParameter(viewPager, "<this>");
        PagerAdapter adapter = viewPager.getAdapter();
        return (adapter != null ? adapter.getCount() : 0) > 0;
    }

    public static final boolean isNotEmpty(ViewPager2 viewPager2) {
        Intrinsics.checkNotNullParameter(viewPager2, "<this>");
        RecyclerView.Adapter adapter = viewPager2.getAdapter();
        return (adapter != null ? adapter.getItemCount() : 0) > 0;
    }

    public static final float pxToDp(float f, Composer composer, int i) {
        composer.startReplaceGroup(-1886190216);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1886190216, i, -1, "com.tbuonomo.viewpagerdotsindicator.pxToDp (Extensions.kt:56)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        float fMo1620toDpu2uoSUM = ((Density) objConsume).mo1620toDpu2uoSUM(f);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return fMo1620toDpu2uoSUM;
    }

    public static final float pxToDp(int i, Composer composer, int i2) {
        composer.startReplaceGroup(2066720075);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2066720075, i2, -1, "com.tbuonomo.viewpagerdotsindicator.pxToDp (Extensions.kt:53)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        float fMo1621toDpu2uoSUM = ((Density) objConsume).mo1621toDpu2uoSUM(i);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return fMo1621toDpu2uoSUM;
    }

    public static final void setBackgroundCompat(View view, Drawable drawable) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setBackground(drawable);
    }

    public static final void setPaddingHorizontal(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setPadding(i, view.getPaddingTop(), i, view.getPaddingBottom());
    }

    public static final void setPaddingVertical(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), i);
    }

    public static final void setWidth(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.getLayoutParams().width = i;
        view.requestLayout();
    }
}
