package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class PrivacyToolbarBinding implements ViewBinding {
    public final TextView circlesIcon;
    public final TextView privacyLabel;
    public final LinearLayout privacySelectorContainer;
    public final TextView privacySettingsIcon;
    public final LinearLayout privacyToolbarLayout;
    private final LinearLayout rootView;
    public final TextView separatorIcon;
    public final TextView separatorIconCircles;
    public final TextView sharingIcon;

    private PrivacyToolbarBinding(LinearLayout linearLayout, TextView textView, TextView textView2, LinearLayout linearLayout2, TextView textView3, LinearLayout linearLayout3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = linearLayout;
        this.circlesIcon = textView;
        this.privacyLabel = textView2;
        this.privacySelectorContainer = linearLayout2;
        this.privacySettingsIcon = textView3;
        this.privacyToolbarLayout = linearLayout3;
        this.separatorIcon = textView4;
        this.separatorIconCircles = textView5;
        this.sharingIcon = textView6;
    }

    public static PrivacyToolbarBinding bind(View view) {
        int i = R.id.circlesIcon;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.privacyLabel;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.privacySelectorContainer;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = R.id.privacySettingsIcon;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        LinearLayout linearLayout2 = (LinearLayout) view;
                        i = R.id.separatorIcon;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView4 != null) {
                            i = R.id.separatorIconCircles;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView5 != null) {
                                i = R.id.sharingIcon;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView6 != null) {
                                    return new PrivacyToolbarBinding(linearLayout2, textView, textView2, linearLayout, textView3, linearLayout2, textView4, textView5, textView6);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static PrivacyToolbarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PrivacyToolbarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.privacy_toolbar, viewGroup, false);
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
