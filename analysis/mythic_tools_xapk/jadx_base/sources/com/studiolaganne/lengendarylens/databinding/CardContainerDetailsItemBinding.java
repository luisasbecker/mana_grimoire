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
public final class CardContainerDetailsItemBinding implements ViewBinding {
    public final LinearLayout bottomLayout;
    public final RecyclerView cardsRecyclerView;
    public final View colorView;
    public final TextView deleteActionTextView;
    public final TextView deltaTextView;
    public final TextView editActionTextView;
    public final LinearLayout firstLayout;
    public final TextView iconTextView;
    public final TextView inviteButtonText;
    public final TextView nameTextView;
    public final TextView noCardsTextView;
    public final TextView numCardsLabel;
    public final TextView priceTextView;
    public final LinearLayout rootLayout;
    private final LinearLayout rootView;
    public final View separator;
    public final ConstraintLayout viewListButtonLayout;

    private CardContainerDetailsItemBinding(LinearLayout linearLayout, LinearLayout linearLayout2, RecyclerView recyclerView, View view, TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, LinearLayout linearLayout4, View view2, ConstraintLayout constraintLayout) {
        this.rootView = linearLayout;
        this.bottomLayout = linearLayout2;
        this.cardsRecyclerView = recyclerView;
        this.colorView = view;
        this.deleteActionTextView = textView;
        this.deltaTextView = textView2;
        this.editActionTextView = textView3;
        this.firstLayout = linearLayout3;
        this.iconTextView = textView4;
        this.inviteButtonText = textView5;
        this.nameTextView = textView6;
        this.noCardsTextView = textView7;
        this.numCardsLabel = textView8;
        this.priceTextView = textView9;
        this.rootLayout = linearLayout4;
        this.separator = view2;
        this.viewListButtonLayout = constraintLayout;
    }

    public static CardContainerDetailsItemBinding bind(View view) {
        View viewFindChildViewById;
        int i = R.id.bottomLayout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.cardsRecyclerView;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
            if (recyclerView != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.colorView))) != null) {
                i = R.id.deleteActionTextView;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.deltaTextView;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.editActionTextView;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.firstLayout;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout2 != null) {
                                i = R.id.iconTextView;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView4 != null) {
                                    i = R.id.inviteButtonText;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView5 != null) {
                                        i = R.id.nameTextView;
                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView6 != null) {
                                            i = R.id.noCardsTextView;
                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView7 != null) {
                                                i = R.id.numCardsLabel;
                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView8 != null) {
                                                    i = R.id.priceTextView;
                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView9 != null) {
                                                        LinearLayout linearLayout3 = (LinearLayout) view;
                                                        i = R.id.separator;
                                                        View viewFindChildViewById2 = ViewBindings.findChildViewById(view, i);
                                                        if (viewFindChildViewById2 != null) {
                                                            i = R.id.viewListButtonLayout;
                                                            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                            if (constraintLayout != null) {
                                                                return new CardContainerDetailsItemBinding(linearLayout3, linearLayout, recyclerView, viewFindChildViewById, textView, textView2, textView3, linearLayout2, textView4, textView5, textView6, textView7, textView8, textView9, linearLayout3, viewFindChildViewById2, constraintLayout);
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

    public static CardContainerDetailsItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static CardContainerDetailsItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.card_container_details_item, viewGroup, false);
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
