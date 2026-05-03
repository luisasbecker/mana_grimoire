package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.CachedImageView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class BottomSheetThemeBinding implements ViewBinding {
    public final ConstraintLayout buyButtonLayout;
    public final ConstraintLayout buyButtonLayoutBottom;
    public final TextView buyButtonTextBottom;
    public final ImageView cartIcon;
    public final TextView catchphraseTextView;
    public final ImageView chevronDown;
    public final View divider;
    public final FrameLayout overlay;
    public final TextView priceText;
    private final ConstraintLayout rootView;
    public final ScrollView scrollview;
    public final TextView themeContents;
    public final TextView themeContentsHeader;
    public final TextView themeDescription;
    public final CachedImageView themeImage;
    public final ConstraintLayout themeInfoInnerLayout;
    public final ConstraintLayout themeInfoLayout;
    public final RecyclerView themeScreenshotsRecyclerView;

    private BottomSheetThemeBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, TextView textView, ImageView imageView, TextView textView2, ImageView imageView2, View view, FrameLayout frameLayout, TextView textView3, ScrollView scrollView, TextView textView4, TextView textView5, TextView textView6, CachedImageView cachedImageView, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, RecyclerView recyclerView) {
        this.rootView = constraintLayout;
        this.buyButtonLayout = constraintLayout2;
        this.buyButtonLayoutBottom = constraintLayout3;
        this.buyButtonTextBottom = textView;
        this.cartIcon = imageView;
        this.catchphraseTextView = textView2;
        this.chevronDown = imageView2;
        this.divider = view;
        this.overlay = frameLayout;
        this.priceText = textView3;
        this.scrollview = scrollView;
        this.themeContents = textView4;
        this.themeContentsHeader = textView5;
        this.themeDescription = textView6;
        this.themeImage = cachedImageView;
        this.themeInfoInnerLayout = constraintLayout4;
        this.themeInfoLayout = constraintLayout5;
        this.themeScreenshotsRecyclerView = recyclerView;
    }

    public static BottomSheetThemeBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.buyButtonLayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.buyButtonLayoutBottom;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout2 != null) {
                i = R.id.buyButtonTextBottom;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.cart_icon;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R.id.catchphraseTextView;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.chevron_down;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView2 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.divider))) != null) {
                                i = R.id.overlay;
                                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                if (frameLayout != null) {
                                    i = R.id.priceText;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = R.id.scrollview;
                                        ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
                                        if (scrollView != null) {
                                            i = R.id.themeContents;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView4 != null) {
                                                i = R.id.themeContentsHeader;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView5 != null) {
                                                    i = R.id.themeDescription;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView6 != null) {
                                                        i = R.id.themeImage;
                                                        CachedImageView cachedImageView = (CachedImageView) ViewBindings.findChildViewById(view, i);
                                                        if (cachedImageView != null) {
                                                            i = R.id.themeInfoInnerLayout;
                                                            ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                            if (constraintLayout3 != null) {
                                                                i = R.id.themeInfoLayout;
                                                                ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                if (constraintLayout4 != null) {
                                                                    i = R.id.themeScreenshotsRecyclerView;
                                                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                    if (recyclerView != null) {
                                                                        return new BottomSheetThemeBinding((ConstraintLayout) view, constraintLayout, constraintLayout2, textView, imageView, textView2, imageView2, viewFindChildViewById, frameLayout, textView3, scrollView, textView4, textView5, textView6, cachedImageView, constraintLayout3, constraintLayout4, recyclerView);
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

    public static BottomSheetThemeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BottomSheetThemeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.bottom_sheet_theme, viewGroup, false);
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
