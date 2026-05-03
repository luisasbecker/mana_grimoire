package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityWebBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final WebView webview;

    private ActivityWebBinding(ConstraintLayout constraintLayout, WebView webView) {
        this.rootView = constraintLayout;
        this.webview = webView;
    }

    public static ActivityWebBinding bind(View view) {
        int i = R.id.webview;
        WebView webView = (WebView) ViewBindings.findChildViewById(view, i);
        if (webView != null) {
            return new ActivityWebBinding((ConstraintLayout) view, webView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivityWebBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityWebBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_web, viewGroup, false);
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
