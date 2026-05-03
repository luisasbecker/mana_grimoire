package com.vanniktech.ui;

import android.content.res.ColorStateList;
import android.os.Build;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.webkit.WebSettingsCompat;
import androidx.webkit.WebViewFeature;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000¬\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0019\u0010\u0007\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\n\u001a)\u0010\u000b\u001a\u00020\u0001*\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010\u001a)\u0010\u0011\u001a\u00020\u0001*\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014\u001a9\u0010\u0015\u001a\u00020\u0001*\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u001a\u001a1\u0010\u001b\u001a\u00020\u0001*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0004¢\u0006\u0004\b!\u0010\"\u001a1\u0010#\u001a\u00020\u0001*\u00020$2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004¢\u0006\u0004\b%\u0010&\u001a)\u0010'\u001a\u00020\u0001*\u00020(2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004¢\u0006\u0004\b*\u0010+\u001a)\u0010,\u001a\u00020\u0001*\u00020-2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004¢\u0006\u0004\b.\u0010/\u001a!\u00100\u001a\u00020\u0001*\u0002012\u0006\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u000204¢\u0006\u0004\b5\u00106\u001a\u0019\u00107\u001a\u00020\u0001*\u0002082\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b9\u0010:\u001a!\u0010;\u001a\u00020\u0001*\u00020<2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u0004¢\u0006\u0004\b=\u0010>\u001a)\u0010?\u001a\u00020\u0001*\u00020@2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\bA\u0010B\u001a)\u0010C\u001a\u00020\u0001*\u00020D2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\bE\u0010F\u001a\u0019\u0010G\u001a\u00020\u0001*\u00020H2\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\bI\u0010J\u001a1\u0010K\u001a\u00020\u0001*\u00020L2\u0006\u0010M\u001a\u00020\u00042\u0006\u0010N\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004¢\u0006\u0004\bP\u0010Q\u001a1\u0010R\u001a\u00020\u0001*\u00020S2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010T\u001a\u00020\u00042\u0006\u0010U\u001a\u00020\u00042\u0006\u0010V\u001a\u00020\u0004¢\u0006\u0004\bW\u0010X\u001a9\u0010Y\u001a\u00020\u0001*\u00020Z2\u0006\u0010M\u001a\u00020\u00042\u0006\u0010[\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\\\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004¢\u0006\u0004\b]\u0010^\u001a9\u0010_\u001a\u00020\u0001*\u00020`2\u0006\u0010M\u001a\u00020\u00042\u0006\u0010a\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010b\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004¢\u0006\u0004\bc\u0010d\u001a)\u0010e\u001a\u00020\u0001*\u00020`2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010f\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004¢\u0006\u0004\bg\u0010h\u001a)\u0010i\u001a\u00020\u0001*\u00020`2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010j\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004¢\u0006\u0004\bk\u0010h\u001a)\u0010l\u001a\u00020\u0001*\u00020`2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010f\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004¢\u0006\u0004\bm\u0010h¨\u0006n"}, d2 = {"themeSeekBar", "", "Landroid/widget/SeekBar;", "color", "Lcom/vanniktech/ui/Color;", "themeSeekBar-xAbW3D8", "(Landroid/widget/SeekBar;I)V", "themeProgressBar", "Landroid/widget/ProgressBar;", "themeProgressBar-xAbW3D8", "(Landroid/widget/ProgressBar;I)V", "themeRadioButton", "Landroid/widget/RadioButton;", "colorText", "colorTextSecondary", "themeRadioButton-CoujqA8", "(Landroid/widget/RadioButton;III)V", "themeCheckBox", "Landroid/widget/CheckBox;", "themeCheckBox-CoujqA8", "(Landroid/widget/CheckBox;III)V", "themeMaterialAutoCompleteTextView", "Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;", "colorRipple", "colorDropDownBackground", "themeMaterialAutoCompleteTextView-NhWho2U", "(Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;IIIII)V", "themeToolbar", "Lcom/google/android/material/appbar/MaterialToolbar;", "colorToolbar", "colorOnToolbarPrimary", "colorOnToolbarSecondary", "colorNavigationIcon", "themeToolbar-qLjDh8k", "(Lcom/google/android/material/appbar/MaterialToolbar;IIII)V", "themeTabLayout", "Lcom/google/android/material/tabs/TabLayout;", "themeTabLayout-qLjDh8k", "(Lcom/google/android/material/tabs/TabLayout;IIII)V", "themeFloatingActionButton", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "colorOn", "themeFloatingActionButton-CoujqA8", "(Lcom/google/android/material/floatingactionbutton/FloatingActionButton;III)V", "themeExtendedFloatingActionButton", "Lcom/google/android/material/floatingactionbutton/ExtendedFloatingActionButton;", "themeExtendedFloatingActionButton-CoujqA8", "(Lcom/google/android/material/floatingactionbutton/ExtendedFloatingActionButton;III)V", "themeWebView", "Landroid/webkit/WebView;", "backgroundColor", "isNight", "", "themeWebView-EFWIcRY", "(Landroid/webkit/WebView;IZ)V", "themeRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "themeRecyclerView-xAbW3D8", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "themeSwipeRefreshLayout", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "themeSwipeRefreshLayout-FUHGC9k", "(Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;II)V", "themeTextView", "Landroid/widget/TextView;", "themeTextView-CoujqA8", "(Landroid/widget/TextView;III)V", "themeEditText", "Landroid/widget/EditText;", "themeEditText-CoujqA8", "(Landroid/widget/EditText;III)V", "themeViewPager", "Landroidx/viewpager/widget/ViewPager;", "themeViewPager-xAbW3D8", "(Landroidx/viewpager/widget/ViewPager;I)V", "themeBottomNavigationView", "Lcom/google/android/material/bottomnavigation/BottomNavigationView;", "colorBackground", "colorOnBackground", "colorOnBackgroundSecondary", "themeBottomNavigationView-qLjDh8k", "(Lcom/google/android/material/bottomnavigation/BottomNavigationView;IIII)V", "themeTextInputLayout", "Lcom/google/android/material/textfield/TextInputLayout;", "colorError", "colorBoxPrimary", "colorBoxSecondary", "themeTextInputLayout-qLjDh8k", "(Lcom/google/android/material/textfield/TextInputLayout;IIII)V", "themeChip", "Lcom/google/android/material/chip/Chip;", "colorBackgroundSelected", "colorTextSelected", "themeChip-NhWho2U", "(Lcom/google/android/material/chip/Chip;IIIII)V", "themeButton", "Lcom/google/android/material/button/MaterialButton;", "colorBackgroundDisabled", "colorTextDisabled", "themeButton-NhWho2U", "(Lcom/google/android/material/button/MaterialButton;IIIII)V", "themeOutlineButton", "colorDisabled", "themeOutlineButton-CoujqA8", "(Lcom/google/android/material/button/MaterialButton;III)V", "themeToggleButton", "colorUnchecked", "themeToggleButton-CoujqA8", "themeTextButton", "themeTextButton-CoujqA8", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidViewKt {
    /* JADX INFO: renamed from: themeBottomNavigationView-qLjDh8k, reason: not valid java name */
    public static final void m11334themeBottomNavigationViewqLjDh8k(BottomNavigationView themeBottomNavigationView, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(themeBottomNavigationView, "$this$themeBottomNavigationView");
        ColorStateList colorStateListM11318colorStateListFUHGC9k = AndroidColorKt.m11318colorStateListFUHGC9k(android.R.attr.state_checked, i2, i3);
        themeBottomNavigationView.setItemIconTintList(colorStateListM11318colorStateListFUHGC9k);
        themeBottomNavigationView.setItemRippleColor(AndroidColorKt.m11319colorStateListXxRhnUA(i4));
        themeBottomNavigationView.setItemTextColor(colorStateListM11318colorStateListFUHGC9k);
        AndroidColorKt.m11321setBackgroundColorxAbW3D8(themeBottomNavigationView, i);
    }

    /* JADX INFO: renamed from: themeButton-NhWho2U, reason: not valid java name */
    public static final void m11335themeButtonNhWho2U(MaterialButton themeButton, int i, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(themeButton, "$this$themeButton");
        ViewCompat.setBackgroundTintList(themeButton, AndroidColorKt.m11318colorStateListFUHGC9k(android.R.attr.state_enabled, i, i2));
        ColorStateList colorStateListM11318colorStateListFUHGC9k = AndroidColorKt.m11318colorStateListFUHGC9k(android.R.attr.state_enabled, i3, i4);
        themeButton.setTextColor(colorStateListM11318colorStateListFUHGC9k);
        themeButton.setIconTint(colorStateListM11318colorStateListFUHGC9k);
        themeButton.setRippleColor(AndroidColorKt.m11319colorStateListXxRhnUA(i5));
    }

    /* JADX INFO: renamed from: themeCheckBox-CoujqA8, reason: not valid java name */
    public static final void m11336themeCheckBoxCoujqA8(CheckBox themeCheckBox, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(themeCheckBox, "$this$themeCheckBox");
        themeCheckBox.setButtonTintList(AndroidColorKt.m11319colorStateListXxRhnUA(i));
        m11351themeTextViewCoujqA8(themeCheckBox, i, i2, i3);
    }

    /* JADX INFO: renamed from: themeChip-NhWho2U, reason: not valid java name */
    public static final void m11337themeChipNhWho2U(Chip themeChip, int i, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(themeChip, "$this$themeChip");
        ColorStateList colorStateListM11318colorStateListFUHGC9k = AndroidColorKt.m11318colorStateListFUHGC9k(android.R.attr.state_selected, i4, i3);
        themeChip.setCloseIconTint(colorStateListM11318colorStateListFUHGC9k);
        themeChip.setChipIconTint(colorStateListM11318colorStateListFUHGC9k);
        themeChip.setTextColor(colorStateListM11318colorStateListFUHGC9k);
        themeChip.setRippleColor(AndroidColorKt.m11319colorStateListXxRhnUA(i5));
        themeChip.setChipBackgroundColor(AndroidColorKt.m11318colorStateListFUHGC9k(android.R.attr.state_selected, i2, i));
    }

    /* JADX INFO: renamed from: themeEditText-CoujqA8, reason: not valid java name */
    public static final void m11338themeEditTextCoujqA8(EditText themeEditText, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(themeEditText, "$this$themeEditText");
        EditText editText = themeEditText;
        m11351themeTextViewCoujqA8(editText, i, i2, i3);
        AndroidThemingHacksKt.m11330setCursorDrawableColorxAbW3D8(editText, i);
        ViewCompat.setBackgroundTintList(themeEditText, AndroidColorKt.m11319colorStateListXxRhnUA(i));
    }

    /* JADX INFO: renamed from: themeExtendedFloatingActionButton-CoujqA8, reason: not valid java name */
    public static final void m11339themeExtendedFloatingActionButtonCoujqA8(ExtendedFloatingActionButton themeExtendedFloatingActionButton, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(themeExtendedFloatingActionButton, "$this$themeExtendedFloatingActionButton");
        ViewCompat.setBackgroundTintList(themeExtendedFloatingActionButton, AndroidColorKt.m11319colorStateListXxRhnUA(i));
        themeExtendedFloatingActionButton.setRippleColor(AndroidColorKt.m11319colorStateListXxRhnUA(i3));
        AndroidColorKt.m11325setTextColorxAbW3D8(themeExtendedFloatingActionButton, i2);
        themeExtendedFloatingActionButton.setIconTint(AndroidColorKt.m11319colorStateListXxRhnUA(i2));
    }

    /* JADX INFO: renamed from: themeFloatingActionButton-CoujqA8, reason: not valid java name */
    public static final void m11340themeFloatingActionButtonCoujqA8(FloatingActionButton themeFloatingActionButton, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(themeFloatingActionButton, "$this$themeFloatingActionButton");
        ViewCompat.setBackgroundTintList(themeFloatingActionButton, AndroidColorKt.m11319colorStateListXxRhnUA(i));
        themeFloatingActionButton.setRippleColor(AndroidColorKt.m11319colorStateListXxRhnUA(i3));
        themeFloatingActionButton.setImageTintList(AndroidColorKt.m11319colorStateListXxRhnUA(i2));
    }

    /* JADX INFO: renamed from: themeMaterialAutoCompleteTextView-NhWho2U, reason: not valid java name */
    public static final void m11341themeMaterialAutoCompleteTextViewNhWho2U(MaterialAutoCompleteTextView themeMaterialAutoCompleteTextView, int i, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(themeMaterialAutoCompleteTextView, "$this$themeMaterialAutoCompleteTextView");
        m11338themeEditTextCoujqA8(themeMaterialAutoCompleteTextView, i, i2, i3);
        themeMaterialAutoCompleteTextView.setDropDownBackgroundDrawable(AndroidColorKt.m11317ColorDrawableXxRhnUA(i5));
        themeMaterialAutoCompleteTextView.setSimpleItemSelectedRippleColor(AndroidColorKt.m11319colorStateListXxRhnUA(i4));
    }

    /* JADX INFO: renamed from: themeOutlineButton-CoujqA8, reason: not valid java name */
    public static final void m11342themeOutlineButtonCoujqA8(MaterialButton themeOutlineButton, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(themeOutlineButton, "$this$themeOutlineButton");
        ColorStateList colorStateListM11318colorStateListFUHGC9k = AndroidColorKt.m11318colorStateListFUHGC9k(android.R.attr.state_enabled, i, i2);
        themeOutlineButton.setTextColor(colorStateListM11318colorStateListFUHGC9k);
        themeOutlineButton.setIconTint(colorStateListM11318colorStateListFUHGC9k);
        themeOutlineButton.setStrokeColor(colorStateListM11318colorStateListFUHGC9k);
        themeOutlineButton.setForegroundTintList(null);
        themeOutlineButton.setRippleColor(AndroidColorKt.m11319colorStateListXxRhnUA(i3));
    }

    /* JADX INFO: renamed from: themeProgressBar-xAbW3D8, reason: not valid java name */
    public static final void m11343themeProgressBarxAbW3D8(ProgressBar themeProgressBar, int i) {
        Intrinsics.checkNotNullParameter(themeProgressBar, "$this$themeProgressBar");
        themeProgressBar.setIndeterminateTintList(AndroidColorKt.m11319colorStateListXxRhnUA(i));
    }

    /* JADX INFO: renamed from: themeRadioButton-CoujqA8, reason: not valid java name */
    public static final void m11344themeRadioButtonCoujqA8(RadioButton themeRadioButton, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(themeRadioButton, "$this$themeRadioButton");
        themeRadioButton.setButtonTintList(AndroidColorKt.m11319colorStateListXxRhnUA(i));
        m11351themeTextViewCoujqA8(themeRadioButton, i, i2, i3);
    }

    /* JADX INFO: renamed from: themeRecyclerView-xAbW3D8, reason: not valid java name */
    public static final void m11345themeRecyclerViewxAbW3D8(RecyclerView themeRecyclerView, final int i) {
        Intrinsics.checkNotNullParameter(themeRecyclerView, "$this$themeRecyclerView");
        themeRecyclerView.setEdgeEffectFactory(new RecyclerView.EdgeEffectFactory() { // from class: com.vanniktech.ui.AndroidViewKt$themeRecyclerView$1
            @Override // androidx.recyclerview.widget.RecyclerView.EdgeEffectFactory
            protected EdgeEffect createEdgeEffect(RecyclerView view, int direction) {
                Intrinsics.checkNotNullParameter(view, "view");
                EdgeEffect edgeEffect = new EdgeEffect(view.getContext());
                edgeEffect.setColor(i);
                return edgeEffect;
            }
        });
    }

    /* JADX INFO: renamed from: themeSeekBar-xAbW3D8, reason: not valid java name */
    public static final void m11346themeSeekBarxAbW3D8(SeekBar themeSeekBar, int i) {
        Intrinsics.checkNotNullParameter(themeSeekBar, "$this$themeSeekBar");
        themeSeekBar.setProgressTintList(AndroidColorKt.m11319colorStateListXxRhnUA(i));
        themeSeekBar.setThumbTintList(AndroidColorKt.m11319colorStateListXxRhnUA(i));
    }

    /* JADX INFO: renamed from: themeSwipeRefreshLayout-FUHGC9k, reason: not valid java name */
    public static final void m11347themeSwipeRefreshLayoutFUHGC9k(SwipeRefreshLayout themeSwipeRefreshLayout, int i, int i2) {
        Intrinsics.checkNotNullParameter(themeSwipeRefreshLayout, "$this$themeSwipeRefreshLayout");
        themeSwipeRefreshLayout.setColorSchemeColors(i);
        themeSwipeRefreshLayout.setProgressBackgroundColorSchemeColor(i2);
    }

    /* JADX INFO: renamed from: themeTabLayout-qLjDh8k, reason: not valid java name */
    public static final void m11348themeTabLayoutqLjDh8k(TabLayout themeTabLayout, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(themeTabLayout, "$this$themeTabLayout");
        AndroidColorKt.m11321setBackgroundColorxAbW3D8(themeTabLayout, i);
        themeTabLayout.setSelectedTabIndicatorColor(i2);
        themeTabLayout.setTabIconTint(AndroidColorKt.m11319colorStateListXxRhnUA(i));
        themeTabLayout.setTabTextColors(AndroidColorKt.m11318colorStateListFUHGC9k(android.R.attr.state_selected, i2, i3));
        themeTabLayout.setTabRippleColor(AndroidColorKt.m11319colorStateListXxRhnUA(i4));
    }

    /* JADX INFO: renamed from: themeTextButton-CoujqA8, reason: not valid java name */
    public static final void m11349themeTextButtonCoujqA8(MaterialButton themeTextButton, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(themeTextButton, "$this$themeTextButton");
        ColorStateList colorStateListM11318colorStateListFUHGC9k = AndroidColorKt.m11318colorStateListFUHGC9k(android.R.attr.state_enabled, i, i2);
        themeTextButton.setTextColor(colorStateListM11318colorStateListFUHGC9k);
        themeTextButton.setIconTint(colorStateListM11318colorStateListFUHGC9k);
        themeTextButton.setStrokeColor(AndroidColorKt.m11319colorStateListXxRhnUA(Color.INSTANCE.m11392getTRANSPARENToEAH0UE()));
        themeTextButton.setForegroundTintList(null);
        themeTextButton.setRippleColor(AndroidColorKt.m11319colorStateListXxRhnUA(i3));
    }

    /* JADX INFO: renamed from: themeTextInputLayout-qLjDh8k, reason: not valid java name */
    public static final void m11350themeTextInputLayoutqLjDh8k(TextInputLayout themeTextInputLayout, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(themeTextInputLayout, "$this$themeTextInputLayout");
        themeTextInputLayout.setCounterOverflowTextColor(AndroidColorKt.m11319colorStateListXxRhnUA(i));
        themeTextInputLayout.setCounterTextColor(AndroidColorKt.m11319colorStateListXxRhnUA(i));
        themeTextInputLayout.setDefaultHintTextColor(AndroidColorKt.m11319colorStateListXxRhnUA(i));
        themeTextInputLayout.setHintTextColor(AndroidColorKt.m11319colorStateListXxRhnUA(i));
        themeTextInputLayout.setPlaceholderTextColor(AndroidColorKt.m11319colorStateListXxRhnUA(i));
        themeTextInputLayout.setEndIconTintList(AndroidColorKt.m11319colorStateListXxRhnUA(i));
        themeTextInputLayout.setHelperTextColor(AndroidColorKt.m11319colorStateListXxRhnUA(i));
        themeTextInputLayout.setPrefixTextColor(AndroidColorKt.m11319colorStateListXxRhnUA(i));
        themeTextInputLayout.setStartIconTintList(AndroidColorKt.m11319colorStateListXxRhnUA(i));
        themeTextInputLayout.setSuffixTextColor(AndroidColorKt.m11319colorStateListXxRhnUA(i));
        themeTextInputLayout.setErrorIconTintList(AndroidColorKt.m11319colorStateListXxRhnUA(i2));
        themeTextInputLayout.setBoxStrokeErrorColor(AndroidColorKt.m11319colorStateListXxRhnUA(i2));
        themeTextInputLayout.setBoxStrokeColorStateList(AndroidColorKt.m11318colorStateListFUHGC9k(android.R.attr.state_focused, i3, i4));
    }

    /* JADX INFO: renamed from: themeTextView-CoujqA8, reason: not valid java name */
    public static final void m11351themeTextViewCoujqA8(TextView themeTextView, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(themeTextView, "$this$themeTextView");
        themeTextView.setHighlightColor(i);
        AndroidThemingHacksKt.m11331setHandlesColorxAbW3D8(themeTextView, i);
        themeTextView.setHintTextColor(i3);
        themeTextView.setLinkTextColor(i);
        AndroidColorKt.m11325setTextColorxAbW3D8(themeTextView, i2);
        TextViewCompat.setCompoundDrawableTintList(themeTextView, AndroidColorKt.m11319colorStateListXxRhnUA(i2));
    }

    /* JADX INFO: renamed from: themeToggleButton-CoujqA8, reason: not valid java name */
    public static final void m11352themeToggleButtonCoujqA8(MaterialButton themeToggleButton, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(themeToggleButton, "$this$themeToggleButton");
        ColorStateList colorStateListM11318colorStateListFUHGC9k = AndroidColorKt.m11318colorStateListFUHGC9k(android.R.attr.state_checked, i, i2);
        themeToggleButton.setTextColor(colorStateListM11318colorStateListFUHGC9k);
        themeToggleButton.setIconTint(colorStateListM11318colorStateListFUHGC9k);
        themeToggleButton.setStrokeColor(colorStateListM11318colorStateListFUHGC9k);
        themeToggleButton.setForegroundTintList(null);
        themeToggleButton.setBackgroundColor(0);
        themeToggleButton.setRippleColor(AndroidColorKt.m11319colorStateListXxRhnUA(i3));
    }

    /* JADX INFO: renamed from: themeToolbar-qLjDh8k, reason: not valid java name */
    public static final void m11353themeToolbarqLjDh8k(MaterialToolbar themeToolbar, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(themeToolbar, "$this$themeToolbar");
        AndroidColorKt.m11321setBackgroundColorxAbW3D8(themeToolbar, i);
        themeToolbar.setTitleTextColor(i2);
        themeToolbar.setSubtitleTextColor(i3);
        themeToolbar.setNavigationIconTint(i4);
    }

    /* JADX INFO: renamed from: themeViewPager-xAbW3D8, reason: not valid java name */
    public static final void m11354themeViewPagerxAbW3D8(ViewPager themeViewPager, int i) {
        Intrinsics.checkNotNullParameter(themeViewPager, "$this$themeViewPager");
        Field fieldByName = AndroidThemingHacksKt.getFieldByName(ViewPager.class, "mLeftEdge");
        Object obj = fieldByName != null ? fieldByName.get(themeViewPager) : null;
        EdgeEffect edgeEffect = obj instanceof EdgeEffect ? (EdgeEffect) obj : null;
        if (edgeEffect != null) {
            edgeEffect.setColor(i);
        }
        Field fieldByName2 = AndroidThemingHacksKt.getFieldByName(ViewPager.class, "mRightEdge");
        Object obj2 = fieldByName2 != null ? fieldByName2.get(themeViewPager) : null;
        EdgeEffect edgeEffect2 = obj2 instanceof EdgeEffect ? (EdgeEffect) obj2 : null;
        if (edgeEffect2 != null) {
            edgeEffect2.setColor(i);
        }
    }

    /* JADX INFO: renamed from: themeWebView-EFWIcRY, reason: not valid java name */
    public static final void m11355themeWebViewEFWIcRY(WebView themeWebView, int i, boolean z) {
        Intrinsics.checkNotNullParameter(themeWebView, "$this$themeWebView");
        AndroidColorKt.m11321setBackgroundColorxAbW3D8(themeWebView, i);
        if (WebViewFeature.isFeatureSupported("ALGORITHMIC_DARKENING")) {
            if (Build.VERSION.SDK_INT >= 29) {
                WebSettingsCompat.setAlgorithmicDarkeningAllowed(themeWebView.getSettings(), z);
            }
        } else if (WebViewFeature.isFeatureSupported("FORCE_DARK")) {
            WebSettingsCompat.setForceDark(themeWebView.getSettings(), z ? 2 : 0);
        }
    }
}
