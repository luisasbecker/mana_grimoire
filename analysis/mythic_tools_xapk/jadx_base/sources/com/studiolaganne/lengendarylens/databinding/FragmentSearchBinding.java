package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentSearchBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TabLayout tabs;
    public final ViewPager2 viewPager;

    private FragmentSearchBinding(ConstraintLayout constraintLayout, TabLayout tabLayout, ViewPager2 viewPager2) {
        this.rootView = constraintLayout;
        this.tabs = tabLayout;
        this.viewPager = viewPager2;
    }

    public static FragmentSearchBinding bind(View view) {
        int i = R.id.tabs;
        TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(view, i);
        if (tabLayout != null) {
            i = R.id.view_pager;
            ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(view, i);
            if (viewPager2 != null) {
                return new FragmentSearchBinding((ConstraintLayout) view, tabLayout, viewPager2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentSearchBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentSearchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_search, viewGroup, false);
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
