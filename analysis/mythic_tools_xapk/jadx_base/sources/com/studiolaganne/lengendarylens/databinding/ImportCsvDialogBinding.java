package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class ImportCsvDialogBinding implements ViewBinding {
    public final ConstraintLayout cancelButtonLayout;
    public final TextView cancelText;
    public final LinearLayout csvTabContent;
    public final TextView dialogTitleTextView;
    public final ConstraintLayout fileSelectionArea;
    public final TextView formatInfoTextView;
    public final ConstraintLayout importButtonLayout;
    public final TextView importButtonText;
    private final ConstraintLayout rootView;
    public final TextView selectFileIcon;
    public final TextView selectFilePrompt;
    public final TextView selectedFileNameTextView;
    public final View separator;
    public final TabHost tabHost;
    public final FrameLayout tabcontent;
    public final TabWidget tabs;
    public final EditText txtInput;
    public final LinearLayout txtTabContent;

    private ImportCsvDialogBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, LinearLayout linearLayout, TextView textView2, ConstraintLayout constraintLayout3, TextView textView3, ConstraintLayout constraintLayout4, TextView textView4, TextView textView5, TextView textView6, TextView textView7, View view, TabHost tabHost, FrameLayout frameLayout, TabWidget tabWidget, EditText editText, LinearLayout linearLayout2) {
        this.rootView = constraintLayout;
        this.cancelButtonLayout = constraintLayout2;
        this.cancelText = textView;
        this.csvTabContent = linearLayout;
        this.dialogTitleTextView = textView2;
        this.fileSelectionArea = constraintLayout3;
        this.formatInfoTextView = textView3;
        this.importButtonLayout = constraintLayout4;
        this.importButtonText = textView4;
        this.selectFileIcon = textView5;
        this.selectFilePrompt = textView6;
        this.selectedFileNameTextView = textView7;
        this.separator = view;
        this.tabHost = tabHost;
        this.tabcontent = frameLayout;
        this.tabs = tabWidget;
        this.txtInput = editText;
        this.txtTabContent = linearLayout2;
    }

    public static ImportCsvDialogBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.cancelButtonLayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.cancelText;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.csvTabContent;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = R.id.dialogTitleTextView;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.fileSelectionArea;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout2 != null) {
                            i = R.id.formatInfoTextView;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R.id.importButtonLayout;
                                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                if (constraintLayout3 != null) {
                                    i = R.id.importButtonText;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        i = R.id.selectFileIcon;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView5 != null) {
                                            i = R.id.selectFilePrompt;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView6 != null) {
                                                i = R.id.selectedFileNameTextView;
                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView7 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.separator))) != null) {
                                                    i = R.id.tabHost;
                                                    TabHost tabHost = (TabHost) ViewBindings.findChildViewById(view, i);
                                                    if (tabHost != null) {
                                                        i = android.R.id.tabcontent;
                                                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, android.R.id.tabcontent);
                                                        if (frameLayout != null) {
                                                            i = android.R.id.tabs;
                                                            TabWidget tabWidget = (TabWidget) ViewBindings.findChildViewById(view, android.R.id.tabs);
                                                            if (tabWidget != null) {
                                                                i = R.id.txtInput;
                                                                EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                                                                if (editText != null) {
                                                                    i = R.id.txtTabContent;
                                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (linearLayout2 != null) {
                                                                        return new ImportCsvDialogBinding((ConstraintLayout) view, constraintLayout, textView, linearLayout, textView2, constraintLayout2, textView3, constraintLayout3, textView4, textView5, textView6, textView7, viewFindChildViewById, tabHost, frameLayout, tabWidget, editText, linearLayout2);
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

    public static ImportCsvDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ImportCsvDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.import_csv_dialog, viewGroup, false);
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
