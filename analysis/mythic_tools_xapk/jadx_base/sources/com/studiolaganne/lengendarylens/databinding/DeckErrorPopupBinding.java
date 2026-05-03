package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DeckErrorPopupBinding implements ViewBinding {
    public final LinearLayout errorMessagesContainer;
    public final View errorPopupArrow;
    public final ConstraintLayout errorPopupLayout;
    private final ConstraintLayout rootView;

    private DeckErrorPopupBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, View view, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.errorMessagesContainer = linearLayout;
        this.errorPopupArrow = view;
        this.errorPopupLayout = constraintLayout2;
    }

    public static DeckErrorPopupBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.errorMessagesContainer;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout == null || (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.errorPopupArrow))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        return new DeckErrorPopupBinding(constraintLayout, linearLayout, viewFindChildViewById, constraintLayout);
    }

    public static DeckErrorPopupBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DeckErrorPopupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.deck_error_popup, viewGroup, false);
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
