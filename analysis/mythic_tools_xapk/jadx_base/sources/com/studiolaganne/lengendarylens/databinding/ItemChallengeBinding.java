package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ItemChallengeBinding implements ViewBinding {
    public final TextView challengeEndDateTextView;
    public final TextView challengeNameTextView;
    private final ConstraintLayout rootView;
    public final LinearLayout tasksContainer;

    private ItemChallengeBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, LinearLayout linearLayout) {
        this.rootView = constraintLayout;
        this.challengeEndDateTextView = textView;
        this.challengeNameTextView = textView2;
        this.tasksContainer = linearLayout;
    }

    public static ItemChallengeBinding bind(View view) {
        int i = R.id.challengeEndDateTextView;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.challengeNameTextView;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.tasksContainer;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    return new ItemChallengeBinding((ConstraintLayout) view, textView, textView2, linearLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ItemChallengeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemChallengeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_challenge, viewGroup, false);
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
