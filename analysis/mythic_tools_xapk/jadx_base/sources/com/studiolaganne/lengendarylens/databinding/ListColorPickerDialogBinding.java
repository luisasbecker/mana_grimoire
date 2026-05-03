package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ListColorPickerDialogBinding implements ViewBinding {
    public final TextView colorPickerTitle;
    public final RecyclerView colorRecyclerView;
    public final TextView noColorButton;
    private final ConstraintLayout rootView;

    private ListColorPickerDialogBinding(ConstraintLayout constraintLayout, TextView textView, RecyclerView recyclerView, TextView textView2) {
        this.rootView = constraintLayout;
        this.colorPickerTitle = textView;
        this.colorRecyclerView = recyclerView;
        this.noColorButton = textView2;
    }

    public static ListColorPickerDialogBinding bind(View view) {
        int i = R.id.colorPickerTitle;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.colorRecyclerView;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
            if (recyclerView != null) {
                i = R.id.noColorButton;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    return new ListColorPickerDialogBinding((ConstraintLayout) view, textView, recyclerView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ListColorPickerDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ListColorPickerDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.list_color_picker_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
