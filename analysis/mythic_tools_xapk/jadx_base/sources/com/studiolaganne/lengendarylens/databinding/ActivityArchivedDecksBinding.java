package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityArchivedDecksBinding implements ViewBinding {
    public final ImageView backArrow;
    public final ConstraintLayout backLayout;
    public final ImageView clearFilterButton;
    public final TextView connectingTextView;
    public final ImageView decksImage;
    public final RecyclerView decksRecyclerView;
    public final EditText filterEditText;
    public final ConstraintLayout infoLayout;
    public final LinearLayoutCompat linearLayout;
    public final LottieAnimationView loadingAnimationView;
    public final TextView noDecksText;
    public final ConstraintLayout overlay;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final TextView title;

    private ActivityArchivedDecksBinding(ConstraintLayout constraintLayout, ImageView imageView, ConstraintLayout constraintLayout2, ImageView imageView2, TextView textView, ImageView imageView3, RecyclerView recyclerView, EditText editText, ConstraintLayout constraintLayout3, LinearLayoutCompat linearLayoutCompat, LottieAnimationView lottieAnimationView, TextView textView2, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, TextView textView3) {
        this.rootView = constraintLayout;
        this.backArrow = imageView;
        this.backLayout = constraintLayout2;
        this.clearFilterButton = imageView2;
        this.connectingTextView = textView;
        this.decksImage = imageView3;
        this.decksRecyclerView = recyclerView;
        this.filterEditText = editText;
        this.infoLayout = constraintLayout3;
        this.linearLayout = linearLayoutCompat;
        this.loadingAnimationView = lottieAnimationView;
        this.noDecksText = textView2;
        this.overlay = constraintLayout4;
        this.rootLayout = constraintLayout5;
        this.title = textView3;
    }

    public static ActivityArchivedDecksBinding bind(View view) {
        int i = R.id.backArrow;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.backLayout;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = R.id.clearFilterButton;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.connectingTextView;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.decksImage;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView3 != null) {
                            i = R.id.decksRecyclerView;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                            if (recyclerView != null) {
                                i = R.id.filterEditText;
                                EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                                if (editText != null) {
                                    i = R.id.infoLayout;
                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                    if (constraintLayout2 != null) {
                                        i = R.id.linearLayout;
                                        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) ViewBindings.findChildViewById(view, i);
                                        if (linearLayoutCompat != null) {
                                            i = R.id.loadingAnimationView;
                                            LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
                                            if (lottieAnimationView != null) {
                                                i = R.id.noDecksText;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView2 != null) {
                                                    i = R.id.overlay;
                                                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                    if (constraintLayout3 != null) {
                                                        ConstraintLayout constraintLayout4 = (ConstraintLayout) view;
                                                        i = R.id.title;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView3 != null) {
                                                            return new ActivityArchivedDecksBinding(constraintLayout4, imageView, constraintLayout, imageView2, textView, imageView3, recyclerView, editText, constraintLayout2, linearLayoutCompat, lottieAnimationView, textView2, constraintLayout3, constraintLayout4, textView3);
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

    public static ActivityArchivedDecksBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityArchivedDecksBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_archived_decks, viewGroup, false);
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
