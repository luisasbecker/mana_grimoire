package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class LanguageMenuItemBinding implements ViewBinding {
    public final CardView flagContainer;
    public final ImageView flagImage;
    private final LinearLayout rootView;
    public final TextView titleTextview;

    private LanguageMenuItemBinding(LinearLayout linearLayout, CardView cardView, ImageView imageView, TextView textView) {
        this.rootView = linearLayout;
        this.flagContainer = cardView;
        this.flagImage = imageView;
        this.titleTextview = textView;
    }

    public static LanguageMenuItemBinding bind(View view) {
        int i = R.id.flag_container;
        CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
        if (cardView != null) {
            i = R.id.flag_image;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.title_textview;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new LanguageMenuItemBinding((LinearLayout) view, cardView, imageView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static LanguageMenuItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LanguageMenuItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.language_menu_item, viewGroup, false);
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
