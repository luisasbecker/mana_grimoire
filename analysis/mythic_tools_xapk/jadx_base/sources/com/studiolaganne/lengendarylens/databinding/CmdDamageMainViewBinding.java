package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class CmdDamageMainViewBinding implements ViewBinding {
    public final ImageView cardBackgroundImage;
    public final CardView cardView;
    public final ImageView closeImage;
    public final LinearLayout closeLayout;
    public final TextView cmdHelpTextView;
    public final ImageView cmdIconImage;
    public final RelativeLayout cmdRootLayout;
    public final ConstraintLayout commanderDamageMainInnerLayout;
    public final Guideline guideline1;
    public final Guideline guideline2;
    public final TextView killLabel;
    public final RelativeLayout mainRelativeLayout;
    public final View overlay;
    public final TextView ownCmdDamageTextView;
    public final ImageView ownCmdImage;
    public final ConstraintLayout ownCmdLayout;
    private final CardView rootView;

    private CmdDamageMainViewBinding(CardView cardView, ImageView imageView, CardView cardView2, ImageView imageView2, LinearLayout linearLayout, TextView textView, ImageView imageView3, RelativeLayout relativeLayout, ConstraintLayout constraintLayout, Guideline guideline, Guideline guideline2, TextView textView2, RelativeLayout relativeLayout2, View view, TextView textView3, ImageView imageView4, ConstraintLayout constraintLayout2) {
        this.rootView = cardView;
        this.cardBackgroundImage = imageView;
        this.cardView = cardView2;
        this.closeImage = imageView2;
        this.closeLayout = linearLayout;
        this.cmdHelpTextView = textView;
        this.cmdIconImage = imageView3;
        this.cmdRootLayout = relativeLayout;
        this.commanderDamageMainInnerLayout = constraintLayout;
        this.guideline1 = guideline;
        this.guideline2 = guideline2;
        this.killLabel = textView2;
        this.mainRelativeLayout = relativeLayout2;
        this.overlay = view;
        this.ownCmdDamageTextView = textView3;
        this.ownCmdImage = imageView4;
        this.ownCmdLayout = constraintLayout2;
    }

    public static CmdDamageMainViewBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.card_background_image;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            CardView cardView = (CardView) view;
            i = R.id.closeImage;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.closeLayout;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = R.id.cmd_help_text_view;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.cmdIconImage;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView3 != null) {
                            i = R.id.cmdRootLayout;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                            if (relativeLayout != null) {
                                i = R.id.commander_damage_main_inner_layout;
                                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                if (constraintLayout != null) {
                                    i = R.id.guideline1;
                                    Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                                    if (guideline != null) {
                                        i = R.id.guideline2;
                                        Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                                        if (guideline2 != null) {
                                            i = R.id.killLabel;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView2 != null) {
                                                i = R.id.main_relative_layout;
                                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                if (relativeLayout2 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.overlay))) != null) {
                                                    i = R.id.ownCmdDamageTextView;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView3 != null) {
                                                        i = R.id.ownCmdImage;
                                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                        if (imageView4 != null) {
                                                            i = R.id.ownCmdLayout;
                                                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                            if (constraintLayout2 != null) {
                                                                return new CmdDamageMainViewBinding(cardView, imageView, cardView, imageView2, linearLayout, textView, imageView3, relativeLayout, constraintLayout, guideline, guideline2, textView2, relativeLayout2, viewFindChildViewById, textView3, imageView4, constraintLayout2);
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

    public static CmdDamageMainViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static CmdDamageMainViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.cmd_damage_main_view, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }
}
