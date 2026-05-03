package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class MoveCardDialogBinding implements ViewBinding {
    public final TextView applyFooter;
    public final TextView applyHeader;
    public final LinearLayout applyLayout;
    public final TextView applyValueLabel;
    public final RadioButton binderRadioButton;
    public final RadioButton boxRadioButton;
    public final ConstraintLayout cancelButtonLayout;
    public final TextView cancelText;
    public final RadioGroup containerTypeRadioGroup;
    public final RecyclerView containersRecyclerView;
    public final RadioGroup deckListRadioGroup;
    public final ConstraintLayout deckListSelectionLayout;
    public final TextView deckListSelectionTitle;
    public final LinearLayout deckLoadingLayout;
    public final ProgressBar deckLoadingProgressBar;
    public final RecyclerView decksRecyclerView;
    public final TabItem decksTab;
    public final TextView dialogTitleTextView;
    public final RadioButton mainDeckRadioButton;
    public final LinearLayout mainLayout;
    public final RadioButton maybeboardRadioButton;
    public final TextView minusApplyLabel;
    public final ConstraintLayout moveButtonLayout;
    public final TextView moveButtonText;
    public final TextInputEditText newContainerEditText;
    public final TextInputLayout newContainerInputLayout;
    public final ConstraintLayout newContainerLayout;
    public final TextView plusApplyLabel;
    private final ConstraintLayout rootView;
    public final View separator;
    public final RadioButton sideboardRadioButton;
    public final TabLayout tabLayout;

    private MoveCardDialogBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, LinearLayout linearLayout, TextView textView3, RadioButton radioButton, RadioButton radioButton2, ConstraintLayout constraintLayout2, TextView textView4, RadioGroup radioGroup, RecyclerView recyclerView, RadioGroup radioGroup2, ConstraintLayout constraintLayout3, TextView textView5, LinearLayout linearLayout2, ProgressBar progressBar, RecyclerView recyclerView2, TabItem tabItem, TextView textView6, RadioButton radioButton3, LinearLayout linearLayout3, RadioButton radioButton4, TextView textView7, ConstraintLayout constraintLayout4, TextView textView8, TextInputEditText textInputEditText, TextInputLayout textInputLayout, ConstraintLayout constraintLayout5, TextView textView9, View view, RadioButton radioButton5, TabLayout tabLayout) {
        this.rootView = constraintLayout;
        this.applyFooter = textView;
        this.applyHeader = textView2;
        this.applyLayout = linearLayout;
        this.applyValueLabel = textView3;
        this.binderRadioButton = radioButton;
        this.boxRadioButton = radioButton2;
        this.cancelButtonLayout = constraintLayout2;
        this.cancelText = textView4;
        this.containerTypeRadioGroup = radioGroup;
        this.containersRecyclerView = recyclerView;
        this.deckListRadioGroup = radioGroup2;
        this.deckListSelectionLayout = constraintLayout3;
        this.deckListSelectionTitle = textView5;
        this.deckLoadingLayout = linearLayout2;
        this.deckLoadingProgressBar = progressBar;
        this.decksRecyclerView = recyclerView2;
        this.decksTab = tabItem;
        this.dialogTitleTextView = textView6;
        this.mainDeckRadioButton = radioButton3;
        this.mainLayout = linearLayout3;
        this.maybeboardRadioButton = radioButton4;
        this.minusApplyLabel = textView7;
        this.moveButtonLayout = constraintLayout4;
        this.moveButtonText = textView8;
        this.newContainerEditText = textInputEditText;
        this.newContainerInputLayout = textInputLayout;
        this.newContainerLayout = constraintLayout5;
        this.plusApplyLabel = textView9;
        this.separator = view;
        this.sideboardRadioButton = radioButton5;
        this.tabLayout = tabLayout;
    }

    public static MoveCardDialogBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.applyFooter;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.applyHeader;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.applyLayout;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = R.id.applyValueLabel;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = R.id.binderRadioButton;
                        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, i);
                        if (radioButton != null) {
                            i = R.id.boxRadioButton;
                            RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, i);
                            if (radioButton2 != null) {
                                i = R.id.cancelButtonLayout;
                                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                if (constraintLayout != null) {
                                    i = R.id.cancelText;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        i = R.id.containerTypeRadioGroup;
                                        RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view, i);
                                        if (radioGroup != null) {
                                            i = R.id.containersRecyclerView;
                                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                            if (recyclerView != null) {
                                                i = R.id.deckListRadioGroup;
                                                RadioGroup radioGroup2 = (RadioGroup) ViewBindings.findChildViewById(view, i);
                                                if (radioGroup2 != null) {
                                                    i = R.id.deckListSelectionLayout;
                                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                    if (constraintLayout2 != null) {
                                                        i = R.id.deckListSelectionTitle;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView5 != null) {
                                                            i = R.id.deckLoadingLayout;
                                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                            if (linearLayout2 != null) {
                                                                i = R.id.deckLoadingProgressBar;
                                                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                                                if (progressBar != null) {
                                                                    i = R.id.decksRecyclerView;
                                                                    RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                    if (recyclerView2 != null) {
                                                                        i = R.id.decksTab;
                                                                        TabItem tabItem = (TabItem) ViewBindings.findChildViewById(view, i);
                                                                        if (tabItem != null) {
                                                                            i = R.id.dialogTitleTextView;
                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView6 != null) {
                                                                                i = R.id.mainDeckRadioButton;
                                                                                RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(view, i);
                                                                                if (radioButton3 != null) {
                                                                                    i = R.id.mainLayout;
                                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                    if (linearLayout3 != null) {
                                                                                        i = R.id.maybeboardRadioButton;
                                                                                        RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(view, i);
                                                                                        if (radioButton4 != null) {
                                                                                            i = R.id.minusApplyLabel;
                                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView7 != null) {
                                                                                                i = R.id.moveButtonLayout;
                                                                                                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                if (constraintLayout3 != null) {
                                                                                                    i = R.id.moveButtonText;
                                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView8 != null) {
                                                                                                        i = R.id.newContainerEditText;
                                                                                                        TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textInputEditText != null) {
                                                                                                            i = R.id.newContainerInputLayout;
                                                                                                            TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view, i);
                                                                                                            if (textInputLayout != null) {
                                                                                                                i = R.id.newContainerLayout;
                                                                                                                ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                if (constraintLayout4 != null) {
                                                                                                                    i = R.id.plusApplyLabel;
                                                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (textView9 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.separator))) != null) {
                                                                                                                        i = R.id.sideboardRadioButton;
                                                                                                                        RadioButton radioButton5 = (RadioButton) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (radioButton5 != null) {
                                                                                                                            i = R.id.tabLayout;
                                                                                                                            TabLayout tabLayout = (TabLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (tabLayout != null) {
                                                                                                                                return new MoveCardDialogBinding((ConstraintLayout) view, textView, textView2, linearLayout, textView3, radioButton, radioButton2, constraintLayout, textView4, radioGroup, recyclerView, radioGroup2, constraintLayout2, textView5, linearLayout2, progressBar, recyclerView2, tabItem, textView6, radioButton3, linearLayout3, radioButton4, textView7, constraintLayout3, textView8, textInputEditText, textInputLayout, constraintLayout4, textView9, viewFindChildViewById, radioButton5, tabLayout);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static MoveCardDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MoveCardDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.move_card_dialog, viewGroup, false);
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
