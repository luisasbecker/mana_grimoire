package com.vanniktech.ui;

import android.view.Window;
import androidx.core.view.WindowInsetsControllerCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidWindow.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\u001a1\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n\u001a\u001b\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a\u001b\u0010\u000f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u000e¨\u0006\u0011"}, d2 = {"themeWindow", "", "Landroid/view/Window;", "statusBarColor", "Lcom/vanniktech/ui/Color;", "navigationBarColor", "lightNavigationBars", "", "lightStatusBars", "themeWindow-fLw27eE", "(Landroid/view/Window;IIZZ)V", "setStatusBarColor", "color", "setStatusBarColor-xAbW3D8", "(Landroid/view/Window;I)V", "setNavigationBarColor", "setNavigationBarColor-xAbW3D8", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidWindowKt {
    /* JADX INFO: renamed from: setNavigationBarColor-xAbW3D8, reason: not valid java name */
    private static final void m11356setNavigationBarColorxAbW3D8(Window window, int i) {
        window.setNavigationBarColor(i);
    }

    /* JADX INFO: renamed from: setStatusBarColor-xAbW3D8, reason: not valid java name */
    private static final void m11357setStatusBarColorxAbW3D8(Window window, int i) {
        window.setStatusBarColor(i);
    }

    /* JADX INFO: renamed from: themeWindow-fLw27eE, reason: not valid java name */
    public static final void m11358themeWindowfLw27eE(Window themeWindow, int i, int i2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(themeWindow, "$this$themeWindow");
        WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(themeWindow, themeWindow.getDecorView());
        windowInsetsControllerCompat.setAppearanceLightNavigationBars(z);
        windowInsetsControllerCompat.setAppearanceLightStatusBars(z2);
        m11357setStatusBarColorxAbW3D8(themeWindow, i);
        m11356setNavigationBarColorxAbW3D8(themeWindow, i2);
    }
}
