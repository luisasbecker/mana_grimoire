package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DeckMenuItemsBinding implements ViewBinding {
    public final TextView backIcon;
    public final TextView backLabel;
    public final ConstraintLayout backLayout;
    public final ConstraintLayout cardView;
    public final ImageView createIcon;
    public final TextView createLabel;
    public final ConstraintLayout createLayout;
    public final ImageView icon;
    public final TextView playerNameTextView;
    public final ConstraintLayout refreshLayout;
    private final ConstraintLayout rootView;

    private DeckMenuItemsBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ImageView imageView, TextView textView3, ConstraintLayout constraintLayout4, ImageView imageView2, TextView textView4, ConstraintLayout constraintLayout5) {
        this.rootView = constraintLayout;
        this.backIcon = textView;
        this.backLabel = textView2;
        this.backLayout = constraintLayout2;
        this.cardView = constraintLayout3;
        this.createIcon = imageView;
        this.createLabel = textView3;
        this.createLayout = constraintLayout4;
        this.icon = imageView2;
        this.playerNameTextView = textView4;
        this.refreshLayout = constraintLayout5;
    }

    public static DeckMenuItemsBinding bind(View view) {
        int i = R.id.back_icon;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.back_label;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.back_layout;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout != null) {
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                    i = R.id.create_icon;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R.id.create_label;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.create_layout;
                            ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                            if (constraintLayout3 != null) {
                                i = R.id.icon;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView2 != null) {
                                    i = R.id.player_name_text_view;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        i = R.id.refresh_layout;
                                        ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                        if (constraintLayout4 != null) {
                                            return new DeckMenuItemsBinding(constraintLayout2, textView, textView2, constraintLayout, constraintLayout2, imageView, textView3, constraintLayout3, imageView2, textView4, constraintLayout4);
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

    public static DeckMenuItemsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DeckMenuItemsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.deck_menu_items, viewGroup, false);
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
