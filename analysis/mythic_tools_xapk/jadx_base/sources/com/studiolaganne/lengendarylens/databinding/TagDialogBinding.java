package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.material.button.MaterialButton;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class TagDialogBinding implements ViewBinding {
    public final MaterialButton addTagButton;
    public final LinearLayout addTagLayout;
    public final LinearLayout buttonsLinearLayout;
    public final MaterialButton cancelButton;
    public final TextView currentTagsTextView;
    public final LinearLayout filtersLinearLayout;
    public final FlexboxLayout flexboxLayoutAvailableTags;
    public final FlexboxLayout flexboxLayoutExistingTags;
    private final ConstraintLayout rootView;
    public final MaterialButton saveButton;
    public final View separator0;
    public final View separator2;
    public final EditText tagNameEditText;
    public final TextView titleTextView;

    private TagDialogBinding(ConstraintLayout constraintLayout, MaterialButton materialButton, LinearLayout linearLayout, LinearLayout linearLayout2, MaterialButton materialButton2, TextView textView, LinearLayout linearLayout3, FlexboxLayout flexboxLayout, FlexboxLayout flexboxLayout2, MaterialButton materialButton3, View view, View view2, EditText editText, TextView textView2) {
        this.rootView = constraintLayout;
        this.addTagButton = materialButton;
        this.addTagLayout = linearLayout;
        this.buttonsLinearLayout = linearLayout2;
        this.cancelButton = materialButton2;
        this.currentTagsTextView = textView;
        this.filtersLinearLayout = linearLayout3;
        this.flexboxLayoutAvailableTags = flexboxLayout;
        this.flexboxLayoutExistingTags = flexboxLayout2;
        this.saveButton = materialButton3;
        this.separator0 = view;
        this.separator2 = view2;
        this.tagNameEditText = editText;
        this.titleTextView = textView2;
    }

    public static TagDialogBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        int i = R.id.addTagButton;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = R.id.addTagLayout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.buttonsLinearLayout;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout2 != null) {
                    i = R.id.cancelButton;
                    MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                    if (materialButton2 != null) {
                        i = R.id.currentTagsTextView;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R.id.filtersLinearLayout;
                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout3 != null) {
                                i = R.id.flexboxLayoutAvailableTags;
                                FlexboxLayout flexboxLayout = (FlexboxLayout) ViewBindings.findChildViewById(view, i);
                                if (flexboxLayout != null) {
                                    i = R.id.flexboxLayoutExistingTags;
                                    FlexboxLayout flexboxLayout2 = (FlexboxLayout) ViewBindings.findChildViewById(view, i);
                                    if (flexboxLayout2 != null) {
                                        i = R.id.saveButton;
                                        MaterialButton materialButton3 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                                        if (materialButton3 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.separator0))) != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.separator2))) != null) {
                                            i = R.id.tagNameEditText;
                                            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                                            if (editText != null) {
                                                i = R.id.titleTextView;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView2 != null) {
                                                    return new TagDialogBinding((ConstraintLayout) view, materialButton, linearLayout, linearLayout2, materialButton2, textView, linearLayout3, flexboxLayout, flexboxLayout2, materialButton3, viewFindChildViewById, viewFindChildViewById2, editText, textView2);
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

    public static TagDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TagDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.tag_dialog, viewGroup, false);
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
