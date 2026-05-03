package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class OnboardingPageBinding implements ViewBinding {
    public final ImageView pageImage;
    public final TextView pageText;
    private final LinearLayout rootView;

    private OnboardingPageBinding(LinearLayout linearLayout, ImageView imageView, TextView textView) {
        this.rootView = linearLayout;
        this.pageImage = imageView;
        this.pageText = textView;
    }

    public static OnboardingPageBinding bind(View view) {
        int i = R.id.page_image;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.page_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                return new OnboardingPageBinding((LinearLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static OnboardingPageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static OnboardingPageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.onboarding_page, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
