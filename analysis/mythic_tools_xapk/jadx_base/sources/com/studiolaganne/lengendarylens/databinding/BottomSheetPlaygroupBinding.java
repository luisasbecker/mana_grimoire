package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class BottomSheetPlaygroupBinding implements ViewBinding {
    public final LinearLayoutCompat buttonsLayout;
    public final ImageView chevronDown;
    public final TextView connectingTextView;
    public final ConstraintLayout createButtonLayout;
    public final TextView createButtonText;
    public final LottieAnimationView loadingAnimationView;
    public final ConstraintLayout overlay;
    public final EditText playgroupDescription;
    public final EditText playgroupName;
    private final ConstraintLayout rootView;
    public final LinearLayoutCompat textLayout;
    public final LinearLayoutCompat titleLayout;

    private BottomSheetPlaygroupBinding(ConstraintLayout constraintLayout, LinearLayoutCompat linearLayoutCompat, ImageView imageView, TextView textView, ConstraintLayout constraintLayout2, TextView textView2, LottieAnimationView lottieAnimationView, ConstraintLayout constraintLayout3, EditText editText, EditText editText2, LinearLayoutCompat linearLayoutCompat2, LinearLayoutCompat linearLayoutCompat3) {
        this.rootView = constraintLayout;
        this.buttonsLayout = linearLayoutCompat;
        this.chevronDown = imageView;
        this.connectingTextView = textView;
        this.createButtonLayout = constraintLayout2;
        this.createButtonText = textView2;
        this.loadingAnimationView = lottieAnimationView;
        this.overlay = constraintLayout3;
        this.playgroupDescription = editText;
        this.playgroupName = editText2;
        this.textLayout = linearLayoutCompat2;
        this.titleLayout = linearLayoutCompat3;
    }

    public static BottomSheetPlaygroupBinding bind(View view) {
        int i = R.id.buttonsLayout;
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) ViewBindings.findChildViewById(view, i);
        if (linearLayoutCompat != null) {
            i = R.id.chevron_down;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.connectingTextView;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.createButtonLayout;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout != null) {
                        i = R.id.createButtonText;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.loadingAnimationView;
                            LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
                            if (lottieAnimationView != null) {
                                i = R.id.overlay;
                                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                if (constraintLayout2 != null) {
                                    i = R.id.playgroupDescription;
                                    EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                                    if (editText != null) {
                                        i = R.id.playgroupName;
                                        EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
                                        if (editText2 != null) {
                                            i = R.id.textLayout;
                                            LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) ViewBindings.findChildViewById(view, i);
                                            if (linearLayoutCompat2 != null) {
                                                i = R.id.titleLayout;
                                                LinearLayoutCompat linearLayoutCompat3 = (LinearLayoutCompat) ViewBindings.findChildViewById(view, i);
                                                if (linearLayoutCompat3 != null) {
                                                    return new BottomSheetPlaygroupBinding((ConstraintLayout) view, linearLayoutCompat, imageView, textView, constraintLayout, textView2, lottieAnimationView, constraintLayout2, editText, editText2, linearLayoutCompat2, linearLayoutCompat3);
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

    public static BottomSheetPlaygroupBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BottomSheetPlaygroupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.bottom_sheet_playgroup, viewGroup, false);
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
