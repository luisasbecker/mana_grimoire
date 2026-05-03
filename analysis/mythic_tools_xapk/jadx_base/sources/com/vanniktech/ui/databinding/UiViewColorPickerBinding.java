package com.vanniktech.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.vanniktech.ui.R;
import com.vanniktech.ui.view.ColorComponentView;

/* JADX INFO: loaded from: classes6.dex */
public final class UiViewColorPickerBinding implements ViewBinding {
    public final ColorComponentView alpha;
    public final ColorComponentView blue;
    public final ColorComponentView green;
    public final EditText hexEditText;
    public final TextView hexHeader;
    public final View preview;
    public final ColorComponentView red;
    private final View rootView;

    private UiViewColorPickerBinding(View view, ColorComponentView colorComponentView, ColorComponentView colorComponentView2, ColorComponentView colorComponentView3, EditText editText, TextView textView, View view2, ColorComponentView colorComponentView4) {
        this.rootView = view;
        this.alpha = colorComponentView;
        this.blue = colorComponentView2;
        this.green = colorComponentView3;
        this.hexEditText = editText;
        this.hexHeader = textView;
        this.preview = view2;
        this.red = colorComponentView4;
    }

    public static UiViewColorPickerBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.alpha;
        ColorComponentView colorComponentView = (ColorComponentView) ViewBindings.findChildViewById(view, i);
        if (colorComponentView != null) {
            i = R.id.blue;
            ColorComponentView colorComponentView2 = (ColorComponentView) ViewBindings.findChildViewById(view, i);
            if (colorComponentView2 != null) {
                i = R.id.green;
                ColorComponentView colorComponentView3 = (ColorComponentView) ViewBindings.findChildViewById(view, i);
                if (colorComponentView3 != null) {
                    i = R.id.hexEditText;
                    EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                    if (editText != null) {
                        i = R.id.hexHeader;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.preview))) != null) {
                            i = R.id.red;
                            ColorComponentView colorComponentView4 = (ColorComponentView) ViewBindings.findChildViewById(view, i);
                            if (colorComponentView4 != null) {
                                return new UiViewColorPickerBinding(view, colorComponentView, colorComponentView2, colorComponentView3, editText, textView, viewFindChildViewById, colorComponentView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static UiViewColorPickerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(R.layout.ui_view_color_picker, viewGroup);
        return bind(viewGroup);
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }
}
