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
import com.studiolaganne.lengendarylens.CollectionStatusView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DeckCardVariantItemBinding implements ViewBinding {
    public final CollectionStatusView collectionStatusView;
    public final ImageView dotsImage;
    public final ConstraintLayout dotsLayout;
    private final ConstraintLayout rootView;
    public final TextView selectionCheckbox;
    public final TextView variantCollectorNumber;
    public final ImageView variantFoilImage;
    public final LinearLayout variantInfoLayout;
    public final TextView variantQuantity;
    public final TextView variantSetCode;
    public final ImageView variantSetImage;

    private DeckCardVariantItemBinding(ConstraintLayout constraintLayout, CollectionStatusView collectionStatusView, ImageView imageView, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, ImageView imageView2, LinearLayout linearLayout, TextView textView3, TextView textView4, ImageView imageView3) {
        this.rootView = constraintLayout;
        this.collectionStatusView = collectionStatusView;
        this.dotsImage = imageView;
        this.dotsLayout = constraintLayout2;
        this.selectionCheckbox = textView;
        this.variantCollectorNumber = textView2;
        this.variantFoilImage = imageView2;
        this.variantInfoLayout = linearLayout;
        this.variantQuantity = textView3;
        this.variantSetCode = textView4;
        this.variantSetImage = imageView3;
    }

    public static DeckCardVariantItemBinding bind(View view) {
        int i = R.id.collectionStatusView;
        CollectionStatusView collectionStatusView = (CollectionStatusView) ViewBindings.findChildViewById(view, i);
        if (collectionStatusView != null) {
            i = R.id.dotsImage;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.dotsLayout;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout != null) {
                    i = R.id.selectionCheckbox;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.variantCollectorNumber;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.variantFoilImage;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView2 != null) {
                                i = R.id.variantInfoLayout;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout != null) {
                                    i = R.id.variantQuantity;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = R.id.variantSetCode;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView4 != null) {
                                            i = R.id.variantSetImage;
                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView3 != null) {
                                                return new DeckCardVariantItemBinding((ConstraintLayout) view, collectionStatusView, imageView, constraintLayout, textView, textView2, imageView2, linearLayout, textView3, textView4, imageView3);
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

    public static DeckCardVariantItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DeckCardVariantItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.deck_card_variant_item, viewGroup, false);
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
