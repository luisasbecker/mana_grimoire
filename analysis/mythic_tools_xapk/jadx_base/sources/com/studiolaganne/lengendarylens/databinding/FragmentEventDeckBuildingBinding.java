package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentEventDeckBuildingBinding implements ViewBinding {
    public final TextView autoStartLabel;
    public final LinearLayout cardDistributionLayout;
    public final TextView clockLabel;
    public final ConstraintLayout clockLayout;
    public final ImageView creaImage;
    public final Guideline guidelineEnd;
    public final Guideline guidelineStart;
    public final ImageView landImage;
    public final LinearLayout manaCurveLayout;
    public final MaterialButton nextButton;
    public final ImageView playButton;
    private final LinearLayout rootView;
    public final ImageView spellImage;

    private FragmentEventDeckBuildingBinding(LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, TextView textView2, ConstraintLayout constraintLayout, ImageView imageView, Guideline guideline, Guideline guideline2, ImageView imageView2, LinearLayout linearLayout3, MaterialButton materialButton, ImageView imageView3, ImageView imageView4) {
        this.rootView = linearLayout;
        this.autoStartLabel = textView;
        this.cardDistributionLayout = linearLayout2;
        this.clockLabel = textView2;
        this.clockLayout = constraintLayout;
        this.creaImage = imageView;
        this.guidelineEnd = guideline;
        this.guidelineStart = guideline2;
        this.landImage = imageView2;
        this.manaCurveLayout = linearLayout3;
        this.nextButton = materialButton;
        this.playButton = imageView3;
        this.spellImage = imageView4;
    }

    public static FragmentEventDeckBuildingBinding bind(View view) {
        int i = R.id.auto_start_label;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.card_distribution_layout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.clock_label;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.clock_layout;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout != null) {
                        i = R.id.crea_image;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView != null) {
                            Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, R.id.guideline_end);
                            Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, R.id.guideline_start);
                            i = R.id.land_image;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView2 != null) {
                                i = R.id.mana_curve_layout;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout2 != null) {
                                    i = R.id.next_button;
                                    MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
                                    if (materialButton != null) {
                                        i = R.id.play_button;
                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView3 != null) {
                                            i = R.id.spell_image;
                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView4 != null) {
                                                return new FragmentEventDeckBuildingBinding((LinearLayout) view, textView, linearLayout, textView2, constraintLayout, imageView, guideline, guideline2, imageView2, linearLayout2, materialButton, imageView3, imageView4);
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

    public static FragmentEventDeckBuildingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentEventDeckBuildingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_event_deck_building, viewGroup, false);
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
