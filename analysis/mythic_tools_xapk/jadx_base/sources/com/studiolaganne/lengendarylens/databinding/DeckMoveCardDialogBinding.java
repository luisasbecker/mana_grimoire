package com.studiolaganne.lengendarylens.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.studiolaganne.lengendarylens.R;

/* JADX INFO: loaded from: classes6.dex */
public final class DeckMoveCardDialogBinding implements ViewBinding {
    public final TextView applyFooter;
    public final TextView applyHeader;
    public final LinearLayout applyLayout;
    public final TextView applyValueLabel;
    public final ConstraintLayout cancelButtonLayout;
    public final TextView cancelText;
    public final RecyclerView deckListsRecyclerView;
    public final TextView dialogTitleTextView;
    public final TextView instructionLabel;
    public final TextView minusApplyLabel;
    public final ConstraintLayout moveButtonLayout;
    public final TextView moveButtonText;
    public final TextView plusApplyLabel;
    private final ConstraintLayout rootView;
    public final View separator;

    private DeckMoveCardDialogBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, LinearLayout linearLayout, TextView textView3, ConstraintLayout constraintLayout2, TextView textView4, RecyclerView recyclerView, TextView textView5, TextView textView6, TextView textView7, ConstraintLayout constraintLayout3, TextView textView8, TextView textView9, View view) {
        this.rootView = constraintLayout;
        this.applyFooter = textView;
        this.applyHeader = textView2;
        this.applyLayout = linearLayout;
        this.applyValueLabel = textView3;
        this.cancelButtonLayout = constraintLayout2;
        this.cancelText = textView4;
        this.deckListsRecyclerView = recyclerView;
        this.dialogTitleTextView = textView5;
        this.instructionLabel = textView6;
        this.minusApplyLabel = textView7;
        this.moveButtonLayout = constraintLayout3;
        this.moveButtonText = textView8;
        this.plusApplyLabel = textView9;
        this.separator = view;
    }

    public static DeckMoveCardDialogBinding bind(View view) {
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
                        i = R.id.cancelButtonLayout;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout != null) {
                            i = R.id.cancelText;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView4 != null) {
                                i = R.id.deckListsRecyclerView;
                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                if (recyclerView != null) {
                                    i = R.id.dialogTitleTextView;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView5 != null) {
                                        i = R.id.instructionLabel;
                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView6 != null) {
                                            i = R.id.minusApplyLabel;
                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView7 != null) {
                                                i = R.id.moveButtonLayout;
                                                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                if (constraintLayout2 != null) {
                                                    i = R.id.moveButtonText;
                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView8 != null) {
                                                        i = R.id.plusApplyLabel;
                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView9 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.separator))) != null) {
                                                            return new DeckMoveCardDialogBinding((ConstraintLayout) view, textView, textView2, linearLayout, textView3, constraintLayout, textView4, recyclerView, textView5, textView6, textView7, constraintLayout2, textView8, textView9, viewFindChildViewById);
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

    public static DeckMoveCardDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DeckMoveCardDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.deck_move_card_dialog, viewGroup, false);
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
