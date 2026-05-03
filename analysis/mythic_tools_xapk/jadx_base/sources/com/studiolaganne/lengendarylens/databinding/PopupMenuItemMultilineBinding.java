package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class PopupMenuItemMultilineBinding implements ViewBinding {
    private final TextView rootView;
    public final TextView text1;

    private PopupMenuItemMultilineBinding(TextView textView, TextView textView2) {
        this.rootView = textView;
        this.text1 = textView2;
    }

    public static PopupMenuItemMultilineBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        TextView textView = (TextView) view;
        return new PopupMenuItemMultilineBinding(textView, textView);
    }

    public static PopupMenuItemMultilineBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PopupMenuItemMultilineBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.popup_menu_item_multiline, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public TextView getRoot() {
        return this.rootView;
    }
}
