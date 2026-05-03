package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogPlayerSelectBinding implements ViewBinding {
    public final ImageView closeImage;
    public final TextView closeText;
    public final ImageView diceImage;
    public final TextView mainText;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final ConstraintLayout skipLayout;

    private DialogPlayerSelectBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, ImageView imageView2, TextView textView2, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3) {
        this.rootView = constraintLayout;
        this.closeImage = imageView;
        this.closeText = textView;
        this.diceImage = imageView2;
        this.mainText = textView2;
        this.rootLayout = constraintLayout2;
        this.skipLayout = constraintLayout3;
    }

    public static DialogPlayerSelectBinding bind(View view) {
        int i = R.id.close_image;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.close_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.dice_image;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.main_text;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.root_layout;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout != null) {
                            i = R.id.skip_layout;
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                            if (constraintLayout2 != null) {
                                return new DialogPlayerSelectBinding((ConstraintLayout) view, imageView, textView, imageView2, textView2, constraintLayout, constraintLayout2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static DialogPlayerSelectBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogPlayerSelectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_player_select, viewGroup, false);
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
