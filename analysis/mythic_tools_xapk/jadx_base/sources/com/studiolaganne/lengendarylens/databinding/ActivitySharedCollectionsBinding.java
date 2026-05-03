package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivitySharedCollectionsBinding implements ViewBinding {
    public final ImageView backArrow;
    public final ConstraintLayout backLayout;
    public final LinearLayout bottomSection;
    public final ConstraintLayout infoLayout;
    public final ConstraintLayout inviteButtonLayout;
    public final TextView inviteButtonText;
    public final LinearLayoutCompat linearLayout;
    public final LottieAnimationView loadingAnimationView;
    public final TextView noSharedCollectionsText;
    public final ConstraintLayout overlay;
    public final TextView pendingInvitesHeader;
    public final RecyclerView pendingInvitesRecyclerView;
    public final LinearLayout pendingInvitesSection;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final LinearLayout sharedCollectionsContainer;
    public final TextView sharedCollectionsHeader;
    public final LinearLayout sharedCollectionsSection;
    public final TextView title;
    public final LinearLayout warningPanel;
    public final TextView warningText;

    private ActivitySharedCollectionsBinding(ConstraintLayout constraintLayout, ImageView imageView, ConstraintLayout constraintLayout2, LinearLayout linearLayout, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, TextView textView, LinearLayoutCompat linearLayoutCompat, LottieAnimationView lottieAnimationView, TextView textView2, ConstraintLayout constraintLayout5, TextView textView3, RecyclerView recyclerView, LinearLayout linearLayout2, ConstraintLayout constraintLayout6, LinearLayout linearLayout3, TextView textView4, LinearLayout linearLayout4, TextView textView5, LinearLayout linearLayout5, TextView textView6) {
        this.rootView = constraintLayout;
        this.backArrow = imageView;
        this.backLayout = constraintLayout2;
        this.bottomSection = linearLayout;
        this.infoLayout = constraintLayout3;
        this.inviteButtonLayout = constraintLayout4;
        this.inviteButtonText = textView;
        this.linearLayout = linearLayoutCompat;
        this.loadingAnimationView = lottieAnimationView;
        this.noSharedCollectionsText = textView2;
        this.overlay = constraintLayout5;
        this.pendingInvitesHeader = textView3;
        this.pendingInvitesRecyclerView = recyclerView;
        this.pendingInvitesSection = linearLayout2;
        this.rootLayout = constraintLayout6;
        this.sharedCollectionsContainer = linearLayout3;
        this.sharedCollectionsHeader = textView4;
        this.sharedCollectionsSection = linearLayout4;
        this.title = textView5;
        this.warningPanel = linearLayout5;
        this.warningText = textView6;
    }

    public static ActivitySharedCollectionsBinding bind(View view) {
        int i = R.id.backArrow;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.backLayout;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = R.id.bottomSection;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = R.id.infoLayout;
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout2 != null) {
                        i = R.id.inviteButtonLayout;
                        ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout3 != null) {
                            i = R.id.inviteButtonText;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R.id.linearLayout;
                                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) ViewBindings.findChildViewById(view, i);
                                if (linearLayoutCompat != null) {
                                    i = R.id.loadingAnimationView;
                                    LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
                                    if (lottieAnimationView != null) {
                                        i = R.id.noSharedCollectionsText;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView2 != null) {
                                            i = R.id.overlay;
                                            ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                            if (constraintLayout4 != null) {
                                                i = R.id.pendingInvitesHeader;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView3 != null) {
                                                    i = R.id.pendingInvitesRecyclerView;
                                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                    if (recyclerView != null) {
                                                        i = R.id.pendingInvitesSection;
                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                        if (linearLayout2 != null) {
                                                            ConstraintLayout constraintLayout5 = (ConstraintLayout) view;
                                                            i = R.id.sharedCollectionsContainer;
                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                            if (linearLayout3 != null) {
                                                                i = R.id.sharedCollectionsHeader;
                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView4 != null) {
                                                                    i = R.id.sharedCollectionsSection;
                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (linearLayout4 != null) {
                                                                        i = R.id.title;
                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView5 != null) {
                                                                            i = R.id.warningPanel;
                                                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (linearLayout5 != null) {
                                                                                i = R.id.warningText;
                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView6 != null) {
                                                                                    return new ActivitySharedCollectionsBinding(constraintLayout5, imageView, constraintLayout, linearLayout, constraintLayout2, constraintLayout3, textView, linearLayoutCompat, lottieAnimationView, textView2, constraintLayout4, textView3, recyclerView, linearLayout2, constraintLayout5, linearLayout3, textView4, linearLayout4, textView5, linearLayout5, textView6);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivitySharedCollectionsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivitySharedCollectionsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_shared_collections, viewGroup, false);
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
