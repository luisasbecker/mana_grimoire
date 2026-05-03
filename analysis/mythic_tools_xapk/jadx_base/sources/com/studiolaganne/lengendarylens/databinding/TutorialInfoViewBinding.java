package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class TutorialInfoViewBinding implements ViewBinding {
    public final ImageView nextImage;
    public final TextView nextLabel;
    public final LinearLayoutCompat nextLayout;
    private final ConstraintLayout rootView;
    public final LinearLayoutCompat textLayout;
    public final TextView tutorialText;

    private TutorialInfoViewBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, LinearLayoutCompat linearLayoutCompat, LinearLayoutCompat linearLayoutCompat2, TextView textView2) {
        this.rootView = constraintLayout;
        this.nextImage = imageView;
        this.nextLabel = textView;
        this.nextLayout = linearLayoutCompat;
        this.textLayout = linearLayoutCompat2;
        this.tutorialText = textView2;
    }

    public static TutorialInfoViewBinding bind(View view) {
        int i = R.id.next_image;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.next_label;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.next_layout;
                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) ViewBindings.findChildViewById(view, i);
                if (linearLayoutCompat != null) {
                    i = R.id.text_layout;
                    LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) ViewBindings.findChildViewById(view, i);
                    if (linearLayoutCompat2 != null) {
                        i = R.id.tutorial_text;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            return new TutorialInfoViewBinding((ConstraintLayout) view, imageView, textView, linearLayoutCompat, linearLayoutCompat2, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static TutorialInfoViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TutorialInfoViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.tutorial_info_view, viewGroup, false);
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
