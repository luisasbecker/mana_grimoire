package com.vanniktech.ui;

import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidDialog.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"show", "Landroidx/appcompat/app/AlertDialog;", "Lcom/google/android/material/dialog/MaterialAlertDialogBuilder;", "background", "Lcom/vanniktech/ui/Color;", "colorRipple", "colorButton", "show-CoujqA8", "(Lcom/google/android/material/dialog/MaterialAlertDialogBuilder;III)Landroidx/appcompat/app/AlertDialog;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidDialogKt {
    /* JADX INFO: renamed from: show-CoujqA8, reason: not valid java name */
    public static final AlertDialog m11328showCoujqA8(MaterialAlertDialogBuilder show, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(show, "$this$show");
        show.setBackground(AndroidColorKt.m11317ColorDrawableXxRhnUA(i));
        AlertDialog alertDialogShow = show.show();
        Button button = alertDialogShow.getButton(-1);
        if (button != null) {
            show_CoujqA8$tint(button, i3, i2);
        }
        Button button2 = alertDialogShow.getButton(-3);
        if (button2 != null) {
            show_CoujqA8$tint(button2, i3, i2);
        }
        Button button3 = alertDialogShow.getButton(-2);
        if (button3 != null) {
            show_CoujqA8$tint(button3, i3, i2);
        }
        Intrinsics.checkNotNull(alertDialogShow);
        return alertDialogShow;
    }

    private static final void show_CoujqA8$tint(Button button, int i, int i2) {
        AndroidColorKt.m11325setTextColorxAbW3D8(button, i);
        if (button instanceof MaterialButton) {
            ((MaterialButton) button).setRippleColor(AndroidColorKt.m11319colorStateListXxRhnUA(i2));
        }
    }
}
