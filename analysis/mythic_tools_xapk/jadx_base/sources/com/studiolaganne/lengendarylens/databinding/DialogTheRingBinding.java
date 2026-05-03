package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogTheRingBinding implements ViewBinding {
    public final ImageView cardImage;
    public final ConstraintLayout cardLayout;
    public final ImageView closeImage;
    public final TextView dragHelpTextView;
    public final Guideline guidelineRoom1EndH;
    public final Guideline guidelineRoom1EndW;
    public final Guideline guidelineRoom1StartH;
    public final Guideline guidelineRoom1StartW;
    public final Guideline guidelineRoom2EndH;
    public final Guideline guidelineRoom2StartH;
    public final Guideline guidelineRoom3EndH;
    public final Guideline guidelineRoom3StartH;
    public final Guideline guidelineRoom4EndH;
    public final Guideline guidelineRoom4StartH;
    public final View level1Overlay;
    public final View level1View;
    public final View level2Overlay;
    public final View level2View;
    public final View level3Overlay;
    public final View level3View;
    public final View level4Overlay;
    public final View level4View;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;

    private DialogTheRingBinding(ConstraintLayout constraintLayout, ImageView imageView, ConstraintLayout constraintLayout2, ImageView imageView2, TextView textView, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5, Guideline guideline6, Guideline guideline7, Guideline guideline8, Guideline guideline9, Guideline guideline10, View view, View view2, View view3, View view4, View view5, View view6, View view7, View view8, ConstraintLayout constraintLayout3) {
        this.rootView = constraintLayout;
        this.cardImage = imageView;
        this.cardLayout = constraintLayout2;
        this.closeImage = imageView2;
        this.dragHelpTextView = textView;
        this.guidelineRoom1EndH = guideline;
        this.guidelineRoom1EndW = guideline2;
        this.guidelineRoom1StartH = guideline3;
        this.guidelineRoom1StartW = guideline4;
        this.guidelineRoom2EndH = guideline5;
        this.guidelineRoom2StartH = guideline6;
        this.guidelineRoom3EndH = guideline7;
        this.guidelineRoom3StartH = guideline8;
        this.guidelineRoom4EndH = guideline9;
        this.guidelineRoom4StartH = guideline10;
        this.level1Overlay = view;
        this.level1View = view2;
        this.level2Overlay = view3;
        this.level2View = view4;
        this.level3Overlay = view5;
        this.level3View = view6;
        this.level4Overlay = view7;
        this.level4View = view8;
        this.rootLayout = constraintLayout3;
    }

    public static DialogTheRingBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        View viewFindChildViewById3;
        View viewFindChildViewById4;
        View viewFindChildViewById5;
        View viewFindChildViewById6;
        View viewFindChildViewById7;
        View viewFindChildViewById8;
        int i = R.id.cardImage;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.cardLayout;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = R.id.closeImage;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.dragHelpTextView;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.guidelineRoom1EndH;
                        Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                        if (guideline != null) {
                            i = R.id.guidelineRoom1EndW;
                            Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                            if (guideline2 != null) {
                                i = R.id.guidelineRoom1StartH;
                                Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, i);
                                if (guideline3 != null) {
                                    i = R.id.guidelineRoom1StartW;
                                    Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(view, i);
                                    if (guideline4 != null) {
                                        i = R.id.guidelineRoom2EndH;
                                        Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(view, i);
                                        if (guideline5 != null) {
                                            i = R.id.guidelineRoom2StartH;
                                            Guideline guideline6 = (Guideline) ViewBindings.findChildViewById(view, i);
                                            if (guideline6 != null) {
                                                i = R.id.guidelineRoom3EndH;
                                                Guideline guideline7 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                if (guideline7 != null) {
                                                    i = R.id.guidelineRoom3StartH;
                                                    Guideline guideline8 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                    if (guideline8 != null) {
                                                        i = R.id.guidelineRoom4EndH;
                                                        Guideline guideline9 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                        if (guideline9 != null) {
                                                            i = R.id.guidelineRoom4StartH;
                                                            Guideline guideline10 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                            if (guideline10 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.level1Overlay))) != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.level1View))) != null && (viewFindChildViewById3 = ViewBindings.findChildViewById(view, (i = R.id.level2Overlay))) != null && (viewFindChildViewById4 = ViewBindings.findChildViewById(view, (i = R.id.level2View))) != null && (viewFindChildViewById5 = ViewBindings.findChildViewById(view, (i = R.id.level3Overlay))) != null && (viewFindChildViewById6 = ViewBindings.findChildViewById(view, (i = R.id.level3View))) != null && (viewFindChildViewById7 = ViewBindings.findChildViewById(view, (i = R.id.level4Overlay))) != null && (viewFindChildViewById8 = ViewBindings.findChildViewById(view, (i = R.id.level4View))) != null) {
                                                                ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                                                                return new DialogTheRingBinding(constraintLayout2, imageView, constraintLayout, imageView2, textView, guideline, guideline2, guideline3, guideline4, guideline5, guideline6, guideline7, guideline8, guideline9, guideline10, viewFindChildViewById, viewFindChildViewById2, viewFindChildViewById3, viewFindChildViewById4, viewFindChildViewById5, viewFindChildViewById6, viewFindChildViewById7, viewFindChildViewById8, constraintLayout2);
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

    public static DialogTheRingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogTheRingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_the_ring, viewGroup, false);
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
