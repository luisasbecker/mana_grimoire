package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentChallengesBinding implements ViewBinding {
    public final LinearLayout contentLayout;
    public final TextView noChallengesTextView;
    private final ConstraintLayout rootView;
    public final ScrollView scrollView;

    private FragmentChallengesBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, TextView textView, ScrollView scrollView) {
        this.rootView = constraintLayout;
        this.contentLayout = linearLayout;
        this.noChallengesTextView = textView;
        this.scrollView = scrollView;
    }

    public static FragmentChallengesBinding bind(View view) {
        int i = R.id.contentLayout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.noChallengesTextView;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.scrollView;
                ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
                if (scrollView != null) {
                    return new FragmentChallengesBinding((ConstraintLayout) view, linearLayout, textView, scrollView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentChallengesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentChallengesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_challenges, viewGroup, false);
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
