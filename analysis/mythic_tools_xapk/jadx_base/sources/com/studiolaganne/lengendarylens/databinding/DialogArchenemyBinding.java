package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.LoadingImageView;
import com.studiolaganne.lengendarylens.R;
import com.studiolaganne.lengendarylens.SquareButton;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogArchenemyBinding implements ViewBinding {
    public final ConstraintLayout backButtonLayout;
    public final TextView backButtonText;
    public final ConstraintLayout cardContainer;
    public final LoadingImageView cardImage;
    public final ImageView closeImage;
    public final SquareButton flipCardButton;
    public final ConstraintLayout innerLayout;
    public final ConstraintLayout nextButtonLayout;
    public final TextView noOngoingSchemesText;
    public final RecyclerView ongoingSchemesRecyclerView;
    public final TextView ongoingSchemesText;
    public final TextView planeswalkButtonText;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final ImageView settingsImage;

    private DialogArchenemyBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, ConstraintLayout constraintLayout3, LoadingImageView loadingImageView, ImageView imageView, SquareButton squareButton, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, TextView textView2, RecyclerView recyclerView, TextView textView3, TextView textView4, ConstraintLayout constraintLayout6, ImageView imageView2) {
        this.rootView = constraintLayout;
        this.backButtonLayout = constraintLayout2;
        this.backButtonText = textView;
        this.cardContainer = constraintLayout3;
        this.cardImage = loadingImageView;
        this.closeImage = imageView;
        this.flipCardButton = squareButton;
        this.innerLayout = constraintLayout4;
        this.nextButtonLayout = constraintLayout5;
        this.noOngoingSchemesText = textView2;
        this.ongoingSchemesRecyclerView = recyclerView;
        this.ongoingSchemesText = textView3;
        this.planeswalkButtonText = textView4;
        this.rootLayout = constraintLayout6;
        this.settingsImage = imageView2;
    }

    public static DialogArchenemyBinding bind(View view) {
        int i = R.id.backButtonLayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.backButtonText;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.cardContainer;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout2 != null) {
                    i = R.id.cardImage;
                    LoadingImageView loadingImageView = (LoadingImageView) ViewBindings.findChildViewById(view, i);
                    if (loadingImageView != null) {
                        i = R.id.closeImage;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView != null) {
                            i = R.id.flipCardButton;
                            SquareButton squareButton = (SquareButton) ViewBindings.findChildViewById(view, i);
                            if (squareButton != null) {
                                i = R.id.innerLayout;
                                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                if (constraintLayout3 != null) {
                                    i = R.id.nextButtonLayout;
                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                    if (constraintLayout4 != null) {
                                        i = R.id.noOngoingSchemesText;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView2 != null) {
                                            i = R.id.ongoingSchemesRecyclerView;
                                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                            if (recyclerView != null) {
                                                i = R.id.ongoingSchemesText;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView3 != null) {
                                                    i = R.id.planeswalkButtonText;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView4 != null) {
                                                        ConstraintLayout constraintLayout5 = (ConstraintLayout) view;
                                                        i = R.id.settingsImage;
                                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                        if (imageView2 != null) {
                                                            return new DialogArchenemyBinding(constraintLayout5, constraintLayout, textView, constraintLayout2, loadingImageView, imageView, squareButton, constraintLayout3, constraintLayout4, textView2, recyclerView, textView3, textView4, constraintLayout5, imageView2);
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

    public static DialogArchenemyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogArchenemyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_archenemy, viewGroup, false);
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
