package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentTriviaBinding implements ViewBinding {
    public final TextView attemptsTextView;
    public final TextView bestScoreTextView;
    public final LinearLayout contentLayout;
    public final TextView endDateTextView;
    public final TextView noMoreAttemptsTextView;
    public final TextView noTriviaTextView;
    public final LinearLayout questionsContainer;
    private final ConstraintLayout rootView;
    public final ScrollView scrollView;
    public final ConstraintLayout submitButtonLayout;
    public final TextView submitButtonText;
    public final ConstraintLayout successMessageLayout;
    public final TextView successMessageTextView;
    public final TextView triviaNameTextView;

    private FragmentTriviaBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, LinearLayout linearLayout, TextView textView3, TextView textView4, TextView textView5, LinearLayout linearLayout2, ScrollView scrollView, ConstraintLayout constraintLayout2, TextView textView6, ConstraintLayout constraintLayout3, TextView textView7, TextView textView8) {
        this.rootView = constraintLayout;
        this.attemptsTextView = textView;
        this.bestScoreTextView = textView2;
        this.contentLayout = linearLayout;
        this.endDateTextView = textView3;
        this.noMoreAttemptsTextView = textView4;
        this.noTriviaTextView = textView5;
        this.questionsContainer = linearLayout2;
        this.scrollView = scrollView;
        this.submitButtonLayout = constraintLayout2;
        this.submitButtonText = textView6;
        this.successMessageLayout = constraintLayout3;
        this.successMessageTextView = textView7;
        this.triviaNameTextView = textView8;
    }

    public static FragmentTriviaBinding bind(View view) {
        int i = R.id.attemptsTextView;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.bestScoreTextView;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.contentLayout;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = R.id.endDateTextView;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = R.id.noMoreAttemptsTextView;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView4 != null) {
                            i = R.id.noTriviaTextView;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView5 != null) {
                                i = R.id.questionsContainer;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout2 != null) {
                                    i = R.id.scrollView;
                                    ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
                                    if (scrollView != null) {
                                        i = R.id.submitButtonLayout;
                                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                        if (constraintLayout != null) {
                                            i = R.id.submitButtonText;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView6 != null) {
                                                i = R.id.successMessageLayout;
                                                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                if (constraintLayout2 != null) {
                                                    i = R.id.successMessageTextView;
                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView7 != null) {
                                                        i = R.id.triviaNameTextView;
                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView8 != null) {
                                                            return new FragmentTriviaBinding((ConstraintLayout) view, textView, textView2, linearLayout, textView3, textView4, textView5, linearLayout2, scrollView, constraintLayout, textView6, constraintLayout2, textView7, textView8);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentTriviaBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentTriviaBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_trivia, viewGroup, false);
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
