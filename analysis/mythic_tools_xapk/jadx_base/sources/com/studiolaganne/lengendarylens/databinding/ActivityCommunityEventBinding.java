package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.tabs.TabLayout;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityCommunityEventBinding implements ViewBinding {
    public final ImageView backArrow;
    public final ConstraintLayout backLayout;
    public final ConstraintLayout evenImageLayout;
    public final TextView eventDescriptionTextView;
    public final ImageView eventImage;
    public final TextView eventNameTextView;
    public final ConstraintLayout infoLayout;
    public final LinearLayoutCompat linearLayout;
    public final LottieAnimationView loadingAnimationView;
    public final ConstraintLayout loadingOverlay;
    public final ConstraintLayout main;
    private final ConstraintLayout rootView;
    public final TabLayout tabs;
    public final TextView updatingTextView;
    public final ViewPager2 viewPager;

    private ActivityCommunityEventBinding(ConstraintLayout constraintLayout, ImageView imageView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, TextView textView, ImageView imageView2, TextView textView2, ConstraintLayout constraintLayout4, LinearLayoutCompat linearLayoutCompat, LottieAnimationView lottieAnimationView, ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, TabLayout tabLayout, TextView textView3, ViewPager2 viewPager2) {
        this.rootView = constraintLayout;
        this.backArrow = imageView;
        this.backLayout = constraintLayout2;
        this.evenImageLayout = constraintLayout3;
        this.eventDescriptionTextView = textView;
        this.eventImage = imageView2;
        this.eventNameTextView = textView2;
        this.infoLayout = constraintLayout4;
        this.linearLayout = linearLayoutCompat;
        this.loadingAnimationView = lottieAnimationView;
        this.loadingOverlay = constraintLayout5;
        this.main = constraintLayout6;
        this.tabs = tabLayout;
        this.updatingTextView = textView3;
        this.viewPager = viewPager2;
    }

    public static ActivityCommunityEventBinding bind(View view) {
        int i = R.id.backArrow;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.backLayout;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = R.id.evenImageLayout;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout2 != null) {
                    i = R.id.eventDescriptionTextView;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.eventImage;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null) {
                            i = R.id.eventNameTextView;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = R.id.infoLayout;
                                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                if (constraintLayout3 != null) {
                                    i = R.id.linearLayout;
                                    LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) ViewBindings.findChildViewById(view, i);
                                    if (linearLayoutCompat != null) {
                                        i = R.id.loadingAnimationView;
                                        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
                                        if (lottieAnimationView != null) {
                                            i = R.id.loadingOverlay;
                                            ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                            if (constraintLayout4 != null) {
                                                ConstraintLayout constraintLayout5 = (ConstraintLayout) view;
                                                i = R.id.tabs;
                                                TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(view, i);
                                                if (tabLayout != null) {
                                                    i = R.id.updatingTextView;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView3 != null) {
                                                        i = R.id.viewPager;
                                                        ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(view, i);
                                                        if (viewPager2 != null) {
                                                            return new ActivityCommunityEventBinding(constraintLayout5, imageView, constraintLayout, constraintLayout2, textView, imageView2, textView2, constraintLayout3, linearLayoutCompat, lottieAnimationView, constraintLayout4, constraintLayout5, tabLayout, textView3, viewPager2);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivityCommunityEventBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityCommunityEventBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_community_event, viewGroup, false);
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
