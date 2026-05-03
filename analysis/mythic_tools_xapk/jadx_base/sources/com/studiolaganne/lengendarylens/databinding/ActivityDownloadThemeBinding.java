package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.CachedImageView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityDownloadThemeBinding implements ViewBinding {
    public final ConstraintLayout applyButtonLayout;
    public final TextView applyButtonText;
    public final TextView catchphraseTextView;
    public final ImageView checkmarkDownload;
    public final ConstraintLayout closeButtonLayout;
    public final TextView closeButtonText;
    public final TextView downloadingText;
    public final ConstraintLayout innerLayout;
    public final TextView medalUnlocked;
    public final ImageView playmatImage;
    public final TextView playmatUnlocked;
    public final ProgressBar progressBar;
    public final ConstraintLayout rootLayout;
    public final ConstraintLayout rootLayout1;
    private final ConstraintLayout rootView;
    public final CachedImageView themeImage;
    public final ConstraintLayout themeInfoInnerLayout;
    public final ConstraintLayout themeInfoLayout;
    public final TextView themeUnlocked;
    public final ImageView trophyImage;
    public final ImageView unpackCheckmark;
    public final TextView unpackingText;

    private ActivityDownloadThemeBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, ImageView imageView, ConstraintLayout constraintLayout3, TextView textView3, TextView textView4, ConstraintLayout constraintLayout4, TextView textView5, ImageView imageView2, TextView textView6, ProgressBar progressBar, ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, CachedImageView cachedImageView, ConstraintLayout constraintLayout7, ConstraintLayout constraintLayout8, TextView textView7, ImageView imageView3, ImageView imageView4, TextView textView8) {
        this.rootView = constraintLayout;
        this.applyButtonLayout = constraintLayout2;
        this.applyButtonText = textView;
        this.catchphraseTextView = textView2;
        this.checkmarkDownload = imageView;
        this.closeButtonLayout = constraintLayout3;
        this.closeButtonText = textView3;
        this.downloadingText = textView4;
        this.innerLayout = constraintLayout4;
        this.medalUnlocked = textView5;
        this.playmatImage = imageView2;
        this.playmatUnlocked = textView6;
        this.progressBar = progressBar;
        this.rootLayout = constraintLayout5;
        this.rootLayout1 = constraintLayout6;
        this.themeImage = cachedImageView;
        this.themeInfoInnerLayout = constraintLayout7;
        this.themeInfoLayout = constraintLayout8;
        this.themeUnlocked = textView7;
        this.trophyImage = imageView3;
        this.unpackCheckmark = imageView4;
        this.unpackingText = textView8;
    }

    public static ActivityDownloadThemeBinding bind(View view) {
        int i = R.id.applyButtonLayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.applyButtonText;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.catchphraseTextView;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.checkmarkDownload;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R.id.closeButtonLayout;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout2 != null) {
                            i = R.id.closeButtonText;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R.id.downloadingText;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView4 != null) {
                                    i = R.id.innerLayout;
                                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                    if (constraintLayout3 != null) {
                                        i = R.id.medalUnlocked;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView5 != null) {
                                            i = R.id.playmatImage;
                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView2 != null) {
                                                i = R.id.playmatUnlocked;
                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView6 != null) {
                                                    i = R.id.progressBar;
                                                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                                    if (progressBar != null) {
                                                        i = R.id.rootLayout;
                                                        ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                        if (constraintLayout4 != null) {
                                                            ConstraintLayout constraintLayout5 = (ConstraintLayout) view;
                                                            i = R.id.themeImage;
                                                            CachedImageView cachedImageView = (CachedImageView) ViewBindings.findChildViewById(view, i);
                                                            if (cachedImageView != null) {
                                                                i = R.id.themeInfoInnerLayout;
                                                                ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                if (constraintLayout6 != null) {
                                                                    i = R.id.themeInfoLayout;
                                                                    ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (constraintLayout7 != null) {
                                                                        i = R.id.themeUnlocked;
                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView7 != null) {
                                                                            i = R.id.trophyImage;
                                                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                            if (imageView3 != null) {
                                                                                i = R.id.unpackCheckmark;
                                                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                if (imageView4 != null) {
                                                                                    i = R.id.unpackingText;
                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView8 != null) {
                                                                                        return new ActivityDownloadThemeBinding(constraintLayout5, constraintLayout, textView, textView2, imageView, constraintLayout2, textView3, textView4, constraintLayout3, textView5, imageView2, textView6, progressBar, constraintLayout4, constraintLayout5, cachedImageView, constraintLayout6, constraintLayout7, textView7, imageView3, imageView4, textView8);
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

    public static ActivityDownloadThemeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityDownloadThemeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_download_theme, viewGroup, false);
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
