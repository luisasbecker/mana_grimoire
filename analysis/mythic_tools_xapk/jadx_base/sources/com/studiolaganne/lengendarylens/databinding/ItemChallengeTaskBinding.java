package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ItemChallengeTaskBinding implements ViewBinding {
    public final ImageView checkmarkImageView;
    private final ConstraintLayout rootView;
    public final LinearLayout taskContentLayout;
    public final TextView taskDescriptionTextView;
    public final TextView taskNameTextView;

    private ItemChallengeTaskBinding(ConstraintLayout constraintLayout, ImageView imageView, LinearLayout linearLayout, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.checkmarkImageView = imageView;
        this.taskContentLayout = linearLayout;
        this.taskDescriptionTextView = textView;
        this.taskNameTextView = textView2;
    }

    public static ItemChallengeTaskBinding bind(View view) {
        int i = R.id.checkmarkImageView;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.taskContentLayout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.taskDescriptionTextView;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.taskNameTextView;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        return new ItemChallengeTaskBinding((ConstraintLayout) view, imageView, linearLayout, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ItemChallengeTaskBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemChallengeTaskBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_challenge_task, viewGroup, false);
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
