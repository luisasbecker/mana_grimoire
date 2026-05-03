package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ActivityAboutBinding implements ViewBinding {
    public final TextView apiStatusDot;
    public final LinearLayout apiStatusLayout;
    public final TextView apiStatusText;
    public final LinearLayout buttonsLayout;
    public final LinearLayout discordLayout;
    public final LinearLayout emailLayout;
    public final TextView headerText;
    public final TextView headerText2;
    public final ImageView iconImage;
    public final LinearLayout instagramLayout;
    public final TextView licensesText;
    public final TextView networkStatusDot;
    public final TextView networkStatusText;
    public final ConstraintLayout rootLayout;
    private final RelativeLayout rootView;
    public final TextView systemText;
    public final Toolbar toolbar;
    public final TextView versionText;

    private ActivityAboutBinding(RelativeLayout relativeLayout, TextView textView, LinearLayout linearLayout, TextView textView2, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, TextView textView3, TextView textView4, ImageView imageView, LinearLayout linearLayout5, TextView textView5, TextView textView6, TextView textView7, ConstraintLayout constraintLayout, TextView textView8, Toolbar toolbar, TextView textView9) {
        this.rootView = relativeLayout;
        this.apiStatusDot = textView;
        this.apiStatusLayout = linearLayout;
        this.apiStatusText = textView2;
        this.buttonsLayout = linearLayout2;
        this.discordLayout = linearLayout3;
        this.emailLayout = linearLayout4;
        this.headerText = textView3;
        this.headerText2 = textView4;
        this.iconImage = imageView;
        this.instagramLayout = linearLayout5;
        this.licensesText = textView5;
        this.networkStatusDot = textView6;
        this.networkStatusText = textView7;
        this.rootLayout = constraintLayout;
        this.systemText = textView8;
        this.toolbar = toolbar;
        this.versionText = textView9;
    }

    public static ActivityAboutBinding bind(View view) {
        int i = R.id.apiStatusDot;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.apiStatusLayout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.apiStatusText;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.buttonsLayout;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout2 != null) {
                        i = R.id.discordLayout;
                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout3 != null) {
                            i = R.id.emailLayout;
                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout4 != null) {
                                i = R.id.headerText;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    i = R.id.headerText2;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        i = R.id.iconImage;
                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView != null) {
                                            i = R.id.instagramLayout;
                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                            if (linearLayout5 != null) {
                                                i = R.id.licensesText;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView5 != null) {
                                                    i = R.id.networkStatusDot;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView6 != null) {
                                                        i = R.id.networkStatusText;
                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView7 != null) {
                                                            i = R.id.root_layout;
                                                            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                            if (constraintLayout != null) {
                                                                i = R.id.systemText;
                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView8 != null) {
                                                                    i = R.id.toolbar;
                                                                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, i);
                                                                    if (toolbar != null) {
                                                                        i = R.id.versionText;
                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView9 != null) {
                                                                            return new ActivityAboutBinding((RelativeLayout) view, textView, linearLayout, textView2, linearLayout2, linearLayout3, linearLayout4, textView3, textView4, imageView, linearLayout5, textView5, textView6, textView7, constraintLayout, textView8, toolbar, textView9);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivityAboutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityAboutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_about, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
