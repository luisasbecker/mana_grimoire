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
import com.studiolaganne.lengendarylens.CachedImageView;
import com.studiolaganne.lengendarylens.LoadingImageView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class MessageItemBinding implements ViewBinding {
    public final LoadingImageView cardImage;
    public final TextView message;
    public final ConstraintLayout messageLayout;
    public final ImageView noPhotoIconLeft;
    public final ImageView noPhotoIconRight;
    public final CachedImageView profileIconLeft;
    public final CachedImageView profileIconRight;
    public final ConstraintLayout profileLayoutLeft;
    public final ConstraintLayout profileLayoutRight;
    public final LinearLayout rootLayout;
    private final LinearLayout rootView;
    public final ConstraintLayout spacerLeft;
    public final ConstraintLayout spacerRight;
    public final TextView time;
    public final TextView userFirstName;
    public final TextView userName;

    private MessageItemBinding(LinearLayout linearLayout, LoadingImageView loadingImageView, TextView textView, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, CachedImageView cachedImageView, CachedImageView cachedImageView2, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, LinearLayout linearLayout2, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = linearLayout;
        this.cardImage = loadingImageView;
        this.message = textView;
        this.messageLayout = constraintLayout;
        this.noPhotoIconLeft = imageView;
        this.noPhotoIconRight = imageView2;
        this.profileIconLeft = cachedImageView;
        this.profileIconRight = cachedImageView2;
        this.profileLayoutLeft = constraintLayout2;
        this.profileLayoutRight = constraintLayout3;
        this.rootLayout = linearLayout2;
        this.spacerLeft = constraintLayout4;
        this.spacerRight = constraintLayout5;
        this.time = textView2;
        this.userFirstName = textView3;
        this.userName = textView4;
    }

    public static MessageItemBinding bind(View view) {
        int i = R.id.cardImage;
        LoadingImageView loadingImageView = (LoadingImageView) ViewBindings.findChildViewById(view, i);
        if (loadingImageView != null) {
            i = R.id.message;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.messageLayout;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout != null) {
                    i = R.id.no_photo_icon_left;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R.id.no_photo_icon_right;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null) {
                            i = R.id.profile_icon_left;
                            CachedImageView cachedImageView = (CachedImageView) ViewBindings.findChildViewById(view, i);
                            if (cachedImageView != null) {
                                i = R.id.profile_icon_right;
                                CachedImageView cachedImageView2 = (CachedImageView) ViewBindings.findChildViewById(view, i);
                                if (cachedImageView2 != null) {
                                    i = R.id.profileLayoutLeft;
                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                    if (constraintLayout2 != null) {
                                        i = R.id.profileLayoutRight;
                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                        if (constraintLayout3 != null) {
                                            LinearLayout linearLayout = (LinearLayout) view;
                                            i = R.id.spacerLeft;
                                            ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                            if (constraintLayout4 != null) {
                                                i = R.id.spacerRight;
                                                ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                if (constraintLayout5 != null) {
                                                    i = R.id.time;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView2 != null) {
                                                        i = R.id.userFirstName;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView3 != null) {
                                                            i = R.id.userName;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView4 != null) {
                                                                return new MessageItemBinding(linearLayout, loadingImageView, textView, constraintLayout, imageView, imageView2, cachedImageView, cachedImageView2, constraintLayout2, constraintLayout3, linearLayout, constraintLayout4, constraintLayout5, textView2, textView3, textView4);
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

    public static MessageItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MessageItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.message_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
