package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
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
public final class ImportDeckDialogBinding implements ViewBinding {
    public final ConstraintLayout cancelButtonLayout;
    public final TextView cancelText;
    public final TextView dialogSubtitleTextView;
    public final TextView dialogTitleTextView;
    public final ConstraintLayout fileSelectionArea;
    public final LinearLayout fileTabContent;
    public final ConstraintLayout importButtonLayout;
    public final TextView importButtonText;
    public final TextView moxfieldIssueTextView;
    public final CheckBox replaceAllCheckbox;
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
    public final EditText urlInput;
    public final LinearLayout urlTabContent;

    private ImportDeckDialogBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, TextView textView3, ConstraintLayout constraintLayout3, LinearLayout linearLayout, ConstraintLayout constraintLayout4, TextView textView4, TextView textView5, CheckBox checkBox, TextView textView6, TextView textView7, TextView textView8, View view, TabHost tabHost, FrameLayout frameLayout, TabWidget tabWidget, EditText editText, LinearLayout linearLayout2, EditText editText2, LinearLayout linearLayout3) {
        this.rootView = constraintLayout;
        this.cancelButtonLayout = constraintLayout2;
        this.cancelText = textView;
        this.dialogSubtitleTextView = textView2;
        this.dialogTitleTextView = textView3;
        this.fileSelectionArea = constraintLayout3;
        this.fileTabContent = linearLayout;
        this.importButtonLayout = constraintLayout4;
        this.importButtonText = textView4;
        this.moxfieldIssueTextView = textView5;
        this.replaceAllCheckbox = checkBox;
        this.selectFileIcon = textView6;
        this.selectFilePrompt = textView7;
        this.selectedFileNameTextView = textView8;
        this.separator = view;
        this.tabHost = tabHost;
        this.tabcontent = frameLayout;
        this.tabs = tabWidget;
        this.txtInput = editText;
        this.txtTabContent = linearLayout2;
        this.urlInput = editText2;
        this.urlTabContent = linearLayout3;
    }

    public static ImportDeckDialogBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.cancelButtonLayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.cancelText;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.dialogSubtitleTextView;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.dialogTitleTextView;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = R.id.fileSelectionArea;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout2 != null) {
                            i = R.id.fileTabContent;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout != null) {
                                i = R.id.importButtonLayout;
                                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                if (constraintLayout3 != null) {
                                    i = R.id.importButtonText;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        i = R.id.moxfieldIssueTextView;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView5 != null) {
                                            i = R.id.replaceAllCheckbox;
                                            CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, i);
                                            if (checkBox != null) {
                                                i = R.id.selectFileIcon;
                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView6 != null) {
                                                    i = R.id.selectFilePrompt;
                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView7 != null) {
                                                        i = R.id.selectedFileNameTextView;
                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView8 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.separator))) != null) {
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
                                                                                i = R.id.urlInput;
                                                                                EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
                                                                                if (editText2 != null) {
                                                                                    i = R.id.urlTabContent;
                                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                    if (linearLayout3 != null) {
                                                                                        return new ImportDeckDialogBinding((ConstraintLayout) view, constraintLayout, textView, textView2, textView3, constraintLayout2, linearLayout, constraintLayout3, textView4, textView5, checkBox, textView6, textView7, textView8, viewFindChildViewById, tabHost, frameLayout, tabWidget, editText, linearLayout2, editText2, linearLayout3);
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

    public static ImportDeckDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ImportDeckDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.import_deck_dialog, viewGroup, false);
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
