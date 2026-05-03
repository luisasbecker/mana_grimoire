package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentMythicPlusBinding implements ViewBinding {
    public final ImageView chevronDown;
    public final FrameLayout fragmentContainer;
    private final ConstraintLayout rootView;
    public final TextView tabEvalIcon;
    public final TextView tabEvalLabel;
    public final LinearLayout tabEvaluation;
    public final LinearLayout tabLayout;
    public final LinearLayout tabRecommendations;
    public final TextView tabRecsIcon;
    public final TextView tabRecsLabel;
    public final LinearLayout tabSearch;
    public final TextView tabSearchIcon;
    public final TextView tabSearchLabel;
    public final TextView toastLabel;

    private FragmentMythicPlusBinding(ConstraintLayout constraintLayout, ImageView imageView, FrameLayout frameLayout, TextView textView, TextView textView2, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView3, TextView textView4, LinearLayout linearLayout4, TextView textView5, TextView textView6, TextView textView7) {
        this.rootView = constraintLayout;
        this.chevronDown = imageView;
        this.fragmentContainer = frameLayout;
        this.tabEvalIcon = textView;
        this.tabEvalLabel = textView2;
        this.tabEvaluation = linearLayout;
        this.tabLayout = linearLayout2;
        this.tabRecommendations = linearLayout3;
        this.tabRecsIcon = textView3;
        this.tabRecsLabel = textView4;
        this.tabSearch = linearLayout4;
        this.tabSearchIcon = textView5;
        this.tabSearchLabel = textView6;
        this.toastLabel = textView7;
    }

    public static FragmentMythicPlusBinding bind(View view) {
        int i = R.id.chevronDown;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.fragmentContainer;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout != null) {
                i = R.id.tabEvalIcon;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.tabEvalLabel;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.tabEvaluation;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null) {
                            i = R.id.tabLayout;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout2 != null) {
                                i = R.id.tabRecommendations;
                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout3 != null) {
                                    i = R.id.tabRecsIcon;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = R.id.tabRecsLabel;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView4 != null) {
                                            i = R.id.tabSearch;
                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                            if (linearLayout4 != null) {
                                                i = R.id.tabSearchIcon;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView5 != null) {
                                                    i = R.id.tabSearchLabel;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView6 != null) {
                                                        i = R.id.toastLabel;
                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView7 != null) {
                                                            return new FragmentMythicPlusBinding((ConstraintLayout) view, imageView, frameLayout, textView, textView2, linearLayout, linearLayout2, linearLayout3, textView3, textView4, linearLayout4, textView5, textView6, textView7);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentMythicPlusBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentMythicPlusBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_mythic_plus, viewGroup, false);
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
