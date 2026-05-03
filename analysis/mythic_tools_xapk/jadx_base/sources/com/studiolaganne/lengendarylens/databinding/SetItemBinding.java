package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class SetItemBinding implements ViewBinding {
    public final TextView cardCountText;
    public final LinearLayout detailsLayout;
    public final TextView releasedAtLabel;
    private final LinearLayout rootView;
    public final ImageView setIcon;
    public final TextView setNameText;

    private SetItemBinding(LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, TextView textView2, ImageView imageView, TextView textView3) {
        this.rootView = linearLayout;
        this.cardCountText = textView;
        this.detailsLayout = linearLayout2;
        this.releasedAtLabel = textView2;
        this.setIcon = imageView;
        this.setNameText = textView3;
    }

    public static SetItemBinding bind(View view) {
        int i = R.id.card_count_text;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.details_layout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.released_at_label;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.set_icon;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R.id.set_name_text;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            return new SetItemBinding((LinearLayout) view, textView, linearLayout, textView2, imageView, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static SetItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SetItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.set_item, viewGroup, false);
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
