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
import com.studiolaganne.lengendarylens.LoadingImageView;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class MtEvaluationCardViewBinding implements ViewBinding {
    public final LinearLayout actionRow;
    public final LoadingImageView cardImage;
    public final LinearLayout chipStack;
    public final ImageView dotsMenuButton;
    public final LinearLayout protectionChip;
    public final TextView protectionIcon;
    public final TextView protectionLabel;
    public final TextView redundantBadge;
    public final TextView removeButton;
    private final ConstraintLayout rootView;
    public final View scoreBarFill;
    public final View scoreBarTrack;
    public final LinearLayout signalChipsRow;
    public final TextView subBadgeChip;
    public final TextView titleLabel;

    private MtEvaluationCardViewBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, LoadingImageView loadingImageView, LinearLayout linearLayout2, ImageView imageView, LinearLayout linearLayout3, TextView textView, TextView textView2, TextView textView3, TextView textView4, View view, View view2, LinearLayout linearLayout4, TextView textView5, TextView textView6) {
        this.rootView = constraintLayout;
        this.actionRow = linearLayout;
        this.cardImage = loadingImageView;
        this.chipStack = linearLayout2;
        this.dotsMenuButton = imageView;
        this.protectionChip = linearLayout3;
        this.protectionIcon = textView;
        this.protectionLabel = textView2;
        this.redundantBadge = textView3;
        this.removeButton = textView4;
        this.scoreBarFill = view;
        this.scoreBarTrack = view2;
        this.signalChipsRow = linearLayout4;
        this.subBadgeChip = textView5;
        this.titleLabel = textView6;
    }

    public static MtEvaluationCardViewBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        int i = R.id.actionRow;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.cardImage;
            LoadingImageView loadingImageView = (LoadingImageView) ViewBindings.findChildViewById(view, i);
            if (loadingImageView != null) {
                i = R.id.chipStack;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout2 != null) {
                    i = R.id.dotsMenuButton;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R.id.protectionChip;
                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout3 != null) {
                            i = R.id.protectionIcon;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R.id.protectionLabel;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = R.id.redundantBadge;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = R.id.removeButton;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView4 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.scoreBarFill))) != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.scoreBarTrack))) != null) {
                                            i = R.id.signalChipsRow;
                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                            if (linearLayout4 != null) {
                                                i = R.id.subBadgeChip;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView5 != null) {
                                                    i = R.id.titleLabel;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView6 != null) {
                                                        return new MtEvaluationCardViewBinding((ConstraintLayout) view, linearLayout, loadingImageView, linearLayout2, imageView, linearLayout3, textView, textView2, textView3, textView4, viewFindChildViewById, viewFindChildViewById2, linearLayout4, textView5, textView6);
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

    public static MtEvaluationCardViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MtEvaluationCardViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.mt_evaluation_card_view, viewGroup, false);
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
