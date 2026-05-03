package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class NavDrawerDividerBinding implements ViewBinding {
    private final View rootView;

    private NavDrawerDividerBinding(View view) {
        this.rootView = view;
    }

    public static NavDrawerDividerBinding bind(View view) {
        if (view != null) {
            return new NavDrawerDividerBinding(view);
        }
        throw new NullPointerException("rootView");
    }

    public static NavDrawerDividerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static NavDrawerDividerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.nav_drawer_divider, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }
}
