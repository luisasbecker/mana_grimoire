package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class BottomSheetFilterBinding implements ViewBinding {
    public final LinearLayoutCompat buttonsLayout;
    public final ConstraintLayout cancelButtonLayout;
    public final TextView cancelButtonText;
    public final ImageView chevronDown;
    public final TextView connectingTextView;
    public final ImageView deleteFormatImage;
    public final ImageView deleteSubformatImage;
    public final ImageView deleteTagImage;
    public final ConstraintLayout filterButtonLayout;
    public final TextView filterButtonText;
    public final LinearLayout filterFormatLayout;
    public final LinearLayout filterSubformatLayout;
    public final LinearLayout filterTagLayout;
    public final ImageView formatChevron;
    public final LinearLayout formatLayout;
    public final TextView formatTextView;
    public final LottieAnimationView loadingAnimationView;
    public final ConstraintLayout overlay;
    private final ConstraintLayout rootView;
    public final ImageView subformatChevron;
    public final LinearLayout subformatLayout;
    public final TextView subformatTextView;
    public final ImageView tagChevron;
    public final LinearLayout tagLayout;
    public final TextView tagTextView;

    private BottomSheetFilterBinding(ConstraintLayout constraintLayout, LinearLayoutCompat linearLayoutCompat, ConstraintLayout constraintLayout2, TextView textView, ImageView imageView, TextView textView2, ImageView imageView2, ImageView imageView3, ImageView imageView4, ConstraintLayout constraintLayout3, TextView textView3, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, ImageView imageView5, LinearLayout linearLayout4, TextView textView4, LottieAnimationView lottieAnimationView, ConstraintLayout constraintLayout4, ImageView imageView6, LinearLayout linearLayout5, TextView textView5, ImageView imageView7, LinearLayout linearLayout6, TextView textView6) {
        this.rootView = constraintLayout;
        this.buttonsLayout = linearLayoutCompat;
        this.cancelButtonLayout = constraintLayout2;
        this.cancelButtonText = textView;
        this.chevronDown = imageView;
        this.connectingTextView = textView2;
        this.deleteFormatImage = imageView2;
        this.deleteSubformatImage = imageView3;
        this.deleteTagImage = imageView4;
        this.filterButtonLayout = constraintLayout3;
        this.filterButtonText = textView3;
        this.filterFormatLayout = linearLayout;
        this.filterSubformatLayout = linearLayout2;
        this.filterTagLayout = linearLayout3;
        this.formatChevron = imageView5;
        this.formatLayout = linearLayout4;
        this.formatTextView = textView4;
        this.loadingAnimationView = lottieAnimationView;
        this.overlay = constraintLayout4;
        this.subformatChevron = imageView6;
        this.subformatLayout = linearLayout5;
        this.subformatTextView = textView5;
        this.tagChevron = imageView7;
        this.tagLayout = linearLayout6;
        this.tagTextView = textView6;
    }

    public static BottomSheetFilterBinding bind(View view) {
        int i = R.id.buttonsLayout;
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) ViewBindings.findChildViewById(view, i);
        if (linearLayoutCompat != null) {
            i = R.id.cancelButtonLayout;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = R.id.cancelButtonText;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.chevron_down;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R.id.connectingTextView;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.deleteFormatImage;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView2 != null) {
                                i = R.id.deleteSubformatImage;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView3 != null) {
                                    i = R.id.deleteTagImage;
                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView4 != null) {
                                        i = R.id.filterButtonLayout;
                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                        if (constraintLayout2 != null) {
                                            i = R.id.filterButtonText;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView3 != null) {
                                                i = R.id.filterFormatLayout;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                if (linearLayout != null) {
                                                    i = R.id.filterSubformatLayout;
                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                    if (linearLayout2 != null) {
                                                        i = R.id.filterTagLayout;
                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                        if (linearLayout3 != null) {
                                                            i = R.id.formatChevron;
                                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                            if (imageView5 != null) {
                                                                i = R.id.formatLayout;
                                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                if (linearLayout4 != null) {
                                                                    i = R.id.formatTextView;
                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView4 != null) {
                                                                        i = R.id.loadingAnimationView;
                                                                        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
                                                                        if (lottieAnimationView != null) {
                                                                            i = R.id.overlay;
                                                                            ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (constraintLayout3 != null) {
                                                                                i = R.id.subformatChevron;
                                                                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                if (imageView6 != null) {
                                                                                    i = R.id.subformatLayout;
                                                                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                    if (linearLayout5 != null) {
                                                                                        i = R.id.subformatTextView;
                                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView5 != null) {
                                                                                            i = R.id.tagChevron;
                                                                                            ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                            if (imageView7 != null) {
                                                                                                i = R.id.tagLayout;
                                                                                                LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                if (linearLayout6 != null) {
                                                                                                    i = R.id.tagTextView;
                                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView6 != null) {
                                                                                                        return new BottomSheetFilterBinding((ConstraintLayout) view, linearLayoutCompat, constraintLayout, textView, imageView, textView2, imageView2, imageView3, imageView4, constraintLayout2, textView3, linearLayout, linearLayout2, linearLayout3, imageView5, linearLayout4, textView4, lottieAnimationView, constraintLayout3, imageView6, linearLayout5, textView5, imageView7, linearLayout6, textView6);
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

    public static BottomSheetFilterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BottomSheetFilterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.bottom_sheet_filter, viewGroup, false);
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
