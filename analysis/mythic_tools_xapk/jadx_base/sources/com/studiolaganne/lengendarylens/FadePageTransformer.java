package com.studiolaganne.lengendarylens;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FadePageTransformer.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/studiolaganne/lengendarylens/FadePageTransformer;", "Landroidx/viewpager2/widget/ViewPager2$PageTransformer;", "<init>", "()V", "transformPage", "", "page", "Landroid/view/View;", "position", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FadePageTransformer implements ViewPager2.PageTransformer {
    public static final int $stable = 0;

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(View page, float position) {
        Intrinsics.checkNotNullParameter(page, "page");
        if (position < -1.0f) {
            page.setAlpha(0.0f);
            return;
        }
        if (position <= 0.0f) {
            page.setAlpha(1.0f + position);
        } else if (position <= 1.0f) {
            page.setAlpha(1.0f - position);
        } else {
            page.setAlpha(0.0f);
        }
    }
}
