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
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.button.MaterialButton;
import com.studiolaganne.lengendarylens.R;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

/* JADX INFO: loaded from: classes6.dex */
public final class FragmentEventDraftBinding implements ViewBinding {
    public final TextView autoStartLabel;
    public final TextView clockLabel;
    public final ConstraintLayout clockLayout;
    public final Guideline guidelineEnd;
    public final Guideline guidelineStart;
    public final MaterialButton nextButton;
    public final ImageView nextImage;
    public final ImageView playButton;
    public final ImageView prevImage;
    private final LinearLayout rootView;
    public final View spacer;
    public final TextView tableHeaderTextView;
    public final ViewPager2 viewPager;
    public final WormDotsIndicator wormDotsIndicator;

    private FragmentEventDraftBinding(LinearLayout linearLayout, TextView textView, TextView textView2, ConstraintLayout constraintLayout, Guideline guideline, Guideline guideline2, MaterialButton materialButton, ImageView imageView, ImageView imageView2, ImageView imageView3, View view, TextView textView3, ViewPager2 viewPager2, WormDotsIndicator wormDotsIndicator) {
        this.rootView = linearLayout;
        this.autoStartLabel = textView;
        this.clockLabel = textView2;
        this.clockLayout = constraintLayout;
        this.guidelineEnd = guideline;
        this.guidelineStart = guideline2;
        this.nextButton = materialButton;
        this.nextImage = imageView;
        this.playButton = imageView2;
        this.prevImage = imageView3;
        this.spacer = view;
        this.tableHeaderTextView = textView3;
        this.viewPager = viewPager2;
        this.wormDotsIndicator = wormDotsIndicator;
    }

    public static FragmentEventDraftBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.auto_start_label;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.clock_label;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.clock_layout;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout != null) {
                    Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, R.id.guideline_end);
                    Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, R.id.guideline_start);
                    i = R.id.next_button;
                    MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
                    if (materialButton != null) {
                        i = R.id.next_image;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView != null) {
                            i = R.id.play_button;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView2 != null) {
                                i = R.id.prev_image;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView3 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.spacer))) != null) {
                                    i = R.id.table_header_text_view;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = R.id.view_pager;
                                        ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(view, i);
                                        if (viewPager2 != null) {
                                            i = R.id.worm_dots_indicator;
                                            WormDotsIndicator wormDotsIndicator = (WormDotsIndicator) ViewBindings.findChildViewById(view, i);
                                            if (wormDotsIndicator != null) {
                                                return new FragmentEventDraftBinding((LinearLayout) view, textView, textView2, constraintLayout, guideline, guideline2, materialButton, imageView, imageView2, imageView3, viewFindChildViewById, textView3, viewPager2, wormDotsIndicator);
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

    public static FragmentEventDraftBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentEventDraftBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_event_draft, viewGroup, false);
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
