package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.studiolaganne.lengendarylens.CachedImageView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class BottomSheetAcceptBinding implements ViewBinding {
    public final ConstraintLayout acceptButtonLayout;
    public final TextView acceptButtonText;
    public final LinearLayoutCompat buttonsLayout;
    public final ImageView chevronDown;
    public final TextView connectingTextView;
    public final ConstraintLayout declineButtonLayout;
    public final TextView declineButtonText;
    public final TextView headerTextView;
    public final LottieAnimationView loadingAnimationView;
    public final ImageView noPhotoIcon;
    public final ConstraintLayout overlay;
    public final TextView playerFirstName;
    public final TextView playerUsername;
    public final CachedImageView profileIcon;
    public final ConstraintLayout profileLayout;
    private final ConstraintLayout rootView;
    public final LinearLayoutCompat textLayout;

    private BottomSheetAcceptBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, LinearLayoutCompat linearLayoutCompat, ImageView imageView, TextView textView2, ConstraintLayout constraintLayout3, TextView textView3, TextView textView4, LottieAnimationView lottieAnimationView, ImageView imageView2, ConstraintLayout constraintLayout4, TextView textView5, TextView textView6, CachedImageView cachedImageView, ConstraintLayout constraintLayout5, LinearLayoutCompat linearLayoutCompat2) {
        this.rootView = constraintLayout;
        this.acceptButtonLayout = constraintLayout2;
        this.acceptButtonText = textView;
        this.buttonsLayout = linearLayoutCompat;
        this.chevronDown = imageView;
        this.connectingTextView = textView2;
        this.declineButtonLayout = constraintLayout3;
        this.declineButtonText = textView3;
        this.headerTextView = textView4;
        this.loadingAnimationView = lottieAnimationView;
        this.noPhotoIcon = imageView2;
        this.overlay = constraintLayout4;
        this.playerFirstName = textView5;
        this.playerUsername = textView6;
        this.profileIcon = cachedImageView;
        this.profileLayout = constraintLayout5;
        this.textLayout = linearLayoutCompat2;
    }

    public static BottomSheetAcceptBinding bind(View view) {
        int i = R.id.acceptButtonLayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.acceptButtonText;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.buttonsLayout;
                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) ViewBindings.findChildViewById(view, i);
                if (linearLayoutCompat != null) {
                    i = R.id.chevron_down;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R.id.connectingTextView;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.declineButtonLayout;
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                            if (constraintLayout2 != null) {
                                i = R.id.declineButtonText;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    i = R.id.headerTextView;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        i = R.id.loadingAnimationView;
                                        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i);
                                        if (lottieAnimationView != null) {
                                            i = R.id.no_photo_icon;
                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView2 != null) {
                                                i = R.id.overlay;
                                                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                if (constraintLayout3 != null) {
                                                    i = R.id.playerFirstName;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView5 != null) {
                                                        i = R.id.playerUsername;
                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView6 != null) {
                                                            i = R.id.profile_icon;
                                                            CachedImageView cachedImageView = (CachedImageView) ViewBindings.findChildViewById(view, i);
                                                            if (cachedImageView != null) {
                                                                i = R.id.profileLayout;
                                                                ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                if (constraintLayout4 != null) {
                                                                    i = R.id.textLayout;
                                                                    LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) ViewBindings.findChildViewById(view, i);
                                                                    if (linearLayoutCompat2 != null) {
                                                                        return new BottomSheetAcceptBinding((ConstraintLayout) view, constraintLayout, textView, linearLayoutCompat, imageView, textView2, constraintLayout2, textView3, textView4, lottieAnimationView, imageView2, constraintLayout3, textView5, textView6, cachedImageView, constraintLayout4, linearLayoutCompat2);
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

    public static BottomSheetAcceptBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BottomSheetAcceptBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.bottom_sheet_accept, viewGroup, false);
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
