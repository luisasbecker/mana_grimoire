package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.tabs.TabLayout;
import com.studiolaganne.lengendarylens.MarketplaceSelectorView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentCollectionBinding implements ViewBinding {
    public final ConstraintLayout accountInfo;
    public final TextView collectionAccountHeader;
    public final TextView collectionAccountSubtitle;
    public final TextView connectingTextView;
    public final TextView helpTextView;
    public final LottieAnimationView loadingAnimationView;
    public final TextView loginButtonText;
    public final LinearLayout marketplaceSelectorContainer;
    public final MarketplaceSelectorView marketplaceSelectorView;
    public final View menuBadgeDot;
    public final TextView menuTextView;
    public final ConstraintLayout overlay;
    public final TextView pricesLabel;
    private final ConstraintLayout rootView;
    public final TextView signInReturningTextView;
    public final TextView signInTextView;
    public final ConstraintLayout signUpButtonLayout;
    public final TabLayout tabs;
    public final TextView toggleLayoutTextView;
    public final LinearLayout topBar;
    public final ViewPager2 viewPager;
    public final ImageView zombieIcon;

    private FragmentCollectionBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, LottieAnimationView lottieAnimationView, TextView textView5, LinearLayout linearLayout, MarketplaceSelectorView marketplaceSelectorView, View view, TextView textView6, ConstraintLayout constraintLayout3, TextView textView7, TextView textView8, TextView textView9, ConstraintLayout constraintLayout4, TabLayout tabLayout, TextView textView10, LinearLayout linearLayout2, ViewPager2 viewPager2, ImageView imageView) {
        this.rootView = constraintLayout;
        this.accountInfo = constraintLayout2;
        this.collectionAccountHeader = textView;
        this.collectionAccountSubtitle = textView2;
        this.connectingTextView = textView3;
        this.helpTextView = textView4;
        this.loadingAnimationView = lottieAnimationView;
        this.loginButtonText = textView5;
        this.marketplaceSelectorContainer = linearLayout;
        this.marketplaceSelectorView = marketplaceSelectorView;
        this.menuBadgeDot = view;
        this.menuTextView = textView6;
        this.overlay = constraintLayout3;
        this.pricesLabel = textView7;
        this.signInReturningTextView = textView8;
        this.signInTextView = textView9;
        this.signUpButtonLayout = constraintLayout4;
        this.tabs = tabLayout;
        this.toggleLayoutTextView = textView10;
        this.topBar = linearLayout2;
        this.viewPager = viewPager2;
        this.zombieIcon = imageView;
    }

    public static FragmentCollectionBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.accountInfo;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.collectionAccountHeader;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.collectionAccountSubtitle;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.connectingTextView;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = R.id.helpTextView;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView4 != null) {
                            i = R.id.loadingAnimationView;
                            LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
                            if (lottieAnimationView != null) {
                                i = R.id.loginButtonText;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView5 != null) {
                                    i = R.id.marketplaceSelectorContainer;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                    if (linearLayout != null) {
                                        i = R.id.marketplaceSelectorView;
                                        MarketplaceSelectorView marketplaceSelectorView = (MarketplaceSelectorView) ViewBindings.findChildViewById(view, i);
                                        if (marketplaceSelectorView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.menuBadgeDot))) != null) {
                                            i = R.id.menuTextView;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView6 != null) {
                                                i = R.id.overlay;
                                                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                if (constraintLayout2 != null) {
                                                    i = R.id.pricesLabel;
                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView7 != null) {
                                                        i = R.id.signInReturningTextView;
                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView8 != null) {
                                                            i = R.id.signInTextView;
                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView9 != null) {
                                                                i = R.id.signUpButtonLayout;
                                                                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                if (constraintLayout3 != null) {
                                                                    i = R.id.tabs;
                                                                    TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (tabLayout != null) {
                                                                        i = R.id.toggleLayoutTextView;
                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView10 != null) {
                                                                            i = R.id.topBar;
                                                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (linearLayout2 != null) {
                                                                                i = R.id.view_pager;
                                                                                ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(view, i);
                                                                                if (viewPager2 != null) {
                                                                                    i = R.id.zombieIcon;
                                                                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                    if (imageView != null) {
                                                                                        return new FragmentCollectionBinding((ConstraintLayout) view, constraintLayout, textView, textView2, textView3, textView4, lottieAnimationView, textView5, linearLayout, marketplaceSelectorView, viewFindChildViewById, textView6, constraintLayout2, textView7, textView8, textView9, constraintLayout3, tabLayout, textView10, linearLayout2, viewPager2, imageView);
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

    public static FragmentCollectionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentCollectionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_collection, viewGroup, false);
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
