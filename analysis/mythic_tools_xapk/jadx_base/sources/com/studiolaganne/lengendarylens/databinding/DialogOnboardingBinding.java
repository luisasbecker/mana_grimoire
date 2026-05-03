package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.studiolaganne.lengendarylens.R;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogOnboardingBinding implements ViewBinding {
    public final ImageView closeButton;
    public final WormDotsIndicator dotsIndicator;
    public final TextView onboardingTitle;
    public final TextView onboardingVersion;
    public final ViewPager2 onboardingViewpager;
    private final ConstraintLayout rootView;

    private DialogOnboardingBinding(ConstraintLayout constraintLayout, ImageView imageView, WormDotsIndicator wormDotsIndicator, TextView textView, TextView textView2, ViewPager2 viewPager2) {
        this.rootView = constraintLayout;
        this.closeButton = imageView;
        this.dotsIndicator = wormDotsIndicator;
        this.onboardingTitle = textView;
        this.onboardingVersion = textView2;
        this.onboardingViewpager = viewPager2;
    }

    public static DialogOnboardingBinding bind(View view) {
        int i = R.id.close_button;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.dots_indicator;
            WormDotsIndicator wormDotsIndicator = (WormDotsIndicator) ViewBindings.findChildViewById(view, i);
            if (wormDotsIndicator != null) {
                i = R.id.onboarding_title;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.onboarding_version;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.onboarding_viewpager;
                        ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(view, i);
                        if (viewPager2 != null) {
                            return new DialogOnboardingBinding((ConstraintLayout) view, imageView, wormDotsIndicator, textView, textView2, viewPager2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static DialogOnboardingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogOnboardingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_onboarding, viewGroup, false);
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
