package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ProgressDialogBinding implements ViewBinding {
    public final ProgressBar progressBar;
    private final RelativeLayout rootView;

    private ProgressDialogBinding(RelativeLayout relativeLayout, ProgressBar progressBar) {
        this.rootView = relativeLayout;
        this.progressBar = progressBar;
    }

    public static ProgressDialogBinding bind(View view) {
        int i = R.id.progress_bar;
        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
        if (progressBar != null) {
            return new ProgressDialogBinding((RelativeLayout) view, progressBar);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ProgressDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ProgressDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.progress_dialog, viewGroup, false);
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
