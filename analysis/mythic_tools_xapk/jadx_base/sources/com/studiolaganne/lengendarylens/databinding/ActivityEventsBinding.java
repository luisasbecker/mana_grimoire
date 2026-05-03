package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityEventsBinding implements ViewBinding {
    public final ImageView backButton;
    public final TextView backLabel;
    public final FragmentContainerView eventsFragmentContainer;
    private final FrameLayout rootView;
    public final LinearLayout topLayout;

    private ActivityEventsBinding(FrameLayout frameLayout, ImageView imageView, TextView textView, FragmentContainerView fragmentContainerView, LinearLayout linearLayout) {
        this.rootView = frameLayout;
        this.backButton = imageView;
        this.backLabel = textView;
        this.eventsFragmentContainer = fragmentContainerView;
        this.topLayout = linearLayout;
    }

    public static ActivityEventsBinding bind(View view) {
        int i = R.id.backButton;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.backLabel;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.eventsFragmentContainer;
                FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.findChildViewById(view, i);
                if (fragmentContainerView != null) {
                    i = R.id.top_layout;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        return new ActivityEventsBinding((FrameLayout) view, imageView, textView, fragmentContainerView, linearLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivityEventsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityEventsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_events, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
