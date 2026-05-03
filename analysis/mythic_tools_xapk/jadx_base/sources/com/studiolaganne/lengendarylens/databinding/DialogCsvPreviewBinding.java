package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DialogCsvPreviewBinding implements ViewBinding {
    public final MaterialButton cancelButton;
    public final LinearLayout collectorNumberRow;
    public final Spinner collectorNumberSpinner;
    public final TextView confidenceBadge;
    public final MaterialButton continueButton;
    public final TextView formatLabel;
    public final LinearLayout formatRow;
    public final TextView formatValue;
    public final LinearLayout mappingContent;
    public final ImageView mappingExpandIcon;
    public final LinearLayout mappingHeader;
    public final LinearLayout mappingSection;
    public final TextView mappingSubtitle;
    public final TextView mappingTitle;
    public final LinearLayout nameRow;
    public final Spinner nameSpinner;
    public final TextView previewHeader;
    public final HorizontalScrollView previewScrollView;
    public final LinearLayout previewTableContainer;
    public final LinearLayout quantityRow;
    public final Spinner quantitySpinner;
    private final LinearLayout rootView;
    public final LinearLayout setCodeRow;
    public final Spinner setCodeSpinner;
    public final TextView statsText;
    public final TextView title;
    public final TextView warningText;

    private DialogCsvPreviewBinding(LinearLayout linearLayout, MaterialButton materialButton, LinearLayout linearLayout2, Spinner spinner, TextView textView, MaterialButton materialButton2, TextView textView2, LinearLayout linearLayout3, TextView textView3, LinearLayout linearLayout4, ImageView imageView, LinearLayout linearLayout5, LinearLayout linearLayout6, TextView textView4, TextView textView5, LinearLayout linearLayout7, Spinner spinner2, TextView textView6, HorizontalScrollView horizontalScrollView, LinearLayout linearLayout8, LinearLayout linearLayout9, Spinner spinner3, LinearLayout linearLayout10, Spinner spinner4, TextView textView7, TextView textView8, TextView textView9) {
        this.rootView = linearLayout;
        this.cancelButton = materialButton;
        this.collectorNumberRow = linearLayout2;
        this.collectorNumberSpinner = spinner;
        this.confidenceBadge = textView;
        this.continueButton = materialButton2;
        this.formatLabel = textView2;
        this.formatRow = linearLayout3;
        this.formatValue = textView3;
        this.mappingContent = linearLayout4;
        this.mappingExpandIcon = imageView;
        this.mappingHeader = linearLayout5;
        this.mappingSection = linearLayout6;
        this.mappingSubtitle = textView4;
        this.mappingTitle = textView5;
        this.nameRow = linearLayout7;
        this.nameSpinner = spinner2;
        this.previewHeader = textView6;
        this.previewScrollView = horizontalScrollView;
        this.previewTableContainer = linearLayout8;
        this.quantityRow = linearLayout9;
        this.quantitySpinner = spinner3;
        this.setCodeRow = linearLayout10;
        this.setCodeSpinner = spinner4;
        this.statsText = textView7;
        this.title = textView8;
        this.warningText = textView9;
    }

    public static DialogCsvPreviewBinding bind(View view) {
        int i = R.id.cancelButton;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = R.id.collectorNumberRow;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.collectorNumberSpinner;
                Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, i);
                if (spinner != null) {
                    i = R.id.confidenceBadge;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.continueButton;
                        MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                        if (materialButton2 != null) {
                            i = R.id.formatLabel;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = R.id.formatRow;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout2 != null) {
                                    i = R.id.formatValue;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = R.id.mappingContent;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout3 != null) {
                                            i = R.id.mappingExpandIcon;
                                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView != null) {
                                                i = R.id.mappingHeader;
                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                if (linearLayout4 != null) {
                                                    i = R.id.mappingSection;
                                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                    if (linearLayout5 != null) {
                                                        i = R.id.mappingSubtitle;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView4 != null) {
                                                            i = R.id.mappingTitle;
                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView5 != null) {
                                                                i = R.id.nameRow;
                                                                LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                if (linearLayout6 != null) {
                                                                    i = R.id.nameSpinner;
                                                                    Spinner spinner2 = (Spinner) ViewBindings.findChildViewById(view, i);
                                                                    if (spinner2 != null) {
                                                                        i = R.id.previewHeader;
                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView6 != null) {
                                                                            i = R.id.previewScrollView;
                                                                            HorizontalScrollView horizontalScrollView = (HorizontalScrollView) ViewBindings.findChildViewById(view, i);
                                                                            if (horizontalScrollView != null) {
                                                                                i = R.id.previewTableContainer;
                                                                                LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                if (linearLayout7 != null) {
                                                                                    i = R.id.quantityRow;
                                                                                    LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                    if (linearLayout8 != null) {
                                                                                        i = R.id.quantitySpinner;
                                                                                        Spinner spinner3 = (Spinner) ViewBindings.findChildViewById(view, i);
                                                                                        if (spinner3 != null) {
                                                                                            i = R.id.setCodeRow;
                                                                                            LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                            if (linearLayout9 != null) {
                                                                                                i = R.id.setCodeSpinner;
                                                                                                Spinner spinner4 = (Spinner) ViewBindings.findChildViewById(view, i);
                                                                                                if (spinner4 != null) {
                                                                                                    i = R.id.statsText;
                                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView7 != null) {
                                                                                                        i = R.id.title;
                                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView8 != null) {
                                                                                                            i = R.id.warningText;
                                                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (textView9 != null) {
                                                                                                                return new DialogCsvPreviewBinding((LinearLayout) view, materialButton, linearLayout, spinner, textView, materialButton2, textView2, linearLayout2, textView3, linearLayout3, imageView, linearLayout4, linearLayout5, textView4, textView5, linearLayout6, spinner2, textView6, horizontalScrollView, linearLayout7, linearLayout8, spinner3, linearLayout9, spinner4, textView7, textView8, textView9);
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

    public static DialogCsvPreviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogCsvPreviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_csv_preview, viewGroup, false);
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
