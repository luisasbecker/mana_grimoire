package com.vanniktech.ui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.vanniktech.ui.R;

/* JADX INFO: loaded from: classes6.dex */
public final class UiViewColorComponentBinding implements ViewBinding {
    public final EditText editText;
    public final TextView header;
    private final View rootView;
    public final SeekBar seekBar;

    private UiViewColorComponentBinding(View view, EditText editText, TextView textView, SeekBar seekBar) {
        this.rootView = view;
        this.editText = editText;
        this.header = textView;
        this.seekBar = seekBar;
    }

    public static UiViewColorComponentBinding bind(View view) {
        int i = R.id.editText;
        EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
        if (editText != null) {
            i = R.id.header;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.seekBar;
                SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(view, i);
                if (seekBar != null) {
                    return new UiViewColorComponentBinding(view, editText, textView, seekBar);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static UiViewColorComponentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(R.layout.ui_view_color_component, viewGroup);
        return bind(viewGroup);
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }
}
