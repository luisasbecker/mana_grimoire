package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.LongPressButton;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogPoisonCountersInput180Binding implements ViewBinding {
    public final CardView cardView;
    public final ConstraintLayout innerLayout;
    public final LongPressButton minusButton;
    public final ImageView phyrexianBlack;
    public final ConstraintLayout phyrexianLayout;
    public final ImageView phyrexianWhite;
    public final LongPressButton plusButton;
    public final TextView poisonCountersText;
    private final ConstraintLayout rootView;

    private DialogPoisonCountersInput180Binding(ConstraintLayout constraintLayout, CardView cardView, ConstraintLayout constraintLayout2, LongPressButton longPressButton, ImageView imageView, ConstraintLayout constraintLayout3, ImageView imageView2, LongPressButton longPressButton2, TextView textView) {
        this.rootView = constraintLayout;
        this.cardView = cardView;
        this.innerLayout = constraintLayout2;
        this.minusButton = longPressButton;
        this.phyrexianBlack = imageView;
        this.phyrexianLayout = constraintLayout3;
        this.phyrexianWhite = imageView2;
        this.plusButton = longPressButton2;
        this.poisonCountersText = textView;
    }

    public static DialogPoisonCountersInput180Binding bind(View view) {
        int i = R.id.cardView;
        CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
        if (cardView != null) {
            i = R.id.innerLayout;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = R.id.minus_button;
                LongPressButton longPressButton = (LongPressButton) ViewBindings.findChildViewById(view, i);
                if (longPressButton != null) {
                    i = R.id.phyrexianBlack;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                        i = R.id.phyrexianWhite;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null) {
                            i = R.id.plus_button;
                            LongPressButton longPressButton2 = (LongPressButton) ViewBindings.findChildViewById(view, i);
                            if (longPressButton2 != null) {
                                i = R.id.poisonCountersText;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    return new DialogPoisonCountersInput180Binding(constraintLayout2, cardView, constraintLayout, longPressButton, imageView, constraintLayout2, imageView2, longPressButton2, textView);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static DialogPoisonCountersInput180Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogPoisonCountersInput180Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_poison_counters_input_180, viewGroup, false);
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
