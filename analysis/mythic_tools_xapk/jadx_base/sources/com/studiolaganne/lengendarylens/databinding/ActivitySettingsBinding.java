package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivitySettingsBinding implements ViewBinding {
    public final FragmentContainerView fragmentContainer;
    private final RelativeLayout rootView;

    private ActivitySettingsBinding(RelativeLayout relativeLayout, FragmentContainerView fragmentContainerView) {
        this.rootView = relativeLayout;
        this.fragmentContainer = fragmentContainerView;
    }

    public static ActivitySettingsBinding bind(View view) {
        int i = R.id.fragment_container;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.findChildViewById(view, i);
        if (fragmentContainerView != null) {
            return new ActivitySettingsBinding((RelativeLayout) view, fragmentContainerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivitySettingsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivitySettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_settings, viewGroup, false);
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
