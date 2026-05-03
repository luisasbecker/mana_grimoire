package com.skydoves.colorpickerview.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.Space;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.skydoves.colorpickerview.ColorPickerView;
import com.skydoves.colorpickerview.R;
import com.skydoves.colorpickerview.sliders.AlphaSlideBar;
import com.skydoves.colorpickerview.sliders.BrightnessSlideBar;

/* JADX INFO: loaded from: classes6.dex */
public final class ColorpickerviewDialogColorpickerBinding implements ViewBinding {
    public final AlphaSlideBar alphaSlideBar;
    public final FrameLayout alphaSlideBarFrame;
    public final BrightnessSlideBar brightnessSlideBar;
    public final FrameLayout brightnessSlideBarFrame;
    public final ColorPickerView colorPickerView;
    public final FrameLayout colorPickerViewFrame;
    private final ScrollView rootView;
    public final Space spaceBottom;

    private ColorpickerviewDialogColorpickerBinding(ScrollView scrollView, AlphaSlideBar alphaSlideBar, FrameLayout frameLayout, BrightnessSlideBar brightnessSlideBar, FrameLayout frameLayout2, ColorPickerView colorPickerView, FrameLayout frameLayout3, Space space) {
        this.rootView = scrollView;
        this.alphaSlideBar = alphaSlideBar;
        this.alphaSlideBarFrame = frameLayout;
        this.brightnessSlideBar = brightnessSlideBar;
        this.brightnessSlideBarFrame = frameLayout2;
        this.colorPickerView = colorPickerView;
        this.colorPickerViewFrame = frameLayout3;
        this.spaceBottom = space;
    }

    public static ColorpickerviewDialogColorpickerBinding bind(View view) {
        int i = R.id.alphaSlideBar;
        AlphaSlideBar alphaSlideBar = (AlphaSlideBar) ViewBindings.findChildViewById(view, i);
        if (alphaSlideBar != null) {
            i = R.id.alphaSlideBarFrame;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout != null) {
                i = R.id.brightnessSlideBar;
                BrightnessSlideBar brightnessSlideBar = (BrightnessSlideBar) ViewBindings.findChildViewById(view, i);
                if (brightnessSlideBar != null) {
                    i = R.id.brightnessSlideBarFrame;
                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                    if (frameLayout2 != null) {
                        i = R.id.colorPickerView;
                        ColorPickerView colorPickerView = (ColorPickerView) ViewBindings.findChildViewById(view, i);
                        if (colorPickerView != null) {
                            i = R.id.colorPickerViewFrame;
                            FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                            if (frameLayout3 != null) {
                                i = R.id.space_bottom;
                                Space space = (Space) ViewBindings.findChildViewById(view, i);
                                if (space != null) {
                                    return new ColorpickerviewDialogColorpickerBinding((ScrollView) view, alphaSlideBar, frameLayout, brightnessSlideBar, frameLayout2, colorPickerView, frameLayout3, space);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ColorpickerviewDialogColorpickerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ColorpickerviewDialogColorpickerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.colorpickerview_dialog_colorpicker, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }
}
