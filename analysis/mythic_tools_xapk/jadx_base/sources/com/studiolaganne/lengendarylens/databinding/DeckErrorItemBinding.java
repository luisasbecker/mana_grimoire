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
public final class DeckErrorItemBinding implements ViewBinding {
    public final ImageView errorBulletPoint;
    public final TextView errorText;
    private final LinearLayout rootView;

    private DeckErrorItemBinding(LinearLayout linearLayout, ImageView imageView, TextView textView) {
        this.rootView = linearLayout;
        this.errorBulletPoint = imageView;
        this.errorText = textView;
    }

    public static DeckErrorItemBinding bind(View view) {
        int i = R.id.errorBulletPoint;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.errorText;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                return new DeckErrorItemBinding((LinearLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static DeckErrorItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DeckErrorItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.deck_error_item, viewGroup, false);
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
