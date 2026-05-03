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
public final class CollectionHelpDialogBinding implements ViewBinding {
    public final LinearLayout buttonsLinearLayout;
    public final ConstraintLayout closeButtonLayout;
    public final TextView closeText;
    public final LinearLayout collectionLayout;
    public final TextView collectionMainText;
    public final TextView decksHeader;
    public final LinearLayout decksLayout;
    public final TextView decksMainText;
    public final ImageView decksTextView;
    public final TextView faceCardheader;
    public final LinearLayout filtersLinearLayout;
    public final TextView helpTextView;
    public final TextView listHeader;
    public final TextView listTextView;
    public final LinearLayout listsLayout;
    public final TextView listsMainText;
    private final ConstraintLayout rootView;
    public final View separator2;

    private CollectionHelpDialogBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, ConstraintLayout constraintLayout2, TextView textView, LinearLayout linearLayout2, TextView textView2, TextView textView3, LinearLayout linearLayout3, TextView textView4, ImageView imageView, TextView textView5, LinearLayout linearLayout4, TextView textView6, TextView textView7, TextView textView8, LinearLayout linearLayout5, TextView textView9, View view) {
        this.rootView = constraintLayout;
        this.buttonsLinearLayout = linearLayout;
        this.closeButtonLayout = constraintLayout2;
        this.closeText = textView;
        this.collectionLayout = linearLayout2;
        this.collectionMainText = textView2;
        this.decksHeader = textView3;
        this.decksLayout = linearLayout3;
        this.decksMainText = textView4;
        this.decksTextView = imageView;
        this.faceCardheader = textView5;
        this.filtersLinearLayout = linearLayout4;
        this.helpTextView = textView6;
        this.listHeader = textView7;
        this.listTextView = textView8;
        this.listsLayout = linearLayout5;
        this.listsMainText = textView9;
        this.separator2 = view;
    }

    public static CollectionHelpDialogBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.buttonsLinearLayout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.closeButtonLayout;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = R.id.closeText;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.collectionLayout;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout2 != null) {
                        i = R.id.collectionMainText;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.decksHeader;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R.id.decksLayout;
                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout3 != null) {
                                    i = R.id.decksMainText;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        i = R.id.decksTextView;
                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView != null) {
                                            i = R.id.faceCardheader;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView5 != null) {
                                                i = R.id.filtersLinearLayout;
                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                if (linearLayout4 != null) {
                                                    i = R.id.helpTextView;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView6 != null) {
                                                        i = R.id.listHeader;
                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView7 != null) {
                                                            i = R.id.listTextView;
                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView8 != null) {
                                                                i = R.id.listsLayout;
                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                if (linearLayout5 != null) {
                                                                    i = R.id.listsMainText;
                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView9 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.separator2))) != null) {
                                                                        return new CollectionHelpDialogBinding((ConstraintLayout) view, linearLayout, constraintLayout, textView, linearLayout2, textView2, textView3, linearLayout3, textView4, imageView, textView5, linearLayout4, textView6, textView7, textView8, linearLayout5, textView9, viewFindChildViewById);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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

    public static CollectionHelpDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static CollectionHelpDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.collection_help_dialog, viewGroup, false);
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
