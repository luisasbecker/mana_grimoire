package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class CircleListItemBinding implements ViewBinding {
    public final TextView autoBadge;
    public final TextView circleDescription;
    public final TextView circleName;
    public final ImageView dotsImage;
    public final ConstraintLayout dotsLayout;
    public final LinearLayout rootLayout;
    private final LinearLayout rootView;
    public final LinearLayout textLayout;

    private CircleListItemBinding(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, ImageView imageView, ConstraintLayout constraintLayout, LinearLayout linearLayout2, LinearLayout linearLayout3) {
        this.rootView = linearLayout;
        this.autoBadge = textView;
        this.circleDescription = textView2;
        this.circleName = textView3;
        this.dotsImage = imageView;
        this.dotsLayout = constraintLayout;
        this.rootLayout = linearLayout2;
        this.textLayout = linearLayout3;
    }

    public static CircleListItemBinding bind(View view) {
        int i = R.id.autoBadge;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.circleDescription;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.circleName;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    i = R.id.dotsImage;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R.id.dotsLayout;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout != null) {
                            LinearLayout linearLayout = (LinearLayout) view;
                            i = R.id.textLayout;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout2 != null) {
                                return new CircleListItemBinding(linearLayout, textView, textView2, textView3, imageView, constraintLayout, linearLayout, linearLayout2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static CircleListItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static CircleListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.circle_list_item, viewGroup, false);
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
