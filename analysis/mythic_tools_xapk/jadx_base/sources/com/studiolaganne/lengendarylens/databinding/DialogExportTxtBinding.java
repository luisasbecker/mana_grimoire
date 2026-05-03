package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogExportTxtBinding implements ViewBinding {
    public final ConstraintLayout closeButtonLayout;
    public final TextView closeButtonText;
    public final ConstraintLayout copyButtonLayout;
    public final TextView copyButtonText;
    public final TextView dialogTitleTextView;
    public final ScrollView exportScrollView;
    public final TextView exportTextView;
    public final TextView includeFinishLabel;
    public final LinearLayout includeFinishLayout;
    public final SwitchMaterial includeFinishSwitch;
    public final TextView includeSetLabel;
    public final LinearLayout includeSetLayout;
    public final SwitchMaterial includeSetSwitch;
    public final LinearLayout mainLayout;
    private final ConstraintLayout rootView;
    public final View separator1;
    public final View separator2;
    public final TextView useXLabel;
    public final LinearLayout useXLayout;
    public final SwitchMaterial useXSwitch;

    private DialogExportTxtBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, ConstraintLayout constraintLayout3, TextView textView2, TextView textView3, ScrollView scrollView, TextView textView4, TextView textView5, LinearLayout linearLayout, SwitchMaterial switchMaterial, TextView textView6, LinearLayout linearLayout2, SwitchMaterial switchMaterial2, LinearLayout linearLayout3, View view, View view2, TextView textView7, LinearLayout linearLayout4, SwitchMaterial switchMaterial3) {
        this.rootView = constraintLayout;
        this.closeButtonLayout = constraintLayout2;
        this.closeButtonText = textView;
        this.copyButtonLayout = constraintLayout3;
        this.copyButtonText = textView2;
        this.dialogTitleTextView = textView3;
        this.exportScrollView = scrollView;
        this.exportTextView = textView4;
        this.includeFinishLabel = textView5;
        this.includeFinishLayout = linearLayout;
        this.includeFinishSwitch = switchMaterial;
        this.includeSetLabel = textView6;
        this.includeSetLayout = linearLayout2;
        this.includeSetSwitch = switchMaterial2;
        this.mainLayout = linearLayout3;
        this.separator1 = view;
        this.separator2 = view2;
        this.useXLabel = textView7;
        this.useXLayout = linearLayout4;
        this.useXSwitch = switchMaterial3;
    }

    public static DialogExportTxtBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        int i = R.id.closeButtonLayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.closeButtonText;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.copyButtonLayout;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout2 != null) {
                    i = R.id.copyButtonText;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.dialogTitleTextView;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.exportScrollView;
                            ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
                            if (scrollView != null) {
                                i = R.id.exportTextView;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView4 != null) {
                                    i = R.id.includeFinishLabel;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView5 != null) {
                                        i = R.id.includeFinishLayout;
                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout != null) {
                                            i = R.id.includeFinishSwitch;
                                            SwitchMaterial switchMaterial = (SwitchMaterial) ViewBindings.findChildViewById(view, i);
                                            if (switchMaterial != null) {
                                                i = R.id.includeSetLabel;
                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView6 != null) {
                                                    i = R.id.includeSetLayout;
                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                    if (linearLayout2 != null) {
                                                        i = R.id.includeSetSwitch;
                                                        SwitchMaterial switchMaterial2 = (SwitchMaterial) ViewBindings.findChildViewById(view, i);
                                                        if (switchMaterial2 != null) {
                                                            i = R.id.mainLayout;
                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                            if (linearLayout3 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.separator1))) != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.separator2))) != null) {
                                                                i = R.id.useXLabel;
                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView7 != null) {
                                                                    i = R.id.useXLayout;
                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (linearLayout4 != null) {
                                                                        i = R.id.useXSwitch;
                                                                        SwitchMaterial switchMaterial3 = (SwitchMaterial) ViewBindings.findChildViewById(view, i);
                                                                        if (switchMaterial3 != null) {
                                                                            return new DialogExportTxtBinding((ConstraintLayout) view, constraintLayout, textView, constraintLayout2, textView2, textView3, scrollView, textView4, textView5, linearLayout, switchMaterial, textView6, linearLayout2, switchMaterial2, linearLayout3, viewFindChildViewById, viewFindChildViewById2, textView7, linearLayout4, switchMaterial3);
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

    public static DialogExportTxtBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogExportTxtBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_export_txt, viewGroup, false);
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
