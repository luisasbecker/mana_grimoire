package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentEventsBinding implements ViewBinding {
    public final ConstraintLayout fadeInOverlay;
    public final FragmentContainerView fragmentContainer;
    private final RelativeLayout rootView;
    public final Toolbar toolbar;
    public final ViewPager2 viewPager;

    private FragmentEventsBinding(RelativeLayout relativeLayout, ConstraintLayout constraintLayout, FragmentContainerView fragmentContainerView, Toolbar toolbar, ViewPager2 viewPager2) {
        this.rootView = relativeLayout;
        this.fadeInOverlay = constraintLayout;
        this.fragmentContainer = fragmentContainerView;
        this.toolbar = toolbar;
        this.viewPager = viewPager2;
    }

    public static FragmentEventsBinding bind(View view) {
        int i = R.id.fade_in_overlay;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.fragment_container;
            FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.findChildViewById(view, i);
            if (fragmentContainerView != null) {
                i = R.id.toolbar;
                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, i);
                if (toolbar != null) {
                    i = R.id.view_pager;
                    ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(view, i);
                    if (viewPager2 != null) {
                        return new FragmentEventsBinding((RelativeLayout) view, constraintLayout, fragmentContainerView, toolbar, viewPager2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentEventsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentEventsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_events, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
