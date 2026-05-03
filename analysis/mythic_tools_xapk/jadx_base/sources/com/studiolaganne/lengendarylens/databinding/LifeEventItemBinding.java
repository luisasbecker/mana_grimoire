package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class LifeEventItemBinding implements ViewBinding {
    public final ConstraintLayout cardView;
    public final TextView lifeTotalTextView;
    public final TextView offsetTextView;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final View strikeThrough;
    public final View strikeThroughShadow;

    private LifeEventItemBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, ConstraintLayout constraintLayout3, View view, View view2) {
        this.rootView = constraintLayout;
        this.cardView = constraintLayout2;
        this.lifeTotalTextView = textView;
        this.offsetTextView = textView2;
        this.rootLayout = constraintLayout3;
        this.strikeThrough = view;
        this.strikeThroughShadow = view2;
    }

    public static LifeEventItemBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.life_total_text_view;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.offset_text_view;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.root_layout;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout2 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.strikeThrough))) != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.strikeThroughShadow))) != null) {
                    return new LifeEventItemBinding(constraintLayout, constraintLayout, textView, textView2, constraintLayout2, viewFindChildViewById, viewFindChildViewById2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static LifeEventItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LifeEventItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.life_event_item, viewGroup, false);
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
