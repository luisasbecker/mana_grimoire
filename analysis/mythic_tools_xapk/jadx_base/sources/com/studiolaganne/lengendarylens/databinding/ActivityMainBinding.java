package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityMainBinding implements ViewBinding {
    public final BottomNavigationView bottomNavigation;
    public final ConstraintLayout bottomPlaceholder;
    public final View bottomSpacer;
    public final TextView downloadingLabel;
    public final ConstraintLayout downloadingLayout;
    public final FragmentContainerView fragmentContainer;
    public final ProgressBar progressBar;
    public final RelativeLayout rootLayout;
    private final RelativeLayout rootView;

    private ActivityMainBinding(RelativeLayout relativeLayout, BottomNavigationView bottomNavigationView, ConstraintLayout constraintLayout, View view, TextView textView, ConstraintLayout constraintLayout2, FragmentContainerView fragmentContainerView, ProgressBar progressBar, RelativeLayout relativeLayout2) {
        this.rootView = relativeLayout;
        this.bottomNavigation = bottomNavigationView;
        this.bottomPlaceholder = constraintLayout;
        this.bottomSpacer = view;
        this.downloadingLabel = textView;
        this.downloadingLayout = constraintLayout2;
        this.fragmentContainer = fragmentContainerView;
        this.progressBar = progressBar;
        this.rootLayout = relativeLayout2;
    }

    public static ActivityMainBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.bottom_navigation;
        BottomNavigationView bottomNavigationView = (BottomNavigationView) ViewBindings.findChildViewById(view, i);
        if (bottomNavigationView != null) {
            i = R.id.bottom_placeholder;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.bottom_spacer))) != null) {
                i = R.id.downloading_label;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.downloading_layout;
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout2 != null) {
                        i = R.id.fragment_container;
                        FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.findChildViewById(view, i);
                        if (fragmentContainerView != null) {
                            i = R.id.progressBar;
                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                            if (progressBar != null) {
                                RelativeLayout relativeLayout = (RelativeLayout) view;
                                return new ActivityMainBinding(relativeLayout, bottomNavigationView, constraintLayout, viewFindChildViewById, textView, constraintLayout2, fragmentContainerView, progressBar, relativeLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_main, viewGroup, false);
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
