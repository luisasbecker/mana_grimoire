package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ScanCardItemRotatedBinding implements ViewBinding {
    public final CardView cardView;
    public final TextView icon;
    public final TextView playerNameTextView;
    public final ConstraintLayout rootLayout;
    private final CardView rootView;

    private ScanCardItemRotatedBinding(CardView cardView, CardView cardView2, TextView textView, TextView textView2, ConstraintLayout constraintLayout) {
        this.rootView = cardView;
        this.cardView = cardView2;
        this.icon = textView;
        this.playerNameTextView = textView2;
        this.rootLayout = constraintLayout;
    }

    public static ScanCardItemRotatedBinding bind(View view) {
        CardView cardView = (CardView) view;
        int i = R.id.icon;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.player_name_text_view;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.root_layout;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout != null) {
                    return new ScanCardItemRotatedBinding(cardView, cardView, textView, textView2, constraintLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ScanCardItemRotatedBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ScanCardItemRotatedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.scan_card_item_rotated, viewGroup, false);
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
