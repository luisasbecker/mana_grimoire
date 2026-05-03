package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class PreferenceCategoryLayoutBinding implements ViewBinding {
    private final TextView rootView;
    public final TextView title;

    private PreferenceCategoryLayoutBinding(TextView textView, TextView textView2) {
        this.rootView = textView;
        this.title = textView2;
    }

    public static PreferenceCategoryLayoutBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        TextView textView = (TextView) view;
        return new PreferenceCategoryLayoutBinding(textView, textView);
    }

    public static PreferenceCategoryLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PreferenceCategoryLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.preference_category_layout, viewGroup, false);
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
