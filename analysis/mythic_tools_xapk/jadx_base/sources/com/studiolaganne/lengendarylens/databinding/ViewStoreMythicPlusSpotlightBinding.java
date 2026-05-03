package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ViewStoreMythicPlusSpotlightBinding implements ViewBinding {
    public final ConstraintLayout mythicPlusSpotlightCtaLayout;
    public final TextView mythicPlusSpotlightCtaText;
    public final FrameLayout mythicPlusSpotlightImageContainer;
    public final ConstraintLayout mythicPlusSpotlightInner;
    public final ConstraintLayout mythicPlusSpotlightLayout;
    public final TextView mythicPlusSpotlightTitleLine1;
    public final LinearLayout mythicPlusSpotlightTitleLine2Layout;
    public final TextView mythicPlusSpotlightTitleLine3;
    private final ConstraintLayout rootView;

    private ViewStoreMythicPlusSpotlightBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, FrameLayout frameLayout, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, TextView textView2, LinearLayout linearLayout, TextView textView3) {
        this.rootView = constraintLayout;
        this.mythicPlusSpotlightCtaLayout = constraintLayout2;
        this.mythicPlusSpotlightCtaText = textView;
        this.mythicPlusSpotlightImageContainer = frameLayout;
        this.mythicPlusSpotlightInner = constraintLayout3;
        this.mythicPlusSpotlightLayout = constraintLayout4;
        this.mythicPlusSpotlightTitleLine1 = textView2;
        this.mythicPlusSpotlightTitleLine2Layout = linearLayout;
        this.mythicPlusSpotlightTitleLine3 = textView3;
    }

    public static ViewStoreMythicPlusSpotlightBinding bind(View view) {
        int i = R.id.mythicPlusSpotlightCtaLayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.mythicPlusSpotlightCtaText;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.mythicPlusSpotlightImageContainer;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                if (frameLayout != null) {
                    i = R.id.mythicPlusSpotlightInner;
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout2 != null) {
                        ConstraintLayout constraintLayout3 = (ConstraintLayout) view;
                        i = R.id.mythicPlusSpotlightTitleLine1;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.mythicPlusSpotlightTitleLine2Layout;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout != null) {
                                i = R.id.mythicPlusSpotlightTitleLine3;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    return new ViewStoreMythicPlusSpotlightBinding(constraintLayout3, constraintLayout, textView, frameLayout, constraintLayout2, constraintLayout3, textView2, linearLayout, textView3);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ViewStoreMythicPlusSpotlightBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewStoreMythicPlusSpotlightBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.view_store_mythic_plus_spotlight, viewGroup, false);
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
