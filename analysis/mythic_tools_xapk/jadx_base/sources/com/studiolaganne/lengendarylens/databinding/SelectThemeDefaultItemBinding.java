package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class SelectThemeDefaultItemBinding implements ViewBinding {
    public final ImageView checkmark;
    public final LinearLayout innerLayout;
    public final ImageView mtLogoIcon;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final TextView themeTitle;

    private SelectThemeDefaultItemBinding(ConstraintLayout constraintLayout, ImageView imageView, LinearLayout linearLayout, ImageView imageView2, ConstraintLayout constraintLayout2, TextView textView) {
        this.rootView = constraintLayout;
        this.checkmark = imageView;
        this.innerLayout = linearLayout;
        this.mtLogoIcon = imageView2;
        this.rootLayout = constraintLayout2;
        this.themeTitle = textView;
    }

    public static SelectThemeDefaultItemBinding bind(View view) {
        int i = R.id.checkmark;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.innerLayout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.mtLogoIcon;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i = R.id.themeTitle;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        return new SelectThemeDefaultItemBinding(constraintLayout, imageView, linearLayout, imageView2, constraintLayout, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static SelectThemeDefaultItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SelectThemeDefaultItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.select_theme_default_item, viewGroup, false);
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
