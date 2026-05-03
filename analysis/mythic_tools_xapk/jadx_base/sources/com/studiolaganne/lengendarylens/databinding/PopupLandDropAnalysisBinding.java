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
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class PopupLandDropAnalysisBinding implements ViewBinding {
    public final TextView landCountLabel;
    public final ImageView landCountMinus;
    public final ImageView landCountPlus;
    public final ImageView popupCloseButton;
    public final TextView popupTitle;
    private final ConstraintLayout rootView;
    public final MaterialButtonToggleGroup startingLandsToggle;
    public final MaterialButton tabLands0;
    public final MaterialButton tabLands1;
    public final MaterialButton tabLands2;
    public final MaterialButton tabLands3;
    public final LinearLayout turnListContainer;

    private PopupLandDropAnalysisBinding(ConstraintLayout constraintLayout, TextView textView, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView2, MaterialButtonToggleGroup materialButtonToggleGroup, MaterialButton materialButton, MaterialButton materialButton2, MaterialButton materialButton3, MaterialButton materialButton4, LinearLayout linearLayout) {
        this.rootView = constraintLayout;
        this.landCountLabel = textView;
        this.landCountMinus = imageView;
        this.landCountPlus = imageView2;
        this.popupCloseButton = imageView3;
        this.popupTitle = textView2;
        this.startingLandsToggle = materialButtonToggleGroup;
        this.tabLands0 = materialButton;
        this.tabLands1 = materialButton2;
        this.tabLands2 = materialButton3;
        this.tabLands3 = materialButton4;
        this.turnListContainer = linearLayout;
    }

    public static PopupLandDropAnalysisBinding bind(View view) {
        int i = R.id.landCountLabel;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.landCountMinus;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.landCountPlus;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.popupCloseButton;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView3 != null) {
                        i = R.id.popupTitle;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.startingLandsToggle;
                            MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) ViewBindings.findChildViewById(view, i);
                            if (materialButtonToggleGroup != null) {
                                i = R.id.tabLands0;
                                MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
                                if (materialButton != null) {
                                    i = R.id.tabLands1;
                                    MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                                    if (materialButton2 != null) {
                                        i = R.id.tabLands2;
                                        MaterialButton materialButton3 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                                        if (materialButton3 != null) {
                                            i = R.id.tabLands3;
                                            MaterialButton materialButton4 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                                            if (materialButton4 != null) {
                                                i = R.id.turnListContainer;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                if (linearLayout != null) {
                                                    return new PopupLandDropAnalysisBinding((ConstraintLayout) view, textView, imageView, imageView2, imageView3, textView2, materialButtonToggleGroup, materialButton, materialButton2, materialButton3, materialButton4, linearLayout);
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

    public static PopupLandDropAnalysisBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PopupLandDropAnalysisBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.popup_land_drop_analysis, viewGroup, false);
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
