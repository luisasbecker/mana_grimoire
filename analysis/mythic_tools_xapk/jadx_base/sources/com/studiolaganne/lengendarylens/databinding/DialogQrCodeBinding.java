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
public final class DialogQrCodeBinding implements ViewBinding {
    public final ImageView qrCodeImage;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final TextView userNameText;

    private DialogQrCodeBinding(ConstraintLayout constraintLayout, ImageView imageView, ConstraintLayout constraintLayout2, TextView textView) {
        this.rootView = constraintLayout;
        this.qrCodeImage = imageView;
        this.rootLayout = constraintLayout2;
        this.userNameText = textView;
    }

    public static DialogQrCodeBinding bind(View view) {
        int i = R.id.qr_code_image;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.root_layout;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = R.id.user_name_text;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new DialogQrCodeBinding((ConstraintLayout) view, imageView, constraintLayout, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static DialogQrCodeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogQrCodeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_qr_code, viewGroup, false);
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
