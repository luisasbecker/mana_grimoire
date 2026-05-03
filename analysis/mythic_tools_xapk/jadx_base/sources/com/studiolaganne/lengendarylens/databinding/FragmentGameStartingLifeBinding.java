package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentGameStartingLifeBinding implements ViewBinding {
    public final CardView cardView1;
    public final TextView cardView1Text;
    public final CardView cardView2;
    public final TextView cardView2Text;
    public final CardView cardView3;
    public final TextView cardView3Text;
    public final CardView cardView4;
    public final TextView cardView4Text;
    public final TextView pickThemeTitle;
    public final TextView questionText;
    private final ConstraintLayout rootView;
    public final ImageView themeButton;
    public final View themeOverlay;
    public final ConstraintLayout themePickerLayout;
    public final TextView themeSelection;
    public final TextView themeTitle;
    public final RecyclerView themesRecyclerView;

    private FragmentGameStartingLifeBinding(ConstraintLayout constraintLayout, CardView cardView, TextView textView, CardView cardView2, TextView textView2, CardView cardView3, TextView textView3, CardView cardView4, TextView textView4, TextView textView5, TextView textView6, ImageView imageView, View view, ConstraintLayout constraintLayout2, TextView textView7, TextView textView8, RecyclerView recyclerView) {
        this.rootView = constraintLayout;
        this.cardView1 = cardView;
        this.cardView1Text = textView;
        this.cardView2 = cardView2;
        this.cardView2Text = textView2;
        this.cardView3 = cardView3;
        this.cardView3Text = textView3;
        this.cardView4 = cardView4;
        this.cardView4Text = textView4;
        this.pickThemeTitle = textView5;
        this.questionText = textView6;
        this.themeButton = imageView;
        this.themeOverlay = view;
        this.themePickerLayout = constraintLayout2;
        this.themeSelection = textView7;
        this.themeTitle = textView8;
        this.themesRecyclerView = recyclerView;
    }

    public static FragmentGameStartingLifeBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.cardView1;
        CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
        if (cardView != null) {
            i = R.id.cardView1_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.cardView2;
                CardView cardView2 = (CardView) ViewBindings.findChildViewById(view, i);
                if (cardView2 != null) {
                    i = R.id.cardView2_text;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.cardView3;
                        CardView cardView3 = (CardView) ViewBindings.findChildViewById(view, i);
                        if (cardView3 != null) {
                            i = R.id.cardView3_text;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R.id.cardView4;
                                CardView cardView4 = (CardView) ViewBindings.findChildViewById(view, i);
                                if (cardView4 != null) {
                                    i = R.id.cardView4_text;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        i = R.id.pickThemeTitle;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView5 != null) {
                                            i = R.id.question_text;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView6 != null) {
                                                i = R.id.themeButton;
                                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                                if (imageView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.themeOverlay))) != null) {
                                                    i = R.id.themePickerLayout;
                                                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                    if (constraintLayout != null) {
                                                        i = R.id.themeSelection;
                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView7 != null) {
                                                            i = R.id.themeTitle;
                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView8 != null) {
                                                                i = R.id.themesRecyclerView;
                                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                if (recyclerView != null) {
                                                                    return new FragmentGameStartingLifeBinding((ConstraintLayout) view, cardView, textView, cardView2, textView2, cardView3, textView3, cardView4, textView4, textView5, textView6, imageView, viewFindChildViewById, constraintLayout, textView7, textView8, recyclerView);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static FragmentGameStartingLifeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentGameStartingLifeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_game_starting_life, viewGroup, false);
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
