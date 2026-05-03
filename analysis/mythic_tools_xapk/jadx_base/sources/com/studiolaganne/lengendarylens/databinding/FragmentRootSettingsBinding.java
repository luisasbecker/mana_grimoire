package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentRootSettingsBinding implements ViewBinding {
    public final FragmentContainerView fragmentContainer;
    private final RelativeLayout rootView;
    public final Toolbar toolbar;

    private FragmentRootSettingsBinding(RelativeLayout relativeLayout, FragmentContainerView fragmentContainerView, Toolbar toolbar) {
        this.rootView = relativeLayout;
        this.fragmentContainer = fragmentContainerView;
        this.toolbar = toolbar;
    }

    public static FragmentRootSettingsBinding bind(View view) {
        int i = R.id.fragment_container;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.findChildViewById(view, i);
        if (fragmentContainerView != null) {
            i = R.id.toolbar;
            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, i);
            if (toolbar != null) {
                return new FragmentRootSettingsBinding((RelativeLayout) view, fragmentContainerView, toolbar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentRootSettingsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentRootSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_root_settings, viewGroup, false);
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
