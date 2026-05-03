package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class AutoTagCardListPopupBinding implements ViewBinding {
    public final RecyclerView popupCardList;
    public final ImageView popupCloseButton;
    public final TextView popupTagTitle;
    public final TextView popupViewAllButton;
    private final CardView rootView;

    private AutoTagCardListPopupBinding(CardView cardView, RecyclerView recyclerView, ImageView imageView, TextView textView, TextView textView2) {
        this.rootView = cardView;
        this.popupCardList = recyclerView;
        this.popupCloseButton = imageView;
        this.popupTagTitle = textView;
        this.popupViewAllButton = textView2;
    }

    public static AutoTagCardListPopupBinding bind(View view) {
        int i = R.id.popupCardList;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
        if (recyclerView != null) {
            i = R.id.popupCloseButton;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.popupTagTitle;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.popupViewAllButton;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        return new AutoTagCardListPopupBinding((CardView) view, recyclerView, imageView, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static AutoTagCardListPopupBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AutoTagCardListPopupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.auto_tag_card_list_popup, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }
}
