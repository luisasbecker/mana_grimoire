package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ToastNotificationBinding implements ViewBinding {
    public final LinearLayout contentLayout;
    private final LinearLayout rootView;
    public final ImageView toastIcon;
    public final TextView toastMessage;
    public final LinearLayout toastNotificationLayout;
    public final TextView toastTitle;

    private ToastNotificationBinding(LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView, TextView textView, LinearLayout linearLayout3, TextView textView2) {
        this.rootView = linearLayout;
        this.contentLayout = linearLayout2;
        this.toastIcon = imageView;
        this.toastMessage = textView;
        this.toastNotificationLayout = linearLayout3;
        this.toastTitle = textView2;
    }

    public static ToastNotificationBinding bind(View view) {
        int i = R.id.contentLayout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.toast_icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.toast_message;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    LinearLayout linearLayout2 = (LinearLayout) view;
                    i = R.id.toast_title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        return new ToastNotificationBinding(linearLayout2, linearLayout, imageView, textView, linearLayout2, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ToastNotificationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ToastNotificationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.toast_notification, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
