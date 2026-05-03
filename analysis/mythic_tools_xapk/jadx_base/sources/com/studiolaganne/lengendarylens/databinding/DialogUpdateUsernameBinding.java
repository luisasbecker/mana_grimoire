package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogUpdateUsernameBinding implements ViewBinding {
    public final ConstraintLayout cancelButtonLayout;
    public final TextView cancelText;
    public final TextView dialogTitle;
    public final TextView errorTextView;
    public final LottieAnimationView loadingAnimationView;
    private final LinearLayout rootView;
    public final ConstraintLayout updateButtonLayout;
    public final TextView updateButtonText;
    public final EditText usernameEditText;

    private DialogUpdateUsernameBinding(LinearLayout linearLayout, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, LottieAnimationView lottieAnimationView, ConstraintLayout constraintLayout2, TextView textView4, EditText editText) {
        this.rootView = linearLayout;
        this.cancelButtonLayout = constraintLayout;
        this.cancelText = textView;
        this.dialogTitle = textView2;
        this.errorTextView = textView3;
        this.loadingAnimationView = lottieAnimationView;
        this.updateButtonLayout = constraintLayout2;
        this.updateButtonText = textView4;
        this.usernameEditText = editText;
    }

    public static DialogUpdateUsernameBinding bind(View view) {
        int i = R.id.cancelButtonLayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.cancelText;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.dialog_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.error_text_view;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = R.id.loadingAnimationView;
                        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
                        if (lottieAnimationView != null) {
                            i = R.id.updateButtonLayout;
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                            if (constraintLayout2 != null) {
                                i = R.id.updateButtonText;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView4 != null) {
                                    i = R.id.username_edit_text;
                                    EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                                    if (editText != null) {
                                        return new DialogUpdateUsernameBinding((LinearLayout) view, constraintLayout, textView, textView2, textView3, lottieAnimationView, constraintLayout2, textView4, editText);
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

    public static DialogUpdateUsernameBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogUpdateUsernameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_update_username, viewGroup, false);
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
