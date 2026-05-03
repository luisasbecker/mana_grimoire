package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogMythicPlusInfoBinding implements ViewBinding {
    public final ImageView mythicPlusInfoCloseImage;
    public final ConstraintLayout mythicPlusInfoCtaLayout;
    public final ConstraintLayout mythicPlusInfoDialogRoot;
    public final FrameLayout mythicPlusInfoHeader;
    public final TextView mythicPlusInfoMessage;
    public final TextView mythicPlusInfoPleaseNote;
    private final ConstraintLayout rootView;

    private DialogMythicPlusInfoBinding(ConstraintLayout constraintLayout, ImageView imageView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, FrameLayout frameLayout, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.mythicPlusInfoCloseImage = imageView;
        this.mythicPlusInfoCtaLayout = constraintLayout2;
        this.mythicPlusInfoDialogRoot = constraintLayout3;
        this.mythicPlusInfoHeader = frameLayout;
        this.mythicPlusInfoMessage = textView;
        this.mythicPlusInfoPleaseNote = textView2;
    }

    public static DialogMythicPlusInfoBinding bind(View view) {
        int i = R.id.mythicPlusInfoCloseImage;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.mythicPlusInfoCtaLayout;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                i = R.id.mythicPlusInfoHeader;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                if (frameLayout != null) {
                    i = R.id.mythicPlusInfoMessage;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.mythicPlusInfoPleaseNote;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            return new DialogMythicPlusInfoBinding(constraintLayout2, imageView, constraintLayout, constraintLayout2, frameLayout, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static DialogMythicPlusInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogMythicPlusInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_mythic_plus_info, viewGroup, false);
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
