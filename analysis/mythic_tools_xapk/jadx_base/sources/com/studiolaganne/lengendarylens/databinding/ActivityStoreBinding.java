package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.tabs.TabLayout;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityStoreBinding implements ViewBinding {
    public final ImageView backArrow;
    public final ConstraintLayout backLayout;
    public final ImageView basketImage;
    public final ImageView codeImage;
    public final ConstraintLayout codeLayout;
    public final TextView codeText;
    public final FrameLayout fullScreenOverlay;
    public final ConstraintLayout infoLayout;
    public final LinearLayoutCompat linearLayout;
    public final LottieAnimationView loadingAnimationView;
    public final TextView nothingToSeeLabel;
    public final ConstraintLayout overlay;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final NestedScrollView spotlightContainer;
    public final RecyclerView spotlightRecyclerView;
    public final FrameLayout storeContentFrame;
    public final RecyclerView storeItemsRecyclerView;
    public final TabLayout storeTabLayout;
    public final ChipGroup themeCategoriesChipGroup;
    public final HorizontalScrollView themeCategoriesScrollView;
    public final LinearLayout themesContainer;
    public final TextView themesDescription;
    public final TextView themesHeader;
    public final ConstraintLayout themesHeaderLayout;
    public final ImageView themesImage;
    public final LinearLayout themesLayout;
    public final LinearLayout themesTopLayout;
    public final TextView title;

    private ActivityStoreBinding(ConstraintLayout constraintLayout, ImageView imageView, ConstraintLayout constraintLayout2, ImageView imageView2, ImageView imageView3, ConstraintLayout constraintLayout3, TextView textView, FrameLayout frameLayout, ConstraintLayout constraintLayout4, LinearLayoutCompat linearLayoutCompat, LottieAnimationView lottieAnimationView, TextView textView2, ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, NestedScrollView nestedScrollView, RecyclerView recyclerView, FrameLayout frameLayout2, RecyclerView recyclerView2, TabLayout tabLayout, ChipGroup chipGroup, HorizontalScrollView horizontalScrollView, LinearLayout linearLayout, TextView textView3, TextView textView4, ConstraintLayout constraintLayout7, ImageView imageView4, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView5) {
        this.rootView = constraintLayout;
        this.backArrow = imageView;
        this.backLayout = constraintLayout2;
        this.basketImage = imageView2;
        this.codeImage = imageView3;
        this.codeLayout = constraintLayout3;
        this.codeText = textView;
        this.fullScreenOverlay = frameLayout;
        this.infoLayout = constraintLayout4;
        this.linearLayout = linearLayoutCompat;
        this.loadingAnimationView = lottieAnimationView;
        this.nothingToSeeLabel = textView2;
        this.overlay = constraintLayout5;
        this.rootLayout = constraintLayout6;
        this.spotlightContainer = nestedScrollView;
        this.spotlightRecyclerView = recyclerView;
        this.storeContentFrame = frameLayout2;
        this.storeItemsRecyclerView = recyclerView2;
        this.storeTabLayout = tabLayout;
        this.themeCategoriesChipGroup = chipGroup;
        this.themeCategoriesScrollView = horizontalScrollView;
        this.themesContainer = linearLayout;
        this.themesDescription = textView3;
        this.themesHeader = textView4;
        this.themesHeaderLayout = constraintLayout7;
        this.themesImage = imageView4;
        this.themesLayout = linearLayout2;
        this.themesTopLayout = linearLayout3;
        this.title = textView5;
    }

    public static ActivityStoreBinding bind(View view) {
        int i = R.id.backArrow;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.backLayout;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = R.id.basketImage;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.codeImage;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView3 != null) {
                        i = R.id.codeLayout;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout2 != null) {
                            i = R.id.codeText;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R.id.fullScreenOverlay;
                                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                if (frameLayout != null) {
                                    i = R.id.infoLayout;
                                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                    if (constraintLayout3 != null) {
                                        i = R.id.linearLayout;
                                        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) ViewBindings.findChildViewById(view, i);
                                        if (linearLayoutCompat != null) {
                                            i = R.id.loadingAnimationView;
                                            LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
                                            if (lottieAnimationView != null) {
                                                i = R.id.nothingToSeeLabel;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView2 != null) {
                                                    i = R.id.overlay;
                                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                    if (constraintLayout4 != null) {
                                                        ConstraintLayout constraintLayout5 = (ConstraintLayout) view;
                                                        i = R.id.spotlightContainer;
                                                        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, i);
                                                        if (nestedScrollView != null) {
                                                            i = R.id.spotlightRecyclerView;
                                                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                            if (recyclerView != null) {
                                                                i = R.id.storeContentFrame;
                                                                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                                                if (frameLayout2 != null) {
                                                                    i = R.id.storeItemsRecyclerView;
                                                                    RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                    if (recyclerView2 != null) {
                                                                        i = R.id.storeTabLayout;
                                                                        TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (tabLayout != null) {
                                                                            i = R.id.themeCategoriesChipGroup;
                                                                            ChipGroup chipGroup = (ChipGroup) ViewBindings.findChildViewById(view, i);
                                                                            if (chipGroup != null) {
                                                                                i = R.id.themeCategoriesScrollView;
                                                                                HorizontalScrollView horizontalScrollView = (HorizontalScrollView) ViewBindings.findChildViewById(view, i);
                                                                                if (horizontalScrollView != null) {
                                                                                    i = R.id.themesContainer;
                                                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                    if (linearLayout != null) {
                                                                                        i = R.id.themesDescription;
                                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView3 != null) {
                                                                                            i = R.id.themesHeader;
                                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView4 != null) {
                                                                                                i = R.id.themesHeaderLayout;
                                                                                                ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                if (constraintLayout6 != null) {
                                                                                                    i = R.id.themesImage;
                                                                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (imageView4 != null) {
                                                                                                        i = R.id.themesLayout;
                                                                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                        if (linearLayout2 != null) {
                                                                                                            i = R.id.themesTopLayout;
                                                                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                            if (linearLayout3 != null) {
                                                                                                                i = R.id.title;
                                                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView5 != null) {
                                                                                                                    return new ActivityStoreBinding(constraintLayout5, imageView, constraintLayout, imageView2, imageView3, constraintLayout2, textView, frameLayout, constraintLayout3, linearLayoutCompat, lottieAnimationView, textView2, constraintLayout4, constraintLayout5, nestedScrollView, recyclerView, frameLayout2, recyclerView2, tabLayout, chipGroup, horizontalScrollView, linearLayout, textView3, textView4, constraintLayout6, imageView4, linearLayout2, linearLayout3, textView5);
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

    public static ActivityStoreBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityStoreBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_store, viewGroup, false);
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
