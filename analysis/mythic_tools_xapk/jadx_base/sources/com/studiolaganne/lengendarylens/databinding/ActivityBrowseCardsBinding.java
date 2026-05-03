package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityBrowseCardsBinding implements ViewBinding {
    public final ImageView backImage;
    public final RecyclerView cardsRecyclerView;
    public final EditText filterEditText;
    public final ImageView filterImage;
    public final ConstraintLayout rootLayout;
    private final RelativeLayout rootView;
    public final TextView titleTextView;
    public final LinearLayout topLayout;

    private ActivityBrowseCardsBinding(RelativeLayout relativeLayout, ImageView imageView, RecyclerView recyclerView, EditText editText, ImageView imageView2, ConstraintLayout constraintLayout, TextView textView, LinearLayout linearLayout) {
        this.rootView = relativeLayout;
        this.backImage = imageView;
        this.cardsRecyclerView = recyclerView;
        this.filterEditText = editText;
        this.filterImage = imageView2;
        this.rootLayout = constraintLayout;
        this.titleTextView = textView;
        this.topLayout = linearLayout;
    }

    public static ActivityBrowseCardsBinding bind(View view) {
        int i = R.id.backImage;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.cardsRecyclerView;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
            if (recyclerView != null) {
                i = R.id.filterEditText;
                EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                if (editText != null) {
                    i = R.id.filterImage;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = R.id.rootLayout;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout != null) {
                            i = R.id.titleTextView;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R.id.topLayout;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout != null) {
                                    return new ActivityBrowseCardsBinding((RelativeLayout) view, imageView, recyclerView, editText, imageView2, constraintLayout, textView, linearLayout);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivityBrowseCardsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityBrowseCardsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_browse_cards, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
