package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.LongPressButton;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogOwnCmd180Binding implements ViewBinding {
    public final CardView cardView;
    public final TextView helpText;
    public final ConstraintLayout innerLayout;
    public final LongPressButton minusButton;
    public final TextView ownCmdDamageText;
    public final ConstraintLayout ownCmdLayout;
    public final LongPressButton plusButton;
    private final ConstraintLayout rootView;

    private DialogOwnCmd180Binding(ConstraintLayout constraintLayout, CardView cardView, TextView textView, ConstraintLayout constraintLayout2, LongPressButton longPressButton, TextView textView2, ConstraintLayout constraintLayout3, LongPressButton longPressButton2) {
        this.rootView = constraintLayout;
        this.cardView = cardView;
        this.helpText = textView;
        this.innerLayout = constraintLayout2;
        this.minusButton = longPressButton;
        this.ownCmdDamageText = textView2;
        this.ownCmdLayout = constraintLayout3;
        this.plusButton = longPressButton2;
    }

    public static DialogOwnCmd180Binding bind(View view) {
        int i = R.id.cardView;
        CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
        if (cardView != null) {
            i = R.id.helpText;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.innerLayout;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout != null) {
                    i = R.id.minus_button;
                    LongPressButton longPressButton = (LongPressButton) ViewBindings.findChildViewById(view, i);
                    if (longPressButton != null) {
                        i = R.id.ownCmdDamageText;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                            i = R.id.plus_button;
                            LongPressButton longPressButton2 = (LongPressButton) ViewBindings.findChildViewById(view, i);
                            if (longPressButton2 != null) {
                                return new DialogOwnCmd180Binding(constraintLayout2, cardView, textView, constraintLayout, longPressButton, textView2, constraintLayout2, longPressButton2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static DialogOwnCmd180Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogOwnCmd180Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_own_cmd_180, viewGroup, false);
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
