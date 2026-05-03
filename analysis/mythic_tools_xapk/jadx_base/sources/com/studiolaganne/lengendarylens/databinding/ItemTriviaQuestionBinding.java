package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ItemTriviaQuestionBinding implements ViewBinding {
    public final RadioGroup answersRadioGroup;
    public final TextView questionTextView;
    private final ConstraintLayout rootView;

    private ItemTriviaQuestionBinding(ConstraintLayout constraintLayout, RadioGroup radioGroup, TextView textView) {
        this.rootView = constraintLayout;
        this.answersRadioGroup = radioGroup;
        this.questionTextView = textView;
    }

    public static ItemTriviaQuestionBinding bind(View view) {
        int i = R.id.answersRadioGroup;
        RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view, i);
        if (radioGroup != null) {
            i = R.id.questionTextView;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                return new ItemTriviaQuestionBinding((ConstraintLayout) view, radioGroup, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ItemTriviaQuestionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemTriviaQuestionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_trivia_question, viewGroup, false);
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
