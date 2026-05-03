package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class AutoTagBarItemBinding implements ViewBinding {
    public final View autoTagBarFill;
    public final LinearLayout autoTagBarRoot;
    public final FrameLayout autoTagBarTrack;
    public final TextView autoTagCount;
    public final TextView autoTagLabel;
    private final LinearLayout rootView;

    private AutoTagBarItemBinding(LinearLayout linearLayout, View view, LinearLayout linearLayout2, FrameLayout frameLayout, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.autoTagBarFill = view;
        this.autoTagBarRoot = linearLayout2;
        this.autoTagBarTrack = frameLayout;
        this.autoTagCount = textView;
        this.autoTagLabel = textView2;
    }

    public static AutoTagBarItemBinding bind(View view) {
        int i = R.id.autoTagBarFill;
        View viewFindChildViewById = ViewBindings.findChildViewById(view, i);
        if (viewFindChildViewById != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            i = R.id.autoTagBarTrack;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout != null) {
                i = R.id.autoTagCount;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.autoTagLabel;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        return new AutoTagBarItemBinding(linearLayout, viewFindChildViewById, linearLayout, frameLayout, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static AutoTagBarItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AutoTagBarItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.auto_tag_bar_item, viewGroup, false);
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
